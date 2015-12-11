// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Base64;
import java.util.Arrays;
import java.util.List;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.ProtocolException;
import org.apache.http.RequestLine;
import org.apache.http.protocol.HttpContext;

public final class cwa
    implements HttpRequestInterceptor
{

    private static List a = Arrays.asList(new String[] {
        "dnc", "cpn", "proxy-auth"
    });
    private final Mac b = Mac.getInstance("HmacSHA1");

    public cwa()
    {
        javax.crypto.SecretKey secretkey = KeyGenerator.getInstance("HmacSHA1").generateKey();
        b.init(secretkey);
    }

    private String a(Uri uri)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        if (uri.getEncodedPath() != null)
        {
            b.update(uri.getEncodedPath().getBytes());
        }
        if (uri.getEncodedQuery() == null) goto _L2; else goto _L1
_L1:
        int j;
        uri = uri.getEncodedQuery().split("&");
        j = uri.length;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        String s = uri[i];
        if (!a.contains(s.split("=")[0]))
        {
            b.update(s.getBytes());
        }
          goto _L4
_L2:
        uri = Base64.encodeToString(b.doFinal(), 0);
        this;
        JVM INSTR monitorexit ;
        return uri;
        uri;
        throw uri;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        httprequest = Uri.parse(httprequest.getRequestLine().getUri());
        httpcontext = httprequest.getQueryParameter("proxy-auth");
        boolean flag;
        if (httpcontext != null)
        {
            flag = a(httprequest).equals(httpcontext);
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new ProtocolException("The URL is not signed correctly");
        } else
        {
            return;
        }
    }

}
