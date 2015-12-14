// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aqe;
import azn;
import java.util.ArrayList;
import pn;
import qt;
import qu;
import qv;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            contiCapEditItem

public class PhotoViewerPagerAdapter extends PagerAdapter
{

    private ArrayList a;
    private Context b;
    private qv c;
    private int d;
    private int e;

    public PhotoViewerPagerAdapter()
    {
    }

    public static qv a(PhotoViewerPagerAdapter photoviewerpageradapter)
    {
        return photoviewerpageradapter.c;
    }

    public void a(Context context, ArrayList arraylist, qv qv)
    {
        b = context;
        c = qv;
        a = arraylist;
    }

    public void a(ArrayList arraylist)
    {
        a = arraylist;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        ViewGroup viewgroup1 = (ViewGroup)LayoutInflater.from(b).inflate(0x7f03012e, null);
        Object obj = (FrameLayout)viewgroup1.findViewById(0x7f0d045c);
        ImageView imageview = (ImageView)viewgroup1.findViewById(0x7f0d045d);
        FrameLayout framelayout = (FrameLayout)viewgroup1.findViewById(0x7f0d045e);
        Object obj1 = new android.widget.FrameLayout.LayoutParams(d, e);
        obj1.width = d;
        obj1.height = e;
        ((FrameLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj = (contiCapEditItem)a.get(i);
        if (obj == null)
        {
            return null;
        }
        obj = Uri.parse(((contiCapEditItem) (obj)).urlStr);
        obj1 = (new StringBuilder()).append("photoviewcache").append(i).toString();
        aqe aqe1 = new aqe(azn.d(), azn.d());
        pn.a().a(b, ((String) (obj1)), ((Uri) (obj)).getPath(), imageview, aqe1, new qt(this));
        imageview.setOnClickListener(new qu(this));
        if (((contiCapEditItem)a.get(i)).hasBeautyed)
        {
            framelayout.setVisibility(8);
        } else
        {
            framelayout.setVisibility(0);
        }
        viewgroup.addView(viewgroup1);
        return viewgroup1;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
