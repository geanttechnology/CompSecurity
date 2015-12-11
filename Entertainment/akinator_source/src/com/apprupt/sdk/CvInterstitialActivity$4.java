// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvInterstitialActivity

class this._cls0
    implements com.apprupt.sdk.mediation.tener
{

    final CvInterstitialActivity this$0;

    public void onCloseAd()
    {
        finish();
    }

    public void onFirstTap()
    {
        if (CvInterstitialActivity.access$500(CvInterstitialActivity.this) != null)
        {
            CvInterstitialActivity.access$500(CvInterstitialActivity.this).cvInterstitialFirstTap();
        }
    }

    public void onKillSpace()
    {
        finish();
    }

    ner()
    {
        this$0 = CvInterstitialActivity.this;
        super();
    }
}
