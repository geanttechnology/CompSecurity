// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.Map;

// Referenced classes of package com.amazon.android.webkit:
//            ProxyInfo

public abstract class AmazonUrlRequestHandler
{

    public AmazonUrlRequestHandler()
    {
    }

    public abstract Map getExtraHeaders();

    public ProxyInfo getHttpProxy(String s)
    {
        return getHttpProxy(null, s, null);
    }

    public abstract ProxyInfo getHttpProxy(String s, String s1, Map map);

    public abstract String getUserAgent(String s);
}
