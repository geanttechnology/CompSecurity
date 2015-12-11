// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{

    public static final int AVINDEX_KEYFRAME = 1;

    private native void allocate();

    private native void allocateArray(int i);

    public native int flags();

    public native allocateArray flags(int i);

    public native int min_distance();

    public native allocateArray min_distance(int i);

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

    public native int size();

    public native position size(int i);

    public native long timestamp();

    public native position timestamp(long l);

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
