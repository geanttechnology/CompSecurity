// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ami, apr, aoj, apq, 
//            aok, alz, alt, amc, 
//            amq, aol

class apf extends ami
    implements apr
{

    public apf(alz alz1, String s, String s1, aol aol)
    {
        this(alz1, s, s1, aol, aoj.a);
    }

    apf(alz alz1, String s, String s1, aol aol, aoj aoj1)
    {
        super(alz1, s, s1, aol, aoj1);
    }

    private aok a(aok aok1, apq apq1)
    {
        return aok1.a("X-CRASHLYTICS-API-KEY", apq1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-D", apq1.b).a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("Accept", "application/json");
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
            alt.h().a("Fabric", (new StringBuilder()).append("Failed to parse settings JSON from ").append(getUrl()).toString(), exception);
            alt.h().a("Fabric", (new StringBuilder()).append("Settings response ").append(s).toString());
            return null;
        }
        return jsonobject;
    }

    private Map b(apq apq1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("build_version", apq1.e);
        hashmap.put("display_version", apq1.d);
        hashmap.put("source", Integer.toString(apq1.f));
        if (apq1.g != null)
        {
            hashmap.put("icon_hash", apq1.g);
        }
        apq1 = apq1.c;
        if (!amq.c(apq1))
        {
            hashmap.put("instance", apq1);
        }
        return hashmap;
    }

    JSONObject a(aok aok1)
    {
        int i = aok1.b();
        alt.h().a("Fabric", (new StringBuilder()).append("Settings result was: ").append(i).toString());
        if (a(i))
        {
            return a(aok1.e());
        } else
        {
            alt.h().e("Fabric", (new StringBuilder()).append("Failed to retrieve settings from ").append(getUrl()).toString());
            return null;
        }
    }

    public JSONObject a(apq apq1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        Map map = b(apq1);
        obj = obj1;
        obj1 = getHttpRequest(map);
        obj = obj1;
        apq1 = a(((aok) (obj1)), apq1);
        obj = apq1;
        alt.h().a("Fabric", (new StringBuilder()).append("Requesting settings from ").append(getUrl()).toString());
        obj = apq1;
        alt.h().a("Fabric", (new StringBuilder()).append("Settings query params were: ").append(map).toString());
        obj = apq1;
        obj1 = a(((aok) (apq1)));
        if (apq1 != null)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(apq1.b("X-REQUEST-ID")).toString());
        }
        return ((JSONObject) (obj1));
        apq1;
        if (obj != null)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("Settings request ID: ").append(((aok) (obj)).b("X-REQUEST-ID")).toString());
        }
        throw apq1;
    }

    boolean a(int i)
    {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }
}
