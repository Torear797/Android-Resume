package ru.torear.resume.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ru.torear.resume.App
import ru.torear.resume.R

class ProfileFragment : Fragment() {
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        navController = findNavController()

        val avatarText: TextView = view.findViewById(R.id.avatar_textView)
        val fio: TextView = view.findViewById(R.id.tv_fio)
        val regions: TextView = view.findViewById(R.id.tv_regions)
        val roleName: TextView = view.findViewById(R.id.roleName)
        val phone: TextView = view.findViewById(R.id.phone)
        val email: TextView = view.findViewById(R.id.email)
        val createDate: TextView = view.findViewById(R.id.create_date)
        val logoutBtn: LinearLayout = view.findViewById(R.id.logout)

        avatarText.text = App.user.getInitials()
        fio.text =
            String.format(resources.getString(R.string.fio), App.user.first_name, App.user.surname)
        regions.text = App.user.getRegionString()
        roleName.text = App.user.getRoleString()
        phone.text = App.user.phone
        email.text = App.user.email
        createDate.text = App.user.create_date

        logoutBtn.setOnClickListener {
            App.logout(requireActivity())
        }

        return view
    }
}