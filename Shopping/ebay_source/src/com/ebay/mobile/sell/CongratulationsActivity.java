// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.sell:
//            FormatPriceSpokeFragment

public class CongratulationsActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_GUARANTEE_SELECTED = "extraGuaranteeSelected";
    public static final String EXTRA_LISTING_DRAFT = "extraListingDraft";
    public static final String EXTRA_PUBLISHED_DRAFT = "extraPublishedDraft";
    private static final String STATE_GUARANTEE_SELECTED = "guaranteeSelected";
    private static final String STATE_LISTING_DRAFT = "listingDraft";
    private static final String STATE_PUBLISHED = "publishedDraft";
    private boolean guaranteeSelected;
    private ListingDraft listingDraft;
    private ListingDraft publishedDraft;

    public CongratulationsActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755947: 
            onBackPressed();
            return;

        case 2131756595: 
            view = new MyEbayListItem();
            break;
        }
        view.id = Long.parseLong(publishedDraft.itemId);
        if (listingDraft != null && listingDraft.startDateEnabled != null && listingDraft.startDateEnabled.getBooleanValue())
        {
            view.startPrice = new ItemCurrency(listingDraft.getCurrencyCode(), listingDraft.startPrice.getStringValue());
            ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Scheduled, null, null);
        } else
        {
            ItemViewActivity.StartActivity(this, view, com.ebay.common.ConstantsCommon.ItemKind.Selling, null, null);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        View view;
        View view1;
        View view2;
        int i;
        super.onCreate(bundle);
        setContentView(0x7f0301fb);
        ((TextView)findViewById(0x7f1003a5)).setText(getTitle());
        findViewById(0x7f1003ab).setOnClickListener(this);
        findViewById(0x7f100633).setOnClickListener(this);
        TextView textview1 = (TextView)findViewById(0x7f10062e);
        view = findViewById(0x7f10062f);
        view1 = findViewById(0x7f100630);
        view2 = findViewById(0x7f100631);
        TextView textview = (TextView)findViewById(0x7f100632);
        boolean flag;
        if (bundle == null)
        {
            MyApp.getPrefs().setUserPref(true, "rateAppListAction");
            bundle = getIntent();
            listingDraft = (ListingDraft)bundle.getParcelableExtra("extraListingDraft");
            publishedDraft = (ListingDraft)bundle.getParcelableExtra("extraPublishedDraft");
            guaranteeSelected = bundle.getBooleanExtra("extraGuaranteeSelected", false);
        } else
        {
            listingDraft = (ListingDraft)bundle.getParcelable("listingDraft");
            publishedDraft = (ListingDraft)bundle.getParcelable("publishedDraft");
            guaranteeSelected = bundle.getBoolean("guaranteeSelected");
        }
        flag = DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.B.guarantee);
        if (flag && guaranteeSelected && publishedDraft.guaranteeProvided != null && publishedDraft.guaranteeProvided.getBooleanValue() && publishedDraft.guaranteeSalePrice != null && publishedDraft.guaranteeSalePrice.getStringValue() != null)
        {
            textview1.setText(getString(0x7f070cda, new Object[] {
                EbayCurrencyUtil.formatDisplay(listingDraft.getCurrencyCode(), publishedDraft.guaranteeSalePrice.getDoubleValue(), 0)
            }));
        } else
        if (listingDraft != null && listingDraft.startDateEnabled != null && listingDraft.startDate != null && listingDraft.startDateEnabled.getBooleanValue())
        {
            bundle = listingDraft.startDate.getDateValue();
            java.text.DateFormat dateformat = DateFormat.getTimeFormat(this);
            textview1.setText(getString(0x7f070cdb, new Object[] {
                DateUtils.formatDateTime(this, bundle.getTime(), 0x10018), dateformat.format(bundle)
            }));
        } else
        {
            textview1.setText(0x7f070cd9);
        }
        if (!flag || !guaranteeSelected || publishedDraft.getGuaranteeTerms() == null) goto _L2; else goto _L1
_L1:
        view.setVisibility(0);
        view2.setVisibility(0);
        if (publishedDraft.guaranteeProvided == null || !publishedDraft.guaranteeProvided.getBooleanValue())
        {
            view1.setVisibility(0);
            view2.setVisibility(0);
        } else
        {
            view1.setVisibility(8);
            view2.setVisibility(8);
        }
        bundle = EbaySite.getInstanceFromId(listingDraft.siteId);
        i = 0x7f0707b7;
        if (!bundle.equals(EbaySite.US)) goto _L4; else goto _L3
_L3:
        i = 0x7f0707b8;
_L5:
        bundle = new SpannableStringBuilder();
        FormatPriceSpokeFragment.appendGuaranteeTermsLink(bundle, this, i, publishedDraft.getGuaranteeTerms());
        textview.setText(bundle);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        return;
_L4:
        if (bundle.equals(EbaySite.DE))
        {
            i = 0x7f0707b6;
        }
        if (true) goto _L5; else goto _L2
_L2:
        view.setVisibility(8);
        return;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("listingDraft", listingDraft);
        bundle.putParcelable("publishedDraft", publishedDraft);
        bundle.putBoolean("guaranteeSelected", guaranteeSelected);
    }
}
