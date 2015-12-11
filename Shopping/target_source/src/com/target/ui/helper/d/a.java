// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.d;


public class a
{

    private Object mErrors;
    private Integer mPendingOperationCount;
    private long mRequestNanoTime;
    private Object mResponses;

    public a(Object obj, Object obj1)
    {
        mResponses = obj;
        mErrors = obj1;
        mRequestNanoTime = System.nanoTime();
    }

    public a(Object obj, Object obj1, int i)
    {
        this(obj, obj1);
        mPendingOperationCount = Integer.valueOf(i);
    }

    private void e()
        throws IllegalStateException
    {
        if (mPendingOperationCount == null)
        {
            throw new IllegalStateException("The initial operation count is not yet set");
        } else
        {
            return;
        }
    }

    public int a()
        throws IllegalStateException
    {
        e();
        if (mPendingOperationCount.intValue() > 0)
        {
            Integer integer = mPendingOperationCount;
            mPendingOperationCount = Integer.valueOf(mPendingOperationCount.intValue() - 1);
        }
        return mPendingOperationCount.intValue();
    }

    public void a(int i)
        throws IllegalArgumentException
    {
        if (mPendingOperationCount != null)
        {
            throw new IllegalStateException("The initial operation count has already been set");
        } else
        {
            mPendingOperationCount = Integer.valueOf(i);
            return;
        }
    }

    public Object b()
    {
        return mErrors;
    }

    public Object c()
    {
        return mResponses;
    }

    public long d()
    {
        return mRequestNanoTime;
    }
}
