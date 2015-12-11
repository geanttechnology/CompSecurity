// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;

import android.util.Log;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLogger, LogsSender, ServerLogEntry

public class ServerLogger extends SupersonicLogger
{
    private class SendingCalc
    {

        private int DEFAULT_DEBUG_LEVEL;
        private int DEFAULT_SIZE;
        private int DEFAULT_TIME;
        final ServerLogger this$0;

        private boolean calc(int i)
        {
            while (error(i) || size() || time()) 
            {
                return true;
            }
            return false;
        }

        private boolean error(int i)
        {
            return i == 3;
        }

        private void initDefaults()
        {
        }

        private boolean size()
        {
            return false;
        }

        private boolean time()
        {
            return false;
        }

        public void notifyEvent(int i)
        {
            if (calc(i))
            {
                send();
            }
        }

        public SendingCalc()
        {
            this$0 = ServerLogger.this;
            super();
            DEFAULT_SIZE = 1;
            DEFAULT_TIME = 1;
            DEFAULT_DEBUG_LEVEL = 3;
            initDefaults();
        }
    }


    public static final String NAME = "server";
    private final int SERVER_LOGS_SIZE_LIMIT;
    private ArrayList mLogs;

    public ServerLogger()
    {
        super("server");
        SERVER_LOGS_SIZE_LIMIT = 1000;
        mLogs = new ArrayList();
    }

    public ServerLogger(int i)
    {
        super("server", i);
        SERVER_LOGS_SIZE_LIMIT = 1000;
        mLogs = new ArrayList();
    }

    private void addLogEntry(ServerLogEntry serverlogentry)
    {
        this;
        JVM INSTR monitorenter ;
        mLogs.add(serverlogentry);
        if (!shouldSendLogs()) goto _L2; else goto _L1
_L1:
        send();
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i = mLogs.size();
        if (i <= 1000)
        {
            continue; /* Loop/switch isn't completed */
        }
        serverlogentry = new ArrayList();
        i = 500;
_L4:
        if (i >= mLogs.size())
        {
            break; /* Loop/switch isn't completed */
        }
        serverlogentry.add(mLogs.get(i));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            mLogs = serverlogentry;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (ServerLogEntry serverlogentry) { }
        finally
        {
            this;
        }
        mLogs = new ArrayList();
        if (true) goto _L6; else goto _L5
_L5:
        throw serverlogentry;
    }

    private String getTimestamp()
    {
        return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date()).toString();
    }

    private void send()
    {
        SupersonicUtils.createAndStartWorker(new LogsSender(mLogs), "LogsSender");
        mLogs = new ArrayList();
    }

    private boolean shouldSendLogs()
    {
        return ((ServerLogEntry)mLogs.get(mLogs.size() - 1)).getLogLevel() == 3;
    }

    public void log(SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        addLogEntry(new ServerLogEntry(supersonictag, getTimestamp(), s, i));
        this;
        JVM INSTR monitorexit ;
        return;
        supersonictag;
        throw supersonictag;
    }

    public void logException(SupersonicLogger.SupersonicTag supersonictag, String s, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        s = new StringBuilder(s);
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        s.append(":stacktrace[");
        s.append(Log.getStackTraceString(throwable)).append("]");
        addLogEntry(new ServerLogEntry(supersonictag, getTimestamp(), s.toString(), 3));
        this;
        JVM INSTR monitorexit ;
        return;
        supersonictag;
        throw supersonictag;
    }

}
