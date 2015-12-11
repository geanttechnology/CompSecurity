// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.net.HttpURLConnection;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpUrlConnectionHelper

private static final class I extends I
{

    public Map getAllHeaders()
    {
        return connection.getRequestProperties();
    }

    public String getLastHeader(String s)
    {
        return connection.getRequestProperty(s);
    }

    public void setHeader(String s, String s1)
    {
        connection.addRequestProperty(s, s1);
    }

    public I(HttpURLConnection httpurlconnection)
    {
        super(httpurlconnection);
    }
}
