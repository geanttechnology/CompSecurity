// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.a.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.e.b;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.m;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.a;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            gj, ay, ax, o, 
//            gn, gt, gi, gl, 
//            aq

public final class gm
{
    private final class a extends BroadcastReceiver
    {

        final gm a;

        public final void onReceive(Context context, Intent intent)
        {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
            {
                com.google.android.gms.d.gm.a(a, true);
            } else
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
            {
                com.google.android.gms.d.gm.a(a, false);
                return;
            }
        }

        private a()
        {
            a = gm.this;
            super();
        }

        public a(byte byte0)
        {
            this();
        }
    }


    public static final Handler a = new gj(Looper.getMainLooper());
    private static final String d = com/google/android/gms/ads/e.getName();
    private static final String e = com/google/android/gms/ads/f.getName();
    private static final String f = com/google/android/gms/ads/a/d.getName();
    private static final String g = com/google/android/gms/ads/a/e.getName();
    private static final String h = com/google/android/gms/ads/e/b.getName();
    private static final String i = com/google/android/gms/ads/b.getName();
    public boolean b;
    public boolean c;
    private final Object j = new Object();
    private String k;

    public gm()
    {
        b = true;
        c = false;
    }

    public static Bitmap a(View view)
    {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public static DisplayMetrics a(WindowManager windowmanager)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static PopupWindow a(View view, int l, int i1)
    {
        return new PopupWindow(view, l, i1, false);
    }

    static Object a(gm gm1)
    {
        return gm1.j;
    }

    public static String a()
    {
        Object obj;
        byte abyte0[];
        byte abyte1[];
        int l;
        obj = UUID.randomUUID();
        abyte0 = BigInteger.valueOf(((UUID) (obj)).getLeastSignificantBits()).toByteArray();
        abyte1 = BigInteger.valueOf(((UUID) (obj)).getMostSignificantBits()).toByteArray();
        obj = (new BigInteger(1, abyte0)).toString();
        l = 0;
_L2:
        if (l >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1;
        obj1 = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj1)).update(abyte0);
        ((MessageDigest) (obj1)).update(abyte1);
        byte abyte2[] = new byte[8];
        System.arraycopy(((MessageDigest) (obj1)).digest(), 0, abyte2, 0, 8);
        obj1 = (new BigInteger(1, abyte2)).toString();
        obj = obj1;
_L3:
        l++;
        if (true) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
          goto _L3
    }

    public static String a(Context context, View view, AdSizeParcel adsizeparcel)
    {
        au au = ay.W;
        if (!((Boolean)p.n().a(au)).booleanValue())
        {
            return null;
        }
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("width", adsizeparcel.f);
        jsonobject1.put("height", adsizeparcel.c);
        jsonobject.put("size", jsonobject1);
        jsonobject.put("activity", f(context));
        if (adsizeparcel.e) goto _L2; else goto _L1
_L1:
        context = new JSONArray();
_L8:
        if (view == null) goto _L4; else goto _L3
_L3:
        int l;
        try
        {
            adsizeparcel = view.getParent();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        if (adsizeparcel == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        l = -1;
        if (adsizeparcel instanceof ViewGroup)
        {
            l = ((ViewGroup)adsizeparcel).indexOfChild(view);
        }
        view = new JSONObject();
        view.put("type", adsizeparcel.getClass().getName());
        view.put("index_of_child", l);
        context.put(view);
        if (adsizeparcel == null) goto _L6; else goto _L5
_L5:
        if (adsizeparcel instanceof View)
        {
            view = (View)adsizeparcel;
            continue; /* Loop/switch isn't completed */
        }
          goto _L6
_L4:
        if (context.length() > 0)
        {
            jsonobject.put("parents", context);
        }
_L2:
        context = jsonobject.toString();
        return context;
_L6:
        view = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String a(Context context, o o1, String s)
    {
        if (o1 == null)
        {
            return s;
        }
        Uri uri;
        Uri uri1;
        try
        {
            uri1 = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s;
        }
        uri = uri1;
        if (o1.b(uri1))
        {
            uri = o1.a(uri1, context);
        }
        context = uri.toString();
        return context;
    }

    private static String a(Context context, String s, String s1, int l)
    {
label0:
        {
            au au = ay.V;
            if (((Boolean)p.n().a(au)).booleanValue() && m.a(context).a() && !TextUtils.isEmpty(s))
            {
                context = Uri.parse(s);
                if ((new o(null)).a(context))
                {
                    break label0;
                }
            }
            return s;
        }
        context = new HashMap();
        context.put("ga_cid", s1);
        context.put("ga_hid", String.valueOf(l));
        return a(s, ((Map) (context)));
    }

    static String a(gm gm1, String s)
    {
        gm1.k = s;
        return s;
    }

    public static String a(InputStreamReader inputstreamreader)
    {
        StringBuilder stringbuilder = new StringBuilder(8192);
        char ac[] = new char[2048];
        do
        {
            int l = inputstreamreader.read(ac);
            if (l != -1)
            {
                stringbuilder.append(ac, 0, l);
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    public static String a(String s)
    {
        return Uri.parse(s).buildUpon().query(null).build().toString();
    }

    private static String a(String s, Map map)
    {
        int l = s.indexOf("&adurl");
        if (l == -1)
        {
            l = s.indexOf("?adurl");
        }
        Object obj = Uri.parse(s);
        if ((new o(null)).b(((Uri) (obj))) && l != -1)
        {
            obj = new StringBuilder(s.substring(0, l + 1));
            String s2;
            for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); ((StringBuilder) (obj)).append(s2).append("=").append((String)map.get(s2)).append("&"))
            {
                s2 = (String)iterator1.next();
            }

            return ((StringBuilder) (obj)).append(s.substring(l + 1)).toString();
        }
        s = ((Uri) (obj)).buildUpon();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            s = s.appendQueryParameter(s1, (String)map.get(s1));
        }

        return s.build().toString();
    }

    public static String a(StackTraceElement astacktraceelement[], String s)
    {
        Object obj = ay.ah;
        if (!((Boolean)p.n().a(((au) (obj)))).booleanValue()) goto _L2; else goto _L1
_L1:
        int l = 0;
_L5:
        String s1;
        if (l + 1 >= astacktraceelement.length)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = astacktraceelement[l];
        s1 = ((StackTraceElement) (obj)).getClassName();
        if (!"loadAd".equalsIgnoreCase(((StackTraceElement) (obj)).getMethodName()) || !d.equalsIgnoreCase(s1) && !e.equalsIgnoreCase(s1) && !f.equalsIgnoreCase(s1) && !g.equalsIgnoreCase(s1) && !h.equalsIgnoreCase(s1) && !i.equalsIgnoreCase(s1)) goto _L4; else goto _L3
_L3:
        astacktraceelement = astacktraceelement[l + 1].getClassName();
_L6:
        if (astacktraceelement != null && !astacktraceelement.contains(s))
        {
            return astacktraceelement;
        }
          goto _L2
_L4:
        l++;
          goto _L5
_L2:
        return null;
        astacktraceelement = null;
          goto _L6
    }

    public static ArrayList a(Context context, List list, String s)
    {
        int l = m.a(context).c();
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(a(context, (String)list.next(), s, l))) { }
        return arraylist;
    }

    public static Map a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = p.g().a(uri).iterator(); iterator.hasNext(); hashmap.put(s, uri.getQueryParameter(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    private JSONArray a(Collection collection)
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); a(jsonarray, collection.next())) { }
        return jsonarray;
    }

    private JSONObject a(Bundle bundle)
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); a(jsonobject, s, bundle.get(s)))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    public static void a(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(ongloballayoutlistener);
        }
    }

    public static void a(Activity activity, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onscrollchangedlistener);
        }
    }

    public static void a(Context context, String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s1);
        a(context, s, ((List) (arraylist)));
    }

    public static void a(Context context, String s, String s1, Bundle bundle, boolean flag)
    {
        if (flag)
        {
            Context context2 = context.getApplicationContext();
            Context context1 = context2;
            if (context2 == null)
            {
                context1 = context;
            }
            bundle.putString("os", android.os.Build.VERSION.RELEASE);
            bundle.putString("api", String.valueOf(android.os.Build.VERSION.SDK_INT));
            p.e();
            bundle.putString("device", b());
            bundle.putString("js", s);
            bundle.putString("appid", context1.getPackageName());
            bundle.putString("eids", TextUtils.join(",", com.google.android.gms.d.ay.a()));
        }
        s1 = (new android.net.Uri.Builder()).scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", s1);
        String s2;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); s1.appendQueryParameter(s2, bundle.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        p.e();
        a(context, s, s1.toString());
    }

    public static void a(Context context, String s, List list)
    {
        for (list = list.iterator(); list.hasNext(); com.google.android.gms.d.gl.a(((gi) (new gt(context, s, (String)list.next()))).i)) { }
    }

    public static void a(Context context, String s, List list, String s1)
    {
        for (list = list.iterator(); list.hasNext(); com.google.android.gms.d.gl.a(((gi) (new gt(context, s, (String)list.next(), s1))).i)) { }
    }

    public static void a(Runnable runnable)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            runnable.run();
            return;
        } else
        {
            a.post(runnable);
            return;
        }
    }

    public static void a(HttpURLConnection httpurlconnection, String s)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(true);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", s);
        httpurlconnection.setUseCaches(false);
    }

    private void a(JSONArray jsonarray, Object obj)
    {
        if (obj instanceof Bundle)
        {
            jsonarray.put(a((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonarray.put(a((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            jsonarray.put(a((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            obj = ((Object) ((Object[])(Object[])obj));
            JSONArray jsonarray1 = new JSONArray();
            int i1 = obj.length;
            for (int l = 0; l < i1; l++)
            {
                a(jsonarray1, obj[l]);
            }

            jsonarray.put(jsonarray1);
            return;
        } else
        {
            jsonarray.put(obj);
            return;
        }
    }

    private void a(JSONObject jsonobject, String s, Object obj)
    {
        if (obj instanceof Bundle)
        {
            jsonobject.put(s, a((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonobject.put(s, a((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            if (s == null)
            {
                s = "null";
            }
            jsonobject.put(s, a((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonobject.put(s, a(((Collection) (Arrays.asList((Object[])(Object[])obj)))));
            return;
        } else
        {
            jsonobject.put(s, obj);
            return;
        }
    }

    public static boolean a(Context context)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        context = context.getPackageManager().resolveActivity(intent, 0x10000);
        if (context == null || ((ResolveInfo) (context)).activityInfo == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        boolean flag;
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x10) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboard"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        } else
        {
            flag = true;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x20) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboardHidden"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x80) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "orientation"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x100) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenLayout"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x200) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "uiMode"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x400) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenSize"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x800) == 0)
        {
            String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "smallestScreenSize"
            });
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        } else
        {
            return flag;
        }
    }

    public static boolean a(PackageManager packagemanager, String s, String s1)
    {
        return packagemanager.checkPermission(s1, s) == 0;
    }

    static boolean a(gm gm1, boolean flag)
    {
        gm1.b = flag;
        return flag;
    }

    public static boolean a(ClassLoader classloader, Class class1, String s)
    {
        boolean flag;
        try
        {
            flag = class1.isAssignableFrom(Class.forName(s, false, classloader));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            return false;
        }
        return flag;
    }

    public static int[] a(Activity activity)
    {
        activity = activity.getWindow();
        if (activity != null)
        {
            activity = activity.findViewById(0x1020002);
            if (activity != null)
            {
                return (new int[] {
                    activity.getWidth(), activity.getHeight()
                });
            }
        }
        return d();
    }

    public static int b(String s)
    {
        int l;
        try
        {
            l = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            (new StringBuilder("Could not parse value:")).append(s);
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return 0;
        }
        return l;
    }

    public static String b()
    {
        String s = Build.MANUFACTURER;
        String s1 = Build.MODEL;
        if (s1.startsWith(s))
        {
            return s1;
        } else
        {
            return (new StringBuilder()).append(s).append(" ").append(s1).toString();
        }
    }

    protected static String b(Context context)
    {
        return (new WebView(context)).getSettings().getUserAgentString();
    }

    public static String b(Context context, String s, String s1)
    {
        return a(context, s, s1, m.a(context).c());
    }

    public static void b(Activity activity, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onscrollchangedlistener);
        }
    }

    public static void b(Context context, String s, String s1, Bundle bundle, boolean flag)
    {
        au au = ay.ae;
        if (((Boolean)p.n().a(au)).booleanValue())
        {
            a(context, s, s1, bundle, flag);
        }
    }

    public static void b(Runnable runnable)
    {
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            runnable.run();
            return;
        } else
        {
            com.google.android.gms.d.gl.a(runnable);
            return;
        }
    }

    public static int[] b(Activity activity)
    {
        int ai[] = a(activity);
        com.google.android.gms.ads.internal.client.m.a();
        int l = com.google.android.gms.ads.internal.util.client.a.b(activity, ai[0]);
        com.google.android.gms.ads.internal.client.m.a();
        return (new int[] {
            l, com.google.android.gms.ads.internal.util.client.a.b(activity, ai[1])
        });
    }

    public static android.app.AlertDialog.Builder c(Context context)
    {
        return new android.app.AlertDialog.Builder(context);
    }

    private static String c()
    {
        StringBuffer stringbuffer = new StringBuffer(256);
        stringbuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (android.os.Build.VERSION.RELEASE != null)
        {
            stringbuffer.append(" ").append(android.os.Build.VERSION.RELEASE);
        }
        stringbuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null)
        {
            stringbuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null)
            {
                stringbuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringbuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringbuffer.toString();
    }

    public static boolean c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return s.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
        }
    }

    public static int[] c(Activity activity)
    {
        Window window = activity.getWindow();
        if (window == null) goto _L2; else goto _L1
_L1:
        View view = window.findViewById(0x1020002);
        if (view == null) goto _L2; else goto _L3
_L3:
        int ai[];
        ai = new int[2];
        ai[0] = view.getTop();
        ai[1] = view.getBottom();
_L5:
        com.google.android.gms.ads.internal.client.m.a();
        int l = com.google.android.gms.ads.internal.util.client.a.b(activity, ai[0]);
        com.google.android.gms.ads.internal.client.m.a();
        return (new int[] {
            l, com.google.android.gms.ads.internal.util.client.a.b(activity, ai[1])
        });
_L2:
        ai = d();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static int d(Activity activity)
    {
        if (activity == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return 0;
        }
        activity = AdOverlayInfoParcel.a(activity.getIntent());
        if (activity == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return 0;
        }
        switch (((AdOverlayInfoParcel) (activity)).l)
        {
        default:
            return 0;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;

        case 3: // '\003'
            return 3;
        }
    }

    public static aq d(Context context)
    {
        return new aq(context);
    }

    private static int[] d()
    {
        return (new int[] {
            0, 0
        });
    }

    public static boolean e(Context context)
    {
        KeyguardManager keyguardmanager;
        Object obj;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        boolean flag;
        try
        {
            obj = (ActivityManager)context.getSystemService("activity");
            keyguardmanager = (KeyguardManager)context.getSystemService("keyguard");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (obj != null && keyguardmanager != null) goto _L2; else goto _L1
_L2:
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        if (Process.myPid() != runningappprocessinfo.pid) goto _L6; else goto _L5
_L5:
        if (runningappprocessinfo.importance != 100 || keyguardmanager.inKeyguardRestrictedInputMode()) goto _L4; else goto _L7
_L7:
        context = (PowerManager)context.getSystemService("power");
        if (context != null) goto _L9; else goto _L8
_L8:
        flag = false;
          goto _L10
_L9:
        flag = context.isScreenOn();
          goto _L10
_L4:
        return false;
_L1:
        return false;
_L10:
        if (!flag) goto _L4; else goto _L11
_L11:
        return true;
    }

    private static String f(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        if (context == null)
        {
            return null;
        }
        context = context.getRunningTasks(1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (context.isEmpty())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        context = (android.app.ActivityManager.RunningTaskInfo)context.get(0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (((android.app.ActivityManager.RunningTaskInfo) (context)).topActivity == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        context = ((android.app.ActivityManager.RunningTaskInfo) (context)).topActivity.getClassName();
        return context;
        context;
        return null;
    }

    public final String a(Context context, String s)
    {
label0:
        {
            synchronized (j)
            {
                if (k == null)
                {
                    break label0;
                }
                context = k;
            }
            return context;
        }
        try
        {
            k = p.g().a(context);
        }
        catch (Exception exception) { }
        if (!TextUtils.isEmpty(k))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        com.google.android.gms.ads.internal.client.m.a();
        if (com.google.android.gms.ads.internal.util.client.a.b())
        {
            break MISSING_BLOCK_LABEL_133;
        }
        k = null;
        a.post(new Runnable(context) {

            final Context a;
            final gm b;

            public final void run()
            {
                synchronized (com.google.android.gms.d.gm.a(b))
                {
                    com.google.android.gms.d.gm.a(b, com.google.android.gms.d.gm.b(a));
                    com.google.android.gms.d.gm.a(b).notifyAll();
                }
                return;
                exception1;
                obj1;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                b = gm.this;
                a = context;
                super();
            }
        });
_L1:
        context = k;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        j.wait();
          goto _L1
        context;
        k = c();
        (new StringBuilder("Interrupted, use default user agent: ")).append(k);
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        k = b(context);
_L2:
        k = (new StringBuilder()).append(k).append(" (Mobile; ").append(s).append(")").toString();
        context = k;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        k = c();
          goto _L2
    }

    public final JSONObject a(Map map)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); a(jsonobject, s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new JSONException((new StringBuilder("Could not convert map to JSON: ")).append(map.getMessage()).toString());
        }
        return jsonobject;
    }

    public final void a(Context context, String s, boolean flag, HttpURLConnection httpurlconnection)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", a(context, s));
        httpurlconnection.setUseCaches(false);
    }

}
