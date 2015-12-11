// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import c.a.a.a.a.e.d;
import c.a.a.a.n;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package c.a.a.a.a.b:
//            l

public abstract class a
{

    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final int DEFAULT_TIMEOUT = 10000;
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_D = "X-CRASHLYTICS-D";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_DEVICE_STATE = "X-CRASHLYTICS-DEVICE-STATE";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final n kit;
    private final int method$6bc89afe;
    private final String protocolAndHostOverride;
    private final c.a.a.a.a.e.a requestFactory$6bbea658;
    private final String url;

    public a(n n1, String s, String s1, c.a.a.a.a.e.a a1, int i)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (a1 == null)
        {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else
        {
            kit = n1;
            protocolAndHostOverride = s;
            url = overrideProtocolAndHost(s1);
            requestFactory$6bbea658 = a1;
            method$6bc89afe = i;
            return;
        }
    }

    private String overrideProtocolAndHost(String s)
    {
        String s1 = s;
        if (!l.c(protocolAndHostOverride))
        {
            s1 = PROTOCOL_AND_HOST_PATTERN.matcher(s).replaceFirst(protocolAndHostOverride);
        }
        return s1;
    }

    protected d getHttpRequest()
    {
        return getHttpRequest(Collections.emptyMap());
    }

    protected d getHttpRequest(Map map)
    {
        map = requestFactory$6bbea658.a(method$6bc89afe, getUrl(), map);
        map.a().setUseCaches(false);
        map.a().setConnectTimeout(10000);
        return map.a("User-Agent", (new StringBuilder("Crashlytics Android SDK/")).append(kit.getVersion()).toString()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    protected String getUrl()
    {
        return url;
    }

}
