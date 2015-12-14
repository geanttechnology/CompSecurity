// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bw, AppLovinSdkImpl, by, dh, 
//            aw

class bz
{

    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;
    private final Context c;
    private final Object d[] = new Object[bw.b()];

    bz(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
        b = applovinsdkimpl.getLogger();
        c = applovinsdkimpl.getApplicationContext();
    }

    private static by a(String s)
    {
        for (Iterator iterator = bw.a().iterator(); iterator.hasNext();)
        {
            by by1 = (by)iterator.next();
            if (by1.b().equals(s))
            {
                return by1;
            }
        }

        return null;
    }

    private static Object a(String s, JSONObject jsonobject, Object obj)
    {
        if (obj instanceof Boolean)
        {
            return Boolean.valueOf(jsonobject.getBoolean(s));
        }
        if (obj instanceof Float)
        {
            return Float.valueOf((float)jsonobject.getDouble(s));
        }
        if (obj instanceof Integer)
        {
            return Integer.valueOf(jsonobject.getInt(s));
        }
        if (obj instanceof Long)
        {
            return Long.valueOf(jsonobject.getLong(s));
        }
        if (obj instanceof String)
        {
            return jsonobject.getString(s);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("SDK Error: unknown value type: ").append(obj.getClass()).toString());
        }
    }

    private String e()
    {
        return (new StringBuilder()).append("com.applovin.sdk.").append(dh.a(a.getSdkKey())).append(".").toString();
    }

    public SharedPreferences a()
    {
        if (c == null)
        {
            throw new IllegalArgumentException("No context specified");
        } else
        {
            return c.getSharedPreferences("com.applovin.sdk.1", 0);
        }
    }

    public Object a(by by1)
    {
        if (by1 == null)
        {
            throw new IllegalArgumentException("No setting type specified");
        }
        Object aobj[] = d;
        aobj;
        JVM INSTR monitorenter ;
        Object obj = d[by1.a()];
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        by1 = ((by) (by1.a(obj)));
_L1:
        aobj;
        JVM INSTR monitorexit ;
        return by1;
        by1 = ((by) (by1.c()));
          goto _L1
        by1;
        aobj;
        JVM INSTR monitorexit ;
        throw by1;
    }

    public void a(by by1, Object obj)
    {
        if (by1 == null)
        {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj == null)
        {
            throw new IllegalArgumentException("No new value specified");
        }
        synchronized (d)
        {
            d[by1.a()] = obj;
        }
        b.d("SettingsManager", (new StringBuilder()).append("Setting update: ").append(by1.b()).append(" set to \"").append(obj).append("\"").toString());
        return;
        by1;
        aobj;
        JVM INSTR monitorexit ;
        throw by1;
    }

    void a(AppLovinSdkSettings applovinsdksettings)
    {
        long l;
        boolean flag1;
        boolean flag2;
        l = 0L;
        flag2 = false;
        flag1 = false;
        b.i("SettingsManager", "Loading user-defined settings...");
        if (applovinsdksettings == null)
        {
            return;
        }
        Object aobj[] = d;
        aobj;
        JVM INSTR monitorenter ;
        long l1;
        d[bw.j.a()] = Boolean.valueOf(applovinsdksettings.isVerboseLoggingEnabled());
        l1 = applovinsdksettings.getBannerAdRefreshSeconds();
        if (l1 < 0L) goto _L2; else goto _L1
_L1:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        l = Math.max(30L, l1);
        d[bw.A.a()] = Long.valueOf(l);
        d[bw.z.a()] = Boolean.valueOf(true);
_L7:
        String s1 = applovinsdksettings.getAutoPreloadSizes();
        String s;
        s = s1;
        if (s1 == null)
        {
            s = "NONE";
        }
        Object aobj1[];
        int i;
        aobj1 = d;
        i = bw.J.a();
        s1 = s;
        if (s.equals("NONE"))
        {
            s1 = "";
        }
        aobj1[i] = s1;
        s1 = applovinsdksettings.getAutoPreloadTypes();
        s = s1;
        if (s1 == null)
        {
            s = "NONE";
        }
        String as[];
        int k;
        if (s.equals("NONE"))
        {
            break MISSING_BLOCK_LABEL_446;
        }
        as = s.split(",");
        k = as.length;
        int j;
        j = 0;
        i = 0;
_L8:
        boolean flag;
        flag2 = flag1;
        flag = i;
        if (j >= k) goto _L4; else goto _L3
_L3:
        s1 = as[j];
        if (s1.equals(AppLovinAdType.REGULAR.getLabel()))
        {
            flag = true;
            break MISSING_BLOCK_LABEL_423;
        }
          goto _L5
_L2:
        if (l1 != -1L) goto _L7; else goto _L6
_L6:
        d[bw.z.a()] = Boolean.valueOf(false);
          goto _L7
        applovinsdksettings;
        aobj;
        JVM INSTR monitorexit ;
        throw applovinsdksettings;
_L5:
        if (s1.equals(AppLovinAdType.INCENTIVIZED.getLabel()) || s1.contains("INCENT"))
        {
            break MISSING_BLOCK_LABEL_436;
        }
        flag = i;
        if (s1.contains("REWARD"))
        {
            break MISSING_BLOCK_LABEL_436;
        }
        break MISSING_BLOCK_LABEL_423;
_L4:
        java.util.Map.Entry entry;
        for (; flag; flag = false)
        {
            break MISSING_BLOCK_LABEL_333;
        }

        d[bw.J.a()] = "";
        d[bw.K.a()] = Boolean.valueOf(flag2);
        if (applovinsdksettings instanceof aw)
        {
            for (applovinsdksettings = ((aw)applovinsdksettings).b().entrySet().iterator(); applovinsdksettings.hasNext();)
            {
                entry = (java.util.Map.Entry)applovinsdksettings.next();
                d[((by)entry.getKey()).a()] = entry.getValue();
            }

        }
        aobj;
        JVM INSTR monitorexit ;
        return;
_L9:
        j++;
        i = ((flag) ? 1 : 0);
          goto _L8
        flag1 = true;
        flag = i;
          goto _L9
    }

    void a(JSONObject jsonobject)
    {
        b.d("SettingsManager", "Loading settings from JSON array...");
        Object aobj[] = d;
        aobj;
        JVM INSTR monitorenter ;
        Iterator iterator = jsonobject.keys();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_234;
            }
            obj1 = (String)iterator.next();
        } while (obj1 == null);
        int i = ((String) (obj1)).length();
        if (i <= 0) goto _L2; else goto _L1
_L1:
        by by1 = a(((String) (obj1)));
        if (by1 == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj1 = a(((String) (obj1)), jsonobject, by1.c());
        d[by1.a()] = obj1;
        b.d("SettingsManager", (new StringBuilder()).append("Setting update: ").append(by1.b()).append(" set to \"").append(obj1).append("\"").toString());
          goto _L2
        Object obj;
        obj;
        b.e("SettingsManager", "Unable to parse JSON settings array", ((Throwable) (obj)));
          goto _L2
        jsonobject;
        aobj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        b.w("SettingsManager", (new StringBuilder()).append("Unknown setting recieved: ").append(((String) (obj1))).toString());
          goto _L2
        obj;
        b.e("SettingsManager", "Unable to convert setting object ", ((Throwable) (obj)));
          goto _L2
        aobj;
        JVM INSTR monitorexit ;
    }

    void b()
    {
        String s;
        android.content.SharedPreferences.Editor editor;
        if (c == null)
        {
            throw new IllegalArgumentException("No context specified");
        }
        b.i("SettingsManager", "Saving settings with the application...");
        s = e();
        editor = a().edit();
        Object aobj[] = d;
        aobj;
        JVM INSTR monitorenter ;
        Iterator iterator = bw.a().iterator();
_L1:
        Object obj;
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_300;
            }
            obj1 = (by)iterator.next();
            obj = d[((by) (obj1)).a()];
        } while (obj == null);
        obj1 = (new StringBuilder()).append(s).append(((by) (obj1)).b()).toString();
        if (!(obj instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        editor.putBoolean(((String) (obj1)), ((Boolean)obj).booleanValue());
          goto _L1
        Exception exception;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
label0:
        {
            if (!(obj instanceof Float))
            {
                break label0;
            }
            editor.putFloat(((String) (obj1)), ((Float)obj).floatValue());
        }
          goto _L1
label1:
        {
            if (!(obj instanceof Integer))
            {
                break label1;
            }
            editor.putInt(((String) (obj1)), ((Integer)obj).intValue());
        }
          goto _L1
label2:
        {
            if (!(obj instanceof Long))
            {
                break label2;
            }
            editor.putLong(((String) (obj1)), ((Long)obj).longValue());
        }
          goto _L1
label3:
        {
            if (!(obj instanceof String))
            {
                break label3;
            }
            editor.putString(((String) (obj1)), (String)obj);
        }
          goto _L1
        throw new RuntimeException((new StringBuilder()).append("SDK Error: unknown value: ").append(obj.getClass()).toString());
        aobj;
        JVM INSTR monitorexit ;
        editor.commit();
        b.d("SettingsManager", "Settings saved with the application.");
        return;
    }

    void c()
    {
        String s;
        SharedPreferences sharedpreferences;
        if (c == null)
        {
            throw new IllegalArgumentException("No context specified");
        }
        b.i("SettingsManager", "Loading settings saved with the application...");
        s = e();
        sharedpreferences = a();
        Object aobj[] = d;
        aobj;
        JVM INSTR monitorenter ;
        Iterator iterator = bw.a().iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        by by1 = (by)iterator.next();
        Object obj;
        Object obj1;
        obj = (new StringBuilder()).append(s).append(by1.b()).toString();
        obj1 = by1.c();
        if (!(obj1 instanceof Boolean)) goto _L4; else goto _L3
_L3:
        obj = Boolean.valueOf(sharedpreferences.getBoolean(((String) (obj)), ((Boolean)obj1).booleanValue()));
_L5:
        d[by1.a()] = obj;
        continue; /* Loop/switch isn't completed */
_L6:
        b.e("SettingsManager", (new StringBuilder()).append("Unable to load \"").append(by1.b()).append("\"").toString(), ((Throwable) (obj)));
        continue; /* Loop/switch isn't completed */
        obj;
        aobj;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
label0:
        {
            if (!(obj1 instanceof Float))
            {
                break label0;
            }
            obj = Float.valueOf(sharedpreferences.getFloat(((String) (obj)), ((Float)obj1).floatValue()));
        }
          goto _L5
label1:
        {
            if (!(obj1 instanceof Integer))
            {
                break label1;
            }
            obj = Integer.valueOf(sharedpreferences.getInt(((String) (obj)), ((Integer)obj1).intValue()));
        }
          goto _L5
label2:
        {
            if (!(obj1 instanceof Long))
            {
                break label2;
            }
            obj = Long.valueOf(sharedpreferences.getLong(((String) (obj)), ((Long)obj1).longValue()));
        }
          goto _L5
label3:
        {
            if (!(obj1 instanceof String))
            {
                break label3;
            }
            obj = sharedpreferences.getString(((String) (obj)), (String)obj1);
        }
          goto _L5
        try
        {
            throw new RuntimeException((new StringBuilder()).append("SDK Error: unknown value: ").append(obj1.getClass()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L6
_L2:
        aobj;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    void d()
    {
        synchronized (d)
        {
            Arrays.fill(d, null);
        }
        obj = a().edit();
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
