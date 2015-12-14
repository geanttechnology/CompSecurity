// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.crashlytics.android.beta:
//            BuildProperties, CheckForUpdatesResponseTransform, CheckForUpdatesResponse

class CheckForUpdatesRequest extends AbstractSpiCall
{

    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String INSTANCE = "instance";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    public CheckForUpdatesRequest(Kit kit, String s, String s1, HttpRequestFactory httprequestfactory, CheckForUpdatesResponseTransform checkforupdatesresponsetransform)
    {
        super(kit, s, s1, httprequestfactory, HttpMethod.GET);
        responseTransform = checkforupdatesresponsetransform;
    }

    private HttpRequest applyHeadersTo(HttpRequest httprequest, String s, String s1)
    {
        return httprequest.header("Accept", "application/json").header("User-Agent", (new StringBuilder()).append("Crashlytics Android SDK/").append(kit.getVersion()).toString()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).header("X-CRASHLYTICS-API-KEY", s).header("X-CRASHLYTICS-D", s1);
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
        HttpRequest httprequest;
        Map map;
        map = getQueryParamsFor(buildproperties);
        httprequest = getHttpRequest(map);
        Object obj;
        buildproperties = httprequest;
        obj = httprequest;
        s = applyHeadersTo(httprequest, s, s1);
        buildproperties = s;
        obj = s;
        Fabric.getLogger().d("Beta", (new StringBuilder()).append("Checking for updates from ").append(getUrl()).toString());
        buildproperties = s;
        obj = s;
        Fabric.getLogger().d("Beta", (new StringBuilder()).append("Checking for updates query params are: ").append(map).toString());
        buildproperties = s;
        obj = s;
        if (!s.ok()) goto _L2; else goto _L1
_L1:
        buildproperties = s;
        obj = s;
        Fabric.getLogger().d("Beta", "Checking for updates was successful");
        buildproperties = s;
        obj = s;
        s1 = new JSONObject(s.body());
        buildproperties = s;
        obj = s;
        s1 = responseTransform.fromJson(s1);
        buildproperties = s1;
        if (s != null)
        {
            s = s.header("X-REQUEST-ID");
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Checking for updates request ID: ").append(s).toString());
            buildproperties = s1;
        }
_L4:
        return buildproperties;
_L2:
        buildproperties = s;
        obj = s;
        Fabric.getLogger().e("Beta", (new StringBuilder()).append("Checking for updates failed. Response code: ").append(s.code()).toString());
        buildproperties = obj1;
        if (s == null) goto _L4; else goto _L3
_L3:
        s = s.header("X-REQUEST-ID");
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Checking for updates request ID: ").append(s).toString());
        return null;
        s;
        obj = null;
_L8:
        buildproperties = ((BuildProperties) (obj));
        Fabric.getLogger().e("Beta", (new StringBuilder()).append("Error while checking for updates from ").append(getUrl()).toString(), s);
        buildproperties = obj1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        s = ((HttpRequest) (obj)).header("X-REQUEST-ID");
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Checking for updates request ID: ").append(s).toString());
        return null;
        s;
        buildproperties = null;
_L7:
        if (buildproperties != null)
        {
            s1 = buildproperties.header("X-REQUEST-ID");
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Checking for updates request ID: ").append(s1).toString());
        }
        throw s;
        s;
        if (true) goto _L7; else goto _L6
_L6:
        s;
          goto _L8
    }
}
