// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.NotificationSetting;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditNotificationActivity

class a extends j
{

    final EditNotificationActivity a;

    protected NotificationSetting a(Void void1)
    {
        void1 = AccountManager.c();
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        void1 = (NotificationSetting)o.a(void1.longValue()).d();
        return void1;
        void1;
        void1.printStackTrace();
_L2:
        return null;
        void1;
        void1.printStackTrace();
        continue; /* Loop/switch isn't completed */
        void1;
        void1.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    (EditNotificationActivity editnotificationactivity)
    {
        a = editnotificationactivity;
        super();
    }
}
