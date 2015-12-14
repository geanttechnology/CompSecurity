// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;

// Referenced classes of package com.photo.morph.brushes:
//            AbstractBrush

public class SelectBrush extends AbstractBrush
{

    public Mode f;
    public Bitmap g;
    private int h;

    public SelectBrush()
    {
        this(Mode.SELECT);
    }

    private SelectBrush(Mode mode)
    {
        super(null);
        f = null;
        f = mode;
        h = Color.argb(128, 255, 0, 0);
    }

    public SelectBrush(Mode mode, byte byte0)
    {
        this(mode);
    }

    private native void paint();

    public final void a(PointF pointf)
    {
        android.opengl.GLSurfaceView.Renderer renderer = d;
        renderer;
        JVM INSTR monitorenter ;
        if (g == null) goto _L2; else goto _L1
_L1:
        android.graphics.PorterDuff.Mode mode;
        Canvas canvas;
        Paint paint1;
        canvas = new Canvas(g);
        paint1 = new Paint(1);
        paint1.setStyle(android.graphics.Paint.Style.FILL);
        paint1.setStrokeWidth(1.0F);
        paint1.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint1.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint1.setColor(h);
        if (f.compareTo(Mode.SELECT) != 0)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        mode = android.graphics.PorterDuff.Mode.SRC;
_L3:
        paint1.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawCircle(pointf.x, pointf.y, b / 2.0F, paint1);
_L2:
        paint();
        super.a(pointf);
        return;
        mode = android.graphics.PorterDuff.Mode.CLEAR;
          goto _L3
        pointf;
        renderer;
        JVM INSTR monitorexit ;
        throw pointf;
    }

    public final void b(PointF pointf)
    {
        android.opengl.GLSurfaceView.Renderer renderer = d;
        renderer;
        JVM INSTR monitorenter ;
        PointF pointf1 = a;
        if (g == null) goto _L2; else goto _L1
_L1:
        android.graphics.PorterDuff.Mode mode;
        Canvas canvas;
        Paint paint1;
        canvas = new Canvas(g);
        paint1 = new Paint(1);
        paint1.setStyle(android.graphics.Paint.Style.STROKE);
        paint1.setStrokeWidth(b);
        paint1.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint1.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint1.setColor(h);
        if (f.compareTo(Mode.SELECT) != 0)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        mode = android.graphics.PorterDuff.Mode.SRC;
_L3:
        paint1.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawLine(pointf1.x, pointf1.y, pointf.x, pointf.y, paint1);
_L2:
        paint();
        super.b(pointf);
        return;
        mode = android.graphics.PorterDuff.Mode.CLEAR;
          goto _L3
        pointf;
        renderer;
        JVM INSTR monitorexit ;
        throw pointf;
    }

    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode SELECT;
        public static final Mode UNSELECT;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/photo/morph/brushes/SelectBrush$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            SELECT = new Mode("SELECT", 0);
            UNSELECT = new Mode("UNSELECT", 1);
            $VALUES = (new Mode[] {
                SELECT, UNSELECT
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }

}
