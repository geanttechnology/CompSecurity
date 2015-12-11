// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public final class hh extends View
{

    public boolean a;
    private Bitmap b;
    private Rect c;
    private Rect d;
    private Rect e;
    private Rect f;

    public hh(Context context)
    {
        super(context);
        a = false;
        b = null;
        c = null;
        d = null;
        e = null;
        f = new Rect();
    }

    final void a()
    {
        if (a)
        {
            e = c;
            return;
        } else
        {
            e = d;
            return;
        }
    }

    public final void onDraw(Canvas canvas)
    {
        while (e == null || b == null) 
        {
            return;
        }
        getDrawingRect(f);
        canvas.drawBitmap(b, e, f, null);
    }

    public final void setImageBitmap(Bitmap bitmap)
    {
        b = bitmap;
        int i = b.getWidth();
        int j = b.getHeight();
        d = new Rect(0, 0, i / 2, j);
        c = new Rect(i / 2, 0, i, j);
        a();
    }
}
