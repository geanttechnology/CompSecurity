// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;

import com.rdio.android.core.util.Logging;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubConnection

private static class 
{

    public static void closeSocket(Socket socket, Logging logging)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
        return;
        socket;
        logging.log(6, "PubSubConnection", (new StringBuilder("Failed to close connection.")).append(socket.toString()).toString());
        logging.logException(socket, false);
        return;
    }

    public static void closeStream(InputStream inputstream, Logging logging)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
        logging.log(6, "PubSubConnection", (new StringBuilder("Error closing input stream ")).append(inputstream.toString()).toString());
        logging.logException(inputstream, false);
        return;
    }

    public static void closeStream(OutputStream outputstream, Logging logging)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        outputstream;
        logging.log(6, "PubSubConnection", (new StringBuilder("Error closing output stream ")).append(outputstream.toString()).toString());
        logging.logException(outputstream, false);
        return;
    }

    private ()
    {
    }
}
