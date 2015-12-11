// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;

public class SellButtonLayout extends LinearLayout
{
    public static interface a
    {

        public abstract void l();
    }


    private a a;

    public SellButtonLayout(Context context)
    {
        super(context);
        a();
    }

    public SellButtonLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public SellButtonLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        ButterKnife.bind(this, inflate(getContext(), 0x7f040071, this));
    }

    void onSellClicked()
    {
        if (a != null)
        {
            a.l();
        }
    }

    public void setTapHandler(a a1)
    {
        a = a1;
    }
}
