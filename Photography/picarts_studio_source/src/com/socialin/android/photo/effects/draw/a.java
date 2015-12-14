// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import com.photo.gpu.g;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.RectangleF;
import com.picsart.effectnew.h;
import com.socialin.android.util.Utils;
import myobfuscated.ay.b;
import myobfuscated.ay.c;

// Referenced classes of package com.socialin.android.photo.effects.draw:
//            b

public final class a
    implements c
{

    View a;
    PointF b;
    public EffectsDrawController c;
    boolean d;
    boolean e;
    float f;
    float g;
    public Bitmap h;
    public boolean i;
    public Rect j;
    int k;
    public RectangleF l;
    boolean m;
    public com.socialin.android.photo.effects.draw.b n;
    public b o;
    Handler p;
    float q;
    public g r;
    Paint s;
    boolean t;
    boolean u;
    PointF v;
    Paint w;
    public Context x;
    boolean y;
    private int z;

    public a(Context context, Bitmap bitmap, Bitmap bitmap1)
    {
        b = new PointF();
        d = false;
        e = false;
        f = 5F;
        g = 3F;
        h = null;
        i = true;
        j = new Rect();
        k = 0;
        z = 0;
        l = new RectangleF();
        m = false;
        new RectF();
        q = 5F;
        s = new Paint(2);
        t = false;
        u = false;
        v = new PointF();
        w = new Paint();
        y = false;
        x = context;
        h = bitmap;
        k = bitmap.getWidth();
        z = bitmap.getHeight();
        j.set(0, 0, k, z);
        c = new EffectsDrawController(context, bitmap, bitmap1, (byte)0);
        f = Utils.a(5F, context);
        g = Utils.a(3F, context);
        w.setAntiAlias(true);
        w.setColor(0xffff0000);
        w.setStyle(android.graphics.Paint.Style.STROKE);
        w.setStrokeWidth(2.0F);
    }

    public final void a(int i1, int j1)
    {
        if (n != null)
        {
            n.a(i1, j1);
        }
    }

    public final void a(Boolean boolean1)
    {
        y = boolean1.booleanValue();
    }

    public final void a(boolean flag)
    {
        if (o != null)
        {
            o.e = flag;
        }
    }

    public final boolean a()
    {
        if (n != null)
        {
            return n.b();
        } else
        {
            return false;
        }
    }

    public final MaskBrushNew b()
    {
        if (c != null)
        {
            return c.k;
        } else
        {
            return null;
        }
    }

    public final void b(int i1, int j1)
    {
        if (n != null)
        {
            n.b(i1, j1);
        }
    }

    public final void b(boolean flag)
    {
        if (o == null)
        {
            return;
        }
        long l1 = System.currentTimeMillis();
        if (flag)
        {
            o.o = b.n;
        } else
        {
            o.o = b.m;
        }
        e();
        if (p == null)
        {
            p = new Handler();
        }
        p.post(new Runnable(l1, flag) {

            private long a;
            private boolean b;
            private a c;

            public final void run()
            {
                if (c.o == null)
                {
                    return;
                }
                float f1 = Math.min(180L, System.currentTimeMillis() - a);
                if (b)
                {
                    c.o.o = c.o.o + 5F;
                } else
                {
                    c.o.o = c.o.o - 5F;
                }
                c.e();
                if (f1 < 180F)
                {
                    c.p.post(this);
                    return;
                }
                if (b)
                {
                    c.o.o = b.m;
                } else
                {
                    c.o.o = b.n;
                }
                c.e();
            }

            
            {
                c = a.this;
                a = l1;
                b = flag;
                super();
            }
        });
    }

    public final void c()
    {
        EffectsDrawController effectsdrawcontroller = c;
        MaskBrushNew maskbrushnew = effectsdrawcontroller.k;
        maskbrushnew.v = com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE;
        maskbrushnew.b(255);
        maskbrushnew.a(2);
        maskbrushnew.a(25F);
        effectsdrawcontroller.l.c();
    }

    public final void c(boolean flag)
    {
        if (t)
        {
            u = flag;
        }
    }

    public final void d()
    {
        if (!d) goto _L2; else goto _L1
_L1:
        if (o == null || !o.e || !o.a(l)) goto _L4; else goto _L3
_L3:
        b(false);
_L2:
        d = false;
        e = false;
        return;
_L4:
        if (e)
        {
            c.n();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    final void e()
    {
        if (a != null)
        {
            a.invalidate();
        }
    }

    public final void f()
    {
        while (n != null && (e || n.e() || i || n.e() && n.f() || c.m != com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH) || c == null || c.m != com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH || n == null) 
        {
            return;
        }
        n.g();
    }
}
