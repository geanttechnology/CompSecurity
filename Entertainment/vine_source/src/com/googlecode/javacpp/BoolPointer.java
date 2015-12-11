// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class BoolPointer extends Pointer
{

    public BoolPointer(int i)
    {
        try
        {
            allocateArray(i);
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", unsatisfiedlinkerror);
        }
    }

    public BoolPointer(Pointer pointer)
    {
        super(pointer);
    }

    private native void allocateArray(int i);

    public BoolPointer capacity(int i)
    {
        return (BoolPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public boolean get()
    {
        return get(0);
    }

    public native boolean get(int i);

    public BoolPointer limit(int i)
    {
        return (BoolPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public BoolPointer position(int i)
    {
        return (BoolPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public native BoolPointer put(int i, boolean flag);

    public BoolPointer put(boolean flag)
    {
        return put(0, flag);
    }
}
