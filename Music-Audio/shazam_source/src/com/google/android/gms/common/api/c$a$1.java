// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.support.v4.app.i;
import android.support.v4.app.k;

// Referenced classes of package com.google.android.gms.common.api:
//            c, u

final class a
    implements Runnable
{

    final c a;
    final a b;

    public final void run()
    {
        if (b.b.isFinishing() || b.b.getSupportFragmentManager().g())
        {
            return;
        } else
        {
            b.b(u.b(b.b), a);
            return;
        }
    }

    ( , c c1)
    {
        b = ;
        a = c1;
        super();
    }
}
