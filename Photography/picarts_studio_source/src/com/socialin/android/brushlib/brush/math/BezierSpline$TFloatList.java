// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush.math;

import java.io.Serializable;

class cursor
    implements Serializable
{

    private static final long serialVersionUID = 0x8272adaa072b600dL;
    private float array[];
    private int capacity;
    private int cursor;

    public void add(float f)
    {
        if (cursor == capacity)
        {
            capacity = capacity * 2;
            float af[] = new float[capacity];
            System.arraycopy(array, 0, af, 0, array.length);
            array = af;
        }
        float af1[] = array;
        int i = cursor;
        cursor = i + 1;
        af1[i] = f;
    }

    public void clear()
    {
        cursor = 0;
    }

    public float get(int i)
    {
        if (i < 0 || i >= capacity)
        {
            throw new IllegalArgumentException();
        } else
        {
            return array[i];
        }
    }

    public void set(int i, float f)
    {
        if (i < 0 || i >= capacity)
        {
            throw new IllegalArgumentException();
        } else
        {
            array[i] = f;
            return;
        }
    }

    public int size()
    {
        return cursor;
    }

    public (int i)
    {
        capacity = i;
        array = new float[i];
        cursor = 0;
    }
}
