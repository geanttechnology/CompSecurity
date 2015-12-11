// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.d:
//            kg, ka, kh, ke, 
//            jy

final class b
    implements kg
{

    final jy a;
    final nit> b;
    final ka c;

    public final void a(Status status, Object obj, Integer integer, long l)
    {
        if (status.b())
        {
            if (integer == kh.a)
            {
                status = a.c;
            } else
            {
                status = a.b;
            }
            status = new <init>(Status.a, a, null, (a)obj, status, l);
        } else
        {
            status = new <init>(new Status(16, (new StringBuilder("There is no valid resource for the container: ")).append(a.a).toString()), null, a.b);
        }
        b.a(new ke(status));
    }

    api.Status(ka ka1, jy jy1, api.Status status)
    {
        c = ka1;
        a = jy1;
        b = status;
        super();
    }
}
