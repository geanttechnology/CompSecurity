// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.SearchImageLoader;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.model.SparkleModel;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Sparkle;

public class SparkleWidget extends LinearLayout
    implements ModelView
{

    private LinearLayout contentLayout;
    private ImageView image;
    private RelativeLayout imageWrapper;
    private ImageView indicator;
    UserPreferenceManager preferencesManager;
    private ResourceProvider resourceProvider;
    private ResultLayoutType resultLayoutType;
    private SearchImageLoader searchImageLoader;
    private TextView text;
    UserInteractionListener userInteractionListener;

    public SparkleWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_widget_sparkle, this);
        imageWrapper = (RelativeLayout)findViewById(com.amazon.retailsearch.R.id.rs_widget_sparkle_image_wrapper);
        image = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_widget_sparkle_image);
        text = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_widget_sparkle_text);
        indicator = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_widget_sparkle_indicator);
        contentLayout = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_widget_sparkle_content);
        resultLayoutType = preferencesManager.getResultLayoutType();
    }

    public void build(final SparkleModel url)
    {
        if (url == null || url.getSparkle() == null)
        {
            setVisibility(8);
            return;
        }
        resourceProvider = url.getResourceProvider();
        text.setVisibility(8);
        image.setVisibility(8);
        boolean flag = url.hasMargin();
        url = url.getSparkle();
        if (!Utils.isEmpty(url.getTitle()))
        {
            StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, getContext());
            styledspannablestring.append(url.getTitle(), com.amazon.retailsearch.R.style.Rs_Widget_Sparkle_Text);
            text.setText(styledspannablestring);
            text.setVisibility(0);
        }
        if (url.getImage() != null && !TextUtils.isEmpty(url.getImage().getUrl()) && getSearchImageLoader() != null)
        {
            getSearchImageLoader().load(url.getImage().getUrl(), new SearchImageLoaderListener() {

                final SparkleWidget this$0;

                public void onLoad(Bitmap bitmap)
                {
                    image.setImageBitmap(bitmap);
                    image.setVisibility(0);
                }

            
            {
                this$0 = SparkleWidget.this;
                super();
            }
            });
        }
        Object obj;
        int i;
        if (text.getVisibility() == 8)
        {
            indicator.setVisibility(8);
        } else
        {
            indicator.setVisibility(0);
        }
        i = 0;
        obj = (android.widget.LinearLayout.LayoutParams)contentLayout.getLayoutParams();
        if (flag)
        {
            i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_widget_sparkle_layout_margin);
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(i, i, i, i);
            contentLayout.setBackgroundResource(com.amazon.retailsearch.R.drawable.rs_widget_sparkle_background);
        } else
        {
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, 0, 0, 0);
            contentLayout.setBackgroundResource(0);
            contentLayout.setBackgroundColor(getResources().getColor(com.amazon.retailsearch.R.color.rs_white));
        }
        obj = imageWrapper.getLayoutParams();
        if (flag)
        {
            i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_widget_sparkle_image_width) - i;
        } else
        {
            i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_widget_sparkle_image_width);
        }
        obj.width = i;
        url = url.getUrl();
        contentLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final SparkleWidget this$0;
            final String val$url;

            public void onClick(View view)
            {
                userInteractionListener.loadUrl(url);
            }

            
            {
                this$0 = SparkleWidget.this;
                url = s;
                super();
            }
        });
        setVisibility(0);
    }

    public volatile void build(Object obj)
    {
        build((SparkleModel)obj);
    }

    public SearchImageLoader getSearchImageLoader()
    {
        if (searchImageLoader == null)
        {
            searchImageLoader = (new com.amazon.retailsearch.android.ui.GeneralSearchImageLoader.Builder(resourceProvider, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_widget_sparkle_image_height))).build();
        }
        return searchImageLoader;
    }

}
