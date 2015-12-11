// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ProductNutritionInfoView extends LinearLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a();
    }


    private a mListener;

    public ProductNutritionInfoView(Context context)
    {
        super(context);
        a();
    }

    public ProductNutritionInfoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductNutritionInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f03018d, this);
        setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.a();
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
