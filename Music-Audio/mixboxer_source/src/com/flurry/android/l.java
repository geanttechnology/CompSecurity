// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            m, dx, t, AdUnit, 
//            AdFrame, FlurryAds, cw, p

final class l
    implements m
{

    private static final Map N;
    private static String p = com/flurry/android/l.getSimpleName();

    l()
    {
    }

    public final p b(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        if (context == null || flurryads == null || cw == null || adunit == null)
        {
            return null;
        }
        if (adunit == null) goto _L2; else goto _L1
_L1:
        Object obj = adunit.getAdFrames();
        if (obj != null && !((List) (obj)).isEmpty()) goto _L4; else goto _L3
_L3:
        obj = null;
_L6:
        if (obj == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = (AdFrame)((List) (obj)).get(0);
        if (obj != null)
        {
            int i = ((AdFrame) (obj)).getBinding().intValue();
            if (adunit.getCombinable().intValue() == 1 || i == 2 || i == 1 || i == 3)
            {
                obj = "FLURRY";
                continue; /* Loop/switch isn't completed */
            }
            if (i == 4)
            {
                obj = "THIRD_PARTY";
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        m m1 = (m)N.get(obj);
        if (m1 == null)
        {
            Log.w(p, (new StringBuilder()).append("Cannot create ad banner for type: ").append(((String) (obj))).toString());
            return null;
        } else
        {
            (new StringBuilder()).append("Creating ad banner for type: ").append(((String) (obj))).toString();
            return m1.b(context, flurryads, cw, adunit);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("FLURRY", new dx());
        hashmap.put("THIRD_PARTY", new t());
        N = Collections.unmodifiableMap(hashmap);
    }
}
