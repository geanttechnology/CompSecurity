// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import java.nio.ByteBuffer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocate extends FunctionPointer
{

    private native void allocate();

    public native int call(Pointer pointer, ByteBuffer bytebuffer, int i);

    static 
    {
        Loader.load();
    }

    protected ()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
