// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import com.groupon.manager.UniversalInfo;
import com.groupon.util.IOUtils;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class SyncManagerTaskRunner
    implements Runnable
{

    protected CountDownLatch countDownLatch;
    protected Exception exception;
    protected UniversalInfo info;
    protected InputStream inputStream;
    protected AbstractSyncManagerProcess process;
    protected Object result;

    public SyncManagerTaskRunner(CountDownLatch countdownlatch, AbstractSyncManagerProcess abstractsyncmanagerprocess, UniversalInfo universalinfo)
    {
        countDownLatch = countdownlatch;
        process = abstractsyncmanagerprocess;
        info = universalinfo;
    }

    public void closeInputStream()
    {
        IOUtils.close(inputStream);
    }

    public Exception getException()
    {
        return exception;
    }

    public Object getResult()
    {
        return result;
    }

    public void run()
    {
        inputStream = process.triggerSync(info);
        result = process.triggerJsonParsing(inputStream, info);
        countDownLatch.countDown();
        return;
        Object obj;
        obj;
        if (process.isThrowingErrorOnException())
        {
            exception = ((Exception) (obj));
        }
        countDownLatch.countDown();
        return;
        obj;
        countDownLatch.countDown();
        throw obj;
    }

    public void runBatchTask()
        throws Exception
    {
        process.startDatabaseTask(inputStream, result, info);
    }
}
