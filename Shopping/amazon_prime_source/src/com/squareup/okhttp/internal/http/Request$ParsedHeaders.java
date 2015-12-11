// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;


// Referenced classes of package com.squareup.okhttp.internal.http:
//            Request, Headers

private static class proxyAuthorization
{

    private String proxyAuthorization;
    private String userAgent;



    public (Headers headers)
    {
        int i = 0;
        while (i < headers.size()) 
        {
            String s = headers.name(i);
            String s1 = headers.value(i);
            if ("User-Agent".equalsIgnoreCase(s))
            {
                userAgent = s1;
            } else
            if ("Proxy-Authorization".equalsIgnoreCase(s))
            {
                proxyAuthorization = s1;
            }
            i++;
        }
    }
}
