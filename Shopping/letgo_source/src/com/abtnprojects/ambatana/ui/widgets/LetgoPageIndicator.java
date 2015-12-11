// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LetgoPageIndicator extends LinearLayout
    implements android.support.v4.view.ViewPager.e
{

    private int a;
    private int b;

    public LetgoPageIndicator(Context context)
    {
        this(context, null);
    }

    public LetgoPageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LetgoPageIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 0;
        b = -1;
    }

    public void a(int i)
    {
    }

    public void a(int i, float f, int j)
    {
    }

    public void b(int i)
    {
        int j = b;
        b = i;
        if (i > -1)
        {
            ImageView imageview = (ImageView)getChildAt(i);
            if (imageview != null)
            {
                imageview.setImageResource(0x7f020103);
            }
        }
        if (j > -1)
        {
            ImageView imageview1 = (ImageView)getChildAt(j);
            if (imageview1 != null)
            {
                imageview1.setImageResource(0x7f020104);
            }
        }
    }

    public void setIndicatorsSize(int i)
    {
        a = i;
        removeAllViews();
        for (int j = 0; j < i; j++)
        {
            ImageView imageview = new ImageView(getContext());
            int k = (getResources().getDisplayMetrics().densityDpi / 160) * 4;
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 1;
            layoutparams.setMargins(k, 0, k, 0);
            imageview.setLayoutParams(layoutparams);
            imageview.setImageResource(0x7f020104);
            addView(imageview);
        }

    }
}
