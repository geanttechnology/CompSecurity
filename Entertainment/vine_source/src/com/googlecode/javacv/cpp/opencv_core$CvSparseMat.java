// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class  extends 
{
    protected static class ReleaseDeallocator extends opencv_core.CvSparseMat
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseSparseMat(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_core.CvSparseMat cvsparsemat)
        {
            super(cvsparsemat);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create(int i, int ai[], int j)
    {
        ai = opencv_core.cvCreateSparseMat(i, ai, j);
        if (ai != null)
        {
            ai.deallocator(new ReleaseDeallocator(ai));
        }
        return ai;
    }

    public ReleaseDeallocator clone()
    {
        ReleaseDeallocator releasedeallocator = opencv_core.cvCloneSparseMat(this);
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

    public native int dims();

    public native clone dims(int i);

    public native int hashsize();

    public native clone hashsize(int i);

    public native PointerPointer hashtable();

    public native clone hashtable(PointerPointer pointerpointer);

    public native int hdr_refcount();

    public native clone hdr_refcount(int i);

    public native clone heap();

    public native clone heap(clone clone1);

    public native int idxoffset();

    public native clone idxoffset(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.on(i);
    }

    public native IntPointer refcount();

    public native on refcount(IntPointer intpointer);

    public void release()
    {
        deallocate();
    }

    public native int size(int i);

    public native deallocate size(int i, int j);

    public native int type();

    public native deallocate type(int i);

    public native int valoffset();

    public native deallocate valoffset(int i);

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
