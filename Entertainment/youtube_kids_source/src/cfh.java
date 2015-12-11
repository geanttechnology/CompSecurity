// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class cfh
    implements cff
{

    private static String a = cfh.getCanonicalName();
    private final HttpClient b;
    private final XMLReader c;
    private final boolean d;

    private cfh(HttpClient httpclient, XMLReader xmlreader, boolean flag)
    {
        b = httpclient;
        c = null;
        d = flag;
    }

    public cfh(boolean flag)
    {
        this(a.A(), null, flag);
    }

    public final cfy a(Uri uri)
    {
        Object obj;
        cga cga1;
        cga1 = null;
        obj = new HttpGet(uri.toString());
        ((HttpGet) (obj)).setHeader("Origin", "package:com.google.android.youtube");
        HttpResponse httpresponse = b.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        obj = httpresponse;
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i != 404)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        obj = httpresponse;
        uri = new cfy(-1);
        a.a(httpresponse);
        return uri;
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj = httpresponse;
        uri = String.valueOf(uri);
        obj = httpresponse;
        bmo.b((new StringBuilder(String.valueOf(uri).length() + 57)).append("Request for app status from ").append(uri).append(" got response code").append(i).toString());
        obj = httpresponse;
        uri = new cfy(-2);
        a.a(httpresponse);
        return uri;
        obj = httpresponse;
        cfg cfg1 = new cfg();
        obj = httpresponse;
        uri = httpresponse.getEntity().getContent();
        obj = httpresponse;
        if (c == null) goto _L2; else goto _L1
_L1:
        obj = httpresponse;
        c.setContentHandler(cfg1);
        obj = httpresponse;
        uri = new InputSource(uri);
        obj = httpresponse;
        uri.setEncoding("UTF-8");
        obj = httpresponse;
        c.parse(uri);
_L4:
        obj = httpresponse;
        i = cfg1.e;
        if (i >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = httpresponse;
        uri = new cfy(-2);
        a.a(httpresponse);
        return uri;
_L2:
        obj = httpresponse;
        Xml.parse(uri, android.util.Xml.Encoding.UTF_8, cfg1);
        if (true) goto _L4; else goto _L3
        uri;
_L15:
        obj = httpresponse;
        Log.e(a, "Could not send the request to TV.", uri);
        a.a(httpresponse);
_L8:
        return new cfy(-2);
_L3:
        obj = httpresponse;
        if (!d) goto _L6; else goto _L5
_L5:
        obj = httpresponse;
        uri = a;
        uri = cga1;
_L7:
        obj = httpresponse;
        cga1 = new cga();
        obj = httpresponse;
        cga1.d = i;
        obj = httpresponse;
        cga1.a = cfg1.a;
        obj = httpresponse;
        cga1.b = cfg1.c;
        obj = httpresponse;
        cga1.c = uri;
        obj = httpresponse;
        cga1.e = cfg1.f;
        obj = httpresponse;
        cga1.f = cfg1.b;
        obj = httpresponse;
        cga1.g = cfg1.g;
        obj = httpresponse;
        uri = cga1.a();
        a.a(httpresponse);
        return uri;
_L6:
        obj = httpresponse;
        if (cfg1.d != null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        obj = httpresponse;
        uri = a;
        uri = cga1;
          goto _L7
        obj = httpresponse;
        uri = new cgr(cfg1.d);
          goto _L7
        uri;
_L13:
        obj = httpresponse;
        Log.e(a, "Illegal state exception.", uri);
        a.a(httpresponse);
          goto _L8
        uri;
        httpresponse = null;
_L12:
        obj = httpresponse;
        Log.e(a, "Sax exception", uri);
        a.a(httpresponse);
          goto _L8
        uri;
        httpresponse = null;
_L11:
        obj = httpresponse;
        Log.e(a, "Assertion error", uri);
        a.a(httpresponse);
          goto _L8
        uri;
        obj = null;
_L10:
        a.a(((HttpResponse) (obj)));
        throw uri;
        uri;
        if (true) goto _L10; else goto _L9
_L9:
        uri;
          goto _L11
        uri;
          goto _L12
        uri;
        httpresponse = null;
          goto _L13
        uri;
        httpresponse = null;
        if (true) goto _L15; else goto _L14
_L14:
    }

}
