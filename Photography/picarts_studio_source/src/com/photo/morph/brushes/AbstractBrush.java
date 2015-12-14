// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

// Referenced classes of package com.photo.morph.brushes:
//            a

public class AbstractBrush
    implements a
{

    protected PointF a;
    protected float b;
    protected float c;
    protected android.opengl.GLSurfaceView.Renderer d;
    public boolean e;
    private Bitmap f;
    private float g;

    public AbstractBrush()
    {
        this(null);
    }

    public AbstractBrush(android.opengl.GLSurfaceView.Renderer renderer)
    {
        g = 1.0F;
        a = new PointF(0.0F, 0.0F);
        b = 128F;
        c = 1.0F;
        d = null;
        e = false;
        f = null;
    }

    private void b(boolean flag)
    {
        float f1;
        boolean flag1;
        flag1 = true;
        f1 = 4F;
        if (!e || f == null)
        {
            return;
        }
        android.opengl.GLSurfaceView.Renderer renderer = d;
        renderer;
        JVM INSTR monitorenter ;
        Canvas canvas;
        canvas = new Canvas(f);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        if (!flag) goto _L2; else goto _L1
_L1:
        Paint paint = new Paint(2);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        if (g != 0.0F)
        {
            f1 = 4F / g;
        }
        paint.setStrokeWidth(f1);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setARGB(255, 128, 128, 128);
        canvas.drawCircle(a.x, a.y, b / 2.0F, paint);
          goto _L2
_L4:
        paintAreaChanged(flag);
        renderer;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        renderer;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        while (flag) 
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private native void paintAreaChanged(boolean flag);

    public final float a()
    {
        return b;
    }

    public final void a(float f1)
    {
        b = f1;
    }

    public final void a(Bitmap bitmap)
    {
        f = bitmap;
    }

    public void a(PointF pointf)
    {
        a.set(pointf);
        b(true);
    }

    public final void a(android.opengl.GLSurfaceView.Renderer renderer)
    {
        d = renderer;
    }

    public final void a(boolean flag)
    {
        e = flag;
    }

    public final float b()
    {
        return c;
    }

    public final void b(float f1)
    {
        c = Math.max(0.0F, Math.min(1.0F, f1));
    }

    public void b(PointF pointf)
    {
        a.set(pointf);
        b(true);
    }

    public final void c(float f1)
    {
        g = f1;
    }

    public void c(PointF pointf)
    {
        a.set(pointf);
        b(false);
    }
}
