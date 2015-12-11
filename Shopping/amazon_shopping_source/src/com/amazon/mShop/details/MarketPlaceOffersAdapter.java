// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.PagedListingAdapter;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.marketplace.OfferListingBrowser;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ConditionalOffersSummary;
import com.amazon.rio.j2me.client.services.mShop.OfferListing;
import com.amazon.rio.j2me.client.services.mShop.OffersSummary;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceOfferView, MarketPlaceOfferDetailView

public class MarketPlaceOffersAdapter extends PagedListingAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    private final ViewGroup footer;
    private final ProductController productController;

    private MarketPlaceOffersAdapter(AmazonActivity amazonactivity, ProductController productcontroller, ListView listview, String s, int i)
    {
        super(amazonactivity);
        productController = productcontroller;
        productcontroller = new OfferListingBrowser(8, 6, productcontroller.getAsin(), productcontroller.getRequestId());
        productcontroller.setConditionType(s);
        setBrowser(productcontroller);
        productcontroller.startFirstPageRequest(i, null);
        footer = (ViewGroup)View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.loading_progress_footer, null);
        listview.addFooterView(footer, null, false);
        listview.setOnItemClickListener(this);
        listview.setAdapter(this);
    }

    public static View getMarketPlaceOffersView(AmazonActivity amazonactivity, ProductController productcontroller, String s)
    {
        Object obj = productcontroller.getConditionalOffersSummary(s);
        s = ((ConditionalOffersSummary) (obj)).getSummary();
        obj = ((ConditionalOffersSummary) (obj)).getConditionType();
        View view = View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.marketplace_offers_list, null);
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.offers_before_price)).setText(amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.mp_offers_from_before_price, new Object[] {
            Integer.valueOf(s.getCount())
        }));
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.offers_price)).setText(UIUtils.convertUnsupportedCharacter(amazonactivity, s.getLowestPrice(), com.amazon.mShop.util.UIUtils.CharacterColor.RED));
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.offers_after_price)).setText(amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.mp_offers_from_after_price, new Object[] {
            Integer.valueOf(s.getCount())
        }));
        new MarketPlaceOffersAdapter(amazonactivity, productcontroller, (ListView)view.findViewById(0x102000a), ((String) (obj)), s.getCount());
        return view;
    }

    private void setFooterVisibility(int i)
    {
        for (int j = 0; j < footer.getChildCount(); j++)
        {
            footer.getChildAt(j).setVisibility(i);
        }

    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        browser.setCurrentIndex(i);
        viewgroup = view;
        if (!(view instanceof MarketPlaceOfferView))
        {
            viewgroup = View.inflate(getContext(), com.amazon.mShop.android.lib.R.layout.marketplace_offer, null);
        }
        view = (OfferListing)browser.getCurrentObject();
        ((MarketPlaceOfferView)viewgroup).update(productController, view);
        return viewgroup;
    }

    public void onCancelled()
    {
        super.onCancelled();
        setFooterVisibility(8);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        super.onError(exception, servicecall);
        setFooterVisibility(8);
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final MarketPlaceOffersAdapter this$0;

            public void onActionButtonClick(int i)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() );
            }

            
            {
                this$0 = MarketPlaceOffersAdapter.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError((AmazonActivity)(AmazonActivity)getContext(), servicecall, ((AmazonActivity)getContext()).getCurrentView(), exception);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < 0 || i >= browser.getReceivedCount())
        {
            return;
        } else
        {
            browser.setCurrentIndex(i);
            adapterview = (OfferListing)browser.getCurrentObject();
            view = (AmazonActivity)getContext();
            RefMarkerObserver.logRefMarker("dp_olp_3p");
            view.pushView(MarketPlaceOfferDetailView.getMarketPlaceOfferDetailView(view, productController, adapterview));
            return;
        }
    }

    public void onPageComplete()
    {
        onPageComplete();
        if (browser.getAvailableCount() <= browser.getReceivedCount())
        {
            setFooterVisibility(8);
        }
    }


}
