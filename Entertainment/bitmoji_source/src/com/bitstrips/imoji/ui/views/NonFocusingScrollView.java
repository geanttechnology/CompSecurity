// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class NonFocusingScrollView extends ScrollView
{

    public NonFocusingScrollView(Context context)
    {
        super(context);
    }

    public NonFocusingScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public NonFocusingScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        return true;
    }
}
