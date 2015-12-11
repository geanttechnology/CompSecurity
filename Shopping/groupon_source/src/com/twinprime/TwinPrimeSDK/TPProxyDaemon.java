// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPVTP, TPLog, TPControlChannelStateMachine, TwinPrimeSDKPvt, 
//            TPVTPManager

public class TPProxyDaemon extends Thread
{
    static class TPProxyChannel
    {

        protected WeakReference localSelectionKeyRef;
        TPProxyWriteBuffer localWriteBuffer;
        protected WeakReference remoteSelectionKeyRef;
        TPProxyWriteBuffer remoteWriteBuffer;
        protected TPVTP vtp;

        public static String interestBits(int i)
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            if ((i & 0x10) == 16)
            {
                s = "ACCEPT ";
            } else
            {
                s = "";
            }
            stringbuilder.append(s);
            if ((i & 8) == 8)
            {
                s = "CONNECT ";
            } else
            {
                s = "";
            }
            stringbuilder.append(s);
            if ((i & 1) == 1)
            {
                s = "READ ";
            } else
            {
                s = "";
            }
            stringbuilder.append(s);
            if ((i & 4) == 4)
            {
                s = "WRITE ";
            } else
            {
                s = "";
            }
            stringbuilder.append(s);
            return stringbuilder.toString();
        }

        public void close(SelectionKey selectionkey, SelectionKey selectionkey1)
        {
            if (selectionkey != null)
            {
                try
                {
                    selectionkey1.cancel();
                    selectionkey1.channel().close();
                }
                catch (IOException ioexception) { }
            }
            if (selectionkey1 != null)
            {
                try
                {
                    selectionkey.cancel();
                    selectionkey.channel().close();
                }
                // Misplaced declaration of an exception variable
                catch (SelectionKey selectionkey) { }
            }
            try
            {
                if (vtp != null)
                {
                    TPControlChannelStateMachine.getInstance().tpVtpManager.releaseVtp(vtp);
                }
            }
            // Misplaced declaration of an exception variable
            catch (SelectionKey selectionkey) { }
            vtp = null;
        }

        protected SelectionKey getOtherKey(SelectionKey selectionkey)
        {
            SelectionKey selectionkey1 = (SelectionKey)localSelectionKeyRef.get();
            SelectionKey selectionkey2 = (SelectionKey)remoteSelectionKeyRef.get();
            if (selectionkey1 == selectionkey)
            {
                return selectionkey2;
            } else
            {
                return selectionkey1;
            }
        }

        public boolean isDone()
        {
            SelectionKey selectionkey = (SelectionKey)localSelectionKeyRef.get();
            SelectionKey selectionkey1 = (SelectionKey)remoteSelectionKeyRef.get();
            if (selectionkey != null && selectionkey1 != null && selectionkey.interestOps() == 0 && selectionkey1.interestOps() == 0)
            {
                close(selectionkey, selectionkey1);
                return true;
            } else
            {
                return false;
            }
        }

        public void read(SelectionKey selectionkey)
        {
            TPProxyWriteBuffer tpproxywritebuffer;
            SelectionKey selectionkey1;
            SelectionKey selectionkey2;
            selectionkey2 = (SelectionKey)localSelectionKeyRef.get();
            selectionkey1 = (SelectionKey)remoteSelectionKeyRef.get();
            tpproxywritebuffer = null;
            if (selectionkey2 != selectionkey) goto _L2; else goto _L1
_L1:
            tpproxywritebuffer = remoteWriteBuffer;
_L4:
            if (tpproxywritebuffer != null)
            {
                readChannel(selectionkey, tpproxywritebuffer);
                if (!tpproxywritebuffer.isEmpty() || tpproxywritebuffer.closeWriteBuffer)
                {
                    selectionkey = getOtherKey(selectionkey);
                    if (selectionkey != null)
                    {
                        selectionkey.interestOps(selectionkey.interestOps() | 4);
                    }
                }
            }
            return;
_L2:
            if (selectionkey1 == selectionkey)
            {
                tpproxywritebuffer = localWriteBuffer;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected void readChannel(SelectionKey selectionkey, TPProxyWriteBuffer tpproxywritebuffer)
        {
            SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
_L2:
            ByteBuffer bytebuffer = ByteBuffer.allocate(4096);
            int i;
            try
            {
                i = socketchannel.read(bytebuffer);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (TPLog.LOG13.isLoggable("TPLocalProxy"))
                {
                    ((IOException) (obj)).printStackTrace();
                }
                tpproxywritebuffer.closeWriteBuffer = true;
                i = -1;
            }
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                StringBuilder stringbuilder1 = (new StringBuilder()).append("Read ").append(i).append("B from ");
                Object obj;
                if (selectionkey == localSelectionKeyRef.get())
                {
                    obj = "Local ";
                } else
                {
                    obj = "Remote ";
                }
                Log.d("TPLocalProxy", stringbuilder1.append(((String) (obj))).append(selectionkey).toString());
            }
            if (i > 0)
            {
                bytebuffer.flip();
                tpproxywritebuffer.add(bytebuffer);
                continue; /* Loop/switch isn't completed */
            }
            if (i != -1)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                StringBuilder stringbuilder = (new StringBuilder()).append("Closing read  ");
                String s;
                if (selectionkey == localSelectionKeyRef.get())
                {
                    s = "Local ";
                } else
                {
                    s = "Remote ";
                }
                Log.d("TPLocalProxy", stringbuilder.append(s).append(selectionkey).toString());
            }
            selectionkey.interestOps(selectionkey.interestOps() & -2);
            tpproxywritebuffer.closeWriteBuffer = true;
            if (socketchannel.socket().isInputShutdown())
            {
                break MISSING_BLOCK_LABEL_247;
            }
            socketchannel.socket().shutdownInput();
            return;
            selectionkey;
            return;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public String selectionKeyToString(SelectionKey selectionkey)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append((new StringBuilder()).append("Key:").append(selectionkey).toString());
            if (selectionkey != null)
            {
                stringbuilder.append((new StringBuilder()).append(" interest:").append(interestBits(selectionkey.interestOps())).toString());
            }
            return stringbuilder.toString();
        }

        public void setRemoteKey(SelectionKey selectionkey)
        {
            remoteSelectionKeyRef = new WeakReference(selectionkey);
            if (!remoteWriteBuffer.isEmpty())
            {
                selectionkey.interestOps(selectionkey.interestOps() | 4);
            }
        }

        protected void setVtp(TPVTP tpvtp)
        {
            vtp = tpvtp;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("ProxyChannel");
            stringbuilder.append((new StringBuilder()).append("\n\t[Local] ").append(selectionKeyToString((SelectionKey)localSelectionKeyRef.get())).toString());
            stringbuilder.append((new StringBuilder()).append("\n\t[Remote] ").append(selectionKeyToString((SelectionKey)remoteSelectionKeyRef.get())).toString());
            return stringbuilder.toString();
        }

        public void write(SelectionKey selectionkey)
        {
            TPProxyWriteBuffer tpproxywritebuffer;
            SelectionKey selectionkey1;
            SelectionKey selectionkey2;
            selectionkey1 = (SelectionKey)localSelectionKeyRef.get();
            selectionkey2 = (SelectionKey)remoteSelectionKeyRef.get();
            tpproxywritebuffer = null;
            if (selectionkey2 != selectionkey) goto _L2; else goto _L1
_L1:
            tpproxywritebuffer = remoteWriteBuffer;
_L7:
            if (tpproxywritebuffer == null)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            writeChannel(selectionkey, tpproxywritebuffer);
_L4:
            return;
_L2:
            if (selectionkey1 == selectionkey)
            {
                tpproxywritebuffer = localWriteBuffer;
            }
            continue; /* Loop/switch isn't completed */
            IOException ioexception;
            ioexception;
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                ioexception.printStackTrace();
            }
            writeChannelClose(selectionkey);
            selectionkey = getOtherKey(selectionkey);
            if (selectionkey == null) goto _L4; else goto _L3
_L3:
            selectionkey.interestOps(selectionkey.interestOps() & -2);
            selectionkey = (SocketChannel)selectionkey.channel();
            if (selectionkey.socket().isInputShutdown()) goto _L4; else goto _L5
_L5:
            try
            {
                selectionkey.socket().shutdownInput();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SelectionKey selectionkey)
            {
                return;
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected void writeChannel(SelectionKey selectionkey, TPProxyWriteBuffer tpproxywritebuffer)
            throws IOException
        {
            SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
            do
            {
                ByteBuffer bytebuffer = tpproxywritebuffer.peek();
                if (bytebuffer == null)
                {
                    break;
                }
                int i = socketchannel.write(bytebuffer);
                if (TPLog.LOG13.isLoggable("TPLocalProxy"))
                {
                    StringBuilder stringbuilder1 = (new StringBuilder()).append("Wrote ").append(i).append("B to ");
                    String s;
                    if (selectionkey == localSelectionKeyRef.get())
                    {
                        s = "Local ";
                    } else
                    {
                        s = "Remote ";
                    }
                    Log.d("TPLocalProxy", stringbuilder1.append(s).append(selectionkey).toString());
                }
                if (bytebuffer.hasRemaining())
                {
                    break;
                }
                tpproxywritebuffer.remove();
            } while (true);
            if (!tpproxywritebuffer.isEmpty())
            {
                break MISSING_BLOCK_LABEL_292;
            }
            selectionkey.interestOps(selectionkey.interestOps() & -5);
            if (!tpproxywritebuffer.closeWriteBuffer || socketchannel.socket().isOutputShutdown())
            {
                break MISSING_BLOCK_LABEL_268;
            }
            try
            {
                socketchannel.socket().shutdownOutput();
            }
            catch (IOException ioexception) { }
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                StringBuilder stringbuilder = (new StringBuilder()).append("Closing write ");
                String s1;
                if (selectionkey == localSelectionKeyRef.get())
                {
                    s1 = "Local ";
                } else
                {
                    s1 = "Remote ";
                }
                Log.d("TPLocalProxy", stringbuilder.append(s1).append(selectionkey).toString());
            }
            if (selectionkey != localSelectionKeyRef.get())
            {
                break MISSING_BLOCK_LABEL_268;
            }
            selectionkey.interestOps(selectionkey.interestOps() & -2);
            tpproxywritebuffer.closeWriteBuffer = true;
            if (socketchannel.socket().isInputShutdown())
            {
                break MISSING_BLOCK_LABEL_268;
            }
            socketchannel.socket().shutdownInput();
_L2:
            return;
            selectionkey;
            if (!TPLog.LOG13.isLoggable("TPLocalProxy")) goto _L2; else goto _L1
_L1:
            selectionkey.printStackTrace();
            return;
            selectionkey.interestOps(selectionkey.interestOps() | 4);
            return;
        }

        public void writeChannelClose(SelectionKey selectionkey)
        {
            selectionkey.interestOps(selectionkey.interestOps() & -5);
            SocketChannel socketchannel = (SocketChannel)selectionkey.channel();
            if (!socketchannel.socket().isOutputShutdown())
            {
                try
                {
                    socketchannel.socket().shutdownOutput();
                }
                catch (IOException ioexception) { }
                if (TPLog.LOG13.isLoggable("TPLocalProxy"))
                {
                    StringBuilder stringbuilder = (new StringBuilder()).append("Closing write ");
                    String s;
                    if (selectionkey == localSelectionKeyRef.get())
                    {
                        s = "Local ";
                    } else
                    {
                        s = "Remote ";
                    }
                    Log.d("TPLocalProxy", stringbuilder.append(s).append(selectionkey).toString());
                }
            }
        }

        TPProxyChannel(SelectionKey selectionkey, SelectionKey selectionkey1, TPVTP tpvtp)
        {
            localSelectionKeyRef = new WeakReference(selectionkey);
            remoteSelectionKeyRef = new WeakReference(selectionkey1);
            localWriteBuffer = new TPProxyWriteBuffer();
            remoteWriteBuffer = new TPProxyWriteBuffer();
            vtp = tpvtp;
        }
    }

    static class TPProxyChannelSwallowConnect extends TPProxyChannel
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

        private void appendStringToBuffer(TPProxyWriteBuffer tpproxywritebuffer, byte abyte0[])
        {
            ByteBuffer bytebuffer = ByteBuffer.allocate(abyte0.length);
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                Log.d("TPLocalProxy", (new StringBuilder()).append("Sending: ").append(abyte0).toString());
            }
            bytebuffer.put(abyte0);
            bytebuffer.flip();
            tpproxywritebuffer.add(bytebuffer);
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
            SelectionKey selectionkey1 = (SelectionKey)super.localSelectionKeyRef.get();
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
                super.read(selectionkey);
                return;
            }
        }


        TPProxyChannelSwallowConnect(SelectionKey selectionkey, SelectionKey selectionkey1, TPVTP tpvtp)
        {
            super(selectionkey, selectionkey1, tpvtp);
            passThrough = false;
            connectBuffer = ByteBuffer.allocate(2048);
        }
    }

    static class TPProxyPortRegistration
    {

        public Object attachment;
        public volatile SelectionKey key;
        public SelectableChannel server;

        TPProxyPortRegistration()
        {
        }
    }

    static class TPProxyWriteBuffer
    {

        public boolean closeWriteBuffer;
        ArrayDeque writeBuffer;

        public void add(ByteBuffer bytebuffer)
        {
            if (closeWriteBuffer)
            {
                throw new IllegalStateException("Can't add buffer to a closed write buffer");
            } else
            {
                writeBuffer.add(bytebuffer);
                return;
            }
        }

        public boolean isEmpty()
        {
            return writeBuffer.isEmpty();
        }

        public ByteBuffer peek()
        {
            return (ByteBuffer)writeBuffer.peekFirst();
        }

        public void remove()
        {
            writeBuffer.remove();
        }

        public TPProxyWriteBuffer()
        {
            writeBuffer = new ArrayDeque();
            closeWriteBuffer = false;
        }
    }


    static TPProxyDaemon proxyDaemon = null;
    private long early_wakeup;
    private long invalid_keys;
    ArrayList list;
    private long local_connections;
    private long local_registrations;
    private int permPort;
    private long read_received;
    ConcurrentLinkedQueue registrationQueue;
    private long remote_connections;
    boolean running;
    Selector selector;
    private long write_received;

    private TPProxyDaemon()
        throws IOException
    {
        local_connections = 0L;
        running = false;
        selector = Selector.open();
        list = new ArrayList();
        registrationQueue = new ConcurrentLinkedQueue();
        start();
    }

    private void doAccept(SelectionKey selectionkey)
        throws IOException
    {
        ServerSocketChannel serversocketchannel = (ServerSocketChannel)selectionkey.channel();
        Object obj = serversocketchannel.accept();
        ((SocketChannel) (obj)).socket().setTcpNoDelay(true);
        ((SocketChannel) (obj)).configureBlocking(false);
        SelectionKey selectionkey1 = ((SocketChannel) (obj)).register(selector, 1);
        TPProxyChannelSwallowConnect tpproxychannelswallowconnect;
        if (selectionkey.attachment() instanceof TPVTP)
        {
            obj = (TPVTP)selectionkey.attachment();
        } else
        {
            obj = null;
        }
        tpproxychannelswallowconnect = new TPProxyChannelSwallowConnect(selectionkey1, null, ((TPVTP) (obj)));
        if (obj != null)
        {
            connectVTP(((TPVTP) (obj)), tpproxychannelswallowconnect);
            selectionkey.cancel();
            serversocketchannel.close();
        }
        selectionkey1.attach(tpproxychannelswallowconnect);
        list.add(tpproxychannelswallowconnect);
    }

    private void doConnection(SelectionKey selectionkey)
    {
        SocketChannel socketchannel;
        TPProxyChannel tpproxychannel;
        socketchannel = (SocketChannel)selectionkey.channel();
        tpproxychannel = (TPProxyChannel)selectionkey.attachment();
        if (socketchannel.finishConnect())
        {
            socketchannel.socket().setTcpNoDelay(true);
            selectionkey.interestOps(1);
            tpproxychannel.setRemoteKey(selectionkey);
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                Log.d("TPLocalProxy", (new StringBuilder()).append("Finishing remote Socket Connection, Interesting bits: ").append(TPProxyChannel.interestBits(selectionkey.interestOps())).toString());
                return;
            }
            break MISSING_BLOCK_LABEL_131;
        }
        Thread.dumpStack();
        selectionkey.cancel();
        selectionkey = (SelectionKey)tpproxychannel.localSelectionKeyRef.get();
        if (selectionkey != null)
        {
            try
            {
                selectionkey.channel().close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SelectionKey selectionkey) { }
            if (TPLog.LOG13.isLoggable("TPLocalProxy"))
            {
                selectionkey.printStackTrace();
            }
        }
    }

    public static TPProxyDaemon getInstance()
    {
        com/twinprime/TwinPrimeSDK/TPProxyDaemon;
        JVM INSTR monitorenter ;
        TPProxyDaemon tpproxydaemon = proxyDaemon;
        if (tpproxydaemon != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        proxyDaemon = new TPProxyDaemon();
_L2:
        tpproxydaemon = proxyDaemon;
        com/twinprime/TwinPrimeSDK/TPProxyDaemon;
        JVM INSTR monitorexit ;
        return tpproxydaemon;
        Object obj;
        obj;
        if (!TPLog.LOG10.isLoggable("TPLocalProxy")) goto _L2; else goto _L1
_L1:
        ((IOException) (obj)).printStackTrace();
          goto _L2
        obj;
        throw obj;
    }

    private void selectLoop()
        throws IOException
    {
        Iterator iterator;
        int i;
        i = selector.select();
        iterator = selector.selectedKeys().iterator();
        if (registrationQueue.isEmpty()) goto _L2; else goto _L1
_L1:
        do
        {
            TPProxyPortRegistration tpproxyportregistration = (TPProxyPortRegistration)registrationQueue.poll();
            if (tpproxyportregistration == null)
            {
                break;
            }
            tpproxyportregistration.key = tpproxyportregistration.server.register(selector, 16, tpproxyportregistration.attachment);
            local_registrations = local_registrations + 1L;
        } while (true);
        if (i != 0) goto _L2; else goto _L3
_L3:
        return;
_L2:
        if (i == 0)
        {
            early_wakeup = early_wakeup + 1L;
            return;
        }
        while (iterator.hasNext()) 
        {
            SelectionKey selectionkey = (SelectionKey)iterator.next();
            iterator.remove();
            if (!selectionkey.isValid())
            {
                invalid_keys = invalid_keys + 1L;
                iterator.remove();
            } else
            if (selectionkey.isAcceptable())
            {
                local_connections = local_connections + 1L;
                doAccept(selectionkey);
            } else
            if (selectionkey.isConnectable())
            {
                doConnection(selectionkey);
                remote_connections = remote_connections + 1L;
            } else
            {
                TPProxyChannel tpproxychannel = (TPProxyChannel)selectionkey.attachment();
                if (selectionkey.isWritable())
                {
                    tpproxychannel.write(selectionkey);
                    write_received = write_received + 1L;
                }
                if (selectionkey.isReadable())
                {
                    tpproxychannel.read(selectionkey);
                    read_received = read_received + 1L;
                }
                if (tpproxychannel.isDone())
                {
                    list.remove(tpproxychannel);
                }
            }
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public void connectVTP(TPVTP tpvtp, Object obj)
    {
        tpvtp = new InetSocketAddress(TPControlChannelStateMachine.getInstance().accIPAddrStr, tpvtp.nat_port);
        SocketChannel socketchannel = SocketChannel.open();
        socketchannel.socket().setTcpNoDelay(true);
        socketchannel.configureBlocking(false);
        socketchannel.connect(tpvtp);
        socketchannel.register(selector, 8, obj);
_L1:
        return;
        tpvtp;
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            tpvtp.printStackTrace();
            return;
        }
          goto _L1
    }

    int getPermProxyPort()
    {
        this;
        JVM INSTR monitorenter ;
        if (permPort == 0) goto _L2; else goto _L1
_L1:
        int i = permPort;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        ServerSocketChannel serversocketchannel;
        serversocketchannel = ServerSocketChannel.open();
        serversocketchannel.configureBlocking(false);
        ServerSocket serversocket = serversocketchannel.socket();
        serversocket.bind(null);
        i = serversocket.getLocalPort();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        permPort = i;
        registerSelectableChannel(serversocketchannel, null, null);
_L6:
        i = permPort;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (!TPLog.LOG10.isLoggable("TPLocalProxy")) goto _L6; else goto _L5
_L5:
        ((IOException) (obj)).printStackTrace();
          goto _L6
        obj;
        throw obj;
    }

    void registerSelectableChannel(SelectableChannel selectablechannel, SelectionKey selectionkey, Object obj)
    {
        TPProxyPortRegistration tpproxyportregistration = new TPProxyPortRegistration();
        tpproxyportregistration.key = selectionkey;
        tpproxyportregistration.server = selectablechannel;
        tpproxyportregistration.attachment = obj;
        registrationQueue.add(tpproxyportregistration);
        selector.wakeup();
    }

    public void run()
    {
        running = true;
        if (TPLog.LOG13.isLoggable("TPLocalProxy"))
        {
            Log.d("TPLocalProxy", "Starting local proxy...");
        }
_L1:
        boolean flag = running;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        selectLoop();
          goto _L1
        Object obj;
        obj;
        if (!TPLog.LOG10.isLoggable("TPLocalProxy")) goto _L1; else goto _L2
_L2:
        ((IOException) (obj)).printStackTrace();
          goto _L1
        obj;
        running = false;
        TwinPrimeSDKPvt.disableSDK();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(super.toString());
        stringbuilder.append((new StringBuilder()).append("\n\tlocal_connects:\t").append(local_connections).append("\tremote_connects: ").append(remote_connections).toString());
        stringbuilder.append((new StringBuilder()).append("\n\tread_received:\t").append(read_received).append("\twrite_received:\t").append(write_received).toString());
        stringbuilder.append((new StringBuilder()).append("\n\tbad_select_keys:\t").append(invalid_keys).append("\tearly_wake_up:\t").append(early_wakeup).toString());
        stringbuilder.append((new StringBuilder()).append("\n\tlocal_register:\t").append(local_registrations).toString());
        stringbuilder.append((new StringBuilder()).append("\n\t Selector:").append(selector).toString());
        TPProxyChannel tpproxychannel;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append("\n\t  ").append(tpproxychannel).toString()))
        {
            tpproxychannel = (TPProxyChannel)iterator.next();
        }

        return stringbuilder.toString();
    }

}
