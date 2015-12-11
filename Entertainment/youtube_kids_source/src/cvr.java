// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

public final class cvr
    implements HttpRequestHandler
{

    private final bjp a;
    private final cvl b;
    private final cvk c;

    public cvr(bjp bjp1, cvl cvl1, cvk cvk1)
    {
        a = bjp1;
        b = cvl1;
        c = cvk1;
    }

    public final void handle(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
    {
        httpcontext = httprequest.getRequestLine().getMethod();
        if ("GET".equalsIgnoreCase(httpcontext))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        httprequest = String.valueOf(httpcontext);
        if (httprequest.length() == 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        httprequest = "Method is not supported: ".concat(httprequest);
_L1:
        throw new MethodNotSupportedException(httprequest);
        try
        {
            httprequest = new String("Method is not supported: ");
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new HttpException("Internal error while handling an exo requset.", httprequest);
        }
          goto _L1
        Object obj;
        String s;
        String s1;
        Object obj1;
        long l2;
        obj1 = Uri.parse(httprequest.getRequestLine().getUri());
        httpcontext = ((Uri) (obj1)).getQueryParameter("id");
        s = Uri.decode(((Uri) (obj1)).getQueryParameter("s"));
        s1 = ((Uri) (obj1)).getQueryParameter("i");
        obj = ((Uri) (obj1)).getQueryParameter("l");
        obj1 = ((Uri) (obj1)).getQueryParameter("m");
        l2 = Long.parseLong(((String) (obj)));
        obj = httprequest.getLastHeader("Range");
        long l;
        long l1;
        long l3;
        l = 0L;
        l3 = l;
        l1 = l2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        httprequest = Pattern.compile("bytes=(\\d*)-(\\d*)").matcher(((Header) (obj)).getValue());
        l3 = l;
        l1 = l2;
        String s2;
        if (!httprequest.matches())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        s2 = httprequest.group(1);
        l1 = l2;
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        l = Long.parseLong(s2);
        l1 = l2 - l;
        httprequest = httprequest.group(2);
        l3 = l;
        if (TextUtils.isEmpty(httprequest))
        {
            break MISSING_BLOCK_LABEL_270;
        }
        l1 = Long.parseLong(httprequest);
        l1 = (l1 - l) + 1L;
        l3 = l;
        if (!TextUtils.isEmpty(httpcontext))
        {
            break MISSING_BLOCK_LABEL_340;
        }
        httpcontext = (art)a.b_();
        httprequest = new arx(Uri.parse(s), l3, l1, null);
_L2:
        httpresponse.setEntity(new cvq(httpcontext, httprequest, "video/mp4"));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        httpresponse.setStatusCode(200);
        return;
        httprequest = c.a(httpcontext, s1, ((String) (obj1)));
        httprequest = new arx(Uri.parse(s), l3, l1, httprequest);
        httpcontext = b.b();
          goto _L2
        httpresponse.setStatusCode(206);
        return;
        httprequest;
        httpresponse.setStatusCode(404);
        return;
    }
}
