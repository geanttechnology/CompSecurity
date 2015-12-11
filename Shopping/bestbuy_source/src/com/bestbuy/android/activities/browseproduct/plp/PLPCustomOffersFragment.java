// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import dw;
import hf;
import hh;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kf;
import nb;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class PLPCustomOffersFragment extends BBYBaseFragment
{

    private View a;
    private ListView b;
    private View c;
    private hf g;
    private dw h;
    private ArrayList i;
    private String j;
    private nb k;
    private RelativeLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private ImageView o;
    private String p;
    private String q;

    static ArrayList a(PLPCustomOffersFragment plpcustomoffersfragment)
    {
        return plpcustomoffersfragment.i;
    }

    private void a(MdotWebFragment mdotwebfragment)
    {
        try
        {
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            android.support.v4.app.Fragment fragment = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (fragment instanceof HomeTabFragment)
            {
                ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(mdotwebfragment, true);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MdotWebFragment mdotwebfragment)
        {
            kf.e("PLPCustomOffersFragment", (new StringBuilder()).append("Error attempting to open delievery mDot punch out").append(mdotwebfragment.getLocalizedMessage()).toString());
        }
    }

    public void a(String s)
    {
        if (!s.startsWith("/si/")) goto _L2; else goto _L1
_L1:
        g = new hf(d, this, s, "Best-Match", 20, 1, false, null, false);
        g.execute(new Void[0]);
_L4:
        return;
_L2:
        if (!s.startsWith("/site/"))
        {
            continue; /* Loop/switch isn't completed */
        }
        NameValuePair namevaluepair;
        if (s.contains(".p?") && s.contains("skuId"))
        {
            s = URLEncodedUtils.parse(URI.create(s), "UTF-8").iterator();
            do
            {
                if (!s.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                namevaluepair = (NameValuePair)s.next();
            } while (!namevaluepair.getName().equals("skuId"));
            break; /* Loop/switch isn't completed */
        } else
        {
            MdotWebFragment mdotwebfragment = new MdotWebFragment(false);
            Bundle bundle = new Bundle();
            bundle.putString(getResources().getString(0x7f080055), (new StringBuilder()).append("http://www.bestbuy.com").append(s).toString());
            mdotwebfragment.setArguments(bundle);
            a(mdotwebfragment);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = namevaluepair.getValue();
        ((HomeActivity)d).openPDP(s, "", true);
        return;
    }

    public void a(List list, boolean flag)
    {
        if (p == null) goto _L2; else goto _L1
_L1:
        n.setVisibility(0);
        if (!p.equals(getString(0x7f080077))) goto _L4; else goto _L3
_L3:
        o.setImageResource(0x7f020168);
_L6:
        b.setVisibility(0);
        l.setVisibility(8);
        h = new dw(d, this, 0x7f0300bb, list);
        b.setAdapter(h);
        return;
_L4:
        if (p.equals(getString(0x7f080075)))
        {
            o.setImageResource(0x7f020158);
        } else
        if (p.equals(getString(0x7f08012a)))
        {
            o.setImageResource(0x7f02007a);
        } else
        if (p.equals(getString(0x7f08006c)))
        {
            o.setImageResource(0x7f020133);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        n.setVisibility(8);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHome();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        ((BBYBaseFragmentActivity)activity).changeActionBarAddToVisibility(activity, false);
        k = nb.a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            a = layoutinflater.inflate(0x7f0300ba, viewgroup, false);
            c = a.findViewById(0x7f0c0064);
            m = (LinearLayout)a.findViewById(0x7f0c00bd);
            b = (ListView)a.findViewById(0x7f0c0075);
            l = (RelativeLayout)a.findViewById(0x7f0c00b9);
            ((RelativeLayout)a.findViewById(0x7f0c00be)).setVisibility(8);
            o = (ImageView)a.findViewById(0x7f0c00c2);
            n = (LinearLayout)a.findViewById(0x7f0c00c1);
            b.setSelection(0x80000000);
            (new hh(d, this, c, q)).executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PLPCustomOffersFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (BBYProduct)PLPCustomOffersFragment.a(a).get(i1);
                ((HomeActivity)a.d).openPDP(adapterview.getSummary().getSkuId(), "", (new StringBuilder()).append("").append(adapterview.getSummary().getProductId()).toString(), false, false);
            }

            
            {
                a = PLPCustomOffersFragment.this;
                super();
            }
        });
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        String s = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
        k.i(s);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(j);
    }
}
