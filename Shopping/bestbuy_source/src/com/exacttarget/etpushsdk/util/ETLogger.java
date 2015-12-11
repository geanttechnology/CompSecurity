// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.exacttarget.etpushsdk.ETPush;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BackgroundEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            n, m, h, EventBus

public class ETLogger
    implements BackgroundEventListener
{

    private static final String LOG_FILE_NAME = "JB4A-SDK-log.log";
    private static final long MIN_FILE_SIZE = 25000L;
    private static final long MIN_MEMORY_SIZE = 4096L;
    private static final String TAG = "~ETLogger";
    private static final String TEMP_LOG_FILE_NAME = "JB4A-SDK-log-temp.log";
    private static Context appContext;
    private static boolean captureInProgress = false;
    private static final StringBuilder inMemoryLog = new StringBuilder();
    private static final Object loggerSynchronization = new Object();
    private static long maxFileSize;
    private static long maxMemorySize;
    private static final ETLogger sInstance = new ETLogger();
    private final Thread captureLogThread = new Thread();

    private ETLogger()
    {
    }

    private String addVersionInfo()
    {
        if (appContext != null)
        {
            return (new StringBuilder()).append(String.format("App Version: %s (%d) SDK Version: %s (%d) Package: %s", new Object[] {
                n.d(appContext), Integer.valueOf(n.c(appContext)), ETPush.getSdkVersionName(), Integer.valueOf(ETPush.getSdkVersionCode()), appContext.getPackageName()
            })).append(System.getProperty("line.separator")).toString();
        } else
        {
            return "";
        }
    }

    private static void copyFile(File file, File file1)
    {
        if (!file1.exists() && !file1.createNewFile())
        {
            System.out.println((new StringBuilder()).append("Problem creating file: ").append(file1.getAbsolutePath()).toString());
        }
        file = (new FileInputStream(file)).getChannel();
        file1 = (new FileOutputStream(file1)).getChannel();
        file1.transferFrom(file, 0L, file.size());
        System.out.println((new StringBuilder()).append("Transferred: ").append(file1.size()).toString());
        file.close();
        file1.close();
    }

    private void flushLogToFile(String s)
    {
        try
        {
            if (!TextUtils.isEmpty(s))
            {
                inMemoryLog.append(formatLogLine("~ETLogger", s));
            }
            inMemoryLog.append(addVersionInfo());
            s = inMemoryLog.toString();
            inMemoryLog.setLength(0);
            logFileReset(s.length());
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(appContext.openFileOutput("JB4A-SDK-log.log", 32768));
            outputstreamwriter.append(s);
            outputstreamwriter.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("~ETLogger", "Problem flushing logging data to file.");
        }
    }

    private String formatLogDate(long l)
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US)).format(new Date(l));
    }

    private String formatLogLine(String s, String s1)
    {
        return (new StringBuilder()).append(String.format("%s %-25s %s", new Object[] {
            formatLogDate(System.currentTimeMillis()), s, s1
        })).append(System.getProperty("line.separator")).toString();
    }

    public static ETLogger getInstance()
    {
        return sInstance;
    }

    private void logFileReset(long l)
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        boolean flag;
        obj4 = null;
        obj = null;
        obj2 = null;
        obj6 = null;
        obj5 = null;
        obj3 = null;
        flag = true;
        if (l != 0L) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        File file;
        obj1 = appContext.getFileStreamPath("JB4A-SDK-log.log");
        file = appContext.getFileStreamPath("JB4A-SDK-log-temp.log");
        if (!((File) (obj1)).exists())
        {
            break MISSING_BLOCK_LABEL_466;
        }
        obj1 = (new FileInputStream(((File) (obj1)))).getChannel();
        obj3 = obj1;
        obj = obj2;
        obj4 = obj6;
        if (((FileChannel) (obj1)).size() + l <= maxFileSize) goto _L4; else goto _L3
_L3:
        obj3 = obj1;
        obj = obj2;
        obj4 = obj6;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        obj3 = obj1;
        obj = obj2;
        obj4 = obj6;
        if (file.delete())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        obj3 = obj1;
        obj = obj2;
        obj4 = obj6;
        m.d("~ETLogger", String.format("Problem deleting file: %1$s", new Object[] {
            file.getAbsolutePath()
        }));
        obj3 = obj1;
        obj = obj2;
        obj4 = obj6;
        obj2 = (new FileOutputStream(file)).getChannel();
        obj3 = obj1;
        obj = obj2;
        obj4 = obj2;
        l = ((FileChannel) (obj1)).transferTo(l, 0x7fffffffffffffffL, ((java.nio.channels.WritableByteChannel) (obj2)));
        obj5 = obj2;
        if (l <= 0L) goto _L4; else goto _L5
_L5:
        if (obj1 != null)
        {
            try
            {
                ((FileChannel) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                System.out.println(((Exception) (obj)).getMessage());
                return;
            }
        }
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((FileChannel) (obj2)).close();
        if (!flag) goto _L1; else goto _L6
_L6:
        obj = appContext.getFileStreamPath("JB4A-SDK-log.log");
        obj1 = appContext.getFileStreamPath("JB4A-SDK-log-temp.log");
        if (!((File) (obj)).delete())
        {
            m.d("~ETLogger", String.format("Problem deleting file: %1$s", new Object[] {
                ((File) (obj)).getAbsolutePath()
            }));
        }
        copyFile(((File) (obj1)), ((File) (obj)));
        if (!((File) (obj1)).delete())
        {
            m.d("~ETLogger", String.format("Problem deleting file: %1$s", new Object[] {
                ((File) (obj1)).getAbsolutePath()
            }));
            return;
        }
          goto _L1
        obj2;
        obj1 = null;
_L10:
        obj3 = obj1;
        obj = obj4;
        System.out.println(((Exception) (obj2)).getMessage());
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((FileChannel) (obj1)).close();
        if (obj4 == null) goto _L1; else goto _L7
_L7:
        try
        {
            ((FileChannel) (obj4)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            System.out.println(((Exception) (obj)).getMessage());
        }
        return;
        obj1;
        obj3 = null;
_L9:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        ((FileChannel) (obj3)).close();
        if (obj != null)
        {
            try
            {
                ((FileChannel) (obj)).close();
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
        throw obj1;
        obj1;
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
          goto _L10
_L4:
        flag = false;
        obj2 = obj5;
          goto _L5
        flag = false;
        obj1 = null;
        obj2 = obj3;
          goto _L5
    }

    protected transient void captureLog(String s, String s1, Object aobj[])
    {
        if (!isCaptureInProgress())
        {
            return;
        }
        synchronized (loggerSynchronization)
        {
            (new Thread(new h(this, aobj, s1, s))).start();
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean emailLogFile(Activity activity, String as[], String s, String s1)
    {
        File file;
        Object obj;
        obj = appContext.getFileStreamPath("JB4A-SDK-log.log");
        file = new File((new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)).append("/").append("JB4A-SDK-log.log").toString());
        if (!file.exists() || file.delete())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        m.d("~ETLogger", String.format("Problem deleting file: %1$s", new Object[] {
            file.getAbsolutePath()
        }));
        return false;
        try
        {
            flushLogToFile(String.format("Sending log via email to: %1$s", new Object[] {
                Arrays.toString(as)
            }));
            copyFile(((File) (obj)), file);
            obj = new Intent("android.intent.action.SEND_MULTIPLE");
            ((Intent) (obj)).setType("plain/text");
            ((Intent) (obj)).putExtra("android.intent.extra.EMAIL", as);
            ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", s);
            ((Intent) (obj)).putExtra("android.intent.extra.TEXT", s1);
            as = new ArrayList();
            as.add(Uri.fromFile(file));
            ((Intent) (obj)).putParcelableArrayListExtra("android.intent.extra.STREAM", as);
            activity.startActivity(Intent.createChooser(((Intent) (obj)), "Send Log Using:"));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            m.c("~ETLogger", activity.getMessage(), activity);
            return false;
        }
        return true;
    }

    public void get()
    {
        captureInProgress = false;
        flushLogToFile("Stop capture requests.  Flushing log.");
        EventBus.getInstance().unregister(this);
    }

    public StringBuilder getInMemoryLog()
    {
        return inMemoryLog;
    }

    public String getLogFilePath(Context context)
    {
        return context.getFileStreamPath("JB4A-SDK-log.log").getAbsolutePath();
    }

    public boolean isCaptureInProgress()
    {
        return captureInProgress;
    }

    public void onEvent(BackgroundEvent backgroundevent)
    {
        if (backgroundevent.isInBackground() && isCaptureInProgress())
        {
            flushLogToFile("App sent to background, so flush log");
        }
    }

    public boolean startCapture(Context context, long l, long l1, boolean flag)
    {
        appContext = context;
        if (l < 4096L)
        {
            m.d("~ETLogger", String.format("maxMemorySize must be over %1$d", new Object[] {
                Long.valueOf(4096L)
            }));
            return false;
        }
        if (l1 < 25000L)
        {
            m.d("~ETLogger", String.format("maxFileSize must be over %1$d", new Object[] {
                Long.valueOf(25000L)
            }));
            return false;
        }
        if (l > l1)
        {
            m.d("~ETLogger", "maxMemorySize must be less than maxFileSize");
            return false;
        }
        maxMemorySize = l;
        maxFileSize = l1;
        captureInProgress = true;
        inMemoryLog.setLength(0);
        if (flag)
        {
            context = appContext.getFileStreamPath("JB4A-SDK-log.log");
            if (context.exists() && !context.delete())
            {
                m.d("~ETLogger", String.format("Problem deleting file: %1$s", new Object[] {
                    context.getAbsolutePath()
                }));
            }
        }
        EventBus.getInstance().register(this);
        return true;
    }

    public void stopCapture()
    {
        captureInProgress = false;
        flushLogToFile("Stop capture requests.  Flushing log.");
        EventBus.getInstance().unregister(this);
    }






}
