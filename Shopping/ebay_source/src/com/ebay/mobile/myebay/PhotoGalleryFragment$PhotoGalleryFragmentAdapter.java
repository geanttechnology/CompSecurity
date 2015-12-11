// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ebay.common.util.ImageCache;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.myebay:
//            PhotoGalleryFragment

private final class imageUrls extends PagerAdapter
{

    private final ArrayList imageUrls;
    final PhotoGalleryFragment this$0;
    private final ArrayList views = new ArrayList();

    private View getItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (String)imageUrls.get(i);
        View view = LayoutInflater.from(getActivity()).inflate(0x7f030199, null);
        ImageView imageview = (ImageView)view.findViewById(0x7f10005b);
        i = (int)(0.80000000000000004D * (double)getResources().getDisplayMetrics().heightPixels);
        imageview.setMinimumHeight(i);
        imageview.setMinimumWidth(i);
        if (viewgroup == null)
        {
            imageview.setImageResource(0x7f02027a);
            return view;
        } else
        {
            imageCache.setImage(imageview, viewgroup);
            return view;
        }
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
        if (i < views.size())
        {
            views.set(i, null);
        }
    }

    public int getCount()
    {
        return imageUrls.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        int k = getCount();
        int j = k;
        if (i + 1 > k)
        {
            j = i + 1;
        }
        if (views.size() < j)
        {
            views.ensureCapacity(j);
            for (; views.size() < j; views.add(null)) { }
        }
        View view1 = (View)views.get(i);
        View view = view1;
        if (view1 == null)
        {
            view = getItem(viewgroup, i);
            views.set(i, view);
            viewgroup.addView(view);
        }
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return obj == view;
    }

    public (ArrayList arraylist)
    {
        this$0 = PhotoGalleryFragment.this;
        super();
        imageUrls = arraylist;
    }
}
