// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class put extends Pointer
{

    private native void allocate();

    private native void allocate(long l);

    public native put getCvMat(long l);

    public native put getCvMatND(long l);

    public native put getIplImage(long l);

    public native put put(long l, put put1);

    public transient put put(put aput[])
    {
        if (size() < (long)aput.length)
        {
            resize(aput.length);
        }
        for (int i = 0; i < aput.length; i++)
        {
            put(i, aput[i]);
        }

        return this;
    }

    public native void resize(long l);

    public native long size();

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
    }

    public allocate(long l)
    {
        allocate(l);
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }

    public transient allocate(allocate aallocate[])
    {
        this(aallocate.length);
        put(aallocate);
    }
}
