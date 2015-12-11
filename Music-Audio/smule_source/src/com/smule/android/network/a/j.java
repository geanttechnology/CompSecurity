// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;
import java.util.Locale;

public class j
{

    protected static j a;
    private static final String b = com/smule/android/network/a/j.getName();
    private static Context c;

    private j(Context context)
    {
        c = context;
    }

    public static j a(Context context)
    {
        if (a == null)
        {
            a = new j(context);
        }
        return a;
    }

    public o a(String s)
    {
        HashMap hashmap = new HashMap();
        Locale locale = c.getResources().getConfiguration().locale;
        String s1 = locale.getLanguage();
        aa.a(b, (new StringBuilder()).append("Current locale = ").append(locale).append(" lang = ").append(s1).toString());
        hashmap.put("locPackageId", s);
        s = new k(m.a, "/v2/loc/resource", l.b, n.c, hashmap, true);
        s.i = true;
        return com.smule.android.network.core.b.a().a(s);
    }

}
