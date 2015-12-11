// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class position extends Pointer
{

    private native void allocateArray(int i);

    public native position get();

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native position put(position position1);

    public transient position put(position aposition[])
    {
        for (int i = 0; i < aposition.length; i++)
        {
            position(i).put(aposition[i]);
        }

        return this;
    }

    static 
    {
        Loader.load();
    }

    public (int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }

    public transient allocateArray(allocateArray aallocatearray[])
    {
        this(aallocatearray.length);
        put(aallocatearray);
        position(0);
    }
}
