// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.adview:
//            InterstitialAdDialogCreator, AppLovinInterstitialAdDialog

final class u
    implements Runnable
{

    final AppLovinSdk a;
    final Activity b;

    u(AppLovinSdk applovinsdk, Activity activity)
    {
        a = applovinsdk;
        b = activity;
        super();
    }

    public void run()
    {
        (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(a, b).show();
    }
}
