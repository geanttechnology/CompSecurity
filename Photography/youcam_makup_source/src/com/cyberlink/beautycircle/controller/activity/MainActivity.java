// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aj;
import com.cyberlink.beautycircle.controller.a.al;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.au;
import com.cyberlink.beautycircle.controller.a.c;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.fragment.BottomBarFragment;
import com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment;
import com.cyberlink.beautycircle.controller.fragment.PageProductsFragment;
import com.cyberlink.beautycircle.controller.fragment.a;
import com.cyberlink.beautycircle.controller.fragment.f;
import com.cyberlink.beautycircle.controller.fragment.l;
import com.cyberlink.beautycircle.controller.fragment.m;
import com.cyberlink.beautycircle.controller.fragment.p;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.i;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            e, c, d

public class MainActivity extends BaseArcMenuActivity
{

    public static final UUID o = UUID.randomUUID();
    static int q = 0;
    private static int t = 5;
    private static long u = 2000L;
    private View A;
    private int B;
    private int C;
    private long D;
    private long E;
    private int F;
    private long G;
    private Boolean H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private android.view.View.OnClickListener M;
    private android.view.View.OnClickListener N;
    private android.view.View.OnClickListener O;
    private android.view.View.OnClickListener P;
    private boolean Q;
    private d R;
    private d S;
    private android.support.v4.view.ViewPager.OnPageChangeListener T;
    private a U;
    private android.view.View.OnClickListener V;
    private Runnable W;
    f p;
    protected android.view.View.OnLongClickListener r;
    public BroadcastReceiver s;
    private ArrayList v;
    private ViewPager w;
    private BottomBarFragment x;
    private boolean y;
    private View z;

    public MainActivity()
    {
        v = new ArrayList();
        w = null;
        x = null;
        y = false;
        C = 1;
        D = 0L;
        E = 0L;
        p = null;
        F = 0;
        G = 0L;
        H = null;
        I = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.perfectcorp.a.b.a(new aq("explore", ""));
                if (MainActivity.w().equals("ycn"))
                {
                    com.cyberlink.beautycircle.c.a(a, null, Long.valueOf(-1L), "NAILS", false, false, true);
                    a.finish();
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                    com.cyberlink.beautycircle.controller.activity.MainActivity.b(a, false);
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true, false);
                    return;
                }
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                com.cyberlink.beautycircle.c.a(a, 0, 0, 0);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        K = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                com.cyberlink.beautycircle.c.a(a, 2, 2, 0);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                com.cyberlink.beautycircle.c.a(a, 2, 5, 0);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        M = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                com.cyberlink.beautycircle.c.a(a, 2, 1, 0);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        N = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                view = new Dialog(a);
                view.requestWindowFeature(1);
                view.setContentView(k.bc_dialog_share_to_opt);
                view.findViewById(com.cyberlink.beautycircle.j.itemMore).setVisibility(8);
                ((TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_desc)).setText(com.cyberlink.beautycircle.m.bc_register_more);
                com.cyberlink.beautycircle.controller.adapter.j j1 = new com.cyberlink.beautycircle.controller.adapter.j(a);
                ListView listview = (ListView)view.findViewById(com.cyberlink.beautycircle.j.content_list);
                listview.setAdapter(j1);
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, view, j1) {

                    final Dialog a;
                    final com.cyberlink.beautycircle.controller.adapter.j b;
                    final _cls21 c;

                    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        a.dismiss();
                        Globals.a();
                        com.cyberlink.beautycircle.controller.activity.MainActivity.a(c.a, true);
                        adapterview = (com.cyberlink.beautycircle.model.a)b.getItem(i1);
                        if (((com.cyberlink.beautycircle.model.a) (adapterview)).b == com.cyberlink.beautycircle.m.bc_register_fb)
                        {
                            com.cyberlink.beautycircle.c.a(c.a, 0, 1, 0);
                        } else
                        {
                            if (((com.cyberlink.beautycircle.model.a) (adapterview)).b == com.cyberlink.beautycircle.m.bc_register_twitter)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 3, 0);
                                return;
                            }
                            if (((com.cyberlink.beautycircle.model.a) (adapterview)).b == com.cyberlink.beautycircle.m.bc_register_weibo)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 2, 0);
                                return;
                            }
                            if (((com.cyberlink.beautycircle.model.a) (adapterview)).b == com.cyberlink.beautycircle.m.bc_register_qq)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 4, 0);
                                return;
                            }
                            if (((com.cyberlink.beautycircle.model.a) (adapterview)).b == com.cyberlink.beautycircle.m.bc_register_wechat)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 5, 0);
                                return;
                            }
                        }
                    }

            
            {
                c = _pcls21;
                a = dialog;
                b = j1;
                super();
            }
                });
                view.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
                view.show();
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        O = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                com.cyberlink.beautycircle.c.a(a, 1, 0, 0);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        P = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                long l1 = System.currentTimeMillis();
                if (l1 - com.cyberlink.beautycircle.controller.activity.MainActivity.c(a) > MainActivity.x())
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, 1);
                } else
                {
                    MainActivity.d(a);
                }
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, l1);
                if (com.cyberlink.beautycircle.controller.activity.MainActivity.e(a) >= MainActivity.y())
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, 0);
                    Globals.a(String.format(Locale.getDefault(), "Beauty Circle Version: (%s)", new Object[] {
                        a.getString(com.cyberlink.beautycircle.m.BC_BUILD_NUMBER)
                    }), 1);
                }
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        Q = false;
        R = new d() {

            final MainActivity a;

            public void a()
            {
                a.m();
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        S = new d() {

            final MainActivity a;

            public void a()
            {
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        T = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final MainActivity a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                if (com.cyberlink.beautycircle.controller.activity.MainActivity.f(a) != com.cyberlink.beautycircle.controller.activity.MainActivity.g(a))
                {
                    MainActivity.h(a);
                    com.cyberlink.beautycircle.controller.activity.MainActivity.b(a, com.cyberlink.beautycircle.controller.activity.MainActivity.g(a));
                }
                if (i1 >= 0 && i1 < com.cyberlink.beautycircle.controller.activity.MainActivity.i(a).size())
                {
                    int j1 = 0;
                    while (j1 < com.cyberlink.beautycircle.controller.activity.MainActivity.i(a).size()) 
                    {
                        Object obj = (com.cyberlink.beautycircle.controller.activity.e)com.cyberlink.beautycircle.controller.activity.MainActivity.i(a).get(j1);
                        if (obj != null)
                        {
                            if (i1 == j1)
                            {
                                BottomBarFragment bottombarfragment = a.u();
                                if (bottombarfragment != null)
                                {
                                    bottombarfragment.a(((com.cyberlink.beautycircle.controller.activity.e) (obj)).a);
                                    bottombarfragment.a();
                                }
                                if (((com.cyberlink.beautycircle.controller.activity.e) (obj)).c != null)
                                {
                                    ((com.cyberlink.beautycircle.controller.activity.e) (obj)).c.a();
                                }
                                obj = ((com.cyberlink.beautycircle.controller.activity.e) (obj)).a();
                                ((f) (obj)).a(i1);
                                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, a.p);
                                a.p = ((f) (obj));
                                com.cyberlink.beautycircle.controller.activity.MainActivity.j(a);
                            } else
                            {
                                ((com.cyberlink.beautycircle.controller.activity.e) (obj)).a().f();
                            }
                        }
                        j1++;
                    }
                }
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        U = new a() {

            final MainActivity a;

            public boolean a(com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab tab)
            {
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, false, false);
                if (!com.cyberlink.beautycircle.controller.activity.MainActivity.k(a).isEnabled())
                {
                    return false;
                }
                if (tab.name().equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.d.toString()) || tab.name().equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.e.toString()))
                {
                    aq.c = tab.name();
                }
                int i1 = 0;
                do
                {
label0:
                    {
                        if (i1 < com.cyberlink.beautycircle.controller.activity.MainActivity.i(a).size())
                        {
                            if (((com.cyberlink.beautycircle.controller.activity.e)com.cyberlink.beautycircle.controller.activity.MainActivity.i(a).get(i1)).a != tab)
                            {
                                break label0;
                            }
                            com.cyberlink.beautycircle.controller.activity.MainActivity.c(a, i1);
                            com.cyberlink.beautycircle.controller.activity.MainActivity.k(a).setCurrentItem(i1);
                        }
                        return true;
                    }
                    i1++;
                } while (true);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        V = new android.view.View.OnClickListener() {

            final MainActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, false, false);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        r = new android.view.View.OnLongClickListener() {

            final MainActivity a;

            public boolean onLongClick(View view)
            {
                MainActivity.q++;
                if (MainActivity.q >= 3)
                {
                    MainActivity.q = 0;
                    a.v();
                }
                return false;
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        W = new Runnable() {

            final MainActivity a;

            public void run()
            {
                com.cyberlink.beautycircle.controller.activity.MainActivity.l(a);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
        s = new BroadcastReceiver() {

            final MainActivity a;

            public void onReceive(Context context, Intent intent)
            {
                if (!com.cyberlink.beautycircle.model.network.c.a())
                {
                    a.a(context.getString(com.cyberlink.beautycircle.m.bc_server_connect_fail), true);
                    return;
                } else
                {
                    a.m();
                    return;
                }
            }

            
            {
                a = MainActivity.this;
                super();
            }
        };
    }

    private void A()
    {
        Iterator iterator = v.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.cyberlink.beautycircle.controller.activity.e e1 = (com.cyberlink.beautycircle.controller.activity.e)iterator.next();
            if (e1.b() && e1.a().isAdded())
            {
                e1.a().e();
            }
        } while (true);
    }

    private void B()
    {
        String s1;
        long l5;
        long l6;
        long l7;
        long l8;
        long l9;
        long l10;
        if (v.size() == 0)
        {
            return;
        }
        l9 = System.currentTimeMillis();
        l10 = D;
        s1 = null;
        l7 = 0L;
        l5 = 0L;
        l6 = 0L;
        l8 = 0L;
        if (C != com.cyberlink.beautycircle.controller.activity.TabPage.b.index) goto _L2; else goto _L1
_L1:
        long l1;
        long l2;
        long l3;
        long l4;
        s1 = "FeedPage";
        l1 = ((m)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).n();
        l2 = ((m)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).o();
        l4 = l6;
        l3 = l5;
_L4:
        boolean flag = x.a;
        x.a = false;
        if (s1 != null)
        {
            com.perfectcorp.a.b.a(new au(s1, l9 - l10, l1, l3, l4, flag, l2));
        }
        D = System.currentTimeMillis();
        return;
_L2:
        if (C == com.cyberlink.beautycircle.controller.activity.TabPage.c.index)
        {
            s1 = "DiscoverPage";
            l1 = ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).n();
            l3 = ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).s;
            l4 = ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).t;
            l2 = ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).o();
            ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).s = 0L;
            ((l)((com.cyberlink.beautycircle.controller.activity.e)v.get(C)).a()).t = 0L;
        } else
        {
            l1 = l7;
            l3 = l5;
            l4 = l6;
            l2 = l8;
            if (C == TabPage.d.index)
            {
                s1 = "ProductPage";
                l1 = l7;
                l3 = l5;
                l4 = l6;
                l2 = l8;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void C()
    {
        if (B == com.cyberlink.beautycircle.controller.activity.TabPage.b.index)
        {
            s.a = "bc_feed";
        } else
        if (B == com.cyberlink.beautycircle.controller.activity.TabPage.c.index)
        {
            s.a = "bc_discover";
            return;
        }
    }

    private void D()
    {
        Globals.f().a(new j() {

            final MainActivity a;

            protected Boolean a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    try
                    {
                        AccountManager.a(false, true, Globals.c()).d();
                    }
                    catch (CancellationException cancellationexception)
                    {
                        cancellationexception.printStackTrace();
                        return boolean1;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                        return boolean1;
                    }
                    catch (ExecutionException executionexception)
                    {
                        executionexception.printStackTrace();
                        return boolean1;
                    }
                }
                return boolean1;
            }

            protected volatile Object a(Object obj)
            {
                return a((Boolean)obj);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        }).a(new com.perfectcorp.utility.m() {

            final MainActivity a;

            protected void a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    Globals.a(String.format(Locale.getDefault(), a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_success), new Object[] {
                        Globals.e()
                    }));
                } else
                {
                    Globals.a(String.format(Locale.getDefault(), a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_change_webserver_fail), new Object[] {
                        Globals.e()
                    }));
                }
                com.cyberlink.beautycircle.controller.activity.MainActivity.b(a);
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = MainActivity.this;
                super();
            }
        });
    }

    static int a(MainActivity mainactivity, int i1)
    {
        mainactivity.F = i1;
        return i1;
    }

    static long a(MainActivity mainactivity, long l1)
    {
        mainactivity.G = l1;
        return l1;
    }

    static void a(MainActivity mainactivity)
    {
        mainactivity.z();
    }

    static void a(MainActivity mainactivity, Bundle bundle)
    {
        mainactivity.e(bundle);
    }

    static void a(MainActivity mainactivity, f f1)
    {
        mainactivity.a(f1);
    }

    static void a(MainActivity mainactivity, boolean flag, boolean flag1)
    {
        mainactivity.a(flag, flag1);
    }

    private void a(f f1)
    {
        Long long1;
        if (p == null)
        {
            p = f1;
            return;
        }
        long1 = Long.valueOf(System.currentTimeMillis());
        if (!(p instanceof m)) goto _L2; else goto _L1
_L1:
        com.perfectcorp.a.b.a(new aj("feed", Long.valueOf(E), long1));
_L4:
        p = f1;
        E = System.currentTimeMillis();
        return;
_L2:
        if (p instanceof l)
        {
            com.perfectcorp.a.b.a(new aj("discover", Long.valueOf(E), long1));
        } else
        if (p instanceof PageProductsFragment)
        {
            com.perfectcorp.a.b.a(new aj("product", Long.valueOf(E), long1));
        } else
        if (p instanceof PageNotificationsFragment)
        {
            com.perfectcorp.a.b.a(new aj("notification", Long.valueOf(E), long1));
        } else
        if (p instanceof p)
        {
            com.perfectcorp.a.b.a(new aj("me", Long.valueOf(E), long1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(boolean flag)
    {
        RelativeLayout relativelayout;
label0:
        {
label1:
            {
label2:
                {
                    relativelayout = (RelativeLayout)findViewById(com.cyberlink.beautycircle.j.bc_welcom_layout);
                    if (!flag)
                    {
                        break label0;
                    }
                    com.perfectcorp.a.b.a(new al());
                    relativelayout.setVisibility(0);
                    if (z == null)
                    {
                        z = getLayoutInflater().inflate(k.bc_activity_welcome, relativelayout);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_explore).setOnClickListener(I);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_email_login).setOnClickListener(J);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_weibo_login).setOnClickListener(K);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_weibo_more).setOnClickListener(N);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_wechat_login).setOnClickListener(L);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_wechat_more).setOnClickListener(N);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_fb_login).setOnClickListener(M);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_fb_more).setOnClickListener(N);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_have_an_account).setOnClickListener(O);
                        z.findViewById(com.cyberlink.beautycircle.j.bc_welcome_desc_text).setOnLongClickListener(r);
                        if (!Locale.getDefault().equals(Locale.CHINA))
                        {
                            break label1;
                        }
                        findViewById(com.cyberlink.beautycircle.j.bc_fb_login_panel).setVisibility(8);
                        if (!Globals.s().equals("YCN"))
                        {
                            break label2;
                        }
                        findViewById(com.cyberlink.beautycircle.j.bc_weibo_login_panel).setVisibility(8);
                    }
                    return;
                }
                findViewById(com.cyberlink.beautycircle.j.bc_wechat_login_panel).setVisibility(8);
                return;
            }
            findViewById(com.cyberlink.beautycircle.j.bc_weibo_login_panel).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_wechat_login_panel).setVisibility(8);
            return;
        }
        z();
        relativelayout.setVisibility(8);
    }

    private void a(boolean flag, boolean flag1)
    {
        RelativeLayout relativelayout = (RelativeLayout)findViewById(com.cyberlink.beautycircle.j.bc_guideline_layout);
        if (flag)
        {
            relativelayout.setVisibility(0);
            relativelayout.setOnClickListener(V);
            if (A == null)
            {
                A = getLayoutInflater().inflate(k.bc_view_guideline, relativelayout);
            }
            return;
        } else
        {
            relativelayout.setVisibility(8);
            relativelayout.setOnClickListener(null);
            return;
        }
    }

    static boolean a(MainActivity mainactivity, boolean flag)
    {
        mainactivity.y = flag;
        return flag;
    }

    static int b(MainActivity mainactivity, int i1)
    {
        mainactivity.C = i1;
        return i1;
    }

    static void b(MainActivity mainactivity)
    {
        mainactivity.A();
    }

    static void b(MainActivity mainactivity, boolean flag)
    {
        mainactivity.a(flag);
    }

    static int c(MainActivity mainactivity, int i1)
    {
        mainactivity.B = i1;
        return i1;
    }

    static long c(MainActivity mainactivity)
    {
        return mainactivity.G;
    }

    static int d(MainActivity mainactivity)
    {
        int i1 = mainactivity.F;
        mainactivity.F = i1 + 1;
        return i1;
    }

    private void d(Bundle bundle)
    {
        (new AsyncTask(bundle) {

            final Bundle a;
            final MainActivity b;

            protected transient Integer a(Void avoid[])
            {
label0:
                {
                    avoid = Integer.valueOf(0);
                    if (Globals.n.booleanValue())
                    {
                        if (AccountManager.b() != null || !Globals.k)
                        {
                            break label0;
                        }
                        if (Globals.k && Globals.l)
                        {
                            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.a("BC_welcome_page_0819"));
                        }
                        avoid = Integer.valueOf(2);
                        aq.c = "welcome_page";
                    }
                    return avoid;
                }
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, true);
                Globals.a();
                return Integer.valueOf(1);
            }

            protected void a(Integer integer)
            {
                if (integer.intValue() == 2)
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.b(b, true);
                } else
                if (integer.intValue() == 1)
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(b);
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, true, false);
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.MainActivity.a(b);
                }
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, a);
                com.cyberlink.beautycircle.controller.activity.MainActivity.b(b);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Integer)obj);
            }

            
            {
                b = MainActivity.this;
                a = bundle;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    static int e(MainActivity mainactivity)
    {
        return mainactivity.F;
    }

    private void e(Bundle bundle)
    {
        ((RelativeLayout)findViewById(com.cyberlink.beautycircle.j.bc_main_layout)).setVisibility(0);
        v.clear();
        v = new ArrayList();
        v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.a, com/cyberlink/beautycircle/controller/fragment/m, S, bundle));
        v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.b, com/cyberlink/beautycircle/controller/fragment/l, S, bundle));
        H = Boolean.valueOf(AccountManager.n());
        if (H.booleanValue())
        {
            v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.c, com/cyberlink/beautycircle/controller/fragment/PageProductsFragment, R, bundle));
        }
        v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.d, com/cyberlink/beautycircle/controller/fragment/PageNotificationsFragment, S, bundle));
        v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.e, com/cyberlink/beautycircle/controller/fragment/p, S, bundle));
        w = (ViewPager)findViewById(com.cyberlink.beautycircle.j.main_view_pager);
        if (w != null)
        {
            w.setOffscreenPageLimit(4);
            w.setAdapter(new com.cyberlink.beautycircle.controller.activity.c(this, getSupportFragmentManager()));
            w.setOnPageChangeListener(T);
        }
        u();
        int i1;
        if (bundle != null)
        {
            i1 = bundle.getInt("CurTabIdx", com.cyberlink.beautycircle.controller.activity.TabPage.a.index);
        } else
        {
            i1 = com.cyberlink.beautycircle.controller.activity.TabPage.a.index;
        }
        B = i1;
        if (B == com.cyberlink.beautycircle.controller.activity.TabPage.a.index)
        {
            Object obj = (TabPage)getIntent().getSerializableExtra("TabPage");
            if (obj != null)
            {
                B = ((TabPage) (obj)).index;
            } else
            {
                B = 1;
            }
        }
        T.onPageSelected(B);
        w.setCurrentItem(B);
        obj = findViewById(com.cyberlink.beautycircle.j.home_secret_btn);
        if (obj != null)
        {
            ((View) (obj)).setOnClickListener(P);
        }
        f(bundle);
        b(bundle);
    }

    static int f(MainActivity mainactivity)
    {
        return mainactivity.C;
    }

    private void f(Bundle bundle)
    {
        if (Globals.i())
        {
            c(bundle);
            a(getString(com.cyberlink.beautycircle.m.bc_developmode_text), 3000);
            (new AsyncTask() {

                final MainActivity a;

                protected transient String a(Void avoid[])
                {
                    return AccountManager.b();
                }

                protected void a(String s1)
                {
                    if (s1 == null)
                    {
                        Globals.b((new StringBuilder()).append("No Log-in, Locale(").append(AccountManager.a()).append(")").toString());
                        return;
                    }
                    UserInfo userinfo = AccountManager.d();
                    String s2 = "";
                    s1 = s2;
                    if (userinfo != null)
                    {
                        s1 = s2;
                        if (userinfo.displayName != null)
                        {
                            s1 = userinfo.displayName;
                        }
                    }
                    Globals.b((new StringBuilder()).append("Log-in(").append(s1).append("), Locale(").append(AccountManager.a()).append(")").toString());
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((String)obj);
                }

            
            {
                a = MainActivity.this;
                super();
            }
            }).executeOnExecutor(j.q, new Void[0]);
        }
    }

    static int g(MainActivity mainactivity)
    {
        return mainactivity.B;
    }

    static void h(MainActivity mainactivity)
    {
        mainactivity.B();
    }

    static ArrayList i(MainActivity mainactivity)
    {
        return mainactivity.v;
    }

    static void j(MainActivity mainactivity)
    {
        mainactivity.C();
    }

    static ViewPager k(MainActivity mainactivity)
    {
        return mainactivity.w;
    }

    static void l(MainActivity mainactivity)
    {
        mainactivity.D();
    }

    static Runnable m(MainActivity mainactivity)
    {
        return mainactivity.W;
    }

    static String w()
    {
        return d;
    }

    static long x()
    {
        return u;
    }

    static int y()
    {
        return t;
    }

    private void z()
    {
label0:
        {
            if (Globals.l && !Globals.m)
            {
                Globals.m = true;
                if (!Globals.k)
                {
                    break label0;
                }
                com.perfectcorp.a.b.a(new c("A", "BC_welcome_page_0819"));
            }
            return;
        }
        com.perfectcorp.a.b.a(new c("B", "BC_welcome_page_0819"));
    }

    public void a(int i1, boolean flag)
    {
        if (w != null)
        {
            w.setCurrentItem(i1, flag);
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        int i1 = w.getCurrentItem();
        if (i1 >= 0 && i1 < v.size())
        {
            return ((com.cyberlink.beautycircle.controller.activity.e)v.get(i1)).a().a(motionevent);
        } else
        {
            return false;
        }
    }

    public void c(Bundle bundle)
    {
        if (!Q)
        {
            Q = true;
            v.add(new com.cyberlink.beautycircle.controller.activity.e(this, com.cyberlink.beautycircle.controller.fragment.BottomBarFragment.Tab.f, com/cyberlink/beautycircle/controller/fragment/k, S, bundle));
            w.getAdapter().notifyDataSetChanged();
            if (u() != null)
            {
                u().c();
            }
        }
    }

    protected boolean e()
    {
        if (A != null && A.getVisibility() == 0)
        {
            A.performClick();
        } else
        {
            if (!v.isEmpty())
            {
                ((com.cyberlink.beautycircle.controller.activity.e)v.get(0)).a().g();
            }
            super.e();
        }
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR lookupswitch 3: default 44
    //                   48144: 99
    //                   48157: 147
    //                   48165: 185;
           goto _L1 _L2 _L3 _L4
_L1:
        if (w != null)
        {
            int k1 = w.getCurrentItem();
            if (k1 >= 0 && k1 < v.size())
            {
                ((com.cyberlink.beautycircle.controller.activity.e)v.get(k1)).a().onActivityResult(i1, j1, intent);
            }
        }
        return;
_L2:
        if (y)
        {
            boolean flag;
            if (48256 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                y = false;
                a(true, flag);
            }
        }
        a(false);
        continue; /* Loop/switch isn't completed */
_L3:
        if (j1 == 48256)
        {
            a(intent);
            if (intent != null)
            {
                BCTileImage.a((Post)Model.a(com/cyberlink/beautycircle/model/Post, intent.getStringExtra("ShareInPost")));
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 == -1)
        {
            a(intent);
            if (intent != null)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "SearchPost result: ", (Post)Model.a(com/cyberlink/beautycircle/model/Post, intent.getStringExtra("Post"))
                });
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_main);
        AccountManager.l();
        d(bundle);
        com.cyberlink.beautycircle.model.network.c.a(this, s);
        D = System.currentTimeMillis();
    }

    protected void onDestroy()
    {
        B();
        com.cyberlink.beautycircle.model.network.c.b(this, s);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode = (com.cyberlink.beautycircle.model.MeTabItem.MeListMode)intent.getSerializableExtra("ListMode");
        if (melistmode != null)
        {
            Bundle bundle = new Bundle();
            bundle.putSerializable("ListMode", melistmode);
            a(bundle);
        }
        intent = (TabPage)intent.getSerializableExtra("TabPage");
        if (intent != null && ((TabPage) (intent)).index != B)
        {
            B = ((TabPage) (intent)).index;
            T.onPageSelected(B);
            w.setCurrentItem(B);
        }
    }

    protected void onPause()
    {
        a(p);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        C();
        boolean flag = AccountManager.n();
        if (H != null && H.booleanValue() != flag)
        {
            overridePendingTransition(0, 0);
            finish();
            com.cyberlink.beautycircle.c.a(this, (TabPage)null);
        } else
        {
            E = System.currentTimeMillis();
            A();
            if (z != null && z.getVisibility() == 0)
            {
                (new AsyncTask() {

                    final MainActivity a;

                    protected transient Boolean a(Void avoid[])
                    {
                        boolean flag1;
                        if (AccountManager.b() != null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag1)
                        {
                            com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true);
                            Globals.a();
                        }
                        return Boolean.valueOf(flag1);
                    }

                    protected void a(Boolean boolean1)
                    {
                        if (boolean1.booleanValue())
                        {
                            com.cyberlink.beautycircle.controller.activity.MainActivity.b(a, false);
                            com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, true, false);
                        } else
                        if (Globals.n.booleanValue() && AccountManager.b() == null && Globals.k)
                        {
                            com.cyberlink.beautycircle.controller.activity.MainActivity.b(a, true);
                            return;
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((Boolean)obj);
                    }

            
            {
                a = MainActivity.this;
                super();
            }
                }).executeOnExecutor(j.q, new Void[0]);
                return;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (v != null)
        {
            Iterator iterator = v.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.cyberlink.beautycircle.controller.activity.e e1 = (com.cyberlink.beautycircle.controller.activity.e)iterator.next();
                if (e1.b() && e1.a().isAdded())
                {
                    getSupportFragmentManager().putFragment(bundle, e1.b.getName(), e1.a());
                }
            } while (true);
        }
        if (w != null)
        {
            B = w.getCurrentItem();
            bundle.putInt("CurTabIdx", w.getCurrentItem());
        }
    }

    public com.cyberlink.beautycircle.controller.fragment.e r()
    {
        int i1 = w.getCurrentItem();
        if (i1 >= 0 && i1 < v.size())
        {
            return (com.cyberlink.beautycircle.controller.fragment.e)((com.cyberlink.beautycircle.controller.activity.e)v.get(i1)).a();
        } else
        {
            return null;
        }
    }

    public BottomBarFragment u()
    {
        if (x == null)
        {
            x = (BottomBarFragment)getFragmentManager().findFragmentById(com.cyberlink.beautycircle.j.fragment_bottombar_panel);
            if (x != null)
            {
                x.a(U);
            }
        }
        View view = findViewById(com.cyberlink.beautycircle.j.fragment_bottombar_shadow);
        if (view != null)
        {
            int i1;
            if (x != null)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        return x;
    }

    public void v()
    {
        String as[] = com.cyberlink.beautycircle.model.network.i.a();
        String s1 = Globals.c();
        int i1 = Arrays.asList(as).indexOf(s1);
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(this)).setTitle("Change Server and Logout").setSingleChoiceItems(as, i1, null).setPositiveButton(com.cyberlink.beautycircle.m.bc_dialog_button_yes, new android.content.DialogInterface.OnClickListener(i1, as) {

            final int a;
            final String b[];
            final MainActivity c;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                dialoginterface.dismiss();
                j1 = ((AlertDialog)dialoginterface).getListView().getCheckedItemPosition();
                if (j1 != a)
                {
                    Globals.a((String)Arrays.asList(b).get(j1));
                    com.cyberlink.beautycircle.controller.activity.MainActivity.m(c).run();
                }
            }

            
            {
                c = MainActivity.this;
                a = i1;
                b = as;
                super();
            }
        }).setNegativeButton(com.cyberlink.beautycircle.m.bc_dialog_button_no, null).create();
        alertdialog.show();
        Globals.a(alertdialog, getResources().getColor(g.bc_color_main_style));
    }


    private class TabPage extends Enum
    {

        public static final TabPage a;
        public static final TabPage b;
        public static final TabPage c;
        public static final TabPage d;
        public static final TabPage e;
        public static final TabPage f;
        public static final TabPage g;
        private static final TabPage h[];
        public final int index;

        public static TabPage valueOf(String s1)
        {
            return (TabPage)Enum.valueOf(com/cyberlink/beautycircle/controller/activity/MainActivity$TabPage, s1);
        }

        public static TabPage[] values()
        {
            return (TabPage[])h.clone();
        }

        static 
        {
            a = new TabPage("INVALID", 0, -1);
            b = new TabPage("FEED", 1, 0);
            c = new TabPage("DISCOVERY", 2, 1);
            d = new TabPage("PRODUCTS", 3, 2);
            e = new TabPage("NOTIFICATIONS", 4, 3);
            f = new TabPage("ME", 5, 4);
            g = new TabPage("DEVELOPER", 6, 5);
            h = (new TabPage[] {
                a, b, c, d, e, f, g
            });
        }

        private TabPage(String s1, int i1, int j1)
        {
            super(s1, i1);
            index = j1;
        }
    }

}
