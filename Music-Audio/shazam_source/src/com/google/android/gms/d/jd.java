// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class jd extends iy
{

    public String a;
    public String b;
    public String c;
    public String d;

    public jd()
    {
    }

    public final volatile void a(iy iy1)
    {
        a((jd)iy1);
    }

    public final void a(jd jd1)
    {
        if (!TextUtils.isEmpty(a))
        {
            jd1.a = a;
        }
        if (!TextUtils.isEmpty(b))
        {
            jd1.b = b;
        }
        if (!TextUtils.isEmpty(c))
        {
            jd1.c = c;
        }
        if (!TextUtils.isEmpty(d))
        {
            jd1.d = d;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("appName", a);
        hashmap.put("appVersion", b);
        hashmap.put("appId", c);
        hashmap.put("appInstallerId", d);
        return a(hashmap);
    }
}
