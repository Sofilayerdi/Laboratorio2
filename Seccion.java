class Seccion {
    private String nombreSeccion;  
    private Contenedor[][] contenedores;  
    private int pesoMax;

    public Seccion(String nombreSeccion, int pesoMax) {
        this.nombreSeccion = nombreSeccion;
        this.pesoMax = pesoMax;
        this.contenedores = new Contenedor[10][5];  
    }

    public String getNombreSeccion() {
        return nombreSeccion;  
    }


    public int getPesoMax() {
        return pesoMax;
    }

    public Contenedor[][] getContenedores() {
        return contenedores; 
    }


    public boolean agregarContenedor(Contenedor contenedor) {
        for (int i = 0; i < contenedores.length; i++) {
            for (int j = 0; j < contenedores[i].length; j++) {
                if (contenedores[i][j] == null) {  
                    contenedores[i][j] = contenedor;
                    return true; 
                }
            }
        }
        return false;  
    }


    public int pesoTotal() {
        int pesoTotal = 0;
        for (int i = 0; i < contenedores.length; i++) {
            for (int j = 0; j < contenedores[i].length; j++) {
                if (contenedores[i][j] != null) { 
                    pesoTotal += contenedores[i][j].getPeso();
                }
            }
        }
        return pesoTotal;
    }


    public boolean MoverContenedor(int id, int nFila, int nColumna, Seccion seccionA, Seccion seccionB){
        Contenedor[][] contenedores = seccionA.getContenedores();
        Contenedor[][] contenedores2 = seccionB.getContenedores();
        
        for( int i = 0; i< contenedores.length; i++){
            for(int j = 0; j < contenedores[i].length; j++){
                if (contenedores2[nFila][nColumna] == null && contenedores[i][j].getID() == id){
                    contenedores2[nFila][nColumna] = contenedores[i][j];
                    contenedores[i][j] = null;

                    return true;
                }
            }
        }
        return false; 
    }
}