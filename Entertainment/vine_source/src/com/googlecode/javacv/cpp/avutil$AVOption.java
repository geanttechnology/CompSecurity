// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avutil

public static class allocateArray extends Pointer
{

    public static final int AV_OPT_FLAG_AUDIO_PARAM = 8;
    public static final int AV_OPT_FLAG_DECODING_PARAM = 2;
    public static final int AV_OPT_FLAG_ENCODING_PARAM = 1;
    public static final int AV_OPT_FLAG_FILTERING_PARAM = 0x10000;
    public static final int AV_OPT_FLAG_METADATA = 4;
    public static final int AV_OPT_FLAG_SUBTITLE_PARAM = 32;
    public static final int AV_OPT_FLAG_VIDEO_PARAM = 16;

    private native void allocate();

    private native void allocateArray(int i);

    public native int flags();

    public native allocateArray flags(int i);

    public native BytePointer help();

    public native double max();

    public native allocateArray max(double d);

    public native double min();

    public native allocateArray min(double d);

    public native BytePointer name();

    public native int offset();

    public native allocateArray offset(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int type();

    public native position type(int i);

    public native BytePointer unit();

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
