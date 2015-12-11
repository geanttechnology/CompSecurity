// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class LoadingIndicator extends RelativeLayout
{

    public LoadingIndicator(Context context)
    {
        super(context);
        init(context);
    }

    public LoadingIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public LoadingIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    public void init(Context context)
    {
        LayoutInflater.from(context).inflate(com.comcast.cim.cmasl.android.util.R.layout.loading_indicator, this, true);
    }
}
