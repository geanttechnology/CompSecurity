// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.adapter;

import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.i;

// Referenced classes of package com.tremorvideo.sdk.android.adapter:
//            TremorAdapterCallbackListener

public class TremorAdapterCalls
{

    private static TremorAdapterCallbackListener a;
    private static i b;

    public TremorAdapterCalls()
    {
    }

    public static void clearListener()
    {
        a = null;
    }

    public static int getAdDuration()
    {
        int j = -1;
        if (b != null)
        {
            j = b.m();
        }
        ad.d((new StringBuilder()).append("FWAdapter: returning Duration Time: ").append(j).toString());
        return j;
    }

    public static int getPlayHeadMS()
    {
        int j = -1;
        if (b != null)
        {
            j = b.l();
        }
        ad.d((new StringBuilder()).append("FWAdapter: returning PlayHEAD Time: ").append(j).toString());
        return j;
    }

    public static void onAdFinished()
    {
        if (a != null)
        {
            a.onAdFinished();
        }
        b = null;
    }

    public static void onAdReady()
    {
        if (a != null)
        {
            a.onAdReady();
        }
    }

    public static void onGetAdFailed()
    {
        if (a != null)
        {
            a.onAdFailed();
        }
    }

    public static void onLeaveApp()
    {
        if (a != null)
        {
            a.onLeaveAd();
        }
    }

    public static void setActivity(i j)
    {
        b = j;
    }

    public static void setAdapterCallBackListener(TremorAdapterCallbackListener tremoradaptercallbacklistener)
    {
        ad.d("Adding adapter callback listener");
        a = tremoradaptercallbacklistener;
    }
}
