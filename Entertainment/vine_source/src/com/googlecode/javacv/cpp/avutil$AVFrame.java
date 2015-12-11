// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import com.googlecode.javacpp.ShortPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avutil

public static class allocateArray extends Pointer
{

    public static final int AV_NUM_DATA_POINTERS = 8;
    public static final int FF_DECODE_ERROR_INVALID_BITSTREAM = 1;
    public static final int FF_DECODE_ERROR_MISSING_REFERENCE = 2;

    private native void allocate();

    private native void allocateArray(int i);

    public native BytePointer base(int i);

    public native PointerPointer base();

    public native allocateArray base(int i, BytePointer bytepointer);

    public native long best_effort_timestamp();

    public native allocateArray best_effort_timestamp(long l);

    public native PointerPointer buf();

    public native Ref buf(int i);

    public native Ref buf(int i, Ref ref);

    public native int buffer_hints();

    public native Ref buffer_hints(int i);

    public native long channel_layout();

    public native Ref channel_layout(long l);

    public native int channels();

    public native Ref channels(int i);

    public native int coded_picture_number();

    public native Ref coded_picture_number(int i);

    public native BytePointer data(int i);

    public native PointerPointer data();

    public native Ref data(int i, BytePointer bytepointer);

    public native ShortPointer dct_coeff();

    public native Ref dct_coeff(ShortPointer shortpointer);

    public native int decode_error_flags();

    public native Ref decode_error_flags(int i);

    public native int display_picture_number();

    public native Ref display_picture_number(int i);

    public native long error(int i);

    public native LongPointer error();

    public native Ref error(int i, long l);

    public native PointerPointer extended_buf();

    public native Ref extended_buf(int i);

    public native Ref extended_buf(int i, Ref ref);

    public native BytePointer extended_data(int i);

    public native PointerPointer extended_data();

    public native Ref extended_data(int i, BytePointer bytepointer);

    public native int format();

    public native Ref format(int i);

    public native int height();

    public native Ref height(int i);

    public native Pointer hwaccel_picture_private();

    public native Ref hwaccel_picture_private(Pointer pointer);

    public native int interlaced_frame();

    public native Ref interlaced_frame(int i);

    public native int key_frame();

    public native Ref key_frame(int i);

    public native int linesize(int i);

    public native IntPointer linesize();

    public native Ref linesize(int i, int j);

    public native IntPointer mb_type();

    public native Ref mb_type(IntPointer intpointer);

    public native BytePointer mbskip_table();

    public native Ref mbskip_table(BytePointer bytepointer);

    public native nary metadata();

    public native nary metadata(nary nary);

    public native byte motion_subsample_log2();

    public native nary motion_subsample_log2(byte byte0);

    public native ShortPointer motion_val();

    public native nary motion_val(int i, int j, int k, short word0);

    public native short motion_val(int i, int j, int k);

    public native int nb_extended_buf();

    public native nary nb_extended_buf(int i);

    public native int nb_samples();

    public native nary nb_samples(int i);

    public native int nb_side_data();

    public native nary nb_side_data(int i);

    public native Pointer opaque();

    public native nary opaque(Pointer pointer);

    public native Pointer owner();

    public native nary owner(Pointer pointer);

    public native int palette_has_changed();

    public native nary palette_has_changed(int i);

    public native Pointer pan_scan();

    public native nary pan_scan(Pointer pointer);

    public native int pict_type();

    public native nary pict_type(int i);

    public native long pkt_dts();

    public native nary pkt_dts(long l);

    public native long pkt_duration();

    public native nary pkt_duration(long l);

    public native long pkt_pos();

    public native nary pkt_pos(long l);

    public native long pkt_pts();

    public native nary pkt_pts(long l);

    public native int pkt_size();

    public native nary pkt_size(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native long pts();

    public native position pts(long l);

    public native Ref qp_table_buf();

    public native Ref qp_table_buf(Ref ref);

    public native BytePointer qscale_table();

    public native Ref qscale_table(BytePointer bytepointer);

    public native int qscale_type();

    public native Ref qscale_type(int i);

    public native int qstride();

    public native Ref qstride(int i);

    public native int quality();

    public native Ref quality(int i);

    public native BytePointer ref_index(int i);

    public native PointerPointer ref_index();

    public native Ref ref_index(int i, BytePointer bytepointer);

    public native int reference();

    public native Ref reference(int i);

    public native long reordered_opaque();

    public native Ref reordered_opaque(long l);

    public native int repeat_pict();

    public native Ref repeat_pict(int i);

    public native al sample_aspect_ratio(al al);

    public native al sample_aspect_ratio();

    public native int sample_rate();

    public native al sample_rate(int i);

    public native PointerPointer side_data();

    public native ideData side_data(int i, ideData idedata);

    public native ideData side_data(int i);

    public native Pointer thread_opaque();

    public native ideData thread_opaque(Pointer pointer);

    public native int top_field_first();

    public native ideData top_field_first(int i);

    public native int type();

    public native ideData type(int i);

    public native int width();

    public native ideData width(int i);

    static 
    {
        Loader.load();
    }

    public ideData()
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
