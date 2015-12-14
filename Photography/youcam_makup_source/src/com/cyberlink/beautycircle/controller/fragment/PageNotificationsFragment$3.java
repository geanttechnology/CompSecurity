// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class a extends j
{

    final PageNotificationsFragment a;

    protected Boolean a(Void void1)
    {
        void1 = AccountManager.b();
        boolean flag;
        if (void1 != null && !void1.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    (PageNotificationsFragment pagenotificationsfragment)
    {
        a = pagenotificationsfragment;
        super();
    }
}
