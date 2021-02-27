package ru.torear.resume.ui.category

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
import ru.torear.resume.models.Category
import java.util.*

class CategoryFragment : Fragment(), CategoryAdapter.OnCategoryClickListener {

    private val categoryList: MutableList<Category> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        /*Получение списка категорий*/
        setTestData()

        /*Инициализация адаптера*/
        if (view is RecyclerView) {
            with(view) {
                addItemDecoration(SpacesItemDecoration(10, 10))
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = CategoryAdapter(categoryList, this@CategoryFragment)
            }
        }
        return view
    }

    private fun setTestData() {
        var index = 0
        categoryList.add(
            index,
            Category(
                index++,
                resources.getString(R.string.samsung),
                R.drawable.phone1,
            )
        )

        categoryList.add(
            index,
            Category(
                index++,
                resources.getString(R.string.huawei),
                R.drawable.phone3,
            )
        )

        categoryList.add(
            index,
            Category(
                index++,
                resources.getString(R.string.honor),
                R.drawable.phone5,
            )
        )

        categoryList.add(
            index,
            Category(
                index++,
                resources.getString(R.string.vivo),
                R.drawable.phone7,
            )
        )

        categoryList.add(
            index,
            Category(
                index,
                resources.getString(R.string.xiaomi),
                R.drawable.phone9,
            )
        )


    }

    override fun onCategoryClick(cat: Category) {
        val myBottomSheet: SubCatBottomSheetDialog =
            SubCatBottomSheetDialog.newInstance(
                cat.title
            )

        myBottomSheet.show(childFragmentManager, myBottomSheet.tag)
    }
}