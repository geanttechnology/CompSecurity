// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a, n

public class h extends a
{

    public boolean a;
    public long f;

    public h(Activity activity, ViewGroup viewgroup, int i, s s, n n)
    {
        super(activity, viewgroup, i, s, n);
        a = true;
        f = 0L;
    }

    protected d a(int i, int k)
    {
        Long long1 = AccountManager.c();
        f = i + k;
        Object obj;
        if (a)
        {
            obj = Integer.valueOf(1);
            a = false;
        } else
        {
            obj = null;
        }
        obj = (d)Post.a(long1, i, k, ((Integer) (obj))).a(new j() {

            final h a;

            public d a(d d1)
            {
                return d1;
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
                    ((BaseActivity)a.c).a(a.c.getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = h.this;
                super();
            }
        }).d();
        return ((d) (obj));
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
