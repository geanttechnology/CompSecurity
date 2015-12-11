// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.content.Context;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;

public final class NautilusDomain
{
    public static interface Factory
    {

        public abstract String getMachineGroupId(Context context);

        public abstract com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Configuration getShoppingCartDataManagerConfiguration(Context context);

        public abstract void initializeDataManager(EbayContext ebaycontext, DataManager datamanager);

        public abstract void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus);
    }

    static final class Settings
    {

        public final Factory factory;

        public Settings(Context context, Factory factory1)
        {
            factory = factory1;
        }
    }


    private static volatile Settings settings = null;

    private NautilusDomain()
    {
    }

    public static String getMachineGroupId(Context context)
    {
        verifyInitialized();
        return settings.factory.getMachineGroupId(context);
    }

    public static com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Configuration getShoppingCartDataManagerConfiguration(Context context)
    {
        verifyInitialized();
        return settings.factory.getShoppingCartDataManagerConfiguration(context);
    }

    public static void init(Context context, Factory factory)
    {
        if (context == null)
        {
            throw new NullPointerException("context");
        }
        if (factory == null)
        {
            throw new NullPointerException("factory");
        }
        if (settings == null)
        {
            settings = new Settings(context, factory);
        }
    }

    public static void initializeDataManager(EbayContext ebaycontext, DataManager datamanager)
    {
        verifyInitialized();
        settings.factory.initializeDataManager(ebaycontext, datamanager);
    }

    public static void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        verifyInitialized();
        settings.factory.rewriteServiceErrors(ebaycontext, resultstatus);
    }

    private static void verifyInitialized()
    {
        if (settings == null)
        {
            throw new RuntimeException("NautilusDomain not initialized! Call NautilusDomain.init().");
        } else
        {
            return;
        }
    }

}
