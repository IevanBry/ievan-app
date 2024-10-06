package com.example.ievan_app

fun main() {
    println("Hai Teman2 Teknik Informatika")
    println("Selamat sudah berhasil naik kelas")

    var angka = 15
    println("Hasil dari angka 15 +10 = ${angka+10}")

    val nilaiInt = 10000 //-2,147,483,648 to 2,147,483,647.
    val nilaiDouble = 100.003 //15 desimal
    val nilaiFloat = 100.00f //7 desimal
    val nilaiLong: Long = 1000000000000004 //-2^63 to 2^63-1
    val nilaiShort: Short = 10 //-32,768 to 32,767
    val nilaiByte: Byte = 1 //-128 to 127

    println("Nilai Integer " + nilaiInt)
    println("Nilai Double " + nilaiDouble)
    println("Nilai Float " + nilaiFloat)
    println("Nilai Long " + nilaiLong)
    println("Nilai Short " + nilaiShort)
    println("Nilai Byte " + nilaiByte)

    val huruf = 'c'
    println("Ini penggunaan karakter '${huruf}'")

    val nilaiBoolean = true
    println("Nilai Boolean yang dibuat adalah $nilaiBoolean")

    val nilaiString = "18"
    println("Halo " + nilaiString + "!\nApa Kabar?")
}
