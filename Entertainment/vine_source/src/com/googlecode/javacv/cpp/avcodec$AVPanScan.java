// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.ShortPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avcodec

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native ShortPointer _position();

    public native allocateArray _position(int i, int j, short word0);

    public native short _position(int i, int j);

    public native int height();

    public native allocateArray height(int i);

    public native int id();

    public native allocateArray id(int i);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native int width();

    public native position width(int i);

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
