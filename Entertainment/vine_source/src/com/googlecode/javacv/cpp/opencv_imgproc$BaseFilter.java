// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class _cls9 extends Pointer
{

    public native _cls9 anchor();

    public native _cls9 anchor(_cls9 _pcls9);

    public native void filter(PointerPointer pointerpointer, BytePointer bytepointer, int i, int j, int k, int l);

    public native _cls9 ksize();

    public native _cls9 ksize(_cls9 _pcls9);

    public native void reset();

    static 
    {
        Loader.load();
    }

    public _cls9()
    {
    }

    public _cls9(Pointer pointer)
    {
        super(pointer);
    }
}
