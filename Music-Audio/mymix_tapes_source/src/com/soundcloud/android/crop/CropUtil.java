// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.soundcloud.android.crop.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.soundcloud.android.crop:
//            MonitoredActivity

class CropUtil
{
    private static class BackgroundJob extends MonitoredActivity.LifeCycleAdapter
        implements Runnable
    {

        private final MonitoredActivity mActivity;
        private final Runnable mCleanupRunner = new _cls1();
        private final ProgressDialog mDialog;
        private final Handler mHandler;
        private final Runnable mJob;

        public void onActivityDestroyed(MonitoredActivity monitoredactivity)
        {
            mCleanupRunner.run();
            mHandler.removeCallbacks(mCleanupRunner);
        }

        public void onActivityStarted(MonitoredActivity monitoredactivity)
        {
            mDialog.show();
        }

        public void onActivityStopped(MonitoredActivity monitoredactivity)
        {
            mDialog.hide();
        }

        public void run()
        {
            mJob.run();
            mHandler.post(mCleanupRunner);
            return;
            Exception exception;
            exception;
            mHandler.post(mCleanupRunner);
            throw exception;
        }



        public BackgroundJob(MonitoredActivity monitoredactivity, Runnable runnable, ProgressDialog progressdialog, Handler handler)
        {
            mActivity = monitoredactivity;
            mDialog = progressdialog;
            mJob = runnable;
            mActivity.addLifeCycleListener(this);
            mHandler = handler;
        }
    }


    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";

    CropUtil()
    {
    }

    public static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static boolean copyExifRotation(File file, File file1)
    {
        if (file == null || file1 == null)
        {
            return false;
        }
        try
        {
            file = new ExifInterface(file.getAbsolutePath());
            file1 = new ExifInterface(file1.getAbsolutePath());
            file1.setAttribute("Orientation", file.getAttribute("Orientation"));
            file1.saveAttributes();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("Error copying Exif data", file);
            return false;
        }
        return true;
    }

    public static int getExifRotation(File file)
    {
        if (file == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = (new ExifInterface(file.getAbsolutePath())).getAttributeInt("Orientation", 0);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("Error getting Exif data", file);
            return 0;
        }
        switch (i)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            return 0;

        case 3: // '\003'
            return 180;

        case 6: // '\006'
            return 90;

        case 8: // '\b'
            return 270;
        }
    }

    public static File getFromMediaUri(ContentResolver contentresolver, Uri uri)
    {
        if (uri != null) goto _L2; else goto _L1
_L1:
        uri = null;
_L12:
        return uri;
_L2:
        ContentResolver contentresolver1;
        ContentResolver contentresolver2;
        if ("file".equals(uri.getScheme()))
        {
            return new File(uri.getPath());
        }
        if (!"content".equals(uri.getScheme()))
        {
            break MISSING_BLOCK_LABEL_205;
        }
        contentresolver2 = null;
        contentresolver1 = null;
        contentresolver = contentresolver.query(uri, new String[] {
            "_data", "_display_name"
        }, null, null, null);
        if (contentresolver == null) goto _L4; else goto _L3
_L3:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        if (!contentresolver.moveToFirst()) goto _L4; else goto _L5
_L5:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        if (!uri.toString().startsWith("content://com.google.android.gallery3d")) goto _L7; else goto _L6
_L6:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        int i = contentresolver.getColumnIndex("_display_name");
_L8:
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        uri = contentresolver.getString(i);
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        if (TextUtils.isEmpty(uri))
        {
            break; /* Loop/switch isn't completed */
        }
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        File file = new File(uri);
        uri = file;
        if (contentresolver != null)
        {
            contentresolver.close();
            return file;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        i = contentresolver.getColumnIndex("_data");
        if (true) goto _L8; else goto _L4
_L4:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
_L10:
        return null;
        contentresolver;
        if (contentresolver1 != null)
        {
            contentresolver1.close();
        }
        if (true) goto _L10; else goto _L9
_L9:
        contentresolver;
        if (contentresolver2 != null)
        {
            contentresolver2.close();
        }
        throw contentresolver;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static void startBackgroundJob(MonitoredActivity monitoredactivity, String s, String s1, Runnable runnable, Handler handler)
    {
        (new Thread(new BackgroundJob(monitoredactivity, runnable, ProgressDialog.show(monitoredactivity, s, s1, true, false), handler))).start();
    }

    // Unreferenced inner class com/soundcloud/android/crop/CropUtil$BackgroundJob$1

/* anonymous class */
    class BackgroundJob._cls1
        implements Runnable
    {

        final BackgroundJob this$0;

        public void run()
        {
            mActivity.removeLifeCycleListener(BackgroundJob.this);
            if (mDialog.getWindow() != null)
            {
                mDialog.dismiss();
            }
        }

            
            {
                this$0 = BackgroundJob.this;
                super();
            }
    }

}
