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

public static class  extends Pointer
{

    public native int anchor();

    public native  anchor(int i);

    public native void filter(PointerPointer pointerpointer, BytePointer bytepointer, int i, int j, int k);

    public native int ksize();

    public native  ksize(int i);

    public native void reset();

    static 
    {
        Loader.load();
    }

    public ()
    {
    }

    public (Pointer pointer)
    {
        super(pointer);
    }
}
