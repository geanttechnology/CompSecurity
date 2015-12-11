// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDnsResolver
    implements DnsResolver
{

    private final Map dnsMap = new ConcurrentHashMap();
    public HttpClientAndroidLog log;

    public InMemoryDnsResolver()
    {
        log = new HttpClientAndroidLog(cz/msebera/android/httpclient/impl/conn/InMemoryDnsResolver);
    }

    public transient void add(String s, InetAddress ainetaddress[])
    {
        Args.notNull(s, "Host name");
        Args.notNull(ainetaddress, "Array of IP addresses");
        dnsMap.put(s, ainetaddress);
    }

    public InetAddress[] resolve(String s)
        throws UnknownHostException
    {
        InetAddress ainetaddress[] = (InetAddress[])dnsMap.get(s);
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("Resolving ").append(s).append(" to ").append(Arrays.deepToString(ainetaddress)).toString());
        }
        if (ainetaddress == null)
        {
            throw new UnknownHostException((new StringBuilder()).append(s).append(" cannot be resolved").toString());
        } else
        {
            return ainetaddress;
        }
    }
}
