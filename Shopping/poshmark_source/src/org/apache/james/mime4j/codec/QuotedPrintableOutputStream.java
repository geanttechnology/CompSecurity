// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QuotedPrintableOutputStream extends FilterOutputStream
{

    private static final byte CR = 13;
    private static final int DEFAULT_BUFFER_SIZE = 3072;
    private static final byte DOT = 46;
    private static final byte EQ = 61;
    private static final byte HEX_DIGITS[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        65, 66, 67, 68, 69, 70
    };
    private static final byte LF = 10;
    private static final byte QUOTED_PRINTABLE_LAST_PLAIN = 126;
    private static final int QUOTED_PRINTABLE_MAX_LINE_LENGTH = 76;
    private static final int QUOTED_PRINTABLE_OCTETS_PER_ESCAPE = 3;
    private static final byte SP = 32;
    private static final byte TB = 9;
    private final boolean binary;
    private boolean closed;
    private int nextSoftBreak;
    private final byte outBuffer[];
    private int outputIndex;
    private boolean pendingCR;
    private boolean pendingSpace;
    private boolean pendingTab;
    private byte singleByte[];

    public QuotedPrintableOutputStream(int i, OutputStream outputstream, boolean flag)
    {
        super(outputstream);
        closed = false;
        singleByte = new byte[1];
        outBuffer = new byte[i];
        binary = flag;
        pendingSpace = false;
        pendingTab = false;
        pendingCR = false;
        outputIndex = 0;
        nextSoftBreak = 77;
    }

    public QuotedPrintableOutputStream(OutputStream outputstream, boolean flag)
    {
        this(3072, outputstream, flag);
    }

    private void clearPending()
        throws IOException
    {
        pendingSpace = false;
        pendingTab = false;
        pendingCR = false;
    }

    private void completeEncoding()
        throws IOException
    {
        writePending();
        flushOutput();
    }

    private void encode(byte byte0)
        throws IOException
    {
        if (byte0 != 10)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (binary)
        {
            writePending();
            escape(byte0);
            return;
        }
        if (!pendingCR) goto _L2; else goto _L1
_L1:
        if (!pendingSpace) goto _L4; else goto _L3
_L3:
        escape((byte)32);
_L5:
        lineBreak();
        clearPending();
        return;
_L4:
        if (pendingTab)
        {
            escape((byte)9);
        }
        if (true) goto _L5; else goto _L2
_L2:
        writePending();
        plain(byte0);
        return;
        if (byte0 == 13)
        {
            if (binary)
            {
                escape(byte0);
                return;
            } else
            {
                pendingCR = true;
                return;
            }
        }
        writePending();
        if (byte0 == 32)
        {
            if (binary)
            {
                escape(byte0);
                return;
            } else
            {
                pendingSpace = true;
                return;
            }
        }
        if (byte0 == 9)
        {
            if (binary)
            {
                escape(byte0);
                return;
            } else
            {
                pendingTab = true;
                return;
            }
        }
        if (byte0 < 32)
        {
            escape(byte0);
            return;
        }
        if (byte0 > 126)
        {
            escape(byte0);
            return;
        }
        if (byte0 == 61 || byte0 == 46)
        {
            escape(byte0);
            return;
        } else
        {
            plain(byte0);
            return;
        }
    }

    private void encodeChunk(byte abyte0[], int i, int j)
        throws IOException
    {
        for (int k = i; k < j + i; k++)
        {
            encode(abyte0[k]);
        }

    }

    private void escape(byte byte0)
        throws IOException
    {
        int i = nextSoftBreak - 1;
        nextSoftBreak = i;
        if (i <= 3)
        {
            softBreak();
        }
        byte0 &= 0xff;
        write((byte)61);
        nextSoftBreak = nextSoftBreak - 1;
        write(HEX_DIGITS[byte0 >> 4]);
        nextSoftBreak = nextSoftBreak - 1;
        write(HEX_DIGITS[byte0 % 16]);
    }

    private void lineBreak()
        throws IOException
    {
        write((byte)13);
        write((byte)10);
        nextSoftBreak = 76;
    }

    private void plain(byte byte0)
        throws IOException
    {
        int i = nextSoftBreak - 1;
        nextSoftBreak = i;
        if (i <= 1)
        {
            softBreak();
        }
        write(byte0);
    }

    private void softBreak()
        throws IOException
    {
        write((byte)61);
        lineBreak();
    }

    private void write(byte byte0)
        throws IOException
    {
        byte abyte0[] = outBuffer;
        int i = outputIndex;
        outputIndex = i + 1;
        abyte0[i] = byte0;
        if (outputIndex >= outBuffer.length)
        {
            flushOutput();
        }
    }

    private void writePending()
        throws IOException
    {
        if (!pendingSpace) goto _L2; else goto _L1
_L1:
        plain((byte)32);
_L4:
        clearPending();
        return;
_L2:
        if (pendingTab)
        {
            plain((byte)9);
        } else
        if (pendingCR)
        {
            plain((byte)13);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        }
        completeEncoding();
        closed = true;
        return;
        Exception exception;
        exception;
        closed = true;
        throw exception;
    }

    public void flush()
        throws IOException
    {
        flushOutput();
    }

    void flushOutput()
        throws IOException
    {
        if (outputIndex < outBuffer.length)
        {
            out.write(outBuffer, 0, outputIndex);
        } else
        {
            out.write(outBuffer);
        }
        outputIndex = 0;
    }

    public void write(int i)
        throws IOException
    {
        singleByte[0] = (byte)i;
        write(singleByte, 0, 1);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Stream has been closed");
        } else
        {
            encodeChunk(abyte0, i, j);
            return;
        }
    }

}
