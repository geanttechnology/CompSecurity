// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            l, n, QueryRequest, u

class <init> extends <init>
{

    final Query Du;
    final l Dv;

    protected volatile void a(com.google.android.gms.common.api.a a1)
        throws RemoteException
    {
        a((n)a1);
    }

    protected void a(n n1)
        throws RemoteException
    {
        n1.eT().a(new QueryRequest(Du), new <init>(this));
    }

    yRequest(l l1, Query query)
    {
        Dv = l1;
        Du = query;
        super(l1);
    }
}
