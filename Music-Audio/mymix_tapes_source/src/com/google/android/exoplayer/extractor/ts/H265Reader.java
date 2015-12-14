// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.Collections;

// Referenced classes of package com.google.android.exoplayer.extractor.ts:
//            ElementaryStreamReader, NalUnitTargetBuffer, SeiReader

final class H265Reader extends ElementaryStreamReader
{

    private static final int BLA_N_LP = 18;
    private static final int BLA_W_LP = 16;
    private static final int BLA_W_RADL = 17;
    private static final int CRA_NUT = 21;
    private static final int IDR_N_LP = 20;
    private static final int IDR_W_RADL = 19;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private boolean foundFirstSample;
    private boolean hasOutputFormat;
    private boolean isKeyframe;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean prefixFlags[] = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private long samplePosition;
    private long sampleTimeUs;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    public H265Reader(TrackOutput trackoutput, SeiReader seireader)
    {
        super(trackoutput);
        seiReader = seireader;
    }

    private void feedNalUnitTargetBuffersData(byte abyte0[], int i, int j)
    {
        if (!hasOutputFormat)
        {
            vps.appendToNalUnit(abyte0, i, j);
            sps.appendToNalUnit(abyte0, i, j);
            pps.appendToNalUnit(abyte0, i, j);
        }
        prefixSei.appendToNalUnit(abyte0, i, j);
        suffixSei.appendToNalUnit(abyte0, i, j);
    }

    private void feedNalUnitTargetBuffersStart(int i)
    {
        if (!hasOutputFormat)
        {
            vps.startNalUnit(i);
            sps.startNalUnit(i);
            pps.startNalUnit(i);
        }
        prefixSei.startNalUnit(i);
        suffixSei.startNalUnit(i);
    }

    private void feedNalUnitTargetEnd(long l, int i)
    {
        vps.endNalUnit(i);
        sps.endNalUnit(i);
        pps.endNalUnit(i);
        if (prefixSei.endNalUnit(i))
        {
            int j = NalUnitUtil.unescapeStream(prefixSei.nalData, prefixSei.nalLength);
            seiWrapper.reset(prefixSei.nalData, j);
            seiWrapper.skipBytes(5);
            seiReader.consume(seiWrapper, l, true);
        }
        if (suffixSei.endNalUnit(i))
        {
            i = NalUnitUtil.unescapeStream(suffixSei.nalData, suffixSei.nalLength);
            seiWrapper.reset(suffixSei.nalData, i);
            seiWrapper.skipBytes(5);
            seiReader.consume(seiWrapper, l, true);
        }
    }

    public static boolean isFirstSliceSegmentInPic(byte abyte0[], int i)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            int j = NalUnitUtil.getH265NalUnitType(abyte0, i);
            if (j > 9)
            {
                flag = flag1;
                if (j < 16)
                {
                    break label0;
                }
                flag = flag1;
                if (j > 21)
                {
                    break label0;
                }
            }
            flag = flag1;
            if ((abyte0[i + 5] & 0x80) != 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isRandomAccessPoint(int i)
    {
        return i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21;
    }

    private void parseMediaFormat(NalUnitTargetBuffer nalunittargetbuffer, NalUnitTargetBuffer nalunittargetbuffer1, NalUnitTargetBuffer nalunittargetbuffer2)
    {
        byte abyte0[] = new byte[nalunittargetbuffer.nalLength + nalunittargetbuffer1.nalLength + nalunittargetbuffer2.nalLength];
        System.arraycopy(nalunittargetbuffer.nalData, 0, abyte0, 0, nalunittargetbuffer.nalLength);
        System.arraycopy(nalunittargetbuffer1.nalData, 0, abyte0, nalunittargetbuffer.nalLength, nalunittargetbuffer1.nalLength);
        System.arraycopy(nalunittargetbuffer2.nalData, 0, abyte0, nalunittargetbuffer.nalLength + nalunittargetbuffer1.nalLength, nalunittargetbuffer2.nalLength);
        NalUnitUtil.unescapeStream(nalunittargetbuffer1.nalData, nalunittargetbuffer1.nalLength);
        nalunittargetbuffer = new ParsableBitArray(nalunittargetbuffer1.nalData);
        nalunittargetbuffer.skipBits(44);
        int l1 = nalunittargetbuffer.readBits(3);
        nalunittargetbuffer.skipBits(1);
        nalunittargetbuffer.skipBits(88);
        nalunittargetbuffer.skipBits(8);
        int i = 0;
        for (int j1 = 0; j1 < l1; j1++)
        {
            int l = i;
            if (nalunittargetbuffer.readBits(1) == 1)
            {
                l = i + 89;
            }
            i = l;
            if (nalunittargetbuffer.readBits(1) == 1)
            {
                i = l + 8;
            }
        }

        nalunittargetbuffer.skipBits(i);
        if (l1 > 0)
        {
            nalunittargetbuffer.skipBits((8 - l1) * 2);
        }
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int k3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (k3 == 3)
        {
            nalunittargetbuffer.skipBits(1);
        }
        int k2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int j2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        int k1 = k2;
        int i1 = j2;
        if (nalunittargetbuffer.readBit())
        {
            k1 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            int j3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            int l2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            int i3 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            if (k3 == 1 || k3 == 2)
            {
                i = 2;
            } else
            {
                i = 1;
            }
            if (k3 == 1)
            {
                i1 = 2;
            } else
            {
                i1 = 1;
            }
            k1 = k2 - (k1 + j3) * i;
            i1 = j2 - (l2 + i3) * i1;
        }
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        j2 = nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (nalunittargetbuffer.readBit())
        {
            i = 0;
        } else
        {
            i = l1;
        }
        for (; i <= l1; i++)
        {
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        }

        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        nalunittargetbuffer.readUnsignedExpGolombCodedInt();
        if (nalunittargetbuffer.readBit() && nalunittargetbuffer.readBit())
        {
            skipScalingList(nalunittargetbuffer);
        }
        nalunittargetbuffer.skipBits(2);
        if (nalunittargetbuffer.readBit())
        {
            nalunittargetbuffer.skipBits(4);
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.readUnsignedExpGolombCodedInt();
            nalunittargetbuffer.skipBits(1);
        }
        skipShortTermRefPicSets(nalunittargetbuffer);
        if (nalunittargetbuffer.readBit())
        {
            for (int j = 0; j < nalunittargetbuffer.readUnsignedExpGolombCodedInt(); j++)
            {
                nalunittargetbuffer.skipBits(j2 + 4 + 1);
            }

        }
        nalunittargetbuffer.skipBits(2);
        float f1 = 1.0F;
        float f = f1;
        if (nalunittargetbuffer.readBit())
        {
            f = f1;
            if (nalunittargetbuffer.readBit())
            {
                int k = nalunittargetbuffer.readBits(8);
                if (k == 255)
                {
                    k = nalunittargetbuffer.readBits(16);
                    int i2 = nalunittargetbuffer.readBits(16);
                    f = f1;
                    if (k != 0)
                    {
                        f = f1;
                        if (i2 != 0)
                        {
                            f = (float)k / (float)i2;
                        }
                    }
                } else
                if (k < NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length)
                {
                    f = NalUnitUtil.ASPECT_RATIO_IDC_VALUES[k];
                } else
                {
                    Log.w("H265Reader", (new StringBuilder()).append("Unexpected aspect_ratio_idc value: ").append(k).toString());
                    f = f1;
                }
            }
        }
        output.format(MediaFormat.createVideoFormat("video/hevc", -1, -1L, k1, i1, f, Collections.singletonList(abyte0)));
        hasOutputFormat = true;
    }

    private void skipScalingList(ParsableBitArray parsablebitarray)
    {
        for (int i = 0; i < 4; i++)
        {
            int j = 0;
            while (j < 6) 
            {
                int k;
                if (!parsablebitarray.readBit())
                {
                    parsablebitarray.readUnsignedExpGolombCodedInt();
                } else
                {
                    int l = Math.min(64, 1 << (i + 4 << 1));
                    if (i > 1)
                    {
                        parsablebitarray.readSignedExpGolombCodedInt();
                    }
                    k = 0;
                    while (k < l) 
                    {
                        parsablebitarray.readSignedExpGolombCodedInt();
                        k++;
                    }
                }
                if (i == 3)
                {
                    k = 3;
                } else
                {
                    k = 1;
                }
                j += k;
            }
        }

    }

    private static void skipShortTermRefPicSets(ParsableBitArray parsablebitarray)
    {
        int j1 = parsablebitarray.readUnsignedExpGolombCodedInt();
        boolean flag = false;
        int k = 0;
        for (int i = 0; i < j1;)
        {
            if (i != 0)
            {
                flag = parsablebitarray.readBit();
            }
            int j;
            if (flag)
            {
                parsablebitarray.skipBits(1);
                parsablebitarray.readUnsignedExpGolombCodedInt();
                int l = 0;
                do
                {
                    j = k;
                    if (l > k)
                    {
                        break;
                    }
                    if (parsablebitarray.readBit())
                    {
                        parsablebitarray.skipBits(1);
                    }
                    l++;
                } while (true);
            } else
            {
                k = parsablebitarray.readUnsignedExpGolombCodedInt();
                int k1 = parsablebitarray.readUnsignedExpGolombCodedInt();
                int i1 = k + k1;
                for (j = 0; j < k; j++)
                {
                    parsablebitarray.readUnsignedExpGolombCodedInt();
                    parsablebitarray.skipBits(1);
                }

                k = 0;
                do
                {
                    j = i1;
                    if (k >= k1)
                    {
                        break;
                    }
                    parsablebitarray.readUnsignedExpGolombCodedInt();
                    parsablebitarray.skipBits(1);
                    k++;
                } while (true);
            }
            i++;
            k = j;
        }

    }

    public void consume(ParsableByteArray parsablebytearray, long l, boolean flag)
    {
        while (parsablebytearray.bytesLeft() > 0) 
        {
            int i = parsablebytearray.getPosition();
            int j = parsablebytearray.limit();
            byte abyte0[] = parsablebytearray.data;
            totalBytesWritten = totalBytesWritten + (long)parsablebytearray.bytesLeft();
            output.sampleData(parsablebytearray, parsablebytearray.bytesLeft());
            while (i < j) 
            {
                int k = NalUnitUtil.findNalUnit(abyte0, i, j, prefixFlags);
                if (k < j)
                {
                    int j1 = k - i;
                    if (j1 > 0)
                    {
                        feedNalUnitTargetBuffersData(abyte0, i, k);
                    }
                    int i1 = NalUnitUtil.getH265NalUnitType(abyte0, k);
                    int k1 = j - k;
                    if (isFirstSliceSegmentInPic(abyte0, k))
                    {
                        if (foundFirstSample)
                        {
                            if (isKeyframe && !hasOutputFormat && vps.isCompleted() && sps.isCompleted() && pps.isCompleted())
                            {
                                parseMediaFormat(vps, sps, pps);
                            }
                            int l1;
                            if (isKeyframe)
                            {
                                i = 1;
                            } else
                            {
                                i = 0;
                            }
                            l1 = (int)(totalBytesWritten - samplePosition);
                            output.sampleMetadata(sampleTimeUs, i, l1 - k1, k1, null);
                        }
                        foundFirstSample = true;
                        samplePosition = totalBytesWritten - (long)k1;
                        sampleTimeUs = l;
                        isKeyframe = isRandomAccessPoint(i1);
                    }
                    if (j1 < 0)
                    {
                        i = -j1;
                    } else
                    {
                        i = 0;
                    }
                    feedNalUnitTargetEnd(l, i);
                    feedNalUnitTargetBuffersStart(i1);
                    i = k + 3;
                } else
                {
                    feedNalUnitTargetBuffersData(abyte0, i, j);
                    i = j;
                }
            }
        }
    }

    public void packetFinished()
    {
    }

    public void seek()
    {
        seiReader.seek();
        NalUnitUtil.clearPrefixFlags(prefixFlags);
        vps.reset();
        sps.reset();
        pps.reset();
        prefixSei.reset();
        suffixSei.reset();
        foundFirstSample = false;
        totalBytesWritten = 0L;
    }
}
