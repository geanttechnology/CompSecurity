// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class zero extends Pointer
{
    static class ReleaseDeallocator extends opencv_imgproc.IplConvKernel
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_imgproc.cvReleaseStructuringElement(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_imgproc.IplConvKernel iplconvkernel)
        {
            super(iplconvkernel);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create(int i, int j, int k, int l, int i1, int ai[])
    {
        ai = opencv_imgproc.cvCreateStructuringElementEx(i, j, k, l, i1, ai);
        if (ai != null)
        {
            ai.deallocator(new ReleaseDeallocator(ai));
        }
        return ai;
    }

    public native int anchorX();

    public native ReleaseDeallocator anchorX(int i);

    public native int anchorY();

    public native ReleaseDeallocator anchorY(int i);

    public native int nCols();

    public native ReleaseDeallocator nCols(int i);

    public native int nRows();

    public native ReleaseDeallocator nRows(int i);

    public native int nShiftR();

    public native ReleaseDeallocator nShiftR(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public void release()
    {
        deallocate();
    }

    public native IntPointer values();

    public native deallocate values(IntPointer intpointer);

    static 
    {
        Loader.load();
    }

    public <init>()
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
