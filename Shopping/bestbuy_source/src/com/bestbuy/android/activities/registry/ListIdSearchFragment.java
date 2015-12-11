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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import cg;
import ch;
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

public class ListIdSearchFragment extends BBYBaseFragment
    implements cg, ch
{

    private BBYTextView a;
    private BBYTextView b;
    private BBYTextView c;
    private View g;
    private ListView h;
    private String i;
    private cz j;
    private boolean k;
    private RegistryWishList l;
    private View m;
    private LinearLayout n;
    private RegistryWishListCompleteData o;

    public ListIdSearchFragment()
    {
        o = new RegistryWishListCompleteData();
    }

    public ListIdSearchFragment(boolean flag, String s)
    {
        o = new RegistryWishListCompleteData();
        k = flag;
        i = s;
    }

    static RegistryWishList a(ListIdSearchFragment listidsearchfragment)
    {
        return listidsearchfragment.l;
    }

    static RegistryWishList a(ListIdSearchFragment listidsearchfragment, RegistryWishList registrywishlist)
    {
        listidsearchfragment.l = registrywishlist;
        return registrywishlist;
    }

    static View b(ListIdSearchFragment listidsearchfragment)
    {
        return listidsearchfragment.g;
    }

    public void a(RegistryWishListCompleteData registrywishlistcompletedata)
    {
        ArrayList arraylist = new ArrayList();
        Object obj;
        if (!k)
        {
            arraylist = registrywishlistcompletedata.getRegistryWishlistArray();
            BBYTextView bbytextview = b;
            int i1;
            if (arraylist.size() > 1)
            {
                obj = " Registries found for ";
            } else
            {
                obj = " Registry found for ";
            }
            bbytextview.setText(((String) (obj)));
            obj = arraylist;
        } else
        {
            for (int j1 = 0; j1 < registrywishlistcompletedata.getRegistryWishlistArray().size(); j1++)
            {
                if (!((RegistryWishList)registrywishlistcompletedata.getRegistryWishlistArray().get(j1)).getType().equals("weddingregistrylists"))
                {
                    arraylist.add(registrywishlistcompletedata.getRegistryWishlistArray().get(j1));
                }
            }

            BBYTextView bbytextview1 = b;
            if (arraylist.size() > 1)
            {
                obj = " WishLists found for ";
            } else
            {
                obj = " WishList found for ";
            }
            bbytextview1.setText(((String) (obj)));
            obj = arraylist;
        }
        i1 = ((ArrayList) (obj)).size();
        a.setText(Integer.toString(i1));
        c.setText((new StringBuilder()).append("\"").append(i).append("\"").toString());
        j = new cz(getActivity(), 0x7f0300e4, ((ArrayList) (obj)), k);
        j.notifyDataSetChanged();
        h.setAdapter(j);
        h.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(registrywishlistcompletedata) {

            final RegistryWishListCompleteData a;
            final ListIdSearchFragment b;

            public void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                if (k1 < a.getRegistryWishlistArray().size())
                {
                    ListIdSearchFragment.a(b, (RegistryWishList)a.getRegistryWishlistArray().get(k1));
                    (new jd(b.d, b, fr.d(), ListIdSearchFragment.a(b).getUuid(), ListIdSearchFragment.a(b).getType(), false, ListIdSearchFragment.b(b))).executeOnExecutor(nb.g, new Void[0]);
                }
            }

            
            {
                b = ListIdSearchFragment.this;
                a = registrywishlistcompletedata;
                super();
            }
        });
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            arraylist = new BuyerRegistryAndWishListFragment(d, this, arraylist, l, k);
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

                final ListIdSearchFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = ListIdSearchFragment.this;
                super();
            }
            });
        } else
        {
            arraylist.setMessage(Html.fromHtml(d.getResources().getString(0x7f080270))).setCancelable(false).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f080284)), new android.content.DialogInterface.OnClickListener() {

                final ListIdSearchFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = ListIdSearchFragment.this;
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
        HomeActivity.inListIdSearchFragment = true;
        if (k)
        {
            ((BBYBaseFragmentActivity)activity).updateActionBarTitle("Search List ID");
        } else
        {
            ((BBYBaseFragmentActivity)activity).updateActionBarTitle("Search Registry ID");
        }
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d.getWindow().setSoftInputMode(3);
        layoutinflater = layoutinflater.inflate(0x7f0300e5, viewgroup, false);
        if (layoutinflater != null)
        {
            n = (LinearLayout)layoutinflater.findViewById(0x7f0c0386);
            a = (BBYTextView)layoutinflater.findViewById(0x7f0c0388);
            b = (BBYTextView)layoutinflater.findViewById(0x7f0c0389);
            c = (BBYTextView)layoutinflater.findViewById(0x7f0c038a);
            g = layoutinflater.findViewById(0x7f0c0064);
            h = (ListView)layoutinflater.findViewById(0x7f0c004d);
            m = layoutinflater.findViewById(0x7f0c0047);
            if (i == null || i != null && i.isEmpty())
            {
                if (!k)
                {
                    b.setText("0 Registries found for \"\"");
                } else
                {
                    b.setText("0 Wish Lists found for \"\"");
                }
                m.setVisibility(0);
            } else
            {
                (new js(d, this, i, k, g, 999, "")).executeOnExecutor(nb.g, new Void[0]);
            }
            n.setOnClickListener(new android.view.View.OnClickListener() {

                final ListIdSearchFragment a;

                public void onClick(View view)
                {
                }

            
            {
                a = ListIdSearchFragment.this;
                super();
            }
            });
        }
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        HomeActivity.inListIdSearchFragment = false;
    }

    public void onResume()
    {
        super.onResume();
        if (k)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Search List ID");
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Search Registry ID");
        }
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
    }
}
