// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

final class  extends j
{

    protected NetworkManager a(Void void1)
    {
        if (NetworkManager.a == null)
        {
            NetworkManager.a = new NetworkManager();
        }
        NetworkManager networkmanager = NetworkManager.a;
        networkmanager;
        JVM INSTR monitorenter ;
        String s;
        if (NetworkManager.a.d)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        s = AccountManager.a();
        void1 = s;
        if (!AccountManager.a(s))
        {
            void1 = Locale.getDefault().toString();
        }
        nit>();
        NetworkManager.a(NetworkManager.a, void1);
        networkmanager;
        JVM INSTR monitorexit ;
        return NetworkManager.a;
        void1;
        networkmanager;
        JVM INSTR monitorexit ;
        throw void1;
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    ()
    {
    }
}
