// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceListener;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.util.Utils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapperModel, ThumbSwitcher

public abstract class ImageWrapper extends LinearLayout
    implements RetailSearchResultView
{
    private static class ViewHolder
    {

        public ImageRequest displayedImage;
        public ImageView imageView;
        public ThumbSwitcher thumbSwitcher;

        private ViewHolder()
        {
        }

    }


    private ImageRequest activeImageRequest;
    private ImageRequest displayedImage;
    private ResourceListener imageListener;
    protected ImageView imageView;
    private ResourceProvider resourceProvider;
    protected ThumbSwitcher thumbSwitcher;

    public ImageWrapper(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(ImageWrapperModel imagewrappermodel, ViewType viewtype)
    {
        if (imageView == null || imagewrappermodel == null)
        {
            hideImage();
            return;
        }
        resourceProvider = imagewrappermodel.getResourceProvider();
        imageView.setContentDescription(imagewrappermodel.getContentDescription());
        if (!hasThumbSwitcher())
        {
            loadAndShowImage(imagewrappermodel.getImage());
        } else
        {
            thumbSwitcher.buildView(imagewrappermodel.getAsin(), this, imagewrappermodel.getImageList(), resourceProvider);
        }
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((ImageWrapperModel)obj, viewtype);
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    public boolean hasThumbSwitcher()
    {
        return thumbSwitcher != null;
    }

    public void hideImage()
    {
        imageView.setImageDrawable(null);
        displayedImage = null;
        updateTag();
    }

    protected void loadAndShowImage(final ImageRequest imageRequest)
    {
        if (displayedImage != null && displayedImage.equals(imageRequest))
        {
            return;
        }
        if (imageRequest == null || displayedImage != null)
        {
            hideImage();
        }
        imageListener = new AbstractResourceListener() {

            final ImageWrapper this$0;
            final ImageRequest val$imageRequest;

            public void result(Bitmap bitmap)
            {
                if (imageListener != this || !Utils.isEqual(imageRequest, activeImageRequest))
                {
                    return;
                }
                if (bitmap == null)
                {
                    hideImage();
                    return;
                } else
                {
                    showImage(activeImageRequest, bitmap);
                    return;
                }
            }

            public volatile void result(Object obj)
            {
                result((Bitmap)obj);
            }

            
            {
                this$0 = ImageWrapper.this;
                imageRequest = imagerequest;
                super();
            }
        };
        activeImageRequest = imageRequest;
        imageRequest = new ImageLoader(resourceProvider.getContext(), imageListener, System.currentTimeMillis(), imageRequest);
        resourceProvider.execute(imageRequest);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ViewHolder viewholder = (ViewHolder)getTag();
        if (viewholder == null)
        {
            postInflate();
            updateTag();
            return;
        } else
        {
            displayedImage = viewholder.displayedImage;
            imageView = viewholder.imageView;
            thumbSwitcher = viewholder.thumbSwitcher;
            return;
        }
    }

    protected abstract void postInflate();

    public void showImage(ImageRequest imagerequest, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            hideImage();
            return;
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap.getConfig() == null)
        {
            bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
        }
        imageView.setImageBitmap(bitmap1);
        displayedImage = imagerequest;
        updateTag();
    }

    void updateTag()
    {
        ViewHolder viewholder = new ViewHolder();
        viewholder.displayedImage = displayedImage;
        viewholder.imageView = imageView;
        viewholder.thumbSwitcher = thumbSwitcher;
        setTag(viewholder);
    }


}
