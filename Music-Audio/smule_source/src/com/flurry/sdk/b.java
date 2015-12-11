// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            aw, ap, r, at

public class b
{

    public final aw a;
    public final Map b;
    private final Context c;
    private final r d;
    private final ap e;

    public b(aw aw1, Map map, Context context, r r, ap ap1)
    {
        a = aw1;
        b = map;
        c = context;
        d = r;
        e = ap1;
    }

    public static aw a(String s)
    {
        aw aaw[] = aw.values();
        int j = aaw.length;
        for (int i = 0; i < j; i++)
        {
            aw aw1 = aaw[i];
            if (aw1.a().equals(s))
            {
                return aw1;
            }
        }

        return aw.a;
    }

    public Context a()
    {
        return c;
    }

    public r b()
    {
        return d;
    }

    public ap c()
    {
        return e;
    }

    public AdFrame d()
    {
        return e.j();
    }

    public AdUnit e()
    {
        return e.a();
    }

    public at f()
    {
        return e.b();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("event=").append(a.toString());
        stringbuilder.append(",params=").append(b);
        if (e.p() != null)
        {
            stringbuilder.append(",adspace=").append(e.a().adSpace);
        }
        return stringbuilder.toString();
    }
}
