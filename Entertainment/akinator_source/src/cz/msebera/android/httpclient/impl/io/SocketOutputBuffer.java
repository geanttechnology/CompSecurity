// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractSessionOutputBuffer

public class SocketOutputBuffer extends AbstractSessionOutputBuffer
{

    public SocketOutputBuffer(Socket socket, int i, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(socket, "Socket");
        int j = i;
        i = j;
        if (j < 0)
        {
            i = socket.getSendBufferSize();
        }
        j = i;
        if (i < 1024)
        {
            j = 1024;
        }
        init(socket.getOutputStream(), j, httpparams);
    }
}
