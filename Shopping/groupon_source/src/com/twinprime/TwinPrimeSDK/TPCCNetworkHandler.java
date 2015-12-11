// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPRunnable, TPLog, TPControlChannelMessage

public class TPCCNetworkHandler
    implements TPRunnable
{

    static final boolean $assertionsDisabled;
    private final InetAddress accIPAddr;
    private final int accPort;
    private boolean isAlive;
    private int maxQueuedNetworkMessages;
    private int maxQueuedStateMachineMessages;
    private final Selector selector;
    private final SocketChannel socketChannel;
    private final SelectionKey socketChannelSelectionKey;
    private Queue tpccMessageQueue;
    private final LinkedBlockingQueue xcpMessageOutQueue;

    TPCCNetworkHandler(InetAddress inetaddress, int i, Queue queue)
        throws IOException
    {
        this(inetaddress, i, queue, null);
    }

    TPCCNetworkHandler(InetAddress inetaddress, int i, Queue queue, SocketChannel socketchannel)
        throws IOException
    {
        isAlive = true;
        maxQueuedNetworkMessages = 0;
        maxQueuedStateMachineMessages = 0;
        selector = Selector.open();
        accIPAddr = inetaddress;
        accPort = i;
        tpccMessageQueue = queue;
        xcpMessageOutQueue = new LinkedBlockingQueue(100);
        if (inetaddress == null)
        {
            throw new IOException();
        }
        if (TPLog.LOG13.isLoggable("TPCCNetworkHandler"))
        {
            Log.d("TPCCNetworkHandler", (new StringBuilder()).append("Attempting connection to accelerator: ").append(inetaddress).toString());
        }
        if (socketchannel == null)
        {
            socketchannel = SocketChannel.open();
        }
        socketChannel = socketchannel;
        socketChannel.configureBlocking(true);
        try
        {
            socketChannel.connect(new InetSocketAddress(inetaddress, i));
        }
        // Misplaced declaration of an exception variable
        catch (Queue queue)
        {
            inetaddress = new IOException((new StringBuilder()).append("Error during connect to ").append(inetaddress).toString());
            inetaddress.setStackTrace(queue.getStackTrace());
            throw inetaddress;
        }
        if (!socketChannel.finishConnect())
        {
            throw new IOException();
        }
        socketChannel.configureBlocking(false);
        socketChannelSelectionKey = socketChannel.register(selector, 1);
        if (TPLog.LOG13.isLoggable("TPCCNetworkHandler"))
        {
            Log.d("TPCCNetworkHandler", "TPCCNetworkHandler initialized");
        }
    }

    public boolean isAlive()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isAlive;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    void kill()
    {
        this;
        JVM INSTR monitorenter ;
        isAlive = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean queueMessage(ByteBuffer bytebuffer)
    {
        if (!isAlive || bytebuffer == null)
        {
            return false;
        }
        synchronized (xcpMessageOutQueue)
        {
            if (xcpMessageOutQueue.offer(bytebuffer))
            {
                break MISSING_BLOCK_LABEL_40;
            }
        }
        return false;
        bytebuffer;
        linkedblockingqueue;
        JVM INSTR monitorexit ;
        throw bytebuffer;
        int i = xcpMessageOutQueue.size();
        if (i > maxQueuedNetworkMessages)
        {
            maxQueuedNetworkMessages = i;
        }
        linkedblockingqueue;
        JVM INSTR monitorexit ;
        int j = socketChannelSelectionKey.interestOps();
        try
        {
            socketChannel.register(selector, j | 4);
            selector.wakeup();
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            sendTPMessage(2, null, "TPCCNetworkHandler ClosedChannelException: TPCCNetworkHandler.queueMessage()");
            return false;
        }
        return true;
    }

    public void run()
    {
        Object obj;
        selector.select();
        obj = selector.selectedKeys();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((Set) (obj)).isEmpty()) goto _L2; else goto _L3
_L3:
        obj = ((Set) (obj)).iterator();
_L9:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L4
_L4:
        obj1 = (SelectionKey)((Iterator) (obj)).next();
        ((Iterator) (obj)).remove();
        if (obj1 != socketChannelSelectionKey)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        if (!((SelectionKey) (obj1)).isReadable()) goto _L6; else goto _L5
_L5:
        ByteBuffer bytebuffer;
        int i;
        bytebuffer = ByteBuffer.allocate(1024);
        i = socketChannel.read(bytebuffer);
        if (i <= 0) goto _L8; else goto _L7
_L7:
        sendTPMessage(1, bytebuffer, (new StringBuilder()).append("bytes read: ").append(i).toString());
_L6:
        if (((SelectionKey) (obj1)).isWritable())
        {
            synchronized (xcpMessageOutQueue)
            {
                if (xcpMessageOutQueue.size() > 0)
                {
                    ByteBuffer abytebuffer[] = (ByteBuffer[])xcpMessageOutQueue.toArray(new ByteBuffer[0]);
                    socketChannel.write(abytebuffer);
                    socketChannel.register(selector, 1);
                    xcpMessageOutQueue.clear();
                }
            }
        }
          goto _L9
        exception;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IOException ioexception)
        {
            sendTPMessage(2, null, "TPCCNetworkHandler IOException in network read/write. TPCCNetworkHandler.run()");
        }
_L2:
        return;
_L8:
        if (i >= 0) goto _L6; else goto _L10
_L10:
        ((SelectionKey) (obj1)).interestOps(((SelectionKey) (obj1)).interestOps() & -2);
        if (!socketChannel.socket().isInputShutdown())
        {
            socketChannel.socket().shutdownInput();
        }
        sendTPMessage(2, null, "TPCCNetworkHandler -1 on read TPCCNetworkHandler.run()");
          goto _L6
        if (TPLog.LOG10.isLoggable("TPCCNetworkHandler"))
        {
            Log.d("TPCCNetworkHandler", "TPCCNetworkHandler: Invalid selector SelectionKey. TPCCNetworkHandler.run()");
        }
        if (TPLog.isInTPDevelop() && !$assertionsDisabled)
        {
            throw new AssertionError();
        }
          goto _L9
    }

    void sendTPMessage(int i, ByteBuffer bytebuffer, String s)
    {
label0:
        {
            {
                if (bytebuffer != null)
                {
                    break label0;
                }
                TPControlChannelMessage tpcontrolchannelmessage;
                try
                {
                    tpcontrolchannelmessage = new TPControlChannelMessage(i);
                }
                catch (TPControlChannelMessage.TPControlChannelMessageException tpcontrolchannelmessageexception)
                {
                    if (TPLog.LOG10.isLoggable("TPCCNetworkHandler"))
                    {
                        Log.e("TPCCNetworkHandler", "FATAL ERROR: TPCCNetworkHandler invalid message parameters");
                        StringBuilder stringbuilder = (new StringBuilder()).append("messageType: ").append(i).append(", messageBuffer = null: ");
                        boolean flag;
                        if (bytebuffer == null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        Log.e("TPCCNetworkHandler", stringbuilder.append(flag).toString());
                        Log.e("TPCCNetworkHandler", s);
                    }
                    if (TPLog.isInTPDevelop() && !$assertionsDisabled)
                    {
                        throw new AssertionError();
                    }
                    break MISSING_BLOCK_LABEL_239;
                }
                bytebuffer = tpcontrolchannelmessage;
            }
            if (bytebuffer != null)
            {
                if (!tpccMessageQueue.offer(bytebuffer))
                {
                    if (TPLog.LOG10.isLoggable("TPCCNetworkHandler"))
                    {
                        Log.e("TPCCNetworkHandler", "FATAL ERROR: TPCCNetworkHandler outbound message queue full");
                    }
                    if (TPLog.isInTPDevelop() && !$assertionsDisabled)
                    {
                        throw new AssertionError();
                    }
                } else
                {
                    i = tpccMessageQueue.size();
                    if (i > maxQueuedStateMachineMessages)
                    {
                        maxQueuedStateMachineMessages = i;
                    }
                }
            }
            break MISSING_BLOCK_LABEL_217;
        }
        tpcontrolchannelmessage = new TPControlChannelMessage(i, bytebuffer);
        bytebuffer = tpcontrolchannelmessage;
        break MISSING_BLOCK_LABEL_17;
        if (TPLog.LOG13.isLoggable("TPCCNetworkHandler") && s != null)
        {
            Log.d("TPCCNetworkHandler", s);
        }
    }

    static 
    {
        boolean flag;
        if (!com/twinprime/TwinPrimeSDK/TPCCNetworkHandler.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
