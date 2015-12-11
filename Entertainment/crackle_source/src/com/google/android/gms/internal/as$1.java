// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            as, ay, bc, ct

class fB
    implements Runnable
{

    final ay fB;
    final as fC;

    public void run()
    {
        try
        {
            fB.gc.destroy();
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not destroy mediation adapter.", remoteexception);
        }
    }

    (as as1, ay ay1)
    {
        fC = as1;
        fB = ay1;
        super();
    }
}
