// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            avfilter

public static class allocateArray extends Pointer
{
    public static class Free_AVFilterBuffer extends FunctionPointer
    {

        private native void allocate();

        public native void call(avfilter.AVFilterBuffer avfilterbuffer);

        static 
        {
            Loader.load();
        }

        protected Free_AVFilterBuffer()
        {
            allocate();
        }

        public Free_AVFilterBuffer(Pointer pointer)
        {
            super(pointer);
        }
    }


    private native void allocate();

    private native void allocateArray(int i);

    public native BytePointer data(int i);

    public native PointerPointer data();

    public native Free_AVFilterBuffer data(int i, BytePointer bytepointer);

    public native BytePointer extended_data(int i);

    public native PointerPointer extended_data();

    public native Free_AVFilterBuffer extended_data(int i, BytePointer bytepointer);

    public native int format();

    public native Free_AVFilterBuffer format(int i);

    public native Free_AVFilterBuffer free();

    public native Free_AVFilterBuffer free(Free_AVFilterBuffer free_avfilterbuffer);

    public native int h();

    public native Free_AVFilterBuffer h(int i);

    public native int linesize(int i);

    public native IntPointer linesize();

    public native Free_AVFilterBuffer linesize(int i, int j);

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public native Pointer priv();

    public native position priv(Pointer pointer);

    public native int refcount();

    public native position refcount(int i);

    public native int w();

    public native position w(int i);

    static 
    {
        Loader.load();
    }

    public Free_AVFilterBuffer()
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
