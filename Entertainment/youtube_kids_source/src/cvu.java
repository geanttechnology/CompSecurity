// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.security.Key;
import java.util.Locale;
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

final class cvu
    implements HttpRequestHandler
{

    private static final Pattern a = Pattern.compile("bytes=(\\d*)-(\\d*)");
    private final Key b;

    public cvu(Key key)
    {
        b = key;
    }

    public final void handle(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
    {
        boolean flag;
        flag = true;
        try
        {
            httpcontext = httprequest.getRequestLine().getMethod().toUpperCase();
            if (!httpcontext.equals("GET"))
            {
                throw new MethodNotSupportedException(String.valueOf(httpcontext).concat(" method is not supported."));
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            bmo.a("Internal error while handling a local file request", httprequest);
            throw new HttpException("Internal error while handling a local file request", httprequest);
        }
        httpcontext = new File(Uri.parse(httprequest.getRequestLine().getUri()).getQueryParameter("f"));
        if (httpcontext.exists())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        httprequest = String.valueOf(httpcontext.getAbsolutePath());
        if (httprequest.length() == 0)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        httprequest = "Requested file not found: ".concat(httprequest);
_L2:
        bmo.b(httprequest);
        httpresponse.setStatusCode(404);
        return;
        httprequest = new String("Requested file not found: ");
        if (true) goto _L2; else goto _L1
_L1:
        if (httpcontext.canRead())
        {
            break MISSING_BLOCK_LABEL_201;
        }
        httprequest = String.valueOf(httpcontext.getAbsolutePath());
        if (httprequest.length() == 0)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        httprequest = "Requested file cannot be read: ".concat(httprequest);
_L4:
        bmo.b(httprequest);
        httpresponse.setStatusCode(403);
        return;
        httprequest = new String("Requested file cannot be read: ");
        if (true) goto _L4; else goto _L3
_L3:
        long l1;
        httprequest = httprequest.getLastHeader("Range");
        l1 = httpcontext.length() - 1L;
        if (httprequest == null)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        String s;
        httprequest = a.matcher(httprequest.getValue());
        if (!httprequest.matches())
        {
            break MISSING_BLOCK_LABEL_505;
        }
        s = httprequest.group(1);
        if (TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        long l = Long.parseLong(s);
_L11:
        httprequest = httprequest.group(2);
        if (!TextUtils.isEmpty(httprequest))
        {
            l1 = Long.parseLong(httprequest);
        }
        if (l < 0L)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        long l2;
        long l3;
        if (l1 < httpcontext.length())
        {
            l2 = l;
            l3 = l1;
            if (l <= l1)
            {
                break MISSING_BLOCK_LABEL_364;
            }
        }
        bmo.b(String.format("Invalid range %d-%d requested, file size is %d", new Object[] {
            Long.valueOf(l), Long.valueOf(l1), Long.valueOf(httpcontext.length())
        }));
        httpresponse.setStatusCode(416);
        return;
_L12:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        httpresponse.setStatusCode(206);
        httprequest = String.format(Locale.US, "bytes %d-%d/%d", new Object[] {
            Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(httpcontext.length())
        });
        httpresponse.setHeader("Content-Range", httprequest);
        httprequest = String.valueOf(httprequest);
        if (httprequest.length() == 0) goto _L8; else goto _L7
_L7:
        httprequest = "Requested range: ".concat(httprequest);
_L9:
        bmo.e(httprequest);
_L10:
        httpresponse.setEntity(new cvs(httpcontext, "video/mp4", l2, l3, b));
        return;
_L8:
        httprequest = new String("Requested range: ");
          goto _L9
        httpresponse.setStatusCode(200);
          goto _L10
_L6:
        l = 0L;
          goto _L11
        flag = false;
        l2 = 0L;
        l3 = l1;
          goto _L12
    }

}
