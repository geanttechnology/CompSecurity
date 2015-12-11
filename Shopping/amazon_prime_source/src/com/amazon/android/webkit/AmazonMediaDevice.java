// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public class AmazonMediaDevice
{

    public static final int AUDIO = 0;
    public static final int SCREEN = 2;
    public static final int VIDEO = 1;
    private String mDeviceName;
    private int mMediaType;
    private String mUniqueDeviceID;

    public AmazonMediaDevice(String s, String s1, int i)
    {
        mDeviceName = s;
        mUniqueDeviceID = s1;
        mMediaType = i;
    }

    public String getDeviceID()
    {
        return mUniqueDeviceID;
    }

    public String getDeviceName()
    {
        return mDeviceName;
    }

    public int getDeviceType()
    {
        return mMediaType;
    }
}
