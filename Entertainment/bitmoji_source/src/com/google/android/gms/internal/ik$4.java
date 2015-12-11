// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            ik

class .b extends .b
{

    final String RE;
    final ik Ry;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.removeMoment(RE);
        a(((com.google.android.gms.common.api.Result) (Status.zQ)));
    }

    .b(ik ik1, com.google.android.gms.common.api. , String s)
    {
        Ry = ik1;
        RE = s;
        super();
    }
}
