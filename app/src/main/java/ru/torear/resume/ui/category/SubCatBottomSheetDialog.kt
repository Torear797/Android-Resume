package ru.torear.resume.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.torear.resume.R
import ru.torear.resume.SpacesItemDecoration
import ru.torear.resume.models.StoreItems
import ru.torear.resume.ui.store.StoreAdapter
import java.util.*

class SubCatBottomSheetDialog : BottomSheetDialogFragment() {
    private val items: MutableList<StoreItems> = ArrayList()
    private var selectVendor = ""
    private var recyclerView: RecyclerView? = null

    companion object {
        fun newInstance(
            vendor: String
        ): SubCatBottomSheetDialog {
            val fragment = SubCatBottomSheetDialog()
            val args = Bundle()
            args.putSerializable("vendor", vendor)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        selectVendor = arguments?.getString("vendor") as String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sub_cat, container, false)
        recyclerView = view.findViewById(R.id.list)
        return view
    }

    override fun onStart() {
        super.onStart()
        /*Получение моделей телефонов*/
        if (selectVendor != "")
            setTestData()

        if (items.isNotEmpty())
            initRecyclerView(recyclerView!!)
    }

    private fun setTestData() {
        var index = 0
        when (selectVendor) {
            resources.getString(R.string.samsung) -> {
                items.add(
                    index,
                    StoreItems
                        (
                        index++,
                        "S21",
                        "Samsung",
                        8000,
                        R.drawable.phone1
                    )
                )

                items.add(
                    index,
                    StoreItems
                        (
                        index,
                        "Note20",
                        "Samsung",
                        7000,
                        R.drawable.phone2
                    )
                )
            }
            resources.getString(R.string.huawei) -> {
                items.add(
                    index,
                    StoreItems
                        (
                        index++,
                        "P40 Pro+",
                        "HUAWEI",
                        6800,
                        R.drawable.phone3
                    )
                )

                items.add(
                    index,
                    StoreItems
                        (
                        index,
                        "Y8p",
                        "HUAWEI",
                        5500,
                        R.drawable.phone4
                    )
                )
            }
            resources.getString(R.string.honor) -> {
                items.add(
                    index,
                    StoreItems
                        (
                        index++,
                        "10I",
                        "Honor",
                        2540,
                        R.drawable.phone5
                    )
                )

                items.add(
                    index,
                    StoreItems
                        (
                        index,
                        "30",
                        "Honor",
                        6900,
                        R.drawable.phone6
                    )
                )
            }
            resources.getString(R.string.vivo) -> {
                items.add(
                    index,
                    StoreItems
                        (
                        index++,
                        "X50 Pro",
                        "Vivo",
                        8200,
                        R.drawable.phone7
                    )
                )

                items.add(
                    index,
                    StoreItems
                        (
                        index,
                        "X50",
                        "Vivo",
                        5200,
                        R.drawable.phone8
                    )
                )
            }
            resources.getString(R.string.xiaomi) -> {
                items.add(
                    index,
                    StoreItems
                        (
                        index++,
                        "Mi 10T",
                        "Xiaomi",
                        5400,
                        R.drawable.phone9
                    )
                )
                items.add(
                    index,
                    StoreItems
                        (
                        index,
                        "Note 8 Pro",
                        "Xiaomi",
                        2350,
                        R.drawable.phone10
                    )
                )
            }
        }
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(SpacesItemDecoration(10, 10))
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = StoreAdapter(items, null)
    }

}