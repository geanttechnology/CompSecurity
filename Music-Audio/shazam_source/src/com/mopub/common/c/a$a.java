// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.c;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

// Referenced classes of package com.mopub.common.c:
//            a

private static final class <init> extends Handler
{

    private static final Map a;

    public final void close()
    {
    }

    public final void flush()
    {
    }

    public final void publish(LogRecord logrecord)
    {
        if (isLoggable(logrecord))
        {
            String s;
            Throwable throwable;
            int i;
            if (a.containsKey(logrecord.getLevel()))
            {
                i = ((Integer)a.get(logrecord.getLevel())).intValue();
            } else
            {
                i = 2;
            }
            s = (new StringBuilder()).append(logrecord.getMessage()).append("\n").toString();
            throwable = logrecord.getThrown();
            logrecord = s;
            if (throwable != null)
            {
                logrecord = (new StringBuilder()).append(s).append(Log.getStackTraceString(throwable)).toString();
            }
            Log.println(i, "MoPub", logrecord);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap(7);
        a = hashmap;
        hashmap.put(Level.FINEST, Integer.valueOf(2));
        a.put(Level.FINER, Integer.valueOf(2));
        a.put(Level.FINE, Integer.valueOf(2));
        a.put(Level.CONFIG, Integer.valueOf(3));
        a.put(Level.INFO, Integer.valueOf(4));
        a.put(Level.WARNING, Integer.valueOf(5));
        a.put(Level.SEVERE, Integer.valueOf(6));
    }

    private cord()
    {
    }

    cord(byte byte0)
    {
        this();
    }
}
