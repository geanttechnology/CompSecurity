// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bj, bw, by, bf, 
//            r, ec, en

public final class bv extends bj
{

    public bv()
    {
    }

    protected ec a(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || r == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new bw(context, r, adcreative, bundle);
        }
    }

    protected en a(Context context, r r, Bundle bundle)
    {
        if (context == null || r == null || bundle == null)
        {
            return null;
        } else
        {
            return new by(context, r, bundle);
        }
    }

    protected String f()
    {
        return "InMobi";
    }

    protected List g()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMInterstitial"));
        return arraylist;
    }

    protected List j()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.inmobi.androidsdk.IMBrowserActivity";
        activityinfo.configChanges = 3248;
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected List k()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMBanner"));
        return arraylist;
    }

    protected List n()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.inmobi.MY_APP_ID");
        return arraylist;
    }

    protected List o()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        return arraylist;
    }
}
