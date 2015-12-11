// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.gotv.crackle.Application;

// Referenced classes of package com.freewheel.ad:
//            AdFetcher

class this._cls0
    implements Runnable
{

    final AdFetcher this$0;

    public void run()
    {
        try
        {
            com.google.android.gms.ads.identifier.dClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(Application.getAppContext());
            AdFetcher.access$002(AdFetcher.this, info.getId());
            AdFetcher.access$102(AdFetcher.this, info.isLimitAdTrackingEnabled());
        }
        catch (Exception exception) { }
        if (TextUtils.isEmpty(AdFetcher.access$000(AdFetcher.this)))
        {
            AdFetcher.access$002(AdFetcher.this, android.provider.ure.getString(Application.getInstance().getContentResolver(), "android_id"));
            AdFetcher.access$102(AdFetcher.this, false);
        }
    }

    ure()
    {
        this$0 = AdFetcher.this;
        super();
    }
}
