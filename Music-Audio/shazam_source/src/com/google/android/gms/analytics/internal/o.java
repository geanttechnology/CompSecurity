// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak, r, g, ah, 
//            j

public class o
{

    public final r i;

    public o(r r1)
    {
        w.a(r1);
        i = r1;
    }

    private static String a(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if (obj instanceof Boolean)
        {
            if (obj == Boolean.TRUE)
            {
                return "true";
            } else
            {
                return "false";
            }
        }
        if (obj instanceof Throwable)
        {
            return ((Throwable)obj).toString();
        } else
        {
            return obj.toString();
        }
    }

    protected static String a(String s, Object obj, Object obj1, Object obj2)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        String s2 = a(obj);
        obj1 = a(obj1);
        obj2 = a(obj2);
        StringBuilder stringbuilder = new StringBuilder();
        s = "";
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append(s1);
            s = ": ";
        }
        obj = s;
        if (!TextUtils.isEmpty(s2))
        {
            stringbuilder.append(s);
            stringbuilder.append(s2);
            obj = ", ";
        }
        s = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            stringbuilder.append(((String) (obj)));
            stringbuilder.append(((String) (obj1)));
            s = ", ";
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            stringbuilder.append(s);
            stringbuilder.append(((String) (obj2)));
        }
        return stringbuilder.toString();
    }

    protected static void j()
    {
        if (f.a)
        {
            throw new IllegalStateException("Call only supported on the client side");
        } else
        {
            return;
        }
    }

    public static boolean m()
    {
        return Log.isLoggable((String)ak.c.a(), 2);
    }

    void a(int i1, String s, Object obj, Object obj1, Object obj2)
    {
        g g1 = null;
        if (i != null)
        {
            g1 = i.e;
        }
        if (g1 != null)
        {
            g1.a(i1, s, obj, obj1, obj2);
        } else
        {
            String s1 = (String)ak.c.a();
            if (Log.isLoggable(s1, i1))
            {
                Log.println(i1, s1, a(s, obj, obj1, obj2));
                return;
            }
        }
    }

    public final void a(String s, Object obj)
    {
        a(2, s, obj, null, null);
    }

    public final void a(String s, Object obj, Object obj1)
    {
        a(2, s, obj, obj1, null);
    }

    public final void b(String s)
    {
        a(2, s, null, null, null);
    }

    public final void b(String s, Object obj)
    {
        a(3, s, obj, null, null);
    }

    public final void b(String s, Object obj, Object obj1)
    {
        a(3, s, obj, obj1, null);
    }

    public final void c(String s)
    {
        a(3, s, null, null, null);
    }

    public final void c(String s, Object obj)
    {
        a(4, s, obj, null, null);
    }

    public final void c(String s, Object obj, Object obj1)
    {
        a(5, s, obj, obj1, null);
    }

    public final void d(String s)
    {
        a(4, s, null, null, null);
    }

    public final void d(String s, Object obj)
    {
        a(5, s, obj, null, null);
    }

    public final void d(String s, Object obj, Object obj1)
    {
        a(6, s, obj, obj1, null);
    }

    public final void e(String s)
    {
        a(5, s, null, null, null);
    }

    public final void e(String s, Object obj)
    {
        a(6, s, obj, null, null);
    }

    public final void f(String s)
    {
        a(6, s, null, null, null);
    }

    protected final ah k()
    {
        r r1 = i;
        r.a(r1.f);
        return r1.f;
    }

    protected final j l()
    {
        r r1 = i;
        r.a(r1.g);
        return r1.g;
    }
}
