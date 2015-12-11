// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import java.util.List;
import kl;
import km;
import kn;

public class ProductImageGallery extends RelativeLayout
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private kl a;
    private LayoutInflater b;
    private ViewPager c;
    private km d;
    private Context e;

    public ProductImageGallery(Context context)
    {
        super(context);
        e = context;
    }

    public ProductImageGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = context;
    }

    public ProductImageGallery(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e = context;
    }

    public static LayoutInflater a(ProductImageGallery productimagegallery)
    {
        return productimagegallery.b;
    }

    public static km b(ProductImageGallery productimagegallery)
    {
        return productimagegallery.d;
    }

    public static ViewPager c(ProductImageGallery productimagegallery)
    {
        return productimagegallery.c;
    }

    public void a(Context context, List list, km km)
    {
        e = context;
        d = km;
        b = LayoutInflater.from(context);
        km = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        c = new ViewPager(context);
        kn kn1 = new kn(this, context, list);
        c.setAdapter(kn1);
        c.setCurrentItem(0);
        c.setOnPageChangeListener(this);
        addView(c, km);
        a = new kl(this, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(14);
        context.addRule(12);
        context.setMargins(0, 30, 0, 5);
        addView(a, context);
        if (list.size() > 1)
        {
            a.a(list.size());
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            ((BBYBaseFragmentActivity)e).reEnablePullDown();
        } else
        if (i == 1)
        {
            ((BBYBaseFragmentActivity)e).disablePullDown();
            return;
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        a.b(i);
    }
}
