// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth.params;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.nio.charset.Charset;

public final class AuthParams
{

    private AuthParams()
    {
    }

    public static String getCredentialCharset(HttpParams httpparams)
    {
        Args.notNull(httpparams, "HTTP parameters");
        String s = (String)httpparams.getParameter("http.auth.credential-charset");
        httpparams = s;
        if (s == null)
        {
            httpparams = HTTP.DEF_PROTOCOL_CHARSET.name();
        }
        return httpparams;
    }

    public static void setCredentialCharset(HttpParams httpparams, String s)
    {
        Args.notNull(httpparams, "HTTP parameters");
        httpparams.setParameter("http.auth.credential-charset", s);
    }
}
