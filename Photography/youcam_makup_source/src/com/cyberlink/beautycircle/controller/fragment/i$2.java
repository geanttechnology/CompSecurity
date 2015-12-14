// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            i

class c extends j
{

    final CircleDetail a;
    final Long b;
    final Long c;
    final i d;

    protected CircleDetail a(Void void1)
    {
        void1 = AccountManager.d();
        if (void1 != null)
        {
            i.a(d, ((UserInfo) (void1)).id);
        }
        if (a != null)
        {
            return a;
        }
        try
        {
            void1 = (CircleDetail)((d)NetworkCircle.a(b, c, Long.valueOf(i.c(d))).d()).b.get(0);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return null;
        }
        return void1;
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    cle(i k, CircleDetail circledetail, Long long1, Long long2)
    {
        d = k;
        a = circledetail;
        b = long1;
        c = long2;
        super();
    }
}
