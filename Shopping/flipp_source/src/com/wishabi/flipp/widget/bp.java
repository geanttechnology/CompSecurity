// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ap;
import android.view.View;
import android.widget.EdgeEffect;

public final class bp extends View
{

    final EdgeEffect a;
    final EdgeEffect b;
    final EdgeEffect c;
    final EdgeEffect d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;

    public bp(Context context)
    {
        super(context);
        a = new EdgeEffect(context);
        b = new EdgeEffect(context);
        c = new EdgeEffect(context);
        d = new EdgeEffect(context);
        e = false;
        g = false;
        f = false;
        h = false;
    }

    public final void a()
    {
        a.onRelease();
        b.onRelease();
        c.onRelease();
        d.onRelease();
        e = false;
        g = false;
        f = false;
        h = false;
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!a.isFinished())
        {
            int i = canvas.save();
            canvas.translate(0.0F, getHeight());
            canvas.rotate(-90F, 0.0F, 0.0F);
            a.setSize(getHeight(), getWidth());
            if (a.draw(canvas))
            {
                ap.d(this);
            }
            canvas.restoreToCount(i);
        }
        if (!b.isFinished())
        {
            int j = canvas.save();
            canvas.translate(getWidth(), 0.0F);
            canvas.rotate(90F, 0.0F, 0.0F);
            b.setSize(getHeight(), getWidth());
            if (b.draw(canvas))
            {
                ap.d(this);
            }
            canvas.restoreToCount(j);
        }
        if (!c.isFinished())
        {
            int k = canvas.save();
            c.setSize(getWidth(), getHeight());
            if (c.draw(canvas))
            {
                ap.d(this);
            }
            canvas.restoreToCount(k);
        }
        if (!d.isFinished())
        {
            int l = canvas.save();
            canvas.translate(getWidth(), getHeight());
            canvas.rotate(180F, 0.0F, 0.0F);
            d.setSize(getWidth(), getHeight());
            if (d.draw(canvas))
            {
                ap.d(this);
            }
            canvas.restoreToCount(l);
        }
    }
}
