// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

public class ParserCursor
{

    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int j)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i > j)
        {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        } else
        {
            lowerBound = i;
            upperBound = j;
            pos = i;
            return;
        }
    }

    public boolean atEnd()
    {
        return pos >= upperBound;
    }

    public int getLowerBound()
    {
        return lowerBound;
    }

    public int getPos()
    {
        return pos;
    }

    public int getUpperBound()
    {
        return upperBound;
    }

    public String toString()
    {
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(16);
        chararraybuffer.append('[');
        chararraybuffer.append(Integer.toString(lowerBound));
        chararraybuffer.append('>');
        chararraybuffer.append(Integer.toString(pos));
        chararraybuffer.append('>');
        chararraybuffer.append(Integer.toString(upperBound));
        chararraybuffer.append(']');
        return chararraybuffer.toString();
    }

    public void updatePos(int i)
    {
        if (i < lowerBound)
        {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + lowerBound);
        }
        if (i > upperBound)
        {
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + upperBound);
        } else
        {
            pos = i;
            return;
        }
    }
}
