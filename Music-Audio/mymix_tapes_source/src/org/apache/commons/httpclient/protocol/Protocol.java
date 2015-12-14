// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.util.LangUtils;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            SecureProtocolSocketFactory, DefaultProtocolSocketFactory, SSLProtocolSocketFactory, ProtocolSocketFactory

public class Protocol
{

    private static final Map PROTOCOLS = Collections.synchronizedMap(new HashMap());
    private int defaultPort;
    private String scheme;
    private boolean secure;
    private ProtocolSocketFactory socketFactory;

    public Protocol(String s, ProtocolSocketFactory protocolsocketfactory, int i)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("scheme is null");
        }
        if (protocolsocketfactory == null)
        {
            throw new IllegalArgumentException("socketFactory is null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException("port is invalid: " + i);
        } else
        {
            scheme = s;
            socketFactory = protocolsocketfactory;
            defaultPort = i;
            secure = protocolsocketfactory instanceof SecureProtocolSocketFactory;
            return;
        }
    }

    public Protocol(String s, SecureProtocolSocketFactory secureprotocolsocketfactory, int i)
    {
        this(s, ((ProtocolSocketFactory) (secureprotocolsocketfactory)), i);
    }

    public static Protocol getProtocol(String s)
        throws IllegalStateException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("id is null");
        }
        Protocol protocol1 = (Protocol)PROTOCOLS.get(s);
        Protocol protocol = protocol1;
        if (protocol1 == null)
        {
            protocol = lazyRegisterProtocol(s);
        }
        return protocol;
    }

    private static Protocol lazyRegisterProtocol(String s)
        throws IllegalStateException
    {
        if ("http".equals(s))
        {
            s = new Protocol("http", DefaultProtocolSocketFactory.getSocketFactory(), 80);
            registerProtocol("http", s);
            return s;
        }
        if ("https".equals(s))
        {
            s = new Protocol("https", SSLProtocolSocketFactory.getSocketFactory(), 443);
            registerProtocol("https", s);
            return s;
        } else
        {
            throw new IllegalStateException("unsupported protocol: '" + s + "'");
        }
    }

    public static void registerProtocol(String s, Protocol protocol)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("id is null");
        }
        if (protocol == null)
        {
            throw new IllegalArgumentException("protocol is null");
        } else
        {
            PROTOCOLS.put(s, protocol);
            return;
        }
    }

    public static void unregisterProtocol(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("id is null");
        } else
        {
            PROTOCOLS.remove(s);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Protocol)
        {
            obj = (Protocol)obj;
            flag = flag1;
            if (defaultPort == ((Protocol) (obj)).getDefaultPort())
            {
                flag = flag1;
                if (scheme.equalsIgnoreCase(((Protocol) (obj)).getScheme()))
                {
                    flag = flag1;
                    if (secure == ((Protocol) (obj)).isSecure())
                    {
                        flag = flag1;
                        if (socketFactory.equals(((Protocol) (obj)).getSocketFactory()))
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int getDefaultPort()
    {
        return defaultPort;
    }

    public String getScheme()
    {
        return scheme;
    }

    public ProtocolSocketFactory getSocketFactory()
    {
        return socketFactory;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, defaultPort), scheme.toLowerCase()), secure), socketFactory);
    }

    public boolean isSecure()
    {
        return secure;
    }

    public int resolvePort(int i)
    {
        int j = i;
        if (i <= 0)
        {
            j = getDefaultPort();
        }
        return j;
    }

    public String toString()
    {
        return scheme + ":" + defaultPort;
    }

}
