// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialAdDialog

public interface InterstitialAdDialogCreator
{

    public abstract AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk applovinsdk, Activity activity);
}
