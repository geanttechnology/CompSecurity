// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Log;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            FwLog

public static final class ngTag
{

    public final String description;
    public final boolean isLoggable;
    public final int priority;
    public final String tag;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ngTag)
        {
            obj = (ngTag)obj;
            flag = flag1;
            if (((ngTag) (obj)).priority == priority)
            {
                flag = flag1;
                if (((priority) (obj)).tag.equals(tag))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final void log(String s)
    {
        FwLog.println(this, s);
    }

    public final void log(String s, Throwable throwable)
    {
        FwLog.println(this, s, throwable);
    }

    public final void logAsError(String s)
    {
        FwLog.println(6, tag, s);
    }

    public final void logAsError(String s, Throwable throwable)
    {
        FwLog.println(6, tag, s, throwable);
    }

    public final void logAsWarning(String s)
    {
        FwLog.println(5, tag, s);
    }

    public final void logAsWarning(String s, Throwable throwable)
    {
        FwLog.println(5, tag, s, throwable);
    }

    public String toString()
    {
        priority;
        JVM INSTR tableswitch 2 7: default 44
    //                   2 69
    //                   3 75
    //                   4 44
    //                   5 81
    //                   6 87
    //                   7 93;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6
_L1:
        String s = " - INFO";
_L8:
        return (new StringBuilder()).append(tag).append(s).toString();
_L2:
        s = " - VERBOSE";
        continue; /* Loop/switch isn't completed */
_L3:
        s = " - DEBUG";
        continue; /* Loop/switch isn't completed */
_L4:
        s = " - WARN";
        continue; /* Loop/switch isn't completed */
_L5:
        s = " - ERROR";
        continue; /* Loop/switch isn't completed */
_L6:
        s = " - ASSERT";
        if (true) goto _L8; else goto _L7
_L7:
    }

    public (String s, int i, String s1)
    {
        tag = s;
        description = s1;
        priority = i;
        isLoggable = Log.isLoggable(s, i);
        if (isLoggable && i < 4)
        {
            Log.i(com/ebay/nautilus/kernel/util/FwLog.getSimpleName(), (new StringBuilder()).append(s1).append(": ").append(this).toString());
        }
        FwLog.addLoggingTag(this);
    }
}
