// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class IntPointer extends Pointer
{

    public IntPointer(int i)
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

    public IntPointer(Pointer pointer)
    {
        super(pointer);
    }

    public IntPointer(String s)
    {
        this(s.length() + 1);
        putString(s);
    }

    public IntPointer(IntBuffer intbuffer)
    {
        super(intbuffer);
        if (intbuffer != null && intbuffer.hasArray())
        {
            int ai[] = intbuffer.array();
            allocateArray(ai.length);
            put(ai);
            position(intbuffer.position());
            limit(intbuffer.limit());
        }
    }

    public transient IntPointer(int ai[])
    {
        this(ai.length);
        put(ai);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final IntBuffer asBuffer()
    {
        return asByteBuffer().asIntBuffer();
    }

    public IntPointer capacity(int i)
    {
        return (IntPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public int get()
    {
        return get(0);
    }

    public native int get(int i);

    public IntPointer get(int ai[])
    {
        return get(ai, 0, ai.length);
    }

    public native IntPointer get(int ai[], int i, int j);

    public String getString()
    {
        int ai[] = getStringCodePoints();
        return new String(ai, 0, ai.length);
    }

    public int[] getStringCodePoints()
    {
        int ai[] = new int[16];
        int j = 0;
        int i = position();
        do
        {
            int k = position(i).get();
            ai[j] = k;
            if (k == 0)
            {
                break;
            }
            k = j + 1;
            int l = i + 1;
            j = k;
            i = l;
            if (k >= ai.length)
            {
                int ai1[] = new int[ai.length * 2];
                System.arraycopy(ai, 0, ai1, 0, ai.length);
                ai = ai1;
                j = k;
                i = l;
            }
        } while (true);
        int ai2[] = new int[j];
        System.arraycopy(ai, 0, ai2, 0, j);
        return ai2;
    }

    public IntPointer limit(int i)
    {
        return (IntPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public IntPointer position(int i)
    {
        return (IntPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public IntPointer put(int i)
    {
        return put(0, i);
    }

    public native IntPointer put(int i, int j);

    public IntPointer put(int ai[])
    {
        return put(ai, 0, ai.length);
    }

    public native IntPointer put(int ai[], int i, int j);

    public IntPointer putString(String s)
    {
        int ai[] = new int[s.length()];
        for (int i = 0; i < ai.length; i++)
        {
            ai[i] = s.codePointAt(i);
        }

        return put(ai).put(ai.length, 0);
    }
}
