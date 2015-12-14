// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.photo.morph.brushes.SelectBrush;
import com.photo.morph.brushes.a;
import com.socialin.android.util.Utils;

// Referenced classes of package com.photo.morph:
//            b, MorphRenderer, a

public class MorphGLSurfaceView extends GLSurfaceView
    implements b
{

    public static boolean a;
    MorphRenderer b;
    a c;
    private int d;
    private int e;
    private PointF f;
    private float g;
    private float h;
    private float i;
    private float j;
    private Bitmap k;
    private Bitmap l;
    private boolean m;
    private PointF n;
    private PointF o;
    private com.photo.morph.a p;
    private float q;
    private boolean r;
    private float s;
    private float t;

    public MorphGLSurfaceView(Context context)
    {
        super(context);
        d = 0;
        e = 0;
        c = null;
        i = 0.1F;
        j = 6F;
        k = null;
        l = null;
        m = false;
        n = new PointF();
        o = new PointF();
        q = 5F;
        r = false;
        s = 1.0F;
        t = 1.0F;
        q = Utils.a(5F, context);
        d();
    }

    public MorphGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = 0;
        e = 0;
        c = null;
        i = 0.1F;
        j = 6F;
        k = null;
        l = null;
        m = false;
        n = new PointF();
        o = new PointF();
        q = 5F;
        r = false;
        s = 1.0F;
        t = 1.0F;
        q = Utils.a(5F, context);
        d();
    }

    static int a(MorphGLSurfaceView morphglsurfaceview, int i1)
    {
        morphglsurfaceview.d = i1;
        return i1;
    }

    static Bitmap a(MorphGLSurfaceView morphglsurfaceview, Bitmap bitmap)
    {
        morphglsurfaceview.l = bitmap;
        return bitmap;
    }

    static MorphRenderer a(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.b;
    }

    private void a(PointF pointf)
    {
        if (m)
        {
            if (!r)
            {
                c.c(pointf);
            }
            m = false;
            r = false;
        }
    }

    static int b(MorphGLSurfaceView morphglsurfaceview, int i1)
    {
        morphglsurfaceview.e = i1;
        return i1;
    }

    static Bitmap b(MorphGLSurfaceView morphglsurfaceview, Bitmap bitmap)
    {
        morphglsurfaceview.k = bitmap;
        return bitmap;
    }

    static void b(MorphGLSurfaceView morphglsurfaceview)
    {
        float f1 = morphglsurfaceview.b.a();
        float f2 = morphglsurfaceview.b.b();
        f1 = Math.min(f1 / (float)morphglsurfaceview.d, f2 / (float)morphglsurfaceview.e);
        morphglsurfaceview.b.b(morphglsurfaceview.j * f1);
        morphglsurfaceview.b.a(morphglsurfaceview.i * f1);
        morphglsurfaceview.s = f1;
    }

    static int c(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.d;
    }

    static int d(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.e;
    }

    private void d()
    {
        setEGLContextClientVersion(2);
        b = new MorphRenderer();
        b.a = this;
        setRenderer(b);
        setRenderMode(1);
        setTouchMode(TouchMode.PAINT);
    }

    static Bitmap e(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.l;
    }

    private void e()
    {
        if (p != null)
        {
            p.a();
        }
        c.a(n);
    }

    static Bitmap f(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.k;
    }

    static a g(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.c;
    }

    static com.photo.morph.a h(MorphGLSurfaceView morphglsurfaceview)
    {
        return morphglsurfaceview.p;
    }

    public final float a()
    {
        float f1;
        if (b != null && d > 0 && e > 0)
        {
            f1 = b.a();
            float f2 = b.b();
            f1 = Math.min(f1 / (float)d, f2 / (float)e);
        } else
        {
            f1 = 1.0F;
        }
        if (f1 == 0.0F)
        {
            return 1.0F;
        } else
        {
            return f1;
        }
    }

    public final void b()
    {
        a(n);
    }

    public final void c()
    {
        if (p != null)
        {
            p.b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (b == null || c == null)
        {
            return true;
        }
        int i1 = motionevent.getActionMasked();
        if (motionevent.getPointerCount() < 2)
        {
            i1 = 0;
        } else
        {
            if (c != null)
            {
                a(n);
            }
            PointF pointf = new PointF(motionevent.getX(0), motionevent.getY(0));
            PointF pointf3 = new PointF(motionevent.getX(1), motionevent.getY(1));
            PointF pointf2 = new PointF((pointf.x + pointf3.x) / 2.0F, (pointf.y + pointf3.y) / 2.0F);
            float f1 = pointf3.x - pointf.x;
            float f3 = pointf3.y - pointf.y;
            f1 = (float)Math.sqrt(f3 * f3 + f1 * f1);
            pointf = b.h();
            float f5 = b.g();
            float f7 = b.e();
            float f9 = b.f();
            if (i1 != 5 && f != null)
            {
                pointf = new PointF((pointf.x + pointf2.x) - f.x, (pointf.y + pointf2.y) - f.y);
            }
            f = pointf2;
            pointf3 = new PointF(pointf.x, pointf.y);
            pointf2 = new PointF(pointf2.x - pointf3.x, pointf2.y - pointf3.y);
            if (i1 == 5)
            {
                g = f1;
                f3 = 1.0F;
                f1 = 1.0F;
            } else
            {
                f3 = f1 / g;
                f1 = f3 / h;
            }
            h = f3;
            f3 = Math.max(f7, Math.min(f9, f5 * f1));
            if (f3 != f5)
            {
                pointf = new PointF(pointf2.x * f1, f1 * pointf2.y);
                pointf = new PointF(pointf2.x - pointf.x, pointf2.y - pointf.y);
                f1 = pointf3.x;
                float f6 = pointf.x;
                float f8 = pointf3.y;
                pointf = new PointF(f1 + f6, pointf.y + f8);
            }
            b.a(pointf);
            b.c(f3);
            t = f3 / s;
            if (c != null)
            {
                c.c(t);
            }
            i1 = 1;
        }
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        m = false;
_L4:
        return true;
_L2:
        PointF pointf1 = b.a(motionevent.getX(), motionevent.getY());
        switch (motionevent.getActionMasked())
        {
        case 0: // '\0'
            if (p != null)
            {
                m = true;
                n.x = pointf1.x;
                n.y = pointf1.y;
                o.x = motionevent.getX();
                o.y = motionevent.getY();
                if (p.a(c))
                {
                    r = true;
                } else
                {
                    r = false;
                    e();
                }
            }
            break;

        case 2: // '\002'
            if (m)
            {
                float f4 = motionevent.getX();
                float f2 = motionevent.getY();
                if (r)
                {
                    f4 -= o.x;
                    f2 -= o.y;
                    if ((float)Math.sqrt(f4 * f4 + f2 * f2) >= q)
                    {
                        e();
                        r = false;
                    }
                }
                if (!r)
                {
                    c.b(pointf1);
                    n.x = pointf1.x;
                    n.y = pointf1.y;
                }
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            a(pointf1);
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setBitmap(Bitmap bitmap)
    {
        b.a(bitmap, new Runnable() {

            private MorphGLSurfaceView a;

            public final void run()
            {
                com.photo.morph.MorphGLSurfaceView.a(a, com.photo.morph.MorphGLSurfaceView.a(a).c());
                MorphGLSurfaceView.b(a, com.photo.morph.MorphGLSurfaceView.a(a).d());
                MorphGLSurfaceView.b(a);
                com.photo.morph.MorphGLSurfaceView.a(a, Bitmap.createBitmap(MorphGLSurfaceView.c(a), MorphGLSurfaceView.d(a), android.graphics.Bitmap.Config.ARGB_8888));
                com.photo.morph.MorphGLSurfaceView.a(a).setSelectionBitmap(MorphGLSurfaceView.e(a));
                MorphGLSurfaceView.b(a, Bitmap.createBitmap(MorphGLSurfaceView.c(a), MorphGLSurfaceView.d(a), android.graphics.Bitmap.Config.ARGB_8888));
                com.photo.morph.MorphGLSurfaceView.a(a).setBrushAreaBitmap(MorphGLSurfaceView.f(a));
                if (MorphGLSurfaceView.g(a) != null)
                {
                    MorphGLSurfaceView.g(a).a(com.photo.morph.MorphGLSurfaceView.a(a));
                    MorphGLSurfaceView.g(a).a(MorphGLSurfaceView.f(a));
                    if (MorphGLSurfaceView.g(a) instanceof SelectBrush)
                    {
                        ((SelectBrush)MorphGLSurfaceView.g(a)).g = MorphGLSurfaceView.e(a);
                    }
                }
                if (MorphGLSurfaceView.h(a) != null)
                {
                    MorphGLSurfaceView.h(a).c();
                }
            }

            
            {
                a = MorphGLSurfaceView.this;
                super();
            }
        });
    }

    public void setBrush(a a1)
    {
        a(n);
        c = a1;
        if (c != null)
        {
            c.a(b);
            c.c(t);
            c.a(k);
            if (c instanceof SelectBrush)
            {
                ((SelectBrush)c).g = l;
            }
        }
    }

    public void setListener(com.photo.morph.a a1)
    {
        p = a1;
    }

    public void setTouchMode(TouchMode touchmode)
    {
    }

    static 
    {
        a = false;
        try
        {
            System.loadLibrary("morph");
            a = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            Log.e(com/photo/morph/MorphGLSurfaceView.getSimpleName(), "Can't load \"morph\" library.");
            Log.e(com/photo/morph/MorphGLSurfaceView.getSimpleName(), unsatisfiedlinkerror.getMessage());
        }
        Log.e("ex1", (new StringBuilder("morph lib loaded = ")).append(a).toString());
    }

    private class TouchMode extends Enum
    {

        private static final TouchMode $VALUES[];
        public static final TouchMode PAINT;
        public static final TouchMode TRANSFORM;

        public static TouchMode valueOf(String s1)
        {
            return (TouchMode)Enum.valueOf(com/photo/morph/MorphGLSurfaceView$TouchMode, s1);
        }

        public static TouchMode[] values()
        {
            return (TouchMode[])$VALUES.clone();
        }

        static 
        {
            TRANSFORM = new TouchMode("TRANSFORM", 0);
            PAINT = new TouchMode("PAINT", 1);
            $VALUES = (new TouchMode[] {
                TRANSFORM, PAINT
            });
        }

        private TouchMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
