// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageButton;

class AndroidTargetUtils
{
    private static class EclairTargetUtils
    {

        protected static BitmapDrawable getNewBitmapDrawable(Resources resources, String s)
        {
            return new BitmapDrawable(resources, s);
        }

        private EclairTargetUtils()
        {
        }
    }

    private static class FroyoTargetUtils
    {

        protected static String getPackageCodePath(Context context)
        {
            return context.getPackageCodePath();
        }

        protected static int getRotation(Display display)
        {
            return display.getRotation();
        }

        private FroyoTargetUtils()
        {
        }
    }

    private static class GingerbreadTargetUtils
    {

        protected static void editorApply(android.content.SharedPreferences.Editor editor)
        {
            editor.apply();
        }

        private GingerbreadTargetUtils()
        {
        }
    }

    private static class HoneycombTargetUtils
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

        private HoneycombTargetUtils()
        {
        }
    }

    private static class JellyBeanTargetUtils
    {

        public static void setBackgroundForLinerLayout(View view, Drawable drawable)
        {
            view.setBackground(drawable);
        }

        protected static void setImageButtonAlpha(ImageButton imagebutton, int i)
        {
            imagebutton.setImageAlpha(i);
        }

        private JellyBeanTargetUtils()
        {
        }
    }


    private AndroidTargetUtils()
    {
    }

    public static final void disableHardwareAcceleration(View view)
    {
        HoneycombTargetUtils.disableHardwareAcceleration(view);
    }

    public static void editorApply(android.content.SharedPreferences.Editor editor)
    {
        GingerbreadTargetUtils.editorApply(editor);
    }

    public static transient void executeAsyncTask(AsyncTask asynctask, Object aobj[])
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(asynctask, aobj);
            return;
        } else
        {
            asynctask.execute(aobj);
            return;
        }
    }

    public static BitmapDrawable getNewBitmapDrawable(Resources resources, String s)
    {
        if (isAtLeastAndroidAPI(5))
        {
            return EclairTargetUtils.getNewBitmapDrawable(resources, s);
        } else
        {
            return new BitmapDrawable(s);
        }
    }

    public static int getOrientation(Display display)
    {
        if (isAtLeastAndroidAPI(8))
        {
            return FroyoTargetUtils.getRotation(display);
        } else
        {
            return display.getOrientation();
        }
    }

    public static String getPackageCodePath(Context context)
    {
        return FroyoTargetUtils.getPackageCodePath(context);
    }

    public static void hideActionAndStatusBars(Activity activity)
    {
        HoneycombTargetUtils.hideActionAndStatusBars(activity);
    }

    public static boolean isAtLeastAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException sqliteexception)
    {
        return HoneycombTargetUtils.isInstanceOfSQLiteDatabaseLockedException(sqliteexception);
    }

    public static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (isAtLeastAndroidAPI(16))
        {
            JellyBeanTargetUtils.setBackgroundForLinerLayout(view, drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void setImageButtonAlpha(ImageButton imagebutton, int i)
    {
        if (isAtLeastAndroidAPI(16))
        {
            JellyBeanTargetUtils.setImageButtonAlpha(imagebutton, i);
            return;
        } else
        {
            imagebutton.setAlpha(i);
            return;
        }
    }

    public static void webViewOnPause(WebView webview)
    {
        HoneycombTargetUtils.webViewOnPause(webview);
    }

    public static void webViewOnResume(WebView webview)
    {
        HoneycombTargetUtils.webViewOnResume(webview);
    }
}
