// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.util.Log;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads.identity:
//            ILog, Log

private static class <init>
    implements ILog
{

    private transient Iterable formatAndSplit(String s, Object aobj[])
    {
        String s1 = s;
        if (aobj != null)
        {
            s1 = s;
            if (aobj.length > 0)
            {
                s1 = String.format(s, aobj);
            }
        }
        return Log.split$3274cb7b(s1);
    }

    public transient void d$524da578(String s, Object aobj[])
    {
        for (s = formatAndSplit(s, aobj).iterator(); s.hasNext(); s.next()) { }
    }

    public transient void e(String s, String s1, Object aobj[])
    {
        for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); Log.e(s, (String)s1.next())) { }
    }

    public transient void i(String s, String s1, Object aobj[])
    {
        for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); Log.i(s, (String)s1.next())) { }
    }

    public transient void v$524da578(String s, Object aobj[])
    {
        for (s = formatAndSplit(s, aobj).iterator(); s.hasNext(); s.next()) { }
    }

    public transient void w(String s, String s1, Object aobj[])
    {
        for (s1 = formatAndSplit(s1, aobj).iterator(); s1.hasNext(); Log.w(s, (String)s1.next())) { }
    }

    private ()
    {
    }

    (byte byte0)
    {
        this();
    }
}
