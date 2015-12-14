// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;
import android.os.Handler;

// Referenced classes of package com.photo.morph.brushes:
//            AbstractBrush

public class RestoreBrush extends AbstractBrush
{

    private Handler f;
    private Runnable g = new Runnable() {

        private RestoreBrush a;

        public final void run()
        {
            synchronized (a.d)
            {
                RestoreBrush.a(a, a.a.x, a.a.y, a.b / 2.0F, a.c * 0.04F, RestoreBrush.a(a).ordinal());
            }
            RestoreBrush.c(a).postDelayed(RestoreBrush.b(a), 40L);
            return;
            exception;
            renderer;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                a = RestoreBrush.this;
                super();
            }
    };
    private Mode h;

    public RestoreBrush()
    {
        this(Mode.PHOTOSHOP);
    }

    private RestoreBrush(Mode mode)
    {
        super(null);
        h = null;
        f = new Handler();
        h = mode;
    }

    public RestoreBrush(Mode mode, byte byte0)
    {
        this(mode);
    }

    static Mode a(RestoreBrush restorebrush)
    {
        return restorebrush.h;
    }

    static void a(RestoreBrush restorebrush, float f1, float f2, float f3, float f4, int i)
    {
        restorebrush.paint(f1, f2, f3, f4, i);
    }

    static Runnable b(RestoreBrush restorebrush)
    {
        return restorebrush.g;
    }

    static Handler c(RestoreBrush restorebrush)
    {
        return restorebrush.f;
    }

    private native void paint(float f1, float f2, float f3, float f4, int i);

    public final void a(PointF pointf)
    {
        super.a(pointf);
        f.postDelayed(g, 40L);
    }

    public final void c(PointF pointf)
    {
        super.c(pointf);
        f.removeCallbacks(g);
    }

    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode AVERAGE;
        public static final Mode PHOTOSHOP;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/photo/morph/brushes/RestoreBrush$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            PHOTOSHOP = new Mode("PHOTOSHOP", 0);
            AVERAGE = new Mode("AVERAGE", 1);
            $VALUES = (new Mode[] {
                PHOTOSHOP, AVERAGE
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }

}
