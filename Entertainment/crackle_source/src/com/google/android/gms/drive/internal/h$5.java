// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            h, j, z, o

class <init> extends <init>
{

    final h rc;

    protected volatile void a(com.google.android.gms.common.api.a a1)
    {
        a((j)a1);
    }

    protected void a(j j1)
    {
        try
        {
            j1.cN().a(new z(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            a(((com.google.android.gms.common.api.Result) (new Status(8, j1.getLocalizedMessage(), null))));
        }
    }

    (h h1)
    {
        rc = h1;
        super(h1);
    }
}
