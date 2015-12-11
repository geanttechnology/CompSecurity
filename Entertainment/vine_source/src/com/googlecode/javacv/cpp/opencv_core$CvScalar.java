// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocateArray extends Pointer
{

    public static final position ALPHA1 = (new <init>()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 1.0D);
    public static final val ALPHA255 = (new <init>()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 255D);
    public static final val BLACK = opencv_core.CV_RGB(0.0D, 0.0D, 0.0D);
    public static final val BLUE = opencv_core.CV_RGB(0.0D, 0.0D, 255D);
    public static final val CYAN = opencv_core.CV_RGB(0.0D, 255D, 255D);
    public static final val GRAY = opencv_core.CV_RGB(128D, 128D, 128D);
    public static final val GREEN = opencv_core.CV_RGB(0.0D, 255D, 0.0D);
    public static final val MAGENTA = opencv_core.CV_RGB(255D, 0.0D, 255D);
    public static final val ONE = (new <init>()).val(0, 1.0D).val(1, 1.0D).val(2, 1.0D).val(3, 1.0D);
    public static final val ONEHALF = (new <init>()).val(0, 0.5D).val(1, 0.5D).val(2, 0.5D).val(3, 0.5D);
    public static final val RED = opencv_core.CV_RGB(255D, 0.0D, 0.0D);
    public static final val WHITE = opencv_core.CV_RGB(255D, 255D, 255D);
    public static final val YELLOW = opencv_core.CV_RGB(255D, 255D, 0.0D);
    public static final val ZERO = (new <init>()).val(0, 0.0D).val(1, 0.0D).val(2, 0.0D).val(3, 0.0D);

    private native void allocate();

    private native void allocateArray(int i);

    public double blue()
    {
        return val(0);
    }

    public val blue(double d)
    {
        val(0, d);
        return this;
    }

    public native DoublePointer getDoublePointerVal();

    public native LongPointer getLongPointerVal();

    public double getVal(int i)
    {
        return val(i);
    }

    public double green()
    {
        return val(1);
    }

    public val green(double d)
    {
        val(1, d);
        return this;
    }

    public double magnitude()
    {
        return Math.sqrt(val(0) * val(0) + val(1) * val(1) + val(2) * val(2) + val(3) * val(3));
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public double red()
    {
        return val(2);
    }

    public val red(double d)
    {
        val(2, d);
        return this;
    }

    public void scale(double d)
    {
        for (int i = 0; i < 4; i++)
        {
            val(i, val(i) * d);
        }

    }

    public val setVal(int i, double d)
    {
        return val(i, d);
    }

    public String toString()
    {
        if (isNull())
        {
            return super.toString();
        }
        if (capacity() == 0)
        {
            return (new StringBuilder()).append("(").append((float)val(0)).append(", ").append((float)val(1)).append(", ").append((float)val(2)).append(", ").append((float)val(3)).append(")").toString();
        }
        String s = "";
        int j = position();
        int i = 0;
        while (i < capacity()) 
        {
            position(i);
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if (i == 0)
            {
                s = "(";
            } else
            {
                s = " (";
            }
            s = stringbuilder.append(s).append((float)val(0)).append(", ").append((float)val(1)).append(", ").append((float)val(2)).append(", ").append((float)val(3)).append(")").toString();
            i++;
        }
        position(j);
        return s;
    }

    public native double val(int i);

    public native position val(int i, double d);

    static 
    {
        Loader.load();
    }

    public ()
    {
        allocate();
    }

    public allocate(double d, double d1, double d2, double d3)
    {
        allocate();
        val(0, d).val(1, d1).val(2, d2).val(3, d3);
    }

    public val(int i)
    {
        allocateArray(i);
    }

    public allocateArray(Pointer pointer)
    {
        super(pointer);
    }
}
