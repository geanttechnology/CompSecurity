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

    protected static final transient void executeAsyncTaskWithThreadPooling(AsyncTask asynctask, Object aobj[])
    {
        asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
    }

    protected static void hideActionAndStatusBars(Activity activity)
    {
        ActionBar actionbar = activity.getActionBar();
        if (actionbar != null)
        {
            actionbar.hide();
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(4);
    }

    public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException sqliteexception)
    {
        return sqliteexception instanceof SQLiteDatabaseLockedException;
    }

    protected static void webViewOnPause(WebView webview)
    {
        webview.onPause();
    }

    protected static void webViewOnResume(WebView webview)
    {
        webview.onResume();
    }

    private ()
    {
    }
}
