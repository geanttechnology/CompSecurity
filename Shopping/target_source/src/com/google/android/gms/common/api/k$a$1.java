// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.api:
//            k

class b
    implements Runnable
{

    final k a;
    final ConnectionResult b;
    final Result c;

    public void run()
    {
        k.c(a, b);
    }

    Result(Result result, k k1, ConnectionResult connectionresult)
    {
        c = result;
        a = k1;
        b = connectionresult;
        super();
    }
}
