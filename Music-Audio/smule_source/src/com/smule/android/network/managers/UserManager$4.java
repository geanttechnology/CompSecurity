// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.a;

// Referenced classes of package com.smule.android.network.managers:
//            UserManager

class b
    implements Runnable
{

    final NetworkResponseCallback a;
    final String b;
    final UserManager c;

    public void run()
    {
        com.smule.android.network.core.a.a(a, c.c(b));
    }

    lback(UserManager usermanager, NetworkResponseCallback networkresponsecallback, String s)
    {
        c = usermanager;
        a = networkresponsecallback;
        b = s;
        super();
    }
}
