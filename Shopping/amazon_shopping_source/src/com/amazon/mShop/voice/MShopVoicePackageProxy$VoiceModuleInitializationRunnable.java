// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import amazon.android.dexload.SupplementalDexLoader;
import android.util.Log;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;
import com.amazon.shopapp.voice.mshop.VoiceSearchPackageInterface;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mShop.voice:
//            MShopVoicePackageProxy

private class <init>
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
            MShopVoicePackageProxy.access$202(MShopVoicePackageProxy.this, getVoiceSearchPackageInterface());
            MShopVoicePackageProxy.access$300(MShopVoicePackageProxy.this).set(true);
            MShopVoiceModule.getInstance().setIsVoicePackageLoaded(true);
        }
        catch (Throwable throwable)
        {
            Log.e(MShopVoicePackageProxy.access$400(), "Voice module initialization failed", throwable);
        }
        MShopVoicePackageProxy.access$500(MShopVoicePackageProxy.this).countDown();
    }

    private ()
    {
        this$0 = MShopVoicePackageProxy.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
