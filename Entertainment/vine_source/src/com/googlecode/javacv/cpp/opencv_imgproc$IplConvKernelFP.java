// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class zero extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native int anchorX();

    public native zero anchorX(int i);

    public native int anchorY();

    public native zero anchorY(int i);

    public native int nCols();

    public native zero nCols(int i);

    public native int nRows();

    public native zero nRows(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native FloatPointer values();

    public native position values(FloatPointer floatpointer);

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
        zero();
    }

    public zero(int i)
    {
        allocateArray(i);
        zero();
    }

    public zero(Pointer pointer)
    {
        super(pointer);
    }
}
