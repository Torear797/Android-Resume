package ru.torear.resume.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.torear.resume.R
import ru.torear.resume.SpacesItemDecoration
import ru.torear.resume.models.News
import java.util.*

class NewsFragment : Fragment(), MyNewsRecyclerViewAdapter.OnNewsClickListener {

    private val news: MutableList<News> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        /*Получение новостей*/
        setTestData()

        /*Инициализация адаптера*/
        if (view is RecyclerView) {
            with(view) {
                addItemDecoration(SpacesItemDecoration(10, 10))
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = MyNewsRecyclerViewAdapter(news, this@NewsFragment)
            }
        }
        return view
    }


    private fun setTestData() {
        var index = 0
        news.add(
            index, News(
                index++,
                "Vivo обновила список смартфонов, которые получат Android 11",
                "Компания vivo расширила опубликованный ранее список фирменных смартфонов, которые получат обновление прошивки до Android 11. В обновлённую дорожную карту вошли ещё семь гаджетов, российские владельцы которых получат актуальную версию мобильной ОС в 2021-м.",
                "25.02.2021",
                R.drawable.news1,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Samsung запатентовала необычный Android-слайдер с мощной акустикой",
                "Патентный портфель Samsung пополнила очередная разработка: смартфон в форм-факторе слайдера, который можно сдвигать в двух разных направлениях. Благодаря такой конструкции аппарат получил расширенную функциональность, совместив экран без вырезов с выдвижной фронталкой и продвинутым динамиком на фронтальной панели.",
                "24.02.2021",
                R.drawable.news2,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Google «прокачала» старые версии Android новыми функциями",
                "Google не только работает над новой версией Android, но и совершенствует более ранние ревизии ОС. Компания выпустила ряд обновлений с новыми функциями для владельцев Android 7.0 и выше — подробное описание нововведений уже появилось в официальном блоге софтмейкера.",
                "24.02.2021",
                R.drawable.news3,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Qualcomm улучшит тактильное восприятие Android-смартфонов",
                "С выпуском iPhone 6S компания Apple доказала, что вибрация в смартфоне может быть приятной. Следом и другие производители начали уделять внимание этому вопросу. Как стало известно, Qualcomm и Lofelt объединились с целью улучшить тактильную отдачу в Android-смартфонах.",
                "23.02.2021",
                R.drawable.news4,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Samsung расширила срок поддержки фирменных устройств Galaxy",
                "Через полгода после перехода на трёхлетний цикл обновления своих Android-флагманов Samsung объявила о дальнейшем расширении срока поддержки фирменных устройств. Помимо продления программной «живучести» гаджетов ещё на один год, компания расширила и список аппаратов, для которых будут гарантированной выпускаться апдейты прошивки.",
                "23.02.2021",
                R.drawable.news5,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Google использует ИИ, чтобы улучшить управление в Android 12",
                "С ростом популярности жестового способа управления в Android-устройствах многие пользователи часто случайно выходят из приложения или ошибочно нажимают «Назад». Согласно наблюдениям разработчиков, в Android 12 тестируется функция предотвращения таких случайных действий для упрощения управления интерфейсом.",
                "22.02.2021",
                R.drawable.news6,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Стали известны подробности кастомизации Android 12",
                "Одной из фишек Android 12 станем обновлённый интерфейс с расширенной поддержкой тем. Как выглядят возможности кастомизации новой ОС, показали инсайдеры, опубликовавшие серию скриншотов, сделанных в предварительной сборке прошивки для разработчиков.",
                "22.02.2021",
                R.drawable.news7,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "В Android 12 всё же нашли новый интерфейс",
                "Ранее на этой неделе Google выпустила Android 12 Developer Preview. Система включает множество изменений, но не все из тех, что ожидались. В частности, установив обновление, владельцы «пикселей» не обнаружили заметных изменений в пользовательском интерфейсе. Оказывается, что они попросту по какой-то причине скрыты. ",
                "20.02.2021",
                R.drawable.news8,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "В YouTube для Android появилась полезная функция",
                "Без каких-либо анонсов Google обновила клиент YouTube для Android, добавив крайне полезную функцию. Так, владельцы мобильных устройств получили возможность просматривать видео в куда большем разрешении, чем позволяют их дисплеи.",
                "20.02.2021",
                R.drawable.news9,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Google выпустила тестовую версию Android 12 для телевизоров",
                "На фоне выхода Android 12 Developer Preview практически незамеченным остался ещё один релиз от Google. Совсем тихо состоялся выпуск тестовой версии Android TV на базе Android 12. Самое удивительное, что не так давно была представлена Android TV на базе Android 11, которая до сих пор не доступна сторонним производителям.",
                "19.02.2021",
                R.drawable.news10,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "В Android 12 нашли функцию из iOS 14",
                "Google уже выпустила Android 12 Developer Preview, а вместе с этим в сети начали появляться сообщения об изменениях в новой версии мобильной ОС. Судя по всему, поисковый гигант вдохновлялся iOS 14, ведь многие нововведения полностью повторяют то, что показала Apple в прошлом году.",
                "19.02.2021",
                R.drawable.news11,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Вышла Android 12 Developer Preview. Что нового?",
                "Компания Google выпустила первую версию Android 12 для разработчиков. Ключевыми особенностями новой ОС стали улучшенная навигация с помощью жестов, расширенная поддержка мультимедийных форматов, обновлённый пользовательский интерфейс и другие полезные нововведения.",
                "19.02.2021",
                R.drawable.news12,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Дизайн и дату анонса двух новых планшетов Samsung слили в сеть",
                "По данным инсайдеров, Samsung готовится пополнить линейку фирменных планшетов сразу двумя моделями «облегчённой» серии Galaxy Tab Lite. Изображения и некоторые характеристики неанонсированных Android-гаджетов уже засветились в сети задолго до ожидаемой даты презентации.",
                "19.02.2021",
                R.drawable.news13,
                false
            )
        )
        news.add(
            index, News(
                index++,
                "Google запустила функцию локальной раздачи Android-приложений",
                "Специально для пользователей с медленным интернетом Google обновила технологию Nearby Sharing — теперь с её помощью можно скачать мобильные приложения, используя в качестве сервера находящиеся поблизости Android-гаджеты. Новая функция уже доступна официально, а в сети появилась инструкция по «расшариванию» установочных файлов.",
                "18.02.2021",
                R.drawable.news14,
                false
            )
        )
        news.add(
            index, News(
                index,
                "Карл Пей объяснил истинную причину покупки бренда «отца Android»",
                "На днях появилась информация, что компания Nothing, созданная сооснователем OnePlus Карлом Пеем, купила права на торговую марку Essential, под которой создатель Android Энди Рубин собирался изменить рынок смартфонов. Ни одна из сторон не комментировала сделку, но теперь владелец «Ничего» всё же дал официальный комментарий.",
                "17.02.2021",
                R.drawable.news15,
                false
            )
        )
    }

    override fun onShareClick(news: News) {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, news.text)
        startActivity(Intent.createChooser(shareIntent, getString(R.string.send_to)))
    }

}