// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

abstract class adh extends aam
{

    public adh(aad aad1, String s, String s1, acy acy, HttpMethod httpmethod)
    {
        super(aad1, s, s1, acy, httpmethod);
    }

    private HttpRequest a(HttpRequest httprequest, adk adk1)
    {
        return httprequest.a("X-CRASHLYTICS-API-KEY", adk1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
    }

    private HttpRequest b(HttpRequest httprequest, adk adk1)
    {
        Object obj;
        HttpRequest httprequest1;
        httprequest1 = httprequest.e("app[identifier]", adk1.b).e("app[name]", adk1.f).e("app[display_version]", adk1.c).e("app[build_version]", adk1.d).a("app[source]", Integer.valueOf(adk1.g)).e("app[minimum_sdk_version]", adk1.h).e("app[built_sdk_version]", adk1.i);
        if (!CommonUtils.c(adk1.e))
        {
            httprequest1.e("app[instance_identifier]", adk1.e);
        }
        if (adk1.j == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        obj = null;
        httprequest = null;
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(adk1.j.b);
        httprequest = inputstream;
        obj = inputstream;
        httprequest1.e("app[icon][hash]", adk1.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputstream).a("app[icon][width]", Integer.valueOf(adk1.j.c)).a("app[icon][height]", Integer.valueOf(adk1.j.d));
        CommonUtils.a(inputstream, "Failed to close app icon InputStream.");
_L2:
        if (adk1.k != null)
        {
            for (httprequest = adk1.k.iterator(); httprequest.hasNext(); httprequest1.e(b(((aaf) (adk1))), adk1.c()))
            {
                adk1 = (aaf)httprequest.next();
                httprequest1.e(a(adk1), adk1.b());
            }

        }
        break MISSING_BLOCK_LABEL_321;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        obj = httprequest;
        zw.h().e("Fabric", (new StringBuilder()).append("Failed to find app icon with resource ID: ").append(adk1.j.b).toString(), notfoundexception);
        CommonUtils.a(httprequest, "Failed to close app icon InputStream.");
        if (true) goto _L2; else goto _L1
_L1:
        httprequest;
        CommonUtils.a(((java.io.Closeable) (obj)), "Failed to close app icon InputStream.");
        throw httprequest;
        return httprequest1;
    }

    String a(aaf aaf1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
            aaf1.a()
        });
    }

    public boolean a(adk adk1)
    {
        HttpRequest httprequest = b(a(getHttpRequest(), adk1), adk1);
        zw.h().a("Fabric", (new StringBuilder()).append("Sending app info to ").append(getUrl()).toString());
        if (adk1.j != null)
        {
            zw.h().a("Fabric", (new StringBuilder()).append("App icon hash is ").append(adk1.j.a).toString());
            zw.h().a("Fabric", (new StringBuilder()).append("App icon size is ").append(adk1.j.c).append("x").append(adk1.j.d).toString());
        }
        int i = httprequest.b();
        if ("POST".equals(httprequest.p()))
        {
            adk1 = "Create";
        } else
        {
            adk1 = "Update";
        }
        zw.h().a("Fabric", (new StringBuilder()).append(adk1).append(" app request ID: ").append(httprequest.b("X-REQUEST-ID")).toString());
        zw.h().a("Fabric", (new StringBuilder()).append("Result was ").append(i).toString());
        return abh.a(i) == 0;
    }

    String b(aaf aaf1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
            aaf1.a()
        });
    }
}
