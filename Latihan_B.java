/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5;

/**
 *
 * @author advan
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Latihan_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Masukkan kalimat: ");
        String line = br.readLine();

        line = (line == null) ? "" : line.trim();
        int jumlahKata = line.isEmpty() ? 0 : line.split("\\s+").length;

        System.out.println("Jumlah kata: " + jumlahKata);
    }
}
