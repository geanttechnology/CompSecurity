// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.app.Application;
import android.util.Log;
import java.io.IOException;
import java.util.Timer;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClient, ByteCountedOutputStream, LogFileSpec, LogPurger

protected class scheduleUpload
    implements Runnable
{

    private final byte bytesToWrite[];
    private boolean scheduleUpload;
    final LogClient this$0;

    public void run()
    {
        LogClient logclient = LogClient.this;
        logclient;
        JVM INSTR monitorenter ;
        if (LogClient.access$100(LogClient.this) == null || LogClient.access$100(LogClient.this).getByteCount() + (long)bytesToWrite.length <= 64512L) goto _L2; else goto _L1
_L1:
        if (!scheduleUpload) goto _L4; else goto _L3
_L3:
        closeLogAndQueueForUpload();
_L2:
        if (LogClient.access$100(LogClient.this) != null) goto _L6; else goto _L5
_L5:
        LogFileSpec logfilespec;
        StringBuilder stringbuilder;
        LogClient.access$202(LogClient.this, Long.valueOf(System.currentTimeMillis()));
        logfilespec = LogClient.access$000(LogClient.this);
        stringbuilder = (new StringBuilder()).append(Long.toString(LogClient.access$200(LogClient.this).longValue()));
        if (LogClient.access$300(LogClient.this) == null) goto _L8; else goto _L7
_L7:
        Object obj = (new StringBuilder()).append("_").append(LogClient.access$300(LogClient.this).getNextPackageNumber()).toString();
_L9:
        obj = logfilespec.createFileName(stringbuilder.append(((String) (obj))).toString());
        LogClient.access$402(LogClient.this, (new StringBuilder()).append(((String) (obj))).append(".").append("tmp").toString());
        LogClient.access$102(LogClient.this, new ByteCountedOutputStream(LogClient.access$500(LogClient.this).openFileOutput(LogClient.access$400(LogClient.this), 0)));
        Log.d(com/groupon/tracking/mobile/internal/LogClient.getName(), (new StringBuilder()).append("Creating new file ").append(LogClient.access$400(LogClient.this)).toString());
        if (LogClient.access$300(LogClient.this) != null)
        {
            LogClient.access$300(LogClient.this).onLogCreate(LogClient.access$200(LogClient.this).longValue(), LogClient.access$400(LogClient.this), LogClient.access$100(LogClient.this));
        }
_L6:
        LogClient.access$100(LogClient.this).write(bytesToWrite);
        LogClient.access$100(LogClient.this).flush();
        if (scheduleUpload && LogClient.access$600(LogClient.this) == null)
        {
            LogClient.access$602(LogClient.this, new Timer());
            LogClient.access$600(LogClient.this).schedule(new imerTask(LogClient.this), 0x1d4c0L);
        }
_L10:
        return;
_L4:
        closeLog();
          goto _L2
        obj;
        logclient;
        JVM INSTR monitorexit ;
        throw obj;
_L8:
        obj = "";
          goto _L9
        IOException ioexception;
        ioexception;
        closeLogAndQueueForUpload();
        (new LogPurger(LogClient.access$500(LogClient.this), LogClient.access$000(LogClient.this))).purge();
          goto _L10
    }

    public imerTask(byte abyte0[], boolean flag)
    {
        this$0 = LogClient.this;
        super();
        bytesToWrite = abyte0;
        scheduleUpload = flag;
    }
}
