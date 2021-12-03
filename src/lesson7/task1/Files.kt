@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

import lesson3.task1.length
import lesson4.task1.digits
import java.io.BufferedWriter
import java.io.File
import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow

// Урок 7: работа с файлами
// Урок интегральный, поэтому его задачи имеют сильно увеличенную стоимость
// Максимальное количество баллов = 55
// Рекомендуемое количество баллов = 20
// Вместе с предыдущими уроками (пять лучших, 3-7) = 55/103

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var currentLineLength = 0
    fun append(word: String) {
        if (currentLineLength > 0) {
            if (word.length + currentLineLength >= lineLength) {
                writer.newLine()
                currentLineLength = 0
            } else {
                writer.write(" ")
                currentLineLength++
            }
        }
        writer.write(word)
        currentLineLength += word.length
    }
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            writer.newLine()
            if (currentLineLength > 0) {
                writer.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(Regex("\\s+"))) {
            append(word)
        }
    }
    writer.close()
}

/**
 * Простая (8 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
 * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
 * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
 * Подчёркивание в середине и/или в конце строк значения не имеет.
 */
fun deleteMarked(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> = TODO()


/**
 * Средняя (12 баллов)
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (15 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (20 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 * Вернуть ассоциативный массив с числом слов больше 20, если 20-е, 21-е, ..., последнее слова
 * имеют одинаковое количество вхождений (см. также тест файла input/onegin.txt).
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя (14 баллов)
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (22 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
<body>
<p>
Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
</p>
<p>
Suspendisse <s>et elit in enim tempus iaculis</s>.
</p>
</body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */

val opHtmlMap = mapOf(
    "**" to "<b>",
    "*" to "<i>",
    "~~" to "<s>"
)
val edHtmlMap = mapOf(
    "**" to "</b>",
    "*" to "</i>",
    "~~" to "</s>",

)

//"<html><body><p>n<i>fH)<b>(</b>cG<b>%zu{W<s>Vs_zy(</s>Y|{<s>/pCTEh%</s>|JDF&<s>,`n)</s>65^</b>tQ<s>_u\\</s>77Q%<s>Kpi!F'MtR</s>!8i3</i>u@2bq/tY]]|<s>V<b>VsO</b>DRt=A0rab</s>M?'Ie<s>]`$RTY\"vMc{$</s>1F'diC?pwDNqi!d{MR%nFts-Bs?<b>z^AS=W1U6{e(c&|bG76G;BB\"'^3.nx|u`0zzqFp2F@?dQ.F5b$0&crQ{3(+c(</b>!{4S<s>#=N^9\\([oX/ch:}md(-rF1rFr9T0T,-Ecbbr|8QA1`k</s>?_!kyYlq=af;iDNI!_RXL%<i>\"eOZmB<s>Z|'V4)!E6X;O5`<b>&:Y</b>ugm}<b>9yHB</b>6c}5])<b>cR</b>R!!7P4Yft</s>E52/vzSA<s>2SQ6U</s>CNu<b>1vRN!</b>$<b>g<s>)'|HH{</s>RmK)eDO[:zgsT8=FRZ</b>n#14#g@#<s>x<b>V</b>|+kS8</s>ik#N%)@6bq<b>)0Pb{'$CQm]is\\l<s>=</s><s>2Q3M</s>Xf</b>K:<b>n.Lj</b></i>?&=UW\\/se3&,Z}<s><i></i>P<i>f]</i>1?+\"ZYD<b>#u<i></i>syWjq</b>[0]wRp1})<b></b>s<i>=f#Pj+</i>-qf<b>F[<i>i/T</i>9=C{WY`;/e<i>{md)</i>;eB</b>9<b>u:</b>g<i>\"eEOQapX<b>(sf</b><b>KWgz</b>_^pzaO]\":A#O</i></s>8Cn{BMT:3}\\Q,-^t:B#U)_Ef;L5uK'<i>vy3E7D=V</i>z:|Ul</p></body></html>"
//"<html><body><p>n<i>fH)<b>(</b>cG<b>%zu{W<s>Vs_zy(</s>Y|{<s>/pCTEh%</s>|JDF&<s>,`n)</s>65^</b>tQ<s>_u\\</s>77Q%<s>Kpi!F'MtR</s>!8i3</i>u@2bq/tY]]|<s>V<b>VsO</b>DRt=A0rab</s>M?'Ie<s>]`$RTY\"vMc{$</s>1F'diC?pwDNqi!d{MR%nFts-Bs?<b>z^AS=W1U6{e(c&|bG76G;BB\"'^3.nx|u`0zzqFp2F@?dQ.F5b$0&crQ{3(+c(</b>!{4S<s>#=N^9\\([oX/ch:}md(-rF1rFr9T0T,-Ecbbr|8QA1`k</s>?_!kyYlq=af;iDNI!_RXL%<i>\"eOZmB<s>Z|'V4)!E6X;O5`<b>&:Y</b>ugm}<b>9yHB</b>6c}5])<b>cR</b>R!!7P4Yft</s>E52/vzSA<s>2SQ6U</s>CNu<b>1vRN!</b>$<b>g<s>)'|HH{</s>RmK)eDO[:zgsT8=FRZ</b>n#14#g@#<s>x<b>V</b>|+kS8</s>ik#N%)@6bq<b>)0Pb{'$CQm]is\\l<s>=</s><s>2Q3M</s>Xf</b>K:<b>n.Lj</b></i>?&=UW\\/se3&</p><p>,</p><p>Z}<s><i></i>P<i>f]</i>1?+\"ZYD<b>#u<i></i>syWjq</b>[0]wRp1})<b></b>s<i>=f#Pj+</i>-qf<b>F[<i>i/T</i>9=C{WY`;/e<i>{md)</i>;eB</b>9<b>u:</b>g<i>\"eEOQapX<b>(sf</b><b>KWgz</b>_^pzaO]\":A#O</i></s>8Cn{BMT:3}\\Q,-^t:B#U)_Ef;L5uK'<i>vy3E7D=V</i>z:|Ul</p></body></html>"

fun markdownToHtmlSimple(inputName: String, outputName: String) {
    var text = File(inputName).readText().replace("  ", " ")
    val stack = Stack<String>()
    var buffer = ""

    fun process(char: Char) {
        if (opHtmlMap[buffer] != null && opHtmlMap[buffer + char.toString()] == null) {
            if (stack.isEmpty() || stack.last() != opHtmlMap[buffer]) {
                stack.add(opHtmlMap[buffer])
                text = text.replaceFirst(buffer, opHtmlMap[buffer]!!, ignoreCase = true)
                buffer = if (char == '~' || char == '*') {
                    char.toString()
                } else ""
            } else {
                stack.pop()
                text = text.replaceFirst(buffer, edHtmlMap[buffer]!!, ignoreCase = true)
                buffer = if (char == '~' || char == '*') {
                    char.toString()
                } else ""
            }
        } else {
            buffer += if (char == '~' || char == '*') {
                char.toString()
            } else ""
        }
    }

    for (char in text) process(char)

    val paragraphs = text.split(Regex("\\r\\n\\s+\\r\\n|\\n\\n\\s+\\n\\n"))
    text = ""
    paragraphs.forEach {
        text += "<p>$it</p>"
    }

    val bw = File(outputName).bufferedWriter()
    bw.write("<html><body>")
    bw.write(text)
    bw.write("</body></html>")
    bw.flush()
    bw.close()
}

/**
 * Сложная (23 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body><p>...</p></body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
 * Утка по-пекински
 * Утка
 * Соус
 * Салат Оливье
1. Мясо
 * Или колбаса
2. Майонез
3. Картофель
4. Что-то там ещё
 * Помидоры
 * Фрукты
1. Бананы
23. Яблоки
1. Красные
2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
<body>
<p>
<ul>
<li>
Утка по-пекински
<ul>
<li>Утка</li>
<li>Соус</li>
</ul>
</li>
<li>
Салат Оливье
<ol>
<li>Мясо
<ul>
<li>Или колбаса</li>
</ul>
</li>
<li>Майонез</li>
<li>Картофель</li>
<li>Что-то там ещё</li>
</ol>
</li>
<li>Помидоры</li>
<li>Фрукты
<ol>
<li>Бананы</li>
<li>Яблоки
<ol>
<li>Красные</li>
<li>Зелёные</li>
</ol>
</li>
</ol>
</li>
</ul>
</p>
</body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная (30 баллов)
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
19935
 *    111
--------
19935
+ 19935
+19935
--------
2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
235
 *  10
-----
0
+235
-----
2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Сложная (25 баллов)
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
19935 | 22
-198     906
----
13
-0
--
135
-132
----
3
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */

/**
 *  616995 | 2
 * -6        308497
 * --
 *  01
 *  -0
 *  --
 *   16
 *  -16
 *  ---
 *   09
 *   -8
 *   --
 *    19
 *   -18
 *   ---
 *     15
 *    -14
 *    ---
 *      1

 */

fun printDivisionProcess(dividend: Int, divisor: Int, outputName: String) {
    val dividendDigits = dividend.digits().reversed()
    val divisorDigits = divisor.digits().reversed()
    val quotient = dividend / divisor
    val quotientDigits = quotient.digits().reversed()
    val remainder = dividend % divisor
    val remainderDigits = remainder.digits().reversed()

    val matrix = Array(3 * quotient.length() + 1) { Array(dividend.length() + 1) { " " } }

    // prints some int in matrix
    // returns endIndex
    fun printIntInMatrix(n: Int, row: Int, startIndex: Int): Int {
        for ((index, digit) in n.digits().reversed().withIndex()) {
            matrix[row][startIndex + index] = digit.toString()
        }
        return startIndex + n.length() - 1
    }

    // returns startIndex
    fun printIntInMatrixByEndIndex(n: Int, row: Int, endIndex: Int, addMinus: Boolean = false): Int {
        for ((index, digit) in n.digits().withIndex()) {
            matrix[row][endIndex - index] = digit.toString()
        }
        if (addMinus) {
            matrix[row][endIndex - n.length()] = "-"
            return endIndex - n.length()
        }
        return endIndex - n.length() + 1
    }

    // returns endIndex
    fun printInMatrix(string: String, row: Int, startIndex: Int): Int {
        string.forEachIndexed { index, c ->
            matrix[row][startIndex + index] = c.toString()
        }
        return startIndex + string.length - 1
    }

    fun indexOfSmth(row: Int): Int {
        for (i in matrix[row].indices) if (matrix[row][i] != " ") return i
        return -1
    }

    printIntInMatrix(dividend, 0, 1)
    var div2 = quotientDigits[0] * divisor
    var div1 = if (div2 != 0) {
        if (dividend.subInt(div2.length()) < div2) dividend.subInt(div2.length() + 1)
        else dividend.subInt(div2.length())
    } else dividend
    printIntInMatrixByEndIndex(div2, 1, div1.length(), addMinus = true)
    var remIndex = printInMatrix(
        "-".repeat(maxOf(div2.length() + 1, div1.length())),
        2,
        minOf(indexOfSmth(0), indexOfSmth(1))
    )
    var rem = div1 - div2
    val offset = indexOfSmth(1) + div2.length() - 1

    for (i in 1 until quotient.length()) {
        printIntInMatrixByEndIndex(rem, 3 * i, remIndex)
        printIntInMatrixByEndIndex(dividendDigits[i + offset], 3 * i, remIndex + 1)
        div2 = quotientDigits[i] * divisor
        div1 = rem * 10 + dividendDigits[i + offset]
        printIntInMatrixByEndIndex(div2, 3 * i + 1, remIndex + 1, addMinus = true)
        remIndex = printInMatrix(
            "-".repeat(maxOf(div2.length() + 1, div1.length())),
            3 * i + 2,
            minOf(indexOfSmth(3 * i + 1), indexOfSmth(3 * i))
        )
        rem = div1 - div2
    }

    printIntInMatrixByEndIndex(rem, matrix.size - 1, dividend.length())

    val bw = File(outputName).bufferedWriter()

    var hasUselessSpaces = true
    matrix.forEach {
        if (it[0] != " ") {
            hasUselessSpaces = false
            return@forEach
        }
    }

    matrix.forEachIndexed { index, array ->
        when (index) {
            0 -> {
                for ((i, c) in array.withIndex()) {
                    if (hasUselessSpaces && i == 0) continue
                    bw.write(c)
                }
                bw.writeln(" | $divisor")
            }
            1 -> {
                for ((i, c) in array.withIndex()) {
                    if (hasUselessSpaces && i == 0) continue
                    bw.write(c)
                }
                bw.writeln("   $quotient")
            }
            else -> {
                var printedLine = false
                for ((i, c) in array.withIndex()) {
                    if (hasUselessSpaces && i == 0) continue
                    if (printedLine && c == " ") break
                    if (c != " ") printedLine = true
                    bw.write(c)
                }
                bw.newLine()
            }
        }
    }
    bw.flush()
    bw.close()
}

fun Int.subInt(startIndex: Int, endIndex: Int): Int {
    val digits = this.digits().reversed()
    var result = 0
    for (i in startIndex until endIndex) {
        result += digits[i]
        result *= 10
    }
    return result / 10
}

fun Int.subInt(endIndex: Int) = this.subInt(0, endIndex)

fun BufferedWriter.writeln(string: String) {
    write(string)
    newLine()
}