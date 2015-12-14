// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.baidu.frontia.FrontiaApplication;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.cyberlink.uma.g;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.database.more.a.a;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.u;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.utility.StorageMonitor;
import com.cyberlink.youcammakeup.utility.bc;
import com.cyberlink.youcammakeup.utility.be;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.a.b;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.facebook.model.GraphPlace;
import com.pf.common.utility.m;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup:
//            BaseActivity, DisplayBroadcastReceiver

public class Globals extends Application
{

    private static String J = null;
    private static String K = null;
    private static String L = null;
    private static boolean N;
    public static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.getDefault());
    public static final String b = System.getProperty("line.separator");
    public static final String c;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = false;
    private static Globals q;
    private static final List u = Collections.synchronizedList(new LinkedList());
    private static final List v = Collections.synchronizedList(new LinkedList());
    private static final Handler z = new Handler(Looper.getMainLooper());
    private boolean A;
    private boolean B;
    private Integer C;
    private bc D;
    private DisplayBroadcastReceiver E;
    private com.cyberlink.youcammakeup.pages.libraryview.b F;
    private o G;
    private File H;
    private File I;
    private Exporter M;
    private Bitmap O;
    private Bitmap P;
    private Bitmap Q;
    private Bitmap R;
    private Uri S;
    private ArrayList T;
    private List U;
    private GraphPlace V;
    private long W;
    private MakeupItemMetadata X;
    private boolean Y;
    private Pair Z;
    private Bitmap aa;
    private List ab;
    StatusManager g;
    public boolean h;
    public d i;
    LauncherActivity j;
    EditViewActivity k;
    final HashMap l = new HashMap();
    NetworkManager m;
    public long n;
    public List o;
    public int p;
    private String r;
    private ar s;
    private MotionControlHelper t;
    private STORE_NAME w;
    private c x;
    private f y;

    public Globals()
    {
        r = null;
        s = null;
        t = null;
        w = null;
        x = null;
        y = null;
        C = null;
        g = StatusManager.j();
        h = true;
        i = new d();
        H = null;
        I = null;
        n = -1L;
        o = null;
        p = -2;
        O = null;
        P = null;
        Q = null;
        R = null;
        W = -1L;
        Y = false;
        aa = null;
        ab = new ArrayList();
    }

    public static String J()
    {
        String s1;
        try
        {
            s1 = d().getApplicationContext().getPackageManager().getPackageInfo(d().getApplicationContext().getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            com.pf.common.utility.m.e("Globals", (new StringBuilder()).append("Could not get versionName name: ").append(namenotfoundexception).toString());
            return "";
        }
        return s1;
    }

    public static com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig O()
    {
        Context context = d().getApplicationContext();
        if (context == null)
        {
            return null;
        } else
        {
            com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig feedbackconfig = new com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig();
            feedbackconfig.apiUri = NetworkManager.D();
            feedbackconfig.product = "YouCam Makeup";
            feedbackconfig.version = "1.0";
            feedbackconfig.sr = com.cyberlink.youcammakeup.kernelctrl.networkmanager.u.a(context);
            feedbackconfig.hwid = com.cyberlink.youcammakeup.kernelctrl.networkmanager.u.d(context);
            feedbackconfig.phoneid = com.cyberlink.youcammakeup.kernelctrl.networkmanager.u.a(context, d().w());
            feedbackconfig.appversion = com.cyberlink.youcammakeup.kernelctrl.networkmanager.u.b(context);
            feedbackconfig.versionUpgradeHistory = com.cyberlink.youcammakeup.kernelctrl.z.v();
            feedbackconfig.umaid = com.cyberlink.uma.g.a(context);
            return feedbackconfig;
        }
    }

    public static boolean P()
    {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean S()
    {
        String s1 = Environment.getExternalStorageState();
        com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("getExternalStorageState: ").append(s1).toString());
        return "mounted".equals(s1);
    }

    public static void T()
    {
        float f1 = bo.c();
        if (bo.b())
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, d());
            bo.e();
            bo.v();
            bo.b(new bu(f1) {

                final float a;

                public void a(List list)
                {
                    com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, com.cyberlink.youcammakeup.Globals.d());
                }

            
            {
                a = f1;
                super();
            }
            });
        } else
        if (com.cyberlink.youcammakeup.kernelctrl.z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", d()) != f1 || bo.a())
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, d());
            bo.e();
            bo.v();
            bo.a(new bu(f1) {

                final float a;

                public void a(List list)
                {
                    bo.u();
                    if (bo.a())
                    {
                        bo.b(new bu(this) {

                            final _cls2 a;

                            public void a(List list)
                            {
                                com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, com.cyberlink.youcammakeup.Globals.d());
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    } else
                    {
                        com.cyberlink.youcammakeup.kernelctrl.z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, com.cyberlink.youcammakeup.Globals.d());
                        return;
                    }
                }

            
            {
                a = f1;
                super();
            }
            });
            return;
        }
    }

    public static boolean U()
    {
        Object obj2 = null;
        InputStream inputstream = d().getApplicationContext().getAssets().open("AppConfig/Config.json");
        Object obj = inputstream;
        byte abyte0[] = new byte[inputstream.available()];
        obj = inputstream;
        inputstream.read(abyte0);
        obj = inputstream;
        Object obj1 = new JSONObject(new String(abyte0, "UTF-8"));
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
_L15:
        if (obj != null) goto _L4; else goto _L3
_L3:
        com.pf.common.utility.m.e("Globals", "isDeviceInUnSupportedList() error, jsonObject is null");
        return false;
        obj1;
        inputstream = null;
_L13:
        obj = inputstream;
        String s3 = ((Exception) (obj1)).getMessage();
        obj1 = s3;
        if (s3 == null)
        {
            obj1 = "Unknown error";
        }
        obj = inputstream;
        com.pf.common.utility.m.e("Globals", (new StringBuilder()).append("isDeviceInUnSupportedList() error, e=").append(((String) (obj1))).toString());
        obj = obj2;
        if (inputstream == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj2;
            continue; /* Loop/switch isn't completed */
        }
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = null;
_L12:
        String s1;
        String s2;
        boolean flag;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw exception;
_L4:
        obj = ((JSONObject) (obj)).get("UnsupportedList");
        if (obj instanceof JSONObject) goto _L6; else goto _L5
_L5:
        com.pf.common.utility.m.e("Globals", "isDeviceInUnSupportedList() error, can't find UnsupportedList");
        return false;
        obj;
        com.pf.common.utility.m.e("Globals", (new StringBuilder()).append("isDeviceInUnSupportedList() error, e").append(((JSONException) (obj)).getMessage()).toString());
_L10:
        flag = false;
_L8:
        return flag;
_L6:
        obj = (JSONObject)obj;
        s2 = Build.BRAND.toLowerCase(Locale.US).trim();
        obj1 = Build.MANUFACTURER.toLowerCase(Locale.US).trim();
        s1 = Build.DEVICE.toLowerCase(Locale.US).trim();
        s2 = (new StringBuilder()).append(s2).append("_").append(s1).toString();
        com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("isDeviceInUnSupportedList(), info. key=").append(s2).toString());
        if (((JSONObject) (obj)).has(s2))
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        obj1 = (new StringBuilder()).append(((String) (obj1))).append("_").append(s1).toString();
        com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("isDeviceInUnSupportedList(), info. key=").append(((String) (obj1))).toString());
        if (((JSONObject) (obj)).has(((String) (obj1))))
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder()).append("unknown_").append(s1).toString();
        com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("isDeviceInUnSupportedList(), info. key=").append(s1).toString());
        flag = ((JSONObject) (obj)).has(s1);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
        s1;
        if (true) goto _L12; else goto _L11
_L11:
        obj1;
        if (true) goto _L13; else goto _L2
_L2:
        obj = obj1;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public static boolean V()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public static boolean X()
    {
        Matcher matcher;
        int i1;
        if (Build.MANUFACTURER.equalsIgnoreCase("motorola"))
        {
            if ((matcher = Pattern.compile("XT(\\d{4})").matcher(Build.MODEL)).find() && ((i1 = Integer.parseInt(matcher.group(1))) > 1060 && i1 < 1070))
            {
                return true;
            }
        }
        return false;
    }

    public static android.app.ActivityManager.RunningAppProcessInfo a(Context context)
    {
        int i1 = Process.myPid();
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (runningappprocessinfo.pid == i1)
            {
                return runningappprocessinfo;
            }
        }

        throw new AssertionError();
    }

    public static String a(Context context, String s1)
    {
        if (context != null && s1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        context = ((ApplicationInfo) (context)).metaData;
_L4:
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = context.getString(s1);
        return context;
        context = null;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static boolean a(Runnable runnable, long l1)
    {
        return z.postDelayed(runnable, l1);
    }

    public static boolean a(String s1)
    {
        String s2 = null;
        boolean flag1 = true;
        String s3;
        boolean flag;
        if (s1 == "model/Davinci.cade")
        {
            s3 = "KEY_APP_VERSION_FOR_DAVINCI_MODEL";
            s2 = "VENUS_FACE_DETECT_MODEL_MD5_COMPARE_SUCCESS";
        } else
        if (s1 == "model/Venus.regressor")
        {
            s3 = "KEY_APP_VERSION_FOR_VENUS_MODEL";
            s2 = "VENUS_FACE_ALIGN_MODEL_MD5_COMPARE_SUCCESS";
        } else
        if (s1 == "model/Venus.classifier")
        {
            s3 = "KEY_APP_VERSION_FOR_GENDER_MODEL";
            s2 = "VENUS_GENDER_MODEL_MD5_COMPARE_SUCCESS";
        } else
        {
            s3 = null;
        }
        if (s3 == null || s2 == null)
        {
            com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("IsModelNeedToCompareMD5 can't get pref key for ").append(s1).toString());
            flag = false;
        } else
        {
            s1 = com.cyberlink.youcammakeup.kernelctrl.z.b(s3, "", d());
            flag = flag1;
            if (com.cyberlink.youcammakeup.widgetpool.a.b.a().b().equalsIgnoreCase(s1))
            {
                flag = flag1;
                if (com.cyberlink.youcammakeup.kernelctrl.z.a(s2, false, d().getApplicationContext()))
                {
                    return false;
                }
            }
        }
        return flag;
    }

    public static void b(String s1)
    {
        String s2 = null;
        String s3;
        if (s1 == "model/Davinci.cade")
        {
            s3 = "KEY_APP_VERSION_FOR_DAVINCI_MODEL";
            s2 = "VENUS_FACE_DETECT_MODEL_MD5_COMPARE_SUCCESS";
        } else
        if (s1 == "model/Venus.regressor")
        {
            s3 = "KEY_APP_VERSION_FOR_VENUS_MODEL";
            s2 = "VENUS_FACE_ALIGN_MODEL_MD5_COMPARE_SUCCESS";
        } else
        if (s1 == "model/Venus.classifier")
        {
            s3 = "KEY_APP_VERSION_FOR_GENDER_MODEL";
            s2 = "VENUS_GENDER_MODEL_MD5_COMPARE_SUCCESS";
        } else
        {
            s3 = null;
        }
        if (s3 == null || s2 == null)
        {
            com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("setModelMD5Compared can't get pref key for ").append(s1).toString());
        }
        com.cyberlink.youcammakeup.kernelctrl.z.a(s3, com.cyberlink.youcammakeup.widgetpool.a.b.a().b(), d());
        com.cyberlink.youcammakeup.kernelctrl.z.a(s2, Boolean.valueOf(true), d());
    }

    public static void c(Runnable runnable)
    {
        if (P())
        {
            runnable.run();
            return;
        } else
        {
            d(runnable);
            return;
        }
    }

    public static Globals d()
    {
        return q;
    }

    public static void d(String s1)
    {
        android.content.SharedPreferences.Editor editor = d().getApplicationContext().getSharedPreferences("BeautyCircleResumeActivityFile", 0).edit();
        editor.putString("BeautyCircleResumeActivity", s1);
        editor.commit();
    }

    public static boolean d(Activity activity)
    {
        boolean flag;
        boolean flag3 = false;
        boolean flag2 = false;
        boolean flag1 = flag3;
        List list;
        try
        {
            list = ((ActivityManager)activity.getSystemService("activity")).getRunningTasks(10);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
            return flag1;
        }
        flag = flag2;
        flag1 = flag3;
        if (((android.app.ActivityManager.RunningTaskInfo)list.get(0)).numActivities != 1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        flag = flag2;
        flag1 = flag3;
        if (((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getClassName().equals(activity.getClass().getName()))
        {
            flag = true;
        }
        flag1 = flag;
        if (((android.app.ActivityManager.RunningTaskInfo)list.get(0)).numActivities != 2)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        flag1 = flag;
        if (!((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getClassName().equals(activity.getClass().getName()))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        flag1 = flag;
        flag2 = ((android.app.ActivityManager.RunningTaskInfo)list.get(0)).baseActivity.getClassName().equals("com.google.android.gms.ads.AdActivity");
        if (flag2)
        {
            return true;
        }
        return flag;
    }

    public static boolean d(Runnable runnable)
    {
        return z.post(runnable);
    }

    public static void e(Runnable runnable)
    {
        z.removeCallbacks(runnable);
    }

    public static boolean u()
    {
        return N;
    }

    public Bitmap A()
    {
        if (R == null)
        {
            R = BitmapFactory.decodeResource(getResources(), 0x7f020898);
        }
        return R;
    }

    public Uri B()
    {
        return S;
    }

    public ArrayList C()
    {
        return T;
    }

    public MakeupItemMetadata D()
    {
        return X;
    }

    public List E()
    {
        return U;
    }

    public GraphPlace F()
    {
        return V;
    }

    public long G()
    {
        return W;
    }

    public void H()
    {
        for (; !u.isEmpty(); ((Runnable)u.remove(0)).run()) { }
    }

    public boolean I()
    {
        return Y;
    }

    public Pair K()
    {
        return Z;
    }

    public void L()
    {
        if (Z == null || Z.second == null)
        {
            return;
        }
        Object obj = (ap)Z.second;
        com.cyberlink.youcammakeup.kernelctrl.z.b(this, "KEY_BEAUTY_CATEGORY_ALL", Long.valueOf(0L));
        for (Iterator iterator = ((ap) (obj)).b().iterator(); iterator.hasNext(); com.cyberlink.youcammakeup.kernelctrl.z.b(this, String.valueOf(((a)iterator.next()).a()), Long.valueOf(0L))) { }
        com.cyberlink.youcammakeup.kernelctrl.z.c(this, 0L);
        com.cyberlink.youcammakeup.kernelctrl.z.d(this, "KEY_MAKEUP_CATEGORY_ALL", Long.valueOf(0L));
        obj = ((ap) (obj)).i();
        if (obj != null)
        {
            obj = ((MKCategoryV2Status) (obj)).b();
            if (obj != null)
            {
                for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.cyberlink.youcammakeup.kernelctrl.z.d(this, String.valueOf(((com.cyberlink.youcammakeup.database.more.makeup.b)((Iterator) (obj)).next()).a()), Long.valueOf(0L))) { }
            }
        }
        com.cyberlink.youcammakeup.kernelctrl.z.a(this, com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b());
    }

    public boolean M()
    {
        String s1;
        String s2;
        String s3;
        String s4;
        s1 = "armeabi-v7a";
        s4 = "ro.product.cpu.abi";
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            s4 = "ro.product.cpu.abilist";
        }
        s3 = s1;
        s2 = s1;
        Process process = (new ProcessBuilder(new String[] {
            "/system/bin/getprop", s4
        })).redirectErrorStream(true).start();
        s3 = s1;
        s2 = s1;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(process.getInputStream()));
_L2:
        s3 = s1;
        s2 = s1;
        s4 = bufferedreader.readLine();
        if (s4 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s4;
        if (true) goto _L2; else goto _L1
_L1:
        s3 = s1;
        s2 = s1;
        process.destroy();
        if (!s1.equalsIgnoreCase("x86")) goto _L4; else goto _L3
_L3:
        return true;
        Object obj;
        obj;
        s2 = s3;
        ((IOException) (obj)).printStackTrace();
        if (s3.equalsIgnoreCase("x86")) goto _L3; else goto _L4
_L4:
        return false;
        obj;
        if (!s2.equalsIgnoreCase("x86"));
        throw obj;
    }

    public String N()
    {
        return d().getApplicationContext().getSharedPreferences("BeautyCircleResumeActivityFile", 0).getString("BeautyCircleResumeActivity", "");
    }

    public Bitmap Q()
    {
        if (aa == null)
        {
            aa = BitmapFactory.decodeResource(getResources(), 0x7f0201bf);
        }
        return aa;
    }

    public void R()
    {
        ab.clear();
    }

    public boolean W()
    {
        return A;
    }

    public Activity a(ActivityType activitytype)
    {
        return (Activity)l.get(activitytype);
    }

    public c a()
    {
        if (x == null)
        {
            x = new c(d().l());
        }
        return x;
    }

    public void a(long l1)
    {
        W = l1;
    }

    public void a(long l1, ap ap1)
    {
        Z = Pair.create(Long.valueOf(l1), ap1);
    }

    public void a(Activity activity)
    {
        v.add(new WeakReference(activity));
    }

    public void a(Uri uri)
    {
        S = uri;
    }

    public void a(ActivityType activitytype, Activity activity)
    {
        l.put(activitytype, activity);
    }

    public void a(EditViewActivity editviewactivity)
    {
        k = editviewactivity;
    }

    public void a(LauncherActivity launcheractivity)
    {
        j = launcheractivity;
    }

    public void a(MakeupItemMetadata makeupitemmetadata)
    {
        X = makeupitemmetadata;
    }

    public void a(ar ar1)
    {
        if (ar1 != null)
        {
            s = new ar(ar1);
            return;
        } else
        {
            s = null;
            return;
        }
    }

    public void a(GraphPlace graphplace)
    {
        V = graphplace;
    }

    public void a(Runnable runnable)
    {
        u.add(0, runnable);
    }

    public void a(ArrayList arraylist)
    {
        T = arraylist;
    }

    public void a(List list)
    {
        U = list;
    }

    public void a(boolean flag)
    {
        Y = flag;
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
        android.support.multidex.a.a(this);
    }

    public f b()
    {
        if (y == null)
        {
            y = new f(d().l(), d().m(), d().n(), d().o());
            y.b(M());
            y.a((new StringBuilder()).append(p()).append("/").toString());
        }
        return y;
    }

    public void b(Activity activity)
    {
        Object obj = new ArrayList();
        Iterator iterator = v.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            Activity activity1 = (Activity)weakreference.get();
            if (activity1 == null || activity1 == activity)
            {
                ((List) (obj)).add(weakreference);
            }
        } while (true);
        for (activity = ((List) (obj)).iterator(); activity.hasNext(); v.remove(obj))
        {
            obj = (WeakReference)activity.next();
        }

    }

    public void b(Context context)
    {
        if (m != null)
        {
            return;
        } else
        {
            m = new NetworkManager(context);
            return;
        }
    }

    public void b(Runnable runnable)
    {
        u.remove(runnable);
    }

    public void b(boolean flag)
    {
        A = flag;
    }

    public STORE_NAME c()
    {
        if (w == null)
        {
            String s1 = getApplicationContext().getResources().getString(0x7f07073d);
            if (s1 != null && !s1.isEmpty())
            {
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.STORE_NAME.b.a()))
                {
                    w = com.cyberlink.youcammakeup.STORE_NAME.b;
                } else
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.STORE_NAME.c.a()))
                {
                    w = com.cyberlink.youcammakeup.STORE_NAME.c;
                } else
                if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.STORE_NAME.d.a()))
                {
                    w = com.cyberlink.youcammakeup.STORE_NAME.d;
                } else
                {
                    w = com.cyberlink.youcammakeup.STORE_NAME.a;
                }
            }
            com.pf.common.utility.m.b("Globals", (new StringBuilder()).append("FN_STORE_NAME=").append(s1).toString());
        }
        return w;
    }

    public void c(String s1)
    {
        r = s1;
    }

    public boolean c(Activity activity)
    {
        for (Iterator iterator = v.iterator(); iterator.hasNext();)
        {
            BaseActivity baseactivity = (BaseActivity)((WeakReference)iterator.next()).get();
            if (baseactivity != null && baseactivity != activity && !baseactivity.b() && !baseactivity.isFinishing())
            {
                return false;
            }
        }

        return true;
    }

    public Integer e()
    {
        if (C != null)
        {
            return C;
        }
        Object obj;
        RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
        obj = randomaccessfile.readLine();
        obj = Pattern.compile("^MemTotal:\\s+(\\d+)\\s+kB$").matcher(((CharSequence) (obj)));
        randomaccessfile.close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (((Matcher) (obj)).groupCount() >= 1)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        return C;
        C = Integer.valueOf(Integer.parseInt(((Matcher) (obj)).group(1)));
_L2:
        return C;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void e(String s1)
    {
        if (!u())
        {
            Crashlytics.getInstance().core.log(s1);
        }
    }

    public bc f()
    {
        this;
        JVM INSTR monitorenter ;
        bc bc1;
        if (D == null)
        {
            D = new bc(this);
        }
        bc1 = D;
        this;
        JVM INSTR monitorexit ;
        return bc1;
        Exception exception;
        exception;
        throw exception;
    }

    public DisplayBroadcastReceiver g()
    {
        this;
        JVM INSTR monitorenter ;
        DisplayBroadcastReceiver displaybroadcastreceiver;
        if (E == null)
        {
            E = new DisplayBroadcastReceiver(this);
        }
        displaybroadcastreceiver = E;
        this;
        JVM INSTR monitorexit ;
        return displaybroadcastreceiver;
        Exception exception;
        exception;
        throw exception;
    }

    public com.cyberlink.youcammakeup.pages.libraryview.b h()
    {
        this;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.pages.libraryview.b b1;
        if (F == null)
        {
            F = new com.cyberlink.youcammakeup.pages.libraryview.b(this);
        }
        b1 = F;
        this;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public o i()
    {
        this;
        JVM INSTR monitorenter ;
        o o1;
        if (G == null)
        {
            G = new o();
        }
        o1 = G;
        this;
        JVM INSTR monitorexit ;
        return o1;
        Exception exception;
        exception;
        throw exception;
    }

    public MotionControlHelper j()
    {
        if (t == null)
        {
            t = MotionControlHelper.e();
        }
        return t;
    }

    public String k()
    {
        String s1 = null;
        this;
        JVM INSTR monitorenter ;
        if (H != null && !H.exists())
        {
            H = null;
        }
        if (H != null || H != null) goto _L2; else goto _L1
_L1:
        Object obj = getCacheDir();
        if (obj != null) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L4:
        obj = (new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append("/imagecache/").toString();
        H = new File(((String) (obj)));
        if (!H.exists())
        {
            H.mkdir();
        }
_L2:
        s1 = H.getAbsolutePath();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public String l()
    {
        return getApplicationInfo().nativeLibraryDir;
    }

    public String m()
    {
        this;
        JVM INSTR monitorenter ;
        if (J == null)
        {
            J = (new StringBuilder()).append(p()).append("/Davinci.cade").toString();
        }
        boolean flag = a("model/Davinci.cade");
        Object obj = "";
        File file = new File(J);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L12:
        Object obj1;
        int j1;
        obj1 = obj;
        j1 = i1;
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        b("model/Davinci.cade");
        obj1 = obj;
        j1 = i1;
          goto _L6
_L17:
        if (i1 >= 3) goto _L8; else goto _L7
_L7:
        FileOutputStream fileoutputstream;
        byte abyte0[];
        if (!file.exists())
        {
            file.createNewFile();
        }
        obj1 = getAssets().open("model/Davinci.cade");
        fileoutputstream = new FileOutputStream(J);
        abyte0 = new byte[1024];
_L11:
        j1 = ((InputStream) (obj1)).read(abyte0);
        if (j1 <= 0) goto _L10; else goto _L9
_L9:
        fileoutputstream.write(abyte0, 0, j1);
          goto _L11
        obj;
        throw new RuntimeException((new StringBuilder()).append("Cannot get Davinci.cade. msg=").append(((IOException) (obj)).getMessage()).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = be.a(d().getApplicationContext(), "model/Davinci.cade");
        if (((String) (obj)).equals(be.a(J)))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
          goto _L12
_L10:
        ((InputStream) (obj1)).close();
        fileoutputstream.close();
        obj1 = obj;
        if (!file.exists()) goto _L14; else goto _L13
_L13:
        obj1 = obj;
        if (((String) (obj)).isEmpty())
        {
            obj1 = be.a(d().getApplicationContext(), "model/Davinci.cade");
        }
        if (((String) (obj1)).equals(be.a(J)))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 == 0) goto _L16; else goto _L15
_L15:
        b("model/Davinci.cade");
_L8:
        obj = J;
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L16:
        com.pf.common.utility.m.e("Globals", "getFaceDetectModelPath copied model invalid, try again");
_L14:
        i1++;
        obj = obj1;
          goto _L17
_L2:
        j1 = 1;
        obj1 = obj;
_L6:
        if (j1 == 0) goto _L8; else goto _L18
_L18:
        i1 = 0;
        obj = obj1;
          goto _L17
    }

    public String n()
    {
        this;
        JVM INSTR monitorenter ;
        if (K == null)
        {
            K = (new StringBuilder()).append(p()).append("/Venus.regressor").toString();
        }
        boolean flag = a("model/Venus.regressor");
        Object obj = "";
        File file = new File(K);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L12:
        Object obj1;
        int j1;
        obj1 = obj;
        j1 = i1;
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        b("model/Venus.regressor");
        obj1 = obj;
        j1 = i1;
          goto _L6
_L17:
        if (i1 >= 3) goto _L8; else goto _L7
_L7:
        FileOutputStream fileoutputstream;
        byte abyte0[];
        if (!file.exists())
        {
            file.createNewFile();
        }
        obj1 = getAssets().open("model/Venus.regressor");
        fileoutputstream = new FileOutputStream(K);
        abyte0 = new byte[1024];
_L11:
        j1 = ((InputStream) (obj1)).read(abyte0);
        if (j1 <= 0) goto _L10; else goto _L9
_L9:
        fileoutputstream.write(abyte0, 0, j1);
          goto _L11
        obj;
        throw new RuntimeException((new StringBuilder()).append("Cannot get Venus.regressor. msg=").append(((IOException) (obj)).getMessage()).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = be.a(d().getApplicationContext(), "model/Venus.regressor");
        if (((String) (obj)).equals(be.a(K)))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
          goto _L12
_L10:
        ((InputStream) (obj1)).close();
        fileoutputstream.close();
        obj1 = obj;
        if (!file.exists()) goto _L14; else goto _L13
_L13:
        obj1 = obj;
        if (((String) (obj)).isEmpty())
        {
            obj1 = be.a(d().getApplicationContext(), "model/Venus.regressor");
        }
        if (((String) (obj1)).equals(be.a(K)))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 == 0) goto _L16; else goto _L15
_L15:
        b("model/Venus.regressor");
_L8:
        obj = K;
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L16:
        com.pf.common.utility.m.e("Globals", "getFaceAlignModelPath copied model invalid, try again");
_L14:
        i1++;
        obj = obj1;
          goto _L17
_L2:
        j1 = 1;
        obj1 = obj;
_L6:
        if (j1 == 0) goto _L8; else goto _L18
_L18:
        i1 = 0;
        obj = obj1;
          goto _L17
    }

    public String o()
    {
        this;
        JVM INSTR monitorenter ;
        if (L == null)
        {
            L = (new StringBuilder()).append(p()).append("/Venus.classifier").toString();
        }
        boolean flag = a("model/Venus.classifier");
        Object obj = "";
        File file = new File(L);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L12:
        Object obj1;
        int j1;
        obj1 = obj;
        j1 = i1;
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        b("model/Venus.classifier");
        obj1 = obj;
        j1 = i1;
          goto _L6
_L17:
        if (i1 >= 3) goto _L8; else goto _L7
_L7:
        FileOutputStream fileoutputstream;
        byte abyte0[];
        if (!file.exists())
        {
            file.createNewFile();
        }
        obj1 = getAssets().open("model/Venus.classifier");
        fileoutputstream = new FileOutputStream(L);
        abyte0 = new byte[1024];
_L11:
        j1 = ((InputStream) (obj1)).read(abyte0);
        if (j1 <= 0) goto _L10; else goto _L9
_L9:
        fileoutputstream.write(abyte0, 0, j1);
          goto _L11
        obj;
        throw new RuntimeException((new StringBuilder()).append("Cannot get Venus.classifier. msg=").append(((IOException) (obj)).getMessage()).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = be.a(d().getApplicationContext(), "model/Venus.classifier");
        if (((String) (obj)).equals(be.a(L)))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
          goto _L12
_L10:
        ((InputStream) (obj1)).close();
        fileoutputstream.close();
        obj1 = obj;
        if (!file.exists()) goto _L14; else goto _L13
_L13:
        obj1 = obj;
        if (((String) (obj)).isEmpty())
        {
            obj1 = be.a(d().getApplicationContext(), "model/Venus.classifier");
        }
        if (((String) (obj1)).equals(be.a(L)))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 == 0) goto _L16; else goto _L15
_L15:
        b("model/Venus.classifier");
_L8:
        obj = L;
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L16:
        com.pf.common.utility.m.e("Globals", "getGenderModelPath copied model invalid, try again");
_L14:
        i1++;
        obj = obj1;
          goto _L17
_L2:
        j1 = 1;
        obj1 = obj;
_L6:
        if (j1 == 0) goto _L8; else goto _L18
_L18:
        i1 = 0;
        obj = obj1;
          goto _L17
    }

    public void onCreate()
    {
        super.onCreate();
        q = this;
        B = a(this).processName.equals(getApplicationInfo().processName);
        if (!B)
        {
            return;
        }
        String s1;
        boolean flag;
        if ((getApplicationInfo().flags & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        N = flag;
        com.cyberlink.youcammakeup.kernelctrl.z.f(com.cyberlink.youcammakeup.widgetpool.a.b.a().b());
        if (!N)
        {
            Fabric.with(this, new Kit[] {
                new Crashlytics(), new CrashlyticsNdk()
            });
            Crashlytics.setUserIdentifier(com.cyberlink.youcammakeup.clflurry.b.b(getApplicationContext()));
            m.b = 3;
            m.a = true;
            Fabric.getLogger().setLogLevel(m.b);
        }
        com.cyberlink.youcammakeup.clflurry.b.a(this);
        e = Boolean.parseBoolean(getApplicationContext().getString(0x7f07073b));
        s1 = com.cyberlink.youcammakeup.baidupush.a.a(getApplicationContext(), "PushNotificationType");
        if (e && s1 != null && s1.equals("Baidu"))
        {
            com.pf.common.utility.m.b("Globals", "IsBaiduPushNotification=true");
            d = true;
            FrontiaApplication.initFrontiaApplication(getApplicationContext());
        }
        StorageMonitor.a().b();
        com.cyberlink.beautycircle.Globals.b(getApplicationContext());
    }

    public String p()
    {
        return getFilesDir().getAbsolutePath();
    }

    public String q()
    {
        return getFilesDir().getAbsolutePath();
    }

    public Exporter r()
    {
        this;
        JVM INSTR monitorenter ;
        Exporter exporter;
        if (M == null)
        {
            M = new Exporter();
        }
        exporter = M;
        this;
        JVM INSTR monitorexit ;
        return exporter;
        Exception exception;
        exception;
        throw exception;
    }

    public LauncherActivity s()
    {
        return j;
    }

    public EditViewActivity t()
    {
        return k;
    }

    public String v()
    {
        return r;
    }

    public NetworkManager w()
    {
        if (m == null)
        {
            b(this);
        }
        return m;
    }

    public Bitmap x()
    {
        if (O == null)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 480;
            options.inTargetDensity = (int)(getResources().getDisplayMetrics().density * 160F);
            O = BitmapFactory.decodeResource(getResources(), 0x7f0206d1, options);
        }
        return O;
    }

    public Bitmap y()
    {
        if (P == null)
        {
            P = BitmapFactory.decodeResource(getResources(), 0x7f0206d2);
        }
        return P;
    }

    public Bitmap z()
    {
        if (Q == null)
        {
            Q = BitmapFactory.decodeResource(getResources(), 0x7f02089a);
        }
        return Q;
    }

    static 
    {
        c = File.separator;
    }

    private class STORE_NAME extends Enum
    {

        public static final STORE_NAME a;
        public static final STORE_NAME b;
        public static final STORE_NAME c;
        public static final STORE_NAME d;
        private static final STORE_NAME e[];

        public static STORE_NAME valueOf(String s1)
        {
            return (STORE_NAME)Enum.valueOf(com/cyberlink/youcammakeup/Globals$STORE_NAME, s1);
        }

        public static STORE_NAME[] values()
        {
            return (STORE_NAME[])e.clone();
        }

        public abstract String a();

        public abstract boolean b();

        public abstract boolean c();

        static 
        {
            a = new STORE_NAME("Google", 0) {

                public String a()
                {
                    return "Google";
                }

                public boolean b()
                {
                    return true;
                }

                public boolean c()
                {
                    return false;
                }

            };
            b = new STORE_NAME("China", 1) {

                public String a()
                {
                    return "China";
                }

                public boolean b()
                {
                    return false;
                }

                public boolean c()
                {
                    return true;
                }

            };
            c = new STORE_NAME("Baidu", 2) {

                public String a()
                {
                    return "Baidu";
                }

                public boolean b()
                {
                    return false;
                }

                public boolean c()
                {
                    return true;
                }

            };
            d = new STORE_NAME("Huawei", 3) {

                public String a()
                {
                    return "Huawei";
                }

                public boolean b()
                {
                    return false;
                }

                public boolean c()
                {
                    return true;
                }

            };
            e = (new STORE_NAME[] {
                a, b, c, d
            });
        }

        private STORE_NAME(String s1, int i1)
        {
            super(s1, i1);
        }

    }

}
