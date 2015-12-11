// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import java.util.ArrayList;
import java.util.List;

public class MShopWebViewNotification
{
    public static interface WebCartSubscriber
    {

        public abstract void onCartCountChanged(int i);
    }


    private static List sWebCartSubscribers = new ArrayList();

    public MShopWebViewNotification()
    {
    }

    public static void addWebCartSubscriber(WebCartSubscriber webcartsubscriber)
    {
        sWebCartSubscribers.add(webcartsubscriber);
    }

    public static void notifyCartCountChanged(int i)
    {
        for (int j = sWebCartSubscribers.size() - 1; j >= 0; j--)
        {
            ((WebCartSubscriber)sWebCartSubscribers.get(j)).onCartCountChanged(i);
        }

    }

    public static void removeWebCartSubscriber(WebCartSubscriber webcartsubscriber)
    {
        sWebCartSubscribers.remove(webcartsubscriber);
    }

}
