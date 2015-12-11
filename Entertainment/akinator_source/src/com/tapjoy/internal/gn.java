// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            r, n, o, l, 
//            k, gd, ar, bn

public final class gn
{

    final k A;
    final k B;
    final Context a;
    final SharedPreferences b;
    final r c;
    final r d;
    final n e;
    final n f;
    final r g;
    final n h;
    final o i;
    final o j;
    final o k;
    final r l;
    final n m;
    final l n;
    final o o;
    final l p;
    final r q;
    final r r;
    final n s;
    final n t;
    final r u;
    final r v;
    final r w;
    final r x;
    final r y;
    final r z;

    private gn(Context context)
    {
        context = context.getApplicationContext();
        a = context;
        b = context.getSharedPreferences("fiverocks", 0);
        c = new r(b, "sdk");
        d = new r(b, "ir");
        e = new n(b, "fql", 0);
        f = new n(b, "fq", 0);
        g = new r(b, "push");
        h = new n(b, "ss", 0);
        i = new o(b, "std");
        j = new o(b, "slt");
        k = new o(b, "sld");
        l = new r(b, "ptc");
        m = new n(b, "pc", 0);
        n = new l(b, "ptp");
        o = new o(b, "lpt");
        p = new l(b, "plp");
        q = new r(b, "adv");
        r = new r(b, "ui");
        s = new n(b, "ul", -1);
        t = new n(b, "uf", -1);
        u = new r(b, "uv1");
        v = new r(b, "uv2");
        w = new r(b, "uv3");
        x = new r(b, "uv4");
        y = new r(b, "uv5");
        z = new r(b, "idfa");
        A = new k(b, "idfa.optout");
        B = new k(b, "push.optout");
    }

    public static gn a(Context context)
    {
        return new gn(context);
    }

    final android.content.SharedPreferences.Editor a()
    {
        return b.edit();
    }

    public final String b()
    {
        String s2 = b.getString("ir", null);
        if (s2 == null) goto _L2; else goto _L1
_L1:
        if (s2.length() <= 0) goto _L4; else goto _L3
_L3:
        return s2;
_L4:
        return null;
_L2:
        Object obj = new File(gd.b(a), "referrer");
        String s1 = s2;
        if (((File) (obj)).exists())
        {
            try
            {
                s1 = bn.a(((File) (obj)), ar.c);
            }
            catch (IOException ioexception)
            {
                ioexception = s2;
            }
        }
        obj = b.edit();
        if (s1 != null)
        {
            s2 = s1;
        } else
        {
            s2 = "";
        }
        ((android.content.SharedPreferences.Editor) (obj)).putString("ir", s2).commit();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = s1;
        if (s1.length() > 0) goto _L3; else goto _L5
_L5:
        return null;
    }
}
