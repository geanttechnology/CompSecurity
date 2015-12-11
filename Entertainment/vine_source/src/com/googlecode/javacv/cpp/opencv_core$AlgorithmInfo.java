// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class tructor extends Pointer
{

    private native void allocate(String s, tructor tructor);

    public native void addParam_(er er, String s, int i, Pointer pointer, boolean flag, er er1, er er2, 
            String s1);

    public native void get(er er, String s, int i, Pointer pointer);

    public native void getParams(er er);

    public native String name();

    public native String paramHelp(String s);

    public native int paramType(String s);

    public native void read(er er, er er1, er er2);

    public native void write(er er, er er1);

    static 
    {
        Loader.load();
    }

    public tructor(Pointer pointer)
    {
        super(pointer);
    }

    public tructor(String s, tructor tructor)
    {
        allocate(s, tructor);
    }
}
