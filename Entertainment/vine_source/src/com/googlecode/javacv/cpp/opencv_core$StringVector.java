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

    public native String get(long l);

    public native put put(long l, String s);

    public transient put put(String as[])
    {
        if (size() < (long)as.length)
        {
            resize(as.length);
        }
        for (int i = 0; i < as.length; i++)
        {
            put(i, as[i]);
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

    public transient allocate(String as[])
    {
        this(as.length);
        put(as);
    }
}
