// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.Dates;
import com.bestbuy.android.api.lib.models.pdp.ESRBRating;
import com.bestbuy.android.api.lib.models.pdp.Link;
import com.bestbuy.android.api.lib.models.pdp.MovieRatings;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.Properties;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Brand;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Manufacturer;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PrimaryArtist;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SellerInfo;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragmentContainer

public class PDPSkuAndTitleFragment extends BBYBaseFragment
{

    private OverviewResponse a;
    private View b;
    private BBYTextView c;
    private String g;
    private boolean h;
    private String i;
    private DNMProduct j;

    public PDPSkuAndTitleFragment()
    {
    }

    public PDPSkuAndTitleFragment(OverviewResponse overviewresponse, DNMProduct dnmproduct, boolean flag)
    {
        a = overviewresponse;
        j = dnmproduct;
        h = flag;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        bundle.putSerializable("dnmProduct", dnmproduct);
        bundle.putBoolean("isFromDNM", flag);
        setArguments(bundle);
    }

    static BBYTextView a(PDPSkuAndTitleFragment pdpskuandtitlefragment)
    {
        return pdpskuandtitlefragment.c;
    }

    static String a(PDPSkuAndTitleFragment pdpskuandtitlefragment, String s)
    {
        pdpskuandtitlefragment.i = s;
        return s;
    }

    static String b(PDPSkuAndTitleFragment pdpskuandtitlefragment)
    {
        return pdpskuandtitlefragment.g;
    }

    private void b()
    {
        Object obj4;
        Object obj5;
        if (j != null)
        {
            Object obj = j.getLpn();
            Object obj1 = (BBYTextView)b.findViewById(0x7f0c02c1);
            Object obj2;
            BBYTextView bbytextview;
            Object obj3;
            Object obj6;
            BBYTextView bbytextview1;
            if (obj != null && !((String) (obj)).isEmpty() && h)
            {
                if (j.getLpn().equals("null"))
                {
                    ((BBYTextView) (obj1)).setVisibility(8);
                } else
                {
                    ((BBYTextView) (obj1)).setVisibility(0);
                    ((BBYTextView) (obj1)).setText((new StringBuilder()).append("<span class='bold'>Open Item ID: </span>").append(((String) (obj))).toString());
                }
            }
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        obj4 = (BBYTextView)b.findViewById(0x7f0c02c5);
        obj5 = (BBYTextView)b.findViewById(0x7f0c028e);
        obj6 = (BBYTextView)b.findViewById(0x7f0c02bc);
        bbytextview1 = (BBYTextView)b.findViewById(0x7f0c02c2);
        obj3 = (BBYTextView)b.findViewById(0x7f0c02be);
        obj2 = (BBYTextView)b.findViewById(0x7f0c02bf);
        obj1 = (BBYTextView)b.findViewById(0x7f0c02c3);
        obj = (BBYTextView)b.findViewById(0x7f0c02c7);
        bbytextview = (BBYTextView)b.findViewById(0x7f0c02c0);
        if (a.getSkuId() != null && !a.getSkuId().isEmpty())
        {
            ((BBYTextView)b.findViewById(0x7f0c02bd)).setText((new StringBuilder()).append("<span class='bold'>SKU: </span>").append(a.getSkuId()).toString());
        }
        if (a.getManufacturerId() != null && a.getManufacturerId().getModelNumber() != null && !a.getManufacturerId().getModelNumber().isEmpty())
        {
            ((BBYTextView) (obj6)).setVisibility(0);
            ((BBYTextView) (obj6)).setText((new StringBuilder()).append("<span class='bold'>Model: </span>").append(a.getManufacturerId().getModelNumber()).toString());
        }
        if (a.getProperties() != null && a.getProperties().getPrimaryArtist() != null && ((PrimaryArtist)a.getProperties().getPrimaryArtist().get(0)).getDisplayName() != null)
        {
            bbytextview1.setVisibility(0);
            bbytextview1.setText((new StringBuilder()).append("<span class='bold'>Artist: </span>").append(((PrimaryArtist)a.getProperties().getPrimaryArtist().get(0)).getDisplayName()).toString());
        }
        if (a.getEsrbRating() == null || a.getEsrbRating().getRating() == null) goto _L4; else goto _L3
_L3:
        ((BBYTextView) (obj4)).setVisibility(0);
        ((BBYTextView) (obj5)).setVisibility(0);
        obj6 = a.getEsrbRating().getRating();
        if (obj6 != null && !((String) (obj6)).isEmpty())
        {
            ((BBYTextView) (obj4)).setText("ESRB Rating:");
            ((BBYTextView) (obj5)).setText(((String) (obj6)));
            ((BBYTextView) (obj5)).setOnClickListener(new android.view.View.OnClickListener() {

                final PDPSkuAndTitleFragment a;

                public void onClick(View view)
                {
                    PDPSkuAndTitleFragment.a(a, a.d.getResources().getString(0x7f080190));
                    a.a(PDPSkuAndTitleFragment.c(a));
                }

            
            {
                a = PDPSkuAndTitleFragment.this;
                super();
            }
            });
        }
_L6:
        if (a.getProperties() != null)
        {
            obj4 = a.getProperties().getFileSize();
            if (obj4 != null && !((String) (obj4)).isEmpty())
            {
                ((BBYTextView) (obj3)).setVisibility(0);
                ((BBYTextView) (obj3)).setText((new StringBuilder()).append("<span class='bold'>Filesize: </span>").append(((String) (obj4))).toString());
            }
        }
        if (a.getBrand() != null)
        {
            obj4 = a.getBrand().getPublisher();
            obj5 = a.getBrand().getVendor();
            obj3 = a.getBrand().getLabel();
            if (obj4 != null && !((String) (obj4)).isEmpty())
            {
                ((BBYTextView) (obj2)).setVisibility(0);
                ((BBYTextView) (obj2)).setText((new StringBuilder()).append("<span class='bold'>Publisher: </span>").append(((String) (obj4))).toString());
            }
            if (obj5 != null && !((String) (obj5)).isEmpty())
            {
                bbytextview.setVisibility(0);
                bbytextview.setText((new StringBuilder()).append("<span class='bold'>Vendor: </span>").append(((String) (obj5))).toString());
            }
            if (obj3 != null && !((String) (obj3)).isEmpty())
            {
                obj2 = (BBYTextView)b.findViewById(0x7f0c02c4);
                ((BBYTextView) (obj2)).setVisibility(0);
                ((BBYTextView) (obj2)).setText((new StringBuilder()).append("<span class='bold'>Label: </span>").append(((String) (obj3))).toString());
            }
        }
        if (a.getDates() != null && a.getDates().getStreetDate() != null)
        {
            obj2 = a.getDates().getStreetDate();
            if (obj2 != null)
            {
                obj2 = ((String) (obj2)).toString();
                if (!((String) (obj2)).isEmpty() && obj2 != null)
                {
                    ((BBYTextView) (obj1)).setText((new StringBuilder()).append("<span class='bold'>Release: </span>").append(((String) (obj2))).toString());
                    ((BBYTextView) (obj1)).setVisibility(0);
                }
            }
        }
        if (a.getAttributes() != null && a.getAttributes().isMarketplace())
        {
            obj1 = a.getPriceBlock();
            if (obj1 != null)
            {
                obj1 = ((PriceBlock) (obj1)).getSellerInfo();
                if (obj1 != null && ((SellerInfo) (obj1)).getSeller() != null && ((SellerInfo) (obj1)).getSellerUrl() != null)
                {
                    ((BBYTextView)b.findViewById(0x7f0c02c6)).setVisibility(0);
                    ((BBYTextView) (obj)).setVisibility(0);
                    ((BBYTextView) (obj)).setText(((SellerInfo) (obj1)).getSeller());
                    ((BBYTextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(((SellerInfo) (obj1))) {

                        final SellerInfo a;
                        final PDPSkuAndTitleFragment b;

                        public void onClick(View view)
                        {
                            PDPSkuAndTitleFragment.a(b, (new StringBuilder()).append("http://www.bestbuy.com").append(a.getSellerUrl()).toString());
                            b.a(PDPSkuAndTitleFragment.c(b));
                        }

            
            {
                b = PDPSkuAndTitleFragment.this;
                a = sellerinfo;
                super();
            }
                    });
                }
            }
        }
_L2:
        return;
_L4:
        if (a.getAttributes() != null && a.getAttributes().isParentalAdvisory())
        {
            ((BBYTextView) (obj4)).setVisibility(0);
            ((BBYTextView) (obj5)).setVisibility(0);
            ((BBYTextView) (obj4)).setText("Rating:");
            ((BBYTextView) (obj5)).setText("Parental Advisory");
            ((BBYTextView) (obj5)).setOnClickListener(new android.view.View.OnClickListener() {

                final PDPSkuAndTitleFragment a;

                public void onClick(View view)
                {
                    PDPSkuAndTitleFragment.a(a, a.d.getResources().getString(0x7f0802a0));
                    a.a(PDPSkuAndTitleFragment.c(a));
                }

            
            {
                a = PDPSkuAndTitleFragment.this;
                super();
            }
            });
        } else
        if (a.getMovieRatings() != null && a.getMovieRatings().getRating() != null && !a.getMovieRatings().getRating().isEmpty())
        {
            ((BBYTextView) (obj4)).setVisibility(0);
            ((BBYTextView) (obj5)).setVisibility(0);
            ((BBYTextView) (obj4)).setText("Rating:");
            ((BBYTextView) (obj5)).setText(a.getMovieRatings().getRating());
            ((BBYTextView) (obj5)).setOnClickListener(new android.view.View.OnClickListener() {

                final PDPSkuAndTitleFragment a;

                public void onClick(View view)
                {
                    PDPSkuAndTitleFragment.a(a, (new StringBuilder()).append("http://www.bestbuy.com").append(PDPSkuAndTitleFragment.d(a).getMovieRatings().getLink().getUrl()).toString());
                    a.a(PDPSkuAndTitleFragment.c(a));
                }

            
            {
                a = PDPSkuAndTitleFragment.this;
                super();
            }
            });
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static String c(PDPSkuAndTitleFragment pdpskuandtitlefragment)
    {
        return pdpskuandtitlefragment.i;
    }

    static OverviewResponse d(PDPSkuAndTitleFragment pdpskuandtitlefragment)
    {
        return pdpskuandtitlefragment.a;
    }

    public void a(String s)
    {
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        android.support.v4.app.Fragment fragment = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        MdotWebFragment mdotwebfragment = new MdotWebFragment(true, true);
        Bundle bundle = new Bundle();
        bundle.putString(getResources().getString(0x7f080055), s);
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = layoutinflater.inflate(0x7f0300b1, viewgroup, false);
        c = (BBYTextView)b.findViewById(0x7f0c029a);
        if (a == null)
        {
            layoutinflater = getArguments();
            a = (OverviewResponse)layoutinflater.getSerializable("product");
            j = (DNMProduct)layoutinflater.getSerializable("dnmProduct");
            h = layoutinflater.getBoolean("isFromDNM");
        }
        if (a != null)
        {
            g = a.getNames().getShortName();
        }
        c.setText(g);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final PDPSkuAndTitleFragment a;

            public void onClick(View view)
            {
                view = PDPSkuAndTitleFragment.a(a).getLayout();
                if (view != null)
                {
                    int k = view.getLineCount();
                    if (k > 0 && view.getEllipsisCount(k - 1) > 0)
                    {
                        PDPSkuAndTitleFragment.a(a).setMaxLines(5);
                        PDPSkuAndTitleFragment.a(a).setEms(PDPSkuAndTitleFragment.b(a).length());
                    }
                }
            }

            
            {
                a = PDPSkuAndTitleFragment.this;
                super();
            }
        });
        b();
        return b;
    }

    public void onResume()
    {
        super.onResume();
    }
}
