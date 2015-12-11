// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.internal.zzx;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

// Referenced classes of package com.google.android.gms.internal:
//            zzia, zzic, zzbq, zzby, 
//            zzbu, zzan, zziz, zzij, 
//            zzie

public class zzid
{

    private static final String zzIA = com/google/android/gms/ads/doubleclick/PublisherAdView.getName();
    private static final String zzIB = com/google/android/gms/ads/doubleclick/PublisherInterstitialAd.getName();
    private static final String zzIC = com/google/android/gms/ads/search/SearchAdView.getName();
    private static final String zzID = com/google/android/gms/ads/AdLoader.getName();
    public static final Handler zzIE = new zzia(Looper.getMainLooper());
    private static final String zzIy = com/google/android/gms/ads/AdView.getName();
    private static final String zzIz = com/google/android/gms/ads/InterstitialAd.getName();
    private boolean zzIF;
    private boolean zzIG;
    private String zzIa;
    private final Object zzpd = new Object();

    public zzid()
    {
        zzIF = true;
        zzIG = false;
    }

    public static void runOnUiThread(Runnable runnable)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            runnable.run();
            return;
        } else
        {
            zzIE.post(runnable);
            return;
        }
    }

    static Object zza(zzid zzid1)
    {
        return zzid1.zzpd;
    }

    static String zza(zzid zzid1, String s)
    {
        zzid1.zzIa = s;
        return s;
    }

    private JSONArray zza(Collection collection)
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); zza(jsonarray, collection.next())) { }
        return jsonarray;
    }

    private void zza(JSONArray jsonarray, Object obj)
    {
        if (obj instanceof Bundle)
        {
            jsonarray.put(zze((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonarray.put(zzz((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            jsonarray.put(zza((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonarray.put(zza((Object[])obj));
            return;
        } else
        {
            jsonarray.put(obj);
            return;
        }
    }

    private void zza(JSONObject jsonobject, String s, Object obj)
    {
        if (obj instanceof Bundle)
        {
            jsonobject.put(s, zze((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonobject.put(s, zzz((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            if (s == null)
            {
                s = "null";
            }
            jsonobject.put(s, zza((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonobject.put(s, zza(((Collection) (Arrays.asList((Object[])obj)))));
            return;
        } else
        {
            jsonobject.put(s, obj);
            return;
        }
    }

    static boolean zza(zzid zzid1, boolean flag)
    {
        zzid1.zzIF = flag;
        return flag;
    }

    public static void zzb(Runnable runnable)
    {
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            runnable.run();
            return;
        } else
        {
            com.google.android.gms.internal.zzic.zza(runnable);
            return;
        }
    }

    private JSONObject zze(Bundle bundle)
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); zza(jsonobject, s, bundle.get(s)))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    private boolean zzr(Context context)
    {
        context = (PowerManager)context.getSystemService("power");
        if (context == null)
        {
            return false;
        } else
        {
            return context.isScreenOn();
        }
    }

    public boolean zzH(Context context)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        context = context.getPackageManager().resolveActivity(intent, 0x10000);
        if (context == null || ((ResolveInfo) (context)).activityInfo == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean flag;
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x10) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboard"
            }));
            flag = false;
        } else
        {
            flag = true;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x20) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "keyboardHidden"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x80) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "orientation"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x100) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenLayout"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x200) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "uiMode"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x400) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "screenSize"
            }));
            flag = false;
        }
        if ((((ResolveInfo) (context)).activityInfo.configChanges & 0x800) == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] {
                "smallestScreenSize"
            }));
            return false;
        } else
        {
            return flag;
        }
    }

    public boolean zzI(Context context)
    {
        if (zzIG)
        {
            return false;
        } else
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.USER_PRESENT");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new zza(null), intentfilter);
            zzIG = true;
            return true;
        }
    }

    protected String zzJ(Context context)
    {
        return (new WebView(context)).getSettings().getUserAgentString();
    }

    public android.app.AlertDialog.Builder zzK(Context context)
    {
        return new android.app.AlertDialog.Builder(context);
    }

    public zzbq zzL(Context context)
    {
        return new zzbq(context);
    }

    public String zzM(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        if (context == null)
        {
            return null;
        }
        context = context.getRunningTasks(1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (context.isEmpty())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        context = (android.app.ActivityManager.RunningTaskInfo)context.get(0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (((android.app.ActivityManager.RunningTaskInfo) (context)).topActivity == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        context = ((android.app.ActivityManager.RunningTaskInfo) (context)).topActivity.getClassName();
        return context;
        context;
        return null;
    }

    public boolean zzN(Context context)
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
        if (obj == null || keyguardmanager == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_113;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        } while (Process.myPid() != runningappprocessinfo.pid);
        if (runningappprocessinfo.importance != 100 || keyguardmanager.inKeyguardRestrictedInputMode())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        flag = zzr(context);
        if (flag)
        {
            return true;
        }
        return false;
        return false;
    }

    public Bitmap zzO(Context context)
    {
        if (!(context instanceof Activity))
        {
            return null;
        }
        Bitmap bitmap;
        try
        {
            context = ((Activity)context).getWindow().getDecorView();
            bitmap = Bitmap.createBitmap(context.getWidth(), context.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            context.layout(0, 0, context.getWidth(), context.getHeight());
            context.draw(canvas);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Fail to capture screen shot", context);
            return null;
        }
        return bitmap;
    }

    public DisplayMetrics zza(WindowManager windowmanager)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public PopupWindow zza(View view, int i, int j, boolean flag)
    {
        return new PopupWindow(view, i, j, flag);
    }

    public String zza(Context context, View view, AdSizeParcel adsizeparcel)
    {
        if (!((Boolean)zzby.zzvg.get()).booleanValue())
        {
            return null;
        }
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("width", adsizeparcel.width);
        jsonobject1.put("height", adsizeparcel.height);
        jsonobject.put("size", jsonobject1);
        jsonobject.put("activity", zzM(context));
        if (adsizeparcel.zztf) goto _L2; else goto _L1
_L1:
        context = new JSONArray();
_L8:
        if (view == null) goto _L4; else goto _L3
_L3:
        int i;
        try
        {
            adsizeparcel = view.getParent();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to get view hierarchy json", context);
            return null;
        }
        if (adsizeparcel == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        i = -1;
        if (adsizeparcel instanceof ViewGroup)
        {
            i = ((ViewGroup)adsizeparcel).indexOfChild(view);
        }
        view = new JSONObject();
        view.put("type", adsizeparcel.getClass().getName());
        view.put("index_of_child", i);
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

    public String zza(Context context, zzan zzan1, String s)
    {
        if (zzan1 == null)
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
        if (zzan1.zzc(uri1))
        {
            uri = zzan1.zza(uri1, context);
        }
        context = uri.toString();
        return context;
    }

    public String zza(zziz zziz1, String s)
    {
        return zza(zziz1.getContext(), zziz1.zzhg(), s);
    }

    public String zza(InputStreamReader inputstreamreader)
    {
        StringBuilder stringbuilder = new StringBuilder(8192);
        char ac[] = new char[2048];
        do
        {
            int i = inputstreamreader.read(ac);
            if (i != -1)
            {
                stringbuilder.append(ac, 0, i);
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    public String zza(StackTraceElement astacktraceelement[], String s)
    {
        if (!((Boolean)zzby.zzvr.get()).booleanValue()) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        StackTraceElement stacktraceelement;
        String s1;
        if (i + 1 >= astacktraceelement.length)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        stacktraceelement = astacktraceelement[i];
        s1 = stacktraceelement.getClassName();
        if (!"loadAd".equalsIgnoreCase(stacktraceelement.getMethodName()) || !zzIy.equalsIgnoreCase(s1) && !zzIz.equalsIgnoreCase(s1) && !zzIA.equalsIgnoreCase(s1) && !zzIB.equalsIgnoreCase(s1) && !zzIC.equalsIgnoreCase(s1) && !zzID.equalsIgnoreCase(s1)) goto _L4; else goto _L3
_L3:
        astacktraceelement = astacktraceelement[i + 1].getClassName();
_L6:
        if (astacktraceelement != null && !astacktraceelement.contains(s))
        {
            return astacktraceelement;
        }
          goto _L2
_L4:
        i++;
          goto _L5
_L2:
        return null;
        astacktraceelement = null;
          goto _L6
    }

    JSONArray zza(Object aobj[])
    {
        JSONArray jsonarray = new JSONArray();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            zza(jsonarray, aobj[i]);
        }

        return jsonarray;
    }

    public void zza(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(ongloballayoutlistener);
        }
    }

    public void zza(Activity activity, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onscrollchangedlistener);
        }
    }

    public void zza(Context context, String s, WebSettings websettings)
    {
        websettings.setUserAgentString(zzf(context, s));
    }

    public void zza(Context context, String s, String s1, Bundle bundle, boolean flag)
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
            bundle.putString("device", zzp.zzbv().zzgE());
            bundle.putString("js", s);
            bundle.putString("appid", context1.getPackageName());
            bundle.putString("eids", TextUtils.join(",", zzby.zzdf()));
        }
        s1 = (new android.net.Uri.Builder()).scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", s1);
        String s2;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); s1.appendQueryParameter(s2, bundle.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        zzp.zzbv().zzc(context, s, s1.toString());
    }

    public void zza(Context context, String s, List list)
    {
        for (list = list.iterator(); list.hasNext(); (new zzij(context, s, (String)list.next())).zzgz()) { }
    }

    public void zza(Context context, String s, List list, String s1)
    {
        for (list = list.iterator(); list.hasNext(); (new zzij(context, s, (String)list.next(), s1)).zzgz()) { }
    }

    public void zza(Context context, String s, boolean flag, HttpURLConnection httpurlconnection)
    {
        zza(context, s, flag, httpurlconnection, false);
    }

    public void zza(Context context, String s, boolean flag, HttpURLConnection httpurlconnection, String s1)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", s1);
        httpurlconnection.setUseCaches(false);
    }

    public void zza(Context context, String s, boolean flag, HttpURLConnection httpurlconnection, boolean flag1)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", zzf(context, s));
        httpurlconnection.setUseCaches(flag1);
    }

    public boolean zza(Context context, Bitmap bitmap, String s)
    {
        zzx.zzcj("saveImageToFile must not be called on the main UI thread.");
        try
        {
            context = context.openFileOutput(s, 0);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, context);
            context.close();
            bitmap.recycle();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Fail to save file", context);
            return false;
        }
        return true;
    }

    public boolean zza(PackageManager packagemanager, String s, String s1)
    {
        return packagemanager.checkPermission(s1, s) == 0;
    }

    public boolean zza(ClassLoader classloader, Class class1, String s)
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

    public int zzaA(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Could not parse value:")).append(s).toString());
            return 0;
        }
        return i;
    }

    public boolean zzaB(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return s.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
        }
    }

    public String zzaz(String s)
    {
        return Uri.parse(s).buildUpon().query(null).build().toString();
    }

    public void zzb(Activity activity, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onscrollchangedlistener);
        }
    }

    public void zzb(Context context, Intent intent)
    {
        try
        {
            context.startActivity(intent);
            return;
        }
        catch (Throwable throwable)
        {
            intent.addFlags(0x10000000);
        }
        context.startActivity(intent);
    }

    public void zzb(Context context, String s, String s1, Bundle bundle, boolean flag)
    {
        if (((Boolean)zzby.zzvo.get()).booleanValue())
        {
            zza(context, s, s1, bundle, flag);
        }
    }

    public void zzc(Context context, String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s1);
        zza(context, s, arraylist);
    }

    public Map zze(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = zzp.zzbx().zzf(uri).iterator(); iterator.hasNext(); hashmap.put(s, uri.getQueryParameter(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public String zzf(Context context, String s)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzIa == null)
                {
                    break label0;
                }
                context = zzIa;
            }
            return context;
        }
        try
        {
            zzIa = zzp.zzbx().getDefaultUserAgent(context);
        }
        catch (Exception exception) { }
        if (!TextUtils.isEmpty(zzIa))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (zzl.zzcF().zzgT())
        {
            break MISSING_BLOCK_LABEL_133;
        }
        zzIa = null;
        zzIE.post(new _cls1(context));
_L1:
        context = zzIa;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        zzpd.wait();
          goto _L1
        context;
        zzIa = zzgC();
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Interrupted, use default user agent: ")).append(zzIa).toString());
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        zzIa = zzJ(context);
_L2:
        zzIa = (new StringBuilder()).append(zzIa).append(" (Mobile; ").append(s).append(")").toString();
        context = zzIa;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        zzIa = zzgC();
          goto _L2
    }

    public Bitmap zzg(Context context, String s)
    {
        zzx.zzcj("getBackgroundImage must not be called on the main UI thread.");
        try
        {
            context = context.openFileInput(s);
            s = BitmapFactory.decodeStream(context);
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to get background image");
            return null;
        }
        return s;
    }

    public int[] zzg(Activity activity)
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
        return zzgF();
    }

    public boolean zzgB()
    {
        return zzIF;
    }

    String zzgC()
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

    public String zzgD()
    {
        Object obj;
        byte abyte0[];
        byte abyte1[];
        int i;
        obj = UUID.randomUUID();
        abyte0 = BigInteger.valueOf(((UUID) (obj)).getLeastSignificantBits()).toByteArray();
        abyte1 = BigInteger.valueOf(((UUID) (obj)).getMostSignificantBits()).toByteArray();
        obj = (new BigInteger(1, abyte0)).toString();
        i = 0;
_L2:
        if (i >= 2)
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
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
          goto _L3
    }

    public String zzgE()
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

    protected int[] zzgF()
    {
        return (new int[] {
            0, 0
        });
    }

    public void zzh(Context context, String s)
    {
        zzx.zzcj("deleteFile must not be called on the main UI thread.");
        context.deleteFile(s);
    }

    public int[] zzh(Activity activity)
    {
        int ai[] = zzg(activity);
        return (new int[] {
            zzl.zzcF().zzc(activity, ai[0]), zzl.zzcF().zzc(activity, ai[1])
        });
    }

    public int[] zzi(Activity activity)
    {
        activity = activity.getWindow();
        if (activity != null)
        {
            activity = activity.findViewById(0x1020002);
            if (activity != null)
            {
                return (new int[] {
                    activity.getTop(), activity.getBottom()
                });
            }
        }
        return zzgF();
    }

    public int[] zzj(Activity activity)
    {
        int ai[] = zzi(activity);
        return (new int[] {
            zzl.zzcF().zzc(activity, ai[0]), zzl.zzcF().zzc(activity, ai[1])
        });
    }

    public Bitmap zzk(View view)
    {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public JSONObject zzz(Map map)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); zza(jsonobject, s, map.get(s)))
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


    private class zza extends BroadcastReceiver
    {

        final zzid zzIH;

        public final void onReceive(Context context, Intent intent)
        {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
            {
                com.google.android.gms.internal.zzid.zza(zzIH, true);
            } else
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
            {
                com.google.android.gms.internal.zzid.zza(zzIH, false);
                return;
            }
        }

        private zza()
        {
            zzIH = zzid.this;
            super();
        }

        zza(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements Runnable
    {

        final zzid zzIH;
        final Context zzry;

        public void run()
        {
            synchronized (com.google.android.gms.internal.zzid.zza(zzIH))
            {
                com.google.android.gms.internal.zzid.zza(zzIH, zzIH.zzJ(zzry));
                com.google.android.gms.internal.zzid.zza(zzIH).notifyAll();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls1(Context context)
        {
            zzIH = zzid.this;
            zzry = context;
            super();
        }
    }

}
