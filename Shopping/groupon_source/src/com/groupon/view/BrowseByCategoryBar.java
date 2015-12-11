// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BrowseByCategoryBar extends FrameLayout
{
    private class OnBrowseByCategoryBarClickListener
        implements android.view.View.OnClickListener
    {

        final BrowseByCategoryBar this$0;

        public void onClick(View view)
        {
            performClick();
        }

        private OnBrowseByCategoryBarClickListener()
        {
            this$0 = BrowseByCategoryBar.this;
            super();
        }

    }


    protected TextView textView;
    protected LinearLayout titleBar;

    public BrowseByCategoryBar(Context context)
    {
        this(context, null, 0);
    }

    public BrowseByCategoryBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BrowseByCategoryBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflateBar();
    }

    private void inflateBar()
    {
        inflate(getContext(), 0x7f030045, this);
        textView = (TextView)findViewById(0x7f100118);
        titleBar = (LinearLayout)findViewById(0x7f100117);
        titleBar.setOnClickListener(new OnBrowseByCategoryBarClickListener());
    }
}
