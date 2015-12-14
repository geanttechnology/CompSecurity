// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.OutputStream;

final class QuotedPrintableEncoder
{

    private static final byte HEX_DIGITS[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        65, 66, 67, 68, 69, 70
    };
    private final boolean binary;
    private final byte inBuffer[];
    private int nextSoftBreak;
    private OutputStream out;
    private final byte outBuffer[];
    private int outputIndex;
    private boolean pendingCR;
    private boolean pendingSpace;
    private boolean pendingTab;

    public QuotedPrintableEncoder(int i, boolean flag)
    {
        inBuffer = new byte[i];
        outBuffer = new byte[i * 3];
        outputIndex = 0;
        nextSoftBreak = 77;
        out = null;
        binary = flag;
        pendingSpace = false;
        pendingTab = false;
        pendingCR = false;
    }

    private void clearPending()
        throws IOException
    {
        pendingSpace = false;
        pendingTab = false;
        pendingCR = false;
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
        if (byte0 == 61)
        {
            escape(byte0);
            return;
        } else
        {
            plain(byte0);
            return;
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

    void completeEncoding()
        throws IOException
    {
        writePending();
        flushOutput();
    }

    void encodeChunk(byte abyte0[], int i, int j)
        throws IOException
    {
        for (int k = i; k < j + i; k++)
        {
            encode(abyte0[k]);
        }

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

    void initEncoding(OutputStream outputstream)
    {
        out = outputstream;
        pendingSpace = false;
        pendingTab = false;
        pendingCR = false;
        nextSoftBreak = 77;
    }

}
