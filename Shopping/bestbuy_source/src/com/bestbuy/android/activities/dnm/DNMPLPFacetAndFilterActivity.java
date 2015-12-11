// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import cb;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.api.lib.models.dnm.DNMSortOption;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMPLPNarrowFacetFragment

public class DNMPLPFacetAndFilterActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener, cb
{

    private nb a;
    private ArrayList b;
    private ArrayList c;
    private DNMPLPNarrowFacetFragment d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private String h;
    private String i;
    private double j;
    private double k;
    private int l;
    private String m;
    private String n;
    private String o;
    private DNMResponse p;

    public DNMPLPFacetAndFilterActivity()
    {
        b = new ArrayList();
    }

    public void a(ArrayList arraylist, String s, ArrayList arraylist1)
    {
        Intent intent = new Intent();
        intent.putExtra("SELECTED_FACETS", arraylist);
        intent.putExtra("SORT_ORDER", s);
        intent.putExtra("BASE_FACETS", arraylist1);
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
        a = nb.a();
        if (bundle != null)
        {
            h = getIntent().getStringExtra("STORE_ID");
            j = getIntent().getDoubleExtra("LAT", 0.0D);
            k = getIntent().getDoubleExtra("LNG", 0.0D);
            l = getIntent().getIntExtra("RADIUS", 0);
            m = getIntent().getStringExtra("DNM_TYPE");
            o = getIntent().getStringExtra("SEARCH_QUERY");
            n = getIntent().getStringExtra("SELECTED_SORT_OPTION");
        }
        if (bundle != null && bundle.containsKey("DNM_RESPONSE"))
        {
            p = (DNMResponse)getIntent().getSerializableExtra("DNM_RESPONSE");
            f = p.getFacetsFilters();
            c = p.getSortOptions();
            g = p.getSelectedFilters();
            if (g == null || g.isEmpty())
            {
                g = (ArrayList)getIntent().getSerializableExtra("SELECTED_FACETS");
            }
        }
        if (bundle != null && bundle.containsKey("DNM_BASE_FACETS"))
        {
            e = (ArrayList)getIntent().getSerializableExtra("DNM_BASE_FACETS");
        }
        if (n == null || n.isEmpty() || n.equals(getString(0x7f080068)))
        {
            n = "rating";
        }
        if (g != null)
        {
            bundle = g.iterator();
            do
            {
                if (!bundle.hasNext())
                {
                    break;
                }
                DNMFacetFilter dnmfacetfilter = (DNMFacetFilter)bundle.next();
                if (dnmfacetfilter.getFacetTitle() != null && dnmfacetfilter.getFacetTitle().equals("Store") && p.getDnmProducts() != null)
                {
                    Iterator iterator = p.getDnmProducts().iterator();
                    if (iterator.hasNext())
                    {
                        i = ((DNMProduct)iterator.next()).getStoreName();
                    }
                    dnmfacetfilter.setDisplayText(i);
                }
            } while (true);
        }
        DNMSortOption dnmsortoption = new DNMSortOption();
        Iterator iterator1 = c.iterator();
        do
        {
            bundle = dnmsortoption;
            if (!iterator1.hasNext())
            {
                break;
            }
            bundle = (DNMSortOption)iterator1.next();
        } while (!bundle.getValue().equals(n));
        findViewById(0x7f0c02f6).setOnClickListener(this);
        findViewById(0x7f0c02f5).setOnClickListener(this);
        d = new DNMPLPNarrowFacetFragment(e, f, c, g, bundle, h, j, k, l, m, o);
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.replace(0x7f0c02f7, d, "PLPNarrowResultsFilterFragment");
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
