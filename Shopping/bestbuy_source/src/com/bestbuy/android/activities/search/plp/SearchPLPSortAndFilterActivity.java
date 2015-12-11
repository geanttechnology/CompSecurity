// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.search.plp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import com.bestbuy.android.api.lib.models.search.FacetValues;
import com.bestbuy.android.api.lib.models.search.Facets;
import com.bestbuy.android.api.lib.models.search.RequestInfo;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.search.Sort;
import com.bestbuy.android.api.lib.models.search.SortOptions;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lt;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.search.plp:
//            SearchPLPNarrowResultsFilterFragment

public class SearchPLPSortAndFilterActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener, dm
{

    private BBYTextView a;
    private ArrayList b;
    private ArrayList c;
    private HashMap d;
    private ArrayList e;
    private ArrayList f;
    private int g;
    private SearchPLPNarrowResultsFilterFragment h;
    private ArrayList i;
    private String j;
    private nb k;
    private String l;
    private String m;
    private Sort n;
    private String o;
    private boolean p;
    private boolean q;
    private String r;
    private ArrayList s;

    public SearchPLPSortAndFilterActivity()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        i = new ArrayList();
        n = null;
        r = "";
        s = null;
    }

    private void a()
    {
        HashSet hashset = new HashSet();
        if (f != null)
        {
            for (int i1 = 0; i1 < f.size(); i1++)
            {
                hashset.add(((SortOptions)f.get(i1)).getValue());
            }

            if (c != null)
            {
                Iterator iterator = c.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    SortOptions sortoptions = (SortOptions)iterator.next();
                    if (hashset.add(sortoptions.getValue()))
                    {
                        f.add(sortoptions);
                    }
                } while (true);
            }
        }
    }

    private void b()
    {
        if (b != null && !b.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            HashMap hashmap = new HashMap();
            if (b != null && !b.isEmpty())
            {
                Iterator iterator = b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Facets facets = (Facets)iterator.next();
                    arraylist.add(facets);
                    ArrayList arraylist2 = facets.getValues();
                    if (arraylist2 != null && !arraylist2.isEmpty())
                    {
                        hashmap.put(facets.getDisplayName(), arraylist2);
                    }
                } while (true);
            }
            int i1 = 0;
            while (i1 < e.size()) 
            {
                Object obj = (Facets)e.get(i1);
                if (!hashmap.containsKey(((Facets) (obj)).getDisplayName()))
                {
                    b(((Facets) (obj)).getValues());
                } else
                {
                    ArrayList arraylist1 = (ArrayList)hashmap.get(((Facets) (obj)).getDisplayName());
                    obj = ((Facets) (obj)).getValues();
                    int j1 = 0;
                    while (j1 < ((ArrayList) (obj)).size()) 
                    {
                        FacetValues facetvalues = (FacetValues)((ArrayList) (obj)).get(j1);
                        int k1 = 0;
                        boolean flag = false;
                        for (; k1 < arraylist1.size(); k1++)
                        {
                            FacetValues facetvalues1 = (FacetValues)arraylist1.get(k1);
                            if (facetvalues1.getValue().equals(facetvalues.getValue()))
                            {
                                ((ArrayList) (obj)).set(j1, facetvalues1);
                                flag = true;
                            }
                        }

                        if (!flag)
                        {
                            i.add(facetvalues.getValue());
                        }
                        j1++;
                    }
                }
                i1++;
            }
        }
    }

    private void b(ArrayList arraylist)
    {
        FacetValues facetvalues;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); i.add(facetvalues.getValue()))
        {
            facetvalues = (FacetValues)arraylist.next();
        }

    }

    public void a(String s1)
    {
        r = s1;
    }

    public void a(ArrayList arraylist)
    {
        s = arraylist;
    }

    public void a(ArrayList arraylist, String s1)
    {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("SELECTED_FACETS", arraylist);
        intent.putExtra("SORT_ORDER", s1);
        intent.putStringArrayListExtra("Selected_Facets_For_Analytics", s);
        intent.putExtra("Latest_Facet_Selected", r);
        setResult(-1, intent);
        finish();
        overridePendingTransition(0x7f040005, 0x7f040008);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            findViewById(0x7f0c02f6).setVisibility(0);
            return;
        } else
        {
            findViewById(0x7f0c02f6).setVisibility(4);
            return;
        }
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0c02f5)
        {
            setResult(-1, null);
            finish();
            overridePendingTransition(0x7f040005, 0x7f040008);
        } else
        if (view.getId() == 0x7f0c02f6)
        {
            view = new Intent();
            view.putExtra("CLEAR_ALL", true);
            view.putExtra("SORT_ORDER", h.d());
            setResult(-1, view);
            finish();
            overridePendingTransition(0x7f040005, 0x7f040008);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getActionBar().hide();
        setContentView(0x7f0300b9);
        getWindow().setLayout(-1, -1);
        bundle = getIntent().getExtras();
        k = nb.a();
        o = bundle.getString("BreadCrumb");
        p = bundle.getBoolean("isFacetsSearch");
        q = bundle.getBoolean("isBrowseProduct");
        if (bundle.containsKey("SEARCH_RESPONSE"))
        {
            SearchApi searchapi = (SearchApi)getIntent().getSerializableExtra("SEARCH_RESPONSE");
            if (searchapi != null)
            {
                b = searchapi.getFacets();
                c = searchapi.getSortOptions();
                d = searchapi.getRequestedFacets();
                n = searchapi.getRequestInfo().getSort();
                g = searchapi.getTotal();
                j = searchapi.getRequestInfo().getQuery();
                k.a(searchapi.getCategoryMap());
            }
        }
        if (bundle.containsKey("SELECTED_CATEGORY"))
        {
            l = "";
        }
        if (bundle.containsKey("SEARCH_BASE_FACETS") && getIntent().getSerializableExtra("SEARCH_BASE_FACETS") != null)
        {
            e = (ArrayList)getIntent().getSerializableExtra("SEARCH_BASE_FACETS");
        }
        if (bundle.containsKey("SEARCH_BASE_SORT_OPTIONS") && getIntent().getSerializableExtra("SEARCH_BASE_SORT_OPTIONS") != null)
        {
            f = (ArrayList)getIntent().getSerializableExtra("SEARCH_BASE_SORT_OPTIONS");
        }
        if (bundle.containsKey("IS_OUTLET_ITEMS"))
        {
            m = getIntent().getExtras().getString("IS_OUTLET_ITEMS");
        }
        if (e == null)
        {
            e = b;
        }
        if (f == null)
        {
            f = c;
        }
        b();
        a();
        a = (BBYTextView)findViewById(0x7f0c02f4);
        bundle = (new StringBuilder()).append("<span class='bold'>").append(g).append(" </span>").append("Results").toString();
        try
        {
            lt.a(this, a, bundle, 300);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (n != null && !n.getValue().equals("Best-Selling") || d != null && !d.isEmpty())
        {
            findViewById(0x7f0c02f6).setVisibility(0);
        } else
        {
            findViewById(0x7f0c02f6).setVisibility(8);
        }
        findViewById(0x7f0c02f6).setOnClickListener(this);
        findViewById(0x7f0c02f5).setOnClickListener(this);
        h = new SearchPLPNarrowResultsFilterFragment(e, f, b, d, n, c, j, i, l, m);
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.replace(0x7f0c02f7, h, "SearchPLPNarrowResultsFilterFragment");
        bundle.commit();
    }

    protected void onPause()
    {
        super.onPause();
        lu.a();
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
    }
}
