// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.support.v4.app.g;
import android.support.v4.app.i;

// Referenced classes of package com.google.android.gms.common.api:
//            c, u

class a
    implements Runnable
{

    final c a;
    final a b;

    public void run()
    {
        if (a(b).isFinishing() || b(b).f().d())
        {
            return;
        } else
        {
            b(b, u.b(b(b)), a);
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
