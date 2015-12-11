// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocate extends LongPointer
{

    private native void allocate();

    static 
    {
        Loader.load();
    }

    public ()
    {
        this(null);
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
