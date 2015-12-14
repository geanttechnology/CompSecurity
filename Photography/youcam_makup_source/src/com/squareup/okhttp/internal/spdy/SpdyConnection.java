// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.d;
import okio.f;
import okio.l;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Settings, Http20Draft14, Variant, Spdy3, 
//            SpdyStream, Ping, FrameWriter, ErrorCode, 
//            IncomingStreamHandler, PushObserver

public final class SpdyConnection
    implements Closeable
{

    static final boolean $assertionsDisabled;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    private static final ExecutorService executor;
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set currentPushRequests;
    final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    private SpdyConnection(Builder builder)
    {
        byte byte0 = 2;
        super();
        streams = new HashMap();
        idleStartTimeNs = System.nanoTime();
        unacknowledgedBytesRead = 0L;
        okHttpSettings = new Settings();
        peerSettings = new Settings();
        receivedInitialPeerSettings = false;
        currentPushRequests = new LinkedHashSet();
        protocol = builder.protocol;
        pushObserver = builder.pushObserver;
        client = builder.client;
        handler = builder.handler;
        int i;
        if (builder.client)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        nextStreamId = i;
        if (builder.client && protocol == Protocol.HTTP_2)
        {
            nextStreamId = nextStreamId + 2;
        }
        i = byte0;
        if (builder.client)
        {
            i = 1;
        }
        nextPingId = i;
        if (builder.client)
        {
            okHttpSettings.set(7, 0, 0x1000000);
        }
        hostName = builder.hostName;
        if (protocol == Protocol.HTTP_2)
        {
            variant = new Http20Draft14();
            pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] {
                hostName
            }), true));
            peerSettings.set(7, 0, 65535);
            peerSettings.set(5, 0, 16384);
        } else
        if (protocol == Protocol.SPDY_3)
        {
            variant = new Spdy3();
            pushExecutor = null;
        } else
        {
            throw new AssertionError(protocol);
        }
        bytesLeftInWriteWindow = peerSettings.getInitialWindowSize(0x10000);
        socket = builder.socket;
        frameWriter = variant.newWriter(l.a(l.a(builder.socket)), client);
        readerRunnable = new Reader();
        (new Thread(readerRunnable)).start();
    }


    private void close(ErrorCode errorcode, ErrorCode errorcode1)
    {
        if (!$assertionsDisabled && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        shutdown(errorcode);
        errorcode = null;
_L5:
        this;
        JVM INSTR monitorenter ;
        SpdyStream aspdystream[];
        if (streams.isEmpty())
        {
            break MISSING_BLOCK_LABEL_285;
        }
        aspdystream = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
        streams.clear();
        setIdle(false);
_L9:
        if (pings == null) goto _L2; else goto _L1
_L1:
        Ping aping[];
        aping = (Ping[])pings.values().toArray(new Ping[pings.size()]);
        pings = null;
_L8:
        this;
        JVM INSTR monitorexit ;
        Object obj;
        int i;
        int k;
        obj = errorcode;
        if (aspdystream == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        k = aspdystream.length;
        i = 0;
_L4:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aspdystream[i];
        ((SpdyStream) (obj)).close(errorcode1);
        obj = errorcode;
_L6:
        i++;
        errorcode = ((ErrorCode) (obj));
        if (true) goto _L4; else goto _L3
        errorcode;
          goto _L5
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        IOException ioexception;
        ioexception;
        obj = errorcode;
        if (errorcode != null)
        {
            obj = ioexception;
        }
          goto _L6
_L3:
        obj = errorcode;
        if (aping != null)
        {
            int i1 = aping.length;
            for (int j = 0; j < i1; j++)
            {
                aping[j].cancel();
            }

        }
        frameWriter.close();
        errorcode = ((ErrorCode) (obj));
_L7:
        try
        {
            socket.close();
        }
        // Misplaced declaration of an exception variable
        catch (ErrorCode errorcode) { }
        if (errorcode != null)
        {
            throw errorcode;
        } else
        {
            return;
        }
        errorcode;
        if (obj != null)
        {
            errorcode = ((ErrorCode) (obj));
        }
          goto _L7
_L2:
        aping = null;
          goto _L8
        aspdystream = null;
          goto _L9
    }

    private SpdyStream newStream(int i, List list, boolean flag, boolean flag1)
    {
        FrameWriter framewriter;
        boolean flag2;
        boolean flag3 = true;
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag1)
        {
            flag1 = flag3;
        } else
        {
            flag1 = false;
        }
        framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_71;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        list;
        framewriter;
        JVM INSTR monitorexit ;
        throw list;
        SpdyStream spdystream;
        int j;
        j = nextStreamId;
        nextStreamId = nextStreamId + 2;
        spdystream = new SpdyStream(j, this, flag2, flag1, list);
        if (spdystream.isOpen())
        {
            streams.put(Integer.valueOf(j), spdystream);
            setIdle(false);
        }
        this;
        JVM INSTR monitorexit ;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        frameWriter.synStream(flag2, flag1, j, i, list);
_L1:
        framewriter;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            frameWriter.flush();
        }
        return spdystream;
        if (client)
        {
            throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        }
        frameWriter.pushPromise(i, j, list);
          goto _L1
    }

    private void pushDataLater(int i, f f1, int j, boolean flag)
    {
        d d1 = new d();
        f1.a(j);
        f1.read(d1, j);
        if (d1.a() != (long)j)
        {
            throw new IOException((new StringBuilder()).append(d1.a()).append(" != ").append(j).toString());
        } else
        {
            pushExecutor.submit(new NamedRunnable(j, flag) {

                final SpdyConnection this$0;
                final d val$buffer;
                final int val$byteCount;
                final boolean val$inFinished;
                final int val$streamId;

                public void execute()
                {
                    boolean flag1 = pushObserver.onData(streamId, buffer, byteCount, inFinished);
                    if (!flag1)
                    {
                        break MISSING_BLOCK_LABEL_52;
                    }
                    frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                    if (flag1)
                    {
                        break MISSING_BLOCK_LABEL_63;
                    }
                    if (!inFinished)
                    {
                        break MISSING_BLOCK_LABEL_99;
                    }
                    synchronized (SpdyConnection.this)
                    {
                        currentPushRequests.remove(Integer.valueOf(streamId));
                    }
                    return;
                    exception;
                    spdyconnection;
                    JVM INSTR monitorexit ;
                    try
                    {
                        throw exception;
                    }
                    catch (IOException ioexception) { }
                }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                buffer = d1;
                byteCount = j;
                inFinished = flag;
                super(final_s, final_aobj);
            }
            });
            return;
        }
    }

    private void pushHeadersLater(int i, List list, boolean flag)
    {
        pushExecutor.submit(new NamedRunnable(list, flag) {

            final SpdyConnection this$0;
            final boolean val$inFinished;
            final List val$requestHeaders;
            final int val$streamId;

            public void execute()
            {
                boolean flag1;
                flag1 = pushObserver.onHeaders(streamId, requestHeaders, inFinished);
                if (!flag1)
                {
                    break MISSING_BLOCK_LABEL_48;
                }
                frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                if (flag1)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                if (!inFinished)
                {
                    break MISSING_BLOCK_LABEL_95;
                }
                synchronized (SpdyConnection.this)
                {
                    currentPushRequests.remove(Integer.valueOf(streamId));
                }
                return;
                exception;
                spdyconnection;
                JVM INSTR monitorexit ;
                try
                {
                    throw exception;
                }
                catch (IOException ioexception) { }
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                requestHeaders = list;
                inFinished = flag;
                super(final_s, final_aobj);
            }
        });
    }

    private void pushRequestLater(int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        if (!currentPushRequests.contains(Integer.valueOf(i)))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
        this;
        JVM INSTR monitorexit ;
        return;
        currentPushRequests.add(Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        pushExecutor.submit(new NamedRunnable(i, list) {

            final SpdyConnection this$0;
            final List val$requestHeaders;
            final int val$streamId;

            public void execute()
            {
                if (!pushObserver.onRequest(streamId, requestHeaders))
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                synchronized (SpdyConnection.this)
                {
                    currentPushRequests.remove(Integer.valueOf(streamId));
                }
                return;
                exception;
                spdyconnection;
                JVM INSTR monitorexit ;
                try
                {
                    throw exception;
                }
                catch (IOException ioexception) { }
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                requestHeaders = list;
                super(final_s, final_aobj);
            }
        });
        return;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    private void pushResetLater(int i, ErrorCode errorcode)
    {
        pushExecutor.submit(new NamedRunnable(i, errorcode) {

            final SpdyConnection this$0;
            final ErrorCode val$errorCode;
            final int val$streamId;

            public void execute()
            {
                pushObserver.onReset(streamId, errorCode);
                synchronized (SpdyConnection.this)
                {
                    currentPushRequests.remove(Integer.valueOf(streamId));
                }
                return;
                exception;
                spdyconnection;
                JVM INSTR monitorexit ;
                throw exception;
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                errorCode = errorcode;
                super(final_s, final_aobj);
            }
        });
    }

    private boolean pushedStream(int i)
    {
        return protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private Ping removePing(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (pings == null) goto _L2; else goto _L1
_L1:
        Ping ping1 = (Ping)pings.remove(Integer.valueOf(i));
_L4:
        this;
        JVM INSTR monitorexit ;
        return ping1;
_L2:
        ping1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void setIdle(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        long l1 = System.nanoTime();
_L1:
        idleStartTimeNs = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        l1 = 0x7fffffffffffffffL;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private void writePing(boolean flag, int i, int j, Ping ping1)
    {
        FrameWriter framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        if (ping1 == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ping1.send();
        frameWriter.ping(flag, i, j);
        framewriter;
        JVM INSTR monitorexit ;
        return;
        ping1;
        framewriter;
        JVM INSTR monitorexit ;
        throw ping1;
    }

    private void writePingLater(boolean flag, int i, int j, Ping ping1)
    {
        executor.submit(new NamedRunnable(j, ping1) {

            final SpdyConnection this$0;
            final int val$payload1;
            final int val$payload2;
            final Ping val$ping;
            final boolean val$reply;

            public void execute()
            {
                try
                {
                    writePing(reply, payload1, payload2, ping);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                reply = flag;
                payload1 = i;
                payload2 = j;
                ping = ping1;
                super(final_s, final_aobj);
            }
        });
    }

    void addBytesToWriteWindow(long l1)
    {
        bytesLeftInWriteWindow = bytesLeftInWriteWindow + l1;
        if (l1 > 0L)
        {
            notifyAll();
        }
    }

    public void close()
    {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush()
    {
        frameWriter.flush();
    }

    public long getIdleStartTimeNs()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = idleStartTimeNs;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public Protocol getProtocol()
    {
        return protocol;
    }

    SpdyStream getStream(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)streams.get(Integer.valueOf(i));
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isIdle()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = idleStartTimeNs;
        boolean flag;
        if (l1 != 0x7fffffffffffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public SpdyStream newStream(List list, boolean flag, boolean flag1)
    {
        return newStream(0, list, flag, flag1);
    }

    public int openStreamCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = streams.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public Ping ping()
    {
        Object obj = new Ping();
        this;
        JVM INSTR monitorenter ;
        if (shutdown)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_33;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        int i;
        i = nextPingId;
        nextPingId = nextPingId + 2;
        if (pings == null)
        {
            pings = new HashMap();
        }
        pings.put(Integer.valueOf(i), obj);
        this;
        JVM INSTR monitorexit ;
        writePing(false, i, 0x4f4b6f6b, ((Ping) (obj)));
        return ((Ping) (obj));
    }

    public SpdyStream pushStream(int i, List list, boolean flag)
    {
        if (client)
        {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (protocol != Protocol.HTTP_2)
        {
            throw new IllegalStateException("protocol != HTTP_2");
        } else
        {
            return newStream(i, list, flag, false);
        }
    }

    SpdyStream removeStream(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)streams.remove(Integer.valueOf(i));
        if (spdystream == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (streams.isEmpty())
        {
            setIdle(true);
        }
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    public void sendConnectionPreface()
    {
        frameWriter.connectionPreface();
        frameWriter.settings(okHttpSettings);
        int i = okHttpSettings.getInitialWindowSize(0x10000);
        if (i != 0x10000)
        {
            frameWriter.windowUpdate(0, i - 0x10000);
        }
    }

    public void shutdown(ErrorCode errorcode)
    {
        FrameWriter framewriter = frameWriter;
        framewriter;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!shutdown)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        framewriter;
        JVM INSTR monitorexit ;
        return;
        int i;
        shutdown = true;
        i = lastGoodStreamId;
        this;
        JVM INSTR monitorexit ;
        frameWriter.goAway(i, errorcode, Util.EMPTY_BYTE_ARRAY);
        framewriter;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        framewriter;
        JVM INSTR monitorexit ;
        throw errorcode;
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
    }

    public void writeData(int i, boolean flag, d d1, long l1)
    {
        long l2 = l1;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        frameWriter.data(flag, i, d1, 0);
_L4:
        return;
_L5:
        int j;
        j = Math.min((int)Math.min(l2, bytesLeftInWriteWindow), frameWriter.maxDataLength());
        bytesLeftInWriteWindow = bytesLeftInWriteWindow - (long)j;
        this;
        JVM INSTR monitorexit ;
        l2 -= j;
        FrameWriter framewriter = frameWriter;
        boolean flag1;
        if (flag && l2 == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        framewriter.data(flag1, i, d1, j);
_L2:
        if (l2 <= 0L) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
        while (bytesLeftInWriteWindow <= 0L) 
        {
            wait();
        }
          goto _L5
        d1;
        throw new InterruptedIOException();
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
    }

    void writeSynReply(int i, boolean flag, List list)
    {
        frameWriter.synReply(flag, i, list);
    }

    void writeSynReset(int i, ErrorCode errorcode)
    {
        frameWriter.rstStream(i, errorcode);
    }

    void writeSynResetLater(int i, ErrorCode errorcode)
    {
        executor.submit(new NamedRunnable(i, errorcode) {

            final SpdyConnection this$0;
            final ErrorCode val$errorCode;
            final int val$streamId;

            public void execute()
            {
                try
                {
                    writeSynReset(streamId, errorCode);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                errorCode = errorcode;
                super(final_s, final_aobj);
            }
        });
    }

    void writeWindowUpdateLater(int i, long l1)
    {
        executor.submit(new NamedRunnable(i, l1) {

            final SpdyConnection this$0;
            final int val$streamId;
            final long val$unacknowledgedBytesRead;

            public void execute()
            {
                try
                {
                    frameWriter.windowUpdate(streamId, unacknowledgedBytesRead);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                this$0 = SpdyConnection.this;
                streamId = i;
                unacknowledgedBytesRead = l1;
                super(final_s, final_aobj);
            }
        });
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyConnection.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        executor = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    }







/*
    static boolean access$1402(SpdyConnection spdyconnection, boolean flag)
    {
        spdyconnection.shutdown = flag;
        return flag;
    }

*/



/*
    static int access$1502(SpdyConnection spdyconnection, int i)
    {
        spdyconnection.lastGoodStreamId = i;
        return i;
    }

*/








/*
    static boolean access$2102(SpdyConnection spdyconnection, boolean flag)
    {
        spdyconnection.receivedInitialPeerSettings = flag;
        return flag;
    }

*/








    private class Builder
    {

        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private Protocol protocol;
        private PushObserver pushObserver;
        private Socket socket;

        public SpdyConnection build()
        {
            return new SpdyConnection(this);
        }

        public Builder handler(IncomingStreamHandler incomingstreamhandler)
        {
            handler = incomingstreamhandler;
            return this;
        }

        public Builder protocol(Protocol protocol1)
        {
            protocol = protocol1;
            return this;
        }

        public Builder pushObserver(PushObserver pushobserver)
        {
            pushObserver = pushobserver;
            return this;
        }







        public Builder(String s, boolean flag, Socket socket1)
        {
            handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            protocol = Protocol.SPDY_3;
            pushObserver = PushObserver.CANCEL;
            hostName = s;
            client = flag;
            socket = socket1;
        }

        public Builder(boolean flag, Socket socket1)
        {
            this(((InetSocketAddress)socket1.getRemoteSocketAddress()).getHostName(), flag, socket1);
        }
    }


    private class Reader extends NamedRunnable
        implements FrameReader.Handler
    {

        FrameReader frameReader;
        final SpdyConnection this$0;

        private void ackSettingsLater(Settings settings1)
        {
            SpdyConnection.executor.submit(new NamedRunnable(new Object[] {
                hostName
            }, settings1) {

                final Reader this$1;
                final Settings val$peerSettings;

                public void execute()
                {
                    try
                    {
                        frameWriter.ackSettings(peerSettings);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

                transient 
                {
                    this$1 = Reader.this;
                    peerSettings = settings1;
                    super(final_s, aobj);
                }
            });
        }

        public void ackSettings()
        {
        }

        public void alternateService(int i, String s, ByteString bytestring, String s1, int j, long l1)
        {
        }

        public void data(boolean flag, int i, f f1, int j)
        {
            if (pushedStream(i))
            {
                pushDataLater(i, f1, j, flag);
            } else
            {
                SpdyStream spdystream = getStream(i);
                if (spdystream == null)
                {
                    writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                    f1.g(j);
                    return;
                }
                spdystream.receiveData(f1, j);
                if (flag)
                {
                    spdystream.receiveFin();
                    return;
                }
            }
        }

        protected void execute()
        {
            Object obj;
            ErrorCode errorcode;
            Object obj2;
            ErrorCode errorcode1;
            obj2 = ErrorCode.INTERNAL_ERROR;
            errorcode1 = ErrorCode.INTERNAL_ERROR;
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            frameReader = variant.newReader(l.a(l.b(socket)), client);
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            if (client)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            frameReader.readConnectionPreface();
_L2:
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            if (frameReader.nextFrame(this)) goto _L2; else goto _L1
_L1:
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            obj2 = ErrorCode.NO_ERROR;
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            ErrorCode errorcode2 = ErrorCode.CANCEL;
            IOException ioexception;
            Object obj1;
            try
            {
                close(((ErrorCode) (obj2)), errorcode2);
            }
            catch (IOException ioexception1) { }
            Util.closeQuietly(frameReader);
            return;
            obj;
            obj = errorcode;
            obj2 = ErrorCode.PROTOCOL_ERROR;
            obj = ErrorCode.PROTOCOL_ERROR;
            try
            {
                close(((ErrorCode) (obj2)), ((ErrorCode) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
            Util.closeQuietly(frameReader);
            return;
            obj1;
            obj2 = obj;
            obj = obj1;
_L4:
            try
            {
                close(((ErrorCode) (obj2)), errorcode1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            Util.closeQuietly(frameReader);
            throw obj;
            obj;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void goAway(int i, ErrorCode errorcode, ByteString bytestring)
        {
            if (bytestring.e() <= 0);
            synchronized (SpdyConnection.this)
            {
                bytestring = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
                shutdown = true;
            }
            int k = bytestring.length;
            for (int j = 0; j < k; j++)
            {
                errorcode = bytestring[j];
                if (errorcode.getId() > i && errorcode.isLocallyInitiated())
                {
                    errorcode.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    removeStream(errorcode.getId());
                }
            }

            break MISSING_BLOCK_LABEL_128;
            bytestring;
            errorcode;
            JVM INSTR monitorexit ;
            throw bytestring;
        }

        public void headers(boolean flag, boolean flag1, int i, int j, List list, HeadersMode headersmode)
        {
            if (!pushedStream(i)) goto _L2; else goto _L1
_L1:
            pushHeadersLater(i, list, flag1);
_L4:
            return;
_L2:
            synchronized (SpdyConnection.this)
            {
                if (!shutdown)
                {
                    break MISSING_BLOCK_LABEL_54;
                }
            }
            return;
            list;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw list;
            SpdyStream spdystream = getStream(i);
            if (spdystream != null)
            {
                break MISSING_BLOCK_LABEL_218;
            }
            if (!headersmode.failIfStreamAbsent())
            {
                break MISSING_BLOCK_LABEL_92;
            }
            writeSynResetLater(i, ErrorCode.INVALID_STREAM);
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            if (i > lastGoodStreamId)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            if (i % 2 != nextStreamId % 2)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            list = new SpdyStream(i, SpdyConnection.this, flag, flag1, list);
            lastGoodStreamId = i;
            streams.put(Integer.valueOf(i), list);
            SpdyConnection.executor.submit(new NamedRunnable(new Object[] {
                hostName, Integer.valueOf(i)
            }, list) {

                final Reader this$1;
                final SpdyStream val$newStream;

                public void execute()
                {
                    try
                    {
                        handler.receive(newStream);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        throw new RuntimeException(ioexception);
                    }
                }

                transient 
                {
                    this$1 = Reader.this;
                    newStream = spdystream;
                    super(final_s, aobj);
                }
            });
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            spdyconnection;
            JVM INSTR monitorexit ;
            if (headersmode.failIfStreamPresent())
            {
                spdystream.closeLater(ErrorCode.PROTOCOL_ERROR);
                removeStream(i);
                return;
            }
            spdystream.receiveHeaders(list, headersmode);
            if (flag1)
            {
                spdystream.receiveFin();
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void ping(boolean flag, int i, int j)
        {
            if (flag)
            {
                Ping ping1 = removePing(i);
                if (ping1 != null)
                {
                    ping1.receive();
                }
                return;
            } else
            {
                writePingLater(true, i, j, null);
                return;
            }
        }

        public void priority(int i, int j, int k, boolean flag)
        {
        }

        public void pushPromise(int i, int j, List list)
        {
            pushRequestLater(j, list);
        }

        public void rstStream(int i, ErrorCode errorcode)
        {
            if (pushedStream(i))
            {
                pushResetLater(i, errorcode);
            } else
            {
                SpdyStream spdystream = removeStream(i);
                if (spdystream != null)
                {
                    spdystream.receiveRstStream(errorcode);
                    return;
                }
            }
        }

        public void settings(boolean flag, Settings settings1)
        {
            spdyconnection = SpdyConnection.this;
            spdyconnection;
            JVM INSTR monitorenter ;
            int i = peerSettings.getInitialWindowSize(0x10000);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            peerSettings.clear();
            int k;
            peerSettings.merge(settings1);
            if (getProtocol() == Protocol.HTTP_2)
            {
                ackSettingsLater(settings1);
            }
            k = peerSettings.getInitialWindowSize(0x10000);
            long l1;
            if (k == -1 || k == i)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            l1 = k - i;
            if (!receivedInitialPeerSettings)
            {
                addBytesToWriteWindow(l1);
                receivedInitialPeerSettings = true;
            }
            if (streams.isEmpty()) goto _L2; else goto _L1
_L1:
            settings1 = (SpdyStream[])streams.values().toArray(new SpdyStream[streams.size()]);
_L3:
            spdyconnection;
            JVM INSTR monitorexit ;
            if (settings1 != null && l1 != 0L)
            {
                int i1 = settings1.length;
                for (int j = 0; j < i1; j++)
                {
                    synchronized (settings1[j])
                    {
                        spdyconnection.addBytesToWriteWindow(l1);
                    }
                }

            }
            break MISSING_BLOCK_LABEL_241;
            settings1;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw settings1;
            settings1;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw settings1;
            return;
_L2:
            settings1 = null;
              goto _L3
            settings1 = null;
            l1 = 0L;
              goto _L3
        }

        public void windowUpdate(int i, long l1)
        {
            if (i == 0)
            {
                synchronized (SpdyConnection.this)
                {
                    SpdyConnection spdyconnection1 = SpdyConnection.this;
                    spdyconnection1.bytesLeftInWriteWindow = spdyconnection1.bytesLeftInWriteWindow + l1;
                    notifyAll();
                }
                return;
            }
            break MISSING_BLOCK_LABEL_50;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw exception;
            SpdyStream spdystream;
            spdystream = getStream(i);
            if (spdystream == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            spdystream;
            JVM INSTR monitorenter ;
            spdystream.addBytesToWriteWindow(l1);
            spdystream;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            spdystream;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        private Reader()
        {
            this$0 = SpdyConnection.this;
            super("OkHttp %s", new Object[] {
                hostName
            });
        }

    }

}
