// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.purchase.i;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.he;

// Referenced classes of package com.google.android.gms.ads.internal:
//            b, p, q

final class a
    implements Runnable
{

    final Intent a;
    final b b;

    public final void run()
    {
        p.o();
        int j = i.a(a);
        p.o();
        if (j == 0 && b.c.j != null && b.c.j.b != null && b.c.j.b.f() != null)
        {
            b.c.j.b.f().a();
        }
        b.c.D = false;
    }

    lay.d(b b1, Intent intent)
    {
        b = b1;
        a = intent;
        super();
    }
}
