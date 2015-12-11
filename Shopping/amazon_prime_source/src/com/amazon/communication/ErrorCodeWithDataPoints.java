// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.util.List;

public class ErrorCodeWithDataPoints
{

    private final int mCommunicationErrorCode;
    private final List mDataPoints;

    public ErrorCodeWithDataPoints(int i, List list)
    {
        mCommunicationErrorCode = i;
        mDataPoints = list;
    }

    public int getCode()
    {
        return mCommunicationErrorCode;
    }

    public List getDataPoints()
    {
        return mDataPoints;
    }
}
