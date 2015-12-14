// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.r;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            f

public abstract class g extends f
{

    public ViewGroup g;
    public m h;
    public View i;
    public View j;
    public View k;
    public View l;
    public BiDirectionSwipeRefreshLayout m;
    public View n;
    public View o;
    public String p;
    protected d q;
    public android.view.View.OnClickListener r;
    private boolean s;
    private android.widget.AbsListView.OnScrollListener t;
    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener u;
    private com.cyberlink.beautycircle.view.widgetpool.common.c v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private android.view.View.OnClickListener y;

    public g()
    {
        s = false;
        o = null;
        p = null;
        t = new android.widget.AbsListView.OnScrollListener() {

            final g a;
            private boolean b;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                boolean flag = false;
                if (!b || j1 <= 0 || a.k == null)
                {
                    return;
                }
                if (i1 == 0)
                {
                    g.a(a, false);
                } else
                {
                    flag = true;
                }
                g.a(a, a.k, flag);
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
                if (i1 == 0)
                {
                    b = false;
                    return;
                } else
                {
                    b = true;
                    return;
                }
            }

            
            {
                a = g.this;
                super();
                b = false;
            }
        };
        q = new d() {

            final g a;
            private boolean b;

            public void a(PLA_AbsListView pla_abslistview, int i1)
            {
                if (i1 == 0)
                {
                    b = false;
                    return;
                } else
                {
                    b = true;
                    return;
                }
            }

            public void a(PLA_AbsListView pla_abslistview, int i1, int j1, int k1)
            {
                boolean flag = false;
                if (!b || j1 <= 0 || a.k == null)
                {
                    return;
                }
                if (i1 == 0)
                {
                    g.a(a, false);
                } else
                {
                    flag = true;
                }
                g.a(a, a.k, flag);
            }

            
            {
                a = g.this;
                super();
                b = false;
            }
        };
        u = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final g a;

            public void onRefresh()
            {
                a.i();
            }

            
            {
                a = g.this;
                super();
            }
        };
        v = new com.cyberlink.beautycircle.view.widgetpool.common.c() {

            final g a;

            public void a()
            {
                a.j();
            }

            
            {
                a = g.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.p != null)
                    {
                        com.perfectcorp.a.b.a(new r(a.p));
                    }
                    view = a.getActivity();
                    if (view instanceof MainActivity)
                    {
                        if (!view.getPackageName().equals("com.cyberlink.youcammakeup") && !view.getPackageName().equals("com.cyberlink.youperfect"))
                        {
                            break label0;
                        }
                        com.cyberlink.beautycircle.c.a(view);
                    }
                    return;
                }
                ((MainActivity)view).f();
            }

            
            {
                a = g.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                if (a.g != null)
                {
                    view = a.g.getClass();
                    if (android/widget/ListView.isAssignableFrom(view))
                    {
                        g.a(a, (ListView)a.g);
                    } else
                    if (com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView.isAssignableFrom(view))
                    {
                        g.a(a, (CLMultiColumnListView)a.g);
                        return;
                    }
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                Object obj = a.getActivity();
                if (obj == null)
                {
                    return;
                } else
                {
                    view = new PopupMenu(((android.content.Context) (obj)), view);
                    obj = view.getMenu();
                    ((Menu) (obj)).add(com.cyberlink.beautycircle.m.bc_me_create_circle).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls4 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            aq.c = "create_circle";
                            a.a.l();
                            return true;
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    ((Menu) (obj)).add(com.cyberlink.beautycircle.m.bc_me_create_post).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls4 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            aq.c = "create_post";
                            a.a.k();
                            return true;
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        r = new android.view.View.OnClickListener() {

            final g a;

            public void onClick(View view)
            {
                a.m();
            }

            
            {
                a = g.this;
                super();
            }
        };
    }

    private void a(View view, boolean flag)
    {
        if (s)
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (view != null && view.getVisibility() != 0)
        {
            view.setVisibility(0);
            ObjectAnimator.ofFloat(view, "alpha", new float[] {
                0.0F, 1.0F
            }).setDuration(300L).start();
        }
_L9:
        if (!d) goto _L4; else goto _L3
_L3:
        if (flag) goto _L6; else goto _L5
_L5:
        if (b != null && b.getVisibility() != 0)
        {
            b.setVisibility(0);
            ObjectAnimator.ofFloat(b, "alpha", new float[] {
                0.0F, 1.0F
            }).setDuration(300L).start();
        }
_L4:
        return;
_L2:
        if (view != null && view.getVisibility() != 4)
        {
            view.setVisibility(4);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (b == null || b.getVisibility() == 4) goto _L4; else goto _L7
_L7:
        b.setVisibility(4);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void a(ListView listview)
    {
        if (listview == null)
        {
            return;
        }
        int i1 = listview.getFirstVisiblePosition();
        s = true;
        if (i1 > 4)
        {
            listview.setSelection(4);
        }
        listview.smoothScrollToPosition(0);
        listview.postDelayed(new Runnable(listview) {

            final ListView a;
            final g b;

            public void run()
            {
                a.setSelection(0);
            }

            
            {
                b = g.this;
                a = listview;
                super();
            }
        }, 300L);
    }

    static void a(g g1, View view, boolean flag)
    {
        g1.a(view, flag);
    }

    static void a(g g1, ListView listview)
    {
        g1.a(listview);
    }

    static void a(g g1, CLMultiColumnListView clmulticolumnlistview)
    {
        g1.a(clmulticolumnlistview);
    }

    private void a(CLMultiColumnListView clmulticolumnlistview)
    {
        if (clmulticolumnlistview == null)
        {
            return;
        }
        int i1 = clmulticolumnlistview.getFirstVisiblePosition();
        s = true;
        if (i1 > 4)
        {
            clmulticolumnlistview.setSelection(4);
        }
        clmulticolumnlistview.h(0);
        clmulticolumnlistview.postDelayed(new Runnable(clmulticolumnlistview) {

            final CLMultiColumnListView a;
            final g b;

            public void run()
            {
                a.setSelection(0);
            }

            
            {
                b = g.this;
                a = clmulticolumnlistview;
                super();
            }
        }, 300L);
    }

    static boolean a(g g1, boolean flag)
    {
        g1.s = flag;
        return flag;
    }

    public void a(LayoutInflater layoutinflater, View view, Integer integer, Integer integer1)
    {
        if (layoutinflater != null && view != null)
        {
            g = (ViewGroup)view.findViewById(j.bc_list_view);
            if (g != null)
            {
                if (integer != null)
                {
                    i = layoutinflater.inflate(integer.intValue(), g, false);
                }
                if (integer1 != null)
                {
                    j = layoutinflater.inflate(integer1.intValue(), g, false);
                }
                layoutinflater = g.getClass();
                if (android/widget/ListView.isAssignableFrom(layoutinflater))
                {
                    if (integer != null && i != null)
                    {
                        ((ListView)g).addHeaderView(i, null, false);
                    }
                    if (integer1 != null && j != null)
                    {
                        ((ListView)g).addFooterView(j, null, false);
                    }
                    ((ListView)g).setOnScrollListener(t);
                } else
                if (com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView.isAssignableFrom(layoutinflater))
                {
                    if (integer != null && i != null)
                    {
                        ((CLMultiColumnListView)g).a(i, null, false);
                    }
                    if (integer1 != null && j != null)
                    {
                        ((CLMultiColumnListView)g).b(j, null, false);
                    }
                    ((CLMultiColumnListView)g).setOnScrollListener(q);
                }
                if (j != null)
                {
                    n = j.findViewById(j.bc_footer_waiting_cursor);
                }
                m = (BiDirectionSwipeRefreshLayout)view.findViewById(j.bc_pull_to_refresh_layout);
                if (m != null)
                {
                    m.setColorSchemeResources(new int[] {
                        com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style, com.cyberlink.beautycircle.g.bc_color_main_style
                    });
                    m.setEnabled(true);
                    m.setOnRefreshListener(u);
                    m.setOnLoadNextListener(v);
                    m.setTarget(g);
                    return;
                }
            }
        }
    }

    public void a(View view, int i1, boolean flag)
    {
        o = view.findViewById(j.empty_layout);
        DialogUtils.a(o, i1, flag, r);
    }

    public void a(View view, View view1, View view2)
    {
        if (view == null || view1 == null)
        {
            return;
        } else
        {
            view1.post(new Runnable(view, view1, view2) {

                final View a;
                final View b;
                final View c;
                final g d;

                public void run()
                {
                    Class class1 = d.g.getClass();
                    if (!android/widget/ListView.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
                    int i1 = ((ListView)a).getFirstVisiblePosition();
_L9:
                    if (i1 != 0) goto _L4; else goto _L3
_L3:
                    b.setVisibility(8);
                    if (d.d)
                    {
                        c.setVisibility(0);
                    }
_L6:
                    return;
_L2:
                    if (!com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView.isAssignableFrom(class1)) goto _L6; else goto _L5
_L5:
                    i1 = ((CLMultiColumnListView)a).getFirstVisiblePosition();
                    continue; /* Loop/switch isn't completed */
_L4:
                    b.setVisibility(0);
                    if (!d.d) goto _L6; else goto _L7
_L7:
                    c.setVisibility(8);
                    return;
                    if (true) goto _L9; else goto _L8
_L8:
                }

            
            {
                d = g.this;
                a = view;
                b = view1;
                c = view2;
                super();
            }
            });
            return;
        }
    }

    public void a(View view, boolean flag, boolean flag1, boolean flag2, String s1)
    {
        boolean flag3 = false;
        d = flag2;
        e = flag;
        f = flag1;
        k = view.findViewById(j.to_top_btn);
        if (k != null)
        {
            k.setVisibility(4);
            if (e)
            {
                k.setOnClickListener(x);
            }
        }
        l = view.findViewById(j.create_post_btn);
        int i1;
        if (l != null)
        {
            Object obj = l;
            if (f)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            ((View) (obj)).setVisibility(i1);
            if (f)
            {
                l.setOnClickListener(y);
            }
        }
        obj = getActivity();
        b = view.findViewById(j.home_btn);
        if (b != null)
        {
            if (obj instanceof MainActivity)
            {
                b.setVisibility(0);
                b.setOnClickListener(w);
            } else
            {
                b.setVisibility(4);
            }
        }
        c = (TextView)view.findViewById(j.demo_server_notice);
        if (c != null && e.a)
        {
            view = c;
            if (d)
            {
                i1 = ((flag3) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
        e();
        p = s1;
    }

    public void a(boolean flag)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            fragmentactivity.runOnUiThread(new Runnable(flag) {

                final boolean a;
                final g b;

                public void run()
                {
                    if (b.m != null && !a)
                    {
                        b.m.setRefreshing(a);
                    }
                }

            
            {
                b = g.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    public void b(boolean flag)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            fragmentactivity.runOnUiThread(new Runnable(flag) {

                final boolean a;
                final g b;

                public void run()
                {
                    if (b.n != null)
                    {
                        View view = b.n;
                        int i1;
                        if (a)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = 8;
                        }
                        view.setVisibility(i1);
                    }
                }

            
            {
                b = g.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    public void c(boolean flag)
    {
        if (o == null)
        {
            return;
        } else
        {
            o.post(new Runnable(flag) {

                final boolean a;
                final g b;

                public void run()
                {
                    View view = b.o;
                    int i1;
                    if (a)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = 8;
                    }
                    view.setVisibility(i1);
                }

            
            {
                b = g.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    public m h()
    {
        return h;
    }

    public void i()
    {
        m m1 = h();
        if (m1 != null && !m1.h())
        {
            m1.c();
        }
    }

    public void j()
    {
        m m1 = h();
        if (m1 != null)
        {
            m1.c(true);
        }
    }

    public void k()
    {
        com.cyberlink.beautycircle.c.b(getActivity());
    }

    public void l()
    {
        com.cyberlink.beautycircle.c.a(getActivity(), null, Boolean.valueOf(false));
    }

    public void m()
    {
        if (h != null)
        {
            h.c();
        }
    }
}
