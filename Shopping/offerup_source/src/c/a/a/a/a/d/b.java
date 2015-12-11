// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.d;

import android.content.Context;
import c.a.a.a.a.b.l;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package c.a.a.a.a.d:
//            g, d, m, k

public abstract class b
    implements g
{

    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    protected final Context context;
    final ScheduledExecutorService executorService;
    protected final d filesManager;
    volatile int rolloverIntervalSeconds;
    final AtomicReference scheduledRolloverFutureRef = new AtomicReference();

    public b(Context context1, ScheduledExecutorService scheduledexecutorservice, d d1)
    {
        rolloverIntervalSeconds = -1;
        context = context1;
        executorService = scheduledexecutorservice;
        filesManager = d1;
    }

    public void cancelTimeBasedFileRollOver()
    {
        if (scheduledRolloverFutureRef.get() != null)
        {
            l.a(context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)scheduledRolloverFutureRef.get()).cancel(false);
            scheduledRolloverFutureRef.set(null);
        }
    }

    protected void configureRollover(int i)
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
        l.a(context, obj.toString());
        try
        {
            filesManager.writeEvent(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            l.b(context, "Failed to write event.");
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
            l.b(context, "Failed to roll file over.");
            return false;
        }
        return flag;
    }

    void scheduleTimeBasedFileRollOver(long l1, long l2)
    {
        m m1;
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
            break MISSING_BLOCK_LABEL_83;
        }
        m1 = new m(context, this);
        l.a(context, (new StringBuilder("Scheduling time based file roll over every ")).append(l2).append(" seconds").toString());
        scheduledRolloverFutureRef.set(executorService.scheduleAtFixedRate(m1, l1, l2, TimeUnit.SECONDS));
        return;
        RejectedExecutionException rejectedexecutionexception;
        rejectedexecutionexception;
        l.b(context, "Failed to schedule time based file roll over");
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
        k k1 = getFilesSender();
        if (k1 != null) goto _L2; else goto _L1
_L1:
        l.a(context, "skipping files send because we don't yet know the target endpoint");
_L6:
        return;
_L2:
        List list;
        int i;
        l.a(context, "Sending all files");
        list = filesManager.getBatchOfFilesToSend();
        i = 0;
_L4:
        int i1;
        int j1;
        i1 = i;
        j1 = i;
        if (list.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = i;
        l.a(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] {
            Integer.valueOf(list.size())
        }));
        i1 = i;
        boolean flag = k1.send(list);
        int j;
        j = i;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        i1 = i;
        j = list.size();
        i = j + i;
        filesManager.deleteSentFiles(list);
        j = i;
        j1 = j;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = j;
        list = filesManager.getBatchOfFilesToSend();
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        i = i1;
_L7:
        l.b(context, (new StringBuilder("Failed to send batch of analytics files to server: ")).append(exception.getMessage()).toString());
        j1 = i;
        if (j1 != 0) goto _L6; else goto _L5
_L5:
        filesManager.deleteOldestInRollOverIfOverMax();
        return;
        exception;
          goto _L7
    }

    public void sendEvents()
    {
        sendAndCleanUpIfSuccess();
    }
}
