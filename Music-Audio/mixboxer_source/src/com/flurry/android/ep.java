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
//            ff, cs, bx, fc, 
//            FlurryAds, cw, AdUnit, ae, 
//            AdCreative, p

final class ep extends ff
{

    ep()
    {
    }

    protected final String O()
    {
        return "Mobclix";
    }

    protected final List P()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("mobclix", "3.2.1", "com.mobclix.android.sdk.MobclixFullScreenAdView"));
        return arraylist;
    }

    protected final List Q()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.mobclix.android.sdk.MobclixBrowserActivity";
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected final List R()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("mobclix", "3.2.1", "com.mobclix.android.sdk.MobclixAdView"));
        return arraylist;
    }

    protected final List S()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.mobclix.APPLICATION_ID");
        return arraylist;
    }

    protected final List T()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        arraylist.add("android.permission.READ_PHONE_STATE");
        return arraylist;
    }

    protected final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adunit == null || bundle == null)
        {
            return null;
        } else
        {
            return new bx(context, flurryads, cw, adunit);
        }
    }

    protected final p a(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new fc(context, flurryads, cw, adcreative);
        }
    }
}
