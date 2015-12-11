// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.crittercism.app.Crittercism;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClientService, ByteCountedOutputStream, LogClientUploader, LogFileSpec, 
//            LogPurger

public class LogClient
{
    public static interface ClientListener
    {

        public abstract int getNextPackageNumber();

        public abstract void onLogCreate(long l, String s, ByteCountedOutputStream bytecountedoutputstream)
            throws IOException;
    }

    protected class CloseAndUploadTimerTask extends TimerTask
    {

        final LogClient this$0;

        public void run()
        {
            closeLogAndQueueForUpload();
        }

        protected CloseAndUploadTimerTask()
        {
            this$0 = LogClient.this;
            super();
        }
    }

    protected class WriterRunnable
        implements Runnable
    {

        private final byte bytesToWrite[];
        private boolean scheduleUpload;
        final LogClient this$0;

        public void run()
        {
            LogClient logclient = LogClient.this;
            logclient;
            JVM INSTR monitorenter ;
            if (countedOutputStream == null || countedOutputStream.getByteCount() + (long)bytesToWrite.length <= 64512L) goto _L2; else goto _L1
_L1:
            if (!scheduleUpload) goto _L4; else goto _L3
_L3:
            closeLogAndQueueForUpload();
_L2:
            if (countedOutputStream != null) goto _L6; else goto _L5
_L5:
            LogFileSpec logfilespec;
            StringBuilder stringbuilder;
            timestamp = Long.valueOf(System.currentTimeMillis());
            logfilespec = spec;
            stringbuilder = (new StringBuilder()).append(Long.toString(timestamp.longValue()));
            if (clientListener == null) goto _L8; else goto _L7
_L7:
            Object obj = (new StringBuilder()).append("_").append(clientListener.getNextPackageNumber()).toString();
_L9:
            obj = logfilespec.createFileName(stringbuilder.append(((String) (obj))).toString());
            tmpFileName = (new StringBuilder()).append(((String) (obj))).append(".").append("tmp").toString();
            countedOutputStream = new ByteCountedOutputStream(application.openFileOutput(tmpFileName, 0));
            Log.d(com/groupon/tracking/mobile/internal/LogClient.getName(), (new StringBuilder()).append("Creating new file ").append(tmpFileName).toString());
            if (clientListener != null)
            {
                clientListener.onLogCreate(timestamp.longValue(), tmpFileName, countedOutputStream);
            }
_L6:
            countedOutputStream.write(bytesToWrite);
            countedOutputStream.flush();
            if (scheduleUpload && timer == null)
            {
                timer = new Timer();
                timer.schedule(new CloseAndUploadTimerTask(), 0x1d4c0L);
            }
_L10:
            return;
_L4:
            closeLog();
              goto _L2
            obj;
            logclient;
            JVM INSTR monitorexit ;
            throw obj;
_L8:
            obj = "";
              goto _L9
            IOException ioexception;
            ioexception;
            closeLogAndQueueForUpload();
            (new LogPurger(application, spec)).purge();
              goto _L10
        }

        public WriterRunnable(byte abyte0[], boolean flag)
        {
            this$0 = LogClient.this;
            super();
            bytesToWrite = abyte0;
            scheduleUpload = flag;
        }
    }


    private static final long MAX_LOG_DURATION = 0x1d4c0L;
    private static final long MAX_LOG_SIZE = 64512L;
    private static final long MAX_TEMP_FILE_AGE_MS = 0x240c8400L;
    private static final String MOBILE_EVENT_TMP_EXTENSION = "tmp";
    private Application application;
    private ClientListener clientListener;
    private ByteCountedOutputStream countedOutputStream;
    private LogClientUploader logClientUploader;
    private Executor logExecutor;
    private LogFileSpec spec;
    private boolean testMode;
    private Timer timer;
    private Long timestamp;
    private String tmpFileName;

    public LogClient()
    {
        logExecutor = Executors.newSingleThreadExecutor();
    }

    private void init()
    {
        Ln.d("NST LogClient.init", new Object[0]);
        cleanUpLogFiles();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 3);
        calendar.set(12, (new Random()).nextInt(60));
        calendar.add(10, (new Random()).nextInt(3));
        if (calendar.getTime().before(new Date()))
        {
            calendar.add(7, 1);
        }
        PendingIntent pendingintent = PendingIntent.getService(application, 0, new Intent(application, com/groupon/tracking/mobile/internal/LogClientService), 0x8000000);
        AlarmManager alarmmanager = (AlarmManager)application.getSystemService("alarm");
        long l = 0x5265c00L;
        if (testMode)
        {
            calendar.setTimeInMillis(System.currentTimeMillis() + 5000L);
            l = 10000L;
        }
        alarmmanager.setInexactRepeating(1, calendar.getTimeInMillis(), l, pendingintent);
    }

    protected void cleanUpLogFiles()
    {
        FilenameFilter filenamefilter = new FilenameFilter() {

            final LogClient this$0;
            final LogFileSpec tmpFileSpec;

            public boolean accept(File file1, String s)
            {
                return tmpFileSpec.matchesSpec(s);
            }

            
            {
                this$0 = LogClient.this;
                super();
                tmpFileSpec = new LogFileSpec(spec.getPrefix(), (new StringBuilder()).append(spec.getExtension()).append(".").append("tmp").toString());
            }
        };
        File afile[] = application.getFilesDir().listFiles(filenamefilter);
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            Ln.d("Found left-behind log file: %s. Renaming for upload.", new Object[] {
                file.getName()
            });
            if (!renameTempToFinal(file) && System.currentTimeMillis() - file.lastModified() > 0x240c8400L && !file.delete())
            {
                logToCrittercism((new StringBuilder()).append("LogClient: Could not delete ").append(file.getName()).toString());
            }
        }

    }

    protected void closeLog()
    {
        this;
        JVM INSTR monitorenter ;
        ByteCountedOutputStream bytecountedoutputstream;
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
        bytecountedoutputstream = countedOutputStream;
        if (bytecountedoutputstream == null) goto _L2; else goto _L1
_L1:
        countedOutputStream.close();
_L3:
        Log.d(com/groupon/tracking/mobile/internal/LogClient.getName(), (new StringBuilder()).append("Closing for upload ").append(tmpFileName).toString());
        renameTempToFinal(new File(application.getFilesDir(), tmpFileName));
_L2:
        timestamp = null;
        tmpFileName = null;
        countedOutputStream = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Ln.e(((Throwable) (obj)));
          goto _L3
        obj;
        throw obj;
    }

    protected void closeLogAndQueueForUpload()
    {
        this;
        JVM INSTR monitorenter ;
        Ln.d("NST closeLogAndQueueForUpload", new Object[0]);
        closeLog();
        logClientUploader.uploadFiles();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected String finalFileName(String s)
    {
        String s1 = s;
        if (s.endsWith(".tmp"))
        {
            int i = ".tmp".length();
            s1 = s.substring(0, s.length() - i);
        }
        return s1;
    }

    public void forceRotateLog()
    {
        logExecutor.execute(new CloseAndUploadTimerTask());
    }

    public String getNstUrl()
    {
        return logClientUploader.url;
    }

    public boolean isTestMode()
    {
        return testMode;
    }

    protected void logToCrittercism(String s)
    {
        Crittercism.logHandledException(new IOException(s));
        Ln.e(s, new Object[0]);
    }

    protected boolean renameTempToFinal(File file)
    {
        String s = finalFileName(file.getName());
        File file1 = new File(file.getParentFile(), s);
        boolean flag = file.renameTo(file1);
        if (!flag)
        {
            logToCrittercism((new StringBuilder()).append("LogClient: Could not rename ").append(s).append(" to ").append(file1.getName()).toString());
        }
        return flag;
    }

    public void setNstUrl(String s)
    {
        logClientUploader.url = s;
    }

    public void setTestMode(boolean flag)
    {
        testMode = flag;
        init();
    }

    public void write(byte abyte0[], boolean flag)
    {
        logExecutor.execute(new WriterRunnable(abyte0, flag));
    }




/*
    static ByteCountedOutputStream access$102(LogClient logclient, ByteCountedOutputStream bytecountedoutputstream)
    {
        logclient.countedOutputStream = bytecountedoutputstream;
        return bytecountedoutputstream;
    }

*/



/*
    static Long access$202(LogClient logclient, Long long1)
    {
        logclient.timestamp = long1;
        return long1;
    }

*/




/*
    static String access$402(LogClient logclient, String s)
    {
        logclient.tmpFileName = s;
        return s;
    }

*/




/*
    static Timer access$602(LogClient logclient, Timer timer1)
    {
        logclient.timer = timer1;
        return timer1;
    }

*/
}
