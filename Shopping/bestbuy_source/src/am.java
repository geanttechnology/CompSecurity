// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

class am
{

    private static final String a = am.getSimpleName();
    private static final Map o;
    private final String b;
    private final int c;
    private final String d;
    private final String e;
    private final Long f;
    private final String g = c();
    private final String h = d();
    private final Integer i = Integer.valueOf(e());
    private final String j;
    private final Context k;
    private String l;
    private String m;
    private boolean n;

    am(Context context, String s, String s1)
    {
        m = s;
        b = a(context);
        d = Build.MANUFACTURER;
        e = Build.MODEL;
        s = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long l1 = s.getBlockCount();
        f = Long.valueOf(((long)s.getBlockSize() * l1) / 0x100000L);
        j = android.os.Build.VERSION.RELEASE;
        k = context;
        n = false;
        c = b(context);
        l = s1;
    }

    private static String a(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "Unknown";
        }
        return context;
    }

    private static int b(Context context)
    {
        int i1;
        try
        {
            i1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(a, "Error retrieving application version", context);
            return -1;
        }
        return i1;
    }

    private static String c()
    {
        Object obj = "Unknown";
        Object obj1 = new RandomAccessFile("/proc/meminfo", "r");
        Object obj2 = ((RandomAccessFile) (obj1)).readLine();
        obj = obj2;
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
_L2:
        obj = obj2;
        if (i1 >= ((String) (obj2)).length())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = obj2;
        Character character = Character.valueOf(((String) (obj2)).charAt(i1));
        obj = obj2;
        if (!Character.isDigit(character.charValue()))
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj = obj2;
        Throwable throwable;
        try
        {
            stringbuilder.append(character);
            break MISSING_BLOCK_LABEL_161;
        }
        catch (Throwable throwable1) { }
        finally { }
        break MISSING_BLOCK_LABEL_118;
        obj = obj2;
        obj2 = Long.toString(Long.valueOf(Long.parseLong(stringbuilder.toString())).longValue() / 1024L);
        obj = obj2;
        try
        {
            ((RandomAccessFile) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return ((String) (obj));
        }
        obj2 = obj;
        return ((String) (obj2));
        obj1;
        obj1 = null;
        obj2 = obj;
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                return ((String) (obj));
            }
            return ((String) (obj));
        } else
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj;
        obj1 = null;
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        throw obj;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String c(Context context)
    {
        Object obj;
        try
        {
            context = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            p.a("Error determining carrier name", context);
            context = "unknown";
        }
        obj = context;
        if (context == null)
        {
            obj = "unknown";
        }
        return ((String) (obj));
    }

    private static String d()
    {
        Object obj1;
        String s;
        s = null;
        obj1 = "Unknown";
        Object obj = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
        s = ((RandomAccessFile) (obj)).readLine();
        obj1 = s;
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return ((String) (obj1));
        }
        return ((String) (obj1));
        obj;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((RandomAccessFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return "Unknown";
            }
            return "Unknown";
        } else
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj;
        obj1 = s;
_L2:
        if (obj1 != null)
        {
            try
            {
                ((RandomAccessFile) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        Object obj2;
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int e()
    {
        final class a
            implements FileFilter
        {

            public final boolean accept(File file)
            {
                return Pattern.matches("cpu[0-9]+", file.getName());
            }

            a()
            {
            }
        }

        int i1;
        try
        {
            i1 = (new File("/sys/devices/system/cpu/")).listFiles(new a()).length;
        }
        catch (Throwable throwable)
        {
            return -1;
        }
        return i1;
    }

    private String f()
    {
_L2:
        if (n)
        {
            return "unknown";
        }
        Object obj = ((ConnectivityManager)k.getSystemService("connectivity")).getActiveNetworkInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (!((NetworkInfo) (obj)).isConnected())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (((NetworkInfo) (obj)).getType() == 1)
        {
            return "wifi";
        }
        if (((NetworkInfo) (obj)).getType() != 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        int i1 = ((NetworkInfo) (obj)).getSubtype();
        if (!o.containsKey(Integer.valueOf(i1)))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = (String)o.get(Integer.valueOf(i1));
        return ((String) (obj));
        return "offline";
        Object obj1;
        obj1;
        n = true;
        continue; /* Loop/switch isn't completed */
        obj1;
        p.a("Error determining connection type", ((Throwable) (obj1)));
        return "unknown";
        if (true) goto _L2; else goto _L1
_L1:
    }

    final String a()
    {
        return b;
    }

    final void a(bd bd1)
    {
        if (c != -1)
        {
            bd1.a("avi", c).a();
        }
        bd1.a("av", b).a().a("agv", "4.1.5.0").a().a("ab", "4a7494a184c449ed1cdc3f18d8c1d70e96674133");
    }

    final void a(e e1)
    {
        e1.a("ky", l);
        e1.a("an", k.getPackageName());
        e1.a("osn", "Android");
        e1.a("bid", m);
    }

    final void a(JSONObject jsonobject)
    {
        if (c != -1)
        {
            jsonobject.put("avi", c);
        }
        jsonobject.put("av", b);
        jsonobject.put("agv", "4.1.5.0");
        jsonobject.put("ab", "4a7494a184c449ed1cdc3f18d8c1d70e96674133");
    }

    public final String b()
    {
        return l;
    }

    final void b(bd bd1)
    {
        bd1.a("dm", d).a().a("dmo", e).a().a("ds", f.longValue()).a().a("tm", g).a().a("cf", h).a().a("cc", i.intValue()).a().a("osv", j).a().a("ca", c(k)).a().a("ct", f()).a().a("av", b);
        if (m != null)
        {
            bd1.a().a("bid", m);
        }
    }

    final void b(JSONObject jsonobject)
    {
        jsonobject.put("dm", d);
        jsonobject.put("dmo", e);
        jsonobject.put("ds", f);
        jsonobject.put("tm", g);
        jsonobject.put("cf", h);
        jsonobject.put("cc", i);
        jsonobject.put("osv", j);
        jsonobject.put("ca", c(k));
        jsonobject.put("ct", f());
        if (m != null)
        {
            jsonobject.put("bid", m);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        o = hashmap;
        hashmap.put(Integer.valueOf(7), "2g");
        o.put(Integer.valueOf(4), "2g");
        o.put(Integer.valueOf(2), "2g");
        o.put(Integer.valueOf(1), "2g");
        o.put(Integer.valueOf(11), "2g");
        o.put(Integer.valueOf(5), "3g");
        o.put(Integer.valueOf(6), "3g");
        o.put(Integer.valueOf(10), "3g");
        o.put(Integer.valueOf(9), "3g");
        o.put(Integer.valueOf(3), "3g");
        o.put(Integer.valueOf(14), "3g");
        o.put(Integer.valueOf(12), "3g");
        o.put(Integer.valueOf(15), "4g");
        o.put(Integer.valueOf(8), "4g");
        o.put(Integer.valueOf(13), "4g");
    }
}
