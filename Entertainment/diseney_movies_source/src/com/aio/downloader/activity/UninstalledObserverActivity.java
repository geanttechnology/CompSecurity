// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UninstalledObserverActivity extends Activity
{

    private static final String TAG = "UninstalledObserverActivity";
    private int mObserverProcessPid;

    public UninstalledObserverActivity()
    {
        mObserverProcessPid = -1;
    }

    private String getUserSerial()
    {
        Object obj;
        obj = getSystemService("user");
        if (obj == null)
        {
            Log.e("UninstalledObserverActivity", "userManager not exsit !!!");
            return null;
        }
        long l;
        Object obj2 = android/os/Process.getMethod("myUserHandle", null).invoke(android/os/Process, null);
        l = ((Long)obj.getClass().getMethod("getSerialNumberForUser", new Class[] {
            obj2.getClass()
        }).invoke(obj, new Object[] {
            obj2
        })).longValue();
        return String.valueOf(l);
        Object obj1;
        obj1;
        Log.e("UninstalledObserverActivity", "", ((Throwable) (obj1)));
_L2:
        return null;
        obj1;
        Log.e("UninstalledObserverActivity", "", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        Log.e("UninstalledObserverActivity", "", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        Log.e("UninstalledObserverActivity", "", ((Throwable) (obj1)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    private native int init(String s);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            mObserverProcessPid = init(null);
            return;
        } else
        {
            mObserverProcessPid = init(getUserSerial());
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    static 
    {
        Log.d("UninstalledObserverActivity", "load lib --> uninstalled_observer");
        System.loadLibrary("uninstalled_observer");
    }
}
