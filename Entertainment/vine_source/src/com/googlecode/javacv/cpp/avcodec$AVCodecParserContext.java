// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{

    public static final int AV_PARSER_PTS_NB = 4;
    public static final int PARSER_FLAG_COMPLETE_FRAMES = 1;
    public static final int PARSER_FLAG_FETCHED_OFFSET = 4;
    public static final int PARSER_FLAG_ONCE = 2;
    public static final int PARSER_FLAG_USE_CODEC_TS = 4096;

    private native void allocate();

    private native void allocateArray(int i);

    public native long convergence_duration();

    public native allocateArray convergence_duration(long l);

    public native long cur_frame_dts(int i);

    public native LongPointer cur_frame_dts();

    public native allocateArray cur_frame_dts(int i, long l);

    public native long cur_frame_end(int i);

    public native LongPointer cur_frame_end();

    public native allocateArray cur_frame_end(int i, long l);

    public native long cur_frame_offset(int i);

    public native LongPointer cur_frame_offset();

    public native allocateArray cur_frame_offset(int i, long l);

    public native long cur_frame_pos(int i);

    public native LongPointer cur_frame_pos();

    public native allocateArray cur_frame_pos(int i, long l);

    public native long cur_frame_pts(int i);

    public native LongPointer cur_frame_pts();

    public native allocateArray cur_frame_pts(int i, long l);

    public native int cur_frame_start_index();

    public native allocateArray cur_frame_start_index(int i);

    public native long cur_offset();

    public native allocateArray cur_offset(long l);

    public native long dts();

    public native allocateArray dts(long l);

    public native int dts_ref_dts_delta();

    public native allocateArray dts_ref_dts_delta(int i);

    public native int dts_sync_point();

    public native allocateArray dts_sync_point(int i);

    public native int duration();

    public native allocateArray duration(int i);

    public native int fetch_timestamp();

    public native allocateArray fetch_timestamp(int i);

    public native int field_order();

    public native allocateArray field_order(int i);

    public native int flags();

    public native allocateArray flags(int i);

    public native long frame_offset();

    public native allocateArray frame_offset(long l);

    public native int key_frame();

    public native allocateArray key_frame(int i);

    public native long last_dts();

    public native allocateArray last_dts(long l);

    public native long last_pos();

    public native allocateArray last_pos(long l);

    public native long last_pts();

    public native allocateArray last_pts(long l);

    public native long next_frame_offset();

    public native allocateArray next_frame_offset(long l);

    public native long offset();

    public native allocateArray offset(long l);

    public native allocateArray parser();

    public native allocateArray parser(allocateArray allocatearray);

    public native int pict_type();

    public native allocateArray pict_type(int i);

    public native int picture_structure();

    public native allocateArray picture_structure(int i);

    public native long pos();

    public native allocateArray pos(long l);

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

    public native long pts();

    public native position pts(long l);

    public native int pts_dts_delta();

    public native position pts_dts_delta(int i);

    public native int repeat_pict();

    public native position repeat_pict(int i);

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
