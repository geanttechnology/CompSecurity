// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            TsExtractor, ElementaryStreamReader

private class state extends eader
{

    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 5;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private boolean bodyStarted;
    private int bytesRead;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ElementaryStreamReader pesPayloadReader;
    private final ParsableBitArray pesScratch = new ParsableBitArray(new byte[9]);
    private boolean ptsFlag;
    private int state;
    final TsExtractor this$0;
    private long timeUs;

    private boolean continueRead(ParsableByteArray parsablebytearray, byte abyte0[], int i)
    {
        int j = Math.min(parsablebytearray.bytesLeft(), i - bytesRead);
        if (j > 0)
        {
            if (abyte0 == null)
            {
                parsablebytearray.skipBytes(j);
            } else
            {
                parsablebytearray.readBytes(abyte0, bytesRead, j);
            }
            bytesRead = bytesRead + j;
            if (bytesRead != i)
            {
                return false;
            }
        }
        return true;
    }

    private boolean parseHeader()
    {
        pesScratch.setPosition(0);
        int i = pesScratch.readBits(24);
        if (i != 1)
        {
            Log.w("TsExtractor", (new StringBuilder()).append("Unexpected start code prefix: ").append(i).toString());
            payloadSize = -1;
            return false;
        }
        pesScratch.skipBits(8);
        i = pesScratch.readBits(16);
        pesScratch.skipBits(8);
        ptsFlag = pesScratch.readBit();
        pesScratch.skipBits(7);
        extendedHeaderLength = pesScratch.readBits(8);
        if (i == 0)
        {
            payloadSize = -1;
        } else
        {
            payloadSize = (i + 6) - 9 - extendedHeaderLength;
        }
        return true;
    }

    private void parseHeaderExtension()
    {
        pesScratch.setPosition(0);
        timeUs = 0L;
        if (ptsFlag)
        {
            pesScratch.skipBits(4);
            long l = pesScratch.readBits(3);
            pesScratch.skipBits(1);
            long l1 = pesScratch.readBits(15) << 15;
            pesScratch.skipBits(1);
            long l2 = pesScratch.readBits(15);
            pesScratch.skipBits(1);
            timeUs = ptsToTimeUs(l << 30 | l1 | l2);
        }
    }

    private void setState(int i)
    {
        state = i;
        bytesRead = 0;
    }

    public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        state;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 40
    //                   1 40
    //                   2 102
    //                   3 113;
           goto _L3 _L3 _L3 _L4 _L5
_L3:
        setState(1);
_L2:
        if (parsablebytearray.bytesLeft() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        switch (state)
        {
        case 0: // '\0'
            parsablebytearray.skipBytes(parsablebytearray.bytesLeft());
            break;

        case 1: // '\001'
            if (continueRead(parsablebytearray, pesScratch.data, 9))
            {
                byte byte0;
                if (parseHeader())
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 0;
                }
                setState(byte0);
            }
            break;

        case 2: // '\002'
            int i = Math.min(5, extendedHeaderLength);
            if (continueRead(parsablebytearray, pesScratch.data, i) && continueRead(parsablebytearray, null, extendedHeaderLength))
            {
                parseHeaderExtension();
                bodyStarted = false;
                setState(3);
            }
            break;

        case 3: // '\003'
            int l = parsablebytearray.bytesLeft();
            int j;
            int k;
            long l1;
            if (payloadSize == -1)
            {
                j = 0;
            } else
            {
                j = l - payloadSize;
            }
            k = l;
            if (j > 0)
            {
                k = l - j;
                parsablebytearray.setLimit(parsablebytearray.getPosition() + k);
            }
            extractoroutput = pesPayloadReader;
            l1 = timeUs;
            if (!bodyStarted)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            extractoroutput.consume(parsablebytearray, l1, flag);
            bodyStarted = true;
            if (payloadSize != -1)
            {
                payloadSize = payloadSize - k;
                if (payloadSize == 0)
                {
                    pesPayloadReader.packetFinished();
                    setState(1);
                }
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Log.w("TsExtractor", "Unexpected start indicator reading extended header");
        continue; /* Loop/switch isn't completed */
_L5:
        if (payloadSize != -1)
        {
            Log.w("TsExtractor", (new StringBuilder()).append("Unexpected start indicator: expected ").append(payloadSize).append(" more bytes").toString());
        }
        if (bodyStarted)
        {
            pesPayloadReader.packetFinished();
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L6
_L6:
        return;
        if (true) goto _L3; else goto _L7
_L7:
    }

    public void seek()
    {
        state = 0;
        bytesRead = 0;
        bodyStarted = false;
        pesPayloadReader.seek();
    }

    public (ElementaryStreamReader elementarystreamreader)
    {
        this$0 = TsExtractor.this;
        super(null);
        pesPayloadReader = elementarystreamreader;
        state = 0;
    }
}
