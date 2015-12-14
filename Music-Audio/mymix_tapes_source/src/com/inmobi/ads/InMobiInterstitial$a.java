// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiInterstitial, InMobiAdRequestStatus

private static final class a extends Handler
{

    private WeakReference a;
    private WeakReference b;
    private boolean c;

    public void a()
    {
        c = false;
    }

    public void handleMessage(Message message)
    {
        Map map;
        Object obj;
        InMobiInterstitial inmobiinterstitial;
        terstitialAdListener terstitialadlistener;
        obj = null;
        map = null;
        inmobiinterstitial = (InMobiInterstitial)b.get();
        terstitialadlistener = (terstitialAdListener)a.get();
        if (inmobiinterstitial == null || terstitialadlistener == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch 1 7: default 84
    //                   1 96
    //                   2 118
    //                   3 135
    //                   4 145
    //                   5 155
    //                   6 181
    //                   7 191;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        break MISSING_BLOCK_LABEL_118;
_L6:
        break MISSING_BLOCK_LABEL_135;
_L7:
        break MISSING_BLOCK_LABEL_145;
_L8:
        break MISSING_BLOCK_LABEL_155;
_L9:
        break MISSING_BLOCK_LABEL_181;
_L10:
        break MISSING_BLOCK_LABEL_191;
_L3:
        Logger.a(com.inmobi.commons.core.utilities.el.INTERNAL, InMobiInterstitial.access$000(), "Unhandled ad lifecycle event! Ignoring ...");
_L2:
        return;
_L4:
        if (c) goto _L2; else goto _L11
_L11:
        c = true;
        terstitialadlistener.onAdLoadSucceeded(inmobiinterstitial);
        return;
        terstitialadlistener.onAdLoadFailed(inmobiinterstitial, (InMobiAdRequestStatus)message.obj);
        return;
        terstitialadlistener.onAdDisplayed(inmobiinterstitial);
        return;
        terstitialadlistener.onAdDismissed(inmobiinterstitial);
        return;
        if (message.obj != null)
        {
            map = (Map)message.obj;
        }
        terstitialadlistener.onAdInteraction(inmobiinterstitial, map);
        return;
        terstitialadlistener.onUserLeftApplication(inmobiinterstitial);
        return;
        Map map1 = obj;
        if (message.obj != null)
        {
            map1 = (Map)message.obj;
        }
        terstitialadlistener.onAdRewardActionCompleted(inmobiinterstitial, map1);
        return;
    }

    public terstitialAdListener(InMobiInterstitial inmobiinterstitial, terstitialAdListener terstitialadlistener)
    {
        super(Looper.getMainLooper());
        c = false;
        b = new WeakReference(inmobiinterstitial);
        a = new WeakReference(terstitialadlistener);
    }
}
