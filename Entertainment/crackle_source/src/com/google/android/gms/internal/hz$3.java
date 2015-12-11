// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            hz, hs

class .b extends .b
{

    final hz Ec;
    final Moment Eh;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((hs));
    }

    protected void a(hs hs1)
    {
        hs1.writeMoment(Eh);
        a(((com.google.android.gms.common.api.Result) (Status.nA)));
    }

    .b(hz hz1, com.google.android.gms.common.api. , Moment moment)
    {
        Ec = hz1;
        Eh = moment;
        super();
    }
}
