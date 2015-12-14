// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bvo
    implements bvw
{

    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    public final Context context;
    final ScheduledExecutorService executorService;
    public final bvq filesManager;
    volatile int rolloverIntervalSeconds;
    final AtomicReference scheduledRolloverFutureRef = new AtomicReference();

    public bvo(Context context1, ScheduledExecutorService scheduledexecutorservice, bvq bvq1)
    {
        rolloverIntervalSeconds = -1;
        context = context1;
        executorService = scheduledexecutorservice;
        filesManager = bvq1;
    }

    public void cancelTimeBasedFileRollOver()
    {
        if (scheduledRolloverFutureRef.get() != null)
        {
            CommonUtils.a(context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)scheduledRolloverFutureRef.get()).cancel(false);
            scheduledRolloverFutureRef.set(null);
        }
    }

    public void configureRollover(int i)
    {
        rolloverIntervalSeconds = i;
        scheduleTimeBasedFileRollOver(0L, rolloverIntervalSeconds);
    }

    public void deleteAllEvents()
    {
        filesManager.deleteAllEventsFiles();
    }

    public int getRollover()
    {
        return rolloverIntervalSeconds;
    }

    public void recordEvent(Object obj)
    {
        CommonUtils.a(context, obj.toString());
        try
        {
            filesManager.writeEvent(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CommonUtils.a(context, "Failed to write event.", ((Throwable) (obj)));
        }
        scheduleTimeBasedRollOverIfNeeded();
    }

    public boolean rollFileOver()
    {
        boolean flag;
        try
        {
            flag = filesManager.rollFileOver();
        }
        catch (IOException ioexception)
        {
            CommonUtils.a(context, "Failed to roll file over.", ioexception);
            return false;
        }
        return flag;
    }

    void scheduleTimeBasedFileRollOver(long l, long l1)
    {
        bwb bwb1;
        boolean flag;
        if (scheduledRolloverFutureRef.get() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        bwb1 = new bwb(context, this);
        CommonUtils.a(context, (new StringBuilder()).append("Scheduling time based file roll over every ").append(l1).append(" seconds").toString());
        scheduledRolloverFutureRef.set(executorService.scheduleAtFixedRate(bwb1, l, l1, TimeUnit.SECONDS));
        return;
        RejectedExecutionException rejectedexecutionexception;
        rejectedexecutionexception;
        CommonUtils.a(context, "Failed to schedule time based file roll over", rejectedexecutionexception);
        return;
    }

    public void scheduleTimeBasedRollOverIfNeeded()
    {
        boolean flag;
        if (rolloverIntervalSeconds != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            scheduleTimeBasedFileRollOver(rolloverIntervalSeconds, rolloverIntervalSeconds);
        }
    }

    void sendAndCleanUpIfSuccess()
    {
        bvy bvy1 = getFilesSender();
        if (bvy1 != null) goto _L2; else goto _L1
_L1:
        CommonUtils.a(context, "skipping files send because we don't yet know the target endpoint");
_L6:
        return;
_L2:
        List list;
        int i;
        CommonUtils.a(context, "Sending all files");
        list = filesManager.getBatchOfFilesToSend();
        i = 0;
_L7:
        int j;
        int k;
        j = i;
        k = i;
        if (list.size() <= 0) goto _L4; else goto _L3
_L3:
        k = i;
        CommonUtils.a(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] {
            Integer.valueOf(list.size())
        }));
        k = i;
        boolean flag = bvy1.send(list);
        j = i;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        k = i;
        j = list.size();
        i = j + i;
        filesManager.deleteSentFiles(list);
        j = i;
        if (flag) goto _L5; else goto _L4
_L4:
        if (j == 0)
        {
            filesManager.deleteOldestInRollOverIfOverMax();
            return;
        }
          goto _L6
_L5:
        k = j;
        list = filesManager.getBatchOfFilesToSend();
        i = j;
          goto _L7
        Exception exception;
        exception;
        i = k;
_L8:
        CommonUtils.a(context, (new StringBuilder()).append("Failed to send batch of analytics files to server: ").append(exception.getMessage()).toString(), exception);
        j = i;
          goto _L4
        exception;
          goto _L8
    }

    public void sendEvents()
    {
        sendAndCleanUpIfSuccess();
    }
}
