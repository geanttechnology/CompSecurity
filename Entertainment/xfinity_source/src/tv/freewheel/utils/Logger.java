// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.lang.reflect.Method;
import java.util.List;

// Referenced classes of package tv.freewheel.utils:
//            CommonUtil

public class Logger
{

    private static boolean forceVerbose = false;
    private static int logLevel = 2;
    private Method logDebugMethod;
    private Method logErrorMethod;
    private Method logInfoMethod;
    private Method logVerboseMethod;
    private Method logWarnMethod;
    private String tag;
    private boolean textWithThreadIDAsPrefix;

    private Logger(String s)
    {
        logVerboseMethod = null;
        logDebugMethod = null;
        logInfoMethod = null;
        logWarnMethod = null;
        logErrorMethod = null;
        textWithThreadIDAsPrefix = false;
        tag = "FW-";
        tag = s;
        s = tv/freewheel/utils/Logger.getClassLoader();
        Class aclass[];
        s = Class.forName("android.util.Log", true, s);
        aclass = new Class[2];
        aclass[0] = java/lang/String;
        aclass[1] = java/lang/String;
        try
        {
            logVerboseMethod = s.getMethod("v", aclass);
            logDebugMethod = s.getMethod("d", aclass);
            logInfoMethod = s.getMethod("i", aclass);
            logWarnMethod = s.getMethod("w", aclass);
            logErrorMethod = s.getMethod("e", aclass);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    private void doLoggerInvoke(Method method, String s, int i)
    {
        if (i < logLevel)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (textWithThreadIDAsPrefix)
        {
            s = (new StringBuilder()).append(CommonUtil.currentThreadIdentifier()).append(s).toString();
        }
        method.invoke(null, new Object[] {
            tag, s
        });
        return;
        method;
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    public static Logger getLogger(Object obj)
    {
        return getLogger(obj, false);
    }

    public static Logger getLogger(Object obj, boolean flag)
    {
        return getLogger(obj.getClass().getSimpleName(), flag);
    }

    public static Logger getLogger(String s)
    {
        return getLogger(s, false);
    }

    public static Logger getLogger(String s, boolean flag)
    {
        s = new Logger(s);
        s.textWithThreadIDAsPrefix = flag;
        return s;
    }

    public static void overrideLogLevel(Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("fwdbg://"));
        if (!activity.getPackageManager().queryIntentActivities(intent, 0x10000).isEmpty())
        {
            forceVerbose = true;
            logLevel = 2;
        }
    }

    public static void setLogLevel(int i)
    {
        if (!forceVerbose)
        {
            logLevel = i;
        }
    }

    public void debug(String s)
    {
        doLoggerInvoke(logDebugMethod, s, 3);
    }

    public void error(String s)
    {
        doLoggerInvoke(logErrorMethod, s, 6);
    }

    public void info(String s)
    {
        doLoggerInvoke(logInfoMethod, s, 4);
    }

    public void verbose(String s)
    {
        doLoggerInvoke(logVerboseMethod, s, 2);
    }

    public void warn(String s)
    {
        doLoggerInvoke(logWarnMethod, s, 5);
    }

}
