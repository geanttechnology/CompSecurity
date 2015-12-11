// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.Ac3Util;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c

final class a extends c
{

    private final ParsableBitArray b = new ParsableBitArray(new byte[8]);
    private final ParsableByteArray c;
    private int d;
    private int e;
    private boolean f;
    private long g;
    private MediaFormat h;
    private int i;
    private int j;
    private long k;

    public a(TrackOutput trackoutput)
    {
        super(trackoutput);
        c = new ParsableByteArray(b.data);
        d = 0;
    }

    public final void a()
    {
        d = 0;
        e = 0;
        f = false;
    }

    public final void a(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        if (flag)
        {
            k = l;
        }
_L14:
        if (parsablebytearray.bytesLeft() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        d;
        JVM INSTR tableswitch 0 2: default 48
    //                   0 51
    //                   1 184
    //                   2 383;
           goto _L1 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_51;
_L1:
        continue; /* Loop/switch isn't completed */
_L9:
        if (parsablebytearray.bytesLeft() <= 0) goto _L6; else goto _L5
_L5:
        if (f) goto _L8; else goto _L7
_L7:
        if (parsablebytearray.readUnsignedByte() == 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
          goto _L9
_L8:
        int i1 = parsablebytearray.readUnsignedByte();
        if (i1 != 119) goto _L11; else goto _L10
_L10:
        f = false;
        i1 = 1;
_L12:
        if (i1 != 0)
        {
            d = 1;
            c.data[0] = 11;
            c.data[1] = 119;
            e = 2;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (i1 == 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
          goto _L9
_L6:
        i1 = 0;
          goto _L12
_L3:
        byte abyte0[] = c.data;
        int j1 = Math.min(parsablebytearray.bytesLeft(), 8 - e);
        parsablebytearray.readBytes(abyte0, e, j1);
        e = e + j1;
        boolean flag1;
        if (e == 8)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            b.setPosition(0);
            i = Ac3Util.parseFrameSize(b);
            if (h == null)
            {
                b.setPosition(0);
                h = Ac3Util.parseFrameAc3Format(b);
                a.format(h);
                j = Ac3Util.getBitrate(i, h.sampleRate);
            }
            g = (int)((8000L * (long)i) / (long)j);
            c.setPosition(0);
            a.sampleData(c, 8);
            d = 2;
        }
        continue; /* Loop/switch isn't completed */
          goto _L9
_L4:
        int k1 = Math.min(parsablebytearray.bytesLeft(), i - e);
        a.sampleData(parsablebytearray, k1);
        e = k1 + e;
        if (e == i)
        {
            a.sampleMetadata(k, 1, i, 0, null);
            k = k + g;
            d = 0;
        }
        if (true) goto _L14; else goto _L13
_L13:
    }

    public final void b()
    {
    }
}
