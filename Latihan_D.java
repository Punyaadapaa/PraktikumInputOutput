/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5;

/**
 *
 * @author advan
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Latihan_D {
    public static void main(String[] args) {
        try {
            Path sumber = Path.of("911.png");
            Path tujuan = Path.of("copy_911.png");

            if (!Files.exists(sumber)) {
                System.err.println("File sumber tidak ditemukan: " + sumber.toAbsolutePath());
                return;
            }

            if (tujuan.getParent() != null) {
                Files.createDirectories(tujuan.getParent());
            }

            Files.copy(sumber, tujuan, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Berhasil menyalin file!");
            System.out.println("Dari : " + sumber.toAbsolutePath());
            System.out.println("Ke   : " + tujuan.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Gagal menyalin file: " + e.getMessage());
        }
    }
}

