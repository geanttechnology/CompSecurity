// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;


// Referenced classes of package com.medialets.advertising:
//            AdView

public interface AdListener
{

    public abstract void onDownloadFailed(int i);

    public abstract void onFinishedLoadingView(AdView adview);

    public abstract void onInterstitialDismissed();

    public abstract void onNoAdsAvailable();
}
