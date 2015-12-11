// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// Referenced classes of package cz.msebera.android.httpclient.conn.scheme:
//            SocketFactory

public interface LayeredSocketFactory
    extends SocketFactory
{

    public abstract Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException;
}
