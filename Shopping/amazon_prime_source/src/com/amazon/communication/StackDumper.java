// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StackDumper
{

    private static final DPLogger log = new DPLogger("TComm.StackDumper");
    private final Context mContext;

    public StackDumper(Context context)
    {
        mContext = context;
    }

    public void dumpStack(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("processName must not be null");
        }
        try
        {
            int i = getPid(s);
            log.info("dumpStack", "process found", new Object[] {
                "processName", s, "pid", Integer.valueOf(i)
            });
            Process.sendSignal(i, 3);
            log.info("dumpStack", "signal sent", new Object[] {
                "processName", s, "pid", Integer.valueOf(i)
            });
            return;
        }
        catch (IOException ioexception)
        {
            log.warn("dumpStack", "stack dump failed", new Object[] {
                "processName", s, "error", ioexception.getMessage()
            });
        }
    }

    protected int getPid(String s)
        throws IOException
    {
        Object obj = ((ActivityManager)mContext.getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            throw new IOException("Failed to get list of running app processes");
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (s.equals(runningappprocessinfo.processName))
            {
                return runningappprocessinfo.pid;
            }
        }

        throw new IOException((new StringBuilder()).append("No process found with name ").append(s).toString());
    }

}
