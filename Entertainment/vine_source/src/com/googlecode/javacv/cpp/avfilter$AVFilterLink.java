// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{

    public static final int AVLINK_INIT = 2;
    public static final int AVLINK_STARTINIT = 1;
    public static final int AVLINK_UNINIT = 0;

    private native void allocate();

    private native void allocateArray(int i);

    public native int age_index();

    public native allocateArray age_index(int i);

    public native long channel_layout();

    public native allocateArray channel_layout(long l);

    public native int channels();

    public native allocateArray channels(int i);

    public native int closed();

    public native allocateArray closed(int i);

    public native rRef cur_buf_copy();

    public native rRef cur_buf_copy(rRef rref);

    public native long current_pts();

    public native rRef current_pts(long l);

    public native xt dst();

    public native xt dst(xt xt);

    public native xt dstpad(xt xt);

    public native xt dstpad();

    public native int flags();

    public native xt flags(int i);

    public native int format();

    public native xt format(int i);

    public native long frame_count();

    public native xt frame_count(long l);

    public native xt frame_rate(xt xt);

    public native xt frame_rate();

    public native int frame_requested();

    public native xt frame_requested(int i);

    public native  graph();

    public native  graph( );

    public native int h();

    public native  h(int i);

    public native Pointer in_channel_layouts();

    public native  in_channel_layouts(Pointer pointer);

    public native ts in_formats();

    public native ts in_formats(ts ts);

    public native ts in_samplerates();

    public native ts in_samplerates(ts ts);

    public native int max_samples();

    public native ts max_samples(int i);

    public native int min_samples();

    public native ts min_samples(int i);

    public native Pointer out_channel_layouts();

    public native ts out_channel_layouts(Pointer pointer);

    public native ts out_formats();

    public native ts out_formats(ts ts);

    public native ts out_samplerates();

    public native ts out_samplerates(ts ts);

    public native ts partial_buf(ts ts);

    public native ts partial_buf();

    public native int partial_buf_size();

    public native ts partial_buf_size(int i);

    public native Pointer pool();

    public native ts pool(Pointer pointer);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int request_samples();

    public native position request_samples(int i);

    public native position sample_aspect_ratio(position position1);

    public native position sample_aspect_ratio();

    public native int sample_rate();

    public native position sample_rate(int i);

    public native xt src();

    public native xt src(xt xt);

    public native xt srcpad(xt xt);

    public native xt srcpad();

    public native xt time_base(xt xt);

    public native xt time_base();

    public native int type();

    public native xt type(int i);

    public native int w();

    public native xt w(int i);

    static 
    {
        Loader.load();
    }

    public xt()
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
