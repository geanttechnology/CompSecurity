// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            eo, bt, bz, bv, 
//            bq, r, ap, gd, 
//            en

public final class bo
    implements eo
{

    private static final String a = com/flurry/sdk/bo.getSimpleName();
    private static final Map b = a();

    public bo()
    {
    }

    private static eo a(String s)
    {
        return (eo)b.get(s);
    }

    private static Map a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("AdMob".toUpperCase(Locale.US), new bt());
        hashmap.put("Millennial Media".toUpperCase(Locale.US), new bz());
        hashmap.put("InMobi".toUpperCase(Locale.US), new bv());
        hashmap.put("Facebook Audience Network".toUpperCase(Locale.US), new bq());
        return Collections.unmodifiableMap(hashmap);
    }

    public en a(Context context, r r1)
    {
        if (context == null || r1 == null)
        {
            context = null;
        } else
        {
            if (r1.k().a() == null || r1.k().b() == null)
            {
                return null;
            }
            Object obj = r1.k().a().adFrames;
            if (obj == null || ((List) (obj)).isEmpty())
            {
                return null;
            }
            obj = (AdFrame)((List) (obj)).get(0);
            if (obj == null)
            {
                return null;
            }
            obj = ((AdFrame) (obj)).content;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                return null;
            }
            eo eo1 = a(((String) (obj)).toUpperCase(Locale.US));
            if (eo1 == null)
            {
                return null;
            }
            gd.a(3, a, (new StringBuilder()).append("Creating ad network takeover launcher: ").append(eo1.getClass().getSimpleName()).append(" for type: ").append(((String) (obj))).toString());
            r1 = eo1.a(context, r1);
            context = r1;
            if (r1 == null)
            {
                gd.b(a, (new StringBuilder()).append("Cannot create ad network takeover launcher for type: ").append(((String) (obj))).toString());
                return r1;
            }
        }
        return context;
    }

}
