// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            x, n

public class v extends x
{

    public v(Activity activity, ViewGroup viewgroup, int i, Long along[], s s, n n)
    {
        super(activity, viewgroup, i, along, s, n);
    }

    protected d a(int i, int k)
    {
        d d1 = (d)NetworkPost.c("Post", a[0].longValue(), AccountManager.c(), i, k).a(new j() {

            final v a;

            public d a(d d2)
            {
                return d2;
            }

            public volatile Object a(Object obj1)
            {
                return a((d)obj1);
            }

            public void a(int l)
            {
                super.a(l);
                if (a.c != null && (a.c instanceof MainActivity))
                {
                    ((BaseFbActivity)a.c).a(a.c.getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = v.this;
                super();
            }
        }).d();
        return d1;
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
_L2:
        return null;
        obj;
        ((ExecutionException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((CancellationException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }
}
