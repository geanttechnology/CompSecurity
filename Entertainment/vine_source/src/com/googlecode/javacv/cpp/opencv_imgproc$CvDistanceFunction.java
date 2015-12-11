// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class allocate extends FunctionPointer
{

    private native void allocate();

    public native float call(FloatPointer floatpointer, FloatPointer floatpointer1, Pointer pointer);

    static 
    {
        Loader.load();
    }

    protected A()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
