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
//            ff, cs, ah, fo, 
//            FlurryAds, cw, AdUnit, ae, 
//            AdCreative, p

final class bu extends ff
{

    bu()
    {
    }

    protected final String O()
    {
        return "Millennial Media";
    }

    protected final List P()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("MMAdView", "5.0.1", "com.millennialmedia.android.MMInterstitial"));
        return arraylist;
    }

    protected final List Q()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.millennialmedia.android.MMActivity";
        activityinfo.configChanges = 3248;
        arraylist.add(activityinfo);
        activityinfo = new ActivityInfo();
        activityinfo.name = "com.millennialmedia.android.VideoPlayer";
        activityinfo.configChanges = 3248;
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected final List R()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("MMAdView", "5.0.1", "com.millennialmedia.android.MMAdView"));
        return arraylist;
    }

    protected final List S()
    {
        return new ArrayList();
    }

    protected final List T()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        arraylist.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arraylist.add("android.permission.ACCESS_NETWORK_STATE");
        return arraylist;
    }

    protected final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adunit == null || bundle == null)
        {
            return null;
        } else
        {
            return new ah(context, flurryads, cw, adunit, bundle);
        }
    }

    protected final p a(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new fo(context, flurryads, cw, adcreative, bundle);
        }
    }

    protected final List aj()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.millennial.MYAPIDINTERSTITIAL");
        return arraylist;
    }

    protected final List ak()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.millennial.MYAPID");
        arraylist.add("com.flurry.millennial.MYAPIDRECTANGLE");
        return arraylist;
    }
}
