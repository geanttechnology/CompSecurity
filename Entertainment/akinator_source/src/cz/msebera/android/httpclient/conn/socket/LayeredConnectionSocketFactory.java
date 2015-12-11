// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// Referenced classes of package cz.msebera.android.httpclient.conn.socket:
//            ConnectionSocketFactory

public interface LayeredConnectionSocketFactory
    extends ConnectionSocketFactory
{

    public abstract Socket createLayeredSocket(Socket socket, String s, int i, HttpContext httpcontext)
        throws IOException, UnknownHostException;
}
