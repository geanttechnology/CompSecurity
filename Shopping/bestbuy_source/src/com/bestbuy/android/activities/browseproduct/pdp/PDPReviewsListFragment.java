// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cj;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.FeatureReviewsResponse;
import com.bestbuy.android.api.lib.models.pdpreviews.DistilledReviewSummary;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewFeaturesDetails;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewsResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import fb;
import hi;
import ig;
import java.util.ArrayList;
import java.util.HashMap;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragmentContainer, PDPFragment

public class PDPReviewsListFragment extends BBYBaseFragment
    implements cj
{

    private RelativeLayout A;
    private TextView B;
    private String C;
    private PDPFragment D;
    private PDPOverviewResponseRoot E;
    private android.widget.AdapterView.OnItemSelectedListener F = new android.widget.AdapterView.OnItemSelectedListener() {

        final PDPReviewsListFragment a;

        public void onItemSelected(AdapterView adapterview, View view, int i1, long l1)
        {
            PDPReviewsListFragment.a(a, true);
            PDPReviewsListFragment.a(a, 0);
            PDPReviewsListFragment.b(a, 0);
            adapterview = (String)PDPReviewsListFragment.a(a).getAdapter().getItem(i1);
            if (!adapterview.equals("Newest")) goto _L2; else goto _L1
_L1:
            PDPReviewsListFragment.a(a, "SubmissionTime:desc");
_L4:
            (new hi(a.d, a, PDPReviewsListFragment.b(a), PDPReviewsListFragment.c(a).getSkuId(), PDPReviewsListFragment.d(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.f(a))).executeOnExecutor(nb.h, new Void[0]);
            return;
_L2:
            if (adapterview.equals("Oldest"))
            {
                PDPReviewsListFragment.a(a, "SubmissionTime:asc");
            } else
            if (adapterview.equals("Most Helpful"))
            {
                PDPReviewsListFragment.a(a, "Helpfulness:desc,SubmissionTime:desc");
            } else
            if (adapterview.equals("Highest Rated"))
            {
                PDPReviewsListFragment.a(a, "Rating:desc,SubmissionTime:desc");
            } else
            if (adapterview.equals("Lowest Rated"))
            {
                PDPReviewsListFragment.a(a, "Rating:asc,SubmissionTime:desc");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            PDPReviewsListFragment.a(a, false);
        }

            
            {
                a = PDPReviewsListFragment.this;
                super();
            }
    };
    private android.widget.AbsListView.OnScrollListener G = new android.widget.AbsListView.OnScrollListener() {

        final PDPReviewsListFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (PDPReviewsListFragment.g(a) != null && !PDPReviewsListFragment.g(a).isEmpty())
            {
                PDPReviewsListFragment.h(a).setVisibility(8);
            } else
            {
                PDPReviewsListFragment.h(a).setVisibility(0);
            }
            PDPReviewsListFragment.a(a, false);
            if (PDPReviewsListFragment.i(a) && k1 - (PDPReviewsListFragment.j(a).getHeaderViewsCount() + PDPReviewsListFragment.j(a).getFooterViewsCount()) < PDPReviewsListFragment.k(a))
            {
                PDPReviewsListFragment.a(a, PDPReviewsListFragment.e(a) + PDPReviewsListFragment.d(a));
                (new hi(a.d, a, null, PDPReviewsListFragment.c(a).getSkuId(), PDPReviewsListFragment.d(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.f(a))).executeOnExecutor(nb.h, new Void[0]);
                PDPReviewsListFragment.b(a, false);
            } else
            if (PDPReviewsListFragment.i(a) && PDPReviewsListFragment.l(a) != null && i1 == k1 - PDPReviewsListFragment.m(a) - j1)
            {
                (new ig(a.d, a, null, PDPReviewsListFragment.n(a).getOverview().getSkuId(), PDPReviewsListFragment.g(a), PDPReviewsListFragment.e(a), PDPReviewsListFragment.l(a))).executeOnExecutor(nb.h, new Void[0]);
                PDPReviewsListFragment.o(a);
                PDPReviewsListFragment.b(a, false);
                return;
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
            if (i1 == 0)
            {
                PDPReviewsListFragment.b(a, false);
                return;
            } else
            {
                PDPReviewsListFragment.b(a, true);
                return;
            }
        }

            
            {
                a = PDPReviewsListFragment.this;
                super();
            }
    };
    private View a;
    private OverviewResponse b;
    private View c;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private ListView l;
    private ArrayList m;
    private fb n;
    private DialogSpinner o;
    private View p;
    private boolean q;
    private String r;
    private LinearLayout s;
    private LinearLayout t;
    private RelativeLayout u;
    private PDPOverviewResponse v;
    private View w;
    private String x;
    private String y;
    private int z;

    public PDPReviewsListFragment()
    {
        g = 10;
        h = 0;
        j = 0;
        k = 0;
        m = new ArrayList();
        r = "Helpfulness:desc,SubmissionTime:desc";
        x = "";
        z = 0;
    }

    public PDPReviewsListFragment(OverviewResponse overviewresponse, PDPOverviewResponse pdpoverviewresponse)
    {
        g = 10;
        h = 0;
        j = 0;
        k = 0;
        m = new ArrayList();
        r = "Helpfulness:desc,SubmissionTime:desc";
        x = "";
        z = 0;
        b = overviewresponse;
        v = pdpoverviewresponse;
    }

    public PDPReviewsListFragment(OverviewResponse overviewresponse, PDPOverviewResponse pdpoverviewresponse, PDPFragment pdpfragment)
    {
        g = 10;
        h = 0;
        j = 0;
        k = 0;
        m = new ArrayList();
        r = "Helpfulness:desc,SubmissionTime:desc";
        x = "";
        z = 0;
        b = overviewresponse;
        v = pdpoverviewresponse;
        D = pdpfragment;
    }

    public PDPReviewsListFragment(OverviewResponse overviewresponse, PDPOverviewResponse pdpoverviewresponse, String s1)
    {
        g = 10;
        h = 0;
        j = 0;
        k = 0;
        m = new ArrayList();
        r = "Helpfulness:desc,SubmissionTime:desc";
        x = "";
        z = 0;
        b = overviewresponse;
        v = pdpoverviewresponse;
        x = s1;
    }

    static int a(PDPReviewsListFragment pdpreviewslistfragment, int i1)
    {
        pdpreviewslistfragment.h = i1;
        return i1;
    }

    static TextView a(PDPReviewsListFragment pdpreviewslistfragment, TextView textview)
    {
        pdpreviewslistfragment.B = textview;
        return textview;
    }

    static DialogSpinner a(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.o;
    }

    static String a(PDPReviewsListFragment pdpreviewslistfragment, String s1)
    {
        pdpreviewslistfragment.r = s1;
        return s1;
    }

    static boolean a(PDPReviewsListFragment pdpreviewslistfragment, boolean flag)
    {
        pdpreviewslistfragment.q = flag;
        return flag;
    }

    static int b(PDPReviewsListFragment pdpreviewslistfragment, int i1)
    {
        pdpreviewslistfragment.j = i1;
        return i1;
    }

    static View b(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.c;
    }

    static boolean b(PDPReviewsListFragment pdpreviewslistfragment, boolean flag)
    {
        pdpreviewslistfragment.i = flag;
        return flag;
    }

    static OverviewResponse c(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.b;
    }

    static int d(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.g;
    }

    static int e(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.h;
    }

    static String f(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.r;
    }

    static String g(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.x;
    }

    static RelativeLayout h(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.A;
    }

    static boolean i(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.i;
    }

    static ListView j(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.l;
    }

    static int k(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.k;
    }

    static String l(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.y;
    }

    static int m(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.z;
    }

    static PDPOverviewResponse n(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.v;
    }

    static int o(PDPReviewsListFragment pdpreviewslistfragment)
    {
        int i1 = pdpreviewslistfragment.h;
        pdpreviewslistfragment.h = i1 + 1;
        return i1;
    }

    static String p(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.C;
    }

    static TextView q(PDPReviewsListFragment pdpreviewslistfragment)
    {
        return pdpreviewslistfragment.B;
    }

    public void a(FeatureReviewsResponse featurereviewsresponse)
    {
        A.setVisibility(8);
        if (featurereviewsresponse != null)
        {
            k = k + featurereviewsresponse.getResults().size();
            y = featurereviewsresponse.getNext();
            if (h == 0)
            {
                k = featurereviewsresponse.getResults().size();
                m = featurereviewsresponse.getResults();
                if (m != null && m.size() > 0)
                {
                    n = new fb(d, g, m);
                }
                if (y != null && !y.isEmpty())
                {
                    l.addFooterView(p);
                    z = 1;
                }
                l.setAdapter(n);
            } else
            {
                m.addAll(featurereviewsresponse.getResults());
                n.notifyDataSetChanged();
            }
            if (y == null || y.isEmpty())
            {
                l.removeFooterView(p);
                n.notifyDataSetChanged();
            }
        }
    }

    public void a(ReviewsResponse reviewsresponse)
    {
        A.setVisibility(0);
        k = reviewsresponse.getTotalResults();
        if (h <= 0)
        {
            m = reviewsresponse.getResults();
            if (m != null && !reviewsresponse.isHasErrors())
            {
                if (l.getHeaderViewsCount() == 0 && l.getFooterViewsCount() == 0 && m.size() > 1)
                {
                    l.addHeaderView(w);
                    l.addFooterView(p, null, false);
                }
                n = new fb(d, g, m);
                l.setAdapter(n);
            }
        } else
        {
            if (q)
            {
                m = reviewsresponse.getResults();
            } else
            {
                m.addAll(reviewsresponse.getResults());
            }
            n.notifyDataSetChanged();
        }
        if (k == m.size())
        {
            l.removeFooterView(p);
        }
    }

    public void a(String s1)
    {
        x = s1;
        if (v != null && v.getDistilledReviewSummary() != null && s1 != null && !s1.isEmpty())
        {
            ((BBYBaseFragmentActivity)d).changeActionBarClearVisibility(d, true);
            (new ig(d, this, c, v.getOverview().getSkuId(), s1, h, null)).executeOnExecutor(nb.h, new Void[0]);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).changeActionBarClearVisibility(d, false);
            (new hi(d, this, c, b.getSkuId(), g, h, r)).executeOnExecutor(nb.h, new Void[0]);
            s1 = new ArrayList();
            s1.add("Most Helpful");
            s1.add("Newest");
            s1.add("Oldest");
            s1.add("Highest Rated");
            s1.add("Lowest Rated");
            s1 = new ArrayAdapter(d, 0x7f03002c, s1);
            s1.setDropDownViewResource(0x1090009);
            o.setAdapter(s1);
            o.setSelection(0x80000000, false);
            o.setOnItemSelectedListener(F);
            return;
        }
    }

    public void a(String s1, ArrayList arraylist, LinearLayout linearlayout, String s2)
    {
        TextView textview;
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.setMargins(0, 0, 0, 10);
        textview = new TextView(a.getContext());
        if (s1.equals("Cons"))
        {
            textview.setTextColor(getActivity().getResources().getColor(0x7f0b000d));
            break MISSING_BLOCK_LABEL_67;
        } else
        {
            if (s1.equals("Pros"))
            {
                textview.setTextColor(getActivity().getResources().getColor(0x7f0b0007));
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
                TextView textview1 = new TextView(a.getContext());
                textview1.setTag("UnClicked");
                textview1.setTextSize(15F);
                if (!s2.isEmpty() && ((ReviewFeaturesDetails)arraylist.get(i1)).getFeature().equals(s2))
                {
                    textview1.setTextColor(getActivity().getResources().getColor(0x7f0b0063));
                    textview1.setBackgroundResource(0x7f0201b0);
                    textview1.setTag("Clicked");
                    B = textview1;
                } else
                {
                    textview1.setTextColor(getActivity().getResources().getColor(0x7f0b0031));
                    textview1.setBackgroundResource(0x7f0201b1);
                }
                textview1.setLayoutParams(layoutparams);
                textview1.setId(i1);
                if (s1.equals("Cons"))
                {
                    textview1.setText((new StringBuilder()).append(((ReviewFeaturesDetails)arraylist.get(i1)).getFeature()).append(" (").append(((ReviewFeaturesDetails)arraylist.get(i1)).getNegativeReviewsMentioned()).append(")").toString());
                } else
                if (s1.equals("Pros"))
                {
                    textview1.setText((new StringBuilder()).append(((ReviewFeaturesDetails)arraylist.get(i1)).getFeature()).append(" (").append(((ReviewFeaturesDetails)arraylist.get(i1)).getPositiveReviewsMentioned()).append(")").toString());
                }
                textview1.setOnClickListener(new android.view.View.OnClickListener(s1, textview1, arraylist) {

                    final String a;
                    final TextView b;
                    final ArrayList c;
                    final PDPReviewsListFragment d;

                    public void onClick(View view)
                    {
                        HashMap hashmap = new HashMap();
                        hashmap.put("&&products", (new StringBuilder()).append(";").append(PDPReviewsListFragment.c(d).getSkuId()).toString());
                        if (a.equals("Cons"))
                        {
                            hashmap.put("bb.distilledReviewCon", "1");
                            hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PDPReviewsListFragment.p(d)).append("pdp: distilled review: con: reviews").toString());
                            lu.b((new StringBuilder()).append(PDPReviewsListFragment.p(d)).append("pdp: reviews: con").toString(), hashmap);
                        } else
                        if (a.equals("Pros"))
                        {
                            hashmap.put("bb.distilledReviewPro", "1");
                            hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PDPReviewsListFragment.p(d)).append("pdp: distilled review: pro: reviews").toString());
                            lu.b((new StringBuilder()).append(PDPReviewsListFragment.p(d)).append("pdp: reviews: pro").toString(), hashmap);
                        }
                        if (PDPReviewsListFragment.q(d) == null)
                        {
                            PDPReviewsListFragment.a(d, b);
                        } else
                        if (!PDPReviewsListFragment.q(d).getText().toString().equals(b.getText().toString()))
                        {
                            PDPReviewsListFragment.q(d).setTag("UnClicked");
                            PDPReviewsListFragment.q(d).setTextColor(d.getActivity().getResources().getColor(0x7f0b0031));
                            PDPReviewsListFragment.q(d).setBackgroundResource(0x7f0201b1);
                            PDPReviewsListFragment.a(d, b);
                        }
                        if (b.getTag().equals("UnClicked"))
                        {
                            PDPReviewsListFragment.a(d, 0);
                            b.setTag("Clicked");
                            b.setTextColor(d.getActivity().getResources().getColor(0x7f0b0063));
                            b.setBackgroundResource(0x7f0201b0);
                            d.a(((ReviewFeaturesDetails)c.get(view.getId())).getFeature());
                            return;
                        } else
                        {
                            PDPReviewsListFragment.a(d, 0);
                            b.setTag("UnClicked");
                            b.setTextColor(d.getActivity().getResources().getColor(0x7f0b0031));
                            b.setBackgroundResource(0x7f0201b1);
                            d.a(null);
                            return;
                        }
                    }

            
            {
                d = PDPReviewsListFragment.this;
                a = s1;
                b = textview;
                c = arraylist;
                super();
            }
                });
                linearlayout.addView(textview1);
                i1++;
            } while (true);
            linearlayout.addView(textview, 0);
            return;
        } while (true);
    }

    public void b()
    {
        ((PDPFragmentContainer)getParentFragment()).e();
        PDPReviewsListFragment pdpreviewslistfragment = new PDPReviewsListFragment(b, v);
        ((PDPFragmentContainer)getParentFragment()).a(pdpreviewslistfragment, true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        ((HomeActivity)d).setOnClearReviewsListener(this);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle("Ratings & Reviews");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            C = bundle.getString("BreadCrumb");
            E = (PDPOverviewResponseRoot)bundle.getSerializable("PDPOverviewResponseRoot");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            a = layoutinflater.inflate(0x7f0300b0, viewgroup, false);
            c = a.findViewById(0x7f0c0064);
            l = (ListView)a.findViewById(0x7f0c02bb);
            p = layoutinflater.inflate(0x7f0300d9, null);
            w = layoutinflater.inflate(0x7f03003c, null);
            u = (RelativeLayout)w.findViewById(0x7f0c00fc);
            A = (RelativeLayout)w.findViewById(0x7f0c00fe);
            o = (DialogSpinner)w.findViewById(0x7f0c0100);
            l.setOnScrollListener(G);
            a(x);
            if (v != null && v.getDistilledReviewSummary() != null)
            {
                u.setVisibility(0);
                layoutinflater = layoutinflater.inflate(0x7f0300d4, null);
                s = (LinearLayout)layoutinflater.findViewById(0x7f0c034c);
                t = (LinearLayout)layoutinflater.findViewById(0x7f0c034d);
                u.addView(layoutinflater);
                if (v.getDistilledReviewSummary().getBestFeatures() != null && v.getDistilledReviewSummary().getBestFeatures().size() > 0)
                {
                    a("Pros", v.getDistilledReviewSummary().getBestFeatures(), s, x);
                }
                if (v.getDistilledReviewSummary().getWorstFeatures() != null && v.getDistilledReviewSummary().getWorstFeatures().size() > 0)
                {
                    a("Cons", v.getDistilledReviewSummary().getWorstFeatures(), t, x);
                }
                l.addHeaderView(w);
            } else
            {
                u.setVisibility(8);
            }
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
        ((BBYBaseFragmentActivity)d).changeActionBarClearVisibility(d, false);
        if (D != null)
        {
            D.a(E, C);
        }
    }

    public void onResume()
    {
label0:
        {
            super.onResume();
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Ratings & Reviews");
            if (l())
            {
                if (v == null || v.getDistilledReviewSummary() == null || x == null || x.isEmpty())
                {
                    break label0;
                }
                (new ig(d, this, c, v.getOverview().getSkuId(), x, h, null)).executeOnExecutor(nb.h, new Void[0]);
            }
            return;
        }
        (new hi(d, this, c, b.getSkuId(), g, h, r)).executeOnExecutor(nb.h, new Void[0]);
    }
}
