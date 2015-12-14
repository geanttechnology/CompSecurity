// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.socialin.android.util.l;

public class CameraCapturedPreview extends View
{

    private Bitmap a;
    private Rect b;
    private RectF c;

    public CameraCapturedPreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new Rect();
        c = new RectF();
    }

    protected void onDraw(Canvas canvas)
    {
        if (a != null)
        {
            canvas.drawBitmap(a, null, c, null);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int i1)
    {
        super.onSizeChanged(i, j, k, i1);
        b.set(0, 0, i, j);
    }

    public void setCapturedImage(Bitmap bitmap)
    {
        if (a != null)
        {
            a.recycle();
        }
        a = bitmap;
        if (bitmap != null)
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            int i1 = b.width();
            int k = b.height();
            i1 = (i1 - i) / 2;
            k = (k - j) / 2;
            c.set(i1, k, i + i1, j + k);
            l.a(c);
        }
        invalidate();
    }
}
