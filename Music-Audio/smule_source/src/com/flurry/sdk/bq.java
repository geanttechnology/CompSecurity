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
//            bj, bp, br, bf, 
//            r, ec, en

public class bq extends bj
{

    public bq()
    {
    }

    protected ec a(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || r == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new bp(context, r, adcreative, bundle);
        }
    }

    protected en a(Context context, r r, Bundle bundle)
    {
        if (context == null || r == null || bundle == null)
        {
            return null;
        } else
        {
            return new br(context, r, bundle);
        }
    }

    protected String f()
    {
        return "Facebook Audience Network";
    }

    protected List g()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("AudienceNetwork", "3.14.+", "com.facebook.ads.InterstitialAd"));
        return arraylist;
    }

    protected List j()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.facebook.ads.InterstitialAdActivity";
        activityinfo.configChanges = 4016;
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected List k()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("AudienceNetwork", "3.14.+", "com.facebook.ads.Ad"));
        return arraylist;
    }

    protected List n()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.fan.MY_APP_ID");
        return arraylist;
    }

    protected List o()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        arraylist.add("android.permission.ACCESS_NETWORK_STATE");
        return arraylist;
    }
}
