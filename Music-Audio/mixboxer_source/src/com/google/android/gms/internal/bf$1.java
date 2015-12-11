// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            bf, bd, ct

class gj
    implements Runnable
{

    final bf gj;

    public void run()
    {
        try
        {
            bf.a(gj).w();
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Could not call onAdClicked.", remoteexception);
        }
    }

    (bf bf1)
    {
        gj = bf1;
        super();
    }
}
