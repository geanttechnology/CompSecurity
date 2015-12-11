// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import android.util.Log;
import com.amazon.mShop.wearable.model.MobileState;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.HomeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private static class <init>
    implements HomeResponseListener
{

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(ServiceCall servicecall)
    {
        MShopWearListenerService.access$1200();
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e("WearListenerService", "Unable to query home info", exception);
    }

    public void receivedCartItems(CartItems cartitems, ServiceCall servicecall)
    {
    }

    public void receivedCompletedRemembersItemIds(List list, ServiceCall servicecall)
    {
    }

    public void receivedLoginData(LoginData logindata, ServiceCall servicecall)
    {
        logindata = logindata.getPrimeOneClickStatus();
        if (logindata != null)
        {
            MShopWearListenerService.access$700().oneClickEnabled = logindata.getIsOneClickEnabled();
            return;
        } else
        {
            MShopWearListenerService.access$700().oneClickEnabled = false;
            return;
        }
    }

    public void receivedNotification(Notification notification, ServiceCall servicecall)
    {
    }

    public void receivedPromoSlot0(PromoSlot promoslot, ServiceCall servicecall)
    {
    }

    public void receivedPromoSlot1(PromoSlot promoslot, ServiceCall servicecall)
    {
    }

    public void receivedShoveler0(HomeShoveler homeshoveler, ServiceCall servicecall)
    {
    }

    public void receivedShoveler1(HomeShoveler homeshoveler, ServiceCall servicecall)
    {
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
