// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.os.Handler;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            k, q, p

class a
    implements Runnable
{

    final k a;

    public void run()
    {
        boolean flag = a.e();
        if (k.a(a) != flag)
        {
            k.a(a, flag);
            a.a().a(q.a(k.a(a)));
        }
        k.b(a).postDelayed(this, 3000L);
    }

    (k k1)
    {
        a = k1;
        super();
    }
}
