// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.api:
//            m, p

final class nit> extends nit>
{

    final m a;
    final ConnectionResult b;
    final Result c;

    public final void a()
    {
        m m1;
        ConnectionResult connectionresult;
label0:
        {
            m1 = a;
            connectionresult = b;
            if (m1.b(2))
            {
                if (!connectionresult.b())
                {
                    break label0;
                }
                m1.h();
            }
            return;
        }
        if (m1.a(connectionresult))
        {
            m1.i();
            m1.h();
            return;
        } else
        {
            m1.b(connectionresult);
            return;
        }
    }

    Result(Result result, p p, m m1, ConnectionResult connectionresult)
    {
        c = result;
        a = m1;
        b = connectionresult;
        super(p);
    }
}
