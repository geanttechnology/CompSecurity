// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.internal.dq;

// Referenced classes of package com.google.android.gms.cast:
//            Cast

class wr extends wr
{

    final x wr;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((dq));
    }

    protected void a(dq dq1)
        throws RemoteException
    {
        try
        {
            dq1.b(null, null, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (dq dq1)
        {
            x(2001);
        }
    }

    ( )
    {
        wr = ;
        super(null);
    }
}
