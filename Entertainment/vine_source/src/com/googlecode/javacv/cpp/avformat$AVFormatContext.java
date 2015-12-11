// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{

    public static final int AVFMT_FLAG_CUSTOM_IO = 128;
    public static final int AVFMT_FLAG_DISCARD_CORRUPT = 256;
    public static final int AVFMT_FLAG_GENPTS = 1;
    public static final int AVFMT_FLAG_IGNDTS = 8;
    public static final int AVFMT_FLAG_IGNIDX = 2;
    public static final int AVFMT_FLAG_KEEP_SIDE_DATA = 0x40000;
    public static final int AVFMT_FLAG_MP4A_LATM = 32768;
    public static final int AVFMT_FLAG_NOBUFFER = 64;
    public static final int AVFMT_FLAG_NOFILLIN = 16;
    public static final int AVFMT_FLAG_NONBLOCK = 4;
    public static final int AVFMT_FLAG_NOPARSE = 32;
    public static final int AVFMT_FLAG_PRIV_OPT = 0x20000;
    public static final int AVFMT_FLAG_SORT_DTS = 0x10000;
    public static final int FF_FDEBUG_TS = 1;
    public static final int RAW_PACKET_BUFFER_SIZE = 0x2625a0;

    private native void allocate();

    private native void allocateArray(int i);

    public native int audio_codec_id();

    public native allocateArray audio_codec_id(int i);

    public native int audio_preload();

    public native allocateArray audio_preload(int i);

    public native allocateArray av_class();

    public native int avio_flags();

    public native allocateArray avio_flags(int i);

    public native int avoid_negative_ts();

    public native allocateArray avoid_negative_ts(int i);

    public native int bit_rate();

    public native allocateArray bit_rate(int i);

    public native PointerPointer chapters();

    public native allocateArray chapters(int i);

    public native allocateArray chapters(int i, allocateArray allocatearray);

    public native int correct_ts_overflow();

    public native allocateArray correct_ts_overflow(int i);

    public native int ctx_flags();

    public native allocateArray ctx_flags(int i);

    public native long data_offset();

    public native allocateArray data_offset(long l);

    public native int debug();

    public native allocateArray debug(int i);

    public native long duration();

    public native allocateArray duration(long l);

    public native int duration_estimation_method();

    public native allocateArray duration_estimation_method(int i);

    public native int error_recognition();

    public native allocateArray error_recognition(int i);

    public native byte filename(int i);

    public native BytePointer filename();

    public native allocateArray filename(int i, byte byte0);

    public native int flags();

    public native allocateArray flags(int i);

    public native int flush_packets();

    public native allocateArray flush_packets(int i);

    public native int fps_probe_size();

    public native allocateArray fps_probe_size(int i);

    public native allocateArray iformat(allocateArray allocatearray);

    public native allocateArray iformat();

    public native allocateArray interrupt_callback(allocateArray allocatearray);

    public native allocateArray interrupt_callback();

    public native int io_repositioned();

    public native allocateArray io_repositioned(int i);

    public native BytePointer key();

    public native int keylen();

    public native allocateArray keylen(int i);

    public native int max_analyze_duration();

    public native allocateArray max_analyze_duration(int i);

    public native int max_chunk_duration();

    public native allocateArray max_chunk_duration(int i);

    public native int max_chunk_size();

    public native allocateArray max_chunk_size(int i);

    public native int max_delay();

    public native allocateArray max_delay(int i);

    public native int max_index_size();

    public native allocateArray max_index_size(int i);

    public native int max_picture_buffer();

    public native allocateArray max_picture_buffer(int i);

    public native allocateArray metadata(allocateArray allocatearray);

    public native allocateArray metadata();

    public native int nb_chapters();

    public native allocateArray nb_chapters(int i);

    public native int nb_programs();

    public native allocateArray nb_programs(int i);

    public native int nb_streams();

    public native allocateArray nb_streams(int i);

    public native long offset();

    public native allocateArray offset(long l);

    public native allocateArray offset_timebase(allocateArray allocatearray);

    public native allocateArray offset_timebase();

    public native allocateArray oformat(allocateArray allocatearray);

    public native allocateArray oformat();

    public native allocateArray packet_buffer(allocateArray allocatearray);

    public native allocateArray packet_buffer();

    public native allocateArray packet_buffer_end(allocateArray allocatearray);

    public native allocateArray packet_buffer_end();

    public native int packet_size();

    public native allocateArray packet_size(int i);

    public native allocateArray parse_queue(allocateArray allocatearray);

    public native allocateArray parse_queue();

    public native allocateArray parse_queue_end(allocateArray allocatearray);

    public native allocateArray parse_queue_end();

    public native allocateArray pb(allocateArray allocatearray);

    public native allocateArray pb();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native Pointer priv_data();

    public native position priv_data(Pointer pointer);

    public native int probesize();

    public native position probesize(int i);

    public native PointerPointer programs();

    public native position programs(int i, position position1);

    public native position programs(int i);

    public native position raw_packet_buffer(position position1);

    public native position raw_packet_buffer();

    public native position raw_packet_buffer_end(position position1);

    public native position raw_packet_buffer_end();

    public native int raw_packet_buffer_remaining_size();

    public native position raw_packet_buffer_remaining_size(int i);

    public native int seek2any();

    public native position seek2any(int i);

    public native int skip_initial_bytes();

    public native position skip_initial_bytes(int i);

    public native long start_time();

    public native position start_time(long l);

    public native long start_time_realtime();

    public native position start_time_realtime(long l);

    public native PointerPointer streams();

    public native position streams(int i, position position1);

    public native position streams(int i);

    public native int subtitle_codec_id();

    public native position subtitle_codec_id(int i);

    public native int ts_id();

    public native position ts_id(int i);

    public native int use_wallclock_as_timestamps();

    public native position use_wallclock_as_timestamps(int i);

    public native int video_codec_id();

    public native position video_codec_id(int i);

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
    }

    public allocate(int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }
}
