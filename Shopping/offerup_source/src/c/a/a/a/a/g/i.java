// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.g;

import c.a.a.a.a.b.a;
import c.a.a.a.a.b.l;
import c.a.a.a.a.e.c;
import c.a.a.a.a.e.d;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package c.a.a.a.a.g:
//            v, u

final class i extends a
    implements v
{

    public i(n n1, String s, String s1, c.a.a.a.a.e.a a1)
    {
        this(n1, s, s1, a1, c.a);
    }

    private i(n n1, String s, String s1, c.a.a.a.a.e.a a1, int j)
    {
        super(n1, s, s1, a1, j);
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
            e.d().a("Fabric", (new StringBuilder("Failed to parse settings JSON from ")).append(getUrl()).toString(), exception);
            e.d().a("Fabric", (new StringBuilder("Settings response ")).append(s).toString());
            return null;
        }
        return jsonobject;
    }

    public final JSONObject a(u u1)
    {
        Object obj = null;
        d d2;
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put("build_version", u1.e);
        hashmap.put("display_version", u1.d);
        hashmap.put("source", Integer.toString(u1.f));
        if (u1.g != null)
        {
            hashmap.put("icon_hash", u1.g);
        }
        String s = u1.c;
        if (!l.c(s))
        {
            hashmap.put("instance", s);
        }
        d2 = getHttpRequest(hashmap);
        d d1 = d2;
        d2 = d2.a("X-CRASHLYTICS-API-KEY", u1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-D", u1.b).a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("Accept", "application/json");
        d1 = d2;
        e.d().a("Fabric", (new StringBuilder("Requesting settings from ")).append(getUrl()).toString());
        d1 = d2;
        e.d().a("Fabric", (new StringBuilder("Settings query params were: ")).append(hashmap).toString());
        d1 = d2;
        int j = d2.b();
        d1 = d2;
        e.d().a("Fabric", (new StringBuilder("Settings result was: ")).append(j).toString());
        if (j != 200 && j != 201 && j != 202 && j != 203)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        if (!j) goto _L2; else goto _L1
_L1:
        d1 = d2;
        u1 = a(d2.c());
_L4:
        if (d2 != null)
        {
            e.d().a("Fabric", (new StringBuilder("Settings request ID: ")).append(d2.a("X-REQUEST-ID")).toString());
        }
        return u1;
_L2:
        d1 = d2;
        e.d().e("Fabric", (new StringBuilder("Failed to retrieve settings from ")).append(getUrl()).toString());
        u1 = obj;
        if (true) goto _L4; else goto _L3
_L3:
        u1;
_L6:
        if (d1 != null)
        {
            e.d().a("Fabric", (new StringBuilder("Settings request ID: ")).append(d1.a("X-REQUEST-ID")).toString());
        }
        throw u1;
        u1;
        d1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
