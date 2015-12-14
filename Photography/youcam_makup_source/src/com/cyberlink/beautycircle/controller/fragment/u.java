// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, h, v, w

public class u extends g
{

    private boolean A;
    private n B;
    private com.cyberlink.beautycircle.utility.u C;
    private a D;
    private PagerAdapter E;
    private android.view.View.OnTouchListener F;
    private android.support.v4.view.ViewPager.OnPageChangeListener G;
    private Runnable H;
    private com.cyberlink.beautycircle.model.network.NetworkUser.UserListType s;
    private View t;
    private ViewPager u;
    private LinearLayout v;
    private int w;
    private ArrayList x;
    private TreeMap y;
    private TreeMap z;

    public u()
    {
        s = null;
        w = 0;
        x = new ArrayList();
        y = new TreeMap();
        z = new TreeMap();
        A = false;
        B = new h(this);
        C = new com.cyberlink.beautycircle.utility.u() {

            final u a;

            public void a()
            {
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = u.this;
                super();
            }
        };
        D = new a() {

            final u a;

            public void a(UserInfo userinfo)
            {
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = u.this;
                super();
            }
        };
        E = new PagerAdapter() {

            final u a;

            public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
            {
                if (obj != null)
                {
                    viewgroup.removeView(((com.cyberlink.beautycircle.controller.fragment.w)obj).b);
                    if (com.cyberlink.beautycircle.controller.fragment.u.e(a).containsKey(Integer.valueOf(i1)))
                    {
                        com.cyberlink.beautycircle.controller.fragment.u.e(a).remove(Integer.valueOf(i1));
                    }
                }
            }

            public int getCount()
            {
                return u.c(a).size();
            }

            public int getItemPosition(Object obj)
            {
                if (com.cyberlink.beautycircle.controller.fragment.u.e(a).size() <= 0) goto _L2; else goto _L1
_L1:
                Iterator iterator = com.cyberlink.beautycircle.controller.fragment.u.e(a).entrySet().iterator();
_L6:
                if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (entry.getValue() != obj) goto _L6; else goto _L5
_L5:
                obj = (Integer)entry.getKey();
_L8:
                if (obj != null)
                {
                    return ((Integer) (obj)).intValue();
                } else
                {
                    return -2;
                }
_L2:
                return -2;
_L4:
                obj = null;
                if (true) goto _L8; else goto _L7
_L7:
            }

            public Object instantiateItem(ViewGroup viewgroup, int i1)
            {
                Object obj = null;
                android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
                com.cyberlink.beautycircle.controller.fragment.w w1 = obj;
                if (fragmentactivity != null)
                {
                    w1 = obj;
                    if (i1 < u.c(a).size())
                    {
                        com.cyberlink.beautycircle.controller.fragment.w w2 = (com.cyberlink.beautycircle.controller.fragment.w)com.cyberlink.beautycircle.controller.fragment.u.e(a).get(Integer.valueOf(i1));
                        com.cyberlink.beautycircle.controller.fragment.v v1 = (com.cyberlink.beautycircle.controller.fragment.v)u.c(a).get(i1);
                        w1 = w2;
                        if (w2 == null)
                        {
                            w1 = new com.cyberlink.beautycircle.controller.fragment.w(a, fragmentactivity, viewgroup, v1);
                            com.cyberlink.beautycircle.controller.fragment.u.e(a).put(Integer.valueOf(i1), w1);
                        }
                        if (v1.b == null)
                        {
                            com.cyberlink.beautycircle.controller.fragment.u.a(a, i1, v1);
                        }
                        w1.a();
                    }
                }
                return w1;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return view.getTag().equals(Integer.valueOf(((com.cyberlink.beautycircle.controller.fragment.w)obj).hashCode()));
            }

            
            {
                a = u.this;
                super();
            }
        };
        F = new android.view.View.OnTouchListener() {

            final u a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 1 3: default 32
            //                           1 41
            //                           2 32
            //                           3 56;
                   goto _L1 _L2 _L1 _L3
_L1:
                u.h(a);
_L5:
                return false;
_L2:
                view.performClick();
                u.g(a);
                continue; /* Loop/switch isn't completed */
_L3:
                u.g(a);
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                a = u.this;
                super();
            }
        };
        G = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final u a;

            public void onPageScrollStateChanged(int i1)
            {
                if (i1 == 0 && com.cyberlink.beautycircle.controller.fragment.u.j(a) == 0 && com.cyberlink.beautycircle.controller.fragment.u.k(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.u.a(a, false);
                    u.l(a);
                }
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                if (i1 < com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildCount())
                {
                    Object obj = (Integer)com.cyberlink.beautycircle.controller.fragment.u.i(a).getTag();
                    if (obj != null)
                    {
                        if (((Integer) (obj)).intValue() == i1)
                        {
                            return;
                        }
                        obj = (ImageView)com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildAt(((Integer) (obj)).intValue());
                        if (obj != null)
                        {
                            ((ImageView) (obj)).setImageResource(i.bc_indicator_dot);
                            ((ImageView) (obj)).setSelected(false);
                        }
                    }
                    obj = (ImageView)com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildAt(i1);
                    if (obj != null)
                    {
                        ((ImageView) (obj)).setImageResource(i.bc_indicator_dot);
                        ((ImageView) (obj)).setSelected(true);
                    }
                    com.cyberlink.beautycircle.controller.fragment.u.i(a).setTag(Integer.valueOf(i1));
                }
                u.b(a, i1);
                u.g(a);
            }

            
            {
                a = u.this;
                super();
            }
        };
        H = new Runnable() {

            final u a;

            public void run()
            {
                if (com.cyberlink.beautycircle.controller.fragment.u.m(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.u.n(a);
                    u.c(a, u.c(a).size());
                    com.cyberlink.beautycircle.controller.fragment.u.m(a).setCurrentItem(com.cyberlink.beautycircle.controller.fragment.u.j(a), true);
                }
            }

            
            {
                a = u.this;
                super();
            }
        };
    }

    static View a(u u1)
    {
        return u1.t;
    }

    private void a()
    {
        Object obj = getActivity();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        long l1;
        long l2;
        if ((obj = ((Activity) (obj)).getIntent()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = ((Intent) (obj)).getLongExtra("UserId", -1L);
        l2 = ((Intent) (obj)).getLongExtra("ListId", -1L);
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.c && s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a && s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b && s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.e)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l1 == -1L)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = k.bc_view_item_user_list;
_L4:
        h = new w(getActivity(), g, i1, l1, l2, s, B, null);
        h.d(false);
        h.c();
        return;
        if (s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f && s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g && s != com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h) goto _L1; else goto _L3
_L3:
        i1 = k.bc_view_item_discover_user_list;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(int i1, com.cyberlink.beautycircle.controller.fragment.v v1)
    {
        if (v1 == null || v1.a == null)
        {
            return;
        } else
        {
            long l1 = v1.a.id;
            Object obj = AccountManager.c();
            obj = Post.a(new Long[] {
                Long.valueOf(l1)
            }, null, ((Long) (obj)), 0, 1);
            z.put(Long.valueOf(v1.a.id), obj);
            ((j) (obj)).a(new j(v1) {

                final com.cyberlink.beautycircle.controller.fragment.v a;
                final u b;

                public Boolean a(d d1)
                {
                    boolean flag1 = false;
                    boolean flag = flag1;
                    if (d1 != null)
                    {
                        flag = flag1;
                        if (d1.b != null)
                        {
                            flag = flag1;
                            if (d1.b.size() > 0)
                            {
                                a.b = (Post)d1.b.get(0);
                                flag = true;
                            }
                        }
                    }
                    return Boolean.valueOf(flag);
                }

                public volatile Object a(Object obj1)
                {
                    return a((d)obj1);
                }

            
            {
                b = u.this;
                a = v1;
                super();
            }
            }).a(new com.perfectcorp.utility.m(i1, v1) {

                final int a;
                final com.cyberlink.beautycircle.controller.fragment.v b;
                final u c;

                public void a()
                {
                    super.a();
                    u.f(c).remove(Long.valueOf(b.a.id));
                }

                public void a(int j1)
                {
                    super.a(j1);
                    u.f(c).remove(Long.valueOf(b.a.id));
                }

                public void a(Boolean boolean1)
                {
                    if (boolean1 != null && boolean1.booleanValue())
                    {
                        boolean1 = (com.cyberlink.beautycircle.controller.fragment.w)com.cyberlink.beautycircle.controller.fragment.u.e(c).get(Integer.valueOf(a));
                        if (boolean1 != null && ((com.cyberlink.beautycircle.controller.fragment.w) (boolean1)).a != null && ((com.cyberlink.beautycircle.controller.fragment.w) (boolean1)).a.equals(b))
                        {
                            boolean1.a();
                        }
                    }
                    u.f(c).remove(Long.valueOf(b.a.id));
                }

                public void b(Object obj1)
                {
                    a((Boolean)obj1);
                }

            
            {
                c = u.this;
                a = i1;
                b = v1;
                super();
            }
            });
            return;
        }
    }

    private void a(View view)
    {
        if (s.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g))
        {
            t = view.findViewById(com.cyberlink.beautycircle.j.bc_view_pager_container);
            u = (ViewPager)view.findViewById(com.cyberlink.beautycircle.j.bc_view_pager);
            u.setOnTouchListener(F);
            v = (LinearLayout)view.findViewById(com.cyberlink.beautycircle.j.bc_view_indicator);
            w = 0;
            y.clear();
            x.clear();
            u.setOffscreenPageLimit(4);
            u.setAdapter(E);
            u.setOnPageChangeListener(G);
            n();
        }
    }

    private void a(View view, LayoutInflater layoutinflater)
    {
        Integer integer;
        if (s == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g)
        {
            integer = Integer.valueOf(k.bc_view_header_master);
        } else
        {
            integer = null;
        }
        a(layoutinflater, view, integer, Integer.valueOf(k.bc_view_footer_no_bottom_padding));
        a();
        a(view, true, false, false, null);
        a(view, 0, true);
        t.c.a(C);
        AccountManager.a(D);
        layoutinflater = getActivity();
        if (layoutinflater instanceof MainActivity)
        {
            layoutinflater = ((MainActivity)layoutinflater).u();
            if (layoutinflater != null)
            {
                a(((BottomBarFragment) (layoutinflater)));
            }
        }
        a(view);
    }

    static void a(u u1, int i1)
    {
        u1.c(i1);
    }

    static void a(u u1, int i1, com.cyberlink.beautycircle.controller.fragment.v v1)
    {
        u1.a(i1, v1);
    }

    static boolean a(u u1, boolean flag)
    {
        u1.A = flag;
        return flag;
    }

    static int b(u u1, int i1)
    {
        u1.w = i1;
        return i1;
    }

    static PagerAdapter b(u u1)
    {
        return u1.E;
    }

    static int c(u u1, int i1)
    {
        i1 = u1.w % i1;
        u1.w = i1;
        return i1;
    }

    static ArrayList c(u u1)
    {
        return u1.x;
    }

    private void c(int i1)
    {
        Object obj = getActivity();
        if (obj == null || v == null)
        {
            return;
        }
        i1 -= v.getChildCount();
        if (i1 > 0)
        {
            obj = (LayoutInflater)((Activity) (obj)).getSystemService("layout_inflater");
            for (; i1 > 0; i1--)
            {
                ImageView imageview = (ImageView)((LayoutInflater) (obj)).inflate(k.bc_view_item_page_indicator, v, false);
                v.addView(imageview);
            }

        } else
        if (i1 < 0)
        {
            v.removeViews(v.getChildCount() + i1, -i1);
        }
        if (v.getChildCount() > 1)
        {
            v.setVisibility(0);
            return;
        } else
        {
            v.setVisibility(8);
            return;
        }
    }

    static android.support.v4.view.ViewPager.OnPageChangeListener d(u u1)
    {
        return u1.G;
    }

    static TreeMap e(u u1)
    {
        return u1.y;
    }

    static TreeMap f(u u1)
    {
        return u1.z;
    }

    static void g(u u1)
    {
        u1.p();
    }

    static void h(u u1)
    {
        u1.q();
    }

    static LinearLayout i(u u1)
    {
        return u1.v;
    }

    static int j(u u1)
    {
        return u1.w;
    }

    static boolean k(u u1)
    {
        return u1.A;
    }

    static void l(u u1)
    {
        u1.n();
    }

    static ViewPager m(u u1)
    {
        return u1.u;
    }

    static int n(u u1)
    {
        int i1 = u1.w;
        u1.w = i1 + 1;
        return i1;
    }

    private void n()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("Master");
        NetworkUser.a(AccountManager.c(), 0, 20, arraylist).a(new j() {

            final u a;

            protected Boolean a(d d1)
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (d1 != null)
                {
                    flag = flag1;
                    if (d1.b != null)
                    {
                        flag = flag1;
                        if (d1.b.size() > 0)
                        {
                            com.cyberlink.beautycircle.controller.fragment.u.e(a).clear();
                            u.c(a).clear();
                            d1 = d1.b.iterator();
                            do
                            {
                                if (!d1.hasNext())
                                {
                                    break;
                                }
                                UserInfo userinfo = (UserInfo)d1.next();
                                if (userinfo != null && userinfo.bgImageUrl != null && !userinfo.bgImageUrl.toString().isEmpty())
                                {
                                    com.cyberlink.beautycircle.controller.fragment.v v1 = new com.cyberlink.beautycircle.controller.fragment.v(a);
                                    v1.a = userinfo;
                                    u.c(a).add(v1);
                                }
                            } while (true);
                            flag = true;
                        }
                    }
                }
                return Boolean.valueOf(flag);
            }

            protected volatile Object a(Object obj)
            {
                return a((d)obj);
            }

            
            {
                a = u.this;
                super();
            }
        }).a(new com.perfectcorp.utility.m() {

            final u a;

            protected void a(int i1)
            {
                super.a(i1);
            }

            protected void a(Boolean boolean1)
            {
                if (boolean1 != null && boolean1.booleanValue())
                {
                    com.cyberlink.beautycircle.controller.fragment.u.a(a).setVisibility(0);
                    u.b(a).notifyDataSetChanged();
                    com.cyberlink.beautycircle.controller.fragment.u.a(a, u.c(a).size());
                    com.cyberlink.beautycircle.controller.fragment.u.d(a).onPageSelected(0);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.fragment.u.a(a).setVisibility(8);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = u.this;
                super();
            }
        });
    }

    private void o()
    {
        if (s == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g)
        {
            q();
            w = 0;
            for (Iterator iterator = z.values().iterator(); iterator.hasNext(); ((j)iterator.next()).a(true)) { }
            n();
        }
    }

    private void p()
    {
        if (u != null && x.size() > 1)
        {
            u.removeCallbacks(H);
            u.postDelayed(H, 10000L);
        }
    }

    private void q()
    {
        if (u != null)
        {
            u.removeCallbacks(H);
        }
    }

    public void i()
    {
        super.i();
        if (w != 0)
        {
            A = true;
            u.setCurrentItem(0, true);
            return;
        } else
        {
            o();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (s == null)
        {
            bundle = getActivity();
            if (bundle == null)
            {
                return null;
            }
            bundle = bundle.getIntent();
            if (bundle == null)
            {
                return null;
            }
            s = (com.cyberlink.beautycircle.model.network.NetworkUser.UserListType)bundle.getSerializableExtra("UserListType");
        }
        if (s == null)
        {
            return null;
        }
        int i1;
        if (s == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.f || s == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g || s == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.h)
        {
            i1 = k.bc_fragment_page_discover_userlist;
        } else
        {
            i1 = k.bc_fragment_page_userlist;
        }
        viewgroup = layoutinflater.inflate(i1, viewgroup, false);
        a(viewgroup, layoutinflater);
        b();
        return viewgroup;
    }

    public void onDestroyView()
    {
        t.c.b(C);
        AccountManager.b(D);
        super.onDestroyView();
    }

    public void onPause()
    {
        super.onPause();
        q();
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
        if (h != null && h.g)
        {
            h.g();
        }
        p();
    }
}
