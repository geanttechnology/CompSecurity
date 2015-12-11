// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import com.mopub.c.i;
import com.mopub.common.c.a;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.mopub.common:
//            m

public final class j
{

    public static HttpGet a(String s)
    {
        com.mopub.common.m.a(s);
        com.mopub.common.m.a(s);
        if (b(s))
        {
            throw new UnsupportedEncodingException((new StringBuilder("URL is improperly encoded: ")).append(s).toString());
        }
          goto _L1
        Exception exception;
        exception;
_L2:
        s = new HttpGet(s);
        String s1 = i.b();
        if (s1 != null)
        {
            s.addHeader(com.mopub.common.d.j.u.x, s1);
        }
        return s;
_L1:
        Object obj;
        if (!c(s))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        obj = d(s);
_L3:
        obj = ((URI) (obj)).toURL().toString();
        s = ((String) (obj));
          goto _L2
        obj = new URI(s);
          goto _L3
    }

    private static boolean b(String s)
    {
        try
        {
            URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            com.mopub.common.c.a.d((new StringBuilder("Url is improperly encoded: ")).append(s).toString());
            return true;
        }
        return false;
    }

    private static boolean c(String s)
    {
        try
        {
            new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return true;
        }
        return false;
    }

    private static URI d(String s)
    {
        Object obj;
        try
        {
            obj = new URL(s);
            obj = new URI(((URL) (obj)).getProtocol(), ((URL) (obj)).getUserInfo(), ((URL) (obj)).getHost(), ((URL) (obj)).getPort(), ((URL) (obj)).getPath(), ((URL) (obj)).getQuery(), ((URL) (obj)).getRef());
        }
        catch (Exception exception)
        {
            com.mopub.common.c.a.d((new StringBuilder("Failed to encode url: ")).append(s).toString());
            throw exception;
        }
        return ((URI) (obj));
    }
}
