// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class ads extends aam
    implements aef
{

    public ads(aad aad1, String s, String s1, acy acy)
    {
        this(aad1, s, s1, acy, HttpMethod.GET);
    }

    ads(aad aad1, String s, String s1, acy acy, HttpMethod httpmethod)
    {
        super(aad1, s, s1, acy, httpmethod);
    }

    private HttpRequest a(HttpRequest httprequest, aee aee1)
    {
        return httprequest.a("X-CRASHLYTICS-API-KEY", aee1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-D", aee1.b).a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("Accept", "application/json");
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
            zw.h().a("Fabric", (new StringBuilder()).append("Failed to parse settings JSON from ").append(getUrl()).toString(), exception);
            zw.h().a("Fabric", (new StringBuilder()).append("Settings response ").append(s).toString());
            return null;
        }
        return jsonobject;
    }

    private Map b(aee aee1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("build_version", aee1.e);
        hashmap.put("display_version", aee1.d);
        hashmap.put("source", Integer.toString(aee1.f));
        if (aee1.g != null)
        {
            hashmap.put("icon_hash", aee1.g);
        }
        aee1 = aee1.c;
        if (!CommonUtils.c(aee1))
        {
            hashmap.put("instance", aee1);
        }
        return hashmap;
    }

    public JSONObject a(aee aee1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        Map map = b(aee1);
        obj = obj1;
        obj1 = getHttpRequest(map);
        obj = obj1;
        aee1 = a(((HttpRequest) (obj1)), aee1);
        obj = aee1;
        zw.h().a("Fabric", (new StringBuilder()).append("Requesting settings from ").append(getUrl()).toString());
        obj = aee1;
        zw.h().a("Fabric", (new StringBuilder()).append("Settings query params were: ").append(map).toString());
        obj = aee1;
        obj1 = a(((HttpRequest) (aee1)));
        if (aee1 != null)
        {
            zw.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(aee1.b("X-REQUEST-ID")).toString());
        }
        return ((JSONObject) (obj1));
        aee1;
        if (obj != null)
        {
            zw.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(((HttpRequest) (obj)).b("X-REQUEST-ID")).toString());
        }
        throw aee1;
    }

    JSONObject a(HttpRequest httprequest)
    {
        int i = httprequest.b();
        zw.h().a("Fabric", (new StringBuilder()).append("Settings result was: ").append(i).toString());
        if (a(i))
        {
            return a(httprequest.e());
        } else
        {
            zw.h().e("Fabric", (new StringBuilder()).append("Failed to retrieve settings from ").append(getUrl()).toString());
            return null;
        }
    }

    boolean a(int i)
    {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }
}
