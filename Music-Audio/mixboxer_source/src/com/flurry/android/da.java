// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            ff, cs, dy, ad, 
//            FlurryAds, cw, AdUnit, ae, 
//            AdCreative, p

final class da extends ff
{

    da()
    {
    }

    protected final String O()
    {
        return "InMobi";
    }

    protected final List P()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("InMobiAndroidSDK", "3.5.0", "com.inmobi.androidsdk.IMAdInterstitial"));
        return arraylist;
    }

    protected final List Q()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.inmobi.androidsdk.IMBrowserActivity";
        activityinfo.configChanges = 3248;
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected final List R()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("InMobiAndroidSDK", "3.5.0", "com.inmobi.androidsdk.IMAdView"));
        return arraylist;
    }

    protected final List S()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.inmobi.MY_APP_ID");
        return arraylist;
    }

    protected final List T()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        return arraylist;
    }

    protected final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adunit == null || bundle == null)
        {
            return null;
        } else
        {
            return new dy(context, flurryads, cw, adunit, bundle);
        }
    }

    protected final p a(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new ad(context, flurryads, cw, adcreative, bundle);
        }
    }
}
