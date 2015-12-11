// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MagicImageView extends ImageView
{

    public MagicImageView(Context context)
    {
        super(context);
    }

    public MagicImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public MagicImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        if (i > j)
        {
            i = j;
        }
        setMeasuredDimension(i, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
