// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

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
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
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

// Referenced classes of package com.google.android.gms.b:
//            bx, f, ca, cj, 
//            cd, s

public class bz
{

    public static final Handler a = new bx(Looper.getMainLooper());
    private final Object b = new Object();
    private boolean c;
    private String d;
    private boolean e;

    public bz()
    {
        c = true;
        e = false;
    }

    static Object a(bz bz1)
    {
        return bz1.b;
    }

    static String a(bz bz1, String s1)
    {
        bz1.d = s1;
        return s1;
    }

    private JSONArray a(Collection collection)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); a(jsonarray, collection.next())) { }
        return jsonarray;
    }

    private JSONObject a(Bundle bundle)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        String s1;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); a(jsonobject, s1, bundle.get(s1)))
        {
            s1 = (String)iterator.next();
        }

        return jsonobject;
    }

    private void a(JSONArray jsonarray, Object obj)
        throws JSONException
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
            jsonarray.put(a((Object[])(Object[])obj));
            return;
        } else
        {
            jsonarray.put(obj);
            return;
        }
    }

    private void a(JSONObject jsonobject, String s1, Object obj)
        throws JSONException
    {
        if (obj instanceof Bundle)
        {
            jsonobject.put(s1, a((Bundle)obj));
            return;
        }
        if (obj instanceof Map)
        {
            jsonobject.put(s1, a((Map)obj));
            return;
        }
        if (obj instanceof Collection)
        {
            if (s1 == null)
            {
                s1 = "null";
            }
            jsonobject.put(s1, a((Collection)obj));
            return;
        }
        if (obj instanceof Object[])
        {
            jsonobject.put(s1, a(((Collection) (Arrays.asList((Object[])(Object[])obj)))));
            return;
        } else
        {
            jsonobject.put(s1, obj);
            return;
        }
    }

    public int a(String s1)
    {
        int i;
        try
        {
            i = Integer.parseInt(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Could not parse value:").append(s1).toString());
            return 0;
        }
        return i;
    }

    public Bitmap a(View view)
    {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public DisplayMetrics a(WindowManager windowmanager)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public PopupWindow a(View view, int i, int j, boolean flag)
    {
        return new PopupWindow(view, i, j, flag);
    }

    String a()
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

    protected String a(Context context)
    {
        return (new WebView(context)).getSettings().getUserAgentString();
    }

    public String a(Context context, f f1, String s1)
    {
        if (f1 == null)
        {
            return s1;
        }
        Uri uri;
        Uri uri1;
        try
        {
            uri1 = Uri.parse(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s1;
        }
        uri = uri1;
        if (f1.c(uri1))
        {
            uri = f1.a(uri1, context);
        }
        context = uri.toString();
        return context;
    }

    public String a(Context context, String s1)
    {
label0:
        {
            synchronized (b)
            {
                if (d == null)
                {
                    break label0;
                }
                context = d;
            }
            return context;
        }
        try
        {
            d = com.google.android.gms.ads.internal.c.e().a(context);
        }
        catch (Exception exception) { }
        if (!TextUtils.isEmpty(d))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (h.a().a())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        d = null;
        a.post(new _cls1(context));
_L1:
        context = d;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        b.wait();
          goto _L1
        context;
        d = a();
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Interrupted, use default user agent: ").append(d).toString());
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        d = a(context);
_L2:
        d = (new StringBuilder()).append(d).append(" (Mobile; ").append(s1).append(")").toString();
        context = d;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        d = a();
          goto _L2
    }

    public String a(cj cj1, String s1)
    {
        return a(cj1.getContext(), cj1.j(), s1);
    }

    public Map a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        String s1;
        for (Iterator iterator = com.google.android.gms.ads.internal.c.e().a(uri).iterator(); iterator.hasNext(); hashmap.put(s1, uri.getQueryParameter(s1)))
        {
            s1 = (String)iterator.next();
        }

        return hashmap;
    }

    JSONArray a(Object aobj[])
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            a(jsonarray, aobj[i]);
        }

        return jsonarray;
    }

    public JSONObject a(Map map)
        throws JSONException
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            String s1;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); a(jsonobject, s1, map.get(s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new JSONException((new StringBuilder()).append("Could not convert map to JSON: ").append(map.getMessage()).toString());
        }
        return jsonobject;
    }

    public void a(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            activity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(ongloballayoutlistener);
        }
    }

    public void a(Context context, String s1, WebSettings websettings)
    {
        websettings.setUserAgentString(a(context, s1));
    }

    public void a(Context context, String s1, List list, String s2)
    {
        for (list = list.iterator(); list.hasNext(); (new cd(context, s1, (String)list.next(), s2)).b()) { }
    }

    public void a(Context context, String s1, boolean flag, HttpURLConnection httpurlconnection)
    {
        a(context, s1, flag, httpurlconnection, false);
    }

    public void a(Context context, String s1, boolean flag, HttpURLConnection httpurlconnection, String s2)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", s2);
        httpurlconnection.setUseCaches(false);
    }

    public void a(Context context, String s1, boolean flag, HttpURLConnection httpurlconnection, boolean flag1)
    {
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setInstanceFollowRedirects(flag);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestProperty("User-Agent", a(context, s1));
        httpurlconnection.setUseCaches(flag1);
    }

    public boolean a(PackageManager packagemanager, String s1, String s2)
    {
        return packagemanager.checkPermission(s2, s1) == 0;
    }

    public int[] a(Activity activity)
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

    public android.app.AlertDialog.Builder b(Context context)
    {
        return new android.app.AlertDialog.Builder(context);
    }

    public String b()
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

    public boolean b(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return false;
        } else
        {
            return s1.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
        }
    }

    public int[] b(Activity activity)
    {
        int ai[] = a(activity);
        return (new int[] {
            h.a().b(activity, ai[0]), h.a().b(activity, ai[1])
        });
    }

    public s c(Context context)
    {
        return new s(context);
    }

    public String c()
    {
        String s1 = Build.MANUFACTURER;
        String s2 = Build.MODEL;
        if (s2.startsWith(s1))
        {
            return s2;
        } else
        {
            return (new StringBuilder()).append(s1).append(" ").append(s2).toString();
        }
    }

    public int[] c(Activity activity)
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
        return d();
    }

    protected int[] d()
    {
        return (new int[] {
            0, 0
        });
    }

    public int[] d(Activity activity)
    {
        int ai[] = c(activity);
        return (new int[] {
            h.a().b(activity, ai[0]), h.a().b(activity, ai[1])
        });
    }


    /* member class not found */
    class _cls1 {}

}
