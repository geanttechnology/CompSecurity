// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AspectImageButton extends ImageButton
{

    private float mAspectRatio;

    public AspectImageButton(Context context)
    {
        super(context);
    }

    public AspectImageButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = getContext().obtainStyledAttributes(attributeset, com.gotv.crackle.handset.R.styleable.AspectImageView);
        mAspectRatio = context.getFloat(0, 1.0F);
        context.recycle();
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getSize(j);
        j = Math.round((float)i * mAspectRatio);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
    }
}
