// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.voice;

import agj;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import dax;

public class BitmapSoundLevelsView extends View
{

    public dax a;
    private final Paint b;
    private int c;
    private final Bitmap d;
    private int e;
    private Bitmap f;
    private Rect g;
    private final Matrix h;
    private agj i;

    public BitmapSoundLevelsView(Context context)
    {
        this(context, null);
    }

    public BitmapSoundLevelsView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BitmapSoundLevelsView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        b = new Paint();
        h = new Matrix();
        i = new agj(this);
        context = BitmapFactory.decodeResource(context.getResources(), 0x7f02024e);
        d = context;
        if (context == null)
        {
            j = 0;
        } else
        {
            j = context.getWidth();
        }
        e = j;
        g = new Rect();
        b.setFilterBitmap(true);
    }

    private void a()
    {
        if (isEnabled())
        {
            b();
            return;
        } else
        {
            c();
            return;
        }
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        agj agj1 = i;
        agj1.a = true;
        agj1.sendEmptyMessage(0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        agj agj1 = i;
        agj1.a = false;
        agj1.removeMessages(0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        a();
    }

    protected void onDetachedFromWindow()
    {
        c();
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas)
    {
        Bitmap bitmap;
        int j;
        int l;
label0:
        {
            if (isEnabled())
            {
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.a;
                }
                if (j > c)
                {
                    int k = c;
                    c = (j - c) / 4 + k;
                } else
                {
                    c = (int)((float)c * 0.95F);
                }
                if (d != null)
                {
                    j = ((getWidth() - e) * c) / 100 + e;
                    l = (getWidth() - j) / 2;
                    bitmap = d;
                    Bitmap bitmap1 = f;
                    if (l != 0 || bitmap1 == null)
                    {
                        break label0;
                    }
                    canvas.drawBitmap(bitmap1, h, null);
                }
            }
            return;
        }
        g.set(l, l, l + j, j + l);
        canvas.drawBitmap(bitmap, null, g, b);
    }

    protected void onSizeChanged(int j, int k, int l, int i1)
    {
        super.onSizeChanged(j, k, l, i1);
        while (j <= 0 || k <= 0 || d == null) 
        {
            return;
        }
        f = Bitmap.createScaledBitmap(d, j, k, true);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            a();
            return;
        } else
        {
            c();
            return;
        }
    }

    public void setEnabled(boolean flag)
    {
        if (flag == isEnabled())
        {
            return;
        } else
        {
            super.setEnabled(flag);
            a();
            return;
        }
    }
}
