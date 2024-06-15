package ru.mixail_akulov.a36_jetpacknavcom1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import ru.mixail_akulov.a36_jetpacknavcom1.databinding.FragmentRootBinding

/**
 * Корневой экран. Может запускать [BoxFragment], передавая цвет фона в качестве аргумента.
 */

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)

        binding.openYellowBoxButton.setOnClickListener {
            openBox(Color.rgb(255, 255, 200))
        }
        binding.openGreenBoxButton.setOnClickListener {
            openBox(Color.rgb(200, 255, 200))
        }

        // listening for the results from BoxFragment
        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE, viewLifecycleOwner) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), getString(R.string.generated_number, number), Toast.LENGTH_SHORT).show()
        }
    }

    private fun openBox(color: Int) {

        // запустить BoxFragment с аргументами и дополнительными параметрами

        findNavController().navigate(
            R.id.action_rootFragment_to_boxFragment,        // навигационное действие, которое должно быть выполнено
            bundleOf(BoxFragment.ARG_COLOR to color), // аргументы в пользу назначения
            // необязательные дополнительные опции, пример простой анимации:
            navOptions {
                anim {
                    enter = R.anim.enter
                    exit = R.anim.exit
                    popEnter = R.anim.pop_enter
                    popExit = R.anim.pop_exit
                }
            }
        )
    }
}