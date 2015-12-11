// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils

private static class 
{

    public static final void disableHardwareAcceleration(View view)
    {
        view.setLayerType(1, null);
    }

    protected static void enableHardwareAcceleration(Window window)
    {
        window.setFlags(0x1000000, 0x1000000);
    }

    protected static final transient void executeAsyncTaskWithThreadPooling( , Object aobj[])
    {
        .Executor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
    }

    protected static void hideActionBar(Activity activity)
    {
        activity = activity.getActionBar();
        if (activity != null)
        {
            activity.hide();
        }
    }

    public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException sqliteexception)
    {
        return sqliteexception instanceof SQLiteDatabaseLockedException;
    }

    protected static void removeJavascriptInterface(WebView webview, String s)
    {
        webview.removeJavascriptInterface(s);
    }

    private ()
    {
    }
}
