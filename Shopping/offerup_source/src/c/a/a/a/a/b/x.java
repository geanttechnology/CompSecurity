// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;

// Referenced classes of package c.a.a.a.a.b:
//            z, c, l, y, 
//            t, b

public final class x
{

    private static final Pattern a = Pattern.compile("[^\\p{Alnum}]");
    private static final String b = Pattern.quote("/");
    private final ReentrantLock c = new ReentrantLock();
    private final z d = new z();
    private final boolean e;
    private final boolean f;
    private final Context g;
    private final String h;
    private final String i;
    private final Collection j;
    private c k;
    private b l;
    private boolean m;

    public x(Context context, String s, String s1, Collection collection)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null)
        {
            throw new IllegalArgumentException("kits must not be null");
        }
        g = context;
        h = s;
        i = s1;
        j = collection;
        k = new c(context);
        e = c.a.a.a.a.b.l.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!e)
        {
            c.a.a.a.e.d().a("Fabric", (new StringBuilder("Device ID collection disabled for ")).append(context.getPackageName()).toString());
        }
        f = c.a.a.a.a.b.l.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!f)
        {
            c.a.a.a.e.d().a("Fabric", (new StringBuilder("User information collection disabled for ")).append(context.getPackageName()).toString());
        }
    }

    private String a(SharedPreferences sharedpreferences)
    {
        c.lock();
        String s1 = sharedpreferences.getString("crashlytics.installation.id", null);
        String s;
        s = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        s = b(UUID.randomUUID().toString());
        sharedpreferences.edit().putString("crashlytics.installation.id", s).commit();
        c.unlock();
        return s;
        sharedpreferences;
        c.unlock();
        throw sharedpreferences;
    }

    private static void a(Map map, y y1, String s)
    {
        if (s != null)
        {
            map.put(y1, s);
        }
    }

    private void a(JSONObject jsonobject)
    {
        for (Iterator iterator = g().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put(((y)entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            }
            catch (Exception exception)
            {
                c.a.a.a.e.d().c("Fabric", (new StringBuilder("Could not write value to JSON: ")).append(((y)entry.getKey()).name()).toString(), exception);
            }
        }

    }

    private boolean a(String s)
    {
        return g.checkCallingPermission(s) == 0;
    }

    private static String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return a.matcher(s).replaceAll("").toLowerCase(Locale.US);
        }
    }

    private static String c(String s)
    {
        return s.replaceAll(b, "");
    }

    private b k()
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        if (!m)
        {
            l = k.a();
            m = true;
        }
        b1 = l;
        this;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private String l()
    {
        Object obj = null;
        String s = obj;
        if (e)
        {
            String s1 = android.provider.Settings.Secure.getString(g.getContentResolver(), "android_id");
            s = obj;
            if (!"9774d56d682e549c".equals(s1))
            {
                s = b(s1);
            }
        }
        return s;
    }

    private String m()
    {
        if (!e || android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        String s = b((String)android/os/Build.getField("SERIAL").get(null));
        return s;
        Exception exception;
        exception;
        c.a.a.a.e.d().c("Fabric", "Could not retrieve android.os.Build.SERIAL value", exception);
        return null;
    }

    public final String a(String s, String s1)
    {
        JSONObject jsonobject;
        try
        {
            s1 = s1.replaceAll("\\.", (new StringBuilder(new String(new char[] {
                's', 'l', 'c'
            }))).reverse().toString());
            s1 = c.a.a.a.a.b.l.a(1, c.a.a.a.a.b.l.a((new StringBuilder()).append(s).append(s1).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c.a.a.a.e.d().c("Fabric", "Could not create cipher to encrypt headers.", s);
            return "";
        }
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), b());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c.a.a.a.e.d().c("Fabric", "Could not write application id to JSON", s);
        }
        a(jsonobject);
        try
        {
            jsonobject.put("os_version", d());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c.a.a.a.e.d().c("Fabric", "Could not write OS version to JSON", s);
        }
        try
        {
            jsonobject.put("model", e());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c.a.a.a.e.d().c("Fabric", "Could not write model to JSON", s);
        }
        s = "";
        if (jsonobject.length() > 0)
        {
            try
            {
                s = c.a.a.a.a.b.l.a(s1.doFinal(jsonobject.toString().getBytes()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                c.a.a.a.e.d().c("Fabric", "Could not encrypt IDs", s);
                return "";
            }
        }
        return s;
    }

    public final boolean a()
    {
        return f;
    }

    public final String b()
    {
        String s1 = i;
        String s = s1;
        if (s1 == null)
        {
            SharedPreferences sharedpreferences = c.a.a.a.a.b.l.a(g);
            String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
            s = s2;
            if (s2 == null)
            {
                s = a(sharedpreferences);
            }
        }
        return s;
    }

    public final String c()
    {
        return h;
    }

    public final String d()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            c(android.os.Build.VERSION.RELEASE), c(android.os.Build.VERSION.INCREMENTAL)
        });
    }

    public final String e()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            c(Build.MANUFACTURER), c(Build.MODEL)
        });
    }

    public final String f()
    {
        String s = "";
        if (e)
        {
            String s1 = l();
            s = s1;
            if (s1 == null)
            {
                SharedPreferences sharedpreferences = c.a.a.a.a.b.l.a(g);
                String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
                s = s2;
                if (s2 == null)
                {
                    s = a(sharedpreferences);
                }
            }
        }
        return s;
    }

    public final Map g()
    {
        Object obj1;
        HashMap hashmap;
        y y1;
        obj1 = null;
        hashmap = new HashMap();
        Iterator iterator = j.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj2 = (n)iterator.next();
            if (obj2 instanceof t)
            {
                obj2 = ((t)obj2).getDeviceIdentifiers().entrySet().iterator();
                while (((Iterator) (obj2)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj2)).next();
                    a(hashmap, (y)entry.getKey(), (String)entry.getValue());
                }
            }
        } while (true);
        a(hashmap, y.d, l());
        y1 = c.a.a.a.a.b.y.e;
        if (!e || !a("android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        Object obj = (TelephonyManager)g.getSystemService("phone");
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj = b(((TelephonyManager) (obj)).getDeviceId());
_L4:
        a(hashmap, y1, ((String) (obj)));
        a(hashmap, y.f, m());
        y1 = y.a;
        if (!e || !a("android.permission.ACCESS_WIFI_STATE"))
        {
            break MISSING_BLOCK_LABEL_321;
        }
        obj = (WifiManager)g.getSystemService("wifi");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        obj = ((WifiManager) (obj)).getConnectionInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        obj = b(((WifiInfo) (obj)).getMacAddress());
_L5:
        a(hashmap, y1, ((String) (obj)));
        a(hashmap, y.b, j());
        y1 = y.g;
        obj = obj1;
        if (e)
        {
            b b1 = k();
            obj = obj1;
            if (b1 != null)
            {
                obj = b1.a;
            }
        }
        a(hashmap, y1, ((String) (obj)));
        return Collections.unmodifiableMap(hashmap);
_L2:
        obj = null;
          goto _L4
        obj = null;
          goto _L5
    }

    public final String h()
    {
        return d.a(g);
    }

    public final Boolean i()
    {
        Object obj = null;
        Boolean boolean1 = obj;
        if (e)
        {
            b b1 = k();
            boolean1 = obj;
            if (b1 != null)
            {
                boolean1 = Boolean.valueOf(b1.b);
            }
        }
        return boolean1;
    }

    public final String j()
    {
        if (!e || !a("android.permission.BLUETOOTH"))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter != null)
        {
            try
            {
                b(bluetoothadapter.getAddress());
            }
            catch (Exception exception)
            {
                c.a.a.a.e.d().c("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", exception);
            }
        }
        return null;
    }

}
