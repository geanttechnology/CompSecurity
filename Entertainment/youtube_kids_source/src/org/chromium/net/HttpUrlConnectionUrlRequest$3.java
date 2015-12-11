// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


// Referenced classes of package org.chromium.net:
//            HttpUrlConnectionUrlRequest

class a
    implements Runnable
{

    private HttpUrlConnectionUrlRequest a;

    public void run()
    {
        HttpUrlConnectionUrlRequest.b(a);
    }

    (HttpUrlConnectionUrlRequest httpurlconnectionurlrequest)
    {
        a = httpurlconnectionurlrequest;
        super();
    }
}
