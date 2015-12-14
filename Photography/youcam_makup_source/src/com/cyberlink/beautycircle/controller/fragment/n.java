// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.controller.adapter.c;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, h

public class n extends g
{

    private Long s;
    private a t;
    private com.cyberlink.beautycircle.controller.adapter.n u;

    public n()
    {
        t = new a() {

            final n a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = n.this;
                super();
            }
        };
        u = new h(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            bundle = (com.cyberlink.beautycircle.controller.activity.GeneralWaterFallActivity.ParamsFollowingCircles)Model.a(com/cyberlink/beautycircle/controller/activity/GeneralWaterFallActivity$ParamsFollowingCircles, bundle.getString("Params"));
            if (bundle != null)
            {
                s = ((com.cyberlink.beautycircle.controller.activity.GeneralWaterFallActivity.ParamsFollowingCircles) (bundle)).userId;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(k.bc_fragment_page_hot_topic, viewgroup, false);
        a(layoutinflater, viewgroup, null, Integer.valueOf(k.bc_view_footer));
        h = new c(getActivity(), g, s.longValue(), 2, u);
        h.c();
        a(viewgroup, true, false, false, null);
        a(viewgroup, 0, true);
        AccountManager.a(t);
        b();
        return viewgroup;
    }

    public void onDestroy()
    {
        AccountManager.b(t);
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (h != null)
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
