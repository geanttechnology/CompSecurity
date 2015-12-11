// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bx

class a extends BitmapDrawable
{

    Bitmap a;
    final bx b;

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
    }

    public int getIntrinsicHeight()
    {
        return a.getHeight();
    }

    public int getIntrinsicWidth()
    {
        return a.getWidth();
    }

    public (bx bx1, Bitmap bitmap)
    {
        b = bx1;
        super(bitmap);
        a = bitmap;
    }
}
