// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.amazon.mShop.control.item.BuyButtonController;
import com.amazon.mShop.control.item.BuyButtonType;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.ui.resources.DateFormat;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.ShippingOffer;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class BuyButtonView extends Button
{

    protected BuyButtonController buyButtonController;

    public BuyButtonView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BuyButtonController getBuyButtonController()
    {
        return buyButtonController;
    }

    protected String getFriendAppText()
    {
        return FriendAppProxy.Factory.getProxy(buyButtonController.getProductController()).getButtonLabel(getContext());
    }

    public String getPrimeText(ShippingOffer shippingoffer, boolean flag)
    {
        Object obj = shippingoffer.getDeliveryDate();
        String s = shippingoffer.getName();
        String s1 = shippingoffer.getPrice();
        shippingoffer = getResources();
        StringBuffer stringbuffer = new StringBuffer();
        if (flag)
        {
            stringbuffer.append(shippingoffer.getString(com.amazon.mShop.android.lib.R.string.buy_box_pre_order));
        }
        if (!Util.isEmpty(s))
        {
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(" ");
            }
            stringbuffer.append(s);
        }
        if (stringbuffer.length() > 0)
        {
            stringbuffer.append(" ");
        }
        stringbuffer.append(s1);
        if (obj != null)
        {
            stringbuffer.append("\n");
            obj = DateFormat.getCalendarFromDate(((com.amazon.rio.j2me.client.services.mShop.Date) (obj)));
            stringbuffer.append(shippingoffer.getString(com.amazon.mShop.android.lib.R.string.buy_box_1_click_prime_with_get_it_by_promise_android, new Object[] {
                obj, obj, obj
            }));
        }
        return stringbuffer.toString();
    }

    public void update(BuyButtonController buybuttoncontroller)
    {
        Resources resources;
        int i;
        int j;
        int k;
        buyButtonController = buybuttoncontroller;
        BuyButtonType buybuttontype = buybuttoncontroller.getBuyButtonType();
        ShippingOffer shippingoffer = buybuttoncontroller.getPrimeOneClickShippingOffer();
        resources = getResources();
        if (BuyButtonType.ADD_TO_CART == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_add_to_cart);
        } else
        if (BuyButtonType.ADD_TO_WISH_LIST == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_add_to_wishlist);
        } else
        if (BuyButtonType.BUY_NOW == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_buy_now);
        } else
        if (BuyButtonType.BUY_NOW_1_CLICK == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_buy_now_with_one_click);
        } else
        if (BuyButtonType.PRE_ORDER_1_CLICK == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_preorder_with_one_click);
        } else
        if (BuyButtonType.PRE_ORDER_NOW == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_pre_order_now);
        } else
        if (BuyButtonType.SEE_MORE_BUYING_OPTIONS == buybuttontype)
        {
            setText(com.amazon.mShop.android.lib.R.string.buy_box_see_all_buying_options);
        } else
        if (BuyButtonType.BUY_NOW_1_CLICK_PRIME == buybuttontype)
        {
            setText(getPrimeText(shippingoffer, false));
        } else
        if (BuyButtonType.PRE_ORDER_1_CLICK_PRIME == buybuttontype)
        {
            setText(getPrimeText(shippingoffer, true));
        } else
        if (BuyButtonType.FRIEND_APP_BUTTON == buybuttontype)
        {
            setText(getFriendAppText());
        } else
        if (BuyButtonType.SUBSCRIBER_AND_SAVE == buybuttontype)
        {
            setText(getResources().getString(com.amazon.mShop.android.lib.R.string.sns_dp_subscribe_button, new Object[] {
                getResources().getString(com.amazon.mShop.android.lib.R.string.sns_dp_button_prefix), getResources().getString(com.amazon.mShop.android.lib.R.string.sns_dp_block_save), buybuttoncontroller.getProductController().getExtraOfferListing().getSnsDiscountPercent()
            }));
        }
        i = resources.getInteger(com.amazon.mShop.android.lib.R.integer.text_min_lines_buy_button);
        j = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding);
        k = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding_small);
        buybuttontype.getStyleColor();
        JVM INSTR lookupswitch 5: default 124
    //                   1: 458
    //                   2: 567
    //                   4: 486
    //                   8: 583
    //                   16: 532;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        buybuttontype.getActionIcon();
        JVM INSTR lookupswitch 3: default 164
    //                   32: 622
    //                   64: 598
    //                   128: 610;
           goto _L7 _L8 _L9 _L10
_L7:
        buybuttoncontroller = null;
_L11:
        i = 127;
        if (isEnabled())
        {
            i = 255;
        }
        j = getCurrentTextColor();
        setTextColor(Color.argb(i, Color.red(j), Color.green(j), Color.blue(j)));
        if (buybuttoncontroller != null)
        {
            buybuttoncontroller.setAlpha(i);
        }
        setCompoundDrawablesWithIntrinsicBounds(buybuttoncontroller, null, null, null);
        return;
_L2:
        setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.btn_orange);
        setMinLines(i);
        setPadding(j, k, j, k);
          goto _L1
_L4:
        setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.btn_gold);
        setMinLines(1);
        setPadding(j, j, 0, j);
        setTextSize(0, resources.getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.buy_box_add_button_text_size));
        setGravity(19);
          goto _L1
_L6:
        setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.btn_gray);
        setMinLines(1);
        setTextSize(0, resources.getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.buy_box_add_button_text_size));
        setGravity(17);
          goto _L1
_L3:
        setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.btn_taupe);
        setMinLines(i);
          goto _L1
_L5:
        setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.btn_orange);
        setMinLines(2);
          goto _L1
_L9:
        buybuttoncontroller = resources.getDrawable(com.amazon.mShop.android.lib.R.drawable.btn_icn_arrow);
          goto _L11
_L10:
        buybuttoncontroller = resources.getDrawable(com.amazon.mShop.android.lib.R.drawable.btn_icn_cart);
          goto _L11
_L8:
        buybuttoncontroller = resources.getDrawable(com.amazon.mShop.android.lib.R.drawable.btn_icn_1_click);
          goto _L11
    }
}
