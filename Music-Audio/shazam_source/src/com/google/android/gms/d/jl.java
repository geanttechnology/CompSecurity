// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class jl extends iy
{

    public String a;
    public long b;
    public String c;
    public String d;

    public jl()
    {
    }

    public final void a(iy iy1)
    {
        iy1 = (jl)iy1;
        if (!TextUtils.isEmpty(a))
        {
            iy1.a = a;
        }
        if (b != 0L)
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
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("variableName", a);
        hashmap.put("timeInMillis", Long.valueOf(b));
        hashmap.put("category", c);
        hashmap.put("label", d);
        return a(hashmap);
    }
}
