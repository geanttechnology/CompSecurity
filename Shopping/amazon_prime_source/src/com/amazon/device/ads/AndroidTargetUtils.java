// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.ImageButton;

// Referenced classes of package com.amazon.device.ads:
//            AndroidBuildInfo, StringUtils, ThreadUtils

class AndroidTargetUtils
{
    public static class AndroidClassAdapter
    {

        private final AndroidBuildInfo androidBuildInfo;

        private boolean isAtLeastAndroidAPI(int i)
        {
            return AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, i);
        }

        public WebSettingsAdapter withWebSettings(WebSettings websettings)
        {
            return new WebSettingsAdapter(websettings);
        }


        public AndroidClassAdapter(AndroidBuildInfo androidbuildinfo)
        {
            androidBuildInfo = androidbuildinfo;
        }
    }

    public class AndroidClassAdapter.WebSettingsAdapter
    {

        final AndroidClassAdapter this$0;
        private final WebSettings webSettings;

        public void setMediaPlaybackRequiresUserGesture(boolean flag)
        {
            if (isAtLeastAndroidAPI(17))
            {
                JellyBeanMR1TargetUtils.setMediaPlaybackRequiresUserGesture(webSettings, flag);
            }
        }

        public AndroidClassAdapter.WebSettingsAdapter(WebSettings websettings)
        {
            this$0 = AndroidClassAdapter.this;
            super();
            webSettings = websettings;
        }
    }

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

        protected static void enableHardwareAcceleration(Window window)
        {
            window.setFlags(0x1000000, 0x1000000);
        }

        protected static final transient void executeAsyncTaskWithThreadPooling(ThreadUtils.MobileAdsAsyncTask mobileadsasynctask, Object aobj[])
        {
            mobileadsasynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
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

        private HoneycombTargetUtils()
        {
        }
    }

    private static class JellyBeanMR1TargetUtils
    {

        public static void setMediaPlaybackRequiresUserGesture(WebSettings websettings, boolean flag)
        {
            websettings.setMediaPlaybackRequiresUserGesture(flag);
        }

        private JellyBeanMR1TargetUtils()
        {
        }
    }

    private static class JellyBeanTargetUtils
    {

        public static void hideStatusBar(Activity activity)
        {
            activity.getWindow().getDecorView().setSystemUiVisibility(4);
        }

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

    private static class KitKatTargetUtils
    {

        public static void enableWebViewDebugging(boolean flag)
        {
            ThreadUtils.executeOnMainThread(new Runnable(flag) {

                final boolean val$enable;

                public void run()
                {
                    WebView.setWebContentsDebuggingEnabled(enable);
                }

            
            {
                enable = flag;
                super();
            }
            });
        }

        private KitKatTargetUtils()
        {
        }
    }


    public static final AndroidClassAdapter defaultAndroidClassAdapter = new AndroidClassAdapter(new AndroidBuildInfo());
    private static boolean isWebViewCheckedAndOk = false;

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

    public static void enableHardwareAcceleration(Window window)
    {
        if (isAtLeastAndroidAPI(11))
        {
            HoneycombTargetUtils.enableHardwareAcceleration(window);
        }
    }

    public static void enableWebViewDebugging(boolean flag)
    {
        if (isAtLeastAndroidAPI(19))
        {
            KitKatTargetUtils.enableWebViewDebugging(flag);
        }
    }

    public static transient void executeAsyncTask(ThreadUtils.MobileAdsAsyncTask mobileadsasynctask, Object aobj[])
    {
        if (isAtLeastAndroidAPI(11))
        {
            HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(mobileadsasynctask, aobj);
            return;
        } else
        {
            mobileadsasynctask.execute(aobj);
            return;
        }
    }

    public static AndroidClassAdapter getDefaultAndroidClassAdapter()
    {
        return defaultAndroidClassAdapter;
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
        if (isAtLeastAndroidAPI(11))
        {
            HoneycombTargetUtils.hideActionBar(activity);
        }
        if (isAtLeastAndroidAPI(16))
        {
            JellyBeanTargetUtils.hideStatusBar(activity);
        }
    }

    public static boolean isAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT == i;
    }

    public static boolean isAndroidAPI(AndroidBuildInfo androidbuildinfo, int i)
    {
        return androidbuildinfo.getSDKInt() == i;
    }

    public static boolean isAtLeastAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean isAtLeastAndroidAPI(AndroidBuildInfo androidbuildinfo, int i)
    {
        return androidbuildinfo.getSDKInt() >= i;
    }

    public static boolean isAtOrBelowAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT <= i;
    }

    public static boolean isAtOrBelowAndroidAPI(AndroidBuildInfo androidbuildinfo, int i)
    {
        return androidbuildinfo.getSDKInt() <= i;
    }

    public static boolean isBetweenAndroidAPIs(AndroidBuildInfo androidbuildinfo, int i, int j)
    {
        return isAtLeastAndroidAPI(androidbuildinfo, i) && isAtOrBelowAndroidAPI(androidbuildinfo, j);
    }

    protected static boolean isDatabaseLocked(SQLiteException sqliteexception)
    {
        if (isAtLeastAndroidAPI(11))
        {
            return isInstanceOfSQLiteDatabaseLockedException(sqliteexception);
        } else
        {
            return StringUtils.doesExceptionContainLockedDatabaseMessage(sqliteexception);
        }
    }

    public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException sqliteexception)
    {
        return HoneycombTargetUtils.isInstanceOfSQLiteDatabaseLockedException(sqliteexception);
    }

    public static boolean isWebViewOk(Context context)
    {
        boolean flag = false;
        if (!isAtOrBelowAndroidAPI(8) || isWebViewCheckedAndOk) goto _L2; else goto _L1
_L1:
        if (WebViewDatabase.getInstance(context) != null) goto _L4; else goto _L3
_L3:
        return flag;
_L4:
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context != null)
        {
            context.close();
        }
        isWebViewCheckedAndOk = true;
_L2:
        return true;
        context;
        flag = isDatabaseLocked(context);
        if (true) goto _L3; else goto _L5
_L5:
        throw new NullPointerException();
        context;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw context;
        }
    }

    public static void removeJavascriptInterface(WebView webview, String s)
    {
        HoneycombTargetUtils.removeJavascriptInterface(webview, s);
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

}
