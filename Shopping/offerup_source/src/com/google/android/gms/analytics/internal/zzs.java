// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzy

class zzs
    implements Logger
{

    private boolean zzLF;
    private int zzNW;

    zzs()
    {
        zzNW = 2;
    }

    public void error(Exception exception)
    {
    }

    public void error(String s)
    {
    }

    public int getLogLevel()
    {
        return zzNW;
    }

    public void info(String s)
    {
    }

    public void setLogLevel(int i)
    {
        zzNW = i;
        if (!zzLF)
        {
            Log.i((String)zzy.zzOg.get(), (new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.")).append((String)zzy.zzOg.get()).append(" DEBUG").toString());
            zzLF = true;
        }
    }

    public void verbose(String s)
    {
    }

    public void warn(String s)
    {
    }
}
