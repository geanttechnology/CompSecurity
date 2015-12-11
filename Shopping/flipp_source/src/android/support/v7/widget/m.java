// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            r, g, bi

final class m extends r
{

    final bi a;
    final int b;
    final int c;
    final cj d;
    final g e;

    m(g g1, bi bi, int i, int j, cj cj1)
    {
        e = g1;
        a = bi;
        b = i;
        c = j;
        d = cj1;
        super((byte)0);
    }

    public final void a(View view)
    {
    }

    public final void b(View view)
    {
        d.a(null);
        e.e(a);
        e.e.remove(a);
        e.c();
    }

    public final void c(View view)
    {
        if (b != 0)
        {
            ap.a(view, 0.0F);
        }
        if (c != 0)
        {
            ap.b(view, 0.0F);
        }
    }
}
