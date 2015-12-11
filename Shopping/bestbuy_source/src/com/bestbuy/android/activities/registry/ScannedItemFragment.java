// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hj;
import iy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jb;
import jv;
import ll;
import lp;
import lu;
import mf;
import mo;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ScannedItemCustomerAlsoViewedFragment, MyEmptyWishListFragment, MyEmptyWeddingRegistryList, WishListWithProductsFragment

public class ScannedItemFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private static boolean C;
    private BBYTextView A;
    private RelativeLayout B;
    private boolean D;
    private Activity E;
    private String a;
    private String b;
    private String c;
    private String g;
    private BBYTextView h;
    private ImageView i;
    private RatingBar j;
    private BBYTextView k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private View o;
    private ArrayList p;
    private RelativeLayout q;
    private LinearLayout r;
    private BBYTextView s;
    private LinearLayout t;
    private LinearLayout u;
    private ArrayList v;
    private ImageView w;
    private ImageView x;
    private LinearLayout y;
    private ImageView z;

    public ScannedItemFragment(Activity activity, String s1, String s2, String s3)
    {
        p = new ArrayList();
        D = false;
        E = activity;
        a = s1;
        b = s2;
        c = s3;
        if (!s3.equals("weddingregistrylists"))
        {
            D = true;
        }
    }

    public void a(String s1)
    {
        ((BBYTextView)y.findViewById(0x7f0c039f)).setText(s1);
        ll.b(y);
    }

    public void a(ArrayList arraylist)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (isVisible())
                    {
                        ((BBYBaseFragmentActivity)E).updateActionBarTitle("We Found It");
                    }
                    if (arraylist == null || arraylist.size() <= 0)
                    {
                        break label0;
                    }
                    l.setVisibility(0);
                    m.removeAllViews();
                    n.removeAllViews();
                    arraylist = (BBYProduct)arraylist.get(0);
                    Summary summary = arraylist.getSummary();
                    h.setText(summary.getNames().getShortName());
                    j.setNumStars(5);
                    float f = (float)summary.getCustomerRatings().getAverageRating().getScore();
                    j.setRating(f);
                    if (f > 0.0F)
                    {
                        int i1 = summary.getCustomerRatings().getTotalCount();
                        Object obj;
                        if (i1 == 1)
                        {
                            k.setText((new StringBuilder()).append("(").append(i1).append(" ").append(E.getString(0x7f0802df)).toString());
                        } else
                        {
                            k.setText((new StringBuilder()).append("(").append(i1).append(" ").append(E.getString(0x7f0802e0)).toString());
                        }
                        if (i1 > 999)
                        {
                            k.setTextSize(2, 10F);
                        } else
                        {
                            k.setTextSize(2, 11F);
                        }
                    } else
                    {
                        k.setTextSize(2, 10F);
                        k.setText(E.getString(0x7f080394));
                    }
                    obj = lp.a(E, arraylist, 3, false, null, false, "");
                    if (obj != null)
                    {
                        m.addView(((View) (obj)));
                    }
                    arraylist = mo.a(E, this, arraylist, null, 5, false, null, null);
                    if (arraylist != null)
                    {
                        n.addView(arraylist);
                        ((ImageView)n.findViewById(0x7f0c034a)).setOnClickListener(this);
                        ((ImageView)n.findViewById(0x7f0c0348)).setOnClickListener(this);
                        s = (BBYTextView)n.findViewById(0x7f0c0349);
                    }
                    arraylist = "";
                    obj = arraylist;
                    if (summary.getMedia() == null)
                    {
                        break label1;
                    }
                    obj = arraylist;
                    if (summary.getMedia().getPrimaryImage() != null)
                    {
                        obj = summary.getMedia().getPrimaryImage().getUrl();
                    }
                    if (!((String) (obj)).isEmpty())
                    {
                        arraylist = ((ArrayList) (obj));
                        if (!((String) (obj)).equals(E.getString(0x7f080068)))
                        {
                            break label2;
                        }
                    }
                    arraylist = ((ArrayList) (obj));
                    if (summary.getMedia().getListImage() != null)
                    {
                        arraylist = summary.getMedia().getListImage().getUrl();
                    }
                }
                if (!arraylist.isEmpty())
                {
                    obj = arraylist;
                    if (!arraylist.equals(E.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                obj = arraylist;
                if (summary.getMedia().getThumbnailImage() != null)
                {
                    obj = summary.getMedia().getThumbnailImage().getUrl();
                }
            }
            ng.a(((String) (obj)), i, false);
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            ((ImageView)t.findViewById(0x7f0c03a4)).setBackgroundResource(0x7f0200c9);
            if (D)
            {
                ((BBYTextView)t.findViewById(0x7f0c03a5)).setText("My Favorite");
                return;
            } else
            {
                ((BBYTextView)t.findViewById(0x7f0c03a5)).setText("Our Favorite");
                return;
            }
        } else
        {
            ((ImageView)t.findViewById(0x7f0c03a4)).setBackgroundResource(0x7f0200cc);
            ((BBYTextView)t.findViewById(0x7f0c03a5)).setText("Favorite This");
            return;
        }
    }

    public void b()
    {
        ((HomeActivity)E).setOnLifeEventsTopNavigationListener(this, "", false);
        n.setVisibility(0);
        q.setVisibility(0);
        ((BBYBaseFragmentActivity)E).updateActionBarTitle("We Found It");
        if (t != null)
        {
            ((ImageView)t.findViewById(0x7f0c03a4)).setBackgroundResource(0x7f0200cc);
            ((BBYTextView)t.findViewById(0x7f0c03a5)).setText("Favorite This");
        }
        r.setVisibility(8);
        B.setVisibility(8);
        if (!C)
        {
            a("Item Removed");
        }
        ((ImageView)n.findViewById(0x7f0c034a)).setOnClickListener(this);
        ((ImageView)n.findViewById(0x7f0c0348)).setOnClickListener(this);
        FragmentTransaction fragmenttransaction = ((BBYBaseFragmentActivity)E).getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0c03ab, new ScannedItemCustomerAlsoViewedFragment(this, b, a, false, c), "CustomerAlsoViewedList");
        fragmenttransaction.commit();
    }

    public void b(ArrayList arraylist)
    {
        ((HomeActivity)E).setOnLifeEventsTopNavigationListener(this, "Remove", true);
        nb nb1 = nb.a();
        if (c.equalsIgnoreCase("weddingregistrylists") || c.equalsIgnoreCase("weddingregistrylist"))
        {
            nb1.l(true);
        } else
        {
            nb1.j(true);
        }
        nb1.k(true);
        v = arraylist;
        n.setVisibility(8);
        q.setVisibility(8);
        ((BBYBaseFragmentActivity)E).updateActionBarTitle("Item Added");
        r.setVisibility(0);
        B.setVisibility(0);
        B.setOnClickListener(this);
        t = (LinearLayout)r.findViewById(0x7f0c03a3);
        t.setOnClickListener(this);
        u = (LinearLayout)r.findViewById(0x7f0c03a6);
        u.setOnClickListener(this);
        if (c.equalsIgnoreCase("weddingregistrylists") || c.equalsIgnoreCase("weddingregistrylist"))
        {
            z.setImageResource(0x7f02016f);
            A.setText("Return to Registry");
            nb1.l(true);
        } else
        {
            z.setImageResource(0x7f020170);
            A.setText("Return to Wish List");
        }
        arraylist = ((BBYBaseFragmentActivity)E).getSupportFragmentManager().beginTransaction();
        arraylist.add(0x7f0c03ab, new ScannedItemCustomerAlsoViewedFragment(this, b, a, true, c), "CustomerAlsoBoughtList");
        arraylist.commit();
    }

    public void c()
    {
        b();
    }

    public void g()
    {
        Activity activity = E;
        String s2 = c;
        String s3 = b;
        String s1;
        if (v.size() > 0)
        {
            s1 = ((Entities)v.get(0)).getUuid();
        } else
        {
            s1 = "";
        }
        (new jb(activity, this, s2, s3, s1)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        E = activity;
        ((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle();
        activity = ((BBYBaseFragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        activity.add(0x7f0c03ab, new ScannedItemCustomerAlsoViewedFragment(this, b, a, false, c), "CustomerAlsoViewedList");
        activity.commit();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 7: default 72
    //                   2131493203: 73
    //                   2131493704: 469
    //                   2131493706: 356
    //                   2131493795: 599
    //                   2131493798: 670
    //                   2131493802: 94
    //                   2131493805: 778;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L2:
        E.finish();
        E.overridePendingTransition(0x7f040005, 0x7f040008);
        return;
_L7:
        g = s.getText().toString();
        view = new HashMap();
        view.put("bb.addToList", "1");
        if (!c.equalsIgnoreCase("weddingregistrylists"))
        {
            view.put("&&products", (new StringBuilder()).append(";").append(a).append(";;;;evar48=LE-WL").toString());
            lu.b((new StringBuilder()).append(lu.L).append(c.substring(0, c.length() - 1)).toString(), view);
            (new iy(E, this, null, b, a, c, g)).executeOnExecutor(nb.g, new Void[0]);
            return;
        }
        if (c.equalsIgnoreCase("weddingregistrylists"))
        {
            view.put("&&products", (new StringBuilder()).append(";").append(a).append(";;;;evar48=WR-WR").toString());
            lu.b(lu.az, view);
            (new iy(E, this, null, b, a, c, g)).executeOnExecutor(nb.g, new Void[0]);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (Integer.valueOf(s.getText().toString()).intValue() < 10)
        {
            s.setText(String.valueOf(Integer.valueOf(s.getText().toString()).intValue() + 1));
            ((ImageView)n.findViewById(0x7f0c0348)).setImageResource(0x7f020115);
        }
        if (Integer.valueOf(s.getText().toString()).intValue() == 10)
        {
            ((ImageView)n.findViewById(0x7f0c034a)).setImageResource(0x7f020007);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ((ImageView)n.findViewById(0x7f0c034a)).setImageResource(0x7f020006);
        if (Integer.valueOf(s.getText().toString()).intValue() > 1)
        {
            s.setText(String.valueOf(Integer.valueOf(s.getText().toString()).intValue() - 1));
            if (Integer.valueOf(s.getText().toString()).intValue() == 1)
            {
                ((ImageView)n.findViewById(0x7f0c0348)).setImageResource(0x7f020116);
                return;
            } else
            {
                ((ImageView)n.findViewById(0x7f0c0348)).setImageResource(0x7f020115);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        Activity activity = E;
        String s1 = b;
        if (v.size() > 0)
        {
            view = ((Entities)v.get(0)).getUuid();
        } else
        {
            view = "";
        }
        (new jv(activity, this, s1, view, c, true, null, null)).executeOnExecutor(nb.g, new Void[0]);
        return;
_L6:
        int i1 = getParentFragment().getChildFragmentManager().getBackStackEntryCount() - 1;
        while (i1 >= 0 && !(getParentFragment().getChildFragmentManager().getFragments().get(i1) instanceof MyEmptyWishListFragment) && !(getParentFragment().getChildFragmentManager().getFragments().get(i1) instanceof MyEmptyWeddingRegistryList) && !(getParentFragment().getChildFragmentManager().getFragments().get(i1) instanceof WishListWithProductsFragment)) 
        {
            getParentFragment().getChildFragmentManager().popBackStackImmediate();
            i1--;
        }
        if (true) goto _L1; else goto _L8
_L8:
        (new mf()).a(E, "LIFE_EVENTS_PRODUCT_SCAN", "LIFE_EVENTS_PRODUCT_SCAN", b, c);
        C = true;
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300ea, null);
        h = (BBYTextView)layoutinflater.findViewById(0x7f0c00c9);
        i = (ImageView)layoutinflater.findViewById(0x7f0c00c8);
        j = (RatingBar)layoutinflater.findViewById(0x7f0c00cb);
        k = (BBYTextView)layoutinflater.findViewById(0x7f0c00cc);
        m = (LinearLayout)layoutinflater.findViewById(0x7f0c00cd);
        n = (LinearLayout)layoutinflater.findViewById(0x7f0c0301);
        o = layoutinflater.findViewById(0x7f0c012c);
        r = (LinearLayout)layoutinflater.findViewById(0x7f0c03a2);
        y = (LinearLayout)layoutinflater.findViewById(0x7f0c039e);
        q = (RelativeLayout)layoutinflater.findViewById(0x7f0c03a9);
        w = (ImageView)layoutinflater.findViewById(0x7f0c034a);
        x = (ImageView)layoutinflater.findViewById(0x7f0c0348);
        z = (ImageView)layoutinflater.findViewById(0x7f0c03a7);
        A = (BBYTextView)layoutinflater.findViewById(0x7f0c03a8);
        B = (RelativeLayout)layoutinflater.findViewById(0x7f0c03ad);
        viewgroup = (BBYButton)layoutinflater.findViewById(0x7f0c03aa);
        if (D)
        {
            viewgroup.setText("Add Item");
            viewgroup.setCompoundDrawablesWithIntrinsicBounds(0x7f020170, 0, 0, 0);
        }
        viewgroup.setOnClickListener(this);
        l = (LinearLayout)layoutinflater.findViewById(0x7f0c03a1);
        l.setVisibility(8);
        p.add(a);
        ((HomeActivity)E).setOnLifeEventsTopNavigationListener(this, "", false);
        ((BBYBaseFragmentActivity)E).hideActionBarHomeAndSearchBox(E);
        (new hj(E, this, o, p)).executeOnExecutor(nb.h, new Void[0]);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        C = true;
        ((BBYBaseFragmentActivity)E).updateActionBarTitle("Item Added");
        if (l())
        {
            (new hj(E, this, o, p)).executeOnExecutor(nb.h, new Void[0]);
        }
    }
}
