// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.util.Ac3Util;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.CodecSpecificDataUtil;
import shared_presage.com.google.android.exoplayer.util.NalUnitUtil;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.mp4:
//            a, Track, TrackEncryptionBox, f

final class b
{
    private static final class a
    {

        public final TrackEncryptionBox a[];
        public MediaFormat b;
        public int c;

        public a(int i)
        {
            a = new TrackEncryptionBox[i];
            c = -1;
        }
    }


    private static Pair a(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 21);
        int j1 = parsablebytearray.readUnsignedByte();
        int k1 = parsablebytearray.readUnsignedByte();
        int i1 = parsablebytearray.getPosition();
        int j = 0;
        i = 0;
        for (; j < k1; j++)
        {
            parsablebytearray.skipBytes(1);
            int l1 = parsablebytearray.readUnsignedShort();
            for (int k = 0; k < l1; k++)
            {
                int j2 = parsablebytearray.readUnsignedShort();
                i += j2 + 4;
                parsablebytearray.skipBytes(j2);
            }

        }

        parsablebytearray.setPosition(i1);
        byte abyte0[] = new byte[i];
        j = 0;
        i1 = 0;
        for (; j < k1; j++)
        {
            parsablebytearray.skipBytes(1);
            int i2 = parsablebytearray.readUnsignedShort();
            for (int l = 0; l < i2; l++)
            {
                int k2 = parsablebytearray.readUnsignedShort();
                System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, i1, NalUnitUtil.NAL_START_CODE.length);
                i1 += NalUnitUtil.NAL_START_CODE.length;
                System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, i1, k2);
                i1 += k2;
                parsablebytearray.skipBytes(k2);
            }

        }

        if (i == 0)
        {
            parsablebytearray = null;
        } else
        {
            parsablebytearray = Collections.singletonList(abyte0);
        }
        return Pair.create(parsablebytearray, Integer.valueOf((j1 & 3) + 1));
    }

    public static Track a(a.a a1, a.b b1)
    {
        ParsableByteArray parsablebytearray1;
        a a4;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        long l3;
        long l4;
        a.a a2 = a1.e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.v);
        ParsableByteArray parsablebytearray = a2.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.G).ah;
        parsablebytearray.setPosition(16);
        i1 = parsablebytearray.readInt();
        if (i1 != Track.TYPE_AUDIO && i1 != Track.TYPE_VIDEO && i1 != Track.TYPE_TEXT && i1 != Track.TYPE_SUBTITLE)
        {
            return null;
        }
        a1 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.E).ah;
        a1.setPosition(8);
        j1 = shared_presage.com.google.android.exoplayer.extractor.mp4.a.a(a1.readInt());
        boolean flag;
        if (j1 == 0)
        {
            i = 8;
        } else
        {
            i = 16;
        }
        a1.skipBytes(i);
        k1 = a1.readInt();
        a1.skipBytes(4);
        l = 1;
        l1 = a1.getPosition();
        if (j1 == 0)
        {
            i = 4;
        } else
        {
            i = 8;
        }
        j = 0;
_L10:
        flag = l;
        if (j >= i) goto _L2; else goto _L1
_L1:
        if (((ParsableByteArray) (a1)).data[l1 + j] == -1) goto _L4; else goto _L3
_L3:
        flag = false;
_L2:
        if (flag)
        {
            a1.skipBytes(i);
            l3 = -1L;
        } else
        if (j1 == 0)
        {
            l3 = a1.readUnsignedInt();
        } else
        {
            l3 = a1.readUnsignedLongToLong();
        }
        a1 = Pair.create(Integer.valueOf(k1), Long.valueOf(l3));
        l = ((Integer)((Pair) (a1)).first).intValue();
        l3 = ((Long)((Pair) (a1)).second).longValue();
        a1 = b1.ah;
        a1.setPosition(8);
        if (shared_presage.com.google.android.exoplayer.extractor.mp4.a.a(a1.readInt()) == 0)
        {
            i = 8;
        } else
        {
            i = 16;
        }
        a1.skipBytes(i);
        l4 = a1.readUnsignedInt();
        if (l3 == -1L)
        {
            l3 = -1L;
        } else
        {
            l3 = Util.scaleLargeTimestamp(l3, 0xf4240L, l4);
        }
        a1 = a2.e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.w).e(shared_presage.com.google.android.exoplayer.extractor.mp4.a.x);
        b1 = a2.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.F).ah;
        b1.setPosition(8);
        if (shared_presage.com.google.android.exoplayer.extractor.mp4.a.a(b1.readInt()) == 0)
        {
            i = 8;
        } else
        {
            i = 16;
        }
        b1.skipBytes(i);
        l4 = b1.readUnsignedInt();
        parsablebytearray1 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.H).ah;
        parsablebytearray1.setPosition(12);
        j1 = parsablebytearray1.readInt();
        a4 = new a(j1);
        i = 0;
        break MISSING_BLOCK_LABEL_370;
_L4:
        j++;
        continue; /* Loop/switch isn't completed */
_L6:
        if (i >= j1)
        {
            break MISSING_BLOCK_LABEL_1255;
        }
        k1 = parsablebytearray1.getPosition();
        l1 = parsablebytearray1.readInt();
        float f1;
        a.b b2;
        a.a a3;
        int i2;
        int j2;
        boolean flag1;
        if (l1 > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1, "childAtomSize should be positive");
        j = parsablebytearray1.readInt();
        if (j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.b && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.c && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.N && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.X && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.d && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.e && j != shared_presage.com.google.android.exoplayer.extractor.mp4.a.f)
        {
            break; /* Loop/switch isn't completed */
        }
        parsablebytearray1.setPosition(k1 + 8);
        parsablebytearray1.skipBytes(24);
        i2 = parsablebytearray1.readUnsignedShort();
        j2 = parsablebytearray1.readUnsignedShort();
        f1 = 1.0F;
        parsablebytearray1.skipBytes(50);
        b2 = null;
        j = parsablebytearray1.getPosition();
        a3 = null;
        do
        {
            if (j - k1 >= l1)
            {
                break;
            }
            parsablebytearray1.setPosition(j);
            int k = parsablebytearray1.getPosition();
            int k2 = parsablebytearray1.readInt();
            if (k2 == 0 && parsablebytearray1.getPosition() - k1 == l1)
            {
                break;
            }
            int l2;
            if (k2 > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assertions.checkArgument(flag1, "childAtomSize should be positive");
            l2 = parsablebytearray1.readInt();
            if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.y)
            {
                if (a3 == null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                Assertions.checkState(flag1);
                parsablebytearray1.setPosition(k + 8 + 4);
                l2 = (parsablebytearray1.readUnsignedByte() & 3) + 1;
                if (l2 == 3)
                {
                    throw new IllegalStateException();
                }
                a1 = new ArrayList();
                int j3 = parsablebytearray1.readUnsignedByte();
                for (k = 0; k < (j3 & 0x1f); k++)
                {
                    a1.add(NalUnitUtil.parseChildNalUnit(parsablebytearray1));
                }

                j3 = parsablebytearray1.readUnsignedByte();
                for (k = 0; k < j3; k++)
                {
                    a1.add(NalUnitUtil.parseChildNalUnit(parsablebytearray1));
                }

                a1 = Pair.create(a1, Integer.valueOf(l2));
                b1 = (List)((Pair) (a1)).first;
                a4.c = ((Integer)((Pair) (a1)).second).intValue();
                a1 = "video/avc";
            } else
            if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.z)
            {
                boolean flag2;
                if (a3 == null)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                Assertions.checkState(flag2);
                a1 = a(parsablebytearray1, k);
                b1 = (List)((Pair) (a1)).first;
                a4.c = ((Integer)((Pair) (a1)).second).intValue();
                a1 = "video/hevc";
            } else
            if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.g)
            {
                boolean flag3;
                if (a3 == null)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                Assertions.checkState(flag3);
                a1 = "video/3gpp";
                b1 = b2;
            } else
            if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.A)
            {
                boolean flag4;
                if (a3 == null)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                Assertions.checkState(flag4);
                b1 = b(parsablebytearray1, k);
                a1 = (String)((Pair) (b1)).first;
                b1 = Collections.singletonList(((Pair) (b1)).second);
            } else
            if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.J)
            {
                a4.a[i] = a(parsablebytearray1, k, k2);
                a1 = a3;
                b1 = b2;
            } else
            {
                a1 = a3;
                b1 = b2;
                if (l2 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.T)
                {
                    parsablebytearray1.setPosition(k + 8);
                    k = parsablebytearray1.readUnsignedIntToInt();
                    int i3 = parsablebytearray1.readUnsignedIntToInt();
                    f1 = (float)k / (float)i3;
                    a1 = a3;
                    b1 = b2;
                }
            }
            j += k2;
            a3 = a1;
            b2 = b1;
        } while (true);
        if (a3 != null)
        {
            a4.b = MediaFormat.createVideoFormat(a3, -1, l3, i2, j2, f1, b2);
        }
_L7:
        parsablebytearray1.setPosition(k1 + l1);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (j == shared_presage.com.google.android.exoplayer.extractor.mp4.a.i || j == shared_presage.com.google.android.exoplayer.extractor.mp4.a.O || j == shared_presage.com.google.android.exoplayer.extractor.mp4.a.j)
        {
            a(parsablebytearray1, j, k1, l1, l3, a4, i);
        } else
        if (j == shared_presage.com.google.android.exoplayer.extractor.mp4.a.U)
        {
            a4.b = MediaFormat.createTextFormat("application/ttml+xml", l3);
        } else
        if (j == shared_presage.com.google.android.exoplayer.extractor.mp4.a.af)
        {
            a4.b = MediaFormat.createTextFormat("application/x-quicktime-tx3g", l3);
        }
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
        if (a4.b == null)
        {
            return null;
        }
        return new Track(l, i1, l4, l3, a4.b, a4.a, a4.c);
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static TrackEncryptionBox a(ParsableByteArray parsablebytearray, int i, int j)
    {
        Object obj;
        int k;
        k = i + 8;
        obj = null;
_L2:
        int l;
        int i1;
        if (k - i >= j)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        parsablebytearray.setPosition(k);
        i1 = parsablebytearray.readInt();
        l = parsablebytearray.readInt();
        if (l != shared_presage.com.google.android.exoplayer.extractor.mp4.a.P)
        {
            break; /* Loop/switch isn't completed */
        }
        parsablebytearray.readInt();
_L5:
        k += i1;
        if (true) goto _L2; else goto _L1
_L1:
        if (l != shared_presage.com.google.android.exoplayer.extractor.mp4.a.K) goto _L4; else goto _L3
_L3:
        parsablebytearray.skipBytes(4);
        parsablebytearray.readInt();
        parsablebytearray.readInt();
          goto _L5
_L4:
        if (l != shared_presage.com.google.android.exoplayer.extractor.mp4.a.L) goto _L5; else goto _L6
_L6:
        l = k + 8;
_L7:
        int j1;
label0:
        {
            if (l - k >= i1)
            {
                break MISSING_BLOCK_LABEL_202;
            }
            parsablebytearray.setPosition(l);
            j1 = parsablebytearray.readInt();
            if (parsablebytearray.readInt() != shared_presage.com.google.android.exoplayer.extractor.mp4.a.M)
            {
                break label0;
            }
            parsablebytearray.skipBytes(4);
            l = parsablebytearray.readInt();
            boolean flag;
            if (l >> 8 == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new byte[16];
            parsablebytearray.readBytes(((byte []) (obj)), 0, obj.length);
            obj = new TrackEncryptionBox(flag, l & 0xff, ((byte []) (obj)));
        }
          goto _L5
        l += j1;
          goto _L7
        obj = null;
          goto _L5
        return ((TrackEncryptionBox) (obj));
    }

    public static f a(Track track, a.a a1)
    {
        ParsableByteArray parsablebytearray = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.ac).ah;
        Object obj = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.ad);
        a.b b1 = ((a.b) (obj));
        if (obj == null)
        {
            b1 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.ae);
        }
        ParsableByteArray parsablebytearray1 = b1.ah;
        ParsableByteArray parsablebytearray2 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.ab).ah;
        ParsableByteArray parsablebytearray3 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.Y).ah;
        obj = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.Z);
        long al[];
        int ai[];
        long al1[];
        int ai1[];
        int j5;
        int k5;
        if (obj != null)
        {
            obj = ((a.b) (obj)).ah;
        } else
        {
            obj = null;
        }
        a1 = a1.d(shared_presage.com.google.android.exoplayer.extractor.mp4.a.aa);
        if (a1 != null)
        {
            a1 = ((a.b) (a1)).ah;
        } else
        {
            a1 = null;
        }
        parsablebytearray.setPosition(12);
        j5 = parsablebytearray.readUnsignedIntToInt();
        k5 = parsablebytearray.readUnsignedIntToInt();
        al = new long[k5];
        ai = new int[k5];
        al1 = new long[k5];
        ai1 = new int[k5];
        if (k5 == 0)
        {
            return new f(al, ai, al1, ai1);
        }
        parsablebytearray1.setPosition(12);
        int l5 = parsablebytearray1.readUnsignedIntToInt();
        parsablebytearray2.setPosition(12);
        int j2 = parsablebytearray2.readUnsignedIntToInt() - 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        boolean flag;
        int l4;
        long l6;
        long l7;
        boolean flag1;
        if (parsablebytearray2.readInt() == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1, "stsc first chunk must be 1");
        k1 = parsablebytearray2.readUnsignedIntToInt();
        parsablebytearray2.skipBytes(4);
        j = -1;
        if (j2 > 0)
        {
            j = parsablebytearray2.readUnsignedIntToInt() - 1;
        }
        parsablebytearray3.setPosition(12);
        i2 = parsablebytearray3.readUnsignedIntToInt();
        l2 = parsablebytearray3.readUnsignedIntToInt();
        k2 = parsablebytearray3.readUnsignedIntToInt();
        k = 0;
        l = 0;
        i = 0;
        if (a1 != null)
        {
            a1.setPosition(12);
            l = a1.readUnsignedIntToInt() - 1;
            k = a1.readUnsignedIntToInt();
            i = a1.readInt();
        }
        i1 = -1;
        j1 = 0;
        if (obj != null)
        {
            ((ParsableByteArray) (obj)).setPosition(12);
            j1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt();
            i1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt() - 1;
        }
        if (b1.ag == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ad)
        {
            l6 = parsablebytearray1.readUnsignedInt();
        } else
        {
            l6 = parsablebytearray1.readUnsignedLongToLong();
        }
        j3 = 0;
        i3 = k1;
        l1 = j1;
        j1 = j;
        l4 = i2 - 1;
        j = i1;
        flag = false;
        k3 = i;
        i2 = k1;
        i = j2;
        l7 = 0L;
        i1 = l1;
        j2 = l4;
        l1 = k;
        k1 = l;
        l = i2;
        k = j1;
        i2 = ((flag) ? 1 : 0);
        j1 = k3;
        while (j3 < k5) 
        {
            al[j3] = l6;
            int l3;
            if (j5 == 0)
            {
                l3 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                l3 = j5;
            }
            ai[j3] = l3;
            al1[j3] = (long)j1 + l7;
            if (obj == null)
            {
                l3 = 1;
            } else
            {
                l3 = 0;
            }
            ai1[j3] = l3;
            if (j3 == j)
            {
                ai1[j3] = 1;
                i1--;
                if (i1 > 0)
                {
                    j = ((ParsableByteArray) (obj)).readUnsignedIntToInt();
                    j--;
                }
            }
            l7 += k2;
            l2--;
            if (l2 == 0 && j2 > 0)
            {
                l2 = parsablebytearray3.readUnsignedIntToInt();
                k2 = parsablebytearray3.readUnsignedIntToInt();
                j2--;
            }
            if (a1 != null)
            {
                l1--;
                if (l1 == 0 && k1 > 0)
                {
                    l1 = a1.readUnsignedIntToInt();
                    j1 = a1.readInt();
                    k1--;
                }
            }
            l3 = i3 - 1;
            if (l3 == 0)
            {
                i2++;
                if (i2 < l5)
                {
                    if (b1.ag == shared_presage.com.google.android.exoplayer.extractor.mp4.a.ad)
                    {
                        l6 = parsablebytearray1.readUnsignedInt();
                    } else
                    {
                        l6 = parsablebytearray1.readUnsignedLongToLong();
                    }
                }
                int j4;
                int i5;
                if (i2 == k)
                {
                    l = parsablebytearray2.readUnsignedIntToInt();
                    parsablebytearray2.skipBytes(4);
                    int i4 = i - 1;
                    i = l;
                    i3 = i4;
                    if (i4 > 0)
                    {
                        k = parsablebytearray2.readUnsignedIntToInt() - 1;
                        i3 = i4;
                        i = l;
                    }
                } else
                {
                    i3 = i;
                    i = l;
                }
                if (i2 < l5)
                {
                    l3 = i2;
                    i2 = i;
                    l = k;
                    k = l3;
                } else
                {
                    l = k;
                    int k4 = i;
                    i = l3;
                    k = i2;
                    i2 = k4;
                }
            } else
            {
                l6 += ai[j3];
                i3 = k;
                j4 = l;
                i5 = i;
                i = l3;
                k = i2;
                l = i3;
                i2 = j4;
                i3 = i5;
            }
            j3++;
            l3 = i;
            i = i3;
            i3 = i2;
            i2 = k;
            k = l;
            l = i3;
            i3 = l3;
        }
        Util.scaleLargeTimestampsInPlace(al1, 0xf4240L, track.timescale);
        if (i1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (l2 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (i3 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (j2 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (k1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        return new f(al, ai, al1, ai1);
    }

    private static void a(ParsableByteArray parsablebytearray, int i, int j, int k, long l, a a1, int i1)
    {
        Object obj;
        int k1;
        int i2;
        int k2;
        parsablebytearray.setPosition(j + 8);
        parsablebytearray.skipBytes(16);
        i2 = parsablebytearray.readUnsignedShort();
        k2 = parsablebytearray.readUnsignedShort();
        parsablebytearray.skipBytes(4);
        k1 = parsablebytearray.readUnsignedFixedPoint1616();
        obj = null;
        if (i != shared_presage.com.google.android.exoplayer.extractor.mp4.a.j) goto _L2; else goto _L1
_L1:
        obj = "audio/ac3";
_L16:
        byte abyte1[];
        int j1;
        j1 = parsablebytearray.getPosition();
        abyte1 = null;
_L7:
        if (j1 - j >= k) goto _L4; else goto _L3
_L3:
        Object obj1;
        byte abyte0[];
        int l1;
        int j2;
        int l2;
        int i3;
        int j3;
        parsablebytearray.setPosition(j1);
        i3 = parsablebytearray.getPosition();
        l2 = parsablebytearray.readInt();
        boolean flag;
        if (l2 > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag, "childAtomSize should be positive");
        j3 = parsablebytearray.readInt();
        if (i != shared_presage.com.google.android.exoplayer.extractor.mp4.a.i && i != shared_presage.com.google.android.exoplayer.extractor.mp4.a.O) goto _L6; else goto _L5
_L5:
        if (j3 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.A)
        {
            obj1 = b(parsablebytearray, i3);
            obj = (String)((Pair) (obj1)).first;
            abyte1 = (byte[])((Pair) (obj1)).second;
            obj1 = obj;
            abyte0 = abyte1;
            j2 = i2;
            l1 = k1;
            if ("audio/mp4a-latm".equals(obj))
            {
                obj1 = CodecSpecificDataUtil.parseAacAudioSpecificConfig(abyte1);
                l1 = ((Integer)((Pair) (obj1)).first).intValue();
                j2 = ((Integer)((Pair) (obj1)).second).intValue();
                abyte0 = abyte1;
                obj1 = obj;
            }
        } else
        {
            obj1 = obj;
            abyte0 = abyte1;
            j2 = i2;
            l1 = k1;
            if (j3 == shared_presage.com.google.android.exoplayer.extractor.mp4.a.J)
            {
                a1.a[i1] = a(parsablebytearray, i3, l2);
                obj1 = obj;
                abyte0 = abyte1;
                j2 = i2;
                l1 = k1;
            }
        }
_L11:
        j1 += l2;
        obj = obj1;
        abyte1 = abyte0;
        i2 = j2;
        k1 = l1;
          goto _L7
_L2:
        if (i == shared_presage.com.google.android.exoplayer.extractor.mp4.a.l)
        {
            obj = "audio/eac3";
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (i != shared_presage.com.google.android.exoplayer.extractor.mp4.a.j || j3 != shared_presage.com.google.android.exoplayer.extractor.mp4.a.k) goto _L9; else goto _L8
_L8:
        parsablebytearray.setPosition(i3 + 8);
        a1.b = Ac3Util.parseAnnexFAc3Format(parsablebytearray);
_L14:
        return;
_L9:
        obj1 = obj;
        abyte0 = abyte1;
        j2 = i2;
        l1 = k1;
        if (i != shared_presage.com.google.android.exoplayer.extractor.mp4.a.l) goto _L11; else goto _L10
_L10:
        obj1 = obj;
        abyte0 = abyte1;
        j2 = i2;
        l1 = k1;
        if (j3 != shared_presage.com.google.android.exoplayer.extractor.mp4.a.m) goto _L11; else goto _L12
_L12:
        parsablebytearray.setPosition(i3 + 8);
        a1.b = Ac3Util.parseAnnexFEAc3Format(parsablebytearray);
        return;
_L4:
        if (obj == null) goto _L14; else goto _L13
_L13:
        if (abyte1 == null)
        {
            parsablebytearray = null;
        } else
        {
            parsablebytearray = Collections.singletonList(abyte1);
        }
        a1.b = MediaFormat.createAudioFormat(((String) (obj)), k2, l, i2, k1, parsablebytearray);
        return;
        if (true) goto _L16; else goto _L15
_L15:
    }

    private static Pair b(ParsableByteArray parsablebytearray, int i)
    {
        String s;
        s = null;
        parsablebytearray.setPosition(i + 8 + 4);
        parsablebytearray.skipBytes(1);
        for (i = parsablebytearray.readUnsignedByte(); i > 127; i = parsablebytearray.readUnsignedByte()) { }
        parsablebytearray.skipBytes(2);
        i = parsablebytearray.readUnsignedByte();
        if ((i & 0x80) != 0)
        {
            parsablebytearray.skipBytes(2);
        }
        if ((i & 0x40) != 0)
        {
            parsablebytearray.skipBytes(parsablebytearray.readUnsignedShort());
        }
        if ((i & 0x20) != 0)
        {
            parsablebytearray.skipBytes(2);
        }
        parsablebytearray.skipBytes(1);
        for (i = parsablebytearray.readUnsignedByte(); i > 127; i = parsablebytearray.readUnsignedByte()) { }
        parsablebytearray.readUnsignedByte();
        JVM INSTR lookupswitch 7: default 180
    //                   32: 238
    //                   33: 245
    //                   35: 251
    //                   64: 257
    //                   107: 230
    //                   165: 264
    //                   166: 271;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        parsablebytearray.skipBytes(12);
        parsablebytearray.skipBytes(1);
        int j = parsablebytearray.readUnsignedByte();
        for (i = j & 0x7f; j > 127; i = i << 8 | j & 0x7f)
        {
            j = parsablebytearray.readUnsignedByte();
        }

        break; /* Loop/switch isn't completed */
_L6:
        return Pair.create("audio/mpeg", null);
_L2:
        s = "video/mp4v-es";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "video/avc";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "video/hevc";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "audio/mp4a-latm";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "audio/ac3";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "audio/eac3";
        if (true) goto _L1; else goto _L9
_L9:
        byte abyte0[] = new byte[i];
        parsablebytearray.readBytes(abyte0, 0, i);
        return Pair.create(s, abyte0);
    }
}
