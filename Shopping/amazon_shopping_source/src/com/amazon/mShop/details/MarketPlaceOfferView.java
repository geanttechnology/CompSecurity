// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.ui.BadgeView;
import com.amazon.mShop.util.BadgeUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.MerchantInfo;
import com.amazon.rio.j2me.client.services.mShop.OfferListing;

// Referenced classes of package com.amazon.mShop.details:
//            ItemViewUtils

public class MarketPlaceOfferView extends LinearLayout
{

    private View mAmazonLogo;
    private BadgeView mBadgeView;
    private BasicOfferListing mBasicOffer;
    private TextView mItemPrice;
    private TextView mItemShippingPrice;
    private TextView mOfferCondition;
    private TextView mOfferMerchantName;
    private TextView mOfferMerchantPercentPositive;
    private TextView mOfferMerchantRatingCount;
    private final Resources mResources = getResources();

    public MarketPlaceOfferView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mItemPrice = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_price);
        mBadgeView = (BadgeView)findViewById(com.amazon.mShop.android.lib.R.id.item_badge);
        mItemShippingPrice = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_shipping_price);
        mOfferCondition = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.offer_condition);
        mOfferMerchantName = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.offer_merchant_name);
        mOfferMerchantPercentPositive = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.offer_merchant_percent_positive);
        mOfferMerchantRatingCount = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.offer_merchant_rating_count);
    }

    public void update(ProductController productcontroller, OfferListing offerlisting)
    {
        mBasicOffer = offerlisting.getBasicOffer();
        ExtraOfferListing extraofferlisting = offerlisting.getExtraOffer();
        productcontroller = mBasicOffer.getMerchantInfo();
        ItemViewUtils.updatePriceForMarketplace(mItemPrice, mBasicOffer);
        ItemViewUtils.updateShippingPrice((AmazonActivity)getContext(), mItemShippingPrice, mBasicOffer, extraofferlisting, false);
        mOfferCondition.setText(mBasicOffer.getCondition());
        String s;
        boolean flag;
        if (mBadgeView != null)
        {
            if (BadgeUtils.isContainedBadge(mBasicOffer))
            {
                mBadgeView.update(mBasicOffer.getBadgeInfo().getBadge());
            } else
            {
                mBadgeView.setVisibility(8);
            }
        }
        if (productcontroller.getIsAmazon() != null)
        {
            flag = productcontroller.getIsAmazon().booleanValue();
        } else
        {
            flag = false;
        }
        productcontroller = productcontroller.getMerchantName();
        if (!Util.isEmpty(productcontroller))
        {
            if (flag)
            {
                mOfferMerchantName.setVisibility(8);
                Object obj;
                Integer integer;
                if (mAmazonLogo == null)
                {
                    mAmazonLogo = ((ViewStub)findViewById(com.amazon.mShop.android.lib.R.id.amazon_logo_stub)).inflate();
                } else
                {
                    mAmazonLogo.setVisibility(0);
                }
            } else
            {
                mOfferMerchantName.setText(productcontroller);
                mOfferMerchantName.setVisibility(0);
                if (mAmazonLogo != null)
                {
                    mAmazonLogo.setVisibility(8);
                }
            }
        } else
        {
            mOfferMerchantName.setVisibility(8);
            if (mAmazonLogo != null)
            {
                mAmazonLogo.setVisibility(8);
            }
        }
        obj = null;
        offerlisting = null;
        integer = null;
        s = obj;
        if (!flag)
        {
            offerlisting = extraofferlisting.getMerchantRatingPercentPositive();
            productcontroller = integer;
            if (offerlisting != null)
            {
                productcontroller = integer;
                if (offerlisting.intValue() > 0)
                {
                    productcontroller = mResources.getString(com.amazon.mShop.android.lib.R.string.mp_percent_positive, new Object[] {
                        offerlisting
                    });
                }
            }
            offerlisting = productcontroller;
            s = obj;
            if (mOfferMerchantRatingCount != null)
            {
                integer = extraofferlisting.getMerchantRatingCount();
                offerlisting = productcontroller;
                s = obj;
                if (integer != null)
                {
                    offerlisting = productcontroller;
                    s = obj;
                    if (integer.intValue() > 0)
                    {
                        s = mResources.getString(com.amazon.mShop.android.lib.R.string.mp_count_ratings, new Object[] {
                            integer
                        });
                        offerlisting = productcontroller;
                    }
                }
            }
        }
        if (Util.isEmpty(offerlisting))
        {
            mOfferMerchantPercentPositive.setVisibility(8);
        } else
        {
            mOfferMerchantPercentPositive.setText(offerlisting);
            mOfferMerchantPercentPositive.setVisibility(0);
        }
        if (Util.isEmpty(s))
        {
            if (mOfferMerchantRatingCount != null)
            {
                mOfferMerchantRatingCount.setVisibility(8);
            }
            return;
        } else
        {
            mOfferMerchantRatingCount.setText(s);
            mOfferMerchantRatingCount.setVisibility(0);
            return;
        }
    }
}
