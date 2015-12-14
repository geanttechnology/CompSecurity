// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

// Referenced classes of package com.applovin.impl.adview:
//            af

public class InterstitialAdDialogCreatorImpl
    implements InterstitialAdDialogCreator
{

    private static final Object a = new Object();
    private static WeakReference b = new WeakReference(null);
    private static WeakReference c = new WeakReference(null);

    public InterstitialAdDialogCreatorImpl()
    {
    }

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk applovinsdk, Activity activity)
    {
        AppLovinSdk applovinsdk1;
        applovinsdk1 = applovinsdk;
        if (applovinsdk == null)
        {
            applovinsdk1 = AppLovinSdk.getInstance(activity);
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        applovinsdk = (af)b.get();
        if (applovinsdk == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (applovinsdk.isShowing() && c.get() == activity)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        applovinsdk = new af(applovinsdk1, activity);
        b = new WeakReference(applovinsdk);
        c = new WeakReference(activity);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return applovinsdk;
        applovinsdk1.getLogger().w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
          goto _L1
        applovinsdk;
        obj;
        JVM INSTR monitorexit ;
        throw applovinsdk;
    }

}
