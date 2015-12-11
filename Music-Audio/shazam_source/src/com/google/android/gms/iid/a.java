// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.iid:
//            f, e

public final class a
{

    static Map a = new HashMap();
    public static f c;
    public static String g;
    private static e h;
    Context b;
    KeyPair d;
    public String e;
    long f;

    private a(Context context, String s)
    {
        e = "";
        b = context.getApplicationContext();
        e = s;
    }

    static int a(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            (new StringBuilder("Never happens: can't find own package ")).append(context);
            return 0;
        }
        return i;
    }

    public static a a(Context context, Bundle bundle)
    {
        com/google/android/gms/iid/a;
        JVM INSTR monitorenter ;
        if (bundle != null) goto _L2; else goto _L1
_L1:
        bundle = "";
          goto _L3
_L5:
        a a1;
        Context context1;
        context1 = context.getApplicationContext();
        if (c == null)
        {
            c = new f(context1);
            h = new e(context1);
        }
        g = Integer.toString(a(context1));
        a1 = (a)a.get(bundle);
        context = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        context = new a(context1, bundle);
        a.put(bundle, context);
        com/google/android/gms/iid/a;
        JVM INSTR monitorexit ;
        return context;
_L2:
        bundle = bundle.getString("subtype");
          goto _L3
        context;
        throw context;
_L3:
        if (bundle == null)
        {
            bundle = "";
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static f a()
    {
        return c;
    }

    static String a(KeyPair keypair)
    {
        keypair = keypair.getPublic().getEncoded();
        try
        {
            keypair = MessageDigest.getInstance("SHA1").digest(keypair);
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            return null;
        }
        keypair[0] = (byte)((keypair[0] & 0xf) + 112 & 0xff);
        keypair = Base64.encodeToString(keypair, 0, 8, 11);
        return keypair;
    }

    static String a(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 11);
    }

    public static a b(Context context)
    {
        return a(context, null);
    }

    static e b()
    {
        return h;
    }

    public static boolean c()
    {
        String s = c.a("appVersion");
        long l;
        if (s != null && s.equals(g))
        {
            if ((s = c.a("lastToken")) != null && System.currentTimeMillis() / 1000L - Long.valueOf(l = Long.parseLong(s)).longValue() <= 0x93a80L)
            {
                return false;
            }
        }
        return true;
    }

    public final String a(String s, String s1, Bundle bundle)
    {
        bundle.putString("scope", s1);
        bundle.putString("sender", s);
        e e1;
        KeyPair keypair;
        if ("".equals(e))
        {
            s1 = s;
        } else
        {
            s1 = e;
        }
        if (!bundle.containsKey("legacy.register"))
        {
            bundle.putString("subscription", s);
            bundle.putString("subtype", s1);
            bundle.putString("X-subscription", s);
            bundle.putString("X-subtype", s1);
        }
        e1 = h;
        if (d == null)
        {
            d = c.d(e);
        }
        if (d == null)
        {
            f = System.currentTimeMillis();
            d = c.a(e, f);
        }
        keypair = d;
        s1 = e1.a(bundle, keypair);
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.hasExtra("google.messenger"))
            {
                s = e1.a(bundle, keypair);
            }
        }
        return com.google.android.gms.iid.e.a(s);
    }

}
