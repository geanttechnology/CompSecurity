// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import amazon.android.dexload.SupplementalDexLoader;
import android.content.Context;
import android.util.Log;
import com.amazon.avod.MShopAmazonInstantVideo;
import com.amazon.avod.playbackclient.settings.page.MobileStreamingQualitySettingsFragmentFactory;
import com.amazon.avod.sdk.AmazonInstantVideo;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.mShop.aiv:
//            AmazonInstantVideoProxy, AIVAvailabilityUtils

private class this._cls0
    implements Runnable
{

    final AmazonInstantVideoProxy this$0;

    private Object initializeReflectively(String s, Context context)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        Log.d("AmazonApplication", (new StringBuilder()).append("loading and initializing class ").append(s).toString());
        s = ((String) (SecondDexEntry.getInstance().getClassLoader().loadClass(s).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0])));
        s.getClass().getDeclaredMethod("initialize", new Class[] {
            android/content/Context
        }).invoke(s, new Object[] {
            context
        });
        return s;
    }

    public void run()
    {
        boolean flag = false;
        SupplementalDexLoader.getInstance().waitForLoad();
        AmazonInstantVideoProxy.access$202(AmazonInstantVideoProxy.this, (MShopAmazonInstantVideo)initializeReflectively("com.amazon.avod.MShopAmazonInstantVideoDelegate", AmazonInstantVideoProxy.access$100(AmazonInstantVideoProxy.this)));
        AmazonInstantVideoProxy.access$302(AmazonInstantVideoProxy.this, (MobileStreamingQualitySettingsFragmentFactory)initializeReflectively("com.amazon.avod.playbackclient.settings.page.MobileStreamingQualitySettingsFragmentFactoryDelegate", AmazonInstantVideoProxy.access$100(AmazonInstantVideoProxy.this)));
        AmazonInstantVideo amazoninstantvideo = new AmazonInstantVideo(AmazonInstantVideoProxy.access$100(AmazonInstantVideoProxy.this));
        amazoninstantvideo.queryPlaybackSupport(new PlaybackSupportResponse() {

            final AmazonInstantVideoProxy.AIVInitializationRunnable this$1;

            public void onPlaybackSupport(com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport playbacksupport)
            {
                AmazonInstantVideoProxy.access$402(this$0, playbacksupport.isPlaybackSupported());
                AmazonInstantVideoProxy.access$502(this$0, playbacksupport.isPlaybackSustainable());
            }

            
            {
                this$1 = AmazonInstantVideoProxy.AIVInitializationRunnable.this;
                super();
            }
        });
        amazoninstantvideo.cleanup();
        flag = true;
_L2:
        AmazonInstantVideoProxy.access$800(AmazonInstantVideoProxy.this).countDown();
        AIVAvailabilityUtils.setIsAIVInitialized(flag);
        return;
        Exception exception;
        exception;
        Log.e("AmazonApplication", "AIV initialization failed, falling back to silently disabling AIV integration", exception);
        AmazonInstantVideoProxy.access$202(AmazonInstantVideoProxy.this, new o(null));
        AmazonInstantVideoProxy.access$302(AmazonInstantVideoProxy.this, new SettingsFragmentFactory(null));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public _cls1.this._cls1(Context context)
    {
        this$0 = AmazonInstantVideoProxy.this;
        super();
        AmazonInstantVideoProxy.access$102(AmazonInstantVideoProxy.this, context);
    }
}
