// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class bxf extends bth
    implements bxt
{

    public bxf(bsy bsy1, String s, String s1, bwl bwl)
    {
        this(bsy1, s, s1, bwl, HttpMethod.GET);
    }

    bxf(bsy bsy1, String s, String s1, bwl bwl, HttpMethod httpmethod)
    {
        super(bsy1, s, s1, bwl, httpmethod);
    }

    private HttpRequest a(HttpRequest httprequest, bxs bxs1)
    {
        return httprequest.a("X-CRASHLYTICS-API-KEY", bxs1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-D", bxs1.b).a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("Accept", "application/json");
    }

    private JSONObject a(String s)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(s);
        }
        catch (Exception exception)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("Failed to parse settings JSON from ").append(getUrl()).toString(), exception);
            bso.h().a("Fabric", (new StringBuilder()).append("Settings response ").append(s).toString());
            return null;
        }
        return jsonobject;
    }

    private Map b(bxs bxs1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("build_version", bxs1.e);
        hashmap.put("display_version", bxs1.d);
        hashmap.put("source", Integer.toString(bxs1.f));
        if (bxs1.g != null)
        {
            hashmap.put("icon_hash", bxs1.g);
        }
        bxs1 = bxs1.c;
        if (!CommonUtils.c(bxs1))
        {
            hashmap.put("instance", bxs1);
        }
        return hashmap;
    }

    public JSONObject a(bxs bxs1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        Map map = b(bxs1);
        obj = obj1;
        obj1 = getHttpRequest(map);
        obj = obj1;
        bxs1 = a(((HttpRequest) (obj1)), bxs1);
        obj = bxs1;
        bso.h().a("Fabric", (new StringBuilder()).append("Requesting settings from ").append(getUrl()).toString());
        obj = bxs1;
        bso.h().a("Fabric", (new StringBuilder()).append("Settings query params were: ").append(map).toString());
        obj = bxs1;
        obj1 = a(((HttpRequest) (bxs1)));
        if (bxs1 != null)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(bxs1.b("X-REQUEST-ID")).toString());
        }
        return ((JSONObject) (obj1));
        bxs1;
        if (obj != null)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(((HttpRequest) (obj)).b("X-REQUEST-ID")).toString());
        }
        throw bxs1;
    }

    JSONObject a(HttpRequest httprequest)
    {
        int i = httprequest.b();
        bso.h().a("Fabric", (new StringBuilder()).append("Settings result was: ").append(i).toString());
        if (a(i))
        {
            return a(httprequest.e());
        } else
        {
            bso.h().e("Fabric", (new StringBuilder()).append("Failed to retrieve settings from ").append(getUrl()).toString());
            return null;
        }
    }

    boolean a(int i)
    {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }
}
