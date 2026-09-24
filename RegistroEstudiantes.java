import java.util.Scanner; 

  

public class RegistrarEstudiantes { 

    static int[] ids = new int[100]; 

    static String[] nombres = new String[100]; 

    static double[] promedios = new double[100]; 

  

    static int tamano = 100;    

    static int cantidad = 0;    

    static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) { 

        int opcion; 

        do { 

            System.out.println("========================================="); 

            System.out.println("      TDA REGISTRO DE ESTUDIANTES"); 

            System.out.println("========================================="); 

            System.out.println("1. Registrar estudiante"); 

            System.out.println("2. Listar estudiantes"); 

            System.out.println("3. Buscar estudiante"); 

            System.out.println("4. Modificar estudiante"); 

            System.out.println("5. Eliminar estudiante"); 

            System.out.println("0. Salir"); 

  

            opcion = leerEntero("Elija una opcion: "); 

  

            if (opcion == 1) { 

                registrar(); 

            } else if (opcion == 2) { 

                listar(); 

            } else if (opcion == 3) { 

                int id = leerEntero("ID a buscar: "); 

                buscar(id); 

            } else if (opcion == 4) { 

                modificar(); 

            } else if (opcion == 5) { 

                int id = leerEntero("ID a eliminar: "); 

                eliminar(id); 

            } else if (opcion == 0) { 

                System.out.println("Saliendo del programa..."); 

            } else { 

                System.out.println("Error: opcion invalida. Vuelva a intentar."); 

            } 

  

        } while (opcion != 0); 

    } 

  

    static void registrar() { 

        if (cantidad == tamano) { 

            System.out.println("El registro esta lleno."); 

            return; 

        } 

  

        int id = leerEntero("ID: "); 

  

        if (buscarIndice(id) != -1) { 

            System.out.println("Error: ya existe un estudiante con ese ID."); 

            return; 

        } 

  

        System.out.print("Nombre: "); 

        String nombre = sc.nextLine(); 

  

        double promedio = leerDecimal("Promedio: "); 

  

        ids[cantidad] = id; 

        nombres[cantidad] = nombre; 

        promedios[cantidad] = promedio; 

        cantidad = cantidad + 1; 

  

        System.out.println("Estudiante registrado con exito."); 

    } 

 

    static void listar() { 

        if (cantidad == 0) { 

            System.out.println("No hay estudiantes registrados."); 

            return; 

        } 

  

        for (int i = 0; i < cantidad; i++) { 

            System.out.println("ID: " + ids[i] + " | Nombre: " + nombres[i] + " | Promedio: " + promedios[i]); 

        } 

    } 

  

  

    static void buscar(int id) { 

        int i = buscarIndice(id); 

        if (i == -1) { 

            System.out.println("No existe un estudiante con ID " + id); 

        } else { 

            System.out.println("Encontrado -> ID: " + ids[i] + " | Nombre: " + nombres[i] + " | Promedio: " + promedios[i]); 

        } 

    } 

  

    static void modificar() { 

        int id = leerEntero("ID a modificar: "); 

  

        int i = buscarIndice(id); 

        if (i == -1) { 

            System.out.println("Error: no existe un estudiante con ese ID."); 

            return; 

        } 

  

        double nuevoPromedio = leerDecimal("Nuevo promedio: "); 

        promedios[i] = nuevoPromedio; 

  

        System.out.println("Promedio actualizado."); 

    } 

  

       static void eliminar(int id) { 

        int i = buscarIndice(id); 

        if (i == -1) { 

            System.out.println("Error: no existe un estudiante con ese ID."); 

            return; 

        } 

 

        for (int j = i; j < cantidad - 1; j++) { 

            ids[j] = ids[j + 1]; 

            nombres[j] = nombres[j + 1]; 

            promedios[j] = promedios[j + 1]; 

        } 

  

        cantidad = cantidad - 1; 

        System.out.println("Estudiante eliminado."); 

    } 

  

    static int buscarIndice(int id) { 

        for (int i = 0; i < cantidad; i++) { 

            if (ids[i] == id) { 

                return i; 

            } 

        } 

        return -1; // no se encontro 

    } 

    static double leerDecimal(String mensaje) { 

        while (true) { 

            System.out.print(mensaje); 

            String texto = sc.nextLine(); 

            try { 

                return Double.parseDouble(texto); 

            } catch (NumberFormatException e) { 

                System.out.println("Error: debe ingresar un numero valido."); 

            } 

        } 

    } 

} 
