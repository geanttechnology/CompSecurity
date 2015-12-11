// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            m, gu, bu, da, 
//            ep, ao, AdUnit, AdFrame, 
//            cy, p, FlurryAds, cw

final class t
    implements m
{

    private static final Map Z;
    private static final String p = com/flurry/android/t.getSimpleName();

    t()
    {
    }

    public final p b(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        if (context == null || flurryads == null || cw == null || adunit == null)
        {
            context = null;
        } else
        {
            Object obj = adunit.getAdFrames();
            if (obj == null || ((List) (obj)).isEmpty())
            {
                return null;
            }
            obj = (AdFrame)((List) (obj)).get(0);
            if (obj == null)
            {
                return null;
            }
            obj = ((AdFrame) (obj)).getContent().toString();
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                return null;
            }
            Object obj1 = ((String) (obj)).toUpperCase(Locale.US);
            obj1 = (m)Z.get(obj1);
            if (obj1 == null)
            {
                return null;
            }
            (new StringBuilder()).append("Creating ad network view for type: ").append(((String) (obj))).toString();
            flurryads = ((m) (obj1)).b(context, flurryads, cw, adunit);
            if (flurryads == null)
            {
                cy.d(p, (new StringBuilder()).append("Cannot create ad network view for type: ").append(((String) (obj))).toString());
                return null;
            }
            context = flurryads;
            if (flurryads != null)
            {
                flurryads.T = adunit;
                return flurryads;
            }
        }
        return context;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Admob".toUpperCase(Locale.US), new gu());
        hashmap.put("Millennial Media".toUpperCase(Locale.US), new bu());
        hashmap.put("InMobi".toUpperCase(Locale.US), new da());
        hashmap.put("Mobclix".toUpperCase(Locale.US), new ep());
        hashmap.put("Jumptap".toUpperCase(Locale.US), new ao());
        Z = Collections.unmodifiableMap(hashmap);
    }
}
