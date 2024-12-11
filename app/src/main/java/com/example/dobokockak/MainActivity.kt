package com.example.dobokockak

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize button
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        listView = findViewById(R.id.listView)
        enableEdgeToEdge()

        // Edge-to-edge insets setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Spinner setup
        // The items are now retrieved from strings.xml
        val spinner: Spinner = findViewById(R.id.spinner)

        // Set default unselectable item for Spinner
        val initialItems = resources.getStringArray(R.array.kockak).toList()
        val items = initialItems
        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout for spinner items
            initialItems // Items to display in the spinner
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0) // Set no default selection, so prompt item is displayed




    fun dice(diceType: String) : String
    {

        val currentTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val currentTimeString = dateFormat.format(Date(currentTime))

        when (diceType)
        {
            "Érme" -> when (Random.nextInt(2))
            {
                1 -> return "Érme   Fej     $currentTimeString"
                0 -> return "Érme   Írás    $currentTimeString"
            }

            "Általános dobókocka" -> when (Random.nextInt(6))
            {
                1 -> return "Általános dobókocka    1   $currentTimeString"
                2 -> return "Általános dobókocka    2   $currentTimeString"
                3 -> return "Általános dobókocka    3   $currentTimeString"
                4 -> return "Általános dobókocka    4   $currentTimeString"
                5 -> return "Általános dobókocka    5   $currentTimeString"
                0 -> return "Általános dobókocka    6   $currentTimeString"
            }

            "Tetraéder" -> when (Random.nextInt(4))
            {
                1 -> return "Tetraéder    1   $currentTimeString"
                2 -> return "Tetraéder    2   $currentTimeString"
                3 -> return "Tetraéder    3   $currentTimeString"
                0 -> return "Tetraéder    4   $currentTimeString"
            }

            "Oktaéder" -> when (Random.nextInt(8))
            {
                1 -> return "Oktaéder   1   $currentTimeString"
                2 -> return "Oktaéder   2   $currentTimeString"
                3 -> return "Oktaéder   3   $currentTimeString"
                4 -> return "Oktaéder   4   $currentTimeString"
                5 -> return "Oktaéder   5   $currentTimeString"
                6 -> return "Oktaéder   6   $currentTimeString"
                7 -> return "Oktaéder   7   $currentTimeString"
                0 -> return "Oktaéder   8   $currentTimeString"
            }

            "Dodekaéder" -> when (Random.nextInt(12))
            {
                1 -> return "Dodekaéder     1     $currentTimeString"
                2 -> return "Dodekaéder     2     $currentTimeString"
                3 -> return "Dodekaéder     3     $currentTimeString"
                4 -> return "Dodekaéder     4     $currentTimeString"
                5 -> return "Dodekaéder     5     $currentTimeString"
                6 -> return "Dodekaéder     6     $currentTimeString"
                7 -> return "Dodekaéder     7     $currentTimeString"
                8 -> return "Dodekaéder     8     $currentTimeString"
                9 -> return "Dodekaéder     9     $currentTimeString"
                10 -> return "Dodekaéder    10    $currentTimeString"
                11 -> return "Dodekaéder    11    $currentTimeString"
                0 -> return "Dodekaéder     12    $currentTimeString"
            }

            "Ikozaéder" -> when (Random.nextInt(20))
            {
                1 -> return "Ikozaéder  1   $currentTimeString"
                2 -> return "Ikozaéder  2   $currentTimeString"
                3 -> return "Ikozaéder  3   $currentTimeString"
                4 -> return "Ikozaéder  4   $currentTimeString"
                5 -> return "Ikozaéder  5   $currentTimeString"
                6 -> return "Ikozaéder  6   $currentTimeString"
                7 -> return "Ikozaéder  7   $currentTimeString"
                8 -> return "Ikozaéder  8   $currentTimeString"
                9 -> return "Ikozaéder  9   $currentTimeString"
                10 -> return "Ikozaéder 10  $currentTimeString"
                11 -> return "Ikozaéder 11  $currentTimeString"
                12 -> return "Ikozaéder 12  $currentTimeString"
                13 -> return "Ikozaéder 13  $currentTimeString"
                14 -> return "Ikozaéder 14  $currentTimeString"
                15 -> return "Ikozaéder 15  $currentTimeString"
                16 -> return "Ikozaéder 16  $currentTimeString"
                17 -> return "Ikozaéder 17  $currentTimeString"
                18 -> return "Ikozaéder 18  $currentTimeString"
                19 -> return "Ikozaéder 19  $currentTimeString"
                0 -> return "Ikozaéder  20  $currentTimeString"

            }
        }
        return "Érvénytelen dobókocka típus"
    }


    // Button click event setup
        button.setOnClickListener {
            val result = dice(spinner.selectedItem.toString())
            Toast.makeText(this, result, Toast.LENGTH_LONG).show()

            // Add result to ListView
            val adapter = listView.adapter as? ArrayAdapter<String> ?: ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
            adapter.add(result)
            listView.adapter = adapter
        }

        button2.setOnClickListener {
            Toast.makeText(this, "Lista Törölve", Toast.LENGTH_LONG).show()

            // Add result to ListView
            val adapter = listView.adapter as? ArrayAdapter<String> ?: ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
            adapter.clear()
            listView.adapter = adapter
        }

        button3.setOnClickListener {
            val adapter = listView.adapter as? ArrayAdapter<String>
            if (adapter != null) {
                var totalCount = 0
                var coinCount = 0
                var d4Count = 0
                var d6Count = 0
                var d8Count = 0
                var d12Count = 0
                var d20Count = 0

                val d4Rolls = mutableListOf<Int>()
                val d6Rolls = mutableListOf<Int>()
                val d8Rolls = mutableListOf<Int>()
                val d12Rolls = mutableListOf<Int>()
                val d20Rolls = mutableListOf<Int>()

                // Iterate over each item in the list and extract relevant statistics
                for (i in 0 until adapter.count) {
                    val item = adapter.getItem(i)
                    if (item != null) {
                        totalCount++
                        when {
                            item.contains("Érme") -> coinCount++
                            item.contains("Tetraéder") -> {
                                d4Count++
                                val parts = item.split("\\s+".toRegex()) // whitespace slpit
                                val value = parts[1].toIntOrNull() ?: 0
                                d4Rolls.add(value)

                            }
                            item.contains("Általános dobókocka") -> {
                                d6Count++
                                val parts = item.split("\\s+".toRegex()) // whitespace slpit
                                val value = parts[1].toIntOrNull() ?: 0
                                d6Rolls.add(value)
                            }
                            item.contains("Oktaéder") -> {
                                d8Count++
                                val parts = item.split("\\s+".toRegex()) // whitespace slpit
                                val value = parts[1].toIntOrNull() ?: 0
                                d8Rolls.add(value)
                            }
                            item.contains("Dodekaéder") -> {
                                d12Count++
                                val parts = item.split("\\s+".toRegex()) // whitespace slpit
                                val value = parts[1].toIntOrNull() ?: 0
                                d12Rolls.add(value)
                            }
                            item.contains("Ikozaéder") -> {
                                d20Count++
                                val parts = item.split("\\s+".toRegex()) // whitespace slpit
                                val value = parts[1].toIntOrNull() ?: 0
                                d20Rolls.add(value)
                            }
                        }
                    }
                }

                // Helper function to get the most and least frequent value
                fun getMostAndLeastFrequent(rolls: List<Int>): Pair<String, String> {
                    if (rolls.isEmpty()) return "Nincs statisztika" to "Nincs statisztika"
                    val frequencyMap = rolls.groupingBy { it }.eachCount()
                    val mostFrequent = frequencyMap.maxByOrNull { it.value }?.key ?: "Nincs statisztika"
                    val leastFrequent = frequencyMap.minByOrNull { it.value }?.key ?: "Nincs statisztika"
                    return "$mostFrequent" to "$leastFrequent"
                }

                // Inflate the custom layout
                val dialogView = layoutInflater.inflate(R.layout.dialog_statistics, null)

                // Set values in the custom layout
                dialogView.findViewById<TextView>(R.id.totalCountTextView).text = "Összes dobás száma: $totalCount"
                dialogView.findViewById<TextView>(R.id.coinCountTextView).text = "Érme dobások száma: $coinCount"
                dialogView.findViewById<TextView>(R.id.d4CountTextView).text = "Tetraéder dobások száma: $d4Count"
                dialogView.findViewById<TextView>(R.id.d6CountTextView).text = "Általános dobókocka dobások száma: $d6Count"
                dialogView.findViewById<TextView>(R.id.d8CountTextView).text = "Oktaéder dobások száma: $d8Count"
                dialogView.findViewById<TextView>(R.id.d12CountTextView).text = "Dodekaéder dobások száma: $d12Count"
                dialogView.findViewById<TextView>(R.id.d20CountTextView).text = "Ikozaéder dobások száma: $d20Count"

                // Set most and least frequent values for each dice type
                val (d4Most, d4Least) = getMostAndLeastFrequent(d4Rolls)
                val (d6Most, d6Least) = getMostAndLeastFrequent(d6Rolls)
                val (d8Most, d8Least) = getMostAndLeastFrequent(d8Rolls)
                val (d12Most, d12Least) = getMostAndLeastFrequent(d12Rolls)
                val (d20Most, d20Least) = getMostAndLeastFrequent(d20Rolls)

                dialogView.findViewById<TextView>(R.id.d4mostFrequentTextView).text = "Leggyakoribb dobás: $d4Most"
                dialogView.findViewById<TextView>(R.id.d4leastFrequentTextView).text = "Legritkább dobás: $d4Least"

                dialogView.findViewById<TextView>(R.id.d6mostFrequentTextView).text = "Leggyakoribb dobás: $d6Most"
                dialogView.findViewById<TextView>(R.id.d6leastFrequentTextView).text = "Legritkább dobás: $d6Least"

                dialogView.findViewById<TextView>(R.id.d8mostFrequentTextView).text = "Leggyakoribb dobás: $d8Most"
                dialogView.findViewById<TextView>(R.id.d8leastFrequentTextView).text = "Legritkább dobás: $d8Least"

                dialogView.findViewById<TextView>(R.id.d12mostFrequentTextView).text = "Leggyakoribb dobás: $d12Most"
                dialogView.findViewById<TextView>(R.id.d12leastFrequentTextView).text = "Legritkább dobás: $d12Least"

                dialogView.findViewById<TextView>(R.id.d20mostFrequentTextView).text = "Leggyakoribb dobás: $d20Most"
                dialogView.findViewById<TextView>(R.id.d20leastFrequentTextView).text = "Legritkább dobás: $d20Least"

                // Create and show an AlertDialog with the custom layout
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Statisztika")
                builder.setView(dialogView)
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
            } else {
                Toast.makeText(this, "Nincs elem a listában", Toast.LENGTH_LONG).show()
            }
        }




    }
}
