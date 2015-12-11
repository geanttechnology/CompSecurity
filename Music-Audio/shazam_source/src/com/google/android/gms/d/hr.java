// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class hr extends iy
{

    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public boolean g;
    public double h;

    public hr()
    {
    }

    public final void a(iy iy1)
    {
        boolean flag = true;
        iy1 = (hr)iy1;
        if (!TextUtils.isEmpty(a))
        {
            iy1.a = a;
        }
        if (!TextUtils.isEmpty(b))
        {
            iy1.b = b;
        }
        if (!TextUtils.isEmpty(c))
        {
            iy1.c = c;
        }
        if (!TextUtils.isEmpty(d))
        {
            iy1.d = d;
        }
        if (e)
        {
            iy1.e = true;
        }
        if (!TextUtils.isEmpty(f))
        {
            iy1.f = f;
        }
        if (g)
        {
            iy1.g = g;
        }
        if (h != 0.0D)
        {
            double d1 = h;
            if (d1 < 0.0D || d1 > 100D)
            {
                flag = false;
            }
            w.b(flag, "Sample rate must be between 0% and 100%");
            iy1.h = d1;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("hitType", a);
        hashmap.put("clientId", b);
        hashmap.put("userId", c);
        hashmap.put("androidAdId", d);
        hashmap.put("AdTargetingEnabled", Boolean.valueOf(e));
        hashmap.put("sessionControl", f);
        hashmap.put("nonInteraction", Boolean.valueOf(g));
        hashmap.put("sampleRate", Double.valueOf(h));
        return a(hashmap);
    }
}
