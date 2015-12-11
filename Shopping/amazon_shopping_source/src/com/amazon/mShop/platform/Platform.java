// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.util.Logger;

// Referenced classes of package com.amazon.mShop.platform:
//            Resources

public interface Platform
{
    public static class Factory
    {

        private static Platform instance;

        public static Platform getInstance()
        {
            com/amazon/mShop/platform/Platform$Factory;
            JVM INSTR monitorenter ;
            Platform platform = instance;
            com/amazon/mShop/platform/Platform$Factory;
            JVM INSTR monitorexit ;
            return platform;
            Exception exception;
            exception;
            throw exception;
        }

        public static void setInstance(Platform platform)
        {
            com/amazon/mShop/platform/Platform$Factory;
            JVM INSTR monitorenter ;
            instance = platform;
            com/amazon/mShop/platform/Platform$Factory;
            JVM INSTR monitorexit ;
            return;
            platform;
            throw platform;
        }

        public Factory()
        {
        }
    }


    public abstract int getAppStartCountForAllLocales();

    public abstract Object getApplicationContext();

    public abstract String getApplicationId();

    public abstract String getApplicationVersion();

    public abstract DataStore getDataStore();

    public abstract String getDeviceName();

    public abstract Logger getLogger(Class class1);

    public abstract MShopService getMShopService();

    public abstract Resources getResources();

    public abstract void invokeLater(Runnable runnable);

    public abstract void invokeLater(Runnable runnable, long l);

    public abstract boolean isAmazonAppStoreSupported();

    public abstract boolean isAmazonKindleSupported();

    public abstract boolean isAmazonMp3Supported();

    public abstract boolean isAmazonVideoSupported();

    public abstract void resetApplicationId();

    public abstract void runOnUiThread(Runnable runnable);
}
