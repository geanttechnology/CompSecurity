// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPMedia;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsList;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import eg;
import java.util.ArrayList;
import ll;
import ng;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPProductAvailabilityContainer, PDPReviewsListFragment, PDPFragmentContainer

public class PDPSourceProductAvailabilityFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private LinearLayout A;
    private View B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private PDPOverviewResponse G;
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
    private eg w;
    private ArrayList x;
    private ArrayList y;
    private PDPProductAvailabilityContainer z;

    public PDPSourceProductAvailabilityFragment()
    {
        a = 0;
        b = 0;
        c = 0;
        r = new ArrayList();
        s = new ArrayList();
        t = new ArrayList();
        y = new ArrayList();
    }

    public PDPSourceProductAvailabilityFragment(OverviewResponse overviewresponse, Fragment fragment, BuyingOptionsResponse buyingoptionsresponse, PDPOverviewResponse pdpoverviewresponse)
    {
        a = 0;
        b = 0;
        c = 0;
        r = new ArrayList();
        s = new ArrayList();
        t = new ArrayList();
        y = new ArrayList();
        h = overviewresponse;
        g = buyingoptionsresponse;
        G = pdpoverviewresponse;
    }

    static ArrayList a(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.x;
    }

    static ArrayList b(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.y;
    }

    static ArrayList c(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.r;
    }

    static ArrayList d(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.s;
    }

    static ArrayList e(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.t;
    }

    static eg f(PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment)
    {
        return pdpsourceproductavailabilityfragment.w;
    }

    public void a(BuyingOptionsResponse buyingoptionsresponse)
    {
        if (buyingoptionsresponse == null) goto _L2; else goto _L1
_L1:
        g = buyingoptionsresponse;
        if (g == null) goto _L2; else goto _L3
_L3:
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
        l.setText(g.getNames().getShortName());
        p = g.getBuyingOptions();
        if (p == null) goto _L2; else goto _L4
_L4:
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
        if (a > 0)
        {
            x.add((new StringBuilder()).append("Show: New Condition(").append(a).append(")").toString());
        }
        if (b > 0)
        {
            x.add((new StringBuilder()).append("Show: Open-Box Condition(").append(b).append(")").toString());
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
        if (r.isEmpty()) goto _L6; else goto _L5
_L5:
        y.addAll(r);
_L8:
        w.notifyDataSetChanged();
_L2:
        return;
_L6:
        if (!s.isEmpty())
        {
            y.addAll(s);
        } else
        if (!t.isEmpty())
        {
            y.addAll(t);
        }
        if (true) goto _L8; else goto _L7
_L7:
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

    public void b()
    {
        ll.b(C);
    }

    public void b(String s1)
    {
        String s2;
label0:
        {
            D = (LinearLayout)j.findViewById(0x7f0c0082);
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
        ((BBYTextView)D.findViewById(0x7f0c0083)).setText(s2);
        ll.b(D);
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
        if (view.getId() == F.getId())
        {
            if (h.getCustomerRatings() != null && h.getCustomerRatings().getAverageRating() != null && h.getCustomerRatings().getAverageRating().getScore() > 0.0D && h.getCustomerRatings().getTotalCount() >= 1)
            {
                view = new PDPReviewsListFragment(h, G);
                z.a(view, true);
            }
        } else
        if (view == o)
        {
            ((PDPFragmentContainer)z.getParentFragment()).e();
            return;
        }
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
            w = new eg(i, this, A, B, 0x7f03008b, y, h);
            v.setAdapter(w);
            o.setOnClickListener(this);
            C = (LinearLayout)j.findViewById(0x7f0c0080);
            D = (LinearLayout)j.findViewById(0x7f0c0082);
            if (g != null)
            {
                a(g);
            }
        } else
        {
            ((ViewGroup)j.getParent()).removeView(j);
        }
        u.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final PDPSourceProductAvailabilityFragment a;

            public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (String)PDPSourceProductAvailabilityFragment.a(a).get(i1);
                PDPSourceProductAvailabilityFragment.b(a).clear();
                if (!adapterview.contains("New Condition")) goto _L2; else goto _L1
_L1:
                PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.c(a));
_L4:
                PDPSourceProductAvailabilityFragment.f(a).notifyDataSetChanged();
                return;
_L2:
                if (adapterview.contains("Open-Box Condition"))
                {
                    PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.d(a));
                } else
                if (adapterview.contains("Refurbished Condition"))
                {
                    PDPSourceProductAvailabilityFragment.b(a).addAll(PDPSourceProductAvailabilityFragment.e(a));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = PDPSourceProductAvailabilityFragment.this;
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
