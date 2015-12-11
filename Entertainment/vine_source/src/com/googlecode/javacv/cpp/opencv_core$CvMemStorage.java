// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class zero extends Pointer
{
    protected static class ReleaseDeallocator extends opencv_core.CvMemStorage
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseMemStorage(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_core.CvMemStorage cvmemstorage)
        {
            super(cvmemstorage);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create()
    {
        return create(0);
    }

    public static create create(int i)
    {
        create create1 = opencv_core.cvCreateMemStorage(i);
        if (create1 != null)
        {
            create1.deallocator(new ReleaseDeallocator(create1));
        }
        return create1;
    }

    public native int block_size();

    public native ReleaseDeallocator block_size(int i);

    public native ReleaseDeallocator bottom();

    public native ReleaseDeallocator bottom(ReleaseDeallocator releasedeallocator);

    public native int free_space();

    public native ReleaseDeallocator free_space(int i);

    public native ReleaseDeallocator parent();

    public native ReleaseDeallocator parent(ReleaseDeallocator releasedeallocator);

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

    public native int signature();

    public native deallocate signature(int i);

    public native deallocate top();

    public native deallocate top(deallocate deallocate);

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
