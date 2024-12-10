public class Operador {

    private  String nombre;
    private  int costoM;
    private  int valorVenta;
    private  int cantidaM;
    private int valorSimcard;
    private int costoSimcard;
    private int cantidadSim;


    public Operador(String nombre, int costoM, int valorVenta, int valorSimcard, int costoSimcard) {
        this.nombre = nombre;
        this.costoM = costoM;
        this.valorVenta = valorVenta;
        this.valorSimcard = valorSimcard;
        this.costoSimcard = costoSimcard;
        this.cantidaM=0;
        this.cantidadSim = 0;
    }

    public int getCantidadSim() {
        return cantidadSim;
    }
//vamos sumando las cantidades de simcard y se van acumulando
    public void setCantidadSim(int cantidadSim) {
        this.cantidadSim = this.cantidadSim + cantidadSim;
    }

    public int getValorSimcard() {
        return valorSimcard;
    }

    public void setValorSimcard(int valorSimcard) {
        this.valorSimcard = valorSimcard;
    }

    public int getCostoSimcard() {
        return costoSimcard;
    }

    public void setCostoSimcard(int costoSimcard) {
        this.costoSimcard = costoSimcard;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoM() {
        return costoM;
    }

    public void setCostoM(int costoM) {
        this.costoM = costoM;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public int getCantidaM() {
        return cantidaM;
    }

    public void setCantidaM(int cantidaM) {
        this.cantidaM = this.cantidaM + cantidaM;
    }
    // acción o comportamiento

    public int ganancia(){

        return this.cantidaM * this.valorVenta - this.cantidaM * this.costoM;
    }
    public int costo(){
        return this.cantidaM * this.costoM;
    }

    //Es la el valor que el cliente ha pagado
    public int valorRecolectado(){

        return this.cantidaM*this.valorVenta + this.cantidadSim * this.valorSimcard;
    }

    public int gananciaSim(){

        return this.cantidadSim * this.valorSimcard - this.cantidadSim * this.costoSimcard;

    }
    public int costoSim(){
        return this.cantidadSim * this.costoSimcard;
    }
    //Sumamos el costo del las simcard con las de minutos
    public int costoTotal(){
        return costoSim() + costo();
    }
    //Sumamos la ganancia de los minutos con la ganancia de las simcard
    public int gananciaTotal(){
        return gananciaSim()+ganancia();
    }


}
