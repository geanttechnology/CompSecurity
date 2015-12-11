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
//            opencv_imgproc

public static class ter extends Pointer
{

    private native void allocate();

    private native void allocate(ter ter,  , ter ter1, int i, int j, int k, int l, 
            int i1, ter ter2);

    public native ter anchor();

    public native ter anchor(ter ter);

    public native void apply(ter ter, ter ter1, ter ter2, ter ter3, boolean flag);

    public native int borderElemSize();

    public native ter borderElemSize(int i);

    public native IntPointer borderTab();

    public native ter borderTab(IntPointer intpointer);

    public native int bufStep();

    public native ter bufStep(int i);

    public native int bufType();

    public native ter bufType(int i);

    public native int columnBorderType();

    public native ter columnBorderType(int i);

    public native ter columnFilter();

    public native ter columnFilter(ter ter);

    public native BytePointer constBorderRow();

    public native ter constBorderRow(BytePointer bytepointer);

    public native BytePointer constBorderValue();

    public native ter constBorderValue(BytePointer bytepointer);

    public native int dstType();

    public native ter dstType(int i);

    public native int dstY();

    public native ter dstY(int i);

    public native int dx1();

    public native ter dx1(int i);

    public native int dx2();

    public native ter dx2(int i);

    public native int endY();

    public native ter endY(int i);

    public native ter filter2D();

    public native ter filter2D(ter ter);

    public native void init(ter ter,  , ter ter1, int i, int j, int k, int l, 
            int i1, ter ter2);

    public native boolean isSeparable();

    public native ter ksize();

    public native ter ksize(ter ter);

    public native int maxWidth();

    public native ter maxWidth(int i);

    public native int proceed(BytePointer bytepointer, int i, int j, BytePointer bytepointer1, int k);

    public native int remainingInputRows();

    public native int remainingOutputRows();

    public native BytePointer ringBuf();

    public native ter ringBuf(BytePointer bytepointer);

    public native ter roi();

    public native ter roi(ter ter);

    public native int rowBorderType();

    public native ter rowBorderType(int i);

    public native int rowCount();

    public native ter rowCount(int i);

    public native  rowFilter();

    public native  rowFilter( );

    public native PointerPointer rows();

    public native  rows(PointerPointer pointerpointer);

    public native BytePointer srcRow();

    public native  srcRow(BytePointer bytepointer);

    public native int srcType();

    public native  srcType(int i);

    public native int start( ,  1, boolean flag, int i);

    public native int start( ,  1, int i);

    public native int startY();

    public native  startY(int i);

    public native int startY0();

    public native  startY0(int i);

    public native  wholeSize();

    public native  wholeSize( );

    static 
    {
        Loader.load();
    }

    public ter()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }

    public ter(ter ter,  , ter ter1, int i, int j, int k, int l, 
            int i1, ter ter2)
    {
        allocate(ter, , ter1, i, j, k, l, i1, ter2);
    }
}
