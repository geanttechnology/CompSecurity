// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            m, r, s, a, 
//            c, v

public class t
{

    private static long a = -1L;

    private static long a(String s1)
    {
        long l;
        long l1;
        long l2;
        if (!s1.contains("."))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        List list = Arrays.asList(s1.split("\\."));
        if (list.size() <= 2)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        l = Long.parseLong((String)list.get(0));
        l1 = Long.parseLong((String)list.get(1));
        l2 = Long.parseLong((String)list.get(2));
        return l2 + (l * 0x186a0L + l1 * 1000L);
        NumberFormatException numberformatexception;
        numberformatexception;
        if (m.a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Version code was not a well formated versioning string + ").append(numberformatexception).toString());
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s1.length();
        for (int i = 0; i < j; i++)
        {
            char c1 = s1.charAt(i);
            if (Character.isDigit(c1))
            {
                stringbuilder.append(c1);
            }
        }

        return Long.parseLong(stringbuilder.toString());
    }

    protected static void a(m m1, Context context)
    {
        String s1 = r.j(context);
        if (!s1.equalsIgnoreCase(m1.r()))
        {
            a(m1, context, s1, m1.r());
            r.c(m1.r(), context);
        }
_L1:
        return;
        m1;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception checking SDK upgrade: ").append(m1).toString());
            return;
        }
          goto _L1
    }

    private static void a(m m1, Context context, String s1, String s2)
    {
        long l = a(s1);
        if (l >= 459L)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" deleting old SDK Config.").toString());
        }
        s.a(context, new s());
        if (l >= 514L)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" Setting old config version to 0.").toString());
        }
        s2 = s.a(context);
        s2.a(0L);
        s.a(context, s2);
        if (l == 0L || l >= 516L)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        if (!r.a(m1, context).isEmpty())
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" with actively monitored regions. Wiping out regions, and setting delay to ignore first enter geofence.").toString());
            }
            r.a(m1, null, context);
            a = System.currentTimeMillis() / 1000L + 0x15180L;
        }
        if (l >= 550L)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" Migrating user credentials and attributes to new storage format.").toString());
        }
        m1 = r.a(context, "user_credentials", java/lang/String);
        s2 = r.a(context, "user_attributes", java/lang/String);
        r.a(m1, context);
        r.c(s2, context);
        if (l >= 556L)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" re-calculating the event object checksums.").toString());
        }
        r.a(r.a(context, true).a(), context);
        if (l >= a("2.0.0")) goto _L2; else goto _L1
_L1:
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" migrating credentials to new storage.").toString());
        }
        s2 = r.d(context);
        if (s2.isEmpty()) goto _L4; else goto _L3
_L3:
        m1 = r.e(context);
        java.util.Map.Entry entry;
        for (s2 = s2.entrySet().iterator(); s2.hasNext(); ((Set)m1.get(entry.getKey())).add(entry.getValue()))
        {
            entry = (java.util.Map.Entry)s2.next();
            if (!m1.containsKey(entry.getKey()))
            {
                m1.put(entry.getKey(), new HashSet());
            }
        }

          goto _L5
_L35:
        return;
_L5:
        r.a(null, context);
        r.b(m1, context);
_L4:
        m1 = r.a(context, true).a();
        if (m1.isEmpty()) goto _L2; else goto _L6
_L6:
        if (m.a)
        {
            Log.d("Kahuna", "Adding event numbers to all previous events.");
        }
          goto _L7
_L20:
        int i;
        if (i >= m1.size()) goto _L9; else goto _L8
_L8:
        boolean flag;
        s2 = (c)m1.get(i);
        s2.a(i + 1);
        flag = v.a(s2.d());
        if (flag) goto _L11; else goto _L10
_L10:
        Object obj;
        Object obj1;
        Object obj2;
        obj = new HashMap();
        obj1 = JSONObjectInstrumentation.init(s2.d());
        obj2 = ((JSONObject) (obj1)).keys();
_L19:
        if (!((Iterator) (obj2)).hasNext()) goto _L13; else goto _L12
_L12:
        HashSet hashset;
        String s3;
        hashset = new HashSet();
        s3 = (String)((Iterator) (obj2)).next();
        if (((JSONObject) (obj1)).optJSONArray(s3) == null) goto _L15; else goto _L14
_L14:
        JSONArray jsonarray;
        int k;
        jsonarray = ((JSONObject) (obj1)).optJSONArray(s3);
        k = jsonarray.length();
        int j = 0;
_L45:
        if (j >= k) goto _L17; else goto _L16
_L16:
        String s4 = jsonarray.optString(j);
        if (!v.a(s4))
        {
            hashset.add(s4);
        }
          goto _L18
_L15:
        hashset.add(((JSONObject) (obj1)).optString(s3));
_L17:
        ((Map) (obj)).put(s3, hashset);
          goto _L19
        s2;
        Log.e("Kahuna", (new StringBuilder()).append("Caught exception migrating old event credentials from Archive: ").append(s2).toString());
_L11:
        i++;
          goto _L20
_L13:
        s2.a(((Map) (obj)));
          goto _L11
_L9:
        r.a(m1, context);
_L2:
        if (l >= a("2.0.2"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" k_user_attributes event reording.").toString());
        }
        obj = r.g(context);
        if (v.a(((Set) (obj)))) goto _L22; else goto _L21
_L21:
        s2 = r.f(context);
        if (v.a(s2.keySet())) goto _L22; else goto _L23
_L23:
        m1 = new HashMap();
        obj = ((Set) (obj)).iterator();
_L27:
        if (!((Iterator) (obj)).hasNext()) goto _L25; else goto _L24
_L24:
        obj1 = (String)((Iterator) (obj)).next();
        obj2 = (String)s2.get(obj1);
        if (obj2 == null) goto _L27; else goto _L26
_L26:
        m1.put(obj1, obj2);
          goto _L27
_L25:
        if (m1.size() <= 0) goto _L22; else goto _L28
_L28:
        s2 = r.a(context, true).a();
        obj = new c("k_user_attributes");
        ((c) (obj)).b(m1);
        if (s2.isEmpty()) goto _L30; else goto _L29
_L29:
        m1 = (c)s2.get(s2.size() - 1);
_L47:
        if (m1 == null) goto _L32; else goto _L31
_L31:
        if (m1.k() <= 0L) goto _L32; else goto _L33
_L33:
        ((c) (obj)).a(m1.k() + 1L);
_L44:
        s2.add(obj);
        r.a(s2, context);
_L22:
        r.a(null, context);
        if (l >= a("2.0.3")) goto _L35; else goto _L34
_L34:
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Upgrading from SDK version ").append(s1).append(" remove k_auto_logout.").toString());
        }
        s1 = r.a(context, true).a();
        if (v.a(s1)) goto _L35; else goto _L36
_L36:
        long l1;
        if (m.a)
        {
            Log.d("Kahuna", "Migrating k_auto_logout events and re-adding event numbers.");
        }
        l1 = ((c)s1.get(0)).k();
        l = l1;
        if (l1 < 1L)
        {
            l = 1L;
        }
        s2 = new ArrayList();
        i = 0;
_L46:
        if (i >= s1.size()) goto _L38; else goto _L37
_L37:
        obj = (c)s1.get(i);
        if (!"k_auto_logout".equals(((c) (obj)).a())) goto _L40; else goto _L39
_L39:
        if (i + 1 >= s1.size())
        {
            break MISSING_BLOCK_LABEL_1380;
        }
        m1 = (c)s1.get(i + 1);
_L48:
        if (m1 == null) goto _L42; else goto _L41
_L41:
        if (!"k_user_login".equals(m1.a())) goto _L42; else goto _L43
_L32:
        ((c) (obj)).a(r.m(context));
          goto _L44
_L42:
        ((c) (obj)).a("k_user_login");
_L40:
        ((c) (obj)).a(l);
        s2.add(obj);
        l = 1L + l;
          goto _L43
_L38:
        try
        {
            r.a(s2, context);
            r.b(l, context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception performing upgrade script: ").append(m1).toString());
            }
        }
          goto _L35
_L7:
        i = 0;
          goto _L20
_L18:
        j++;
          goto _L45
_L43:
        i++;
          goto _L46
_L30:
        m1 = null;
          goto _L47
        m1 = null;
          goto _L48
    }

    protected static boolean a(boolean flag)
    {
        long l = System.currentTimeMillis() / 1000L;
        boolean flag2 = false;
        boolean flag1 = flag2;
        if (a > 0L)
        {
            flag1 = flag2;
            if (a > l)
            {
                flag1 = true;
            }
        }
        if (flag)
        {
            a = -1L;
        }
        return flag1;
    }

}
