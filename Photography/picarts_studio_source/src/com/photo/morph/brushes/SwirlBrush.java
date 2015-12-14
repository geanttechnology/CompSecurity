// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;
import android.os.Handler;

// Referenced classes of package com.photo.morph.brushes:
//            AbstractBrush

public class SwirlBrush extends AbstractBrush
{

    public Mode f;
    private Handler g;
    private Runnable h = new Runnable() {

        private SwirlBrush a;

        public final void run()
        {
            synchronized (a.d)
            {
                SwirlBrush.a(a, a.a.x, a.a.y, a.b / 2.0F, a.c * 0.04F, 0.0F, SwirlBrush.a(a).ordinal());
            }
            SwirlBrush.c(a).postDelayed(SwirlBrush.b(a), 40L);
            return;
            exception;
            renderer;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                a = SwirlBrush.this;
                super();
            }
    };

    public SwirlBrush()
    {
        this(Mode.LEFT);
    }

    private SwirlBrush(Mode mode)
    {
        super(null);
        f = null;
        g = new Handler();
        f = mode;
    }

    static Mode a(SwirlBrush swirlbrush)
    {
        return swirlbrush.f;
    }

    static void a(SwirlBrush swirlbrush, float f1, float f2, float f3, float f4, float f5, int i)
    {
        swirlbrush.paint(f1, f2, f3, f4, f5, i);
    }

    static Runnable b(SwirlBrush swirlbrush)
    {
        return swirlbrush.h;
    }

    static Handler c(SwirlBrush swirlbrush)
    {
        return swirlbrush.g;
    }

    private native void paint(float f1, float f2, float f3, float f4, float f5, int i);

    public final void a(PointF pointf)
    {
        super.a(pointf);
        g.postDelayed(h, 40L);
    }

    public final void c(PointF pointf)
    {
        super.c(pointf);
        g.removeCallbacks(h);
    }

    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode LEFT;
        public static final Mode RIGHT;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/photo/morph/brushes/SwirlBrush$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            RIGHT = new Mode("RIGHT", 0);
            LEFT = new Mode("LEFT", 1);
            $VALUES = (new Mode[] {
                RIGHT, LEFT
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }

}
