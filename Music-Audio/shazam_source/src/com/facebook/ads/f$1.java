// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.View;
import com.facebook.ads.a.b;
import com.facebook.ads.a.c;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.g.a;
import com.facebook.ads.a.i;

// Referenced classes of package com.facebook.ads:
//            f, c, g

final class <init> extends b
{

    final f a;

    public final void a()
    {
        if (com.facebook.ads.f.b(a) != null)
        {
            com.facebook.ads.f.b(a).c();
        }
    }

    public final void a(View view)
    {
        if (view == null)
        {
            throw new IllegalStateException("Cannot present null view");
        }
        com.facebook.ads.f.c(a);
        com.facebook.ads.f.a(a, view);
        a.removeAllViews();
        a.addView(f.d(a));
        if (f.d(a) instanceof a)
        {
            g.a(f.e(a), f.d(a), f.f(a));
        }
        if (com.facebook.ads.f.a(a) != null)
        {
            com.facebook.ads.f.a(a).a(a);
        }
    }

    public final void a(c c1)
    {
        if (com.facebook.ads.f.a(a) != null)
        {
            com.facebook.ads.f.a(a).a(a, c1.a());
        }
    }

    public final void b()
    {
        if (com.facebook.ads.f.a(a) != null)
        {
            com.facebook.ads.f.a(a).b(a);
        }
    }

    public final void c()
    {
        if (com.facebook.ads.f.g(a) != null)
        {
            com.facebook.ads.f.g(a);
        }
        if ((com.facebook.ads.f.a(a) instanceof com.facebook.ads.g) && com.facebook.ads.f.a(a) != com.facebook.ads.f.g(a))
        {
            com.facebook.ads.f.a(a);
        }
    }

    g(f f1)
    {
        a = f1;
        super();
    }
}
