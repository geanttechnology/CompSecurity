// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.webm;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.webm:
//            WebmExtractor

private static final class <init>
{

    public int channelCount;
    public long codecDelayNs;
    public String codecId;
    public byte codecPrivate[];
    public int defaultSampleDurationNs;
    public byte encryptionKeyId[];
    public boolean hasContentEncryption;
    public int nalUnitLengthFieldLength;
    public int number;
    public int pixelHeight;
    public int pixelWidth;
    public int sampleRate;
    public byte sampleStrippedBytes[];
    public long seekPreRollNs;
    public TrackOutput trackOutput;
    public int type;

    private static Pair parseAvcCodecPrivate(ParsableByteArray parsablebytearray)
        throws ParserException
    {
        ArrayList arraylist;
        int i;
        int j;
        int k;
        boolean flag;
        try
        {
            parsablebytearray.setPosition(4);
            j = (parsablebytearray.readUnsignedByte() & 3) + 1;
        }
        // Misplaced declaration of an exception variable
        catch (ParsableByteArray parsablebytearray)
        {
            throw new ParserException("Error parsing AVC codec private");
        }
        if (j != 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        arraylist = new ArrayList();
        k = parsablebytearray.readUnsignedByte();
        i = 0;
_L2:
        if (i >= (k & 0x1f))
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        k = parsablebytearray.readUnsignedByte();
        i = 0;
_L4:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        parsablebytearray = Pair.create(arraylist, Integer.valueOf(j));
        return parsablebytearray;
    }

    private static Pair parseHevcCodecPrivate(ParsableByteArray parsablebytearray)
        throws ParserException
    {
        int i;
        int j;
        byte abyte0[];
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        try
        {
            parsablebytearray.setPosition(21);
            i1 = parsablebytearray.readUnsignedByte();
            j1 = parsablebytearray.readUnsignedByte();
        }
        // Misplaced declaration of an exception variable
        catch (ParsableByteArray parsablebytearray)
        {
            throw new ParserException("Error parsing HEVC codec private");
        }
        i = 0;
        l = parsablebytearray.getPosition();
        j = 0;
_L10:
        if (j >= j1) goto _L2; else goto _L1
_L1:
        parsablebytearray.skipBytes(1);
        k1 = parsablebytearray.readUnsignedShort();
        k = 0;
_L4:
        if (k >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = parsablebytearray.readUnsignedShort();
        i += l1 + 4;
        parsablebytearray.skipBytes(l1);
        k++;
        if (true) goto _L4; else goto _L3
_L2:
        parsablebytearray.setPosition(l);
        abyte0 = new byte[i];
        l = 0;
        j = 0;
_L11:
        if (j >= j1) goto _L6; else goto _L5
_L5:
        parsablebytearray.skipBytes(1);
        k1 = parsablebytearray.readUnsignedShort();
        k = 0;
_L8:
        if (k >= k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = parsablebytearray.readUnsignedShort();
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, l, NalUnitUtil.NAL_START_CODE.length);
        l += NalUnitUtil.NAL_START_CODE.length;
        System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, l, l1);
        l += l1;
        parsablebytearray.skipBytes(l1);
        k++;
        if (true) goto _L8; else goto _L7
_L7:
        continue; /* Loop/switch isn't completed */
_L9:
        return Pair.create(parsablebytearray, Integer.valueOf((i1 & 3) + 1));
_L13:
        parsablebytearray = Collections.singletonList(abyte0);
          goto _L9
_L3:
        j++;
          goto _L10
        j++;
          goto _L11
_L6:
        if (i != 0) goto _L13; else goto _L12
_L12:
        parsablebytearray = null;
          goto _L9
    }

    private static List parseVorbisCodecPrivate(byte abyte0[])
        throws ParserException
    {
_L2:
        k = j + 1;
        j = abyte0[j];
        if (abyte0[k] == 1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        throw new ParserException("Error parsing vorbis codec private");
        abyte1 = new byte[l];
        System.arraycopy(abyte0, k, abyte1, 0, l);
        k += l;
        if (abyte0[k] == 3)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        throw new ParserException("Error parsing vorbis codec private");
        i = k + (i + j);
        if (abyte0[i] == 5)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        throw new ParserException("Error parsing vorbis codec private");
        byte abyte2[] = new byte[abyte0.length - i];
        System.arraycopy(abyte0, i, abyte2, 0, abyte0.length - i);
        abyte0 = new ArrayList(2);
        abyte0.add(abyte1);
        abyte0.add(abyte2);
        return abyte0;
        if (abyte0[0] != 2)
        {
            try
            {
                throw new ParserException("Error parsing vorbis codec private");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }
        int j = 0;
        byte abyte1[];
        int i;
        int k;
        int l;
        for (i = 1; abyte0[i] == -1; i++)
        {
            j += 255;
        }

        l = j + abyte0[i];
        j = 0;
        k = i + 1;
        i = j;
        j = k;
        while (abyte0[j] == -1) 
        {
            i += 255;
            j++;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public MediaFormat getMediaFormat(long l)
        throws ParserException
    {
        String s;
        Object obj;
        char c;
        byte byte0;
        obj = null;
        byte0 = -1;
        s = codecId;
        c = '\uFFFF';
        s.hashCode();
        JVM INSTR lookupswitch 12: default 124
    //                   -2095576542: 258
    //                   -2095575984: 228
    //                   -1730367663: 304
    //                   -1482641357: 352
    //                   -538363189: 243
    //                   -538363109: 273
    //                   62923557: 336
    //                   62923603: 368
    //                   82338133: 198
    //                   82338134: 213
    //                   855502857: 288
    //                   1951062397: 320;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        c;
        JVM INSTR tableswitch 0 11: default 188
    //                   0 384
    //                   1 416
    //                   2 426
    //                   3 426
    //                   4 426
    //                   5 458
    //                   6 509
    //                   7 560
    //                   8 580
    //                   9 659
    //                   10 678
    //                   11 689;
           goto _L14 _L15 _L16 _L17 _L17 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L14:
        throw new ParserException("Unrecognized codec identifier.");
_L10:
        if (s.equals("V_VP8"))
        {
            c = '\0';
        }
          goto _L1
_L11:
        if (s.equals("V_VP9"))
        {
            c = '\001';
        }
          goto _L1
_L3:
        if (s.equals("V_MPEG4/ISO/SP"))
        {
            c = '\002';
        }
          goto _L1
_L6:
        if (s.equals("V_MPEG4/ISO/ASP"))
        {
            c = '\003';
        }
          goto _L1
_L2:
        if (s.equals("V_MPEG4/ISO/AP"))
        {
            c = '\004';
        }
          goto _L1
_L7:
        if (s.equals("V_MPEG4/ISO/AVC"))
        {
            c = '\005';
        }
          goto _L1
_L12:
        if (s.equals("V_MPEGH/ISO/HEVC"))
        {
            c = '\006';
        }
          goto _L1
_L4:
        if (s.equals("A_VORBIS"))
        {
            c = '\007';
        }
          goto _L1
_L13:
        if (s.equals("A_OPUS"))
        {
            c = '\b';
        }
          goto _L1
_L8:
        if (s.equals("A_AAC"))
        {
            c = '\t';
        }
          goto _L1
_L5:
        if (s.equals("A_MPEG/L3"))
        {
            c = '\n';
        }
          goto _L1
_L9:
        if (s.equals("A_AC3"))
        {
            c = '\013';
        }
          goto _L1
_L15:
        s = "video/x-vnd.on2.vp8";
        c = byte0;
_L26:
        if (MimeTypes.isAudio(s))
        {
            return MediaFormat.createAudioFormat(s, c, l, channelCount, sampleRate, ((List) (obj)));
        }
        break; /* Loop/switch isn't completed */
_L16:
        s = "video/x-vnd.on2.vp9";
        c = byte0;
        continue; /* Loop/switch isn't completed */
_L17:
        s = "video/mp4v-es";
        if (codecPrivate == null)
        {
            obj = null;
        } else
        {
            obj = Collections.singletonList(codecPrivate);
        }
        c = byte0;
        continue; /* Loop/switch isn't completed */
_L18:
        s = "video/avc";
        Pair pair = parseAvcCodecPrivate(new ParsableByteArray(codecPrivate));
        obj = (List)pair.first;
        nalUnitLengthFieldLength = ((Integer)pair.second).intValue();
        c = byte0;
        continue; /* Loop/switch isn't completed */
_L19:
        s = "video/hevc";
        Pair pair1 = parseHevcCodecPrivate(new ParsableByteArray(codecPrivate));
        obj = (List)pair1.first;
        nalUnitLengthFieldLength = ((Integer)pair1.second).intValue();
        c = byte0;
        continue; /* Loop/switch isn't completed */
_L20:
        s = "audio/vorbis";
        c = '\u2000';
        obj = parseVorbisCodecPrivate(codecPrivate);
        continue; /* Loop/switch isn't completed */
_L21:
        s = "audio/opus";
        c = '\u1680';
        obj = new ArrayList(3);
        ((List) (obj)).add(codecPrivate);
        ((List) (obj)).add(ByteBuffer.allocate(64).putLong(codecDelayNs).array());
        ((List) (obj)).add(ByteBuffer.allocate(64).putLong(seekPreRollNs).array());
        continue; /* Loop/switch isn't completed */
_L22:
        s = "audio/mp4a-latm";
        obj = Collections.singletonList(codecPrivate);
        c = byte0;
        continue; /* Loop/switch isn't completed */
_L23:
        c = '\u1000';
        s = "audio/mpeg";
        continue; /* Loop/switch isn't completed */
_L24:
        s = "audio/ac3";
        c = byte0;
        if (true) goto _L26; else goto _L25
_L25:
        if (MimeTypes.isVideo(s))
        {
            return MediaFormat.createVideoFormat(s, c, l, pixelWidth, pixelHeight, ((List) (obj)));
        } else
        {
            throw new ParserException("Unexpected MIME type.");
        }
    }

    private ()
    {
        number = -1;
        type = -1;
        defaultSampleDurationNs = -1;
        pixelWidth = -1;
        pixelHeight = -1;
        nalUnitLengthFieldLength = -1;
        channelCount = -1;
        sampleRate = -1;
        codecDelayNs = -1L;
        seekPreRollNs = -1L;
    }

    seekPreRollNs(seekPreRollNs seekprerollns)
    {
        this();
    }
}
