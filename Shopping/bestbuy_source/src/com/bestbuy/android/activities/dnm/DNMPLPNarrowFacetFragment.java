// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

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
import cb;
import com.bestbuy.android.api.lib.models.dnm.DNMFacet;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import com.bestbuy.android.api.lib.models.dnm.DNMSortOption;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fe;
import fj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DNMPLPNarrowFacetFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private String A;
    private double B;
    private double C;
    private int D;
    private String E;
    private ArrayList F;
    private LayoutInflater a;
    private View b;
    private Activity c;
    private LinearLayout g;
    private RelativeLayout h;
    private ExpandableListView i;
    private ListView j;
    private BBYTextView k;
    private RelativeLayout l;
    private ArrayList m;
    private Map n;
    private fe o;
    private fj p;
    private ArrayList q;
    private DNMSortOption r;
    private ArrayList s;
    private ArrayList t;
    private Map u;
    private ArrayList v;
    private Map w;
    private ArrayList x;
    private String y;
    private cb z;

    public DNMPLPNarrowFacetFragment()
    {
        b = null;
        m = new ArrayList(10);
        u = new HashMap();
        v = new ArrayList();
        F = new ArrayList();
    }

    public DNMPLPNarrowFacetFragment(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, ArrayList arraylist3, DNMSortOption dnmsortoption, String s1, double d1, double d2, int i1, String s2, String s3)
    {
        b = null;
        m = new ArrayList(10);
        u = new HashMap();
        v = new ArrayList();
        F = new ArrayList();
        s = arraylist;
        t = arraylist1;
        q = arraylist2;
        r = dnmsortoption;
        A = s1;
        B = d1;
        C = d2;
        D = i1;
        E = s2;
        x = arraylist3;
    }

    static String a(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment, String s1)
    {
        dnmplpnarrowfacetfragment.y = s1;
        return s1;
    }

    static ArrayList a(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.q;
    }

    private void a(int i1, DNMFacetFilter dnmfacetfilter)
    {
        String s1 = ((DNMFacet)m.get(i1)).getName();
        Object obj = (List)u.get(s1);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            a(s1, (DNMFacetFilter)((List) (obj)).get(0));
        }
        obj = new ArrayList();
        ((List) (obj)).add(dnmfacetfilter);
        u.put(s1, obj);
        if (u.size() >= 1)
        {
            z.a(true);
            h.setBackground(new ColorDrawable(0xff0067ab));
            h.setClickable(true);
            h.setOnClickListener(this);
        }
        o.a();
        b(s1, dnmfacetfilter);
    }

    static void a(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment, int i1, DNMFacetFilter dnmfacetfilter)
    {
        dnmplpnarrowfacetfragment.a(i1, dnmfacetfilter);
    }

    static void a(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment, String s1, DNMFacetFilter dnmfacetfilter)
    {
        dnmplpnarrowfacetfragment.a(s1, dnmfacetfilter);
    }

    private void a(String s1, DNMFacetFilter dnmfacetfilter)
    {
        g.removeView(g.findViewWithTag(dnmfacetfilter.getFilterQuery()));
        List list = (List)u.get(s1);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DNMFacetFilter dnmfacetfilter1 = (DNMFacetFilter)iterator.next();
            if (dnmfacetfilter1.getFilterQuery().equals(dnmfacetfilter.getFilterQuery()))
            {
                list.remove(dnmfacetfilter1);
            }
        } while (true);
        if (list == null || list.isEmpty())
        {
            u.remove(s1);
        } else
        {
            u.put(s1, list);
        }
        v.remove(dnmfacetfilter);
        h.setBackground(new ColorDrawable(0xff0067ab));
        h.setOnClickListener(this);
    }

    static BBYTextView b(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.k;
    }

    private void b(String s1, DNMFacetFilter dnmfacetfilter)
    {
        v.add(dnmfacetfilter);
        String s2 = dnmfacetfilter.getDisplayText();
        LinearLayout linearlayout = new LinearLayout(c);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        linearlayout.setOrientation(0);
        View view = a.inflate(0x7f0300b8, null);
        ((BBYTextView)view.findViewById(0x7f0c02f3)).setText(s2);
        view.findViewById(0x7f0c02f2).setOnClickListener(new android.view.View.OnClickListener(s1, dnmfacetfilter) {

            final String a;
            final DNMFacetFilter b;
            final DNMPLPNarrowFacetFragment c;

            public void onClick(View view1)
            {
                DNMPLPNarrowFacetFragment.a(c, a, b);
                DNMPLPNarrowFacetFragment.g(c).setBackground(new ColorDrawable(0xff0067ab));
                DNMPLPNarrowFacetFragment.g(c).setOnClickListener(c);
                DNMPLPNarrowFacetFragment.h(c).notifyDataSetChanged();
            }

            
            {
                c = DNMPLPNarrowFacetFragment.this;
                a = s1;
                b = dnmfacetfilter;
                super();
            }
        });
        linearlayout.addView(view);
        linearlayout.setTag(dnmfacetfilter.getFilterQuery());
        s1 = new View(c);
        s1.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(11, 1));
        linearlayout.addView(s1);
        g.addView(linearlayout, 0);
    }

    static View c(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.b;
    }

    static RelativeLayout d(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.l;
    }

    private void d()
    {
        Iterator iterator = x.iterator();
label0:
        do
        {
            ArrayList arraylist;
            DNMFacetFilter dnmfacetfilter;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                dnmfacetfilter = (DNMFacetFilter)iterator.next();
                if (dnmfacetfilter.getFacetTitle().equals("Discount Type"))
                {
                    continue;
                }
                z.a(true);
                b(dnmfacetfilter.getFacetTitle(), dnmfacetfilter);
                ArrayList arraylist1 = (ArrayList)u.get(dnmfacetfilter.getFacetTitle());
                if (arraylist1 != null)
                {
                    arraylist = arraylist1;
                    if (!arraylist1.isEmpty())
                    {
                        break label1;
                    }
                }
                arraylist = new ArrayList();
            }
            arraylist.add(dnmfacetfilter);
            u.put(dnmfacetfilter.getFacetTitle(), arraylist);
        } while (true);
    }

    static DNMSortOption e(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.r;
    }

    private void e()
    {
        v.clear();
        for (Iterator iterator = u.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = ((List)u.get(obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                DNMFacetFilter dnmfacetfilter = (DNMFacetFilter)((Iterator) (obj)).next();
                v.add(dnmfacetfilter);
            }
        }

    }

    static fj f(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.p;
    }

    private void f()
    {
        Object obj = new HashMap();
        HashMap hashmap = new HashMap();
        m = new ArrayList(10);
        for (int i1 = 0; i1 < 10; i1++)
        {
            m.add(new DNMFacet());
        }

        w = new HashMap();
        Object obj1 = new HashMap();
        HashMap hashmap1 = new HashMap();
        Object obj2 = new HashSet();
        if (s != null)
        {
            DNMFacet dnmfacet1;
            for (Iterator iterator = s.iterator(); iterator.hasNext(); ((Set) (obj2)).add(dnmfacet1.getName()))
            {
                dnmfacet1 = (DNMFacet)iterator.next();
                hashmap.put(dnmfacet1.getName(), dnmfacet1);
                ((Map) (obj1)).put(dnmfacet1.getName(), dnmfacet1.getFilters());
            }

        }
        if (t != null)
        {
            DNMFacet dnmfacet2;
            for (Iterator iterator1 = t.iterator(); iterator1.hasNext(); ((Set) (obj2)).add(dnmfacet2.getName()))
            {
                dnmfacet2 = (DNMFacet)iterator1.next();
                ((Map) (obj)).put(dnmfacet2.getName(), dnmfacet2);
                hashmap1.put(dnmfacet2.getName(), dnmfacet2.getFilters());
            }

        }
        obj1 = ((Map) (obj1)).keySet();
        for (obj2 = ((Set) (obj2)).iterator(); ((Iterator) (obj2)).hasNext();)
        {
            Object obj3 = (String)((Iterator) (obj2)).next();
            if (((Set) (obj1)).contains(obj3))
            {
                Object obj4 = (DNMFacet)((Map) (obj)).get(obj3);
                obj3 = (DNMFacet)hashmap.get(obj3);
                if (obj4 == null)
                {
                    DNMFacetFilter dnmfacetfilter;
                    for (obj4 = ((DNMFacet) (obj3)).getFilters().iterator(); ((Iterator) (obj4)).hasNext(); w.put(dnmfacetfilter.getDisplayText(), dnmfacetfilter))
                    {
                        dnmfacetfilter = (DNMFacetFilter)((Iterator) (obj4)).next();
                    }

                    m.set(((DNMFacet) (obj3)).getIndex(), obj3);
                } else
                {
                    obj4 = ((DNMFacet) (obj4)).getFilters();
                    ArrayList arraylist = ((DNMFacet) (obj3)).getFilters();
                    for (int j1 = 0; j1 < arraylist.size(); j1++)
                    {
                        DNMFacetFilter dnmfacetfilter1 = (DNMFacetFilter)arraylist.get(j1);
                        int k1 = 0;
                        boolean flag = false;
                        for (; k1 < ((ArrayList) (obj4)).size(); k1++)
                        {
                            DNMFacetFilter dnmfacetfilter2 = (DNMFacetFilter)((ArrayList) (obj4)).get(k1);
                            if (dnmfacetfilter1.getDisplayText().equals(dnmfacetfilter2.getDisplayText()))
                            {
                                arraylist.set(j1, dnmfacetfilter2);
                                flag = true;
                            }
                        }

                        if (!flag)
                        {
                            w.put(dnmfacetfilter1.getDisplayText(), dnmfacetfilter1);
                        }
                    }

                    ((DNMFacet) (obj3)).setFilters(arraylist);
                    m.set(((DNMFacet) (obj3)).getIndex(), obj3);
                }
            } else
            {
                obj3 = (DNMFacet)((Map) (obj)).get(obj3);
                m.set(((Set) (obj1)).size(), obj3);
            }
        }

        s.clear();
        obj = m.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            DNMFacet dnmfacet = (DNMFacet)((Iterator) (obj)).next();
            if (dnmfacet != null && dnmfacet.getName() != null && !dnmfacet.getName().isEmpty())
            {
                s.add(dnmfacet);
            }
        } while (true);
        m.clear();
        m.addAll(s);
    }

    static RelativeLayout g(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.h;
    }

    static fe h(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.o;
    }

    static ArrayList i(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        return dnmplpnarrowfacetfragment.m;
    }

    static void j(DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        dnmplpnarrowfacetfragment.e();
    }

    public Map b()
    {
        return u;
    }

    public Map c()
    {
        return w;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        c = activity;
        z = (cb)activity;
    }

    public void onClick(View view)
    {
        if (view == h)
        {
            e();
            z.a(v, y, s);
        } else
        if (view == l)
        {
            if (b.findViewById(0x7f0c0313).getVisibility() == 8)
            {
                l.setBackgroundResource(0x7f020020);
                b.findViewById(0x7f0c0313).setVisibility(0);
                b.findViewById(0x7f0c0311).setVisibility(8);
                k.setTextColor(c.getResources().getColor(0x7f0b0012));
                return;
            } else
            {
                b.findViewById(0x7f0c0313).setVisibility(8);
                b.findViewById(0x7f0c0311).setVisibility(0);
                l.setBackgroundResource(0x7f020021);
                k.setTextColor(c.getResources().getColor(0x7f0b0005));
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
        g = (LinearLayout)b.findViewById(0x7f0c00bd);
        h = (RelativeLayout)b.findViewById(0x7f0c030d);
        h.setClickable(false);
        k = (BBYTextView)b.findViewById(0x7f0c0310);
        l = (RelativeLayout)b.findViewById(0x7f0c030f);
        f();
        if (m != null)
        {
            n = new HashMap();
            layoutinflater = m.iterator();
            do
            {
                if (!layoutinflater.hasNext())
                {
                    break;
                }
                viewgroup = (DNMFacet)layoutinflater.next();
                if (viewgroup != null && viewgroup.getName() != null && !viewgroup.getName().isEmpty())
                {
                    n.put(viewgroup.getName(), viewgroup.getFilters());
                }
            } while (true);
        }
        if (r != null)
        {
            y = r.getValue();
            k.setText(r.getDisplayName());
        }
        l.setOnClickListener(this);
        i = (ExpandableListView)b.findViewById(0x7f0c0312);
        i.setGroupIndicator(null);
        i.setChildIndicator(null);
        o = new fe(c, this, m, n);
        i.setAdapter(o);
        j = (ListView)b.findViewById(0x7f0c0313);
        j.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final DNMPLPNarrowFacetFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                DNMPLPNarrowFacetFragment.a(a, ((DNMSortOption)DNMPLPNarrowFacetFragment.a(a).get(i1)).getValue());
                DNMPLPNarrowFacetFragment.b(a).setText(((DNMSortOption)DNMPLPNarrowFacetFragment.a(a).get(i1)).getDisplayName());
                DNMPLPNarrowFacetFragment.c(a).findViewById(0x7f0c0313).setVisibility(8);
                DNMPLPNarrowFacetFragment.c(a).findViewById(0x7f0c0311).setVisibility(0);
                DNMPLPNarrowFacetFragment.d(a).setBackgroundResource(0x7f020021);
                DNMPLPNarrowFacetFragment.f(a).a(DNMPLPNarrowFacetFragment.e(a).getDisplayName());
                DNMPLPNarrowFacetFragment.g(a).setBackground(new ColorDrawable(0xff0067ab));
                DNMPLPNarrowFacetFragment.g(a).setClickable(true);
                DNMPLPNarrowFacetFragment.g(a).setOnClickListener(a);
            }

            
            {
                a = DNMPLPNarrowFacetFragment.this;
                super();
            }
        });
        p = new fj(c, 0x7f0300c2, q, r.getDisplayName());
        j.setAdapter(p);
        i.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final DNMPLPNarrowFacetFragment a;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i1, int j1, long l1)
            {
                expandablelistview = (DNMFacetFilter)DNMPLPNarrowFacetFragment.h(a).getChild(i1, j1);
                if (view.findViewById(0x7f0c030b).getVisibility() == 8)
                {
                    view.findViewById(0x7f0c030b).setVisibility(0);
                    DNMPLPNarrowFacetFragment.a(a, i1, expandablelistview);
                } else
                {
                    view.findViewById(0x7f0c030b).setVisibility(8);
                    view = ((DNMFacet)DNMPLPNarrowFacetFragment.i(a).get(i1)).getName();
                    DNMPLPNarrowFacetFragment.a(a, view, expandablelistview);
                }
                DNMPLPNarrowFacetFragment.j(a);
                return true;
            }

            
            {
                a = DNMPLPNarrowFacetFragment.this;
                super();
            }
        });
        i.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final DNMPLPNarrowFacetFragment a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i1, long l1)
            {
                ((ImageView)view.findViewById(0x7f0c0307)).setImageResource(0x7f020117);
                return false;
            }

            
            {
                a = DNMPLPNarrowFacetFragment.this;
                super();
            }
        });
        if (x != null && !x.isEmpty())
        {
            d();
        }
        return b;
    }
}
