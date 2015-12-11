// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avformat

public static class allocateArray extends Pointer
{
    public static class Callback_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected Callback_Pointer()
        {
            allocate();
        }

        public Callback_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public native Callback_Pointer callback();

    public native Callback_Pointer callback(Callback_Pointer callback_pointer);

    public native Pointer opaque();

    public native Callback_Pointer opaque(Pointer pointer);

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

    public Callback_Pointer()
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
