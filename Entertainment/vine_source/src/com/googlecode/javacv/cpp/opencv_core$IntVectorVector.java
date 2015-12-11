// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocate extends Pointer
{

    private native void allocate();

    private native void allocate(long l);

    public native int get(long l, long l1);

    public native allocate put(long l, long l1, int i);

    public native void resize(long l);

    public native void resize(long l, long l1);

    public native long size();

    public native long size(long l);

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
}
