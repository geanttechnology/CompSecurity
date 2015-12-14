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

abstract class bwu extends bth
{

    public bwu(bsy bsy1, String s, String s1, bwl bwl, HttpMethod httpmethod)
    {
        super(bsy1, s, s1, bwl, httpmethod);
    }

    private HttpRequest a(HttpRequest httprequest, bwx bwx1)
    {
        return httprequest.a("X-CRASHLYTICS-API-KEY", bwx1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
    }

    private HttpRequest b(HttpRequest httprequest, bwx bwx1)
    {
        Object obj;
        HttpRequest httprequest1;
        httprequest1 = httprequest.e("app[identifier]", bwx1.b).e("app[name]", bwx1.f).e("app[display_version]", bwx1.c).e("app[build_version]", bwx1.d).a("app[source]", Integer.valueOf(bwx1.g)).e("app[minimum_sdk_version]", bwx1.h).e("app[built_sdk_version]", bwx1.i);
        if (!CommonUtils.c(bwx1.e))
        {
            httprequest1.e("app[instance_identifier]", bwx1.e);
        }
        if (bwx1.j == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        obj = null;
        httprequest = null;
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(bwx1.j.b);
        httprequest = inputstream;
        obj = inputstream;
        httprequest1.e("app[icon][hash]", bwx1.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputstream).a("app[icon][width]", Integer.valueOf(bwx1.j.c)).a("app[icon][height]", Integer.valueOf(bwx1.j.d));
        CommonUtils.a(inputstream, "Failed to close app icon InputStream.");
_L2:
        if (bwx1.k != null)
        {
            for (httprequest = bwx1.k.iterator(); httprequest.hasNext(); httprequest1.e(b(((bta) (bwx1))), bwx1.c()))
            {
                bwx1 = (bta)httprequest.next();
                httprequest1.e(a(bwx1), bwx1.b());
            }

        }
        break MISSING_BLOCK_LABEL_321;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        obj = httprequest;
        bso.h().e("Fabric", (new StringBuilder()).append("Failed to find app icon with resource ID: ").append(bwx1.j.b).toString(), notfoundexception);
        CommonUtils.a(httprequest, "Failed to close app icon InputStream.");
        if (true) goto _L2; else goto _L1
_L1:
        httprequest;
        CommonUtils.a(((java.io.Closeable) (obj)), "Failed to close app icon InputStream.");
        throw httprequest;
        return httprequest1;
    }

    String a(bta bta1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
            bta1.a()
        });
    }

    public boolean a(bwx bwx1)
    {
        HttpRequest httprequest = b(a(getHttpRequest(), bwx1), bwx1);
        bso.h().a("Fabric", (new StringBuilder()).append("Sending app info to ").append(getUrl()).toString());
        if (bwx1.j != null)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("App icon hash is ").append(bwx1.j.a).toString());
            bso.h().a("Fabric", (new StringBuilder()).append("App icon size is ").append(bwx1.j.c).append("x").append(bwx1.j.d).toString());
        }
        int i = httprequest.b();
        if ("POST".equals(httprequest.p()))
        {
            bwx1 = "Create";
        } else
        {
            bwx1 = "Update";
        }
        bso.h().a("Fabric", (new StringBuilder()).append(bwx1).append(" app request ID: ").append(httprequest.b("X-REQUEST-ID")).toString());
        bso.h().a("Fabric", (new StringBuilder()).append("Result was ").append(i).toString());
        return buk.a(i) == 0;
    }

    String b(bta bta1)
    {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
            bta1.a()
        });
    }
}
