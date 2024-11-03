

/**
 * Un semplice orologio in formato hh:mm:ss
 * Utilizza il sistema orario di 24 ore
 * 
 * @author Greta Brugnatti
 * @version 03/11/2024
 * 
 */
public class Orologio
{
    private int ore; 
    private int min;
    private int sec;

    /**
     * Costruttore di un orologio
     */
    public Orologio()
    {
        ore = 0;
        min = 0;
        sec = 0;
    }
    
    /**
     * 
     * Costruttore di un orologio dati i seguenti parametri:
     * @param h Ore desiderate (0<h<23)
     * @param m Minuti desiderati (0<m<59)
     * @param s Secondi desiderati (0<s<59)
     * 
     */
    
    public Orologio(int h, int m, int s)
    {
        if(h>=24 || h<0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. Le ore devono essere comprese tra 0 e 23");
        }
        if(m>=60 || m<0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. I minuti devono essere compresi tra 0 e 59");
        }
        if(s>=60 || s<0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. I secondi devono essere compresi tra 0 e 59");
        }
        
        ore = h;
        min = m;
        sec = s;
    }
    
    /**
     *    Ritorna una stringa dell'orario in formato hh:mm:ss
     */
    public String toString()
    {
        String orario = " ";
        if(ore < 10){
            orario = "0" + String.valueOf(ore) + ":";
        } else {
            orario = String.valueOf(ore) + ":";
        }
        
        if(min < 10){
            orario = orario + "0" + String.valueOf(min) + ":";
        } else {
            orario = orario + String.valueOf(min) + ":";
        }
        
        if(sec < 10){
            orario = orario + "0" + String.valueOf(sec);
        } else {
            orario = orario + String.valueOf(sec);
        }
        return orario;
    }
    
    /**
    * 
    * Aggiunge un secondo ai secondi
    * 
    */
    public void tick(){
        if(sec == 59){
            if(min == 59){
                if(ore == 23){
                    ore = 0;
                    min = 0;
                    sec = 0;
                } else {
                    ore = ore + 1;
                    min = 0;
                    sec = 0;
                }
            } else{
                min = min + 1;
                sec = 0;
            }
        } else {
            sec = sec + 1;
        }
    }
    
    /**
     * 
     * Aggiunge n secondi
     * @param s Numero di secondi da aggiungere
     * 
    */
   public void ntick(int s){
      for(int i=0; i < s; i++){
          tick();
      }
   }
   /**
    * 
    * Resetta l'orologio portando lo a mezzanotte
    * 
    */
   public void reset (){
       ore = 0;
       min = 0;
       sec = 0;
   }

}
