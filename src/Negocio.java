import java.util.ArrayList;

public class Negocio {

    private Fotocopia fotocopia;
    private Impresora impresora;
    private Plotter plotter;
    private ArrayList<Operador> lisOper;
    private int constoEnergiaDia;
    private int costoEmpleadoDia;

    public Negocio(int costoEmpleadoDia, int constoEnergiaDia) {

        this.impresora = new Impresora(400,250,100,200);
        this.fotocopia = new Fotocopia(150,50,80,100);
        this.plotter = new Plotter(80,20,100,40);


        lisOper = new ArrayList<>();
        lisOper.add(new Operador("Uff",30,100,1000,500));
        lisOper.add(new Operador("Claro",60,100,3000,1500));
        lisOper.add(new Operador("Molestar",70,100,1500,600));

        this.costoEmpleadoDia = costoEmpleadoDia;
        this.constoEnergiaDia = constoEnergiaDia;
    }

    public Fotocopia getFotocopia() {
        return fotocopia;
    }

    public void setFotocopia(Fotocopia fotocopia) {
        this.fotocopia = fotocopia;
    }

    public Plotter getPlotter() {
        return plotter;
    }

    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
    }

    public Impresora getImpresora(){
        return impresora;
    }
    public void setImpresora(Impresora impresora){
        this.impresora = impresora;
    }

    public ArrayList<Operador> getLisOper() {
        return lisOper;
    }

    public void setLisOper(ArrayList<Operador> lisOper) {
        this.lisOper = lisOper;
    }

    public int getConstoEnergiaDia() {
        return constoEnergiaDia;
    }

    public void setConstoEnergiaDia(int constoEnergiaDia) {
        this.constoEnergiaDia = constoEnergiaDia;
    }

    public int getCostoEmpleadoDia() {
        return costoEmpleadoDia;
    }

    public void setCostoEmpleadoDia(int costoEmpleadoDia) {
        this.costoEmpleadoDia = costoEmpleadoDia;
    }

    // acciones o comportamientos

    public boolean registrar(int i,int cantidaM) {
            System.out.println("Oper =" + this.lisOper.get(i - 1).getNombre() + "[" + this.lisOper.get(i - 1).getCantidaM() + "]");
            this.lisOper.get(i - 1).setCantidaM(cantidaM);
            System.out.println("Oper =" + this.lisOper.get(i - 1).getNombre() + "[" + this.lisOper.get(i - 1).getCantidaM() + "]");
            System.out.println("Ganacia =" + this.lisOper.get(i - 1).ganancia() + "Costo=[" + this.lisOper.get(i - 1).costo() + "]");

        return true;
    }
    public boolean registrarS(int i,int cantidadS){
        System.out.println("Sim =" + this.lisOper.get(i - 1).getNombre() + "[" + this.lisOper.get(i - 1).getCantidadSim() + "]");
        this.lisOper.get(i - 1).setCantidadSim(cantidadS);
        System.out.println("Sim =" + this.lisOper.get(i - 1).getNombre() + "[" + this.lisOper.get(i - 1).getCantidadSim() + "]");
        System.out.println("Ganacia =" + this.lisOper.get(i - 1).gananciaSim() + "\nCosto=[" + this.lisOper.get(i - 1).costoSim() + "]");

        return  true;
    }

    public boolean registrarImpresora(int opc, int cantidad,int valorPagado){

        if(opc == 1){
            if(valorPagado == cantidad * this.impresora.getValorColor()){
                impresora.setCanitdadColor(cantidad);
            }
            else{
                return false;
            }
        }

        else
            if(opc == 2) {
                if (valorPagado == cantidad * this.impresora.getValorBn()) {
                    impresora.setCantidadBN((cantidad));
                }
                else
                    return false;
            }
            else
                return false;

        this.impresora.setValorPagado(valorPagado);
       return true ;
    }

    public boolean ventaMayor(){

        //Creamos variables para que guarden la ganacia mayor
        int mayorOperador =0;
        int mayorSimcard = 0;
        String nombreOperador = "";
        String nombreSimacard = "";

        for (int i = 0; i < lisOper.size(); i++) {
            if(lisOper.get(i).ganancia() > mayorOperador){
                mayorOperador = lisOper.get(i).ganancia();
                nombreOperador = lisOper.get(i).getNombre();
            }
            for (int j = 0; j < lisOper.size() ; j++) {
                if(lisOper.get(j).gananciaSim() > mayorSimcard){
                    mayorSimcard = lisOper.get(j).gananciaSim();
                    nombreSimacard = lisOper.get(j).getNombre();
                }
            }
        }


        //evaluamos los diferentes casos para saber cual es la ganancia mayor
        if(mayorOperador > fotocopia.ganancia() && mayorOperador > impresora.ganancia()&&
            mayorOperador > mayorSimcard && mayorOperador >plotter.totalGanancia()){
            System.out.println("El servicio con mayor ganancia es operador es: "+ nombreOperador +"="+ mayorOperador);
        }
        else if (mayorSimcard > mayorOperador && mayorSimcard > fotocopia.ganancia() &&
                mayorSimcard > impresora.ganancia() && mayorSimcard > plotter.totalGanancia()) {
            System.out.println("El servicio con mayor ganancia es la venta de simcard "+nombreSimacard +"= "+ mayorSimcard);
        }
        else if(fotocopia.ganancia() > mayorOperador && fotocopia.ganancia() > impresora.ganancia() &&
                fotocopia.ganancia() > mayorSimcard && fotocopia.ganancia() > plotter.totalGanancia()){
            System.out.println("EL servicio con mayor ganancia es Fotocopia con = " + fotocopia.ganancia());
        }
        else if (impresora.ganancia()>mayorOperador && impresora.ganancia() > fotocopia.ganancia() &&
                impresora.ganancia() > mayorSimcard && impresora.ganancia() > plotter.totalGanancia()) {
            System.out.println("El servicio con mayor ganancia es IMPRESORA con = " + impresora.ganancia());
        }
        else
            if(plotter.totalGanancia() > mayorOperador && plotter.totalGanancia() > impresora.ganancia()
        && plotter.totalGanancia()> fotocopia.ganancia() && plotter.totalGanancia() > mayorSimcard){
            System.out.println("EL servicio con mayor ganancia es Ploter =" + plotter.totalGanancia());
        }

        return true;

    }
    public boolean registrar(int tipoC,int cantidad, int valorPagado){

        if(tipoC==1){
            if(valorPagado==cantidad*this.fotocopia.getValorColor())
                this.fotocopia.setCanitdadColor(cantidad);
            else
                return false;
        }
        else
        if(tipoC==2){
            if(valorPagado==cantidad*this.fotocopia.getValorBn())
                this.fotocopia.setCantidadBN(cantidad);
            else
                return false;
        }
        else
            return false;

        this.fotocopia.setValorPagado(valorPagado);
        return true;
    }

    public boolean registrar(int opc, int valorPagado,int ancho,int alto){

        //Inicializamos la variables a cero del ancho del plano y el alto del afiche
        getPlotter().setAnchoAfiche(0);
        getPlotter().setAltoAfiche(0);
        //Inicializamos la variables a cero del ancho del plano y el alto del Plano
        getPlotter().setAnchoPlano(0);
        getPlotter().setAltoPlano(0);


            //Validamos que opcion escoge el usuario
            if (opc == 1) {

                if (valorPagado == (ancho * alto) * plotter.getValorAfiche()) {
                    getPlotter().setAnchoAfiche(ancho);
                    getPlotter().setAltoAfiche(alto);
                } else {
                    return false;
                }
            } else if (opc == 2) {
                if (valorPagado == (ancho * alto) * plotter.getValorPlano()) {
                    plotter.setAltoPlano(alto);
                    plotter.setAnchoPlano(ancho);
                } else
                    return false;
            }
        this.plotter.setValorPagado(valorPagado);

            //LLamamos estos metodos para que nos guardando las ganancias y costos
            plotter.agregarGanancia();
            plotter.agregarCosto();
        return true;
    }


    //Sumamos todos los costos de los servicios
    public int costo(){
        return fotocopia.costo() + impresora.costo() + plotter.costoTotal()+ getConstoEnergiaDia() +
                getCostoEmpleadoDia();
    }
    public int gananciaServicios(){
        return fotocopia.ganancia()+ impresora.ganancia()+plotter.totalGanancia();
    }


}
