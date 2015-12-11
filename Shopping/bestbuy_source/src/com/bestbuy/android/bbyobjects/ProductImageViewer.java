// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import ko;
import kp;

public class ProductImageViewer extends LinearLayout
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private ko a;
    private kp b;

    public ProductImageViewer(Context context)
    {
        super(context);
    }

    public ProductImageViewer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ProductImageViewer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        a.a(i);
    }

    public void setPromoPagerListener(kp kp)
    {
        b = kp;
    }
}
