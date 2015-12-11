// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.bestbuy.android.activities.mybby.MyBBYListIdActivity;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dg;
import java.util.ArrayList;
import java.util.HashMap;
import jn;
import ll;
import lu;
import nb;

public class BuyerRegistryAndWishListFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private android.widget.AdapterView.OnItemSelectedListener A = new android.widget.AdapterView.OnItemSelectedListener() {

        final BuyerRegistryAndWishListFragment a;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = (String)BuyerRegistryAndWishListFragment.a(a).getAdapter().getItem(i1);
            if (adapterview.equals("All Gifts") || adapterview.equals("All Items"))
            {
                BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, BuyerRegistryAndWishListFragment.d(a), BuyerRegistryAndWishListFragment.e(a), 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
            } else
            {
                if (adapterview.equals("Favorite Items") || adapterview.equals("Favorite Gifts"))
                {
                    adapterview = new ArrayList();
                    view = new ArrayList();
                    for (i1 = 0; i1 < BuyerRegistryAndWishListFragment.e(a).size(); i1++)
                    {
                        if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i1)).isFavorite())
                        {
                            adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i1));
                            view.add(BuyerRegistryAndWishListFragment.d(a).get(i1));
                        }
                    }

                    BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                    BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                    if (adapterview.size() <= 0)
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                        BuyerRegistryAndWishListFragment.b(a).bringToFront();
                        if (BuyerRegistryAndWishListFragment.h(a))
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Favorite Items");
                            return;
                        } else
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Favorite Gifts");
                            return;
                        }
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                        return;
                    }
                }
                if (adapterview.equals("Purchased Gifts") || adapterview.equals("Purchased Items"))
                {
                    adapterview = new ArrayList();
                    view = new ArrayList();
                    for (i1 = 0; i1 < BuyerRegistryAndWishListFragment.e(a).size(); i1++)
                    {
                        if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i1)).getPurchaseQuantity() > 0)
                        {
                            adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i1));
                            view.add(BuyerRegistryAndWishListFragment.d(a).get(i1));
                        }
                    }

                    BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                    BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                    if (adapterview.size() <= 0)
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                        BuyerRegistryAndWishListFragment.b(a).bringToFront();
                        if (BuyerRegistryAndWishListFragment.h(a))
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Purchased Items");
                            return;
                        } else
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Purchased Gifts");
                            return;
                        }
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                        return;
                    }
                }
                if (adapterview.equals("Not Purchased Gifts") || adapterview.equals("Not Purchased Items"))
                {
                    adapterview = new ArrayList();
                    view = new ArrayList();
                    for (i1 = 0; i1 < BuyerRegistryAndWishListFragment.e(a).size(); i1++)
                    {
                        if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i1)).getPurchaseQuantity() != 0)
                        {
                            continue;
                        }
                        adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i1));
                        if (BuyerRegistryAndWishListFragment.d(a) != null && BuyerRegistryAndWishListFragment.d(a).size() > 0)
                        {
                            view.add(BuyerRegistryAndWishListFragment.d(a).get(i1));
                        }
                    }

                    BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                    BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                    if (adapterview.size() <= 0 || view.size() <= 0)
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                        BuyerRegistryAndWishListFragment.b(a).bringToFront();
                        if (BuyerRegistryAndWishListFragment.h(a))
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Not Purchased Items");
                            return;
                        } else
                        {
                            BuyerRegistryAndWishListFragment.b(a).setText("No Not Purchased Gifts");
                            return;
                        }
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                        return;
                    }
                }
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                a = BuyerRegistryAndWishListFragment.this;
                super();
            }
    };
    private android.widget.AbsListView.OnScrollListener B = new android.widget.AbsListView.OnScrollListener() {

        final BuyerRegistryAndWishListFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (BuyerRegistryAndWishListFragment.k(a) || k1 <= 0 || i1 + j1 != k1)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            i1 = (BuyerRegistryAndWishListFragment.l(a) + 1) * 25;
            k1 = i1 + 25;
            if (BuyerRegistryAndWishListFragment.e(a) == null || BuyerRegistryAndWishListFragment.e(a).size() <= i1)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            abslistview = new ArrayList();
            do
            {
label0:
                {
                    if (BuyerRegistryAndWishListFragment.e(a).size() > k1)
                    {
                        j1 = k1;
                    } else
                    {
                        j1 = BuyerRegistryAndWishListFragment.e(a).size();
                    }
                    if (i1 >= j1)
                    {
                        break label0;
                    }
                    abslistview.add(BuyerRegistryAndWishListFragment.e(a).get(i1));
                    i1++;
                }
            } while (true);
            BuyerRegistryAndWishListFragment.m(a);
            BuyerRegistryAndWishListFragment.a(a, true);
            if (abslistview.size() > 0)
            {
                (new jn(BuyerRegistryAndWishListFragment.c(a), a, null, abslistview, false)).executeOnExecutor(nb.h, new Void[0]);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
        }

            
            {
                a = BuyerRegistryAndWishListFragment.this;
                super();
            }
    };
    private Activity a;
    private BBYBaseFragment b;
    private ArrayList c;
    private View g;
    private ImageView h;
    private DialogSpinner i;
    private ListView j;
    private View k;
    private dg l;
    private RegistryWishList m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private ImageView t;
    private ArrayList u;
    private boolean v;
    private BBYTextView w;
    private boolean x;
    private int y;
    private View z;

    public BuyerRegistryAndWishListFragment()
    {
        v = false;
        x = false;
        y = 0;
    }

    public BuyerRegistryAndWishListFragment(Activity activity, BBYBaseFragment bbybasefragment, ArrayList arraylist, RegistryWishList registrywishlist, boolean flag)
    {
        v = false;
        x = false;
        y = 0;
        a = activity;
        b = bbybasefragment;
        c = arraylist;
        m = registrywishlist;
        v = flag;
    }

    static DialogSpinner a(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.i;
    }

    static dg a(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment, dg dg1)
    {
        buyerregistryandwishlistfragment.l = dg1;
        return dg1;
    }

    static boolean a(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment, boolean flag)
    {
        buyerregistryandwishlistfragment.x = flag;
        return flag;
    }

    static BBYTextView b(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.w;
    }

    static Activity c(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.a;
    }

    static ArrayList d(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.u;
    }

    static ArrayList e(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.c;
    }

    static LinearLayout f(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.n;
    }

    static RegistryWishList g(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.m;
    }

    static boolean h(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.v;
    }

    static dg i(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.l;
    }

    static ListView j(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.j;
    }

    static boolean k(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.x;
    }

    static int l(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        return buyerregistryandwishlistfragment.y;
    }

    static int m(BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        int i1 = buyerregistryandwishlistfragment.y;
        buyerregistryandwishlistfragment.y = i1 + 1;
        return i1;
    }

    public void a(String s1)
    {
        int i1 = nb.a().b().getInt("cartQuantity", 0);
        HashMap hashmap = new HashMap();
        if (i1 == 1)
        {
            hashmap.put("bb.scOpen", "1");
        }
        hashmap.put("bb.scAdd", "1");
        hashmap.put("&&products", (new StringBuilder()).append(";[").append(s1).append("];;;;eVar7=[LE]").toString());
        hashmap.put(lu.bp, "LE");
        lu.a(lu.J, hashmap);
        ll.b(o);
    }

    public void a(ArrayList arraylist, ArrayList arraylist1, boolean flag)
    {
        x = false;
        if (u != null && y > 0)
        {
            u.addAll(arraylist);
        } else
        {
            u = arraylist;
        }
        b();
        if (l == null)
        {
            if (arraylist != null && arraylist.size() > 0)
            {
                j.addFooterView(z);
                l = new dg(a, this, 0x7f03011c, u, c, 2, n, m, v);
                j.setAdapter(l);
            } else
            {
                p.setVisibility(0);
                ((BBYTextView)p.findViewById(0x7f0c0085)).setText("No Items added ");
            }
        } else
        if (arraylist != null && arraylist.size() > 0)
        {
            l.notifyDataSetChanged();
        } else
        {
            p.setVisibility(0);
            ((BBYTextView)p.findViewById(0x7f0c0085)).setText("No Items added ");
        }
        if (u.size() < 25 || c.size() == u.size())
        {
            j.removeFooterView(z);
        }
    }

    public void b()
    {
        Object obj = new ArrayList();
        if (v)
        {
            ((ArrayList) (obj)).add("All Items");
            ((ArrayList) (obj)).add("Purchased Items");
            ((ArrayList) (obj)).add("Not Purchased Items");
            ((ArrayList) (obj)).add("Favorite Items");
        } else
        {
            ((ArrayList) (obj)).add("All Gifts");
            ((ArrayList) (obj)).add("Purchased Gifts");
            ((ArrayList) (obj)).add("Not Purchased Gifts");
            ((ArrayList) (obj)).add("Favorite Gifts");
        }
        obj = new ArrayAdapter(a, 0x7f03002c, ((java.util.List) (obj)));
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x1090009);
        i.setAdapter(((SpinnerAdapter) (obj)));
        i.setSelection(0x80000000, false);
        i.setOnItemSelectedListener(A);
    }

    public void b(String s1)
    {
        String s2;
label0:
        {
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s2 = getString(0x7f08009e);
        }
        ((BBYTextView)q.findViewById(0x7f0c0083)).setText(s2);
        ll.b(q);
    }

    public View c()
    {
        return k;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131492982: 
        case 2131492984: 
        case 2131492985: 
        case 2131492986: 
        default:
            return;

        case 2131492983: 
        case 2131492987: 
            view = new Intent(a, com/bestbuy/android/activities/mybby/MyBBYListIdActivity);
            break;
        }
        view.putExtra("FragmentName", "ListIdModalFragment");
        view.putExtra("uuid", m.getUuid());
        view.putExtra("retailListAlias", m.getRetailListAlias());
        view.putExtra("listName", m.getShortDescription());
        view.putExtra("listType", m.getType());
        a.startActivity(view);
        a.overridePendingTransition(0x7f04000e, 0x7f040005);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f03001b, null);
            n = (LinearLayout)g.findViewById(0x7f0c004a);
            s = (RelativeLayout)g.findViewById(0x7f0c0076);
            o = (LinearLayout)g.findViewById(0x7f0c0080);
            q = (LinearLayout)g.findViewById(0x7f0c0082);
            k = g.findViewById(0x7f0c0064);
            p = (LinearLayout)g.findViewById(0x7f0c0084);
            h = (ImageView)g.findViewById(0x7f0c007b);
            i = (DialogSpinner)g.findViewById(0x7f0c007d);
            j = (ListView)g.findViewById(0x7f0c007e);
            j.setOnScrollListener(B);
            w = (BBYTextView)g.findViewById(0x7f0c007f);
            w.setVisibility(8);
            r = (RelativeLayout)g.findViewById(0x7f0c0077);
            r.setOnClickListener(this);
            t = (ImageView)g.findViewById(0x7f0c007b);
            t.setOnClickListener(this);
            s.setOnClickListener(this);
            z = layoutinflater.inflate(0x7f0300bc, null);
            x = true;
            if (c.size() > 25)
            {
                y = 0;
                layoutinflater = new ArrayList();
                for (int i1 = 0; i1 < 25; i1++)
                {
                    layoutinflater.add(c.get(i1));
                }

                (new jn(a, this, k, layoutinflater, false)).executeOnExecutor(nb.h, new Void[0]);
            } else
            {
                y = 0;
                (new jn(a, this, k, c, false)).executeOnExecutor(nb.h, new Void[0]);
            }
        }
        return g;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)a).updateActionBarTitle(m.getShortDescription());
        ((BBYBaseFragmentActivity)a).hideActionBarHomeAndSearchBox(a);
    }
}
