// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditNotificationActivity

class a extends j
{

    final ArrayList a;
    final EditNotificationActivity b;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected String a(Void void1)
    {
        void1 = AccountManager.b();
        if (void1 == null || void1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        void1 = (String)o.a(void1, a).d();
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

    (EditNotificationActivity editnotificationactivity, ArrayList arraylist)
    {
        b = editnotificationactivity;
        a = arraylist;
        super();
    }
}
