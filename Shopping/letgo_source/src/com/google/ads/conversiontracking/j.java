// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.ads.conversiontracking:
//            h, d, u

public class j
{
    public static class a
    {

        private final String a;
        private final String b;
        private final long c;

        public static a a(String s)
        {
            if (!TextUtils.isEmpty(s))
            {
                if ((s = s.split(" ")).length == 3)
                {
                    boolean flag;
                    try
                    {
                        s = new a(s[0], s[1], Long.parseLong(s[2]));
                        flag = s.a();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return null;
                    }
                    if (!flag)
                    {
                        return s;
                    }
                }
            }
            return null;
        }

        static String a(a a1)
        {
            return a1.b;
        }

        static String b(a a1)
        {
            return a1.a;
        }

        static long c(a a1)
        {
            return a1.c;
        }

        public boolean a()
        {
            return c + 0x1cf7c5800L < j.a();
        }

        public a(String s, String s1)
        {
            this(s, s1, j.a());
        }

        private a(String s, String s1, long l)
        {
            a = s;
            b = s1;
            c = l;
        }
    }

    public static class b
    {

        private final String a;
        private final a b;

        static String a(b b1)
        {
            return b1.a;
        }

        static a b(b b1)
        {
            return b1.b;
        }

        public b(String s, a a1)
        {
            a = s;
            b = a1;
        }
    }

    public static class c
    {

        private String a;
        private boolean b;
        private boolean c;
        private d d;
        private String e;
        private String f;
        private a g;
        private Map h;
        private String i;
        private long j;
        private boolean k;

        static boolean a(c c1)
        {
            return c1.c;
        }

        static d b(c c1)
        {
            return c1.d;
        }

        static String c(c c1)
        {
            return c1.a;
        }

        static String d(c c1)
        {
            return c1.f;
        }

        static Map e(c c1)
        {
            return c1.h;
        }

        static a f(c c1)
        {
            return c1.g;
        }

        static String g(c c1)
        {
            return c1.e;
        }

        static long h(c c1)
        {
            return c1.j;
        }

        static boolean i(c c1)
        {
            return c1.k;
        }

        static boolean j(c c1)
        {
            return c1.b;
        }

        static String k(c c1)
        {
            return c1.i;
        }

        public c a()
        {
            k = true;
            return this;
        }

        public c a(long l)
        {
            j = TimeUnit.MILLISECONDS.toSeconds(l);
            return this;
        }

        public c a(a a1)
        {
            g = a1;
            return this;
        }

        public c a(d d1)
        {
            d = d1;
            return this;
        }

        public c a(String s)
        {
            a = s;
            return this;
        }

        public c a(boolean flag)
        {
            b = flag;
            return this;
        }

        public c b(String s)
        {
            e = s;
            return this;
        }

        public c c(String s)
        {
            f = s;
            return this;
        }

        public c()
        {
        }
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        private static final d e[];

        public static d[] a()
        {
            return (d[])e.clone();
        }

        static 
        {
            a = new d("DOUBLECLICK_AUDIENCE", 0);
            b = new d("DOUBLECLICK_CONVERSION", 1);
            c = new d("GOOGLE_CONVERSION", 2);
            d = new d("IAP_CONVERSION", 3);
            e = (new d[] {
                a, b, c, d
            });
        }

        private d(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map a = new HashMap();
    private static boolean b = false;
    private static long c = -1L;
    private static boolean d = true;
    private static boolean e = false;
    private static final Object f = new Object();
    private static h g = null;
    private static boolean h = false;

    static long a()
    {
        if (b && c >= 0L)
        {
            return c;
        } else
        {
            return System.currentTimeMillis();
        }
    }

    public static h a(Context context)
    {
        synchronized (f)
        {
            if (g == null)
            {
                g = new h(context);
            }
            context = g;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static a a(Context context, String s)
    {
        String s1;
        synchronized (a)
        {
            s1 = (String)a.get(s);
        }
        obj = s1;
        if (s1 == null)
        {
            obj = context.getSharedPreferences("google_conversion_click_referrer", 0).getString(s, "");
        }
        return a.a(((String) (obj)));
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static b a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        uri = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(uri))
        {
            return null;
        }
        uri = String.valueOf(uri);
        String s1;
        String s2;
        if (uri.length() != 0)
        {
            uri = "http://hostname/?".concat(uri);
        } else
        {
            uri = new String("http://hostname/?");
        }
        uri = Uri.parse(uri);
        s1 = uri.getQueryParameter("conv");
        s2 = uri.getQueryParameter("gclid");
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            return null;
        }
        String s = uri.getQueryParameter("ai");
        uri = s;
        if (s == null)
        {
            uri = "";
        }
        return new b(s1, new a(s2, uri));
    }

    static String a(long l)
    {
        return String.format(Locale.US, "%d.%03d", new Object[] {
            Long.valueOf(l / 1000L), Long.valueOf(l % 1000L)
        });
    }

    public static String a(Context context, c c1)
        throws NoSuchAlgorithmException
    {
        return a(context, c1, (new com.google.ads.conversiontracking.d(context)).a());
    }

    public static String a(Context context, c c1, l.a a1)
        throws NoSuchAlgorithmException
    {
        String s;
        String s1;
        s1 = context.getPackageName();
        s = "";
        Object obj = context.getPackageManager().getPackageInfo(s1, 0).versionName;
        s = ((String) (obj));
_L2:
        obj = null;
        if (a1 == null)
        {
            obj = e(context);
        }
        if (!c.a(c1) && c.b(c1) == d.b)
        {
            return a(c1, s1, s, a1, ((String) (obj)));
        }
        break; /* Loop/switch isn't completed */
        obj;
        Log.w("GoogleConversionReporter", "Error to retrieve app version", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        if (c.b(c1) == d.a)
        {
            return a(c1, a1);
        }
        if (c.b(c1) == d.d)
        {
            return c(c1, s1, s, a1, ((String) (obj)));
        } else
        {
            return b(c1, s1, s, a1, ((String) (obj)));
        }
    }

    public static String a(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        if (TextUtils.isEmpty(a.a(a1)))
        {
            String s = String.valueOf("&gclid=");
            a1 = String.valueOf(a.b(a1));
            if (a1.length() != 0)
            {
                return s.concat(a1);
            } else
            {
                return new String(s);
            }
        } else
        {
            String s1 = String.valueOf(String.valueOf("&gclid="));
            String s2 = String.valueOf(String.valueOf(a.b(a1)));
            String s3 = String.valueOf(String.valueOf("ai"));
            a1 = String.valueOf(String.valueOf(a.a(a1)));
            return (new StringBuilder(s1.length() + 2 + s2.length() + s3.length() + a1.length())).append(s1).append(s2).append("&").append(s3).append("=").append(a1).toString();
        }
    }

    public static String a(c c1)
    {
        static class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[d.a().length];
                try
                {
                    a[d.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[d.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2.a[c.b(c1).ordinal()])
        {
        default:
            return "google_nonrepeatable_conversion";

        case 1: // '\001'
            return "doubleclick_nonrepeatable_conversion";

        case 2: // '\002'
            return "iap_nonrepeatable_conversion";
        }
    }

    public static String a(c c1, l.a a1)
    {
        if (a1 == null)
        {
            return null;
        }
        String s = String.valueOf(String.valueOf("https://pubads.g.doubleclick.net/activity;dc_iu="));
        String s2 = String.valueOf(String.valueOf(c.d(c1)));
        String s3 = String.valueOf(String.valueOf("dc_lat"));
        String s4 = String.valueOf(String.valueOf(a(a1)));
        String s5 = String.valueOf(String.valueOf("dc_rdid"));
        a1 = String.valueOf(String.valueOf(a1.a()));
        a1 = new StringBuilder((new StringBuilder(s.length() + 4 + s2.length() + s3.length() + s4.length() + s5.length() + a1.length())).append(s).append(s2).append(";").append(s3).append("=").append(s4).append(";").append(s5).append("=").append(a1).toString());
        if (c.e(c1) != null)
        {
            String s1;
            Object obj;
            for (c1 = c.e(c1).entrySet().iterator(); c1.hasNext(); a1.append((new StringBuilder(s1.length() + 2 + ((String) (obj)).length())).append(";").append(s1).append("=").append(((String) (obj))).toString()))
            {
                obj = (java.util.Map.Entry)c1.next();
                s1 = Uri.encode((String)((java.util.Map.Entry) (obj)).getKey());
                obj = Uri.encode(((java.util.Map.Entry) (obj)).getValue().toString());
                s1 = String.valueOf(String.valueOf(s1));
                obj = String.valueOf(String.valueOf(obj));
            }

        }
        return a1.toString();
    }

    public static String a(c c1, String s, String s1, l.a a1, String s2)
    {
        String s3 = String.valueOf(String.valueOf("https://pubads.g.doubleclick.net/activity;xsp="));
        c1 = String.valueOf(String.valueOf(c.c(c1)));
        String s4 = String.valueOf(String.valueOf("ait"));
        String s5 = String.valueOf(String.valueOf("bundleid"));
        s = String.valueOf(String.valueOf(s));
        String s6 = String.valueOf(String.valueOf("appversion"));
        s1 = String.valueOf(String.valueOf(s1));
        String s7 = String.valueOf(String.valueOf("osversion"));
        String s8 = String.valueOf(String.valueOf(android.os.Build.VERSION.RELEASE));
        String s9 = String.valueOf(String.valueOf("sdkversion"));
        String s10 = String.valueOf(String.valueOf("ct-sdk-a-v2.2.1"));
        String s11 = String.valueOf(String.valueOf("timestamp"));
        String s12 = String.valueOf(String.valueOf(a(a())));
        String s13 = String.valueOf(String.valueOf("dc_lat"));
        String s14 = String.valueOf(String.valueOf(a(a1)));
        c1 = (new StringBuilder(s3.length() + 15 + c1.length() + s4.length() + s5.length() + s.length() + s6.length() + s1.length() + s7.length() + s8.length() + s9.length() + s10.length() + s11.length() + s12.length() + s13.length() + s14.length())).append(s3).append(c1).append(";").append(s4).append("=").append("1").append(";").append(s5).append("=").append(s).append(";").append(s6).append("=").append(s1).append(";").append(s7).append("=").append(s8).append(";").append(s9).append("=").append(s10).append(";").append(s11).append("=").append(s12).append(";").append(s13).append("=").append(s14).toString();
        if (a1 == null)
        {
            c1 = String.valueOf(c1);
            s = String.valueOf(String.valueOf(";isu="));
            s1 = String.valueOf(String.valueOf(s2));
            return (new StringBuilder(c1.length() + 0 + s.length() + s1.length())).append(c1).append(s).append(s1).toString();
        } else
        {
            c1 = String.valueOf(c1);
            s = String.valueOf(String.valueOf(";dc_rdid="));
            s1 = String.valueOf(String.valueOf(a1.a()));
            return (new StringBuilder(c1.length() + 0 + s.length() + s1.length())).append(c1).append(s).append(s1).toString();
        }
    }

    private static String a(l.a a1)
    {
        if (a1 == null || a1.b())
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    private static List a(SharedPreferences sharedpreferences)
    {
        ArrayList arraylist = new ArrayList();
        sharedpreferences = sharedpreferences.getAll().entrySet().iterator();
        do
        {
            if (!sharedpreferences.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)sharedpreferences.next();
            if (a.a((String)entry.getValue()) == null)
            {
                arraylist.add(entry.getKey());
            }
        } while (true);
        return arraylist;
    }

    public static void a(Context context, String s, String s1)
    {
        context = context.getSharedPreferences(s, 0).edit();
        context.putBoolean(s1, true);
        context.commit();
    }

    private static void a(android.net.Uri.Builder builder, boolean flag, Map map)
    {
        if (flag && map != null)
        {
            Iterator iterator = map.entrySet().iterator();
label0:
            do
            {
                java.util.Map.Entry entry;
label1:
                do
                {
                    while (iterator.hasNext()) 
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        if (!(entry.getValue() instanceof String))
                        {
                            continue label1;
                        }
                        map = String.valueOf("data.");
                        String s = String.valueOf((String)entry.getKey());
                        if (s.length() != 0)
                        {
                            map = map.concat(s);
                        } else
                        {
                            map = new String(map);
                        }
                        builder.appendQueryParameter(map, (String)entry.getValue());
                    }
                    break label0;
                } while (!(entry.getValue() instanceof String[]));
                String as[] = (String[])(String[])entry.getValue();
                int k = as.length;
                int i = 0;
                while (i < k) 
                {
                    String s1 = as[i];
                    map = String.valueOf("data.");
                    String s2 = String.valueOf((String)entry.getKey());
                    if (s2.length() != 0)
                    {
                        map = map.concat(s2);
                    } else
                    {
                        map = new String(map);
                    }
                    builder.appendQueryParameter(map, s1);
                    i++;
                }
            } while (true);
        }
    }

    public static boolean a(Context context, b b1)
    {
        if (b1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        List list;
        context = context.getSharedPreferences("google_conversion_click_referrer", 0);
        list = a(((SharedPreferences) (context)));
        if (context.getString(b.a(b1), null) == null && context.getAll().size() == 100 && list.isEmpty()) goto _L1; else goto _L3
_L3:
        String s1;
        String s = String.valueOf(String.valueOf(a.b(b.b(b1))));
        s1 = String.valueOf(String.valueOf(" "));
        String s2 = String.valueOf(String.valueOf(a.a(b.b(b1))));
        String s3 = String.valueOf(String.valueOf(" "));
        long l = a.c(b.b(b1));
        s1 = (new StringBuilder(s.length() + 20 + s1.length() + s2.length() + s3.length())).append(s).append(s1).append(s2).append(s3).append(l).toString();
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        String s4;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); a.remove(s4))
        {
            s4 = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_234;
        context;
        map;
        JVM INSTR monitorexit ;
        throw context;
        a.put(b.a(b1), s1);
        map;
        JVM INSTR monitorexit ;
        (new Thread(new Runnable(context, list, b1, s1) {

            final SharedPreferences a;
            final List b;
            final b c;
            final String d;

            public void run()
            {
                android.content.SharedPreferences.Editor editor = a.edit();
                for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); editor.remove((String)iterator1.next())) { }
                editor.putString(b.a(c), d);
                editor.commit();
            }

            
            {
                a = sharedpreferences;
                b = list;
                c = b1;
                d = s;
                super();
            }
        })).start();
        return true;
    }

    public static boolean a(Context context, c c1, boolean flag)
    {
        return a(context, a(c1), b(c1), flag);
    }

    public static boolean a(Context context, String s, String s1, boolean flag)
    {
        boolean flag1 = true;
        if (b && e)
        {
            flag1 = d;
        } else
        if (!flag)
        {
            flag = context.getSharedPreferences(s, 0).getBoolean(s1, false);
            if (flag)
            {
                context = String.valueOf(s1);
                if (context.length() != 0)
                {
                    context = "Already sent ping for conversion ".concat(context);
                } else
                {
                    context = new String("Already sent ping for conversion ");
                }
                Log.i("GoogleConversionReporter", context);
            }
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }
        return flag1;
    }

    public static long b(Context context)
    {
        return context.getSharedPreferences("google_conversion", 0).getLong("last_retry_time", 0L);
    }

    public static String b(c c1)
    {
        switch (_cls2.a[c.b(c1).ordinal()])
        {
        default:
            return c.g(c1);

        case 1: // '\001'
            return c.c(c1);

        case 2: // '\002'
            return String.format("google_iap_ping:%s", new Object[] {
                c.k(c1)
            });
        }
    }

    public static String b(c c1, String s, String s1, l.a a1, String s2)
    {
        String s3 = a(c.f(c1));
        s1 = Uri.parse("https://www.googleadservices.com/pagead/conversion/").buildUpon().appendEncodedPath(String.valueOf(c.c(c1)).concat("/")).appendQueryParameter("bundleid", s).appendQueryParameter("appversion", s1).appendQueryParameter("osversion", android.os.Build.VERSION.RELEASE).appendQueryParameter("sdkversion", "ct-sdk-a-v2.2.1");
        if (a1 != null)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s = s1.appendQueryParameter("gms", s).appendQueryParameter("lat", a(a1));
        if (c.g(c1) != null && c.d(c1) != null)
        {
            s.appendQueryParameter("label", c.g(c1)).appendQueryParameter("value", c.d(c1));
        }
        if (c.h(c1) != 0L)
        {
            s.appendQueryParameter("timestamp", a(c.h(c1)));
        } else
        {
            s.appendQueryParameter("timestamp", a(a()));
        }
        if (c.a(c1))
        {
            s.appendQueryParameter("remarketing_only", "1");
        }
        if (c.i(c1))
        {
            s.appendQueryParameter("auto", "1");
        }
        if (c.j(c1))
        {
            s.appendQueryParameter("usage_tracking_enabled", "1");
        } else
        {
            s.appendQueryParameter("usage_tracking_enabled", "0");
        }
        if (a1 != null)
        {
            s.appendQueryParameter("rdid", a1.a());
        } else
        {
            s.appendQueryParameter("muid", s2);
        }
        a(s, c.a(c1), c.e(c1));
        c1 = String.valueOf(String.valueOf(s.build()));
        s = String.valueOf(String.valueOf(s3));
        return (new StringBuilder(c1.length() + 0 + s.length())).append(c1).append(s).toString();
    }

    public static String c(c c1, String s, String s1, l.a a1, String s2)
    {
        c1 = Uri.parse("https://www.googleadservices.com/pagead/conversion/").buildUpon().appendQueryParameter("sku", c.k(c1)).appendQueryParameter("value", c.d(c1)).appendQueryParameter("bundleid", s).appendQueryParameter("appversion", s1).appendQueryParameter("osversion", android.os.Build.VERSION.RELEASE).appendQueryParameter("sdkversion", "ct-sdk-a-v2.2.1").appendQueryParameter("timestamp", a(a())).appendQueryParameter("lat", a(a1));
        if (a1 != null)
        {
            c1.appendQueryParameter("rdid", a1.a());
        } else
        {
            c1.appendQueryParameter("muid", s2);
        }
        return c1.build().toString();
    }

    public static void c(Context context)
    {
        context = context.getSharedPreferences("google_conversion", 0).edit();
        context.putLong("last_retry_time", a());
        context.commit();
    }

    public static boolean d(Context context)
    {
        if (b)
        {
            return h;
        }
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null)
        {
            context = context.getActiveNetworkInfo();
            if (context == null || !context.isConnected())
            {
                return false;
            }
        }
        return true;
    }

    private static String e(Context context)
        throws NoSuchAlgorithmException
    {
        Object obj = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        context = ((Context) (obj));
        if (obj == null)
        {
            context = "null";
        }
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).update(context.getBytes());
        return u.a(((MessageDigest) (obj)).digest(), false);
    }

}
