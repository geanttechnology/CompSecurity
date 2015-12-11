// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class SizeTPointer extends Pointer
{

    public SizeTPointer(int i)
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

    public SizeTPointer(Pointer pointer)
    {
        super(pointer);
    }

    private native void allocateArray(int i);

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public SizeTPointer capacity(int i)
    {
        return (SizeTPointer)super.capacity(i);
    }

    public long get()
    {
        return get(0);
    }

    public native long get(int i);

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public SizeTPointer limit(int i)
    {
        return (SizeTPointer)super.limit(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public SizeTPointer position(int i)
    {
        return (SizeTPointer)super.position(i);
    }

    public native SizeTPointer put(int i, long l);

    public SizeTPointer put(long l)
    {
        return put(0, l);
    }
}
