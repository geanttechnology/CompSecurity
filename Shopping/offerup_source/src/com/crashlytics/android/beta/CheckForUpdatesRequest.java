// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import c.a.a.a.a.b.a;
import c.a.a.a.a.e.c;
import c.a.a.a.a.e.d;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.crashlytics.android.beta:
//            BuildProperties, CheckForUpdatesResponseTransform, CheckForUpdatesResponse

class CheckForUpdatesRequest extends a
{

    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String INSTANCE = "instance";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    public CheckForUpdatesRequest(n n1, String s, String s1, c.a.a.a.a.e.a a1, CheckForUpdatesResponseTransform checkforupdatesresponsetransform)
    {
        super(n1, s, s1, a1, c.a);
        responseTransform = checkforupdatesresponsetransform;
    }

    private d applyHeadersTo(d d1, String s, String s1)
    {
        return d1.a("Accept", "application/json").a("User-Agent", (new StringBuilder("Crashlytics Android SDK/")).append(kit.getVersion()).toString()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("X-CRASHLYTICS-API-KEY", s).a("X-CRASHLYTICS-D", s1);
    }

    private Map getQueryParamsFor(BuildProperties buildproperties)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("build_version", buildproperties.versionCode);
        hashmap.put("display_version", buildproperties.versionName);
        hashmap.put("instance", buildproperties.buildId);
        hashmap.put("source", "3");
        return hashmap;
    }

    public CheckForUpdatesResponse invoke(String s, String s1, BuildProperties buildproperties)
    {
        Object obj1 = null;
        d d1;
        Map map;
        map = getQueryParamsFor(buildproperties);
        d1 = getHttpRequest(map);
        Object obj;
        buildproperties = d1;
        obj = d1;
        s = applyHeadersTo(d1, s, s1);
        buildproperties = s;
        obj = s;
        e.d().a("Beta", (new StringBuilder("Checking for updates from ")).append(getUrl()).toString());
        buildproperties = s;
        obj = s;
        e.d().a("Beta", (new StringBuilder("Checking for updates query params are: ")).append(map).toString());
        buildproperties = s;
        obj = s;
        boolean flag;
        if (200 == s.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        buildproperties = s;
        obj = s;
        e.d().a("Beta", "Checking for updates was successful");
        buildproperties = s;
        obj = s;
        s1 = new JSONObject(s.c());
        buildproperties = s;
        obj = s;
        s1 = responseTransform.fromJson(s1);
        buildproperties = s1;
        if (s != null)
        {
            s = s.a("X-REQUEST-ID");
            e.d().a("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
            buildproperties = s1;
        }
_L4:
        return buildproperties;
_L2:
        buildproperties = s;
        obj = s;
        e.d().e("Beta", (new StringBuilder("Checking for updates failed. Response code: ")).append(s.b()).toString());
        buildproperties = obj1;
        if (s == null) goto _L4; else goto _L3
_L3:
        s = s.a("X-REQUEST-ID");
        e.d().a("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
        return null;
        s;
        obj = null;
_L8:
        buildproperties = ((BuildProperties) (obj));
        e.d().c("Beta", (new StringBuilder("Error while checking for updates from ")).append(getUrl()).toString(), s);
        buildproperties = obj1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        s = ((d) (obj)).a("X-REQUEST-ID");
        e.d().a("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
        return null;
        s;
        buildproperties = null;
_L7:
        if (buildproperties != null)
        {
            s1 = buildproperties.a("X-REQUEST-ID");
            e.d().a("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s1).toString());
        }
        throw s;
        s;
        if (true) goto _L7; else goto _L6
_L6:
        s;
          goto _L8
    }
}
