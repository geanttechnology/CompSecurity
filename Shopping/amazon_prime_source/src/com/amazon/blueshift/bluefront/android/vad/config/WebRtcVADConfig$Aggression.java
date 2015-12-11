// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad.config;

import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad.config:
//            WebRtcVADConfig

public static class mGlobalThreshold
{

    private final int mGlobalThreshold;
    private final int mLocalThreshold;
    private final int mOverHangMax1;
    private final int mOverHangMax2;

    public int getGlobalThreshold()
    {
        return mGlobalThreshold;
    }

    public int getLocalThreshold()
    {
        return mLocalThreshold;
    }

    public int getOverHangMax1()
    {
        return mOverHangMax1;
    }

    public int getOverHangMax2()
    {
        return mOverHangMax2;
    }

    public (int i, int j, int k, int l)
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
        Preconditions.checkArgument(flag, "OverHangMax1 must be positive.");
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "OverHangMax2 must be positive.");
        if (k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "LocalThreshold must be positive.");
        if (l > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "GlobalThreshold must be positive.");
        mOverHangMax1 = i;
        mOverHangMax2 = j;
        mLocalThreshold = k;
        mGlobalThreshold = l;
    }
}
