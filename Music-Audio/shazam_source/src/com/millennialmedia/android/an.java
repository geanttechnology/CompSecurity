// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.millennialmedia.android:
//            al, a, v, am, 
//            ab, ag, w, at, 
//            r

public final class an
{
    static class a
    {

        protected static final String a = com/millennialmedia/android/an$a.getName();

        static void a(Context context, long l1)
        {
            if (com.millennialmedia.android.an.d())
            {
                a(context, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), l1);
            }
        }

        private static final void a(Context context, Intent intent, long l1)
        {
            if (context != null)
            {
                intent.addCategory("millennialmedia.category.CATEGORY_SDK");
                if (l1 != -4L)
                {
                    intent.putExtra("internalId", l1);
                }
                intent.putExtra("packageName", context.getPackageName());
                String s = intent.getStringExtra("intentType");
                if (!TextUtils.isEmpty(s))
                {
                    s = String.format(" Type[%s]", new Object[] {
                        s
                    });
                } else
                {
                    s = "";
                }
                (new StringBuilder(" @@ Intent: ")).append(intent.getAction()).append(" ").append(s).append(" for ").append(l1);
                al.a();
                context.sendBroadcast(intent);
            }
        }

        static void a(Context context, String s, long l1)
        {
            if (com.millennialmedia.android.an.d())
            {
                a(context, (new Intent("millennialmedia.action.ACTION_INTENT_STARTED")).putExtra("intentType", s), l1);
            }
        }

        static void a(ab ab1)
        {
            if (ab1 != null)
            {
                an.a(new Runnable(ab1) {

                    final ab a;

                    public final void run()
                    {
                        if (a == null || a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_36;
                        }
                        a.c.onSingleTap(a.d());
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                super();
            }
                });
                if (com.millennialmedia.android.an.d())
                {
                    a(ab1.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), ab1.h);
                    a(ab1.j(), new Intent("millennialmedia.action.ACTION_AD_SINGLE_TAP"), ab1.h);
                    return;
                }
            }
        }

        static void a(ab ab1, ag ag)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
            } else
            {
                an.a(new Runnable(ab1, ag) {

                    final ab a;
                    final ag b;

                    public final void run()
                    {
                        if (a == null || a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_40;
                        }
                        a.c.requestFailed(a.d(), b);
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                b = ag;
                super();
            }
                });
                if (com.millennialmedia.android.an.d())
                {
                    String s = ab1.m();
                    a(ab1.j(), (new Intent(s)).putExtra("error", ag), ab1.h);
                    return;
                }
            }
        }

        protected static void a(String s)
        {
            al.b();
            au.c.a(new Runnable(s) {

                final String a;

                public final void run()
                {
                    w w1 = new w();
                    try
                    {
                        w1.a(a);
                        return;
                    }
                    catch (Exception exception)
                    {
                        al.a(a.a, "Error logging event: ", exception);
                    }
                }

            
            {
                a = s;
                super();
            }
            });
        }

        static void b(ab ab1)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
            } else
            {
                an.a(new Runnable(ab1) {

                    final ab a;

                    public final void run()
                    {
                        if (a == null || a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_36;
                        }
                        a.c.MMAdRequestIsCaching(a.d());
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                super();
            }
                });
                if (com.millennialmedia.android.an.d())
                {
                    a(ab1.j(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), ab1.h);
                    return;
                }
            }
        }

        static void c(ab ab1)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
                return;
            }
            if (com.millennialmedia.android.an.d())
            {
                a(ab1.j(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), ab1.h);
            }
            d(ab1);
        }

        static void d(ab ab1)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
                return;
            } else
            {
                an.a(new Runnable(ab1) {

                    final ab a;

                    public final void run()
                    {
                        if (a == null)
                        {
                            break MISSING_BLOCK_LABEL_44;
                        }
                        a.j = true;
                        if (a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_44;
                        }
                        a.c.MMAdOverlayLaunched(a.d());
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                super();
            }
                });
                a(ab1.j(), ab1.h);
                return;
            }
        }

        static void e(ab ab1)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
            } else
            {
                an.a(new Runnable(ab1) {

                    final ab a;

                    public final void run()
                    {
                        if (a == null)
                        {
                            break MISSING_BLOCK_LABEL_44;
                        }
                        a.j = false;
                        if (a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_44;
                        }
                        a.c.MMAdOverlayClosed(a.d());
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                super();
            }
                });
                if (com.millennialmedia.android.an.d() && ab1.j() != null)
                {
                    a(ab1.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), ab1.h);
                    return;
                }
            }
        }

        static void f(ab ab1)
        {
            if (ab1 == null)
            {
                com.millennialmedia.android.al.d();
            } else
            {
                an.a(new Runnable(ab1) {

                    final ab a;

                    public final void run()
                    {
                        if (a == null || a.c == null)
                        {
                            break MISSING_BLOCK_LABEL_36;
                        }
                        a.c.requestCompleted(a.d());
                        return;
                        Exception exception;
                        exception;
                        al.a("MMSDK", "Exception raised in your RequestListener: ", exception);
                        return;
                    }

            
            {
                a = ab1;
                super();
            }
                });
                if (com.millennialmedia.android.an.d())
                {
                    String s = ab1.n();
                    a(ab1.j(), new Intent(s), ab1.h);
                    return;
                }
            }
        }


        a()
        {
        }
    }


    static int a;
    static boolean b = false;
    static String c = ",";
    static Handler d = new Handler(Looper.getMainLooper());
    static String e;
    private static boolean f;
    private static int g = 0x711e41a1;
    private static String h = null;
    private static boolean i = false;

    private static AlertDialog a(Context context, String s)
    {
        context = (new android.app.AlertDialog.Builder(context)).create();
        context.setTitle("Whoops!");
        context.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[] {
            s
        }));
        context.setButton(-3, "OK", new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
            }

        });
        context.show();
        return context;
    }

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        for (int i1 = 0; i1 < abyte0.length; i1++)
        {
            stringbuilder.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i1])
            }));
        }

        return stringbuilder.toString();
    }

    static void a(Context context, Map map)
    {
        Object obj2;
        obj2 = null;
        al.b();
        map.put("density", Float.toString(context.getResources().getDisplayMetrics().density));
        map.put("hpx", g(context));
        map.put("wpx", f(context));
        if (!i) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s;
        String s1;
        boolean flag;
        if (context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        obj = "true";
_L14:
        map.put("sk", obj);
        map.put("mic", Boolean.toString(context.getPackageManager().hasSystemFeature("android.hardware.microphone")));
        s1 = "true";
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0)
        {
            break MISSING_BLOCK_LABEL_1196;
        }
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = o(context);
        if (info == null)
        {
            break MISSING_BLOCK_LABEL_1196;
        }
        float f1;
        if (info == null)
        {
            obj = null;
        } else
        {
            obj = info.getId();
        }
        obj1 = s1;
        s = ((String) (obj));
        if (obj != null)
        {
            obj1 = s1;
            s = ((String) (obj));
            if (info.isLimitAdTrackingEnabled())
            {
                obj1 = "false";
                s = ((String) (obj));
            }
        }
_L20:
        if (s != null)
        {
            map.put("aaid", s);
            map.put("ate", obj1);
        } else
        {
            obj = c(context);
            if (obj != null)
            {
                map.put("mmdid", obj);
            }
        }
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!android.os.Build.VERSION.SDK.equalsIgnoreCase("8") || Environment.getExternalStorageState().equals("mounted") && com.millennialmedia.android.a.a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            map.put("cachedvideo", "true");
        } else
        {
            map.put("cachedvideo", "false");
        }
        if (Build.MODEL != null)
        {
            map.put("dm", Build.MODEL);
        }
        if (android.os.Build.VERSION.RELEASE != null)
        {
            map.put("dv", (new StringBuilder("Android")).append(android.os.Build.VERSION.RELEASE).toString());
        }
        map.put("sdkversion", "5.4.0-c325424f.a");
        obj = context.getResources().getConfiguration();
        if (((Configuration) (obj)).mcc != 0) goto _L5; else goto _L4
_L4:
        obj1 = n(context);
        if (obj1 == null || ((String) (obj1)).length() < 6) goto _L5; else goto _L6
_L6:
        obj = ((String) (obj1)).substring(0, 3);
_L15:
        map.put("mcc", obj);
        obj = context.getResources().getConfiguration();
        if (((Configuration) (obj)).mnc != 0) goto _L8; else goto _L7
_L7:
        obj1 = n(context);
        if (obj1 == null || ((String) (obj1)).length() < 6) goto _L8; else goto _L9
_L9:
        obj = ((String) (obj1)).substring(3);
_L16:
        map.put("mnc", obj);
        obj = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            map.put("cn", obj);
        }
        obj = Locale.getDefault();
        if (obj != null)
        {
            map.put("language", ((Locale) (obj)).getLanguage());
            map.put("country", ((Locale) (obj)).getCountry());
        }
        try
        {
            obj = context.getPackageName();
            map.put("pkid", obj);
            obj1 = context.getPackageManager();
            map.put("pknm", ((PackageManager) (obj1)).getApplicationLabel(((PackageManager) (obj1)).getApplicationInfo(((String) (obj)), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.a("MMSDK", "Can't insert package information", ((Throwable) (obj)));
        }
        obj = v.a(context).b(context);
        if (obj != null)
        {
            map.put("appsids", obj);
        }
        obj = com.millennialmedia.android.a.a(context);
        if (obj != null)
        {
            map.put("vid", obj);
        }
        s = b(context);
        if (!com.millennialmedia.android.a.g(context)) goto _L11; else goto _L10
_L10:
        obj = new StatFs(com.millennialmedia.android.a.e(context).getAbsolutePath());
_L17:
        s1 = Long.toString((long)((StatFs) (obj)).getAvailableBlocks() * (long)((StatFs) (obj)).getBlockSize());
        obj = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (obj == null) goto _L13; else goto _L12
_L12:
        if (((Intent) (obj)).getIntExtra("plugged", 0) == 0)
        {
            context = "false";
        } else
        {
            context = "true";
        }
        f1 = 100F / (float)((Intent) (obj)).getIntExtra("scale", 100);
        obj1 = Integer.toString((int)((float)((Intent) (obj)).getIntExtra("level", 0) * f1));
        obj = context;
        context = ((Context) (obj1));
_L19:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_731;
        }
        if (context.length() > 0)
        {
            map.put("bl", context);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_753;
        }
        if (((String) (obj)).length() > 0)
        {
            map.put("plugged", obj);
        }
        if (s1.length() > 0)
        {
            map.put("space", s1);
        }
        map.put("conn", s);
        context = URLEncoder.encode(e(), "UTF-8");
        if (!TextUtils.isEmpty(context))
        {
            map.put("pip", context);
        }
_L18:
        if (am.l != null)
        {
            map.put("lat", Double.toString(am.l.getLatitude()));
            map.put("long", Double.toString(am.l.getLongitude()));
            if (am.l.hasAccuracy())
            {
                map.put("ha", Float.toString(am.l.getAccuracy()));
                map.put("va", Float.toString(am.l.getAccuracy()));
            }
            if (am.l.hasSpeed())
            {
                map.put("spd", Float.toString(am.l.getSpeed()));
            }
            if (am.l.hasBearing())
            {
                map.put("brg", Float.toString(am.l.getBearing()));
            }
            if (am.l.hasAltitude())
            {
                map.put("alt", Double.toString(am.l.getAltitude()));
            }
            map.put("tslr", Long.toString(am.l.getTime()));
            map.put("loc", "true");
            map.put("lsrc", am.l.getProvider());
            return;
        } else
        {
            map.put("loc", "false");
            return;
        }
_L2:
        obj = "false";
          goto _L14
_L5:
        obj = String.valueOf(((Configuration) (obj)).mcc);
          goto _L15
_L8:
        obj = String.valueOf(((Configuration) (obj)).mnc);
          goto _L16
_L11:
        obj = new StatFs(context.getFilesDir().getPath());
          goto _L17
        context;
        al.a("MMSDK", "Exception inserting common parameters: ", context);
          goto _L18
_L13:
        context = null;
        obj = obj2;
          goto _L19
        s = null;
        obj1 = s1;
          goto _L20
    }

    static void a(ab ab1)
    {
        if (ab1 != null)
        {
            Context context = ab1.j();
            String.format("MMAd External ID: %d", new Object[] {
                Integer.valueOf(ab1.f())
            });
            com.millennialmedia.android.al.c();
            String.format("MMAd Internal ID: %d", new Object[] {
                Long.valueOf(ab1.h)
            });
            com.millennialmedia.android.al.c();
            String.format("APID: %s", new Object[] {
                ab1.e
            });
            com.millennialmedia.android.al.c();
            if (com.millennialmedia.android.a.g(context))
            {
                ab1 = "";
            } else
            {
                ab1 = "not ";
            }
            String.format("SD card is %savailable.", new Object[] {
                ab1
            });
            com.millennialmedia.android.al.c();
            if (context != null)
            {
                String.format("Package: %s", new Object[] {
                    context.getPackageName()
                });
                com.millennialmedia.android.al.c();
                String.format("MMDID: %s", new Object[] {
                    c(context)
                });
                com.millennialmedia.android.al.c();
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.INTERNET is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.VIBRATE is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)
                {
                    ab1 = "not ";
                } else
                {
                    ab1 = "";
                }
                String.format("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[] {
                    ab1
                });
                com.millennialmedia.android.al.c();
                com.millennialmedia.android.al.c();
                com.millennialmedia.android.a.a(context, 2, new a.b(context) {

                    final Context a;

                    final boolean a(r r1)
                    {
                        String s1 = r1.d();
                        String s2 = r1.a;
                        String s;
                        if (r1.c(a))
                        {
                            s = "";
                        } else
                        {
                            s = "not ";
                        }
                        if (r1.a())
                        {
                            r1 = "";
                        } else
                        {
                            r1 = "not ";
                        }
                        String.format("%s %s is %son disk. Is %sexpired.", new Object[] {
                            s1, s2, s, r1
                        });
                        com.millennialmedia.android.al.c();
                        return true;
                    }

            
            {
                a = context;
                super();
            }
                });
                return;
            }
        }
    }

    static void a(Runnable runnable)
    {
        if (a())
        {
            runnable.run();
            return;
        } else
        {
            d.post(runnable);
            return;
        }
    }

    static void a(Runnable runnable, long l1)
    {
        d.postDelayed(runnable, l1);
    }

    static void a(String s)
    {
        com/millennialmedia/android/an;
        JVM INSTR monitorenter ;
        h = s;
        com/millennialmedia/android/an;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    static boolean a()
    {
        return d.getLooper() == Looper.myLooper();
    }

    static boolean a(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        return context.getActiveNetworkInfo() != null && context.getActiveNetworkInfo().isConnected();
    }

    static String b(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return "unknown";
        }
        if (context.getActiveNetworkInfo() != null && context.getActiveNetworkInfo().isConnected())
        {
            int i1 = context.getActiveNetworkInfo().getType();
            int j1 = context.getActiveNetworkInfo().getSubtype();
            if (i1 == 1)
            {
                return "wifi";
            }
            if (i1 == 0)
            {
                switch (j1)
                {
                default:
                    return "unknown";

                case 7: // '\007'
                    return "1xrtt";

                case 4: // '\004'
                    return "cdma";

                case 2: // '\002'
                    return "edge";

                case 14: // '\016'
                    return "ehrpd";

                case 5: // '\005'
                    return "evdo_0";

                case 6: // '\006'
                    return "evdo_a";

                case 12: // '\f'
                    return "evdo_b";

                case 1: // '\001'
                    return "gprs";

                case 8: // '\b'
                    return "hsdpa";

                case 10: // '\n'
                    return "hspa";

                case 15: // '\017'
                    return "hspap";

                case 9: // '\t'
                    return "hsupa";

                case 11: // '\013'
                    return "iden";

                case 13: // '\r'
                    return "lte";

                case 3: // '\003'
                    return "umts";
                }
            } else
            {
                return "unknown";
            }
        } else
        {
            return "offline";
        }
    }

    static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    static String c(Context context)
    {
        Object obj = null;
        com/millennialmedia/android/an;
        JVM INSTR monitorenter ;
        if (h == null) goto _L2; else goto _L1
_L1:
        context = h;
_L4:
        com/millennialmedia/android/an;
        JVM INSTR monitorexit ;
        return context;
_L2:
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        context = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = new StringBuilder("mmh_");
        context.append(a(MessageDigest.getInstance("MD5").digest(s.getBytes())));
        context.append("_");
        context.append(a(MessageDigest.getInstance("SHA1").digest(s.getBytes())));
        context = context.toString();
        h = context;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        context;
        al.a("MMSDK", "Exception calculating hash: ", context);
        context = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean c()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    static void d(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            a(context, "INTERNET permission").show();
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            a(context, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    static boolean d()
    {
        return f;
    }

    private static String e()
    {
        StringBuilder stringbuilder;
        Enumeration enumeration;
        stringbuilder = new StringBuilder();
        enumeration = NetworkInterface.getNetworkInterfaces();
_L6:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_146;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L3:
        Object obj;
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (InetAddress)enumeration1.nextElement();
        } while (((InetAddress) (obj)).isLoopbackAddress());
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(',');
        }
        obj = ((InetAddress) (obj)).getHostAddress().toUpperCase();
        if (!InetAddressUtils.isIPv4Address(((String) (obj)))) goto _L2; else goto _L1
_L1:
        stringbuilder.append(((String) (obj)));
          goto _L3
_L2:
        int i1;
        try
        {
            i1 = ((String) (obj)).indexOf('%');
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.a("MMSDK", "Exception getting ip information: ", ((Throwable) (obj)));
            return "";
        }
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
_L4:
        stringbuilder.append(((String) (obj)));
          goto _L3
        continue; /* Loop/switch isn't completed */
        obj = ((String) (obj)).substring(0, i1);
          goto _L4
        obj = stringbuilder.toString();
        return ((String) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void e(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.MMActivity"), 128);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            al.a("MMSDK", "Activity MMActivity not declared in AndroidManifest.xml", namenotfoundexception);
            namenotfoundexception.printStackTrace();
            a(context, "MMActivity class").show();
            return;
        }
    }

    static String f(Context context)
    {
        return Integer.toString(context.getResources().getDisplayMetrics().widthPixels);
    }

    static String g(Context context)
    {
        return Integer.toString(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static void h(Context context)
    {
        context = v.a(context);
        context.a(true);
        if (!TextUtils.isEmpty(((v) (context)).f))
        {
            au.c.a(new au.a._cls1(((v) (context)).f));
        }
    }

    static int i(Context context)
    {
        return ((AudioManager)context.getApplicationContext().getSystemService("audio")).getStreamVolume(3);
    }

    static String j(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String k(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String l(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return "default";

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";

        case 3: // '\003'
            return "square";
        }
    }

    static final String m(Context context)
    {
        if (android.provider.Settings.System.getString(context.getContentResolver(), "accelerometer_rotation").equals("1"))
        {
            return "false";
        } else
        {
            return "true";
        }
    }

    private static String n(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
    }

    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info o(Context context)
    {
        try
        {
            context = AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("MMSDK", "Unrecoverable error connecting to Google Play services (e.g.,the old version of the service doesnt support getting AdvertisingId", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("MMSDK", "Google Play services is not available entirely.", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("MMSDK", "IllegalStateException: ", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("MMSDK", "Google Play Services is not installed, up-to-date, or enabled", context);
            return null;
        }
        return context;
    }

    static 
    {
        try
        {
            System.loadLibrary("nmsp_speex");
            i = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror) { }
    }
}
