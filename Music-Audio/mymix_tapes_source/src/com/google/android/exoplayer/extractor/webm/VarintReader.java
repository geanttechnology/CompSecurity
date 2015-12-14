// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader
{

    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final int VARINT_LENGTH_MASKS[] = {
        128, 64, 32, 16, 8, 4, 2, 1
    };
    private int length;
    private final byte scratch[] = new byte[8];
    private int state;

    public VarintReader()
    {
    }

    public int getLastLength()
    {
        return length;
    }

    public long readUnsignedVarint(ExtractorInput extractorinput, boolean flag, boolean flag1)
        throws IOException, InterruptedException
    {
label0:
        {
            if (state != 0)
            {
                break label0;
            }
            if (!extractorinput.readFully(scratch, 0, 1, flag))
            {
                return -1L;
            }
            byte byte0 = scratch[0];
            length = -1;
            int i = 0;
label1:
            do
            {
label2:
                {
                    if (i < VARINT_LENGTH_MASKS.length)
                    {
                        if ((VARINT_LENGTH_MASKS[i] & (byte0 & 0xff)) == 0)
                        {
                            break label2;
                        }
                        length = i + 1;
                    }
                    if (length == -1)
                    {
                        throw new IllegalStateException("No valid varint length mask found");
                    }
                    break label1;
                }
                i++;
            } while (true);
            state = 1;
        }
        extractorinput.readFully(scratch, 1, length - 1);
        if (flag1)
        {
            extractorinput = scratch;
            extractorinput[0] = (byte)(extractorinput[0] & ~VARINT_LENGTH_MASKS[length - 1]);
        }
        long l = 0L;
        for (int j = 0; j < length; j++)
        {
            l = l << 8 | (long)(scratch[j] & 0xff);
        }

        state = 0;
        return l;
    }

    public void reset()
    {
        state = 0;
        length = 0;
    }

}
