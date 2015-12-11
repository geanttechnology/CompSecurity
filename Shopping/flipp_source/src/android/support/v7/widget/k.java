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

final class k extends r
{

    final bi a;
    final cj b;
    final g c;

    k(g g1, bi bi, cj cj1)
    {
        c = g1;
        a = bi;
        b = cj1;
        super((byte)0);
    }

    public final void a(View view)
    {
    }

    public final void b(View view)
    {
        b.a(null);
        ap.c(view, 1.0F);
        c.d(a);
        c.f.remove(a);
        c.c();
    }
}
