// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.android.webkit:
//            ProxyInfo

public class AmazonUrlRequest
{

    private byte body[];
    private Map extraHeaders;
    private final Map headers;
    private boolean isFailoverDisabled;
    private final boolean isMainFrame;
    private final boolean isPrerender;
    private final String method;
    private ProxyInfo proxyInfo;
    private final String url;
    private String userAgent;

    public AmazonUrlRequest(String s, String s1, Map map, boolean flag, boolean flag1)
    {
        url = s;
        method = s1;
        headers = Collections.unmodifiableMap(map);
        isMainFrame = flag;
        isPrerender = flag1;
        extraHeaders = new HashMap();
    }

    public AmazonUrlRequest(String s, String s1, Map map, byte abyte0[])
    {
        this(s, s1, map, false, false);
        body = abyte0;
    }

    public void addExtraHeaders(Map map)
    {
        extraHeaders.putAll(map);
    }

    public byte[] getBody()
    {
        return body;
    }

    public Map getExtraHeaders()
    {
        return Collections.unmodifiableMap(extraHeaders);
    }

    public Map getHeaders()
    {
        return headers;
    }

    public String getHttpMethod()
    {
        return method;
    }

    public ProxyInfo getProxyInfo()
    {
        return proxyInfo;
    }

    public String getUrl()
    {
        return url;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public boolean isFailoverDisabled()
    {
        return isFailoverDisabled;
    }

    public boolean isMainFrame()
    {
        return isMainFrame;
    }

    public boolean isPrerender()
    {
        return isPrerender;
    }

    public void setFailoverDisabled(boolean flag)
    {
        isFailoverDisabled = flag;
    }

    public void setProxyInfo(ProxyInfo proxyinfo)
    {
        proxyInfo = proxyinfo;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }
}
