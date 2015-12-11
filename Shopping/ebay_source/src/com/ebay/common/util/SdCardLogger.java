// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class SdCardLogger extends Handler
    implements com.ebay.nautilus.kernel.util.FwLog.Logger
{

    private static final String LOG = "log";
    private static final String NEW_LINE = "\r\n";
    private static final String TAB = "\t";
    private static final String TIME_FORMAT = "kk:mm:ss";
    private static SdCardLogger instance;
    private static FileOutputStream output;

    private SdCardLogger(Looper looper)
    {
        super(looper);
        try
        {
            looper = DateFormat.format("MM-dd", new Date());
            Object obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/ebay-log/").toString();
            (new File(((String) (obj)))).mkdirs();
            obj = new StringBuilder(((String) (obj)));
            ((StringBuilder) (obj)).append(looper);
            ((StringBuilder) (obj)).append(".txt");
            output = new FileOutputStream(((StringBuilder) (obj)).toString(), true);
            FwLog.setAlternateLogger(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Looper looper)
        {
            Log.e(com/ebay/common/util/SdCardLogger.getSimpleName(), looper.getLocalizedMessage(), looper);
        }
    }

    public static void initialize()
    {
        if (instance == null)
        {
            HandlerThread handlerthread = new HandlerThread("SdCardLogger");
            handlerthread.start();
            instance = new SdCardLogger(handlerthread.getLooper());
        }
    }

    public static void log(String s, String s1)
    {
        if (instance == null || output == null)
        {
            Log.e(com/ebay/common/util/SdCardLogger.getSimpleName(), "logger is not initialized");
            return;
        } else
        {
            instance.println(3, s, s1);
            return;
        }
    }

    public void handleMessage(Message message)
    {
        try
        {
            output.write(message.getData().getString("log").getBytes());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e(com/ebay/common/util/SdCardLogger.getSimpleName(), message.getLocalizedMessage(), message);
        }
    }

    public void println(int i, String s, String s1)
    {
        s1 = (new StringBuilder()).append(DateFormat.format("kk:mm:ss", new Date())).append("\t").append(s).append("\t").append(s1).append("\r\n").toString();
        s = new Bundle();
        s.putString("log", s1);
        s1 = obtainMessage();
        s1.setData(s);
        sendMessage(s1);
    }
}
