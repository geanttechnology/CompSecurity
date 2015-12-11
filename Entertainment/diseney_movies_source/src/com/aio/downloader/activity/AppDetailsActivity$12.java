// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0
    implements AdListener
{

    final AppDetailsActivity this$0;

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
        Log.e("rtrtr", (new StringBuilder()).append(aderror).toString());
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
