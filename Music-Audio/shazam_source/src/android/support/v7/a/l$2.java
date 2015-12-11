// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.support.v4.view.ak;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.view.View;

// Referenced classes of package android.support.v7.a:
//            l

final class a
    implements s
{

    final l a;

    public final ak a(View view, ak ak1)
    {
        int i = ak1.b();
        int j = l.b(a, i);
        ak ak2 = ak1;
        if (i != j)
        {
            ak2 = ak1.a(ak1.a(), j, ak1.c(), ak1.d());
        }
        return w.a(view, ak2);
    }

    k(l l1)
    {
        a = l1;
        super();
    }
}
