public class Plotter {
    private int valorPlano;
    private int costoPlano;
    private int valorAfiche;
    private int costoAfiche;
    private float anchoAfiche;
    private float altoAfiche;
    private float anchoPlano;
    private float altoPlano;
    private int totalGanancia;
    private int costoTotal;
    private int valorPagado;


    public Plotter(int valorPlano, int costoPlano, int valorAfiche, int costoAfiche) {
        this.valorPlano = valorPlano;
        this.costoPlano = costoPlano;
        this.valorAfiche = valorAfiche;
        this.costoAfiche = costoAfiche;
        this.anchoAfiche = 0;
        this.altoAfiche = 0;
        this.altoPlano = 0;
        this.anchoPlano = 0;
        this.totalGanancia = 0;
        this.costoTotal = 0;
        this.valorPagado = 0;
    }

    public int getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(int valorPagado) {
        this.valorPagado = this.valorPagado + valorPagado;
    }

    public float getAnchoPlano() {
        return anchoPlano;
    }

    public void setAnchoPlano(float anchoPlano) {
        this.anchoPlano = anchoPlano;
    }

    public float getAltoPlano() {
        return altoPlano;
    }

    public void setAltoPlano(float altoPlano) {
        this.altoPlano =  altoPlano;
    }

    public int getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(int valorPlano) {
        this.valorPlano = valorPlano;
    }

    public int getCostoPlano() {
        return costoPlano;
    }

    public void setCostoPlano(int costoPlano) {
        this.costoPlano = costoPlano;
    }

    public int getValorAfiche() {
        return valorAfiche;
    }

    public void setValorAfiche(int valorAfiche) {
        this.valorAfiche = valorAfiche;
    }

    public int getCostoAfiche() {
        return costoAfiche;
    }

    public void setCostoAfiche(int costoAfiche) {
        this.costoAfiche = costoAfiche;
    }

    public float getAnchoAfiche() {
        return anchoAfiche;
    }

    public void setAnchoAfiche(float anchoAfiche) {
        this.anchoAfiche = anchoAfiche;
    }

    public float getAltoAfiche() {
        return altoAfiche;
    }

    public void setAltoAfiche(float altoAfiche) {
        this.altoAfiche = altoAfiche;
    }


    // calculamos el area del afiche
    public float areaAfiche(){
       return  altoAfiche * anchoAfiche;
    }
    // calculamos el area del plano
    public float areaPlano(){
        return altoPlano * anchoPlano;
    }

    public int costo() {
        float total = areaAfiche() * costoAfiche + areaPlano() * costoPlano;
        return (int) total;
    }

    public int costoTotal(){
       return costoTotal;
    }
    public void agregarCosto(){
        costoTotal += costo();
    }

    public int ganancia(){
        float total = (areaPlano() * (valorPlano-costoPlano)) +(areaAfiche() * (valorAfiche-costoAfiche));
        return(int)total;
    }

    public int totalGanancia(){
        return totalGanancia;
    }

    // la ganacia se va acumulando en  la variable
    public void agregarGanancia(){
         totalGanancia+= ganancia();
    }

    @Override
    public String toString() {
        return "Plotter{" +
                " \nvalor Plano=" + valorPlano +
                ",\ncosto Plano=" + costoPlano +
                ",\nvalor Afiche=" + valorAfiche +
                ",\ncosto Afiche=" + costoAfiche +
                ",\nGanancia total = "+ totalGanancia +
                ",\nCosto total: " + costoTotal() +
                '}';
    }
}
