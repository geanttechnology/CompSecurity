// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.a.a.a.a;
import com.a.a.a.b;

// Referenced classes of package com.smule.android.d:
//            j, p, n

class a
    implements ServiceConnection
{

    final n a;
    final j b;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (!b.d) goto _L2; else goto _L1
_L1:
        return;
_L2:
        b.c("Billing service connected.");
        b.j = com.a.a.a.b.a(ibinder);
        componentname = b.i.getPackageName();
        int i;
        b.c("Checking for in-app billing 3 support.");
        i = b.j.a(3, componentname, "inapp");
        if (i != 0)
        {
            try
            {
                if (a != null)
                {
                    a.a(new p(i, "Error checking for billing v3 support."));
                }
                b.e = false;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname) { }
            if (a != null)
            {
                a.a(new p(-1001, "RemoteException while setting up in-app billing."));
            }
            componentname.printStackTrace();
            return;
        }
        b.c((new StringBuilder()).append("In-app billing version 3 supported for ").append(componentname).toString());
        i = b.j.a(3, componentname, "subs");
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        b.c("Subscriptions AVAILABLE.");
        b.e = true;
_L4:
        b.c = true;
        if (a == null) goto _L1; else goto _L3
_L3:
        a.a(new p(0, "Setup successful."));
        return;
        b.c((new StringBuilder()).append("Subscriptions NOT AVAILABLE. Response: ").append(i).toString());
          goto _L4
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        b.c("Billing service disconnected.");
    }

    tName(j j1, n n1)
    {
        b = j1;
        a = n1;
        super();
    }
}
