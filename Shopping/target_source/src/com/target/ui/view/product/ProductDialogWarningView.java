// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class ProductDialogWarningView extends LinearLayout
{
    static class Views extends a
    {

        TextView subTitle;
        TextView title;
        ImageView warningIcon;

        public Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public ProductDialogWarningView(Context context)
    {
        super(context);
        a(context);
    }

    public ProductDialogWarningView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public ProductDialogWarningView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0301b3, this);
        mViews = new Views(this);
    }

    public void a(String s, String s1, boolean flag)
    {
        if (o.g(s))
        {
            mViews.title.setText(s);
            al.b(mViews.title);
        } else
        {
            al.c(mViews.title);
        }
        if (o.g(s1))
        {
            mViews.subTitle.setText(s1);
            al.b(mViews.subTitle);
        } else
        {
            al.c(mViews.subTitle);
        }
        if (flag)
        {
            al.b(mViews.warningIcon);
            return;
        } else
        {
            al.c(mViews.warningIcon);
            return;
        }
    }
}
