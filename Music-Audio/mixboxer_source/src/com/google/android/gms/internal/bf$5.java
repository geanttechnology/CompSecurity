// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            bf, bg, bd, ct

class gk
    implements Runnable
{

    final bf gj;
    final com.google.ads.uest.ErrorCode gk;

    public void run()
    {
        try
        {
            bf.a(gj).onAdFailedToLoad(bg.a(gk));
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    (bf bf1, com.google.ads.uest.ErrorCode errorcode)
    {
        gj = bf1;
        gk = errorcode;
        super();
    }
}
