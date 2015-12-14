// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.net.Socket;

// Referenced classes of package org.apache.commons.httpclient:
//            ProxyClient, ConnectMethod

public static class <init>
{

    private ConnectMethod connectMethod;
    private Socket socket;

    private void setConnectMethod(ConnectMethod connectmethod)
    {
        connectMethod = connectmethod;
    }

    private void setSocket(Socket socket1)
    {
        socket = socket1;
    }

    public ConnectMethod getConnectMethod()
    {
        return connectMethod;
    }

    public Socket getSocket()
    {
        return socket;
    }



    private ()
    {
    }

    ( )
    {
        this();
    }
}
