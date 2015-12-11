// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.groupon.util.ImageUrl;
import com.groupon.util.PlaceholderImageCache;
import com.groupon.util.imageservice.ImageCdnUrlBuilder;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class PlaceholderUrlImageView extends UrlImageView
{
    private class DownloadImageWithUnknownDimensions
        implements Runnable
    {

        private final String imageUrl;
        final PlaceholderUrlImageView this$0;

        public void run()
        {
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            downloadBestFitImage(imageUrl);
        }

        public DownloadImageWithUnknownDimensions(String s)
        {
            this$0 = PlaceholderUrlImageView.this;
            super();
            imageUrl = s;
        }
    }


    private int height;
    private com.groupon.util.imageservice.ImageCdnUrlBuilder.Format imageFormat;
    private PlaceholderImageCache placeholderImageCache;
    private int placeholderResId;
    private String placeholderTag;
    private int width;

    public PlaceholderUrlImageView(Context context)
    {
        this(context, null, 0);
    }

    public PlaceholderUrlImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PlaceholderUrlImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.PlaceholderUrlImageView);
        placeholderResId = attributeset.getResourceId(0, 0);
        i = attributeset.getResourceId(1, 0x7f080486);
        imageFormat = com.groupon.util.imageservice.ImageCdnUrlBuilder.Format.valueOf(context.getResources().getString(i));
        attributeset.recycle();
        placeholderImageCache = (PlaceholderImageCache)RoboGuice.getInjector(context).getInstance(com/groupon/util/PlaceholderImageCache);
        placeholderTag = String.valueOf(placeholderResId);
        setImageDrawable(getPlaceholder());
    }

    private void downloadBestFitImage(String s)
    {
        setImageUrl(new ImageUrl(s, true), null, getPlaceholder(), UrlImageView.ScaleImageType.CENTER_CROP, false, width, height);
    }

    protected String generateCdnImageUrl(String s, int i, int j, int k)
    {
        return (new ImageCdnUrlBuilder(s)).size(i, j).quality(k).pattern("^https?:\\/\\/img\\.grouponcdn\\.com\\/.*((\\/v1\\/)|(\\.(jpg|gif|png)))$").format(imageFormat).build();
    }

    public Drawable getPlaceholder()
    {
        return placeholderImageCache.get(placeholderTag, placeholderResId);
    }

    public void requestImage(String s)
    {
        if (width != 0 && height != 0)
        {
            downloadBestFitImage(s);
            return;
        } else
        {
            post(new DownloadImageWithUnknownDimensions(s));
            return;
        }
    }


/*
    static int access$002(PlaceholderUrlImageView placeholderurlimageview, int i)
    {
        placeholderurlimageview.width = i;
        return i;
    }

*/


/*
    static int access$102(PlaceholderUrlImageView placeholderurlimageview, int i)
    {
        placeholderurlimageview.height = i;
        return i;
    }

*/

}
