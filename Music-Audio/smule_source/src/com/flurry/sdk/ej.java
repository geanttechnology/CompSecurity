// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            eo, bo, r, ap, 
//            gd, en

public final class ej
    implements eo
{

    static final String a = com/flurry/sdk/ej.getSimpleName();
    private static final Map b = a();

    public ej()
    {
    }

    private static eo a(String s)
    {
        return (eo)b.get(s);
    }

    private static String a(AdUnit adunit)
    {
        if (adunit == null)
        {
            return null;
        }
        Object obj = adunit.adFrames;
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return null;
        }
        obj = (AdFrame)((List) (obj)).get(0);
        if (obj == null)
        {
            return null;
        }
        int i = ((AdFrame) (obj)).binding;
        if (adunit.combinable == 1 || i == 2 || i == 1 || i == 3)
        {
            return "FLURRY";
        }
        if (i == 4)
        {
            return "THIRD_PARTY";
        } else
        {
            return null;
        }
    }

    private static Map a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("FLURRY", new a());
        hashmap.put("THIRD_PARTY", new bo());
        return Collections.unmodifiableMap(hashmap);
    }

    public en a(Context context, r r1)
    {
        String s;
        if (context != null && r1 != null)
        {
            if ((s = a(r1.k().a())) != null)
            {
                eo eo1 = a(s);
                if (eo1 == null)
                {
                    gd.e(a, (new StringBuilder()).append("Cannot create ad takeover for type: ").append(s).toString());
                    return null;
                } else
                {
                    gd.a(3, a, (new StringBuilder()).append("Creating ad takeover for type: ").append(s).toString());
                    return eo1.a(context, r1);
                }
            }
        }
        return null;
    }


    private class a
        implements eo
    {

        public en a(Context context, r r1)
        {
            return new em(context, r1);
        }

        private a()
        {
        }

    }

}
