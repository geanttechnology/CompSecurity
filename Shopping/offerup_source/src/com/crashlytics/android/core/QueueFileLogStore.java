// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import c.a.a.a.a.b.ab;
import c.a.a.a.a.b.l;
import c.a.a.a.e;
import c.a.a.a.q;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package com.crashlytics.android.core:
//            FileLogStore, ByteString

class QueueFileLogStore
    implements FileLogStore
{

    private ab logFile;
    private final int maxLogSize;
    private final File workingFile;

    public QueueFileLogStore(File file, int i)
    {
        workingFile = file;
        maxLogSize = i;
    }

    private void doWriteToLog(long l1, String s)
    {
        if (logFile != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (s == null)
        {
            s = "null";
        }
        String s1;
        int i;
        try
        {
            i = maxLogSize / 4;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e.d().c("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", s);
            return;
        }
        s1 = s;
        if (s.length() > i)
        {
            s1 = (new StringBuilder("...")).append(s.substring(s.length() - i)).toString();
        }
        s = s1.replaceAll("\r", " ").replaceAll("\n", " ");
        s = String.format(Locale.US, "%d %s%n", new Object[] {
            Long.valueOf(l1), s
        }).getBytes("UTF-8");
        logFile.a(s);
        while (!logFile.b() && logFile.a() > maxLogSize) 
        {
            logFile.c();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void openLogFile()
    {
        if (logFile != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        logFile = new ab(workingFile);
        return;
        IOException ioexception;
        ioexception;
        e.d().c("CrashlyticsCore", (new StringBuilder("Could not open log file: ")).append(workingFile).toString(), ioexception);
        return;
    }

    public void closeLogFile()
    {
        l.a(logFile, "There was a problem closing the Crashlytics log file.");
        logFile = null;
    }

    public void deleteLogFile()
    {
        closeLogFile();
        workingFile.delete();
    }

    public ByteString getLogAsByteString()
    {
        if (workingFile.exists())
        {
            openLogFile();
            if (logFile != null)
            {
                final int offsetHolder[] = new int[1];
                offsetHolder[0] = 0;
                final byte logBytes[] = new byte[logFile.a()];
                try
                {
                    logFile.a(new _cls1());
                }
                catch (IOException ioexception)
                {
                    e.d().c("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", ioexception);
                }
                return ByteString.copyFrom(logBytes, 0, offsetHolder[0]);
            }
        }
        return null;
    }

    public void writeToLog(long l1, String s)
    {
        openLogFile();
        doWriteToLog(l1, s);
    }

    private class _cls1
        implements af
    {

        final QueueFileLogStore this$0;
        final byte val$logBytes[];
        final int val$offsetHolder[];

        public void read(InputStream inputstream, int i)
        {
            int ai[];
            inputstream.read(logBytes, offsetHolder[0], i);
            ai = offsetHolder;
            ai[0] = ai[0] + i;
            inputstream.close();
            return;
            Exception exception;
            exception;
            inputstream.close();
            throw exception;
        }

        _cls1()
        {
            this$0 = QueueFileLogStore.this;
            logBytes = abyte0;
            offsetHolder = ai;
            super();
        }
    }

}
