// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class NotifyScrollView extends ScrollView
{
    public static interface a
    {

        public abstract void a(ScrollView scrollview, int i, int j, int k, int l);
    }


    private a a;

    public NotifyScrollView(Context context)
    {
        this(context, null);
    }

    public NotifyScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public NotifyScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public a getListener()
    {
        return a;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (a != null)
        {
            a.a(this, i, j, k, l);
        }
    }

    public void setListener(a a1)
    {
        a = a1;
    }
}
