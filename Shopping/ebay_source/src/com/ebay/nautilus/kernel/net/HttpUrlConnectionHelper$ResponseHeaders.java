// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.net.HttpURLConnection;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpUrlConnectionHelper

private static final class  extends 
{

    public Map getAllHeaders()
    {
        return connection.getHeaderFields();
    }

    public String getLastHeader(String s)
    {
        return connection.getHeaderField(s);
    }

    public void setHeader(String s, String s1)
    {
        throw new RuntimeException("Cannot set response headers!");
    }

    public (HttpURLConnection httpurlconnection)
    {
        super(httpurlconnection);
    }
}
