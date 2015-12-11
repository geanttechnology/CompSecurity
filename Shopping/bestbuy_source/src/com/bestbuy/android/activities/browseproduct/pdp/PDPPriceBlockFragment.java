// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.HashMap;
import kf;
import lp;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPReviewsListFragment, PDPFragmentContainer

public class PDPPriceBlockFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    public static LinearLayout a;
    private static final String l = com/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment.getSimpleName();
    private Activity b;
    private OverviewResponse c;
    private View g;
    private boolean h;
    private DNMProduct i;
    private LinearLayout j;
    private LinearLayout k;
    private double m;
    private PDPOverviewResponse n;
    private String o;
    private PDPOverviewResponseRoot p;

    public PDPPriceBlockFragment()
    {
        m = 0.0D;
    }

    public PDPPriceBlockFragment(OverviewResponse overviewresponse, DNMProduct dnmproduct, boolean flag, PDPOverviewResponse pdpoverviewresponse)
    {
        m = 0.0D;
        c = overviewresponse;
        i = dnmproduct;
        h = flag;
        n = pdpoverviewresponse;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        bundle.putSerializable("dnmProduct", dnmproduct);
        bundle.putSerializable("pdpOverviewResponse", pdpoverviewresponse);
        bundle.putBoolean("isFromDNM", flag);
        setArguments(bundle);
    }

    private void a(MdotWebFragment mdotwebfragment)
    {
        try
        {
            ((BBYBaseFragmentActivity)b).changeActionBarShareVisibility(b, false);
            android.support.v4.app.Fragment fragment = ((FragmentActivity)b).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (fragment instanceof HomeTabFragment)
            {
                ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(mdotwebfragment, true);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MdotWebFragment mdotwebfragment)
        {
            kf.e(l, (new StringBuilder()).append("Error attempting to open delievery mDot punch out").append(mdotwebfragment.getLocalizedMessage()).toString());
        }
    }

    public void a(PriceBlock priceblock)
    {
        Object obj = new BBYProduct();
        ((BBYProduct) (obj)).setPriceBlock(priceblock);
        if (c != null && c.getRestrictedPriceBlock() != null)
        {
            ((BBYProduct) (obj)).setRestrictedPrice(c.getRestrictedPriceBlock().getPrice());
        }
        Summary summary = new Summary();
        summary.setActive(c.isActive());
        summary.setAttributes(c.getAttributes());
        summary.setAvailability(c.getAvailability());
        summary.setBrand(c.getBrand());
        summary.setNames(c.getNames());
        summary.setPdpMedia(c.getMedia());
        summary.setCondition(c.getCondition());
        summary.setCustomerRatings(c.getCustomerRatings());
        summary.setDepartment(c.getDepartment());
        summary.setDescriptions(c.getDescriptions());
        summary.setItemId(c.getProductId());
        summary.setManufacturerId(c.getManufacturerId());
        Properties properties = new Properties();
        properties.setChatType(c.getProperties().getFreeShippingCode());
        properties.setContractCondition(c.getProperties().getContractCondition());
        properties.setFileSize(c.getProperties().getFileSize());
        properties.setFormat(c.getProperties().getFormat());
        properties.setFreeShippingCode(c.getProperties().getFreeShippingCode());
        properties.setMediaType(c.getProperties().getMediaType());
        properties.setTopHat(c.getProperties().getTopHat());
        summary.setProperties(properties);
        ((BBYProduct) (obj)).setSummary(summary);
        a = (LinearLayout)g.findViewById(0x7f0c028c);
        a.removeAllViewsInLayout();
        if (priceblock != null)
        {
            c.setPriceBlock(priceblock);
        }
        if (h && i != null)
        {
            if (h)
            {
                boolean flag;
                if (i.getSkuTypeCode() != null && !i.getSkuTypeCode().equals(getString(0x7f080068)))
                {
                    if (i.getSkuTypeCode().equals(getString(0x7f08003a)))
                    {
                        flag = true;
                    } else
                    if (i.getSkuDisplayable() != null)
                    {
                        if (i.getSkuDisplayable().equals("1"))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                priceblock = lp.a(b, ((BBYProduct) (obj)), 4, true, i, flag, o);
            } else
            {
                priceblock = lp.a(b, ((BBYProduct) (obj)), 4, false, null, false, o);
            }
            a.addView(priceblock);
        }
        if (i == null || !i.getOpenBoxCondition().equalsIgnoreCase("Certified")) goto _L2; else goto _L1
_L1:
        k.setVisibility(0);
        k.setOnClickListener(this);
_L4:
        return;
_L2:
        if (summary == null || h)
        {
            break MISSING_BLOCK_LABEL_964;
        }
        priceblock = lp.a(b, ((BBYProduct) (obj)), 4, false, null, false, o);
        a.addView(priceblock);
        obj = summary.getProperties().getFreeShippingCode();
        if ((summary.getAttributes() == null || !summary.getAttributes().isLowPriceGuaranteedProduct()) && (obj == null || !((String) (obj)).contains("freeShipping") && !((String) (obj)).contains("freeDeliveryAppliance") && !((String) (obj)).contains("freeDeliveryTVs50in")))
        {
            break MISSING_BLOCK_LABEL_948;
        }
        if (obj == null || !((String) (obj)).contains("freeShipping") && !((String) (obj)).contains("freeDeliveryAppliance") && !((String) (obj)).contains("freeDeliveryTVs50in"))
        {
            continue; /* Loop/switch isn't completed */
        }
        g.findViewById(0x7f0c0292).setVisibility(0);
        priceblock = "";
        if (((String) (obj)).equals("freeShipping"))
        {
            priceblock = "FREE SHIPPING";
        } else
        if (((String) (obj)).equals("freeDeliveryAppliance"))
        {
            ((ImageView)g.findViewById(0x7f0c0293)).setImageResource(0x7f0200d0);
            priceblock = "FREE DELIVERY";
        } else
        if (((String) (obj)).contains("freeDeliveryTVs50in"))
        {
            ((ImageView)g.findViewById(0x7f0c0293)).setImageResource(0x7f0200d0);
            priceblock = "FREE DELIVERY ON TVS 51\" AND LARGER";
        } else
        if (((String) (obj)).contains("freeShipping"))
        {
            priceblock = ((String) (obj)).replace("freeShipping", "");
            priceblock = (new StringBuilder()).append("FREE SHIPPING ON ORDERS $").append(priceblock).append(" & UP").toString();
        }
        if (((String) (obj)).contains("freeDeliveryAppliance"))
        {
            priceblock = ((String) (obj)).replace("freeDeliveryAppliance", "");
            priceblock = (new StringBuilder()).append("FREE DELIVERY ON ORDERS $").append(priceblock).append(" & UP").toString();
            ((ImageView)g.findViewById(0x7f0c0293)).setImageResource(0x7f0200d0);
        }
        ((BBYTextView)g.findViewById(0x7f0c0294)).setText(priceblock);
        if (summary.getAttributes() == null || !summary.getAttributes().isLowPriceGuaranteedProduct()) goto _L4; else goto _L3
_L3:
        g.findViewById(0x7f0c0291).setVisibility(0);
        return;
        g.findViewById(0x7f0c0290).setVisibility(8);
        return;
        g.findViewById(0x7f0c0290).setVisibility(8);
        return;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (c != null)
        {
            a(c.getPriceBlock());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = activity;
    }

    public void onClick(View view)
    {
        if (view == j && m != 0.0D)
        {
            Object obj = new HashMap();
            ((HashMap) (obj)).put("bb.ratingsReviews", "1");
            ((HashMap) (obj)).put("bb.reviewsInteraction", "Ratings & Reviews: PDP");
            ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(o).append("pdp: reviews").toString());
            ((HashMap) (obj)).put("&&products", (new StringBuilder()).append(";").append(c.getSkuId()).toString());
            lu.b((new StringBuilder()).append(o).append("pdp: reviews").toString(), ((HashMap) (obj)));
            obj = (PDPFragment)getParentFragment();
            PDPReviewsListFragment pdpreviewslistfragment = new PDPReviewsListFragment(c, n, ((PDPFragment) (obj)));
            Bundle bundle1 = new Bundle();
            bundle1.putString("BreadCrumb", o);
            bundle1.putSerializable("PDPOverviewResponseRoot", p);
            pdpreviewslistfragment.setArguments(bundle1);
            ((PDPFragmentContainer)((PDPFragment) (obj)).getParentFragment()).a(pdpreviewslistfragment, true);
        }
        if (view == k)
        {
            view = ((BBYBaseFragmentActivity)b).getCurrentActionBarTitle();
            f.i(view);
            ((BBYBaseFragmentActivity)b).updateActionBarTitle(getResources().getString(0x7f0801b8));
            view = new MdotWebFragment(false);
            Bundle bundle = new Bundle();
            bundle.putString(getResources().getString(0x7f080055), "file:///android_asset/geek-certified-info.html");
            view.setArguments(bundle);
            a(view);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (c == null)
        {
            bundle = getArguments();
            if (bundle != null)
            {
                o = bundle.getString("BreadCrumb");
                p = (PDPOverviewResponseRoot)bundle.getSerializable("PDPOverviewResponseRoot");
                c = (OverviewResponse)bundle.getSerializable("product");
                i = (DNMProduct)bundle.getSerializable("dnmProduct");
                h = bundle.getBoolean("isFromDNM");
                n = (PDPOverviewResponse)bundle.getSerializable("pdpOverviewResponse");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i1;
        if (h && i != null)
        {
            m = i.getCustomerRating();
            i1 = Integer.parseInt(i.getNumberOfReviews());
        } else
        if (c != null && c.getCustomerRatings() != null && c.getCustomerRatings().getAverageRating() != null)
        {
            m = c.getCustomerRatings().getAverageRating().getScore();
            i1 = c.getCustomerRatings().getTotalCount();
        } else
        {
            i1 = 0;
        }
        g = layoutinflater.inflate(0x7f0300aa, viewgroup, false);
        j = (LinearLayout)g.findViewById(0x7f0c028d);
        k = (LinearLayout)g.findViewById(0x7f0c0295);
        layoutinflater = (RatingBar)g.findViewById(0x7f0c00cb);
        viewgroup = (BBYTextView)g.findViewById(0x7f0c00cc);
        bundle = (BBYTextView)g.findViewById(0x7f0c028e);
        layoutinflater.setNumStars(5);
        if (c != null && c.getProductType() != null && c.getProductType().equals("bundle"))
        {
            layoutinflater.setVisibility(8);
            viewgroup.setVisibility(8);
            bundle.setVisibility(8);
        } else
        if (m != 0.0D)
        {
            layoutinflater.setRating((float)m);
            if (i1 == 1)
            {
                viewgroup.setText((new StringBuilder()).append("(").append(i1).append(" ").append(b.getString(0x7f0802df)).toString());
            } else
            {
                viewgroup.setText((new StringBuilder()).append("(").append(i1).append(" ").append(b.getString(0x7f0802e0)).toString());
            }
            bundle.setText((new StringBuilder()).append("").append(m).toString());
        } else
        {
            viewgroup.setText(b.getString(0x7f080394));
        }
        j.setOnClickListener(this);
        return g;
    }

    public void onResume()
    {
        super.onResume();
    }

}
