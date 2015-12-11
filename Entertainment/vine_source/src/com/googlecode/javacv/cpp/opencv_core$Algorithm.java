// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class allocate extends Pointer
{
    public static class Constructor extends FunctionPointer
    {

        private native void allocate();

        public native opencv_core.Algorithm call();

        static 
        {
            Loader.load();
        }

        protected Constructor()
        {
            allocate();
        }

        public Constructor(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Getter extends FunctionPointer
    {

        public native int call(opencv_core.Algorithm algorithm);

        static 
        {
            Loader.load();
        }

        public Getter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Setter extends FunctionPointer
    {

        public native void call(opencv_core.Algorithm algorithm, int i);

        static 
        {
            Loader.load();
        }

        public Setter(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static native Setter _create(String s);

    private native void allocate();

    public static native void getList(or or);

    public native or getAlgorithm(String s);

    public native boolean getBool(String s);

    public native double getDouble(String s);

    public native int getInt(String s);

    public native or getMat(String s);

    public native or getMatVector(String s);

    public native void getParams(or or);

    public native String getString(String s);

    public native nfo info();

    public native String name();

    public native String paramHelp(String s);

    public native int paramType(String s);

    public native void read(age age,  );

    public native void set(String s, double d);

    public native void set(String s, int i);

    public native void set(String s,  );

    public native void set(String s,  );

    public native void set(String s,  );

    public native void set(String s, String s1);

    public native void set(String s, boolean flag);

    public native void write(age age);

    static 
    {
        Loader.load();
    }

    public Setter()
    {
        allocate();
    }

    public allocate(Pointer pointer)
    {
        super(pointer);
    }
}
