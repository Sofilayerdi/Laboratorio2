import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static void main(String[] args){

        Seccion ProductosElectronicos = new Seccion("Productos Electronicos ", 200000);
        Seccion Ropa = new Seccion("Ropa ", 150000);
        Seccion Alimentos = new Seccion("Alimentos ", 250000);
        Seccion Maquinaria = new Seccion("Maquinaria ", 300000);

        Scanner scanner = new Scanner(System.in);

        boolean seguir = true;
        
        while(seguir){
            System.out.println("-----Funciones-----");
            System.out.println("1. Agregar contenedor");
            System.out.println("2. Ver informacion de contenedores");
            System.out.println("3. Mover contenedores");
            System.out.println("4. Peso total por seccion");
            System.out.println("5. Salir del sistema");
            System.out.println("Elija una opcion (1-5): ");
            int decision = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------");

            if(decision == 1){
                System.out.println("--Ingrese lo que se solicita--");

                System.out.println("Seccion a la que pertenece contenedor: ");
                String nSeccion = scanner.nextLine();

                System.out.println("Numero de ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Nombre del producto: ");
                String nProducto = scanner.nextLine();

                System.out.println("Peso del contenedor (Kg): ");
                int peso = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Destino al que se dirige: ");
                String destino = scanner.nextLine();

                Contenedor contenedor = new Contenedor(id, nProducto, peso, destino);

                if (nSeccion.equalsIgnoreCase("Productos Electronicos")) {
                    boolean agregado = ProductosElectronicos.agregarContenedor(contenedor); 
                    if (agregado) {
                        System.out.println("Contenedor agregado exitosamente.");
                    } else {
                        System.out.println("ERROR: La seccion ya se encuentra llena.");
                    }

                } else if (nSeccion.equalsIgnoreCase("Ropa")) {
                    boolean agregado = Ropa.agregarContenedor(contenedor);
                    if (agregado) {
                        System.out.println("Contenedor agregado exitosamente.");
                    } else {
                        System.out.println("ERROR: La seccion ya se encuentra llena.");
                    }

                } else if (nSeccion.equalsIgnoreCase("Alimentos")) {
                    boolean agregado = Alimentos.agregarContenedor(contenedor);
                    if (agregado) {
                        System.out.println("Contenedor agregado exitosamente.");
                    } else {
                        System.out.println("ERROR: La seccion ya se encuentra llena.");
                    }

                } else if (nSeccion.equalsIgnoreCase("Maquinaria")) {
                    boolean agregado = Maquinaria.agregarContenedor(contenedor);
                    if (agregado) {
                        System.out.println("Contenedor agregado exitosamente.");
                    } else {
                        System.out.println("ERROR: La seccion ya se encuentra llena.");
                    }

                } else {
                    System.out.println("ERROR: seccion no reconocida.");
                }



            }

            else if(decision == 2){
                System.out.println("Ingresa el nombre de la seccion que deseas ver: ");
                String dSeccion = scanner.nextLine();

                Seccion nSeccion = null;

                if (dSeccion.equals("Productos Electronicos")) {
                    nSeccion = ProductosElectronicos;
                } else if (dSeccion.equalsIgnoreCase("Ropa")) {
                    nSeccion = Ropa;
                } else if (dSeccion.equalsIgnoreCase("Alimentos")) {
                    nSeccion = Alimentos;
                } else if (dSeccion.equalsIgnoreCase("Maquinaria")) {
                    nSeccion = Maquinaria;
                } else {
                    System.out.println("ERROR: Seccion no reconocida.");
                }

                if (nSeccion != null) {
                    Contenedor[][] contenedores = nSeccion.getContenedores();
                    for (int i = 0; i < contenedores.length; i++) {
                        for (int j = 0; j < contenedores[i].length; j++) {
                            if (contenedores[i][j] != null) { 
                                System.out.println("-- Contenedor --");
                                System.out.println("Fila: " + i + " Columna: " + j);
                                System.out.println("ID: " + contenedores[i][j].getID());
                                System.out.println("Nombre del producto: " + contenedores[i][j].getNombreProducto());
                                System.out.println("Peso: " + contenedores[i][j].getPeso());
                                System.out.println("Destino: " + contenedores[i][j].getDestino());
                                System.out.println("----------------");
                            }
                        }
                    }
                }
            }

            else if(decision == 3){
                System.out.println("Ingresa la seccion del contenedor que deseas mover: ");
                String nseccionA = scanner.nextLine();
                
                System.out.println("Ingresa el ID del contenedor: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingresa la seccion a la cual lo deseas mover: ");
                String nseccionB = scanner.nextLine();

                System.out.println("Ingresa la fila donde lo deseas posicionar: ");
                int nFila = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingresa la columna donde lo deseas posicionar: ");
                int nColumna = scanner.nextInt();
                scanner.nextLine();

                if (nFila < 0 || nFila >= 10 || nColumna < 0 || nColumna >= 5) {
                    System.out.println("ERROR: Fila o columna fuera de los limites permitidos.");
                    continue; 
                }

                Seccion seccionA = null;

                if (nseccionA.equalsIgnoreCase("Productos Electronicos")) {
                    seccionA = ProductosElectronicos;
                } else if (nseccionA.equalsIgnoreCase("Ropa")) {
                    seccionA = Ropa;
                } else if (nseccionA.equalsIgnoreCase("Alimentos")) {
                    seccionA = Alimentos;
                } else if (nseccionA.equalsIgnoreCase("Maquinaria")) {
                    seccionA = Maquinaria;
                } else {
                    System.out.println("ERROR: Seccion no reconocida.");
                }

                Seccion seccionB = null;

                if (nseccionB.equalsIgnoreCase("Productos Electronicos")) {
                    seccionB = ProductosElectronicos;
                } else if (nseccionB.equalsIgnoreCase("Ropa")) {
                    seccionB = Ropa;
                } else if (nseccionB.equalsIgnoreCase("Alimentos")) {
                    seccionB = Alimentos;
                } else if (nseccionB.equalsIgnoreCase("Maquinaria")) {
                    seccionB = Maquinaria;
                } else {
                    System.out.println("ERROR: Seccion no reconocida.");
                }

                if (seccionA != null && seccionB != null) {
                    boolean movido = seccionA.MoverContenedor(id, nFila, nColumna, seccionA, seccionB);
                    if (movido) {
                        System.out.println("Contenedor movido exitosamente.");
                    }
                } else {
                    System.out.println("ERROR: Una o ambas secciones no existen.");
                }
                
            }

            else if(decision == 4){
                System.out.println("Ingresa la seccion que desea pesar: ");
                String pSeccion = scanner.nextLine();
                
                Seccion eSeccion = null;

                if (pSeccion.equalsIgnoreCase("Productos Electronicos")) {
                    eSeccion = ProductosElectronicos;
                } else if (pSeccion.equalsIgnoreCase("Ropa")) {
                    eSeccion = Ropa;
                } else if (pSeccion.equalsIgnoreCase("Alimentos")) {
                    eSeccion = Alimentos;
                } else if (pSeccion.equalsIgnoreCase("Maquinaria")) {
                    eSeccion = Maquinaria;
                } else {
                    System.out.println("ERROR: Seccion no reconocida.");
                }

                int peso = eSeccion.pesoTotal();

                System.out.println("El peso total (Kg) de la seccion  " + eSeccion.getNombreSeccion() + " es: " + peso);

                if(peso > eSeccion.getPesoMax()){
                    System.out.println("Se excede la capacidad maxima");
                }

                else{
                    System.out.print("No se excede de la capacidad maxima");
                }

            }

            else if(decision == 5){
                System.out.println("Saliendo...");
                seguir = false; 
                System.exit(0);
            }

            else{
                System.out.println("ERROR: Elija un numero del 1 al 5");
            }

        }        

    }

}