// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import android.util.Pair;

public class MediaProperties
{

    public static final int ACODEC_AAC_LC = 2;
    public static final int ACODEC_AAC_PLUS = 3;
    public static final int ACODEC_AMRNB = 1;
    public static final int ACODEC_AMRWB = 8;
    public static final int ACODEC_ENHANCED_AAC_PLUS = 4;
    public static final int ACODEC_EVRC = 6;
    public static final int ACODEC_MP3 = 5;
    public static final int ACODEC_NO_AUDIO = 0;
    public static final int ACODEC_OGG = 9;
    private static final int ASPECT_RATIOS[] = {
        1, 2, 3, 4, 5, 6
    };
    public static final int ASPECT_RATIO_11_9 = 5;
    private static final Pair ASPECT_RATIO_11_9_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(176), Integer.valueOf(144)), new Pair(Integer.valueOf(352), Integer.valueOf(288))
    };
    public static final int ASPECT_RATIO_16_9 = 2;
    private static final Pair ASPECT_RATIO_16_9_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(640), Integer.valueOf(360)), new Pair(Integer.valueOf(854), Integer.valueOf(480)), new Pair(Integer.valueOf(1280), Integer.valueOf(720)), new Pair(Integer.valueOf(1920), Integer.valueOf(1080))
    };
    public static final int ASPECT_RATIO_1_1 = 6;
    private static final Pair ASPECT_RATIO_1_1_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(480), Integer.valueOf(480))
    };
    public static final int ASPECT_RATIO_3_2 = 1;
    private static final Pair ASPECT_RATIO_3_2_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(720), Integer.valueOf(480)), new Pair(Integer.valueOf(1080), Integer.valueOf(720))
    };
    public static final int ASPECT_RATIO_4_3 = 3;
    private static final Pair ASPECT_RATIO_4_3_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(128), Integer.valueOf(96)), new Pair(Integer.valueOf(160), Integer.valueOf(120)), new Pair(Integer.valueOf(320), Integer.valueOf(240)), new Pair(Integer.valueOf(640), Integer.valueOf(480)), new Pair(Integer.valueOf(960), Integer.valueOf(720))
    };
    public static final int ASPECT_RATIO_5_3 = 4;
    private static final Pair ASPECT_RATIO_5_3_RESOLUTIONS[] = {
        new Pair(Integer.valueOf(800), Integer.valueOf(480))
    };
    public static final int ASPECT_RATIO_UNDEFINED = 0;
    public static final int AUDIO_MAX_TRACK_COUNT = 1;
    public static final int AUDIO_MAX_VOLUME_PERCENT = 100;
    public static final int BITRATE_128K = 0x1f400;
    public static final int BITRATE_192K = 0x2ee00;
    public static final int BITRATE_1M = 0xf4240;
    public static final int BITRATE_1_2M = 0x124f80;
    public static final int BITRATE_1_5M = 0x16e360;
    public static final int BITRATE_256K = 0x3e800;
    public static final int BITRATE_28K = 28000;
    public static final int BITRATE_2M = 0x1e8480;
    public static final int BITRATE_384K = 0x5dc00;
    public static final int BITRATE_40K = 40000;
    public static final int BITRATE_512K = 0x7d000;
    public static final int BITRATE_5M = 0x4c4b40;
    public static final int BITRATE_64K = 64000;
    public static final int BITRATE_800K = 0xc3500;
    public static final int BITRATE_8M = 0x7a1200;
    public static final int BITRATE_96K = 0x17700;
    public static final int DEFAULT_CHANNEL_COUNT = 1;
    public static final int DEFAULT_SAMPLING_FREQUENCY = 32000;
    public static final int FILE_3GP = 0;
    public static final int FILE_AMR = 2;
    public static final int FILE_JPEG = 5;
    public static final int FILE_M4V = 10;
    public static final int FILE_MP3 = 3;
    public static final int FILE_MP4 = 1;
    public static final int FILE_PNG = 8;
    public static final int FILE_UNSUPPORTED = 255;
    public static final int H263_PROFILE_0_LEVEL_10 = 0;
    public static final int H263_PROFILE_0_LEVEL_20 = 1;
    public static final int H263_PROFILE_0_LEVEL_30 = 2;
    public static final int H263_PROFILE_0_LEVEL_40 = 3;
    public static final int H263_PROFILE_0_LEVEL_45 = 4;
    public static final int H264_PROFILE_0_LEVEL_1 = 150;
    public static final int H264_PROFILE_0_LEVEL_1B = 151;
    public static final int H264_PROFILE_0_LEVEL_1_1 = 152;
    public static final int H264_PROFILE_0_LEVEL_1_2 = 153;
    public static final int H264_PROFILE_0_LEVEL_1_3 = 154;
    public static final int H264_PROFILE_0_LEVEL_2 = 155;
    public static final int H264_PROFILE_0_LEVEL_2_1 = 156;
    public static final int H264_PROFILE_0_LEVEL_2_2 = 157;
    public static final int H264_PROFILE_0_LEVEL_3 = 158;
    public static final int H264_PROFILE_0_LEVEL_3_1 = 159;
    public static final int H264_PROFILE_0_LEVEL_3_2 = 160;
    public static final int H264_PROFILE_0_LEVEL_4 = 161;
    public static final int H264_PROFILE_0_LEVEL_4_1 = 162;
    public static final int H264_PROFILE_0_LEVEL_4_2 = 163;
    public static final int H264_PROFILE_0_LEVEL_5 = 164;
    public static final int H264_PROFILE_0_LEVEL_5_1 = 165;
    public static final int H264_PROFILE_H_LEVEL_1 = 210;
    public static final int H264_PROFILE_H_LEVEL_1B = 211;
    public static final int H264_PROFILE_H_LEVEL_1_1 = 212;
    public static final int H264_PROFILE_H_LEVEL_1_2 = 213;
    public static final int H264_PROFILE_H_LEVEL_1_3 = 214;
    public static final int H264_PROFILE_H_LEVEL_2 = 215;
    public static final int H264_PROFILE_H_LEVEL_2_1 = 216;
    public static final int H264_PROFILE_H_LEVEL_2_2 = 217;
    public static final int H264_PROFILE_H_LEVEL_3 = 218;
    public static final int H264_PROFILE_H_LEVEL_3_1 = 219;
    public static final int H264_PROFILE_H_LEVEL_3_2 = 220;
    public static final int H264_PROFILE_H_LEVEL_4 = 221;
    public static final int H264_PROFILE_H_LEVEL_4_1 = 222;
    public static final int H264_PROFILE_H_LEVEL_4_2 = 223;
    public static final int H264_PROFILE_H_LEVEL_5 = 224;
    public static final int H264_PROFILE_H_LEVEL_5_1 = 225;
    public static final int H264_PROFILE_M_LEVEL_1 = 180;
    public static final int H264_PROFILE_M_LEVEL_1B = 181;
    public static final int H264_PROFILE_M_LEVEL_1_1 = 182;
    public static final int H264_PROFILE_M_LEVEL_1_2 = 183;
    public static final int H264_PROFILE_M_LEVEL_1_3 = 184;
    public static final int H264_PROFILE_M_LEVEL_2 = 185;
    public static final int H264_PROFILE_M_LEVEL_2_1 = 186;
    public static final int H264_PROFILE_M_LEVEL_2_2 = 187;
    public static final int H264_PROFILE_M_LEVEL_3 = 188;
    public static final int H264_PROFILE_M_LEVEL_3_1 = 189;
    public static final int H264_PROFILE_M_LEVEL_3_2 = 190;
    public static final int H264_PROFILE_M_LEVEL_4 = 191;
    public static final int H264_PROFILE_M_LEVEL_4_1 = 192;
    public static final int H264_PROFILE_M_LEVEL_4_2 = 193;
    public static final int H264_PROFILE_M_LEVEL_5 = 194;
    public static final int H264_PROFILE_M_LEVEL_5_1 = 195;
    public static final int HEIGHT_1080 = 1080;
    public static final int HEIGHT_120 = 120;
    public static final int HEIGHT_144 = 144;
    public static final int HEIGHT_240 = 240;
    public static final int HEIGHT_288 = 288;
    public static final int HEIGHT_360 = 360;
    public static final int HEIGHT_480 = 480;
    public static final int HEIGHT_720 = 720;
    public static final int HEIGHT_96 = 96;
    public static final int MAX_MMS_CLIP_MOOV_SIZE = 15360;
    public static final int MAX_MMS_CLIP_SIZE = 0x4b000;
    public static final int MPEG4_SP_LEVEL_0 = 50;
    public static final int MPEG4_SP_LEVEL_0B = 51;
    public static final int MPEG4_SP_LEVEL_1 = 52;
    public static final int MPEG4_SP_LEVEL_2 = 53;
    public static final int MPEG4_SP_LEVEL_3 = 54;
    public static final int MPEG4_SP_LEVEL_4A = 55;
    public static final int MPEG4_SP_LEVEL_5 = 56;
    public static final int MPEG4_SP_LEVEL_6 = 57;
    public static final int SAMPLES_PER_FRAME_AAC = 1024;
    public static final int SAMPLES_PER_FRAME_AMRNB = 160;
    public static final int SAMPLES_PER_FRAME_AMRWB = 320;
    public static final int SAMPLES_PER_FRAME_EAAC = 2048;
    public static final int SAMPLES_PER_FRAME_MP3 = 1152;
    private static final int SUPPORTED_ACODECS[] = {
        2, 1, 8
    };
    private static final int SUPPORTED_BITRATES[] = {
        28000, 40000, 64000, 0x17700, 0x1f400, 0x2ee00, 0x3e800, 0x5dc00, 0x7d000, 0xc3500, 
        0xf4240, 0x124f80, 0x16e360, 0x1e8480, 0x4c4b40, 0x7a1200
    };
    private static final int SUPPORTED_VCODECS[] = {
        1, 2, 4, 5, 6
    };
    private static final int SUPPORTED_VCODEC_PROFILE_LEVELS[] = {
        0, 1, 2, 3, 4, 50, 51, 52, 53, 54, 
        55, 56, 150, 151, 152, 153, 154, 155, 156, 157, 
        158, 159, 160, 161, 162, 163, 164, 165, 180, 181, 
        182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 
        192, 193, 194, 195, 210, 211, 212, 213, 214, 215, 
        216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 
        255
    };
    private static final int SUPPORTED_VIDEO_FILE_FORMATS[] = {
        0, 1, 10
    };
    public static final int UNSUPPORTED_PROFILE_LEVEL = 255;
    public static final int VCODEC_H263 = 1;
    public static final int VCODEC_H264BP = 4;
    public static final int VCODEC_H264HP = 6;
    public static final int VCODEC_H264MP = 5;
    public static final int VCODEC_MPEG4 = 2;
    public static final int VCODEC_NOVIDEO = 0;

    private MediaProperties()
    {
    }

    public static int[] getAllSupportedAspectRatios()
    {
        return ASPECT_RATIOS;
    }

    public static int[] getSupportedAudioCodecs()
    {
        return SUPPORTED_ACODECS;
    }

    public static int getSupportedAudioTrackCount()
    {
        return 1;
    }

    public static int getSupportedMaxVolume()
    {
        return 100;
    }

    public static Pair[] getSupportedResolutions(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown aspect ratio: ").append(i).toString());

        case 1: // '\001'
            return ASPECT_RATIO_3_2_RESOLUTIONS;

        case 3: // '\003'
            return ASPECT_RATIO_4_3_RESOLUTIONS;

        case 4: // '\004'
            return ASPECT_RATIO_5_3_RESOLUTIONS;

        case 5: // '\005'
            return ASPECT_RATIO_11_9_RESOLUTIONS;

        case 2: // '\002'
            return ASPECT_RATIO_16_9_RESOLUTIONS;

        case 6: // '\006'
            return ASPECT_RATIO_1_1_RESOLUTIONS;
        }
    }

    public static int[] getSupportedVideoBitrates()
    {
        return SUPPORTED_BITRATES;
    }

    public static int[] getSupportedVideoCodecs()
    {
        return SUPPORTED_VCODECS;
    }

    public static int[] getSupportedVideoFileFormat()
    {
        return SUPPORTED_VIDEO_FILE_FORMATS;
    }

}
