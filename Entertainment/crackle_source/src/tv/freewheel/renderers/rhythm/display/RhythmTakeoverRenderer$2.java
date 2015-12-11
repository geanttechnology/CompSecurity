// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm.display;

import com.rhythmnewmedia.sdk.display.InterstitialAdView;

// Referenced classes of package tv.freewheel.renderers.rhythm.display:
//            RhythmTakeoverRenderer

class this._cls0
    implements Runnable
{

    final RhythmTakeoverRenderer this$0;

    public void run()
    {
        ((InterstitialAdView)adView).requestNewAd();
    }

    ()
    {
        this$0 = RhythmTakeoverRenderer.this;
        super();
    }
}
