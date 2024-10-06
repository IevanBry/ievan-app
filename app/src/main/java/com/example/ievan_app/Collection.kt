package com.example.ievan_app

fun main() {
    val kataMutable: MutableList<String> = mutableListOf("Hai", "Halo", "Aloha")
    println("List yang menggunakan Mutable " + kataMutable)

    kataMutable.add("Hi")
    println("List mutable setelah di tambahkan " + kataMutable)

    kataMutable.removeAt(0)
    println("List mutable setelah dihapus " + kataMutable)

    kataMutable.shuffle()
    println("List mutable setelah shuffle " + kataMutable)

    val kataImmutable: List<String> = kataMutable
    println(kataImmutable)

    println("Kata pertama dari mutable : " + kataImmutable.first())

    val cobaSet: Set<String> = setOf("Pemrograman", "Pemrograman", "Mobile")
    println("Set : " + cobaSet)

    val cobaMap: Map<Int, String> = mapOf(1 to "Shumaya", 2 to "Resty", 3 to "Ramadhani")
    println("Map : " + cobaMap.values)
}