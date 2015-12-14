// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a, n

public class e extends a
{

    private static final String a = null;
    private String f;
    private CircleDetail k;

    public e(Activity activity, ViewGroup viewgroup, int i, s s, n n)
    {
        super(activity, viewgroup, i, s, n);
        f = a;
        k = null;
    }

    protected d a(int i, int l)
    {
        if (k == null)
        {
            return null;
        }
        Object obj;
        obj = AccountManager.c();
        obj = (d)Post.a(k.id, k.circleTypeId, null, f, ((Long) (obj)), k.defaultType, Integer.valueOf(i), Integer.valueOf(l)).a(new j() {

            final e a;

            public d a(d d1)
            {
                return d1;
            }

            public volatile Object a(Object obj2)
            {
                return a((d)obj2);
            }

            public void a(int i1)
            {
                super.a(i1);
                if (a.c != null && (a.c instanceof MainActivity))
                {
                    ((BaseActivity)a.c).a(a.c.getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = e.this;
                super();
            }
        }).d();
        return ((d) (obj));
        Object obj1;
        obj1;
        ((InterruptedException) (obj1)).printStackTrace();
_L2:
        return null;
        obj1;
        ((ExecutionException) (obj1)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj1;
        ((CancellationException) (obj1)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(CircleDetail circledetail)
    {
        k = circledetail;
    }

}
