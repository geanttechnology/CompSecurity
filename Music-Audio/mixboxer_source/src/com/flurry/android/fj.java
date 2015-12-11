// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            ba, AdUnit, AdFrame, cy, 
//            FlurryAds, cw, ae

final class fj
    implements ba
{

    private static final String p = com/flurry/android/fj.getSimpleName();
    private final Map gQ;

    public fj(Map map)
    {
        gQ = map;
    }

    public final ae a(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
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
            String s = ((AdFrame) (obj)).getContent().toString();
            if (TextUtils.isEmpty(s))
            {
                return null;
            }
            if (gQ != null)
            {
                obj = (ba)gQ.get(s.toUpperCase(Locale.US));
            } else
            {
                obj = null;
            }
            if (obj == null)
            {
                return null;
            }
            (new StringBuilder()).append("Creating ad network takeover launcher: ").append(obj.getClass().getSimpleName()).append(" for type: ").append(s).toString();
            flurryads = ((ba) (obj)).a(context, flurryads, cw, adunit);
            context = flurryads;
            if (flurryads == null)
            {
                cy.d(p, (new StringBuilder()).append("Cannot create ad network takeover launcher for type: ").append(s).toString());
                return flurryads;
            }
        }
        return context;
    }

}
