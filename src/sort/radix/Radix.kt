package sort.radix

import sort.Sort
import java.util.*

/**
 * Algorithm, who shows Radix sort
 */
class Radix : Sort() {
    override fun sort(array: Array<Int>): Array<Int> {

        val koef = 10
        val it : Iterator<Int> = array.iterator()
        var max = Int.MIN_VALUE
        while (it.hasNext()){
            val number = it.next()
            if (number > max) max = number
        }

        val radixNumber = max.toString().length
        var cloneArray = array.clone()
        val newArray = array.clone()
        var i : Int
        i = 0
        while(i < radixNumber) {
            val hist :  Array<Int> = Array(koef, {x -> 0})
            val func :  Array<Int> = Array(koef, {x -> 0})
            //нужен еще внешний цикл, который будет по разрядам

            var j = 0
            while (j < cloneArray.size) {
                val mod = cloneArray[j] % koef
                hist[mod] = hist[mod].inc()
                j = j.inc()
            }
            //из гистограммы получаем функцию распределения
            func[0] = hist[0]
            for (k in 1..(hist.size - 1)) {
                func[k] = func[k - 1] + hist[k]
            }
            j = 0
            while (j < cloneArray.size) {
                cloneArray[j] = newArray[j]
                j = j.inc()
            }

            for (k in (cloneArray.size - 1) downTo 0) {
                val q = Math.pow(koef.toDouble(), i.toDouble()).toInt()
                val r = cloneArray[k] / q
                val number = r % koef
                newArray[func[number] - 1] = cloneArray[k]
                func[number] = func[number].dec()
            }
            i = i.inc()
            j = 0
            cloneArray = newArray.clone()
            while (j < cloneArray.size) {
                cloneArray[j] = cloneArray[j] / koef
                j = j.inc()
            }


            println()
            println("Отладочный вывод на шаге" + i)
            newArray.forEach{print(it.toString() + " ")}
            println()
        }
        println()
        println()
        println("Результат")
        return newArray
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val radix = Radix()
            val array = Array<Int>(Random().nextInt(30), { i -> Random().nextInt(30)})
            println("Исходный массив")
            array.forEach{print(it.toString() + " ")}
            println()
            println()

            radix.sort(array).forEach{print(it.toString() + " ")}
            println()
        }
    }
}