// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.pdpreviews.DistilledReviewSummary;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewFeaturesDetails;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import ll;
import lu;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPReviewsListFragment, PDPFragmentContainer

public class PDPReviewAndRatingsFragment extends BBYBaseFragment
{

    private Activity a;
    private OverviewResponse b;
    private View c;
    private RatingBar g;
    private BBYTextView h;
    private BBYTextView i;
    private BBYTextView j;
    private RelativeLayout k;
    private DNMProduct l;
    private double m;
    private int n;
    private LinearLayout o;
    private LinearLayout p;
    private RelativeLayout q;
    private PDPOverviewResponse r;
    private RelativeLayout s;
    private String t;
    private PDPOverviewResponseRoot u;

    public PDPReviewAndRatingsFragment()
    {
        m = 0.0D;
        n = 0;
    }

    public PDPReviewAndRatingsFragment(OverviewResponse overviewresponse, DNMProduct dnmproduct, PDPOverviewResponse pdpoverviewresponse)
    {
        m = 0.0D;
        n = 0;
        b = overviewresponse;
        l = dnmproduct;
        r = pdpoverviewresponse;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        bundle.putSerializable("dnmProduct", dnmproduct);
        bundle.putSerializable("pdpOverviewResponse", pdpoverviewresponse);
        setArguments(bundle);
    }

    static String a(PDPReviewAndRatingsFragment pdpreviewandratingsfragment)
    {
        return pdpreviewandratingsfragment.t;
    }

    static OverviewResponse b(PDPReviewAndRatingsFragment pdpreviewandratingsfragment)
    {
        return pdpreviewandratingsfragment.b;
    }

    static PDPOverviewResponse c(PDPReviewAndRatingsFragment pdpreviewandratingsfragment)
    {
        return pdpreviewandratingsfragment.r;
    }

    static PDPOverviewResponseRoot d(PDPReviewAndRatingsFragment pdpreviewandratingsfragment)
    {
        return pdpreviewandratingsfragment.u;
    }

    public void a(String s1, ArrayList arraylist, LinearLayout linearlayout)
    {
        TextView atextview[];
        TextView textview;
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.setMargins(0, 0, 0, 10);
        atextview = new TextView[arraylist.size()];
        textview = new TextView(c.getContext());
        if (s1.equals("Cons"))
        {
            textview.setTextColor(getResources().getColor(0x7f0b000d));
            break MISSING_BLOCK_LABEL_71;
        } else
        {
            if (s1.equals("Pros"))
            {
                textview.setTextColor(getResources().getColor(0x7f0b0007));
            }
            continue;
        }
        do
        {
            textview.setText(s1);
            textview.setTextSize(30F);
            textview.setLayoutParams(layoutparams);
            textview.setPadding(0, 0, 0, 15);
            int i1 = 0;
            do
            {
                if (i1 >= arraylist.size())
                {
                    break;
                }
                atextview[i1] = new TextView(c.getContext());
                atextview[i1].setTextSize(15F);
                atextview[i1].setTextColor(getResources().getColor(0x7f0b0031));
                atextview[i1].setBackgroundResource(0x7f0201b1);
                atextview[i1].setLayoutParams(layoutparams);
                atextview[i1].setId(i1);
                if (s1.equals("Cons"))
                {
                    atextview[i1].setText((new StringBuilder()).append(((ReviewFeaturesDetails)arraylist.get(i1)).getFeature()).append(" (").append(((ReviewFeaturesDetails)arraylist.get(i1)).getNegativeReviewsMentioned()).append(")").toString());
                } else
                if (s1.equals("Pros"))
                {
                    atextview[i1].setText((new StringBuilder()).append(((ReviewFeaturesDetails)arraylist.get(i1)).getFeature()).append(" (").append(((ReviewFeaturesDetails)arraylist.get(i1)).getPositiveReviewsMentioned()).append(")").toString());
                }
                atextview[i1].setOnClickListener(new android.view.View.OnClickListener(s1, arraylist) {

                    final String a;
                    final ArrayList b;
                    final PDPReviewAndRatingsFragment c;

                    public void onClick(View view)
                    {
                        Object obj;
                        obj = new HashMap();
                        ((HashMap) (obj)).put("&&products", (new StringBuilder()).append(";").append(PDPReviewAndRatingsFragment.b(c).getSkuId()).toString());
                        if (!a.equals("Cons")) goto _L2; else goto _L1
_L1:
                        ((HashMap) (obj)).put("bb.distilledReviewCon", "1");
                        ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(PDPReviewAndRatingsFragment.a(c)).append("pdp: distilled review: con").toString());
                        lu.b((new StringBuilder()).append(PDPReviewAndRatingsFragment.a(c)).append("pdp: reviews: con").toString(), ((HashMap) (obj)));
_L4:
                        obj = (PDPFragment)c.getParentFragment();
                        view = new PDPReviewsListFragment(PDPReviewAndRatingsFragment.b(c), PDPReviewAndRatingsFragment.c(c), ((ReviewFeaturesDetails)b.get(view.getId())).getFeature());
                        Bundle bundle = new Bundle();
                        bundle.putString("BreadCrumb", PDPReviewAndRatingsFragment.a(c));
                        bundle.putSerializable("PDPOverviewResponseRoot", PDPReviewAndRatingsFragment.d(c));
                        view.setArguments(bundle);
                        ((PDPFragmentContainer)((PDPFragment) (obj)).getParentFragment()).a(view, true);
                        return;
_L2:
                        if (a.equals("Pros"))
                        {
                            ((HashMap) (obj)).put("bb.distilledReviewPro", "1");
                            ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(PDPReviewAndRatingsFragment.a(c)).append("pdp: distilled review: pro").toString());
                            lu.b((new StringBuilder()).append(PDPReviewAndRatingsFragment.a(c)).append("pdp: reviews: pro").toString(), ((HashMap) (obj)));
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                c = PDPReviewAndRatingsFragment.this;
                a = s1;
                b = arraylist;
                super();
            }
                });
                linearlayout.addView(atextview[i1]);
                i1++;
            } while (true);
            linearlayout.addView(textview, 0);
            return;
        } while (true);
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (b == null)
        {
            bundle = getArguments();
            if (bundle != null)
            {
                t = bundle.getString("BreadCrumb");
                u = (PDPOverviewResponseRoot)bundle.getSerializable("PDPOverviewResponseRoot");
                b = (OverviewResponse)bundle.getSerializable("product");
                l = (DNMProduct)bundle.getSerializable("dnmProduct");
                r = (PDPOverviewResponse)bundle.getSerializable("pdpOverviewResponse");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f0300af, viewgroup, false);
            g = (RatingBar)c.findViewById(0x7f0c00cb);
            h = (BBYTextView)c.findViewById(0x7f0c02b8);
            i = (BBYTextView)c.findViewById(0x7f0c0299);
            j = (BBYTextView)c.findViewById(0x7f0c02b9);
            q = (RelativeLayout)c.findViewById(0x7f0c00fc);
            s = (RelativeLayout)c.findViewById(0x7f0c00fa);
            s.setVisibility(8);
            k = (RelativeLayout)c.findViewById(0x7f0c02b6);
            g.setNumStars(5);
            if (l != null)
            {
                m = l.getCustomerRating();
                n = Integer.parseInt(l.getNumberOfReviews());
            } else
            if (b != null && b.getCustomerRatings() != null)
            {
                bundle = b.getCustomerRatings();
                if (bundle.getAverageRating() != null)
                {
                    m = bundle.getAverageRating().getScore();
                    n = bundle.getTotalCount();
                }
            }
            g.setRating((float)m);
            if (n == 1)
            {
                i.setText((new StringBuilder()).append("(").append(n).append(" ").append(a.getString(0x7f0802df)).toString());
            } else
            {
                i.setText((new StringBuilder()).append("(").append(n).append(" ").append(a.getString(0x7f0802e0)).toString());
            }
            h.setText((new StringBuilder()).append("").append(m).toString());
            if (b.getCustomerRatings() != null)
            {
                bundle = b.getCustomerRatings();
                if (bundle.getAverageRating() != null)
                {
                    bundle = bundle.getAverageRating();
                    j.setText((new StringBuilder()).append(bundle.getPercent0To100()).append("% would recommend this product").toString());
                }
            }
            k.setOnClickListener(new android.view.View.OnClickListener() {

                final PDPReviewAndRatingsFragment a;

                public void onClick(View view)
                {
                    view = new HashMap();
                    view.put("bb.ratingsReviews", "1");
                    view.put("bb.reviewsInteraction", "Ratings & Reviews: PDP: Tab");
                    view.put("bb.prevPageLink", (new StringBuilder()).append(PDPReviewAndRatingsFragment.a(a)).append("pdp: reviews tab").toString());
                    view.put("&&products", (new StringBuilder()).append(";").append(PDPReviewAndRatingsFragment.b(a).getSkuId()).toString());
                    lu.b((new StringBuilder()).append(PDPReviewAndRatingsFragment.a(a)).append("pdp: reviews").toString(), view);
                    view = (PDPFragment)a.getParentFragment();
                    PDPReviewsListFragment pdpreviewslistfragment = new PDPReviewsListFragment(PDPReviewAndRatingsFragment.b(a), PDPReviewAndRatingsFragment.c(a), view);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("BreadCrumb", PDPReviewAndRatingsFragment.a(a));
                    bundle1.putSerializable("PDPOverviewResponseRoot", PDPReviewAndRatingsFragment.d(a));
                    pdpreviewslistfragment.setArguments(bundle1);
                    ((PDPFragmentContainer)view.getParentFragment()).a(pdpreviewslistfragment, true);
                }

            
            {
                a = PDPReviewAndRatingsFragment.this;
                super();
            }
            });
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        if (m <= 0.0D)
        {
            ll.a(viewgroup);
        }
        if (r != null && r.getDistilledReviewSummary() != null)
        {
            s.setVisibility(0);
            layoutinflater = layoutinflater.inflate(0x7f0300d4, null);
            o = (LinearLayout)layoutinflater.findViewById(0x7f0c034c);
            p = (LinearLayout)layoutinflater.findViewById(0x7f0c034d);
            q.addView(layoutinflater);
            if (r.getDistilledReviewSummary().getBestFeatures() != null && r.getDistilledReviewSummary().getBestFeatures().size() > 0)
            {
                a("Pros", r.getDistilledReviewSummary().getBestFeatures(), o);
            }
            if (r.getDistilledReviewSummary().getWorstFeatures() != null && r.getDistilledReviewSummary().getWorstFeatures().size() > 0)
            {
                a("Cons", r.getDistilledReviewSummary().getWorstFeatures(), p);
            }
        } else
        {
            s.setVisibility(8);
        }
        return c;
    }

    public void onResume()
    {
        super.onResume();
    }
}
