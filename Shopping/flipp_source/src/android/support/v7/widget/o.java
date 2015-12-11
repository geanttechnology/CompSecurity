// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            r, p, g

final class o extends r
{

    final p a;
    final cj b;
    final View c;
    final g d;

    o(g g1, p p1, cj cj1, View view)
    {
        d = g1;
        a = p1;
        b = cj1;
        c = view;
        super((byte)0);
    }

    public final void a(View view)
    {
    }

    public final void b(View view)
    {
        b.a(null);
        ap.c(c, 1.0F);
        ap.a(c, 0.0F);
        ap.b(c, 0.0F);
        d.g(a.b);
        d.g.remove(a.b);
        d.c();
    }
}
