// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class WidgetHeaderCard extends LinearLayout
{

    public WidgetHeaderCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void init()
    {
        setOrientation(0);
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (layoutparams == null)
        {
            layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
        } else
        {
            layoutparams.width = -1;
            layoutparams.height = -2;
        }
        setLayoutParams(layoutparams);
    }
}
