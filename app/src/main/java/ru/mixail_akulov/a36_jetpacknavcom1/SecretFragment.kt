package ru.mixail_akulov.a36_jetpacknavcom1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.mixail_akulov.a36_jetpacknavcom1.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {

    private lateinit var binding: FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)
        binding.closeBoxButton.setOnClickListener {
            // вернуться к указанному месту назначения
            findNavController().popBackStack(R.id.rootFragment, false)
        }
        binding.goBackButton.setOnClickListener {
            // вернуться к предыдущему экрану
            findNavController().popBackStack()
        }
    }

}