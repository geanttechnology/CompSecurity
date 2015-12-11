// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.os.Environment;
import com.crashlytics.android.Crashlytics;
import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;
import com.edisonwang.android.slog.SLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CrashUtil
{

    private static final HashMap sEnv = new HashMap();
    private static final int sLock[] = new int[0];
    private static boolean sLogsOn;

    public CrashUtil()
    {
    }

    public static void collectLogs(int i, int j)
    {
        Object obj;
        String as[];
        long l1;
        l1 = System.currentTimeMillis();
        obj = new ArrayList();
        ((ArrayList) (obj)).add("logcat");
        ((ArrayList) (obj)).add("-d");
        ((ArrayList) (obj)).add("V");
        as = new String[i + j];
        obj = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])((ArrayList) (obj)).toArray(new String[((ArrayList) (obj)).size()])).getInputStream()));
        boolean flag;
        j = 0;
        flag = false;
_L2:
        String s = ((BufferedReader) (obj)).readLine();
        int l;
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        as[j] = s;
        l = j + 1;
        int i1 = as.length;
        j = l;
        if (l == i1)
        {
            flag = true;
            j = 0;
        }
        if (true) goto _L2; else goto _L1
_L1:
        ((BufferedReader) (obj)).close();
        break MISSING_BLOCK_LABEL_131;
_L10:
        if (l >= k) goto _L4; else goto _L3
_L3:
        if (!SLog.sLogsOn) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj1 = new PrintStream(new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "vine_logs.txt")));
        ((PrintStream) (obj1)).print(as[i]);
        ((PrintStream) (obj1)).println();
        obj = obj1;
_L8:
        j = i + 1;
        i = j;
        if (j == as.length)
        {
            i = 0;
        }
        break; /* Loop/switch isn't completed */
        exception;
        try
        {
            ((BufferedReader) (obj)).close();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log((new StringBuilder()).append("Failed to print out the last few lines: ").append(obj).toString());
        }
        return;
_L6:
        log((new StringBuilder()).append("[adb] ").append(as[i]).toString());
        if (true) goto _L8; else goto _L7
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        ((PrintStream) (obj)).flush();
        ((PrintStream) (obj)).close();
        SLog.e("Collecting logs took {}ms.", Long.valueOf(System.currentTimeMillis() - l1));
        return;
        Object obj1;
        Exception exception;
        int k;
        if (flag)
        {
            k = i;
        } else
        {
            k = j;
        }
        obj = null;
        l = 0;
        i = j;
        continue; /* Loop/switch isn't completed */
_L7:
        l++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static int getDefaultIgnoreCountForLogCollection(Throwable throwable)
    {
        byte byte0 = 4;
        int i = byte0;
        if (throwable != null)
        {
            throwable = throwable.getStackTrace();
            i = byte0;
            if (throwable != null)
            {
                i = throwable.length;
            }
        }
        return i;
    }

    public static String getStackTraceAsString(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter, true));
        return stringwriter.getBuffer().toString();
    }

    public static void log(String s)
    {
        if (sLogsOn)
        {
            SLog.i2(s);
            return;
        } else
        {
            Crashlytics.log(s);
            return;
        }
    }

    public static transient void log(String s, Object aobj[])
    {
        s = MessageFormatter.format(s, aobj).getMessage();
        if (sLogsOn)
        {
            SLog.i2(s);
            return;
        } else
        {
            Crashlytics.log(s);
            return;
        }
    }

    public static void logException(Throwable throwable)
    {
        if (sLogsOn)
        {
            SLog.e2("Exception was logged.", throwable);
            return;
        } else
        {
            Crashlytics.logException(throwable);
            Crashlytics.setString("LastException", getStackTraceAsString(throwable));
            return;
        }
    }

    public static transient void logException(Throwable throwable, String s, Object aobj[])
    {
        aobj = MessageFormatter.format(s, aobj).getMessage();
        if (!sLogsOn)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = sLock;
        s;
        JVM INSTR monitorenter ;
        SLog.e("logException triggered: ");
        String s1;
        for (Iterator iterator = sEnv.keySet().iterator(); iterator.hasNext(); SLog.i((new StringBuilder()).append(s1).append(": ").append(sEnv.get(s1)).toString()))
        {
            s1 = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_100;
        throwable;
        s;
        JVM INSTR monitorexit ;
        throw throwable;
        s;
        JVM INSTR monitorexit ;
        SLog.e2(((String) (aobj)), throwable);
        return;
        Crashlytics.log(((String) (aobj)));
        Crashlytics.logException(throwable);
        return;
    }

    public static void logOrThrowInDebug(Exception exception)
    {
        if (sLogsOn)
        {
            throw new RuntimeException(exception);
        } else
        {
            Crashlytics.logException(exception);
            Crashlytics.setString("LastException", getStackTraceAsString(exception));
            return;
        }
    }

    public static void set(String s, int i)
    {
        if (sLogsOn)
        {
            setEnv(s, Integer.valueOf(i));
            return;
        } else
        {
            Crashlytics.setInt(s, i);
            return;
        }
    }

    public static void set(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "null";
        }
        if (sLogsOn)
        {
            setEnv(s, s2);
            return;
        } else
        {
            Crashlytics.setString(s, s2);
            return;
        }
    }

    private static void setEnv(String s, Object obj)
    {
        synchronized (sLock)
        {
            sEnv.put(s, obj);
        }
        return;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setup(boolean flag)
    {
        sLogsOn = flag;
    }

    public static void start(Context context)
    {
        if (sLogsOn)
        {
            SLog.d("Crashlytics will be started now if this is running with logs off.");
            return;
        } else
        {
            Crashlytics.start(context);
            return;
        }
    }

}
