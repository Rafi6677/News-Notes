package com.example.newsnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsnotes.databinding.FragmentNewsDetailsBinding
import com.example.newsnotes.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class NewsDetailsFragment : Fragment() {

    private lateinit var fragmentNewsDetailsBinding: FragmentNewsDetailsBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentNewsDetailsBinding = FragmentNewsDetailsBinding.bind(view)

        val args: NewsDetailsFragmentArgs by navArgs()
        val article = args.selectedArticle

        viewModel = (activity as MainActivity).viewModel

        fragmentNewsDetailsBinding.wvDetails.apply {
            webViewClient = WebViewClient()

            if (article.url != null) {
                loadUrl(article.url)
            }
        }
        fragmentNewsDetailsBinding.saveButton.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Saved successfully", Snackbar.LENGTH_LONG)
                .show()
        }
    }

}