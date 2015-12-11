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
//            ef, bn, r, ap, 
//            gd, ec

public final class ei
    implements ef
{

    static final String a = com/flurry/sdk/ei.getSimpleName();
    private static final Map b = a();

    public ei()
    {
    }

    private static ef a(String s)
    {
        return (ef)b.get(s);
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
        hashmap.put("THIRD_PARTY", new bn());
        return Collections.unmodifiableMap(hashmap);
    }

    public ec b(Context context, r r1)
    {
        String s;
        if (context != null && r1 != null)
        {
            if ((s = a(r1.k().a())) != null)
            {
                ef ef1 = a(s);
                if (ef1 == null)
                {
                    gd.e(a, (new StringBuilder()).append("Cannot create ad banner for type: ").append(s).toString());
                    return null;
                } else
                {
                    gd.a(3, a, (new StringBuilder()).append("Creating ad banner for type: ").append(s).toString());
                    return ef1.b(context, r1);
                }
            }
        }
        return null;
    }


    private class a
        implements ef
    {

        private ec.a a = new ec.a() {

            final a a;

            public void a()
            {
                a.a(a);
            }

            public void b()
            {
                a.a(a);
            }

            public void c()
            {
                a.a(a);
            }

                
                {
                    a = a.this;
                    super();
                }
        };

        private void a()
        {
            ea ea1 = new ea();
            ea1.e = ea.a.b;
            ea1.b();
        }

        static void a(a a1)
        {
            a1.a();
        }

        public ec b(Context context, r r1)
        {
            return new eb(context, r1, a, false);
        }

        private a()
        {
        }

    }

}
