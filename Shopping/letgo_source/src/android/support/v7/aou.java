// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package android.support.v7:
//            ami, aox, aok, alz, 
//            amq, aph, amb, alt, 
//            amc, amz, aol, aoj

abstract class aou extends ami
{

    public aou(alz alz1, String s, String s1, aol aol, aoj aoj)
    {
        super(alz1, s, s1, aol, aoj);
    }

    private aok a(aok aok1, aox aox1)
    {
        return aok1.a("X-CRASHLYTICS-API-KEY", aox1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
    }

    private aok b(aok aok1, aox aox1)
    {
        Object obj;
        aok aok2;
        aok2 = aok1.e("app[identifier]", aox1.b).e("app[name]", aox1.f).e("app[display_version]", aox1.c).e("app[build_version]", aox1.d).a("app[source]", Integer.valueOf(aox1.g)).e("app[minimum_sdk_version]", aox1.h).e("app[built_sdk_version]", aox1.i);
        if (!amq.c(aox1.e))
        {
            aok2.e("app[instance_identifier]", aox1.e);
        }
        if (aox1.j == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        obj = null;
        aok1 = null;
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(aox1.j.b);
        aok1 = inputstream;
        obj = inputstream;
        aok2.e("app[icon][hash]", aox1.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputstream).a("app[icon][width]", Integer.valueOf(aox1.j.c)).a("app[icon][height]", Integer.valueOf(aox1.j.d));
        amq.a(inputstream, "Failed to close app icon InputStream.");
_L2:
        if (aox1.k != null)
        {
            for (aok1 = aox1.k.iterator(); aok1.hasNext(); aok2.e(b(((amb) (aox1))), aox1.c()))
            {
                aox1 = (amb)aok1.next();
                aok2.e(a(aox1), aox1.b());
            }

        }
        break MISSING_BLOCK_LABEL_321;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        obj = aok1;
        alt.h().e("Fabric", (new StringBuilder()).append("Failed to find app icon with resource ID: ").append(aox1.j.b).toString(), notfoundexception);
        amq.a(aok1, "Failed to close app icon InputStream.");
        if (true) goto _L2; else goto _L1
_L1:
        aok1;
        amq.a(((java.io.Closeable) (obj)), "Failed to close app icon InputStream.");
        throw aok1;
        return aok2;
    }

    String a(amb amb1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
            amb1.a()
        });
    }

    public boolean a(aox aox1)
    {
        aok aok1 = b(a(getHttpRequest(), aox1), aox1);
        alt.h().a("Fabric", (new StringBuilder()).append("Sending app info to ").append(getUrl()).toString());
        if (aox1.j != null)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("App icon hash is ").append(aox1.j.a).toString());
            alt.h().a("Fabric", (new StringBuilder()).append("App icon size is ").append(aox1.j.c).append("x").append(aox1.j.d).toString());
        }
        int i = aok1.b();
        if ("POST".equals(aok1.p()))
        {
            aox1 = "Create";
        } else
        {
            aox1 = "Update";
        }
        alt.h().a("Fabric", (new StringBuilder()).append(aox1).append(" app request ID: ").append(aok1.b("X-REQUEST-ID")).toString());
        alt.h().a("Fabric", (new StringBuilder()).append("Result was ").append(i).toString());
        return amz.a(i) == 0;
    }

    String b(amb amb1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
            amb1.a()
        });
    }
}
