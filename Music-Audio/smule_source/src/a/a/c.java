// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package a.a:
//            b, en, eq, ds

public final class c extends SSLSocketFactory
{

    private SSLSocketFactory a;
    private eq b;
    private ds c;

    public c(SSLSocketFactory sslsocketfactory, eq eq, ds ds)
    {
        a = sslsocketfactory;
        b = eq;
        c = ds;
    }

    private Socket a(Socket socket)
    {
        Object obj = socket;
        if (socket != null)
        {
            obj = socket;
            try
            {
                if (socket instanceof SSLSocket)
                {
                    obj = new b((SSLSocket)socket, b, c);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw socket;
            }
            catch (Throwable throwable)
            {
                en.a(throwable);
                return socket;
            }
        }
        return ((Socket) (obj));
    }

    public final SSLSocketFactory a()
    {
        return a;
    }

    public final Socket createSocket()
    {
        return a(a.createSocket());
    }

    public final Socket createSocket(String s, int i)
    {
        return a(a.createSocket(s, i));
    }

    public final Socket createSocket(String s, int i, InetAddress inetaddress, int j)
    {
        return a(a.createSocket(s, i, inetaddress, j));
    }

    public final Socket createSocket(InetAddress inetaddress, int i)
    {
        return a(a.createSocket(inetaddress, i));
    }

    public final Socket createSocket(InetAddress inetaddress, int i, InetAddress inetaddress1, int j)
    {
        return a(a.createSocket(inetaddress, i, inetaddress1, j));
    }

    public final Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a(a.createSocket(socket, s, i, flag));
    }

    public final String[] getDefaultCipherSuites()
    {
        return a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites()
    {
        return a.getSupportedCipherSuites();
    }
}
