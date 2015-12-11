// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.graphics.Rect;
import android.support.v4.view.ba;
import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.view.View;

// Referenced classes of package android.support.design.internal:
//            f

final class g
    implements ba
{

    private f a;

    g(f f1)
    {
        a = f1;
        super();
    }

    public final dn onApplyWindowInsets(View view, dn dn1)
    {
        if (f.a(a) == null)
        {
            f.a(a, new Rect());
        }
        f.a(a).set(dn1.a(), dn1.b(), dn1.c(), dn1.d());
        view = a;
        boolean flag;
        if (f.a(a).isEmpty() || f.b(a) == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setWillNotDraw(flag);
        bi.d(a);
        return dn1.f();
    }
}
