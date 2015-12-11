// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import java.util.ArrayList;

public class LVMediaCoderProperties
{

    public static final int AUDIO_CHANNEL_COUNT_1 = 1;
    static final int AUDIO_CHANNEL_COUNT_2 = 2;
    public static final int AUDIO_SAMPLE_RATE_11025 = 11025;
    public static final int AUDIO_SAMPLE_RATE_12000 = 12000;
    public static final int AUDIO_SAMPLE_RATE_16000 = 16000;
    public static final int AUDIO_SAMPLE_RATE_22050 = 22050;
    public static final int AUDIO_SAMPLE_RATE_24000 = 24000;
    public static final int AUDIO_SAMPLE_RATE_32000 = 32000;
    public static final int AUDIO_SAMPLE_RATE_4096 = 4096;
    public static final int AUDIO_SAMPLE_RATE_44100 = 44100;
    public static final int AUDIO_SAMPLE_RATE_48000 = 48000;
    public static final int AUDIO_SAMPLE_RATE_64000 = 64000;
    public static final int AUDIO_SAMPLE_RATE_7350 = 7350;
    public static final int AUDIO_SAMPLE_RATE_8000 = 8000;
    public static final int AUDIO_SAMPLE_RATE_88200 = 0x15888;
    public static final int AUDIO_SAMPLE_RATE_96000 = 0x17700;
    public static final int BITRATE_1M = 0xfa000;
    public static final int BITRATE_2M = 0x1f4000;
    public static final int BITRATE_3M = 0x2ee000;
    public static final int BITRATE_512K = 0x7d000;
    public static final int BITRATE_5M = 0x4e2000;
    public static final int BITRATE_8M = 0x7d0000;
    public static final int BITRATE_AUDIO_128K = 0x1f400;
    public static final int BITRATE_AUDIO_64K = 64000;
    static boolean DEBUG = false;
    static boolean DUMPS = false;
    public static final int ENCODE_AUDIO = 1;
    public static final int ENCODE_VIDEO = 0;
    protected static final int ERROR_BLACK_FRAME = -1;
    public static final int FRAMERATE_15 = 15;
    public static final int FRAMERATE_24 = 24;
    public static final int FRAMERATE_25 = 25;
    public static final int FRAMERATE_30 = 30;
    public static final int INPUT_TYPE_RGB = 0;
    public static final int INPUT_TYPE_RGBA = 1;
    static final boolean RS_FILTERS_ENABLED = false;
    private static final ArrayList SUPPORTED_AUDIO_BITRATES = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(64000));
                add(Integer.valueOf(0x1f400));
            }
    };
    private static final ArrayList SUPPORTED_AUDIO_CHANNELCOUNTS = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(1));
            }
    };
    private static final ArrayList SUPPORTED_AUDIO_SAMPLERATES = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(48000));
                add(Integer.valueOf(44100));
                add(Integer.valueOf(32000));
                add(Integer.valueOf(22050));
                add(Integer.valueOf(16000));
                add(Integer.valueOf(11025));
                add(Integer.valueOf(8000));
            }
    };
    private static final ArrayList SUPPORTED_FRAMERATES = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(15));
                add(Integer.valueOf(24));
                add(Integer.valueOf(25));
                add(Integer.valueOf(30));
            }
    };
    private static final ArrayList SUPPORTED_HEIGHT_WIDTH = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(240));
                add(Integer.valueOf(320));
                add(Integer.valueOf(480));
                add(Integer.valueOf(640));
                add(Integer.valueOf(720));
            }
    };
    private static final ArrayList SUPPORTED_VIDEO_BITRATES = new ArrayList() {

        private static final long serialVersionUID = 1L;

            
            {
                add(Integer.valueOf(0x7d000));
                add(Integer.valueOf(0xfa000));
                add(Integer.valueOf(0x1f4000));
                add(Integer.valueOf(0x2ee000));
                add(Integer.valueOf(0x4e2000));
                add(Integer.valueOf(0x7d0000));
            }
    };
    public static final int VIDEO_HEIGHT_240 = 240;
    public static final int VIDEO_HEIGHT_320 = 320;
    public static final int VIDEO_HEIGHT_480 = 480;
    public static final int VIDEO_HEIGHT_640 = 640;
    public static final int VIDEO_HEIGHT_720 = 720;
    public static final int VIDEO_WIDTH_240 = 240;
    public static final int VIDEO_WIDTH_320 = 320;
    public static final int VIDEO_WIDTH_480 = 480;
    public static final int VIDEO_WIDTH_640 = 640;
    public static final int VIDEO_WIDTH_720 = 720;

    public LVMediaCoderProperties()
    {
    }

    public static ArrayList getSupportedAudioBitrates()
    {
        return SUPPORTED_AUDIO_BITRATES;
    }

    public static ArrayList getSupportedChannelCounts()
    {
        return SUPPORTED_AUDIO_CHANNELCOUNTS;
    }

    public static ArrayList getSupportedFrameRates()
    {
        return SUPPORTED_FRAMERATES;
    }

    public static ArrayList getSupportedHeightAndWidth()
    {
        return SUPPORTED_HEIGHT_WIDTH;
    }

    public static ArrayList getSupportedSampleRates()
    {
        return SUPPORTED_AUDIO_SAMPLERATES;
    }

    public static ArrayList getSupportedVideoBitrates()
    {
        return SUPPORTED_VIDEO_BITRATES;
    }

}
