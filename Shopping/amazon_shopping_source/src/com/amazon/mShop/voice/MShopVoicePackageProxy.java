// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import amazon.android.dexload.SupplementalDexLoader;
import android.app.Activity;
import android.util.Log;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.util.ConcurrentUtils;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;
import com.amazon.shopapp.voice.mshop.VoiceSearchPackageInterface;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MShopVoicePackageProxy
{
    private static class SingletonHolder
    {

        private static final MShopVoicePackageProxy INSTANCE = new MShopVoicePackageProxy();



        private SingletonHolder()
        {
        }
    }

    private class VoiceModuleInitializationRunnable
        implements Runnable
    {

        final MShopVoicePackageProxy this$0;

        VoiceSearchPackageInterface getVoiceSearchPackageInterface()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException
        {
            return (VoiceSearchPackageInterface)SecondDexEntry.getInstance().getClassLoader().loadClass("com.amazon.shopapp.voice.mshop.VoiceSearchPackage").newInstance();
        }

        public void run()
        {
            try
            {
                SupplementalDexLoader.getInstance().waitForLoad();
                mVoicePackage = getVoiceSearchPackageInterface();
                mIsSuccessfullyInitialized.set(true);
                MShopVoiceModule.getInstance().setIsVoicePackageLoaded(true);
            }
            catch (Throwable throwable)
            {
                Log.e(MShopVoicePackageProxy.TAG, "Voice module initialization failed", throwable);
            }
            mVoiceModuleLatch.countDown();
        }

        private VoiceModuleInitializationRunnable()
        {
            this$0 = MShopVoicePackageProxy.this;
            super();
        }

    }


    private static final String TAG = com/amazon/mShop/voice/MShopVoicePackageProxy.getSimpleName();
    private final AtomicBoolean mInitializationStarted = new AtomicBoolean(false);
    private AtomicBoolean mIsSuccessfullyInitialized;
    private final CountDownLatch mVoiceModuleLatch = new CountDownLatch(1);
    private VoiceSearchPackageInterface mVoicePackage;
    private final String voiceSearchPackageClassName = "com.amazon.shopapp.voice.mshop.VoiceSearchPackage";

    public MShopVoicePackageProxy()
    {
        mIsSuccessfullyInitialized = new AtomicBoolean(false);
        mVoicePackage = null;
    }

    public static MShopVoicePackageProxy getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void initializeMShopVoiceModule()
    {
        if (mInitializationStarted.getAndSet(true))
        {
            throw new IllegalStateException("Voice module initialization can only be called once");
        } else
        {
            (new Thread(new VoiceModuleInitializationRunnable())).start();
            return;
        }
    }

    public void openVoiceSearch(Activity activity, boolean flag)
    {
        if (mIsSuccessfullyInitialized.get() && mVoicePackage != null)
        {
            mVoicePackage.startVoiceSearch(activity, flag);
            return;
        }
        try
        {
            Log.e(TAG, "Voice Search library is not initialized");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Error", activity);
        }
        return;
    }

    public void waitForInitialization()
    {
        ConcurrentUtils.waitLatchWithTimeOut(mVoiceModuleLatch, 10L, TimeUnit.SECONDS);
    }



/*
    static VoiceSearchPackageInterface access$202(MShopVoicePackageProxy mshopvoicepackageproxy, VoiceSearchPackageInterface voicesearchpackageinterface)
    {
        mshopvoicepackageproxy.mVoicePackage = voicesearchpackageinterface;
        return voicesearchpackageinterface;
    }

*/



}
