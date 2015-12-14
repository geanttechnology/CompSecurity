// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom, TrackEncryptionBox, TrackSampleTable, Track

final class AtomParsers
{
    private static final class StsdDataHolder
    {

        public MediaFormat mediaFormat;
        public int nalUnitLengthFieldLength;
        public final TrackEncryptionBox trackEncryptionBoxes[];

        public StsdDataHolder(int i)
        {
            trackEncryptionBoxes = new TrackEncryptionBox[i];
            nalUnitLengthFieldLength = -1;
        }
    }


    private AtomParsers()
    {
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsablebytearray, int i, int j, int k, long l, StsdDataHolder stsddataholder, int i1)
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
        if (i != Atom.TYPE_ac_3) goto _L2; else goto _L1
_L1:
        obj = "audio/ac3";
_L16:
        byte abyte1[];
        int j1;
        abyte1 = null;
        j1 = parsablebytearray.getPosition();
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
        if (i != Atom.TYPE_mp4a && i != Atom.TYPE_enca) goto _L6; else goto _L5
_L5:
        if (j3 == Atom.TYPE_esds)
        {
            obj1 = parseEsdsFromParent(parsablebytearray, i3);
            obj = (String)((Pair) (obj1)).first;
            abyte1 = (byte[])((Pair) (obj1)).second;
            obj1 = obj;
            j2 = i2;
            l1 = k1;
            abyte0 = abyte1;
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
            j2 = i2;
            l1 = k1;
            abyte0 = abyte1;
            if (j3 == Atom.TYPE_sinf)
            {
                stsddataholder.trackEncryptionBoxes[i1] = parseSinfFromParent(parsablebytearray, i3, l2);
                obj1 = obj;
                j2 = i2;
                l1 = k1;
                abyte0 = abyte1;
            }
        }
_L11:
        j1 += l2;
        obj = obj1;
        i2 = j2;
        k1 = l1;
        abyte1 = abyte0;
          goto _L7
_L2:
        if (i == Atom.TYPE_ec_3)
        {
            obj = "audio/eac3";
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (i != Atom.TYPE_ac_3 || j3 != Atom.TYPE_dac3) goto _L9; else goto _L8
_L8:
        parsablebytearray.setPosition(i3 + 8);
        stsddataholder.mediaFormat = Ac3Util.parseAnnexFAc3Format(parsablebytearray);
_L14:
        return;
_L9:
        obj1 = obj;
        j2 = i2;
        l1 = k1;
        abyte0 = abyte1;
        if (i != Atom.TYPE_ec_3) goto _L11; else goto _L10
_L10:
        obj1 = obj;
        j2 = i2;
        l1 = k1;
        abyte0 = abyte1;
        if (j3 != Atom.TYPE_dec3) goto _L11; else goto _L12
_L12:
        parsablebytearray.setPosition(i3 + 8);
        stsddataholder.mediaFormat = Ac3Util.parseAnnexFEAc3Format(parsablebytearray);
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
        stsddataholder.mediaFormat = MediaFormat.createAudioFormat(((String) (obj)), k2, l, i2, k1, parsablebytearray);
        return;
        if (true) goto _L16; else goto _L15
_L15:
    }

    private static Pair parseAvcCFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 4);
        int j = (parsablebytearray.readUnsignedByte() & 3) + 1;
        if (j == 3)
        {
            throw new IllegalStateException();
        }
        ArrayList arraylist = new ArrayList();
        int k = parsablebytearray.readUnsignedByte();
        for (i = 0; i < (k & 0x1f); i++)
        {
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        }

        k = parsablebytearray.readUnsignedByte();
        for (i = 0; i < k; i++)
        {
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        }

        return Pair.create(arraylist, Integer.valueOf(j));
    }

    private static Pair parseEsdsFromParent(ParsableByteArray parsablebytearray, int i)
    {
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
    //                   32: 239
    //                   33: 245
    //                   35: 251
    //                   64: 257
    //                   107: 232
    //                   165: 263
    //                   166: 269;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = null;
_L10:
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
        if (true) goto _L10; else goto _L9
_L9:
        byte abyte0[] = new byte[i];
        parsablebytearray.readBytes(abyte0, 0, i);
        return Pair.create(s, abyte0);
    }

    private static int parseHdlr(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(16);
        return parsablebytearray.readInt();
    }

    private static Pair parseHvcCFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 21);
        int k1 = parsablebytearray.readUnsignedByte();
        int l1 = parsablebytearray.readUnsignedByte();
        i = 0;
        int j1 = parsablebytearray.getPosition();
        for (int j = 0; j < l1; j++)
        {
            parsablebytearray.skipBytes(1);
            int i2 = parsablebytearray.readUnsignedShort();
            for (int l = 0; l < i2; l++)
            {
                int k2 = parsablebytearray.readUnsignedShort();
                i += k2 + 4;
                parsablebytearray.skipBytes(k2);
            }

        }

        parsablebytearray.setPosition(j1);
        byte abyte0[] = new byte[i];
        j1 = 0;
        for (int k = 0; k < l1; k++)
        {
            parsablebytearray.skipBytes(1);
            int j2 = parsablebytearray.readUnsignedShort();
            for (int i1 = 0; i1 < j2; i1++)
            {
                int l2 = parsablebytearray.readUnsignedShort();
                System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, j1, NalUnitUtil.NAL_START_CODE.length);
                j1 += NalUnitUtil.NAL_START_CODE.length;
                System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, j1, l2);
                j1 += l2;
                parsablebytearray.skipBytes(l2);
            }

        }

        if (i == 0)
        {
            parsablebytearray = null;
        } else
        {
            parsablebytearray = Collections.singletonList(abyte0);
        }
        return Pair.create(parsablebytearray, Integer.valueOf((k1 & 3) + 1));
    }

    private static long parseMdhd(ParsableByteArray parsablebytearray)
    {
        byte byte0 = 8;
        parsablebytearray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsablebytearray.readInt()) != 0)
        {
            byte0 = 16;
        }
        parsablebytearray.skipBytes(byte0);
        return parsablebytearray.readUnsignedInt();
    }

    private static long parseMvhd(ParsableByteArray parsablebytearray)
    {
        byte byte0 = 8;
        parsablebytearray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsablebytearray.readInt()) != 0)
        {
            byte0 = 16;
        }
        parsablebytearray.skipBytes(byte0);
        return parsablebytearray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8);
        i = parsablebytearray.readUnsignedIntToInt();
        int j = parsablebytearray.readUnsignedIntToInt();
        return (float)i / (float)j;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsablebytearray, int i, int j)
    {
        boolean flag = true;
        int l;
        for (int k = i + 8; k - i < j; k += l)
        {
            parsablebytearray.setPosition(k);
            l = parsablebytearray.readInt();
            if (parsablebytearray.readInt() == Atom.TYPE_tenc)
            {
                parsablebytearray.skipBytes(4);
                i = parsablebytearray.readInt();
                byte abyte0[];
                if (i >> 8 != 1)
                {
                    flag = false;
                }
                abyte0 = new byte[16];
                parsablebytearray.readBytes(abyte0, 0, abyte0.length);
                return new TrackEncryptionBox(flag, i & 0xff, abyte0);
            }
        }

        return null;
    }

    private static TrackEncryptionBox parseSinfFromParent(ParsableByteArray parsablebytearray, int i, int j)
    {
        int k = i + 8;
        TrackEncryptionBox trackencryptionbox = null;
        while (k - i < j) 
        {
            parsablebytearray.setPosition(k);
            int l = parsablebytearray.readInt();
            int i1 = parsablebytearray.readInt();
            if (i1 == Atom.TYPE_frma)
            {
                parsablebytearray.readInt();
            } else
            if (i1 == Atom.TYPE_schm)
            {
                parsablebytearray.skipBytes(4);
                parsablebytearray.readInt();
                parsablebytearray.readInt();
            } else
            if (i1 == Atom.TYPE_schi)
            {
                trackencryptionbox = parseSchiFromParent(parsablebytearray, k, l);
            }
            k += l;
        }
        return trackencryptionbox;
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containeratom)
    {
        ParsableByteArray parsablebytearray = containeratom.getLeafAtomOfType(Atom.TYPE_stsz).data;
        Object obj = containeratom.getLeafAtomOfType(Atom.TYPE_stco);
        Atom.LeafAtom leafatom = ((Atom.LeafAtom) (obj));
        if (obj == null)
        {
            leafatom = containeratom.getLeafAtomOfType(Atom.TYPE_co64);
        }
        ParsableByteArray parsablebytearray1 = leafatom.data;
        ParsableByteArray parsablebytearray2 = containeratom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsablebytearray3 = containeratom.getLeafAtomOfType(Atom.TYPE_stts).data;
        obj = containeratom.getLeafAtomOfType(Atom.TYPE_stss);
        long al[];
        int ai[];
        long al1[];
        int ai1[];
        int i6;
        int j6;
        if (obj != null)
        {
            obj = ((Atom.LeafAtom) (obj)).data;
        } else
        {
            obj = null;
        }
        containeratom = containeratom.getLeafAtomOfType(Atom.TYPE_ctts);
        if (containeratom != null)
        {
            containeratom = ((Atom.LeafAtom) (containeratom)).data;
        } else
        {
            containeratom = null;
        }
        parsablebytearray.setPosition(12);
        i6 = parsablebytearray.readUnsignedIntToInt();
        j6 = parsablebytearray.readUnsignedIntToInt();
        al = new long[j6];
        ai = new int[j6];
        al1 = new long[j6];
        ai1 = new int[j6];
        if (j6 == 0)
        {
            return new TrackSampleTable(al, ai, al1, ai1);
        }
        parsablebytearray1.setPosition(12);
        int k6 = parsablebytearray1.readUnsignedIntToInt();
        parsablebytearray2.setPosition(12);
        int i3 = parsablebytearray2.readUnsignedIntToInt() - 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int k3;
        boolean flag;
        int j4;
        int k4;
        int l4;
        int j5;
        int k5;
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
        l1 = parsablebytearray2.readUnsignedIntToInt();
        parsablebytearray2.skipBytes(4);
        k = -1;
        if (i3 > 0)
        {
            k = parsablebytearray2.readUnsignedIntToInt() - 1;
        }
        k3 = 0;
        j2 = l1;
        parsablebytearray3.setPosition(12);
        k4 = parsablebytearray3.readUnsignedIntToInt() - 1;
        k2 = parsablebytearray3.readUnsignedIntToInt();
        l4 = parsablebytearray3.readUnsignedIntToInt();
        l = 0;
        j = 0;
        i = 0;
        if (containeratom != null)
        {
            containeratom.setPosition(12);
            j = containeratom.readUnsignedIntToInt() - 1;
            l = containeratom.readUnsignedIntToInt();
            i = containeratom.readInt();
        }
        i1 = -1;
        k1 = 0;
        if (obj != null)
        {
            ((ParsableByteArray) (obj)).setPosition(12);
            k1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt();
            i1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt() - 1;
        }
        if (leafatom.type == Atom.TYPE_stco)
        {
            l6 = parsablebytearray1.readUnsignedInt();
        } else
        {
            l6 = parsablebytearray1.readUnsignedLongToLong();
        }
        l7 = 0L;
        flag = false;
        i2 = i;
        i = l1;
        l1 = j;
        k5 = k1;
        j = i3;
        k1 = j2;
        j4 = l;
        l = k2;
        j5 = i1;
        j2 = ((flag) ? 1 : 0);
        while (j2 < j6) 
        {
            al[j2] = l6;
            int j1;
            int l2;
            int j3;
            int l3;
            int i4;
            int i5;
            int l5;
            long l8;
            if (i6 == 0)
            {
                j1 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                j1 = i6;
            }
            ai[j2] = j1;
            al1[j2] = (long)i2 + l7;
            if (obj == null)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            ai1[j2] = j1;
            j3 = j5;
            l2 = k5;
            if (j2 == j5)
            {
                ai1[j2] = 1;
                j1 = k5 - 1;
                j3 = j5;
                l2 = j1;
                if (j1 > 0)
                {
                    j3 = ((ParsableByteArray) (obj)).readUnsignedIntToInt() - 1;
                    l2 = j1;
                }
            }
            l8 = l7 + (long)l4;
            j1 = l - 1;
            l = j1;
            i4 = k4;
            l3 = l4;
            if (j1 == 0)
            {
                l = j1;
                i4 = k4;
                l3 = l4;
                if (k4 > 0)
                {
                    l = parsablebytearray3.readUnsignedIntToInt();
                    l3 = parsablebytearray3.readUnsignedIntToInt();
                    i4 = k4 - 1;
                }
            }
            j1 = j4;
            l4 = l1;
            i5 = i2;
            if (containeratom != null)
            {
                j4--;
                j1 = j4;
                l4 = l1;
                i5 = i2;
                if (j4 == 0)
                {
                    j1 = j4;
                    l4 = l1;
                    i5 = i2;
                    if (l1 > 0)
                    {
                        j1 = containeratom.readUnsignedIntToInt();
                        i5 = containeratom.readInt();
                        l4 = l1 - 1;
                    }
                }
            }
            l1 = k1 - 1;
            if (l1 == 0)
            {
                j4 = k3 + 1;
                if (j4 < k6)
                {
                    if (leafatom.type == Atom.TYPE_stco)
                    {
                        l6 = parsablebytearray1.readUnsignedInt();
                    } else
                    {
                        l6 = parsablebytearray1.readUnsignedLongToLong();
                    }
                }
                i2 = k;
                k1 = j;
                if (j4 == k)
                {
                    k3 = parsablebytearray2.readUnsignedIntToInt();
                    parsablebytearray2.skipBytes(4);
                    j--;
                    i2 = k;
                    k1 = j;
                    i = k3;
                    if (j > 0)
                    {
                        i2 = parsablebytearray2.readUnsignedIntToInt() - 1;
                        i = k3;
                        k1 = j;
                    }
                }
                k3 = j4;
                k = i2;
                l7 = l6;
                j = k1;
                l5 = i;
                if (j4 < k6)
                {
                    l1 = i;
                    l5 = i;
                    j = k1;
                    l7 = l6;
                    k = i2;
                    k3 = j4;
                }
            } else
            {
                l7 = l6 + (long)ai[j2];
                l5 = i;
            }
            j2++;
            j5 = j3;
            l6 = l7;
            j4 = j1;
            k1 = l1;
            k5 = l2;
            k4 = i4;
            l1 = l4;
            i = l5;
            l4 = l3;
            i2 = i5;
            l7 = l8;
        }
        Util.scaleLargeTimestampsInPlace(al1, 0xf4240L, track.timescale);
        if (k5 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (l == 0)
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
        if (k4 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        if (l1 == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkArgument(flag1);
        return new TrackSampleTable(al, ai, al1, ai1);
    }

    private static StsdDataHolder parseStsd(ParsableByteArray parsablebytearray, long l)
    {
        parsablebytearray.setPosition(12);
        int j = parsablebytearray.readInt();
        StsdDataHolder stsddataholder = new StsdDataHolder(j);
        int i = 0;
        while (i < j) 
        {
            int k = parsablebytearray.getPosition();
            int i1 = parsablebytearray.readInt();
            int j1;
            boolean flag;
            if (i1 > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkArgument(flag, "childAtomSize should be positive");
            j1 = parsablebytearray.readInt();
            if (j1 == Atom.TYPE_avc1 || j1 == Atom.TYPE_avc3 || j1 == Atom.TYPE_encv || j1 == Atom.TYPE_mp4v || j1 == Atom.TYPE_hvc1 || j1 == Atom.TYPE_hev1 || j1 == Atom.TYPE_s263)
            {
                parseVideoSampleEntry(parsablebytearray, k, i1, l, stsddataholder, i);
            } else
            if (j1 == Atom.TYPE_mp4a || j1 == Atom.TYPE_enca || j1 == Atom.TYPE_ac_3)
            {
                parseAudioSampleEntry(parsablebytearray, j1, k, i1, l, stsddataholder, i);
            } else
            if (j1 == Atom.TYPE_TTML)
            {
                stsddataholder.mediaFormat = MediaFormat.createTextFormat("application/ttml+xml", l);
            } else
            if (j1 == Atom.TYPE_tx3g)
            {
                stsddataholder.mediaFormat = MediaFormat.createTextFormat("application/x-quicktime-tx3g", l);
            }
            parsablebytearray.setPosition(k + i1);
            i++;
        }
        return stsddataholder;
    }

    private static Pair parseTkhd(ParsableByteArray parsablebytearray)
    {
        int i = 4;
        parsablebytearray.setPosition(8);
        int j = Atom.parseFullAtomVersion(parsablebytearray.readInt());
        byte byte0;
        boolean flag1;
        int k;
        int l;
        if (j == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 16;
        }
        parsablebytearray.skipBytes(byte0);
        k = parsablebytearray.readInt();
        parsablebytearray.skipBytes(4);
        flag1 = true;
        l = parsablebytearray.getPosition();
        if (j == 0)
        {
            byte0 = i;
        } else
        {
            byte0 = 8;
        }
        i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < byte0)
                {
                    if (parsablebytearray.data[l + i] == -1)
                    {
                        break label0;
                    }
                    flag = false;
                }
                long l1;
                if (flag)
                {
                    parsablebytearray.skipBytes(byte0);
                    l1 = -1L;
                } else
                if (j == 0)
                {
                    l1 = parsablebytearray.readUnsignedInt();
                } else
                {
                    l1 = parsablebytearray.readUnsignedLongToLong();
                }
                return Pair.create(Integer.valueOf(k), Long.valueOf(l1));
            }
            i++;
        } while (true);
    }

    public static Track parseTrak(Atom.ContainerAtom containeratom, Atom.LeafAtom leafatom)
    {
        Atom.ContainerAtom containeratom1 = containeratom.getContainerAtomOfType(Atom.TYPE_mdia);
        int i = parseHdlr(containeratom1.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (i != Track.TYPE_AUDIO && i != Track.TYPE_VIDEO && i != Track.TYPE_TEXT && i != Track.TYPE_SUBTITLE)
        {
            return null;
        }
        containeratom = parseTkhd(containeratom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        int j = ((Integer)((Pair) (containeratom)).first).intValue();
        long l = ((Long)((Pair) (containeratom)).second).longValue();
        long l1 = parseMvhd(leafatom.data);
        if (l == -1L)
        {
            l = -1L;
        } else
        {
            l = Util.scaleLargeTimestamp(l, 0xf4240L, l1);
        }
        containeratom = containeratom1.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        l1 = parseMdhd(containeratom1.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        containeratom = parseStsd(containeratom.getLeafAtomOfType(Atom.TYPE_stsd).data, l);
        if (((StsdDataHolder) (containeratom)).mediaFormat == null)
        {
            return null;
        } else
        {
            return new Track(j, i, l1, l, ((StsdDataHolder) (containeratom)).mediaFormat, ((StsdDataHolder) (containeratom)).trackEncryptionBoxes, ((StsdDataHolder) (containeratom)).nalUnitLengthFieldLength);
        }
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsablebytearray, int i, int j, long l, StsdDataHolder stsddataholder, int k)
    {
        float f;
        Object obj1;
        String s1;
        int i1;
        int j1;
        int k1;
        parsablebytearray.setPosition(i + 8);
        parsablebytearray.skipBytes(24);
        j1 = parsablebytearray.readUnsignedShort();
        k1 = parsablebytearray.readUnsignedShort();
        f = 1.0F;
        parsablebytearray.skipBytes(50);
        obj1 = null;
        i1 = parsablebytearray.getPosition();
        s1 = null;
_L2:
label0:
        {
            int l1;
            int i2;
            if (i1 - i < j)
            {
                parsablebytearray.setPosition(i1);
                l1 = parsablebytearray.getPosition();
                i2 = parsablebytearray.readInt();
                if (i2 != 0 || parsablebytearray.getPosition() - i != j)
                {
                    break label0;
                }
            }
            String s;
            Object obj;
            int j2;
            boolean flag;
            if (s1 == null)
            {
                return;
            } else
            {
                stsddataholder.mediaFormat = MediaFormat.createVideoFormat(s1, -1, l, j1, k1, f, ((List) (obj1)));
                return;
            }
        }
        if (i2 > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag, "childAtomSize should be positive");
        j2 = parsablebytearray.readInt();
        if (j2 != Atom.TYPE_avcC)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s1 == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        s = "video/avc";
        obj1 = parseAvcCFromParent(parsablebytearray, l1);
        obj = (List)((Pair) (obj1)).first;
        stsddataholder.nalUnitLengthFieldLength = ((Integer)((Pair) (obj1)).second).intValue();
_L3:
        i1 += i2;
        s1 = s;
        obj1 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        if (j2 == Atom.TYPE_hvcC)
        {
            if (s1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            s = "video/hevc";
            obj1 = parseHvcCFromParent(parsablebytearray, l1);
            obj = (List)((Pair) (obj1)).first;
            stsddataholder.nalUnitLengthFieldLength = ((Integer)((Pair) (obj1)).second).intValue();
        } else
        if (j2 == Atom.TYPE_d263)
        {
            if (s1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            s = "video/3gpp";
            obj = obj1;
        } else
        if (j2 == Atom.TYPE_esds)
        {
            if (s1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            obj = parseEsdsFromParent(parsablebytearray, l1);
            s = (String)((Pair) (obj)).first;
            obj = Collections.singletonList(((Pair) (obj)).second);
        } else
        if (j2 == Atom.TYPE_sinf)
        {
            stsddataholder.trackEncryptionBoxes[k] = parseSinfFromParent(parsablebytearray, l1, i2);
            s = s1;
            obj = obj1;
        } else
        {
            s = s1;
            obj = obj1;
            if (j2 == Atom.TYPE_pasp)
            {
                f = parsePaspFromParent(parsablebytearray, l1);
                s = s1;
                obj = obj1;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }
}
