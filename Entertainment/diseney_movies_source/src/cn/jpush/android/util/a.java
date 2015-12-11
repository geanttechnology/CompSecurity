// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.InstrumentedListActivity;
import cn.jpush.android.data.d;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.DownloadService;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.q;
import cn.jpush.android.service.r;
import cn.jpush.android.ui.PushActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            x, m, ai, ae, 
//            b, y

public final class a
{

    public static int a;
    private static List b;
    private static final X500Principal c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final ArrayList g;
    private static final ArrayList h;
    private static final ArrayList i;
    private static PushReceiver j;
    private static final String z[];

    private static String A(Context context)
    {
label0:
        {
            if (!a() || !c(context, z[7]))
            {
                cn.jpush.android.util.x.f();
                return null;
            }
            context = new File(f);
            if (!context.exists())
            {
                break label0;
            }
            try
            {
                context = cn.jpush.android.util.m.a(new FileInputStream(context));
                if (context.size() <= 0)
                {
                    break label0;
                }
                context = (String)context.get(0);
                (new StringBuilder(z[9])).append(context).toString();
                cn.jpush.android.util.x.d();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
            return context;
        }
        return null;
    }

    private static String B(Context context)
    {
        Object obj = k(context);
        if (ai.a(((String) (obj))) || !d(((String) (obj)))) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        String s1;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            s1 = Build.SERIAL;
        } else
        {
            s1 = null;
        }
        if (ai.a(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s1;
        if (d(s1)) goto _L1; else goto _L3
_L3:
        context = i(context, " ");
        if (ai.a(context))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = context;
        if (d(context)) goto _L1; else goto _L4
_L4:
        return UUID.randomUUID().toString();
    }

    private static boolean C(Context context)
    {
        String s1;
        String s2;
        try
        {
            s2 = android.provider.Settings.System.getString(context.getContentResolver(), z[51]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cn.jpush.android.util.x.f();
            return false;
        }
        s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = i(context, "");
        }
        android.provider.Settings.System.putString(context.getContentResolver(), z[51], s1);
        cn.jpush.android.util.x.d();
        return true;
    }

    private static boolean D(Context context)
    {
        Intent intent = new Intent(z[4]);
        intent.setPackage(context.getPackageName());
        intent.addCategory(z[5]);
        context = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        context = Class.forName(((ActivityInfo) (context)).name);
        if (context == null)
        {
            return false;
        }
        boolean flag;
        if (cn/jpush/android/api/InstrumentedActivity.isAssignableFrom(context))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        flag = cn/jpush/android/api/InstrumentedListActivity.isAssignableFrom(context);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        return true;
        context;
        return false;
    }

    private static void E(Context context)
    {
        cn.jpush.android.util.x.d();
        if (j == null)
        {
            j = new PushReceiver();
        }
        context.registerReceiver(j, new IntentFilter(z[68]));
        context.registerReceiver(j, new IntentFilter(z[65]));
        try
        {
            IntentFilter intentfilter = new IntentFilter(z[69]);
            intentfilter.addDataScheme(z[67]);
            IntentFilter intentfilter1 = new IntentFilter(z[66]);
            intentfilter1.addDataScheme(z[67]);
            IntentFilter intentfilter2 = new IntentFilter(z[64]);
            intentfilter2.setPriority(1000);
            intentfilter2.addCategory(context.getPackageName());
            context.registerReceiver(j, intentfilter);
            context.registerReceiver(j, intentfilter1);
            context.registerReceiver(j, intentfilter2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static int a(byte byte0)
    {
        return byte0 & 0xff;
    }

    public static int a(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f1);
    }

    public static Intent a(Context context, d d1, boolean flag)
    {
        Intent intent = new Intent();
        intent.putExtra(z[74], flag);
        intent.putExtra(z[73], d1);
        intent.setAction(z[72]);
        intent.addCategory(context.getPackageName());
        intent.addFlags(0x10000000);
        return intent;
    }

    public static String a(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        if (context == null)
        {
            return z[99];
        } else
        {
            int i1 = ((DisplayMetrics) (context)).widthPixels;
            int j1 = ((DisplayMetrics) (context)).heightPixels;
            return (new StringBuilder()).append(i1).append("*").append(j1).toString();
        }
    }

    public static String a(Context context, String s1)
    {
        String s3 = (new StringBuilder()).append(android.os.Build.VERSION.RELEASE).append(",").append(Integer.toString(android.os.Build.VERSION.SDK_INT)).toString();
        String s4 = Build.MODEL;
        String s5 = cn.jpush.android.service.q.a(context, z[17], z[14]);
        String s6 = Build.DEVICE;
        String s2;
        int i1;
        if (ai.a(cn.jpush.android.a.e))
        {
            s2 = " ";
        } else
        {
            s2 = cn.jpush.android.a.e;
        }
        s1 = (new StringBuilder()).append(s3).append(z[100]).append(s4).append(z[100]).append(s5).append(z[100]).append(s6).append(z[100]).append(s2).append(z[100]).append(s1).append(z[100]);
        s2 = context.getApplicationInfo().sourceDir;
        if (ai.a(s2))
        {
            cn.jpush.android.util.x.f();
            i1 = 0;
        } else
        {
            (new StringBuilder(z[101])).append(s2).toString();
            cn.jpush.android.util.x.c();
            if (s2.startsWith(z[102]))
            {
                i1 = 1;
            } else
            if (s2.startsWith(z[103]))
            {
                i1 = 0;
            } else
            {
                cn.jpush.android.util.x.d();
                i1 = 0;
            }
        }
        if (i1 != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        return s1.append(i1).append(z[100]).append(a(context)).toString();
    }

    public static String a(String s1)
    {
        int j1 = 0;
        Object obj;
        byte abyte0[];
        int i1;
        try
        {
            obj = MessageDigest.getInstance(z[27]);
            s1 = s1.toCharArray();
            abyte0 = new byte[s1.length];
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cn.jpush.android.util.x.c();
            return "";
        }
        i1 = 0;
        while (i1 < s1.length) 
        {
            abyte0[i1] = (byte)s1[i1];
            i1++;
        }
        s1 = ((MessageDigest) (obj)).digest(abyte0);
        obj = new StringBuffer();
        i1 = j1;
_L2:
        if (i1 >= s1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = s1[i1] & 0xff;
        if (j1 >= 16)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        ((StringBuffer) (obj)).append("0");
        ((StringBuffer) (obj)).append(Integer.toHexString(j1));
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        s1 = ((StringBuffer) (obj)).toString();
        return s1;
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int i1;
        int j1;
        try
        {
            abyte0 = MessageDigest.getInstance(z[27]).digest(abyte0);
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            cn.jpush.android.util.x.c();
            return "";
        }
        i1 = 0;
        if (i1 >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = abyte0[i1] & 0xff;
        if (j1 >= 16)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        stringbuffer.append("0");
        stringbuffer.append(Integer.toHexString(j1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_24;
_L1:
        abyte0 = stringbuffer.toString();
        return abyte0;
    }

    public static JSONObject a(String s1, JSONArray jsonarray)
    {
        if (jsonarray == null || jsonarray.length() == 0)
        {
            return null;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(z[58], jsonarray);
            jsonobject.put(z[46], s1);
            jsonobject.put(z[59], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.getMessage();
            cn.jpush.android.util.x.f();
            return null;
        }
        return jsonobject;
    }

    public static void a(Context context, d d1)
    {
        try
        {
            Intent intent = new Intent(z[76]);
            intent.putExtra(z[75], d1.n);
            intent.putExtra(z[77], d1.i);
            intent.putExtra(z[80], d1.j);
            intent.putExtra(z[82], d1.k);
            intent.putExtra(z[37], d1.l);
            intent.putExtra(z[79], d1.c);
            if (d1.f())
            {
                intent.putExtra(z[81], d1.U);
            }
            intent.addCategory(d1.m);
            context.sendBroadcast(intent, String.format(z[40], new Object[] {
                d1.m
            }));
            (new StringBuilder(z[78])).append(String.format(z[40], new Object[] {
                d1.m
            })).toString();
            cn.jpush.android.util.x.d();
            ServiceInterface.a(d1.c, 1018, context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getMessage();
        }
        cn.jpush.android.util.x.f();
    }

    public static void a(Context context, String s1, String s2, int i1)
    {
        Object obj = Uri.parse(s2);
        if (obj == null)
        {
            (new StringBuilder(z[94])).append(s2).toString();
            cn.jpush.android.util.x.c();
            return;
        } else
        {
            s2 = new Intent(z[28], ((Uri) (obj)));
            s2.setFlags(0x14000000);
            obj = android.content.Intent.ShortcutIconResource.fromContext(context, i1);
            Intent intent = new Intent(z[93]);
            intent.putExtra(z[97], false);
            intent.putExtra(z[96], s1);
            intent.putExtra(z[92], s2);
            intent.putExtra(z[95], ((android.os.Parcelable) (obj)));
            context.sendBroadcast(intent);
            return;
        }
    }

    public static boolean a()
    {
        boolean flag = Environment.getExternalStorageState().equals(z[85]);
        if (!flag)
        {
            cn.jpush.android.util.x.c();
        }
        return flag;
    }

    public static boolean a(Context context, String s1, String s2)
    {
        Intent intent;
label0:
        {
            if (context == null)
            {
                throw new IllegalArgumentException(z[25]);
            }
            if (TextUtils.isEmpty(s1))
            {
                (new StringBuilder(z[24])).append(s1).toString();
                cn.jpush.android.util.x.e();
                return false;
            }
            Intent intent1 = n(context, s1);
            intent = intent1;
            if (intent1 != null)
            {
                break MISSING_BLOCK_LABEL_109;
            }
            try
            {
                if (!TextUtils.isEmpty(s2))
                {
                    break label0;
                }
                cn.jpush.android.util.x.c();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                cn.jpush.android.util.x.h();
                return false;
            }
            return false;
        }
        intent = new Intent();
        intent.setClassName(s1, s2);
        intent.addCategory(z[5]);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
        return true;
    }

    public static boolean a(Context context, String s1, boolean flag)
    {
        PackageManager packagemanager = context.getPackageManager();
        s1 = new Intent(s1);
        s1.addCategory(context.getPackageName());
        return !packagemanager.queryBroadcastReceivers(s1, 0).isEmpty();
    }

    public static int b(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length < 20)
        {
            return -1;
        } else
        {
            return abyte0[3] & 0xff;
        }
    }

    public static String b(Context context, String s1)
    {
        String s3 = (new StringBuilder()).append(android.os.Build.VERSION.RELEASE).append(",").append(Integer.toString(android.os.Build.VERSION.SDK_INT)).toString();
        String s4 = Build.MODEL;
        String s5 = cn.jpush.android.service.q.a(context, z[17], z[14]);
        String s6 = Build.DEVICE;
        String s2;
        String s7;
        if (ai.a(cn.jpush.android.a.e))
        {
            s2 = " ";
        } else
        {
            s2 = cn.jpush.android.a.e;
        }
        s7 = d(context);
        context = new JSONObject();
        try
        {
            context.put(z[12], s3);
            context.put(z[13], s4);
            context.put(z[14], s5);
            context.put(z[11], s6);
            context.put(z[10], s2);
            context.put(z[15], s7);
            context.put(z[16], s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        return context.toString();
    }

    public static String b(String s1)
    {
        StringBuffer stringbuffer;
        int i1;
        int j1;
        try
        {
            s1 = MessageDigest.getInstance(z[27]).digest(s1.getBytes(z[84]));
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cn.jpush.android.util.x.c();
            return "";
        }
        i1 = 0;
        if (i1 >= s1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = s1[i1] & 0xff;
        if (j1 >= 16)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        stringbuffer.append("0");
        stringbuffer.append(Integer.toHexString(j1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_33;
_L1:
        s1 = stringbuffer.toString();
        return s1;
    }

    public static void b()
    {
        android.os.PowerManager.WakeLock wakelock = cn.jpush.android.service.r.a().b();
        if (wakelock != null)
        {
            if (wakelock.isHeld())
            {
                try
                {
                    wakelock.release();
                }
                catch (RuntimeException runtimeexception)
                {
                    (new StringBuilder(z[26])).append(runtimeexception).toString();
                    cn.jpush.android.util.x.c();
                }
            }
            cn.jpush.android.util.x.c();
        }
    }

    public static void b(Context context, String s1, String s2)
    {
        try
        {
            s1 = new Intent(s1);
            s1.putExtra(z[37], s2);
            s2 = context.getPackageName();
            if (ai.a(s2))
            {
                cn.jpush.android.util.x.e(z[39], z[38]);
            }
            s1.addCategory(s2);
            context.sendBroadcast(s1, String.format(z[40], new Object[] {
                s2
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getMessage();
        }
        cn.jpush.android.util.x.f();
    }

    public static void b(Context context, String s1, String s2, int i1)
    {
        Object obj;
        obj = new Intent(context, cn/jpush/android/service/PushReceiver);
        ((Intent) (obj)).setAction(z[48]);
        ((Intent) (obj)).putExtra(z[44], true);
        ((Intent) (obj)).putExtra(z[50], s2);
        ((Intent) (obj)).putExtra(z[46], i1);
        s2 = PendingIntent.getBroadcast(context, 0, ((Intent) (obj)), 0x8000000);
        obj = (NotificationManager)context.getSystemService(z[47]);
        i1 = -1;
        int j1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 256).applicationInfo.icon;
        i1 = j1;
_L2:
        int k1 = i1;
        if (i1 < 0)
        {
            k1 = 0x1080052;
        }
        String s3 = z[45];
        String s4 = z[49];
        Notification notification = new Notification(k1, s1, System.currentTimeMillis());
        notification.flags = 34;
        notification.setLatestEventInfo(context, s3, s4, s2);
        ((NotificationManager) (obj)).notify(s1.hashCode(), notification);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean b(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService(z[6])).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    private static boolean b(Context context, String s1, boolean flag)
    {
        return !context.getPackageManager().queryIntentServices(new Intent(s1), 0).isEmpty();
    }

    public static int c(byte abyte0[])
    {
        int i1;
        int j1;
        boolean flag;
        i1 = 0;
        flag = false;
        j1 = ((flag) ? 1 : 0);
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        if (abyte0.length >= 6) goto _L4; else goto _L3
_L3:
        j1 = ((flag) ? 1 : 0);
_L2:
        return j1;
_L4:
        int k1 = 0;
        do
        {
            j1 = i1;
            if (k1 >= 2)
            {
                continue;
            }
            j1 = abyte0[k1];
            k1++;
            i1 = (j1 & 0xff) + (i1 << 8);
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static String c()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (!(new File(z[87])).exists()) goto _L2; else goto _L1
_L1:
        Object obj = new BufferedReader(new FileReader(new File(z[87])));
_L6:
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null) goto _L4; else goto _L3
_L3:
        if (!s1.contains(z[88])) goto _L6; else goto _L5
_L5:
        int i1 = s1.indexOf(":");
        if (i1 < 0) goto _L6; else goto _L7
_L7:
        if (i1 >= s1.length() - 1) goto _L6; else goto _L8
_L8:
        stringbuffer.append(s1.substring(i1 + 1).trim());
          goto _L6
_L2:
        return stringbuffer.toString();
_L4:
        try
        {
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (true) goto _L2; else goto _L9
_L9:
    }

    public static short c(Context context)
    {
        return ae.b(context);
    }

    public static void c(Context context, String s1, String s2)
    {
        Object obj;
        int i1;
        if (!i(context))
        {
            return;
        }
        cn.jpush.android.util.x.c();
        obj = new Intent(context, cn/jpush/android/service/PushReceiver);
        ((Intent) (obj)).setAction(z[48]);
        ((Intent) (obj)).putExtra(z[44], true);
        ((Intent) (obj)).putExtra(z[89], s2);
        s2 = PendingIntent.getBroadcast(context, 0, ((Intent) (obj)), 0x8000000);
        obj = (NotificationManager)context.getSystemService(z[47]);
        i1 = -1;
        int j1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 256).applicationInfo.icon;
        i1 = j1;
_L2:
        int k1 = i1;
        if (i1 < 0)
        {
            k1 = 0x1080052;
        }
        String s3 = z[90];
        String s4 = z[91];
        Notification notification = new Notification(k1, s1, System.currentTimeMillis());
        notification.flags = 34;
        notification.setLatestEventInfo(context, s3, s4, s2);
        ((NotificationManager) (obj)).notify(s1.hashCode(), notification);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void c(String s1)
    {
        b.add(s1);
    }

    public static boolean c(Context context, String s1)
    {
        if (context == null || TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException(z[8]);
        }
        return context.getPackageManager().checkPermission(s1, context.getPackageName()) == 0;
    }

    public static String d()
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration;
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
_L4:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if (inetaddress.isLoopbackAddress() || !(inetaddress instanceof Inet4Address)) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress().toString();
        return ((String) (obj));
        Exception exception;
        exception;
        cn.jpush.android.util.x.e();
        exception.printStackTrace();
        return "";
    }

    public static String d(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService(z[6])).getActiveNetworkInfo();
        if (context == null)
        {
            context = z[83];
        } else
        {
            String s1 = context.getTypeName();
            String s2 = context.getSubtypeName();
            if (s1 == null)
            {
                return z[83];
            }
            context = s1;
            if (s2 != null)
            {
                return (new StringBuilder()).append(s1).append(",").append(s2).toString();
            }
        }
        return context;
    }

    public static boolean d(Context context, String s1)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = new ComponentName(context.getPackageName(), s1);
        try
        {
            packagemanager.getReceiverInfo(context, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    private static boolean d(Context context, String s1, String s2)
    {
        PackageManager packagemanager = context.getPackageManager();
        s2 = new Intent(s2);
        s2.setPackage(context.getPackageName());
        for (context = packagemanager.queryBroadcastReceivers(s2, 0).iterator(); context.hasNext();)
        {
            s2 = ((ResolveInfo)context.next()).activityInfo;
            if (s2 != null && ((ActivityInfo) (s2)).name.equals(s1))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean d(String s1)
    {
_L2:
        return false;
        if (ai.a(s1) || s1.length() < 10) goto _L2; else goto _L1
_L1:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= b.size())
                {
                    break label1;
                }
                if (s1.equals(b.get(i1)) || s1.startsWith((String)b.get(i1)))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    public static String e(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService(z[6])).getActiveNetworkInfo();
        if (context == null)
        {
            return "";
        } else
        {
            return context.getTypeName().toUpperCase(Locale.getDefault());
        }
    }

    public static void e(Context context, String s1)
    {
        Intent intent = new Intent();
        intent.addFlags(0x10000000);
        intent.setAction(z[28]);
        intent.setDataAndType(Uri.fromFile(new File(s1)), z[29]);
        context.startActivity(intent);
    }

    public static void f(Context context)
    {
        h(context, null);
    }

    public static boolean f(Context context, String s1)
    {
        try
        {
            context.getPackageManager().getApplicationInfo(s1, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static String g(Context context, String s1)
    {
        if (c(context, z[71]))
        {
            boolean flag;
            try
            {
                context = ((WifiManager)context.getSystemService(z[32])).getConnectionInfo().getMacAddress();
                flag = ai.a(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                cn.jpush.android.util.x.j();
                return s1;
            }
            if (!flag)
            {
                return context;
            }
        }
        return s1;
    }

    public static boolean g(Context context)
    {
        return ((PowerManager)context.getSystemService(z[56])).isScreenOn();
    }

    public static int h(Context context)
    {
        context = context.registerReceiver(null, new IntentFilter(z[42]));
        int i1 = context.getIntExtra(z[43], -1);
        boolean flag;
        if (i1 == 2 || i1 == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return -1;
        } else
        {
            return context.getIntExtra(z[41], -1);
        }
    }

    public static void h(Context context, String s1)
    {
        Intent intent = new Intent(z[4]);
        String s2 = context.getPackageName();
        intent.setPackage(s2);
        if (!ai.a(s1))
        {
            intent.putExtra(z[37], s1);
        }
        intent.addCategory(z[5]);
        s1 = context.getPackageManager().resolveActivity(intent, 0);
        (new StringBuilder(z[70])).append(((ResolveInfo) (s1)).activityInfo.name).toString();
        cn.jpush.android.util.x.d();
        intent.setClassName(s2, ((ResolveInfo) (s1)).activityInfo.name);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static String i(Context context, String s1)
    {
        if (c(context, z[19]))
        {
            s1 = ((TelephonyManager)context.getSystemService(z[18])).getDeviceId();
        }
        return s1;
    }

    public static boolean i(Context context)
    {
        boolean flag;
        boolean flag3 = false;
        boolean flag4 = false;
        flag = false;
        boolean flag1 = flag3;
        boolean flag2 = flag4;
        CertificateFactory certificatefactory;
        int i1;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return flag2;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag3;
        flag2 = flag4;
        certificatefactory = CertificateFactory.getInstance(z[62]);
        i1 = 0;
_L2:
        flag1 = flag;
        flag2 = flag;
        if (i1 >= context.length)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        flag1 = flag;
        flag2 = flag;
        flag = ((X509Certificate)certificatefactory.generateCertificate(new ByteArrayInputStream(context[i1].toByteArray()))).getSubjectX500Principal().equals(c);
        flag1 = flag;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i1++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        return flag1;
        return flag;
    }

    public static String j(Context context)
    {
        String s1 = ae.a(context, z[104], "");
        if (!ai.a(s1) && d(s1))
        {
            return s1;
        } else
        {
            String s2 = y(context);
            ae.b(context, z[104], s2);
            return s2;
        }
    }

    public static void j(Context context, String s1)
    {
        if (!ai.a(s1))
        {
            q(context, s1);
            o(context, s1);
            ae.b(context, z[36], s1);
        }
    }

    public static String k(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), z[86]);
    }

    private static boolean k(Context context, String s1)
    {
        if (context == null || TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException(z[8]);
        }
        context = context.getPackageManager();
        try
        {
            context.getPermissionInfo(s1, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static String l(Context context)
    {
        boolean flag1 = false;
        String s1 = ae.a(context, z[36], null);
        if (!ai.a(s1))
        {
            a = cn.jpush.android.util.b.d.ordinal();
            return s1;
        }
        s1 = p(context, s1);
        if (!ai.a(s1))
        {
            a = b.b.ordinal();
            o(context, s1);
            ae.b(context, z[36], s1);
            return s1;
        }
        s1 = A(context);
        if (!ai.a(s1))
        {
            a = b.c.ordinal();
            q(context, s1);
            ae.b(context, z[36], s1);
            return s1;
        }
        boolean flag2 = c(context, z[35]);
        boolean flag;
        if (c(context, z[7]) && a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag2 || flag)
        {
            if (!flag && flag2)
            {
                flag1 = C(context);
            } else
            {
                flag1 = true;
            }
        }
        if (!flag1)
        {
            a = b.e.ordinal();
            return B(context);
        }
        String s2 = i(context, s1);
        String s3 = k(context);
        String s4 = g(context, "");
        s1 = UUID.randomUUID().toString();
        s2 = a((new StringBuilder()).append(s2).append(s3).append(s4).append(s1).toString());
        if (!ai.a(s2))
        {
            s1 = s2;
        }
        s2 = q(context, s1);
        if (!ai.a(o(context, s1)) || !ai.a(s2))
        {
            (new StringBuilder(z[63])).append(s1).toString();
            cn.jpush.android.util.x.c();
            ae.b(context, z[36], s1);
            a = b.a.ordinal();
            return s1;
        } else
        {
            a = b.e.ordinal();
            cn.jpush.android.util.x.c();
            return B(context);
        }
    }

    private static boolean l(Context context, String s1)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = new ComponentName(context.getPackageName(), s1);
        try
        {
            packagemanager.getServiceInfo(context, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static void m(Context context)
    {
        context = ((PowerManager)context.getSystemService(z[56])).newWakeLock(1, z[57]);
        context.setReferenceCounted(false);
        cn.jpush.android.service.r.a().a(context);
        if (!cn.jpush.android.service.r.a().b().isHeld())
        {
            cn.jpush.android.service.r.a().b().acquire();
        }
        cn.jpush.android.util.x.c();
    }

    private static boolean m(Context context, String s1)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = new ComponentName(context.getPackageName(), s1);
        try
        {
            packagemanager.getActivityInfo(context, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    private static Intent n(Context context, String s1)
    {
        context = context.getPackageManager();
        if (context.getPackageInfo(s1, 256) == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        context = context.getLaunchIntentForPackage(s1);
        return context;
        context;
        return null;
    }

    public static JSONArray n(Context context)
    {
        Object obj = new ArrayList();
        List list = context.getPackageManager().getInstalledPackages(0);
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            PackageInfo packageinfo = (PackageInfo)list.get(i1);
            y y2 = new y();
            y2.a = packageinfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            y2.b = packageinfo.packageName;
            y2.c = packageinfo.versionName;
            y2.d = packageinfo.versionCode;
            ((ArrayList) (obj)).add(y2);
        }

        context = new JSONArray();
        try
        {
            JSONObject jsonobject;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); context.put(jsonobject))
            {
                y y1 = (y)((Iterator) (obj)).next();
                jsonobject = new JSONObject();
                jsonobject.put(z[1], y1.a);
                jsonobject.put(z[2], y1.b);
                jsonobject.put(z[3], y1.c);
                jsonobject.put(z[0], y1.d);
            }

        }
        catch (JSONException jsonexception) { }
        return context;
    }

    private static String o(Context context, String s1)
    {
        if (a() && c(context, z[7])) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        return context;
_L2:
        FileOutputStream fileoutputstream;
        context = new File(d);
        if (!context.exists())
        {
            try
            {
                context.mkdir();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                cn.jpush.android.util.x.j();
            }
        }
        context = new File(f);
        if (context.exists())
        {
            try
            {
                context.delete();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
        }
        try
        {
            context.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cn.jpush.android.util.x.j();
            return null;
        }
        fileoutputstream = new FileOutputStream(context);
        context = fileoutputstream;
        fileoutputstream.write(s1.getBytes());
        context = fileoutputstream;
        fileoutputstream.flush();
        context = fileoutputstream;
        cn.jpush.android.util.x.d();
        context = s1;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return s1;
            }
            return s1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        context;
        s1 = null;
_L8:
        context = s1;
        cn.jpush.android.util.x.j();
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return null;
        s1;
        context = null;
_L6:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw s1;
        s1;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        s1 = fileoutputstream;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static boolean o(Context context)
    {
        boolean flag1 = false;
        if (!ae.a(context, z[20], "0").equals("1"))
        {
            break MISSING_BLOCK_LABEL_30;
        }
        cn.jpush.android.util.x.d();
        return false;
        context = ae.a(context, z[23], "");
        if (!ai.a(context))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        cn.jpush.android.util.x.d();
        return true;
        String as[];
        (new StringBuilder(z[21])).append(context).toString();
        cn.jpush.android.util.x.d();
        as = context.split("_");
        String s1;
        context = as[0];
        s1 = as[1];
        int j1;
        int k1;
        int l1;
        context = context.toCharArray();
        s1 = s1.split(z[22]);
        Calendar calendar = Calendar.getInstance();
        j1 = calendar.get(7);
        k1 = calendar.get(11);
        l1 = context.length;
        int i1 = 0;
_L2:
        boolean flag;
        flag = flag1;
        if (i1 >= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        int i2;
        int j2;
        if (j1 != Integer.valueOf(String.valueOf(context[i1])).intValue() + 1)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        i2 = Integer.valueOf(s1[0]).intValue();
        j2 = Integer.valueOf(s1[1]).intValue();
        if (k1 >= i2 && k1 <= j2)
        {
            return true;
        }
        i1++;
        if (true) goto _L2; else goto _L1
        context;
        flag = true;
_L1:
        return flag;
    }

    private static String p(Context context, String s1)
    {
        String s2 = s1;
        if (c(context, z[35]))
        {
            try
            {
                s2 = android.provider.Settings.System.getString(context.getContentResolver(), z[36]);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                cn.jpush.android.util.x.f();
                return s1;
            }
        }
        return s2;
    }

    public static boolean p(Context context)
    {
        context = ae.a(context, z[110], "");
        if (!TextUtils.isEmpty(context)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        try
        {
            context = new JSONObject(context);
            i1 = context.optInt(z[109], -1);
            j1 = context.optInt(z[106], -1);
            k1 = context.optInt(z[108], -1);
            l1 = context.optInt(z[107], -1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (i1 < 0 || j1 < 0 || k1 < 0 || l1 < 0 || j1 > 59 || l1 > 59 || k1 > 23 || i1 > 23)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = Calendar.getInstance();
        i2 = context.get(11);
        j2 = context.get(12);
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i2 > i1 && i2 < k1 || i2 == i1 && j2 >= j1 || i2 == k1 && j2 <= l1)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (i1 != k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i2 != i1 || j2 < j1 || j2 > l1) goto _L1; else goto _L4
_L4:
        return true;
        if (i1 <= k1 || (i2 <= i1 || i2 > 23) && (i2 < 0 || i2 >= k1) && (i2 != i1 || j2 < j1) && (i2 != k1 || j2 > l1)) goto _L1; else goto _L5
_L5:
        return true;
    }

    private static String q(Context context, String s1)
    {
        if (!c(context, z[35]))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        boolean flag = android.provider.Settings.System.putString(context.getContentResolver(), z[36], s1);
        if (flag)
        {
            return s1;
        }
        break MISSING_BLOCK_LABEL_38;
        context;
        cn.jpush.android.util.x.f();
        return null;
    }

    public static boolean q(Context context)
    {
        boolean flag;
        boolean flag1;
        cn.jpush.android.util.x.b(z[39], z[115]);
        if (!l(context, cn/jpush/android/service/PushService.getCanonicalName()))
        {
            cn.jpush.android.util.x.e(z[39], (new StringBuilder(z[112])).append(cn/jpush/android/service/PushService.getCanonicalName()).toString());
            flag = false;
        } else
        if (!b(context, z[125], false))
        {
            cn.jpush.android.util.x.e(z[39], z[121]);
            flag = false;
        } else
        {
label0:
            {
                if (b(context, z[123], false))
                {
                    break label0;
                }
                cn.jpush.android.util.x.e(z[39], z[118]);
                flag = false;
            }
        }
_L3:
        Object obj;
        Object obj1;
        if (!ai.a(cn.jpush.android.a.f))
        {
            flag1 = true;
        } else
        {
            cn.jpush.android.util.x.d(z[39], z[111]);
            flag1 = false;
        }
        if (!cn.jpush.android.a.i && !D(context))
        {
            cn.jpush.android.util.x.d(z[39], z[122]);
        }
        return flag1 && flag;
        l(context, cn/jpush/android/service/DownloadService.getCanonicalName());
        if (d(context, cn/jpush/android/service/PushReceiver.getCanonicalName())) goto _L2; else goto _L1
_L1:
        cn.jpush.android.util.x.e(z[39], (new StringBuilder(z[116])).append(cn/jpush/android/service/PushReceiver.getCanonicalName()).toString());
        E(context);
_L4:
        flag = true;
          goto _L3
_L2:
        if (d(context, cn/jpush/android/service/PushReceiver.getCanonicalName(), z[117]))
        {
            cn.jpush.android.util.x.d(z[39], z[126]);
        }
        if (!a(context, z[64], true))
        {
            cn.jpush.android.util.x.e(z[39], z[119]);
            flag = false;
        } else
        if (!d(context, cn/jpush/android/service/AlarmReceiver.getCanonicalName()))
        {
            cn.jpush.android.util.x.e(z[39], (new StringBuilder(z[116])).append(cn/jpush/android/service/AlarmReceiver.getCanonicalName()).toString());
            flag = false;
        } else
        {
            m(context, cn/jpush/android/ui/PushActivity.getCanonicalName());
            obj1 = z[72];
            obj = context.getPackageManager();
            obj1 = new Intent(((String) (obj1)));
            ((Intent) (obj1)).addCategory(context.getPackageName());
            if (!((PackageManager) (obj)).queryIntentActivities(((Intent) (obj1)), 0).isEmpty());
            obj = (new StringBuilder()).append(context.getPackageName()).append(z[127]).toString();
            if (!k(context, ((String) (obj))))
            {
                cn.jpush.android.util.x.e(z[39], (new StringBuilder(z[128])).append(((String) (obj))).toString());
                flag = false;
            } else
            {
label1:
                {
                    g.add(obj);
                    obj = g.iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label1;
                        }
                        obj1 = (String)((Iterator) (obj)).next();
                    } while (c(context.getApplicationContext(), ((String) (obj1))));
                    cn.jpush.android.util.x.e(z[39], (new StringBuilder(z[113])).append(((String) (obj1))).toString());
                    flag = false;
                }
            }
        }
          goto _L3
label2:
        {
            if (!i(context) || c(context.getApplicationContext(), z[35]))
            {
                break label2;
            }
            cn.jpush.android.util.x.e(z[39], z[114]);
            flag = false;
        }
          goto _L3
        obj = h.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj1 = (String)((Iterator) (obj)).next();
            if (!c(context.getApplicationContext(), ((String) (obj1))))
            {
                cn.jpush.android.util.x.d(z[39], (new StringBuilder(z[120])).append(((String) (obj1))).toString());
            }
        } while (true);
        obj = i.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            obj1 = (String)((Iterator) (obj)).next();
            if (!c(context.getApplicationContext(), ((String) (obj1))))
            {
                cn.jpush.android.util.x.d(z[39], (new StringBuilder(z[120])).append(((String) (obj1))).append(z[124]).toString());
            }
        }
          goto _L4
    }

    public static void r(Context context)
    {
        if (j == null || d(context, cn/jpush/android/service/PushReceiver.getCanonicalName()))
        {
            break MISSING_BLOCK_LABEL_26;
        }
        context.unregisterReceiver(j);
        return;
        context;
        context.getMessage();
        cn.jpush.android.util.x.f();
        return;
    }

    public static long s(Context context)
    {
        return PushService.a(context);
    }

    public static String t(Context context)
    {
        return PushService.b(context);
    }

    public static String u(Context context)
    {
        return ae.a(context, z[98], "");
    }

    public static String v(Context context)
    {
        String s1 = cn.jpush.android.a.f;
        Object obj = s1;
        if (!ai.a(s1))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = context.getPackageManager();
        try
        {
            context = ((PackageManager) (obj)).getApplicationInfo(context.getPackageName(), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s1;
        }
        obj = s1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = s1;
        if (((ApplicationInfo) (context)).metaData != null)
        {
            obj = ((ApplicationInfo) (context)).metaData.getString(z[60]);
        }
        return ((String) (obj));
    }

    public static String w(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService(z[6])).getActiveNetworkInfo();
        if (context == null)
        {
            return z[33];
        }
        if (context.getType() == 1)
        {
            return z[32];
        }
        if (context.getType() == 0)
        {
            int i1 = context.getSubtype();
            if (i1 == 4 || i1 == 1 || i1 == 2)
            {
                return z[34];
            }
            if (i1 == 3 || i1 == 8 || i1 == 6 || i1 == 5 || i1 == 12)
            {
                return z[31];
            }
            if (i1 == 13)
            {
                return z[30];
            }
        }
        return "";
    }

    private static String x(Context context)
    {
        if (!c(context, z[71]))
        {
            return null;
        }
        try
        {
            context = ((WifiManager)context.getSystemService(z[32])).getConnectionInfo().getMacAddress();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cn.jpush.android.util.x.j();
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (context.equals(""))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        (new StringBuilder(z[105])).append(context).toString();
        cn.jpush.android.util.x.d();
        context = a((new StringBuilder()).append(context).append(Build.MODEL).toString());
        return context;
        return null;
    }

    private static String y(Context context)
    {
        Object obj = i(context, "");
        if (d(((String) (obj))))
        {
            return ((String) (obj));
        }
        String s1;
        s1 = k(context);
        if (ai.a(s1) || !d(s1))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = s1;
        if (!z[61].equals(s1.toLowerCase(Locale.getDefault())))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s1 = x(context);
        if (ai.a(s1))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = s1;
        if (d(s1))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s1 = z(context);
        obj = s1;
        if (s1 == null)
        {
            return " ";
        }
        break MISSING_BLOCK_LABEL_102;
        obj;
        cn.jpush.android.util.x.j();
        obj = z(context);
        return ((String) (obj));
    }

    private static String z(Context context)
    {
        Object obj;
        cn.jpush.android.util.x.c();
        obj = context.getSharedPreferences(z[53], 0).getString(z[55], null);
        if (ai.a(((String) (obj)))) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        if (a())
        {
            break; /* Loop/switch isn't completed */
        }
        SharedPreferences sharedpreferences = context.getSharedPreferences(z[53], 0);
        context = sharedpreferences.getString(z[55], null);
        obj = context;
        if (context == null)
        {
            context = UUID.randomUUID().toString();
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString(z[55], context);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return context;
        }
        if (true) goto _L1; else goto _L3
_L3:
        String s1 = ae.a(context, z[54], null);
        obj = s1;
        if (s1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new File(e);
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_213;
        }
        Object obj1;
        obj1 = cn.jpush.android.util.m.a(new FileInputStream(((File) (obj))));
        if (((ArrayList) (obj1)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj1 = (String)((ArrayList) (obj1)).get(0);
        ae.b(context, z[54], ((String) (obj1)));
        (new StringBuilder(z[52])).append(((String) (obj1))).toString();
        cn.jpush.android.util.x.d();
        return ((String) (obj1));
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        String s2;
        s2 = ai.b(UUID.nameUUIDFromBytes((new StringBuilder()).append(System.currentTimeMillis()).toString().getBytes()).toString());
        ae.b(context, z[54], s2);
        try
        {
            ((File) (obj)).createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            cn.jpush.android.util.x.j();
            return s2;
        }
        filenotfoundexception = new FileOutputStream(((File) (obj)));
        context = filenotfoundexception;
        filenotfoundexception.write(s2.getBytes());
        context = filenotfoundexception;
        filenotfoundexception.flush();
        context = filenotfoundexception;
        cn.jpush.android.util.x.d();
        obj = s2;
        if (filenotfoundexception != null)
        {
            try
            {
                filenotfoundexception.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return s2;
            }
            return s2;
        }
        if (true) goto _L1; else goto _L4
_L4:
        context;
        filenotfoundexception = null;
_L8:
        context = filenotfoundexception;
        cn.jpush.android.util.x.j();
        obj = s2;
        if (filenotfoundexception == null) goto _L1; else goto _L5
_L5:
        try
        {
            filenotfoundexception.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s2;
        }
        return s2;
        Exception exception;
        exception;
        context = null;
_L7:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw exception;
        exception;
        if (true) goto _L7; else goto _L6
_L6:
        context;
          goto _L8
    }

    private static String z(char ac[])
    {
        char ac1[];
        int i1;
        int j1;
        int l1;
        l1 = ac.length;
        j1 = 0;
        i1 = 0;
        ac1 = ac;
        if (l1 > 1) goto _L2; else goto _L1
_L1:
        int k1;
        k1 = i1;
        ac1 = ac;
        j1 = i1;
_L9:
        char c1 = ac1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 64
    //                   0 96
    //                   1 102
    //                   2 108
    //                   3 114;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_114;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        i1 = 57;
_L10:
        ac1[j1] = (char)(i1 ^ c1);
        j1 = k1 + 1;
        if (l1 != 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        ac1 = ac;
        k1 = j1;
        j1 = l1;
        if (true) goto _L9; else goto _L8
_L8:
        i1 = 40;
          goto _L10
_L5:
        i1 = 14;
          goto _L10
_L6:
        i1 = 92;
          goto _L10
        i1 = 117;
          goto _L10
        ac1 = ac;
_L2:
        i1 = j1;
        ac = ac1;
        if (l1 <= j1)
        {
            return (new String(ac1)).intern();
        }
        if (true) goto _L1; else goto _L11
_L11:
    }

    private static char[] z(String s1)
    {
        s1 = s1.toCharArray();
        char ac[] = s1;
        do
        {
            int i1 = s1.length;
            if (i1 >= 2)
            {
                break;
            }
            if (i1 == 0)
            {
                continue;
            }
            ac[0] = (char)(ac[0] ^ 0x39);
            break;
        } while (true);
        return ac;
    }

    static 
    {
        String s1;
        Object obj;
        char c1;
        String as[] = new String[130];
        int i1 = 0;
        s1 = "^k.*ZGj9";
        c1 = '\uFFFF';
label0:
        do
        {
            String as1[] = as;
            s1 = z(z(s1));
            switch (c1)
            {
            default:
                as1[i1] = s1;
                s1 = "Fo1\020";
                i1 = 1;
                c1 = '\0';
                break;

            case 0: // '\0'
                as1[i1] = s1;
                s1 = "Xe;";
                i1 = 2;
                c1 = '\001';
                break;

            case 1: // '\001'
                as1[i1] = s1;
                i1 = 3;
                s1 = "^k.*WIc9";
                c1 = '\002';
                break;

            case 2: // '\002'
                as1[i1] = s1;
                i1 = 4;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \0214pf";
                c1 = '\003';
                break;

            case 3: // '\003'
                as1[i1] = s1;
                i1 = 5;
                s1 = "I`8\007VAjr\034W\\k2\001\027Ko(\020^G|%[ui[\0226qm\\";
                c1 = '\004';
                break;

            case 4: // '\004'
                as1[i1] = s1;
                i1 = 6;
                s1 = "Ka2\033\\Kz5\003P\\w";
                c1 = '\005';
                break;

            case 5: // '\005'
                as1[i1] = s1;
                s1 = "I`8\007VAjr\005\\Zc5\006JAa2[nzG\b0fmV\b0kfO\020*j|A\0164~m";
                c1 = '\006';
                i1 = 7;
                break;

            case 6: // '\006'
                as1[i1] = s1;
                i1 = 8;
                s1 = "Mc,\001@\b~=\007XE}";
                c1 = '\007';
                break;

            case 7: // '\007'
                as1[i1] = s1;
                i1 = 9;
                s1 = "oa(UJLm=\007]\bh5\031\\\b}=\003\\L.8\020OAm9<]\b#|";
                c1 = '\b';
                break;

            case 8: // '\b'
                as1[i1] = s1;
                i1 = 10;
                s1 = "Kf=\033WMb";
                c1 = '\t';
                break;

            case 9: // '\t'
                as1[i1] = s1;
                i1 = 11;
                s1 = "Lk*\034ZM";
                c1 = '\n';
                break;

            case 10: // '\n'
                as1[i1] = s1;
                i1 = 12;
                s1 = "I`8\007VAj\017\021R~k.\006PG`";
                c1 = '\013';
                break;

            case 11: // '\013'
                as1[i1] = s1;
                i1 = 13;
                s1 = "Ea8\020U";
                c1 = '\f';
                break;

            case 12: // '\f'
                as1[i1] = s1;
                i1 = 14;
                s1 = "Jo/\020[I`8";
                c1 = '\r';
                break;

            case 13: // '\r'
                as1[i1] = s1;
                i1 = 15;
                s1 = "Fk(\002VZe";
                c1 = '\016';
                break;

            case 14: // '\016'
                as1[i1] = s1;
                i1 = 16;
                s1 = "]|0";
                c1 = '\017';
                break;

            case 15: // '\017'
                as1[i1] = s1;
                i1 = 17;
                s1 = "O}1[OM|/\034VF >\024JMl=\033]";
                c1 = '\020';
                break;

            case 16: // '\020'
                as1[i1] = s1;
                i1 = 18;
                s1 = "Xf3\033\\";
                c1 = '\021';
                break;

            case 17: // '\021'
                as1[i1] = s1;
                i1 = 19;
                s1 = "I`8\007VAjr\005\\Zc5\006JAa2[kmO\030*i`A\0220f{Z\035!|";
                c1 = '\022';
                break;

            case 18: // '\022'
                as1[i1] = s1;
                i1 = 20;
                s1 = "Kb3\006\\X{/\035";
                c1 = '\023';
                break;

            case 19: // '\023'
                as1[i1] = s1;
                i1 = 21;
                s1 = "X{/\035\031\\g1\020\031A}|\uFF6F";
                c1 = '\024';
                break;

            case 20: // '\024'
                as1[i1] = s1;
                i1 = 22;
                s1 = "tP";
                c1 = '\025';
                break;

            case 21: // '\025'
                as1[i1] = s1;
                i1 = 23;
                s1 = "X{/\035MAc9";
                c1 = '\026';
                break;

            case 22: // '\026'
                as1[i1] = s1;
                i1 = 24;
                s1 = "og*\020\031]~|\001V\b}(\024K\\.=\005I\bh3\007\031A`*\024UAj|\005XZo1\006\031\005.,\024ZCo;\020wIc9O";
                c1 = '\027';
                break;

            case 23: // '\027'
                as1[i1] = s1;
                i1 = 25;
                s1 = "f[\0209\031Ka2\001\\Pz";
                c1 = '\030';
                break;

            case 24: // '\030'
                as1[i1] = s1;
                i1 = 26;
                s1 = "zk0\020X[k|\002XCk|\031VKe|\024_\\k.U\f\030>l\030J\022";
                c1 = '\031';
                break;

            case 25: // '\031'
                as1[i1] = s1;
                i1 = 27;
                s1 = "eJi";
                c1 = '\032';
                break;

            case 26: // '\032'
                as1[i1] = s1;
                i1 = 28;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \n<|\177";
                c1 = '\033';
                break;

            case 27: // '\033'
                as1[i1] = s1;
                i1 = 29;
                s1 = "I~,\031PKo(\034VF!*\033]\006o2\021KGg8[IIm7\024^M#=\007Z@g*\020";
                c1 = '\034';
                break;

            case 28: // '\034'
                as1[i1] = s1;
                i1 = 30;
                s1 = "\034i";
                c1 = '\035';
                break;

            case 29: // '\035'
                as1[i1] = s1;
                i1 = 31;
                s1 = "\033i";
                c1 = '\036';
                break;

            case 30: // '\036'
                as1[i1] = s1;
                i1 = 32;
                s1 = "_g:\034";
                c1 = '\037';
                break;

            case 31: // '\037'
                as1[i1] = s1;
                i1 = 33;
                s1 = "F{0\031";
                c1 = ' ';
                break;

            case 32: // ' '
                as1[i1] = s1;
                i1 = 34;
                s1 = "\032i";
                c1 = '!';
                break;

            case 33: // '!'
                as1[i1] = s1;
                i1 = 35;
                s1 = "I`8\007VAjr\005\\Zc5\006JAa2[nzG\b0f{K\b!pfI\017";
                c1 = '"';
                break;

            case 34: // '"'
                as1[i1] = s1;
                i1 = 36;
                s1 = "b^)\006QwJ9\003PKk\025\021";
                c1 = '#';
                break;

            case 35: // '#'
                as1[i1] = s1;
                i1 = 37;
                s1 = "K`r\037I]}4[XFj.\032PL \031-mzO";
                c1 = '$';
                break;

            case 36: // '$'
                as1[i1] = s1;
                i1 = 38;
                s1 = "ko2UWGz|\022\\\\.,\024ZCo;\020\031Fo1\020\027";
                c1 = '%';
                break;

            case 37: // '%'
                as1[i1] = s1;
                i1 = 39;
                s1 = "i`8\007VAj\t\001PD";
                c1 = '&';
                break;

            case 38: // '&'
                as1[i1] = s1;
                i1 = 40;
                s1 = "\r}r\005\\Zc5\006JAa2[sx[\017=feK\017&xoK";
                c1 = '\'';
                break;

            case 39: // '\''
                as1[i1] = s1;
                i1 = 41;
                s1 = "Xb)\022^Mj";
                c1 = '(';
                break;

            case 40: // '('
                as1[i1] = s1;
                i1 = 42;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \0364m|K\016,fkF\035;~mJ";
                c1 = ')';
                break;

            case 41: // ')'
                as1[i1] = s1;
                i1 = 43;
                s1 = "[z=\001L[";
                c1 = '*';
                break;

            case 42: // '*'
                as1[i1] = s1;
                i1 = 44;
                s1 = "Lk>\000^w`3\001PNg?\024MAa2";
                c1 = '+';
                break;

            case 43: // '+'
                as1[i1] = s1;
                i1 = 45;
                s1 = "b^)\006Q\u63F8\u7934\uFF46\u7F4F\u5C28\u7EF7\u8BAF\u4EBF\u7874";
                c1 = ',';
                break;

            case 44: // ','
                as1[i1] = s1;
                i1 = 46;
                s1 = "\\w,\020";
                c1 = '-';
                break;

            case 45: // '-'
                as1[i1] = s1;
                i1 = 47;
                s1 = "Fa(\034_Am=\001PG`";
                c1 = '.';
                break;

            case 46: // '.'
                as1[i1] = s1;
                i1 = 48;
                s1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([wgZ\0253pkO\b<vfQ\023%|fK\030*izA\004,";
                c1 = '/';
                break;

            case 47: // '/'
                as1[i1] = s1;
                i1 = 49;
                s1 = "\u68E8\u6D45\u526C\u96B3\u6229\b]\030>\031\u6702\u6DF5\u52FC\u7EAA\u8B98\u4ECB\u780F\u305E\u70CC\u51C2\u67CD\u7705\u8BBA\u60B0";
                c1 = '0';
                break;

            case 48: // '0'
                as1[i1] = s1;
                i1 = 50;
                s1 = "Im(\034OAz%";
                c1 = '1';
                break;

            case 49: // '1'
                as1[i1] = s1;
                i1 = 51;
                s1 = "aC\031<";
                c1 = '2';
                break;

            case 50: // '2'
                as1[i1] = s1;
                i1 = 52;
                s1 = "oa(UJLm=\007]\bh5\031\\\b}=\003\\L.)\021PL.qU";
                c1 = '3';
                break;

            case 51: // '3'
                as1[i1] = s1;
                i1 = 53;
                s1 = "x|9\023Jng0\020";
                c1 = '4';
                break;

            case 52: // '4'
                as1[i1] = s1;
                i1 = 54;
                s1 = "X{/\035f]j5\021";
                c1 = '5';
                break;

            case 53: // '5'
                as1[i1] = s1;
                i1 = 55;
                s1 = "Ck%";
                c1 = '6';
                break;

            case 54: // '6'
                as1[i1] = s1;
                i1 = 56;
                s1 = "Xa+\020K";
                c1 = '7';
                break;

            case 55: // '7'
                as1[i1] = s1;
                i1 = 57;
                s1 = "x{/\035";
                c1 = '8';
                break;

            case 56: // '8'
                as1[i1] = s1;
                i1 = 58;
                s1 = "Lo(\024";
                c1 = '9';
                break;

            case 57: // '9'
                as1[i1] = s1;
                i1 = 59;
                s1 = "Az5\030\\";
                c1 = ':';
                break;

            case 58: // ':'
                as1[i1] = s1;
                i1 = 60;
                s1 = "b^\t&qwO\f%rmW";
                c1 = ';';
                break;

            case 59: // ';'
                as1[i1] = s1;
                i1 = 61;
                s1 = "\0219kA]\03588C\001\032kiA\000K";
                c1 = '<';
                break;

            case 60: // '<'
                as1[i1] = s1;
                i1 = 62;
                s1 = "p iE\0";
                c1 = '=';
                break;

            case 61: // '='
                as1[i1] = s1;
                i1 = 63;
                s1 = "ok2\020KIz9U}Mx5\026\\aj|\006LKm9\006J\b";
                c1 = '>';
                break;

            case 62: // '>'
                as1[i1] = s1;
                i1 = 64;
                s1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([wgZ\0253pkO\b<vfQ\0160zmG\n0}w^\016:aq";
                c1 = '?';
                break;

            case 63: // '?'
                as1[i1] = s1;
                i1 = 65;
                s1 = "I`8\007VAjr\033\\\\ ?\032WF \037:wfK\037!p~G\b,fkF\035;~m";
                c1 = '@';
                break;

            case 64: // '@'
                as1[i1] = s1;
                i1 = 66;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \f4zcO\0330fzK\021:omJ";
                c1 = 'A';
                break;

            case 65: // 'A'
                as1[i1] = s1;
                i1 = 67;
                s1 = "Xo?\036XOk";
                c1 = 'B';
                break;

            case 66: // 'B'
                as1[i1] = s1;
                i1 = 68;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \t&|zQ\f'|{K\022!";
                c1 = 'C';
                break;

            case 67: // 'C'
                as1[i1] = s1;
                i1 = 69;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \f4zcO\0330fiJ\0300}";
                c1 = 'D';
                break;

            case 68: // 'D'
                as1[i1] = s1;
                i1 = 70;
                s1 = "eo5\033\031Kb=\006J\bg/U";
                c1 = 'E';
                break;

            case 69: // 'E'
                as1[i1] = s1;
                i1 = 71;
                s1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwY\0253pw]\b4mm";
                c1 = 'F';
                break;

            case 70: // 'F'
                as1[i1] = s1;
                i1 = 72;
                s1 = "K`r\037I]}4[XFj.\032PL )\034\027x{/\035xKz5\003P\\w";
                c1 = 'G';
                break;

            case 71: // 'G'
                as1[i1] = s1;
                i1 = 73;
                s1 = "Ja8\f";
                c1 = 'H';
                break;

            case 72: // 'H'
                as1[i1] = s1;
                i1 = 74;
                s1 = "A}\t\005]Iz9#\\Z}5\032W";
                c1 = 'I';
                break;

            case 73: // 'I'
                as1[i1] = s1;
                i1 = 75;
                s1 = "K`r\037I]}4[XFj.\032PL \035%icK\005";
                c1 = 'J';
                break;

            case 74: // 'J'
                as1[i1] = s1;
                i1 = 76;
                s1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([tm]\0174~mQ\0160zmG\n0}";
                c1 = 'K';
                break;

            case 75: // 'K'
                as1[i1] = s1;
                i1 = 77;
                s1 = "K`r\037I]}4[XFj.\032PL \0210j{O\0330";
                c1 = 'L';
                break;

            case 76: // 'L'
                as1[i1] = s1;
                i1 = 78;
                s1 = "{k2\021\031J|3\024]Ko/\001\031\\a|\024IX4|";
                c1 = 'M';
                break;

            case 77: // 'M'
                as1[i1] = s1;
                i1 = 79;
                s1 = "K`r\037I]}4[XFj.\032PL \021&~wG\030";
                c1 = 'N';
                break;

            case 78: // 'N'
                as1[i1] = s1;
                i1 = 80;
                s1 = "K`r\037I]}4[XFj.\032PL \037:w|K\022!f|W\f0";
                c1 = 'O';
                break;

            case 79: // 'O'
                as1[i1] = s1;
                i1 = 81;
                s1 = "K`r\037I]}4[XFj.\032PL \032<umQ\f4m`";
                c1 = 'P';
                break;

            case 80: // 'P'
                as1[i1] = s1;
                i1 = 82;
                s1 = "K`r\037I]}4[XFj.\032PL \b<mdK";
                c1 = 'Q';
                break;

            case 81: // 'Q'
                as1[i1] = s1;
                i1 = 83;
                s1 = "}`7\033V_`";
                c1 = 'R';
                break;

            case 82: // 'R'
                as1[i1] = s1;
                i1 = 84;
                s1 = "]z:X\001";
                c1 = 'S';
                break;

            case 83: // 'S'
                as1[i1] = s1;
                i1 = 85;
                s1 = "Ea)\033MMj";
                c1 = 'T';
                break;

            case 84: // 'T'
                as1[i1] = s1;
                i1 = 86;
                s1 = "I`8\007VAj\003\034]";
                c1 = 'U';
                break;

            case 85: // 'U'
                as1[i1] = s1;
                i1 = 87;
                s1 = "\007~.\032Z\007m,\000PFh3";
                c1 = 'V';
                break;

            case 86: // 'V'
                as1[i1] = s1;
                i1 = 88;
                s1 = "x|3\026\\[}3\007";
                c1 = 'W';
                break;

            case 87: // 'W'
                as1[i1] = s1;
                i1 = 89;
                s1 = "\\a=\006M|k$\001";
                c1 = 'X';
                break;

            case 88: // 'X'
                as1[i1] = s1;
                i1 = 90;
                s1 = "b^)\006Q\u63F8\u7934\uFF46\u5370\u5434\u54A4O,\005rMw\u4E51\u534C\u9174";
                c1 = 'Y';
                break;

            case 89: // 'Y'
                as1[i1] = s1;
                i1 = 91;
                s1 = "\u8BDF\u523E|%VZz=\031\031\u4E22\u83B9\u538A\u60DD\u76BD\u532D\u5403\u54D04IXE9\f\u5E4F\u66DC\u65BE\035\033]Za5\021tI`5\023\\[z\u76A4\u5EE1\u5B6E\u6B9D";
                c1 = 'Z';
                break;

            case 90: // 'Z'
                as1[i1] = s1;
                i1 = 92;
                s1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027a@\b0w|";
                c1 = '[';
                break;

            case 91: // '['
                as1[i1] = s1;
                i1 = 93;
                s1 = "Ka1[XFj.\032PL 0\024LFm4\020K\006o?\001PG`r<w{Z\0359uw]\024:k|M\t!";
                c1 = '\\';
                break;

            case 92: // '\\'
                as1[i1] = s1;
                i1 = 94;
                s1 = "}`9\rIMm(\020]\022.5\033OIb5\021\031]|0U\024\b";
                c1 = ']';
                break;

            case 93: // ']'
                as1[i1] = s1;
                i1 = 95;
                s1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027aM\023;fzK\017:lzM\031";
                c1 = '^';
                break;

            case 94: // '^'
                as1[i1] = s1;
                i1 = 96;
                s1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027fO\0210";
                c1 = '_';
                break;

            case 95: // '_'
                as1[i1] = s1;
                i1 = 97;
                s1 = "L{,\031PKo(\020";
                c1 = '`';
                break;

            case 96: // '`'
                as1[i1] = s1;
                i1 = 98;
                s1 = "Zk;\034J\\|=\001PG`\003\034]";
                c1 = 'a';
                break;

            case 97: // 'a'
                as1[i1] = s1;
                i1 = 99;
                s1 = "\030$l";
                c1 = 'b';
                break;

            case 98: // 'b'
                as1[i1] = s1;
                i1 = 100;
                s1 = "\f*";
                c1 = 'c';
                break;

            case 99: // 'c'
                as1[i1] = s1;
                i1 = 101;
                s1 = "k{.\007\\Fz|\005R\bg2\006MIb0\020]\b~=\001Q\022.";
                c1 = 'd';
                break;

            case 100: // 'd'
                as1[i1] = s1;
                i1 = 102;
                s1 = "\007}%\006MMcs\024IX!";
                c1 = 'e';
                break;

            case 101: // 'e'
                as1[i1] = s1;
                i1 = 103;
                s1 = "\007j=\001X\007o,\005\026";
                c1 = 'f';
                break;

            case 102: // 'f'
                as1[i1] = s1;
                i1 = 104;
                s1 = "Ac9\034";
                c1 = 'g';
                break;

            case 103: // 'g'
                as1[i1] = s1;
                i1 = 105;
                s1 = "eO\037UXLj.UPFh3X\024\005#|";
                c1 = 'h';
                break;

            case 104: // 'h'
                as1[i1] = s1;
                i1 = 106;
                s1 = "[z=\007Meg2\006";
                c1 = 'i';
                break;

            case 105: // 'i'
                as1[i1] = s1;
                i1 = 107;
                s1 = "M`8\001tA`/";
                c1 = 'j';
                break;

            case 106: // 'j'
                as1[i1] = s1;
                i1 = 108;
                s1 = "M`8=V]|";
                c1 = 'k';
                break;

            case 107: // 'k'
                as1[i1] = s1;
                i1 = 109;
                s1 = "[z=\007M`a)\007";
                c1 = 'l';
                break;

            case 108: // 'l'
                as1[i1] = s1;
                i1 = 110;
                s1 = "[g0\020WKk\f\000J@Z5\030\\";
                c1 = 'm';
                break;

            case 109: // 'm'
                as1[i1] = s1;
                i1 = 111;
                s1 = "lk*\020UG~9\007\031[f3\000UL./\020M\bO,\005rMw|\034W\bO2\021KGg88XFg:\020J\\ $\030U";
                c1 = 'n';
                break;

            case 110: // 'n'
                as1[i1] = s1;
                i1 = 112;
                s1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L./\020K^g?\020\003\b";
                c1 = 'o';
                break;

            case 111: // 'o'
                as1[i1] = s1;
                i1 = 113;
                s1 = "|f9UIM|1\034J[a5\033\031A}|\007\\Y{5\007\\L.qU";
                c1 = 'p';
                break;

            case 112: // 'p'
                as1[i1] = s1;
                i1 = 114;
                s1 = "|f9UIM|1\034J[a5\033\031A}|\007\\Y{5\007\\L.qUXFj.\032PL ,\020KEg/\006PG`r\"kaZ\031*jmZ\b<wo]";
                c1 = 'q';
                break;

            case 113: // 'q'
                as1[i1] = s1;
                i1 = 115;
                s1 = "Im(\034VF4?\035\\Ke\n\024UAj\021\024WAh9\006M";
                c1 = 'r';
                break;

            case 114: // 'r'
                as1[i1] = s1;
                i1 = 116;
                s1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L..\020ZMg*\020K\022.";
                c1 = 's';
                break;

            case 115: // 's'
                as1[i1] = s1;
                i1 = 117;
                s1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \036:v|Q\037:txB\031!|l";
                c1 = 't';
                break;

            case 116: // 't'
                as1[i1] = s1;
                i1 = 118;
                s1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L.5\033MM`(U_Ab(\020K\b4|\026W\006d,\000J@ =\033]Za5\021\027A`(\020W\\ \0160ig\\\b";
                c1 = 'u';
                break;

            case 117: // 'u'
                as1[i1] = s1;
                i1 = 119;
                s1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L.5\033MM`(U_Ab(\020K\bh3\007\031x{/\035kMm9\034OM|fUZF 6\005L[fr\024WL|3\034]\006g2\001\\Fzr;v|G\032<ziZ\025:ww\\\0316|aX\0311fx\\\023-`";
                c1 = 'v';
                break;

            case 118: // 'v'
                as1[i1] = s1;
                i1 = 120;
                s1 = "\177k|\007\\Ka1\030\\Fj|\fV].=\021]\bz4\020\031Xk.\030P[}5\032W\b#|";
                c1 = 'w';
                break;

            case 119: // 'w'
                as1[i1] = s1;
                i1 = 121;
                s1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L.5\033MM`(U_Ab(\020K\bh3\007\031x{/\035jM|*\034ZM4|\026W\006d,\000J@ =\033]Za5\021\027A`(\020W\\ \0160~a]\b0k";
                c1 = 'x';
                break;

            case 120: // 'x'
                as1[i1] = s1;
                i1 = 122;
                s1 = "qa)UJ@a)\031]\bc=\036\\\bc=\034W\bo?\001P^g(\f\031Mv(\020WL}|<W[z.\000TM`(\020]im(\034OAz%U\021b^)\006Q\001\"|\032M@k.\002P[k|\fV].+\034UD.2\032M\b}9\020\031]}9\007\031Kb5\026R\bo2\021\031]}9\007\031Im(\034OM.(\034TM./\001XZz|\032W\b|9\005VZz|\034W\b^3\007MIbrU";
                c1 = 'y';
                break;

            case 121: // 'y'
                as1[i1] = s1;
                i1 = 123;
                s1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([km^\023'm";
                c1 = 'z';
                break;

            case 122: // 'z'
                as1[i1] = s1;
                i1 = 124;
                s1 = "\004.3\001QM|+\034JM.%\032L\bm=\033\031Fa(UUGm=\001\\\bz4\020\031Lk*\034ZM}r";
                c1 = '{';
                break;

            case 123: // '{'
                as1[i1] = s1;
                i1 = 125;
                s1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([kmI\025&mm\\";
                c1 = '|';
                break;

            case 124: // '|'
                as1[i1] = s1;
                i1 = 126;
                s1 = "x{/\035kMm9\034OM||\006QG{0\021\031Fa(UQIx9UPFz9\033M\bh5\031MM||X\024\bo2\021KGg8[PFz9\033M\006o?\001PG`r7vgZ\0036ve^\0200mmJpUiDk=\006\\\b|9\030V^k|\001QM.5\033MM`(U_Ab(\020K\bg2UxFj.\032PLC=\033PNk/\001\027Pc0";
                c1 = '}';
                break;

            case 125: // '}'
                as1[i1] = s1;
                i1 = 127;
                s1 = "\006~9\007TA}/\034VF \026%l{F\0038|{]\0352|";
                c1 = '~';
                break;

            case 126: // '~'
                as1[i1] = s1;
                i1 = 128;
                s1 = "|f9UIM|1\034J[g3\033\031[f3\000UL.>\020\031Lk:\034WMj|X\031";
                c1 = '\177';
                break;

            case 127: // '\177'
                as1[i1] = s1;
                i1 = 129;
                s1 = "k@a4WL|3\034]\bJ9\027LO\"\023HxFj.\032PL\"\037Hl{";
                c1 = '\200';
                break;

            case 128: 
                as1[i1] = s1;
                break label0;
            }
        } while (true);
        z = as;
        obj = new ArrayList();
        b = ((List) (obj));
        s1 = "\033;dC\016\033>mF\016\021;dL\f";
        c1 = '\uFFFF';
_L19:
        s1 = z(z(s1));
        c1;
        JVM INSTR tableswitch 0 7: default 2972
    //                   0 3263
    //                   1 3282
    //                   2 3314
    //                   3 3333
    //                   4 3352
    //                   5 3379
    //                   6 3399
    //                   7 3419;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        ((List) (obj)).add(s1);
        obj = b;
        s1 = "\030>hL\000\021>mE\017\034>lE\t";
        c1 = '\uFFFF';
_L13:
        s1 = z(z(s1));
        c1;
        JVM INSTR tableswitch 0 1: default 3020
    //                   0 3157
    //                   1 3041;
           goto _L10 _L11 _L12
_L10:
        ((List) (obj)).add(s1);
        obj = b;
        s1 = "\030>lE\t\030>lE\t\030>lE";
        c1 = '\0';
          goto _L13
_L12:
        ((List) (obj)).add(s1);
        c = new X500Principal(z[129]);
        obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath());
        s1 = "\007j=\001X\007";
        c1 = '\uFFFF';
_L18:
        s1 = z(z(s1));
        c1;
        JVM INSTR tableswitch 0 1: default 3120
    //                   0 3178
    //                   1 3215;
           goto _L14 _L15 _L16
_L14:
        d = ((StringBuilder) (obj)).append(s1).toString();
        obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath());
        s1 = "\007j=\001X\007 ,\000J@Q)\021PL";
        c1 = '\0';
        if (true) goto _L18; else goto _L17
_L17:
_L11:
        ((List) (obj)).add(s1);
        obj = b;
        s1 = "\030>lE\t\030>lE\t\030>lE\t";
        c1 = '\001';
          goto _L13
_L15:
        e = ((StringBuilder) (obj)).append(s1).toString();
        obj = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath());
        s1 = "\007j=\001X\007 ,\000J@Q8\020OAm9\034]";
        c1 = '\001';
          goto _L18
_L16:
        f = ((StringBuilder) (obj)).append(s1).toString();
        a = 1;
        g = new ArrayList();
        h = new ArrayList();
        obj = g;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[pfZ\031'wmZ";
        c1 = '\0';
          goto _L19
_L2:
        ((ArrayList) (obj)).add(s1);
        obj = g;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[niE\031*ugM\027";
        c1 = '\001';
          goto _L19
_L3:
        ((ArrayList) (obj)).add(s1);
        g.add(z[7]);
        obj = g;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jw@\031!ng\\\027*j|O\b0";
        c1 = '\002';
          goto _L19
_L4:
        ((ArrayList) (obj)).add(s1);
        obj = h;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[oaL\0164mm";
        c1 = '\003';
          goto _L19
_L5:
        ((ArrayList) (obj)).add(s1);
        obj = h;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[z`O\0222|wY\0253pw]\b4mm";
        c1 = '\004';
          goto _L19
_L6:
        ((ArrayList) (obj)).add(s1);
        obj = new ArrayList();
        i = ((ArrayList) (obj));
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwH\025;|wB\0236x|G\023;";
        c1 = '\005';
          goto _L19
_L7:
        ((ArrayList) (obj)).add(s1);
        obj = i;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwM\0234k{K\0039vkO\b<vf";
        c1 = '\006';
          goto _L19
_L8:
        ((ArrayList) (obj)).add(s1);
        obj = i;
        s1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwB\0236x|G\023;fmV\b'xwM\0238ti@\030&";
        c1 = '\007';
          goto _L19
_L9:
        ((ArrayList) (obj)).add(s1);
        i.add(z[71]);
    }
}
