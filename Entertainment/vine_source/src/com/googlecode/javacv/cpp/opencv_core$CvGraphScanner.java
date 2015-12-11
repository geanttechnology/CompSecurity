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
    protected static class ReleaseDeallocator extends opencv_core.CvGraphScanner
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public void deallocate()
        {
            opencv_core.cvReleaseGraphScanner(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_core.CvGraphScanner cvgraphscanner)
        {
            super(cvgraphscanner);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public static position create(position position1, position position2, int i)
    {
        position1 = opencv_core.cvCreateGraphScanner(position1, position2, i);
        if (position1 != null)
        {
            position1.deallocator(new ReleaseDeallocator(position1));
        }
        return position1;
    }

    public native ReleaseDeallocator dst(ReleaseDeallocator releasedeallocator);

    public native ReleaseDeallocator dst();

    public native ReleaseDeallocator edge();

    public native ReleaseDeallocator edge(ReleaseDeallocator releasedeallocator);

    public native ReleaseDeallocator graph();

    public native ReleaseDeallocator graph(ReleaseDeallocator releasedeallocator);

    public native int index();

    public native ReleaseDeallocator index(int i);

    public native int mask();

    public native ReleaseDeallocator mask(int i);

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

    public native deallocate stack(deallocate deallocate);

    public native deallocate stack();

    public native deallocate vtx(deallocate deallocate);

    public native deallocate vtx();

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
