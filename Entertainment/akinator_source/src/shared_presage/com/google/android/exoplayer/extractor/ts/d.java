// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.NalUnitUtil;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            c, h, i

final class d extends c
{
    private static final class a
    {

        private final ParsableBitArray a;
        private byte b[];
        private int c;
        private boolean d;
        private int e;

        public final void a()
        {
            d = false;
            c = 0;
            e = -1;
        }

        public final void a(int i1)
        {
            if (i1 == 1)
            {
                a();
                d = true;
            }
        }

        public final void a(byte abyte0[], int i1, int j1)
        {
            if (d)
            {
                j1 -= i1;
                if (b.length < c + j1)
                {
                    b = Arrays.copyOf(b, (c + j1) * 2);
                }
                System.arraycopy(abyte0, i1, b, c, j1);
                c = j1 + c;
                a.reset(b, c);
                i1 = a.peekExpGolombCodedNumLength();
                if (i1 != -1 && i1 <= a.bitsLeft())
                {
                    a.skipBits(i1);
                    i1 = a.peekExpGolombCodedNumLength();
                    if (i1 != -1 && i1 <= a.bitsLeft())
                    {
                        e = a.readUnsignedExpGolombCodedInt();
                        d = false;
                        return;
                    }
                }
            }
        }

        public final boolean b()
        {
            return e != -1;
        }

        public final int c()
        {
            return e;
        }

        public a()
        {
            b = new byte[128];
            a = new ParsableBitArray(b);
            a();
        }
    }


    private boolean b;
    private final i c;
    private final boolean d[] = new boolean[3];
    private final a e;
    private final h f = new h(7);
    private final h g = new h(8);
    private final h h = new h(6);
    private boolean i;
    private long j;
    private boolean k;
    private long l;
    private long m;
    private final ParsableByteArray n = new ParsableByteArray();

    public d(TrackOutput trackoutput, i i1, boolean flag)
    {
        super(trackoutput);
        c = i1;
        if (flag)
        {
            trackoutput = null;
        } else
        {
            trackoutput = new a();
        }
        e = trackoutput;
    }

    private static void a(ParsableBitArray parsablebitarray, int i1)
    {
        int i2 = 8;
        int k1 = 0;
        int l1 = 8;
        while (k1 < i1) 
        {
            int j1 = i2;
            if (i2 != 0)
            {
                j1 = (parsablebitarray.readSignedExpGolombCodedInt() + l1 + 256) % 256;
            }
            if (j1 != 0)
            {
                l1 = j1;
            }
            k1++;
            i2 = j1;
        }
    }

    private void a(byte abyte0[], int i1, int j1)
    {
        if (e != null)
        {
            e.a(abyte0, i1, j1);
        }
        if (!b)
        {
            f.a(abyte0, i1, j1);
            g.a(abyte0, i1, j1);
        }
        h.a(abyte0, i1, j1);
    }

    public final void a()
    {
        c.a();
        NalUnitUtil.clearPrefixFlags(d);
        f.a();
        g.a();
        h.a();
        if (e != null)
        {
            e.a();
        }
        i = false;
        j = 0L;
    }

    public final void a(ParsableByteArray parsablebytearray, long l1, boolean flag)
    {
_L20:
        byte abyte0[];
        int i1;
        int i2;
        if (parsablebytearray.bytesLeft() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = parsablebytearray.getPosition();
        i2 = parsablebytearray.limit();
        abyte0 = parsablebytearray.data;
        j = j + (long)parsablebytearray.bytesLeft();
        a.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
_L18:
        int l2;
        if (i1 >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        l2 = NalUnitUtil.findNalUnit(abyte0, i1, i2, d);
        if (l2 >= i2) goto _L2; else goto _L1
_L1:
        int i3;
        int j3;
        int k3;
        j3 = l2 - i1;
        if (j3 > 0)
        {
            a(abyte0, i1, l2);
        }
        i3 = NalUnitUtil.getNalUnitType(abyte0, l2);
        k3 = i2 - l2;
        i3;
        JVM INSTR lookupswitch 2: default 148
    //                   5: 305
    //                   9: 313;
           goto _L3 _L4 _L5
_L3:
        float f1;
        float f2;
        Object obj;
        byte abyte1[];
        byte abyte2[];
        Object obj1;
        int j1;
        int k1;
        int j2;
        int k2;
        int l3;
        int i4;
        int j4;
        int k4;
        long l4;
        if (j3 < 0)
        {
            i1 = -j3;
        } else
        {
            i1 = 0;
        }
        f.b(i1);
        g.b(i1);
        if (h.b(i1))
        {
            i1 = NalUnitUtil.unescapeStream(h.a, h.b);
            n.reset(h.a, i1);
            n.setPosition(4);
            c.a(n, l1, true);
        }
        if (e != null)
        {
            e.a(i3);
        }
        if (!b)
        {
            f.a(i3);
            g.a(i3);
        }
        h.a(i3);
        i1 = l2 + 3;
        continue; /* Loop/switch isn't completed */
_L4:
        k = true;
          goto _L3
_L5:
        if (!i) goto _L7; else goto _L6
_L6:
        if (e != null && e.b())
        {
            i1 = e.c();
            flag = k;
            if (i1 == 2 || i1 == 7)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            k = i1 | flag;
            e.a();
        }
        if (!k || b || !f.b() || !g.b()) goto _L9; else goto _L8
_L8:
        obj = f;
        obj1 = g;
        abyte1 = new byte[((h) (obj)).b];
        abyte2 = new byte[((h) (obj1)).b];
        System.arraycopy(((h) (obj)).a, 0, abyte1, 0, ((h) (obj)).b);
        System.arraycopy(((h) (obj1)).a, 0, abyte2, 0, ((h) (obj1)).b);
        obj1 = new ArrayList();
        ((List) (obj1)).add(abyte1);
        ((List) (obj1)).add(abyte2);
        NalUnitUtil.unescapeStream(((h) (obj)).a, ((h) (obj)).b);
        obj = new ParsableBitArray(((h) (obj)).a);
        ((ParsableBitArray) (obj)).skipBits(32);
        i1 = ((ParsableBitArray) (obj)).readBits(8);
        ((ParsableBitArray) (obj)).skipBits(16);
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        j1 = 1;
        if (i1 == 100 || i1 == 110 || i1 == 122 || i1 == 244 || i1 == 44 || i1 == 83 || i1 == 86 || i1 == 118 || i1 == 128 || i1 == 138)
        {
            j2 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            if (j2 == 3)
            {
                ((ParsableBitArray) (obj)).skipBits(1);
            }
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).skipBits(1);
            if (((ParsableBitArray) (obj)).readBit())
            {
                if (j2 != 3)
                {
                    i1 = 8;
                } else
                {
                    i1 = 12;
                }
                j1 = 0;
                while (j1 < i1) 
                {
                    if (((ParsableBitArray) (obj)).readBit())
                    {
                        if (j1 < 6)
                        {
                            k1 = 16;
                        } else
                        {
                            k1 = 64;
                        }
                        a(((ParsableBitArray) (obj)), k1);
                    }
                    j1++;
                }
            }
            j1 = j2;
        }
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        l4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        if (l4 == 0L)
        {
            ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        } else
        if (l4 == 1L)
        {
            ((ParsableBitArray) (obj)).skipBits(1);
            ((ParsableBitArray) (obj)).readSignedExpGolombCodedInt();
            ((ParsableBitArray) (obj)).readSignedExpGolombCodedInt();
            l4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            i1 = 0;
            while ((long)i1 < l4) 
            {
                ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
                i1++;
            }
        }
        ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        ((ParsableBitArray) (obj)).skipBits(1);
        j2 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        k1 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
        flag = ((ParsableBitArray) (obj)).readBit();
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!flag)
        {
            ((ParsableBitArray) (obj)).skipBits(1);
        }
        ((ParsableBitArray) (obj)).skipBits(1);
        j2 = (j2 + 1) * 16;
        k2 = (2 - i1) * (k1 + 1) * 16;
        k1 = j2;
        i1 = k2;
        if (((ParsableBitArray) (obj)).readBit())
        {
            j4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            k4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            l3 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            i4 = ((ParsableBitArray) (obj)).readUnsignedExpGolombCodedInt();
            if (j1 == 0)
            {
                if (flag)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                i1 = 2 - i1;
                j1 = 1;
            } else
            {
                if (j1 == 3)
                {
                    i1 = 1;
                } else
                {
                    i1 = 2;
                }
                if (j1 == 1)
                {
                    j1 = 2;
                } else
                {
                    j1 = 1;
                }
                if (flag)
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                k1 = (2 - k1) * j1;
                j1 = i1;
                i1 = k1;
            }
            k1 = j2 - j1 * (j4 + k4);
            i1 = k2 - (l3 + i4) * i1;
        }
        f2 = 1.0F;
        if (!((ParsableBitArray) (obj)).readBit() || !((ParsableBitArray) (obj)).readBit()) goto _L11; else goto _L10
_L10:
        j1 = ((ParsableBitArray) (obj)).readBits(8);
        if (j1 != 255) goto _L13; else goto _L12
_L12:
        j1 = ((ParsableBitArray) (obj)).readBits(16);
        j2 = ((ParsableBitArray) (obj)).readBits(16);
        f1 = f2;
        if (j1 != 0)
        {
            f1 = f2;
            if (j2 != 0)
            {
                f1 = (float)j1 / (float)j2;
            }
        }
_L16:
        a.format(MediaFormat.createVideoFormat("video/avc", -1, -1L, k1, i1, f1, ((List) (obj1))));
        b = true;
_L9:
        if (k)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j1 = (int)(j - l);
        a.sampleMetadata(m, i1, j1 - k3, k3, null);
_L7:
        i = true;
        l = j - (long)k3;
        m = l1;
        k = false;
          goto _L3
_L13:
        if (j1 >= NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length) goto _L15; else goto _L14
_L14:
        f1 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[j1];
          goto _L16
_L15:
        Log.w("H264Reader", (new StringBuilder("Unexpected aspect_ratio_idc value: ")).append(j1).toString());
_L11:
        f1 = 1.0F;
          goto _L16
_L2:
        a(abyte0, i1, i2);
        i1 = i2;
        if (true) goto _L18; else goto _L17
_L17:
        if (true) goto _L20; else goto _L19
_L19:
    }

    public final void b()
    {
    }
}
