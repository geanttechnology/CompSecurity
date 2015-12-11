// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import android.view.View;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.item.ProductSubscriber;
import com.amazon.mShop.details.MarketPlaceView;
import com.amazon.mShop.details.ProductSubscriberBase;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;

public class OfferListingView extends LinearLayout
    implements TitleProvider
{

    private AmazonActivity mAmazonActivity;
    private final View mLoadingSpinner;
    private MarketPlaceView mMarketPlaceView;
    private final ProductController mProductController;
    private final ProductSubscriber mProductSubscriber = getProductSubscriber();

    public OfferListingView(AmazonActivity amazonactivity, ProductController productcontroller)
    {
        super(amazonactivity);
        mAmazonActivity = amazonactivity;
        mLoadingSpinner = View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.progress_bar, null);
        mProductController = productcontroller;
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        addView(mLoadingSpinner);
    }

    private void error(Exception exception, ServiceCall servicecall)
    {
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final OfferListingView this$0;

            public void onActionButtonClick(int i)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        mProductController.replayProductRequest();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = OfferListingView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(mAmazonActivity, servicecall, this, exception);
    }

    private ProductSubscriber getProductSubscriber()
    {
        return new ProductSubscriberBase() {

            final OfferListingView this$0;

            public void onError(Exception exception, ServiceCall servicecall)
            {
                error(exception, servicecall);
            }

            public void onProductUpdated()
            {
                update();
            }

            
            {
                this$0 = OfferListingView.this;
                super();
            }
        };
    }

    public static void show(AmazonActivity amazonactivity, String s, String s1, String s2)
    {
        Object obj = amazonactivity.getClickStreamOrigin();
        if (Util.isEmpty(((String) (obj))))
        {
            obj = ClickStreamTag.ORIGIN_DEFAULT;
        } else
        {
            obj = new ClickStreamTag(((String) (obj)));
        }
        s = new ProductController(s, ((ClickStreamTag) (obj)));
        s.setIsSelectedChild(true);
        if (WebUtils.isDefined(s1))
        {
            s.setListId(s1);
        }
        if (WebUtils.isDefined(s2))
        {
            s.setListItemId(s2);
        }
        amazonactivity.pushView(new OfferListingView(amazonactivity, s));
    }

    private void update()
    {
        com.amazon.rio.j2me.client.services.mShop.ConditionalOffersSummary aconditionalofferssummary[] = mProductController.getConditionalOffersSummaryList();
        if (aconditionalofferssummary != null && aconditionalofferssummary.length > 0)
        {
            mMarketPlaceView = new MarketPlaceView(mAmazonActivity, mProductController);
            addView(mMarketPlaceView, new android.widget.LinearLayout.LayoutParams(-1, -1));
            mLoadingSpinner.setVisibility(8);
            removeView(mLoadingSpinner);
            mMarketPlaceView.setVisibility(0);
            mAmazonActivity.updateTitle(this);
            mProductController.removeSubscriber(mProductSubscriber);
        }
    }

    public CharSequence getTitle()
    {
        if (mMarketPlaceView != null)
        {
            return mMarketPlaceView.getTitle();
        } else
        {
            return "";
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mProductController.addSubscriber(mProductSubscriber);
        mProductController.tryStartRequest();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mProductController.removeSubscriber(mProductSubscriber);
    }



}
