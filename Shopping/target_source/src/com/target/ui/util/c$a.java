// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;


// Referenced classes of package com.target.ui.util:
//            c

public static class mDeviceStatus
{

    private final int mDeviceStatus;
    private final boolean mIsEnabled;

    public boolean a()
    {
        return mIsEnabled;
    }

    public int b()
    {
        return mDeviceStatus;
    }

    (boolean flag, int i)
    {
        mIsEnabled = flag;
        mDeviceStatus = i;
    }
}
