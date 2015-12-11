// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public static long cvSubdiv2DRotateEdge(long l, int i)
    {
        return (-4L & l) + ((long)i + l & 3L);
    }

    public static long cvSubdiv2DSymEdge(long l)
    {
        return 2L ^ l;
    }

    public long CV_SUBDIV2D_NEXT_EDGE(long l)
    {
        return next((int)l & 3);
    }

    public nt cvSubdiv2DEdgeDst(long l)
    {
        return pt((int)l + 2 & 3);
    }

    public nt cvSubdiv2DEdgeOrg(long l)
    {
        return pt((int)l & 3);
    }

    public long cvSubdiv2DGetEdge(long l, int i)
    {
        l = next((int)l + i & 3);
        return (-4L & l) + ((long)(i >> 4) + l & 3L);
    }

    public long cvSubdiv2DNextEdge(long l)
    {
        return CV_SUBDIV2D_NEXT_EDGE(l);
    }

    public native int flags();

    public native CV_SUBDIV2D_NEXT_EDGE flags(int i);

    public native long next(int i);

    public native CV_SUBDIV2D_NEXT_EDGE next(int i, long l);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native nt pt(int i, nt nt);

    public native nt pt(int i);

    static 
    {
        Loader.load();
    }

    public nt()
    {
        allocate();
    }

    public allocate(int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }
}
