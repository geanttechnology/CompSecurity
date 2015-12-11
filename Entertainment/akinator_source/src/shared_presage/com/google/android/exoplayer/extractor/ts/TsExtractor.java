// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import shared_presage.com.google.android.exoplayer.audio.AudioCapabilities;
import shared_presage.com.google.android.exoplayer.extractor.Extractor;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.extractor.PositionHolder;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            f, c, g, b, 
//            a, d, i, e

public final class TsExtractor
    implements Extractor
{
    private final class a extends d
    {

        final TsExtractor a;
        private final ParsableBitArray b = new ParsableBitArray(new byte[4]);

        public final void a()
        {
        }

        public final void a(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
        {
            if (flag)
            {
                parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
            }
            parsablebytearray.readBytes(b, 3);
            b.skipBits(12);
            int i = b.readBits(12);
            parsablebytearray.skipBytes(5);
            int k = (i - 9) / 4;
            for (int j = 0; j < k; j++)
            {
                parsablebytearray.readBytes(b, 4);
                b.skipBits(19);
                int l = b.readBits(13);
                a.tsPayloadReaders.put(l, a. new c());
            }

        }

        public a()
        {
            a = TsExtractor.this;
            super((byte)0);
        }
    }

    private final class b extends d
    {

        final TsExtractor a;
        private final ParsableBitArray b = new ParsableBitArray(new byte[9]);
        private final shared_presage.com.google.android.exoplayer.extractor.ts.c c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;
        private long j;

        private void a(int k)
        {
            d = k;
            e = 0;
        }

        private boolean a(ParsableByteArray parsablebytearray, byte abyte0[], int k)
        {
            int l = Math.min(parsablebytearray.bytesLeft(), k - e);
            if (l > 0)
            {
                if (abyte0 == null)
                {
                    parsablebytearray.skipBytes(l);
                } else
                {
                    parsablebytearray.readBytes(abyte0, e, l);
                }
                e = l + e;
                if (e != k)
                {
                    return false;
                }
            }
            return true;
        }

        public final void a()
        {
            d = 0;
            e = 0;
            f = false;
            c.a();
        }

        public final void a(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
        {
            if (!flag) goto _L2; else goto _L1
_L1:
            d;
            JVM INSTR tableswitch 0 3: default 40
        //                       0 40
        //                       1 40
        //                       2 102
        //                       3 113;
               goto _L3 _L3 _L3 _L4 _L5
_L3:
            a(1);
_L2:
            if (parsablebytearray.bytesLeft() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            switch (d)
            {
            case 0: // '\0'
                parsablebytearray.skipBytes(parsablebytearray.bytesLeft());
                break;

            case 1: // '\001'
                if (a(parsablebytearray, b.data, 9))
                {
                    b.setPosition(0);
                    int k = b.readBits(24);
                    if (k != 1)
                    {
                        Log.w("TsExtractor", (new StringBuilder("Unexpected start code prefix: ")).append(k).toString());
                        i = -1;
                        k = 0;
                    } else
                    {
                        b.skipBits(8);
                        k = b.readBits(16);
                        b.skipBits(8);
                        g = b.readBit();
                        b.skipBits(7);
                        h = b.readBits(8);
                        if (k == 0)
                        {
                            i = -1;
                        } else
                        {
                            i = (k + 6) - 9 - h;
                        }
                        k = 1;
                    }
                    if (k != 0)
                    {
                        k = 2;
                    } else
                    {
                        k = 0;
                    }
                    a(k);
                }
                break;

            case 2: // '\002'
                int l = Math.min(5, h);
                if (a(parsablebytearray, b.data, l) && a(parsablebytearray, ((byte []) (null)), h))
                {
                    b.setPosition(0);
                    j = 0L;
                    if (g)
                    {
                        b.skipBits(4);
                        long l1 = b.readBits(3);
                        b.skipBits(1);
                        long l3 = b.readBits(15) << 15;
                        b.skipBits(1);
                        long l4 = b.readBits(15);
                        b.skipBits(1);
                        j = a.ptsToTimeUs(l1 << 30 | l3 | l4);
                    }
                    f = false;
                    a(3);
                }
                break;

            case 3: // '\003'
                int k1 = parsablebytearray.bytesLeft();
                int i1;
                int j1;
                long l2;
                if (i == -1)
                {
                    i1 = 0;
                } else
                {
                    i1 = k1 - i;
                }
                j1 = k1;
                if (i1 > 0)
                {
                    j1 = k1 - i1;
                    parsablebytearray.setLimit(parsablebytearray.getPosition() + j1);
                }
                extractoroutput = c;
                l2 = j;
                if (!f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                extractoroutput.a(parsablebytearray, l2, flag);
                f = true;
                if (i != -1)
                {
                    i = i - j1;
                    if (i == 0)
                    {
                        c.b();
                        a(1);
                    }
                }
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            Log.w("TsExtractor", "Unexpected start indicator reading extended header");
            continue; /* Loop/switch isn't completed */
_L5:
            if (i != -1)
            {
                Log.w("TsExtractor", (new StringBuilder("Unexpected start indicator: expected ")).append(i).append(" more bytes").toString());
            }
            if (f)
            {
                c.b();
            }
            continue; /* Loop/switch isn't completed */
            if (true) goto _L2; else goto _L6
_L6:
            return;
            if (true) goto _L3; else goto _L7
_L7:
        }

        public b(shared_presage.com.google.android.exoplayer.extractor.ts.c c1)
        {
            a = TsExtractor.this;
            super((byte)0);
            c = c1;
            d = 0;
        }
    }

    private final class c extends d
    {

        final TsExtractor a;
        private final ParsableBitArray b = new ParsableBitArray(new byte[5]);

        public final void a()
        {
        }

        public final void a(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput)
        {
            int j;
            if (flag)
            {
                parsablebytearray.skipBytes(parsablebytearray.readUnsignedByte());
            }
            parsablebytearray.readBytes(b, 3);
            b.skipBits(12);
            j = b.readBits(12);
            parsablebytearray.skipBytes(7);
            parsablebytearray.readBytes(b, 2);
            b.skipBits(4);
            int k = b.readBits(12);
            parsablebytearray.skipBytes(k);
            if (a.id3Reader == null)
            {
                a.id3Reader = new f(extractoroutput.track(21));
            }
            j = j - 9 - k - 4;
_L12:
            if (j <= 0) goto _L2; else goto _L1
_L1:
            Object obj;
            int l;
            int i1;
            parsablebytearray.readBytes(b, 5);
            l = b.readBits(8);
            b.skipBits(3);
            i1 = b.readBits(13);
            b.skipBits(4);
            int j1 = b.readBits(12);
            parsablebytearray.skipBytes(j1);
            j -= j1 + 5;
            if (a.streamTypes.get(l))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = null;
            l;
            JVM INSTR lookupswitch 8: default 296
        //                       3: 342
        //                       4: 361
        //                       15: 380
        //                       21: 514
        //                       27: 435
        //                       36: 478
        //                       129: 400
        //                       135: 400;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L3:
            if (obj != null)
            {
                a.streamTypes.put(l, true);
                a.tsPayloadReaders.put(i1, a. new b(((shared_presage.com.google.android.exoplayer.extractor.ts.c) (obj))));
            }
            continue; /* Loop/switch isn't completed */
_L4:
            obj = new g(extractoroutput.track(3));
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new g(extractoroutput.track(4));
            continue; /* Loop/switch isn't completed */
_L6:
            obj = new shared_presage.com.google.android.exoplayer.extractor.ts.b(extractoroutput.track(15));
            continue; /* Loop/switch isn't completed */
_L10:
            if (!a.allowedPassthroughStreamTypes.get(l))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = new shared_presage.com.google.android.exoplayer.extractor.ts.a(extractoroutput.track(l));
            continue; /* Loop/switch isn't completed */
_L8:
            obj = new shared_presage.com.google.android.exoplayer.extractor.ts.d(extractoroutput.track(27), new i(extractoroutput.track(256)), a.idrKeyframesOnly);
            continue; /* Loop/switch isn't completed */
_L9:
            obj = new e(extractoroutput.track(36), new i(extractoroutput.track(256)));
            continue; /* Loop/switch isn't completed */
_L7:
            obj = a.id3Reader;
            if (true) goto _L3; else goto _L2
_L2:
            extractoroutput.endTracks();
            return;
            if (true) goto _L12; else goto _L11
_L11:
        }

        public c()
        {
            a = TsExtractor.this;
            super((byte)0);
        }
    }

    private static abstract class d
    {

        public abstract void a();

        public abstract void a(ParsableByteArray parsablebytearray, boolean flag, ExtractorOutput extractoroutput);

        private d()
        {
        }

        d(byte byte0)
        {
            this();
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
    f id3Reader;
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
        tsPayloadReaders.put(0, new a());
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
            audiocapabilities.supportsEncoding(6);
        }
        return sparsebooleanarray;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        output = extractoroutput;
        extractoroutput.seekMap(SeekMap.UNSEEKABLE);
    }

    final long ptsToTimeUs(long l)
    {
        if (lastPts != 0x8000000000000000L)
        {
            long l3 = (lastPts + 0xffffffffL) / 0x1ffffffffL;
            long l1 = (l3 - 1L) * 0x1ffffffffL + l;
            l = l3 * 0x1ffffffffL + l;
            if (Math.abs(l1 - lastPts) < Math.abs(l - lastPts))
            {
                l = l1;
            }
        }
        long l2 = (0xf4240L * l) / 0x15f90L;
        if (lastPts == 0x8000000000000000L)
        {
            timestampOffsetUs = firstSampleTimestampUs - l2;
        }
        lastPts = l;
        return timestampOffsetUs + l2;
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        if (!extractorinput.readFully(tsPacketBuffer.data, 0, 188, true))
        {
            return -1;
        }
        tsPacketBuffer.setPosition(0);
        tsPacketBuffer.setLimit(188);
        if (tsPacketBuffer.readUnsignedByte() != 71)
        {
            return 0;
        }
        tsPacketBuffer.readBytes(tsScratch, 3);
        tsScratch.skipBits(1);
        boolean flag = tsScratch.readBit();
        tsScratch.skipBits(1);
        int i = tsScratch.readBits(13);
        tsScratch.skipBits(2);
        boolean flag1 = tsScratch.readBit();
        boolean flag2 = tsScratch.readBit();
        if (flag1)
        {
            int j = tsPacketBuffer.readUnsignedByte();
            tsPacketBuffer.skipBytes(j);
        }
        if (flag2)
        {
            extractorinput = (d)tsPayloadReaders.get(i);
            if (extractorinput != null)
            {
                extractorinput.a(tsPacketBuffer, flag, output);
            }
        }
        return 0;
    }

    public final void seek()
    {
        timestampOffsetUs = 0L;
        lastPts = 0x8000000000000000L;
        for (int i = 0; i < tsPayloadReaders.size(); i++)
        {
            ((d)tsPayloadReaders.valueAt(i)).a();
        }

    }

    public final boolean sniff(ExtractorInput extractorinput)
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
