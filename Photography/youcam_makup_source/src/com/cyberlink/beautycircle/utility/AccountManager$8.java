// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.model.UserInfo;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, a

class a
    implements Runnable
{

    final UserInfo a;
    final AccountManager b;

    public void run()
    {
        for (Iterator iterator = b.e.iterator(); iterator.hasNext(); ((a)iterator.next()).a(a)) { }
    }

    _cls9(AccountManager accountmanager, UserInfo userinfo)
    {
        b = accountmanager;
        a = userinfo;
        super();
    }
}
