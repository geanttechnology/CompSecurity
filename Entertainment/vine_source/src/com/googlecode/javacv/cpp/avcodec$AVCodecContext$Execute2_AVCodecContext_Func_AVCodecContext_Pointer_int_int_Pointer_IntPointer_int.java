// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocate extends FunctionPointer
{

    private native void allocate();

    public native int call(allocate allocate1, allocate allocate2, Pointer pointer, IntPointer intpointer, int i);

    static 
    {
        Loader.load();
    }

    protected _89_()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
