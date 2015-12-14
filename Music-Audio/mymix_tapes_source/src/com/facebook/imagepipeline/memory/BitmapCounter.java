// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public class BitmapCounter
{

    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    private long mSize;

    public BitmapCounter(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mMaxCount = i;
        mMaxSize = j;
    }

    public static int getBitmapSize(Bitmap bitmap)
    {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public void decrease(Bitmap bitmap)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        int i = getBitmapSize(bitmap);
        boolean flag;
        if ((long)i <= mSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (mCount > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mSize = mSize - (long)i;
        mCount = mCount - 1;
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public long getSize()
    {
        this;
        JVM INSTR monitorenter ;
        long l = mSize;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean increase(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        int i = getBitmapSize(bitmap);
        if (mCount >= mMaxCount) goto _L2; else goto _L1
_L1:
        long l = mSize;
        long l1 = i;
        int j = mMaxSize;
        if (l + l1 <= (long)j) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        mCount = mCount + 1;
        mSize = mSize + (long)i;
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        bitmap;
        throw bitmap;
    }
}
