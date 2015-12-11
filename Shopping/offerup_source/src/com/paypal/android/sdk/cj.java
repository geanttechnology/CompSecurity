// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.paypal.android.sdk:
//            ck, bl, ch, bj

public abstract class cj
{

    private static final String a = com/paypal/android/sdk/cj.getSimpleName();
    private static long b = 1L;
    private final Map c = new LinkedHashMap();
    private final ck d;
    private final ch e;
    private final String f;
    private final long g;
    private String h;
    private String i;
    private bj j;
    private Integer k;
    private String l;

    public cj(ch ch, ck ck1, String s1)
    {
        long l1 = b;
        b = 1L + l1;
        g = l1;
        e = ch;
        f = s1;
        d = ck1;
    }

    public static void k()
    {
    }

    public String a(ch ch)
    {
        String s1 = d.a(ch);
        if (s1 != null)
        {
            ch = s1;
            if (f != null)
            {
                ch = (new StringBuilder()).append(s1).append(f).toString();
            }
            return ch;
        } else
        {
            throw new RuntimeException((new StringBuilder("API ")).append(ch.toString()).append(" has no record for server ").append(d.c()).toString());
        }
    }

    public final void a(bj bj)
    {
        if (j != null)
        {
            IllegalStateException illegalstateexception = new IllegalStateException("Multiple exceptions reported");
            Log.e(a, (new StringBuilder("first mError=")).append(j).toString());
            Log.e(a, (new StringBuilder("second mError=")).append(bj).toString());
            Log.e(a, "", illegalstateexception);
            throw illegalstateexception;
        } else
        {
            j = bj;
            return;
        }
    }

    public final void a(Integer integer)
    {
        k = integer;
    }

    public final void a(String s1)
    {
        h = s1;
    }

    protected final void a(String s1, String s2)
    {
        c.put(s1, s2);
    }

    public final void a(String s1, String s2, String s3)
    {
        a(((bj) (new bl(s1, s2, s3))));
    }

    public boolean a()
    {
        return false;
    }

    public abstract String b();

    public final void b(String s1)
    {
        i = s1;
    }

    public abstract void c();

    public final void c(String s1)
    {
        l = s1;
    }

    public abstract void d();

    public abstract String e();

    public final String f()
    {
        return h;
    }

    public final String g()
    {
        return i;
    }

    public final ch h()
    {
        return e;
    }

    public final Map i()
    {
        return c;
    }

    public final String j()
    {
        return l;
    }

    public void l()
    {
    }

    protected final JSONObject m()
    {
        String s1 = i;
        Object obj = (new JSONTokener(s1)).nextValue();
        if (!(obj instanceof JSONObject))
        {
            throw new JSONException((new StringBuilder("could not parse:")).append(s1).append("\nnextValue:").append(obj).toString());
        } else
        {
            return (JSONObject)obj;
        }
    }

    public final String n()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" SN:").append(g).toString();
    }

    public final long o()
    {
        return g;
    }

    public final bj p()
    {
        return j;
    }

    public final boolean q()
    {
        return j == null;
    }

    public final Integer r()
    {
        return k;
    }

    public final ck s()
    {
        return d;
    }

}
