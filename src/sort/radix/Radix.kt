package sort.radix

import sort.Sort

/**
 * Algorithm, who shows Radix sort
 */
class Radix : Sort() {
    override fun sort(array: Array<Int>): Array<Int> {

        //определить максимальное

        val hist :  Array<Int> = Array(10, {i -> 0})
        val func :  Array<Int> = Array(10, {i -> 0})
        val it : Iterator<Int> = array.iterator()
        val newArray : Array<Int> = Array(array.size, {i -> 0})
        var koef = 1
        //по коллекциии строим гистограмму беря остаток от деления на число кратное 10
        //сначала десятки, потом сотки, потом тысячи

        //нужен еще внешний цикл, который будет по разрядам
        koef *= 10
        while (it.hasNext()){
            val number = it.next()
            val mod = number % koef
            hist[mod] = hist[mod].inc()
        }
        //из гистограммы получаем функцию распределения
        func[0] = hist[0]
        for (i in 1..(hist.size - 1)){
            func[i] = func[i - 1] + hist[i]
        }
        for (i in (array.size - 1) downTo 0){
            val number = array[i] % koef
            newArray[func[number]] = array[i]
            func[number] = func[number].dec()
        }
        return array
    }
}