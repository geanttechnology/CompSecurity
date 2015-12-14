// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.socialin.android.util.Utils;
import myobfuscated.ay.c;

// Referenced classes of package com.picsart.effectnew:
//            RectangleF, EffectsDrawController, f, MaskBrushNew

public final class e
    implements c
{

    public View a;
    public PointF b;
    public EffectsDrawController c;
    public boolean d;
    public boolean e;
    public float f;
    public float g;
    public boolean h;
    public RectangleF i;
    public boolean j;
    public f k;
    public boolean l;
    public boolean m;
    public PointF n;
    public Paint o;
    private Rect p;
    private int q;
    private int r;

    public e(Context context, Bitmap bitmap, Bitmap bitmap1)
    {
        b = new PointF();
        d = false;
        e = false;
        f = 5F;
        g = 3F;
        h = true;
        p = new Rect();
        q = 0;
        r = 0;
        i = new RectangleF();
        j = false;
        new RectF();
        new Paint(2);
        l = false;
        m = false;
        n = new PointF();
        o = new Paint();
        q = bitmap.getWidth();
        r = bitmap.getHeight();
        p.set(0, 0, q, r);
        c = new EffectsDrawController(context, bitmap, bitmap1);
        f = Utils.a(5F, context);
        g = Utils.a(3F, context);
        o.setAntiAlias(true);
        o.setColor(0xffff0000);
        o.setStyle(android.graphics.Paint.Style.STROKE);
        o.setStrokeWidth(2.0F);
    }

    public final void a(int i1, int j1)
    {
    }

    public final void a(boolean flag)
    {
        if (l)
        {
            m = flag;
        }
    }

    public final boolean a()
    {
        if (k == null);
        return false;
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
    }

    public final void c()
    {
        if (a != null)
        {
            a.invalidate();
        }
    }

    public final void d()
    {
        while (k != null && (e || h || c.m != EffectsDrawController.EffectsDrawMode.BRUSH) || c == null) 
        {
            return;
        }
        EffectsDrawController.EffectsDrawMode effectsdrawmode = EffectsDrawController.EffectsDrawMode.BRUSH;
    }
}
