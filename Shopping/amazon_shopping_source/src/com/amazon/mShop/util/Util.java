// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import com.amazon.mShop.platform.Platform;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

public class Util
{

    private static final int MAILTO_URI_PREFIX_LEN = "mailto:".length();

    private Util()
    {
    }

    public static Timer createTimer(Runnable runnable, long l, long l1)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(runnable) {

            final Runnable val$runnable;

            public void run()
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(runnable);
            }

            
            {
                runnable = runnable1;
                super();
            }
        }, l, l1);
        return timer;
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isEmpty(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(byte abyte0[])
    {
        return abyte0 == null || abyte0.length == 0;
    }

    public static boolean isEmpty(Object aobj[])
    {
        return aobj == null || aobj.length == 0;
    }

    public static boolean isEqual(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static String join(List list, String s)
    {
        if (isEmpty(list))
        {
            return null;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            join((String[])list.toArray(new String[list.size()]), stringbuffer, s);
            return stringbuffer.toString();
        }
    }

    public static String join(String as[], String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        join(as, stringbuffer, s);
        return stringbuffer.toString();
    }

    public static void join(String as[], StringBuffer stringbuffer, String s)
    {
        for (int i = 0; i < as.length; i++)
        {
            stringbuffer.append(as[i]);
            if (i + 1 < as.length)
            {
                stringbuffer.append(s);
            }
        }

    }

    public static int parseRuleMaxLength(String s)
    {
        int i;
        s = new StringTokenizer(s);
        i = 0;
_L2:
        String s1;
        if (!s.hasMoreTokens())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        s1 = s.nextToken();
        if (!s1.startsWith("maxlength:"))
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = Integer.parseInt(s1.substring("maxlength:".length()));
        i = j;
        continue; /* Loop/switch isn't completed */
        return i;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
