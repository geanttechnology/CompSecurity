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

final class n extends r
{

    final p a;
    final cj b;
    final g c;

    n(g g1, p p1, cj cj1)
    {
        c = g1;
        a = p1;
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
        ap.a(view, 0.0F);
        ap.b(view, 0.0F);
        c.g(a.a);
        c.g.remove(a.a);
        c.c();
    }
}
