// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            at, bc

class au extends at
{

    au()
    {
    }

    final long a()
    {
        return bc.a();
    }

    public final void a(View view, float f1)
    {
        bc.a(view, f1);
    }

    public final void a(View view, int i, Paint paint)
    {
        bc.a(view, i, paint);
    }

    public void a(View view, Paint paint)
    {
        bc.a(view, bc.b(view), paint);
        view.invalidate();
    }

    public final void b(View view, float f1)
    {
        bc.b(view, f1);
    }

    public final void c(View view, float f1)
    {
        bc.c(view, f1);
    }

    public final float f(View view)
    {
        return bc.a(view);
    }

    public final int g(View view)
    {
        return bc.b(view);
    }

    public final float k(View view)
    {
        return bc.c(view);
    }

    public final float l(View view)
    {
        return bc.d(view);
    }
}
