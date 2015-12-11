// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SingleGenericItemView extends FrameLayout
{
    private static class a
    {

        private TextView textView;

        static TextView a(a a1)
        {
            return a1.textView;
        }

        public a(View view)
        {
            textView = (TextView)view.findViewById(0x7f1005b6);
        }
    }


    private a mViews;

    public SingleGenericItemView(Context context)
    {
        super(context);
        a();
    }

    public SingleGenericItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public SingleGenericItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        mViews = new a(inflate(getContext(), 0x7f0301f4, this));
    }

    public void setItemTitle(String s)
    {
        a.a(mViews).setText(s);
    }
}
