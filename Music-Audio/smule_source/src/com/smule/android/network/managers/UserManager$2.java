// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.a;

// Referenced classes of package com.smule.android.network.managers:
//            UserManager

class a
    implements Runnable
{

    final ginResponseCallback a;
    final UserManager b;

    public void run()
    {
        com.smule.android.network.core.a.a(a, b.v());
    }

    ginResponseCallback(UserManager usermanager, ginResponseCallback ginresponsecallback)
    {
        b = usermanager;
        a = ginresponsecallback;
        super();
    }
}
