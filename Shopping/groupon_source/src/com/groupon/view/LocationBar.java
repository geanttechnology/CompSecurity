// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class LocationBar extends FrameLayout
{

    protected ImageView buttonView;
    protected TextView textView;
    protected LinearLayout titleBar;

    public LocationBar(Context context)
    {
        this(context, null, 0);
    }

    public LocationBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LocationBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        RoboGuice.getInjector(context).injectMembers(this);
        inflateBar();
    }

    public CharSequence getText()
    {
        return textView.getText();
    }

    protected void inflateBar()
    {
        inflate(getContext(), 0x7f030153, this);
        buttonView = (ImageView)findViewById(0x7f1003e5);
        textView = (TextView)findViewById(0x7f1003e6);
        titleBar = (LinearLayout)findViewById(0x7f100117);
        titleBar.setOnClickListener(new android.view.View.OnClickListener() {

            final LocationBar this$0;

            public void onClick(View view)
            {
                performClick();
            }

            
            {
                this$0 = LocationBar.this;
                super();
            }
        });
    }

    public void setEnabled(boolean flag)
    {
        if (titleBar != null)
        {
            titleBar.setEnabled(flag);
        }
        if (textView != null)
        {
            textView.setEnabled(flag);
        }
        super.setEnabled(flag);
    }

    public void setText(int i)
    {
        textView.setText(i, android.widget.TextView.BufferType.SPANNABLE);
    }

    public void setText(CharSequence charsequence)
    {
        textView.setText(charsequence, android.widget.TextView.BufferType.SPANNABLE);
    }
}
