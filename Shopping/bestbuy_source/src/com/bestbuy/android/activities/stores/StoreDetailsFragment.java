// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.deals.StoreDeals;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dy;
import hg;
import hm;
import ih;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import jx;
import kf;
import lf;
import lg;
import lh;
import ll;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            DialogSpinner, StoresOutletFragment

public class StoreDetailsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, lg
{

    private BBYStore a;
    private BBYProductViewPager b;
    private LinearLayout c;
    private LinearLayout g;
    private LinearLayout h;
    private hm i;
    private String j;
    private View k;
    private View l;
    private nb m;
    private View n;
    private RelativeLayout o;
    private RelativeLayout p;
    private DialogSpinner q;
    private ArrayList r;
    private StoreDeals s;
    private RelativeLayout t;
    private String u;
    private LinearLayout v;
    private FrameLayout w;
    private dy x;

    public StoreDetailsFragment()
    {
    }

    public StoreDetailsFragment(BBYStore bbystore, String s1, boolean flag)
    {
        j = s1;
        a = bbystore;
    }

    public StoreDetailsFragment(String s1, boolean flag)
    {
        j = s1;
    }

    static ArrayList a(StoreDetailsFragment storedetailsfragment)
    {
        return storedetailsfragment.r;
    }

    private void a(Uri uri)
    {
        (new lf(d, uri, u, this)).show();
    }

    static View b(StoreDetailsFragment storedetailsfragment)
    {
        return storedetailsfragment.l;
    }

    static StoreDeals c(StoreDetailsFragment storedetailsfragment)
    {
        return storedetailsfragment.s;
    }

    static BBYStore d(StoreDetailsFragment storedetailsfragment)
    {
        return storedetailsfragment.a;
    }

    private void d()
    {
        Object obj = new android.app.AlertDialog.Builder(d);
        String s1 = a.getStoreDetails().getPhone().replaceAll("\\D", "");
        s1 = (new StringBuilder()).append("(").append(s1.substring(0, 3)).append(") ").append(s1.substring(3, 6)).append("-").append(s1.substring(6, 10)).toString();
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml((new StringBuilder()).append("<font face = 'Sans-Serif'>").append(s1).append("</font>").toString()));
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(Html.fromHtml(d.getResources().getString(0x7f0800e0)), new android.content.DialogInterface.OnClickListener() {

            final StoreDetailsFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(StoreDetailsFragment.d(a).getStoreDetails().getPhone()).toString()));
                a.d.startActivity(intent);
                dialoginterface.cancel();
            }

            
            {
                a = StoreDetailsFragment.this;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final StoreDetailsFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
            }

            
            {
                a = StoreDetailsFragment.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }

    public void a(StoreDeals storedeals)
    {
        s = storedeals;
        q.setVisibility(0);
        r = storedeals.getCategories();
        if (r != null)
        {
            int i1 = r.indexOf("site_wide");
            if (i1 >= 0)
            {
                Collections.swap(r, 0, i1);
            }
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = r.iterator(); iterator.hasNext(); arraylist.add(storedeals.replace("&amp;", "&")))
            {
                String s1 = (String)iterator.next();
                storedeals = s1;
                if (s1.equals("site_wide"))
                {
                    storedeals = s1.replace("site_wide", "All Products");
                }
            }

            storedeals = new ArrayAdapter(d, 0x7f03002c, arraylist);
            storedeals.setDropDownViewResource(0x1090009);
            q.setAdapter(storedeals);
        }
        if (r != null && r.size() == 1 && r.contains("error"))
        {
            q.setVisibility(8);
            t.setVisibility(0);
        }
    }

    public void a(Store store)
    {
        (new lh(d, a, store)).show();
    }

    public void a(BBYStore bbystore)
    {
        if (k != null)
        {
            k.setVisibility(8);
        }
        a = bbystore;
        String.format(d.getResources().getString(0x7f080344), new Object[] {
            bbystore.getStoreId()
        });
        String s1;
        if (bbystore.getStoreDetails().getLocationSubType().equals("Mobile Store"))
        {
            ((BBYTextView)n.findViewById(0x7f0c03d3)).setText("MOST POPULAR");
            n.findViewById(0x7f0c03d2).setBackgroundResource(0x7f02001a);
            o.setBackgroundResource(0x7f020031);
            (new hg(d, this, l, "abcat0800000", null, 1, 10, false)).executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((BBYTextView)n.findViewById(0x7f0c03d3)).setText("BEST DEALS HERE");
            n.findViewById(0x7f0c03d2).setBackgroundResource(0x7f020022);
            i = new hm(d, this, l, bbystore.getStoreId());
            i.executeOnExecutor(nb.h, new Void[0]);
        }
        ((BBYTextView)n.findViewById(0x7f0c010e)).setText(Html.fromHtml("<i>Welcome to: </i>"));
        s1 = bbystore.getStoreDetails().getName().toUpperCase().replace(" - ", "\n");
        if (bbystore.getStoreDetails().getLocationSubType().equals("Mobile Store"))
        {
            ((BBYTextView)n.findViewById(0x7f0c03d0)).setText((new StringBuilder()).append("BEST BUY MOBILE \n").append(s1).toString());
        } else
        {
            ((BBYTextView)n.findViewById(0x7f0c03d0)).setText(s1);
        }
        u = (new StringBuilder()).append(bbystore.getStoreDetails().getAddress()).append("\n").append(bbystore.getStoreDetails().getCity()).append(", ").append(bbystore.getStoreDetails().getState()).append(" ").append(bbystore.getStoreDetails().getZipCode()).toString();
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            x = new dy(d, arraylist, this, true, "stores");
            b.setAdapter(x);
            b.startAnimation(ll.a(d));
            if (arraylist.size() == 1)
            {
                b.setPagingEnabled(false);
            }
            t.setVisibility(8);
            b.setVisibility(0);
            if (a.getStoreDetails().getLocationSubType().equals("Mobile Store"))
            {
                ((HomeActivity)d).loadMostPopularRecommendations("store", "storeloadmostpopular", arraylist);
            }
            return;
        } else
        {
            b.setVisibility(8);
            t.setVisibility(0);
            return;
        }
    }

    public void a(boolean flag)
    {
    }

    public void b()
    {
        if (w != null)
        {
            ll.a(w);
        }
    }

    public BBYStore c()
    {
        return a;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        m = nb.a();
        bundle = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
        m.i(bundle);
        ((BBYBaseFragmentActivity)d).hideStoresSearchActionBar(d);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        if (view == c)
        {
            if (j != null && !j.isEmpty())
            {
                (new jx(d, this, k, j)).executeOnExecutor(nb.h, new Void[0]);
            }
        } else
        {
            if (view == h)
            {
                view = (new StringBuilder()).append(a.getStoreDetails().getAddress()).append(", ").append(a.getStoreDetails().getCity()).append(", ").append(a.getStoreDetails().getState()).append(" ").append(a.getStoreDetails().getZipCode()).toString();
                view = Uri.parse((new StringBuilder()).append(d.getResources().getString(0x7f0801d0)).append(m.y()).append(",").append(m.z()).append("&daddr=").append(view).append("&hl=en").toString());
                kf.b(getClass().getName(), (new StringBuilder()).append("The BBYStore driving url is ").append(view).toString());
                a(view);
                return;
            }
            if (view == g)
            {
                d();
                return;
            }
            if (view != p && view == v)
            {
                view = new PLPFragmentContainer();
                PLPFragment plpfragment = new PLPFragment(true, "MostPopular", "Most Popular", "abcat0800000", null, "Stores", 10);
                ((BaseTabContainer)getParentFragment()).a(view, true);
                view.a(plpfragment, true);
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
        if (n == null)
        {
            n = layoutinflater.inflate(0x7f030102, viewgroup, false);
            m = nb.a();
            c = (LinearLayout)n.findViewById(0x7f0c02ed);
            g = (LinearLayout)n.findViewById(0x7f0c014f);
            h = (LinearLayout)n.findViewById(0x7f0c03d1);
            k = n.findViewById(0x7f0c0064);
            l = n.findViewById(0x7f0c0064);
            w = (FrameLayout)n.findViewById(0x7f0c0071);
            c.setOnClickListener(this);
            g.setOnClickListener(this);
            h.setOnClickListener(this);
            b = (BBYProductViewPager)n.findViewById(0x7f0c005e);
            o = (RelativeLayout)n.findViewById(0x7f0c03cf);
            t = (RelativeLayout)n.findViewById(0x7f0c03d5);
            q = (DialogSpinner)n.findViewById(0x7f0c03d4);
            p = (RelativeLayout)n.findViewById(0x7f0c03d7);
            p.setOnClickListener(this);
            layoutinflater = new StoresOutletFragment(true, "MORE DEALS HERE", a.getStoreId());
            v = (LinearLayout)n.findViewById(0x7f0c0073);
            v.setOnClickListener(this);
            getChildFragmentManager().beginTransaction().add(0x7f0c03d6, layoutinflater).commit();
            if (a == null && j != null && !j.isEmpty())
            {
                (new jx(d, this, k, j)).executeOnExecutor(nb.h, new Void[0]);
            } else
            {
                a(a);
            }
            d.getActionBar().setTitle("");
            ((ViewGroup)p.getParent()).setVisibility(8);
            q.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                final StoreDetailsFragment a;

                public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
                {
                    adapterview = (String)StoreDetailsFragment.a(a).get(i1);
                    (new ih(a.d, a, StoreDetailsFragment.b(a), (ArrayList)StoreDetailsFragment.c(a).getDeals().get(adapterview))).executeOnExecutor(nb.h, new Void[0]);
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                a = StoreDetailsFragment.this;
                super();
            }
            });
        } else
        {
            ((ViewGroup)n.getParent()).removeView(n);
        }
        w.setVisibility(0);
        return n;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(m.T());
        ((BBYBaseFragmentActivity)d).showActionBarHome();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
        if (l() && a == null && j != null && !j.isEmpty())
        {
            (new jx(d, this, k, j)).executeOnExecutor(nb.h, new Void[0]);
        }
        if (x != null)
        {
            x.notifyDataSetChanged();
        }
    }
}
