// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import java.util.List;

public class b extends com.target.mothership.services.apigee.d.b
{
    public static class a
    {

        private String mDateString;
        private String mStatus;

        public String a()
        {
            return mDateString;
        }

        public String b()
        {
            return mStatus;
        }

        public a()
        {
        }
    }


    private String mCanceledDate;
    private String mIsCancellable;
    private String mIsDelayed;
    private String mIsRepromiseItem;
    private String mOrderItemStatus;
    private List mOrderItemStatusList;

    public b()
    {
    }

    public String Q()
    {
        return mIsCancellable;
    }

    public String R()
    {
        return mOrderItemStatus;
    }

    public List S()
    {
        return mOrderItemStatusList;
    }
}
