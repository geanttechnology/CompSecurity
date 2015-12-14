// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TTieZhiSafeImageView extends ImageView
{

    public TTieZhiSafeImageView(Context context)
    {
        super(context);
    }

    public TTieZhiSafeImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TTieZhiSafeImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj = (BitmapDrawable)getDrawable();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((BitmapDrawable) (obj)).getBitmap();
        if (obj == null || ((Bitmap) (obj)).isRecycled()) goto _L2; else goto _L3
_L3:
        boolean flag = false;
_L5:
        if (!flag)
        {
            super.onDraw(canvas);
        }
        return;
_L2:
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
