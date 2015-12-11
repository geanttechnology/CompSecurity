// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPBundledProductFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.BundleItems;
import com.bestbuy.android.api.lib.models.pdp.ContractOption;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.ProductOption;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsList;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Price;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SellerInfo;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fr;
import im;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lb;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragmentContainer, PDPFragment, PDPProductAvailabilityContainer, PDPSourceProductAvailabilityFragment, 
//            PDPOptionsSubFragment

public class PDPSourceDetailFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private BBYTextView A;
    private BBYTextView B;
    private BBYTextView C;
    private BBYTextView D;
    private BBYTextView E;
    private BBYTextView F;
    private BBYTextView G;
    private ArrayList H;
    private LinearLayout I;
    private ArrayList J;
    private ArrayList K;
    private View L;
    private Set M;
    private BuyingOptionsResponse N;
    private BBYTextView O;
    private BBYTextView P;
    private String Q;
    private String R;
    private PDPOverviewResponse S;
    private OverviewResponse a;
    private DNMProduct b;
    private View c;
    private View g;
    private View h;
    private String i;
    private String j;
    private Double k;
    private Double l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private ImageView x;
    private BBYTextView y;
    private BBYTextView z;

    public PDPSourceDetailFragment()
    {
        j = "";
        k = Double.valueOf(0.0D);
        J = new ArrayList();
        M = new HashSet();
    }

    public PDPSourceDetailFragment(OverviewResponse overviewresponse, DNMProduct dnmproduct, PDPOverviewResponse pdpoverviewresponse)
    {
        j = "";
        k = Double.valueOf(0.0D);
        J = new ArrayList();
        M = new HashSet();
        a = overviewresponse;
        b = dnmproduct;
        S = pdpoverviewresponse;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        bundle.putSerializable("dnmProduct", dnmproduct);
        bundle.putSerializable("pdpOverviewResponse", pdpoverviewresponse);
        setArguments(bundle);
    }

    static String a(PDPSourceDetailFragment pdpsourcedetailfragment)
    {
        return pdpsourcedetailfragment.Q;
    }

    static String a(PDPSourceDetailFragment pdpsourcedetailfragment, String s1)
    {
        pdpsourcedetailfragment.Q = s1;
        return s1;
    }

    private void a(DNMProduct dnmproduct, String s1)
    {
        int i1 = 0;
        g.setVisibility(0);
        o.setVisibility(0);
        String s2 = dnmproduct.getOpenBoxCondition();
        if (s2 != null && !s2.equals(getString(0x7f080068)))
        {
            s1 = s2;
            if (s2.equals("Certified"))
            {
                s1 = "Geek Squad Certified";
            }
            p.setVisibility(0);
            A.setText(s1);
        }
        if (!dnmproduct.getOpenBoxDamageType().equals(getString(0x7f080068)))
        {
            q.setVisibility(0);
            String s3 = dnmproduct.getOpenBoxDamageType();
            s1 = s3;
            if (!dnmproduct.getOpenBoxDamageLocation().equals(getString(0x7f080068)))
            {
                s1 = (new StringBuilder()).append(s3).append(", ").append(Html.fromHtml("<i> Location: </i>")).append(dnmproduct.getOpenBoxDamageLocation()).toString();
            }
            B.setText(s1);
        }
        H = dnmproduct.getOpenBoxMissingAccessories();
        if (H != null && H.size() != 0)
        {
            r.setVisibility(0);
            dnmproduct = "";
            while (i1 < H.size()) 
            {
                if (H.size() == 1)
                {
                    dnmproduct = (new StringBuilder()).append(dnmproduct).append((String)H.get(i1)).toString();
                } else
                {
                    dnmproduct = (new StringBuilder()).append(dnmproduct).append((String)H.get(i1)).append(", ").toString();
                }
                i1++;
            }
            dnmproduct = dnmproduct.replaceAll(", $", "");
            C.setText(dnmproduct);
        }
    }

    private void a(OverviewResponse overviewresponse, String s1)
    {
        if ((b == null || !b.getDnmType().equals("Open Box")) && !s1.equalsIgnoreCase("openbox")) goto _L2; else goto _L1
_L1:
        m.setVisibility(0);
        h.setVisibility(0);
        n.setVisibility(0);
        P.setText("This is an ");
        x.setImageResource(0x7f020134);
        ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Open-Box");
        if (b != null)
        {
            a(b, s1);
        }
_L4:
        return;
_L2:
        if (overviewresponse == null || overviewresponse.getAttributes() == null || !overviewresponse.getAttributes().isMarketplace())
        {
            break; /* Loop/switch isn't completed */
        }
        m.setVisibility(0);
        h.setVisibility(0);
        n.setVisibility(0);
        x.setImageResource(0x7f020111);
        if (s1.equalsIgnoreCase("pre-owned"))
        {
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Marketplace Pre-Owned");
        } else
        if (s1.equalsIgnoreCase("refurbished"))
        {
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Marketplace Refurbished");
            O.setText("About Marketplace Refurbished");
        } else
        {
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Marketplace");
        }
        O.setPaintFlags(8);
        O.setOnClickListener(new android.view.View.OnClickListener(s1) {

            final String a;
            final PDPSourceDetailFragment b;

            public void onClick(View view)
            {
                if (a.equalsIgnoreCase("refurbished"))
                {
                    view = new lb(b.d, 0x7f080229, 0x7f080228);
                } else
                {
                    view = new lb(b.d, 0x7f08022b, 0x7f080227);
                }
                view.show();
            }

            
            {
                b = PDPSourceDetailFragment.this;
                a = s1;
                super();
            }
        });
        overviewresponse = overviewresponse.getPriceBlock();
        if (overviewresponse != null)
        {
            overviewresponse = overviewresponse.getSellerInfo();
            if (overviewresponse != null)
            {
                s.setVisibility(0);
                if (overviewresponse.getSeller() != null)
                {
                    t.setVisibility(0);
                    D.setText(overviewresponse.getSeller());
                    D.setOnClickListener(new android.view.View.OnClickListener(overviewresponse) {

                        final SellerInfo a;
                        final PDPSourceDetailFragment b;

                        public void onClick(View view)
                        {
                            PDPSourceDetailFragment.a(b, (new StringBuilder()).append("http://www.bestbuy.com").append(a.getSellerUrl()).toString());
                            b.a(PDPSourceDetailFragment.a(b));
                        }

            
            {
                b = PDPSourceDetailFragment.this;
                a = sellerinfo;
                super();
            }
                    });
                }
                if (overviewresponse.getAverageScore() != null)
                {
                    u.setVisibility(0);
                    E.setText((new StringBuilder()).append(overviewresponse.getAverageScore()).append(" out of 5").toString());
                    return;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s1.equalsIgnoreCase(getString(0x7f080077)) || overviewresponse.getCondition().equalsIgnoreCase("refurbished"))
        {
            m.setVisibility(0);
            h.setVisibility(0);
            n.setVisibility(0);
            x.setImageResource(0x7f02016a);
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(getString(0x7f080077));
            return;
        }
        if (s1.equalsIgnoreCase("pre-owned"))
        {
            m.setVisibility(0);
            h.setVisibility(0);
            n.setVisibility(0);
            x.setImageResource(0x7f020159);
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Pre-Owned");
            return;
        }
        if (overviewresponse.getProductType().equalsIgnoreCase("bundle"))
        {
            m.setVisibility(0);
            h.setVisibility(0);
            n.setVisibility(0);
            x.setImageResource(0x7f02005c);
            ((BBYTextView)c.findViewById(0x7f0c02cc)).setText(" Bundled");
            y.setText((new StringBuilder()).append(overviewresponse.getBundleItems().size()).append(" Items ").toString());
            z.setText("In This Bundle");
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void a(ArrayList arraylist)
    {
        I.setVisibility(0);
        ((BBYTextView)I.findViewById(0x7f0c0210)).setText((new StringBuilder()).append(a.getBundleItems().size()).append(" Items").toString());
        I.setOnClickListener(this);
    }

    private String b(String s1)
    {
        Object obj;
        try
        {
            double d = Double.parseDouble(s1);
            obj = new DecimalFormat("###,###,###.##");
            ((NumberFormat) (obj)).setMinimumFractionDigits(2);
            ((NumberFormat) (obj)).setMaximumFractionDigits(2);
            obj = ((NumberFormat) (obj)).format(Double.valueOf(d));
        }
        catch (Exception exception)
        {
            return s1;
        }
        return ((String) (obj));
    }

    public void a(BuyingOptionsResponse buyingoptionsresponse)
    {
_L2:
        return;
        if (b != null && b.getDnmType().equals("Open Box") || buyingoptionsresponse == null) goto _L2; else goto _L1
_L1:
        N = buyingoptionsresponse;
        K = buyingoptionsresponse.getBuyingOptions();
        if (K == null || K.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        m.setVisibility(0);
        h.setVisibility(0);
        v.setVisibility(0);
        if (((BuyingOptionsList)K.get(0)).getPrice() != null && ((BuyingOptionsList)K.get(0)).getPrice().getCurrentPrice() != 0.0D)
        {
            l = Double.valueOf(((BuyingOptionsList)K.get(0)).getPrice().getCurrentPrice());
        }
        int i1 = 0;
        while (i1 < K.size()) 
        {
            M.add(((BuyingOptionsList)K.get(i1)).getCondition());
            buyingoptionsresponse = fr.j();
            boolean flag;
            if (buyingoptionsresponse != null && buyingoptionsresponse.equals("10150"))
            {
                flag = true;
            } else
            if (buyingoptionsresponse != null && buyingoptionsresponse.equals("10067"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((((BuyingOptionsList)K.get(i1)).getPrice() == null || !((BuyingOptionsList)K.get(i1)).getPrice().getPricingType().equals("ICR-strikeThrough")) && !((BuyingOptionsList)K.get(i1)).getPrice().getPricingType().equals("MAP") && !((BuyingOptionsList)K.get(i1)).getPrice().getPricingType().equals("ICR-noPrice") || flag)
            {
                k = Double.valueOf(((BuyingOptionsList)K.get(i1)).getPrice().getCurrentPrice());
                if (l != null && k != null && k.compareTo(l) < 0)
                {
                    l = k;
                }
            }
            i1++;
        }
        j = "More buying options";
        y.setText((new StringBuilder()).append(j).append(" ").toString());
        if (l == null || Double.isNaN(l.doubleValue()))
        {
            z.setText(" ");
        } else
        {
            z.setText((new StringBuilder()).append("From $").append(b(Double.toString(l.doubleValue()))).toString());
        }
        if (a.getPriceBlock() == null || a.getPriceBlock().getProductOptions() == null || a.getPriceBlock().getProductOptions().getContractOptions() == null || a.getPriceBlock().getProductOptions().getContractOptions().size() <= 0) goto _L2; else goto _L3
_L3:
        m.setVisibility(0);
        h.setVisibility(0);
        w.setVisibility(0);
        F.setText(((ContractOption)a.getPriceBlock().getProductOptions().getContractOptions().get(0)).getType());
        G.setText(getResources().getString(0x7f08029b));
        return;
    }

    public void a(String s1)
    {
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        android.support.v4.app.Fragment fragment = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        MdotWebFragment mdotwebfragment = new MdotWebFragment(true, true);
        Bundle bundle = new Bundle();
        bundle.putString(getResources().getString(0x7f080055), s1);
        mdotwebfragment.setArguments(bundle);
        if (fragment instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(mdotwebfragment, true);
            return;
        }
        if (fragment instanceof PDPFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(mdotwebfragment, true);
            return;
        } else
        {
            ((HomeActivity)d).addFragment(0x7f0c0033, mdotwebfragment, "MdotWebFragment");
            return;
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
        if (view == I)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            view = new PLPBundledProductFragment(d, J);
            ((PDPFragmentContainer)((PDPFragment)getParentFragment()).getParentFragment()).a(view, true);
        } else
        {
            if (view == v)
            {
                view = (PDPFragment)getParentFragment();
                PDPProductAvailabilityContainer pdpproductavailabilitycontainer = new PDPProductAvailabilityContainer(" Product Availability ");
                PDPSourceProductAvailabilityFragment pdpsourceproductavailabilityfragment = new PDPSourceProductAvailabilityFragment(a, getParentFragment(), N, S);
                ((PDPFragmentContainer)view.getParentFragment()).a(pdpproductavailabilitycontainer, true);
                pdpproductavailabilitycontainer.a(pdpsourceproductavailabilityfragment, true);
                return;
            }
            if (view == w)
            {
                Object obj = a.getPriceBlock();
                if (obj != null && ((PriceBlock) (obj)).getProductOptions() != null && ((PriceBlock) (obj)).getProductOptions().getContractOptions() != null)
                {
                    view = (PDPFragment)getParentFragment();
                    obj = new PDPOptionsSubFragment(((PriceBlock) (obj)).getProductOptions().getContractOptions(), true);
                    ((PDPFragmentContainer)view.getParentFragment()).a(((android.support.v4.app.Fragment) (obj)), true);
                    return;
                }
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            bundle = getArguments();
            a = (OverviewResponse)bundle.getSerializable("product");
            b = (DNMProduct)bundle.getSerializable("dnmProduct");
            S = (PDPOverviewResponse)bundle.getSerializable("pdpOverviewResponse");
        }
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f0300b3, viewgroup, false);
            L = c.findViewById(0x7f0c0064);
            m = (LinearLayout)c.findViewById(0x7f0c02c8);
            I = (LinearLayout)c.findViewById(0x7f0c02e8);
            P = (BBYTextView)c.findViewById(0x7f0c02ca);
            x = (ImageView)c.findViewById(0x7f0c02cb);
            n = (LinearLayout)c.findViewById(0x7f0c02c9);
            v = (RelativeLayout)c.findViewById(0x7f0c02e4);
            y = (BBYTextView)v.findViewById(0x7f0c02e5);
            z = (BBYTextView)v.findViewById(0x7f0c02e7);
            o = (LinearLayout)c.findViewById(0x7f0c02d6);
            p = (LinearLayout)c.findViewById(0x7f0c02d7);
            A = (BBYTextView)c.findViewById(0x7f0c02d9);
            q = (LinearLayout)c.findViewById(0x7f0c02da);
            B = (BBYTextView)c.findViewById(0x7f0c02dc);
            r = (LinearLayout)c.findViewById(0x7f0c02dd);
            C = (BBYTextView)c.findViewById(0x7f0c02df);
            s = (LinearLayout)c.findViewById(0x7f0c02ce);
            O = (BBYTextView)c.findViewById(0x7f0c02cf);
            t = (LinearLayout)c.findViewById(0x7f0c02d0);
            u = (LinearLayout)c.findViewById(0x7f0c02d3);
            D = (BBYTextView)c.findViewById(0x7f0c02d2);
            E = (BBYTextView)c.findViewById(0x7f0c02d5);
            g = c.findViewById(0x7f0c02ab);
            h = c.findViewById(0x7f0c02e9);
            w = (RelativeLayout)c.findViewById(0x7f0c02e0);
            F = (BBYTextView)c.findViewById(0x7f0c02e1);
            G = (BBYTextView)c.findViewById(0x7f0c02e3);
            m.setVisibility(8);
            v.setVisibility(8);
            n.setVisibility(8);
            w.setVisibility(8);
            v.setOnClickListener(this);
            w.setOnClickListener(this);
            if (a != null)
            {
                (new im(d, this, L, a.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                i = a.getCondition();
                if (i != null)
                {
                    a(a, i);
                }
                if (a.getBundleItems() != null)
                {
                    for (int i1 = 0; i1 < a.getBundleItems().size(); i1++)
                    {
                        R = ((BundleItems)a.getBundleItems().get(i1)).getSkuId();
                        J.add(R);
                    }

                    if (J != null && J.size() > 0)
                    {
                        J.removeAll(Arrays.asList(new String[] {
                            "", null
                        }));
                        a(J);
                    }
                }
            }
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }
}
