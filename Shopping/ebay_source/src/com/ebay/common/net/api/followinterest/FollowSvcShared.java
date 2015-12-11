// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.os.Looper;

public class FollowSvcShared
{

    public static final String LOGTAG_FOLLOW_SVC_IO = "FollowSvcIo";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo followSvcLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("FollowSvcIo", 2, "Log Follow Service network operations");

    public FollowSvcShared()
    {
    }

    public static boolean isMain()
    {
        return Looper.getMainLooper() == Looper.myLooper();
    }

}
