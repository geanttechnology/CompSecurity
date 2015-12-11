// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.view.a;

public class RegistryStickyHeaderView extends LinearLayout
{
    static class Views extends a
    {

        TextView title;

        public Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public RegistryStickyHeaderView(Context context)
    {
        super(context);
        a(context);
    }

    public RegistryStickyHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public RegistryStickyHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0301e0, this);
        mViews = new Views(this);
    }

    public void setTitle(String s)
    {
        if (!o.g(s))
        {
            return;
        } else
        {
            mViews.title.setText(s);
            return;
        }
    }
}
