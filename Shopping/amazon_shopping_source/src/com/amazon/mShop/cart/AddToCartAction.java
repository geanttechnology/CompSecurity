// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.control.cart.CartSubscriber;
import com.amazon.mShop.control.item.BuyButtonController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.BuyButtonView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.NativeAppNotification;
import com.amazon.rio.j2me.client.services.ApplicationException;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import java.util.Iterator;
import java.util.List;

public class AddToCartAction
    implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener, Cancellable, CartSubscriber
{

    private String mAsin;
    protected Context mContext;
    private String mDealId;

    public AddToCartAction()
    {
    }

    private String getDialogMessage(CartItems cartitems)
    {
        boolean flag = false;
        int i = 0;
        Object obj = null;
        List list = cartitems.getCartItem();
        cartitems = obj;
        if (list != null)
        {
            cartitems = list.iterator();
            do
            {
                if (!cartitems.hasNext())
                {
                    break;
                }
                CartItem cartitem = (CartItem)cartitems.next();
                if (cartitem.getAsin().equals(mAsin))
                {
                    boolean flag1 = true;
                    flag = flag1;
                    if (cartitem.getMsToExpiry() != null)
                    {
                        i = Math.round((float)cartitem.getMsToExpiry().intValue() / 1000F / 60F);
                        flag = flag1;
                    }
                }
            } while (true);
            if (flag && mDealId != null)
            {
                cartitems = String.format(mContext.getString(com.amazon.mShop.android.lib.R.string.cart_added_timed_to_cart), new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                cartitems = obj;
                if (flag)
                {
                    return mContext.getString(com.amazon.mShop.android.lib.R.string.cart_added_to_cart);
                }
            }
        }
        return cartitems;
    }

    private void showDialog(CartItems cartitems)
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = new com.amazon.mShop.AmazonAlertDialog.Builder(mContext);
        if (cartitems == null) goto _L2; else goto _L1
_L1:
        if (Util.isEmpty(cartitems.getMessages())) goto _L4; else goto _L3
_L3:
        builder.setMessage(Util.join(cartitems.getMessages(), "\n"));
_L2:
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.cart_go_to_shopping_cart_button_dialog, this);
        builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.cart_continue_shopping_button_dialog, this);
        cartitems = builder.create();
        cartitems.setIcon(0);
        cartitems.show();
        return;
_L4:
        cartitems = getDialogMessage(cartitems);
        if (cartitems != null)
        {
            builder.setMessage(cartitems);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void addItem(Context context, String s, String s1, String s2, String s3, String s4, String s5)
    {
        mContext = context;
        mDealId = s4;
        mAsin = s;
        context = CartController.getInstance();
        if (!context.hasServiceCallRunning())
        {
            CartController.getInstance().addCartSubscriber(this);
            context.addToCart(s, s1, s2, s3, s4, s5, (new TaskCallbackFactory(mContext)).getTaskCallback(this, com.amazon.mShop.android.lib.R.string.cart_adding_to_cart));
        }
    }

    public void cancel()
    {
        CartController cartcontroller = CartController.getInstance();
        CartController.getInstance().removeCartSubscriber(this);
        cartcontroller.cancel();
    }

    public void onCartDidUpdateCheckOutTimerForItem(CartItem cartitem)
    {
    }

    public void onCartReceived(CartItems cartitems)
    {
        CartController.getInstance().removeCartSubscriber(this);
        NativeAppNotification.notifyNativeCartChanged(CartController.getInstance().getCartTotalQuantity());
        UIUtils.vibrate(mContext, 50L);
        showDialog(cartitems);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            ActivityUtils.startCartActivity(mContext);
            dialoginterface.dismiss();
            RefMarkerObserver.logRefMarker("crt_dia_go_to_crt");
            return;
        }
        if (i == -2)
        {
            dialoginterface.dismiss();
            RefMarkerObserver.logRefMarker("crt_dia_con_shop");
            return;
        } else
        {
            Log.e("Amazon.AddToCartAction", (new StringBuilder()).append("Unexpected button click with which=").append(i).toString());
            return;
        }
    }

    public void onClick(View view)
    {
        if (view instanceof BuyButtonView)
        {
            Object obj = ((BuyButtonView)view).getBuyButtonController();
            Object obj1 = ((BuyButtonController) (obj)).getProductController();
            String s = ((ProductController) (obj1)).getAsin();
            String s1 = ((BuyButtonController) (obj)).getOfferId();
            String s2 = ((ProductController) (obj1)).getClickStreamTag().getTag();
            String s3 = ((ProductController) (obj1)).getListId();
            obj1 = ((ProductController) (obj1)).getListItemId();
            obj = ((BuyButtonController) (obj)).getDealId();
            addItem(view.getContext(), s, s1, s3, ((String) (obj1)), ((String) (obj)), s2);
            RefMarkerObserver.logRefMarker("dp_buy_crt");
        }
    }

    public void onError(Exception exception, final ServiceCall currentView)
    {
        if ((exception instanceof ApplicationException) && mDealId != null)
        {
            if (UIUtils.getServerMessageForException(exception) == null)
            {
                UIUtils.alert(mContext, mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.deal_cannot_add_to_cart));
            } else
            {
                UIUtils.alert(mContext, exception);
            }
        } else
        {
            currentView = ((AmazonActivity)mContext).getCurrentView();
            com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

                final AddToCartAction this$0;
                final View val$currentView;

                public void onActionButtonClick(int i)
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            ((AmazonActivity)mContext).clearErrorOnView(currentView);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = AddToCartAction.this;
                currentView = view;
                super();
            }
            };
            AmazonErrorUtils.reportMShopServerError((AmazonActivity)mContext, amazonerrorboxactionlistener, currentView, exception, mContext.getString(com.amazon.mShop.android.lib.R.string.ok));
        }
        CartController.getInstance().removeCartSubscriber(this);
    }
}
