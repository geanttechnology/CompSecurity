// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.smile;

import android.os.SystemClock;
import com.amazon.mShop.control.smile.SmileController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.util.ActivityUtils;

public class SmileHelper
{

    private static long LAST_SYNC_TIME = SystemClock.elapsedRealtime();
    private static final String TAG = com/amazon/mShop/smile/SmileHelper.getSimpleName();

    public SmileHelper()
    {
    }

    public static boolean isSmile()
    {
        return ActivityUtils.isSmileEnabled() && User.isLoggedIn() && User.getUser().isSmile();
    }

    public static boolean shouldSyncSmileInfo()
    {
        return ActivityUtils.isSmileEnabled() && User.isLoggedIn();
    }

    public static void syncSmileInfoWithTimeInterval()
    {
        if (shouldSyncSmileInfo())
        {
            long l = SystemClock.elapsedRealtime();
            if (l - LAST_SYNC_TIME > 0x927c0L)
            {
                LAST_SYNC_TIME = l;
                SmileController.getInstance().syncSmileInfo();
                com.amazon.mShop.util.DebugUtil.Log.i(TAG, "AmazonSmile sync the smile info in each ten minutes");
            }
        }
    }

    public static boolean updateSmileInfo(boolean flag, String s)
    {
        User.userUpdated(flag, s);
        return true;
    }

}
