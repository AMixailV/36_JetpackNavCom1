package ru.mixail_akulov.a36_jetpacknavcom1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.mixail_akulov.a36_jetpacknavcom1.databinding.FragmentBoxBinding
import kotlin.random.Random

/**
 * Второй фрагмент запускается из [RootFragment].
 * Аргументы: цвет (int), который должен быть указан ключом аргумента [ARG_COLOR].
 *
 * Может возвращать результат через Fragment Result API с кодом запроса = [REQUEST_CODE]
 * и пакетом, содержащим случайно сгенерированное число в [EXTRA_RANDOM_NUMBER] (int).
 */

class BoxFragment : Fragment(R.layout.fragment_box){

    private lateinit var binding: FragmentBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        // аргументы, как обычно, находятся в связке requireArgument()
        val color = requireArguments().getInt(ARG_COLOR)

        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            // просто вернитесь к предыдущему экрану, также можно использовать navigationUp()
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            // запустить следующий экран без каких-либо аргументов
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding.generateNumberButton.setOnClickListener {
            val number = Random.nextInt(100)
            // отправить результат
            parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(EXTRA_RANDOM_NUMBER to number))
            // вернуться к предыдущему экрану, также можно использовать navigationUp()
            findNavController().popBackStack()
        }
    }

    companion object {
        const val ARG_COLOR = "color"

        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}