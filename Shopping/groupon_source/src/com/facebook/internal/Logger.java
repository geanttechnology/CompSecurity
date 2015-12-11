// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.facebook.internal:
//            Validate

public class Logger
{

    private static final HashMap stringsToReplace = new HashMap();
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority;
    private final String tag;

    public Logger(LoggingBehavior loggingbehavior, String s)
    {
        priority = 3;
        Validate.notNullOrEmpty(s, "tag");
        behavior = loggingbehavior;
        tag = (new StringBuilder()).append("FacebookSDK.").append(s).toString();
        contents = new StringBuilder();
    }

    public static void log(LoggingBehavior loggingbehavior, int i, String s, String s1)
    {
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingbehavior))
        {
            String s2 = replaceStrings(s1);
            s1 = s;
            if (!s.startsWith("FacebookSDK."))
            {
                s1 = (new StringBuilder()).append("FacebookSDK.").append(s).toString();
            }
            Log.println(i, s1, s2);
            if (loggingbehavior == LoggingBehavior.DEVELOPER_ERRORS)
            {
                (new Exception()).printStackTrace();
            }
        }
    }

    public static void log(LoggingBehavior loggingbehavior, String s, String s1)
    {
        log(loggingbehavior, 3, s, s1);
    }

    public static transient void log(LoggingBehavior loggingbehavior, String s, String s1, Object aobj[])
    {
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingbehavior))
        {
            log(loggingbehavior, 3, s, String.format(s1, aobj));
        }
    }

    public static void registerAccessToken(String s)
    {
        com/facebook/internal/Logger;
        JVM INSTR monitorenter ;
        if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS))
        {
            registerStringToReplace(s, "ACCESS_TOKEN_REMOVED");
        }
        com/facebook/internal/Logger;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void registerStringToReplace(String s, String s1)
    {
        com/facebook/internal/Logger;
        JVM INSTR monitorenter ;
        stringsToReplace.put(s, s1);
        com/facebook/internal/Logger;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private static String replaceStrings(String s)
    {
        com/facebook/internal/Logger;
        JVM INSTR monitorenter ;
        for (Iterator iterator = stringsToReplace.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s = s.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
        }

        com/facebook/internal/Logger;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    private boolean shouldLog()
    {
        return FacebookSdk.isLoggingBehaviorEnabled(behavior);
    }

    public void append(String s)
    {
        if (shouldLog())
        {
            contents.append(s);
        }
    }

    public transient void append(String s, Object aobj[])
    {
        if (shouldLog())
        {
            contents.append(String.format(s, aobj));
        }
    }

    public void appendKeyValue(String s, Object obj)
    {
        append("  %s:\t%s\n", new Object[] {
            s, obj
        });
    }

    public void log()
    {
        logString(contents.toString());
        contents = new StringBuilder();
    }

    public void logString(String s)
    {
        log(behavior, priority, tag, s);
    }

}
