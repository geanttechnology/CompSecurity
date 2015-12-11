// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{

    public static final int MAX_PROBE_PACKETS = 2500;
    public static final int MAX_REORDER_DELAY = 16;
    public static final int MAX_STD_TIMEBASES = 726;

    private native void allocate();

    private native void allocateArray(int i);

    public native allocateArray attached_pic();

    public native allocateArray attached_pic(allocateArray allocatearray);

    public native allocateArray avg_frame_rate(allocateArray allocatearray);

    public native allocateArray avg_frame_rate();

    public native text codec();

    public native text codec(text text);

    public native int codec_info_nb_frames();

    public native text codec_info_nb_frames(int i);

    public native long cur_dts();

    public native text cur_dts(long l);

    public native int discard();

    public native text discard(int i);

    public native int disposition();

    public native text disposition(int i);

    public native long duration();

    public native text duration(long l);

    public native long first_dts();

    public native text first_dts(long l);

    public native int id();

    public native text id(int i);

    public native int index();

    public native text index(int i);

    public native try index_entries();

    public native try index_entries(try try1);

    public native int index_entries_allocated_size();

    public native try index_entries_allocated_size(int i);

    public native long interleaver_chunk_duration();

    public native try interleaver_chunk_duration(long l);

    public native long interleaver_chunk_size();

    public native try interleaver_chunk_size(long l);

    public native int last_IP_duration();

    public native try last_IP_duration(int i);

    public native long last_IP_pts();

    public native try last_IP_pts(long l);

    public native ist last_in_packet_buffer();

    public native ist last_in_packet_buffer(ist ist);

    public native y metadata(y y);

    public native y metadata();

    public native long mux_ts_offset();

    public native y mux_ts_offset(long l);

    public native int nb_decoded_frames();

    public native y nb_decoded_frames(int i);

    public native long nb_frames();

    public native y nb_frames(long l);

    public native int nb_index_entries();

    public native y nb_index_entries(int i);

    public native int need_parsing();

    public native y need_parsing(int i);

    public native serContext parser();

    public native serContext parser(serContext sercontext);

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

    public native ta probe_data();

    public native ta probe_data(ta ta);

    public native int probe_packets();

    public native ta probe_packets(int i);

    public native ta pts();

    public native ta pts(ta ta);

    public native long pts_buffer(int i);

    public native LongPointer pts_buffer();

    public native ta pts_buffer(int i, long l);

    public native int pts_wrap_behavior();

    public native ta pts_wrap_behavior(int i);

    public native int pts_wrap_bits();

    public native ta pts_wrap_bits(int i);

    public native long pts_wrap_reference();

    public native ta pts_wrap_reference(long l);

    public native ta r_frame_rate(ta ta);

    public native ta r_frame_rate();

    public native long reference_dts();

    public native ta reference_dts(long l);

    public native int request_probe();

    public native ta request_probe(int i);

    public native ta sample_aspect_ratio(ta ta);

    public native ta sample_aspect_ratio();

    public native int skip_samples();

    public native ta skip_samples(int i);

    public native int skip_to_keyframe();

    public native ta skip_to_keyframe(int i);

    public native long start_time();

    public native ta start_time(long l);

    public native int stream_identifier();

    public native ta stream_identifier(int i);

    public native ta time_base(ta ta);

    public native ta time_base();

    static 
    {
        Loader.load();
    }

    public ta()
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
