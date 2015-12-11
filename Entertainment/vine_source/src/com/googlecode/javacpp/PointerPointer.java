// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer, BytePointer, CharPointer, DoublePointer, 
//            FloatPointer, IntPointer, LongPointer, ShortPointer

public class PointerPointer extends Pointer
{

    private Pointer pointerArray[];

    public PointerPointer(int i)
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

    public PointerPointer(Pointer pointer)
    {
        super(pointer);
    }

    public transient PointerPointer(Pointer apointer[])
    {
        this(apointer.length);
        put(apointer);
    }

    public transient PointerPointer(byte abyte0[][])
    {
        this(abyte0.length);
        put(abyte0);
    }

    public transient PointerPointer(char ac[][])
    {
        this(ac.length);
        put(ac);
    }

    public transient PointerPointer(double ad[][])
    {
        this(ad.length);
        put(ad);
    }

    public transient PointerPointer(float af[][])
    {
        this(af.length);
        put(af);
    }

    public transient PointerPointer(int ai[][])
    {
        this(ai.length);
        put(ai);
    }

    public transient PointerPointer(long al[][])
    {
        this(al.length);
        put(al);
    }

    public transient PointerPointer(short aword0[][])
    {
        this(aword0.length);
        put(aword0);
    }

    private native void allocateArray(int i);

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public PointerPointer capacity(int i)
    {
        return (PointerPointer)super.capacity(i);
    }

    public Pointer get()
    {
        return get(0);
    }

    public native Pointer get(int i);

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public PointerPointer limit(int i)
    {
        return (PointerPointer)super.limit(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public PointerPointer position(int i)
    {
        return (PointerPointer)super.position(i);
    }

    public volatile Pointer put(Pointer pointer)
    {
        return put(pointer);
    }

    public native PointerPointer put(int i, Pointer pointer);

    public PointerPointer put(Pointer pointer)
    {
        return put(0, pointer);
    }

    public transient PointerPointer put(Pointer apointer[])
    {
        for (int i = 0; i < apointer.length; i++)
        {
            put(i, apointer[i]);
        }

        return this;
    }

    public transient PointerPointer put(byte abyte0[][])
    {
        pointerArray = new Pointer[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            pointerArray[i] = new BytePointer(abyte0[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(char ac[][])
    {
        pointerArray = new Pointer[ac.length];
        for (int i = 0; i < ac.length; i++)
        {
            pointerArray[i] = new CharPointer(ac[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(double ad[][])
    {
        pointerArray = new Pointer[ad.length];
        for (int i = 0; i < ad.length; i++)
        {
            pointerArray[i] = new DoublePointer(ad[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(float af[][])
    {
        pointerArray = new Pointer[af.length];
        for (int i = 0; i < af.length; i++)
        {
            pointerArray[i] = new FloatPointer(af[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(int ai[][])
    {
        pointerArray = new Pointer[ai.length];
        for (int i = 0; i < ai.length; i++)
        {
            pointerArray[i] = new IntPointer(ai[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(long al[][])
    {
        pointerArray = new Pointer[al.length];
        for (int i = 0; i < al.length; i++)
        {
            pointerArray[i] = new LongPointer(al[i]);
        }

        return put(pointerArray);
    }

    public transient PointerPointer put(short aword0[][])
    {
        pointerArray = new Pointer[aword0.length];
        for (int i = 0; i < aword0.length; i++)
        {
            pointerArray[i] = new ShortPointer(aword0[i]);
        }

        return put(pointerArray);
    }
}
