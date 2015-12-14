// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.common;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import bso;
import bsy;
import btb;
import bti;
import btj;
import bty;
import bud;
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

// Referenced classes of package io.fabric.sdk.android.services.common:
//            CommonUtils

public class IdManager
{

    private static final Pattern d = Pattern.compile("[^\\p{Alnum}]");
    private static final String e = Pattern.quote("/");
    btj a;
    bti b;
    boolean c;
    private final ReentrantLock f = new ReentrantLock();
    private final bud g = new bud();
    private final boolean h;
    private final boolean i;
    private final Context j;
    private final String k;
    private final String l;
    private final Collection m;

    public IdManager(Context context, String s, String s1, Collection collection)
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
        a = new btj(context);
        h = CommonUtils.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!h)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("Device ID collection disabled for ").append(context.getPackageName()).toString());
        }
        i = CommonUtils.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!i)
        {
            bso.h().a("Fabric", (new StringBuilder()).append("User information collection disabled for ").append(context.getPackageName()).toString());
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

    private void a(Map map, DeviceIdentifierType deviceidentifiertype, String s)
    {
        if (s != null)
        {
            map.put(deviceidentifiertype, s);
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
            bso.h().e("Fabric", "Could not write application id to JSON", jsonobject);
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
                jsonobject.put(((DeviceIdentifierType)entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            }
            catch (Exception exception)
            {
                bso.h().e("Fabric", (new StringBuilder()).append("Could not write value to JSON: ").append(((DeviceIdentifierType)entry.getKey()).name()).toString(), exception);
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
            bso.h().e("Fabric", "Could not write OS version to JSON", jsonobject);
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
            bso.h().e("Fabric", "Could not write model to JSON", jsonobject);
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
            s1 = CommonUtils.a(1, CommonUtils.a((new StringBuilder()).append(s).append(s1).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            bso.h().e("Fabric", "Could not create cipher to encrypt headers.", s);
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
                s = CommonUtils.a(s1.doFinal(jsonobject.toString().getBytes()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                bso.h().e("Fabric", "Could not encrypt IDs", s);
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
            SharedPreferences sharedpreferences = CommonUtils.a(j);
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
                SharedPreferences sharedpreferences = CommonUtils.a(j);
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
            Object obj = (bsy)iterator.next();
            if (obj instanceof bty)
            {
                obj = ((bty)obj).getDeviceIdentifiers().entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    a(hashmap, (DeviceIdentifierType)entry.getKey(), (String)entry.getValue());
                }
            }
        } while (true);
        a(hashmap, DeviceIdentifierType.ANDROID_ID, l());
        a(hashmap, DeviceIdentifierType.ANDROID_DEVICE_ID, m());
        a(hashmap, DeviceIdentifierType.ANDROID_SERIAL, p());
        a(hashmap, DeviceIdentifierType.WIFI_MAC_ADDRESS, n());
        a(hashmap, DeviceIdentifierType.BLUETOOTH_MAC_ADDRESS, o());
        a(hashmap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, k());
        return Collections.unmodifiableMap(hashmap);
    }

    public String h()
    {
        return g.a(j);
    }

    bti i()
    {
        this;
        JVM INSTR monitorenter ;
        bti bti1;
        if (!c)
        {
            b = a.a();
            c = true;
        }
        bti1 = b;
        this;
        JVM INSTR monitorexit ;
        return bti1;
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
            bti bti1 = i();
            boolean1 = obj;
            if (bti1 != null)
            {
                boolean1 = Boolean.valueOf(bti1.b);
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
            bti bti1 = i();
            s = obj;
            if (bti1 != null)
            {
                s = bti1.a;
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
                bso.h().e("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", exception);
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
        bso.h().e("Fabric", "Could not retrieve android.os.Build.SERIAL value", exception);
        return null;
    }


    private class DeviceIdentifierType extends Enum
    {

        private static final DeviceIdentifierType $VALUES[];
        public static final DeviceIdentifierType ANDROID_ADVERTISING_ID;
        public static final DeviceIdentifierType ANDROID_DEVICE_ID;
        public static final DeviceIdentifierType ANDROID_ID;
        public static final DeviceIdentifierType ANDROID_SERIAL;
        public static final DeviceIdentifierType BLUETOOTH_MAC_ADDRESS;
        public static final DeviceIdentifierType FONT_TOKEN;
        public static final DeviceIdentifierType WIFI_MAC_ADDRESS;
        public final int protobufIndex;

        public static DeviceIdentifierType valueOf(String s)
        {
            return (DeviceIdentifierType)Enum.valueOf(io/fabric/sdk/android/services/common/IdManager$DeviceIdentifierType, s);
        }

        public static DeviceIdentifierType[] values()
        {
            return (DeviceIdentifierType[])$VALUES.clone();
        }

        static 
        {
            WIFI_MAC_ADDRESS = new DeviceIdentifierType("WIFI_MAC_ADDRESS", 0, 1);
            BLUETOOTH_MAC_ADDRESS = new DeviceIdentifierType("BLUETOOTH_MAC_ADDRESS", 1, 2);
            FONT_TOKEN = new DeviceIdentifierType("FONT_TOKEN", 2, 53);
            ANDROID_ID = new DeviceIdentifierType("ANDROID_ID", 3, 100);
            ANDROID_DEVICE_ID = new DeviceIdentifierType("ANDROID_DEVICE_ID", 4, 101);
            ANDROID_SERIAL = new DeviceIdentifierType("ANDROID_SERIAL", 5, 102);
            ANDROID_ADVERTISING_ID = new DeviceIdentifierType("ANDROID_ADVERTISING_ID", 6, 103);
            $VALUES = (new DeviceIdentifierType[] {
                WIFI_MAC_ADDRESS, BLUETOOTH_MAC_ADDRESS, FONT_TOKEN, ANDROID_ID, ANDROID_DEVICE_ID, ANDROID_SERIAL, ANDROID_ADVERTISING_ID
            });
        }

        private DeviceIdentifierType(String s, int i1, int j1)
        {
            super(s, i1);
            protobufIndex = j1;
        }
    }

}
