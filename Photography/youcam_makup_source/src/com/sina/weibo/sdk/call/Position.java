// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.call;


public class Position
{

    private float mLatitude;
    private float mLongitude;
    private boolean mOffset;

    public Position(float f, float f1)
    {
        mLongitude = f;
        mLatitude = f1;
        mOffset = true;
    }

    public Position(float f, float f1, boolean flag)
    {
        mLongitude = f;
        mLatitude = f1;
        mOffset = flag;
    }

    boolean checkValid()
    {
        while (Float.isNaN(mLongitude) || mLongitude < -180F || mLongitude > 180F || Float.isNaN(mLatitude) || mLatitude < -180F || mLatitude > 180F) 
        {
            return false;
        }
        return true;
    }

    public float getLatitude()
    {
        return mLatitude;
    }

    public float getLongitude()
    {
        return mLongitude;
    }

    public String getStrLatitude()
    {
        return String.valueOf(mLatitude);
    }

    public String getStrLongitude()
    {
        return String.valueOf(mLongitude);
    }

    public String getStrOffset()
    {
        if (mOffset)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public boolean isOffset()
    {
        return mOffset;
    }
}
