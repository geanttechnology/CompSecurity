// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.os.Handler;
import android.view.View;
import com.facebook.ads.a.b.b;
import com.facebook.ads.a.b.c;

// Referenced classes of package com.facebook.ads.a:
//            i, b

final class 
    implements c
{

    final Runnable a;
    final i b;

    public final void a()
    {
        i.g();
        b.a.();
    }

    public final void a(b b1)
    {
        i.g();
        i.e(b).removeCallbacks(a);
        i.a(b1);
        i.d(b);
    }

    public final void a(b b1, View view)
    {
        i.g();
        i.e(b).removeCallbacks(a);
        com.facebook.ads.a.b.a a1 = i.f(b);
        i.a(b, b1);
        i.a(b, view);
        if (!i.g(b))
        {
            b.a.a();
            return;
        } else
        {
            b.a.a(view);
            i.a(a1);
            com.facebook.ads.a.i.c(b);
            return;
        }
    }

    public final void b()
    {
        i.g();
        b.a.();
    }

    (i j, Runnable runnable)
    {
        b = j;
        a = runnable;
        super();
    }
}
