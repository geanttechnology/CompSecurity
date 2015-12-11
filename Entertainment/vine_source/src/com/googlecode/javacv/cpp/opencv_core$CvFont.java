// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class ont extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public native IntPointer ascii();

    public native ont ascii(IntPointer intpointer);

    public native r color(r r);

    public native r color();

    public native IntPointer cyrillic();

    public native r cyrillic(IntPointer intpointer);

    public native float dx();

    public native r dx(float f);

    public native int font_face();

    public native r font_face(int i);

    public native IntPointer greek();

    public native r greek(IntPointer intpointer);

    public native float hscale();

    public native r hscale(float f);

    public native int line_type();

    public native r line_type(int i);

    public native BytePointer nameFont();

    public native r nameFont(BytePointer bytepointer);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native float shear();

    public native position shear(float f);

    public native int thickness();

    public native position thickness(int i);

    public native float vscale();

    public native position vscale(float f);

    static 
    {
        Loader.load();
    }

    public r()
    {
        allocate();
    }

    public allocate(int i)
    {
        allocateArray(i);
    }

    public allocateArray(int i, double d, double d1, double d2, 
            int j, int k)
    {
        allocate();
        opencv_core.cvInitFont(this, i, d, d1, d2, j, k);
    }

    public ont(int i, double d, int j)
    {
        allocate();
        opencv_core.cvInitFont(this, i, d, d, 0.0D, j, 16);
    }

    public ont(Pointer pointer)
    {
        super(pointer);
    }
}
