// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.internal.http;

import android.util.Log;
import co.vine.android.util.BuildUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

// Referenced classes of package twitter4j.internal.http:
//            HttpClient, HttpClientConfiguration

public abstract class HttpClientBase
    implements HttpClient, Serializable
{

    private static final boolean LOGGABLE = BuildUtil.isLogsOn();
    private static final String TAG = "t4jHttpClientBase";
    private static final long serialVersionUID = 0x60615468668a4591L;
    protected final HttpClientConfiguration CONF;

    public HttpClientBase(HttpClientConfiguration httpclientconfiguration)
    {
        CONF = httpclientconfiguration;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof HttpClientBase))
            {
                return false;
            }
            obj = (HttpClientBase)obj;
            if (!CONF.equals(((HttpClientBase) (obj)).CONF))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return CONF.hashCode();
    }

    protected boolean isProxyConfigured()
    {
        return CONF.getHttpProxyHost() != null && !CONF.getHttpProxyHost().equals("");
    }

    public void shutdown()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("HttpClientBase{CONF=").append(CONF).append('}').toString();
    }

    public void write(DataOutputStream dataoutputstream, String s)
        throws IOException
    {
        dataoutputstream.writeBytes(s);
        if (LOGGABLE)
        {
            Log.v("t4jHttpClientBase", s);
        }
    }

}
