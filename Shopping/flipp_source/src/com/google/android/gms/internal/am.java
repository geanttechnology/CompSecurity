// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            at, bq, et, al

final class am
    implements Runnable
{

    final at a;
    final al b;

    am(al al, at at1)
    {
        b = al;
        a = at1;
        super();
    }

    public final void run()
    {
        try
        {
            a.c.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Could not destroy mediation adapter.", remoteexception);
        }
    }
}
