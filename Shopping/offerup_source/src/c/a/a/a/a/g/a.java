// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import c.a.a.a.a.b.l;
import c.a.a.a.a.e.d;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.p;
import c.a.a.a.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package c.a.a.a.a.g:
//            d, k

abstract class a extends c.a.a.a.a.b.a
{

    public a(n n1, String s, String s1, c.a.a.a.a.e.a a1, int i)
    {
        super(n1, s, s1, a1, i);
    }

    private d a(d d1, c.a.a.a.a.g.d d2)
    {
        d d3;
        d3 = d1.a("app[identifier]", null, d2.b).a("app[name]", null, d2.f).a("app[display_version]", null, d2.c).a("app[build_version]", null, d2.d).a("app[source]", Integer.valueOf(d2.g)).a("app[minimum_sdk_version]", null, d2.h).a("app[built_sdk_version]", null, d2.i);
        if (!l.c(d2.e))
        {
            d3.a("app[instance_identifier]", null, d2.e);
        }
        if (d2.j == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(d2.j.b);
        d1 = inputstream;
        d3.a("app[icon][hash]", null, d2.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputstream).a("app[icon][width]", Integer.valueOf(d2.j.c)).a("app[icon][height]", Integer.valueOf(d2.j.d));
        l.a(inputstream, "Failed to close app icon InputStream.");
        break MISSING_BLOCK_LABEL_190;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        inputstream = null;
_L4:
        d1 = inputstream;
        e.d().c("Fabric", (new StringBuilder("Failed to find app icon with resource ID: ")).append(d2.j.b).toString(), notfoundexception);
        l.a(inputstream, "Failed to close app icon InputStream.");
          goto _L1
        d2;
        d1 = null;
_L3:
        l.a(d1, "Failed to close app icon InputStream.");
        throw d2;
_L1:
        if (d2.k != null)
        {
            for (d1 = d2.k.iterator(); d1.hasNext(); d3.a(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
    d2.a()
}), null, d2.c()))
            {
                d2 = (p)d1.next();
                d3.a(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
                    d2.a()
                }), null, d2.b());
            }

        }
        return d3;
        d2;
        if (true) goto _L3; else goto _L2
_L2:
        notfoundexception;
          goto _L4
    }

    public boolean a(c.a.a.a.a.g.d d1)
    {
        d d2 = a(getHttpRequest().a("X-CRASHLYTICS-API-KEY", d1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()), d1);
        e.d().a("Fabric", (new StringBuilder("Sending app info to ")).append(getUrl()).toString());
        if (d1.j != null)
        {
            e.d().a("Fabric", (new StringBuilder("App icon hash is ")).append(d1.j.a).toString());
            e.d().a("Fabric", (new StringBuilder("App icon size is ")).append(d1.j.c).append("x").append(d1.j.d).toString());
        }
        int i = d2.b();
        if ("POST".equals(d2.d()))
        {
            d1 = "Create";
        } else
        {
            d1 = "Update";
        }
        e.d().a("Fabric", (new StringBuilder()).append(d1).append(" app request ID: ").append(d2.a("X-REQUEST-ID")).toString());
        e.d().a("Fabric", (new StringBuilder("Result was ")).append(i).toString());
        return android.support.v4.e.a.a(i) == 0;
    }
}
