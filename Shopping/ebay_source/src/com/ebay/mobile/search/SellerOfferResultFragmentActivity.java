// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.model.search.SellerOffer;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.common.net.api.search.SellerOfferParameters;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.shell.app.BaseActivity;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

public class SellerOfferResultFragmentActivity extends SearchResultFragmentActivity
    implements android.view.View.OnClickListener
{

    private static final String OFFER_ID = "OFFER_ID";
    private static final String OFFER_TYPE = "OFFER_TYPE";
    private View info;
    private String legalTextMessage;
    private View sellerOfferLayout;
    private TextView sellerOfferSubTitle;
    private TextView sellerOfferTitle;
    private SourceIdentification sid;
    private String trackOfferId;
    private String trackOfferType;

    public SellerOfferResultFragmentActivity()
    {
    }

    public static void startActivity(BaseActivity baseactivity, String s, String s1, String s2, String s3, SourceIdentification sourceidentification)
    {
        if (TextUtils.isEmpty(s2) || TextUtils.isEmpty(s1))
        {
            return;
        }
        SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(baseactivity, null);
        searchparameters.sellerOffer = new SellerOfferParameters(s1, s2, s, s3);
        s = new Intent(baseactivity, com/ebay/mobile/search/SellerOfferResultFragmentActivity);
        if (sourceidentification != null)
        {
            s.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        }
        s.putExtra("search_param", searchparameters);
        s.putExtra("OFFER_TYPE", s1);
        s.putExtra("OFFER_ID", s2);
        s.setFlags(0x24000000);
        baseactivity.startActivity(s);
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f100603)
        {
            (new TrackingData("SOPInfo", TrackingType.EVENT)).send(this);
            (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(getString(0x7f07057b)).setMessage(legalTextMessage).setPositiveButton(0x104000a, null).show();
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        sellerOfferLayout = findViewById(0x7f100602);
        sellerOfferTitle = (TextView)findViewById(0x7f100604);
        sellerOfferSubTitle = (TextView)findViewById(0x7f100605);
        info = findViewById(0x7f100603);
        info.setOnClickListener(this);
        bundle = getIntent();
        trackOfferType = bundle.getStringExtra("OFFER_TYPE");
        trackOfferId = bundle.getStringExtra("OFFER_ID");
        sid = (SourceIdentification)bundle.getParcelableExtra("com.ebay.mobile.analytics.sid");
    }

    protected boolean onNewSearchParametersDelivered(SearchParameters searchparameters)
    {
        SellerOfferParameters sellerofferparameters = searchParameters.sellerOffer;
        searchparameters = searchparameters.sellerOffer;
        return !TextUtils.equals(sellerofferparameters.offerId, ((SellerOfferParameters) (searchparameters)).offerId);
    }

    public void onSearchComplete(SearchResult searchresult)
    {
        super.onSearchComplete(searchresult);
        searchresult = searchresult.sellerOffer;
        if (searchresult == null)
        {
            finish();
            return;
        }
        sellerOfferLayout.setVisibility(0);
        sellerOfferTitle.setText(((SellerOffer) (searchresult)).title);
        if (TextUtils.isEmpty(((SellerOffer) (searchresult)).subTitle))
        {
            sellerOfferSubTitle.setVisibility(8);
        } else
        {
            sellerOfferSubTitle.setText(((SellerOffer) (searchresult)).subTitle);
        }
        legalTextMessage = ((SellerOffer) (searchresult)).legalText;
        if (!TextUtils.isEmpty(legalTextMessage))
        {
            findViewById(0x7f100603).setVisibility(0);
            legalTextMessage = Html.fromHtml(legalTextMessage).toString();
            return;
        } else
        {
            findViewById(0x7f100603).setVisibility(4);
            return;
        }
    }

    public void onSearchStarted(SearchParameters searchparameters)
    {
        super.onSearchStarted(searchparameters);
        sellerOfferLayout.setVisibility(4);
    }

    protected void sendPageImpression()
    {
        boolean flag = DeviceInfoUtil.isPortrait(this);
        TrackingData trackingdata = new TrackingData("SellerOfferPage", TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("offer_type", trackOfferType);
        trackingdata.addKeyValuePair("offer_id", trackOfferId);
        String s;
        if (flag)
        {
            s = "p";
        } else
        {
            s = "l";
        }
        trackingdata.addKeyValuePair("ort", s);
        trackingdata.send(this);
    }
}
