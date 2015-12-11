// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class FullSizeButtonView extends ImageButton
{

    public static final int ATTR_STYLE = 0x7f0100da;

    public FullSizeButtonView(Context context)
    {
        this(context, null);
    }

    public FullSizeButtonView(Context context, AttributeSet attributeset)
    {
        this(context, null, 0x7f0100da);
    }

    public FullSizeButtonView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setMinimumWidth(0);
        setPadding(0, 0, 0, 0);
    }
}
