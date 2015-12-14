// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


public class IntInterval
{

    private int length;
    private int start;

    public IntInterval(int i, int j)
    {
        start = i;
        length = j;
    }

    public boolean equals(int i, int j)
    {
        return start == i && length == j;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof IntInterval))
            {
                return false;
            }
            obj = (IntInterval)obj;
            if (start != ((IntInterval) (obj)).start || length != ((IntInterval) (obj)).length)
            {
                return false;
            }
        }
        return true;
    }

    public int getLength()
    {
        return length;
    }

    public int getStart()
    {
        return start;
    }

    public int hashCode()
    {
        return (start + 899) * 31 + length;
    }

    public void setLength(int i)
    {
        length = i;
    }

    public void setStart(int i)
    {
        start = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{start : ").append(start).append(", length : ").append(length).append("}").toString();
    }
}
