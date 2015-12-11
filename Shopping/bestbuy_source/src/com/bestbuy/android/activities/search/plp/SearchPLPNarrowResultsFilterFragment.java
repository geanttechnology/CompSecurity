// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.search.plp;

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
import com.bestbuy.android.api.lib.models.search.FacetValues;
import com.bestbuy.android.api.lib.models.search.Facets;
import com.bestbuy.android.api.lib.models.search.Sort;
import com.bestbuy.android.api.lib.models.search.SortOptions;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dj;
import dm;
import dn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.search.plp:
//            SearchPLPSortAndFilterActivity

public class SearchPLPNarrowResultsFilterFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private RelativeLayout A;
    private dj B;
    private String C;
    private String D;
    private String E;
    private ArrayList F;
    private String G;
    private boolean H;
    private HashMap I;
    private ArrayList J;
    private String K;
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
    private dm n;
    private ExpandableListView o;
    private ArrayList p;
    private HashMap q;
    private HashMap r;
    private HashMap s;
    private ArrayList t;
    private List u;
    private Sort v;
    private dn w;
    private ListView x;
    private BBYTextView y;
    private String z;

    public SearchPLPNarrowResultsFilterFragment()
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
        I = new HashMap();
        J = new ArrayList();
        K = "";
    }

    public SearchPLPNarrowResultsFilterFragment(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, HashMap hashmap, Sort sort, List list, String s1, 
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
        I = new HashMap();
        J = new ArrayList();
        K = "";
        l = arraylist;
        k = arraylist2;
        r = hashmap;
        v = sort;
        u = arraylist1;
        t = arraylist3;
        C = s1;
        D = s2;
        E = s3;
    }

    static String a(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment, String s1)
    {
        searchplpnarrowresultsfilterfragment.z = s1;
        return s1;
    }

    static List a(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.u;
    }

    private void a(int i1, String s1)
    {
        Object obj;
        Facets facets;
        String s2;
        facets = (Facets)g.get(i1);
        s2 = facets.getFacetField();
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
            F.add(facets.getFacetField());
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

    static void a(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment, int i1, String s1)
    {
        searchplpnarrowresultsfilterfragment.a(i1, s1);
    }

    static void a(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment, String s1, String s2)
    {
        searchplpnarrowresultsfilterfragment.a(s1, s2);
    }

    private void a(String s1, String s2)
    {
        i.removeView(i.findViewWithTag(s2));
        List list = (List)q.get(s1);
        String s3 = (String)f.P().get(s2);
        list.remove(s2);
        if (list == null || list.isEmpty())
        {
            q.remove(s1);
        } else
        {
            q.put(s1, list);
        }
        p.remove((new StringBuilder()).append(s1).append("=").append(s2).toString());
        if (s3 != null && !s3.isEmpty())
        {
            p.remove((new StringBuilder()).append(s1).append("=").append(s3).toString());
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
            Facets facets = (Facets)arraylist.next();
            String s1 = facets.getFacetField();
            if ((s1.equals(getString(0x7f08012c)) || s1.equals(getString(0x7f080157))) && E != null && (E.equals(getString(0x7f080077)) || E.equals(getString(0x7f080075))))
            {
                g.remove(facets);
                h.remove(facets.getDisplayName());
            } else
            if (s1.equals(getString(0x7f08012c)) && E != null && E.equals(getString(0x7f08006c)))
            {
                g.remove(facets);
                h.remove(facets.getDisplayName());
            } else
            {
                ArrayList arraylist1 = new ArrayList();
                for (Iterator iterator = facets.getValues().iterator(); iterator.hasNext(); arraylist1.add(((FacetValues)iterator.next()).getValue())) { }
                s.put(facets.getFacetField(), arraylist1);
            }
        }

        B.a(s, g, h);
    }

    static String b(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.z;
    }

    private void b(String s1, String s2)
    {
        if (I.containsKey(s1))
        {
            K = (String)I.get(s1);
        }
        ((SearchPLPSortAndFilterActivity)c).a((new StringBuilder()).append(K).append(" : ").append(s2).toString());
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
                final SearchPLPNarrowResultsFilterFragment c;

                public void onClick(View view1)
                {
                    SearchPLPNarrowResultsFilterFragment.a(c, a, b);
                    SearchPLPNarrowResultsFilterFragment.h(c).setBackground(new ColorDrawable(0xff0067ab));
                    SearchPLPNarrowResultsFilterFragment.h(c).setOnClickListener(c);
                    SearchPLPNarrowResultsFilterFragment.j(c).notifyDataSetChanged();
                }

            
            {
                c = SearchPLPNarrowResultsFilterFragment.this;
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
                Facets facets = (Facets)arraylist.next();
                Object obj = facets.getFacetField();
                if ((!((String) (obj)).equals(getString(0x7f08012c)) && !((String) (obj)).equals(getString(0x7f080157)) || E == null || !E.equals(getString(0x7f08012a)) && !E.equals(getString(0x7f080077)) && !E.equals(getString(0x7f080075))) && (!((String) (obj)).equals(getString(0x7f08012c)) || E == null || !E.equals(getString(0x7f08006c))))
                {
                    g.add(facets);
                    if (((String) (obj)).equals(getString(0x7f0800f0)))
                    {
                        H = true;
                    }
                    obj = facets.getValues();
                    if (obj != null && !((ArrayList) (obj)).isEmpty())
                    {
                        h.put(facets.getDisplayName(), obj);
                    }
                }
            } while (true);
        }
    }

    static BBYTextView c(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.y;
    }

    static View d(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.b;
    }

    static RelativeLayout e(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.A;
    }

    private void e()
    {
        Facets facets;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); F.add(facets.getFacetField()))
        {
            facets = (Facets)iterator.next();
        }

        B.a(F);
    }

    static Sort f(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.v;
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
            String s3 = (String)iterator.next();
            List list = (List)r.get(s3);
            q.put(s3, list);
            if ((!s3.equals(getString(0x7f08012c)) && !s3.equals(getString(0x7f080157)) || E == null || !E.equals(getString(0x7f08012a)) && !E.equals(getString(0x7f080077)) && !E.equals(getString(0x7f080075))) && (!s3.equals(getString(0x7f08012c)) || E == null || !E.equals(getString(0x7f08006c))))
            {
                Iterator iterator1 = list.iterator();
                while (iterator1.hasNext()) 
                {
                    String s2 = (String)iterator1.next();
                    String s1 = s2;
                    if (s3.equals("category_facet"))
                    {
                        HashMap hashmap = f.P();
                        s1 = s2;
                        if (hashmap != null)
                        {
                            Iterator iterator2 = hashmap.keySet().iterator();
                            do
                            {
                                s1 = s2;
                                if (!iterator2.hasNext())
                                {
                                    break;
                                }
                                s1 = (String)iterator2.next();
                            } while (!((String)hashmap.get(s1)).equals(s2));
                        }
                    }
                    b(s3, s1);
                }
            }
        } while (true);
    }

    static dn g(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.w;
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

    static RelativeLayout h(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.j;
    }

    static List i(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.g;
    }

    static dj j(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        return searchplpnarrowresultsfilterfragment.B;
    }

    static void k(SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        searchplpnarrowresultsfilterfragment.g();
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
        n = (dm)activity;
    }

    public void onClick(View view)
    {
        if (view == j)
        {
            g();
            view = q.entrySet().iterator();
            do
            {
                if (!view.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)view.next();
                if (I.containsKey(entry.getKey()))
                {
                    J.add((new StringBuilder()).append((String)I.get(entry.getKey())).append(" : ").append(entry.getValue().toString().replace("[", "").replace("]", "")).toString());
                    K = (String)I.get(entry.getKey());
                }
            } while (true);
            ((SearchPLPSortAndFilterActivity)c).a(J);
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
        B = new dj(c, this, g, h, D);
        o.setAdapter(B);
        if (G.equals("single"))
        {
            e();
        }
        x = (ListView)b.findViewById(0x7f0c0313);
        x.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SearchPLPNarrowResultsFilterFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                SearchPLPNarrowResultsFilterFragment.a(a, ((SortOptions)SearchPLPNarrowResultsFilterFragment.a(a).get(i1)).getValue());
                adapterview = new HashMap();
                adapterview.put("ProductsFilterSortOrder", SearchPLPNarrowResultsFilterFragment.b(a));
                lu.a(lu.ac, adapterview);
                SearchPLPNarrowResultsFilterFragment.c(a).setText(((SortOptions)SearchPLPNarrowResultsFilterFragment.a(a).get(i1)).getDisplayName());
                SearchPLPNarrowResultsFilterFragment.d(a).findViewById(0x7f0c0313).setVisibility(8);
                SearchPLPNarrowResultsFilterFragment.d(a).findViewById(0x7f0c0311).setVisibility(0);
                SearchPLPNarrowResultsFilterFragment.e(a).setBackgroundResource(0x7f020021);
                SearchPLPNarrowResultsFilterFragment.g(a).a(SearchPLPNarrowResultsFilterFragment.f(a).getDisplayName());
                SearchPLPNarrowResultsFilterFragment.h(a).setBackground(new ColorDrawable(0xff0067ab));
                SearchPLPNarrowResultsFilterFragment.h(a).setClickable(true);
                SearchPLPNarrowResultsFilterFragment.h(a).setOnClickListener(a);
            }

            
            {
                a = SearchPLPNarrowResultsFilterFragment.this;
                super();
            }
        });
        w = new dn(c, 0x7f0300c2, u, v.getDisplayName());
        x.setAdapter(w);
        for (layoutinflater = g.iterator(); layoutinflater.hasNext(); I.put(viewgroup.getFacetField(), viewgroup.getDisplayName()))
        {
            viewgroup = (Facets)layoutinflater.next();
        }

        o.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final SearchPLPNarrowResultsFilterFragment a;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i1, int j1, long l1)
            {
                expandablelistview = ((Facets)SearchPLPNarrowResultsFilterFragment.i(a).get(i1)).getFacetField();
                String s1 = ((FacetValues)SearchPLPNarrowResultsFilterFragment.j(a).getChild(i1, j1)).getValue();
                if (view.findViewById(0x7f0c030b).getVisibility() == 8)
                {
                    view.findViewById(0x7f0c030b).setVisibility(0);
                    SearchPLPNarrowResultsFilterFragment.a(a, i1, s1);
                } else
                {
                    view.findViewById(0x7f0c030b).setVisibility(8);
                    SearchPLPNarrowResultsFilterFragment.a(a, expandablelistview, s1);
                }
                SearchPLPNarrowResultsFilterFragment.k(a);
                return true;
            }

            
            {
                a = SearchPLPNarrowResultsFilterFragment.this;
                super();
            }
        });
        o.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final SearchPLPNarrowResultsFilterFragment a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                ((ImageView)view.findViewById(0x7f0c0307)).setImageResource(0x7f020117);
                return false;
            }

            
            {
                a = SearchPLPNarrowResultsFilterFragment.this;
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
