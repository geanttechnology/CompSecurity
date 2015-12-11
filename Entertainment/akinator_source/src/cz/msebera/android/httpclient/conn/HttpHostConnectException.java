// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;

public class HttpHostConnectException extends ConnectException
{

    private static final long serialVersionUID = 0xd3aaeae66ceb1d00L;
    private final HttpHost host;

    public HttpHostConnectException(HttpHost httphost, ConnectException connectexception)
    {
        this(((IOException) (connectexception)), httphost, null);
    }

    public transient HttpHostConnectException(IOException ioexception, HttpHost httphost, InetAddress ainetaddress[])
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("Connect to ");
        Object obj;
        if (httphost != null)
        {
            obj = httphost.toHostString();
        } else
        {
            obj = "remote host";
        }
        obj = stringbuilder.append(((String) (obj)));
        if (ainetaddress != null && ainetaddress.length > 0)
        {
            ainetaddress = (new StringBuilder()).append(" ").append(Arrays.asList(ainetaddress)).toString();
        } else
        {
            ainetaddress = "";
        }
        obj = ((StringBuilder) (obj)).append(ainetaddress);
        if (ioexception != null && ioexception.getMessage() != null)
        {
            ainetaddress = (new StringBuilder()).append(" failed: ").append(ioexception.getMessage()).toString();
        } else
        {
            ainetaddress = " refused";
        }
        super(((StringBuilder) (obj)).append(ainetaddress).toString());
        host = httphost;
        initCause(ioexception);
    }

    public HttpHost getHost()
    {
        return host;
    }
}
