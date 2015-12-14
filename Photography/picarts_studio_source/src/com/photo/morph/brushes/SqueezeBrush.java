// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;
import android.os.Handler;

// Referenced classes of package com.photo.morph.brushes:
//            AbstractBrush

public class SqueezeBrush extends AbstractBrush
{

    public Mode f;
    private Handler g;
    private Runnable h = new Runnable() {

        private SqueezeBrush a;

        public final void run()
        {
            synchronized (a.d)
            {
                SqueezeBrush.a(a, a.a.x, a.a.y, a.b / 2.0F, a.c * 0.04F, SqueezeBrush.a(a).ordinal());
            }
            SqueezeBrush.c(a).postDelayed(SqueezeBrush.b(a), 40L);
            return;
            exception;
            renderer;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                a = SqueezeBrush.this;
                super();
            }
    };

    public SqueezeBrush()
    {
        this(Mode.IN);
    }

    private SqueezeBrush(Mode mode)
    {
        super(null);
        f = null;
        g = new Handler();
        f = mode;
    }

    static Mode a(SqueezeBrush squeezebrush)
    {
        return squeezebrush.f;
    }

    static void a(SqueezeBrush squeezebrush, float f1, float f2, float f3, float f4, int i)
    {
        squeezebrush.paint(f1, f2, f3, f4, i);
    }

    static Runnable b(SqueezeBrush squeezebrush)
    {
        return squeezebrush.h;
    }

    static Handler c(SqueezeBrush squeezebrush)
    {
        return squeezebrush.g;
    }

    private native void paint(float f1, float f2, float f3, float f4, int i);

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
        public static final Mode IN;
        public static final Mode OUT;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/photo/morph/brushes/SqueezeBrush$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            IN = new Mode("IN", 0);
            OUT = new Mode("OUT", 1);
            $VALUES = (new Mode[] {
                IN, OUT
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }

}
