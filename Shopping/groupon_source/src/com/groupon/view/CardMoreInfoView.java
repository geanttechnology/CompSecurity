// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class CardMoreInfoView extends LinearLayout
{

    private TextView subtitle;
    private TextView title;

    public CardMoreInfoView(Context context)
    {
        super(context);
        init();
    }

    public CardMoreInfoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public CardMoreInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        inflate(getContext(), getLayoutResourceId(), this);
        setOrientation(1);
        title = (TextView)findViewById(0x7f10057b);
        subtitle = (TextView)findViewById(0x7f10057c);
    }

    protected abstract int getLayoutResourceId();

    public void setSubtitle(String s)
    {
        subtitle.setText(s);
    }

    public void setTitle(int i)
    {
        title.setText(i);
    }

    public void setTitle(String s)
    {
        title.setText(s);
    }
}
