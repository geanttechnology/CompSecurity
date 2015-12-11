// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.ui.common.h;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class PdpTitleView extends LinearLayout
{
    static class Views extends a
    {

        TextView subTitle;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public PdpTitleView(Context context)
    {
        super(context);
        a();
    }

    public PdpTitleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpTitleView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030202, this);
        mViews = new Views(this);
    }

    public void setDisplayOptions(h h1)
    {
        mViews.title.setText(Html.fromHtml(h1.b()));
        al.b(mViews.title);
        if (!h1.a())
        {
            al.c(mViews.subTitle);
            return;
        } else
        {
            mViews.subTitle.setText((CharSequence)h1.c().c());
            mViews.subTitle.setTextColor(getResources().getColor(h1.d()));
            al.b(mViews.subTitle);
            return;
        }
    }
}
