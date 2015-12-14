// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.socialin.android.photo.select.o;
import com.socialin.android.photo.tools.a;
import com.socialin.android.util.Utils;
import myobfuscated.cn.b;
import myobfuscated.cn.c;

// Referenced classes of package com.socialin.android.photo.freecrop:
//            f

public final class e
    implements c
{

    private int A;
    private int B;
    private float C;
    float a;
    float b;
    public a c;
    public a d;
    RectF e;
    Rect f;
    float g;
    float h;
    boolean i;
    boolean j;
    boolean k;
    float l;
    float m;
    float n;
    float o;
    public o p;
    public View q;
    boolean r;
    boolean s;
    int t;
    boolean u;
    myobfuscated.cn.a v;
    Paint w;
    float x;
    f y;
    b z;

    public e(Context context, RectF rectf, Rect rect, float f1, float f2)
    {
        b = 0.0F;
        i = false;
        j = false;
        k = false;
        l = 3F;
        m = 7F;
        r = false;
        s = false;
        t = 0;
        u = false;
        e = rectf;
        f = rect;
        l = f1;
        m = f2;
        A = (int)Utils.a(70F, context);
        B = (int)Utils.a(10F, context);
        C = (Utils.a(1.0F, context) * 2.0F) / 3F;
        a = Utils.a(120F, context);
        c = new a(context, 0, 0x7f020334);
        d = new a(context, 25, 0x7f020249);
        w = new Paint();
        w.setFilterBitmap(true);
        if (p == null)
        {
            p = new o(rectf, A, B);
        }
        v = new myobfuscated.cn.a(C);
    }

    public final float a(float f1)
    {
        float f2 = f1;
        if (f1 < e.left)
        {
            f2 = e.left;
        }
        f1 = f2;
        if (f2 > e.right)
        {
            f1 = e.right;
        }
        return f1;
    }

    public final void a()
    {
        if (!s && !v.a.isEmpty())
        {
            d();
        }
    }

    final void a(float f1, float f2)
    {
        v.a(g, h, f1, f2);
        g = f1;
        h = f2;
        if (p != null)
        {
            if (p.a(f1, f2))
            {
                q.invalidate(p.c);
            }
            q.invalidate(p.b);
            e();
        }
    }

    public final float b(float f1)
    {
        float f2 = f1;
        if (f1 < e.top)
        {
            f2 = e.top;
        }
        f1 = f2;
        if (f2 > e.bottom)
        {
            f1 = e.bottom;
        }
        return f1;
    }

    public final void b()
    {
        v.a.reset();
        d.a = false;
        c.a = false;
        u = false;
        r = false;
        e();
    }

    final void c()
    {
        u = false;
        r = false;
    }

    void d()
    {
        e();
        z = new b(this);
        z.start();
    }

    public final void e()
    {
        if (z != null)
        {
            z.b = false;
            z = null;
        }
    }

    public final void h()
    {
        if (q != null)
        {
            q.postInvalidate();
        }
    }
}
