// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            TsExtractor

private final class <init> extends <init>
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
            a.tsPayloadReaders.put(l, new <init>(a));
        }

    }

    public (TsExtractor tsextractor)
    {
        a = tsextractor;
        super((byte)0);
    }
}
