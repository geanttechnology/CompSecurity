// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.util.Log;

// Referenced classes of package org.chromium.net:
//            CronetUrlRequest, UrlRequestException, UrlRequestListener

class b
    implements Runnable
{

    private String a;
    private int b;
    private CronetUrlRequest c;

    public void run()
    {
        if (c.c())
        {
            return;
        }
        CronetUrlRequest.e(c);
        try
        {
            UrlRequestException urlrequestexception = new UrlRequestException((new StringBuilder("Exception in CronetUrlRequest: ")).append(a).toString(), b);
            UrlRequestListener urlrequestlistener = CronetUrlRequest.d(c);
            CronetUrlRequest croneturlrequest = c;
            urlrequestlistener.a(CronetUrlRequest.c(c), urlrequestexception);
            return;
        }
        catch (Exception exception)
        {
            Log.e("ChromiumNetwork", "Exception in onError method", exception);
        }
    }

    (CronetUrlRequest croneturlrequest, String s, int i)
    {
        c = croneturlrequest;
        a = s;
        b = i;
        super();
    }
}
