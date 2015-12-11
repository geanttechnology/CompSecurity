// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            ba, gu, bu, da, 
//            ep, ao, fj, FlurryAds, 
//            cw, AdUnit, ae

final class cv
    implements ba
{

    private static final ba eR;

    cv()
    {
    }

    public final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        return eR.a(context, flurryads, cw, adunit);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Admob".toUpperCase(Locale.US), new gu());
        hashmap.put("Millennial Media".toUpperCase(Locale.US), new bu());
        hashmap.put("InMobi".toUpperCase(Locale.US), new da());
        hashmap.put("Mobclix".toUpperCase(Locale.US), new ep());
        hashmap.put("Jumptap".toUpperCase(Locale.US), new ao());
        eR = new fj(Collections.unmodifiableMap(hashmap));
    }
}
