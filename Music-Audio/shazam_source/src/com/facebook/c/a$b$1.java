// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.c;

import android.os.Handler;
import android.os.SystemClock;

// Referenced classes of package com.facebook.c:
//            a, b

final class t>
    implements Runnable
{

    final a a;

    public final void run()
    {
        if (!a.a || a.a == null)
        {
            return;
        } else
        {
            long l = SystemClock.uptimeMillis();
            a.a.a(l - a.a);
            a.a.post(a.a);
            return;
        }
    }

    k(k k)
    {
        a = k;
        super();
    }
}
