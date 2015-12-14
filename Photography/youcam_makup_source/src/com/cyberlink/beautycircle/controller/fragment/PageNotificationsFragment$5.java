// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.NotificationNew;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class a extends j
{

    final PageNotificationsFragment a;

    protected NotificationNew a(Void void1)
    {
        void1 = AccountManager.b();
        if (void1 == null || void1.isEmpty())
        {
            return null;
        }
        try
        {
            void1 = AccountManager.d();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        if (void1 == null) goto _L2; else goto _L1
_L1:
        void1 = (NotificationNew)o.a(Long.valueOf(((UserInfo) (void1)).id)).d();
_L4:
        return void1;
_L2:
        void1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_21;
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
