// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            Id3Reader, ElementaryStreamReader, MpegAudioReader, AdtsReader, 
//            Ac3Reader, H264Reader, SeiReader, H265Reader

public final class TsExtractor
    implements Extractor
{
    private class PatReader extends TsPayloadReader
    {

        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);
        final TsExtractor this$0;

        public void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
        {
            if (flag)
            {
                parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
            }
            parsablebytearray.readBytes(patScratch, 3);
            patScratch.skipBits(12);
            int i = patScratch.readBits(12);
            parsablebytearray.skipBytes(5);
            int k = (i - 9) / 4;
            for (int j = 0; j < k; j++)
            {
                parsablebytearray.readBytes(patScratch, 4);
                patScratch.skipBits(19);
                int l = patScratch.readBits(13);
                tsPayloadReaders.put(l, new PmtReader());
            }

        }

        public void seek()
        {
        }

        public PatReader()
        {
            this$0 = TsExtractor.this;
            super();
        }
    }

    private class PesReader extends TsPayloadReader
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
        //                       0 40
        //                       1 40
        //                       2 102
        //                       3 113;
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

        public PesReader(ElementaryStreamReader elementarystreamreader)
        {
            this$0 = TsExtractor.this;
            super();
            pesPayloadReader = elementarystreamreader;
            state = 0;
        }
    }

    private class PmtReader extends TsPayloadReader
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
        //                       3: 354
        //                       4: 373
        //                       15: 392
        //                       21: 530
        //                       27: 451
        //                       36: 494
        //                       129: 412
        //                       135: 412;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L3:
            i = k;
            if (obj != null)
            {
                streamTypes.put(l, true);
                tsPayloadReaders.put(i1, new PesReader(((ElementaryStreamReader) (obj))));
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
            obj = new H264Reader(extractoroutput.track(27), new SeiReader(extractoroutput.track(256)), idrKeyframesOnly);
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

        public PmtReader()
        {
            this$0 = TsExtractor.this;
            super();
        }
    }

    private static abstract class TsPayloadReader
    {

        public abstract void consume(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput);

        public abstract void seek();

        private TsPayloadReader()
        {
        }

    }


    private static final long MAX_PTS = 0x1ffffffffL;
    private static final String TAG = "TsExtractor";
    private static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    private static final int TS_STREAM_TYPE_AAC = 15;
    private static final int TS_STREAM_TYPE_ATSC_AC3 = 129;
    private static final int TS_STREAM_TYPE_ATSC_E_AC3 = 135;
    private static final int TS_STREAM_TYPE_EIA608 = 256;
    private static final int TS_STREAM_TYPE_H264 = 27;
    private static final int TS_STREAM_TYPE_H265 = 36;
    private static final int TS_STREAM_TYPE_ID3 = 21;
    private static final int TS_STREAM_TYPE_MPA = 3;
    private static final int TS_STREAM_TYPE_MPA_LSF = 4;
    private static final int TS_SYNC_BYTE = 71;
    final SparseBooleanArray allowedPassthroughStreamTypes;
    private final long firstSampleTimestampUs;
    Id3Reader id3Reader;
    private final boolean idrKeyframesOnly;
    private long lastPts;
    private ExtractorOutput output;
    final SparseBooleanArray streamTypes;
    private long timestampOffsetUs;
    private final ParsableByteArray tsPacketBuffer;
    final SparseArray tsPayloadReaders;
    private final ParsableBitArray tsScratch;

    public TsExtractor()
    {
        this(0L);
    }

    public TsExtractor(long l)
    {
        this(l, null);
    }

    public TsExtractor(long l, AudioCapabilities audiocapabilities)
    {
        this(l, audiocapabilities, true);
    }

    public TsExtractor(long l, AudioCapabilities audiocapabilities, boolean flag)
    {
        firstSampleTimestampUs = l;
        idrKeyframesOnly = flag;
        tsScratch = new ParsableBitArray(new byte[3]);
        tsPacketBuffer = new ParsableByteArray(188);
        streamTypes = new SparseBooleanArray();
        allowedPassthroughStreamTypes = getPassthroughStreamTypes(audiocapabilities);
        tsPayloadReaders = new SparseArray();
        tsPayloadReaders.put(0, new PatReader());
        lastPts = 0x8000000000000000L;
    }

    private static SparseBooleanArray getPassthroughStreamTypes(AudioCapabilities audiocapabilities)
    {
        SparseBooleanArray sparsebooleanarray = new SparseBooleanArray();
        if (audiocapabilities != null)
        {
            if (audiocapabilities.supportsEncoding(5))
            {
                sparsebooleanarray.put(129, true);
            }
            if (!audiocapabilities.supportsEncoding(6));
        }
        return sparsebooleanarray;
    }

    public void init(ExtractorOutput extractoroutput)
    {
        output = extractoroutput;
        extractoroutput.seekMap(SeekMap.UNSEEKABLE);
    }

    long ptsToTimeUs(long l)
    {
        long l1 = l;
        if (lastPts != 0x8000000000000000L)
        {
            long l2 = (lastPts + 0xffffffffL) / 0x1ffffffffL;
            l1 = l + 0x1ffffffffL * (l2 - 1L);
            l += 0x1ffffffffL * l2;
            if (Math.abs(l1 - lastPts) >= Math.abs(l - lastPts))
            {
                l1 = l;
            }
        }
        l = (0xf4240L * l1) / 0x15f90L;
        if (lastPts == 0x8000000000000000L)
        {
            timestampOffsetUs = firstSampleTimestampUs - l;
        }
        lastPts = l1;
        return timestampOffsetUs + l;
    }

    public int read(ExtractorInput extractorinput, PositionHolder positionholder)
        throws IOException, InterruptedException
    {
        boolean flag = false;
        int i;
        if (!extractorinput.readFully(tsPacketBuffer.data, 0, 188, true))
        {
            i = -1;
        } else
        {
            tsPacketBuffer.setPosition(0);
            tsPacketBuffer.setLimit(188);
            i = ((flag) ? 1 : 0);
            if (tsPacketBuffer.readUnsignedByte() == 71)
            {
                tsPacketBuffer.readBytes(tsScratch, 3);
                tsScratch.skipBits(1);
                boolean flag1 = tsScratch.readBit();
                tsScratch.skipBits(1);
                int j = tsScratch.readBits(13);
                tsScratch.skipBits(2);
                boolean flag2 = tsScratch.readBit();
                boolean flag3 = tsScratch.readBit();
                if (flag2)
                {
                    i = tsPacketBuffer.readUnsignedByte();
                    tsPacketBuffer.skipBytes(i);
                }
                i = ((flag) ? 1 : 0);
                if (flag3)
                {
                    extractorinput = (TsPayloadReader)tsPayloadReaders.get(j);
                    i = ((flag) ? 1 : 0);
                    if (extractorinput != null)
                    {
                        extractorinput.consume(tsPacketBuffer, flag1, output);
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public void seek()
    {
        timestampOffsetUs = 0L;
        lastPts = 0x8000000000000000L;
        for (int i = 0; i < tsPayloadReaders.size(); i++)
        {
            ((TsPayloadReader)tsPayloadReaders.valueAt(i)).seek();
        }

    }

    public boolean sniff(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        byte abyte0[] = new byte[1];
        for (int i = 0; i < 5; i++)
        {
            extractorinput.peekFully(abyte0, 0, 1);
            if ((abyte0[0] & 0xff) != 71)
            {
                return false;
            }
            extractorinput.advancePeekPosition(187);
        }

        return true;
    }

}
