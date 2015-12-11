// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mobile.mash.api.MASHEventPlugin;
import com.amazon.mobile.mash.event.CartMASHNotificationReceiver;
import com.amazon.mobile.mash.event.MASHEventType;
import java.util.ArrayList;
import java.util.List;

public class NativeAppNotification
{
    public static interface NativeCartSubscriber
    {

        public abstract void onCartChanged();
    }

    public static interface NativeWishListSubscriber
    {

        public abstract void onWishListChanged();
    }


    private static List sNativeCarSubscribers = new ArrayList();
    private static List sNativeWishListSubscriber = new ArrayList();

    public NativeAppNotification()
    {
    }

    public static void addNativeCartSubscriber(NativeCartSubscriber nativecartsubscriber)
    {
        sNativeCarSubscribers.add(nativecartsubscriber);
    }

    public static void addNativeWishListSubscriber(NativeWishListSubscriber nativewishlistsubscriber)
    {
        sNativeWishListSubscriber.add(nativewishlistsubscriber);
    }

    public static void notifyNativeCartChanged(int i)
    {
        org.json.JSONObject jsonobject = CartMASHNotificationReceiver.getCartUpdateJSONObject(i);
        if (jsonobject != null)
        {
            MASHEventPlugin.sendMASHEventBroadcast(MASHEventType.cartUpdated.name(), jsonobject, AndroidPlatform.getInstance().getApplicationContext());
        }
        for (i = sNativeCarSubscribers.size() - 1; i >= 0; i--)
        {
            ((NativeCartSubscriber)sNativeCarSubscribers.get(i)).onCartChanged();
        }

    }

    public static void notifyNativeWishListChanged()
    {
        for (int i = sNativeWishListSubscriber.size() - 1; i >= 0; i--)
        {
            ((NativeWishListSubscriber)sNativeWishListSubscriber.get(i)).onWishListChanged();
        }

    }

    public static void removeNativeCartSubscriber(NativeCartSubscriber nativecartsubscriber)
    {
        sNativeCarSubscribers.remove(nativecartsubscriber);
    }

    public static void removeNativeWishListSubscriber(NativeWishListSubscriber nativewishlistsubscriber)
    {
        sNativeWishListSubscriber.remove(nativewishlistsubscriber);
    }

}
