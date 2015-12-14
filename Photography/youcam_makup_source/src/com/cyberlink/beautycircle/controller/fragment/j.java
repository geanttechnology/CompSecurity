// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.controller.adapter.d;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, h

public class j extends g
{

    private Long s;
    private a t;
    private n u;

    public j()
    {
        s = null;
        t = new a() {

            final j a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = j.this;
                super();
            }
        };
        u = new h(this);
    }

    public void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (i == 48156 && l == -1 && intent != null)
        {
            boolean flag = intent.getBooleanExtra("IsFollowed", false);
            long l1 = intent.getLongExtra("CircleId", -1L);
            if (l1 != -1L && h != null)
            {
                ((CircleDetail)((d)h).b(String.valueOf(l1))).isFollowed = Boolean.valueOf(flag);
                h.notifyDataSetChanged();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = layoutinflater.inflate(k.bc_fragment_page_circle_group, viewgroup, false);
        viewgroup = getActivity().getIntent();
        if (viewgroup != null)
        {
            viewgroup = Long.valueOf(viewgroup.getLongExtra("NotificationId", 0L));
        } else
        {
            viewgroup = null;
        }
        s = viewgroup;
        a(layoutinflater, bundle, null, Integer.valueOf(k.bc_view_footer));
        h = new d(getActivity(), g, -1L, 2, u);
        ((d)h).a(s.longValue());
        h.d(false);
        h.c();
        a(bundle, true, false, false, null);
        a(bundle, 0, true);
        AccountManager.a(t);
        b();
        return bundle;
    }

    public void onDestroy()
    {
        AccountManager.b(t);
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (h != null && h.j())
        {
            h.g = true;
            e.b(new Object[] {
                "Set ForcedRefresh by refresh expired."
            });
        }
        if (h != null && h.g)
        {
            h.c();
        }
    }
}
