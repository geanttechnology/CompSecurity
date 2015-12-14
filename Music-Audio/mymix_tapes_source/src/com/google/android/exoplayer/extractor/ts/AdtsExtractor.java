// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            AdtsReader

public final class AdtsExtractor
    implements Extractor
{

    private static final int MAX_PACKET_SIZE = 200;
    private AdtsReader adtsReader;
    private boolean firstPacket;
    private final long firstSampleTimestampUs;
    private final ParsableByteArray packetBuffer;

    public AdtsExtractor()
    {
        this(0L);
    }

    public AdtsExtractor(long l)
    {
        firstSampleTimestampUs = l;
        packetBuffer = new ParsableByteArray(200);
        firstPacket = true;
    }

    public void init(ExtractorOutput extractoroutput)
    {
        adtsReader = new AdtsReader(extractoroutput.track(0));
        extractoroutput.endTracks();
        extractoroutput.seekMap(SeekMap.UNSEEKABLE);
    }

    public int read(ExtractorInput extractorinput, PositionHolder positionholder)
        throws IOException, InterruptedException
    {
        int i = extractorinput.read(packetBuffer.data, 0, 200);
        if (i == -1)
        {
            return -1;
        } else
        {
            packetBuffer.setPosition(0);
            packetBuffer.setLimit(i);
            adtsReader.consume(packetBuffer, firstSampleTimestampUs, firstPacket);
            firstPacket = false;
            return 0;
        }
    }

    public void seek()
    {
        firstPacket = true;
        adtsReader.seek();
    }

    public boolean sniff(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        boolean flag = false;
        ParsableByteArray parsablebytearray = new ParsableByteArray(10);
        extractorinput.peekFully(parsablebytearray.data, 0, 10);
        int i = parsablebytearray.readUnsignedInt24();
        if (i != Util.getIntegerCodeForString("ID3"))
        {
            i >>= 8;
        } else
        {
            extractorinput.advancePeekPosition((parsablebytearray.data[6] & 0x7f) << 21 | (parsablebytearray.data[7] & 0x7f) << 14 | (parsablebytearray.data[8] & 0x7f) << 7 | parsablebytearray.data[9] & 0x7f);
            extractorinput.peekFully(parsablebytearray.data, 0, 2);
            parsablebytearray.setPosition(0);
            i = parsablebytearray.readUnsignedShort();
        }
        if ((0xfff6 & i) == 65520)
        {
            flag = true;
        }
        return flag;
    }
}
