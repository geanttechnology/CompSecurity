// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            ConnectTimeoutException

public final class MultihomePlainSocketFactory
    implements SocketFactory
{

    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    private MultihomePlainSocketFactory()
    {
    }

    public static MultihomePlainSocketFactory getSocketFactory()
    {
        return DEFAULT_FACTORY;
    }

    public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(s, "Target host");
        Args.notNull(httpparams, "HTTP parameters");
        Socket socket1 = socket;
        socket = socket1;
        if (socket1 == null)
        {
            socket = createSocket();
        }
        if (inetaddress != null || j > 0)
        {
            if (j <= 0)
            {
                j = 0;
            }
            socket.bind(new InetSocketAddress(inetaddress, j));
        }
        j = HttpConnectionParams.getConnectionTimeout(httpparams);
        inetaddress = InetAddress.getAllByName(s);
        s = new ArrayList(inetaddress.length);
        s.addAll(Arrays.asList(inetaddress));
        Collections.shuffle(s);
        inetaddress = null;
        httpparams = s.iterator();
        s = socket;
        socket = inetaddress;
_L2:
        if (!httpparams.hasNext())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        inetaddress = (InetAddress)httpparams.next();
        s.connect(new InetSocketAddress(inetaddress, i), j);
        if (socket != null)
        {
            throw socket;
        } else
        {
            return s;
        }
        socket;
        throw new ConnectTimeoutException((new StringBuilder()).append("Connect to ").append(inetaddress).append(" timed out").toString());
        socket;
        s = new Socket();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Socket createSocket()
    {
        return new Socket();
    }

    public final boolean isSecure(Socket socket)
        throws IllegalArgumentException
    {
        Args.notNull(socket, "Socket");
        boolean flag;
        if (!socket.isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Socket is closed");
        return false;
    }

}
