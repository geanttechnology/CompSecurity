// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class CharPointer extends Pointer
{

    public CharPointer(int i)
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

    public CharPointer(Pointer pointer)
    {
        super(pointer);
    }

    public CharPointer(String s)
    {
        this(s.toCharArray().length + 1);
        putString(s);
    }

    public CharPointer(CharBuffer charbuffer)
    {
        super(charbuffer);
        if (charbuffer != null && charbuffer.hasArray())
        {
            char ac[] = charbuffer.array();
            allocateArray(ac.length);
            put(ac);
            position(charbuffer.position());
            limit(charbuffer.limit());
        }
    }

    public transient CharPointer(char ac[])
    {
        this(ac.length);
        put(ac);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final CharBuffer asBuffer()
    {
        return asByteBuffer().asCharBuffer();
    }

    public CharPointer capacity(int i)
    {
        return (CharPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public char get()
    {
        return get(0);
    }

    public native char get(int i);

    public CharPointer get(char ac[])
    {
        return get(ac, 0, ac.length);
    }

    public native CharPointer get(char ac[], int i, int j);

    public String getString()
    {
        return new String(getStringChars());
    }

    public char[] getStringChars()
    {
        char ac[] = new char[16];
        int j = 0;
        int i = position();
        do
        {
            char c = position(i).get();
            ac[j] = c;
            if (c == 0)
            {
                break;
            }
            int k = j + 1;
            int l = i + 1;
            j = k;
            i = l;
            if (k >= ac.length)
            {
                char ac1[] = new char[ac.length * 2];
                System.arraycopy(ac, 0, ac1, 0, ac.length);
                ac = ac1;
                j = k;
                i = l;
            }
        } while (true);
        char ac2[] = new char[j];
        System.arraycopy(ac, 0, ac2, 0, j);
        return ac2;
    }

    public CharPointer limit(int i)
    {
        return (CharPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public CharPointer position(int i)
    {
        return (CharPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public CharPointer put(char c)
    {
        return put(0, c);
    }

    public native CharPointer put(int i, char c);

    public CharPointer put(char ac[])
    {
        return put(ac, 0, ac.length);
    }

    public native CharPointer put(char ac[], int i, int j);

    public CharPointer putString(String s)
    {
        s = s.toCharArray();
        return put(s).put(s.length, '\0');
    }
}
