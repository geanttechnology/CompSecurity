// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;

public class Span
{

    private int mLength;
    private int mStart;

    public Span()
    {
        this(0, 0);
    }

    public Span(int i, int j)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Negative startIndex passes as arg to Span constructor");
        }
        if (j < 0)
        {
            throw new IllegalArgumentException("Negative length passed as arg to Span constructor");
        } else
        {
            mStart = i;
            mLength = j;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Span)
        {
            obj = (Span)obj;
            flag = flag1;
            if (Objects.equal(Integer.valueOf(mStart), Integer.valueOf(((Span) (obj)).mStart)))
            {
                flag = flag1;
                if (Objects.equal(Integer.valueOf(mLength), Integer.valueOf(((Span) (obj)).mLength)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int getLength()
    {
        return mLength;
    }

    public int getStart()
    {
        return mStart;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            Integer.valueOf(mStart), Integer.valueOf(mLength)
        });
    }

    public void setLength(int i)
    {
        mLength = i;
    }

    public void setStart(int i)
    {
        mStart = i;
    }
}
