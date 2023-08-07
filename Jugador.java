import java.lang.Math.*;

public class Jugador{
  //campos
  private String nombre;
  private String clase;
  private double vida;
  private int ataque;
  private int defensa;
  private int dinero;
  private int experiencia;

  //constructores
  private Jugador(String nombre, String clase, double vida, int ataque, int defensa, int dinero, int experiencia){
    this.nombre = nombre;
    if (clase.equals("hunter") || clase.equals("warrior") || clase.equals("assasin") || clase.equals("tank")){
      this.clase = clase;
    }
    else{
      this.clase = "normal";
    }
    this.vida = vida;
    this.ataque = ataque;
    this.defensa = defensa;
    this.dinero = dinero;
    this.experiencia = experiencia;
  }

  public Jugador(String nombre, String clase){
    if (clase.equals("cazador")){
      new Jugador(nombre, clase, 1, 50, 0, 100, 0);
    }
    else if (clase.equals("luchador")){
      new Jugador(nombre, clase, 100, 70, 0, 100, 0);
    }
    else if (clase.equals("asesino")){
      new Jugador(nombre, clase, 60, 160, 30, 100, 0);
    }
    else if (clase.equals("tanque")){
      new Jugador(nombre, clase, 130, 20, 100, 100, 0);
    }
    else if(clase.equals("normal")){
      new Jugador(nombre, clase, 90, 80, 80, 100, 0);
    }
  }

  //metodos

  public String getNombre(){
    return this.nombre;
  }
  public String getClase(){
    return this.clase;
  }
  public double getVida(){
    return this.vida;
  }
  public int getAtaque(){
    return this.ataque;
  }
  public int getDefensa(){
    return this.defensa;
  }
  private void lastimar(int ataque){
    //minimo de balance es 1, maximo recomendado es 99.
    int balance_defensa = 13;
    double ataque_real = ataque*((1+balance_defensa/1000)-Math.pow((1+balance_defensa/1000),this.defensa))/(1+balance_defensa/1000);
    this.vida -= ataque_real;  
  }
  public void curar(double cura){
    this.vida += cura; 
  }
  public void atacar(Jugador victima){
    victima.lastimar(this.ataque);
  }

}