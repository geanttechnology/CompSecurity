// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class <init> extends <init>
{

    private native void allocate();

    private native void allocateArray(int i);

    public static torage create(int i, int j, int k, torage torage)
    {
        return opencv_core.cvCreateSet(i, j, k, torage);
    }

    public native int active_count();

    public native torage active_count(int i);

    public native lem free_elems(lem lem);

    public native lem free_elems();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public volatile position position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public lem()
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
