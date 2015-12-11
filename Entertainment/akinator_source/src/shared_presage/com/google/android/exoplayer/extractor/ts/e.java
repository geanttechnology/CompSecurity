// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import java.util.Collections;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.NalUnitUtil;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c, h, i

final class e extends c
{

    private boolean b;
    private final i c;
    private final boolean d[] = new boolean[3];
    private final h e = new h(32);
    private final h f = new h(33);
    private final h g = new h(34);
    private final h h = new h(39);
    private final h i = new h(40);
    private boolean j;
    private long k;
    private boolean l;
    private long m;
    private long n;
    private final ParsableByteArray o = new ParsableByteArray();

    public e(TrackOutput trackoutput, i i1)
    {
        super(trackoutput);
        c = i1;
    }

    private void a(byte abyte0[], int i1, int j1)
    {
        if (!b)
        {
            e.a(abyte0, i1, j1);
            f.a(abyte0, i1, j1);
            g.a(abyte0, i1, j1);
        }
        h.a(abyte0, i1, j1);
        i.a(abyte0, i1, j1);
    }

    public final void a()
    {
        c.a();
        NalUnitUtil.clearPrefixFlags(d);
        e.a();
        f.a();
        g.a();
        h.a();
        i.a();
        j = false;
        k = 0L;
    }

    public final void a(ParsableByteArray parsablebytearray, long l1, boolean flag)
    {
_L17:
        byte abyte0[];
        int i1;
        int i5;
        if (parsablebytearray.bytesLeft() <= 0)
        {
            break MISSING_BLOCK_LABEL_1705;
        }
        i1 = parsablebytearray.getPosition();
        i5 = parsablebytearray.limit();
        abyte0 = parsablebytearray.data;
        k = k + (long)parsablebytearray.bytesLeft();
        a.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
_L15:
        int j5;
        if (i1 >= i5)
        {
            break; /* Loop/switch isn't completed */
        }
        j5 = NalUnitUtil.findNalUnit(abyte0, i1, i5, d);
        if (j5 >= i5) goto _L2; else goto _L1
_L1:
        byte abyte1[];
        Object obj;
        int k5;
        int l5;
        int i6;
        l5 = j5 - i1;
        if (l5 > 0)
        {
            a(abyte0, i1, j5);
        }
        k5 = NalUnitUtil.getH265NalUnitType(abyte0, j5);
        i6 = i5 - j5;
        i1 = NalUnitUtil.getH265NalUnitType(abyte0, j5);
        h h1;
        h h2;
        int j1;
        int j2;
        if (i1 <= 9 || i1 >= 16 && i1 <= 21)
        {
            if ((abyte0[j5 + 5] & 0x80) != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L4; else goto _L3
_L3:
        if (!j) goto _L6; else goto _L5
_L5:
        if (!l || b || !e.b() || !f.b() || !g.b()) goto _L8; else goto _L7
_L7:
        float f2;
        int k1;
        int k2;
        obj = e;
        h1 = f;
        h2 = g;
        abyte1 = new byte[((h) (obj)).b + h1.b + h2.b];
        System.arraycopy(((h) (obj)).a, 0, abyte1, 0, ((h) (obj)).b);
        System.arraycopy(h1.a, 0, abyte1, ((h) (obj)).b, h1.b);
        System.arraycopy(h2.a, 0, abyte1, ((h) (obj)).b + h1.b, h2.b);
        NalUnitUtil.unescapeStream(h1.a, h1.b);
        obj = new ParsableBitArray(h1.a);
        ((ParsableBitArray) (obj)).skipBits(44);
        int l2 = ((ParsableBitArray) (obj)).readBits(3);
        ((ParsableBitArray) (obj)).skipBits(1);
        ((ParsableBitArray) (obj)).skipBits(88);
        ((ParsableBitArray) (obj)).skipBits(8);
        i1 = 0;
        for (j2 = 0; j2 < l2; j2++)
        {
            j1 = i1;
            if (((ParsableBitArray) (obj)).readBits(1) == 1)
            {
                j1 = i1 + 89;
            }
            i1 = j1;
            if (((ParsableBitArray) (obj)).readBits(1) == 1)
            {
                i1 = j1 + 8;
            }
        }

        ((ParsableBitArray) (obj)).skipBits(i1);
        if (l2 > 0)
        {
            ((ParsableBitArray) (obj)).skipBits((8 - l2) * 2);
        }
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        int k7 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        if (k7 == 3)
        {
            ((ParsableBitArray) (obj)).skipBits(1);
        }
        int i4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        int l3 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        k2 = i4;
        k1 = l3;
        int j6;
        if (((ParsableBitArray) (obj)).readBit())
        {
            k2 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            int i7 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            j6 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            int k6 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            if (k7 == 1 || k7 == 2)
            {
                i1 = 2;
            } else
            {
                i1 = 1;
            }
            if (k7 == 1)
            {
                k1 = 2;
            } else
            {
                k1 = 1;
            }
            k2 = i4 - i1 * (k2 + i7);
            k1 = l3 - k1 * (j6 + k6);
        }
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        j6 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        if (((ParsableBitArray) (obj)).readBit())
        {
            i1 = 0;
        } else
        {
            i1 = l2;
        }
        for (; i1 <= l2; i1++)
        {
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        }

        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        if (((ParsableBitArray) (obj)).readBit() && ((ParsableBitArray) (obj)).readBit())
        {
            for (i1 = 0; i1 < 4; i1++)
            {
                int i3 = 0;
                while (i3 < 6) 
                {
                    if (!((ParsableBitArray) (obj)).readBit())
                    {
                        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                    } else
                    {
                        int j4 = Math.min(64, 1 << (i1 + 4 << 1));
                        if (i1 > 1)
                        {
                            ((ParsableBitArray) (obj)).readSignedExpGolombCodedInt();
                        }
                        l3 = 0;
                        while (l3 < j4) 
                        {
                            ((ParsableBitArray) (obj)).readSignedExpGolombCodedInt();
                            l3++;
                        }
                    }
                    if (i1 == 3)
                    {
                        l3 = 3;
                    } else
                    {
                        l3 = 1;
                    }
                    i3 = l3 + i3;
                }
            }

        }
        ((ParsableBitArray) (obj)).skipBits(2);
        if (((ParsableBitArray) (obj)).readBit())
        {
            ((ParsableBitArray) (obj)).skipBits(4);
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).skipBits(1);
        }
        int l6 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        i1 = 0;
        l3 = 0;
        flag = false;
        while (i1 < l6) 
        {
            if (i1 != 0)
            {
                flag = ((ParsableBitArray) (obj)).readBit();
            }
            int j3;
            if (flag)
            {
                ((ParsableBitArray) (obj)).skipBits(1);
                ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                int k4 = 0;
                do
                {
                    j3 = l3;
                    if (k4 > l3)
                    {
                        break;
                    }
                    if (((ParsableBitArray) (obj)).readBit())
                    {
                        ((ParsableBitArray) (obj)).skipBits(1);
                    }
                    k4++;
                } while (true);
            } else
            {
                l3 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                int j7 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                int l4 = l3 + j7;
                for (j3 = 0; j3 < l3; j3++)
                {
                    ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                    ((ParsableBitArray) (obj)).skipBits(1);
                }

                l3 = 0;
                do
                {
                    j3 = l4;
                    if (l3 >= j7)
                    {
                        break;
                    }
                    ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                    ((ParsableBitArray) (obj)).skipBits(1);
                    l3++;
                } while (true);
            }
            i1++;
            l3 = j3;
        }
        if (((ParsableBitArray) (obj)).readBit())
        {
            for (i1 = 0; i1 < ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt(); i1++)
            {
                ((ParsableBitArray) (obj)).skipBits(j6 + 4 + 1);
            }

        }
        ((ParsableBitArray) (obj)).skipBits(2);
        f2 = 1.0F;
        if (!((ParsableBitArray) (obj)).readBit() || !((ParsableBitArray) (obj)).readBit()) goto _L10; else goto _L9
_L9:
        i1 = ((ParsableBitArray) (obj)).readBits(8);
        if (i1 != 255) goto _L12; else goto _L11
_L11:
        float f1;
        i1 = ((ParsableBitArray) (obj)).readBits(16);
        int k3 = ((ParsableBitArray) (obj)).readBits(16);
        f1 = f2;
        if (i1 != 0)
        {
            f1 = f2;
            if (k3 != 0)
            {
                f1 = (float)i1 / (float)k3;
            }
        }
_L13:
        a.format(MediaFormat.createVideoFormat("video/hevc", -1, -1L, k2, k1, f1, Collections.singletonList(abyte1)));
        b = true;
_L8:
        int i2;
        if (l)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i2 = (int)(k - m);
        a.sampleMetadata(n, i1, i2 - i6, i6, null);
_L6:
        j = true;
        m = k - (long)i6;
        n = l1;
        if (k5 == 16 || k5 == 17 || k5 == 18 || k5 == 19 || k5 == 20 || k5 == 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = flag;
_L4:
        if (l5 < 0)
        {
            i1 = -l5;
        } else
        {
            i1 = 0;
        }
        e.b(i1);
        f.b(i1);
        g.b(i1);
        if (h.b(i1))
        {
            i2 = NalUnitUtil.unescapeStream(h.a, h.b);
            o.reset(h.a, i2);
            o.skipBytes(5);
            c.a(o, l1, true);
        }
        if (i.b(i1))
        {
            i1 = NalUnitUtil.unescapeStream(i.a, i.b);
            o.reset(i.a, i1);
            o.skipBytes(5);
            c.a(o, l1, true);
        }
        if (!b)
        {
            e.a(k5);
            f.a(k5);
            g.a(k5);
        }
        h.a(k5);
        i.a(k5);
        i1 = j5 + 3;
        continue; /* Loop/switch isn't completed */
_L12:
        if (i1 < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
        {
            f1 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[i1];
            continue; /* Loop/switch isn't completed */
        }
        Log.w("H265Reader", (new StringBuilder("Unexpected aspect_ratio_idc value: ")).append(i1).toString());
_L10:
        f1 = 1.0F;
        if (true) goto _L13; else goto _L2
_L2:
        a(abyte0, i1, i5);
        i1 = i5;
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
    }

    public final void b()
    {
    }
}
