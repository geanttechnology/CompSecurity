// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class thm.Setter extends Pointer
{

    public static final int ALGORITHM = 6;
    public static final int BOOLEAN = 1;
    public static final int FLOAT = 7;
    public static final int INT = 0;
    public static final int MAT = 4;
    public static final int MAT_VECTOR = 5;
    public static final int REAL = 2;
    public static final int SHORT = 10;
    public static final int STRING = 3;
    public static final int UCHAR = 11;
    public static final int UINT64 = 9;
    public static final int UNSIGNED_INT = 8;

    private native void allocate();

    private native void allocate(int i, boolean flag, int j, thm.Getter getter1, thm.Setter setter1, String s);

    public native thm.Getter getter();

    public native thm.Getter getter(thm.Getter getter1);

    public native thm.Getter help(String s);

    public native String help();

    public native int offset();

    public native thm.Getter offset(int i);

    public native thm.Getter readonly(boolean flag);

    public native boolean readonly();

    public native thm.Setter setter();

    public native thm.Setter setter(thm.Setter setter1);

    public native int type();

    public native thm.Setter type(int i);

    static 
    {
        Loader.load();
    }

    public thm.Setter()
    {
        allocate();
    }

    public thm.Setter(int i, boolean flag, int j, thm.Getter getter1, thm.Setter setter1, String s)
    {
        allocate(i, flag, j, getter1, setter1, s);
    }

    public thm.Setter(Pointer pointer)
    {
        super(pointer);
    }
}
