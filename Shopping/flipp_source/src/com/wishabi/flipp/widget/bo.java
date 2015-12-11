// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class bo extends View
{

    float a;
    float b;
    public final HashMap c = new HashMap();
    private float d;

    public bo(Context context)
    {
        super(context);
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = canvas.save();
        canvas.scale(d, d);
        canvas.translate(-a, -b);
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); ((Drawable)((java.util.Map.Entry)iterator.next()).getValue()).draw(canvas)) { }
        canvas.restoreToCount(i);
    }

    public final void setZoomScale(float f)
    {
        d = f;
        invalidate();
    }
}
