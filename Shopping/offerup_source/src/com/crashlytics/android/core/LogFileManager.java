// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.Context;
import c.a.a.a.a.b.l;
import c.a.a.a.e;
import c.a.a.a.q;
import java.io.File;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            FileLogStore, QueueFileLogStore, ByteString

class LogFileManager
{

    private static final String DIRECTORY_NAME = "log-files";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    static final int MAX_LOG_SIZE = 0x10000;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore(null);
    private final Context context;
    private FileLogStore currentLog;
    private final File logFileDir;

    public LogFileManager(Context context1, File file)
    {
        this(context1, file, null);
    }

    public LogFileManager(Context context1, File file, String s)
    {
        context = context1;
        logFileDir = new File(file, "log-files");
        currentLog = NOOP_LOG_STORE;
        setCurrentSession(s);
    }

    private void ensureTargetDirectoryExists()
    {
        if (!logFileDir.exists())
        {
            logFileDir.mkdirs();
        }
    }

    private String getSessionIdForFile(File file)
    {
        file = file.getName();
        int i = file.lastIndexOf(".temp");
        if (i == -1)
        {
            return file;
        } else
        {
            return file.substring(20, i);
        }
    }

    private File getWorkingFileForSession(String s)
    {
        ensureTargetDirectoryExists();
        s = (new StringBuilder("crashlytics-userlog-")).append(s).append(".temp").toString();
        return new File(logFileDir, s);
    }

    private boolean isLoggingEnabled()
    {
        return l.a(context, "com.crashlytics.CollectCustomLogs", true);
    }

    public void clearLog()
    {
        currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set set)
    {
        File afile[] = logFileDir.listFiles();
        if (afile != null)
        {
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                File file = afile[i];
                if (!set.contains(getSessionIdForFile(file)))
                {
                    file.delete();
                }
            }

        }
    }

    public ByteString getByteStringForLog()
    {
        return currentLog.getLogAsByteString();
    }

    public final void setCurrentSession(String s)
    {
        currentLog.closeLogFile();
        currentLog = NOOP_LOG_STORE;
        if (s == null)
        {
            return;
        }
        if (!isLoggingEnabled())
        {
            e.d().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            return;
        } else
        {
            setLogFile(getWorkingFileForSession(s), 0x10000);
            return;
        }
    }

    void setLogFile(File file, int i)
    {
        currentLog = new QueueFileLogStore(file, i);
    }

    public void writeToLog(long l1, String s)
    {
        currentLog.writeToLog(l1, s);
    }


    private class NoopLogStore
        implements FileLogStore
    {

        public final void closeLogFile()
        {
        }

        public final void deleteLogFile()
        {
        }

        public final ByteString getLogAsByteString()
        {
            return null;
        }

        public final void writeToLog(long l1, String s)
        {
        }

        private NoopLogStore()
        {
        }

        NoopLogStore(_cls1 _pcls1)
        {
            this();
        }
    }

}
