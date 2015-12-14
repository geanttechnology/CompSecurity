// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.progress;

import net.lingala.zip4j.exception.ZipException;

public class ProgressMonitor
{

    public static final int OPERATION_ADD = 0;
    public static final int OPERATION_CALC_CRC = 3;
    public static final int OPERATION_EXTRACT = 1;
    public static final int OPERATION_MERGE = 4;
    public static final int OPERATION_NONE = -1;
    public static final int OPERATION_REMOVE = 2;
    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_WORKING = 1;
    public static final int STATE_BUSY = 1;
    public static final int STATE_READY = 0;
    private boolean cancelAllTasks;
    private int currentOperation;
    private Throwable exception;
    private String fileName;
    private boolean pause;
    private int percentDone;
    private int result;
    private int state;
    private long totalWork;
    private long workCompleted;

    public ProgressMonitor()
    {
        reset();
        percentDone = 0;
    }

    public void cancelAllTasks()
    {
        cancelAllTasks = true;
    }

    public void endProgressMonitorError(Throwable throwable)
        throws ZipException
    {
        reset();
        result = 2;
        exception = throwable;
    }

    public void endProgressMonitorSuccess()
        throws ZipException
    {
        reset();
        result = 0;
    }

    public void fullReset()
    {
        reset();
        exception = null;
        result = 0;
    }

    public int getCurrentOperation()
    {
        return currentOperation;
    }

    public Throwable getException()
    {
        return exception;
    }

    public String getFileName()
    {
        return fileName;
    }

    public int getPercentDone()
    {
        return percentDone;
    }

    public int getResult()
    {
        return result;
    }

    public int getState()
    {
        return state;
    }

    public long getTotalWork()
    {
        return totalWork;
    }

    public long getWorkCompleted()
    {
        return workCompleted;
    }

    public boolean isCancelAllTasks()
    {
        return cancelAllTasks;
    }

    public boolean isPause()
    {
        return pause;
    }

    public void reset()
    {
        currentOperation = -1;
        state = 0;
        fileName = null;
        totalWork = 0L;
        workCompleted = 0L;
        percentDone = 0;
    }

    public void setCurrentOperation(int i)
    {
        currentOperation = i;
    }

    public void setException(Throwable throwable)
    {
        exception = throwable;
    }

    public void setFileName(String s)
    {
        fileName = s;
    }

    public void setPause(boolean flag)
    {
        pause = flag;
    }

    public void setPercentDone(int i)
    {
        percentDone = i;
    }

    public void setResult(int i)
    {
        result = i;
    }

    public void setState(int i)
    {
        state = i;
    }

    public void setTotalWork(long l)
    {
        totalWork = l;
    }

    public void updateWorkCompleted(long l)
    {
        workCompleted = workCompleted + l;
        if (totalWork > 0L)
        {
            percentDone = (int)((workCompleted * 100L) / totalWork);
            if (percentDone > 100)
            {
                percentDone = 100;
            }
        }
        do
        {
            if (!pause)
            {
                return;
            }
            try
            {
                Thread.sleep(150L);
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }
}
