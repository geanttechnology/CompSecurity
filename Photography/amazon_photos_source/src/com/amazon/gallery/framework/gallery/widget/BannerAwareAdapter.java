// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBaseAdapter, ViewFactory

public abstract class BannerAwareAdapter extends GalleryBaseAdapter
{

    private Object bannerMetadata;
    private ViewFactory bannerViewFactory;
    protected final GalleryBaseAdapter delegateAdapter;

    public BannerAwareAdapter(GalleryBaseAdapter gallerybaseadapter)
    {
        delegateAdapter = gallerybaseadapter;
    }

    public int getCount()
    {
        return delegateAdapter.getCount() + 1;
    }

    public Object getItem(int i)
    {
        if (i == 0)
        {
            return null;
        } else
        {
            return delegateAdapter.getItem(i - 1);
        }
    }

    public long getItemId(int i)
    {
        if (i == 0)
        {
            return 0x8000000000000000L;
        } else
        {
            return delegateAdapter.getItemId(i - 1);
        }
    }

    public int getItemViewType(int i)
    {
        if (i == 0)
        {
            return GalleryBaseAdapter.ItemViewType.BANNER.ordinal();
        } else
        {
            return delegateAdapter.getItemViewType(i - 1);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == 0)
        {
            return bannerViewFactory.getView(i, bannerMetadata, view);
        } else
        {
            return delegateAdapter.getView(i - 1, view, viewgroup);
        }
    }

    public void notifyDataSetChanged()
    {
        delegateAdapter.notifyDataSetChanged();
    }

    public void setBannerMetadata(Object obj)
    {
        bannerMetadata = obj;
    }

    public void setBannerViewFactory(ViewFactory viewfactory)
    {
        bannerViewFactory = viewfactory;
    }
}
