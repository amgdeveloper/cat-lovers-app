package com.amgdeveloper.imagedetailviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amgdeveloper.imagedetailviewer.R
import com.amgdeveloper.imagedetailviewer.databinding.FragmentImageListBinding
import com.amgdeveloper.imagedetailviewer.model.ImageData
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by amgdeveloper
 *
 * Fragment that shows the list of ImageData items
 */

@AndroidEntryPoint
class ImageListFragment : Fragment() {

    private lateinit var binding: FragmentImageListBinding
    private val viewModel by viewModels<ImageViewModel>()

    private val imageDataSet = mutableListOf<ImageData>()
    private lateinit var adapter: ImageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageListBinding.inflate(layoutInflater, container, false)
        lifecycleScope.launchWhenStarted {
            viewModel.images.collect{
                    newData ->
            imageDataSet.clear()
            imageDataSet.addAll(newData)
            adapter.notifyDataSetChanged()
            }
        }

        setToolbarTitle()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ImageListAdapter(imageDataSet)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    private fun setToolbarTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.list_of_images)
    }

   inner class ImageListAdapter(private val dataSet: List<ImageData>) :
        RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView
            val imageView: ImageView

            init {
                title = view.findViewById(R.id.listItemTitle)
                imageView = view.findViewById(R.id.ListItemIv)
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.image_list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.text = dataSet[position].title
            holder.imageView.loadImage(dataSet[position].thumbnailUrl)
            holder.itemView.setOnClickListener {
                val action =
                    ImageListFragmentDirections.actionImageListFragmentToDetailFragment(dataSet[position])
                findNavController().navigate(action)
            }
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }
    }
}