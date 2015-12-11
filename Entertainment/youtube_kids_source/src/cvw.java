// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.security.Key;
import java.util.List;
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

public final class cvw
    implements HttpRequestHandler
{

    private final Key a;
    private final bmi b;
    private final bjp c;
    private final cvk d;

    public cvw(Key key, bmi bmi1, bjp bjp1, cvk cvk1)
    {
        a = key;
        b = (bmi)b.a(bmi1);
        c = (bjp)b.a(bjp1);
        d = (cvk)b.a(cvk1);
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
            throw new HttpException("Internal error while handling an exo request.", httprequest);
        }
          goto _L1
        Object obj;
        Object obj1;
        long l2;
        obj1 = Uri.parse(httprequest.getRequestLine().getUri());
        httpcontext = ((Uri) (obj1)).getQueryParameter("v");
        obj = ((Uri) (obj1)).getQueryParameter("i");
        String s = ((Uri) (obj1)).getQueryParameter("l");
        String s1 = ((Uri) (obj1)).getQueryParameter("e");
        obj1 = ((Uri) (obj1)).getQueryParameter("m");
        l2 = Long.parseLong(s);
        if (Long.parseLong(s1) < b.b())
        {
            bmo.c("Offline URL has expired. Not allowed to access content.");
            httpresponse.setStatusCode(403);
            return;
        }
        Header header = httprequest.getLastHeader("Range");
        long l;
        long l1;
        long l3;
        l = 0L;
        l3 = l;
        l1 = l2;
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        httprequest = Pattern.compile("bytes=(\\d*)-(\\d*)").matcher(header.getValue());
        l3 = l;
        l1 = l2;
        String s2;
        if (!httprequest.matches())
        {
            break MISSING_BLOCK_LABEL_294;
        }
        s2 = httprequest.group(1);
        l1 = l2;
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_262;
        }
        l = Long.parseLong(s2);
        l1 = l2 - l;
        httprequest = httprequest.group(2);
        l3 = l;
        if (TextUtils.isEmpty(httprequest))
        {
            break MISSING_BLOCK_LABEL_294;
        }
        l1 = (Long.parseLong(httprequest) - l) + 1L;
        l3 = l;
        if (((List)c.b_()).isEmpty())
        {
            httpresponse.setStatusCode(404);
            return;
        }
        if (TextUtils.isEmpty(httpcontext))
        {
            break MISSING_BLOCK_LABEL_473;
        }
        obj = new arx(null, l3, l1, d.a(httpcontext, ((String) (obj)), ((String) (obj1))));
        httpcontext = new asb();
        httprequest = httpcontext;
        if (a != null)
        {
            httprequest = new atd(a.getEncoded(), httpcontext);
        }
        httpresponse.setEntity(new cvq(new cvv((List)c.b_(), httprequest), ((arx) (obj)), "video/mp4"));
        if (header != null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        httpresponse.setStatusCode(200);
        return;
        httprequest;
        bmo.a("Exception while trying to construct a offline data source.", httprequest);
        httpresponse.setStatusCode(500);
        return;
        httpresponse.setStatusCode(206);
        return;
        httpresponse.setStatusCode(404);
        return;
    }
}
