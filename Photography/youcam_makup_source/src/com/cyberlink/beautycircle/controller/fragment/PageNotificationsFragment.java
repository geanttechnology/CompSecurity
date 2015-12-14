// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.ae;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.adapter.k;
import com.cyberlink.beautycircle.controller.adapter.l;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.t;
import com.cyberlink.beautycircle.model.NotificationList;
import com.cyberlink.beautycircle.model.NotificationNew;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.cyberlink.you.u;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            t, BottomBarFragment, h

public class PageNotificationsFragment extends com.cyberlink.beautycircle.controller.fragment.t
{

    private View A;
    private TextView B;
    private TextView C;
    private TextView D;
    private boolean E;
    private boolean F;
    private View G;
    private View H;
    private View I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private View N;
    private k O;
    private t P;
    private l Q;
    private h R;
    private a S;
    private com.cyberlink.beautycircle.utility.u T;
    private android.view.View.OnClickListener U;
    private android.view.View.OnClickListener V;
    private android.view.View.OnClickListener W;
    private android.view.View.OnClickListener X;
    private int s;
    private int t;
    private int x;
    private View y;
    private View z;

    public PageNotificationsFragment()
    {
        s = 0;
        t = 1;
        x = 2;
        E = false;
        F = false;
        G = null;
        H = null;
        I = null;
        J = s;
        K = false;
        L = false;
        M = false;
        N = null;
        Q = new l() {

            final PageNotificationsFragment a;

            public void a()
            {
            }

            public void a(int i1)
            {
            }

            public void a(Post post)
            {
            }

            public void a(String s1, Date date)
            {
                a.a(false);
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, s1);
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, s1, date);
            }

            public void a(boolean flag)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, flag);
            }

            public void b(boolean flag)
            {
                a.b(flag);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        R = new h() {

            final PageNotificationsFragment b;

            public void a(boolean flag)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(b, flag);
            }

            
            {
                b = PageNotificationsFragment.this;
                super(PageNotificationsFragment.this);
            }
        };
        S = new a() {

            final PageNotificationsFragment a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                userinfo = AccountManager.b();
                if (userinfo == null || userinfo.isEmpty() || com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.b(a) && !PageNotificationsFragment.c(a)) goto _L2; else goto _L1
_L1:
                PageNotificationsFragment.d(a);
                a.d(false);
_L4:
                if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).g = true;
                }
                if (PageNotificationsFragment.f(a) != null)
                {
                    PageNotificationsFragment.f(a).g = true;
                }
                if (PageNotificationsFragment.c(a))
                {
                    PageNotificationsFragment.c(a, false);
                }
                if (a.a && a.isResumed())
                {
                    PageNotificationsFragment.g(a);
                }
                return;
_L2:
                if (userinfo == null || userinfo.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).e();
                    }
                    if (PageNotificationsFragment.f(a) != null)
                    {
                        PageNotificationsFragment.f(a).e();
                    }
                    com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.b(a, false);
                    a.d(true);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        T = new com.cyberlink.beautycircle.utility.u() {

            final PageNotificationsFragment a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    ""
                });
                PageNotificationsFragment.c(a, true);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        U = new android.view.View.OnClickListener() {

            final PageNotificationsFragment a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, PageNotificationsFragment.h(a));
                if (a.h != com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a))
                {
                    a.h = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a);
                    a.h.c(a.g);
                }
                if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) == null || com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).a("Friend"))
                {
                    return;
                }
                view = a;
                boolean flag;
                if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).getCount() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(view, flag);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        V = new android.view.View.OnClickListener() {

            final PageNotificationsFragment a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, PageNotificationsFragment.i(a));
                if (a.h != com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a))
                {
                    a.h = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a);
                    a.h.c(a.g);
                }
                if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a) == null || com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).a("You"))
                {
                    return;
                }
                view = a;
                boolean flag;
                if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.e(a).getCount() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(view, flag);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        W = new android.view.View.OnClickListener() {

            final PageNotificationsFragment a;

            public void onClick(View view)
            {
                boolean flag;
label0:
                {
                    flag = false;
                    com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.j(a));
                    if (a.h != PageNotificationsFragment.f(a))
                    {
                        a.h = PageNotificationsFragment.f(a);
                        a.h.c(a.g);
                    }
                    if (PageNotificationsFragment.f(a) != null)
                    {
                        if (!PageNotificationsFragment.f(a).i() && !PageNotificationsFragment.f(a).g)
                        {
                            break label0;
                        }
                        PageNotificationsFragment.f(a).d(false);
                        PageNotificationsFragment.f(a).c();
                    }
                    return;
                }
                view = a;
                if (PageNotificationsFragment.f(a).getCount() == 0)
                {
                    flag = true;
                }
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(view, flag);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
        X = new android.view.View.OnClickListener() {

            final PageNotificationsFragment a;

            public void onClick(View view)
            {
                view = new Intent(a.getActivity(), com/cyberlink/you/activity/ChatDialogActivity);
                view.putExtra("createNewMessage", true);
                a.startActivity(view);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        };
    }

    static View a(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.z;
    }

    private void a()
    {
        (new j() {

            final PageNotificationsFragment a;

            protected Boolean a(Void void1)
            {
                void1 = AccountManager.b();
                boolean flag;
                if (void1 != null && !void1.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final PageNotificationsFragment a;

            protected void a(Boolean boolean1)
            {
                PageNotificationsFragment.d(a, boolean1.booleanValue());
                if (boolean1.booleanValue())
                {
                    a.d(false);
                    com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.k(a);
                    return;
                } else
                {
                    a.d(true);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        });
    }

    private void a(View view)
    {
        view = AccountManager.b();
        u.a(getActivity(), view);
        u.a(getActivity().getApplication());
    }

    static void a(PageNotificationsFragment pagenotificationsfragment, int l)
    {
        pagenotificationsfragment.c(l);
    }

    static void a(PageNotificationsFragment pagenotificationsfragment, NotificationNew notificationnew)
    {
        pagenotificationsfragment.a(notificationnew);
    }

    static void a(PageNotificationsFragment pagenotificationsfragment, String s1)
    {
        pagenotificationsfragment.a(s1);
    }

    static void a(PageNotificationsFragment pagenotificationsfragment, String s1, Date date)
    {
        pagenotificationsfragment.a(s1, date);
    }

    static void a(PageNotificationsFragment pagenotificationsfragment, boolean flag)
    {
        pagenotificationsfragment.e(flag);
    }

    private void a(NotificationNew notificationnew)
    {
        if (notificationnew != null && (notificationnew.countFriend > 0L || notificationnew.countYou > 0L))
        {
            f(true);
            if (notificationnew.countFriend > 0L && G != null)
            {
                E = true;
                G.setVisibility(0);
            }
            if (notificationnew.countYou > 0L && H != null)
            {
                F = true;
                H.setVisibility(0);
                return;
            }
        }
    }

    private void a(String s1)
    {
        if (s1 != null)
        {
            if (s1.equals("Friend"))
            {
                E = false;
                return;
            }
            if (s1.equals("You"))
            {
                F = false;
                return;
            }
        }
    }

    private void a(String s1, Date date)
    {
        if (s1 == null || date == null || !a)
        {
            return;
        } else
        {
            (new j(s1, date) {

                final String a;
                final Date b;
                final PageNotificationsFragment c;

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

                protected String a(Void void1)
                {
                    void1 = NotificationList.a(a);
                    if (void1 != null && void1.longValue() != b.getTime())
                    {
                        if ((void1 = AccountManager.b()) != null && !void1.isEmpty())
                        {
                            try
                            {
                                com.cyberlink.beautycircle.model.network.o.a(AccountManager.d().id, b.getTime(), a).a(new com.perfectcorp.utility.m(this) {

                                    final _cls6 a;

                                    protected void a(Void void1)
                                    {
                                        NotificationList.a(a.a, a.b.getTime());
                                    }

                                    protected void b(Object obj)
                                    {
                                        a((Void)obj);
                                    }

            
            {
                a = _pcls6;
                super();
            }
                                });
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void void1)
                            {
                                void1.printStackTrace();
                                return null;
                            }
                            return null;
                        }
                    }
                    return null;
                }

            
            {
                c = PageNotificationsFragment.this;
                a = s1;
                b = date;
                super();
            }
            }).d(null);
            return;
        }
    }

    static void b(PageNotificationsFragment pagenotificationsfragment, boolean flag)
    {
        pagenotificationsfragment.f(flag);
    }

    static boolean b(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.L;
    }

    private void c(int l)
    {
        if (z == null || C == null || y == null || B == null) goto _L2; else goto _L1
_L1:
        if (l != t) goto _L4; else goto _L3
_L3:
        J = t;
        if (K)
        {
            com.perfectcorp.a.b.a(new ae("you"));
        }
        z.setSelected(true);
        A.setSelected(false);
        y.setSelected(false);
        C.setTypeface(null, 1);
        D.setTypeface(null, 0);
        B.setTypeface(null, 0);
        if (G != null)
        {
            G.setVisibility(8);
        }
_L2:
        p();
        if (P != null)
        {
            P.b(false);
        }
        return;
_L4:
        if (l == x)
        {
            J = x;
            z.setSelected(false);
            A.setSelected(true);
            y.setSelected(false);
            C.setTypeface(null, 0);
            D.setTypeface(null, 1);
            B.setTypeface(null, 0);
            if (I != null)
            {
                I.setVisibility(8);
            }
        } else
        {
            J = s;
            if (K)
            {
                com.perfectcorp.a.b.a(new ae("people"));
            }
            z.setSelected(false);
            A.setSelected(false);
            y.setSelected(true);
            C.setTypeface(null, 0);
            D.setTypeface(null, 0);
            B.setTypeface(null, 1);
            if (H != null)
            {
                H.setVisibility(8);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static boolean c(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.M;
    }

    static boolean c(PageNotificationsFragment pagenotificationsfragment, boolean flag)
    {
        pagenotificationsfragment.M = flag;
        return flag;
    }

    static void d(PageNotificationsFragment pagenotificationsfragment)
    {
        pagenotificationsfragment.o();
    }

    static boolean d(PageNotificationsFragment pagenotificationsfragment, boolean flag)
    {
        pagenotificationsfragment.L = flag;
        return flag;
    }

    static k e(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.O;
    }

    private void e(boolean flag)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            fragmentactivity.runOnUiThread(new Runnable(flag) {

                final boolean a;
                final PageNotificationsFragment b;

                public void run()
                {
label0:
                    {
                        if (b.o != null && com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(b) != null)
                        {
                            if (!a)
                            {
                                break label0;
                            }
                            if (com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(b).isSelected())
                            {
                                DialogUtils.a(b.o, com.cyberlink.beautycircle.m.bc_notification_you_empty, false, b.r);
                            } else
                            {
                                DialogUtils.a(b.o, com.cyberlink.beautycircle.m.bc_notification_people_empty, false, b.r);
                            }
                            b.o.setVisibility(0);
                        }
                        return;
                    }
                    b.o.setVisibility(8);
                }

            
            {
                b = PageNotificationsFragment.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    static t f(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.P;
    }

    private void f(boolean flag)
    {
        Object obj = getActivity();
        if (obj instanceof MainActivity)
        {
            obj = ((MainActivity)obj).u();
            if (obj != null)
            {
                ((BottomBarFragment) (obj)).a(flag);
            }
        }
    }

    static void g(PageNotificationsFragment pagenotificationsfragment)
    {
        pagenotificationsfragment.a();
    }

    static int h(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.s;
    }

    static int i(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.t;
    }

    static int j(PageNotificationsFragment pagenotificationsfragment)
    {
        return pagenotificationsfragment.x;
    }

    static void k(PageNotificationsFragment pagenotificationsfragment)
    {
        pagenotificationsfragment.n();
    }

    private void n()
    {
        if (O != null && O.j())
        {
            O.g = true;
            com.perfectcorp.utility.e.b(new Object[] {
                "Set NotificationAdapter ForcedRefresh by refresh expired."
            });
        }
        if (P != null && P.j())
        {
            P.g = true;
            com.perfectcorp.utility.e.b(new Object[] {
                "Set UChatListAdapter ForcedRefresh by refresh expired."
            });
        }
        if (h != null && (h.g || h.i()))
        {
            h.d(false);
            h.c();
        }
        if (h instanceof k)
        {
            a(((k)h).d(), ((k)h).b());
        }
    }

    private void o()
    {
        (new j() {

            final PageNotificationsFragment a;

            protected NotificationNew a(Void void1)
            {
                void1 = AccountManager.b();
                if (void1 == null || void1.isEmpty())
                {
                    return null;
                }
                try
                {
                    void1 = AccountManager.d();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    return null;
                }
                if (void1 == null) goto _L2; else goto _L1
_L1:
                void1 = (NotificationNew)com.cyberlink.beautycircle.model.network.o.a(Long.valueOf(((UserInfo) (void1)).id)).d();
_L4:
                return void1;
_L2:
                void1 = null;
                if (true) goto _L4; else goto _L3
_L3:
                break MISSING_BLOCK_LABEL_21;
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final PageNotificationsFragment a;

            protected void a(NotificationNew notificationnew)
            {
                com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.a(a, notificationnew);
            }

            protected void b(Object obj)
            {
                a((NotificationNew)obj);
            }

            
            {
                a = PageNotificationsFragment.this;
                super();
            }
        });
    }

    private void p()
    {
        if (!E && !F)
        {
            f(false);
        }
    }

    private void q()
    {
        if (y != null && y.isSelected())
        {
            if (G != null)
            {
                G.setVisibility(8);
            }
        } else
        if (z != null && z.isSelected() && H != null)
        {
            H.setVisibility(8);
            return;
        }
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k, N);
        }
    }

    public void b(int l)
    {
        super.b(l);
        if (J == t)
        {
            com.perfectcorp.a.b.a(new ae("you"));
        } else
        {
            com.perfectcorp.a.b.a(new ae("people"));
        }
        a();
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k);
        }
    }

    public void f()
    {
        if (a)
        {
            p();
            q();
        }
        super.f();
    }

    public void m()
    {
label0:
        {
            if (h != null)
            {
                if (!(h instanceof k))
                {
                    break label0;
                }
                ((k)h).b(false);
            }
            return;
        }
        h.c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(com.cyberlink.beautycircle.k.bc_fragment_page_notifications, viewgroup, false);
        a(layoutinflater, viewgroup, Integer.valueOf(com.cyberlink.beautycircle.k.bc_view_header_notification), Integer.valueOf(com.cyberlink.beautycircle.k.bc_view_footer));
        if (i != null)
        {
            B = (TextView)i.findViewById(com.cyberlink.beautycircle.j.bc_notification_people_text);
            y = i.findViewById(com.cyberlink.beautycircle.j.bc_notification_people);
            y.setOnClickListener(U);
            C = (TextView)i.findViewById(com.cyberlink.beautycircle.j.bc_notification_you_text);
            z = i.findViewById(com.cyberlink.beautycircle.j.bc_notification_you);
            z.setOnClickListener(V);
            D = (TextView)i.findViewById(com.cyberlink.beautycircle.j.bc_notification_chat_text);
            A = i.findViewById(com.cyberlink.beautycircle.j.bc_notification_chat);
            A.setOnClickListener(W);
            G = i.findViewById(com.cyberlink.beautycircle.j.bc_alert_people);
            H = i.findViewById(com.cyberlink.beautycircle.j.bc_alert_you);
            I = i.findViewById(com.cyberlink.beautycircle.j.bc_alert_chat);
            if (!Globals.m())
            {
                A.setVisibility(8);
                i.findViewById(com.cyberlink.beautycircle.j.bc_notification_select_divider2).setVisibility(8);
            }
            c(s);
            a(viewgroup, com.cyberlink.beautycircle.m.bc_notification_people_empty, false);
        }
        O = new k(getActivity(), g, com.cyberlink.beautycircle.k.bc_view_item_notification_list, Q);
        if (Globals.m())
        {
            P = new t(getActivity(), null, com.cyberlink.beautycircle.k.bc_view_item_notification_u_list, R);
            P.b(viewgroup.findViewById(com.cyberlink.beautycircle.j.bc_delete_btn));
            P.d(I);
            P.a(viewgroup.findViewById(com.cyberlink.beautycircle.j.bc_create_group_btn));
        }
        h = O;
        u = (RelativeLayout)viewgroup.findViewById(com.cyberlink.beautycircle.j.me_signIn_outter);
        N = viewgroup.findViewById(com.cyberlink.beautycircle.j.home_btn);
        viewgroup.findViewById(com.cyberlink.beautycircle.j.bc_create_group_btn).setOnClickListener(X);
        a(viewgroup, true, false, true, "notifications");
        AccountManager.a(S);
        com.cyberlink.beautycircle.utility.t.h.a(T);
        b();
        o();
        if (Globals.m())
        {
            a(viewgroup);
        }
        return viewgroup;
    }

    public void onResume()
    {
        NotificationTab notificationtab;
        super.onResume();
        a(g, k, N);
        Intent intent = getActivity().getIntent();
        notificationtab = (NotificationTab)intent.getSerializableExtra("SubTabPage");
        intent.putExtra("SubTabPage", com.cyberlink.beautycircle.controller.fragment.NotificationTab.a);
        if (notificationtab == null || notificationtab.index == J) goto _L2; else goto _L1
_L1:
        if (notificationtab.index != com.cyberlink.beautycircle.controller.fragment.NotificationTab.b.index) goto _L4; else goto _L3
_L3:
        U.onClick(null);
_L2:
        a();
        if (K)
        {
            if (J != t)
            {
                break; /* Loop/switch isn't completed */
            }
            com.perfectcorp.a.b.a(new ae("you"));
        }
        return;
_L4:
        if (notificationtab.index == NotificationTab.c.index)
        {
            V.onClick(null);
        } else
        if (notificationtab.index == NotificationTab.d.index)
        {
            W.onClick(null);
        }
        if (true) goto _L2; else goto _L5
_L5:
        com.perfectcorp.a.b.a(new ae("people"));
        return;
    }

    private class NotificationTab extends Enum
    {

        public static final NotificationTab a;
        public static final NotificationTab b;
        public static final NotificationTab c;
        public static final NotificationTab d;
        private static final NotificationTab e[];
        public final int index;

        public static NotificationTab valueOf(String s1)
        {
            return (NotificationTab)Enum.valueOf(com/cyberlink/beautycircle/controller/fragment/PageNotificationsFragment$NotificationTab, s1);
        }

        public static NotificationTab[] values()
        {
            return (NotificationTab[])e.clone();
        }

        static 
        {
            a = new NotificationTab("INVALID", 0, -1);
            b = new NotificationTab("PEOPLE", 1, 0);
            c = new NotificationTab("YOU", 2, 1);
            d = new NotificationTab("MESSAGES", 3, 2);
            e = (new NotificationTab[] {
                a, b, c, d
            });
        }

        private NotificationTab(String s1, int l, int i1)
        {
            super(s1, l);
            index = i1;
        }
    }

}
