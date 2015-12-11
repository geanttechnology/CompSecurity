// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.util.Args;

public class DefaultSchemePortResolver
    implements SchemePortResolver
{

    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    public DefaultSchemePortResolver()
    {
    }

    public int resolve(HttpHost httphost)
        throws UnsupportedSchemeException
    {
        Args.notNull(httphost, "HTTP host");
        int i = httphost.getPort();
        if (i > 0)
        {
            return i;
        }
        httphost = httphost.getSchemeName();
        if (httphost.equalsIgnoreCase("http"))
        {
            return 80;
        }
        if (httphost.equalsIgnoreCase("https"))
        {
            return 443;
        } else
        {
            throw new UnsupportedSchemeException((new StringBuilder()).append(httphost).append(" protocol is not supported").toString());
        }
    }

}
