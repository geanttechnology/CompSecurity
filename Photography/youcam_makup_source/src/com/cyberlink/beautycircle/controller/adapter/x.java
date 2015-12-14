// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a, n

public class x extends a
{

    public Long a[];
    private android.view.View.OnClickListener f;

    public x(Activity activity, ViewGroup viewgroup, int i, Long along[], s s, n n)
    {
        super(activity, viewgroup, i, s, n);
        a = null;
        f = new android.view.View.OnClickListener() {

            final x a;

            public void onClick(View view)
            {
                if (a.c != null)
                {
                    ((BaseFbActivity)a.c).a(view, (Post)view.getTag());
                }
            }

            
            {
                a = x.this;
                super();
            }
        };
        a = along;
    }

    protected d a(int i, int k)
    {
        d d1 = (d)Post.a(a, null, AccountManager.c(), i, k).a(new j() {

            final x a;

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
                a = x.this;
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

    public void a(Post post, View view)
    {
        super.a(post, view);
        view = view.findViewById(com.cyberlink.beautycircle.j.issue_btn_share);
        if (view != null)
        {
            view.setTag(post);
            view.setVisibility(0);
            view.setOnClickListener(f);
        }
    }

    public volatile void a(Model model, View view)
    {
        a((Post)model, view);
    }
}
