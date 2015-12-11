// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishListCompleteData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import cz;
import fr;
import java.util.ArrayList;
import jd;
import js;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            BuyerRegistryAndWishListFragment, RegistryFragmentContainer

public class RegistrySearchResults extends BBYBaseFragment
    implements cg
{

    private cz a;
    private ListView b;
    private BBYTextView c;
    private BBYTextView g;
    private BBYTextView h;
    private String i;
    private RegistryWishList j;
    private boolean k;
    private View l;
    private View m;
    private LinearLayout n;
    private RegistryWishListCompleteData o;
    private ArrayList p;
    private String q;
    private String r;

    public RegistrySearchResults()
    {
    }

    public RegistrySearchResults(String s, boolean flag, String s1, String s2)
    {
        i = s;
        k = flag;
        q = s1;
        r = s2;
    }

    static RegistryWishList a(RegistrySearchResults registrysearchresults, RegistryWishList registrywishlist)
    {
        registrysearchresults.j = registrywishlist;
        return registrywishlist;
    }

    static ArrayList a(RegistrySearchResults registrysearchresults)
    {
        return registrysearchresults.p;
    }

    static RegistryWishList b(RegistrySearchResults registrysearchresults)
    {
        return registrysearchresults.j;
    }

    public void a(RegistryWishListCompleteData registrywishlistcompletedata)
    {
        o = registrywishlistcompletedata;
        if (!k)
        {
            p.addAll(registrywishlistcompletedata.getRegistryWishlistArray());
            BBYTextView bbytextview = g;
            int i1;
            if (p.size() > 1)
            {
                registrywishlistcompletedata = " Registries found for ";
            } else
            {
                registrywishlistcompletedata = " Registry found for ";
            }
            bbytextview.setText(registrywishlistcompletedata);
        } else
        {
            for (int j1 = 0; j1 < registrywishlistcompletedata.getRegistryWishlistArray().size(); j1++)
            {
                if (!((RegistryWishList)registrywishlistcompletedata.getRegistryWishlistArray().get(j1)).getType().equals("weddingregistrylists"))
                {
                    p.add(registrywishlistcompletedata.getRegistryWishlistArray().get(j1));
                }
            }

            BBYTextView bbytextview1 = g;
            if (p.size() > 1)
            {
                registrywishlistcompletedata = " Wish Lists found for ";
            } else
            {
                registrywishlistcompletedata = " Wish List found for ";
            }
            bbytextview1.setText(registrywishlistcompletedata);
        }
        i1 = p.size();
        m.setVisibility(0);
        c.setText(Integer.toString(i1));
        if (!q.isEmpty() && !r.isEmpty())
        {
            h.setText((new StringBuilder()).append("\"").append(q).append(" ").append(r).append("\"").toString());
        } else
        {
            h.setText((new StringBuilder()).append("\"").append(i).append("\"").toString());
        }
        a = new cz(getActivity(), 0x7f0300e4, p, k);
        b.setAdapter(a);
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RegistrySearchResults a;

            public void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                if (k1 < RegistrySearchResults.a(a).size())
                {
                    RegistrySearchResults.a(a, (RegistryWishList)RegistrySearchResults.a(a).get(k1));
                    (new jd(a.d, a, fr.d(), RegistrySearchResults.b(a).getUuid(), RegistrySearchResults.b(a).getType(), false, null)).executeOnExecutor(nb.g, new Void[0]);
                }
            }

            
            {
                a = RegistrySearchResults.this;
                super();
            }
        });
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null && !arraylist.isEmpty() && arraylist.size() > 0)
        {
            arraylist = new BuyerRegistryAndWishListFragment(d, this, arraylist, j, k);
            android.support.v4.app.Fragment fragment = getParentFragment();
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(arraylist, true);
            }
            return;
        }
        arraylist = new android.app.AlertDialog.Builder(d);
        if (k)
        {
            arraylist.setMessage(Html.fromHtml(d.getResources().getString(0x7f08026e))).setCancelable(false).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f080284)), new android.content.DialogInterface.OnClickListener() {

                final RegistrySearchResults a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = RegistrySearchResults.this;
                super();
            }
            });
        } else
        {
            arraylist.setMessage(Html.fromHtml(d.getResources().getString(0x7f080270))).setCancelable(false).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f080284)), new android.content.DialogInterface.OnClickListener() {

                final RegistrySearchResults a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = RegistrySearchResults.this;
                super();
            }
            });
        }
        arraylist = arraylist.create();
        arraylist.show();
        ((TextView)arraylist.findViewById(0x102000b)).setGravity(17);
    }

    public void g()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        BBYBaseFragmentActivity bbybasefragmentactivity = (BBYBaseFragmentActivity)activity;
        String s;
        if (k)
        {
            s = "Wish List Search Results";
        } else
        {
            s = "Registry Search Results";
        }
        bbybasefragmentactivity.updateActionBarTitle(s);
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e5, viewgroup, false);
        if (layoutinflater != null)
        {
            n = (LinearLayout)layoutinflater.findViewById(0x7f0c0386);
            c = (BBYTextView)layoutinflater.findViewById(0x7f0c0388);
            g = (BBYTextView)layoutinflater.findViewById(0x7f0c0389);
            h = (BBYTextView)layoutinflater.findViewById(0x7f0c038a);
            l = layoutinflater.findViewById(0x7f0c0064);
            m = layoutinflater.findViewById(0x7f0c0047);
            b = (ListView)layoutinflater.findViewById(0x7f0c004d);
            n.setOnClickListener(new android.view.View.OnClickListener() {

                final RegistrySearchResults a;

                public void onClick(View view)
                {
                }

            
            {
                a = RegistrySearchResults.this;
                super();
            }
            });
        }
        a = null;
        o = new RegistryWishListCompleteData();
        p = new ArrayList();
        if (i == null || i != null && i.isEmpty())
        {
            if (!k)
            {
                g.setText("0 Registries found for \"\"");
            } else
            {
                g.setText("0 Wish Lists found for \"\"");
            }
            m.setVisibility(0);
            return layoutinflater;
        } else
        {
            (new js(d, this, i, k, l, 999, "")).executeOnExecutor(nb.g, new Void[0]);
            return layoutinflater;
        }
    }

    public void onResume()
    {
        super.onResume();
        BBYBaseFragmentActivity bbybasefragmentactivity = (BBYBaseFragmentActivity)getActivity();
        String s;
        if (k)
        {
            s = "Wish List Search Results";
        } else
        {
            s = "Registry Search Results";
        }
        bbybasefragmentactivity.updateActionBarTitle(s);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }
}
