// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.apprupt.sdk:
//            CvInterstitialActivity, CvInterstitialAdWrapper

static final class val.context
    implements Runnable
{

    final Context val$context;
    final CvInterstitialAdWrapper val$wrapper;

    public void run()
    {
        int i = CvInterstitialActivity.access$104();
        CvInterstitialActivity.access$200().put(Integer.valueOf(i), val$wrapper);
        CvInterstitialActivity.access$300()._mth300(new Object[] {
            "Posting interstitial data to queue, id ", Integer.valueOf(CvInterstitialActivity.access$100())
        });
        Bundle bundle = new Bundle();
        bundle.putInt("interstitialId", i);
        Intent intent = new Intent(val$context, com/apprupt/sdk/CvInterstitialActivity);
        intent.setFlags(0x10000000);
        intent.putExtras(bundle);
        val$context.startActivity(intent);
    }

    (CvInterstitialAdWrapper cvinterstitialadwrapper, Context context1)
    {
        val$wrapper = cvinterstitialadwrapper;
        val$context = context1;
        super();
    }
}
