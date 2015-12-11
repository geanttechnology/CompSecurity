// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;

// Referenced classes of package com.appnexus.opensdk:
//            ab, af, at

public interface MediatedInterstitialAdView
    extends ab
{

    public abstract boolean isReady();

    public abstract void requestAd(af af, Activity activity, String s, String s1, at at);

    public abstract void show();
}
