// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import android.app.Activity;
import android.os.Handler;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import com.crittercism.app.Crittercism;
import com.foound.widget.a;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.j;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.LocalizationManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.StoreSectionV2;
import com.smule.pianoandroid.magicpiano.ListingListItem;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ProductListActivity;
import com.smule.pianoandroid.magicpiano.ProductListItem;
import com.smule.pianoandroid.magicpiano.am;
import com.smule.pianoandroid.magicpiano.t;
import com.smule.pianoandroid.search.FuzzySearchIndex;
import com.smule.pianoandroid.search.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            g, i, h, d, 
//            e, f

public class c extends a
{

    public static final String f = com/smule/pianoandroid/data/db/c.getName();
    private static c w;
    ArrayList g;
    ArrayList h;
    Observer i;
    Observer j;
    Handler k;
    private com.smule.pianoandroid.data.db.h l;
    private d m;
    private String n;
    private Boolean o;
    private LinkedHashMap p;
    private Activity q;
    private Boolean r;
    private t s;
    private am t;
    private LayoutInflater u;
    private FuzzySearchIndex v;
    private Runnable x;
    private b y;
    private e z;

    public c()
    {
        n = "";
        o = Boolean.valueOf(false);
        r = Boolean.valueOf(false);
        x = null;
        y = null;
        k = new Handler();
    }

    static Boolean a(c c1, Boolean boolean1)
    {
        c1.r = boolean1;
        return boolean1;
    }

    static void a(c c1)
    {
        c1.j();
    }

    static boolean a(c c1, boolean flag)
    {
        return c1.a(flag);
    }

    private boolean a(boolean flag)
    {
        if (!o.booleanValue())
        {
            a();
            notifyDataSetChanged();
            return true;
        } else
        {
            v.a(n, 0.5F, com.smule.pianoandroid.search.a.e, y);
            return true;
        }
    }

    static Activity b(c c1)
    {
        return c1.q;
    }

    static Boolean c(c c1)
    {
        return c1.r;
    }

    public static c d()
    {
        if (w == null)
        {
            w = new c();
        }
        return w;
    }

    static LinkedHashMap d(c c1)
    {
        return c1.p;
    }

    static Runnable e(c c1)
    {
        return c1.x;
    }

    private void j()
    {
        k.post(new Runnable() {

            final c a;

            public void run()
            {
                boolean flag = true;
                aa.c(c.f, "updateListings...");
                if (com.smule.pianoandroid.data.db.c.b(a) != null)
                {
                    a.g.clear();
                    Object obj = ak.a().d();
                    aa.a(c.f, (new StringBuilder()).append("updateListings ").append(((List) (obj)).size()).toString());
                    ((List) (obj)).add(com.smule.pianoandroid.magicpiano.suggestions.c.a().d());
                    if (com.smule.android.network.core.r.a(com.smule.pianoandroid.data.db.c.b(a)))
                    {
                        aa.a(c.f, "connected true");
                        c c1 = a;
                        if (((List) (obj)).size() <= 2)
                        {
                            flag = false;
                        }
                        com.smule.pianoandroid.data.db.c.a(c1, Boolean.valueOf(flag));
                    } else
                    {
                        aa.a(c.f, "connected false");
                        com.smule.pianoandroid.data.db.c.a(a, Boolean.valueOf(true));
                    }
                    if (!c.c(a).booleanValue())
                    {
                        com.smule.pianoandroid.data.db.c.b(a).findViewById(0x7f0a01d0).setVisibility(8);
                        a.c();
                        return;
                    }
                    com.smule.pianoandroid.data.db.c.b(a).findViewById(0x7f0a01d0).setVisibility(0);
                    StoreSectionV2 storesectionv2;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.g.add(new g((StoreSectionV2)LocalizationManager.a().a("store", storesectionv2))))
                    {
                        storesectionv2 = (StoreSectionV2)((Iterator) (obj)).next();
                    }

                    Collections.sort(a.g, new f());
                    a.a();
                    a.b();
                    a.notifyDataSetChanged();
                    c.d(a).clear();
                    com.smule.pianoandroid.data.db.c.a(a, false);
                    if (c.e(a) != null)
                    {
                        c.e(a).run();
                        return;
                    }
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    private ArrayList k()
    {
        if (o.booleanValue())
        {
            return h;
        } else
        {
            return g;
        }
    }

    public int a(String s1)
    {
        if (s1 != null)
        {
            Iterator iterator = k().iterator();
            for (int i1 = 0; iterator.hasNext(); i1++)
            {
                g g1 = (g)iterator.next();
                if (g1 != null && g1.c != null && g1.c.equals(s1))
                {
                    return getPositionForSection(i1);
                }
            }

        }
        return -1;
    }

    public int a(String s1, String s2)
    {
        int j1 = a(s2);
        int i1 = getSectionForPosition(j1);
        if (j1 != -1)
        {
            s2 = (g)k().get(i1);
            i1 = 0;
            for (s2 = ((g) (s2)).d.iterator(); s2.hasNext();)
            {
                if (((i)s2.next()).b().songId.equals(s1))
                {
                    return j1 + i1;
                }
                i1++;
            }

        }
        return -1;
    }

    public View a(int i1, View view, ViewGroup viewgroup)
    {
        i j1 = (i)getItem(i1);
        if (j1.c().booleanValue() || j1.d().booleanValue())
        {
            return a(j1.a(), view, viewgroup);
        } else
        {
            return b(j1.a(), view, viewgroup);
        }
    }

    protected View a(ListingV2 listingv2, View view, ViewGroup viewgroup)
    {
        if (view == null || !(view instanceof ProductListItem))
        {
            view = u.inflate(0x7f030059, viewgroup, false);
        }
        viewgroup = (ProductListItem)view;
        viewgroup.setPreviewListener(t);
        viewgroup.setProduct(listingv2);
        return view;
    }

    protected void a()
    {
        if (l != null)
        {
            l.a();
        }
    }

    public void a(Activity activity, t t1, am am, e e1)
    {
        v = (new FuzzySearchIndex()).a("songbook");
        q = activity;
        u = (LayoutInflater)activity.getSystemService("layout_inflater");
        s = t1;
        t = am;
        z = e1;
        g = new ArrayList();
        h = new ArrayList();
        p = new LinkedHashMap() {

            final c a;

            protected boolean removeEldestEntry(java.util.Map.Entry entry)
            {
                return size() > 16;
            }

            
            {
                a = c.this;
                super();
            }
        };
        j = new Observer() {

            final c a;

            public void update(Observable observable, Object obj)
            {
                if (!MagicApplication.sInitialized)
                {
                    aa.b(c.f, "ignoring update message");
                    Crittercism.a("SongbookAdapter, ignoring update message!");
                } else
                {
                    observable = (String)((Map)obj).get("ACTION");
                    if ("SONGBOOK_SYNCED_ACTION".equals(observable))
                    {
                        aa.c(c.f, "Songbook sync completed");
                        com.smule.pianoandroid.data.db.c.a(a);
                        return;
                    }
                    if ("PRODUCT_UPDATED_ACTION".equals(observable))
                    {
                        aa.c(c.f, "Product updated");
                        a.notifyDataSetChanged();
                        return;
                    }
                    if ("PRODUCTS_SORTED_ACTION".equals(observable))
                    {
                        aa.c(c.f, "Products sorted");
                        com.smule.pianoandroid.data.db.c.a(a);
                        return;
                    }
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", j);
        i = new Observer() {

            final c a;

            public void update(Observable observable, Object obj)
            {
                aa.c(c.f, "Scores synced");
                if (com.smule.pianoandroid.data.db.c.b(a) != null)
                {
                    com.smule.pianoandroid.data.db.c.b(c.d()).runOnUiThread(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            a.a.notifyDataSetChanged();
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("piandroid.scores.synced", i);
        MagicApplication.getInstance();
        MagicApplication.getLoader().a("SongbookAdapter.init", Arrays.asList(new String[] {
            "StoreManager.loadStore"
        }), new Runnable() {

            final c a;

            public void run()
            {
                aa.a(c.f, "updateListings called from SongbookAdapter.init");
                com.smule.pianoandroid.data.db.c.a(a);
            }

            
            {
                a = c.this;
                super();
            }
        }).a();
    }

    public void a(View view, int i1, int j1)
    {
        Object obj = c(i1);
        if (q != null)
        {
            ((ProductListActivity)q).b(((g) (obj)).a);
        }
        obj = String.format((new StringBuilder()).append(((g) (obj)).a).append(" (%d)").toString(), new Object[] {
            Integer.valueOf(((g) (obj)).d.size())
        });
        ((TextView)view.findViewById(0x7f0a00aa)).setText(((CharSequence) (obj)));
    }

    protected void a(View view, int i1, boolean flag)
    {
        if (view == null)
        {
            aa.b("SongbookAdapter", "invalid view");
        }
        view = view.findViewById(0x7f0a01d6);
        int j1;
        if (flag)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        view.setVisibility(j1);
        if (flag)
        {
            Object obj = c(i1);
            obj = String.format((new StringBuilder()).append(((g) (obj)).a).append(" (%d)").toString(), new Object[] {
                Integer.valueOf(((g) (obj)).d.size())
            });
            ((TextView)view.findViewById(0x7f0a00aa)).setText(((CharSequence) (obj)));
        }
    }

    public void a(d d1)
    {
        m = d1;
    }

    public void a(com.smule.pianoandroid.data.db.h h1)
    {
        l = h1;
    }

    public void a(b b1)
    {
        y = b1;
    }

    public void a(Runnable runnable)
    {
        x = runnable;
    }

    public void a(com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult afuzzysearchresult[])
    {
        long l1 = System.currentTimeMillis();
        h = new ArrayList();
        h.add(new g("Search Results", 0));
        int k1 = afuzzysearchresult.length;
        int i1 = 0;
        int j1 = 0;
        for (; i1 < k1; i1++)
        {
            Object obj = afuzzysearchresult[i1];
            obj = ak.a().f(((com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult) (obj)).mKey);
            ((g)h.get(0)).d.add(new i(j1, ((ListingV2) (obj)).song, ((ListingV2) (obj))));
            j1++;
        }

        a();
        notifyDataSetChanged();
        aa.a(f, (new StringBuilder()).append("updateSearchResult took ").append(System.currentTimeMillis() - l1).toString());
    }

    public boolean a(String s1, Boolean boolean1)
    {
        boolean flag = true;
        if (s1.length() == 0)
        {
            n = "";
            o = Boolean.valueOf(false);
        } else
        {
            n = s1;
            o = Boolean.valueOf(true);
        }
        if (boolean1.booleanValue())
        {
            flag = a(true);
        }
        return flag;
    }

    protected View b(ListingV2 listingv2, View view, ViewGroup viewgroup)
    {
        if (view == null || !(view instanceof ListingListItem))
        {
            view = u.inflate(0x7f03005a, viewgroup, false);
        }
        viewgroup = (ListingListItem)view;
        viewgroup.setPreviewListener(s);
        viewgroup.a(listingv2, Boolean.valueOf(ap.a().b()));
        return view;
    }

    protected void b()
    {
        if (m != null)
        {
            m.a();
        }
    }

    protected void b(int i1)
    {
    }

    protected g c(int i1)
    {
        for (Iterator iterator = k().iterator(); iterator.hasNext();)
        {
            g g1 = (g)iterator.next();
            if (i1 < g1.d.size())
            {
                return g1;
            }
            i1 -= g1.d.size();
        }

        return null;
    }

    protected void c()
    {
        if (m != null)
        {
            m.b();
        }
    }

    public String d(int i1)
    {
        for (Iterator iterator = k().iterator(); iterator.hasNext();)
        {
            g g1 = (g)iterator.next();
            if (i1 < g1.d.size())
            {
                return g1.c;
            }
            i1 -= g1.d.size();
        }

        return null;
    }

    public Boolean e()
    {
        return r;
    }

    public void f()
    {
        l = null;
        z = null;
        m = null;
        q = null;
        r = Boolean.valueOf(false);
        s = null;
        t = null;
        h.clear();
        p.clear();
        com.smule.android.f.h.a().b("SONGBOOK_UPDATED_EVENT", j);
        com.smule.android.f.h.a().b("piandroid.scores.synced", i);
    }

    public String g()
    {
        return n;
    }

    public int getCount()
    {
        Iterator iterator = k().iterator();
        int i1;
        for (i1 = 0; iterator.hasNext(); i1 = ((g)iterator.next()).d.size() + i1) { }
        return i1;
    }

    public Object getItem(int i1)
    {
        for (Iterator iterator = k().iterator(); iterator.hasNext();)
        {
            g g1 = (g)iterator.next();
            if (i1 < g1.d.size())
            {
                return g1.d.get(i1);
            }
            i1 -= g1.d.size();
        }

        return null;
    }

    public long getItemId(int i1)
    {
        return (long)i1;
    }

    public int getItemViewType(int i1)
    {
        i j1 = (i)getItem(i1);
        return !j1.c().booleanValue() && !j1.d().booleanValue() ? 1 : 0;
    }

    public int getPositionForSection(int i1)
    {
        int j1 = 0;
        int k1 = 0;
        for (; j1 < i1; j1++)
        {
            k1 += ((g)k().get(j1)).d.size();
        }

        return k1;
    }

    public int getSectionForPosition(int i1)
    {
        Iterator iterator = k().iterator();
        boolean flag = false;
        int j1 = i1;
        i1 = ((flag) ? 1 : 0);
        do
        {
            g g1;
label0:
            {
                if (iterator.hasNext())
                {
                    g1 = (g)iterator.next();
                    if (j1 >= g1.d.size())
                    {
                        break label0;
                    }
                }
                return i1;
            }
            j1 -= g1.d.size();
            i1++;
        } while (true);
    }

    public Object[] getSections()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = k().iterator(); iterator.hasNext(); arraylist.add(((g)iterator.next()).a)) { }
        return arraylist.toArray();
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean h()
    {
        return o.booleanValue();
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public Map i()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = k().iterator();
        for (int i1 = 0; iterator.hasNext(); i1++)
        {
            g g1 = (g)iterator.next();
            hashmap.put(g1.c, new Pair(g1.a, Integer.valueOf(i1)));
        }

        return hashmap;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i1)
    {
        super.onScrollStateChanged(abslistview, i1);
        if (z != null)
        {
            z.c();
        }
    }

}
