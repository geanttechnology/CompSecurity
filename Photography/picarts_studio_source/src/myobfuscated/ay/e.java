// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ay;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Environment;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import myobfuscated.az.b;
import org.json.JSONArray;

public final class e
{

    public static int a = 0;

    public static Intent a(Activity activity, Class class1, HashMap hashmap, String s, int i, int j)
    {
        activity = new Intent(activity, class1);
        if (hashmap != null)
        {
            Log.e("ex", "bufferData != null");
            activity.putExtra("bufferData", hashmap);
            activity.putExtra("degree", i);
        } else
        {
            activity.putExtra("degree", i);
            activity.putExtra("path", s);
        }
        Log.e("ex", (new StringBuilder("degree = ")).append(i).toString());
        Log.e("ex", (new StringBuilder("path = ")).append(s).toString());
        activity.putExtra("maxPixel", j);
        return activity;
    }

    public static Bitmap a(Bitmap bitmap)
    {
        Object obj;
label0:
        {
            obj = bitmap;
            if (bitmap == null)
            {
                break label0;
            }
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            if (bitmap.getConfig() == android.graphics.Bitmap.Config.ARGB_8888 && bitmap.isMutable())
            {
                obj = bitmap;
                if (i * j * 4 == bitmap.getRowBytes() * j)
                {
                    break label0;
                }
            }
            Bitmap bitmap1 = c.a(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            obj = bitmap;
            if (bitmap1 != null)
            {
                Log.e("ex", "not correct");
                obj = new Canvas(bitmap1);
                Paint paint = new Paint();
                paint.setFilterBitmap(true);
                ((Canvas) (obj)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
                c.a(bitmap);
                obj = bitmap1;
            }
        }
        return ((Bitmap) (obj));
    }

    public static Bitmap a(String s, int i, HashMap hashmap, int j)
    {
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        hashmap = w.a(hashmap, j, i);
_L4:
        return a(((Bitmap) (hashmap)));
_L2:
        s = w.b(s, j, i);
        hashmap = s;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        hashmap = s;
        if (s.getWidth() * s.getHeight() <= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("ex", "(bitmap.getWidth() > maxSize || bitmap.getHeight() > maxSize)");
        hashmap = s;
        continue; /* Loop/switch isn't completed */
        hashmap;
_L5:
        hashmap.printStackTrace();
        hashmap = s;
        if (true) goto _L4; else goto _L3
_L3:
        hashmap;
        s = null;
          goto _L5
    }

    public static Bitmap a(HashMap hashmap, int i, int j)
    {
        hashmap = w.b(hashmap, i, j, 0);
        if (hashmap != null)
        {
            Bitmap bitmap = c.a(i, j, android.graphics.Bitmap.Config.ALPHA_8);
            bitmap.eraseColor(0);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(2);
            canvas.drawBitmap(hashmap, new Rect(0, 0, hashmap.getWidth(), hashmap.getHeight()), new Rect(0, 0, i, j), paint);
            c.a(hashmap);
            canvas.drawColor(-1, android.graphics.PorterDuff.Mode.SRC_ATOP);
            return bitmap;
        } else
        {
            return null;
        }
    }

    public static Bitmap a(HashMap hashmap, String s, int i, int j)
    {
        if (hashmap != null)
        {
            return w.a(hashmap, j, i);
        }
        try
        {
            hashmap = w.b(s, j, i);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            hashmap.printStackTrace();
            return null;
        }
        return hashmap;
    }

    public static Point a(float f, float f1, float f2)
    {
        if (f2 / f < f2 / f1)
        {
            f2 /= f;
        } else
        {
            f2 /= f1;
        }
        return new Point((int)(f * f2), (int)(f2 * f1));
    }

    public static Point a(Bitmap bitmap, int i)
    {
label0:
        {
            int j = bitmap.getWidth();
            int k = bitmap.getHeight();
            i = Math.min(i, Math.max(j, k));
            Point point = new Point(j, k);
            if (point.x <= i)
            {
                bitmap = point;
                if (point.y <= i)
                {
                    break label0;
                }
            }
            bitmap = a(j, k, i);
        }
        return bitmap;
    }

    public static Allocation a(RenderScript renderscript, Context context, String s, String s1, int i, int j)
    {
        context = myobfuscated.az.b.a(context, s, s1, i, j, false);
        if (context != null && !context.isRecycled())
        {
            renderscript = Allocation.createFromBitmap(renderscript, context, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 1);
            c.a(context);
            return renderscript;
        } else
        {
            return null;
        }
    }

    public static String a(Context context, long l)
    {
        int i = 0;
        Object obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context.getString(0x7f0808fb)).append("/").toString();
        String s = (new StringBuilder()).append(((String) (obj))).append(context.getString(0x7f08096c)).append("/").append(l).append("/").toString();
        obj = new File(((String) (obj)));
        File file = new File(s);
        do
        {
label0:
            {
                context = s;
                if (i < 2)
                {
                    context = (new File[] {
                        obj, file
                    })[i];
                    if (context.exists() || context.mkdirs())
                    {
                        break label0;
                    }
                    context = null;
                }
                return context;
            }
            i++;
        } while (true);
    }

    public static String a(String s, String s1)
    {
        s1 = (new StringBuilder()).append("effect").append("_").append(System.currentTimeMillis()).append(s1).toString();
        return (new StringBuilder()).append(s).append(s1).toString();
    }

    public static ByteBuffer a(int i)
    {
        a++;
        Log.e("ex1", (new StringBuilder("efectsUtls buffersCount = ")).append(a).toString());
        return ImageOpCommon.allocNativeBuffer(i);
    }

    public static ByteBuffer a(Context context, String s, String s1, int i, int j)
    {
        context = myobfuscated.az.b.a(context, s, s1, i, j, false);
        if (context != null && !context.isRecycled())
        {
            s = a(context.getWidth() * context.getHeight() * 4);
            context.copyPixelsToBuffer(s);
            c.a(context);
            return s;
        } else
        {
            return null;
        }
    }

    public static void a()
    {
    }

    public static void a(Activity activity, Fragment fragment, String s, int i, HashMap hashmap, int j, int k, int l)
    {
        Intent intent = new Intent();
        intent.setClassName(activity, "com.picsart.studio.editor.activity.StandaloneCropToolActivity");
        if (s != null)
        {
            intent.putExtra("imagePath", s);
        }
        if (hashmap != null)
        {
            intent.putExtra("bufferData", hashmap);
        }
        float f = (float)j / (float)k;
        Log.e("ex1", (new StringBuilder("aspectRatio = ")).append(f).toString());
        intent.putExtra("aspectRatio", f);
        intent.putExtra("degree", i);
        intent.putExtra("scale", true);
        intent.putExtra("source", "effect");
        intent.putExtra("maxPixel", l);
        fragment.startActivityForResult(intent, 7);
    }

    public static void a(Context context, String s, int i, int j, long l)
    {
        Utils.a(context, s, "try", i, j, l);
        AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.EffectTryEvent(s, i, j, l));
        Log.e("ex1", "**************************");
        Log.e("ex1", "analyticsTrackTryEffect");
        Log.e("ex1", (new StringBuilder("effectNameForAnalytics = ")).append(s).toString());
        Log.e("ex1", (new StringBuilder("width = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("height = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("time = ")).append(l).toString());
        Log.e("ex1", "**************************");
    }

    public static void a(Context context, String s, int i, int j, boolean flag, boolean flag1, long l, 
            boolean flag2, JSONArray jsonarray, String s1)
    {
        Utils.a(context, s, "apply", i, j, l);
        AnalyticUtils.getInstance(context).track(new com.socialin.android.apiv3.events.EventsFactory.EffectApplyEvent(s, i, j, flag, flag1, l, flag2, jsonarray, s1));
        Log.e("ex1", "**************************");
        Log.e("ex1", "analyticsTrackEffectApply");
        Log.e("ex1", (new StringBuilder("effectNameForAnalytics = ")).append(s).toString());
        Log.e("ex1", (new StringBuilder("width = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("height = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("processing_time = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("default_settings = ")).append(flag).toString());
        Log.e("ex1", (new StringBuilder("explicit_apply = ")).append(flag1).toString());
        Log.e("ex1", (new StringBuilder("apply_during_try = ")).append(flag2).toString());
        Log.e("ex1", (new StringBuilder("uid = ")).append(s1).toString());
        Log.e("ex1", "**************************");
    }

    public static void a(Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2)
    {
        Rect rect;
        Rect rect1;
label0:
        {
            if (bitmap != null && !bitmap.isRecycled() && bitmap2 != null && !bitmap2.isRecycled())
            {
                int i = bitmap.getWidth();
                int j = bitmap.getHeight();
                int k = bitmap2.getWidth();
                int l = bitmap2.getHeight();
                rect = new Rect(0, 0, i, j);
                rect1 = new Rect(0, 0, k, l);
                if (bitmap1 == null || bitmap1.isRecycled())
                {
                    break label0;
                }
                Log.e("ex1", "maskBitmap != null && !maskBitmap.isRecycled()");
                bitmap2.eraseColor(0);
                bitmap2 = new Canvas(bitmap2);
                Paint paint = new Paint(2);
                bitmap2.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), rect1, paint);
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
                bitmap2.drawBitmap(bitmap, rect, rect1, paint);
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
                paint.setColor(0xff000000);
                bitmap2.drawPaint(paint);
            }
            return;
        }
        bitmap1 = new Canvas(bitmap2);
        bitmap2 = new Paint(2);
        bitmap1.drawColor(0xff000000);
        bitmap1.drawBitmap(bitmap, rect, rect1, bitmap2);
    }

    public static void a(ByteBuffer bytebuffer)
    {
        a--;
        Log.e("ex1", (new StringBuilder("efectsUtls buffersCount = ")).append(a).toString());
        ImageOpCommon.freeNativeBuffer(bytebuffer);
    }

    public static boolean a(Activity activity)
    {
        return w.a(activity);
    }

    public static boolean a(Context context, String s, String s1, android.graphics.Bitmap.CompressFormat compressformat)
    {
        String s2;
        if (s1 == null || s == null)
        {
            return false;
        }
        s2 = w.b(s);
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s = c.a(s);
        if (s != null)
        {
            w.a(new File(s1), s, compressformat, context);
            s.recycle();
            return true;
        }
          goto _L3
_L2:
        if (compressformat != android.graphics.Bitmap.CompressFormat.PNG || !s2.equalsIgnoreCase("png")) goto _L5; else goto _L4
_L4:
        b(s, s1);
        Log.e("ex", "copy png");
        return true;
        context;
        context.printStackTrace();
_L3:
        return false;
_L5:
        if (compressformat != android.graphics.Bitmap.CompressFormat.JPEG || !s2.equalsIgnoreCase("jpeg"))
        {
            break; /* Loop/switch isn't completed */
        }
        b(s, s1);
        Log.e("ex", "copy jpeg");
        return true;
        context;
        context.printStackTrace();
        if (true) goto _L3; else goto _L6
_L6:
        s = c.a(s);
        if (s != null)
        {
            w.a(new File(s1), s, compressformat, context);
            s.recycle();
            return true;
        }
        if (true) goto _L3; else goto _L7
_L7:
    }

    public static int b(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        return (int)((float)Math.max(activity.getWidth(), activity.getHeight()) * 0.75F);
    }

    private static void b(String s, String s1)
    {
        Object obj;
        File file;
        obj = null;
        file = new File(s);
        s1 = new File(s1);
        if (!file.exists())
        {
            throw new IOException((new StringBuilder("FileCopy: no such source file: ")).append(s).toString());
        }
        if (!file.isFile())
        {
            throw new IOException((new StringBuilder("FileCopy: can't copy directory: ")).append(s).toString());
        }
        if (!file.canRead())
        {
            throw new IOException((new StringBuilder("FileCopy: source file is unreadable: ")).append(s).toString());
        }
        if (s1.isDirectory())
        {
            s1 = new File(s1, file.getName());
        }
        s = new FileInputStream(file);
        s1 = new FileOutputStream(s1);
        obj = new byte[4096];
_L3:
        int i = s.read(((byte []) (obj)));
        if (i == -1) goto _L2; else goto _L1
_L1:
        s1.write(((byte []) (obj)), 0, i);
          goto _L3
        Exception exception;
        exception;
        obj = s;
        s = exception;
_L5:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ExceptionReportService.report(((Throwable) (obj)));
            }
        }
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                ExceptionReportService.report(s1);
            }
        }
        throw s;
_L2:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ExceptionReportService.report(s);
        }
        try
        {
            s1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ExceptionReportService.report(s);
        }
        return;
        s;
        s1 = null;
        continue; /* Loop/switch isn't completed */
        exception;
        s1 = null;
        obj = s;
        s = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean b()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return false;
        }
        try
        {
            PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY);
            (new Paint()).setXfermode(porterduffxfermode);
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return false;
        }
        return true;
    }

    static 
    {
        (new StringBuilder("MagicEffects_")).append(System.currentTimeMillis());
    }
}
