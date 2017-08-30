package sort.radix

import sort.Sort
import java.util.*

/**
 * Algorithm, who shows Radix sort
 */
class Radix : Sort() {
    override fun sort(array: Array<Int>): Array<Int> {

        //определить максимальное


        val it : Iterator<Int> = array.iterator()

        val newArray : Array<Int> = Array(array.size, {i -> 0})
        var koef = 1
        //по коллекциии строим гистограмму беря остаток от деления на число кратное 10
        //сначала десятки, потом сотки, потом тысячи


        //найдем максимамальное число в списке
        var max = Int.MIN_VALUE
        while (it.hasNext()){
            val number = it.next()
            if (number > max) max = number
        }

        //пока у нас установлено что все числа в 10ой системе счисления

        var radixNumber = max.toString().length
//        var count = 0;
//        do{
//            radixNumber = max / 10
//            max /= 10
//            count = count.inc()
//        }while (radixNumber != 0)
        var cloneArray = array.clone()
        var i = 0
        while(i < radixNumber) {
            val hist :  Array<Int> = Array(10, {i -> 0})
            val func :  Array<Int> = Array(10, {i -> 0})
            //нужен еще внешний цикл, который будет по разрядам
            koef *= 10
            var j = 0
            while (j < cloneArray.size) {
                val mod = (cloneArray[j] % koef)
                hist[mod] = hist[mod].inc()
                j = j.inc()
            }
            //из гистограммы получаем функцию распределения
            func[0] = hist[0]
            for (i in 1..(hist.size - 1)) {
                func[i] = func[i - 1] + hist[i]
            }
            for (i in (cloneArray.size - 1) downTo 0) {
                val number = cloneArray[i] % koef
                newArray[func[number] - 1] = array[i]
                func[number] = func[number].dec()
            }
            j = 0
            while (j < cloneArray.size) {
                cloneArray[j] /= 10
                j = j.inc()
            }
            i = i.inc()

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
            println("Исходный массив");
            array.forEach{print(it.toString() + " ")}
            println()
            println()

            radix.sort(array).forEach{print(it.toString() + " ")}
            println()
        }
    }
}