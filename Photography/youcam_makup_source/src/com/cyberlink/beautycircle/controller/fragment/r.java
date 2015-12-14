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
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.o;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, h

public class r extends com.cyberlink.beautycircle.controller.fragment.e
{

    private Long s;
    private a t;
    private n x;

    public r()
    {
        s = null;
        t = new a() {

            final r a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = r.this;
                super();
            }
        };
        x = new h(this);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 48148 48148: default 28
    //                   48148 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (h != null)
        {
            h.notifyDataSetChanged();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = layoutinflater.inflate(k.bc_fragment_page_post_group, viewgroup, false);
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
        h = new o(getActivity(), g, k.bc_view_item_discover_list, null, x);
        ((o)h).a(s.longValue());
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
