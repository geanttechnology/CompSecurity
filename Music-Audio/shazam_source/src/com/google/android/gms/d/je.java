// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class je extends iy
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public je()
    {
    }

    public final void a(iy iy1)
    {
        iy1 = (je)iy1;
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
        if (!TextUtils.isEmpty(e))
        {
            iy1.e = e;
        }
        if (!TextUtils.isEmpty(f))
        {
            iy1.f = f;
        }
        if (!TextUtils.isEmpty(g))
        {
            iy1.g = g;
        }
        if (!TextUtils.isEmpty(h))
        {
            iy1.h = h;
        }
        if (!TextUtils.isEmpty(i))
        {
            iy1.i = i;
        }
        if (!TextUtils.isEmpty(j))
        {
            iy1.j = j;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", a);
        hashmap.put("source", b);
        hashmap.put("medium", c);
        hashmap.put("keyword", d);
        hashmap.put("content", e);
        hashmap.put("id", f);
        hashmap.put("adNetworkId", g);
        hashmap.put("gclid", h);
        hashmap.put("dclid", i);
        hashmap.put("aclid", j);
        return a(hashmap);
    }
}
