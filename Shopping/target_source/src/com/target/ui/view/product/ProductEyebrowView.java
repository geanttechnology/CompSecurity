// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.common.b;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class ProductEyebrowView extends LinearLayout
{
    static class Views extends a
    {

        TextView eyeBrows;

        public Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public ProductEyebrowView(Context context)
    {
        super(context);
        a(context);
    }

    public ProductEyebrowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ProductEyebrowView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0301b4, this);
        mViews = new Views(this);
    }

    public void setEyebrowData(b b1)
    {
        if (b1 == null)
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        if (b1.d())
        {
            stringbuilder.append(b1.g().toLowerCase());
            stringbuilder.append(" ");
            stringbuilder.append(" ");
        }
        if (b1.c())
        {
            stringbuilder.append(b1.h().toLowerCase());
        }
        if (o.g(stringbuilder.toString()))
        {
            mViews.eyeBrows.setText(stringbuilder.toString().trim());
            al.b(mViews.eyeBrows);
            return;
        } else
        {
            al.c(mViews.eyeBrows);
            return;
        }
    }
}
