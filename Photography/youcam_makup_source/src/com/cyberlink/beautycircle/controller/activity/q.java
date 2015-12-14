// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.m;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, r, s

class q extends ArrayAdapter
    implements m
{

    final SearchActivity a;
    private View b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private View g;
    private View h;
    private final CLMultiColumnListView i;
    private int j;
    private Integer k;
    private Integer l;
    private android.view.View.OnLayoutChangeListener m;
    private android.view.View.OnLayoutChangeListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;

    public q(SearchActivity searchactivity, CLMultiColumnListView clmulticolumnlistview)
    {
        a = searchactivity;
        super(searchactivity, SearchActivity.u());
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        j = 4;
        k = null;
        l = null;
        m = new android.view.View.OnLayoutChangeListener() {

            final q a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (q.a(a) != null)
                {
                    q.a(a).removeOnLayoutChangeListener(q.b(a));
                    q.a(a, Integer.valueOf(q.a(a).getWidth()));
                    if (com.cyberlink.beautycircle.controller.activity.q.c(a) != null && q.d(a) != null)
                    {
                        q.d(a).getLayoutParams().width = com.cyberlink.beautycircle.controller.activity.q.e(a).intValue();
                        q.d(a).requestLayout();
                    }
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        n = new android.view.View.OnLayoutChangeListener() {

            final q a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (q.d(a) != null)
                {
                    q.d(a).removeOnLayoutChangeListener(q.f(a));
                    q.b(a, Integer.valueOf(q.d(a).getWidth()));
                    if (com.cyberlink.beautycircle.controller.activity.q.e(a) != null)
                    {
                        q.d(a).getLayoutParams().width = com.cyberlink.beautycircle.controller.activity.q.e(a).intValue();
                        q.d(a).requestLayout();
                    }
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                a.a(true, true);
            }

            
            {
                a = q.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                a.a(true);
            }

            
            {
                a = q.this;
                super();
            }
        };
        i = clmulticolumnlistview;
        b = com.cyberlink.beautycircle.controller.activity.SearchActivity.e(searchactivity).inflate(SearchActivity.x(), i, false);
        i.c(b);
        d = b.findViewById(j.suggestion_header_clean_icon);
        if (d != null)
        {
            d.setOnClickListener(p);
            d.addOnLayoutChangeListener(m);
        }
        e = b.findViewById(j.suggestion_header_clear_text);
        if (e != null)
        {
            e.setOnClickListener(o);
            e.addOnLayoutChangeListener(n);
        }
        f = (TextView)b.findViewById(j.suggestion_header_text);
        c = b.findViewById(j.suggestion_header);
        h = com.cyberlink.beautycircle.controller.activity.SearchActivity.e(searchactivity).inflate(SearchActivity.y(), i, false);
        i.c(h);
        g = b.findViewById(j.suggestion_header_progress);
        b();
        i.setAdapter(this);
        i.setOnItemClickListener(this);
    }

    static View a(q q1)
    {
        return q1.d;
    }

    static Integer a(q q1, Integer integer)
    {
        q1.l = integer;
        return integer;
    }

    private void a(int i1)
    {
        j = i1;
        a(i1, 4);
    }

    private void a(int i1, int j1)
    {
        if (d != null)
        {
            d.setVisibility(i1);
            if (i1 == 0)
            {
                d.setOnClickListener(p);
                if (l != null && e != null && !l.equals(Integer.valueOf(e.getWidth())))
                {
                    e.getLayoutParams().width = l.intValue();
                    e.requestLayout();
                }
            }
        }
        if (e != null)
        {
            e.setVisibility(j1);
            if (j1 == 0)
            {
                e.setOnClickListener(o);
            }
        }
    }

    static void a(q q1, int i1, int j1)
    {
        q1.a(i1, j1);
    }

    static android.view.View.OnLayoutChangeListener b(q q1)
    {
        return q1.m;
    }

    static Integer b(q q1, Integer integer)
    {
        q1.k = integer;
        return integer;
    }

    static Integer c(q q1)
    {
        return q1.k;
    }

    static View d(q q1)
    {
        return q1.e;
    }

    static Integer e(q q1)
    {
        return q1.l;
    }

    static android.view.View.OnLayoutChangeListener f(q q1)
    {
        return q1.n;
    }

    public void a()
    {
        if (SearchActivity.p(a).isEmpty())
        {
            g.setVisibility(0);
            h.setVisibility(8);
            return;
        } else
        {
            g.setVisibility(8);
            h.setVisibility(0);
            h.findViewById(j.waiting_cursor).setVisibility(0);
            h.findViewById(j.waiting_text).setVisibility(0);
            return;
        }
    }

    public void a(PLA_AdapterView pla_adapterview, View view, int i1, long l1)
    {
        i1 -= i.getHeaderViewsCount();
        if (i1 >= 0)
        {
            pla_adapterview = ((PLA_AdapterView) (getItem(i1)));
            if (SearchActivity.s(a) == SearchActivity.t(a))
            {
                SearchActivity.a(a).requestFocus();
                com.cyberlink.beautycircle.c.a(a, false, (String)pla_adapterview, SearchActivity.i(a));
            } else
            if (pla_adapterview.getClass().isAssignableFrom(java/lang/String))
            {
                a.c((String)pla_adapterview);
            }
            if (e.a)
            {
                Globals.a((new StringBuilder()).append("onItemClick: ").append(i1).toString());
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        if (d != null && d.getVisibility() == 0 && e != null)
        {
            a(4, 0);
            e.clearAnimation();
            if (k != null)
            {
                r r1 = new r(this, e, k.intValue());
                long l1;
                if (flag)
                {
                    l1 = 200L;
                } else
                {
                    l1 = 0L;
                }
                r1.setDuration(l1);
                e.startAnimation(r1);
            }
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        if (d != null && e != null && e.getVisibility() == 0)
        {
            int i1 = d.getWidth();
            e.clearAnimation();
            r r1 = new r(this, e, i1);
            long l1;
            if (flag)
            {
                l1 = 200L;
            } else
            {
                l1 = 0L;
            }
            r1.setDuration(l1);
            r1.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag1) {

                final boolean a;
                final q b;

                public void onAnimationEnd(Animation animation)
                {
                    q.a(b, 0, 4);
                    if (a && SearchActivity.s(b.a) != null)
                    {
                        SearchActivity.s(b.a).b();
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                b = q.this;
                a = flag;
                super();
            }
            });
            e.startAnimation(r1);
        }
    }

    public void b()
    {
        g.setVisibility(8);
        a(j, 4);
        h.findViewById(j.waiting_cursor).setVisibility(8);
        h.findViewById(j.waiting_text).setVisibility(8);
    }

    public void clear()
    {
        super.clear();
        SearchActivity.b(a, SearchActivity.r(a), false);
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        com.perfectcorp.utility.e.b(new Object[] {
            Integer.valueOf(i1)
        });
        return SearchActivity.s(a).a(i1, view, viewgroup);
    }

    public void notifyDataSetChanged()
    {
        boolean flag = false;
        int i1 = 0;
        super.notifyDataSetChanged();
        boolean flag1 = isEmpty();
        if (SearchActivity.u(a).isLanding)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Show trending header"
            });
            if (flag1)
            {
                c.setVisibility(8);
                return;
            } else
            {
                c.setVisibility(0);
                a(4);
                f.setText(SearchActivity.s(a).b);
                return;
            }
        }
        if (!SearchActivity.p(a).isEmpty())
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Show search result header"
            });
            c.setVisibility(8);
            a(8);
            if (!flag1)
            {
                i1 = 8;
            }
            h.findViewById(j.waiting_cursor).setVisibility(i1);
            h.findViewById(j.waiting_text).setVisibility(i1);
            return;
        }
        if (SearchActivity.d(a).getText().length() == 0)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Show recent keywords header"
            });
            c.setVisibility(0);
            f.setText(SearchActivity.s(a).b);
            byte byte0 = flag;
            if (flag1)
            {
                byte0 = 4;
            }
            a(byte0);
            return;
        } else
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Show suggestions header"
            });
            c.setVisibility(0);
            a(4);
            f.setText(a.getResources().getString(SearchActivity.s(a).c, new Object[] {
                SearchActivity.d(a).getText().toString()
            }));
            return;
        }
    }
}
