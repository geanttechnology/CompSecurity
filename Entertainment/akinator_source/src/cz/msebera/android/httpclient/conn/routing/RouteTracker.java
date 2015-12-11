// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;

// Referenced classes of package cz.msebera.android.httpclient.conn.routing:
//            RouteInfo, HttpRoute

public final class RouteTracker
    implements RouteInfo, Cloneable
{

    private boolean connected;
    private RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private HttpHost proxyChain[];
    private boolean secure;
    private final HttpHost targetHost;
    private RouteInfo.TunnelType tunnelled;

    public RouteTracker(HttpHost httphost, InetAddress inetaddress)
    {
        Args.notNull(httphost, "Target host");
        targetHost = httphost;
        localAddress = inetaddress;
        tunnelled = RouteInfo.TunnelType.PLAIN;
        layered = RouteInfo.LayerType.PLAIN;
    }

    public RouteTracker(HttpRoute httproute)
    {
        this(httproute.getTargetHost(), httproute.getLocalAddress());
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public final void connectProxy(HttpHost httphost, boolean flag)
    {
        Args.notNull(httphost, "Proxy host");
        boolean flag1;
        if (!connected)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Asserts.check(flag1, "Already connected");
        connected = true;
        proxyChain = (new HttpHost[] {
            httphost
        });
        secure = flag;
    }

    public final void connectTarget(boolean flag)
    {
        boolean flag1;
        if (!connected)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Asserts.check(flag1, "Already connected");
        connected = true;
        secure = flag;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof RouteTracker))
            {
                return false;
            }
            obj = (RouteTracker)obj;
            if (connected != ((RouteTracker) (obj)).connected || secure != ((RouteTracker) (obj)).secure || tunnelled != ((RouteTracker) (obj)).tunnelled || layered != ((RouteTracker) (obj)).layered || !LangUtils.equals(targetHost, ((RouteTracker) (obj)).targetHost) || !LangUtils.equals(localAddress, ((RouteTracker) (obj)).localAddress) || !LangUtils.equals(proxyChain, ((RouteTracker) (obj)).proxyChain))
            {
                return false;
            }
        }
        return true;
    }

    public final int getHopCount()
    {
label0:
        {
            int i = 0;
            if (connected)
            {
                if (proxyChain != null)
                {
                    break label0;
                }
                i = 1;
            }
            return i;
        }
        return proxyChain.length + 1;
    }

    public final HttpHost getHopTarget(int i)
    {
        Args.notNegative(i, "Hop index");
        int j = getHopCount();
        boolean flag;
        if (i < j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Args.check(flag, "Hop index exceeds tracked route length");
        if (i < j - 1)
        {
            return proxyChain[i];
        } else
        {
            return targetHost;
        }
    }

    public final RouteInfo.LayerType getLayerType()
    {
        return layered;
    }

    public final InetAddress getLocalAddress()
    {
        return localAddress;
    }

    public final HttpHost getProxyHost()
    {
        if (proxyChain == null)
        {
            return null;
        } else
        {
            return proxyChain[0];
        }
    }

    public final HttpHost getTargetHost()
    {
        return targetHost;
    }

    public final RouteInfo.TunnelType getTunnelType()
    {
        return tunnelled;
    }

    public final int hashCode()
    {
        int i = LangUtils.hashCode(LangUtils.hashCode(17, targetHost), localAddress);
        int k = i;
        if (proxyChain != null)
        {
            HttpHost ahttphost[] = proxyChain;
            int l = ahttphost.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                i = LangUtils.hashCode(i, ahttphost[j]);
                j++;
            } while (true);
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(k, connected), secure), tunnelled), layered);
    }

    public final boolean isConnected()
    {
        return connected;
    }

    public final boolean isLayered()
    {
        return layered == RouteInfo.LayerType.LAYERED;
    }

    public final boolean isSecure()
    {
        return secure;
    }

    public final boolean isTunnelled()
    {
        return tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    public final void layerProtocol(boolean flag)
    {
        Asserts.check(connected, "No layered protocol unless connected");
        layered = RouteInfo.LayerType.LAYERED;
        secure = flag;
    }

    public void reset()
    {
        connected = false;
        proxyChain = null;
        tunnelled = RouteInfo.TunnelType.PLAIN;
        layered = RouteInfo.LayerType.PLAIN;
        secure = false;
    }

    public final HttpRoute toRoute()
    {
        if (!connected)
        {
            return null;
        } else
        {
            return new HttpRoute(targetHost, localAddress, proxyChain, secure, tunnelled, layered);
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(getHopCount() * 30 + 50);
        stringbuilder.append("RouteTracker[");
        if (localAddress != null)
        {
            stringbuilder.append(localAddress);
            stringbuilder.append("->");
        }
        stringbuilder.append('{');
        if (connected)
        {
            stringbuilder.append('c');
        }
        if (tunnelled == RouteInfo.TunnelType.TUNNELLED)
        {
            stringbuilder.append('t');
        }
        if (layered == RouteInfo.LayerType.LAYERED)
        {
            stringbuilder.append('l');
        }
        if (secure)
        {
            stringbuilder.append('s');
        }
        stringbuilder.append("}->");
        if (proxyChain != null)
        {
            HttpHost ahttphost[] = proxyChain;
            int j = ahttphost.length;
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(ahttphost[i]);
                stringbuilder.append("->");
            }

        }
        stringbuilder.append(targetHost);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public final void tunnelProxy(HttpHost httphost, boolean flag)
    {
        Args.notNull(httphost, "Proxy host");
        Asserts.check(connected, "No tunnel unless connected");
        Asserts.notNull(proxyChain, "No tunnel without proxy");
        HttpHost ahttphost[] = new HttpHost[proxyChain.length + 1];
        System.arraycopy(proxyChain, 0, ahttphost, 0, proxyChain.length);
        ahttphost[ahttphost.length - 1] = httphost;
        proxyChain = ahttphost;
        secure = flag;
    }

    public final void tunnelTarget(boolean flag)
    {
        Asserts.check(connected, "No tunnel unless connected");
        Asserts.notNull(proxyChain, "No tunnel without proxy");
        tunnelled = RouteInfo.TunnelType.TUNNELLED;
        secure = flag;
    }
}
