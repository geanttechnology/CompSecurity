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
//            ef, bt, bz, bv, 
//            bq, r, ap, gd, 
//            ec

public final class bn
    implements ef
{

    private static final String a = com/flurry/sdk/bn.getSimpleName();
    private static final Map b = a();

    public bn()
    {
    }

    private static ef a(String s)
    {
        return (ef)b.get(s);
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

    public ec b(Context context, r r1)
    {
        if (context == null || r1 == null)
        {
            context = null;
        } else
        {
            if (r1.k().a() == null)
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
            ef ef1 = a(((String) (obj)).toUpperCase(Locale.US));
            if (ef1 == null)
            {
                return null;
            }
            gd.a(3, a, (new StringBuilder()).append("Creating ad network view for type: ").append(((String) (obj))).toString());
            r1 = ef1.b(context, r1);
            context = r1;
            if (r1 == null)
            {
                gd.b(a, (new StringBuilder()).append("Cannot create ad network view for type: ").append(((String) (obj))).toString());
                return null;
            }
        }
        return context;
    }

}
