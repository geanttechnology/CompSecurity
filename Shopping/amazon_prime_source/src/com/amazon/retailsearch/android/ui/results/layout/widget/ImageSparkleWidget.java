// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.SearchImageLoader;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.layout.FilterRequestListener;
import com.amazon.retailsearch.android.ui.results.layout.model.ImageSparkleModel;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.AppIntent;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            AppIntentType

public class ImageSparkleWidget extends LinearLayout
    implements ModelView
{

    private ImageView image;
    private ResourceProvider resourceProvider;
    private SearchImageLoader searchImageLoader;
    UserInteractionListener userInteractionListener;

    public ImageSparkleWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_widget_image_sparkle, this);
        image = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_widget_image_sparkle_image);
    }

    private SearchImageLoader getSearchImageLoader()
    {
        if (searchImageLoader == null)
        {
            searchImageLoader = (new com.amazon.retailsearch.android.ui.GeneralSearchImageLoader.Builder(resourceProvider, Resources.getSystem().getDisplayMetrics().widthPixels)).build();
        }
        return searchImageLoader;
    }

    public void build(final ImageSparkleModel imageSparkleModel)
    {
        if (imageSparkleModel == null || !imageSparkleModel.shouldDisplay())
        {
            setVisibility(8);
            return;
        }
        resourceProvider = imageSparkleModel.getResourceProvider();
        ImageSparkle imagesparkle = imageSparkleModel.getImageSparkle();
        final AppIntent appIntent = imagesparkle.getAction();
        final String url = imagesparkle.getUrl();
        if (imagesparkle.getImage() != null && getSearchImageLoader() != null)
        {
            SearchImageLoaderListener searchimageloaderlistener = new SearchImageLoaderListener() {

                final ImageSparkleWidget this$0;

                public void onLoad(Bitmap bitmap)
                {
                    image.setImageBitmap(bitmap);
                }

            
            {
                this$0 = ImageSparkleWidget.this;
                super();
            }
            };
            getSearchImageLoader().load(imagesparkle.getImage().getUrl(), searchimageloaderlistener);
        }
        setOnClickListener(new android.view.View.OnClickListener() {

            final ImageSparkleWidget this$0;
            final AppIntent val$appIntent;
            final ImageSparkleModel val$imageSparkleModel;
            final String val$url;

            public void onClick(View view)
            {
                if (appIntent != null)
                {
                    if (AppIntentType.fromTypeString(appIntent.getType()) == AppIntentType.FILTER_BY_ID && !TextUtils.isEmpty(appIntent.getValue()))
                    {
                        imageSparkleModel.getFilterRequestListener().onFilterApplied(appIntent.getValue(), true);
                    }
                } else
                if (!TextUtils.isEmpty(url))
                {
                    userInteractionListener.loadUrl(url);
                    return;
                }
            }

            
            {
                this$0 = ImageSparkleWidget.this;
                appIntent = appintent;
                imageSparkleModel = imagesparklemodel;
                url = s;
                super();
            }
        });
        setVisibility(0);
    }

    public volatile void build(Object obj)
    {
        build((ImageSparkleModel)obj);
    }

}
