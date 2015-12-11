// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public final class FwLog
{
    public static final class LogInfo
    {

        public final String description;
        public final boolean isLoggable;
        public final int priority;
        public final String tag;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof LogInfo)
            {
                obj = (LogInfo)obj;
                flag = flag1;
                if (((LogInfo) (obj)).priority == priority)
                {
                    flag = flag1;
                    if (((LogInfo) (obj)).tag.equals(tag))
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
        //                       2 69
        //                       3 75
        //                       4 44
        //                       5 81
        //                       6 87
        //                       7 93;
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

        public LogInfo(String s, int i, String s1)
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

    public static interface Logger
    {

        public abstract void println(int i, String s, String s1);
    }


    private static volatile WeakReference alt = null;
    private static final Comparator logInfoComparator = new Comparator() {

        public int compare(LogInfo loginfo, LogInfo loginfo1)
        {
            loginfo = (new StringBuilder()).append(loginfo.tag).append(9 - loginfo.priority).toString();
            loginfo1 = (new StringBuilder()).append(loginfo1.tag).append(9 - loginfo1.priority).toString();
            int i = loginfo.compareToIgnoreCase(loginfo1);
            if (i != 0)
            {
                return i;
            } else
            {
                return loginfo.compareTo(loginfo1);
            }
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((LogInfo)obj, (LogInfo)obj1);
        }

    };
    private static final ArrayList loggingTags = new ArrayList();

    public FwLog()
    {
    }

    static void addLoggingTag(LogInfo loginfo)
    {
        WeakReference weakreference = new WeakReference(loginfo);
        loginfo = loggingTags;
        loginfo;
        JVM INSTR monitorenter ;
        int j = loginfo.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (((WeakReference)loginfo.get(i)).get() != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        loginfo.set(i, weakreference);
        loginfo;
        JVM INSTR monitorexit ;
        return;
        loginfo.add(weakreference);
        loginfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        loginfo;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Collection getAllLoggingTags()
    {
        ArrayList arraylist = loggingTags;
        Object obj1 = null;
        arraylist;
        JVM INSTR monitorenter ;
        int j = arraylist.size();
        Object obj;
        obj = obj1;
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        TreeSet treeset = new TreeSet(logInfoComparator);
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (LogInfo)((WeakReference)arraylist.get(i)).get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        treeset.add(obj);
        i++;
        continue; /* Loop/switch isn't completed */
        arraylist.remove(i);
        j--;
        if (true) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (!treeset.isEmpty())
        {
            obj = Collections.unmodifiableSortedSet(treeset);
        }
        arraylist;
        JVM INSTR monitorexit ;
        return ((Collection) (obj));
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static transient void logMethod(LogInfo loginfo, Object aobj[])
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        StackTraceElement stacktraceelement;
        StringBuilder stringbuilder;
        if (astacktraceelement != null && astacktraceelement.length > 3)
        {
            stacktraceelement = astacktraceelement[3];
        } else
        {
            stacktraceelement = null;
        }
        stringbuilder = new StringBuilder();
        if (stacktraceelement != null)
        {
            stringbuilder.append(stacktraceelement.getClassName()).append('.');
            stringbuilder.append(stacktraceelement.getMethodName()).append('(');
        }
        if (aobj != null && aobj.length != 0)
        {
            String s;
            int i;
            boolean flag;
            int j;
            if (aobj.length > 3)
            {
                s = "\n    ";
            } else
            {
                s = ", ";
            }
            flag = true;
            j = aobj.length;
            i = 0;
            while (i < j) 
            {
                Object obj = aobj[i];
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(s);
                }
                if (obj != null && (obj instanceof CharSequence))
                {
                    stringbuilder.append('"').append((CharSequence)obj).append('"');
                } else
                {
                    stringbuilder.append(obj);
                }
                i++;
            }
        }
        if (stacktraceelement != null)
        {
            stringbuilder.append(") - ");
            if (stacktraceelement.getFileName() != null)
            {
                stringbuilder.append(stacktraceelement.getFileName()).append(':');
            }
            stringbuilder.append(stacktraceelement.getLineNumber());
        }
        println(loginfo, stringbuilder.toString());
    }

    public static void println(int i, String s, String s1)
    {
        Object obj;
label0:
        {
            Log.println(i, s, s1);
            if (alt != null)
            {
                obj = alt;
                if (obj != null)
                {
                    obj = (Logger)((WeakReference) (obj)).get();
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    break label0;
                }
                alt = null;
            }
            return;
        }
        ((Logger) (obj)).println(i, s, s1);
    }

    public static void println(int i, String s, String s1, Throwable throwable)
    {
        println(i, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static void println(LogInfo loginfo, String s)
    {
        println(loginfo.priority, loginfo.tag, s);
    }

    public static void println(LogInfo loginfo, String s, Throwable throwable)
    {
        println(loginfo.priority, loginfo.tag, (new StringBuilder()).append(s).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static void setAlternateLogger(Logger logger)
    {
        alt = new WeakReference(logger);
    }

}
