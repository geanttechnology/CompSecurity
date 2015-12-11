// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class fr
{

    final List a;
    final String b;
    final String c;
    final boolean d;
    final String e;
    String f;
    int g;
    private final List h;
    private final String i;
    private final String j;

    public fr(int k, Map map)
    {
        f = (String)map.get("url");
        j = (String)map.get("base_uri");
        b = (String)map.get("post_parameters");
        String s = (String)map.get("drt_include");
        boolean flag;
        if (s != null && (s.equals("1") || s.equals("true")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        i = (String)map.get("activation_overlay_url");
        h = a((String)map.get("check_packages"));
        e = (String)map.get("request_id");
        c = (String)map.get("type");
        a = a((String)map.get("errors"));
        g = k;
    }

    private static List a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Arrays.asList(s.split(","));
        }
    }
}
