// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.appboy.enums.NotificationSubscriptionType;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.DeviceModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.util:
//            ao, b

public class Utils
{

    private static Properties a;
    private static HashMap b = new HashMap();

    public Utils()
    {
    }

    public static float a(float f1, Context context)
    {
        if (context == null)
        {
            return -1F;
        } else
        {
            return ((float)context.getResources().getDisplayMetrics().densityDpi / 160F) * f1;
        }
    }

    public static int a()
    {
        return (int)Runtime.getRuntime().maxMemory();
    }

    public static int a(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int a(DisplayMetrics displaymetrics)
    {
        byte byte0 = 3;
        int i1 = displaymetrics.widthPixels;
        float f1 = displaymetrics.density;
        i1 = (int)(((float)i1 - 0.5F) / f1);
        if (i1 >= 400)
        {
            byte0 = 4;
        }
        if (i1 >= 750)
        {
            byte0 = 5;
        }
        return byte0;
    }

    public static int a(Pattern pattern, String s)
    {
        pattern = pattern.matcher(s);
        if (pattern.find())
        {
            return pattern.start();
        } else
        {
            return -1;
        }
    }

    public static Boolean a(float f1, float f2, Context context)
    {
        Object obj = null;
        float f3 = a(50F, context);
        if (f1 > 2.0F)
        {
            context = Boolean.valueOf(true);
        } else
        {
            context = obj;
            if (f2 < -f3)
            {
                context = obj;
                if (f1 < -2F)
                {
                    return Boolean.valueOf(false);
                }
            }
        }
        return context;
    }

    public static String a(int i1)
    {
        if (i1 >= 0xf4240)
        {
            return (new StringBuilder()).append(String.format("%.1f", new Object[] {
                Double.valueOf((double)i1 / 1000000D)
            })).append("M").toString();
        }
        if (i1 >= 1000)
        {
            return (new StringBuilder()).append(i1 / 1000).append("K").toString();
        } else
        {
            return String.valueOf(i1);
        }
    }

    public static String a(InputStream inputstream)
    {
        inputstream = (new Scanner(inputstream)).useDelimiter("\\A");
        if (inputstream.hasNext())
        {
            return inputstream.next();
        } else
        {
            return "";
        }
    }

    public static String a(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    public static void a(Activity activity, int i1)
    {
        if (activity != null)
        {
            a(activity, activity.getResources().getString(i1), 0);
        }
    }

    public static void a(Activity activity, String s)
    {
        SharedPreferences sharedpreferences;
        int j1;
        sharedpreferences = activity.getSharedPreferences("appSaveDialogPreferences", 4);
        j1 = sharedpreferences.getInt("appSaveDialogCount", 0);
        if (j1 >= 3) goto _L2; else goto _L1
_L1:
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/PicsArt").toString());
        if (file.exists()) goto _L4; else goto _L3
_L3:
        System.out.println((new StringBuilder("false, oldDirectory not exists ")).append(file.getPath()).toString());
_L8:
        int i1 = 0;
_L5:
        if (i1 != 0 && s.contains("Pictures/PicsArt"))
        {
            s = new Intent();
            s.setClassName(activity.getPackageName(), "com.socialin.android.picsart.profile.activity.SaveToSDMessageActivity");
            activity.startActivity(s);
            sharedpreferences.edit().putInt("appSaveDialogCount", j1 + 1).apply();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        File afile[];
        afile = file.listFiles();
        if (afile == null || afile.length == 0)
        {
            System.out.println((new StringBuilder("false, file list is empty  ")).append(afile).toString());
            continue; /* Loop/switch isn't completed */
        }
        if (b(file))
        {
            i1 = 1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = 0;
_L6:
label0:
        {
            if (i1 >= afile.length)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (afile[i1] == null || !afile[i1].isDirectory() || !b(afile[i1]))
            {
                break label0;
            }
            i1 = 1;
        }
        if (true) goto _L5; else goto _L2
        i1++;
          goto _L6
_L2:
        a(activity, (new StringBuilder("Image saved at ")).append(s).toString(), 0);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void a(Activity activity, String s, int i1)
    {
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            myobfuscated.f.m.a(s, activity, 0).show();
            return;
        } else
        {
            activity.runOnUiThread(new _cls1(s, activity, i1));
            return;
        }
    }

    public static void a(Context context, Bitmap bitmap)
    {
        WallpaperManager.getInstance(context).setBitmap(bitmap);
_L2:
        return;
        bitmap;
_L3:
        if (!(context instanceof Activity)) goto _L2; else goto _L1
_L1:
        a((Activity)context, "Failed changing wallpaper.", 0);
        return;
        bitmap;
          goto _L3
    }

    private static void a(Context context, String s)
    {
        CookieSyncManager.createInstance(context).sync();
        context = CookieManager.getInstance();
        String s1 = context.getCookie(s);
        if (s1 == null)
        {
            return;
        }
        String as[] = s1.split(";");
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            String as1[] = as[i1].split("=");
            if (as1.length > 0)
            {
                context.setCookie(s, (new StringBuilder()).append(as1[0].trim()).append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;").toString());
            }
        }

        context.removeExpiredCookie();
    }

    public static void a(Context context, String s, String s1, int i1, int j1, long l1)
    {
        Intent intent = new Intent("com.picsart.performancetool.EFFECTS_ACTION");
        intent.putExtra("event_name", s);
        intent.putExtra("processing_time", l1);
        intent.putExtra("event_end_time", System.currentTimeMillis());
        intent.putExtra("width", i1);
        intent.putExtra("height", j1);
        intent.putExtra("action", s1);
        context.sendBroadcast(intent);
    }

    public static void a(View view, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(ongloballayoutlistener);
            return;
        } else
        {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(ongloballayoutlistener);
            return;
        }
    }

    public static void a(boolean flag, Activity activity)
    {
        android.view.WindowManager.LayoutParams layoutparams = activity.getWindow().getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x400;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfffffbff;
        }
        activity.getWindow().setAttributes(layoutparams);
    }

    public static boolean a(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000;
    }

    public static boolean a(File file)
    {
        if (file.isDirectory())
        {
            String as[] = file.list();
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                if (!a(new File(file, as[i1])))
                {
                    return false;
                }
            }

        }
        return file.delete();
    }

    public static boolean a(Object obj)
    {
        return obj == null;
    }

    public static boolean a(String s)
    {
        return s == null || s.isEmpty();
    }

    public static boolean a(Collection collection)
    {
        return collection == null || collection.isEmpty();
    }

    public static boolean a(Object aobj[])
    {
        return aobj == null || aobj.length == 0;
    }

    public static float b(float f1, Context context)
    {
        return f1 / ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static float b(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getMetrics(displaymetrics);
        return (float)displaymetrics.heightPixels;
    }

    public static int b()
    {
        switch (_cls2.a[PicsartContext.a.ordinal()])
        {
        default:
            return 2048;

        case 1: // '\001'
            return 640;

        case 2: // '\002'
        case 3: // '\003'
            return 1024;
        }
    }

    public static void b(int i1)
    {
        b.put(Integer.valueOf(i1), Long.valueOf(System.nanoTime()));
    }

    public static void b(Activity activity, int i1)
    {
        if (activity != null)
        {
            a(activity, activity.getResources().getString(i1), 1);
        }
    }

    public static void b(Activity activity, String s)
    {
        a(activity, s, 0);
    }

    public static void b(Context context)
    {
        a(context, "instagram.com");
        a(context, ".instagram.com");
        a(context, "https://instagram.com");
        a(context, "https://.instagram.com");
    }

    private static boolean b(File file)
    {
        if (file != null && file.isDirectory()) goto _L2; else goto _L1
_L1:
        File afile[];
        return false;
_L2:
        if ((afile = file.listFiles()) != null && afile.length != 0)
        {
            int i1 = 0;
            while (i1 < afile.length) 
            {
                if (afile[i1] != null)
                {
                    String s = afile[i1].getPath();
                    file = null;
                    s = MimeTypeMap.getFileExtensionFromUrl(s);
                    if (s != null)
                    {
                        file = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
                    }
                    if (!TextUtils.isEmpty(file) && file.contains("image"))
                    {
                        return true;
                    }
                }
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int c(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getMetrics(displaymetrics);
        return Math.min(displaymetrics.widthPixels, displaymetrics.heightPixels);
    }

    public static long c(int i1)
    {
        long l2 = 0L;
        long l1 = l2;
        if (b != null)
        {
            l1 = l2;
            if (b.get(Integer.valueOf(i1)) != null)
            {
                l1 = System.nanoTime() - ((Long)b.get(Integer.valueOf(i1))).longValue();
                b.remove(Integer.valueOf(i1));
            }
        }
        return l1 / 0xf4240L;
    }

    public static ao c()
    {
        Object obj1 = null;
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            obj = new ao();
            android.opengl.EGLDisplay egldisplay = EGL14.eglGetDisplay(0);
            Object aobj[] = new int[2];
            EGL14.eglInitialize(egldisplay, ((int []) (aobj)), 0, ((int []) (aobj)), 1);
            aobj = new EGLConfig[1];
            int ai[] = new int[1];
            EGL14.eglChooseConfig(egldisplay, new int[] {
                12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344
            }, 0, ((EGLConfig []) (aobj)), 0, 1, ai, 0);
            if (ai[0] == 0)
            {
                obj = null;
            } else
            {
                Object obj2 = aobj[0];
                android.opengl.EGLSurface eglsurface = EGL14.eglCreatePbufferSurface(egldisplay, ((EGLConfig) (obj2)), new int[] {
                    12375, 64, 12374, 64, 12344
                }, 0);
                obj2 = EGL14.eglCreateContext(egldisplay, ((EGLConfig) (obj2)), EGL14.EGL_NO_CONTEXT, new int[] {
                    12440, 2, 12344
                }, 0);
                EGL14.eglMakeCurrent(egldisplay, eglsurface, eglsurface, ((android.opengl.EGLContext) (obj2)));
                int ai1[] = new int[1];
                GLES20.glGetIntegerv(3379, ai1, 0);
                int ai3[] = new int[1];
                GLES20.glGetIntegerv(34930, ai3, 0);
                EGL14.eglDestroySurface(egldisplay, eglsurface);
                EGL14.eglDestroyContext(egldisplay, ((android.opengl.EGLContext) (obj2)));
                EGL14.eglTerminate(egldisplay);
                obj.a = ai1[0];
                obj.b = ai3[0];
            }
        } else
        {
            obj = null;
        }
        if (obj == null || ((ao) (obj)).a <= 0 || ((ao) (obj)).b <= 0)
        {
            ao ao1 = new ao();
            obj = (EGL10)EGLContext.getEGL();
            javax.microedition.khronos.egl.EGLDisplay egldisplay1 = ((EGL10) (obj)).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            ((EGL10) (obj)).eglInitialize(egldisplay1, new int[2]);
            javax.microedition.khronos.egl.EGLConfig aeglconfig[] = new javax.microedition.khronos.egl.EGLConfig[1];
            int ai2[] = new int[1];
            ((EGL10) (obj)).eglChooseConfig(egldisplay1, new int[] {
                12351, 12430, 12329, 0, 12339, 1, 12344
            }, aeglconfig, 1, ai2);
            if (ai2[0] == 0)
            {
                ao1 = null;
            } else
            {
                Object obj3 = aeglconfig[0];
                javax.microedition.khronos.egl.EGLSurface eglsurface1 = ((EGL10) (obj)).eglCreatePbufferSurface(egldisplay1, ((javax.microedition.khronos.egl.EGLConfig) (obj3)), new int[] {
                    12375, 64, 12374, 64, 12344
                });
                obj3 = ((EGL10) (obj)).eglCreateContext(egldisplay1, ((javax.microedition.khronos.egl.EGLConfig) (obj3)), EGL10.EGL_NO_CONTEXT, new int[] {
                    12440, 1, 12344
                });
                ((EGL10) (obj)).eglMakeCurrent(egldisplay1, eglsurface1, eglsurface1, ((EGLContext) (obj3)));
                int ai4[] = new int[1];
                GLES10.glGetIntegerv(3379, ai4, 0);
                int ai5[] = new int[1];
                GLES10.glGetIntegerv(34018, ai5, 0);
                ((EGL10) (obj)).eglMakeCurrent(egldisplay1, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                ((EGL10) (obj)).eglDestroySurface(egldisplay1, eglsurface1);
                ((EGL10) (obj)).eglDestroyContext(egldisplay1, ((EGLContext) (obj3)));
                ((EGL10) (obj)).eglTerminate(egldisplay1);
                ao1.a = ai4[0];
                ao1.b = ai5[0];
            }
            obj = obj1;
            if (ao1 != null)
            {
                obj = obj1;
                if (ao1.a > 0)
                {
                    obj = obj1;
                    if (ao1.b > 0)
                    {
                        return ao1;
                    }
                }
            }
        }
        return ((ao) (obj));
    }

    public static void c(Activity activity, String s)
    {
        a(activity, s, 0);
    }

    public static void c(Context context)
    {
        a(context, "dropbox.com");
        a(context, ".dropbox.com");
        a(context, "https://dropbox.com");
        a(context, "https://.dropbox.com");
    }

    public static float d(Activity activity)
    {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        float f1 = activity.getResources().getDisplayMetrics().density;
        return Math.min((float)displaymetrics.widthPixels / f1, (float)displaymetrics.heightPixels / f1);
    }

    public static int d()
    {
        int i1;
        try
        {
            i1 = (new File("/sys/devices/system/cpu/")).listFiles(new a()).length;
        }
        catch (Exception exception)
        {
            return 1;
        }
        return i1;
    }

    public static int d(Context context)
    {
        int i1 = 0;
        if (context != null)
        {
            try
            {
                i1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return 0;
            }
        }
        return i1;
    }

    public static float e(Activity activity)
    {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        float f1 = activity.getResources().getDisplayMetrics().density;
        return (float)displaymetrics.heightPixels / f1;
    }

    public static long e()
    {
        long l1 = 0L;
        RandomAccessFile randomaccessfile;
        Matcher matcher;
        randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
        String s = randomaccessfile.readLine();
        matcher = Pattern.compile("(\\d+)").matcher(s);
        String s1 = "";
        while (matcher.find()) 
        {
            s1 = matcher.group(1);
        }
        long l2;
        randomaccessfile.close();
        l2 = Long.parseLong(s1);
        l1 = l2;
_L2:
        return l1 * 1024L;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String e(Context context)
    {
        String s = (new StringBuilder("http://adturns.com/logstat.php?act_own=32&socialType=")).append(context.getResources().getString(myobfuscated.f.m.e(context, "socialType"))).append("&appId=").append(context.getResources().getString(myobfuscated.f.m.e(context, "app_name_short"))).append("&channel=fromEmail&redirectTo=").append(URLEncoder.encode(context.getPackageName())).append("&n=").append(context.getResources().getString(myobfuscated.f.m.e(context, "configVersion"))).toString();
        return String.format(context.getResources().getString(myobfuscated.f.m.e(context, "msg_email_text")), new Object[] {
            s
        });
    }

    public static String f(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        try
        {
            context = context.getNetworkOperator();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static void f(Activity activity)
    {
        int i1 = activity.getWindowManager().getDefaultDisplay().getRotation();
        Configuration configuration = activity.getResources().getConfiguration();
        switch (i1)
        {
        default:
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                activity.setRequestedOrientation(14);
            }
            return;

        case 0: // '\0'
            switch (configuration.orientation)
            {
            default:
                activity.setRequestedOrientation(1);
                return;

            case 2: // '\002'
                activity.setRequestedOrientation(0);
                break;
            }
            return;

        case 1: // '\001'
            switch (configuration.orientation)
            {
            default:
                activity.setRequestedOrientation(9);
                return;

            case 2: // '\002'
                break;
            }
            if (DeviceModel.currentDevice == DeviceModel.AMAZON_KFTHWI)
            {
                activity.setRequestedOrientation(8);
                return;
            } else
            {
                activity.setRequestedOrientation(0);
                return;
            }

        case 2: // '\002'
            switch (configuration.orientation)
            {
            default:
                activity.setRequestedOrientation(9);
                return;

            case 2: // '\002'
                activity.setRequestedOrientation(8);
                break;
            }
            return;

        case 3: // '\003'
            switch (configuration.orientation)
            {
            default:
                activity.setRequestedOrientation(1);
                return;

            case 2: // '\002'
                break;
            }
            break;
        }
        if (DeviceModel.currentDevice == DeviceModel.AMAZON_KFTHWI)
        {
            activity.setRequestedOrientation(0);
            return;
        } else
        {
            activity.setRequestedOrientation(8);
            return;
        }
    }

    public static void g(Activity activity)
    {
        activity.setRequestedOrientation(4);
    }

    public static int[] g(Context context)
    {
        byte byte1 = 3;
        int i1 = context.getResources().getConfiguration().screenLayout & 0xf;
        byte byte0;
        if (i1 == 3 || i1 == 4)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            byte0 = 2;
            i1 = byte1;
        } else
        {
            i1 = 2;
            byte0 = 1;
        }
        return (new int[] {
            byte0, i1
        });
    }

    public static boolean h(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) > 3;
    }

    public static boolean i(Context context)
    {
        if ((context.getResources().getConfiguration().screenLayout & 0xf) >= 4)
        {
            return j(context) ? (double)context.getResources().getConfiguration().screenWidthDp * 0.66999999999999993D > 730D : context.getResources().getConfiguration().screenWidthDp - 64 > 730;
        } else
        {
            return false;
        }
    }

    public static boolean j(Context context)
    {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static String k(Context context)
    {
        int i1 = Process.myPid();
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (runningappprocessinfo.pid == i1)
            {
                return runningappprocessinfo.processName;
            }
        }

        return null;
    }

    public static void l(Context context)
    {
        context.getSharedPreferences((new StringBuilder("sinPref_")).append(context.getString(myobfuscated.f.m.e(context, "app_name_short"))).toString(), 0).edit().putBoolean("enable_push_notifications", true).apply();
        com.socialin.android.util.b.a(context).a(NotificationSubscriptionType.SUBSCRIBED);
    }

    public static boolean m(Context context)
    {
        boolean flag = false;
        if (context.getSharedPreferences("appVersionPreferences", 0).getInt("appVersionKey", 0) == 0)
        {
            flag = true;
        }
        return flag;
    }

    static 
    {
        com/socialin/android/util/Utils.getSimpleName();
        Properties properties = new Properties();
        a = properties;
        properties.put("2", "google");
        a.put("3", "getjar");
        a.put("5", "amazon");
        a.put("6", "vodafone");
        a.put("7", "ndoo");
        a.put("8", "samsung");
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class a {}

}
