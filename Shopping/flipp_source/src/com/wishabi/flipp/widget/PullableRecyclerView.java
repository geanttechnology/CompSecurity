// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class PullableRecyclerView extends RecyclerView
{

    public PullableRecyclerView(Context context)
    {
        super(context);
    }

    public PullableRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullableRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public final boolean j()
    {
        return super.computeVerticalScrollOffset() == 0;
    }
}
