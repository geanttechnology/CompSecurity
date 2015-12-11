// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal:
//            BitArray

public static final class <init>
    implements BitArray
{

    long data[];
    private int start;

    private static int checkInput(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException(String.format("input must be a positive number: %s", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return i;
        }
    }

    private void growToSize(int i)
    {
        long al[] = new long[i];
        if (data != null)
        {
            System.arraycopy(data, 0, al, 0, data.length);
        }
        data = al;
    }

    private int offsetOf(int i)
    {
        i = (i + start) / 64;
        if (i > data.length - 1)
        {
            growToSize(i + 1);
        }
        return i;
    }

    private int shiftOf(int i)
    {
        return (start + i) % 64;
    }

    public void clear()
    {
        Arrays.fill(data, 0L);
    }

    public boolean get(int i)
    {
        checkInput(i);
        int j = offsetOf(i);
        return (data[j] & 1L << shiftOf(i)) != 0L;
    }

    public void set(int i)
    {
        checkInput(i);
        int j = offsetOf(i);
        long al[] = data;
        al[j] = al[j] | 1L << shiftOf(i);
    }

    public void shiftLeft(int i)
    {
        start = start - checkInput(i);
        if (start < 0)
        {
            i = start / -64 + 1;
            long al[] = new long[data.length + i];
            System.arraycopy(data, 0, al, i, data.length);
            data = al;
            start = start % 64 + 64;
        }
    }

    List toIntegerList()
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j = data.length;
        for (int k = start; i < j * 64 - k; i++)
        {
            if (get(i))
            {
                arraylist.add(Integer.valueOf(i));
            }
        }

        return arraylist;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("{");
        List list = toIntegerList();
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(',');
            }
            stringbuilder.append(list.get(i));
        }

        return stringbuilder.append('}').toString();
    }

    public void toggle(int i)
    {
        checkInput(i);
        int j = offsetOf(i);
        long al[] = data;
        al[j] = al[j] ^ 1L << shiftOf(i);
    }

    public ()
    {
        data = new long[1];
    }

    private data(data data1)
    {
        data = (new long[] {
            data1.a, 0L
        });
    }

    a(a a, a a1)
    {
        this(a);
    }
}
