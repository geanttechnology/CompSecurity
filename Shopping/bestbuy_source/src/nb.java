// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.adobe.mobile.Analytics;
import com.adobe.mobile.Config;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executor;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class nb
{

    private static boolean C = true;
    public static boolean c = false;
    public static String d[] = {
        "Sidemenu", "Hometiles", "Dealcards", "StoresOutletItems"
    };
    public static String e = "phone:Android";
    public static int f = 1;
    public static final Executor g;
    public static final Executor h;
    public static String k = "entry_point";
    public static String l = "pageName";
    public static String m = "fromSideNav";
    public static String n = "fromShake";
    private static final String o = nb.getSimpleName();
    private static nb p;
    private mr A;
    private ArrayList B;
    private double D;
    private double E;
    private boolean F;
    private Fragment G;
    private Map H;
    private HashMap I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private String P;
    private String Q;
    private boolean R;
    private String S;
    public Map a;
    public lr b;
    public String i;
    public Stack j;
    private float q;
    private float r;
    private float s;
    private int t;
    private int u;
    private float v;
    private float w;
    private Display x;
    private String y;
    private Context z;

    protected nb(Context context)
    {
        q = 0.0F;
        r = 0.0F;
        s = 0.0F;
        t = 0;
        u = 0;
        v = 0.0F;
        w = 0.0F;
        x = null;
        y = "";
        B = new ArrayList();
        F = false;
        G = null;
        H = new HashMap();
        I = new HashMap();
        J = false;
        K = false;
        L = false;
        M = false;
        N = false;
        i = "";
        j = new Stack();
        z = context;
        p = this;
        b(context);
        ad();
    }

    public static nb a()
    {
        if (p != null)
        {
            return p;
        } else
        {
            kf.a(o, new Exception("BBYAppData has not yet been initialized."));
            return null;
        }
    }

    public static void a(Context context)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int j1 = astacktraceelement.length;
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < j1)
                {
                    if (astacktraceelement[i1].getClassName().compareTo("com.bestbuy.android.base.BBYApplication") != 0)
                    {
                        break label0;
                    }
                    kf.c(o, "Found correct class!  Setting Instance.");
                    p = new nb(context);
                }
                lu.a(context);
                return;
            }
            i1++;
        } while (true);
    }

    private void ad()
    {
        String s1 = ((TelephonyManager)z.getSystemService("phone")).getLine1Number();
        if (s1 != null)
        {
            String s2 = PhoneNumberUtils.stripSeparators(s1);
            s1 = s2;
            if (s2.length() == 11)
            {
                s1 = s2;
                if (s2.startsWith("1"))
                {
                    s1 = s2.substring(1);
                }
            }
            y = s1;
        }
    }

    private String b(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            P = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
            context = P;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            kf.a(o, context);
            P = "Version 1.0";
            return P;
        }
        return context;
    }

    public static String q()
    {
        return Build.MODEL;
    }

    public String A()
    {
        return b().getString("APP_STATE", "");
    }

    public ArrayList B()
    {
        return new ArrayList(Arrays.asList(b().getString("RECENTLY_UPDATE_LIST_UUID", "").split("\\s*,\\s*")));
    }

    public boolean C()
    {
        return b().getBoolean("IS_GIFT_ADDED_TO_LIST", false);
    }

    public String D()
    {
        return b().getString("LE_CURRENT_MODULE", "");
    }

    public Boolean E()
    {
        return Boolean.valueOf(b().getBoolean("IS_REGISTRY_UPDATED", false));
    }

    public boolean F()
    {
        return b().getBoolean("is_user_logged_in", false);
    }

    public boolean G()
    {
        return b().getBoolean("is_ut_cookie_reset", false);
    }

    public boolean H()
    {
        return F;
    }

    public Fragment I()
    {
        return G;
    }

    public String J()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.g();
        s2 = s1;
        Object obj = Calendar.getInstance();
        s2 = s1;
        ((Calendar) (obj)).add(13, 0x28206f);
        s2 = s1;
        hashmap.put("Expires", (new StringBuilder()).append("").append(((Calendar) (obj)).getTime()).toString());
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        s2 = s1;
        obj = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_190;
        }
        s2 = s1;
        obj = ((String)iterator.next()).toString();
        s2 = s1;
        if (hashmap.get(obj) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s3 = ((String)hashmap.get(obj)).toString();
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(((String) (obj))).append("=").append(s3).append(";").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        obj = s2;
        return ((String) (obj));
    }

    public String K()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.h();
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        String s3;
        s2 = s1;
        s3 = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        s2 = s1;
        s3 = ((String)iterator.next()).toString();
        s2 = s1;
        if (hashmap.get(s3) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s4 = ((String)hashmap.get(s3)).toString();
        s2 = s1;
        if (s3.equals("Secure"))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(s3).append("=").append(s4).append(";").toString();
          goto _L2
        s2 = s1;
        if (!s4.equals("true")) goto _L2; else goto _L3
_L3:
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append("Secure;").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        s3 = s2;
        return s3;
    }

    public String L()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.c();
        s2 = s1;
        Object obj = Calendar.getInstance();
        s2 = s1;
        ((Calendar) (obj)).add(13, 0x28206f);
        s2 = s1;
        hashmap.put("Expires", (new StringBuilder()).append("").append(((Calendar) (obj)).getTime()).toString());
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        s2 = s1;
        obj = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_248;
        }
        s2 = s1;
        obj = ((String)iterator.next()).toString();
        s2 = s1;
        if (!((String) (obj)).equals("s_app"))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        s2 = s1;
        if (hashmap.get(obj) != null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        s2 = s1;
        hashmap.put("s_app", p());
        s2 = s1;
        na.c().put("s_app", p());
        s2 = s1;
        if (hashmap.get(obj) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s3 = ((String)hashmap.get(obj)).toString();
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(((String) (obj))).append("=").append(s3).append(";").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        obj = s2;
        return ((String) (obj));
    }

    public String M()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.d();
        s2 = s1;
        Object obj = Calendar.getInstance();
        s2 = s1;
        ((Calendar) (obj)).add(13, 0x28206f);
        s2 = s1;
        hashmap.put("Expires", (new StringBuilder()).append("").append(((Calendar) (obj)).getTime()).toString());
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        s2 = s1;
        obj = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_190;
        }
        s2 = s1;
        obj = ((String)iterator.next()).toString();
        s2 = s1;
        if (hashmap.get(obj) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s3 = ((String)hashmap.get(obj)).toString();
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(((String) (obj))).append("=").append(s3).append(";").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        obj = s2;
        return ((String) (obj));
    }

    public String N()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.e();
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        String s3;
        s2 = s1;
        s3 = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s2 = s1;
        s3 = ((String)iterator.next()).toString();
        s2 = s1;
        if (hashmap.get(s3) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s4 = ((String)hashmap.get(s3)).toString();
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(s3).append("=").append(s4).append(";").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        s3 = s2;
        return s3;
    }

    public String O()
    {
        String s1;
        String s2;
        s1 = "";
        s2 = s1;
        HashMap hashmap = na.f();
        s2 = s1;
        Iterator iterator = hashmap.keySet().iterator();
_L2:
        String s3;
        s2 = s1;
        s3 = s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s2 = s1;
        s3 = ((String)iterator.next()).toString();
        s2 = s1;
        if (hashmap.get(s3) == null) goto _L2; else goto _L1
_L1:
        s2 = s1;
        String s4 = ((String)hashmap.get(s3)).toString();
        s2 = s1;
        s1 = (new StringBuilder()).append(s1).append(s3).append("=").append(s4).append(";").toString();
          goto _L2
        Exception exception;
        exception;
        kf.a("Exception", exception);
        s3 = s2;
        return s3;
    }

    public HashMap P()
    {
        return I;
    }

    public boolean Q()
    {
        return J;
    }

    public boolean R()
    {
        return K;
    }

    public String S()
    {
        return i;
    }

    public String T()
    {
        if (j.size() == 1)
        {
            return (String)j.peek();
        } else
        {
            return (String)j.pop();
        }
    }

    public Stack U()
    {
        return j;
    }

    public boolean V()
    {
        return L;
    }

    public boolean W()
    {
        return N;
    }

    public boolean X()
    {
        return M;
    }

    public String Y()
    {
        return Q;
    }

    public boolean Z()
    {
        return O;
    }

    public float a(int i1)
    {
        r = ((float)i1 / 320F) * (float)u();
        return r;
    }

    public void a(double d1)
    {
        D = d1;
    }

    public void a(Fragment fragment)
    {
        G = fragment;
    }

    public void a(String s1)
    {
        b().edit().putString(z.getResources().getString(0x7f080041), s1).commit();
    }

    public void a(String s1, Context context)
    {
        gw.a().getCookieStore().clear();
        s1 = CookieManager.getInstance();
        s1.removeAllCookie();
        s1.removeSessionCookie();
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().sync();
    }

    public void a(ArrayList arraylist)
    {
        Iterator iterator = arraylist.iterator();
        String s1;
        for (arraylist = ""; iterator.hasNext(); arraylist = (new StringBuilder()).append(arraylist).append(",").append(s1).toString())
        {
            s1 = (String)iterator.next();
        }

        b().edit().putString("RECENTLY_UPDATE_LIST_UUID", arraylist).commit();
    }

    public void a(HashMap hashmap)
    {
        I.putAll(hashmap);
    }

    public void a(mr mr1)
    {
        A = mr1;
    }

    public void a(boolean flag)
    {
        C = flag;
    }

    public boolean aa()
    {
        return R;
    }

    public String ab()
    {
        return S;
    }

    public boolean ac()
    {
        return b().getBoolean(z.getResources().getString(0x7f080061), false);
    }

    public float b(int i1)
    {
        s = ((float)i1 / 480F) * (float)v();
        return s;
    }

    public SharedPreferences b()
    {
        return z.getSharedPreferences(z.getResources().getString(0x7f08007f), 0);
    }

    public void b(double d1)
    {
        E = d1;
    }

    public void b(String s1)
    {
        b().edit().putString(z.getResources().getString(0x7f080042), s1).commit();
    }

    public void b(boolean flag)
    {
        b().edit().putBoolean("IS_GIFT_ADDED_TO_LIST", flag).commit();
    }

    public SharedPreferences c()
    {
        return z.getSharedPreferences(z.getResources().getString(0x7f08007e), 0);
    }

    public void c(String s1)
    {
        b().edit().putString("APP_STATE", s1).commit();
    }

    public void c(boolean flag)
    {
        b().edit().putBoolean("IS_REGISTRY_UPDATED", flag).commit();
    }

    public String d()
    {
        return z.getResources().getString(0x7f080153);
    }

    public void d(String s1)
    {
        b().edit().putString("LAST_LOGIN_EMAIL_ID", s1).commit();
    }

    public void d(boolean flag)
    {
        b().edit().putBoolean("is_user_logged_in", flag).commit();
    }

    public String e()
    {
        return z.getResources().getString(0x7f0802b3);
    }

    public void e(String s1)
    {
        String s2 = b().getString("RECENTLY_UPDATE_LIST_UUID", "");
        if (!(new ArrayList(Arrays.asList(s2.split("\\s*,\\s*")))).contains(s1))
        {
            s1 = (new StringBuilder()).append(s2).append(",").append(s1).toString();
            b().edit().putString("RECENTLY_UPDATE_LIST_UUID", s1).commit();
        }
    }

    public void e(boolean flag)
    {
        b().edit().putBoolean("is_ut_cookie_reset", flag).commit();
    }

    public String f()
    {
        return z.getResources().getString(0x7f0800df);
    }

    public void f(String s1)
    {
        b().edit().putString("LE_CURRENT_MODULE", s1).commit();
    }

    public void f(boolean flag)
    {
        b().edit().putBoolean("refresh_mybby", flag).commit();
    }

    public String g()
    {
        ft ft1 = na.b();
        if (ft1 == ft.a)
        {
            return z.getResources().getString(0x7f08031e);
        }
        if (ft1 == ft.e)
        {
            return z.getResources().getString(0x7f080323);
        }
        if (ft1 == ft.h)
        {
            return z.getResources().getString(0x7f080321);
        }
        if (ft1 == ft.d)
        {
            return z.getResources().getString(0x7f080325);
        }
        if (ft1 == ft.i)
        {
            return z.getResources().getString(0x7f08031c);
        } else
        {
            return "";
        }
    }

    public String g(String s1)
    {
        String s2;
        s2 = "";
        if (H != null && !H.isEmpty())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        Object obj;
        obj = z.getAssets().open("colorcodes.json");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        gw.a(((InputStream) (obj)), bytearrayoutputstream);
        ((InputStream) (obj)).close();
        obj = new JSONArray(new String(bytearrayoutputstream.toByteArray()));
        int i1 = 0;
_L1:
        JSONObject jsonobject;
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        jsonobject = ((JSONArray) (obj)).optJSONObject(i1);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        H.put(jsonobject.optString("colorname"), jsonobject.optString("colorcode"));
        i1++;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
        if (!H.isEmpty())
        {
            s2 = (String)H.get(s1.toLowerCase(Locale.US));
        }
        return s2;
    }

    public void g(boolean flag)
    {
        F = flag;
    }

    public String h()
    {
        ft ft1 = na.a();
        if (ft1 == ft.a)
        {
            return z.getResources().getString(0x7f080320);
        }
        if (ft1 == ft.e)
        {
            return z.getResources().getString(0x7f080324);
        }
        if (ft1 == ft.h)
        {
            return z.getResources().getString(0x7f080322);
        }
        if (ft1 == ft.d)
        {
            return z.getResources().getString(0x7f080326);
        }
        if (ft1 == ft.i)
        {
            return z.getResources().getString(0x7f08031d);
        } else
        {
            return "";
        }
    }

    public void h(String s1)
    {
        i = s1;
    }

    public void h(boolean flag)
    {
        J = flag;
    }

    public String i()
    {
        return z.getResources().getString(0x7f08021c);
    }

    public void i(String s1)
    {
        j.push(s1);
    }

    public void i(boolean flag)
    {
        K = flag;
    }

    public String j()
    {
        return z.getResources().getString(0x7f0801b2);
    }

    public void j(String s1)
    {
        Q = s1;
    }

    public void j(boolean flag)
    {
        L = flag;
    }

    public String k()
    {
        return z.getResources().getString(0x7f080253);
    }

    public void k(String s1)
    {
        S = s1;
    }

    public void k(boolean flag)
    {
        N = flag;
    }

    public String l()
    {
        return P;
    }

    public void l(boolean flag)
    {
        M = flag;
    }

    public String m()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public void m(boolean flag)
    {
        O = flag;
    }

    public lr n()
    {
        if (b == null)
        {
            b = new lr();
        }
        return b;
    }

    public void n(boolean flag)
    {
        R = flag;
    }

    public HashMap o()
    {
        HashMap hashmap = new HashMap();
        if (a != null)
        {
            String s1 = z.getResources().getString(0x7f08005c);
            hashmap.put(s1, a.get(s1));
            s1 = z.getResources().getString(0x7f08005e);
            hashmap.put(s1, a.get(s1));
            s1 = z.getResources().getString(0x7f08005d);
            hashmap.put(s1, a.get(s1));
        }
        return hashmap;
    }

    public void o(boolean flag)
    {
        b().edit().putBoolean(z.getResources().getString(0x7f080061), flag).commit();
    }

    public String p()
    {
        return ((TelephonyManager)z.getSystemService("phone")).getDeviceId();
    }

    public String r()
    {
        String s1;
label0:
        {
            String s2 = Config.getUserIdentifier();
            if (s2 != null)
            {
                s1 = s2;
                if (s2.length() > 0)
                {
                    break label0;
                }
            }
            s1 = Analytics.getTrackingIdentifier();
        }
        return s1;
    }

    public String s()
    {
        return b().getString(z.getResources().getString(0x7f080042), "");
    }

    public Display t()
    {
        if (x == null)
        {
            x = ((WindowManager)z.getSystemService("window")).getDefaultDisplay();
        }
        return x;
    }

    public int u()
    {
        if (t == 0)
        {
            Display display = t();
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                Point point = new Point();
                display.getSize(point);
                t = point.x;
            } else
            {
                t = display.getWidth();
            }
        }
        return t;
    }

    public int v()
    {
        if (u == 0)
        {
            Display display = t();
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                Point point = new Point();
                display.getSize(point);
                u = point.y;
            } else
            {
                u = display.getHeight();
            }
        }
        return u;
    }

    public mr w()
    {
        if (A != null)
        {
            return A;
        } else
        {
            A = new mr();
            return A;
        }
    }

    public boolean x()
    {
        return C;
    }

    public double y()
    {
        return D;
    }

    public double z()
    {
        return E;
    }

    static 
    {
        g = AsyncTask.SERIAL_EXECUTOR;
        h = AsyncTask.SERIAL_EXECUTOR;
    }
}
