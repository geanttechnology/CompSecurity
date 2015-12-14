// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.z;
import com.cyberlink.beautycircle.controller.adapter.b;
import com.cyberlink.beautycircle.controller.adapter.f;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, x, TopBarFragment, h

public class PageFreeSampleListFragment extends g
{

    private EventListType s;
    private boolean t;
    private String u;
    private a v;
    private u w;
    private n x;

    public PageFreeSampleListFragment()
    {
        s = com.cyberlink.beautycircle.controller.fragment.EventListType.a;
        t = false;
        u = null;
        v = new a() {

            final PageFreeSampleListFragment a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = PageFreeSampleListFragment.this;
                super();
            }
        };
        w = new u() {

            final PageFreeSampleListFragment a;

            public void a()
            {
                e.b(new Object[] {
                    "mOnBrandEventChange"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = PageFreeSampleListFragment.this;
                super();
            }
        };
        x = new h() {

            final PageFreeSampleListFragment b;

            public void a()
            {
                super.a();
                if (b.h != null && b.h.getCount() == 1)
                {
                    Long long1 = ((Model)b.h.getItem(0)).b_();
                    android.support.v4.app.FragmentActivity fragmentactivity = b.getActivity();
                    if (long1 != null && fragmentactivity != null)
                    {
                        if (b.h instanceof b)
                        {
                            c.a(fragmentactivity, long1, null, null);
                            fragmentactivity.finish();
                        } else
                        if (b.h instanceof f)
                        {
                            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.k("click", Long.toString(long1.longValue())));
                            c.a(fragmentactivity, long1, "contest", false);
                            fragmentactivity.finish();
                            return;
                        }
                    }
                }
            }

            
            {
                b = PageFreeSampleListFragment.this;
                super(PageFreeSampleListFragment.this);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getActivity();
        if (bundle != null)
        {
            bundle = bundle.getIntent();
            if (bundle != null)
            {
                s = (EventListType)bundle.getSerializableExtra("eventListType");
                t = bundle.getBooleanExtra("IsFromDeepLink", false);
                u = bundle.getStringExtra("locale");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(k.bc_fragment_page_discover_userlist, viewgroup, false);
        a(layoutinflater, viewgroup, null, Integer.valueOf(k.bc_view_footer));
        layoutinflater = (BaseActivity)getActivity();
        if (t)
        {
            layoutinflater.b().a(0xc4000000, com.cyberlink.beautycircle.controller.fragment.x.a, com.cyberlink.beautycircle.controller.fragment.x.k, 0);
        }
        if (s == com.cyberlink.beautycircle.controller.fragment.EventListType.a)
        {
            layoutinflater.a(m.bc_freesample_title);
            h = new b(getActivity(), g, k.bc_view_item_free_sample_item, x, u);
        } else
        {
            layoutinflater.a(m.bc_contest_title);
            h = new f(getActivity(), g, k.bc_view_item_contest_item, x, u);
        }
        h.d(false);
        h.c();
        a(viewgroup, true, false, false, null);
        a(viewgroup, m.bc_freesample_list_empty, true);
        AccountManager.a(v);
        t.g.a(w);
        b();
        return viewgroup;
    }

    public void onDestroyView()
    {
        AccountManager.b(v);
        t.g.b(w);
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
        if (s == com.cyberlink.beautycircle.controller.fragment.EventListType.a)
        {
            com.perfectcorp.a.b.a(new z("FREE_SAMPLE"));
        } else
        if (s == com.cyberlink.beautycircle.controller.fragment.EventListType.b)
        {
            com.perfectcorp.a.b.a(new z("CONTEST"));
            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.k("pageshow", null));
            return;
        }
    }

    private class EventListType extends Enum
    {

        public static final EventListType a;
        public static final EventListType b;
        private static final EventListType c[];

        public static EventListType valueOf(String s1)
        {
            return (EventListType)Enum.valueOf(com/cyberlink/beautycircle/controller/fragment/PageFreeSampleListFragment$EventListType, s1);
        }

        public static EventListType[] values()
        {
            return (EventListType[])c.clone();
        }

        static 
        {
            a = new EventListType("FREE_SAMPLE", 0);
            b = new EventListType("CONTEST", 1);
            c = (new EventListType[] {
                a, b
            });
        }

        private EventListType(String s1, int i)
        {
            super(s1, i);
        }
    }

}
