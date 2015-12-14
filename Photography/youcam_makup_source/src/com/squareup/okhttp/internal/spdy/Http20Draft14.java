// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import okio.ByteString;
import okio.e;
import okio.f;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter

public final class Http20Draft14
    implements Variant
{

    private static final ByteString CONNECTION_PREFACE = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;

    public Http20Draft14()
    {
    }

    private static transient IllegalArgumentException illegalArgument(String s, Object aobj[])
    {
        throw new IllegalArgumentException(String.format(s, aobj));
    }

    private static transient IOException ioException(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    private static int lengthWithoutPadding(int i, byte byte0, short word0)
    {
        int j = i;
        if ((byte0 & 8) != 0)
        {
            j = i - 1;
        }
        if (word0 > j)
        {
            throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] {
                Short.valueOf(word0), Integer.valueOf(j)
            });
        } else
        {
            return (short)(j - word0);
        }
    }

    private static int readMedium(f f1)
    {
        return (f1.h() & 0xff) << 16 | (f1.h() & 0xff) << 8 | f1.h() & 0xff;
    }

    private static void writeMedium(e e1, int i)
    {
        e1.g(i >>> 16 & 0xff);
        e1.g(i >>> 8 & 0xff);
        e1.g(i & 0xff);
    }

    public Protocol getProtocol()
    {
        return Protocol.HTTP_2;
    }

    public FrameReader newReader(f f1, boolean flag)
    {
        return new Reader(f1, 4096, flag);
    }

    public FrameWriter newWriter(e e1, boolean flag)
    {
        return new Writer(e1, flag);
    }








    private class Reader
        implements FrameReader
    {
        private class ContinuationSource
            implements r
        {

            byte flags;
            int left;
            int length;
            short padding;
            private final f source;
            int streamId;

            private void readContinuationHeader()
            {
                int i = streamId;
                int j = Http20Draft14.readMedium(source);
                left = j;
                length = j;
                byte byte0 = (byte)(source.h() & 0xff);
                flags = (byte)(source.h() & 0xff);
                if (Internal.logger.isLoggable(Level.FINE))
                {
                    Internal.logger.fine(FrameLogger.formatHeader(true, streamId, length, byte0, flags));
                }
                streamId = source.j() & 0x7fffffff;
                if (byte0 != 9)
                {
                    throw Http20Draft14.ioException("%s != TYPE_CONTINUATION", new Object[] {
                        Byte.valueOf(byte0)
                    });
                }
                if (streamId != i)
                {
                    throw Http20Draft14.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
                } else
                {
                    return;
                }
            }

            public void close()
            {
            }

            public long read(d d, long l)
            {
_L7:
                if (left != 0) goto _L2; else goto _L1
_L1:
                source.g(padding);
                padding = 0;
                if ((flags & 4) == 0) goto _L4; else goto _L3
_L3:
                return -1L;
_L4:
                readContinuationHeader();
                continue; /* Loop/switch isn't completed */
_L2:
                l = source.read(d, Math.min(l, left));
                if (l == -1L) goto _L3; else goto _L5
_L5:
                left = (int)((long)left - l);
                return l;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public s timeout()
            {
                return source.timeout();
            }

            public ContinuationSource(f f1)
            {
                source = f1;
            }

            private class FrameLogger
            {

                private static final String BINARY[];
                private static final String FLAGS[];
                private static final String TYPES[] = {
                    "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"
                };

                static String formatFlags(byte byte0, byte byte1)
                {
                    String s1;
                    if (byte1 == 0)
                    {
                        s1 = "";
                    } else
                    {
                        String s;
                        switch (byte0)
                        {
                        case 5: // '\005'
                        default:
                            if (byte1 < FLAGS.length)
                            {
                                s = FLAGS[byte1];
                            } else
                            {
                                s = BINARY[byte1];
                            }
                            if (byte0 == 5 && (byte1 & 4) != 0)
                            {
                                return s.replace("HEADERS", "PUSH_PROMISE");
                            }
                            break;

                        case 4: // '\004'
                        case 6: // '\006'
                            if (byte1 == 1)
                            {
                                return "ACK";
                            } else
                            {
                                return BINARY[byte1];
                            }

                        case 2: // '\002'
                        case 3: // '\003'
                        case 7: // '\007'
                        case 8: // '\b'
                            return BINARY[byte1];
                        }
                        s1 = s;
                        if (byte0 == 0)
                        {
                            s1 = s;
                            if ((byte1 & 0x20) != 0)
                            {
                                return s.replace("PRIORITY", "COMPRESSED");
                            }
                        }
                    }
                    return s1;
                }

                static String formatHeader(boolean flag, int i, int j, byte byte0, byte byte1)
                {
                    String s;
                    String s1;
                    String s2;
                    if (byte0 < TYPES.length)
                    {
                        s = TYPES[byte0];
                    } else
                    {
                        s = String.format("0x%02x", new Object[] {
                            Byte.valueOf(byte0)
                        });
                    }
                    s2 = formatFlags(byte0, byte1);
                    if (flag)
                    {
                        s1 = "<<";
                    } else
                    {
                        s1 = ">>";
                    }
                    return String.format("%s 0x%08x %5d %-13s %s", new Object[] {
                        s1, Integer.valueOf(i), Integer.valueOf(j), s, s2
                    });
                }

                static 
                {
                    boolean flag = false;
                    FLAGS = new String[64];
                    BINARY = new String[256];
                    for (int i = 0; i < BINARY.length; i++)
                    {
                        BINARY[i] = String.format("%8s", new Object[] {
                            Integer.toBinaryString(i)
                        }).replace(' ', '0');
                    }

                    FLAGS[0] = "";
                    FLAGS[1] = "END_STREAM";
                    int ai[] = new int[1];
                    ai[0] = 1;
                    FLAGS[8] = "PADDED";
                    int l = ai.length;
                    for (int j = 0; j < l; j++)
                    {
                        int i1 = ai[j];
                        FLAGS[i1 | 8] = (new StringBuilder()).append(FLAGS[i1]).append("|PADDED").toString();
                    }

                    FLAGS[4] = "END_HEADERS";
                    FLAGS[32] = "PRIORITY";
                    FLAGS[36] = "END_HEADERS|PRIORITY";
                    int ai1[] = new int[3];
                    int[] _tmp = ai1;
                    ai1[0] = 4;
                    ai1[1] = 32;
                    ai1[2] = 36;
                    int j1 = ai1.length;
                    int k = 0;
                    do
                    {
                        l = ((flag) ? 1 : 0);
                        if (k >= j1)
                        {
                            break;
                        }
                        int k1 = ai1[k];
                        int l1 = ai.length;
                        for (l = 0; l < l1; l++)
                        {
                            int i2 = ai[l];
                            FLAGS[i2 | k1] = (new StringBuilder()).append(FLAGS[i2]).append('|').append(FLAGS[k1]).toString();
                            FLAGS[i2 | k1 | 8] = (new StringBuilder()).append(FLAGS[i2]).append('|').append(FLAGS[k1]).append("|PADDED").toString();
                        }

                        k++;
                    } while (true);
                    for (; l < FLAGS.length; l++)
                    {
                        if (FLAGS[l] == null)
                        {
                            FLAGS[l] = BINARY[l];
                        }
                    }

                }

                FrameLogger()
                {
                }
            }

        }


        private final boolean client;
        private final ContinuationSource continuation;
        final HpackDraft09.Reader hpackReader;
        private final f source;

        private void readData(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            boolean flag = true;
            int k = 0;
            boolean flag1;
            if ((byte0 & 1) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((byte0 & 0x20) == 0)
            {
                flag = false;
            }
            if (flag)
            {
                throw Http20Draft14.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((byte0 & 8) != 0)
            {
                k = (short)(source.h() & 0xff);
            }
            i = Http20Draft14.lengthWithoutPadding(i, byte0, k);
            handler.data(flag1, j, source, i);
            source.g(k);
        }

        private void readGoAway(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i < 8)
            {
                throw Http20Draft14.ioException("TYPE_GOAWAY length < 8: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j != 0)
            {
                throw Http20Draft14.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            byte0 = source.j();
            j = source.j();
            i -= 8;
            ErrorCode errorcode = ErrorCode.fromHttp2(j);
            if (errorcode == null)
            {
                throw Http20Draft14.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            }
            ByteString bytestring = ByteString.a;
            if (i > 0)
            {
                bytestring = source.c(i);
            }
            handler.goAway(byte0, errorcode, bytestring);
        }

        private List readHeaderBlock(int i, short word0, byte byte0, int j)
        {
            ContinuationSource continuationsource = continuation;
            continuation.left = i;
            continuationsource.length = i;
            continuation.padding = word0;
            continuation.flags = byte0;
            continuation.streamId = j;
            hpackReader.readHeaders();
            return hpackReader.getAndResetHeaderList();
        }

        private void readHeaders(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (j == 0)
            {
                throw Http20Draft14.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short word0;
            int k;
            boolean flag;
            if ((byte0 & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((byte0 & 8) != 0)
            {
                word0 = (short)(source.h() & 0xff);
            } else
            {
                word0 = 0;
            }
            k = i;
            if ((byte0 & 0x20) != 0)
            {
                readPriority(handler, j);
                k = i - 5;
            }
            handler.headers(false, flag, j, -1, readHeaderBlock(Http20Draft14.lengthWithoutPadding(k, byte0, word0), word0, byte0, j), HeadersMode.HTTP_20_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            boolean flag = true;
            if (i != 8)
            {
                throw Http20Draft14.ioException("TYPE_PING length != 8: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j != 0)
            {
                throw Http20Draft14.ioException("TYPE_PING streamId != 0", new Object[0]);
            }
            i = source.j();
            j = source.j();
            if ((byte0 & 1) == 0)
            {
                flag = false;
            }
            handler.ping(flag, i, j);
        }

        private void readPriority(FrameReader.Handler handler, int i)
        {
            int j = source.j();
            boolean flag;
            if ((0x80000000 & j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.priority(i, j & 0x7fffffff, (source.h() & 0xff) + 1, flag);
        }

        private void readPriority(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 5)
            {
                throw Http20Draft14.ioException("TYPE_PRIORITY length: %d != 5", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j == 0)
            {
                throw Http20Draft14.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else
            {
                readPriority(handler, j);
                return;
            }
        }

        private void readPushPromise(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            short word0 = 0;
            if (j == 0)
            {
                throw Http20Draft14.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((byte0 & 8) != 0)
            {
                word0 = (short)(source.h() & 0xff);
            }
            handler.pushPromise(j, source.j() & 0x7fffffff, readHeaderBlock(Http20Draft14.lengthWithoutPadding(i - 4, byte0, word0), word0, byte0, j));
        }

        private void readRstStream(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 4)
            {
                throw Http20Draft14.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (j == 0)
            {
                throw Http20Draft14.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            i = source.j();
            ErrorCode errorcode = ErrorCode.fromHttp2(i);
            if (errorcode == null)
            {
                throw Http20Draft14.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                handler.rstStream(j, errorcode);
                return;
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (j != 0)
            {
                throw Http20Draft14.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((byte0 & 1) == 0) goto _L2; else goto _L1
_L1:
            if (i != 0)
            {
                throw Http20Draft14.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
_L15:
            return;
_L2:
            Settings settings;
            if (i % 6 != 0)
            {
                throw Http20Draft14.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            settings = new Settings();
            byte0 = 0;
_L10:
            short word0;
            int k;
            if (byte0 >= i)
            {
                break MISSING_BLOCK_LABEL_273;
            }
            word0 = source.i();
            k = source.j();
            j = word0;
            word0;
            JVM INSTR tableswitch 1 6: default 148
        //                       1 198
        //                       2 166
        //                       3 195
        //                       4 217
        //                       5 236
        //                       6 198;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L4
_L7:
            break; /* Loop/switch isn't completed */
_L4:
            break; /* Loop/switch isn't completed */
_L3:
            throw Http20Draft14.ioException("PROTOCOL_ERROR invalid settings id: %s", new Object[] {
                Short.valueOf(word0)
            });
_L5:
            j = word0;
            if (k != 0)
            {
                j = word0;
                if (k != 1)
                {
                    throw Http20Draft14.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            }
            break; /* Loop/switch isn't completed */
_L6:
            j = 4;
_L12:
            settings.set(j, 0, k);
            byte0 += 6;
            if (true) goto _L10; else goto _L9
_L9:
            j = 7;
            if (k >= 0) goto _L12; else goto _L11
_L11:
            throw Http20Draft14.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
_L8:
            if (k < 16384)
            {
                break; /* Loop/switch isn't completed */
            }
            j = word0;
            if (k <= 0xffffff) goto _L12; else goto _L13
_L13:
            throw Http20Draft14.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] {
                Integer.valueOf(k)
            });
            handler.settings(false, settings);
            if (settings.getHeaderTableSize() >= 0)
            {
                hpackReader.maxHeaderTableByteCountSetting(settings.getHeaderTableSize());
                return;
            }
            if (true) goto _L15; else goto _L14
_L14:
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, byte byte0, int j)
        {
            if (i != 4)
            {
                throw Http20Draft14.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            long l = (long)source.j() & 0x7fffffffL;
            if (l == 0L)
            {
                throw Http20Draft14.ioException("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                handler.windowUpdate(j, l);
                return;
            }
        }

        public void close()
        {
            source.close();
        }

        public boolean nextFrame(FrameReader.Handler handler)
        {
            int i;
            try
            {
                source.a(9L);
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            i = Http20Draft14.readMedium(source);
            if (i < 0 || i > 16384)
            {
                throw Http20Draft14.ioException("FRAME_SIZE_ERROR: %s", new Object[] {
                    Integer.valueOf(i)
                });
            }
            byte byte0 = (byte)(source.h() & 0xff);
            byte byte1 = (byte)(source.h() & 0xff);
            int j = source.j() & 0x7fffffff;
            if (Internal.logger.isLoggable(Level.FINE))
            {
                Internal.logger.fine(FrameLogger.formatHeader(true, j, i, byte0, byte1));
            }
            switch (byte0)
            {
            default:
                source.g(i);
                return true;

            case 0: // '\0'
                readData(handler, i, byte1, j);
                return true;

            case 1: // '\001'
                readHeaders(handler, i, byte1, j);
                return true;

            case 2: // '\002'
                readPriority(handler, i, byte1, j);
                return true;

            case 3: // '\003'
                readRstStream(handler, i, byte1, j);
                return true;

            case 4: // '\004'
                readSettings(handler, i, byte1, j);
                return true;

            case 5: // '\005'
                readPushPromise(handler, i, byte1, j);
                return true;

            case 6: // '\006'
                readPing(handler, i, byte1, j);
                return true;

            case 7: // '\007'
                readGoAway(handler, i, byte1, j);
                return true;

            case 8: // '\b'
                readWindowUpdate(handler, i, byte1, j);
                break;
            }
            return true;
        }

        public void readConnectionPreface()
        {
            if (!client)
            {
                ByteString bytestring = source.c(Http20Draft14.CONNECTION_PREFACE.e());
                if (Internal.logger.isLoggable(Level.FINE))
                {
                    Internal.logger.fine(String.format("<< CONNECTION %s", new Object[] {
                        bytestring.c()
                    }));
                }
                if (!Http20Draft14.CONNECTION_PREFACE.equals(bytestring))
                {
                    throw Http20Draft14.ioException("Expected a connection header but was %s", new Object[] {
                        bytestring.a()
                    });
                }
            }
        }

        Reader(f f1, int i, boolean flag)
        {
            source = f1;
            client = flag;
            continuation = new ContinuationSource(source);
            hpackReader = new HpackDraft09.Reader(i, continuation);
        }
    }


    private class Writer
        implements FrameWriter
    {

        private final boolean client;
        private boolean closed;
        private final d hpackBuffer = new d();
        private final HpackDraft09.Writer hpackWriter;
        private int maxFrameSize;
        private final e sink;

        private void writeContinuationFrames(int i, long l)
        {
            while (l > 0L) 
            {
                int j = (int)Math.min(maxFrameSize, l);
                l -= j;
                byte byte0;
                if (l == 0L)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                frameHeader(i, j, (byte)9, byte0);
                sink.write(hpackBuffer, j);
            }
        }

        public void ackSettings(Settings settings1)
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
            maxFrameSize = settings1.getMaxFrameSize(maxFrameSize);
            frameHeader(0, 0, (byte)4, (byte)1);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void close()
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

        public void connectionPreface()
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
            if (Internal.logger.isLoggable(Level.FINE))
            {
                Internal.logger.fine(String.format(">> CONNECTION %s", new Object[] {
                    Http20Draft14.CONNECTION_PREFACE.c()
                }));
            }
            sink.c(Http20Draft14.CONNECTION_PREFACE.f());
            sink.flush();
              goto _L1
        }

        public void data(boolean flag, int i, d d1, int j)
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            d1;
            this;
            JVM INSTR monitorexit ;
            throw d1;
            byte byte0;
            byte0 = 0;
            if (flag)
            {
                byte0 = (byte)1;
            }
            dataFrame(i, byte0, d1, j);
            this;
            JVM INSTR monitorexit ;
        }

        void dataFrame(int i, byte byte0, d d1, int j)
        {
            frameHeader(i, j, (byte)0, byte0);
            if (j > 0)
            {
                sink.write(d1, j);
            }
        }

        public void flush()
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

        void frameHeader(int i, int j, byte byte0, byte byte1)
        {
            if (Internal.logger.isLoggable(Level.FINE))
            {
                Internal.logger.fine(FrameLogger.formatHeader(false, i, j, byte0, byte1));
            }
            if (j > maxFrameSize)
            {
                throw Http20Draft14.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] {
                    Integer.valueOf(maxFrameSize), Integer.valueOf(j)
                });
            }
            if ((0x80000000 & i) != 0)
            {
                throw Http20Draft14.illegalArgument("reserved bit set: %s", new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                Http20Draft14.writeMedium(sink, j);
                sink.g(byte0 & 0xff);
                sink.g(byte1 & 0xff);
                sink.e(0x7fffffff & i);
                return;
            }
        }

        public void goAway(int i, ErrorCode errorcode, byte abyte0[])
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
                throw Http20Draft14.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
            frameHeader(0, abyte0.length + 8, (byte)7, (byte)0);
            sink.e(i);
            sink.e(errorcode.httpCode);
            if (abyte0.length > 0)
            {
                sink.c(abyte0);
            }
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void headers(int i, List list)
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
            headers(false, i, list);
            this;
            JVM INSTR monitorexit ;
        }

        void headers(boolean flag, int i, List list)
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if (hpackBuffer.a() != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            long l = hpackBuffer.a();
            int j = (int)Math.min(maxFrameSize, l);
            byte byte0;
            byte byte1;
            if (l == (long)j)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            byte1 = byte0;
            if (flag)
            {
                byte1 = (byte)(byte0 | 1);
            }
            frameHeader(i, j, (byte)1, byte1);
            sink.write(hpackBuffer, j);
            if (l > (long)j)
            {
                writeContinuationFrames(i, l - (long)j);
            }
        }

        public int maxDataLength()
        {
            return maxFrameSize;
        }

        public void ping(boolean flag, int i, int j)
        {
            byte byte0 = 0;
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_29;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            if (flag)
            {
                byte0 = 1;
            }
            frameHeader(0, 8, (byte)6, byte0);
            sink.e(i);
            sink.e(j);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void pushPromise(int i, int j, List list)
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
            int k;
            long l;
            if (hpackBuffer.a() != 0L)
            {
                throw new IllegalStateException();
            }
            hpackWriter.writeHeaders(list);
            l = hpackBuffer.a();
            k = (int)Math.min(maxFrameSize - 4, l);
            byte byte0;
            if (l == (long)k)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            frameHeader(i, k + 4, (byte)5, byte0);
            sink.e(0x7fffffff & j);
            sink.write(hpackBuffer, k);
            if (l <= (long)k)
            {
                break MISSING_BLOCK_LABEL_150;
            }
            writeContinuationFrames(i, l - (long)k);
            this;
            JVM INSTR monitorexit ;
        }

        public void rstStream(int i, ErrorCode errorcode)
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
            frameHeader(i, 4, (byte)3, (byte)0);
            sink.e(errorcode.httpCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void settings(Settings settings1)
        {
            int i = 0;
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            settings1;
            this;
            JVM INSTR monitorexit ;
            throw settings1;
            frameHeader(0, settings1.size() * 6, (byte)4, (byte)0);
_L6:
            if (i >= 10) goto _L2; else goto _L1
_L1:
            if (settings1.isSet(i)) goto _L4; else goto _L3
_L5:
            int j;
            sink.f(j);
            sink.e(settings1.get(i));
              goto _L3
_L2:
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
_L8:
            j = i;
              goto _L5
_L3:
            i++;
              goto _L6
_L4:
            if (i != 4)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = 3;
              goto _L5
            if (i != 7) goto _L8; else goto _L7
_L7:
            j = 4;
              goto _L5
        }

        public void synReply(boolean flag, int i, List list)
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
            headers(flag, i, list);
            this;
            JVM INSTR monitorexit ;
        }

        public void synStream(boolean flag, boolean flag1, int i, int j, List list)
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
            headers(flag, i, list);
            this;
            JVM INSTR monitorexit ;
        }

        public void windowUpdate(int i, long l)
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
            throw Http20Draft14.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
                Long.valueOf(l)
            });
            frameHeader(i, 4, (byte)8, (byte)0);
            sink.e((int)l);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        Writer(e e1, boolean flag)
        {
            sink = e1;
            client = flag;
            hpackWriter = new HpackDraft09.Writer(hpackBuffer);
            maxFrameSize = 16384;
        }
    }

}
