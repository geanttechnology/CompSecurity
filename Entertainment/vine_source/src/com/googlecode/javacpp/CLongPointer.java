// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class CLongPointer extends Pointer
{

    public CLongPointer(int i)
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

    public CLongPointer(Pointer pointer)
    {
        super(pointer);
    }

    private native void allocateArray(int i);

    public CLongPointer capacity(int i)
    {
        return (CLongPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public long get()
    {
        return get(0);
    }

    public native long get(int i);

    public CLongPointer limit(int i)
    {
        return (CLongPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public CLongPointer position(int i)
    {
        return (CLongPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public native CLongPointer put(int i, long l);

    public CLongPointer put(long l)
    {
        return put(0, l);
    }
}
