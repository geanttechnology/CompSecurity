// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            TsExtractor, c

private final class d extends d
{

    final TsExtractor a;
    private final ParsableBitArray b = new ParsableBitArray(new byte[9]);
    private final c c;
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
    //                   0 40
    //                   1 40
    //                   2 102
    //                   3 113;
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

    public (TsExtractor tsextractor, c c1)
    {
        a = tsextractor;
        super((byte)0);
        c = c1;
        d = 0;
    }
}
