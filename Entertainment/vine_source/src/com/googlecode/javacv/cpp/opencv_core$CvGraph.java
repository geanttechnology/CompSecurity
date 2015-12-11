// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class nit> extends nit>
{

    private native void allocate();

    private native void allocateArray(int i);

    public static rage create(int i, int j, int k, int l, rage rage)
    {
        return opencv_core.cvCreateGraph(i, j, k, l, rage);
    }

    public native rage edges(rage rage);

    public native rage edges();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.sition(i);
    }

    public volatile sition position(int i)
    {
        return position(i);
    }

    public volatile position position(int i)
    {
        return position(i);
    }

    public rage()
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
