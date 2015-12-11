// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.ShortPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class nit> extends nit>
{
    protected static class ReleaseDeallocator extends opencv_core.CvMatND
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseMatND(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_core.CvMatND cvmatnd)
        {
            super(cvmatnd);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create(int i, int ai[], int j)
    {
        ai = opencv_core.cvCreateMatND(i, ai, j);
        if (ai != null)
        {
            ai.deallocator(new ReleaseDeallocator(ai));
        }
        return ai;
    }

    public ReleaseDeallocator clone()
    {
        ReleaseDeallocator releasedeallocator = opencv_core.cvCloneMatND(this);
        if (releasedeallocator != null)
        {
            releasedeallocator.deallocator(new ReleaseDeallocator(releasedeallocator));
        }
        return releasedeallocator;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public native DoublePointer data_db();

    public native clone data_db(DoublePointer doublepointer);

    public native FloatPointer data_fl();

    public native clone data_fl(FloatPointer floatpointer);

    public native IntPointer data_i();

    public native clone data_i(IntPointer intpointer);

    public native BytePointer data_ptr();

    public native clone data_ptr(BytePointer bytepointer);

    public native ShortPointer data_s();

    public native clone data_s(ShortPointer shortpointer);

    public native int dim_size(int i);

    public native clone dim_size(int i, int j);

    public native int dim_step(int i);

    public native clone dim_step(int i, int j);

    public native int dims();

    public native clone dims(int i);

    public native int hdr_refcount();

    public native clone hdr_refcount(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.sition(i);
    }

    public native IntPointer refcount();

    public native sition refcount(IntPointer intpointer);

    public void release()
    {
        deallocate();
    }

    public native int type();

    public native deallocate type(int i);

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
