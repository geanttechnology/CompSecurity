// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
//            zzhi, zzbq, zzan, zzid, 
//            zzhp, zzhm

public class zzhl
{

    public static final Handler zzGk = new zzhi(Looper.getMainLooper());
    private String zzFP;
    private boolean zzGl;
    private boolean zzGm;
    private final Object zzqt = new Object();

    public zzhl()
    {
        zzGl = true;
        zzGm = false;
    }

    static Object zza(zzhl zzhl1)
    {
        return zzhl1.zzqt;
    }

    static String zza(zzhl zzhl1, String s)
    {
        zzhl1.zzFP = s;
        return s;
    }

    private JSONArray zza(Collection collection)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); zza(jsonarray, collection.next())) { }
        return jsonarray;
    }

    private void zza(JSONArray jsonarray, Object obj)
        throws JSONException
    {
        if (obj instanceof Bundle)
        {
            jsonarray.put(zzd((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonarray.put(zzy((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            jsonarray.put(zza((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonarray.put(zza((Object[])(Object[])obj));
            return;
        } else
        {
            jsonarray.put(obj);
            return;
        }
    }

    private void zza(JSONObject jsonobject, String s, Object obj)
        throws JSONException
    {
        if (obj instanceof Bundle)
        {
            jsonobject.put(s, zzd((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonobject.put(s, zzy((Map)obj));
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
            jsonobject.put(s, zza(((Collection) (Arrays.asList((Object[])(Object[])obj)))));
            return;
        } else
        {
            jsonobject.put(s, obj);
            return;
        }
    }

    private JSONObject zzd(Bundle bundle)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); zza(jsonobject, s, bundle.get(s)))
        {
            s = (String)iterator.next();
        }

        return jsonobject;
    }

    protected String zzI(Context context)
    {
        return (new WebView(context)).getSettings().getUserAgentString();
    }

    public android.app.AlertDialog.Builder zzJ(Context context)
    {
        return new android.app.AlertDialog.Builder(context);
    }

    public zzbq zzK(Context context)
    {
        return new zzbq(context);
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

    public String zza(zzid zzid1, String s)
    {
        return zza(zzid1.getContext(), zzid1.zzgH(), s);
    }

    JSONArray zza(Object aobj[])
        throws JSONException
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

    public void zza(Context context, String s, WebSettings websettings)
    {
        websettings.setUserAgentString(zzf(context, s));
    }

    public void zza(Context context, String s, List list, String s1)
    {
        for (list = list.iterator(); list.hasNext(); (new zzhp(context, s, (String)list.next(), s1)).zzgi()) { }
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

    public boolean zza(PackageManager packagemanager, String s, String s1)
    {
        return packagemanager.checkPermission(s1, s) == 0;
    }

    public int zzau(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzaC((new StringBuilder()).append("Could not parse value:").append(s).toString());
            return 0;
        }
        return i;
    }

    public boolean zzav(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return s.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
        }
    }

    public Map zzd(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = zzo.zzbx().zze(uri).iterator(); iterator.hasNext(); hashmap.put(s, uri.getQueryParameter(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public String zzf(Context context, String s)
    {
label0:
        {
            synchronized (zzqt)
            {
                if (zzFP == null)
                {
                    break label0;
                }
                context = zzFP;
            }
            return context;
        }
        try
        {
            zzFP = zzo.zzbx().getDefaultUserAgent(context);
        }
        catch (Exception exception) { }
        if (!TextUtils.isEmpty(zzFP))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (zzk.zzcA().zzgw())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        zzFP = null;
        zzGk.post(new Runnable(context) {

            final zzhl zzGn;
            final Context zzqV;

            public void run()
            {
                synchronized (com.google.android.gms.internal.zzhl.zza(zzGn))
                {
                    com.google.android.gms.internal.zzhl.zza(zzGn, zzGn.zzI(zzqV));
                    com.google.android.gms.internal.zzhl.zza(zzGn).notifyAll();
                }
                return;
                exception1;
                obj1;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                zzGn = zzhl.this;
                zzqV = context;
                super();
            }
        });
_L1:
        context = zzFP;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        zzqt.wait();
          goto _L1
        context;
        zzFP = zzgm();
        zzb.zzaC((new StringBuilder()).append("Interrupted, use default user agent: ").append(zzFP).toString());
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        zzFP = zzI(context);
_L2:
        zzFP = (new StringBuilder()).append(zzFP).append(" (Mobile; ").append(s).append(")").toString();
        context = zzFP;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        zzFP = zzgm();
          goto _L2
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
        return zzgp();
    }

    String zzgm()
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

    public String zzgn()
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

    public String zzgo()
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

    protected int[] zzgp()
    {
        return (new int[] {
            0, 0
        });
    }

    public int[] zzh(Activity activity)
    {
        int ai[] = zzg(activity);
        return (new int[] {
            zzk.zzcA().zzc(activity, ai[0]), zzk.zzcA().zzc(activity, ai[1])
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
        return zzgp();
    }

    public Bitmap zzj(View view)
    {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public int[] zzj(Activity activity)
    {
        int ai[] = zzi(activity);
        return (new int[] {
            zzk.zzcA().zzc(activity, ai[0]), zzk.zzcA().zzc(activity, ai[1])
        });
    }

    public JSONObject zzy(Map map)
        throws JSONException
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
            throw new JSONException((new StringBuilder()).append("Could not convert map to JSON: ").append(map.getMessage()).toString());
        }
        return jsonobject;
    }

}
