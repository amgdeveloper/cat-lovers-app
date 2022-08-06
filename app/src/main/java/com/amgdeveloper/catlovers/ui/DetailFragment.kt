package com.amgdeveloper.catlovers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.amgdeveloper.catlovers.R
import com.amgdeveloper.catlovers.databinding.FragmentDetailBinding


/**
 * Created by amgdeveloper
 *
 * Fragment to show the details of an ImageData
 */
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val args: DetailFragmentArgs by navArgs()
        val imageData = args.imagePhotoExtra

        setToolbarTitle(args)

        args.imagePhotoExtra.let {
            binding.imageview.loadImage(it.url)
            binding.idDesc.text = it.id.toString()
            binding.albumIdDesc.text = it.albumId.toString()
        }
        binding.imageview.loadImage(imageData.url)

        return binding.root
    }

    private fun setToolbarTitle(args: DetailFragmentArgs) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.image, args.imagePhotoExtra.id)
    }
}