// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.util.Log;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class 
    implements IMBannerListener
{

    public final void onBannerInteraction(IMBanner imbanner, Map map)
    {
        Log.i("createInmobiView", " BannerInteraction ");
    }

    public final void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode)
    {
        Log.i("createInmobiView", (new StringBuilder(" BannerRequestFailed - errorCode:")).append(imerrorcode).toString());
    }

    public final void onBannerRequestSucceeded(IMBanner imbanner)
    {
        Log.i("createInmobiView", " BannerRequestSucceeded ");
    }

    public final void onDismissBannerScreen(IMBanner imbanner)
    {
        Log.i("createInmobiView", " DismissBannerScreen");
    }

    public final void onLeaveApplication(IMBanner imbanner)
    {
        Log.i("createInmobiView", " LeaveApplication");
    }

    public final void onShowBannerScreen(IMBanner imbanner)
    {
        Log.i("createInmobiView", " ShowBannerScreen");
    }

    ()
    {
    }
}
