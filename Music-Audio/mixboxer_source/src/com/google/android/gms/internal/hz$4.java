// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            hz, hs

class .b extends .b
{

    final hz Ec;
    final String Ei;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((hs));
    }

    protected void a(hs hs1)
    {
        hs1.removeMoment(Ei);
        a(((com.google.android.gms.common.api.Result) (Status.nA)));
    }

    .b(hz hz1, com.google.android.gms.common.api. , String s)
    {
        Ec = hz1;
        Ei = s;
        super();
    }
}
