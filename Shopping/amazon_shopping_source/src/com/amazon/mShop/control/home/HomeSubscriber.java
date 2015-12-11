// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;

public interface HomeSubscriber
    extends ObjectSubscriber
{

    public abstract void onHomeCallStarted();

    public abstract void onHomeShoveler0Received(HomeShoveler homeshoveler);

    public abstract void onHomeShoveler1Received(HomeShoveler homeshoveler);

    public abstract void onNotificationReceived(Notification notification);

    public abstract void onPromoSlot0Received(PromoSlot promoslot);

    public abstract void onPromoSlot1Received(PromoSlot promoslot);

    public abstract void preHomeCallStarted();
}
