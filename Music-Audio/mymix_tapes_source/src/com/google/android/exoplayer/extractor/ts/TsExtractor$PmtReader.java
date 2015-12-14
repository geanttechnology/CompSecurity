// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            TsExtractor, Id3Reader, MpegAudioReader, AdtsReader, 
//            Ac3Reader, H264Reader, SeiReader, H265Reader

private class eader extends eader
{

    private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
    final TsExtractor this$0;

    public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
    {
        int i;
        if (flag)
        {
            parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
        }
        parsablebytearray.readBytes(pmtScratch, 3);
        pmtScratch.skipBits(12);
        i = pmtScratch.readBits(12);
        parsablebytearray.skipBytes(7);
        parsablebytearray.readBytes(pmtScratch, 2);
        pmtScratch.skipBits(4);
        int j = pmtScratch.readBits(12);
        parsablebytearray.skipBytes(j);
        if (id3Reader == null)
        {
            id3Reader = new Id3Reader(extractoroutput.track(21));
        }
        i = i - 9 - j - 4;
_L12:
        if (i <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int k;
        int l;
        int i1;
        parsablebytearray.readBytes(pmtScratch, 5);
        l = pmtScratch.readBits(8);
        pmtScratch.skipBits(3);
        i1 = pmtScratch.readBits(13);
        pmtScratch.skipBits(4);
        k = pmtScratch.readBits(12);
        parsablebytearray.skipBytes(k);
        k = i - (k + 5);
        i = k;
        if (streamTypes.get(l))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        l;
        JVM INSTR lookupswitch 8: default 300
    //                   3: 354
    //                   4: 373
    //                   15: 392
    //                   21: 530
    //                   27: 451
    //                   36: 494
    //                   129: 412
    //                   135: 412;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L3:
        i = k;
        if (obj != null)
        {
            streamTypes.put(l, true);
            tsPayloadReaders.put(i1, new <init>(TsExtractor.this, ((ElementaryStreamReader) (obj))));
            i = k;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new MpegAudioReader(extractoroutput.track(3));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new MpegAudioReader(extractoroutput.track(4));
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new AdtsReader(extractoroutput.track(15));
        continue; /* Loop/switch isn't completed */
_L10:
        i = k;
        if (!allowedPassthroughStreamTypes.get(l))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new Ac3Reader(extractoroutput.track(l));
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new H264Reader(extractoroutput.track(27), new SeiReader(extractoroutput.track(256)), TsExtractor.access$100(TsExtractor.this));
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new H265Reader(extractoroutput.track(36), new SeiReader(extractoroutput.track(256)));
        continue; /* Loop/switch isn't completed */
_L7:
        obj = id3Reader;
        if (true) goto _L3; else goto _L2
_L2:
        extractoroutput.endTracks();
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public void seek()
    {
    }

    public eader()
    {
        this$0 = TsExtractor.this;
        super(null);
    }
}
