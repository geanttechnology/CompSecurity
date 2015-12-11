// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apx;
import android.support.v7.aqe;
import android.support.v7.aqj;
import android.support.v7.aqk;
import android.support.v7.aql;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, OkHeaders, RetryableSink, HttpEngine

public final class HttpConnection
{
    private abstract class AbstractSource
        implements aqk
    {

        protected boolean closed;
        final HttpConnection this$0;

        protected final void endOfInput(boolean flag)
            throws IOException
        {
            if (state != 5)
            {
                throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
            }
            state = 0;
            if (flag && onIdle == 1)
            {
                onIdle = 0;
                Internal.instance.recycle(pool, connection);
            } else
            if (onIdle == 2)
            {
                state = 6;
                connection.getSocket().close();
                return;
            }
        }

        public aql timeout()
        {
            return source.timeout();
        }

        protected final void unexpectedEndOfInput()
        {
            Util.closeQuietly(connection.getSocket());
            state = 6;
        }

        private AbstractSource()
        {
            this$0 = HttpConnection.this;
            super();
        }

    }

    private final class ChunkedSink
        implements aqj
    {

        private boolean closed;
        final HttpConnection this$0;

        public void close()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = closed;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            closed = true;
            sink.b("0\r\n\r\n");
            state = 3;
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public void flush()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = closed;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            sink.flush();
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public aql timeout()
        {
            return sink.timeout();
        }

        public void write(apv apv1, long l)
            throws IOException
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (l == 0L)
            {
                return;
            } else
            {
                sink.j(l);
                sink.b("\r\n");
                sink.write(apv1, l);
                sink.b("\r\n");
                return;
            }
        }

        private ChunkedSink()
        {
            this$0 = HttpConnection.this;
            super();
        }

    }

    private class ChunkedSource extends AbstractSource
    {

        private static final long NO_CHUNK_YET = -1L;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;
        final HttpConnection this$0;

        private void readChunkSize()
            throws IOException
        {
            if (bytesRemainingInChunk != -1L)
            {
                source.r();
            }
            try
            {
                bytesRemainingInChunk = source.o();
                String s = source.r().trim();
                if (bytesRemainingInChunk < 0L || !s.isEmpty() && !s.startsWith(";"))
                {
                    throw new ProtocolException((new StringBuilder()).append("expected chunk size and optional extensions but was \"").append(bytesRemainingInChunk).append(s).append("\"").toString());
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new ProtocolException(numberformatexception.getMessage());
            }
            if (bytesRemainingInChunk == 0L)
            {
                hasMoreChunks = false;
                com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
                readHeaders(builder);
                httpEngine.receiveHeaders(builder.build());
                endOfInput(true);
            }
        }

        public void close()
            throws IOException
        {
            if (closed)
            {
                return;
            }
            if (hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(apv apv1, long l)
            throws IOException
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (hasMoreChunks) goto _L2; else goto _L1
_L1:
            return -1L;
_L2:
            if (bytesRemainingInChunk != 0L && bytesRemainingInChunk != -1L)
            {
                break; /* Loop/switch isn't completed */
            }
            readChunkSize();
            if (!hasMoreChunks) goto _L1; else goto _L3
_L3:
            l = source.read(apv1, Math.min(l, bytesRemainingInChunk));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            } else
            {
                bytesRemainingInChunk = bytesRemainingInChunk - l;
                return l;
            }
        }

        ChunkedSource(HttpEngine httpengine)
            throws IOException
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemainingInChunk = -1L;
            hasMoreChunks = true;
            httpEngine = httpengine;
        }
    }

    private final class FixedLengthSink
        implements aqj
    {

        private long bytesRemaining;
        private boolean closed;
        final HttpConnection this$0;

        public void close()
            throws IOException
        {
            if (closed)
            {
                return;
            }
            closed = true;
            if (bytesRemaining > 0L)
            {
                throw new ProtocolException("unexpected end of stream");
            } else
            {
                state = 3;
                return;
            }
        }

        public void flush()
            throws IOException
        {
            if (closed)
            {
                return;
            } else
            {
                sink.flush();
                return;
            }
        }

        public aql timeout()
        {
            return sink.timeout();
        }

        public void write(apv apv1, long l)
            throws IOException
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(apv1.a(), 0L, l);
            if (l > bytesRemaining)
            {
                throw new ProtocolException((new StringBuilder()).append("expected ").append(bytesRemaining).append(" bytes but received ").append(l).toString());
            } else
            {
                sink.write(apv1, l);
                bytesRemaining = bytesRemaining - l;
                return;
            }
        }

        private FixedLengthSink(long l)
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemaining = l;
        }

        FixedLengthSink(long l, _cls1 _pcls1)
        {
            this(l);
        }
    }

    private class FixedLengthSource extends AbstractSource
    {

        private long bytesRemaining;
        final HttpConnection this$0;

        public void close()
            throws IOException
        {
            if (closed)
            {
                return;
            }
            if (bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(apv apv1, long l)
            throws IOException
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (bytesRemaining == 0L)
            {
                return -1L;
            }
            l = source.read(apv1, Math.min(bytesRemaining, l));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            bytesRemaining = bytesRemaining - l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
            return l;
        }

        public FixedLengthSource(long l)
            throws IOException
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemaining = l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource
    {

        private boolean inputExhausted;
        final HttpConnection this$0;

        public void close()
            throws IOException
        {
            if (closed)
            {
                return;
            }
            if (!inputExhausted)
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(apv apv1, long l)
            throws IOException
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (inputExhausted)
            {
                return -1L;
            }
            l = source.read(apv1, l);
            if (l == -1L)
            {
                inputExhausted = true;
                endOfInput(false);
                return -1L;
            } else
            {
                return l;
            }
        }

        private UnknownLengthSource()
        {
            this$0 = HttpConnection.this;
            super();
        }

    }


    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final Connection connection;
    private int onIdle;
    private final ConnectionPool pool;
    private final apw sink;
    private final Socket socket;
    private final apx source;
    private int state;

    public HttpConnection(ConnectionPool connectionpool, Connection connection1, Socket socket1)
        throws IOException
    {
        state = 0;
        onIdle = 0;
        pool = connectionpool;
        connection = connection1;
        socket = socket1;
        source = aqe.a(aqe.b(socket1));
        sink = aqe.a(aqe.a(socket1));
    }

    public long bufferSize()
    {
        return source.b().a();
    }

    public void closeIfOwnedBy(Object obj)
        throws IOException
    {
        Internal.instance.closeIfOwnedBy(connection, obj);
    }

    public void closeOnIdle()
        throws IOException
    {
        onIdle = 2;
        if (state == 0)
        {
            state = 6;
            connection.getSocket().close();
        }
    }

    public void flush()
        throws IOException
    {
        sink.flush();
    }

    public boolean isClosed()
    {
        return state == 6;
    }

    public boolean isReadable()
    {
        Exception exception;
        int i;
        boolean flag;
        try
        {
            i = socket.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        socket.setSoTimeout(1);
        flag = source.f();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        socket.setSoTimeout(i);
        return false;
        socket.setSoTimeout(i);
        return true;
        exception;
        socket.setSoTimeout(i);
        throw exception;
    }

    public aqj newChunkedSink()
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 2;
            return new ChunkedSink();
        }
    }

    public aqk newChunkedSource(HttpEngine httpengine)
        throws IOException
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new ChunkedSource(httpengine);
        }
    }

    public aqj newFixedLengthSink(long l)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 2;
            return new FixedLengthSink(l);
        }
    }

    public aqk newFixedLengthSource(long l)
        throws IOException
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new FixedLengthSource(l);
        }
    }

    public aqk newUnknownLengthSource()
        throws IOException
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new UnknownLengthSource();
        }
    }

    public void poolOnIdle()
    {
        onIdle = 1;
        if (state == 0)
        {
            onIdle = 0;
            Internal.instance.recycle(pool, connection);
        }
    }

    public void readHeaders(com.squareup.okhttp.Headers.Builder builder)
        throws IOException
    {
        do
        {
            String s = source.r();
            if (s.length() != 0)
            {
                Internal.instance.addLenient(builder, s);
            } else
            {
                return;
            }
        } while (true);
    }

    public com.squareup.okhttp.Response.Builder readResponse()
        throws IOException
    {
        if (state != 1 && state != 3)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        }
        com.squareup.okhttp.Response.Builder builder;
        try
        {
            StatusLine statusline;
            do
            {
                statusline = StatusLine.parse(source.r());
                builder = (new com.squareup.okhttp.Response.Builder()).protocol(statusline.protocol).code(statusline.code).message(statusline.message);
                com.squareup.okhttp.Headers.Builder builder1 = new com.squareup.okhttp.Headers.Builder();
                readHeaders(builder1);
                builder1.add(OkHeaders.SELECTED_PROTOCOL, statusline.protocol.toString());
                builder.headers(builder1.build());
            } while (statusline.code == 100);
            state = 4;
        }
        catch (EOFException eofexception)
        {
            IOException ioexception = new IOException((new StringBuilder()).append("unexpected end of stream on ").append(connection).append(" (recycle count=").append(Internal.instance.recycleCount(connection)).append(")").toString());
            ioexception.initCause(eofexception);
            throw ioexception;
        }
        return builder;
    }

    public void setTimeouts(int i, int j)
    {
        if (i != 0)
        {
            source.timeout().timeout(i, TimeUnit.MILLISECONDS);
        }
        if (j != 0)
        {
            sink.timeout().timeout(j, TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequest(Headers headers, String s)
        throws IOException
    {
        if (state != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        }
        sink.b(s).b("\r\n");
        int i = 0;
        for (int j = headers.size(); i < j; i++)
        {
            sink.b(headers.name(i)).b(": ").b(headers.value(i)).b("\r\n");
        }

        sink.b("\r\n");
        state = 1;
    }

    public void writeRequestBody(RetryableSink retryablesink)
        throws IOException
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 3;
            retryablesink.writeToSocket(sink);
            return;
        }
    }




/*
    static int access$402(HttpConnection httpconnection, int i)
    {
        httpconnection.state = i;
        return i;
    }

*/




/*
    static int access$602(HttpConnection httpconnection, int i)
    {
        httpconnection.onIdle = i;
        return i;
    }

*/


}
