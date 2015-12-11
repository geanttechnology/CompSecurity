// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class TopCardView extends CardView
{

    public TopCardView(Context context)
    {
        super(context);
    }

    public TopCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TopCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setShadowPadding(int i, int j, int k, int l)
    {
        super.setShadowPadding(0, 0, 0, l);
    }
}
