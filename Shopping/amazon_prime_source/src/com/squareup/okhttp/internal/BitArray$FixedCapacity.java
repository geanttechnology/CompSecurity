// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;


// Referenced classes of package com.squareup.okhttp.internal:
//            BitArray

public static final class data
    implements BitArray
{

    long data;

    private static int checkInput(int i)
    {
        if (i < 0 || i > 63)
        {
            throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return i;
        }
    }

    public void clear()
    {
        data = 0L;
    }

    public boolean get(int i)
    {
        return (data >> checkInput(i) & 1L) == 1L;
    }

    public void set(int i)
    {
        data = data | 1L << checkInput(i);
    }

    public void shiftLeft(int i)
    {
        data = data << checkInput(i);
    }

    public String toString()
    {
        return Long.toBinaryString(data);
    }

    public BitArray toVariableCapacity()
    {
        return new ty(this, null);
    }

    public void toggle(int i)
    {
        data = data ^ 1L << checkInput(i);
    }

    public ty()
    {
        data = 0L;
    }
}
