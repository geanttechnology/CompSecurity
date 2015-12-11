// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            ff, cs, fu, e, 
//            FlurryAds, cw, AdUnit, ae, 
//            AdCreative, p

final class ao extends ff
{

    ao()
    {
    }

    protected final String O()
    {
        return "Jumptap";
    }

    protected final List P()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("JtAdTag", "1.1.10.4", "com.jumptap.adtag.JtAdInterstitial"));
        return arraylist;
    }

    protected final List Q()
    {
        return new ArrayList();
    }

    protected final List R()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new cs("JtAdTag", "1.1.10.4", "com.jumptap.adtag.JtAdView"));
        return arraylist;
    }

    protected final List S()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("com.flurry.jumptap.PUBLISHER_ID");
        return arraylist;
    }

    protected final List T()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.permission.INTERNET");
        arraylist.add("android.permission.READ_PHONE_STATE");
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
            return new fu(context, flurryads, cw, adunit, bundle);
        }
    }

    protected final p a(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        if (context == null || flurryads == null || cw == null || adcreative == null || bundle == null)
        {
            return null;
        } else
        {
            return new e(context, flurryads, cw, adcreative, bundle);
        }
    }
}
