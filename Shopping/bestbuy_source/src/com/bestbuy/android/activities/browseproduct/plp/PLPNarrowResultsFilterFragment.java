// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import ca;
import com.bestbuy.android.api.lib.models.solr.Facet;
import com.bestbuy.android.api.lib.models.solr.SortOption;
import com.bestbuy.android.api.lib.models.solr.Value;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import eu;
import ex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lu;
import nb;

public class PLPNarrowResultsFilterFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private RelativeLayout A;
    private eu B;
    private String C;
    private String D;
    private String E;
    private ArrayList F;
    private String G;
    private boolean H;
    private LayoutInflater a;
    private View b;
    private Activity c;
    private List g;
    private HashMap h;
    private LinearLayout i;
    private RelativeLayout j;
    private ArrayList k;
    private ArrayList l;
    private ArrayList m;
    private ca n;
    private ExpandableListView o;
    private ArrayList p;
    private HashMap q;
    private HashMap r;
    private HashMap s;
    private ArrayList t;
    private List u;
    private SortOption v;
    private ex w;
    private ListView x;
    private BBYTextView y;
    private String z;

    public PLPNarrowResultsFilterFragment()
    {
        b = null;
        k = null;
        l = null;
        m = new ArrayList();
        p = new ArrayList();
        q = new HashMap();
        r = new HashMap();
        s = new HashMap();
        t = new ArrayList();
        u = new ArrayList();
        v = null;
        F = new ArrayList();
        G = "";
        H = false;
    }

    public PLPNarrowResultsFilterFragment(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, HashMap hashmap, SortOption sortoption, List list, String s1, 
            ArrayList arraylist3, String s2, String s3)
    {
        b = null;
        k = null;
        l = null;
        m = new ArrayList();
        p = new ArrayList();
        q = new HashMap();
        r = new HashMap();
        s = new HashMap();
        t = new ArrayList();
        u = new ArrayList();
        v = null;
        F = new ArrayList();
        G = "";
        H = false;
        l = arraylist;
        k = arraylist2;
        r = hashmap;
        v = sortoption;
        u = arraylist1;
        t = arraylist3;
        C = s1;
        D = s2;
        E = s3;
    }

    static String a(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment, String s1)
    {
        plpnarrowresultsfilterfragment.z = s1;
        return s1;
    }

    static List a(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.u;
    }

    private void a(int i1, String s1)
    {
        Object obj;
        Facet facet;
        String s2;
        facet = (Facet)g.get(i1);
        s2 = facet.getFacetField();
        obj = (List)q.get(s2);
        if (obj == null)
        {
            obj = new ArrayList();
        }
        if (!G.equals("single")) goto _L2; else goto _L1
_L1:
        if (F.contains(s2))
        {
            if (!((List) (obj)).isEmpty())
            {
                a(s2, (String)((List) (obj)).get(0));
            }
            ((List) (obj)).clear();
        }
_L4:
        ((List) (obj)).add(s1);
        q.put(s2, obj);
        if (q.size() >= 1)
        {
            n.a(true);
            j.setBackground(new ColorDrawable(0xff0067ab));
            j.setClickable(true);
            j.setOnClickListener(this);
        }
        if (G.equals("Multi") && s2.equals("category_facet"))
        {
            F.add(facet.getFacetField());
            B.a(F);
        }
        b(s2, s1);
        return;
_L2:
        if (s2.equals("category_facet"))
        {
            if (!((List) (obj)).isEmpty())
            {
                a(s2, (String)((List) (obj)).get(0));
            }
            ((List) (obj)).clear();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment, int i1, String s1)
    {
        plpnarrowresultsfilterfragment.a(i1, s1);
    }

    static void a(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment, String s1, String s2)
    {
        plpnarrowresultsfilterfragment.a(s1, s2);
    }

    private void a(String s1, String s2)
    {
        i.removeView(i.findViewWithTag(s2));
        Object obj = (List)q.get(s1);
        ((List) (obj)).remove(s2);
        if (obj == null || ((List) (obj)).isEmpty())
        {
            q.remove(s1);
        } else
        {
            q.put(s1, obj);
        }
        obj = (String)f.P().get(s2);
        p.remove((new StringBuilder()).append(s1).append("=").append(s2).toString());
        if (obj != null && !((String) (obj)).isEmpty())
        {
            p.remove((new StringBuilder()).append(s1).append("=").append(((String) (obj))).toString());
        }
        j.setBackground(new ColorDrawable(0xff0067ab));
        j.setOnClickListener(this);
        if (G.equals("Multi"))
        {
            F.remove(s1);
        }
        B.a(F);
    }

    private void a(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            Facet facet = (Facet)arraylist.next();
            String s1 = facet.getFacetField();
            if ((s1.equals(getString(0x7f08012c)) || s1.equals(getString(0x7f080157))) && E != null && (E.equals(getString(0x7f080077)) || E.equals(getString(0x7f080075))))
            {
                g.remove(facet);
                h.remove(facet.getDisplayName());
            } else
            {
                ArrayList arraylist1 = new ArrayList();
                for (Iterator iterator = facet.getValues().iterator(); iterator.hasNext(); arraylist1.add(((Value)iterator.next()).getValue())) { }
                s.put(facet.getFacetField(), arraylist1);
            }
        }

        B.a(s, g, h);
    }

    static String b(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.z;
    }

    private void b(String s1, String s2)
    {
        p.add((new StringBuilder()).append(s1).append("=").append(s2).toString());
        if (s2.equals(D))
        {
            return;
        } else
        {
            LinearLayout linearlayout = new LinearLayout(c);
            linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
            linearlayout.setOrientation(0);
            linearlayout.setPadding(10, 10, 10, 10);
            View view = a.inflate(0x7f0300b8, null);
            ((BBYTextView)view.findViewById(0x7f0c02f3)).setText(s2);
            view.findViewById(0x7f0c02f2).setOnClickListener(new android.view.View.OnClickListener(s1, s2) {

                final String a;
                final String b;
                final PLPNarrowResultsFilterFragment c;

                public void onClick(View view1)
                {
                    PLPNarrowResultsFilterFragment.a(c, a, b);
                    PLPNarrowResultsFilterFragment.h(c).setBackground(new ColorDrawable(0xff0067ab));
                    PLPNarrowResultsFilterFragment.h(c).setOnClickListener(c);
                    PLPNarrowResultsFilterFragment.i(c).notifyDataSetChanged();
                    view1 = c.f.P();
                    if (view1 != null && !view1.isEmpty())
                    {
                        view1 = (String)view1.get(PLPNarrowResultsFilterFragment.l(c));
                    }
                }

            
            {
                c = PLPNarrowResultsFilterFragment.this;
                a = s1;
                b = s2;
                super();
            }
            });
            linearlayout.addView(view);
            i.addView(linearlayout, 0);
            linearlayout.setTag(s2);
            return;
        }
    }

    private void b(ArrayList arraylist)
    {
        g = new ArrayList();
        h = new HashMap();
        if (arraylist != null && !arraylist.isEmpty())
        {
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break;
                }
                Facet facet = (Facet)arraylist.next();
                Object obj = facet.getFacetField();
                if (!((String) (obj)).equals(getString(0x7f08012c)) && !((String) (obj)).equals(getString(0x7f080157)) || E == null || !E.equals(getString(0x7f08006c)) && !E.equals(getString(0x7f08012a)) && !E.equals(getString(0x7f080077)) && !E.equals(getString(0x7f080075)))
                {
                    g.add(facet);
                    if (((String) (obj)).equals(getString(0x7f0800f0)))
                    {
                        H = true;
                    }
                    obj = facet.getValues();
                    if (obj != null && !((ArrayList) (obj)).isEmpty())
                    {
                        h.put(facet.getDisplayName(), obj);
                    }
                }
            } while (true);
        }
    }

    static BBYTextView c(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.y;
    }

    static View d(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.b;
    }

    static RelativeLayout e(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.A;
    }

    private void e()
    {
        Facet facet;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); F.add(facet.getFacetField()))
        {
            facet = (Facet)iterator.next();
        }

        B.a(F);
    }

    static SortOption f(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.v;
    }

    private void f()
    {
        Iterator iterator = r.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            Object obj = (List)r.get(s1);
            q.put(s1, obj);
            if (!s1.equals(getString(0x7f08012c)) && !s1.equals(getString(0x7f080157)) || E == null || !E.equals(getString(0x7f08006c)) && !E.equals(getString(0x7f08012a)) && !E.equals(getString(0x7f080077)) && !E.equals(getString(0x7f080075)))
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    b(s1, (String)((Iterator) (obj)).next());
                }
            }
        } while (true);
    }

    static ex g(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.w;
    }

    private void g()
    {
        p.clear();
        for (Iterator iterator = q.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            Iterator iterator1 = ((List)q.get(s1)).iterator();
            while (iterator1.hasNext()) 
            {
                String s2 = (String)iterator1.next();
                p.add((new StringBuilder()).append(s1).append("=").append(s2).toString());
            }
        }

    }

    static RelativeLayout h(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.j;
    }

    static eu i(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.B;
    }

    static List j(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.g;
    }

    static void k(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        plpnarrowresultsfilterfragment.g();
    }

    static String l(PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        return plpnarrowresultsfilterfragment.D;
    }

    public HashMap b()
    {
        return q;
    }

    public ArrayList c()
    {
        return t;
    }

    public String d()
    {
        return z;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = activity;
        n = (ca)activity;
    }

    public void onClick(View view)
    {
        if (view == j)
        {
            g();
            n.a(p, z);
        } else
        if (view == A)
        {
            if (b.findViewById(0x7f0c0313).getVisibility() == 8)
            {
                A.setBackgroundResource(0x7f020020);
                b.findViewById(0x7f0c0313).setVisibility(0);
                b.findViewById(0x7f0c0311).setVisibility(8);
                y.setTextColor(c.getResources().getColor(0x7f0b0012));
                return;
            } else
            {
                b.findViewById(0x7f0c0313).setVisibility(8);
                b.findViewById(0x7f0c0311).setVisibility(0);
                A.setBackgroundResource(0x7f020021);
                y.setTextColor(c.getResources().getColor(0x7f0b0005));
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater;
        b = layoutinflater.inflate(0x7f0300bf, viewgroup, false);
        i = (LinearLayout)b.findViewById(0x7f0c00bd);
        j = (RelativeLayout)b.findViewById(0x7f0c030d);
        j.setClickable(false);
        y = (BBYTextView)b.findViewById(0x7f0c0310);
        A = (RelativeLayout)b.findViewById(0x7f0c030f);
        if (v != null)
        {
            z = v.getValue();
            y.setText(v.getDisplayName());
        }
        A.setOnClickListener(this);
        b(l);
        o = (ExpandableListView)b.findViewById(0x7f0c0312);
        o.setGroupIndicator(null);
        o.setChildIndicator(null);
        B = new eu(c, this, g, h, D);
        o.setAdapter(B);
        if (G.equals("single"))
        {
            e();
        }
        x = (ListView)b.findViewById(0x7f0c0313);
        x.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PLPNarrowResultsFilterFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                PLPNarrowResultsFilterFragment.a(a, ((SortOption)PLPNarrowResultsFilterFragment.a(a).get(i1)).getValue());
                adapterview = new HashMap();
                adapterview.put("ProductsFilterSortOrder", PLPNarrowResultsFilterFragment.b(a));
                lu.a(lu.ac, adapterview);
                PLPNarrowResultsFilterFragment.c(a).setText(((SortOption)PLPNarrowResultsFilterFragment.a(a).get(i1)).getDisplayName());
                PLPNarrowResultsFilterFragment.d(a).findViewById(0x7f0c0313).setVisibility(8);
                PLPNarrowResultsFilterFragment.d(a).findViewById(0x7f0c0311).setVisibility(0);
                PLPNarrowResultsFilterFragment.e(a).setBackgroundResource(0x7f020021);
                PLPNarrowResultsFilterFragment.g(a).a(PLPNarrowResultsFilterFragment.f(a).getDisplayName());
                PLPNarrowResultsFilterFragment.h(a).setBackground(new ColorDrawable(0xff0067ab));
                PLPNarrowResultsFilterFragment.h(a).setClickable(true);
                PLPNarrowResultsFilterFragment.h(a).setOnClickListener(a);
            }

            
            {
                a = PLPNarrowResultsFilterFragment.this;
                super();
            }
        });
        w = new ex(c, 0x7f0300c2, u, v.getDisplayName());
        x.setAdapter(w);
        o.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final PLPNarrowResultsFilterFragment a;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i1, int j1, long l1)
            {
                expandablelistview = ((Value)PLPNarrowResultsFilterFragment.i(a).getChild(i1, j1)).getValue();
                if (view.findViewById(0x7f0c030b).getVisibility() == 8)
                {
                    view.findViewById(0x7f0c030b).setVisibility(0);
                    PLPNarrowResultsFilterFragment.a(a, i1, expandablelistview);
                } else
                {
                    view.findViewById(0x7f0c030b).setVisibility(8);
                    view = ((Facet)PLPNarrowResultsFilterFragment.j(a).get(i1)).getFacetField();
                    PLPNarrowResultsFilterFragment.a(a, view, expandablelistview);
                }
                PLPNarrowResultsFilterFragment.k(a);
                expandablelistview = a.f.P();
                if (expandablelistview != null && !expandablelistview.isEmpty())
                {
                    expandablelistview = (String)expandablelistview.get(PLPNarrowResultsFilterFragment.l(a));
                }
                return true;
            }

            
            {
                a = PLPNarrowResultsFilterFragment.this;
                super();
            }
        });
        o.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final PLPNarrowResultsFilterFragment a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                ((ImageView)view.findViewById(0x7f0c0307)).setImageResource(0x7f020117);
                return false;
            }

            
            {
                a = PLPNarrowResultsFilterFragment.this;
                super();
            }
        });
        if (r != null && !r.isEmpty())
        {
            if (!H)
            {
                r.remove("category_facet");
            }
            f();
        }
        if (k != null && !k.isEmpty())
        {
            a(k);
        }
        return b;
    }
}
