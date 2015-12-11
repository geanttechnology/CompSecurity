// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fl;
import ir;
import java.util.ArrayList;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMSubListContainer, DNMListFragmentContainer

public class DNMSubListFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private int A;
    private ArrayList B;
    private String C;
    private String D;
    private String E;
    private RelativeLayout F;
    private boolean G;
    private android.widget.AbsListView.OnScrollListener H = new android.widget.AbsListView.OnScrollListener() {

        final DNMSubListFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (DNMSubListFragment.a(a) && k1 > DNMSubListFragment.b(a))
            {
                DNMSubListFragment.a(a, k1);
                DNMSubListFragment.a(a, false);
            }
            if (!DNMSubListFragment.a(a) && i1 == k1 - j1 && k1 - DNMSubListFragment.c(a) < DNMSubListFragment.d(a))
            {
                DNMSubListFragment.b(a, DNMSubListFragment.e(a) + 1);
                (new ir(DNMSubListFragment.f(a), a, null, DNMSubListFragment.g(a), DNMSubListFragment.h(a), DNMSubListFragment.i(a), 50, DNMSubListFragment.j(a), DNMSubListFragment.k(a).getSkuId(), DNMSubListFragment.e(a), 20, DNMSubListFragment.l(a), DNMSubListFragment.m(a), DNMSubListFragment.n(a))).executeOnExecutor(nb.h, new Void[0]);
                DNMSubListFragment.a(a, true);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
        }

            
            {
                a = DNMSubListFragment.this;
                super();
            }
    };
    private Activity a;
    private View b;
    private String c;
    private View g;
    private int h;
    private fl i;
    private View j;
    private ArrayList k;
    private ArrayList l;
    private boolean m;
    private int n;
    private String o;
    private int p;
    private int q;
    private BBYProduct r;
    private BBYTextView s;
    private ImageView t;
    private RatingBar u;
    private BBYTextView v;
    private ListView w;
    private boolean x;
    private double y;
    private double z;

    public DNMSubListFragment()
    {
        h = 1;
        k = new ArrayList();
        l = new ArrayList();
        m = true;
        n = 0;
        q = 0;
        x = true;
        G = false;
    }

    public DNMSubListFragment(BBYProduct bbyproduct, String s1, double d1, double d2, String s2, 
            int i1, ArrayList arraylist, String s3, String s4)
    {
        h = 1;
        k = new ArrayList();
        l = new ArrayList();
        m = true;
        n = 0;
        q = 0;
        x = true;
        G = false;
        c = s1;
        r = bbyproduct;
        E = bbyproduct.getSkuId();
        y = d1;
        z = d2;
        o = s2;
        A = i1;
        B = arraylist;
        C = s3;
        D = s4;
    }

    static int a(DNMSubListFragment dnmsublistfragment, int i1)
    {
        dnmsublistfragment.n = i1;
        return i1;
    }

    static boolean a(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.m;
    }

    static boolean a(DNMSubListFragment dnmsublistfragment, boolean flag)
    {
        dnmsublistfragment.m = flag;
        return flag;
    }

    static int b(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.n;
    }

    static int b(DNMSubListFragment dnmsublistfragment, int i1)
    {
        dnmsublistfragment.h = i1;
        return i1;
    }

    static int c(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.q;
    }

    static int d(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.p;
    }

    static int e(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.h;
    }

    static Activity f(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.a;
    }

    static String g(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.o;
    }

    static double h(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.y;
    }

    static double i(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.z;
    }

    static String j(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.c;
    }

    static BBYProduct k(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.r;
    }

    static ArrayList l(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.B;
    }

    static String m(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.C;
    }

    static String n(DNMSubListFragment dnmsublistfragment)
    {
        return dnmsublistfragment.D;
    }

    public void a(DNMResponse dnmresponse)
    {
        p = dnmresponse.getTotalCount();
        if (G && p == 1)
        {
            DNMSubListContainer dnmsublistcontainer = (DNMSubListContainer)getParentFragment();
            dnmresponse = (DNMProduct)dnmresponse.getDnmProducts().get(0);
            String s1 = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
            ((CartTabContainer)dnmsublistcontainer.getParentFragment()).a("DNMSubListContainer");
            ((CartTabContainer)dnmsublistcontainer.getParentFragment()).a(dnmresponse, s1);
        } else
        {
            if (h <= 1)
            {
                if (G && p > 1)
                {
                    ((BBYBaseFragmentActivity)a).updateActionBarTitle("Product Availability");
                }
                j.findViewById(0x7f0c0303).setVisibility(0);
                w.removeFooterView(j);
                m = true;
                n = 0;
                l.clear();
                l.addAll(dnmresponse.getDnmProducts());
                k.clear();
                k.addAll(dnmresponse.getProducts());
                w.addFooterView(j, null, false);
                j.findViewById(0x7f0c0304).setVisibility(8);
                q = 1;
                i = new fl(a, 0x7f030035, k, l, f);
                w.setAdapter(i);
                w.setOnItemClickListener(this);
            } else
            {
                k.addAll(dnmresponse.getProducts());
                l.addAll(dnmresponse.getDnmProducts());
                i.notifyDataSetChanged();
            }
            w.setOnScrollListener(H);
            if (p == k.size())
            {
                q = 0;
                j.findViewById(0x7f0c0303).setVisibility(8);
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        f.i(bundle);
        if (!G)
        {
            ((BBYBaseFragmentActivity)a).updateActionBarTitle("Product Availability");
        }
        ((HomeActivity)a).changeSearchBarVisibility(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
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
        if (b == null)
        {
            b = layoutinflater.inflate(0x7f030033, viewgroup, false);
            w = (ListView)b.findViewById(0x7f0c00de);
            j = layoutinflater.inflate(0x7f0300bc, null);
            g = b.findViewById(0x7f0c0064);
            s = (BBYTextView)b.findViewById(0x7f0c00c9);
            t = (ImageView)b.findViewById(0x7f0c00c8);
            u = (RatingBar)b.findViewById(0x7f0c00dc);
            v = (BBYTextView)b.findViewById(0x7f0c00dd);
            F = (RelativeLayout)b.findViewById(0x7f0c00db);
            (new ir(a, this, g, o, y, z, 50, c, E, h, 20, B, C, D)).executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)b.getParent()).removeView(b);
        }
        if (r == null) goto _L2; else goto _L1
_L1:
label0:
        {
label1:
            {
                bundle = r.getSummary();
                s.setText(Html.fromHtml(bundle.getNames().getShortName()));
                u.setNumStars(5);
                float f2 = 0.0F;
                float f1 = f2;
                if (bundle.getCustomerRatings() != null)
                {
                    f1 = f2;
                    if (bundle.getCustomerRatings().getAverageRating() != null)
                    {
                        f1 = (float)bundle.getCustomerRatings().getAverageRating().getScore();
                    }
                }
                u.setRating(f1);
                int i1 = bundle.getCustomerRatings().getTotalCount();
                if (i1 == 1)
                {
                    v.setText((new StringBuilder()).append("(").append(i1).append(" ").append(a.getString(0x7f0802df)).toString());
                } else
                {
                    v.setText((new StringBuilder()).append("(").append(i1).append(" ").append(a.getString(0x7f0802e0)).toString());
                }
                layoutinflater = "";
                viewgroup = layoutinflater;
                if (bundle.getMedia() == null)
                {
                    break label0;
                }
                viewgroup = layoutinflater;
                if (bundle.getMedia().getPrimaryImage() != null)
                {
                    viewgroup = bundle.getMedia().getPrimaryImage().getUrl();
                }
                if (!viewgroup.isEmpty())
                {
                    layoutinflater = viewgroup;
                    if (!viewgroup.equals(a.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                layoutinflater = viewgroup;
                if (bundle.getMedia().getListImage() != null)
                {
                    layoutinflater = bundle.getMedia().getListImage().getUrl();
                }
            }
            if (!layoutinflater.isEmpty())
            {
                viewgroup = layoutinflater;
                if (!layoutinflater.equals(a.getString(0x7f080068)))
                {
                    break label0;
                }
            }
            viewgroup = layoutinflater;
            if (bundle.getMedia().getThumbnailImage() != null)
            {
                viewgroup = bundle.getMedia().getThumbnailImage().getUrl();
            }
        }
        ng.a(viewgroup, t, false);
_L4:
        return b;
_L2:
        F.setVisibility(8);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        view = (DNMProduct)l.get(i1);
        adapterview = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        view = new PDPFragment(view.getSkuId(), view.getProductId(), x, view, false, A);
        adapterview = new PDPFragmentContainer(adapterview);
        if (getParentFragment() instanceof DNMSubListContainer)
        {
            ((DNMSubListContainer)getParentFragment()).a(adapterview, true);
        } else
        {
            ((DNMListFragmentContainer)getParentFragment()).a(adapterview, true);
        }
        adapterview.a(view, true);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)a).updateActionBarTitle("Product Availability");
        if (l())
        {
            (new ir(a, this, g, o, y, z, 50, c, r.getSkuId(), h, 20, B, C, D)).executeOnExecutor(nb.h, new Void[0]);
        }
    }
}
