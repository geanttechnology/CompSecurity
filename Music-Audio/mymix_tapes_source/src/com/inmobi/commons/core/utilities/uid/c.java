// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.utilities.uid:
//            ImIdShareBroadCastReceiver, b, a

public class c
{

    private static final String a = com/inmobi/commons/core/utilities/uid/c.getSimpleName();
    private static final Object b = new Object();
    private static c c;
    private static com.inmobi.commons.core.utilities.uid.a d;
    private static String e;

    private c()
    {
    }

    public static c a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        c c1 = c;
        obj = c1;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new c();
        c = ((c) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((c) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((c) (obj));
    }

    static com.inmobi.commons.core.utilities.uid.a o()
    {
        return d;
    }

    static String p()
    {
        return a;
    }

    private void q()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.inmobi.share.id");
        com.inmobi.commons.a.a.b().registerReceiver(new ImIdShareBroadCastReceiver(), intentfilter);
    }

    private void r()
    {
        b b1 = new b();
        String s1 = b1.c();
        String s = s1;
        if (s1 == null)
        {
            s = UUID.randomUUID().toString();
            b1.b(s);
        }
        e = s;
    }

    String a(Context context)
    {
        return (new b()).d();
    }

    String a(String s)
    {
        return a(s, "SHA-1");
    }

    String a(String s, String s1)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if ("".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        int i1;
        try
        {
            s1 = MessageDigest.getInstance(s1);
            s1.update(s.getBytes());
            s = s1.digest();
            s1 = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        i1 = 0;
        if (i1 >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s1.append(Integer.toString((s[i1] & 0xff) + 256, 16).substring(1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_47;
_L1:
        s = s1.toString();
        return s;
        return "TEST_EMULATOR";
    }

    String b(Context context)
    {
        context = new b();
        Object obj;
        JSONObject jsonobject;
        String s;
        try
        {
            jsonobject = new JSONObject();
            s = context.c();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        jsonobject.put("p", s);
        obj = context.f();
        context = ((Context) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        context = ((Context) (obj));
        if (((String) (obj)).contains(s))
        {
            context = ((String) (obj)).replace(s, "");
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (context.trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = context;
        if (context.charAt(0) == ',')
        {
            obj = context.substring(1);
        }
        context = new JSONArray();
        context.put(obj);
        jsonobject.put("s", context);
        context = jsonobject.toString();
        return context;
    }

    String b(String s)
    {
        return a(s, "MD5");
    }

    public void b()
    {
        e();
        d();
        r();
        q();
        n();
    }

    public String c()
    {
        return e;
    }

    public void d()
    {
        k();
    }

    public void e()
    {
        if (l())
        {
            Object obj = j();
            if (obj != null)
            {
                obj = ((com.inmobi.commons.core.utilities.uid.a) (obj)).b();
                if (obj != null)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG, a, (new StringBuilder()).append("Publisher device Id is ").append(((String) (obj))).toString());
                }
            }
            return;
        } else
        {
            String s = i();
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG, a, (new StringBuilder()).append("Publisher device Id is ").append(a(s)).toString());
            return;
        }
    }

    String f()
    {
        return "1";
    }

    String g()
    {
        return com.inmobi.commons.core.utilities.info.e.d();
    }

    String h()
    {
        return com.inmobi.commons.core.utilities.info.e.e();
    }

    String i()
    {
        String s1 = android.provider.Settings.Secure.getString(com.inmobi.commons.a.a.b().getContentResolver(), "android_id");
        String s = s1;
        if (s1 == null)
        {
            s = android.provider.Settings.System.getString(com.inmobi.commons.a.a.b().getContentResolver(), "android_id");
        }
        return s;
    }

    com.inmobi.commons.core.utilities.uid.a j()
    {
        return d;
    }

    void k()
    {
        b b1 = new b();
        d = new com.inmobi.commons.core.utilities.uid.a();
        d.a(b1.a());
        d.a(b1.b());
        (new Thread(new Runnable(b1) {

            final b a;
            final c b;

            public void run()
            {
                try
                {
                    Object obj1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                    Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                    obj1 = ((Class) (obj1)).getDeclaredMethod("getAdvertisingIdInfo", new Class[] {
                        android/content/Context
                    }).invoke(null, new Object[] {
                        com.inmobi.commons.a.a.b()
                    });
                    String s = (String)((Class) (obj)).getDeclaredMethod("getId", (Class[])null).invoke(obj1, (Object[])null);
                    c.o().a(s);
                    a.a(s);
                    obj = (Boolean)((Class) (obj)).getDeclaredMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(obj1, (Object[])null);
                    c.o().a(((Boolean) (obj)).booleanValue());
                    a.a(((Boolean) (obj)).booleanValue());
                    return;
                }
                catch (NoSuchMethodException nosuchmethodexception)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", nosuchmethodexception);
                    return;
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", invocationtargetexception);
                    return;
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", classnotfoundexception);
                    return;
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", illegalaccessexception);
                }
            }

            
            {
                b = c.this;
                a = b1;
                super();
            }
        })).start();
    }

    boolean l()
    {
        boolean flag = false;
        int i1;
        try
        {
            i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            noclassdeffounderror.printStackTrace();
            return false;
        }
        if (i1 == 0)
        {
            flag = true;
        }
        return flag;
    }

    public boolean m()
    {
        com.inmobi.commons.core.utilities.uid.a a1 = a().j();
        if (a1 != null)
        {
            return a1.a();
        } else
        {
            return false;
        }
    }

    protected void n()
    {
        b b1 = new b();
        Object obj = b1.d();
        long l1 = b1.e();
        String s = ((String) (obj));
        if (obj == null)
        {
            s = UUID.randomUUID().toString();
            b1.c(s);
            b1.b(c());
            b1.d(c());
        }
        if (l1 == 0L)
        {
            b1.a(System.currentTimeMillis());
        }
        obj = new Intent();
        ((Intent) (obj)).setAction("com.inmobi.share.id");
        ((Intent) (obj)).putExtra("imid", s);
        ((Intent) (obj)).putExtra("appendedid", b1.f());
        ((Intent) (obj)).putExtra("imidts", b1.e());
        ((Intent) (obj)).putExtra("appid", b1.c());
        com.inmobi.commons.a.a.b().sendBroadcast(((Intent) (obj)));
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Generating and broadcasting IDs. ID:").append(s).append(" AID:").append(b1.f()).toString());
    }

}
