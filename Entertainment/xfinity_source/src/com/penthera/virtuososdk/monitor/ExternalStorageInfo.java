// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Vector;

public class ExternalStorageInfo extends BroadcastReceiver
{
    public static interface IExternalStorageObserver
    {

        public abstract void onExternalStorageStateChange(String s);
    }


    private static SoftReference iInstance;
    private static final String iSuffixArray[] = {
        "bytes", "KB", "MB", "GB"
    };
    private final String LOG_TAG = com/penthera/virtuososdk/monitor/ExternalStorageInfo.getName();
    double iBytesFree;
    private Vector iObservers;
    int iPercentFree;
    private StatFs iStat;
    String iStorageState;
    double iTotalBytes;

    private ExternalStorageInfo()
    {
        iStat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        iObservers = null;
        iObservers = new Vector();
        reset();
        update();
    }

    public static ExternalStorageInfo getInstance()
    {
        ExternalStorageInfo externalstorageinfo = null;
        if (iInstance != null)
        {
            externalstorageinfo = (ExternalStorageInfo)iInstance.get();
        }
        ExternalStorageInfo externalstorageinfo1 = externalstorageinfo;
        if (externalstorageinfo == null)
        {
            externalstorageinfo1 = new ExternalStorageInfo();
            iInstance = new SoftReference(externalstorageinfo1);
        }
        return externalstorageinfo1;
    }

    private void notifyObservers(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = iObservers.iterator();
_L1:
        boolean flag = iterator.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ((IExternalStorageObserver)iterator.next()).onExternalStorageStateChange(s);
          goto _L1
        s;
        throw s;
    }

    private void reset()
    {
        iTotalBytes = 0.0D;
        iBytesFree = 0.0D;
        iPercentFree = 0;
    }

    public boolean isMounted()
    {
        return "mounted".equals(iStorageState);
    }

    public boolean isWritable()
    {
        Object obj;
        File file;
        obj = new StringBuilder();
        file = Environment.getExternalStorageDirectory();
        if (file == null)
        {
            return false;
        }
        ((StringBuilder) (obj)).append(file.getAbsolutePath());
        ((StringBuilder) (obj)).append("/");
        ((StringBuilder) (obj)).append("virtuoso");
        ((StringBuilder) (obj)).append((new StringBuilder("/.irw")).append(System.currentTimeMillis()).toString());
        obj = new File(((StringBuilder) (obj)).toString());
        ((File) (obj)).createNewFile();
        ((File) (obj)).delete();
        boolean flag = true;
_L2:
        return flag;
        Exception exception;
        exception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        context = intent.getAction();
        if (!context.equals("android.intent.action.MEDIA_REMOVED")) goto _L2; else goto _L1
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "onReceive(): The sdcard has been unmounted: ");
        update();
        notifyObservers(Environment.getExternalStorageState());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!context.equals("android.intent.action.MEDIA_MOUNTED"))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, "onReceive(): The sdcard mounting has been restored: ");
        update();
        notifyObservers(Environment.getExternalStorageState());
          goto _L3
        context;
        throw context;
label0:
        {
            if (!context.equals("android.intent.action.MEDIA_SHARED"))
            {
                break label0;
            }
            update();
            notifyObservers(Environment.getExternalStorageState());
        }
          goto _L3
label1:
        {
            if (!context.equals("android.intent.action.MEDIA_UNMOUNTED"))
            {
                break label1;
            }
            update();
            notifyObservers(Environment.getExternalStorageState());
        }
          goto _L3
label2:
        {
            if (!context.equals("android.intent.action.MEDIA_BAD_REMOVAL"))
            {
                break label2;
            }
            update();
            notifyObservers(Environment.getExternalStorageState());
        }
          goto _L3
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("onReceive(): Received action we don't handle: ")).append(context).toString());
          goto _L3
    }

    public void update()
    {
        iStorageState = Environment.getExternalStorageState();
        if (!iStorageState.equals("mounted"))
        {
            reset();
        } else
        {
            iStat.restat(Environment.getExternalStorageDirectory().getPath());
            float f = iStat.getBlockSize();
            iTotalBytes = (float)iStat.getBlockCount() * f;
            iBytesFree = (float)iStat.getAvailableBlocks() * f;
            if (iTotalBytes > 0.0D)
            {
                iPercentFree = (int)((iBytesFree * 100D) / iTotalBytes + 0.5D);
                return;
            }
        }
    }

}
