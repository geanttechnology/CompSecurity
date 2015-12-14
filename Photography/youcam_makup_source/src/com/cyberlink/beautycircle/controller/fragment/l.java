// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.bc;
import com.cyberlink.beautycircle.controller.a.i;
import com.cyberlink.beautycircle.controller.adapter.g;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CampaignGroup;
import com.cyberlink.beautycircle.model.DiscoverTabItem;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DFPAdUtility;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.d;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.DiscoverTabScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableHorizontalScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, h, BottomBarFragment

public class l extends com.cyberlink.beautycircle.controller.fragment.e
{

    private CampaignGroup A;
    private SlideShowView B;
    private DiscoverTabScrollView C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private View G;
    private View H;
    private ObservableHorizontalScrollView I;
    private d J;
    private boolean K;
    private n L;
    private a M;
    private u N;
    private u O;
    private u P;
    private android.view.View.OnClickListener Q;
    private android.view.View.OnClickListener R;
    private android.view.View.OnClickListener S;
    private android.view.View.OnClickListener T;
    private android.view.View.OnClickListener U;
    private android.view.View.OnClickListener V;
    private android.view.View.OnClickListener W;
    private android.view.View.OnClickListener X;
    public long s;
    public long t;
    private s x;
    private DFPAdUtility y;
    private ViewGroup z;

    public l()
    {
        x = null;
        y = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        s = 0L;
        t = 0L;
        K = false;
        L = new h(this);
        M = new a() {

            final l a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
                if (a.a && a.isResumed())
                {
                    com.cyberlink.beautycircle.controller.fragment.l.a(a);
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
        N = new u() {

            final l a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnNewPost"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
        O = new u() {

            final l a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "FollowChange"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
        P = new u() {

            final l a;

            public void a()
            {
                com.cyberlink.beautycircle.controller.fragment.l.b(a);
            }

            
            {
                a = l.this;
                super();
            }
        };
        Q = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g, null, null);
                com.perfectcorp.a.b.a(new i("beautyist"));
            }

            
            {
                a = l.this;
                super();
            }
        };
        R = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                l l1 = a;
                l1.s = l1.s + 1L;
                view = (com.cyberlink.beautycircle.utility.e)view;
                com.cyberlink.beautycircle.c.a(a.getActivity(), view.getCategoryDefautlType(), view.getCategoryId(), view.getCategoryType(), com.cyberlink.beautycircle.controller.fragment.l.d(a), false, false);
                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.n(Long.toString(view.getCategoryId().longValue())));
                if (view.getCategoryDefautlType().equals("HOW-TO"))
                {
                    view.a();
                    Globals.b();
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
        S = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.perfectcorp.a.b.a(new i("makeup_tips"));
                com.perfectcorp.a.b.a(new bc("beauty_circle"));
                if (!com.perfectcorp.utility.g.a(Globals.n().getApplicationContext(), "com.cyberlink.youcammakeup"))
                {
                    DialogUtils.a(a.getActivity());
                    return;
                }
                try
                {
                    Object obj = a.getResources().getString(com.cyberlink.beautycircle.m.bc_scheme2);
                    view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("ybc_ymk://").append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_host_makeup_tip)).toString()));
                    view.addCategory("android.intent.category.BROWSABLE");
                    obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(((String) (obj))).append("://").append(a.getResources().getString(com.cyberlink.beautycircle.m.bc_host_main)).toString()));
                    view.putExtra(a.getResources().getString(com.cyberlink.beautycircle.m.BACK_TARGET_INTENT), ((android.os.Parcelable) (obj)));
                    a.getActivity().startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    DialogUtils.a(a.getActivity());
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
        T = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f, null, null);
                com.perfectcorp.a.b.a(new i("brand"));
            }

            
            {
                a = l.this;
                super();
            }
        };
        U = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h, null, null);
                com.perfectcorp.a.b.a(new i("editorial"));
            }

            
            {
                a = l.this;
                super();
            }
        };
        V = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType.a, false, null);
                com.perfectcorp.a.b.a(new i("free_sample"));
            }

            
            {
                a = l.this;
                super();
            }
        };
        W = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                view = a;
                view.t = ((l) (view)).t + 1L;
                com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType.b, false, null);
                com.perfectcorp.a.b.a(new i("contest"));
            }

            
            {
                a = l.this;
                super();
            }
        };
        X = new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                DiscoverTabItem discovertabitem = (DiscoverTabItem)view.getTag();
                if (discovertabitem != null && discovertabitem.type != null)
                {
                    if (discovertabitem.type.equals("BEAUTYIST"))
                    {
                        com.cyberlink.beautycircle.controller.fragment.l.g(a).onClick(view);
                    } else
                    {
                        if (discovertabitem.type.equals("BRAND"))
                        {
                            l.h(a).onClick(view);
                            return;
                        }
                        if (discovertabitem.type.equals("BEAUTY_TIP"))
                        {
                            com.cyberlink.beautycircle.controller.fragment.l.i(a).onClick(view);
                            return;
                        }
                        if (discovertabitem.type.equals("EDITORIAL"))
                        {
                            com.cyberlink.beautycircle.controller.fragment.l.j(a).onClick(view);
                            return;
                        }
                        if (discovertabitem.type.equals("FREE_SAMPLE"))
                        {
                            com.cyberlink.beautycircle.controller.fragment.l.k(a).onClick(view);
                            return;
                        }
                        if (discovertabitem.type.equals("CONTEST"))
                        {
                            l.l(a).onClick(view);
                            return;
                        }
                    }
                }
            }

            
            {
                a = l.this;
                super();
            }
        };
    }

    static CampaignGroup a(l l1, CampaignGroup campaigngroup)
    {
        l1.A = campaigngroup;
        return campaigngroup;
    }

    static void a(l l1)
    {
        l1.r();
    }

    private void a(SlideShowView slideshowview)
    {
        if (slideshowview != null)
        {
            if (A != null && A.campaigns != null && !A.campaigns.isEmpty())
            {
                if (slideshowview.a())
                {
                    slideshowview.setCampaignGroup(A);
                    return;
                }
            } else
            {
                CampaignGroup.a("discover").a(new com.perfectcorp.utility.m(slideshowview) {

                    final SlideShowView a;
                    final l b;

                    public void a(int i1)
                    {
                        a.setCampaignGroup(null);
                    }

                    public void a(CampaignGroup campaigngroup)
                    {
                        com.cyberlink.beautycircle.controller.fragment.l.a(b, campaigngroup);
                        a.setCampaignGroup(com.cyberlink.beautycircle.controller.fragment.l.c(b));
                    }

                    public void b(Object obj)
                    {
                        a((CampaignGroup)obj);
                    }

            
            {
                b = l.this;
                a = slideshowview;
                super();
            }
                });
                return;
            }
        }
    }

    static boolean a(l l1, boolean flag)
    {
        l1.K = flag;
        return flag;
    }

    static void b(l l1)
    {
        l1.q();
    }

    static CampaignGroup c(l l1)
    {
        return l1.A;
    }

    static boolean d(l l1)
    {
        return l1.K;
    }

    static DiscoverTabScrollView e(l l1)
    {
        return l1.C;
    }

    static android.view.View.OnClickListener f(l l1)
    {
        return l1.X;
    }

    static android.view.View.OnClickListener g(l l1)
    {
        return l1.Q;
    }

    static android.view.View.OnClickListener h(l l1)
    {
        return l1.T;
    }

    static android.view.View.OnClickListener i(l l1)
    {
        return l1.S;
    }

    static android.view.View.OnClickListener j(l l1)
    {
        return l1.U;
    }

    static android.view.View.OnClickListener k(l l1)
    {
        return l1.V;
    }

    static android.view.View.OnClickListener l(l l1)
    {
        return l1.W;
    }

    private void p()
    {
        boolean flag = true;
        if (D == null || E == null || F == null)
        {
            return;
        }
        LinearLayout linearlayout;
        int i1;
        int j1;
        if (D.getVisibility() == 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (E.getVisibility() == 0)
        {
            i1 = j1 + 1;
        }
        j1 = i1;
        if (F.getVisibility() == 0)
        {
            j1 = i1 + 1;
        }
        if (j1 <= 2)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        linearlayout = D;
        if (i1 != 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        linearlayout.setOrientation(j1);
        linearlayout = E;
        if (i1 != 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        linearlayout.setOrientation(j1);
        linearlayout = F;
        if (i1 != 0)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        linearlayout.setOrientation(i1);
    }

    private void q()
    {
        (new j() {

            final l a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected ArrayList a(Void void1)
            {
                void1 = (DiscoverTabItem)Model.a(com/cyberlink/beautycircle/model/DiscoverTabItem, Globals.D().getString("BeautyOptoinList", ""));
                if (void1 == null)
                {
                    return null;
                } else
                {
                    return ((DiscoverTabItem) (void1)).tabList;
                }
            }

            
            {
                a = l.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final l a;

            protected void a(ArrayList arraylist)
            {
                if (arraylist != null && com.cyberlink.beautycircle.controller.fragment.l.e(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.l.e(a).a(arraylist, l.f(a));
                }
            }

            protected void b(Object obj)
            {
                a((ArrayList)obj);
            }

            
            {
                a = l.this;
                super();
            }
        });
    }

    private void r()
    {
        if (h != null && (h.g || h.i()))
        {
            h.d(false);
            h.c();
            A = null;
            a(B);
            if (J != null && h.g)
            {
                J.b();
            }
        }
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k, H);
        }
    }

    public void b(int i1)
    {
        boolean flag1 = true;
        boolean flag = false;
        super.b(i1);
        r();
        if (y != null)
        {
            y.a(true);
        }
        if (D != null)
        {
            LinearLayout linearlayout;
            if (AccountManager.a(AccountManager.a()))
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            linearlayout = D;
            if (i1 != 0)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            linearlayout.setVisibility(i1);
        }
        p();
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k);
        }
    }

    public void i()
    {
        super.i();
        if (J != null)
        {
            J.b();
        }
    }

    public void k()
    {
        super.k();
        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.m("discover"));
    }

    public long n()
    {
        if (h != null)
        {
            return ((g)h).d;
        } else
        {
            return 0L;
        }
    }

    public long o()
    {
        if (h != null)
        {
            return ((g)h).f;
        } else
        {
            return 0L;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
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
        viewgroup = layoutinflater.inflate(k.bc_fragment_page_discover, viewgroup, false);
        G = viewgroup.findViewById(com.cyberlink.beautycircle.j.search_btn);
        G.setOnClickListener(new android.view.View.OnClickListener() {

            final l a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a.getActivity(), true, null, false);
            }

            
            {
                a = l.this;
                super();
            }
        });
        x = new s(com/cyberlink/beautycircle/controller/fragment/l);
        a(layoutinflater, viewgroup, Integer.valueOf(k.bc_view_header_discover), Integer.valueOf(k.bc_view_footer));
        B = (SlideShowView)i.findViewById(com.cyberlink.beautycircle.j.bc_discover_ad_panel);
        z = (ViewGroup)i.findViewById(com.cyberlink.beautycircle.j.bc_discover_ad_container);
        y = DFPAdUtility.a(com.cyberlink.beautycircle.utility.DFPAdUtility.DFPAdUnitId.b, z, getActivity());
        H = viewgroup.findViewById(com.cyberlink.beautycircle.j.home_btn);
        a(viewgroup, false, true, true, "discover");
        C = (DiscoverTabScrollView)i.findViewById(com.cyberlink.beautycircle.j.bc_discover_tab_panel);
        q();
        I = (ObservableHorizontalScrollView)i.findViewById(com.cyberlink.beautycircle.j.bc_discover_category_list);
        I.setOnScrollChangeListener(new com.cyberlink.beautycircle.view.widgetpool.common.k() {

            final l a;

            public void a(ObservableHorizontalScrollView observablehorizontalscrollview, int i1)
            {
            }

            public void a(ObservableHorizontalScrollView observablehorizontalscrollview, int i1, int j1, int k1, int l1)
            {
                com.cyberlink.beautycircle.controller.fragment.l.a(a, true);
            }

            
            {
                a = l.this;
                super();
            }
        });
        J = new d(getActivity().getApplicationContext(), I, R);
        J.a();
        h = new g(getActivity(), g, k.bc_view_item_discover_list, x, L);
        ((g)h).a = true;
        AccountManager.a(M);
        t.b.a(N);
        t.c.a(O);
        t.f.a(P);
        b();
        return viewgroup;
    }

    public void onDestroy()
    {
        AccountManager.b(M);
        t.b.b(N);
        t.c.b(O);
        t.f.a(P);
        if (y != null)
        {
            y.a(z);
        }
        if (x != null)
        {
            x.b();
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        if (y != null)
        {
            y.b();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (h != null && h.j())
        {
            h.g = true;
            com.perfectcorp.utility.e.b(new Object[] {
                "Set ForcedRefresh by refresh expired."
            });
        }
        r();
        if (y != null)
        {
            y.a();
        }
        a(g, k, H);
    }
}
