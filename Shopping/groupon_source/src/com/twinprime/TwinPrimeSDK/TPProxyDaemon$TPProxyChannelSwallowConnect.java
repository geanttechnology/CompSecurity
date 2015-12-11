// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPProxyDaemon, TPLog, TPControlChannelStateMachine, TPVTPManager, 
//            TPVTP

static class connectBuffer extends connectBuffer
{

    static final byte HEADERS[] = {
        72, 84, 84, 80, 47, 49, 46, 49, 32, 50, 
        48, 48, 32, 79, 75, 13, 10, 67, 111, 110, 
        110, 101, 99, 116, 105, 111, 110, 58, 32, 75, 
        101, 101, 112, 45, 65, 108, 105, 118, 101, 13, 
        10, 80, 114, 111, 120, 121, 45, 67, 111, 110, 
        110, 101, 99, 116, 105, 111, 110, 58, 32, 75, 
        101, 101, 112, 45, 65, 108, 105, 118, 101, 13, 
        10, 13, 10
    };
    private ByteBuffer connectBuffer;
    private boolean passThrough;

    private void appendStringToBuffer(connectBuffer connectbuffer, byte abyte0[])
    {
        ByteBuffer bytebuffer = ByteBuffer.allocate(abyte0.length);
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            Log.d("TPLocalProxy", (new StringBuilder()).append("Sending: ").append(abyte0).toString());
        }
        bytebuffer.put(abyte0);
        bytebuffer.flip();
        connectbuffer.connectBuffer(bytebuffer);
    }

    private boolean trySwallowConnect(SocketChannel socketchannel)
    {
        Charset charset = Charset.forName("ISO-8859-1");
        socketchannel.read(connectBuffer);
        connectBuffer.flip();
        socketchannel = charset.decode(connectBuffer).toString();
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            Log.d("TPLocalProxy", (new StringBuilder()).append("Received request: ").append(socketchannel).toString());
        }
        if (socketchannel.length() <= "CONNECT ".length() || !socketchannel.startsWith("CONNECT "))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        socketchannel = socketchannel.split(" ");
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            Log.d("TPLocalProxy", (new StringBuilder()).append("parsing request with ").append(socketchannel.length).append(" tokens").toString());
        }
        if (socketchannel.length < 2)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        socketchannel = socketchannel[1].split(":");
        if (socketchannel.length != 2)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            Log.d("TPLocalProxy", (new StringBuilder()).append("Received connect for server:").append(socketchannel[0]).append(" port: ").append(socketchannel[1]).toString());
        }
        if (vtp != null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        socketchannel = TPControlChannelStateMachine.getInstance().tpVtpManager.getVtpMapping(socketchannel[0], Short.parseShort(socketchannel[1]));
        if (socketchannel == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        setVtp(socketchannel);
        TPProxyDaemon.getInstance().connectVTP(socketchannel, this);
        return true;
        socketchannel;
        if (TPLog.LOG10.isLoggable("TPLocalProxy"))
        {
            socketchannel.printStackTrace();
        }
        return false;
    }

    public void read(SelectionKey selectionkey)
    {
        SelectionKey selectionkey1 = (SelectionKey)super.KeyRef.get();
        if (!passThrough && selectionkey1 != null && selectionkey1 == selectionkey)
        {
            if (trySwallowConnect((SocketChannel)selectionkey1.channel()))
            {
                passThrough = true;
                appendStringToBuffer(localWriteBuffer, HEADERS);
                selectionkey.interestOps(5);
            }
            return;
        } else
        {
            super.HEADERS(selectionkey);
            return;
        }
    }


    (SelectionKey selectionkey, SelectionKey selectionkey1, TPVTP tpvtp)
    {
        super(selectionkey, selectionkey1, tpvtp);
        passThrough = false;
        connectBuffer = ByteBuffer.allocate(2048);
    }
}
