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
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Latihan_C {

    private static String normalize(String s) {
        if (s == null) return "";
        s = s.toLowerCase();
        s = s.replaceAll("[^\\p{L}\\p{Nd}]+", " ");
        return s.trim();
    }

    public static void main(String[] args) {
        Path input  = Path.of(args.length > 0 ? args[0] : "input.txt");
        Path output = Path.of(args.length > 1 ? args[1] : "count.txt");

        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(input, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                String norm = normalize(line);
                if (norm.isEmpty()) continue;

                String[] words = norm.split("\\s+"); 
                for (String w : words) {
                    if (w.isEmpty()) continue;
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        Map<String, Integer> sorted = new TreeMap<>(freq);

        try (BufferedWriter bw = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            for (Map.Entry<String, Integer> e : sorted.entrySet()) {
                bw.write(e.getKey() + ":" + e.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Gagal menulis file: " + e.getMessage());
            return;
        }

        System.out.println("Selesai. Hasil disimpan ke: " + output.toAbsolutePath());
    }
}
