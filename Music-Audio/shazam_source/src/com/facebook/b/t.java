// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.h;
import com.facebook.j;
import com.facebook.k;
import com.facebook.o;
import com.facebook.p;
import com.facebook.q;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.facebook.b:
//            u, r, c, k

public final class t
{
    public static final class a
    {

        String a;
        String b;
        Uri c;
        int d[];

        static int[] a(JSONArray jsonarray)
        {
            int ai[] = null;
            if (jsonarray != null)
            {
                int j1 = jsonarray.length();
                ai = new int[j1];
                int l = 0;
                do
                {
                    if (l >= j1)
                    {
                        break;
                    }
                    int i1 = jsonarray.optInt(l, -1);
                    int j = i1;
                    if (i1 == -1)
                    {
                        String s = jsonarray.optString(l);
                        j = i1;
                        if (!t.a(s))
                        {
                            try
                            {
                                j = Integer.parseInt(s);
                            }
                            catch (NumberFormatException numberformatexception)
                            {
                                t.a(numberformatexception);
                                j = -1;
                            }
                        }
                    }
                    ai[l] = j;
                    l++;
                } while (true);
            }
            return ai;
        }

        a(String s, String s1, Uri uri, int ai[])
        {
            a = s;
            b = s1;
            c = uri;
            d = ai;
        }
    }

    public static final class b
    {

        public boolean a;
        Map b;
        public com.facebook.b.k c;
        private String d;
        private boolean e;

        private b(boolean flag, String s, boolean flag1, Map map, com.facebook.b.k k1)
        {
            a = flag;
            d = s;
            e = flag1;
            b = map;
            c = k1;
        }

        b(boolean flag, String s, boolean flag1, Map map, com.facebook.b.k k1, byte byte0)
        {
            this(flag, s, flag1, map, k1);
        }
    }

    public static interface c
    {

        public abstract void a(h h1);

        public abstract void a(JSONObject jsonobject);
    }


    private static final String a[] = {
        "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories"
    };
    private static Map b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static int d = 0;
    private static long e = -1L;
    private static long f = -1L;
    private static long g = -1L;
    private static String h = "";
    private static String i = "NoCarrier";

    public static int a(InputStream inputstream, OutputStream outputstream)
    {
        int j = 0;
        BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
        byte abyte0[] = new byte[8192];
_L1:
        int l = bufferedinputstream.read(abyte0);
        if (l == -1)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        outputstream.write(abyte0, 0, l);
        j += l;
          goto _L1
        bufferedinputstream.close();
        if (inputstream != null)
        {
            inputstream.close();
        }
        return j;
        outputstream;
        bufferedinputstream = null;
_L3:
        if (bufferedinputstream != null)
        {
            bufferedinputstream.close();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        throw outputstream;
        outputstream;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static long a(double d1)
    {
        return Math.round(d1 / 1073741824D);
    }

    public static long a(Uri uri)
    {
        uri = k.g().getContentResolver().query(uri, null, null, null, null);
        long l;
        int j = uri.getColumnIndex("_size");
        uri.moveToFirst();
        l = uri.getLong(j);
        if (uri != null)
        {
            uri.close();
        }
        return l;
        Exception exception;
        exception;
        uri = null;
_L2:
        if (uri != null)
        {
            uri.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Uri a(String s, String s1, Bundle bundle)
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https");
        builder.authority(s);
        builder.path(s1);
        if (bundle != null)
        {
            s = bundle.keySet().iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                s1 = (String)s.next();
                Object obj = bundle.get(s1);
                if (obj instanceof String)
                {
                    builder.appendQueryParameter(s1, (String)obj);
                }
            } while (true);
        }
        return builder.build();
    }

    public static a a(String s, String s1, String s2)
    {
        if (a(s1) || a(s2))
        {
            return null;
        }
        s = (b)b.get(s);
        if (s != null)
        {
            s = (Map)((b) (s)).b.get(s1);
            if (s != null)
            {
                return (a)s.get(s2);
            }
        }
        return null;
    }

    static b a(String s, JSONObject jsonobject)
    {
        return b(s, jsonobject);
    }

    public static b a(String s, boolean flag)
    {
        if (!flag && b.containsKey(s))
        {
            return (b)b.get(s);
        }
        JSONObject jsonobject = g(s);
        if (jsonobject == null)
        {
            return null;
        } else
        {
            return b(s, jsonobject);
        }
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
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return obj;
    }

    public static Object a(JSONObject jsonobject, String s, String s1)
    {
        jsonobject = ((JSONObject) (jsonobject.opt(s)));
        if (jsonobject != null && (jsonobject instanceof String))
        {
            jsonobject = ((JSONObject) ((new JSONTokener((String)jsonobject)).nextValue()));
        }
        if (jsonobject != null && !(jsonobject instanceof JSONObject) && !(jsonobject instanceof JSONArray))
        {
            if (s1 != null)
            {
                s = new JSONObject();
                s.putOpt(s1, jsonobject);
                return s;
            } else
            {
                throw new h("Got an unexpected non-JSON object.");
            }
        } else
        {
            return jsonobject;
        }
    }

    public static String a(Context context)
    {
        u.a(context, "context");
        k.a(context);
        return k.j();
    }

    public static String a(InputStream inputstream)
    {
        Object obj = null;
        inputstream = new BufferedInputStream(inputstream);
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        char ac[];
        obj = new StringBuilder();
        ac = new char[2048];
_L3:
        int j = inputstreamreader.read(ac);
        if (j == -1) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(ac, 0, j);
          goto _L3
        Exception exception;
        exception;
        obj = inputstream;
        inputstream = exception;
_L5:
        a(((Closeable) (obj)));
        a(((Closeable) (inputstreamreader)));
        throw inputstream;
_L2:
        obj = ((StringBuilder) (obj)).toString();
        a(((Closeable) (inputstream)));
        a(((Closeable) (inputstreamreader)));
        return ((String) (obj));
        inputstream;
        inputstreamreader = null;
        continue; /* Loop/switch isn't completed */
        exception;
        inputstreamreader = null;
        obj = inputstream;
        inputstream = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static String a(String s, byte abyte0[])
    {
        int l;
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s.update(abyte0);
        s = s.digest();
        abyte0 = new StringBuilder();
        l = s.length;
        for (int j = 0; j < l; j++)
        {
            byte byte0 = s[j];
            abyte0.append(Integer.toHexString(byte0 >> 4 & 0xf));
            abyte0.append(Integer.toHexString(byte0 >> 0 & 0xf));
        }

        return abyte0.toString();
    }

    public static String a(byte abyte0[])
    {
        return a("SHA-1", abyte0);
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

    public static transient Collection a(Object aobj[])
    {
        return Collections.unmodifiableCollection(Arrays.asList(aobj));
    }

    public static Date a(Bundle bundle, String s, Date date)
    {
        if (bundle == null)
        {
            return null;
        }
        bundle = ((Bundle) (bundle.get(s)));
        long l;
        if (bundle instanceof Long)
        {
            l = ((Long)bundle).longValue();
        } else
        if (bundle instanceof String)
        {
            try
            {
                l = Long.parseLong((String)bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                return null;
            }
        } else
        {
            return null;
        }
        if (l == 0L)
        {
            return new Date(0x7fffffffffffffffL);
        } else
        {
            return new Date(l * 1000L + date.getTime());
        }
    }

    public static List a(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < jsonarray.length(); j++)
        {
            arraylist.add(jsonarray.getString(j));
        }

        return arraylist;
    }

    public static Map a(Parcel parcel)
    {
        int l = parcel.readInt();
        if (l >= 0) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Map) (obj));
_L2:
        HashMap hashmap = new HashMap();
        int j = 0;
        do
        {
            obj = hashmap;
            if (j >= l)
            {
                continue;
            }
            hashmap.put(parcel.readString(), parcel.readString());
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Map a(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != null)
        {
            JSONArray jsonarray = jsonobject.optJSONArray("data");
            if (jsonarray != null)
            {
                int j = 0;
                while (j < jsonarray.length()) 
                {
                    Object obj = jsonarray.optJSONObject(j);
                    jsonobject = ((JSONObject) (obj)).optString("name");
                    if (a(((String) (jsonobject))))
                    {
                        jsonobject = null;
                    } else
                    {
                        jsonobject = jsonobject.split("\\|");
                        if (jsonobject.length != 2)
                        {
                            jsonobject = null;
                        } else
                        {
                            String s = jsonobject[0];
                            String s2 = jsonobject[1];
                            if (a(s) || a(s2))
                            {
                                jsonobject = null;
                            } else
                            {
                                jsonobject = ((JSONObject) (obj)).optString("url");
                                if (!a(((String) (jsonobject))))
                                {
                                    jsonobject = Uri.parse(jsonobject);
                                } else
                                {
                                    jsonobject = null;
                                }
                                jsonobject = new a(s, s2, jsonobject, a.a(((JSONObject) (obj)).optJSONArray("versions")));
                            }
                        }
                    }
                    if (jsonobject != null)
                    {
                        String s1 = ((a) (jsonobject)).a;
                        Map map = (Map)hashmap.get(s1);
                        obj = map;
                        if (map == null)
                        {
                            obj = new HashMap();
                            hashmap.put(s1, obj);
                        }
                        ((Map) (obj)).put(((a) (jsonobject)).b, jsonobject);
                    }
                    j++;
                }
            }
        }
        return hashmap;
    }

    public static void a()
    {
        k.b();
    }

    public static void a(Context context, String s)
    {
        boolean flag = c.compareAndSet(false, true);
        if (a(s) || b.containsKey(s) || !flag)
        {
            return;
        } else
        {
            String s1 = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] {
                s
            });
            k.e().execute(new Runnable(context, s1, s) {

                final Context a;
                final String b;
                final String c;

                public final void run()
                {
                    SharedPreferences sharedpreferences = a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                    Object obj = sharedpreferences.getString(b, null);
                    if (!t.a(((String) (obj))))
                    {
                        try
                        {
                            obj = new JSONObject(((String) (obj)));
                        }
                        catch (JSONException jsonexception)
                        {
                            t.a(jsonexception);
                            jsonexception = null;
                        }
                        if (obj != null)
                        {
                            t.a(c, ((JSONObject) (obj)));
                        }
                    }
                    obj = t.f(c);
                    if (obj != null)
                    {
                        t.a(c, ((JSONObject) (obj)));
                        sharedpreferences.edit().putString(b, ((JSONObject) (obj)).toString()).apply();
                    }
                    t.b().set(false);
                }

            
            {
                a = context;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
    }

    public static void a(Bundle bundle, String s, String s1)
    {
        if (!a(s1))
        {
            bundle.putString(s, s1);
        }
    }

    public static void a(Parcel parcel, Map map)
    {
        if (map == null)
        {
            parcel.writeInt(-1);
        } else
        {
            parcel.writeInt(map.size());
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                parcel.writeString((String)entry.getKey());
                parcel.writeString((String)entry.getValue());
            }
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void a(Exception exception)
    {
        if (k.b())
        {
            (new StringBuilder()).append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage());
        }
    }

    public static void a(String s, c c1)
    {
        JSONObject jsonobject = r.a(s);
        if (jsonobject != null)
        {
            c1.a(jsonobject);
            return;
        } else
        {
            c1 = new com.facebook.GraphRequest.b(c1, s) {

                final c a;
                final String b;

                public final void a(p p1)
                {
                    if (p1.b != null)
                    {
                        a.a(p1.b.e);
                        return;
                    } else
                    {
                        r.a(b, p1.a);
                        a.a(p1.a);
                        return;
                    }
                }

            
            {
                a = c1;
                b = s;
                super();
            }
            };
            s = h(s);
            s.a(c1);
            c1 = new GraphRequest[1];
            c1[0] = s;
            u.a(c1, "requests");
            GraphRequest.b(new o(Arrays.asList(c1)));
            return;
        }
    }

    public static void a(URLConnection urlconnection)
    {
        if (urlconnection instanceof HttpURLConnection)
        {
            ((HttpURLConnection)urlconnection).disconnect();
        }
    }

    public static void a(JSONObject jsonobject, Context context)
    {
        double d1;
        int j;
        int l;
        JSONArray jsonarray = new JSONArray();
        jsonarray.put("a2");
        if (e == -1L || System.currentTimeMillis() - e >= 0x1b7740L)
        {
            e = System.currentTimeMillis();
            float f1;
            Object obj;
            Exception exception;
            Object obj1;
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            String s;
            int i1;
            try
            {
                TimeZone timezone = TimeZone.getDefault();
                h = timezone.getDisplayName(timezone.inDaylightTime(new Date()), 0);
            }
            catch (Exception exception4) { }
            if (i.equals("NoCarrier"))
            {
                try
                {
                    i = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
                }
                catch (Exception exception3) { }
            }
            try
            {
                if (d())
                {
                    StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    long l1 = statfs.getBlockCount();
                    f = (long)statfs.getBlockSize() * l1;
                }
                f = a(f);
            }
            catch (Exception exception2) { }
            try
            {
                if (d())
                {
                    StatFs statfs1 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    long l2 = statfs1.getAvailableBlocks();
                    g = (long)statfs1.getBlockSize() * l2;
                }
                g = a(g);
            }
            catch (Exception exception1) { }
        }
        s = context.getPackageName();
        l = -1;
        obj = "";
        j = l;
        obj1 = context.getPackageManager().getPackageInfo(s, 0);
        j = l;
        l = ((PackageInfo) (obj1)).versionCode;
        j = l;
        obj1 = ((PackageInfo) (obj1)).versionName;
        j = l;
        obj = obj1;
_L3:
        jsonarray.put(s);
        jsonarray.put(j);
        jsonarray.put(obj);
        jsonarray.put(android.os.Build.VERSION.RELEASE);
        jsonarray.put(Build.MODEL);
        try
        {
            obj = context.getResources().getConfiguration().locale;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception = Locale.getDefault();
        }
        jsonarray.put((new StringBuilder()).append(((Locale) (obj)).getLanguage()).append("_").append(((Locale) (obj)).getCountry()).toString());
        jsonarray.put(h);
        jsonarray.put(i);
        context = (WindowManager)context.getSystemService("window");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_604;
        }
        context = context.getDefaultDisplay();
        obj = new DisplayMetrics();
        context.getMetrics(((DisplayMetrics) (obj)));
        j = ((DisplayMetrics) (obj)).widthPixels;
        l = ((DisplayMetrics) (obj)).heightPixels;
        f1 = ((DisplayMetrics) (obj)).density;
        d1 = f1;
        i1 = l;
        l = j;
        j = i1;
_L1:
        jsonarray.put(l);
        jsonarray.put(j);
        jsonarray.put(String.format("%.2f", new Object[] {
            Double.valueOf(d1)
        }));
        jsonarray.put(c());
        jsonarray.put(f);
        jsonarray.put(g);
        jsonobject.put("extinfo", jsonarray.toString());
        return;
        context;
        j = 0;
        l = 0;
_L2:
        d1 = 0.0D;
          goto _L1
        context;
        i1 = 0;
        l = j;
        j = i1;
          goto _L2
        context;
        i1 = j;
        j = l;
        l = i1;
          goto _L2
        namenotfoundexception;
          goto _L3
        d1 = 0.0D;
        j = 0;
        l = 0;
          goto _L1
    }

    public static void a(JSONObject jsonobject, com.facebook.b.c c1, String s, boolean flag)
    {
        boolean flag2 = true;
        if (c1 != null && c1.a != null)
        {
            jsonobject.put("attribution", c1.a);
        }
        if (c1 != null && c1.b != null)
        {
            jsonobject.put("advertiser_id", c1.b);
            boolean flag1;
            if (!c1.d)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            jsonobject.put("advertiser_tracking_enabled", flag1);
        }
        if (c1 != null && c1.c != null)
        {
            jsonobject.put("installer_package", c1.c);
        }
        jsonobject.put("anon_id", s);
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        jsonobject.put("application_tracking_enabled", flag);
    }

    public static boolean a(AccessToken accesstoken)
    {
        if (accesstoken != null)
        {
            return accesstoken.equals(AccessToken.a());
        } else
        {
            return false;
        }
    }

    public static boolean a(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static boolean a(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean a(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static Bundle b(String s)
    {
        Bundle bundle = new Bundle();
        if (a(s)) goto _L2; else goto _L1
_L1:
        int j;
        int l;
        s = s.split("&");
        l = s.length;
        j = 0;
_L8:
        if (j >= l) goto _L2; else goto _L3
_L3:
        String as[] = s[j].split("=");
        if (as.length != 2) goto _L5; else goto _L4
_L4:
        bundle.putString(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
          goto _L6
_L5:
        try
        {
            if (as.length == 1)
            {
                bundle.putString(URLDecoder.decode(as[0], "UTF-8"), "");
            }
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            a(unsupportedencodingexception);
        }
          goto _L6
_L2:
        return bundle;
_L6:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static b b(String s, JSONObject jsonobject)
    {
        JSONArray jsonarray = jsonobject.optJSONArray("android_sdk_error_categories");
        if (jsonarray != null) goto _L2; else goto _L1
_L1:
        Object obj = k.a();
_L4:
        jsonobject = new b(jsonobject.optBoolean("supports_implicit_sdk_logging", false), jsonobject.optString("gdpv4_nux_content", ""), jsonobject.optBoolean("gdpv4_nux_enabled", false), a(jsonobject.optJSONObject("android_dialog_configs")), ((com.facebook.b.k) (obj)), (byte)0);
        b.put(s, jsonobject);
        return jsonobject;
_L2:
        if (jsonarray == null)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        int j = 0;
        obj = null;
        String s1 = null;
        String s2 = null;
        Map map = null;
        Map map1 = null;
        Map map2 = null;
        while (j < jsonarray.length()) 
        {
            JSONObject jsonobject1 = jsonarray.optJSONObject(j);
            Map map3 = map2;
            Map map4 = map1;
            Map map5 = map;
            String s3 = s2;
            String s4 = s1;
            Object obj1 = obj;
            if (jsonobject1 != null)
            {
                String s5 = jsonobject1.optString("name");
                map3 = map2;
                map4 = map1;
                map5 = map;
                s3 = s2;
                s4 = s1;
                obj1 = obj;
                if (s5 != null)
                {
                    if (s5.equalsIgnoreCase("other"))
                    {
                        s3 = jsonobject1.optString("recovery_message", null);
                        map3 = k.a(jsonobject1);
                        obj1 = obj;
                        s4 = s1;
                        map5 = map;
                        map4 = map1;
                    } else
                    if (s5.equalsIgnoreCase("transient"))
                    {
                        s4 = jsonobject1.optString("recovery_message", null);
                        map4 = k.a(jsonobject1);
                        map3 = map2;
                        map5 = map;
                        s3 = s2;
                        obj1 = obj;
                    } else
                    {
                        map3 = map2;
                        map4 = map1;
                        map5 = map;
                        s3 = s2;
                        s4 = s1;
                        obj1 = obj;
                        if (s5.equalsIgnoreCase("login_recoverable"))
                        {
                            obj1 = jsonobject1.optString("recovery_message", null);
                            map5 = k.a(jsonobject1);
                            map3 = map2;
                            map4 = map1;
                            s3 = s2;
                            s4 = s1;
                        }
                    }
                }
            }
            j++;
            map2 = map3;
            map1 = map4;
            map = map5;
            s2 = s3;
            s1 = s4;
            obj = obj1;
        }
        obj = new com.facebook.b.k(map2, map1, map, s2, s1, ((String) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient List b(Object aobj[])
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < 2; j++)
        {
            Object obj = aobj[j];
            if (obj != null)
            {
                arraylist.add(obj);
            }
        }

        return arraylist;
    }

    static AtomicBoolean b()
    {
        return c;
    }

    public static void b(Context context)
    {
        b(context, "facebook.com");
        b(context, ".facebook.com");
        b(context, "https://facebook.com");
        b(context, "https://.facebook.com");
    }

    private static void b(Context context, String s)
    {
        CookieSyncManager.createInstance(context).sync();
        context = CookieManager.getInstance();
        String s1 = context.getCookie(s);
        if (s1 == null)
        {
            return;
        }
        String as[] = s1.split(";");
        int l = as.length;
        for (int j = 0; j < l; j++)
        {
            String as1[] = as[j].split("=");
            if (as1.length > 0)
            {
                context.setCookie(s, (new StringBuilder()).append(as1[0].trim()).append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;").toString());
            }
        }

        context.removeExpiredCookie();
    }

    private static int c()
    {
        if (d > 0)
        {
            return d;
        }
        try
        {
            d = (new File("/sys/devices/system/cpu/")).listFiles(new FilenameFilter() {

                public final boolean accept(File file, String s)
                {
                    return Pattern.matches("cpu[0-9]+", s);
                }

            }).length;
        }
        catch (Exception exception) { }
        if (d <= 0)
        {
            d = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return d;
    }

    public static String c(Context context)
    {
        if (context == null)
        {
            return "null";
        }
        if (context == context.getApplicationContext())
        {
            return "unknown";
        } else
        {
            return context.getClass().getSimpleName();
        }
    }

    public static void c(String s)
    {
        if (k.b())
        {
            a(s);
        }
    }

    public static b d(String s)
    {
        if (s != null)
        {
            return (b)b.get(s);
        } else
        {
            return null;
        }
    }

    private static boolean d()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static JSONObject e(String s)
    {
        JSONObject jsonobject = r.a(s);
        if (jsonobject != null)
        {
            return jsonobject;
        }
        s = h(s).a();
        if (((p) (s)).b != null)
        {
            return null;
        } else
        {
            return ((p) (s)).a;
        }
    }

    static JSONObject f(String s)
    {
        return g(s);
    }

    private static JSONObject g(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", a));
        s = GraphRequest.a(s);
        s.g = true;
        s.d = bundle;
        return s.a().a;
    }

    private static GraphRequest h(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", s);
        return new GraphRequest(null, "me", bundle, q.a, null);
    }

}
