// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.util.Log;
import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.control.cart.CartSubscriber;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.home.HomeSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

public class DebugListener
    implements CartSubscriber, HomeSubscriber, UserListener
{

    private static volatile boolean sInitialized = false;

    public DebugListener()
    {
    }

    public static void init()
    {
        if (SSOUtil.DEBUG && !sInitialized)
        {
            DebugListener debuglistener = new DebugListener();
            User.addUserListener(debuglistener);
            HomeController.getInstance().addSubscriber(debuglistener);
            CartController.getInstance().addCartSubscriber(debuglistener);
            sInitialized = true;
        }
    }

    public void onAvailableCountReceived(int i)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.onAvailableCountReceived ").append(i).toString());
        }
    }

    public void onCancelled()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onCancelled");
        }
    }

    public void onCartDidUpdateCheckOutTimerForItem(CartItem cartitem)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onCartDidUpdateCheckOutTimerForItem");
        }
    }

    public void onCartReceived(CartItems cartitems)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onCartReceived");
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.onError ").append(exception).append(" call ").append(servicecall.getMethod()).toString());
        }
    }

    public void onHomeCallStarted()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onHomeCallStarted");
        }
    }

    public void onHomeShoveler0Received(HomeShoveler homeshoveler)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onHomeShoveler0Received");
        }
    }

    public void onHomeShoveler1Received(HomeShoveler homeshoveler)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onHomeShoveler1Received");
        }
    }

    public void onNotificationReceived(Notification notification)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.onNotificationReceived ").append(notification.getTitle()).append(" ").append(notification.getMessage()).toString());
        }
    }

    public void onObjectReceived(Object obj, int i)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.onObjectReceived ").append(obj).append(" index ").append(i).toString());
        }
    }

    public void onObjectsReceived()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onObjectsReceived");
        }
    }

    public void onPageComplete()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onPageComplete");
        }
    }

    public void onPromoSlot0Received(PromoSlot promoslot)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onPromoSlot0Received");
        }
    }

    public void onPromoSlot1Received(PromoSlot promoslot)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.onPromoSlot1Received");
        }
    }

    public void preHomeCallStarted()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.preHomeCallStarted");
        }
    }

    public void userSignedIn(User user)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.userSignedIn ").append(user.getFullName()).toString());
        }
    }

    public void userSignedOut()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "DebugListener.userSignedOut");
        }
    }

    public void userUpdated(User user)
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", (new StringBuilder()).append("DebugListener.userUpdated ").append(user.getFullName()).toString());
        }
    }

}
