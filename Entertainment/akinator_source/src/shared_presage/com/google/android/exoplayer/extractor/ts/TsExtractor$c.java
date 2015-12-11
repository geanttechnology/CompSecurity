// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            TsExtractor, f, g, b, 
//            a, d, i, e

private final class <init> extends <init>
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
    //                   3: 342
    //                   4: 361
    //                   15: 380
    //                   21: 514
    //                   27: 435
    //                   36: 478
    //                   129: 400
    //                   135: 400;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L3:
        if (obj != null)
        {
            a.streamTypes.put(l, true);
            a.tsPayloadReaders.put(i1, new <init>(a, ((c) (obj))));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new g(extractoroutput.track(3));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new g(extractoroutput.track(4));
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new b(extractoroutput.track(15));
        continue; /* Loop/switch isn't completed */
_L10:
        if (!a.allowedPassthroughStreamTypes.get(l))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new a(extractoroutput.track(l));
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new d(extractoroutput.track(27), new i(extractoroutput.track(256)), TsExtractor.access$100(a));
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

    public (TsExtractor tsextractor)
    {
        a = tsextractor;
        super((byte)0);
    }
}
