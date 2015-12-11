// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import com.makeramen.RoundedImageView;

public class SquareRoundCornerImojiView extends RoundedImageView
{

    public SquareRoundCornerImojiView(Context context)
    {
        super(context);
    }

    public SquareRoundCornerImojiView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SquareRoundCornerImojiView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = getMeasuredWidth();
        setMeasuredDimension(i, i);
    }
}
