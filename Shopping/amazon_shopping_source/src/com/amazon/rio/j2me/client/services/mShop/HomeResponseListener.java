// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            CartItems, LoginData, Notification, PromoSlot, 
//            HomeShoveler

public interface HomeResponseListener
    extends ResponseListener
{

    public abstract void completed(ServiceCall servicecall);

    public abstract void receivedCartItems(CartItems cartitems, ServiceCall servicecall);

    public abstract void receivedCompletedRemembersItemIds(List list, ServiceCall servicecall);

    public abstract void receivedLoginData(LoginData logindata, ServiceCall servicecall);

    public abstract void receivedNotification(Notification notification, ServiceCall servicecall);

    public abstract void receivedPromoSlot0(PromoSlot promoslot, ServiceCall servicecall);

    public abstract void receivedPromoSlot1(PromoSlot promoslot, ServiceCall servicecall);

    public abstract void receivedShoveler0(HomeShoveler homeshoveler, ServiceCall servicecall);

    public abstract void receivedShoveler1(HomeShoveler homeshoveler, ServiceCall servicecall);
}
