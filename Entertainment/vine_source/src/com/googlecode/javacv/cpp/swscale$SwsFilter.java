// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            swscale

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native allocateArray chrH(allocateArray allocatearray);

    public native allocateArray chrH();

    public native allocateArray chrV(allocateArray allocatearray);

    public native allocateArray chrV();

    public native allocateArray lumH(allocateArray allocatearray);

    public native allocateArray lumH();

    public native allocateArray lumV(allocateArray allocatearray);

    public native allocateArray lumV();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    static 
    {
        Loader.load();
    }

    public ()
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
