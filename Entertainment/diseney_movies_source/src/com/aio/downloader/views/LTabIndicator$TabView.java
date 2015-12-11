// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.views:
//            LFrameLayout, LTabIndicator

private class  extends LFrameLayout
{

    private TextView mTabText;
    final LTabIndicator this$0;

    private void init()
    {
        mTabText = new TextView(getContext());
        mTabText.setTextAppearance(getContext(), 0x1010041);
        mTabText.setTextSize((float)LTabIndicator.access$1(LTabIndicator.this) / getResources().getConfiguration().fontScale);
        mTabText.setSingleLine(true);
        mTabText.setGravity(17);
        android.widget.ms ms = new android.widget.ms(-1, -1);
        addView(mTabText, ms);
    }

    public TextView getTextView()
    {
        return mTabText;
    }

    public (Context context)
    {
        this(context, null);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        this$0 = LTabIndicator.this;
        super(context, attributeset);
        init();
        setDelayClick(false);
        setColor(LTabIndicator.access$0(LTabIndicator.this));
    }
}
