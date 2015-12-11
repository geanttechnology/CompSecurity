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
//            bj, ca, cc, bf, 
//            r, ec, en

public final class bz extends bj
{

    public bz()
    {
    }

    protected ec a(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || r == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new ca(context, r, adcreative, bundle);
        }
    }

    protected en a(Context context, r r, Bundle bundle)
    {
        if (context == null || r == null || bundle == null)
        {
            return null;
        } else
        {
            return new cc(context, r, bundle);
        }
    }

    protected String f()
    {
        return "Millennial Media";
    }

    protected List g()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("MMAdView", "5.1.0", "com.millennialmedia.android.MMInterstitial"));
        return arraylist;
    }

    protected List h()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.millennial.MYAPIDINTERSTITIAL");
        return arraylist;
    }

    protected List j()
    {
        ArrayList arraylist = new ArrayList();
        ActivityInfo activityinfo = new ActivityInfo();
        activityinfo.name = "com.millennialmedia.android.MMActivity";
        activityinfo.configChanges = 3248;
        arraylist.add(activityinfo);
        return arraylist;
    }

    protected List k()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new bf("MMAdView", "5.1.0", "com.millennialmedia.android.MMAdView"));
        return arraylist;
    }

    protected List l()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.millennial.MYAPID");
        arraylist.add("com.flurry.millennial.MYAPIDRECTANGLE");
        return arraylist;
    }

    protected List n()
    {
        return new ArrayList();
    }

    protected List o()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        arraylist.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arraylist.add("android.permission.ACCESS_NETWORK_STATE");
        return arraylist;
    }
}
