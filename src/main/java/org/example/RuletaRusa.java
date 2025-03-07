package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RuletaRusa {
    private List<String> jugadores;
    private int posicionBala;
    private int posicionActual;
    private Random aleatorio;

    public RuletaRusa() {
    }

    public RuletaRusa(List<String> jugadores, int posicionBala, int posicionActual, Random aleatorio) {
        this.jugadores = jugadores;
        this.posicionBala = posicionBala;
        this.posicionActual = posicionActual;
        this.aleatorio = aleatorio;
    }

    public RuletaRusa(List<String> jugadores) {
        this.jugadores = jugadores;
        this.aleatorio = new Random();
        nuevoAleatorio();
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<String> jugadores) {
        this.jugadores = jugadores;
    }

    public int getPosicionBala() {
        return posicionBala;
    }

    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return aleatorio;
    }

    public void setRandom(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    public void nuevoAleatorio() {
        this.posicionBala = aleatorio.nextInt(6)  + 1;
        this.posicionActual = aleatorio.nextInt(6) + 1;
    }

    public boolean Disparar() {
        System.out.println("SE ESTA GIRANDO EL TAMBOR");
        System.out.println("POSICION DE LA BALAa:" + posicionBala);
        System.out.println("POSICION DEL DISPARO:" + posicionActual);
        if (posicionBala == posicionActual) {
            return true;
        } else {
            nuevoAleatorio();
            return false;
        }

    }

    public void jugar() {
        int jugadorActual = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("COMIENZA LA RULETA RUSA CON : " + jugadores.size() + " jugadores");
        while (true) {
            String jugador = jugadores.get(jugadorActual);
            System.out.println("TURNO DE " + jugador + " PRESIONA ENTER PARA DISPARAR");
            scanner.nextLine();
            if (Disparar()) {
                System.out.println(jugador + "  HA MUERTO");
                System.out.println("FIN DEL JUEGO");
                break;
            } else {
                System.out.println(jugador + " HA SOBREVIVIDO LA SUERTE ESTA CONTIGO");
                System.out.println("PASANDO AL SIGUIENTE JUGADOR");
            }
            jugadorActual = (jugadorActual + 1) % jugadores.size();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> jugadores = new ArrayList<>();

        System.out.print(" Ingrese el número de jugadores: ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numJugadores; i++) {
            System.out.print("Nombre del Jugador " + i + ": ");
            jugadores.add(scanner.nextLine());
        }

        RuletaRusa juego = new RuletaRusa(jugadores);
        juego.jugar();
    }
}


