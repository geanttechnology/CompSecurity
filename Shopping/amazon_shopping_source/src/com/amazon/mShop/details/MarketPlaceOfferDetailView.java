// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.item.BuyBoxController;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.BadgeUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.MerchantInfo;
import com.amazon.rio.j2me.client.services.mShop.OfferListing;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            ItemViewUtils, BuyBoxView

public class MarketPlaceOfferDetailView extends ScrollView
    implements DelayedInitView, TitleProvider
{

    private final AmazonActivity mAmazonActivity;
    private View mAmazonLogo;
    private boolean mInitialized;
    private TextView mItemPrice;
    private TextView mItemShippingPrice;
    private TextView mOfferCondition;
    private OfferListing mOfferListing;
    private TextView mOfferMerchantName;
    private TextView mOfferMerchantPercentPositive;
    private TextView mOfferMerchantRatingCount;
    private ProductController mProductController;
    private final Resources mResources = getResources();

    public MarketPlaceOfferDetailView(AmazonActivity amazonactivity, ProductController productcontroller, OfferListing offerlisting)
    {
        super(amazonactivity);
        mInitialized = false;
        mAmazonActivity = amazonactivity;
        mProductController = productcontroller;
        mOfferListing = offerlisting;
    }

    private List getAvailabilityMessages()
    {
        if (mOfferListing != null)
        {
            BasicOfferListing basicofferlisting = mOfferListing.getBasicOffer();
            if (basicofferlisting != null)
            {
                return basicofferlisting.getAvailabilityMessages();
            }
        }
        return null;
    }

    public static MarketPlaceOfferDetailView getMarketPlaceOfferDetailView(AmazonActivity amazonactivity, ProductController productcontroller, OfferListing offerlisting)
    {
        return new MarketPlaceOfferDetailView(amazonactivity, productcontroller, offerlisting);
    }

    private String getMerchantName()
    {
        if (mOfferListing != null)
        {
            Object obj = mOfferListing.getBasicOffer();
            if (obj != null)
            {
                obj = ((BasicOfferListing) (obj)).getMerchantInfo();
                if (obj != null)
                {
                    return ((MerchantInfo) (obj)).getMerchantName();
                }
            }
        }
        return null;
    }

    private boolean isAmazon()
    {
        if (mOfferListing != null)
        {
            Object obj = mOfferListing.getBasicOffer();
            if (obj != null)
            {
                obj = ((BasicOfferListing) (obj)).getMerchantInfo();
                if (obj != null)
                {
                    return ((MerchantInfo) (obj)).getIsAmazon().booleanValue();
                }
            }
        }
        return false;
    }

    private void updateAvailabilityBlock(ViewGroup viewgroup)
    {
        Object obj = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_availability);
        Object obj1 = getAvailabilityMessages();
        if (obj1 == null)
        {
            ((TextView) (obj)).setVisibility(8);
        } else
        {
            UIUtils.setHyperTexts(((TextView) (obj)), mAmazonActivity, ((List) (obj1)));
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setFocusable(false);
        }
        viewgroup = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_legal_information_link);
        obj = viewgroup.getResources().getString(com.amazon.mShop.android.lib.R.string.legal_info_text);
        obj1 = new SpannableString(((CharSequence) (obj)));
        ((SpannableString) (obj1)).setSpan(new ClickableSpan() {

            final MarketPlaceOfferDetailView this$0;

            public void onClick(View view)
            {
                String s = view.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.opl_review_order_legal_url_android);
                view = view.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.opl_review_order_legal_title);
                mAmazonActivity.pushView(new AmazonBrandedWebView(mAmazonActivity, s, view));
            }

            
            {
                this$0 = MarketPlaceOfferDetailView.this;
                super();
            }
        }, 0, ((String) (obj)).length(), 33);
        viewgroup.setText(((CharSequence) (obj1)));
        viewgroup.setMovementMethod(LinkMovementMethod.getInstance());
        if (isAmazon())
        {
            viewgroup.setVisibility(0);
            viewgroup.setFocusable(false);
            return;
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    private void updateImage(final ImageView imageView)
    {
        final byte thumbnail[] = mProductController.getImage();
        if (thumbnail == null)
        {
            String s = mProductController.getImageUrl();
            int i = mProductController.getMaxImageDimension();
            if (!Util.isEmpty(s))
            {
                (new BitmapFetcher(s, Integer.valueOf(i), Integer.valueOf(0), new com.amazon.mShop.net.HttpFetcher.Subscriber() {

                    final MarketPlaceOfferDetailView this$0;
                    final ImageView val$imageView;
                    final byte val$thumbnail[];

                    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                        ItemViewUtils.updateImage(thumbnail, imageView);
                    }

                    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                        bitmap = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params);
                        imageView.setImageDrawable(bitmap);
                    }

                    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
                    {
                        onHttpResponseReceived((Bitmap)obj, params);
                    }

            
            {
                this$0 = MarketPlaceOfferDetailView.this;
                imageView = imageview;
                thumbnail = abyte0;
                super();
            }
                })).fetch();
            }
            return;
        } else
        {
            ItemViewUtils.updateImage(thumbnail, imageView);
            return;
        }
    }

    private void updateMerchantBlock(ViewGroup viewgroup, BasicOfferListing basicofferlisting, ExtraOfferListing extraofferlisting)
    {
        if (basicofferlisting != null && extraofferlisting != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mOfferMerchantName = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_merchant_name);
        mOfferMerchantPercentPositive = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_merchant_percent_positive);
        mOfferMerchantRatingCount = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_merchant_rating_count);
        basicofferlisting = basicofferlisting.getMerchantInfo();
        if (basicofferlisting == null) goto _L4; else goto _L3
_L3:
        String s;
        Object obj;
        Object obj1;
        int i;
        boolean flag;
        if (basicofferlisting.getIsAmazon() != null)
        {
            flag = basicofferlisting.getIsAmazon().booleanValue();
        } else
        {
            flag = false;
        }
        basicofferlisting = basicofferlisting.getMerchantName();
        if (Util.isEmpty(basicofferlisting)) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            mOfferMerchantName.setVisibility(8);
            if (mAmazonLogo == null)
            {
                mAmazonLogo = ((ViewStub)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_amazon_logo_stub)).inflate();
            } else
            {
                mAmazonLogo.setVisibility(0);
            }
            i = mResources.getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding);
            mAmazonLogo.setPadding(i, i, i, i);
        } else
        {
            mOfferMerchantName.setText(basicofferlisting);
            mOfferMerchantName.setVisibility(0);
            if (mAmazonLogo != null)
            {
                mAmazonLogo.setVisibility(8);
            }
        }
_L7:
        obj = null;
        basicofferlisting = null;
        obj1 = null;
        s = obj;
        if (!flag)
        {
            basicofferlisting = extraofferlisting.getMerchantRatingPercentPositive();
            viewgroup = obj1;
            if (basicofferlisting != null)
            {
                viewgroup = obj1;
                if (basicofferlisting.intValue() > 0)
                {
                    viewgroup = mResources.getString(com.amazon.mShop.android.lib.R.string.mp_percent_positive, new Object[] {
                        basicofferlisting
                    });
                }
            }
            basicofferlisting = viewgroup;
            s = obj;
            if (mOfferMerchantRatingCount != null)
            {
                extraofferlisting = extraofferlisting.getMerchantRatingCount();
                basicofferlisting = viewgroup;
                s = obj;
                if (extraofferlisting != null)
                {
                    basicofferlisting = viewgroup;
                    s = obj;
                    if (extraofferlisting.intValue() > 0)
                    {
                        s = mResources.getString(com.amazon.mShop.android.lib.R.string.mp_count_ratings, new Object[] {
                            extraofferlisting
                        });
                        basicofferlisting = viewgroup;
                    }
                }
            }
        }
        if (Util.isEmpty(basicofferlisting))
        {
            mOfferMerchantPercentPositive.setVisibility(8);
        } else
        {
            mOfferMerchantPercentPositive.setText(basicofferlisting);
            mOfferMerchantPercentPositive.setVisibility(0);
        }
        if (Util.isEmpty(s))
        {
            if (mOfferMerchantRatingCount != null)
            {
                mOfferMerchantRatingCount.setVisibility(8);
                return;
            }
        } else
        {
            mOfferMerchantRatingCount.setText(s);
            mOfferMerchantRatingCount.setVisibility(0);
            return;
        }
_L4:
        if (true) goto _L1; else goto _L6
_L6:
        mOfferMerchantName.setVisibility(8);
        if (mAmazonLogo != null)
        {
            mAmazonLogo.setVisibility(8);
        }
          goto _L7
    }

    private void updateProductBlock(ViewGroup viewgroup, BasicOfferListing basicofferlisting, ExtraOfferListing extraofferlisting)
    {
        if (basicofferlisting != null && extraofferlisting != null)
        {
            mItemPrice = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_item_price);
            mItemShippingPrice = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_item_shipping_price);
            mOfferCondition = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_offer_condition);
            ItemViewUtils.updatePriceForMarketplace(mItemPrice, basicofferlisting);
            ItemViewUtils.updateShippingPrice(mAmazonActivity, mItemShippingPrice, basicofferlisting, extraofferlisting, true);
            mOfferCondition.setText(basicofferlisting.getCondition());
            basicofferlisting = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.market_details_full_tax_include_text);
            String s = viewgroup.getResources().getString(com.amazon.mShop.android.lib.R.string.dp_all_prices_include_tax);
            if (!Util.isEmpty(s))
            {
                basicofferlisting.setText(s);
                basicofferlisting.setVisibility(0);
            } else
            {
                basicofferlisting.setVisibility(8);
            }
            s = extraofferlisting.getComments();
            if (!Util.isEmpty(s))
            {
                basicofferlisting = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.offer_comments);
                s = mResources.getString(com.amazon.mShop.android.lib.R.string.mp_comments, new Object[] {
                    s
                });
                basicofferlisting.setVisibility(0);
                basicofferlisting.setText(s);
            }
            basicofferlisting = extraofferlisting.getMerchantRatingMessage();
            if (!Util.isEmpty(basicofferlisting))
            {
                viewgroup = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.offer_merchant_rating_message);
                viewgroup.setVisibility(0);
                viewgroup.setText(basicofferlisting);
                return;
            }
        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        String s = getMerchantName();
        if (!Util.isEmpty(s))
        {
            return s;
        } else
        {
            return mResources.getString(com.amazon.mShop.android.lib.R.string.mp_new_and_used_offers);
        }
    }

    public void onPushViewCompleted()
    {
        if (!mInitialized)
        {
            ViewGroup viewgroup = (ViewGroup)inflate(getContext(), com.amazon.mShop.android.lib.R.layout.marketplace_offer_details, null);
            Object obj = (ViewGroup)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.marketplace_offer_details_header);
            ItemViewUtils.updateTitleBlock(((View) (obj)), mProductController);
            updateImage((ImageView)((ViewGroup) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.item_row_image));
            obj = (BuyBoxView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.buy_box);
            ((BuyBoxView) (obj)).setBuyBoxController(new BuyBoxController(mProductController, mOfferListing));
            ((BuyBoxView) (obj)).update();
            obj = mOfferListing.getBasicOffer();
            ExtraOfferListing extraofferlisting = mOfferListing.getExtraOffer();
            updateProductBlock(viewgroup, ((BasicOfferListing) (obj)), extraofferlisting);
            updateMerchantBlock(viewgroup, ((BasicOfferListing) (obj)), extraofferlisting);
            updateAvailabilityBlock(viewgroup);
            BadgeUtils.updateAddOnMessageBlocks(viewgroup, ((BasicOfferListing) (obj)), mAmazonActivity);
            addView(viewgroup);
            mInitialized = true;
        }
    }

}
