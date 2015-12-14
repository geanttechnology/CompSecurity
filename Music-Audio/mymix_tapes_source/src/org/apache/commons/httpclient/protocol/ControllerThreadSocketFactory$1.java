// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            ProtocolSocketFactory

class val.localPort extends cketTask
{

    private final String val$host;
    private final InetAddress val$localAddress;
    private final int val$localPort;
    private final int val$port;
    private final ProtocolSocketFactory val$socketfactory;

    public void doit()
        throws IOException
    {
        setSocket(val$socketfactory.createSocket(val$host, val$port, val$localAddress, val$localPort));
    }

    cketTask()
        throws IOException
    {
        val$socketfactory = protocolsocketfactory;
        val$host = s;
        val$port = i;
        val$localAddress = inetaddress;
        val$localPort = j;
    }
}
