// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.model.BaseDeviceInfo;
import com.amazon.clouddrive.model.SourceInfo;

public class BasicSourceInfo
{

    private String mDeviceId;
    private String mSourceId;

    public BasicSourceInfo(SourceInfo sourceinfo)
    {
        mSourceId = sourceinfo.getSourceId();
        mDeviceId = sourceinfo.getDevice().getDeviceId();
    }

    public BasicSourceInfo(String s, String s1)
    {
        mSourceId = s;
        mDeviceId = s1;
    }

    public String getDeviceId()
    {
        return mDeviceId;
    }

    public String getSourceId()
    {
        return mSourceId;
    }
}
