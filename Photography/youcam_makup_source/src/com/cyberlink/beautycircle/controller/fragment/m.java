// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.adapter.h;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CampaignGroup;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DFPAdUtility;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, h, BottomBarFragment

public class m extends com.cyberlink.beautycircle.controller.fragment.e
{

    private SlideShowView A;
    private View B;
    private a C;
    private u D;
    private u E;
    private n F;
    protected android.view.View.OnClickListener s;
    private s t;
    private DFPAdUtility x;
    private ViewGroup y;
    private CampaignGroup z;

    public m()
    {
        t = null;
        B = null;
        s = new android.view.View.OnClickListener() {

            final m a;

            public void onClick(View view)
            {
                Globals.b("NOTIMPL");
            }

            
            {
                a = m.this;
                super();
            }
        };
        C = new a() {

            final m a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
                if (a.a && a.isResumed())
                {
                    com.cyberlink.beautycircle.controller.fragment.m.a(a);
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        D = new u() {

            final m a;

            public void a()
            {
                e.b(new Object[] {
                    "OnNewPost"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        E = new u() {

            final m a;

            public void a()
            {
                e.b(new Object[] {
                    "FollowChange"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        F = new com.cyberlink.beautycircle.controller.fragment.h(this);
    }

    static CampaignGroup a(m m1, CampaignGroup campaigngroup)
    {
        m1.z = campaigngroup;
        return campaigngroup;
    }

    static void a(m m1)
    {
        m1.p();
    }

    private void a(SlideShowView slideshowview)
    {
        if (slideshowview != null)
        {
            if (z != null && z.campaigns != null && !z.campaigns.isEmpty())
            {
                if (slideshowview.a())
                {
                    slideshowview.setCampaignGroup(z);
                    return;
                }
            } else
            {
                CampaignGroup.a("feed").a(new com.perfectcorp.utility.m(slideshowview) {

                    final SlideShowView a;
                    final m b;

                    public void a(int i)
                    {
                        a.setCampaignGroup(null);
                    }

                    public void a(CampaignGroup campaigngroup)
                    {
                        com.cyberlink.beautycircle.controller.fragment.m.a(b, campaigngroup);
                        a.setCampaignGroup(com.cyberlink.beautycircle.controller.fragment.m.b(b));
                    }

                    public void b(Object obj)
                    {
                        a((CampaignGroup)obj);
                    }

            
            {
                b = m.this;
                a = slideshowview;
                super();
            }
                });
                return;
            }
        }
    }

    static CampaignGroup b(m m1)
    {
        return m1.z;
    }

    private void p()
    {
        if (h != null && h.g)
        {
            h.c();
            z = null;
            a(A);
        }
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k, b);
        }
    }

    public void b(int i)
    {
        super.b(i);
        p();
        if (x != null)
        {
            x.a(true);
        }
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k);
        }
    }

    public void k()
    {
        super.k();
        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.m("feed"));
    }

    public long n()
    {
        if (h != null)
        {
            return ((h)h).d;
        } else
        {
            return 0L;
        }
    }

    public long o()
    {
        if (h != null)
        {
            return ((h)h).f;
        } else
        {
            return 0L;
        }
    }

    public void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
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
        viewgroup = layoutinflater.inflate(k.bc_fragment_page_feed, viewgroup, false);
        B = viewgroup.findViewById(com.cyberlink.beautycircle.j.search_btn);
        if (B != null)
        {
            B.setOnClickListener(new android.view.View.OnClickListener() {

                final m a;

                public void onClick(View view)
                {
                    c.a(a.getActivity(), true, null, false);
                }

            
            {
                a = m.this;
                super();
            }
            });
        }
        t = new s(com/cyberlink/beautycircle/controller/fragment/m);
        a(layoutinflater, viewgroup, Integer.valueOf(k.bc_view_header_feed), Integer.valueOf(k.bc_view_footer));
        A = (SlideShowView)i.findViewById(com.cyberlink.beautycircle.j.feed_header_post_ad_panel);
        y = (ViewGroup)i.findViewById(com.cyberlink.beautycircle.j.feed_header_post_ad_container);
        x = DFPAdUtility.a(com.cyberlink.beautycircle.utility.DFPAdUtility.DFPAdUnitId.a, y, getActivity());
        a(A);
        h = new h(getActivity(), g, k.bc_view_item_discover_list, t, F);
        h.d(false);
        h.c();
        b = viewgroup.findViewById(com.cyberlink.beautycircle.j.home_btn);
        a(viewgroup, false, true, true, "feed");
        a(viewgroup, 0, true);
        AccountManager.a(C);
        t.b.a(D);
        t.c.a(E);
        b();
        return viewgroup;
    }

    public void onDestroy()
    {
        AccountManager.b(C);
        t.b.b(D);
        t.c.b(E);
        if (x != null)
        {
            x.a(y);
        }
        if (t != null)
        {
            t.b();
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        if (x != null)
        {
            x.b();
        }
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
        p();
        if (x != null)
        {
            x.a();
        }
        a(g, k, b);
    }
}
