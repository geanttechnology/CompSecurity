// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.thirdparty.http.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.util:
//            b, c, r

public class g
{

    private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String b = com/facebook/ads/internal/util/g.getSimpleName();
    private static boolean c = false;

    public g()
    {
    }

    public static e a(AdSize adsize)
    {
        switch (com.facebook.ads.internal.util._cls2.a[adsize.ordinal()])
        {
        default:
            return e.b;

        case 1: // '\001'
            return e.f;

        case 2: // '\002'
            return e.e;

        case 3: // '\003'
            return e.d;

        case 4: // '\004'
            return e.c;
        }
    }

    public static a a(ContentResolver contentresolver)
    {
        Cursor cursor = contentresolver.query(a, new String[] {
            "aid", "androidid", "limit_tracking"
        }, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        contentresolver = cursor;
        if (cursor.moveToFirst()) goto _L3; else goto _L2
_L2:
        contentresolver = cursor;
        a a1 = new a(null, null, false);
        contentresolver = a1;
        if (cursor != null)
        {
            cursor.close();
            contentresolver = a1;
        }
_L5:
        return contentresolver;
_L3:
        contentresolver = cursor;
        a1 = new a(cursor.getString(cursor.getColumnIndex("aid")), cursor.getString(cursor.getColumnIndex("androidid")), Boolean.valueOf(cursor.getString(cursor.getColumnIndex("limit_tracking"))).booleanValue());
        contentresolver = a1;
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return a1;
        contentresolver;
        cursor = null;
_L9:
        contentresolver = cursor;
        a1 = new a(null, null, false);
        contentresolver = a1;
        if (cursor == null) goto _L5; else goto _L6
_L6:
        cursor.close();
        return a1;
        Exception exception;
        exception;
        contentresolver = null;
_L8:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        contentresolver;
          goto _L9
    }

    public static transient Object a(Object obj, Method method, Object aobj[])
    {
        try
        {
            obj = method.invoke(obj, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return obj;
    }

    public static String a(InputStream inputstream)
    {
        StringWriter stringwriter = new StringWriter();
        inputstream = new InputStreamReader(inputstream);
        char ac[] = new char[4096];
        do
        {
            int i = inputstream.read(ac);
            if (i != -1)
            {
                stringwriter.write(ac, 0, i);
            } else
            {
                String s = stringwriter.toString();
                stringwriter.close();
                inputstream.close();
                return s;
            }
        } while (true);
    }

    public static String a(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            try
            {
                jsonobject.put((String)entry.getKey(), entry.getValue());
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }

        return jsonobject.toString();
    }

    public static String a(byte abyte0[])
    {
        String s;
        try
        {
            abyte0 = new ByteArrayInputStream(abyte0);
            GZIPInputStream gzipinputstream = new GZIPInputStream(abyte0);
            s = a(((InputStream) (gzipinputstream)));
            gzipinputstream.close();
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(abyte0, "Error decompressing data"));
            abyte0.printStackTrace();
            return "";
        }
        return s;
    }

    public static transient Method a(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static transient Method a(String s, String s1, Class aclass[])
    {
        try
        {
            s = a(Class.forName(s), s1, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static void a(Context context, Uri uri)
    {
        uri = new Intent("android.intent.action.VIEW", uri);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.addFlags(0x10000000);
        uri.putExtra("com.android.browser.application_id", context.getPackageName());
        uri.putExtra("create_new_tab", false);
        context.startActivity(uri);
    }

    public static void a(Context context, String s)
    {
        if (AdSettings.isTestMode(context))
        {
            Log.d("FBAudienceNetworkLog", (new StringBuilder()).append(s).append(" (displayed for test ads only)").toString());
        }
    }

    public static void a(DisplayMetrics displaymetrics, View view, AdSize adsize)
    {
        int i;
        if ((int)((float)displaymetrics.widthPixels / displaymetrics.density) >= adsize.getWidth())
        {
            i = displaymetrics.widthPixels;
        } else
        {
            i = (int)Math.ceil((float)adsize.getWidth() * displaymetrics.density);
        }
        displaymetrics = new android.widget.RelativeLayout.LayoutParams(i, (int)Math.ceil((float)adsize.getHeight() * displaymetrics.density));
        displaymetrics.addRule(14, -1);
        view.setLayoutParams(displaymetrics);
    }

    public static void a(View view, boolean flag, String s)
    {
    }

    public static boolean a()
    {
        String s = AdSettings.getUrlPrefix();
        return !com.facebook.ads.internal.util.r.a(s) && s.endsWith(".sb");
    }

    public static boolean a(Context context)
    {
        if (!((PowerManager)context.getSystemService("power")).isScreenOn())
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = ((KeyguardManager)context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return !flag;
    }

    public static boolean a(Context context, View view, int i)
    {
        if (view == null)
        {
            a(view, false, "adView is null.");
            return false;
        }
        if (view.getParent() == null)
        {
            a(view, false, "adView has no parent.");
            return false;
        }
        if (view.getVisibility() != 0)
        {
            a(view, false, "adView is not set to VISIBLE.");
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11 && view.getAlpha() < 0.9F)
        {
            a(view, false, "adView is too transparent.");
            return false;
        }
        int k = view.getWidth();
        int j = view.getHeight();
        int ai[] = new int[2];
        DisplayMetrics displaymetrics;
        try
        {
            view.getLocationOnScreen(ai);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a(view, false, "Cannot get location on screen.");
            return false;
        }
        displaymetrics = context.getResources().getDisplayMetrics();
        if (ai[0] < 0 || displaymetrics.widthPixels - ai[0] < k)
        {
            a(view, false, "adView is not fully on screen horizontally.");
            return false;
        }
        i = (int)(((double)j * (100D - (double)i)) / 100D);
        if (ai[1] < 0 && Math.abs(ai[1]) > i)
        {
            a(view, false, "adView is not visible from the top.");
            return false;
        }
        if ((j + ai[1]) - displaymetrics.heightPixels > i)
        {
            a(view, false, "adView is not visible from the bottom.");
            return false;
        } else
        {
            a(view, true, "adView is visible.");
            return a(context);
        }
    }

    public static byte[] a(String s)
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(s.length());
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            gzipoutputstream.write(s.getBytes());
            gzipoutputstream.close();
            s = bytearrayoutputstream.toByteArray();
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(s, "Error compressing data"));
            s.printStackTrace();
            return new byte[0];
        }
        return s;
    }

    public static void b()
    {
        if (!c)
        {
            try
            {
                _cls1 _lcls1 = new _cls1();
                SSLContext sslcontext = SSLContext.getInstance("SSL");
                SecureRandom securerandom = new SecureRandom();
                sslcontext.init(null, new TrustManager[] {
                    _lcls1
                }, securerandom);
                HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
                Log.d(b, "Sandbox SSL validation disabled.");
                return;
            }
            catch (Exception exception)
            {
                Log.e(b, (new StringBuilder()).append("Failed to disable sandbox SSL validation: ").append(exception).toString());
            }
            return;
        } else
        {
            Log.d(b, "Sandbox SSL validation already disabled, ignoring...");
            return;
        }
    }

    public static com.facebook.ads.internal.thirdparty.http.a c()
    {
        com.facebook.ads.internal.thirdparty.http.a a1 = new com.facebook.ads.internal.thirdparty.http.a();
        a1.c(30000);
        a1.b(3);
        if (a())
        {
            b();
        }
        return a1;
    }


    private class _cls2
    {

        static final int a[];

        static 
        {
            a = new int[AdSize.values().length];
            try
            {
                a[AdSize.INTERSTITIAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[AdSize.RECTANGLE_HEIGHT_250.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[AdSize.BANNER_HEIGHT_90.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[AdSize.BANNER_HEIGHT_50.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class a
    {

        public String a;
        public String b;
        public boolean c;

        public a(String s, String s1, boolean flag)
        {
            a = s;
            b = s1;
            c = flag;
        }
    }


    private class _cls1
        implements X509TrustManager
    {

        public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        {
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        {
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        _cls1()
        {
        }
    }

}
