// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.videoeditor;


// Referenced classes of package com.lifevibes.videoeditor:
//            MediaArtistNativeHelper

public final class this._cls0
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

    public ()
    {
        this$0 = MediaArtistNativeHelper.this;
        super();
    }
}
