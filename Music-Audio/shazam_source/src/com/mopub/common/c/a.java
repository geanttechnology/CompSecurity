// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.c;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class com.mopub.common.c.a
{
    private static final class a extends Handler
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

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final Logger a;
    private static final a b;

    public static void a(String s)
    {
        a(s, null);
    }

    public static void a(String s, Throwable throwable)
    {
        a.log(Level.FINE, s, throwable);
    }

    public static void b(String s)
    {
        b(s, null);
    }

    public static void b(String s, Throwable throwable)
    {
        a.log(Level.CONFIG, s, throwable);
    }

    public static void c(String s)
    {
        a.log(Level.INFO, s, null);
    }

    public static void c(String s, Throwable throwable)
    {
        a.log(Level.WARNING, s, throwable);
    }

    public static void d(String s)
    {
        c(s, null);
    }

    public static void e(String s)
    {
        a.log(Level.SEVERE, s, null);
    }

    static 
    {
label0:
        {
            int i = 0;
            a = Logger.getLogger("com.mopub");
            b = new a((byte)0);
            a.setUseParentHandlers(false);
            a.setLevel(Level.ALL);
            b.setLevel(Level.FINE);
            LogManager.getLogManager().addLogger(a);
            Logger logger = a;
            a a1 = b;
            Handler ahandler[] = logger.getHandlers();
            for (int j = ahandler.length; i < j; i++)
            {
                if (ahandler[i].equals(a1))
                {
                    break label0;
                }
            }

            logger.addHandler(a1);
        }
    }
}
