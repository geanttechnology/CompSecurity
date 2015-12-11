// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;

import com.rdio.android.core.util.Logging;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubConnection

private final class socketThread
    implements Runnable
{

    private volatile boolean keepRunning;
    private OutputStream outgoing;
    private int port;
    private Socket socket;
    private Thread socketThread;
    final PubSubConnection this$0;
    private String url;

    public final void close()
    {
        PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", "Asking socket to close");
        try
        {
            keepRunning = false;
            if (socketThread != null && socketThread.isAlive())
            {
                closeSocket(socket, PubSubConnection.access$000(PubSubConnection.this));
                closeStream(outgoing, PubSubConnection.access$000(PubSubConnection.this));
                outgoing = null;
                socket = null;
                socketThread.interrupt();
                PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", "Stopping socket thread");
            }
            return;
        }
        catch (Throwable throwable)
        {
            PubSubConnection.access$000(PubSubConnection.this).log(6, "PubSubConnection", "Error disconnecting socket");
            PubSubConnection.access$000(PubSubConnection.this).logException(throwable, false);
            return;
        }
    }

    public final boolean isConnected()
    {
        return keepRunning && outgoing != null;
    }

    public final void run()
    {
        PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", "Socket thread started");
        InputStream inputstream1;
        socket = new Socket(url, port);
        inputstream1 = socket.getInputStream();
        InputStream inputstream = inputstream1;
        outgoing = socket.getOutputStream();
        inputstream = inputstream1;
        PubSubConnection.access$1000(PubSubConnection.this);
        inputstream = inputstream1;
        Object obj1 = new ByteArrayOutputStream(8096);
        inputstream = inputstream1;
        byte abyte0[] = new byte[8096];
_L16:
        inputstream = inputstream1;
        if (!keepRunning) goto _L2; else goto _L1
_L1:
        inputstream = inputstream1;
        int l = inputstream1.read(abyte0, 0, 8096);
        if (l != -1) goto _L4; else goto _L3
_L3:
        inputstream = inputstream1;
        PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", "Socket end of stream");
_L2:
        keepRunning = false;
        PubSubConnection.access$900(PubSubConnection.this);
        closeStream(inputstream1, PubSubConnection.access$000(PubSubConnection.this));
        closeStream(outgoing, PubSubConnection.access$000(PubSubConnection.this));
        outgoing = null;
        closeSocket(socket, PubSubConnection.access$000(PubSubConnection.this));
_L14:
        PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", "Socket thread ended");
        return;
_L4:
        int j;
        int k;
        j = 0;
        k = 0;
_L20:
        if (j >= l) goto _L6; else goto _L5
_L5:
        if (abyte0[j] != 0) goto _L8; else goto _L7
_L7:
        inputstream = inputstream1;
        ((ByteArrayOutputStream) (obj1)).reset();
        int i = j + 1;
          goto _L9
_L8:
        i = k;
        if (abyte0[j] != -1) goto _L9; else goto _L10
_L10:
        if (j - k <= 0)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        inputstream = inputstream1;
        ((ByteArrayOutputStream) (obj1)).write(abyte0, k, j - k);
        inputstream = inputstream1;
        byte abyte1[] = ((ByteArrayOutputStream) (obj1)).toByteArray();
        inputstream = inputstream1;
        if (abyte1.length != 0) goto _L12; else goto _L11
_L11:
        inputstream = inputstream1;
        PubSubConnection.access$000(PubSubConnection.this).log(6, "PubSubConnection", "Badly framed message. No starting 0x00.");
_L13:
        inputstream = inputstream1;
        ((ByteArrayOutputStream) (obj1)).reset();
        i = j + 2;
        break; /* Loop/switch isn't completed */
_L12:
        inputstream = inputstream1;
        PubSubConnection.access$1100(PubSubConnection.this, new String(abyte1));
        if (true) goto _L13; else goto _L9
        obj1;
_L19:
        inputstream = inputstream1;
        PubSubConnection.access$000(PubSubConnection.this).log(5, "PubSubConnection", (new StringBuilder("Socket failed.")).append(obj1).toString());
        keepRunning = false;
        PubSubConnection.access$900(PubSubConnection.this);
        closeStream(inputstream1, PubSubConnection.access$000(PubSubConnection.this));
        closeStream(outgoing, PubSubConnection.access$000(PubSubConnection.this));
        outgoing = null;
        closeSocket(socket, PubSubConnection.access$000(PubSubConnection.this));
          goto _L14
_L6:
        if (k >= l) goto _L16; else goto _L15
_L15:
        inputstream = inputstream1;
        ((ByteArrayOutputStream) (obj1)).write(abyte0, k, l - k);
          goto _L16
        obj1;
        Object obj;
        inputstream1 = inputstream;
        obj = obj1;
_L18:
        keepRunning = false;
        PubSubConnection.access$900(PubSubConnection.this);
        closeStream(inputstream1, PubSubConnection.access$000(PubSubConnection.this));
        closeStream(outgoing, PubSubConnection.access$000(PubSubConnection.this));
        outgoing = null;
        closeSocket(socket, PubSubConnection.access$000(PubSubConnection.this));
        throw obj;
        obj;
        inputstream1 = null;
        if (true) goto _L18; else goto _L17
_L17:
        obj1;
        inputstream1 = null;
          goto _L19
_L9:
        j++;
        k = i;
          goto _L20
    }

    public final void send(String s)
    {
        try
        {
            if (outgoing != null)
            {
                PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", (new StringBuilder("Sending '")).append(s).append("'").toString());
                outgoing.write(0);
                outgoing.write(s.getBytes("utf8"));
                outgoing.write(255);
                outgoing.flush();
            }
            return;
        }
        catch (Exception exception)
        {
            PubSubConnection.access$000(PubSubConnection.this).log(5, "PubSubConnection", (new StringBuilder("Error sending '")).append(s).append("'").toString());
        }
        PubSubConnection.access$900(PubSubConnection.this);
    }

    protected (String s, int i)
    {
        this$0 = PubSubConnection.this;
        super();
        PubSubConnection.access$000(PubSubConnection.this).log(3, "PubSubConnection", (new StringBuilder("Creating socket for ")).append(s).append(":").append(i).toString());
        url = s;
        port = i;
        keepRunning = true;
        socketThread = new Thread(this, "PubSub");
        socketThread.start();
    }
}
