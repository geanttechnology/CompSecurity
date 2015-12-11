// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class allocateArray extends Pointer
{

    private native void allocate();

    private native void allocateArray(int i);

    public static ThreadLocal createThreadLocal()
    {
        return new ThreadLocal() {

            protected opencv_imgproc.CvMoments initialValue()
            {
                return new opencv_imgproc.CvMoments();
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

        };
    }

    public native double inv_sqrt_m00();

    public native _cls1.initialValue inv_sqrt_m00(double d);

    public native double m00();

    public native _cls1.initialValue m00(double d);

    public native double m01();

    public native _cls1.initialValue m01(double d);

    public native double m02();

    public native _cls1.initialValue m02(double d);

    public native double m03();

    public native _cls1.initialValue m03(double d);

    public native double m10();

    public native _cls1.initialValue m10(double d);

    public native double m11();

    public native _cls1.initialValue m11(double d);

    public native double m12();

    public native _cls1.initialValue m12(double d);

    public native double m20();

    public native _cls1.initialValue m20(double d);

    public native double m21();

    public native _cls1.initialValue m21(double d);

    public native double m30();

    public native _cls1.initialValue m30(double d);

    public native double mu02();

    public native _cls1.initialValue mu02(double d);

    public native double mu03();

    public native _cls1.initialValue mu03(double d);

    public native double mu11();

    public native _cls1.initialValue mu11(double d);

    public native double mu12();

    public native _cls1.initialValue mu12(double d);

    public native double mu20();

    public native _cls1.initialValue mu20(double d);

    public native double mu21();

    public native _cls1.initialValue mu21(double d);

    public native double mu30();

    public native _cls1.initialValue mu30(double d);

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

    public _cls1()
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
