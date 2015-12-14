// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.utility.m;
import com.tencent.mm.sdk.openapi.e;
import com.tencent.mm.sdk.openapi.k;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ae, af

class a extends m
{

    final af a;
    final ae b;

    protected void a(k k1)
    {
        if (k1 == null && a != null)
        {
            a.b();
            ae.a(null);
        }
        boolean flag = ae.a(b).a(k1);
        if (a != null && !flag)
        {
            a.b();
            ae.a(null);
        }
    }

    protected void b(Object obj)
    {
        a((k)obj);
    }

    (ae ae1, af af1)
    {
        b = ae1;
        a = af1;
        super();
    }
}
