// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native  clone();

    public native  clone( );

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public native int flags();

    public native clone flags(int i);

    public native int header_size();

    public native clone header_size(int i);

    public native eFunc is_instance();

    public native eFunc is_instance(eFunc efunc);

    public native eFunc next();

    public native eFunc next(eFunc efunc);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native position prev();

    public native position prev(position position1);

    public native position read();

    public native position read(position position1);

    public native nc release();

    public native nc release(nc nc);

    public native BytePointer type_name();

    public native nc type_name(BytePointer bytepointer);

    public native  write( );

    public native  write();

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
