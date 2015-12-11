// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.mobile.viewitem.ItemViewPhotoGalleryActivity;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.android.widget:
//            ImageViewPager, RemoteImageView

public static class urlRewriterType extends PagerAdapter
{

    private ImageViewPager imageViewPager;
    private final com.ebay.nautilus.domain.content.dm.er urlRewriterType;
    private final List viewContentUris;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        obj = (View)obj;
        if (obj != null)
        {
            if (obj instanceof RemoteImageView)
            {
                ((RemoteImageView)obj).setOnRemoteImageLoadedListener(null);
            }
            ((View) (obj)).setOnClickListener(null);
            viewgroup.removeView(((View) (obj)));
        }
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
    }

    public int getCount()
    {
        return viewContentUris.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, final int imagePosition)
    {
        String s = (String)viewContentUris.get(imagePosition);
        final Context context = viewgroup.getContext();
        RemoteImageView remoteimageview = new RemoteImageView(context);
        if (imageViewPager != null)
        {
            remoteimageview.setOnRemoteImageLoadedListener(imageViewPager);
        }
        remoteimageview.setTag(Integer.valueOf(imagePosition));
        remoteimageview.setScaleType(android.widget.);
        remoteimageview.setUrlRewriter(urlRewriterType);
        remoteimageview.setAverageBackgroundColor(true);
        remoteimageview.setFadeInAnimation(100);
        remoteimageview.setRemoteImageUrl(s);
        remoteimageview.setOnClickListener(new android.view.View.OnClickListener() {

            final ImageViewPager.ImageViewPagerAdapter this$0;
            final Context val$context;
            final int val$imagePosition;

            public void onClick(View view)
            {
                if (context instanceof Activity)
                {
                    ItemViewPhotoGalleryActivity.StartActivity((Activity)context, Integer.valueOf(imagePosition), viewContentUris);
                }
            }

            
            {
                this$0 = ImageViewPager.ImageViewPagerAdapter.this;
                context = context1;
                imagePosition = i;
                super();
            }
        });
        viewgroup.addView(remoteimageview);
        return remoteimageview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void setImageViewPager(ImageViewPager imageviewpager)
    {
        imageViewPager = imageviewpager;
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }


    public terType(List list, com.ebay.nautilus.domain.content.dm.osition osition)
    {
        viewContentUris = Collections.unmodifiableList(list);
        urlRewriterType = osition;
    }
}
