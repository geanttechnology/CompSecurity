// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter, ErrorCode, 
//            HeadersMode, Settings

public final class Http20Draft09
    implements Variant
{
    static final class ContinuationSource
        implements Source
    {

        byte flags;
        int left;
        int length;
        private final BufferedSource source;
        int streamId;

        private void readContinuationHeader()
            throws IOException
        {
            int i = streamId;
            int j = source.readInt();
            int k = source.readInt();
            int l = (short)((0x3fff0000 & j) >> 16);
            left = l;
            length = l;
            byte byte0 = (byte)((0xff00 & j) >> 8);
            flags = (byte)(j & 0xff);
            streamId = 0x7fffffff & k;
            if (byte0 != 10)
            {
                throw Http20Draft09.ioException("%s != TYPE_CONTINUATION", new Object[] {
                    Byte.valueOf(byte0)
                });
            }
            if (streamId != i)
            {
                throw Http20Draft09.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            } else
            {
                return;
            }
        }

        public void close()
            throws IOException
        {
        }

        public long read(OkBuffer okbuffer, long l)
            throws IOException
        {
            while (left == 0) 
            {
                if ((flags & 4) != 0)
                {
                    return -1L;
                }
                readContinuationHeader();
            }
            l = source.read(okbuffer, Math.min(l, left));
            if (l == -1L)
            {
                return -1L;
            } else
            {
                left = (int)((long)left - l);
                return l;
            }
        }

        public ContinuationSource(BufferedSource bufferedsource)
        {
            source = bufferedsource;
        }
    }

    static final class Reader
        implements FrameReader
    {

        private final boolean client;
        private final ContinuationSource continuation;
        final HpackDraft05.Reader hpackReader;
        private final BufferedSource source;

        private void readData(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            boolean flag;
            if ((byte0 & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.data(flag, i, source, word0);
        }

        private void readGoAway(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (word0 < 8)
            {
                throw Http20Draft09.ioException("TYPE_GOAWAY length < 8: %s", new Object[] {
                    Short.valueOf(word0)
                });
            }
            if (i != 0)
            {
                throw Http20Draft09.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            byte0 = source.readInt();
            i = source.readInt();
            int j = word0 - 8;
            ErrorCode errorcode = ErrorCode.fromHttp2(i);
            if (errorcode == null)
            {
                throw Http20Draft09.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(i)
                });
            }
            ByteString bytestring = ByteString.EMPTY;
            if (j > 0)
            {
                bytestring = source.readByteString(j);
            }
            handler.goAway(byte0, errorcode, bytestring);
        }

        private List readHeaderBlock(short word0, byte byte0, int i)
            throws IOException
        {
            ContinuationSource continuationsource = continuation;
            continuation.left = word0;
            continuationsource.length = word0;
            continuation.flags = byte0;
            continuation.streamId = i;
            hpackReader.readHeaders();
            hpackReader.emitReferenceSet();
            return hpackReader.getAndReset();
        }

        private void readHeaders(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (i == 0)
            {
                throw Http20Draft09.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short word1;
            int j;
            boolean flag;
            if ((byte0 & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = -1;
            word1 = word0;
            if ((byte0 & 8) != 0)
            {
                j = source.readInt() & 0x7fffffff;
                word1 = (short)(word0 - 4);
            }
            handler.headers(false, flag, i, -1, j, readHeaderBlock(word1, byte0, i), HeadersMode.HTTP_20_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            boolean flag = true;
            if (word0 != 8)
            {
                throw Http20Draft09.ioException("TYPE_PING length != 8: %s", new Object[] {
                    Short.valueOf(word0)
                });
            }
            if (i != 0)
            {
                throw Http20Draft09.ioException("TYPE_PING streamId != 0", new Object[0]);
            }
            i = source.readInt();
            int j = source.readInt();
            if ((byte0 & 1) == 0)
            {
                flag = false;
            }
            handler.ping(flag, i, j);
        }

        private void readPriority(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (word0 != 4)
            {
                throw Http20Draft09.ioException("TYPE_PRIORITY length: %d != 4", new Object[] {
                    Short.valueOf(word0)
                });
            }
            if (i == 0)
            {
                throw Http20Draft09.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else
            {
                handler.priority(i, source.readInt() & 0x7fffffff);
                return;
            }
        }

        private void readPushPromise(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (i == 0)
            {
                throw Http20Draft09.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            } else
            {
                handler.pushPromise(i, source.readInt() & 0x7fffffff, readHeaderBlock((short)(word0 - 4), byte0, i));
                return;
            }
        }

        private void readRstStream(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (word0 != 4)
            {
                throw Http20Draft09.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] {
                    Short.valueOf(word0)
                });
            }
            if (i == 0)
            {
                throw Http20Draft09.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            byte0 = source.readInt();
            ErrorCode errorcode = ErrorCode.fromHttp2(byte0);
            if (errorcode == null)
            {
                throw Http20Draft09.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(byte0)
                });
            } else
            {
                handler.rstStream(i, errorcode);
                return;
            }
        }

        private void readSettings(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (i != 0)
            {
                throw Http20Draft09.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((byte0 & 1) != 0)
            {
                if (word0 != 0)
                {
                    throw Http20Draft09.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.ackSettings();
            } else
            {
                if (word0 % 8 != 0)
                {
                    throw Http20Draft09.ioException("TYPE_SETTINGS length %% 8 != 0: %s", new Object[] {
                        Short.valueOf(word0)
                    });
                }
                Settings settings = new Settings();
                for (byte0 = 0; byte0 < word0; byte0 += 8)
                {
                    settings.set(source.readInt() & 0xffffff, 0, source.readInt());
                }

                handler.settings(false, settings);
                if (settings.getHeaderTableSize() >= 0)
                {
                    hpackReader.maxHeaderTableByteCount(settings.getHeaderTableSize());
                    return;
                }
            }
        }

        private void readWindowUpdate(FrameReader.Handler handler, short word0, byte byte0, int i)
            throws IOException
        {
            if (word0 != 4)
            {
                throw Http20Draft09.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                    Short.valueOf(word0)
                });
            }
            long l = source.readInt() & 0x7fffffff;
            if (l == 0L)
            {
                throw Http20Draft09.ioException("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                handler.windowUpdate(i, l);
                return;
            }
        }

        public void close()
            throws IOException
        {
            source.close();
        }

        public boolean nextFrame(FrameReader.Handler handler)
            throws IOException
        {
            byte byte0;
            int i;
            int j;
            byte byte1;
            int k;
            try
            {
                j = source.readInt();
                k = source.readInt();
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            i = (short)((0x3fff0000 & j) >> 16);
            byte1 = (byte)((0xff00 & j) >> 8);
            byte0 = (byte)(j & 0xff);
            j = k & 0x7fffffff;
            byte1;
            JVM INSTR tableswitch 0 9: default 116
        //                       0 132
        //                       1 144
        //                       2 156
        //                       3 168
        //                       4 180
        //                       5 192
        //                       6 204
        //                       7 216
        //                       8 116
        //                       9 228;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L1 _L10
_L1:
            source.skip(i);
_L12:
            return true;
_L2:
            readData(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L3:
            readHeaders(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L4:
            readPriority(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L5:
            readRstStream(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L6:
            readSettings(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L7:
            readPushPromise(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L8:
            readPing(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L9:
            readGoAway(handler, i, byte0, j);
            continue; /* Loop/switch isn't completed */
_L10:
            readWindowUpdate(handler, i, byte0, j);
            if (true) goto _L12; else goto _L11
_L11:
        }

        public void readConnectionHeader()
            throws IOException
        {
            ByteString bytestring;
            if (!client)
            {
                if (!Http20Draft09.CONNECTION_HEADER.equals(bytestring = source.readByteString(Http20Draft09.CONNECTION_HEADER.size())))
                {
                    throw Http20Draft09.ioException("Expected a connection header but was %s", new Object[] {
                        bytestring.utf8()
                    });
                }
            }
        }

        Reader(BufferedSource bufferedsource, int i, boolean flag)
        {
            source = bufferedsource;
            client = flag;
            continuation = new ContinuationSource(source);
            hpackReader = new HpackDraft05.Reader(flag, i, continuation);
        }
    }

    static final class Writer
        implements FrameWriter
    {

        private final boolean client;
        private boolean closed;
        private final OkBuffer hpackBuffer = new OkBuffer();
        private final HpackDraft05.Writer hpackWriter;
        private final BufferedSink sink;

        private void headers(boolean flag, int i, int j, List list)
            throws IOException
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if (hpackBuffer.size() != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            int l = (int)hpackBuffer.size();
            byte byte0 = 4;
            if (flag)
            {
                byte0 = (byte)5;
            }
            byte byte1 = byte0;
            if (j != -1)
            {
                byte1 = (byte)(byte0 | 8);
            }
            int k = l;
            if (j != -1)
            {
                k = l + 4;
            }
            frameHeader(k, (byte)1, byte1, i);
            if (j != -1)
            {
                sink.writeInt(0x7fffffff & j);
            }
            sink.write(hpackBuffer, hpackBuffer.size());
        }

        public void ackSettings()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            frameHeader(0, (byte)4, (byte)1, 0);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void close()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            closed = true;
            sink.close();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void connectionHeader()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            boolean flag = client;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_36;
            }
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
            sink.write(Http20Draft09.CONNECTION_HEADER.toByteArray());
            sink.flush();
              goto _L1
        }

        public void data(boolean flag, int i, OkBuffer okbuffer, int j)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            okbuffer;
            this;
            JVM INSTR monitorexit ;
            throw okbuffer;
            byte byte0;
            byte0 = 0;
            if (flag)
            {
                byte0 = (byte)1;
            }
            dataFrame(i, byte0, okbuffer, j);
            this;
            JVM INSTR monitorexit ;
        }

        void dataFrame(int i, byte byte0, OkBuffer okbuffer, int j)
            throws IOException
        {
            frameHeader(j, (byte)0, byte0, i);
            if (j > 0)
            {
                sink.write(okbuffer, j);
            }
        }

        public void flush()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        void frameHeader(int i, byte byte0, byte byte1, int j)
            throws IOException
        {
            if (i > 16383)
            {
                throw Http20Draft09.illegalArgument("FRAME_SIZE_ERROR length > 16383: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if ((0x80000000 & j) != 0)
            {
                throw Http20Draft09.illegalArgument("reserved bit set: %s", new Object[] {
                    Integer.valueOf(j)
                });
            } else
            {
                sink.writeInt((i & 0x3fff) << 16 | (byte0 & 0xff) << 8 | byte1 & 0xff);
                sink.writeInt(0x7fffffff & j);
                return;
            }
        }

        public void goAway(int i, ErrorCode errorcode, byte abyte0[])
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.httpCode == -1)
            {
                throw Http20Draft09.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
            frameHeader(abyte0.length + 8, (byte)7, (byte)0, 0);
            sink.writeInt(i);
            sink.writeInt(errorcode.httpCode);
            if (abyte0.length > 0)
            {
                sink.write(abyte0);
            }
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void ping(boolean flag, int i, int j)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            byte byte0;
            if (flag)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            frameHeader(8, (byte)6, byte0, 0);
            sink.writeInt(i);
            sink.writeInt(j);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void pushPromise(int i, int j, List list)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            if (hpackBuffer.size() != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            frameHeader((int)(4L + hpackBuffer.size()), (byte)5, (byte)4, i);
            sink.writeInt(0x7fffffff & j);
            sink.write(hpackBuffer, hpackBuffer.size());
            this;
            JVM INSTR monitorexit ;
        }

        public void rstStream(int i, ErrorCode errorcode)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.spdyRstCode == -1)
            {
                throw new IllegalArgumentException();
            }
            frameHeader(4, (byte)3, (byte)0, i);
            sink.writeInt(errorcode.httpCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void settings(Settings settings1)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            settings1;
            this;
            JVM INSTR monitorexit ;
            throw settings1;
            frameHeader(settings1.size() * 8, (byte)4, (byte)0, 0);
            int i = 0;
_L2:
            if (i >= 10)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            if (!settings1.isSet(i))
            {
                break MISSING_BLOCK_LABEL_101;
            }
            sink.writeInt(0xffffff & i);
            sink.writeInt(settings1.get(i));
            break MISSING_BLOCK_LABEL_101;
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void synStream(boolean flag, boolean flag1, int i, int j, int k, int l, List list)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            throw new UnsupportedOperationException();
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            if (closed)
            {
                throw new IOException("closed");
            }
            headers(flag, i, k, list);
            this;
            JVM INSTR monitorexit ;
        }

        public void windowUpdate(int i, long l)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            if (l != 0L && l <= 0x7fffffffL)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            throw Http20Draft09.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
                Long.valueOf(l)
            });
            frameHeader(4, (byte)9, (byte)0, i);
            sink.writeInt((int)l);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        Writer(BufferedSink bufferedsink, boolean flag)
        {
            sink = bufferedsink;
            client = flag;
            hpackWriter = new HpackDraft05.Writer(hpackBuffer);
        }
    }


    private static final ByteString CONNECTION_HEADER = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public Http20Draft09()
    {
    }

    private static transient IllegalArgumentException illegalArgument(String s, Object aobj[])
    {
        throw new IllegalArgumentException(String.format(s, aobj));
    }

    private static transient IOException ioException(String s, Object aobj[])
        throws IOException
    {
        throw new IOException(String.format(s, aobj));
    }

    public int maxFrameSize()
    {
        return 16383;
    }

    public FrameReader newReader(BufferedSource bufferedsource, boolean flag)
    {
        return new Reader(bufferedsource, 4096, flag);
    }

    public FrameWriter newWriter(BufferedSink bufferedsink, boolean flag)
    {
        return new Writer(bufferedsink, flag);
    }




}
