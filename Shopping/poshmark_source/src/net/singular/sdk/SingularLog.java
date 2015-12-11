// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.util.Log;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            CountersLogger, Controller, TimeHelper, LogsKeeper, 
//            ManifestHelper

class SingularLog
{

    private static final boolean LOG_TO_CONSOLE = false;
    private Controller controller;
    private CountersLogger countersLogger;
    private LogsKeeper logsKeeper;
    private boolean outputToDeveloper;

    SingularLog()
    {
        outputToDeveloper = false;
    }

    private void trackInternalException(String s, Throwable throwable)
    {
        try
        {
            if (countersLogger != null)
            {
                countersLogger.increaseCounter("exception_count");
            }
            if (controller != null)
            {
                controller.trackInternalException(s, throwable);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    protected void addToLogKeeper(String s, String s1, String s2, Throwable throwable)
    {
        JSONObject jsonobject;
        if (logsKeeper == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("event_timestamp_s", (new TimeHelper()).currentTimeSeconds());
            jsonobject.put("id", UUID.randomUUID().toString());
            jsonobject.put("level", s);
            jsonobject.put("tag", s1);
            jsonobject.put("message", s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        jsonobject.put("stacktrace", Log.getStackTraceString(throwable));
        logsKeeper.addLine(jsonobject);
        return;
        s;
    }

    public void d(String s, String s1)
    {
        d(s, s1, null);
    }

    public void d(String s, String s1, Throwable throwable)
    {
        addToLogKeeper("d", s, s1, throwable);
    }

    public void e(String s, String s1)
    {
        addToLogKeeper("e", s, s1, null);
    }

    public void e(String s, String s1, Throwable throwable)
    {
        addToLogKeeper("e", s, s1, throwable);
    }

    public void forDeveloper(String s)
    {
        if (outputToDeveloper)
        {
            Log.i("singular_sdk", s);
        }
    }

    public void i(String s, String s1)
    {
        addToLogKeeper("i", s, s1, null);
    }

    public void initialize(ManifestHelper manifesthelper)
    {
        outputToDeveloper = manifesthelper.tryToGetManifestAttributeBool("net.singular.verbose", false);
    }

    public void setController(Controller controller1)
    {
        controller = controller1;
    }

    public void setCountersLogger(CountersLogger counterslogger)
    {
        countersLogger = counterslogger;
    }

    public void setLogsKeeper(LogsKeeper logskeeper)
    {
        logsKeeper = logskeeper;
    }

    public void trackError(String s, String s1)
    {
        trackError(s, s1, null);
    }

    public void trackError(String s, String s1, Throwable throwable)
    {
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        e(s, s1, throwable);
_L1:
        trackInternalException(s1, throwable);
        addToLogKeeper("trackError", s, s1, throwable);
        return;
        try
        {
            e(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
          goto _L1
    }

    public void trackInternalDebugEvent(String s, String s1)
    {
        trackInternalDebugEvent(s, s1, null);
    }

    public void trackInternalDebugEvent(String s, String s1, Throwable throwable)
    {
        try
        {
            if (controller != null)
            {
                controller.trackInternalDebugEvent(s, s1, throwable);
                addToLogKeeper("trackInternalDebugEvent", s, s1, throwable);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void v(String s, String s1)
    {
        addToLogKeeper("v", s, s1, null);
    }

    public void w(String s, String s1)
    {
        addToLogKeeper("w", s, s1, null);
    }
}
