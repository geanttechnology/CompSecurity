// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import ca;
import com.bestbuy.android.api.lib.models.solr.Facet;
import com.bestbuy.android.api.lib.models.solr.SolrRequestInfo;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import com.bestbuy.android.api.lib.models.solr.SortOption;
import com.bestbuy.android.api.lib.models.solr.Value;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lt;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPNarrowResultsFilterFragment

public class PLPSortAndFilterActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener, ca
{

    private BBYTextView a;
    private ArrayList b;
    private ArrayList c;
    private HashMap d;
    private ArrayList e;
    private ArrayList f;
    private SortOption g;
    private int h;
    private PLPNarrowResultsFilterFragment i;
    private ArrayList j;
    private String k;
    private nb l;
    private String m;
    private String n;

    public PLPSortAndFilterActivity()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = 0;
        j = new ArrayList();
    }

    private void a()
    {
        HashSet hashset = new HashSet();
        for (int i1 = 0; i1 < f.size(); i1++)
        {
            hashset.add(((SortOption)f.get(i1)).getValue());
        }

        Iterator iterator = c.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SortOption sortoption = (SortOption)iterator.next();
            if (hashset.add(sortoption.getValue()))
            {
                f.add(sortoption);
            }
        } while (true);
    }

    private void a(ArrayList arraylist)
    {
        Value value;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); j.add(value.getValue()))
        {
            value = (Value)arraylist.next();
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
                    Facet facet = (Facet)iterator.next();
                    arraylist.add(facet);
                    ArrayList arraylist2 = facet.getValues();
                    if (arraylist2 != null && !arraylist2.isEmpty())
                    {
                        hashmap.put(facet.getDisplayName(), arraylist2);
                    }
                } while (true);
            }
            int i1 = 0;
            while (i1 < e.size()) 
            {
                Object obj = (Facet)e.get(i1);
                if (!hashmap.containsKey(((Facet) (obj)).getDisplayName()))
                {
                    a(((Facet) (obj)).getValues());
                } else
                {
                    ArrayList arraylist1 = (ArrayList)hashmap.get(((Facet) (obj)).getDisplayName());
                    obj = ((Facet) (obj)).getValues();
                    int j1 = 0;
                    while (j1 < ((ArrayList) (obj)).size()) 
                    {
                        Value value = (Value)((ArrayList) (obj)).get(j1);
                        int k1 = 0;
                        boolean flag = false;
                        for (; k1 < arraylist1.size(); k1++)
                        {
                            Value value1 = (Value)arraylist1.get(k1);
                            if (value1.getValue().equals(value.getValue()))
                            {
                                ((ArrayList) (obj)).set(j1, value1);
                                flag = true;
                            }
                        }

                        if (!flag)
                        {
                            j.add(value.getValue());
                        }
                        j1++;
                    }
                }
                i1++;
            }
        }
    }

    public void a(ArrayList arraylist, String s)
    {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("SELECTED_FACETS", arraylist);
        intent.putExtra("SORT_ORDER", s);
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
            view.putExtra("SORT_ORDER", i.d());
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
        l = nb.a();
        if (!bundle.getBoolean("isSearch"))
        {
            if (bundle.containsKey("SOLR_RESPONSE"))
            {
                SolrResponse solrresponse = (SolrResponse)getIntent().getSerializableExtra("SOLR_RESPONSE");
                if (solrresponse != null)
                {
                    b = solrresponse.getFacets();
                    c = solrresponse.getSortOptions();
                    if (solrresponse.getRequestInfo() != null)
                    {
                        d = solrresponse.getRequestInfo().getRequestedFacets();
                        g = solrresponse.getRequestInfo().getSortOption();
                    }
                    h = solrresponse.getTotalCount();
                    k = solrresponse.getRequestInfo().getQueryString();
                    l.a(solrresponse.getCategoryMap());
                }
            }
            if (bundle.containsKey("SELECTED_CATEGORY"))
            {
                m = "";
            }
            if (bundle.containsKey("BASE_FACETS") && getIntent().getSerializableExtra("BASE_FACETS") != null)
            {
                e = (ArrayList)getIntent().getSerializableExtra("BASE_FACETS");
            }
            if (bundle.containsKey("BASE_SORT_OPTIONS") && getIntent().getSerializableExtra("BASE_SORT_OPTIONS") != null)
            {
                f = (ArrayList)getIntent().getSerializableExtra("BASE_SORT_OPTIONS");
            }
            if (bundle.containsKey("IS_OUTLET_ITEMS"))
            {
                n = getIntent().getExtras().getString("IS_OUTLET_ITEMS");
            }
            if (e == null)
            {
                e = b;
            }
            if (f == null)
            {
                f = c;
            }
        }
        b();
        a();
        a = (BBYTextView)findViewById(0x7f0c02f4);
        bundle = (new StringBuilder()).append("<span class='bold'>").append(h).append(" </span>").append("Results").toString();
        try
        {
            lt.a(this, a, bundle, 300);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (g != null && !g.getValue().equals("Best-Selling") || d != null && !d.isEmpty())
        {
            findViewById(0x7f0c02f6).setVisibility(0);
        } else
        {
            findViewById(0x7f0c02f6).setVisibility(8);
        }
        findViewById(0x7f0c02f6).setOnClickListener(this);
        findViewById(0x7f0c02f5).setOnClickListener(this);
        i = new PLPNarrowResultsFilterFragment(e, f, b, d, g, c, k, j, m, n);
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.replace(0x7f0c02f7, i, "PLPNarrowResultsFilterFragment");
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
