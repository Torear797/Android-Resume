package ru.torear.resume.ui.contacts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.torear.resume.App
import ru.torear.resume.R

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_contacts, container, false)
        val emailText: TextView = view.findViewById(R.id.email)
        val emailBtn: LinearLayout = view.findViewById(R.id.emailLayout)

        emailText.text = App.user.email

        emailBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, App.user.email)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Отправка письма на почту"));
        }

        return view
    }

}