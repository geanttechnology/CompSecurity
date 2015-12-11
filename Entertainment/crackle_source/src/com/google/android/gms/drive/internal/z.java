// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            a

public class z extends a
{

    private final com.google.android.gms.common.api.a.c jW;

    public z(com.google.android.gms.common.api.a.c c)
    {
        jW = c;
    }

    public void m(Status status)
        throws RemoteException
    {
        jW.a(status);
    }

    public void onSuccess()
        throws RemoteException
    {
        jW.a(Status.nA);
    }
}
