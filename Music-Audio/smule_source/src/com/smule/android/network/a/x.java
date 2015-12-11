// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smule.android.f.t;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class x
{

    private static final String a = com/smule/android/network/a/x.getName();

    private x()
    {
    }

    private static k a(String s, m m1)
    {
        return a(s, m1, false);
    }

    private static k a(String s, m m1, boolean flag)
    {
        s = new k(m1, s, l.b, n.c, null, false);
        s.h = 2;
        s.i = false;
        if (flag)
        {
            s.d = new HashMap();
            m1 = com.smule.android.network.core.b.d().a(false);
            if (!TextUtils.isEmpty(m1))
            {
                ((k) (s)).d.put("advId", m1);
            }
        }
        return s;
    }

    public static o a()
    {
        k k1 = a("/v2/fb/disconnect", m.a);
        k1.f = true;
        return a(k1);
    }

    public static o a(Bitmap bitmap)
    {
        k k1 = a("/v2/user/uploadPicture", m.a);
        k1.f = true;
        Object obj = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, ((java.io.OutputStream) (obj)));
        bitmap = new b.b.a.a.a.a.b(((ByteArrayOutputStream) (obj)).toByteArray(), "image/jpeg", "profile.jpg");
        obj = new HashMap();
        ((HashMap) (obj)).put("picture", bitmap);
        k1.j = ((Map) (obj));
        return a(k1);
    }

    private static o a(k k1)
    {
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(String s)
    {
        k k1 = a("/v2/user/lookup", m.a);
        k1.f = true;
        k1.d = new HashMap();
        k1.d.put("email", s);
        return a(k1);
    }

    public static o a(String s, String s1)
    {
        k k1 = a("/v2/user/emailRegister", m.b, true);
        k1.d.put("email", s);
        k1.d.put("password", s1);
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o a(String s, String s1, long l1, boolean flag)
    {
        k k1 = a("/v2/user/login", m.b, true);
        k1.d.put("email", s);
        k1.d.put("password", s1);
        k1.d.put("automaticLogin", Boolean.valueOf(flag));
        k1.d.put("vorgom", Boolean.valueOf(t.a()));
        if (l1 != 0L)
        {
            k1.d.put("playerId", Long.valueOf(l1));
        }
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o a(String s, String s1, String s2, com.smule.android.f.b b1)
    {
        k k1 = a("/v2/user/update", m.b);
        k1.f = true;
        k1.d = new HashMap();
        if (!TextUtils.isEmpty(s))
        {
            k1.d.put("handle", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            k1.d.put("email", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            k1.d.put("password", s2);
        }
        if (b1 != null)
        {
            k1.d.put("newsletter", Integer.valueOf(b1.a()));
        }
        return a(k1);
    }

    public static o a(String s, String s1, String s2, String s3, String s4, Integer integer, Integer integer1, String s5)
    {
        k k1 = a("/v2/fb/connect", m.b);
        k1.f = true;
        k1.d = new HashMap();
        k1.d.put("afbId", s);
        k1.d.put("fbAppId", com.smule.android.network.core.b.d().a());
        k1.d.put("tfb", s5);
        if (s2 != null)
        {
            k1.d.put("fbEmail", s2);
        }
        if (integer != null)
        {
            k1.d.put("minAge", integer);
        }
        if (integer1 != null)
        {
            k1.d.put("maxAge", integer1);
        }
        if (s3 != null)
        {
            k1.d.put("gender", s3);
        }
        if (s4 != null)
        {
            k1.d.put("birthday", s4);
        }
        if (s1 != null)
        {
            k1.d.put("accessToken", s1);
        }
        k1.i = true;
        return a(k1);
    }

    public static o a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            long l1, Boolean boolean1)
    {
        k k1 = a("/v2/user/gplus/login", m.b, true);
        k1.d.put("id", s);
        k1.d.put("accessToken", s1);
        k1.d.put("email", s2);
        k1.d.put("firstName", s5);
        k1.d.put("lastName", s6);
        k1.d.put("requestedPassword", s7);
        k1.d.put("automaticLogin", boolean1);
        k1.d.put("app", com.smule.android.network.core.b.b());
        if (s3 != null)
        {
            k1.d.put("gender", s3);
        }
        if (s4 != null)
        {
            k1.d.put("birthday", s4);
        }
        if (l1 != 0L)
        {
            k1.d.put("playerId", Long.valueOf(l1));
        }
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            Integer integer, Integer integer1, String s8, long l1, Boolean boolean1, String s9)
    {
        k k1 = a("/v2/fb/login", m.b, true);
        k1.d.put("afbId", s);
        k1.d.put("fbAppId", com.smule.android.network.core.b.d().a());
        k1.d.put("tfb", s9);
        k1.d.put("accessToken", s1);
        if (!TextUtils.isEmpty(s2) && TextUtils.isEmpty(s3))
        {
            k1.d.put("fbEmail", s2);
        }
        if (TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            k1.d.put("enteredEmail", s3);
        }
        k1.d.put("requestedPassword", s8);
        k1.d.put("automaticLogin", boolean1);
        k1.d.put("app", com.smule.android.network.core.b.b());
        k1.d.put("firstName", s4);
        k1.d.put("lastName", s5);
        if (s6 != null)
        {
            k1.d.put("gender", s6);
        }
        if (s7 != null)
        {
            k1.d.put("birthday", s7);
        }
        if (integer != null)
        {
            k1.d.put("minAge", integer);
        }
        if (integer1 != null)
        {
            k1.d.put("maxAge", integer1);
        }
        if (l1 != 0L)
        {
            k1.d.put("playerId", Long.valueOf(l1));
        }
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o a(boolean flag, long l1)
    {
        k k1 = a("/v2/user/guestLogin", m.a, true);
        k1.d.put("automaticLogin", Boolean.valueOf(true));
        k1.d.put("forceNewPlayer", Boolean.valueOf(flag));
        if (l1 != 0L)
        {
            k1.d.put("playerId", Long.valueOf(l1));
        }
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o b()
    {
        k k1 = a("/v2/user/gplus/disconnect", m.a);
        k1.f = true;
        return a(k1);
    }

    public static o b(String s)
    {
        k k1 = a("/v2/user/password/reset", m.a);
        k1.d = new HashMap();
        k1.d.put("email", s);
        return a(k1);
    }

    public static o b(boolean flag, long l1)
    {
        k k1 = a("/v2/user/device/login", m.a, true);
        k1.d.put("automaticLogin", Boolean.valueOf(flag));
        k1.d.put("vorgom", Boolean.valueOf(t.a()));
        if (l1 != 0L)
        {
            k1.d.put("playerId", Long.valueOf(l1));
        }
        k1.d.put("tzOffset", Integer.valueOf(e()));
        k1.i = true;
        return a(k1);
    }

    public static o c()
    {
        k k1 = a("/v2/user/init", m.a);
        k1.i = true;
        k1.d = new HashMap();
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        hashmap.put("uuid", com.smule.android.network.core.b.d().d());
        hashmap.put("uuidType", "androidid");
        arraylist.add(hashmap);
        hashmap = new HashMap();
        hashmap.put("uuid", com.smule.android.network.core.b.d().d());
        hashmap.put("uuidType", "tapjoy");
        arraylist.add(hashmap);
        hashmap = new HashMap();
        String s = com.smule.android.network.core.b.d().a(false);
        if (s != null)
        {
            hashmap.put("uuid", s);
            hashmap.put("uuidType", "advertid");
            arraylist.add(hashmap);
        }
        k1.d.put("uuids", arraylist);
        k1.i = true;
        return a(k1);
    }

    public static o d()
    {
        k k1 = a("/v2/user/device/lookup", m.a);
        k1.f = true;
        k1.i = true;
        return a(k1);
    }

    private static int e()
    {
        return TimeZone.getDefault().getRawOffset() / 1000;
    }

}
