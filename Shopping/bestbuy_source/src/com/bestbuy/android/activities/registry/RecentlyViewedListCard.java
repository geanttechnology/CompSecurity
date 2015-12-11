// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.mybby.MyBBYListIdActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hl;
import iy;
import java.util.ArrayList;
import java.util.HashMap;
import ll;
import lp;
import lu;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            AddItemsToPLPFragment, MyEmptyWishListFragment, MyEmptyWeddingRegistryList

public class RecentlyViewedListCard extends BBYBaseFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private View a;
    private LinearLayout b;
    private View c;
    private View g;
    private ArrayList h;
    private LayoutInflater i;
    private FrameLayout j;
    private String k;
    private String l;
    private BBYBaseFragment m;

    public RecentlyViewedListCard()
    {
        h = new ArrayList();
    }

    public RecentlyViewedListCard(String s, String s1)
    {
        h = new ArrayList();
        k = s;
        l = s1;
    }

    public RecentlyViewedListCard(String s, String s1, BBYBaseFragment bbybasefragment, Activity activity)
    {
        h = new ArrayList();
        k = s;
        l = s1;
        m = bbybasefragment;
        d = activity;
    }

    static String a(RecentlyViewedListCard recentlyviewedlistcard)
    {
        return recentlyviewedlistcard.l;
    }

    private void a(int i1)
    {
label0:
        {
label1:
            {
                g = i.inflate(0x7f0300d5, null);
                Object obj1 = (BBYTextView)g.findViewById(0x7f0c00c9);
                ImageView imageview = (ImageView)g.findViewById(0x7f0c00c8);
                RatingBar ratingbar = (RatingBar)g.findViewById(0x7f0c00cb);
                BBYTextView bbytextview = (BBYTextView)g.findViewById(0x7f0c00cc);
                Object obj = (LinearLayout)g.findViewById(0x7f0c00cd);
                BBYButton bbybutton = (BBYButton)g.findViewById(0x7f0c034f);
                LinearLayout linearlayout = (LinearLayout)g.findViewById(0x7f0c034e);
                linearlayout.setVisibility(0);
                bbybutton.setVisibility(0);
                bbybutton.setOnClickListener(new android.view.View.OnClickListener(i1) {

                    final int a;
                    final RecentlyViewedListCard b;

                    public void onClick(View view)
                    {
                        view = new HashMap();
                        view.put("bb.addToList", "1");
                        if (!RecentlyViewedListCard.a(b).equalsIgnoreCase("weddingregistrylists"))
                        {
                            view.put("&&products", (new StringBuilder()).append(";").append(((BBYProduct)RecentlyViewedListCard.b(b).get(a)).getSkuId()).append(";;;;evar48=LE-WL").toString());
                            lu.b((new StringBuilder()).append(lu.L).append(RecentlyViewedListCard.a(b).substring(0, RecentlyViewedListCard.a(b).length() - 1)).toString(), view);
                            (new iy(b.d, b, null, RecentlyViewedListCard.c(b), ((BBYProduct)RecentlyViewedListCard.b(b).get(a)).getSkuId(), RecentlyViewedListCard.a(b), "1")).executeOnExecutor(nb.g, new Void[0]);
                        } else
                        if (RecentlyViewedListCard.a(b).equalsIgnoreCase("weddingregistrylists"))
                        {
                            view.put("&&products", (new StringBuilder()).append(";").append(((BBYProduct)RecentlyViewedListCard.b(b).get(a)).getSkuId()).append(";;;;evar48=WR-WR").toString());
                            lu.b(lu.aH, view);
                            (new iy(b.d, b, null, RecentlyViewedListCard.c(b), ((BBYProduct)RecentlyViewedListCard.b(b).get(a)).getSkuId(), RecentlyViewedListCard.a(b), "1")).executeOnExecutor(nb.g, new Void[0]);
                            return;
                        }
                    }

            
            {
                b = RecentlyViewedListCard.this;
                a = i1;
                super();
            }
                });
                BBYProduct bbyproduct = (BBYProduct)h.get(i1);
                Summary summary = bbyproduct.getSummary();
                if (summary != null && (summary.getCondition() != null && summary.getCondition().equalsIgnoreCase("openBox") || bbyproduct.getPriceBlock() != null && bbyproduct.getPriceBlock().getAttributes() != null && bbyproduct.getPriceBlock().getAttributes().isMarketplace()))
                {
                    bbybutton.setVisibility(8);
                    linearlayout.setVisibility(8);
                }
                g.setId(i1);
                ((BBYTextView) (obj1)).setText(summary.getNames().getShortName());
                ((LinearLayout) (obj)).removeAllViews();
                ratingbar.setNumStars(5);
                float f1 = 0.0F;
                float f = f1;
                if (summary.getCustomerRatings() != null)
                {
                    f = f1;
                    if (summary.getCustomerRatings().getAverageRating() != null)
                    {
                        f = (float)summary.getCustomerRatings().getAverageRating().getScore();
                        ratingbar.setRating(f);
                    }
                }
                if (f > 1.0F)
                {
                    bbytextview.setTextSize(2, 11F);
                    bbytextview.setText((new StringBuilder()).append("(").append(summary.getCustomerRatings().getTotalCount()).append(" reviews)").toString());
                } else
                {
                    bbytextview.setTextSize(2, 10F);
                    bbytextview.setText(d.getString(0x7f08027c));
                }
                obj1 = lp.a(d, (BBYProduct)h.get(i1), 1, false, null, false, "");
                if (obj1 != null)
                {
                    ((LinearLayout) (obj)).addView(((View) (obj1)));
                }
                obj = "";
                obj1 = obj;
                if (summary.getMedia() == null)
                {
                    break label0;
                }
                obj1 = obj;
                if (summary.getMedia().getPrimaryImage() != null)
                {
                    obj1 = summary.getMedia().getPrimaryImage().getUrl();
                }
                if (!((String) (obj1)).isEmpty())
                {
                    obj = obj1;
                    if (!((String) (obj1)).equals(d.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                obj = obj1;
                if (summary.getMedia().getListImage() != null)
                {
                    obj = summary.getMedia().getListImage().getUrl();
                }
            }
            if (!((String) (obj)).isEmpty())
            {
                obj1 = obj;
                if (!((String) (obj)).equals(d.getString(0x7f080068)))
                {
                    break label0;
                }
            }
            obj1 = obj;
            if (summary.getMedia().getThumbnailImage() != null)
            {
                obj1 = summary.getMedia().getThumbnailImage().getUrl();
            }
        }
        ng.a(((String) (obj1)), imageview, false);
        b.addView(g);
    }

    private String b(ArrayList arraylist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (arraylist != null && arraylist.size() > 0)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                stringbuilder.append(((BBYProduct)arraylist.get(i1)).getSkuId());
                if (i1 != arraylist.size() - 1)
                {
                    stringbuilder.append(',');
                }
            }

        }
        return stringbuilder.toString();
    }

    static ArrayList b(RecentlyViewedListCard recentlyviewedlistcard)
    {
        return recentlyviewedlistcard.h;
    }

    static String c(RecentlyViewedListCard recentlyviewedlistcard)
    {
        return recentlyviewedlistcard.k;
    }

    public void a(ArrayList arraylist)
    {
        a.setVisibility(0);
        if (arraylist != null && (arraylist == null || !arraylist.isEmpty())) goto _L2; else goto _L1
_L1:
        b();
_L4:
        if (c != null)
        {
            c.setVisibility(8);
        }
        return;
_L2:
        h.clear();
        h.addAll(arraylist);
        int i1 = 0;
        do
        {
label0:
            {
                int j1;
                if (h.size() < 5)
                {
                    j1 = h.size();
                } else
                {
                    j1 = 5;
                }
                if (i1 >= j1)
                {
                    break label0;
                }
                a(i1);
                ((LinearLayout)g).setOnClickListener(this);
                i1++;
            }
        } while (true);
        if (!l.equalsIgnoreCase("weddingregistrylists"))
        {
            ((HomeActivity)d).sendRecommendations("wishlistloadrecentlyviewed", "LE", b(h), (BBYProduct)h.get(0));
        } else
        if (l.equalsIgnoreCase("weddingregistrylists"))
        {
            ((HomeActivity)d).sendRecommendations("registryloadrecentlyviewed", "WR", b(h), (BBYProduct)h.get(0));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b()
    {
        if (a != null)
        {
            ll.a(a);
        }
    }

    public void c()
    {
        ((BBYBaseFragmentActivity)d).getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = getParentFragment();
        if (fragment != null && (fragment instanceof AddItemsToPLPFragment))
        {
            nb.a().k(true);
            ((AddItemsToPLPFragment)fragment).a("Item Added");
        } else
        {
            if (fragment != null && (fragment instanceof MyEmptyWishListFragment))
            {
                ((MyEmptyWishListFragment)fragment).b();
                return;
            }
            if (fragment != null && (fragment instanceof MyEmptyWeddingRegistryList))
            {
                ((MyEmptyWeddingRegistryList)fragment).c();
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        BBYProduct bbyproduct;
        Intent intent;
        view.getId();
        intent = new Intent();
        bbyproduct = (BBYProduct)h.get(view.getId());
        intent.putExtra("sku", bbyproduct.getSkuId());
        intent.putExtra("productId", bbyproduct.getSummary().getProductId());
        if (!(d instanceof MyBBYListIdActivity)) goto _L2; else goto _L1
_L1:
        ((MyBBYListIdActivity)d).setResult(-1, intent);
        ((MyBBYListIdActivity)d).finish();
_L4:
        return;
_L2:
        if (!(d instanceof HomeActivity)) goto _L4; else goto _L3
_L3:
        view = "";
        if (l.equalsIgnoreCase("weddingregistrylists")) goto _L6; else goto _L5
_L5:
        view = "Life Events - WishList";
_L8:
        ((HomeActivity)d).openPDP(bbyproduct.getSkuId(), (new StringBuilder()).append("").append(bbyproduct.getSummary().getProductId()).toString(), false, true, true, view, bbyproduct);
        return;
_L6:
        if (l.equalsIgnoreCase("weddingregistrylists"))
        {
            view = "Life Events - WeddingRegistry";
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        i = layoutinflater;
        a = layoutinflater.inflate(0x7f0300df, viewgroup, false);
        c = a.findViewById(0x7f0c0065);
        b = (LinearLayout)a.findViewById(0x7f0c0363);
        j = (FrameLayout)a.findViewById(0x7f0c0064);
        j.setVisibility(0);
        (new hl(d, this, c)).executeOnExecutor(nb.h, new Void[0]);
        return a;
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        Object obj;
        adapterview = ((BBYBaseFragmentActivity)d).getSupportFragmentManager().beginTransaction();
        obj = (BBYProduct)h.get(i1);
        view = ((BBYProduct) (obj)).getSummary().getUrl();
        if (l.equalsIgnoreCase("weddingregistrylists")) goto _L2; else goto _L1
_L1:
        ((HomeActivity)d).sendRecommendations("wishlistclickrecentlyviewed", "LE", ((BBYProduct) (obj)));
_L4:
        if (view != null && view.compareTo("") != 0)
        {
            obj = new MdotWebFragment();
            Bundle bundle = new Bundle();
            bundle.putString("mDotURL", view);
            ((MdotWebFragment) (obj)).setArguments(bundle);
            adapterview.add(0x7f0c0033, ((android.support.v4.app.Fragment) (obj)), "MdotWebFragment");
            adapterview.addToBackStack(null);
            adapterview.commit();
        }
        return;
_L2:
        if (l.equalsIgnoreCase("weddingregistrylists"))
        {
            ((HomeActivity)d).sendRecommendations("registryclickrecentlyviewed", "WR", ((BBYProduct) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }
}
