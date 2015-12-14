// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer
{

    private static final int ID_EBML = 0x1a45dfa3;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    public Sniffer()
    {
    }

    private long readUint(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        extractorinput.peekFully(scratch.data, 0, 1);
        int l = scratch.data[0] & 0xff;
        if (l == 0)
        {
            return 0x8000000000000000L;
        }
        int j = 128;
        int i;
        for (i = 0; (l & j) == 0; i++)
        {
            j >>= 1;
        }

        l &= ~j;
        extractorinput.peekFully(scratch.data, 1, i);
        for (int k = 0; k < i; k++)
        {
            l = (l << 8) + (scratch.data[k + 1] & 0xff);
        }

        peekLength = peekLength + (i + 1);
        return (long)l;
    }

    public boolean sniff(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        long l;
        long l2;
        long l3;
        long l1 = extractorinput.getLength();
        int i;
        if (l1 == -1L || l1 > 1024L)
        {
            l = 1024L;
        } else
        {
            l = l1;
        }
        i = (int)l;
        extractorinput.peekFully(scratch.data, 0, 4);
        l = scratch.readUnsignedInt();
        peekLength = 4;
        for (; l != 0x1a45dfa3L; l = l << 8 & -256L | (long)(scratch.data[0] & 0xff))
        {
            int j = peekLength + 1;
            peekLength = j;
            if (j == i)
            {
                return false;
            }
            extractorinput.peekFully(scratch.data, 0, 1);
        }

        l = readUint(extractorinput);
        l3 = peekLength;
        if (l == 0x8000000000000000L || l1 != -1L && l3 + l >= l1)
        {
            return false;
        }
_L3:
        if ((long)peekLength < l3 + l)
        {
            if (readUint(extractorinput) == 0x8000000000000000L)
            {
                return false;
            }
            l2 = readUint(extractorinput);
            if (l2 < 0L || l2 > 0x7fffffffL)
            {
                return false;
            }
        } else
        {
            return (long)peekLength == l3 + l;
        }
        if (true) goto _L2; else goto _L1
_L2:
        if (l2 != 0L)
        {
            extractorinput.advancePeekPosition((int)l2);
            peekLength = (int)((long)peekLength + l2);
        }
        if (true) goto _L3; else goto _L1
_L1:
    }
}
