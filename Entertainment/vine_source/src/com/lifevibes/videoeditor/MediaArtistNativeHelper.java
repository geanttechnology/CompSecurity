// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.lifevibes.videoeditor:
//            VideoEditor, MediaProperties, MediaVideoItem, MediaItem

class MediaArtistNativeHelper
{
    public static class AlphaMagicSettings
    {

        public int blendingPercent;
        public String file;
        public boolean invertRotation;
        public int rgbHeight;
        public int rgbWidth;

        public AlphaMagicSettings()
        {
        }
    }

    public static class AudioEffect
    {

        public static final int FADE_IN = 8;
        public static final int FADE_OUT = 16;
        public static final int NONE = 0;

        public AudioEffect()
        {
        }
    }

    public final class AudioFormat
    {

        public static final int AAC = 2;
        public static final int AAC_PLUS = 3;
        public static final int AMR_NB = 1;
        public static final int ENHANCED_AAC_PLUS = 4;
        public static final int EVRC = 6;
        public static final int MP3 = 5;
        public static final int NO_AUDIO = 0;
        public static final int NULL_AUDIO = 254;
        public static final int PCM = 7;
        public static final int UNSUPPORTED_AUDIO = 255;
        final MediaArtistNativeHelper this$0;

        public AudioFormat()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public final class AudioSamplingFrequency
    {

        public static final int FREQ_11025 = 11025;
        public static final int FREQ_12000 = 12000;
        public static final int FREQ_16000 = 16000;
        public static final int FREQ_22050 = 22050;
        public static final int FREQ_24000 = 24000;
        public static final int FREQ_32000 = 32000;
        public static final int FREQ_44100 = 44100;
        public static final int FREQ_48000 = 48000;
        public static final int FREQ_8000 = 8000;
        public static final int FREQ_DEFAULT = 0;
        final MediaArtistNativeHelper this$0;

        public AudioSamplingFrequency()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static class AudioSettings
    {

        int ExtendedFs;
        int Fs;
        String Id;
        boolean bInDucking_enable;
        boolean bRemoveOriginal;
        long beginCutTime;
        int channels;
        int ducking_lowVolume;
        int ducking_threshold;
        long endCutTime;
        int fileType;
        boolean loop;
        String pFile;
        String pcmFilePath;
        long startMs;
        int volume;

        public AudioSettings()
        {
        }
    }

    public static final class AudioTransition
    {

        public static final int CROSS_FADE = 1;
        public static final int NONE = 0;

        public AudioTransition()
        {
        }
    }

    public static class BackgroundMusicSettings
    {

        public long beginLoop;
        public int duckingThreshold;
        public boolean enableDucking;
        public long endLoop;
        public String file;
        public int fileType;
        public long insertionTime;
        public boolean isLooping;
        public int lowVolume;
        public int volumePercent;

        public BackgroundMusicSettings()
        {
        }
    }

    public final class Bitrate
    {

        public static final int BR_128_KBPS = 0x1f400;
        public static final int BR_12_2_KBPS = 12200;
        public static final int BR_16_KBPS = 16000;
        public static final int BR_192_KBPS = 0x2ee00;
        public static final int BR_1_2_MBPS = 0x124f80;
        public static final int BR_1_5_MBPS = 0x16e360;
        public static final int BR_1_MBPS = 0xf4240;
        public static final int BR_24_KBPS = 24000;
        public static final int BR_256_KBPS = 0x3e800;
        public static final int BR_288_KBPS = 0x46500;
        public static final int BR_2_MBPS = 0x1e8480;
        public static final int BR_32_KBPS = 32000;
        public static final int BR_384_KBPS = 0x5dc00;
        public static final int BR_48_KBPS = 48000;
        public static final int BR_512_KBPS = 0x7d000;
        public static final int BR_5_MBPS = 0x4c4b40;
        public static final int BR_64_KBPS = 64000;
        public static final int BR_800_KBPS = 0xc3500;
        public static final int BR_8_MBPS = 0x7a1200;
        public static final int BR_96_KBPS = 0x17700;
        public static final int BR_9_2_KBPS = 9200;
        public static final int UNDEFINED = 0;
        public static final int VARIABLE = -1;
        final MediaArtistNativeHelper this$0;

        public Bitrate()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static class ClipSettings
    {

        public int arrayBeginCutTime[];
        public int arrayEndCutTime[];
        public int beginCutPercent;
        public int beginCutTime;
        public String clipDecodedPath;
        public String clipOriginalPath;
        public String clipPath;
        public int clipVolumePercentage;
        public int endCutPercent;
        public int endCutTime;
        public int fileType;
        public int mNumCuts;
        public int mediaRendering;
        public boolean panZoomEnabled;
        public int panZoomPercentEnd;
        public int panZoomPercentStart;
        public int panZoomTopLeftXEnd;
        public int panZoomTopLeftXStart;
        public int panZoomTopLeftYEnd;
        public int panZoomTopLeftYStart;
        public int rgbHeight;
        public int rgbWidth;

        public ClipSettings()
        {
        }
    }

    public static class CodecConfig
    {

        public static final int NXPSWVDEC = 1;
        public static final int SFHWVDEC = 2;
        public static final int UNDEFINED = 0;

        public CodecConfig()
        {
        }
    }

    public static class EditSettings
    {

        public int audioBitrate;
        public int audioChannels;
        public int audioFormat;
        public int audioSamplingFreq;
        public BackgroundMusicSettings backgroundMusicSettings;
        public ClipSettings clipSettingsArray[];
        public EffectSettings effectSettingsArray[];
        public int maxFileSize;
        public String outputFile;
        public int primaryTrackVolume;
        public TransitionSettings transitionSettingsArray[];
        public int videoBitrate;
        public int videoFormat;
        public int videoFrameRate;
        public int videoFrameSize;
        public int videoRenderingType;

        public EditSettings()
        {
        }
    }

    public static class EffectSettings
    {

        public int alphaBlendingEndPercent;
        public int alphaBlendingFadeInTimePercent;
        public int alphaBlendingFadeOutTimePercent;
        public int alphaBlendingMiddlePercent;
        public int alphaBlendingStartPercent;
        public int audioEffectType;
        public int bitmapType;
        public int duration;
        public int durationPercent;
        public int fiftiesFrameRate;
        public int framingBuffer[];
        public String framingFile;
        public boolean framingResize;
        public int framingScaledSize;
        public int height;
        public int rgb16InputColor;
        public int startPercent;
        public int startTime;
        public String text;
        public int textBufferHeight;
        public int textBufferWidth;
        public String textRenderingData;
        public int topLeftX;
        public int topLeftY;
        public int videoEffectType;
        public int width;

        public EffectSettings()
        {
        }
    }

    public final class FileType
    {

        public static final int AMR = 2;
        public static final int GIF = 7;
        public static final int JPG = 5;
        public static final int M4V = 10;
        public static final int MP3 = 3;
        public static final int MP4 = 1;
        public static final int PCM = 4;
        public static final int PNG = 8;
        public static final int THREE_GPP = 0;
        public static final int UNSUPPORTED = 255;
        final MediaArtistNativeHelper this$0;

        public FileType()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public final class MediaRendering
    {

        public static final int BLACK_BORDERS = 2;
        public static final int CROPPING = 1;
        public static final int RESIZING = 0;
        final MediaArtistNativeHelper this$0;

        public MediaRendering()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static interface OnProgressUpdateListener
    {

        public abstract void OnProgressUpdate(int i, int j);
    }

    public static class PreviewClipProperties
    {

        public Properties clipProperties[];

        public PreviewClipProperties()
        {
        }
    }

    public static class PreviewClips
    {

        public long beginPlayTime;
        public String clipPath;
        public long endPlayTime;
        public int fileType;
        public int mediaRendering;

        public PreviewClips()
        {
        }
    }

    public static class PreviewSettings
    {

        public EffectSettings effectSettingsArray[];
        public PreviewClips previewClipsArray[];

        public PreviewSettings()
        {
        }
    }

    public static class Properties
    {

        public String Id;
        public int audioBitrate;
        public int audioChannels;
        public int audioDuration;
        public int audioFormat;
        public int audioSamplingFrequency;
        public int audioVolumeValue;
        public float averageFrameRate;
        public boolean bIsVideo3D;
        public int duration;
        public int fileType;
        public int height;
        public int profileAndLevel;
        public int videoBitrate;
        public int videoDuration;
        public int videoFormat;
        public int width;

        public Properties()
        {
        }
    }

    public final class Result
    {

        public static final int ERR_ADDCTS_HIGHER_THAN_VIDEO_DURATION = 40;
        public static final int ERR_ADDVOLUME_EQUALS_ZERO = 39;
        public static final int ERR_ALLOC = 62;
        public static final int ERR_AMR_EDITING_UNSUPPORTED = 19;
        public static final int ERR_ANALYSIS_DATA_SIZE_TOO_SMALL = 15;
        public static final int ERR_AUDIOBITRATE_TOO_HIGH = 121;
        public static final int ERR_AUDIOBITRATE_TOO_LOW = 119;
        public static final int ERR_AUDIO_CANNOT_BE_MIXED = 47;
        public static final int ERR_AUDIO_CONVERSION_FAILED = 114;
        public static final int ERR_AUDIO_MIXING_MP3_UNSUPPORTED = 44;
        public static final int ERR_AUDIO_MIXING_UNSUPPORTED = 43;
        public static final int ERR_BAD_CONTEXT = 63;
        public static final int ERR_BAD_OPTION_ID = 66;
        public static final int ERR_BAD_STREAM_ID = 65;
        public static final int ERR_BEGIN_CUT_EQUALS_END_CUT = 115;
        public static final int ERR_BEGIN_CUT_LARGER_THAN_DURATION = 12;
        public static final int ERR_BEGIN_CUT_LARGER_THAN_END_CUT = 13;
        public static final int ERR_BUFFER_OUT_TOO_SMALL = 2;
        public static final int ERR_CLOCK_BAD_REF_YEAR = 56;
        public static final int ERR_CONTEXT_FAILED = 64;
        public static final int ERR_DECODER_H263_NOT_BASELINE = 135;
        public static final int ERR_DECODER_H263_PROFILE_NOT_SUPPORTED = 134;
        public static final int ERR_DIR_NO_MORE_ENTRY = 59;
        public static final int ERR_DIR_OPEN_FAILED = 57;
        public static final int ERR_DIR_READ_FAILED = 58;
        public static final int ERR_DURATION_IS_NULL = 111;
        public static final int ERR_EDITING_NO_SUPPORTED_STREAM_IN_FILE = 29;
        public static final int ERR_EDITING_NO_SUPPORTED_VIDEO_STREAM_IN_FILE = 30;
        public static final int ERR_EDITING_UNSUPPORTED_AUDIO_FORMAT = 28;
        public static final int ERR_EDITING_UNSUPPORTED_H263_PROFILE = 25;
        public static final int ERR_EDITING_UNSUPPORTED_MPEG4_PROFILE = 26;
        public static final int ERR_EDITING_UNSUPPORTED_MPEG4_RVLC = 27;
        public static final int ERR_EDITING_UNSUPPORTED_VIDEO_FORMAT = 24;
        public static final int ERR_ENCODER_ACCES_UNIT_ERROR = 23;
        public static final int ERR_END_CUT_SMALLER_THAN_BEGIN_CUT = 116;
        public static final int ERR_EXTERNAL_EFFECT_NULL = 10;
        public static final int ERR_EXTERNAL_TRANSITION_NULL = 11;
        public static final int ERR_FEATURE_UNSUPPORTED_WITH_AAC = 46;
        public static final int ERR_FEATURE_UNSUPPORTED_WITH_AUDIO_TRACK = 45;
        public static final int ERR_FEATURE_UNSUPPORTED_WITH_EVRC = 49;
        public static final int ERR_FILE_BAD_MODE_ACCESS = 80;
        public static final int ERR_FILE_INVALID_POSITION = 81;
        public static final int ERR_FILE_LOCKED = 79;
        public static final int ERR_FILE_NOT_FOUND = 1;
        public static final int ERR_H263_FORBIDDEN_IN_MP4_FILE = 112;
        public static final int ERR_H263_PROFILE_NOT_SUPPORTED = 51;
        public static final int ERR_INCOMPATIBLE_VIDEO_DATA_PARTITIONING = 36;
        public static final int ERR_INCOMPATIBLE_VIDEO_FORMAT = 33;
        public static final int ERR_INCOMPATIBLE_VIDEO_FRAME_SIZE = 34;
        public static final int ERR_INCOMPATIBLE_VIDEO_TIME_SCALE = 35;
        public static final int ERR_INPUT_AUDIO_AU_TOO_LARGE = 21;
        public static final int ERR_INPUT_AUDIO_CORRUPTED_AU = 22;
        public static final int ERR_INPUT_FILE_CONTAINS_NO_SUPPORTED_STREAM = 103;
        public static final int ERR_INPUT_VIDEO_AU_TOO_LARGE = 20;
        public static final int ERR_INTERNAL = 255;
        public static final int ERR_INVALID_3GPP_FILE = 16;
        public static final int ERR_INVALID_AAC_SAMPLING_FREQUENCY = 113;
        public static final int ERR_INVALID_AUDIO_EFFECT_TYPE = 6;
        public static final int ERR_INVALID_AUDIO_TRANSITION_TYPE = 8;
        public static final int ERR_INVALID_CLIP_ANALYSIS_PLATFORM = 32;
        public static final int ERR_INVALID_CLIP_ANALYSIS_VERSION = 31;
        public static final int ERR_INVALID_EFFECT_KIND = 4;
        public static final int ERR_INVALID_FILE_TYPE = 3;
        public static final int ERR_INVALID_INPUT_FILE = 104;
        public static final int ERR_INVALID_VIDEO_EFFECT_TYPE = 5;
        public static final int ERR_INVALID_VIDEO_ENCODING_FRAME_RATE = 9;
        public static final int ERR_INVALID_VIDEO_FRAME_RATE_FOR_H263 = 110;
        public static final int ERR_INVALID_VIDEO_FRAME_SIZE_FOR_H263 = 109;
        public static final int ERR_INVALID_VIDEO_TRANSITION_TYPE = 7;
        public static final int ERR_MAXFILESIZE_TOO_SMALL = 117;
        public static final int ERR_NOMORE_SPACE_FOR_FILE = 136;
        public static final int ERR_NOT_IMPLEMENTED = 69;
        public static final int ERR_NO_SUPPORTED_STREAM_IN_FILE = 38;
        public static final int ERR_NO_SUPPORTED_VIDEO_STREAM_IN_FILE = 52;
        public static final int ERR_ONLY_AMRNB_INPUT_CAN_BE_MIXED = 48;
        public static final int ERR_OUTPUT_FILE_SIZE_TOO_SMALL = 122;
        public static final int ERR_OVERLAPPING_TRANSITIONS = 14;
        public static final int ERR_PARAMETER = 60;
        public static final int ERR_READER_UNKNOWN_STREAM_TYPE = 123;
        public static final int ERR_READ_ONLY = 68;
        public static final int ERR_STATE = 61;
        public static final int ERR_STR_BAD_ARGS = 97;
        public static final int ERR_STR_BAD_STRING = 94;
        public static final int ERR_STR_CONV_FAILED = 95;
        public static final int ERR_STR_OVERFLOW = 96;
        public static final int ERR_THREAD_NOT_STARTED = 100;
        public static final int ERR_UNDEFINED_AUDIO_TRACK_FILE_FORMAT = 41;
        public static final int ERR_UNDEFINED_OUTPUT_AUDIO_FORMAT = 108;
        public static final int ERR_UNDEFINED_OUTPUT_VIDEO_FORMAT = 105;
        public static final int ERR_UNDEFINED_OUTPUT_VIDEO_FRAME_RATE = 107;
        public static final int ERR_UNDEFINED_OUTPUT_VIDEO_FRAME_SIZE = 106;
        public static final int ERR_UNSUPPORTED_ADDED_AUDIO_STREAM = 42;
        public static final int ERR_UNSUPPORTED_INPUT_AUDIO_FORMAT = 18;
        public static final int ERR_UNSUPPORTED_INPUT_VIDEO_FORMAT = 17;
        public static final int ERR_UNSUPPORTED_MEDIA_TYPE = 70;
        public static final int ERR_UNSUPPORTED_MP3_ASSEMBLY = 37;
        public static final int ERR_VIDEOBITRATE_TOO_HIGH = 120;
        public static final int ERR_VIDEOBITRATE_TOO_LOW = 118;
        public static final int ERR_WRITE_ONLY = 67;
        public static final int NO_ERROR = 0;
        public static final int WAR_BUFFER_FULL = 76;
        public static final int WAR_DEBLOCKING_FILTER_NOT_IMPLEMENTED = 133;
        public static final int WAR_INVALID_TIME = 73;
        public static final int WAR_MAX_OUTPUT_SIZE_EXCEEDED = 54;
        public static final int WAR_MEDIATYPE_NOT_SUPPORTED = 102;
        public static final int WAR_NO_DATA_YET = 71;
        public static final int WAR_NO_MORE_AU = 74;
        public static final int WAR_NO_MORE_STREAM = 72;
        public static final int WAR_READER_INFORMATION_NOT_PRESENT = 125;
        public static final int WAR_READER_NO_METADATA = 124;
        public static final int WAR_REDIRECT = 77;
        public static final int WAR_STR_NOT_FOUND = 99;
        public static final int WAR_STR_OVERFLOW = 98;
        public static final int WAR_TIMESCALE_TOO_BIG = 55;
        public static final int WAR_TIME_OUT = 75;
        public static final int WAR_TOO_MUCH_STREAMS = 78;
        public static final int WAR_TRANSCODING_DONE = 101;
        public static final int WAR_TRANSCODING_NECESSARY = 53;
        public static final int WAR_VIDEORENDERER_NO_NEW_FRAME = 132;
        public static final int WAR_WRITER_STOP_REQ = 131;
        final MediaArtistNativeHelper this$0;

        public Result()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static final class SlideDirection
    {

        public static final int BOTTOM_OUT_TOP_IN = 3;
        public static final int LEFT_OUT_RIGTH_IN = 1;
        public static final int RIGHT_OUT_LEFT_IN = 0;
        public static final int TOP_OUT_BOTTOM_IN = 2;

        public SlideDirection()
        {
        }
    }

    public static class SlideTransitionSettings
    {

        public int direction;

        public SlideTransitionSettings()
        {
        }
    }

    public static final class TransitionBehaviour
    {

        public static final int FAST_MIDDLE = 4;
        public static final int LINEAR = 1;
        public static final int SLOW_MIDDLE = 3;
        public static final int SPEED_DOWN = 2;
        public static final int SPEED_UP = 0;

        public TransitionBehaviour()
        {
        }
    }

    public static class TransitionSettings
    {

        public AlphaMagicSettings alphaSettings;
        public int audioTransitionType;
        public int duration;
        public SlideTransitionSettings slideSettings;
        public int transitionBehaviour;
        public int videoTransitionType;

        public TransitionSettings()
        {
        }
    }

    public final class Version
    {

        public int major;
        public int minor;
        public int revision;
        final MediaArtistNativeHelper this$0;

        public Version()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static class VideoEffect
    {

        public static final int BLACK_AND_WHITE = 257;
        public static final int COLORRGB16 = 267;
        public static final int CURTAIN_CLOSING = 17;
        public static final int CURTAIN_OPENING = 9;
        public static final int EXTERNAL = 256;
        public static final int FADE_FROM_BLACK = 8;
        public static final int FADE_TO_BLACK = 16;
        public static final int FIFTIES = 266;
        public static final int FRAMING = 262;
        public static final int GRADIENT = 268;
        public static final int GREEN = 259;
        public static final int NEGATIVE = 261;
        public static final int NONE = 0;
        public static final int PINK = 258;
        public static final int SEPIA = 260;
        public static final int TEXT = 263;
        public static final int ZOOM_IN = 264;
        public static final int ZOOM_OUT = 265;

        public VideoEffect()
        {
        }
    }

    public final class VideoFormat
    {

        public static final int H263 = 1;
        public static final int H264 = 4;
        public static final int H264_HP = 6;
        public static final int H264_MP = 5;
        public static final int MPEG4 = 2;
        public static final int MPEG4_EMP = 3;
        public static final int NO_VIDEO = 0;
        public static final int NULL_VIDEO = 254;
        public static final int UNSUPPORTED = 255;
        final MediaArtistNativeHelper this$0;

        public VideoFormat()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public final class VideoFrameRate
    {

        public static final int FR_10_FPS = 2;
        public static final int FR_12_5_FPS = 3;
        public static final int FR_15_FPS = 4;
        public static final int FR_20_FPS = 5;
        public static final int FR_25_FPS = 6;
        public static final int FR_30_FPS = 7;
        public static final int FR_5_FPS = 0;
        public static final int FR_7_5_FPS = 1;
        final MediaArtistNativeHelper this$0;

        public VideoFrameRate()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public final class VideoFrameSize
    {

        public static final int CIF = 4;
        public static final int NTSC = 8;
        public static final int QCIF = 2;
        public static final int QQVGA = 1;
        public static final int QVGA = 3;
        public static final int S1080p = 14;
        public static final int S720p = 13;
        public static final int SIZE_UNDEFINED = -1;
        public static final int SQCIF = 0;
        public static final int TWITTER480x480 = 5;
        public static final int V720p = 11;
        public static final int VGA = 6;
        public static final int W720p = 12;
        public static final int WVGA = 7;
        public static final int WVGA16x9 = 10;
        public static final int nHD = 9;
        final MediaArtistNativeHelper this$0;

        public VideoFrameSize()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public final class VideoProfile
    {

        public static final int H263_PROFILE_0_LEVEL_10 = 0;
        public static final int H263_PROFILE_0_LEVEL_20 = 1;
        public static final int H263_PROFILE_0_LEVEL_30 = 2;
        public static final int H263_PROFILE_0_LEVEL_40 = 3;
        public static final int H263_PROFILE_0_LEVEL_45 = 4;
        public static final int H264_PROFILE_0_LEVEL_1 = 150;
        public static final int H264_PROFILE_0_LEVEL_1_1 = 152;
        public static final int H264_PROFILE_0_LEVEL_1_2 = 153;
        public static final int H264_PROFILE_0_LEVEL_1_3 = 154;
        public static final int H264_PROFILE_0_LEVEL_1b = 151;
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
        public static final int H264_PROFILE_H_LEVEL_1_1 = 212;
        public static final int H264_PROFILE_H_LEVEL_1_2 = 213;
        public static final int H264_PROFILE_H_LEVEL_1_3 = 214;
        public static final int H264_PROFILE_H_LEVEL_1b = 211;
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
        public static final int H264_PROFILE_M_LEVEL_1_1 = 182;
        public static final int H264_PROFILE_M_LEVEL_1_2 = 183;
        public static final int H264_PROFILE_M_LEVEL_1_3 = 184;
        public static final int H264_PROFILE_M_LEVEL_1b = 181;
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
        public static final int MPEG4_SP_LEVEL_0 = 50;
        public static final int MPEG4_SP_LEVEL_0B = 51;
        public static final int MPEG4_SP_LEVEL_1 = 52;
        public static final int MPEG4_SP_LEVEL_2 = 53;
        public static final int MPEG4_SP_LEVEL_3 = 54;
        public static final int MPEG4_SP_LEVEL_4A = 55;
        public static final int MPEG4_SP_LEVEL_5 = 56;
        public static final int MPEG4_SP_LEVEL_6 = 57;
        public static final int OUT_OF_RANGE = 255;
        final MediaArtistNativeHelper this$0;

        public VideoProfile()
        {
            this$0 = MediaArtistNativeHelper.this;
            super();
        }
    }

    public static class VideoRendering
    {

        public static final int RENDERAS2D = 1;
        public static final int RENDERAS3D = 2;
        public static final int RENDERASINPUT_TYPE = 0;

        public VideoRendering()
        {
        }
    }

    public static class VideoTransition
    {

        public static final int ALPHA_MAGIC = 257;
        public static final int CROSS_FADE = 1;
        public static final int EXTERNAL = 256;
        public static final int FADE_BLACK = 259;
        public static final int NONE = 0;
        public static final int SLIDE_TRANSITION = 258;

        public VideoTransition()
        {
        }
    }


    private static final String AUDIO_TRACK_PCM_FILE = "AudioPcm.pcm";
    public static final int PROCESSING_AUDIO_PCM = 1;
    public static final int PROCESSING_EXPORT = 20;
    public static final int PROCESSING_INTERMEDIATE1 = 11;
    public static final int PROCESSING_INTERMEDIATE2 = 12;
    public static final int PROCESSING_INTERMEDIATE3 = 13;
    public static final int PROCESSING_KENBURNS = 3;
    public static final int PROCESSING_NONE = 0;
    public static final int PROCESSING_TRANSITION = 2;
    private static final String TAG = "MediaArtistNativeHelper";
    public static final int TASK_ENCODING = 2;
    public static final int TASK_LOADING_SETTINGS = 1;
    public static int mTNDecConfigAccurateMode = 0;
    public static int mTNDecConfigFastMode = 1;
    private static final Paint sResizePaint = new Paint(2);
    private final int MAX_THUMBNAIL_PERMITTED = 8;
    private AudioSettings mAudioSettings;
    private String mAudioTrackPCMFilePath;
    private List mClipList;
    PreviewClipProperties mClipProperties;
    EditSettings mEditSettings;
    private boolean mErrorFlagSet;
    private String mExportFilename;
    private VideoEditor.ExportProgressListener mExportProgressListener;
    public boolean mInvalidatePreviewArray;
    private boolean mIsAbortGeneratePreviewInBGCalled;
    private boolean mIsFirstProgress;
    private final Semaphore mLock;
    private int mManualEditContext;
    private String mOutputFilename;
    private EditSettings mPreviewEditSettings;
    int mPreviewEffectsSize;
    private long mPreviewProgress;
    private Object mProcessingObject;
    private int mProcessingState;
    private int mProgressToApp;
    private final String mProjectPath;
    private boolean mRegenerateAudio;
    private String mRenderPreviewOverlayFile;
    private int mRenderPreviewRenderingMode;
    public EditSettings mStoryBoardSettings;
    private MediaItem.GetThumbnailListCallback mThumbnailListListener;
    int mThumbnailTime[];
    private int mTotalClips;
    int mTotalKenBurnClips;
    int mTotalTransitions;
    private final VideoEditor mVideoEditor;

    public MediaArtistNativeHelper(String s, Semaphore semaphore, VideoEditor videoeditor)
    {
        mClipList = new ArrayList();
        mEditSettings = null;
        mClipProperties = null;
        mAudioSettings = null;
        mInvalidatePreviewArray = true;
        mRegenerateAudio = true;
        mExportFilename = null;
        mPreviewProgress = 0L;
        mAudioTrackPCMFilePath = null;
        mTotalClips = 0;
        mPreviewEffectsSize = 0;
        mTotalTransitions = 0;
        mTotalKenBurnClips = 0;
        mErrorFlagSet = false;
        mManualEditContext = 0;
        mIsAbortGeneratePreviewInBGCalled = false;
        mProjectPath = s;
        if (videoeditor != null)
        {
            mVideoEditor = videoeditor;
            if (mStoryBoardSettings == null)
            {
                mStoryBoardSettings = new EditSettings();
            }
            mLock = semaphore;
            _init(mProjectPath, "null");
            mAudioTrackPCMFilePath = null;
            s = getVersion();
            Log.d("MediaArtistNativeHelper", (new StringBuilder()).append("VideoEditor Version ").append(((Version) (s)).major).append(".").append(((Version) (s)).minor).append(".").append(((Version) (s)).revision).toString());
            mExportProgressListener = null;
            onProgressUpdate(0, 0);
            return;
        } else
        {
            mVideoEditor = null;
            throw new IllegalArgumentException("video editor object is null");
        }
    }

    private native void _init(String s, String s1)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private int findVideoBitrate(int i)
    {
        switch (i)
        {
        default:
            Log.e("MediaArtistNativeHelper", "bitrate for frame size not found");
            return 0;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return 0x7d000;

        case 4: // '\004'
        case 5: // '\005'
            return 0x16e360;

        case 6: // '\006'
        case 9: // '\t'
            return 0x1e8480;

        case 7: // '\007'
        case 8: // '\b'
        case 10: // '\n'
            return 0x4c4b40;

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return 0x7a1200;
        }
    }

    private Pair findVideoFrameDimensions(int i)
    {
        switch (i)
        {
        default:
            return new Pair(Integer.valueOf(0), Integer.valueOf(0));

        case 0: // '\0'
            return new Pair(Integer.valueOf(128), Integer.valueOf(96));

        case 1: // '\001'
            return new Pair(Integer.valueOf(160), Integer.valueOf(120));

        case 2: // '\002'
            return new Pair(Integer.valueOf(176), Integer.valueOf(144));

        case 3: // '\003'
            return new Pair(Integer.valueOf(320), Integer.valueOf(240));

        case 4: // '\004'
            return new Pair(Integer.valueOf(352), Integer.valueOf(288));

        case 6: // '\006'
            return new Pair(Integer.valueOf(640), Integer.valueOf(480));

        case 7: // '\007'
            return new Pair(Integer.valueOf(800), Integer.valueOf(480));

        case 8: // '\b'
            return new Pair(Integer.valueOf(720), Integer.valueOf(480));

        case 9: // '\t'
            return new Pair(Integer.valueOf(640), Integer.valueOf(360));

        case 10: // '\n'
            return new Pair(Integer.valueOf(854), Integer.valueOf(480));

        case 11: // '\013'
            return new Pair(Integer.valueOf(1280), Integer.valueOf(720));

        case 12: // '\f'
            return new Pair(Integer.valueOf(1080), Integer.valueOf(720));

        case 13: // '\r'
            return new Pair(Integer.valueOf(960), Integer.valueOf(720));

        case 14: // '\016'
            return new Pair(Integer.valueOf(1920), Integer.valueOf(1080));

        case 5: // '\005'
            return new Pair(Integer.valueOf(480), Integer.valueOf(480));
        }
    }

    private int findVideoResolution(int i, int j)
    {
        byte byte0 = -1;
        i;
        JVM INSTR tableswitch 1 6: default 44
    //                   1 100
    //                   2 129
    //                   3 184
    //                   4 247
    //                   5 263
    //                   6 290;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        i = byte0;
_L9:
        j = i;
        if (i == -1)
        {
            Pair apair[] = MediaProperties.getSupportedResolutions(mVideoEditor.getAspectRatio());
            Pair pair = apair[apair.length - 1];
            j = findVideoResolution(mVideoEditor.getAspectRatio(), ((Integer)pair.second).intValue());
        }
        return j;
_L2:
        if (j == 480)
        {
            i = 8;
        } else
        {
            i = byte0;
            if (j == 720)
            {
                i = 12;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == 480)
        {
            i = 10;
        } else
        if (j == 720)
        {
            i = 11;
        } else
        if (j == 1080)
        {
            i = 14;
        } else
        {
            i = byte0;
            if (j == 360)
            {
                i = 9;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j == 96)
        {
            i = 0;
        } else
        if (j == 120)
        {
            i = 1;
        } else
        if (j == 240)
        {
            i = 3;
        } else
        if (j == 480)
        {
            i = 6;
        } else
        {
            i = byte0;
            if (j == 720)
            {
                i = 13;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = byte0;
        if (j == 480)
        {
            i = 7;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == 144)
        {
            i = 2;
        } else
        {
            i = byte0;
            if (j == 288)
            {
                i = 4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        i = byte0;
        if (j == 480)
        {
            i = 5;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void getMediaItemProperties(List list)
    {
        ClipSettings clipsettings;
        MediaVideoItem mediavideoitem;
        mTotalClips = 0;
        mPreviewEditSettings = new EditSettings();
        mClipProperties = new PreviewClipProperties();
        ClipSettings aclipsettings[] = new ClipSettings[2];
        clipsettings = new ClipSettings();
        if (!(list.get(0) instanceof MediaVideoItem))
        {
            throw new IllegalStateException("Not a media video item");
        }
        mediavideoitem = (MediaVideoItem)list.get(0);
        mTotalClips = list.size();
        mPreviewEditSettings.clipSettingsArray = new ClipSettings[mTotalClips];
        mPreviewEditSettings.effectSettingsArray = new EffectSettings[0];
        mPreviewEditSettings.transitionSettingsArray = new TransitionSettings[mTotalClips - 1];
        mPreviewEditSettings.backgroundMusicSettings = null;
        mPreviewEditSettings.primaryTrackVolume = 100;
        mClipProperties.clipProperties = new Properties[mTotalClips];
        initClipSettings(clipsettings);
        clipsettings.clipPath = mediavideoitem.getFilename();
        clipsettings.fileType = getMediaItemFileType(mediavideoitem.getFileType());
        try
        {
            mClipProperties.clipProperties[0] = getMediaProperties(mediavideoitem.getFilename());
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new IllegalArgumentException("Unsupported file or file not found");
        }
        clipsettings.arrayBeginCutTime = new int[2];
        clipsettings.arrayEndCutTime = new int[2];
        if (!mediavideoitem.isExcludeCalled()) goto _L2; else goto _L1
_L1:
        mClipProperties.clipProperties[0].duration = (int)mediavideoitem.getDuration() - ((int)mediavideoitem.getExcludeEndTime() - (int)mediavideoitem.getExcludeBeginTime());
        clipsettings.arrayBeginCutTime[0] = 0;
        clipsettings.arrayEndCutTime[0] = (int)mediavideoitem.getExcludeBeginTime() - 1;
        clipsettings.arrayBeginCutTime[1] = (int)mediavideoitem.getExcludeEndTime() + 1;
        clipsettings.arrayEndCutTime[1] = (int)mediavideoitem.getDuration();
        clipsettings.mNumCuts = 2;
        if (mClipProperties.clipProperties[0].videoDuration != 0)
        {
            mClipProperties.clipProperties[0].videoDuration = mClipProperties.clipProperties[0].duration;
        }
        if (mClipProperties.clipProperties[0].audioDuration != 0)
        {
            mClipProperties.clipProperties[0].audioDuration = mClipProperties.clipProperties[0].duration;
        }
_L4:
        clipsettings.mediaRendering = getMediaItemRenderingMode(mediavideoitem.getRenderingMode());
        clipsettings.clipVolumePercentage = 100;
        mPreviewEditSettings.clipSettingsArray[0] = clipsettings;
        mPreviewEditSettings.videoFrameSize = findVideoResolution(mVideoEditor.getAspectRatio(), mediavideoitem.getHeight());
        return;
_L2:
        clipsettings.arrayBeginCutTime[0] = (int)mediavideoitem.getBoundaryBeginTime();
        clipsettings.arrayBeginCutTime[1] = 0;
        clipsettings.arrayEndCutTime[0] = (int)mediavideoitem.getBoundaryEndTime();
        clipsettings.arrayEndCutTime[1] = 0;
        clipsettings.mNumCuts = 1;
        mClipProperties.clipProperties[0].duration = clipsettings.arrayEndCutTime[0] - clipsettings.arrayBeginCutTime[0];
        if (mClipProperties.clipProperties[0].videoDuration != 0)
        {
            mClipProperties.clipProperties[0].videoDuration = mClipProperties.clipProperties[0].duration;
        }
        if (mClipProperties.clipProperties[0].audioDuration != 0)
        {
            mClipProperties.clipProperties[0].audioDuration = mClipProperties.clipProperties[0].duration;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private native Version getVersion()
        throws RuntimeException;

    private void lock()
        throws InterruptedException
    {
        if (Log.isLoggable("MediaArtistNativeHelper", 3))
        {
            Log.d("MediaArtistNativeHelper", "lock: grabbing semaphore", new Throwable());
        }
        mLock.acquire();
        if (Log.isLoggable("MediaArtistNativeHelper", 3))
        {
            Log.d("MediaArtistNativeHelper", "lock: grabbed semaphore");
        }
    }

    private native void nativeClearSurface(Surface surface);

    private native int nativeGenerateAudioGraph(String s, String s1, int i, int j, int k);

    private native int nativeGenerateClip(EditSettings editsettings)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private native int nativeGenerateRawAudio(String s, String s1);

    private native int nativeGenerateRawAudioMedia(String s, String s1, long l, long l1);

    private native Bitmap nativeGetPixels(String s, int i, int j, long l, int k);

    private native int nativeGetPixelsList(String s, int i, int j, int k, int l, int i1, int j1, 
            int ai[], int k1, MediaItem.GetThumbnailListCallback getthumbnaillistcallback);

    private native Bitmap[] nativeGetPixelsList(String s, int i, int j, int k, int l, int i1, int j1, 
            int ai[], int k1);

    private native void nativePopulateSettings(EditSettings editsettings, PreviewClipProperties previewclipproperties, AudioSettings audiosettings)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private native int nativeRenderMediaItemPreviewFrame(Surface surface, String s, int i, int j, int k, int l, long l1)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private native int nativeRenderPreviewFrame(Surface surface, long l, int i, int j)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private native void nativeStartPreview(Surface surface, long l, long l1, int i, boolean flag)
        throws IllegalArgumentException, IllegalStateException, RuntimeException;

    private native int nativeStopPreview();

    private void onAudioGraphExtractProgressUpdate(int i, boolean flag)
    {
    }

    private void onProgressUpdate(int i, int j)
    {
        if (mProcessingState != 20 || mExportProgressListener == null || mProgressToApp > 100) goto _L2; else goto _L1
_L1:
        if (mProgressToApp > j) goto _L4; else goto _L3
_L3:
        mProgressToApp = j;
_L7:
        mExportProgressListener.onProgress(mVideoEditor, mOutputFilename, mProgressToApp);
_L2:
        return;
_L4:
        if (j % 2 != 0) goto _L2; else goto _L5
_L5:
        mProgressToApp = mProgressToApp + 1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private native void release()
        throws IllegalStateException, RuntimeException;

    private native void stopEncoding()
        throws IllegalStateException, RuntimeException;

    private native void stopExtraction()
        throws IllegalStateException, RuntimeException;

    private native void stopThumbnail()
        throws IllegalStateException;

    private void unlock()
    {
        if (Log.isLoggable("MediaArtistNativeHelper", 3))
        {
            Log.d("MediaArtistNativeHelper", "unlock: releasing semaphore");
        }
        mLock.release();
    }

    int GetClosestVideoFrameRate(int i)
    {
        byte byte0 = 5;
        if (i > 25)
        {
            byte0 = 7;
        } else
        {
            if (i > 20)
            {
                return 6;
            }
            if (i <= 15)
            {
                if ((double)i > 12.5D)
                {
                    return 4;
                }
                if (i > 10)
                {
                    return 3;
                }
                if ((double)i > 7.5D)
                {
                    return 2;
                }
                return i <= 5 ? 0 : 1;
            }
        }
        return byte0;
    }

    public void export(String s, String s1, int i, int j, int k, int l, long l1, List list, VideoEditor.ExportProgressListener exportprogresslistener)
    {
        mExportFilename = s;
        mProgressToApp = 0;
        if (exportprogresslistener != null)
        {
            mExportProgressListener = exportprogresslistener;
        }
        getMediaItemProperties(list);
        j;
        JVM INSTR lookupswitch 16: default 168
    //                   28000: 179
    //                   40000: 395
    //                   64000: 403
    //                   96000: 411
    //                   128000: 419
    //                   192000: 427
    //                   256000: 435
    //                   384000: 443
    //                   512000: 451
    //                   800000: 459
    //                   1000000: 467
    //                   1200000: 475
    //                   1500000: 483
    //                   2000000: 491
    //                   5000000: 499
    //                   8000000: 507;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_507;
_L1:
        throw new IllegalArgumentException("Argument Bitrate incorrect");
_L2:
        j = 32000;
_L18:
        mPreviewEditSettings.videoFrameRate = 7;
        s1 = mPreviewEditSettings;
        mOutputFilename = s;
        s1.outputFile = s;
        mPreviewEditSettings.videoRenderingType = 0;
        int i1 = mVideoEditor.getAspectRatio();
        mPreviewEditSettings.videoFrameSize = findVideoResolution(i1, i);
        if (mPreviewEditSettings.videoFrameSize == 6)
        {
            if (j == 0xc3500)
            {
                mPreviewEditSettings.videoFrameRate = 5;
            }
            if (j == 0x7d000)
            {
                mPreviewEditSettings.videoFrameRate = 4;
            }
        }
        if (mPreviewEditSettings.videoFrameSize == 4)
        {
            if (j == 0x5dc00)
            {
                if (l != 1)
                {
                    mPreviewEditSettings.videoFrameRate = 6;
                } else
                {
                    mPreviewEditSettings.videoFrameRate = 4;
                }
            }
            if (j == 0x3e800)
            {
                mPreviewEditSettings.videoFrameRate = 4;
            }
        }
        if (mPreviewEditSettings.videoFrameSize == 2)
        {
            if (j == 0x2ee00)
            {
                if (l != 1)
                {
                    mPreviewEditSettings.videoFrameRate = 5;
                } else
                {
                    mPreviewEditSettings.videoFrameRate = 4;
                }
            } else
            if (j == 0x1f400)
            {
                mPreviewEditSettings.videoFrameRate = 4;
            } else
            if (j == 0x17700)
            {
                mPreviewEditSettings.videoFrameRate = 2;
            } else
            if (j == 64000)
            {
                mPreviewEditSettings.videoFrameRate = 2;
            }
        }
        if (findVideoBitrate(mPreviewEditSettings.videoFrameSize) < j)
        {
            throw new IllegalArgumentException("Argument Bitrate NOT Supported for supplied resolution");
        }
        break MISSING_BLOCK_LABEL_594;
_L3:
        j = 48000;
          goto _L18
_L4:
        j = 64000;
          goto _L18
_L5:
        j = 0x17700;
          goto _L18
_L6:
        j = 0x1f400;
          goto _L18
_L7:
        j = 0x2ee00;
          goto _L18
_L8:
        j = 0x3e800;
          goto _L18
_L9:
        j = 0x5dc00;
          goto _L18
_L10:
        j = 0x7d000;
          goto _L18
_L11:
        j = 0xc3500;
          goto _L18
_L12:
        j = 0xf4240;
          goto _L18
_L13:
        j = 0x124f80;
          goto _L18
_L14:
        j = 0x16e360;
          goto _L18
_L15:
        j = 0x1e8480;
          goto _L18
_L16:
        j = 0x4c4b40;
          goto _L18
        j = 0x7a1200;
          goto _L18
        k;
        JVM INSTR tableswitch 1 2: default 620
    //                   1 729
    //                   2 671;
           goto _L19 _L20 _L21
_L19:
        l;
        JVM INSTR tableswitch 1 6: default 660
    //                   1 768
    //                   2 1115
    //                   3 660
    //                   4 1081
    //                   5 1092
    //                   6 1103;
           goto _L22 _L23 _L24 _L22 _L25 _L26 _L27
_L22:
        throw new IllegalArgumentException("Argument Video codec NOT Supported");
_L21:
        s = (MediaVideoItem)list.get(0);
        mPreviewEditSettings.audioFormat = 254;
        mPreviewEditSettings.audioBitrate = s.getAudioBitrate();
        mPreviewEditSettings.audioSamplingFreq = s.getAudioSamplingFrequency();
        mPreviewEditSettings.audioChannels = s.getAudioChannels();
          goto _L19
_L20:
        mPreviewEditSettings.audioFormat = 1;
        mPreviewEditSettings.audioBitrate = 12200;
        mPreviewEditSettings.audioSamplingFreq = 8000;
        mPreviewEditSettings.audioChannels = 1;
          goto _L19
_L23:
        mPreviewEditSettings.videoFormat = 1;
_L28:
        if (l1 != 0L)
        {
            mPreviewEditSettings.maxFileSize = (int)l1;
        } else
        {
            mPreviewEditSettings.maxFileSize = 0;
        }
        if (mTotalClips == 1)
        {
            l1 = ((MediaItem)list.get(0)).getTimelineDuration();
            l1 = (long)((1.04D * (double)(mPreviewEditSettings.audioBitrate + mClipProperties.clipProperties[0].videoBitrate) * (double)l1) / 8000D);
            s = findVideoFrameDimensions(mPreviewEditSettings.videoFrameSize);
            i = 0;
            if (mPreviewEditSettings.maxFileSize != 0 && l1 <= (long)mPreviewEditSettings.maxFileSize || mPreviewEditSettings.maxFileSize == 0)
            {
                i = 1;
            }
            if (mPreviewEditSettings.videoFormat == mClipProperties.clipProperties[0].videoFormat && ((Integer)((Pair) (s)).first).intValue() == mClipProperties.clipProperties[0].width && ((Integer)((Pair) (s)).second).intValue() == mClipProperties.clipProperties[0].height && i == 1)
            {
                mPreviewEditSettings.videoFormat = 254;
            }
        }
        mPreviewEditSettings.videoBitrate = j;
        mPreviewEditSettings.transitionSettingsArray = new TransitionSettings[mTotalClips - 1];
        try
        {
            mProcessingState = 20;
            mProcessingObject = null;
            i = generateClip(mPreviewEditSettings);
            mProcessingState = 0;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "IllegalArgument for generateClip");
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "IllegalStateExceptiont for generateClip");
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
            throw s;
        }
        if (i != 0)
        {
            Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
            throw new RuntimeException((new StringBuilder()).append("generateClip failed with error=").append(i).toString());
        } else
        {
            mExportProgressListener = null;
            return;
        }
_L25:
        mPreviewEditSettings.videoFormat = 4;
          goto _L28
_L26:
        mPreviewEditSettings.videoFormat = 5;
          goto _L28
_L27:
        mPreviewEditSettings.videoFormat = 6;
          goto _L28
_L24:
        mPreviewEditSettings.videoFormat = 2;
          goto _L28
    }

    void export(String s, String s1, int i, int j, List list, VideoEditor.ExportProgressListener exportprogresslistener)
    {
        if (!(list.get(0) instanceof MediaVideoItem))
        {
            throw new IllegalStateException("Not a media video item");
        }
        mExportFilename = s;
        mProgressToApp = 0;
        if (exportprogresslistener != null)
        {
            mExportProgressListener = exportprogresslistener;
        }
        getMediaItemProperties(list);
        j;
        JVM INSTR lookupswitch 16: default 192
    //                   28000: 203
    //                   40000: 292
    //                   64000: 300
    //                   96000: 308
    //                   128000: 316
    //                   192000: 324
    //                   256000: 332
    //                   384000: 340
    //                   512000: 348
    //                   800000: 356
    //                   1000000: 364
    //                   1200000: 372
    //                   1500000: 380
    //                   2000000: 388
    //                   5000000: 396
    //                   8000000: 404;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
        throw new IllegalArgumentException("Argument Bitrate incorrect");
_L2:
        j = 32000;
_L19:
        mPreviewEditSettings.videoFrameRate = 7;
        s1 = mPreviewEditSettings;
        mOutputFilename = s;
        s1.outputFile = s;
        mPreviewEditSettings.videoRenderingType = 0;
        int k = mVideoEditor.getAspectRatio();
        mPreviewEditSettings.videoFrameSize = findVideoResolution(k, i);
        if (findVideoBitrate(mPreviewEditSettings.videoFrameSize) < j)
        {
            throw new IllegalArgumentException("Argument Bitrate NOT Supported for supplied resolution");
        }
        break; /* Loop/switch isn't completed */
_L3:
        j = 48000;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 64000;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 0x17700;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 0x1f400;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 0x2ee00;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 0x3e800;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 0x5dc00;
        continue; /* Loop/switch isn't completed */
_L10:
        j = 0x7d000;
        continue; /* Loop/switch isn't completed */
_L11:
        j = 0xc3500;
        continue; /* Loop/switch isn't completed */
_L12:
        j = 0xf4240;
        continue; /* Loop/switch isn't completed */
_L13:
        j = 0x124f80;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 0x16e360;
        continue; /* Loop/switch isn't completed */
_L15:
        j = 0x1e8480;
        continue; /* Loop/switch isn't completed */
_L16:
        j = 0x4c4b40;
        continue; /* Loop/switch isn't completed */
_L17:
        j = 0x7a1200;
        if (true) goto _L19; else goto _L18
_L18:
        mPreviewEditSettings.videoFormat = 4;
        mPreviewEditSettings.audioFormat = 2;
        mPreviewEditSettings.audioBitrate = 0x17700;
        mPreviewEditSettings.audioSamplingFreq = 32000;
        mPreviewEditSettings.audioChannels = 2;
        mPreviewEditSettings.maxFileSize = 0;
        mPreviewEditSettings.videoBitrate = j;
        s = (MediaVideoItem)list.get(0);
        if (s.getVideoType() == 1 && (s.getVideoType() != 1 || mPreviewEditSettings.videoFrameSize > 4)) goto _L21; else goto _L20
_L20:
        mPreviewEditSettings.audioFormat = 254;
        if (s.getAudioType() != -1)
        {
            mPreviewEditSettings.audioBitrate = s.getAudioBitrate();
            mPreviewEditSettings.audioSamplingFreq = s.getAudioSamplingFrequency();
            mPreviewEditSettings.audioChannels = s.getAudioChannels();
        }
        s.getVideoType();
        JVM INSTR tableswitch 1 6: default 604
    //                   1 615
    //                   2 860
    //                   3 604
    //                   4 826
    //                   5 837
    //                   6 848;
           goto _L22 _L23 _L24 _L22 _L25 _L26 _L27
_L24:
        break MISSING_BLOCK_LABEL_860;
_L22:
        throw new IllegalArgumentException("Argument Video codec NOT Supported");
_L23:
        mPreviewEditSettings.videoFormat = 1;
_L28:
        if (mPreviewEditSettings.videoFormat == 1)
        {
            mPreviewEditSettings.videoFrameRate = 4;
        } else
        {
            mPreviewEditSettings.videoFrameRate = GetClosestVideoFrameRate(s.getFps());
        }
_L21:
        mPreviewEditSettings.transitionSettingsArray = new TransitionSettings[mTotalClips - 1];
        if (mTotalClips == 1)
        {
            s = findVideoFrameDimensions(mPreviewEditSettings.videoFrameSize);
            if (mPreviewEditSettings.videoFormat == mClipProperties.clipProperties[0].videoFormat && ((Integer)((Pair) (s)).first).intValue() == mClipProperties.clipProperties[0].width && ((Integer)((Pair) (s)).second).intValue() == mClipProperties.clipProperties[0].height)
            {
                mPreviewEditSettings.videoFormat = 254;
            }
        }
        try
        {
            mProcessingState = 20;
            mProcessingObject = null;
            i = generateClip(mPreviewEditSettings);
            mProcessingState = 0;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "IllegalArgument for generateClip");
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "IllegalStateExceptiont for generateClip");
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
            throw s;
        }
        if (i != 0)
        {
            Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
            throw new RuntimeException((new StringBuilder()).append("generateClip failed with error=").append(i).toString());
        } else
        {
            mExportProgressListener = null;
            return;
        }
_L25:
        mPreviewEditSettings.videoFormat = 4;
          goto _L28
_L26:
        mPreviewEditSettings.videoFormat = 5;
          goto _L28
_L27:
        mPreviewEditSettings.videoFormat = 6;
          goto _L28
        mPreviewEditSettings.videoFormat = 2;
          goto _L28
    }

    void exportAs2D(String s, String s1, List list, VideoEditor.ExportProgressListener exportprogresslistener)
    {
        if (!(list.get(0) instanceof MediaVideoItem))
        {
            throw new IllegalStateException("Not a media video item");
        }
        getMediaItemProperties(list);
        if (exportprogresslistener != null)
        {
            mExportProgressListener = exportprogresslistener;
        }
        mExportFilename = s;
        mPreviewEditSettings.videoFrameRate = GetClosestVideoFrameRate(((MediaVideoItem)list.get(0)).getFps());
        s1 = mPreviewEditSettings;
        mOutputFilename = s;
        s1.outputFile = s;
        mPreviewEditSettings.videoFrameSize = findVideoResolution(getAspectRatio(((MediaItem)list.get(0)).getWidth(), ((MediaItem)list.get(0)).getHeight()), ((MediaItem)list.get(0)).getHeight());
        mPreviewEditSettings.videoBitrate = getClosestVideoBitrate(((MediaVideoItem)list.get(0)).getVideoBitrate());
        mPreviewEditSettings.videoRenderingType = 1;
        ((MediaVideoItem)list.get(0)).getVideoType();
        JVM INSTR tableswitch 1 6: default 220
    //                   1 231
    //                   2 507
    //                   3 220
    //                   4 473
    //                   5 484
    //                   6 495;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException("Argument Video codec NOT Supported");
_L2:
        mPreviewEditSettings.videoFormat = 1;
_L13:
        if (mPreviewEditSettings.videoFormat == 1)
        {
            mPreviewEditSettings.videoFrameRate = 4;
            if (mPreviewEditSettings.videoBitrate > 0x5dc00)
            {
                mPreviewEditSettings.videoBitrate = 0x5dc00;
            }
        }
        if (((MediaVideoItem)list.get(0)).getAudioType() == -1) goto _L8; else goto _L7
_L7:
        ((MediaVideoItem)list.get(0)).getAudioType();
        JVM INSTR tableswitch 1 2: default 332
    //                   1 593
    //                   2 518;
           goto _L8 _L9 _L10
_L8:
        mPreviewEditSettings.maxFileSize = 0;
        mPreviewEditSettings.transitionSettingsArray = new TransitionSettings[mTotalClips - 1];
        if (mPreviewEditSettings.videoFormat == 1)
        {
            mPreviewEditSettings.videoFrameRate = 4;
            mPreviewEditSettings.videoBitrate = 0x3e800;
            if (mPreviewEditSettings.videoFrameSize > 4)
            {
                mPreviewEditSettings.videoFrameSize = 4;
            }
        }
        int i;
        mProcessingState = 20;
        mProcessingObject = null;
        i = generateClip(mPreviewEditSettings);
        mProcessingState = 0;
        if (i != 0)
        {
            Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
            throw new RuntimeException((new StringBuilder()).append("generateClip failed with error=").append(i).toString());
        } else
        {
            mExportProgressListener = null;
            return;
        }
_L4:
        mPreviewEditSettings.videoFormat = 4;
        continue; /* Loop/switch isn't completed */
_L5:
        mPreviewEditSettings.videoFormat = 5;
        continue; /* Loop/switch isn't completed */
_L6:
        mPreviewEditSettings.videoFormat = 6;
        continue; /* Loop/switch isn't completed */
_L3:
        mPreviewEditSettings.videoFormat = 2;
        continue; /* Loop/switch isn't completed */
_L10:
        mPreviewEditSettings.audioFormat = 2;
        mPreviewEditSettings.audioBitrate = getClosestAudioBitrate(((MediaVideoItem)list.get(0)).getAudioBitrate());
        mPreviewEditSettings.audioSamplingFreq = ((MediaVideoItem)list.get(0)).getAudioSamplingFrequency();
        mPreviewEditSettings.audioChannels = ((MediaVideoItem)list.get(0)).getAudioChannels();
        continue; /* Loop/switch isn't completed */
_L9:
        mPreviewEditSettings.audioFormat = 1;
        mPreviewEditSettings.audioBitrate = 12200;
        mPreviewEditSettings.audioSamplingFreq = 8000;
        mPreviewEditSettings.audioChannels = 1;
        if (true) goto _L8; else goto _L11
_L11:
        s;
        Log.e("MediaArtistNativeHelper", "IllegalArgument for generateClip");
        throw s;
        s;
        Log.e("MediaArtistNativeHelper", "IllegalStateExceptiont for generateClip");
        throw s;
        s;
        Log.e("MediaArtistNativeHelper", "RuntimeException for generateClip");
        throw s;
        if (true) goto _L13; else goto _L12
_L12:
    }

    boolean findThumbnailMode(String s, int i, long l, long l1)
        throws IllegalStateException, IllegalArgumentException
    {
        boolean flag;
        try
        {
            flag = nativeFindThumbnailMode(s, i, l, l1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in nativeFindThumbnailMode");
            return false;
        }
        return flag;
    }

    public int generateClip(EditSettings editsettings)
    {
        int i = -1;
        int j = nativeGenerateClip(editsettings);
        i = j;
_L2:
        return i;
        editsettings;
        Log.e("MediaArtistNativeHelper", "Illegal Argument exception in load settings");
        if (false)
        {
            return 0;
        }
        continue; /* Loop/switch isn't completed */
        editsettings;
        Log.e("MediaArtistNativeHelper", "Illegal state exception in load settings");
        if (false)
        {
            return 0;
        }
        continue; /* Loop/switch isn't completed */
        editsettings;
        Log.e("MediaArtistNativeHelper", "Runtime exception in load settings");
        if (false)
        {
            return 0;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    int getAspectRatio(int i, int j)
    {
        double d = (new BigDecimal((double)i / (double)j)).setScale(3, 4).doubleValue();
        if (d < 1.7D)
        {
            if (d >= 1.6000000000000001D)
            {
                return 4;
            }
            if (d >= 1.5D)
            {
                return 1;
            }
            if (d > 1.3D)
            {
                return 3;
            }
            if (d >= 1.2D)
            {
                return 5;
            }
            if (d == 1.0D)
            {
                return 6;
            }
        }
        return 2;
    }

    int getAudioCodecType(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;

        case 3: // '\003'
            return 3;

        case 4: // '\004'
            return 4;

        case 5: // '\005'
            return 5;
        }
    }

    boolean getAudioflag()
    {
        return mRegenerateAudio;
    }

    int getClosestAudioBitrate(int i)
    {
        if (i > 0 && i <= 16000)
        {
            return 16000;
        }
        if (i > 16000 && i <= 24000)
        {
            return 24000;
        }
        if (i > 24000 && i <= 32000)
        {
            return 32000;
        }
        if (i > 32000 && i <= 48000)
        {
            return 48000;
        }
        if (i > 48000 && i <= 64000)
        {
            return 64000;
        }
        if (i > 64000 && i <= 0x17700)
        {
            return 0x17700;
        }
        if (i > 0x17700 && i <= 0x1f400)
        {
            return 0x1f400;
        }
        if (i > 0x1f400 && i <= 0x2ee00)
        {
            return 0x2ee00;
        }
        return i <= 0x2ee00 || i > 0x3e800 ? -1 : 0x3e800;
    }

    int getClosestVideoBitrate(int i)
    {
        if (i > 0 && i <= 64000)
        {
            return 64000;
        }
        if (i > 64000 && i <= 0x17700)
        {
            return 0x17700;
        }
        if (i > 0x17700 && i <= 0x1f400)
        {
            return 0x1f400;
        }
        if (i > 0x1f400 && i <= 0x2ee00)
        {
            return 0x2ee00;
        }
        if (i > 0x2ee00 && i <= 0x3e800)
        {
            return 0x3e800;
        }
        if (i > 0x3e800 && i <= 0x46500)
        {
            return 0x46500;
        }
        if (i > 0x46500 && i <= 0x5dc00)
        {
            return 0x5dc00;
        }
        if (i > 0x5dc00 && i <= 0x7d000)
        {
            return 0x7d000;
        }
        if (i > 0x7d000 && i <= 0xc3500)
        {
            return 0xc3500;
        }
        if (i > 0xc3500 && i <= 0xf4240)
        {
            return 0xf4240;
        }
        if (i > 0xf4240 && i <= 0x124f80)
        {
            return 0x124f80;
        }
        if (i > 0x124f80 && i <= 0x16e360)
        {
            return 0x16e360;
        }
        if (i > 0x16e360 && i <= 0x1e8480)
        {
            return 0x1e8480;
        }
        if (i > 0x1e8480 && i <= 0x4c4b40)
        {
            return 0x4c4b40;
        }
        if (i > 0x4c4b40 && i <= 0x7a1200)
        {
            return 0x7a1200;
        }
        return i <= 0x7a1200 ? -1 : 0x7a1200;
    }

    int getFileType(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 255: 
            return 255;

        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 1;

        case 5: // '\005'
            return 5;

        case 8: // '\b'
            return 8;

        case 3: // '\003'
            return 3;

        case 10: // '\n'
            return 10;

        case 2: // '\002'
            return 2;
        }
    }

    int getFrameRate(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 0: // '\0'
            return 5;

        case 1: // '\001'
            return 8;

        case 2: // '\002'
            return 10;

        case 3: // '\003'
            return 13;

        case 4: // '\004'
            return 15;

        case 5: // '\005'
            return 20;

        case 6: // '\006'
            return 25;

        case 7: // '\007'
            return 30;
        }
    }

    boolean getGeneratePreview()
    {
        return mInvalidatePreviewArray;
    }

    int getMediaItemFileType(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 255: 
            return 255;

        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 1;

        case 5: // '\005'
            return 5;

        case 8: // '\b'
            return 8;

        case 10: // '\n'
            return 10;

        case 2: // '\002'
            return 2;
        }
    }

    int getMediaItemRenderingMode(int i)
    {
        switch (i)
        {
        default:
            return -1;

        case 0: // '\0'
            return 2;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 1;
        }
    }

    native Properties getMediaProperties(String s)
        throws IllegalArgumentException, IllegalStateException, RuntimeException, Exception;

    Bitmap getPixels(String s, int i, int j, long l)
        throws IllegalStateException, IllegalArgumentException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Invalid input file");
        } else
        {
            return nativeGetPixels(s, i, j, l, getTNAccurateCodecConfig());
        }
    }

    Bitmap getPixelsFast(String s, int i, int j, long l)
        throws IllegalArgumentException
    {
        if (s == null)
        {
            throw new IllegalArgumentException();
        }
        Bitmap bitmap;
        try
        {
            bitmap = nativeGetPixelsFast(s, i, j, l, getTNFastCodecConfig());
        }
        catch (Exception exception)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsFast call ");
            if (true)
            {
                try
                {
                    s = nativeGetPixelsFast(s, i, j, l, getTNAccurateCodecConfig());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsFast call with fallback");
                    throw s;
                }
                return s;
            } else
            {
                return null;
            }
        }
        return bitmap;
    }

    void getPixelsList(String s, int i, int j, long l, long l1, 
            int k, MediaItem.GetThumbnailListCallback getthumbnaillistcallback)
    {
        int ai[] = new int[k];
        int i1 = (int)(l1 - l) / k;
        mThumbnailListListener = getthumbnaillistcallback;
        nativeGetPixelsList(s, i, j, i1, k, (int)l, (int)l1, ai, getTNAccurateCodecConfig(), mThumbnailListListener);
    }

    Bitmap[] getPixelsList(String s, int i, int j, long l, long l1, 
            int k)
    {
        int ai[] = new int[k];
        s = nativeGetPixelsList(s, i, j, (int)(l1 - l) / k, k, (int)l, (int)l1, ai, getTNAccurateCodecConfig());
        mThumbnailTime = ai;
        return s;
    }

    void getPixelsListFast(String s, int i, int j, long l, long l1, 
            int k, MediaItem.GetThumbnailListCallback getthumbnaillistcallback)
    {
        int i1 = 0;
        int ai[] = new int[k];
        int j1 = (int)(l1 - l) / k;
        mThumbnailListListener = getthumbnaillistcallback;
        int k1 = (int)l;
        int i2 = (int)l1;
        try
        {
            nativeGetPixelsListFastCB(s, i, j, j1, k, k1, i2, ai, getTNFastCodecConfig(), mThumbnailListListener);
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem.GetThumbnailListCallback getthumbnaillistcallback)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsListFast call ");
            i1 = 1;
        }
        if (i1 != true)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        i1 = (int)l;
        k1 = (int)l1;
        nativeGetPixelsListFastCB(s, i, j, j1, k, i1, k1, ai, getTNAccurateCodecConfig(), mThumbnailListListener);
        return;
        s;
        Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsListFast call with fallback");
        throw s;
    }

    Pair[] getPixelsListFast(String s, int i, int j, long l, long l1, 
            int k)
    {
        int ai[];
        Pair apair[];
        int i1;
        int k1;
        int i2;
        boolean flag;
        int k2;
        int l2;
        flag = false;
        k1 = 0;
        i1 = 0;
        ai = new int[k];
        apair = new Pair[k];
        k2 = (int)(l1 - l) / k;
        i2 = (int)l;
        l2 = (int)l1;
        Bitmap abitmap[] = nativeGetPixelsListFast(s, i, j, k2, k, i2, l2, ai, getTNFastCodecConfig());
_L2:
        i2 = ((flag) ? 1 : 0);
        k1 = i1;
        if (i1 >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = i1;
        apair[i1] = new Pair(Integer.valueOf(ai[i1]), abitmap[i1]);
        i1++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsListFast call ");
        i2 = 1;
_L1:
        if (i2 != true) goto _L4; else goto _L3
_L3:
        int j1 = (int)l;
        int j2 = (int)l1;
        try
        {
            s = nativeGetPixelsListFast(s, i, j, k2, k, j1, j2, ai, getTNAccurateCodecConfig());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in getPixelsListFast call with fallback");
            throw s;
        }
        if (k1 >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        apair[k1] = new Pair(Integer.valueOf(ai[k1]), s[k1]);
        k1++;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_171;
_L4:
        return apair;
    }

    String getProjectAudioTrackPCMFilePath()
    {
        return mAudioTrackPCMFilePath;
    }

    String getProjectPath()
    {
        return mProjectPath;
    }

    public int getTNAccurateCodecConfig()
    {
        return mTNDecConfigAccurateMode;
    }

    public int getTNFastCodecConfig()
    {
        return mTNDecConfigFastMode;
    }

    public int getVideoCodecType(int i)
    {
        switch (i)
        {
        case 3: // '\003'
        default:
            return -1;

        case 1: // '\001'
            return 1;

        case 4: // '\004'
            return 4;

        case 5: // '\005'
            return 5;

        case 6: // '\006'
            return 6;

        case 2: // '\002'
            return 2;

        case 0: // '\0'
            return 0;
        }
    }

    void initClipSettings(ClipSettings clipsettings)
    {
        clipsettings.clipPath = null;
        clipsettings.clipDecodedPath = null;
        clipsettings.clipOriginalPath = null;
        clipsettings.fileType = 0;
        clipsettings.endCutTime = 0;
        clipsettings.beginCutTime = 0;
        clipsettings.beginCutPercent = 0;
        clipsettings.endCutPercent = 0;
        clipsettings.panZoomEnabled = false;
        clipsettings.panZoomPercentStart = 0;
        clipsettings.panZoomTopLeftXStart = 0;
        clipsettings.panZoomTopLeftYStart = 0;
        clipsettings.panZoomPercentEnd = 0;
        clipsettings.panZoomTopLeftXEnd = 0;
        clipsettings.panZoomTopLeftYEnd = 0;
        clipsettings.mediaRendering = 0;
        clipsettings.rgbWidth = 0;
        clipsettings.rgbHeight = 0;
        clipsettings.clipVolumePercentage = 0;
        clipsettings.mNumCuts = 0;
    }

    void invalidatePcmFile()
    {
        if (mAudioTrackPCMFilePath != null)
        {
            (new File(mAudioTrackPCMFilePath)).delete();
            mAudioTrackPCMFilePath = null;
        }
    }

    public native boolean nativeFindThumbnailMode(String s, int i, long l, long l1)
        throws RuntimeException;

    public native Bitmap nativeGetPixelsFast(String s, int i, int j, long l, int k);

    public native Bitmap[] nativeGetPixelsListFast(String s, int i, int j, int k, int l, int i1, int j1, 
            int ai[], int k1);

    public native int nativeGetPixelsListFastCB(String s, int i, int j, int k, int l, int i1, int j1, 
            int ai[], int k1, MediaItem.GetThumbnailListCallback getthumbnaillistcallback);

    int nativeHelperGetAspectRatio()
    {
        return mVideoEditor.getAspectRatio();
    }

    public void releaseNativeHelper()
    {
        try
        {
            release();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e("MediaArtistNativeHelper", "Illegal State exeption caught in releaseNativeHelper");
            throw illegalstateexception;
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exeption caught in releaseNativeHelper");
            throw runtimeexception;
        }
    }

    void setAudioflag(boolean flag)
    {
        if (!(new File(String.format((new StringBuilder()).append(mProjectPath).append("/").append("AudioPcm.pcm").toString(), new Object[0]))).exists())
        {
            flag = true;
        }
        mRegenerateAudio = flag;
    }

    void setFit2ShareFile(String s)
    {
        mExportFilename = s;
    }

    void stop(String s)
    {
        try
        {
            stopEncoding();
            (new File(mExportFilename)).delete();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "Illegal state exception in unload settings");
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in unload settings");
        }
        throw s;
    }

    void stopAudioWaveformExtraction()
    {
        try
        {
            stopExtraction();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e("MediaArtistNativeHelper", "Illegal state exception in unload settings");
            throw illegalstateexception;
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e("MediaArtistNativeHelper", "Runtime exception in unload settings");
            throw runtimeexception;
        }
    }

    void stopThumbnailList()
    {
        try
        {
            stopThumbnail();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e("MediaArtistNativeHelper", "Illegal state exception in stopThumbnail");
            throw illegalstateexception;
        }
    }

}
