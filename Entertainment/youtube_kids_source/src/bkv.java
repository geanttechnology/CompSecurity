// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

class bkv
    implements SocketFactory
{

    private SocketFactory a;
    private bkt b;

    bkv(bkt bkt1, SocketFactory socketfactory)
    {
        b = bkt1;
        super();
        a = socketfactory;
    }

    public final Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
    {
        bkt.a(b).set(Boolean.TRUE);
        return a.connectSocket(socket, s, i, inetaddress, j, httpparams);
    }

    public final Socket createSocket()
    {
        return a.createSocket();
    }

    public final boolean isSecure(Socket socket)
    {
        return a.isSecure(socket);
    }
}
