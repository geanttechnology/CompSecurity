// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.av;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package myobfuscated.av:
//            a, e

public final class b
{

    public a a;
    public RectF b;
    public RectF c;
    PointF d;
    public RectF e;
    public boolean f;
    public e g;

    public b(Context context)
    {
        b = new RectF();
        c = new RectF();
        d = new PointF();
        e = new RectF();
        f = false;
        a = new a(context);
        a.a = this;
    }

    public final void a()
    {
        if (g != null)
        {
            g.a();
        }
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        b.set(f1, f2, f3, f4);
        c.set(b);
        f = true;
    }
}
