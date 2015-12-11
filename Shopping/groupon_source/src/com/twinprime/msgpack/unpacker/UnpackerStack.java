// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessageTypeException;

public final class UnpackerStack
{

    private int counts[];
    private int top;
    private byte types[];

    public UnpackerStack()
    {
        top = 0;
        types = new byte[128];
        counts = new int[128];
        types[0] = 0;
    }

    public void checkCount()
    {
        if (counts[top] <= 0)
        {
            if (types[top] == 1)
            {
                throw new MessageTypeException("Array is end but readArrayEnd() is not called");
            }
            if (types[top] == 2)
            {
                throw new MessageTypeException("Map is end but readMapEnd() is not called");
            }
        }
    }

    public int getTopCount()
    {
        return counts[top];
    }

    public void pop()
    {
        top = top - 1;
    }

    public void pushArray(int i)
    {
        top = top + 1;
        types[top] = 1;
        counts[top] = i;
    }

    public void pushMap(int i)
    {
        top = top + 1;
        types[top] = 2;
        counts[top] = i * 2;
    }

    public void reduceCount()
    {
        int ai[] = counts;
        int i = top;
        ai[i] = ai[i] - 1;
    }

    public boolean topIsArray()
    {
        return types[top] == 1;
    }

    public boolean topIsMap()
    {
        return types[top] == 2;
    }
}
