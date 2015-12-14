// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mRepeatInterval
{

    public static final int NO_REPEAT = 0x7fffffff;
    private final ArrayList mFixedPositions = new ArrayList();
    private int mRepeatInterval;

    public mRepeatInterval addFixedPosition(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int j;
        if (com.mopub.common.ng(flag))
        {
            if ((j = Collections.binarySearch(mFixedPositions, Integer.valueOf(i))) < 0)
            {
                mFixedPositions.add(~j, Integer.valueOf(i));
                return this;
            }
        }
        return this;
    }

    public mFixedPositions enableRepeatingPositions(int i)
    {
        boolean flag = true;
        if (i <= 1)
        {
            flag = false;
        }
        if (!com.mopub.common.ng(flag, "Repeating interval must be greater than 1"))
        {
            mRepeatInterval = 0x7fffffff;
            return this;
        } else
        {
            mRepeatInterval = i;
            return this;
        }
    }

    List getFixedPositions()
    {
        return mFixedPositions;
    }

    int getRepeatingInterval()
    {
        return mRepeatInterval;
    }




/*
    static int access$102(I i, int j)
    {
        i.mRepeatInterval = j;
        return j;
    }

*/

    public mRepeatInterval()
    {
        mRepeatInterval = 0x7fffffff;
    }
}
