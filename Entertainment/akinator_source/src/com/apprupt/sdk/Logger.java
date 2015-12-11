// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Logger
{
    private static class Basic
        implements log
    {

        private int level;
        private final String tag;

        private void d(int j, Object aobj[], Throwable throwable)
        {
            StringBuilder stringbuilder;
label0:
            {
label1:
                {
label2:
                    {
                        int i1 = level;
                        int k = i1;
                        if (i1 == -1)
                        {
                            k = Logger.rootLevel;
                        }
                        if (k > 0 && (k & j) > 0)
                        {
                            stringbuilder = new StringBuilder();
                            int j1 = aobj.length;
                            for (int l = 0; l < j1; l++)
                            {
                                Object obj = aobj[l];
                                if (stringbuilder.length() > 0)
                                {
                                    stringbuilder.append(" ");
                                }
                                stringbuilder.append(obj);
                            }

                            if (throwable != null)
                            {
                                stringbuilder.append("\n");
                                stringbuilder.append("Exception: ");
                                stringbuilder.append(throwable.getClass().getName());
                                stringbuilder.append("\n");
                                stringbuilder.append(throwable.getMessage());
                                stringbuilder.append("\n");
                                stringbuilder.append(Log.getStackTraceString(throwable));
                            }
                            switch (j)
                            {
                            default:
                                Log.v(tag, stringbuilder.toString());
                                break;

                            case 2: // '\002'
                                break label2;

                            case 4: // '\004'
                                break label1;

                            case 8: // '\b'
                                break label0;
                            }
                        }
                        return;
                    }
                    Log.i(tag, stringbuilder.toString());
                    return;
                }
                Log.w(tag, stringbuilder.toString());
                return;
            }
            Log.e(tag, stringbuilder.toString());
        }

        public transient void e(Throwable throwable, Object aobj[])
        {
            d(8, aobj, throwable);
        }

        public transient void e(Object aobj[])
        {
            d(8, aobj, null);
        }

        public int getLevel()
        {
            return level;
        }

        public transient void i(Throwable throwable, Object aobj[])
        {
            d(2, aobj, throwable);
        }

        public transient void i(Object aobj[])
        {
            d(2, aobj, null);
        }

        public void setLevel(int j)
        {
            level = j;
        }

        public transient void v(Throwable throwable, Object aobj[])
        {
            d(1, aobj, throwable);
        }

        public transient void v(Object aobj[])
        {
            d(1, aobj, null);
        }

        public transient void w(Throwable throwable, Object aobj[])
        {
            d(4, aobj, throwable);
        }

        public transient void w(Object aobj[])
        {
            d(4, aobj, null);
        }

        private Basic(String s)
        {
            level = -1;
            StringBuilder stringbuilder = (new StringBuilder()).append("CV_SDK");
            String s1;
            if (s.length() > 0)
            {
                s1 = ".";
            } else
            {
                s1 = "";
            }
            tag = stringbuilder.append(s1).append(s).toString();
        }

    }

    private static class Dummy
        implements log
    {

        public transient void e(Throwable throwable, Object aobj[])
        {
        }

        public transient void e(Object aobj[])
        {
        }

        public int getLevel()
        {
            return 0;
        }

        public transient void i(Throwable throwable, Object aobj[])
        {
        }

        public transient void i(Object aobj[])
        {
        }

        public void setLevel(int j)
        {
        }

        public transient void v(Throwable throwable, Object aobj[])
        {
        }

        public transient void v(Object aobj[])
        {
        }

        public transient void w(Throwable throwable, Object aobj[])
        {
        }

        public transient void w(Object aobj[])
        {
        }

        private Dummy()
        {
        }

    }

    public static interface log
    {

        public transient abstract void e(Throwable throwable, Object aobj[]);

        public transient abstract void e(Object aobj[]);

        public abstract int getLevel();

        public transient abstract void i(Throwable throwable, Object aobj[]);

        public transient abstract void i(Object aobj[]);

        public abstract void setLevel(int j);

        public transient abstract void v(Throwable throwable, Object aobj[]);

        public transient abstract void v(Object aobj[]);

        public transient abstract void w(Throwable throwable, Object aobj[]);

        public transient abstract void w(Object aobj[]);
    }


    private static final boolean DEBUG = false;
    private static final boolean HDEBUG = false;
    public static final int LEVEL_ALL = 15;
    public static final int LEVEL_DEFAULT = -1;
    public static final int LEVEL_ERROR = 8;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 0;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARNING = 4;
    public static final String TAG_PREFIX = "CV_SDK";
    private static final Dummy dummy = new Dummy();
    static final HashSet excludeLogs = new HashSet(Arrays.asList(new String[] {
        "FLOW"
    }));
    private static final HashMap loggers = new HashMap();
    private static int rootLevel = 0;

    public Logger()
    {
    }

    public static log get()
    {
        return get(null);
    }

    public static log get(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        log log1 = (log)loggers.get(s1);
        s = log1;
        if (log1 == null)
        {
            if (s1.length() > 0 || excludeLogs.contains(s1))
            {
                s = dummy;
            } else
            {
                s = new Basic(s1);
            }
            loggers.put(s1, s);
        }
        return s;
    }

    public static int getLevel()
    {
        return rootLevel;
    }

    public static int getLevel(String s)
    {
        return get(s).getLevel();
    }

    public static void setLevel(int i)
    {
        rootLevel = i;
    }

    public static void setLevel(String s, int i)
    {
        get(s).setLevel(i);
    }


}
