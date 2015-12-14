// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class CrashDetectionManager
{

    private static final String TAG = com/amazon/gallery/thor/metrics/CrashDetectionManager.getName();

    public CrashDetectionManager()
    {
    }

    public static void uploadExistingCrashReportsAsync()
    {
        CrashDetectionHelper crashdetectionhelper = CrashDetectionHelper.getInstance();
        if (crashdetectionhelper != null)
        {
            GLogger.i(TAG, "Uploading crash reports if any exist from a prior session. This message does not guarantee a crash report existed.", new Object[0]);
            crashdetectionhelper.uploadCrashReportAsync();
        }
    }

}
