// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.h;
import com.facebook.j;
import com.facebook.k;
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
import java.util.HashSet;
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

// Referenced classes of package android.support.v7:
//            kc, jz, jk, js

public final class kb
{
    public static class a
    {

        private String a;
        private String b;
        private Uri c;
        private int d[];

        static a a(JSONObject jsonobject)
        {
            return b(jsonobject);
        }

        private static int[] a(JSONArray jsonarray)
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
                        if (!kb.a(s))
                        {
                            try
                            {
                                j = Integer.parseInt(s);
                            }
                            catch (NumberFormatException numberformatexception)
                            {
                                kb.a("FacebookSDK", numberformatexception);
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

        private static a b(JSONObject jsonobject)
        {
            Uri uri = null;
            String s = jsonobject.optString("name");
            String as[];
            if (!kb.a(s))
            {
                if ((as = s.split("\\|")).length == 2)
                {
                    String s1 = as[0];
                    String s2 = as[1];
                    if (!kb.a(s1) && !kb.a(s2))
                    {
                        String s3 = jsonobject.optString("url");
                        if (!kb.a(s3))
                        {
                            uri = Uri.parse(s3);
                        }
                        return new a(s1, s2, uri, a(jsonobject.optJSONArray("versions")));
                    }
                }
            }
            return null;
        }

        public String a()
        {
            return a;
        }

        public String b()
        {
            return b;
        }

        public int[] c()
        {
            return d;
        }

        private a(String s, String s1, Uri uri, int ai[])
        {
            a = s;
            b = s1;
            c = uri;
            d = ai;
        }
    }

    public static class b
    {

        private boolean a;
        private String b;
        private boolean c;
        private Map d;
        private js e;

        public boolean a()
        {
            return a;
        }

        public Map b()
        {
            return d;
        }

        public js c()
        {
            return e;
        }

        private b(boolean flag, String s, boolean flag1, Map map, js js1)
        {
            a = flag;
            b = s;
            c = flag1;
            d = map;
            e = js1;
        }

    }

    public static interface c
    {

        public abstract void a(h h1);

        public abstract void a(JSONObject jsonobject);
    }

    public static interface d
    {

        public abstract Object a(Object obj);
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
        throws IOException
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
        if (bufferedinputstream != null)
        {
            bufferedinputstream.close();
        }
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
            s = (Map)s.b().get(s1);
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
        JSONObject jsonobject = f(s);
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
        throws JSONException
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
        kc.a(context, "context");
        k.a(context);
        return k.i();
    }

    public static String a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        } else
        {
            return uri.toString();
        }
    }

    public static String a(InputStream inputstream)
        throws IOException
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
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return a(((MessageDigest) (s)), abyte0);
    }

    private static String a(MessageDigest messagedigest, byte abyte0[])
    {
        messagedigest.update(abyte0);
        messagedigest = messagedigest.digest();
        abyte0 = new StringBuilder();
        int l = messagedigest.length;
        for (int j = 0; j < l; j++)
        {
            byte byte0 = messagedigest[j];
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

    public static List a(List list, d d1)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Object obj = d1.a(list.next());
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            } while (true);
            if (arraylist.size() != 0)
            {
                return arraylist;
            }
        }
        return null;
    }

    public static List a(JSONArray jsonarray)
        throws JSONException
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
                    a a1 = a.a(jsonarray.optJSONObject(j));
                    if (a1 != null)
                    {
                        String s = a1.a();
                        Map map = (Map)hashmap.get(s);
                        jsonobject = map;
                        if (map == null)
                        {
                            jsonobject = new HashMap();
                            hashmap.put(s, jsonobject);
                        }
                        jsonobject.put(a1.b(), a1);
                    }
                    j++;
                }
            }
        }
        return hashmap;
    }

    static AtomicBoolean a()
    {
        return c;
    }

    public static void a(Context context, String s)
    {
        boolean flag = c.compareAndSet(false, true);
        if (!a(s) && !b.containsKey(s) && flag)
        {
            String s1 = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] {
                s
            });
            k.d().execute(new Runnable(s, context, s1) {

                final String a;
                final Context b;
                final String c;

                public void run()
                {
                    JSONObject jsonobject = kb.e(a);
                    if (jsonobject != null)
                    {
                        kb.a(a, jsonobject);
                        b.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).edit().putString(c, jsonobject.toString()).apply();
                    }
                    kb.a().set(false);
                }

            
            {
                a = s;
                b = context;
                c = s1;
                super();
            }
            });
            context = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).getString(s1, null);
            if (!a(((String) (context))))
            {
                try
                {
                    context = new JSONObject(context);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    a("FacebookSDK", ((Exception) (context)));
                    context = null;
                }
                if (context != null)
                {
                    b(s, context);
                    return;
                }
            }
        }
    }

    public static void a(Bundle bundle, String s, Uri uri)
    {
        if (uri != null)
        {
            a(bundle, s, uri.toString());
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

    public static void a(File file)
    {
        if (!file.exists())
        {
            return;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int l = afile.length;
            for (int j = 0; j < l; j++)
            {
                a(afile[j]);
            }

        }
        file.delete();
    }

    public static void a(String s, c c1)
    {
        JSONObject jsonobject = jz.a(s);
        if (jsonobject != null)
        {
            c1.a(jsonobject);
            return;
        } else
        {
            c1 = new com.facebook.GraphRequest.b(c1, s) {

                final c a;
                final String b;

                public void a(p p1)
                {
                    if (p1.a() != null)
                    {
                        a.a(p1.a().e());
                        return;
                    } else
                    {
                        jz.a(b, p1.b());
                        a.a(p1.b());
                        return;
                    }
                }

            
            {
                a = c1;
                b = s;
                super();
            }
            };
            s = g(s);
            s.a(c1);
            s.j();
            return;
        }
    }

    public static void a(String s, Exception exception)
    {
        if (k.b() && s != null && exception != null)
        {
            Log.d(s, (new StringBuilder()).append(exception.getClass().getSimpleName()).append(": ").append(exception.getMessage()).toString());
        }
    }

    public static void a(String s, String s1)
    {
        if (k.b() && s != null && s1 != null)
        {
            Log.d(s, s1);
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (k.b() && !a(s))
        {
            Log.d(s, s1, throwable);
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
        throws JSONException
    {
        Object obj;
        JSONArray jsonarray;
        String s;
        int j;
        int l;
        jsonarray = new JSONArray();
        jsonarray.put("a2");
        d(context);
        s = context.getPackageName();
        l = -1;
        obj = "";
        j = l;
        Object obj1 = context.getPackageManager().getPackageInfo(s, 0);
        j = l;
        l = ((PackageInfo) (obj1)).versionCode;
        j = l;
        obj1 = ((PackageInfo) (obj1)).versionName;
        j = l;
        obj = obj1;
_L3:
        double d1;
        jsonarray.put(s);
        jsonarray.put(j);
        jsonarray.put(obj);
        jsonarray.put(android.os.Build.VERSION.RELEASE);
        jsonarray.put(Build.MODEL);
        float f1;
        int i1;
        try
        {
            obj = context.getResources().getConfiguration().locale;
        }
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
            break MISSING_BLOCK_LABEL_403;
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
        jsonarray.put(b());
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
        boolean flag = false;
        l = j;
        j = ((flag) ? 1 : 0);
          goto _L2
        context;
        int j1 = j;
        j = l;
        l = j1;
          goto _L2
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
          goto _L3
        d1 = 0.0D;
        j = 0;
        l = 0;
          goto _L1
    }

    public static void a(JSONObject jsonobject, jk jk1, String s, boolean flag)
        throws JSONException
    {
        boolean flag2 = true;
        if (jk1 != null && jk1.a() != null)
        {
            jsonobject.put("attribution", jk1.a());
        }
        if (jk1 != null && jk1.b() != null)
        {
            jsonobject.put("advertiser_id", jk1.b());
            boolean flag1;
            if (!jk1.d())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            jsonobject.put("advertiser_tracking_enabled", flag1);
        }
        if (jk1 != null && jk1.c() != null)
        {
            jsonobject.put("installer_package", jk1.c());
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

    private static int b()
    {
        if (d > 0)
        {
            return d;
        }
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            d = 1;
            return d;
        }
        try
        {
            d = (new File("/sys/devices/system/cpu/")).listFiles(new FilenameFilter() {

                public boolean accept(File file, String s)
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
            a("FacebookSDK", unsupportedencodingexception);
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
        Object obj = jsonobject.optJSONArray("android_sdk_error_categories");
        if (obj == null)
        {
            obj = js.a();
        } else
        {
            obj = js.a(((JSONArray) (obj)));
        }
        jsonobject = new b(jsonobject.optBoolean("supports_implicit_sdk_logging", false), jsonobject.optString("gdpv4_nux_content", ""), jsonobject.optBoolean("gdpv4_nux_enabled", false), a(jsonobject.optJSONObject("android_dialog_configs")), ((js) (obj)));
        b.put(s, jsonobject);
        return jsonobject;
    }

    public static transient List b(Object aobj[])
    {
        ArrayList arraylist = new ArrayList();
        int l = aobj.length;
        for (int j = 0; j < l; j++)
        {
            Object obj = aobj[j];
            if (obj != null)
            {
                arraylist.add(obj);
            }
        }

        return arraylist;
    }

    public static Set b(JSONArray jsonarray)
        throws JSONException
    {
        HashSet hashset = new HashSet();
        for (int j = 0; j < jsonarray.length(); j++)
        {
            hashset.add(jsonarray.getString(j));
        }

        return hashset;
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

    public static boolean b(Uri uri)
    {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()));
    }

    public static b c(String s)
    {
        if (s != null)
        {
            return (b)b.get(s);
        } else
        {
            return null;
        }
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

    private static void c()
    {
        try
        {
            TimeZone timezone = TimeZone.getDefault();
            h = timezone.getDisplayName(timezone.inDaylightTime(new Date()), 0);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static boolean c(Uri uri)
    {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static JSONObject d(String s)
    {
        JSONObject jsonobject = jz.a(s);
        if (jsonobject != null)
        {
            return jsonobject;
        }
        s = g(s).i();
        if (s.a() != null)
        {
            return null;
        } else
        {
            return s.b();
        }
    }

    private static void d(Context context)
    {
        if (e == -1L || System.currentTimeMillis() - e >= 0x1b7740L)
        {
            e = System.currentTimeMillis();
            c();
            e(context);
            f();
            e();
        }
    }

    private static boolean d()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean d(Uri uri)
    {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static long e(Uri uri)
    {
        uri = k.f().getContentResolver().query(uri, null, null, null, null);
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

    static JSONObject e(String s)
    {
        return f(s);
    }

    private static void e()
    {
        try
        {
            if (d())
            {
                StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long l = statfs.getAvailableBlocks();
                g = (long)statfs.getBlockSize() * l;
            }
            g = a(g);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static void e(Context context)
    {
        if (!i.equals("NoCarrier"))
        {
            break MISSING_BLOCK_LABEL_27;
        }
        i = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        return;
        context;
    }

    private static JSONObject f(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", a));
        s = GraphRequest.a(null, s, null);
        s.a(true);
        s.a(bundle);
        return s.i().b();
    }

    private static void f()
    {
        try
        {
            if (d())
            {
                StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long l = statfs.getBlockCount();
                f = (long)statfs.getBlockSize() * l;
            }
            f = a(f);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static GraphRequest g(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", s);
        return new GraphRequest(null, "me", bundle, q.a, null);
    }

}
