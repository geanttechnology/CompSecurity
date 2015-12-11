// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.ah;
import android.support.v4.view.bf;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            k

class a
    implements ac
{

    final k a;

    public bf a(View view, bf bf1)
    {
        int i = bf1.b();
        int j = k.c(a, i);
        bf bf2 = bf1;
        if (i != j)
        {
            bf2 = bf1.a(bf1.a(), j, bf1.c(), bf1.d());
        }
        return ah.a(view, bf2);
    }

    (k k1)
    {
        a = k1;
        super();
    }
}
