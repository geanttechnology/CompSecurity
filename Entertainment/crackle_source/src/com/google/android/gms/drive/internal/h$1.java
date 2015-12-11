// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            h, j, QueryRequest, o

class <init> extends <init>
{

    final Query rb;
    final h rc;

    protected volatile void a(com.google.android.gms.common.api.a a1)
    {
        a((j)a1);
    }

    protected void a(j j1)
    {
        try
        {
            j1.cN().a(new QueryRequest(rb), new <init>(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            a(((com.google.android.gms.common.api.Result) (new <init>(new Status(8, j1.getLocalizedMessage(), null), null))));
        }
    }

    yRequest(h h1, Query query)
    {
        rc = h1;
        rb = query;
        super(h1);
    }
}
