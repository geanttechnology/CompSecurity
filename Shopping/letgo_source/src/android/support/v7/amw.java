// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
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

// Referenced classes of package android.support.v7:
//            amx, amk, amq, alt, 
//            amc, alz, amu, amj

public class amw
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a i[];
        public final int h;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/amw$a, s);
        }

        public static a[] values()
        {
            return (a[])i.clone();
        }

        static 
        {
            a = new a("WIFI_MAC_ADDRESS", 0, 1);
            b = new a("BLUETOOTH_MAC_ADDRESS", 1, 2);
            c = new a("FONT_TOKEN", 2, 53);
            d = new a("ANDROID_ID", 3, 100);
            e = new a("ANDROID_DEVICE_ID", 4, 101);
            f = new a("ANDROID_SERIAL", 5, 102);
            g = new a("ANDROID_ADVERTISING_ID", 6, 103);
            i = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s, int i1, int j1)
        {
            super(s, i1);
            h = j1;
        }
    }


    private static final Pattern d = Pattern.compile("[^\\p{Alnum}]");
    private static final String e = Pattern.quote("/");
    amk a;
    amj b;
    boolean c;
    private final ReentrantLock f = new ReentrantLock();
    private final amx g = new amx();
    private final boolean h;
    private final boolean i;
    private final Context j;
    private final String k;
    private final String l;
    private final Collection m;

    public amw(Context context, String s, String s1, Collection collection)
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
        j = context;
        k = s;
        l = s1;
        m = collection;
        a = new amk(context);
        h = amq.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!h)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("Device ID collection disabled for ").append(context.getPackageName()).toString());
        }
        i = amq.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!i)
        {
            alt.h().a("Fabric", (new StringBuilder()).append("User information collection disabled for ").append(context.getPackageName()).toString());
        }
    }

    private String a(SharedPreferences sharedpreferences)
    {
        f.lock();
        String s1 = sharedpreferences.getString("crashlytics.installation.id", null);
        String s;
        s = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = b(UUID.randomUUID().toString());
        sharedpreferences.edit().putString("crashlytics.installation.id", s).commit();
        f.unlock();
        return s;
        sharedpreferences;
        f.unlock();
        throw sharedpreferences;
    }

    private void a(Map map, a a1, String s)
    {
        if (s != null)
        {
            map.put(a1, s);
        }
    }

    private void a(JSONObject jsonobject)
    {
        try
        {
            jsonobject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            alt.h().e("Fabric", "Could not write application id to JSON", jsonobject);
        }
    }

    private boolean a(String s)
    {
        return j.checkCallingPermission(s) == 0;
    }

    private String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return d.matcher(s).replaceAll("").toLowerCase(Locale.US);
        }
    }

    private void b(JSONObject jsonobject)
    {
        for (Iterator iterator = g().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put(((a)entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            }
            catch (Exception exception)
            {
                alt.h().e("Fabric", (new StringBuilder()).append("Could not write value to JSON: ").append(((a)entry.getKey()).name()).toString(), exception);
            }
        }

    }

    private String c(String s)
    {
        return s.replaceAll(e, "");
    }

    private void c(JSONObject jsonobject)
    {
        try
        {
            jsonobject.put("os_version", d());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            alt.h().e("Fabric", "Could not write OS version to JSON", jsonobject);
        }
    }

    private void d(JSONObject jsonobject)
    {
        try
        {
            jsonobject.put("model", e());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            alt.h().e("Fabric", "Could not write model to JSON", jsonobject);
        }
    }

    public String a(String s, String s1)
    {
        JSONObject jsonobject;
        try
        {
            s1 = s1.replaceAll("\\.", (new StringBuilder(new String(new char[] {
                's', 'l', 'c'
            }))).reverse().toString());
            s1 = amq.a(1, amq.a((new StringBuilder()).append(s).append(s1).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            alt.h().e("Fabric", "Could not create cipher to encrypt headers.", s);
            return "";
        }
        jsonobject = new JSONObject();
        a(jsonobject);
        b(jsonobject);
        c(jsonobject);
        d(jsonobject);
        s = "";
        if (jsonobject.length() > 0)
        {
            try
            {
                s = amq.a(s1.doFinal(jsonobject.toString().getBytes()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                alt.h().e("Fabric", "Could not encrypt IDs", s);
                return "";
            }
        }
        return s;
    }

    public boolean a()
    {
        return i;
    }

    public String b()
    {
        String s1 = l;
        String s = s1;
        if (s1 == null)
        {
            SharedPreferences sharedpreferences = amq.a(j);
            String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
            s = s2;
            if (s2 == null)
            {
                s = a(sharedpreferences);
            }
        }
        return s;
    }

    public String c()
    {
        return k;
    }

    public String d()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            c(android.os.Build.VERSION.RELEASE), c(android.os.Build.VERSION.INCREMENTAL)
        });
    }

    public String e()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            c(Build.MANUFACTURER), c(Build.MODEL)
        });
    }

    public String f()
    {
        String s = "";
        if (h)
        {
            String s1 = l();
            s = s1;
            if (s1 == null)
            {
                SharedPreferences sharedpreferences = amq.a(j);
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

    public Map g()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = m.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (alz)iterator.next();
            if (obj instanceof amu)
            {
                obj = ((amu)obj).getDeviceIdentifiers().entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    a(hashmap, (a)entry.getKey(), (String)entry.getValue());
                }
            }
        } while (true);
        a(hashmap, a.d, l());
        a(hashmap, a.e, m());
        a(hashmap, a.f, p());
        a(hashmap, a.a, n());
        a(hashmap, a.b, o());
        a(hashmap, a.g, k());
        return Collections.unmodifiableMap(hashmap);
    }

    public String h()
    {
        return g.a(j);
    }

    amj i()
    {
        this;
        JVM INSTR monitorenter ;
        amj amj1;
        if (!c)
        {
            b = a.a();
            c = true;
        }
        amj1 = b;
        this;
        JVM INSTR monitorexit ;
        return amj1;
        Exception exception;
        exception;
        throw exception;
    }

    public Boolean j()
    {
        Object obj = null;
        Boolean boolean1 = obj;
        if (h)
        {
            amj amj1 = i();
            boolean1 = obj;
            if (amj1 != null)
            {
                boolean1 = Boolean.valueOf(amj1.b);
            }
        }
        return boolean1;
    }

    public String k()
    {
        Object obj = null;
        String s = obj;
        if (h)
        {
            amj amj1 = i();
            s = obj;
            if (amj1 != null)
            {
                s = amj1.a;
            }
        }
        return s;
    }

    public String l()
    {
        Object obj = null;
        String s = obj;
        if (h)
        {
            String s1 = android.provider.Settings.Secure.getString(j.getContentResolver(), "android_id");
            s = obj;
            if (!"9774d56d682e549c".equals(s1))
            {
                s = b(s1);
            }
        }
        return s;
    }

    public String m()
    {
        if (h && a("android.permission.READ_PHONE_STATE"))
        {
            TelephonyManager telephonymanager = (TelephonyManager)j.getSystemService("phone");
            if (telephonymanager != null)
            {
                return b(telephonymanager.getDeviceId());
            }
        }
        return null;
    }

    public String n()
    {
        if (h && a("android.permission.ACCESS_WIFI_STATE"))
        {
            Object obj = (WifiManager)j.getSystemService("wifi");
            if (obj != null)
            {
                obj = ((WifiManager) (obj)).getConnectionInfo();
                if (obj != null)
                {
                    return b(((WifiInfo) (obj)).getMacAddress());
                }
            }
        }
        return null;
    }

    public String o()
    {
        if (!h || !a("android.permission.BLUETOOTH"))
        {
            break MISSING_BLOCK_LABEL_34;
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
                alt.h().e("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", exception);
            }
        }
        return null;
    }

    public String p()
    {
        if (!h || android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        String s = b((String)android/os/Build.getField("SERIAL").get(null));
        return s;
        Exception exception;
        exception;
        alt.h().e("Fabric", "Could not retrieve android.os.Build.SERIAL value", exception);
        return null;
    }

}
