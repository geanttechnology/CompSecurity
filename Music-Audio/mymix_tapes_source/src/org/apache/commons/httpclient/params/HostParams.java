// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.params;


// Referenced classes of package org.apache.commons.httpclient.params:
//            DefaultHttpParams, HttpParams

public class HostParams extends DefaultHttpParams
{

    public static final String DEFAULT_HEADERS = "http.default-headers";

    public HostParams()
    {
    }

    public HostParams(HttpParams httpparams)
    {
        super(httpparams);
    }

    public String getVirtualHost()
    {
        return (String)getParameter("http.virtual-host");
    }

    public void setVirtualHost(String s)
    {
        setParameter("http.virtual-host", s);
    }
}
