// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.cart.AddToCartAction;
import com.amazon.mShop.control.item.BuyBoxController;
import com.amazon.mShop.control.item.BuyButtonController;
import com.amazon.mShop.control.item.BuyButtonType;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.item.Variations;
import com.amazon.mShop.opl.BuyNowAction;
import com.amazon.mShop.sns.SnsAction;
import com.amazon.mShop.util.MShopUiOOMHandler;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.wishlist.AddToWishlistAction;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceAction, BuyButtonView, FriendAppAction

public class BuyBoxView extends LinearLayout
{

    private android.view.View.OnClickListener mAddToCartAction;
    private android.view.View.OnClickListener mAddToWishlistAction;
    protected BuyBoxController mBuyBoxController;
    private android.view.View.OnClickListener mBuyNowAction;
    private FriendAppAction mFriendAppAction;
    private MarketPlaceAction mMarketPlaceAction;
    private SnsAction mSnsAction;
    TextView mTextViewAboveBuyButtons;
    TextView mTextViewAboveVariationFilters;

    public BuyBoxView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAddToCartAction = new AddToCartAction();
        mAddToWishlistAction = new AddToWishlistAction();
        mBuyNowAction = new BuyNowAction();
    }

    private MarketPlaceAction getMarketplaceAction()
    {
        if (mMarketPlaceAction == null)
        {
            mMarketPlaceAction = new MarketPlaceAction((AmazonActivity)getContext(), mBuyBoxController.getProductController());
        }
        return mMarketPlaceAction;
    }

    public static String getPrimeCountdownString(Integer integer, Resources resources)
    {
        int j = integer.intValue();
        int i = j / 60;
        j -= i * 60;
        if (i != 0)
        {
            if (j != 0)
            {
                return resources.getString(com.amazon.mShop.android.lib.R.string.buy_box_order_within_hr_min_for, new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j)
                });
            } else
            {
                return resources.getString(com.amazon.mShop.android.lib.R.string.buy_box_order_within_hr_for, new Object[] {
                    Integer.valueOf(i)
                });
            }
        } else
        {
            return resources.getString(com.amazon.mShop.android.lib.R.string.buy_box_order_within_min_for, new Object[] {
                Integer.valueOf(j)
            });
        }
    }

    private void removeAllDisabledButtons(LinearLayout linearlayout)
    {
        for (int i = linearlayout.getChildCount() - 1; i >= 0; i--)
        {
            View view = linearlayout.getChildAt(i);
            if ((view instanceof BuyButtonView) && !view.isEnabled())
            {
                linearlayout.removeView(view);
            }
        }

    }

    private void setUpStatusMessage()
    {
        Object obj = "";
        ProductController productcontroller = getBuyBoxController().getProductController();
        Variations variations = productcontroller.getVariations();
        if (productcontroller.mustSelectVariationChild())
        {
            if (variations != null)
            {
                obj = variations.getDimensionLabels();
                obj = getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_to_buy_select, new Object[] {
                    Util.join(((String []) (obj)), getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_to_buy_select_separator))
                });
            }
        } else
        if (!Util.isEmpty(getBuyBoxController().getPrimeOneClickShippingOffersNote()))
        {
            String s = getBuyBoxController().getPrimeOneClickShippingOffersNote();
            obj = s;
            if (variations != null)
            {
                obj = s;
                if (!Util.isEmpty(s))
                {
                    mTextViewAboveVariationFilters.setVisibility(8);
                    mTextViewAboveBuyButtons.setVisibility(0);
                    mTextViewAboveBuyButtons.setText(s);
                    return;
                }
            }
        } else
        {
            Object obj1 = getBuyBoxController().getPrimeShippingOffersRemainingMinutes();
            if (obj1 != null)
            {
                obj1 = getPrimeCountdownString(((Integer) (obj1)), getResources());
                obj = obj1;
                if (variations != null)
                {
                    obj = obj1;
                    if (!Util.isEmpty(((String) (obj1))))
                    {
                        mTextViewAboveVariationFilters.setVisibility(8);
                        mTextViewAboveBuyButtons.setVisibility(0);
                        mTextViewAboveBuyButtons.setText(((CharSequence) (obj1)));
                        return;
                    }
                }
            }
        }
        if (Util.isEmpty(((String) (obj))))
        {
            mTextViewAboveVariationFilters.setVisibility(8);
            mTextViewAboveBuyButtons.setVisibility(8);
            return;
        } else
        {
            mTextViewAboveVariationFilters.setVisibility(0);
            mTextViewAboveVariationFilters.setText(((CharSequence) (obj)));
            mTextViewAboveBuyButtons.setVisibility(8);
            return;
        }
    }

    private void updateBuyNowButtonStatus(BuyButtonView buybuttonview)
    {
label0:
        {
            if (buybuttonview != null)
            {
                if (mBuyBoxController == null || !ProductController.isEligibleForAddOnItem(mBuyBoxController.getBasicOfferListing()))
                {
                    break label0;
                }
                buybuttonview.setVisibility(8);
            }
            return;
        }
        buybuttonview.setVisibility(0);
    }

    public BuyBoxController getBuyBoxController()
    {
        return mBuyBoxController;
    }

    public FriendAppAction getFriendAppAction()
    {
        if (mFriendAppAction == null)
        {
            mFriendAppAction = new FriendAppAction(getContext(), mBuyBoxController.getProductController());
        }
        return mFriendAppAction;
    }

    public SnsAction getSnsAction()
    {
        if (mSnsAction == null)
        {
            mSnsAction = new SnsAction(getContext(), mBuyBoxController.getProductController());
        }
        return mSnsAction;
    }

    public void setButtonsVisibility(int i)
    {
        findViewById(com.amazon.mShop.android.lib.R.id.buy_box_buy_buttons_container).setVisibility(i);
        findViewById(com.amazon.mShop.android.lib.R.id.buy_box_add_buttons_container).setVisibility(i);
    }

    public void setBuyBoxController(BuyBoxController buyboxcontroller)
    {
        mBuyBoxController = buyboxcontroller;
    }

    protected void setUpLoadingIndicator(boolean flag)
    {
        View view1 = findViewById(com.amazon.mShop.android.lib.R.id.loading_indicator);
        if (mBuyBoxController.isWaitingForPrime1ClickShippingOffers() || flag)
        {
            View view = view1;
            if (view1 == null)
            {
                view = ((ViewStub)findViewById(com.amazon.mShop.android.lib.R.id.loading_indicator_stub)).inflate();
            }
            view.setVisibility(0);
        } else
        if (view1 != null)
        {
            view1.setVisibility(8);
            return;
        }
    }

    public void update()
    {
        update(false);
    }

    public void update(final boolean isLoading)
    {
        (new MShopUiOOMHandler((Activity)getContext(), new com.amazon.mShop.util.MShopUiOOMHandler.UiRunnable(new Runnable() {

            final BuyBoxView this$0;
            final boolean val$isLoading;

            public void run()
            {
                updateButtons(isLoading);
                updateStatus(isLoading);
            }

            
            {
                this$0 = BuyBoxView.this;
                isLoading = flag;
                super();
            }
        }, true))).execute();
    }

    protected void updateButtons(LinearLayout linearlayout, BuyButtonController abuybuttoncontroller[])
    {
        if (linearlayout != null && abuybuttoncontroller != null)
        {
            removeAllDisabledButtons(linearlayout);
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < linearlayout.getChildCount(); i++)
            {
                View view = linearlayout.getChildAt(i);
                if (view instanceof BuyButtonView)
                {
                    arraylist.add((BuyButtonView)view);
                }
            }

            for (; arraylist.size() > abuybuttoncontroller.length; arraylist.remove(arraylist.size() - 1))
            {
                linearlayout.removeView((View)arraylist.get(arraylist.size() - 1));
            }

            if (arraylist.size() < abuybuttoncontroller.length)
            {
                LayoutInflater layoutinflater = LayoutInflater.from(getContext());
                for (; arraylist.size() < abuybuttoncontroller.length; arraylist.add((BuyButtonView)linearlayout.getChildAt(linearlayout.getChildCount() - 1)))
                {
                    layoutinflater.inflate(com.amazon.mShop.android.lib.R.layout.buy_button_view, linearlayout);
                }

            }
            int j = 0;
            while (j < abuybuttoncontroller.length) 
            {
                linearlayout = (BuyButtonView)arraylist.get(j);
                linearlayout.update(abuybuttoncontroller[j]);
                BuyButtonType buybuttontype = abuybuttoncontroller[j].getBuyButtonType();
                if (BuyButtonType.ADD_TO_CART == buybuttontype)
                {
                    linearlayout.setOnClickListener(mAddToCartAction);
                } else
                if (BuyButtonType.ADD_TO_WISH_LIST == buybuttontype)
                {
                    linearlayout.setOnClickListener(mAddToWishlistAction);
                } else
                if (BuyButtonType.SEE_MORE_BUYING_OPTIONS == buybuttontype)
                {
                    linearlayout.setOnClickListener(getMarketplaceAction());
                } else
                if (BuyButtonType.FRIEND_APP_BUTTON == buybuttontype)
                {
                    linearlayout.setOnClickListener(getFriendAppAction());
                } else
                if (BuyButtonType.SUBSCRIBER_AND_SAVE == buybuttontype)
                {
                    linearlayout.setOnClickListener(getSnsAction());
                } else
                {
                    linearlayout.setOnClickListener(mBuyNowAction);
                    updateBuyNowButtonStatus(linearlayout);
                }
                j++;
            }
        }
    }

    public void updateButtons(boolean flag)
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.buy_box_buy_buttons_container);
        LinearLayout linearlayout1 = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.buy_box_add_buttons_container);
        if (flag)
        {
            linearlayout.setVisibility(8);
            linearlayout1.setVisibility(8);
            return;
        } else
        {
            linearlayout.setVisibility(0);
            updateButtons(linearlayout, mBuyBoxController.getBuyButtons());
            linearlayout1.setVisibility(0);
            updateButtons(linearlayout1, mBuyBoxController.getAddButtons());
            return;
        }
    }

    public void updateStatus(boolean flag)
    {
        if (mTextViewAboveVariationFilters == null)
        {
            mTextViewAboveVariationFilters = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.buy_box_status_message);
        }
        if (mTextViewAboveBuyButtons == null)
        {
            mTextViewAboveBuyButtons = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.buy_box_status_message_above_buy_buttons);
        }
        if (flag)
        {
            mTextViewAboveVariationFilters.setVisibility(8);
            mTextViewAboveBuyButtons.setVisibility(8);
        } else
        {
            setUpStatusMessage();
        }
        setUpLoadingIndicator(flag);
    }
}
