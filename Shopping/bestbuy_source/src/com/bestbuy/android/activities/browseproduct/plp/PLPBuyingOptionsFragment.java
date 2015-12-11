// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.pdp.PDPProductAvailabilityContainer;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPMedia;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsList;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import eq;
import im;
import java.util.ArrayList;
import nb;
import ng;

public class PLPBuyingOptionsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private LinearLayout A;
    private View B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private BBYProduct G;
    public int a;
    public int b;
    public int c;
    private BuyingOptionsResponse g;
    private OverviewResponse h;
    private Activity i;
    private View j;
    private ImageView k;
    private BBYTextView l;
    private BBYTextView m;
    private RatingBar n;
    private RelativeLayout o;
    private ArrayList p;
    private String q;
    private ArrayList r;
    private ArrayList s;
    private ArrayList t;
    private DialogSpinner u;
    private ListView v;
    private eq w;
    private ArrayList x;
    private ArrayList y;
    private PDPProductAvailabilityContainer z;

    public PLPBuyingOptionsFragment()
    {
        a = 0;
        b = 0;
        c = 0;
        r = new ArrayList();
        s = new ArrayList();
        t = new ArrayList();
        y = new ArrayList();
    }

    public PLPBuyingOptionsFragment(BBYProduct bbyproduct)
    {
        a = 0;
        b = 0;
        c = 0;
        r = new ArrayList();
        s = new ArrayList();
        t = new ArrayList();
        y = new ArrayList();
        G = bbyproduct;
    }

    static ArrayList a(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.x;
    }

    static ArrayList b(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.y;
    }

    static ArrayList c(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.r;
    }

    static ArrayList d(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.s;
    }

    static ArrayList e(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.t;
    }

    static eq f(PLPBuyingOptionsFragment plpbuyingoptionsfragment)
    {
        return plpbuyingoptionsfragment.w;
    }

    public void a(BuyingOptionsResponse buyingoptionsresponse)
    {
        if (buyingoptionsresponse == null) goto _L2; else goto _L1
_L1:
        g = buyingoptionsresponse;
        if (g == null) goto _L2; else goto _L3
_L3:
        if (h == null) goto _L5; else goto _L4
_L4:
        int i1;
        ng.a(h.getMedia().getPrimaryImage().getUrl(), k, false);
        n.setNumStars(5);
        if (h.getCustomerRatings() != null)
        {
            if (h.getCustomerRatings().getAverageRating() != null)
            {
                n.setRating((float)h.getCustomerRatings().getAverageRating().getScore());
            }
            i1 = h.getCustomerRatings().getTotalCount();
            if (i1 == 1)
            {
                m.setText((new StringBuilder()).append("(").append(i1).append(" ").append(i.getString(0x7f0802df)).toString());
            } else
            {
                m.setText((new StringBuilder()).append("(").append(i1).append(" ").append(i.getString(0x7f0802e0)).toString());
            }
        }
_L11:
        l.setText(g.getNames().getShortName());
        p = g.getBuyingOptions();
        if (p != null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
          goto _L2
_L5:
        if (G != null && G.getSummary() != null)
        {
            if (G.getSummary().getMedia() != null && G.getSummary().getMedia().getPrimaryImage() != null)
            {
                ng.a(G.getSummary().getMedia().getPrimaryImage().getUrl(), k, false);
            }
            n.setNumStars(5);
            if (G.getSummary().getCustomerRatings() != null && G.getSummary().getCustomerRatings().getAverageRating() != null)
            {
                n.setRating((float)G.getSummary().getCustomerRatings().getAverageRating().getScore());
            }
            if (G.getSummary().getCustomerRatings() != null)
            {
                i1 = G.getSummary().getCustomerRatings().getTotalCount();
            } else
            {
                i1 = 0;
            }
            if (i1 == 1)
            {
                m.setText((new StringBuilder()).append("(").append(i1).append(" ").append(i.getString(0x7f0802df)).toString());
            } else
            {
                m.setText((new StringBuilder()).append("(").append(i1).append(" ").append(i.getString(0x7f0802e0)).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        i1 = 0;
        while (i1 < p.size()) 
        {
            q = ((BuyingOptionsList)p.get(i1)).getCondition();
            if (q.equals("new"))
            {
                r.add(p.get(i1));
                a = a + 1;
            } else
            if (q.equals("openBox"))
            {
                s.add(p.get(i1));
                b = b + 1;
            } else
            if (q.equals("refurbished"))
            {
                t.add(p.get(i1));
                c = c + 1;
            }
            i1++;
        }
        x = new ArrayList();
        if (b > 0)
        {
            x.add((new StringBuilder()).append("Show: Open-Box Condition(").append(b).append(")").toString());
        }
        if (a > 0)
        {
            x.add((new StringBuilder()).append("Show: New Condition(").append(a).append(")").toString());
        }
        if (c > 0)
        {
            x.add((new StringBuilder()).append("Show: Refurbished Condition(").append(c).append(")").toString());
        }
        y.clear();
        if (x.size() > 1)
        {
            buyingoptionsresponse = new ArrayAdapter(i, 0x7f03002c, x);
            buyingoptionsresponse.setDropDownViewResource(0x1090009);
            u.setAdapter(buyingoptionsresponse);
        } else
        {
            E.setVisibility(8);
        }
        if (s.isEmpty()) goto _L7; else goto _L6
_L6:
        y.addAll(s);
_L9:
        w.notifyDataSetChanged();
_L2:
        return;
_L7:
        if (!r.isEmpty())
        {
            y.addAll(r);
        } else
        if (!t.isEmpty())
        {
            y.addAll(t);
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void a(String s1)
    {
        MdotWebFragment mdotwebfragment = new MdotWebFragment(false);
        Bundle bundle = new Bundle();
        bundle.putString(getResources().getString(0x7f080055), s1);
        mdotwebfragment.setArguments(bundle);
        z.a(mdotwebfragment, true);
        z.a("Seller Information");
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)i).changeActionBarShareVisibility(i, false);
        ((BBYBaseFragmentActivity)i).changeActionBarSearchVisibility(i, false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        i = activity;
    }

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (j == null)
        {
            j = layoutinflater.inflate(0x7f0300ab, viewgroup, false);
            o = (RelativeLayout)j.findViewById(0x7f0c0297);
            A = (LinearLayout)j.findViewById(0x7f0c004a);
            B = j.findViewById(0x7f0c0064);
            B.setBackgroundColor(0);
            k = (ImageView)j.findViewById(0x7f0c022b);
            F = (LinearLayout)j.findViewById(0x7f0c0298);
            F.setOnClickListener(this);
            n = (RatingBar)F.findViewById(0x7f0c00cb);
            m = (BBYTextView)F.findViewById(0x7f0c0299);
            l = (BBYTextView)j.findViewById(0x7f0c029a);
            E = (LinearLayout)j.findViewById(0x7f0c00bd);
            u = (DialogSpinner)j.findViewById(0x7f0c029b);
            v = (ListView)j.findViewById(0x7f0c029c);
            w = new eq(i, this, A, B, 0x7f03008b, y, G.getSkuId());
            v.setAdapter(w);
            o.setOnClickListener(this);
            C = (LinearLayout)j.findViewById(0x7f0c0080);
            D = (LinearLayout)j.findViewById(0x7f0c0082);
            if (g != null)
            {
                a(g);
            } else
            {
                (new im(i, this, B, G.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
            }
        } else
        {
            ((ViewGroup)j.getParent()).removeView(j);
        }
        u.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final PLPBuyingOptionsFragment a;

            public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (String)PLPBuyingOptionsFragment.a(a).get(i1);
                PLPBuyingOptionsFragment.b(a).clear();
                if (!adapterview.contains("New Condition")) goto _L2; else goto _L1
_L1:
                PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.c(a));
_L4:
                PLPBuyingOptionsFragment.f(a).notifyDataSetChanged();
                return;
_L2:
                if (adapterview.contains("Open-Box Condition"))
                {
                    PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.d(a));
                } else
                if (adapterview.contains("Refurbished Condition"))
                {
                    PLPBuyingOptionsFragment.b(a).addAll(PLPBuyingOptionsFragment.e(a));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = PLPBuyingOptionsFragment.this;
                super();
            }
        });
        return j;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        z = (PDPProductAvailabilityContainer)getParentFragment();
        z.a("Product Availability ");
    }
}
