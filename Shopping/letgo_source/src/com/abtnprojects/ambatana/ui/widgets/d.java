// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.is;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.TypedValue;
import android.widget.ImageView;

public class d
    implements android.support.v4.view.ViewPager.e
{

    private final ImageView a;
    private final ImageView b;
    private final LinearLayoutCompat c;
    private final int d;
    private Context e;

    public d(ImageView imageview, ImageView imageview1, LinearLayoutCompat linearlayoutcompat, int i, Context context)
    {
        a = imageview;
        b = imageview1;
        c = linearlayoutcompat;
        d = i;
        e = context.getApplicationContext();
        a();
        d(0);
    }

    private void a()
    {
        int j = (int)TypedValue.applyDimension(1, 4F, e.getResources().getDisplayMetrics());
        int i = 0;
        while (i < d) 
        {
            ImageView imageview = new ImageView(e);
            android.support.v7.widget.LinearLayoutCompat.LayoutParams layoutparams;
            if (i == 0)
            {
                imageview.setImageResource(0x7f020072);
            } else
            {
                imageview.setImageResource(0x7f020073);
            }
            c.addView(imageview);
            layoutparams = new android.support.v7.widget.LinearLayoutCompat.LayoutParams(imageview.getLayoutParams());
            layoutparams.setMargins(j, 0, j, 0);
            imageview.setLayoutParams(layoutparams);
            i++;
        }
    }

    private void d(int i)
    {
        if (i > is.l(e))
        {
            is.b(e, i);
        }
    }

    private void e(int i)
    {
        int j = 0;
        while (j < d) 
        {
            ImageView imageview = (ImageView)c.getChildAt(j);
            if (imageview != null)
            {
                if (j < i || j > i)
                {
                    imageview.setImageResource(0x7f020073);
                } else
                {
                    imageview.setImageResource(0x7f020072);
                }
            }
            j++;
        }
    }

    public void a(int i)
    {
    }

    public void a(int i, float f, int j)
    {
    }

    public void b(int i)
    {
        c(i);
        e(i);
        d(i);
    }

    protected void c(int i)
    {
        if (i == 0)
        {
            a.setImageDrawable(e.getResources().getDrawable(0x7f0200e3));
            b.setImageDrawable(e.getResources().getDrawable(0x7f0200df));
            return;
        }
        if (i == d - 1)
        {
            a.setImageDrawable(e.getResources().getDrawable(0x7f0200e2));
            b.setImageDrawable(e.getResources().getDrawable(0x7f0200e0));
            return;
        } else
        {
            a.setImageDrawable(e.getResources().getDrawable(0x7f0200e2));
            b.setImageDrawable(e.getResources().getDrawable(0x7f0200df));
            return;
        }
    }
}
