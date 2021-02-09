package com.example.newsnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsnotes.databinding.FragmentNewsDetailsBinding

class NewsDetailsFragment : Fragment() {

    private lateinit var fragmentNewsDetailsBinding: FragmentNewsDetailsBinding

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

        fragmentNewsDetailsBinding.wvDetails.apply {
            webViewClient = WebViewClient()

            if (article.url != "") {
                loadUrl(article.url)
            }
        }
    }

}