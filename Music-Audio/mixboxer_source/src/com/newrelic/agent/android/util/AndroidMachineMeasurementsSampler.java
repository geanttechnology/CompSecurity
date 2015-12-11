// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.newrelic.agent.android.api.common.MachineMeasurements;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

// Referenced classes of package com.newrelic.agent.android.util:
//            MachineMeasurementsSampler

public final class AndroidMachineMeasurementsSampler
    implements MachineMeasurementsSampler
{

    private static final int KB_IN_MB = 1024;
    private static final int PID[] = {
        Process.myPid()
    };
    private static AgentLog log = AgentLogManager.getAgentLog();
    private final Context context;

    public AndroidMachineMeasurementsSampler(Context context1)
    {
        context = context1;
    }

    private float getResidentMemory(Context context1)
    {
        int i = ((ActivityManager)context1.getSystemService("activity")).getProcessMemoryInfo(PID)[0].getTotalPss();
        if (i >= 0)
        {
            return (float)(i / 1024);
        } else
        {
            log.debug("MemorySampler: getTotalPss() returned a negative value!");
            return 0.0F;
        }
    }

    public MachineMeasurements sample()
    {
        return new MachineMeasurements(getResidentMemory(context));
    }

}
