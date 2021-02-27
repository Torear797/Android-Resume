package ru.torear.resume.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.orhanobut.hawk.Hawk
import ru.torear.resume.R
import ru.torear.resume.SpacesItemDecoration
import ru.torear.resume.models.StoreItems
import ru.torear.resume.showToast
import java.util.*


class StoreFragment : Fragment(), StoreAdapter.OnItemClickListener {
    private var currentBalanceValue = 0
    private val items: MutableList<StoreItems> = ArrayList()
    private var seekBar: SeekBar? = null
    private var currentBalance: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store, container, false)

        currentBalance = view.findViewById(R.id.balance)
        seekBar = view.findViewById(R.id.changeBalance)
        val storeList: RecyclerView = view.findViewById(R.id.store_list)

        currentBalanceValue = Hawk.get("balance", 0)
        currentBalance!!.text =
            String.format(resources.getString(R.string.balance_text), currentBalanceValue)
        seekBar!!.progress = currentBalanceValue

        seekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                currentBalanceValue = seekBar?.progress ?: 0
                currentBalance!!.text =
                    String.format(resources.getString(R.string.balance_text), currentBalanceValue)
                Hawk.put("balance", currentBalanceValue)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        setTestData(samsung = true, huawei = true, honor = true, vivo = true, xiaomi = true)
        initRecyclerView(storeList)

        val chipGroup: ChipGroup = view.findViewById(R.id.brends)

        val chip1: Chip = view.findViewById(R.id.Samsung)
        val chip2: Chip = view.findViewById(R.id.Huawei)
        val chip3: Chip = view.findViewById(R.id.Honor)
        val chip4: Chip = view.findViewById(R.id.Vivo)
        val chip5: Chip = view.findViewById(R.id.Xiaomi)

        setChipClickListener(chip1, chipGroup, storeList)
        setChipClickListener(chip2, chipGroup, storeList)
        setChipClickListener(chip3, chipGroup, storeList)
        setChipClickListener(chip4, chipGroup, storeList)
        setChipClickListener(chip5, chipGroup, storeList)

        return view
    }

    private fun setChipClickListener(chipN: Chip, brends: ChipGroup, recyclerView: RecyclerView) {
        chipN.setOnClickListener {
            var index = 0

            var samsung = false
            var huawei = false
            var honor = false
            var vivo = false
            var xiaomi = false

            while (index < brends.childCount) {
                val chip = brends.getChildAt(index) as Chip
                if (chip.isChecked) {
                    when (chip.text.toString()) {
                        resources.getString(R.string.samsung) -> samsung = true
                        resources.getString(R.string.huawei) -> huawei = true
                        resources.getString(R.string.honor) -> honor = true
                        resources.getString(R.string.vivo) -> vivo = true
                        resources.getString(R.string.xiaomi) -> xiaomi = true
                    }
                }
                index++
            }

            if (!samsung && !huawei && !honor && !vivo && !xiaomi) {
                samsung = true
                huawei = true
                honor = true
                vivo = true
                xiaomi = true
            }

            setTestData(samsung, huawei, honor, vivo, xiaomi)
            (recyclerView.adapter as StoreAdapter).update(items)
        }
    }

    private fun setTestData(
        samsung: Boolean,
        huawei: Boolean,
        honor: Boolean,
        vivo: Boolean,
        xiaomi: Boolean
    ) {
        items.clear()

        var index = 0

        if (samsung) {
            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "S21",
                    resources.getString(R.string.samsung),
                    8000,
                    R.drawable.phone1
                )
            )

            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "Note20",
                    resources.getString(R.string.samsung),
                    7000,
                    R.drawable.phone2
                )
            )
        }

        if (huawei) {
            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "P40 Pro+",
                    resources.getString(R.string.huawei),
                    6800,
                    R.drawable.phone3
                )
            )

            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "Y8p",
                    resources.getString(R.string.huawei),
                    5500,
                    R.drawable.phone4
                )
            )
        }

        if (honor) {
            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "10I",
                    resources.getString(R.string.honor),
                    2540,
                    R.drawable.phone5
                )
            )

            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "30",
                    resources.getString(R.string.honor),
                    6900,
                    R.drawable.phone6
                )
            )
        }

        if (vivo) {
            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "X50 Pro",
                    resources.getString(R.string.vivo),
                    8200,
                    R.drawable.phone7
                )
            )

            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "X50",
                    resources.getString(R.string.vivo),
                    5200,
                    R.drawable.phone8
                )
            )
        }

        if (xiaomi) {
            items.add(
                index,
                StoreItems
                    (
                    index++,
                    "Mi 10T",
                    resources.getString(R.string.xiaomi),
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
                    resources.getString(R.string.xiaomi),
                    2350,
                    R.drawable.phone10
                )
            )
        }
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(SpacesItemDecoration(10, 10))
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = StoreAdapter(items, this)
    }

    override fun onBayClick(item: StoreItems) {
        if (item.price <= currentBalanceValue) {
            currentBalanceValue -= item.price
            currentBalance!!.text =
                String.format(resources.getString(R.string.balance_text), currentBalanceValue)
            seekBar!!.progress = currentBalanceValue
            Hawk.put("balance", currentBalanceValue)
        } else {
            showToast(getString(R.string.no_balls))
        }
    }
}