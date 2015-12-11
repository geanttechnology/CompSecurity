// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import org.chromium.net.ExtendedResponseInfo;
import org.chromium.net.ResponseInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlRequestException;
import org.chromium.net.UrlRequestListener;

// Referenced classes of package org.chromium.net.urlconnection:
//            CronetHttpURLConnection, CronetInputStream, MessageLoop

class a
    implements UrlRequestListener
{

    private CronetHttpURLConnection a;

    private void a()
    {
        if (CronetHttpURLConnection.e(a) != null)
        {
            CronetHttpURLConnection.e(a).a = true;
        }
        CronetHttpURLConnection.a(a).b();
    }

    public final void a(ExtendedResponseInfo extendedresponseinfo)
    {
        CronetHttpURLConnection.a(a, extendedresponseinfo.a());
        a();
    }

    public final void a(ResponseInfo responseinfo)
    {
        CronetHttpURLConnection.a(a, responseinfo);
        CronetHttpURLConnection.a(a).b();
    }

    public final void a(ResponseInfo responseinfo, String s)
    {
        CronetHttpURLConnection.a(a, true);
        if (CronetHttpURLConnection.c(a))
        {
            try
            {
                CronetHttpURLConnection.a(a, new URL(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ResponseInfo responseinfo)
            {
                return;
            }
        } else
        {
            CronetHttpURLConnection.a(a, responseinfo);
            CronetHttpURLConnection.d(a).b();
            a();
            return;
        }
    }

    public final void a(ResponseInfo responseinfo, ByteBuffer bytebuffer)
    {
        CronetHttpURLConnection.a(a, responseinfo);
        CronetHttpURLConnection.a(a, ByteBuffer.allocate(bytebuffer.capacity()));
        CronetHttpURLConnection.b(a).put(bytebuffer);
        CronetHttpURLConnection.b(a).flip();
        CronetHttpURLConnection.a(a).b();
    }

    public final void a(ResponseInfo responseinfo, UrlRequestException urlrequestexception)
    {
        CronetHttpURLConnection.a(a, responseinfo);
        CronetHttpURLConnection.a(a, urlrequestexception);
        a();
    }

    public (CronetHttpURLConnection cronethttpurlconnection)
    {
        a = cronethttpurlconnection;
        super();
    }
}
