// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native udioProps audio(udioProps udioprops);

    public native udioProps audio();

    public native udioProps buf();

    public native udioProps buf(udioProps udioprops);

    public native BytePointer data(int i);

    public native PointerPointer data();

    public native udioProps data(int i, BytePointer bytepointer);

    public native BytePointer extended_data(int i);

    public native PointerPointer extended_data();

    public native udioProps extended_data(int i, BytePointer bytepointer);

    public native int format();

    public native udioProps format(int i);

    public native int linesize(int i);

    public native IntPointer linesize();

    public native udioProps linesize(int i, int j);

    public native udioProps metadata(udioProps udioprops);

    public native udioProps metadata();

    public native int perms();

    public native udioProps perms(int i);

    public native long pos();

    public native udioProps pos(long l);

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

    public native int type();

    public native position type(int i);

    public native ideoProps video(ideoProps ideoprops);

    public native ideoProps video();

    static 
    {
        Loader.load();
    }

    public ideoProps()
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
