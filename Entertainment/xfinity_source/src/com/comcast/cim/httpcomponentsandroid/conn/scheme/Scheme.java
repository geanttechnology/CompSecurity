// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.scheme;

import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.util.Locale;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn.scheme:
//            LayeredSchemeSocketFactory, SchemeSocketFactoryAdaptor, LayeredSocketFactoryAdaptor, SocketFactoryAdaptor, 
//            SchemeSocketFactory, SocketFactory

public final class Scheme
{

    private final int defaultPort;
    private final boolean layered;
    private final String name;
    private final SchemeSocketFactory socketFactory;
    private String stringRep;

    public Scheme(String s, int i, SchemeSocketFactory schemesocketfactory)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Scheme name may not be null");
        }
        if (i <= 0 || i > 65535)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Port is invalid: ").append(i).toString());
        }
        if (schemesocketfactory == null)
        {
            throw new IllegalArgumentException("Socket factory may not be null");
        } else
        {
            name = s.toLowerCase(Locale.ENGLISH);
            socketFactory = schemesocketfactory;
            defaultPort = i;
            layered = schemesocketfactory instanceof LayeredSchemeSocketFactory;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof Scheme)
            {
                if (!name.equals(((Scheme) (obj = (Scheme)obj)).name) || defaultPort != ((Scheme) (obj)).defaultPort || layered != ((Scheme) (obj)).layered)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int getDefaultPort()
    {
        return defaultPort;
    }

    public final String getName()
    {
        return name;
    }

    public final SchemeSocketFactory getSchemeSocketFactory()
    {
        return socketFactory;
    }

    public final SocketFactory getSocketFactory()
    {
        if (socketFactory instanceof SchemeSocketFactoryAdaptor)
        {
            return ((SchemeSocketFactoryAdaptor)socketFactory).getFactory();
        }
        if (layered)
        {
            return new LayeredSocketFactoryAdaptor((LayeredSchemeSocketFactory)socketFactory);
        } else
        {
            return new SocketFactoryAdaptor(socketFactory);
        }
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, defaultPort), name), layered);
    }

    public final boolean isLayered()
    {
        return layered;
    }

    public final int resolvePort(int i)
    {
        int j = i;
        if (i <= 0)
        {
            j = defaultPort;
        }
        return j;
    }

    public final String toString()
    {
        if (stringRep == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(name);
            stringbuilder.append(':');
            stringbuilder.append(Integer.toString(defaultPort));
            stringRep = stringbuilder.toString();
        }
        return stringRep;
    }
}
