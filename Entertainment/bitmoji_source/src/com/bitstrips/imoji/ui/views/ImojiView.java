// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bitstrips.imoji.models.Imoji;

public class ImojiView extends ImageView
{

    private static final String TAG = "ImageView";
    protected Imoji imoji;

    public ImojiView(Context context)
    {
        super(context);
    }

    public ImojiView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public Imoji getImoji()
    {
        return imoji;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    public void setImoji(Imoji imoji1)
    {
        imoji = imoji1;
    }
}
