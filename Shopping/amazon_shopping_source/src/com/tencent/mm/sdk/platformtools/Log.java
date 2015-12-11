// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            TagDecrypter

public class Log
{
    public static interface LogImp
    {

        public abstract int getLogLevel();

        public abstract void logD(String s, String s1, String s2, int j, int k, long l, 
                long l1, String s3);

        public abstract void logE(String s, String s1, String s2, int j, int k, long l, 
                long l1, String s3);

        public abstract void logI(String s, String s1, String s2, int j, int k, long l, 
                long l1, String s3);
    }


    private static final String SYS_INFO;
    private static LogImp debugLog;
    private static int level = 6;
    private static LogImp logImp;
    public static TagDecrypter tagDecrypter;

    public Log()
    {
    }

    public static void d(String s, String s1)
    {
        d(s, s1, (Object[])null);
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        if (logImp != null && logImp.getLogLevel() <= 1)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            aobj = s1;
            if (s1 == null)
            {
                aobj = "";
            }
            s = decryptTag(s);
            logImp.logD(s, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), ((String) (aobj)));
        }
    }

    private static String decryptTag(String s)
    {
        String s1 = s;
        if (tagDecrypter != null)
        {
            s1 = tagDecrypter.decryptTag(s);
        }
        return s1;
    }

    public static void e(String s, String s1)
    {
        e(s, s1, (Object[])null);
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        if (logImp != null && logImp.getLogLevel() <= 4)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            aobj = s1;
            if (s1 == null)
            {
                aobj = "";
            }
            s = decryptTag(s);
            logImp.logE(s, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), ((String) (aobj)));
        }
    }

    public static void i(String s, String s1)
    {
        i(s, s1, (Object[])null);
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        if (logImp != null && logImp.getLogLevel() <= 2)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            aobj = s1;
            if (s1 == null)
            {
                aobj = "";
            }
            s = decryptTag(s);
            logImp.logI(s, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), ((String) (aobj)));
        }
    }

    static 
    {
        debugLog = new LogImp() {

            public int getLogLevel()
            {
                return Log.level;
            }

            public void logD(String s, String s1, String s2, int j, int k, long l, 
                    long l1, String s3)
            {
                if (Log.level <= 1)
                {
                    android.util.Log.d(s, s3);
                }
            }

            public void logE(String s, String s1, String s2, int j, int k, long l, 
                    long l1, String s3)
            {
                if (Log.level <= 4)
                {
                    android.util.Log.e(s, s3);
                }
            }

            public void logI(String s, String s1, String s2, int j, int k, long l, 
                    long l1, String s3)
            {
                if (Log.level <= 2)
                {
                    android.util.Log.i(s, s3);
                }
            }

        };
        logImp = debugLog;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("VERSION.RELEASE:[").append(android.os.Build.VERSION.RELEASE).toString());
        stringbuilder.append((new StringBuilder()).append("] VERSION.CODENAME:[").append(android.os.Build.VERSION.CODENAME).toString());
        stringbuilder.append((new StringBuilder()).append("] VERSION.INCREMENTAL:[").append(android.os.Build.VERSION.INCREMENTAL).toString());
        stringbuilder.append((new StringBuilder()).append("] BOARD:[").append(Build.BOARD).toString());
        stringbuilder.append((new StringBuilder()).append("] DEVICE:[").append(Build.DEVICE).toString());
        stringbuilder.append((new StringBuilder()).append("] DISPLAY:[").append(Build.DISPLAY).toString());
        stringbuilder.append((new StringBuilder()).append("] FINGERPRINT:[").append(Build.FINGERPRINT).toString());
        stringbuilder.append((new StringBuilder()).append("] HOST:[").append(Build.HOST).toString());
        stringbuilder.append((new StringBuilder()).append("] MANUFACTURER:[").append(Build.MANUFACTURER).toString());
        stringbuilder.append((new StringBuilder()).append("] MODEL:[").append(Build.MODEL).toString());
        stringbuilder.append((new StringBuilder()).append("] PRODUCT:[").append(Build.PRODUCT).toString());
        stringbuilder.append((new StringBuilder()).append("] TAGS:[").append(Build.TAGS).toString());
        stringbuilder.append((new StringBuilder()).append("] TYPE:[").append(Build.TYPE).toString());
        stringbuilder.append((new StringBuilder()).append("] USER:[").append(Build.USER).append("]").toString());
        SYS_INFO = stringbuilder.toString();
    }

}
