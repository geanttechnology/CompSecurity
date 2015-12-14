// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.uma.g;
import com.nostra13.universalimageloader.a.a.a.b;
import com.nostra13.universalimageloader.b.f;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.download.a;
import com.nostra13.universalimageloader.core.i;
import com.perfectcorp.utility.ConfigHelper;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import com.perfectcorp.utility.t;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity, m

public class Globals extends ContextWrapper
{

    private static String A;
    private static String B = "ForAndroid";
    private static String C;
    private static String D = null;
    private static String E;
    private static String F;
    private static String G;
    private static String H;
    private static String I = "4.4";
    private static String J = "gcm";
    private static String K = "Mozilla/5.0";
    private static int L = 1;
    private static int M[] = {
        5, 15, 30
    };
    private static com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig N = null;
    private static float O = 3F;
    private static String P = "PRODUCTION";
    private static j Q = null;
    private static Integer R = null;
    private static Toast W = null;
    public static final String a = System.getProperty("line.separator");
    public static final String b;
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.getDefault());
    public static BaseActivity d = null;
    public static com.cyberlink.beautycircle.controller.adapter.a e = null;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = true;
    public static boolean i = true;
    public static Boolean j = null;
    public static boolean k = true;
    public static boolean l = false;
    public static boolean m = false;
    public static Boolean n = null;
    public static boolean o = false;
    private static int q = 0;
    private static String r;
    private static String s;
    private static boolean t = false;
    private static Context u;
    private static Globals v;
    private static final List x = Collections.synchronizedList(new LinkedList());
    private static String z = null;
    private File S;
    private File T;
    private long U;
    private boolean V;
    public boolean p;
    private String w;
    private STORE_NAME y;

    private Globals(Context context)
    {
        super(context);
        w = null;
        y = null;
        p = true;
        S = null;
        T = null;
        U = -1L;
        V = false;
    }

    public static String A()
    {
        return H;
    }

    public static String B()
    {
        return I;
    }

    public static String C()
    {
        return J;
    }

    public static SharedPreferences D()
    {
        return n().getApplicationContext().getSharedPreferences("BeautyCircle", 0);
    }

    public static boolean E()
    {
        if (n != null)
        {
            return n.booleanValue();
        } else
        {
            Boolean boolean1 = Boolean.valueOf(D().getBoolean("IsFirstTime", true));
            n = boolean1;
            return boolean1.booleanValue();
        }
    }

    static int F()
    {
        return L;
    }

    static String G()
    {
        return P;
    }

    static Toast H()
    {
        return W;
    }

    private static void I()
    {
        (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                if (Globals.l())
                {
                    if (!com.cyberlink.beautycircle.controller.gcm.a.a(Globals.n()))
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "No Google Play Services"
                        });
                    } else
                    {
                        void1 = com.cyberlink.beautycircle.controller.gcm.a.c(Globals.n());
                        com.cyberlink.beautycircle.controller.gcm.a.b(Globals.n()).a(new m(this, void1) {

                            final String a;
                            final _cls8 b;

                            protected void a(com.cyberlink.beautycircle.controller.gcm.b b1)
                            {
                                if (b1 == null || b1.a != 1)
                                {
                                    com.cyberlink.beautycircle.Globals.b("GCM register failed");
                                } else
                                {
                                    com.cyberlink.beautycircle.Globals.b("GCM register successfully");
                                    if (b1.b != null && !b1.b.isEmpty() && (a == null || !b1.b.equals(a)))
                                    {
                                        NetworkManager.a(AccountManager.a());
                                        return;
                                    }
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((com.cyberlink.beautycircle.controller.gcm.b)obj);
                            }

            
            {
                b = _pcls8;
                a = s1;
                super();
            }
                        });
                    }
                }
                return null;
            }

        }).d(null);
    }

    public static int a(int i1)
    {
        return (int)((float)i1 * O);
    }

    public static long a(Long long1)
    {
        if (long1 != null)
        {
            return long1.longValue();
        } else
        {
            return 0L;
        }
    }

    static Toast a(Toast toast)
    {
        W = toast;
        return toast;
    }

    public static String a(Activity activity)
    {
        if (activity == null)
        {
            return "";
        }
        int i1 = activity.getResources().getDisplayMetrics().densityDpi;
        switch (i1)
        {
        default:
            return String.format(Locale.getDefault(), "Unknow(%d)", new Object[] {
                Integer.valueOf(i1)
            });

        case 120: // 'x'
            return "ldpi";

        case 160: 
            return "mdpi";

        case 240: 
            return "hdpi";

        case 320: 
            return "xhdpi";

        case 480: 
            return "xxhdpi";

        case 640: 
            return "xxxhdpi";

        case 213: 
            return "tvdpi";

        case 400: 
            return "400dpi";
        }
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

    public static void a()
    {
        (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                Globals.D().edit().putBoolean("IsFirstTime", false).apply();
                return null;
            }

        }).d(null);
        n = Boolean.valueOf(false);
    }

    public static void a(Dialog dialog, int i1)
    {
        View view = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (view != null)
        {
            view.setBackgroundColor(i1);
        }
        dialog = (TextView)dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        if (dialog != null)
        {
            dialog.setTextColor(i1);
        }
    }

    public static void a(Context context)
    {
        File file = com.nostra13.universalimageloader.b.f.a(context);
        context = (new i(context)).a(3).b(7).a(QueueProcessingType.b).a().d(13).a(new b(file)).e(0x3200000).f(100).a(new com.nostra13.universalimageloader.a.a.b.b()).a(new a(context)).a(new com.nostra13.universalimageloader.core.a.a(false)).a(com.nostra13.universalimageloader.core.d.t()).c();
        com.nostra13.universalimageloader.core.f.b().a(context);
    }

    public static void a(com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig feedbackconfig)
    {
        N = feedbackconfig;
        if (N != null)
        {
            N.product = "BeautyCircle";
            N.bNeedLog = false;
        }
    }

    public static void a(CharSequence charsequence)
    {
        a(charsequence, 1);
    }

    public static void a(CharSequence charsequence, int i1)
    {
        if (d != null)
        {
            d.runOnUiThread(new Runnable(charsequence, i1) {

                final CharSequence a;
                final int b;

                public void run()
                {
                    if (Globals.H() != null)
                    {
                        Globals.H().cancel();
                    }
                    com.cyberlink.beautycircle.Globals.a(Toast.makeText(Globals.n(), a, b));
                    Globals.H().show();
                }

            
            {
                a = charsequence;
                b = i1;
                super();
            }
            });
        }
    }

    public static void a(String s1)
    {
        P = s1;
    }

    public static void a(String s1, int i1)
    {
        if (i())
        {
            a(((CharSequence) ((new StringBuilder()).append("[DEBUG] ").append(s1).toString())), i1);
        }
    }

    public static boolean a(Boolean boolean1)
    {
        return boolean1 != null && boolean1 == Boolean.TRUE;
    }

    public static boolean a(boolean flag)
    {
        boolean flag1 = false;
        int i1;
        if (flag)
        {
            L = M[M.length - 1] + 1;
        } else
        {
            L++;
        }
        b((new StringBuilder()).append("Number of Launch: ").append(L).toString());
        (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                Globals.D().edit().putInt("NumOfLaunch", Globals.F()).apply();
                return null;
            }

        }).d(null);
        i1 = 0;
        do
        {
label0:
            {
                flag = flag1;
                if (i1 < M.length)
                {
                    if (M[i1] != L)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    public static int b(int i1)
    {
        return (int)n().getResources().getDimension(i1);
    }

    public static void b()
    {
        (new j() {

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                Globals.D().edit().putBoolean("ViewedHowTo", true).apply();
                return null;
            }

        }).d(null);
        o = true;
    }

    public static void b(Context context)
    {
        u = context;
    }

    public static void b(String s1)
    {
        a(s1, 1);
    }

    public static void b(boolean flag)
    {
        t = flag;
    }

    public static boolean b(Activity activity)
    {
        boolean flag;
        List list = ((ActivityManager)activity.getSystemService("activity")).getRunningTasks(10);
        if (((android.app.ActivityManager.RunningTaskInfo)list.get(0)).numActivities != 1)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        flag = ((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getClassName().equals(activity.getClass().getName());
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_71;
        activity;
        activity.printStackTrace();
        return false;
    }

    static int c(int i1)
    {
        L = i1;
        return i1;
    }

    public static Globals c(Context context)
    {
        if (v == null)
        {
            Context context1 = context;
            if (context == null)
            {
                context1 = u;
            }
            context = new Globals(context1.getApplicationContext());
            e.b = context1.getApplicationContext();
            context.k();
        }
        return v;
    }

    public static j c(String s1)
    {
        return (new j() {

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                android.content.SharedPreferences.Editor editor = Globals.n().getApplicationContext().getSharedPreferences("BeautyCircleResumeActivityFile", 0).edit();
                editor.putString("BeautyCircleResumeActivity", s2);
                editor.apply();
                return null;
            }

        }).d(s1);
    }

    public static String c()
    {
        return s;
    }

    public static SharedPreferences d(Context context)
    {
        return context.getSharedPreferences("BeautyCircle", 0);
    }

    static String d(String s1)
    {
        s = s1;
        return s1;
    }

    public static boolean d()
    {
        return t;
    }

    public static String e()
    {
        return P;
    }

    public static j f()
    {
        if (Q != null)
        {
            Q.a(true);
            Q = null;
        }
        Q = (new j() {

            protected Boolean a(Void void1)
            {
                boolean flag = false;
                void1 = Globals.G();
                Globals.D().edit().putString("BC_Server_Mode", void1).commit();
                com.cyberlink.beautycircle.Globals.d(Globals.G());
                flag = true;
_L2:
                return Boolean.valueOf(flag);
                void1;
                void1.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

        }).d(null);
        return Q;
    }

    public static void g()
    {
        if (q < 2)
        {
            q = 2;
            e.a = true;
        }
    }

    public static void h()
    {
        if (q < 1)
        {
            q = 1;
        }
    }

    public static boolean i()
    {
        if (q >= 2 || n().p())
        {
            e.a = true;
            q = 2;
        }
        return e.a;
    }

    public static boolean j()
    {
        return q >= 1;
    }

    public static boolean l()
    {
        if (j == null)
        {
            String s1 = a(n().getApplicationContext(), "BCStandAlone");
            if (s1 != null && s1.equals("BeautyCircle"))
            {
                j = Boolean.valueOf(true);
            } else
            {
                j = Boolean.valueOf(false);
            }
        }
        return j.booleanValue();
    }

    public static boolean m()
    {
        return l();
    }

    public static Globals n()
    {
        return c(d);
    }

    public static Integer o()
    {
        if (R != null)
        {
            return R;
        }
        Object obj;
        RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
        obj = randomaccessfile.readLine();
        obj = Pattern.compile("^MemTotal:\\s+(\\d+)\\s+kB$").matcher(((CharSequence) (obj)));
        randomaccessfile.close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (((Matcher) (obj)).groupCount() >= 1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        return R;
        R = Integer.valueOf(Integer.parseInt(((Matcher) (obj)).group(1)));
_L2:
        return R;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String q()
    {
        return K;
    }

    public static boolean r()
    {
        boolean flag = (new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/beautycircle/demobuild.config").toString())).exists();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        com.perfectcorp.utility.e.e(new Object[] {
            "demo build"
        });
        return flag;
        Exception exception;
        exception;
        flag = false;
_L2:
        exception.printStackTrace();
        return flag;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String s()
    {
        String s1 = n().getPackageName();
        if (s1.equalsIgnoreCase("com.cyberlink.youperfect"))
        {
            z = "YCP";
        } else
        if (s1.equalsIgnoreCase("com.cyberlink.youcammakeup"))
        {
            z = "YMK";
        } else
        if (s1.equalsIgnoreCase("com.perfectcorp.ycn"))
        {
            z = "YCN";
        } else
        {
            z = "YMK";
        }
        return z;
    }

    public static String t()
    {
        return A;
    }

    public static String u()
    {
        return B;
    }

    public static String v()
    {
        return C;
    }

    public static String w()
    {
        if (D == null)
        {
            D = com.cyberlink.uma.g.a(n().getApplicationContext());
        }
        return D;
    }

    public static String x()
    {
        return E;
    }

    public static String y()
    {
        return F;
    }

    public static String z()
    {
        return G;
    }

    public void a(Class class1)
    {
        if (class1 == null)
        {
            w = "";
        } else
        {
            w = class1.getSimpleName();
        }
        c(w);
    }

    public void a(Runnable runnable)
    {
        x.add(0, runnable);
    }

    public void b(Runnable runnable)
    {
        x.remove(runnable);
    }

    public void k()
    {
        if (i && q == 2 && android.os.Build.VERSION.SDK_INT < 21)
        {
            com.perfectcorp.utility.e.c(new Object[] {
                "Enable StrickMode"
            });
            DisplayMetrics displaymetrics;
            String as[];
            int i1;
            int j1;
            try
            {
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog().build());
                StrictMode.setVmPolicy((new android.os.StrictMode.VmPolicy.Builder()).detectAll().penaltyLog().build());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        v = this;
        Thread.setDefaultUncaughtExceptionHandler(new com.perfectcorp.utility.b());
        (new j() {

            final Globals a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                void1 = Globals.D();
                if (Globals.r())
                {
                    com.cyberlink.beautycircle.Globals.d("DEMO1");
                } else
                {
                    String s1 = void1.getString("BC_Server_Mode", "PRODUCTION");
                    if (s1 == null)
                    {
                        com.cyberlink.beautycircle.Globals.d("PRODUCTION");
                    } else
                    {
                        com.cyberlink.beautycircle.Globals.d(s1);
                    }
                }
                Globals.n = Boolean.valueOf(void1.getBoolean("IsFirstTime", true));
                Globals.o = void1.getBoolean("ViewedHowTo", false);
                Globals.c(void1.getInt("NumOfLaunch", 1));
                return null;
            }

            
            {
                a = Globals.this;
                super();
            }
        }).d(null);
        E = Build.MODEL;
        F = Build.MANUFACTURER;
        G = Build.CPU_ABI;
        displaymetrics = new DisplayMetrics();
        ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        i1 = displaymetrics.widthPixels;
        j1 = displaymetrics.heightPixels;
        if (i1 > 0 && j1 > 0)
        {
            H = (new StringBuilder()).append(String.valueOf(j1)).append("x").append(String.valueOf(i1)).toString();
        }
        O = displaymetrics.density;
        C = getString(m.BC_BUILD_NUMBER);
        as = C.split("\\.", 4);
        if (as.length >= 3)
        {
            A = String.format("%s.%s.%s", new Object[] {
                as[0], as[1], as[2]
            });
        } else
        {
            A = C;
        }
        if (!p() && l())
        {
            Fabric.with(this, new Kit[] {
                new Crashlytics()
            });
            Crashlytics.setUserIdentifier(com.cyberlink.uma.g.a(this));
        }
        com.perfectcorp.a.b.a(this, getResources().getString(m.share_clflurry_app_key));
        com.perfectcorp.utility.e.b(new Object[] {
            (new StringBuilder()).append("Application startup. Build version :").append(v()).toString()
        });
        (new AsyncTask() {

            final Globals a;

            protected transient Void a(Void avoid[])
            {
                com.perfectcorp.utility.e.c();
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = Globals.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
        a(getApplicationContext());
        I();
        ConfigHelper.a();
        AccountManager.l();
        i();
        com.perfectcorp.utility.t.b();
    }

    public boolean p()
    {
        return (getApplicationInfo().flags & 2) != 0;
    }

    static 
    {
        b = File.separator;
        r = "PRODUCTION";
        s = r;
    }
}
