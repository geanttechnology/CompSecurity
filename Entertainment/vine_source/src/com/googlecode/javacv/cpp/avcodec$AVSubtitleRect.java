// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native BytePointer ass();

    public native allocateArray ass(BytePointer bytepointer);

    public native int flags();

    public native allocateArray flags(int i);

    public native int h();

    public native allocateArray h(int i);

    public native int nb_colors();

    public native allocateArray nb_colors(int i);

    public native allocateArray pict();

    public native allocateArray pict(allocateArray allocatearray);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native BytePointer text();

    public native position text(BytePointer bytepointer);

    public native int type();

    public native position type(int i);

    public native int w();

    public native position w(int i);

    public native int x();

    public native position x(int i);

    public native int y();

    public native position y(int i);

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
