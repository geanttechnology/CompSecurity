// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class DealsCategoryHeaderView extends LinearLayout
{
    static class Views extends a
    {

        View bottomDivider;
        TextView primaryText;
        TextView secondaryText;
        View topDivider;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public DealsCategoryHeaderView(Context context)
    {
        super(context);
        a();
    }

    public DealsCategoryHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public DealsCategoryHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030151, this);
        mViews = new Views(this);
    }

    public void a(boolean flag)
    {
        al.a(mViews.topDivider, flag);
    }

    public void setPrimaryText(String s)
    {
        mViews.primaryText.setText(s);
    }

    public void setSecondaryText(String s)
    {
        mViews.secondaryText.setText(s);
    }
}
