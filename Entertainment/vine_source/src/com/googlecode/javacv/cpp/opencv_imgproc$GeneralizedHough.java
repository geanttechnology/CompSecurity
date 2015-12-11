// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class  extends 
{

    public static native  create(int i);

    public native void detect( ,  1,  2,  3,  4);

    public native void detect( ,  1,  2, int i);

    public native void release();

    public native void setTemplate( , int i,  1);

    public native void setTemplate( ,  1,  2,  3);

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
