// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.ByteString;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, Http20Draft09, ErrorCode, HeadersMode, 
//            Settings

static final class continuation
    implements FrameReader
{

    private final boolean client;
    private final ationSource continuation;
    final ationSource hpackReader;
    private final BufferedSource source;

    private void readData(continuation continuation1, short word0, byte byte0, int i)
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
        continuation1.ata(flag, i, source, word0);
    }

    private void readGoAway(source source1, short word0, byte byte0, int i)
        throws IOException
    {
        if (word0 < 8)
        {
            throw Http20Draft09.access$100("TYPE_GOAWAY length < 8: %s", new Object[] {
                Short.valueOf(word0)
            });
        }
        if (i != 0)
        {
            throw Http20Draft09.access$100("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        byte0 = source.readInt();
        i = source.readInt();
        int j = word0 - 8;
        ErrorCode errorcode = ErrorCode.fromHttp2(i);
        if (errorcode == null)
        {
            throw Http20Draft09.access$100("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                Integer.valueOf(i)
            });
        }
        ByteString bytestring = ByteString.EMPTY;
        if (j > 0)
        {
            bytestring = source.readByteString(j);
        }
        source1.oAway(byte0, errorcode, bytestring);
    }

    private List readHeaderBlock(short word0, byte byte0, int i)
        throws IOException
    {
        ationSource ationsource = continuation;
        continuation.left = word0;
        ationsource.length = word0;
        continuation.flags = byte0;
        continuation.streamId = i;
        hpackReader.eadHeaders();
        hpackReader.mitReferenceSet();
        return hpackReader.etAndReset();
    }

    private void readHeaders(etAndReset etandreset, short word0, byte byte0, int i)
        throws IOException
    {
        if (i == 0)
        {
            throw Http20Draft09.access$100("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
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
        etandreset.eaders(false, flag, i, -1, j, readHeaderBlock(word1, byte0, i), HeadersMode.HTTP_20_HEADERS);
    }

    private void readPing(EADERS eaders, short word0, byte byte0, int i)
        throws IOException
    {
        boolean flag = true;
        if (word0 != 8)
        {
            throw Http20Draft09.access$100("TYPE_PING length != 8: %s", new Object[] {
                Short.valueOf(word0)
            });
        }
        if (i != 0)
        {
            throw Http20Draft09.access$100("TYPE_PING streamId != 0", new Object[0]);
        }
        i = source.readInt();
        int j = source.readInt();
        if ((byte0 & 1) == 0)
        {
            flag = false;
        }
        eaders.ing(flag, i, j);
    }

    private void readPriority(ing ing, short word0, byte byte0, int i)
        throws IOException
    {
        if (word0 != 4)
        {
            throw Http20Draft09.access$100("TYPE_PRIORITY length: %d != 4", new Object[] {
                Short.valueOf(word0)
            });
        }
        if (i == 0)
        {
            throw Http20Draft09.access$100("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else
        {
            ing.riority(i, source.readInt() & 0x7fffffff);
            return;
        }
    }

    private void readPushPromise(t t, short word0, byte byte0, int i)
        throws IOException
    {
        if (i == 0)
        {
            throw Http20Draft09.access$100("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        } else
        {
            t.ushPromise(i, source.readInt() & 0x7fffffff, readHeaderBlock((short)(word0 - 4), byte0, i));
            return;
        }
    }

    private void readRstStream(readHeaderBlock readheaderblock, short word0, byte byte0, int i)
        throws IOException
    {
        if (word0 != 4)
        {
            throw Http20Draft09.access$100("TYPE_RST_STREAM length: %d != 4", new Object[] {
                Short.valueOf(word0)
            });
        }
        if (i == 0)
        {
            throw Http20Draft09.access$100("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        byte0 = source.readInt();
        ErrorCode errorcode = ErrorCode.fromHttp2(byte0);
        if (errorcode == null)
        {
            throw Http20Draft09.access$100("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                Integer.valueOf(byte0)
            });
        } else
        {
            readheaderblock.stStream(i, errorcode);
            return;
        }
    }

    private void readSettings(stStream ststream, short word0, byte byte0, int i)
        throws IOException
    {
        if (i != 0)
        {
            throw Http20Draft09.access$100("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((byte0 & 1) != 0)
        {
            if (word0 != 0)
            {
                throw Http20Draft09.access$100("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            ststream.ckSettings();
        } else
        {
            if (word0 % 8 != 0)
            {
                throw Http20Draft09.access$100("TYPE_SETTINGS length %% 8 != 0: %s", new Object[] {
                    Short.valueOf(word0)
                });
            }
            Settings settings = new Settings();
            for (byte0 = 0; byte0 < word0; byte0 += 8)
            {
                settings.set(source.readInt() & 0xffffff, 0, source.readInt());
            }

            ststream.ettings(false, settings);
            if (settings.getHeaderTableSize() >= 0)
            {
                hpackReader.axHeaderTableByteCount(settings.getHeaderTableSize());
                return;
            }
        }
    }

    private void readWindowUpdate(leSize lesize, short word0, byte byte0, int i)
        throws IOException
    {
        if (word0 != 4)
        {
            throw Http20Draft09.access$100("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                Short.valueOf(word0)
            });
        }
        long l = source.readInt() & 0x7fffffff;
        if (l == 0L)
        {
            throw Http20Draft09.access$100("windowSizeIncrement was 0", new Object[] {
                Long.valueOf(l)
            });
        } else
        {
            lesize.indowUpdate(i, l);
            return;
        }
    }

    public void close()
        throws IOException
    {
        source.close();
    }

    public boolean nextFrame(source source1)
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
        catch (source source1)
        {
            return false;
        }
        i = (short)((0x3fff0000 & j) >> 16);
        byte1 = (byte)((0xff00 & j) >> 8);
        byte0 = (byte)(j & 0xff);
        j = k & 0x7fffffff;
        byte1;
        JVM INSTR tableswitch 0 9: default 116
    //                   0 132
    //                   1 144
    //                   2 156
    //                   3 168
    //                   4 180
    //                   5 192
    //                   6 204
    //                   7 216
    //                   8 116
    //                   9 228;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L1 _L10
_L1:
        source.skip(i);
_L12:
        return true;
_L2:
        readData(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L3:
        readHeaders(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L4:
        readPriority(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L5:
        readRstStream(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L6:
        readSettings(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L7:
        readPushPromise(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L8:
        readPing(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L9:
        readGoAway(source1, i, byte0, j);
        continue; /* Loop/switch isn't completed */
_L10:
        readWindowUpdate(source1, i, byte0, j);
        if (true) goto _L12; else goto _L11
_L11:
    }

    public void readConnectionHeader()
        throws IOException
    {
        ByteString bytestring;
        if (!client)
        {
            if (!Http20Draft09.access$000().equals(bytestring = source.readByteString(Http20Draft09.access$000().size())))
            {
                throw Http20Draft09.access$100("Expected a connection header but was %s", new Object[] {
                    bytestring.utf8()
                });
            }
        }
    }

    ationSource(BufferedSource bufferedsource, int i, boolean flag)
    {
        source = bufferedsource;
        client = flag;
        continuation = new ationSource(source);
        hpackReader = new init>(flag, i, continuation);
    }
}
