// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplication;
import com.poshmark.ui.fragments.CameraPreviewFragment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageUtils
{
    public static class BitmapDownloader extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        public CameraPreviewFragment callingFragment;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "ImageUtils$BitmapDownloader#doInBackground", null);
_L1:
            aobj = doInBackground((Uri[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ImageUtils$BitmapDownloader#doInBackground", null);
              goto _L1
        }

        protected transient String doInBackground(Uri auri[])
        {
            return ImageUtils.downloadBitmap(ImageUtils.generateFileName(), auri[0]);
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "ImageUtils$BitmapDownloader#onPostExecute", null);
_L1:
            onPostExecute((String)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ImageUtils$BitmapDownloader#onPostExecute", null);
              goto _L1
        }

        protected void onPostExecute(String s)
        {
            callingFragment.cropImage(s);
        }

        protected void onPreExecute()
        {
        }

        public BitmapDownloader(CameraPreviewFragment camerapreviewfragment)
        {
            callingFragment = camerapreviewfragment;
        }
    }


    public static final int defaultJPEGQuality = 95;

    public ImageUtils()
    {
    }

    private static void broadcastToMediaScanner()
    {
        try
        {
            File file = new File(getPictureDirectory());
            PMApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder()).append("file://").append(file).toString())));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int l = options.outHeight;
        int i1 = options.outWidth;
        int k = 1;
        if (l > j || i1 > i)
        {
            Math.round((float)l / (float)j);
            k = Math.round((float)i1 / (float)i);
        }
        return k;
    }

    public static Bitmap convertBase64StringToBitmap(String s)
    {
        s = Base64.decode(s, 2);
        return BitmapFactoryInstrumentation.decodeByteArray(s, 0, s.length);
    }

    public static String downloadBitmap(String s, Uri uri)
    {
        File file;
        byte abyte0[];
        int i;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            file = new File(Environment.getExternalStorageDirectory(), ".OCFL311");
        } else
        {
            file = PMApplication.getApplicationObject().getCacheDir();
        }
        if (!file.exists())
        {
            file.mkdirs();
        }
        file = new File(file, s);
        if (!uri.toString().startsWith("content://")) goto _L2; else goto _L1
_L1:
        s = PMApplication.getApplicationObject().getContentResolver().openInputStream(uri);
_L9:
        uri = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L5:
        i = s.read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        uri.write(abyte0, 0, i);
          goto _L5
_L6:
        return null;
_L2:
        try
        {
            s = (new URL(uri.toString())).openStream();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (true) goto _L6; else goto _L4
_L4:
        uri.close();
        if (file.length() <= 0L) goto _L6; else goto _L7
_L7:
        s = file.getAbsolutePath();
        return s;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static int exifOrientation(String s)
    {
        int i;
        try
        {
            i = (new ExifInterface(s)).getAttributeInt("Orientation", 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 0;
        }
        switch (i)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            return 0;

        case 6: // '\006'
            return 90;

        case 3: // '\003'
            return 180;

        case 8: // '\b'
            return 270;
        }
    }

    public static String generateFileName()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MMdd HH_mm_ss");
        Date date = new Date();
        return (new StringBuilder()).append("PMCovershot").append(simpledateformat.format(date)).append(".jpg").toString();
    }

    public static String getBitmapAsBase64String(Uri uri, int i)
    {
        uri = BitmapFactoryInstrumentation.decodeFile(uri.getPath());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        uri.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, bytearrayoutputstream);
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        uri.recycle();
        return Base64.encodeToString(abyte0, 2);
    }

    public static Bitmap getBitmapFromDrawable(Drawable drawable)
    {
        int i = drawable.getIntrinsicWidth();
        Bitmap bitmap;
        Canvas canvas;
        int j;
        if (i <= 0)
        {
            i = 1;
        }
        j = drawable.getIntrinsicHeight();
        if (j <= 0)
        {
            j = 1;
        }
        bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static String getPictureDirectory()
    {
        return (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()).append("/Poshmark").toString();
    }

    public static Bitmap loadScaledBitmapFromResource(Resources resources, int i, int j, int k, boolean flag)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeResource(resources, i, options);
        j = calculateInSampleSize(options, j, k);
        options.inJustDecodeBounds = false;
        options.inSampleSize = j;
        if (flag)
        {
            options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        }
        return BitmapFactoryInstrumentation.decodeResource(resources, i, options);
    }

    public static Uri saveBitmapToDisk(Bitmap bitmap)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MMdd HH_mm_ss");
        Date date = new Date();
        return saveBitmapToDisk(bitmap, (new StringBuilder()).append("PMCovershot").append(simpledateformat.format(date)).append(".jpg").toString());
    }

    public static Uri saveBitmapToDisk(Bitmap bitmap, String s)
    {
label0:
        {
            Object obj1 = null;
            Object obj = s;
            if (s == null)
            {
                s = new SimpleDateFormat("yyyy-MMdd HH_mm_ss");
                obj = new Date();
                obj = (new StringBuilder()).append("PMCovershot").append(s.format(((Date) (obj)))).append(".jpg").toString();
            }
            File file = new File(getPictureDirectory());
            if (!file.mkdirs())
            {
                s = obj1;
                if (!file.isDirectory())
                {
                    break label0;
                }
            }
            s = new File(file, ((String) (obj)));
            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream(s);
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
                fileoutputstream.flush();
                fileoutputstream.close();
                broadcastToMediaScanner();
                s = Uri.fromFile(s);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                bitmap.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                bitmap.printStackTrace();
                return null;
            }
        }
        return s;
    }

    public static Uri saveDrawableToDisk(Drawable drawable)
    {
        Object obj = null;
        File file = new File(getPictureDirectory());
        if (file.mkdirs() || file.isDirectory())
        {
            obj = new SimpleDateFormat("yyyy-MMdd HH_mm_ss");
            Date date = new Date();
            obj = new File(file, (new StringBuilder()).append("PMCovershot").append(((SimpleDateFormat) (obj)).format(date)).append(".jpg").toString());
            try
            {
                drawable = getBitmapFromDrawable(drawable);
                FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj)));
                drawable.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
                fileoutputstream.flush();
                fileoutputstream.close();
                broadcastToMediaScanner();
                drawable.recycle();
                obj = Uri.fromFile(((File) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Drawable drawable)
            {
                drawable.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Drawable drawable)
            {
                drawable.printStackTrace();
                return null;
            }
        }
        return ((Uri) (obj));
    }

    public static Bitmap scaleBitmap(int i, int j, Bitmap bitmap)
    {
        return null;
    }

    public static Bitmap scaleBitmap(int i, int j, Uri uri)
    {
        try
        {
            InputStream inputstream = PMApplication.getContext().getContentResolver().openInputStream(uri);
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactoryInstrumentation.decodeStream(inputstream, null, options);
            i = calculateInSampleSize(options, i, j);
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            uri = BitmapFactoryInstrumentation.decodeStream(PMApplication.getContext().getContentResolver().openInputStream(uri), null, options);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        return uri;
    }

    public static Uri takeScreenshot(View view)
    {
        Object obj = null;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap bitmap = view.getDrawingCache();
        File file = new File(getPictureDirectory());
        if (file.mkdirs() || file.isDirectory())
        {
            obj = new SimpleDateFormat("yyyy-MMdd HH_mm_ss");
            Date date = new Date();
            obj = new File(file, (new StringBuilder()).append("PMCloset").append(((SimpleDateFormat) (obj)).format(date)).append(".jpg").toString());
            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj)));
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream);
                fileoutputstream.close();
                bitmap.recycle();
                view.setDrawingCacheEnabled(false);
                obj = Uri.fromFile(((File) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
                return null;
            }
        }
        return ((Uri) (obj));
    }
}
