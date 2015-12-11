// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class zero extends Pointer
{
    static class ReleaseDeallocator extends opencv_imgproc.CvHistogram
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_imgproc.cvReleaseHist(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_imgproc.CvHistogram cvhistogram)
        {
            super(cvhistogram);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create(int i, int ai[], int j, float af[][], int k)
    {
        ai = opencv_imgproc.cvCreateHist(i, ai, j, af, k);
        if (ai != null)
        {
            ai.deallocator(new ReleaseDeallocator(ai));
        }
        return ai;
    }

    public native ReleaseDeallocator bins();

    public native ReleaseDeallocator bins(ReleaseDeallocator releasedeallocator);

    public native ReleaseDeallocator mat();

    public native ReleaseDeallocator mat(ReleaseDeallocator releasedeallocator);

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

    public native float thresh(int i, int j);

    public native deallocate thresh(int i, int j, float f);

    public native PointerPointer thresh2();

    public native deallocate thresh2(PointerPointer pointerpointer);

    public native int type();

    public native deallocate type(int i);

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
