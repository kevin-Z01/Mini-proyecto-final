import java.sql.PseudoColumnUsage;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void subMenuSimcard(Negocio local, Scanner teclado){
        int opcion;
        int cantidad;

        //para mostrar los nombres de los operadores que hay
        for (int i = 0; i < local.getLisOper().size(); i++) {
            System.out.println((i+1)+". " + local.getLisOper().get(i).getNombre());
        }
        System.out.println("Ingrese el numero de la Simcard: ");
        opcion = teclado.nextInt();

        //Evaluamos que el usuario digite bien
        if(opcion <= local.getLisOper().size()) {
            System.out.println("Ingrese la cantidad de Simcard Compradas: ");
            cantidad = teclado.nextInt();

            if (local.registrarS(opcion, cantidad)) {
                System.out.println("Registrado Correctamente");
            } else
                System.out.println("!!!!Error______*");
        }
        else{
            System.out.println("!!Error digito mal");
        }
    }

    public static void subMenuPlotter(Negocio local,Scanner opc) {
        System.out.println(local.getPlotter().toString());
        int ancho;
        int alto;
        int valorPagado;
        int opcion;

        System.out.println("Ingrese el numero de tipo que deseas:");
        System.out.println("(1)Impresion de afiche");
        System.out.println("(2)Impresion de Plano");
        System.out.println("(3)Salir");
        opcion = opc.nextInt();


        if(opcion < 4) {
            if (opcion < 3) {

                opc = new Scanner(System.in);
                System.out.println("Ingrese el ancho en CM");
                ancho = opc.nextInt();
                System.out.println("Ingrese el alto en CM");
                alto = opc.nextInt();
                System.out.println("Ingrese el valor pagado");
                valorPagado = opc.nextInt();

                if (local.registrar(opcion, valorPagado, ancho, alto)) {
                    System.out.println("Registro exitoso");
                } else {
                    System.out.println("___Error______");
                }

            } else
                System.out.println("Saliste!!");
        } else {
            System.out.println("Error Digite bien");
        }
    }

    public static void subMenuImpresora(Negocio local, Scanner opc){

        //Para mostrarle al usuario la informacion de cada cosa
        System.out.println(local.getImpresora().toString());

        int opcion;
        int cantidadCopias;
        int valorPagado;

        System.out.println("Ingrese el numero de tipos que desas:");
        System.out.println("(1)Impresion a color");
        System.out.println("(2)Impresion a Blanco y negro");
        System.out.println("(3)Salir");
        opcion = opc.nextInt();


        if(opcion < 4) {

            if (opcion < 3) {
                System.out.println("Cantidad de copias a Laser:");
                cantidadCopias = opc.nextInt();
                System.out.println("Ingrese el valor Pagado");
                valorPagado = opc.nextInt();

                if (local.registrarImpresora(opcion, cantidadCopias, valorPagado)) {
                    System.out.println("Registrado Exitosamente");
                } else {
                    System.out.println("!!!!!!___Error___");
                }
            }
        }
        else {
            System.out.println("Error digito mal");
        }
    }

    public static void sebMenuCierredia(Negocio local){
        int sumaV=0,ganancia=0,costo=0;

        for (int i = 0; i < local.getLisOper().size() ; i++) {

            sumaV += local.getLisOper().get(i).valorRecolectado();
            ganancia += local.getLisOper().get(i).gananciaTotal();
            costo += local.getLisOper().get(i).costoTotal();
        }

        //Sumamos toda el valor recolectado en cada servicio
        //y asi hacemos lo mismo con lo demas ya en el segundo sumamos todas las ganancias
        //y por ultimo el costo de todos lo servicios mas el costo del empleado y el recibo de la energia

        sumaV += local.getFotocopia().getValorPagado()+local.getImpresora().getValorPagado()+ local.getPlotter().getValorPagado();
        ganancia +=  local.gananciaServicios();
        costo += local.costo();

        System.out.println("Valor recolectado ="+sumaV);
        System.out.println("Ganancia ="+(ganancia - local.getConstoEnergiaDia()- local.getCostoEmpleadoDia()));
        System.out.println("Costo ="+costo);
        System.out.println(local.ventaMayor());

    }

    public static void subMenuMinutos(Negocio local,Scanner getDate){
        int opcion, cantidadM;

        System.out.println("Ingrese los Minutos vendidos");
        for (int i = 0; i < local.getLisOper().size() ; i++) {
            System.out.println("("+(i+1)+")"+local.getLisOper().get(i).getNombre());
        }
        System.out.print("Ingrese su Opcion:");
        opcion = getDate.nextInt();

        if(opcion <= local.getLisOper().size()) {
            System.out.print("Cantidad Minutos:");
            cantidadM = getDate.nextInt();

            if (local.registrar(opcion, cantidadM))
                System.out.println("Registro Exitoso");
            else
                System.out.println("!!!! Error en el Ingreso de los datos");
        }
        else {
            System.out.println("Error Digito mal");
        }
    }

    public static void subMenuFotocopias(Negocio local,Scanner getDate){
        int tipoCopia, cantiC, valorVenta;

        //Mostramos la informacion en la pantalla
        System.out.println(local.getFotocopia().toString());

        System.out.println("Ingrese los datos de las Fotocopias");
        System.out.print("(1) Color  (2) Blanco y negro:");
        System.out.println("(3) Salir");
        tipoCopia= getDate.nextInt();
        //verificamos que el usuario ingrese bien los datos y no hallan errores

        if(tipoCopia < 4) {
           if (tipoCopia < 3) {
               System.out.print("Cantidad de Copias:");
               cantiC = getDate.nextInt();
               System.out.print("Valor Pagado:");
               valorVenta = getDate.nextInt();

               if (local.registrar(tipoCopia, cantiC, valorVenta))
                   System.out.println("Registro Exitoso");
               else
                   System.out.println("!!!! Error en el Ingreso de los datos");
           }
       }
       else {
           System.out.println("!!!!ERROR DIGITE BIEN!!!!\n");
       }
    }


    public static void main(String[] args) {

        System.out.println("\n************* Hello and welcome! ***********");
        System.out.println("____________Variedades Tecnologicas____________\n");
        Negocio local= new Negocio(35000,12500);

        Scanner getDate = new Scanner(System.in);

        String opcion;
        do{
            System.out.println("(1) Regristrar Minutos");
            System.out.println("(2) Registrar Simcard");
            System.out.println("(3) Regristrar Fotocopias");
            System.out.println("(4) Registrar Plotte");
            System.out.println("(5) Registrar Impresion Laser");
            System.out.println("(6) Cierre del dia");
            System.out.println("(7) Salir");
            System.out.print("Opcion:");
            opcion = getDate.next();
            switch (opcion){
                case "1":
                    subMenuMinutos(local,getDate);
                    break;
                case "2":
                    subMenuSimcard(local,getDate);
                    break;
                case "3":
                    subMenuFotocopias(local,getDate);
                    break;
                case "4":
                    subMenuPlotter(local,getDate);
                    break;
                case "5":
                    subMenuImpresora(local,getDate);
                    break;
                case "6":
                    sebMenuCierredia(local);
                    break;
                case "7":
                    System.out.println("Ok");
                    break;
            }

        }while(!opcion.equals("7"));

        System.out.println("************  Gracias ***************\n");
        System.out.println("Ya esta configurada la aplicación");



    }
}