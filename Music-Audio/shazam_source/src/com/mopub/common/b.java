// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.mopub.common:
//            f

public final class b
    implements Serializable
{

    public final com.mopub.c.b a;
    private final String b;
    private final String c;
    private final String d;
    private final Locale e;
    private final String f;

    public b(String s, f f1, com.mopub.c.b b1)
    {
        b = s;
        c = f1.l;
        d = f1.i;
        e = f1.p.getResources().getConfiguration().locale;
        f = f1.c();
        a = b1;
    }

    private static void a(StringBuilder stringbuilder, String s, String s1)
    {
        stringbuilder.append(s);
        stringbuilder.append(" : ");
        stringbuilder.append(s1);
        stringbuilder.append("\n");
    }

    public final String toString()
    {
        Integer integer = null;
        StringBuilder stringbuilder = new StringBuilder();
        a(stringbuilder, "sdk_version", c);
        a(stringbuilder, "creative_id", a.k);
        a(stringbuilder, "platform_version", Integer.toString(android.os.Build.VERSION.SDK_INT));
        a(stringbuilder, "device_model", d);
        a(stringbuilder, "ad_unit_id", b);
        Object obj;
        Object obj1;
        StringBuilder stringbuilder1;
        long l;
        if (e == null)
        {
            obj = null;
        } else
        {
            obj = e.toString();
        }
        a(stringbuilder, "device_locale", ((String) (obj)));
        a(stringbuilder, "device_id", f);
        a(stringbuilder, "network_type", a.b);
        a(stringbuilder, "platform", "android");
        l = a.o;
        obj = integer;
        if (l != -1L)
        {
            obj = (new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US)).format(new Date(l));
        }
        a(stringbuilder, "timestamp", ((String) (obj)));
        a(stringbuilder, "ad_type", a.a);
        obj1 = a.g;
        integer = a.h;
        stringbuilder1 = new StringBuilder("{");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "0";
        }
        obj1 = stringbuilder1.append(obj).append(", ");
        if (integer == null)
        {
            obj = "0";
        } else
        {
            obj = integer;
        }
        a(stringbuilder, "ad_size", ((StringBuilder) (obj1)).append(obj).append("}").toString());
        return stringbuilder.toString();
    }
}
