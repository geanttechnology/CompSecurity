// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import aag;
import adx;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import zw;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsUncaughtExceptionHandler, CrashlyticsCore, ReportUploader, SessionReport

class val.toSend
    implements Runnable
{

    final CrashlyticsUncaughtExceptionHandler this$0;
    final File val$toSend;

    public void run()
    {
        if (CommonUtils.n(CrashlyticsUncaughtExceptionHandler.access$900(CrashlyticsUncaughtExceptionHandler.this).getContext()))
        {
            zw.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            Object obj = adx.a().b();
            obj = CrashlyticsUncaughtExceptionHandler.access$900(CrashlyticsUncaughtExceptionHandler.this).getCreateReportSpiCall(((aeb) (obj)));
            if (obj != null)
            {
                (new ReportUploader(((CreateReportSpiCall) (obj)))).forceUpload(new SessionReport(val$toSend, CrashlyticsUncaughtExceptionHandler.access$1400()));
            }
        }
    }

    I()
    {
        this$0 = final_crashlyticsuncaughtexceptionhandler;
        val$toSend = File.this;
        super();
    }
}
