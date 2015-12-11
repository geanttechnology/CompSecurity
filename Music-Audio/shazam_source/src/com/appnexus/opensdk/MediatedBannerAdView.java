// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.appnexus.opensdk:
//            ab, ad, at

public interface MediatedBannerAdView
    extends ab
{

    public abstract View requestAd(ad ad, Activity activity, String s, String s1, int i, int j, at at);
}
