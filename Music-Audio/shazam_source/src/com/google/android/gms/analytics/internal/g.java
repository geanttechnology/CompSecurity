// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, o, r, ad, 
//            q, j, ak, c

public class g extends p
{

    private static String a = "3";
    private static String b = "01VDIWEA?";
    private static g c;

    public g(r r1)
    {
        super(r1);
    }

    private static String a(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof Integer)
        {
            obj = new Long(((Integer)obj).intValue());
        }
        if (obj instanceof Long)
        {
            if (Math.abs(((Long)obj).longValue()) < 100L)
            {
                return String.valueOf(obj);
            }
            String s;
            StringBuilder stringbuilder;
            if (String.valueOf(obj).charAt(0) == '-')
            {
                s = "-";
            } else
            {
                s = "";
            }
            obj = String.valueOf(Math.abs(((Long)obj).longValue()));
            stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(Math.round(Math.pow(10D, ((String) (obj)).length() - 1)));
            stringbuilder.append("...");
            stringbuilder.append(s);
            stringbuilder.append(Math.round(Math.pow(10D, ((String) (obj)).length()) - 1.0D));
            return stringbuilder.toString();
        }
        if (obj instanceof Boolean)
        {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable)
        {
            return obj.getClass().getCanonicalName();
        } else
        {
            return "-";
        }
    }

    public static g b()
    {
        return c;
    }

    private void b(int i, String s, Object obj, Object obj1, Object obj2)
    {
        this;
        JVM INSTR monitorenter ;
        w.a(s);
        if (i < 0)
        {
            i = 0;
        }
        if (i >= b.length())
        {
            i = b.length() - 1;
        }
        if (!super.i.d.a()) goto _L2; else goto _L1
_L1:
        char c1;
        long l;
        if (f.a)
        {
            c1 = 'P';
        } else
        {
            c1 = 'C';
        }
_L9:
        obj = (new StringBuilder()).append(a).append(b.charAt(i)).append(c1).append(q.a).append(":").append(a(s, a(obj), a(obj1), a(obj2))).toString();
        s = ((String) (obj));
        if (((String) (obj)).length() > 1024)
        {
            s = ((String) (obj)).substring(0, 1024);
        }
        obj = super.i;
        if (((r) (obj)).g != null && ((r) (obj)).g.n()) goto _L4; else goto _L3
_L10:
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((j) (obj)).b;
        if (((j.a) (obj)).b() == 0L)
        {
            ((j.a) (obj)).a();
        }
        break MISSING_BLOCK_LABEL_410;
_L11:
        obj;
        JVM INSTR monitorenter ;
        l = ((j.a) (obj)).b.a.getLong(((j.a) (obj)).c(), 0L);
        if (l > 0L) goto _L8; else goto _L7
_L7:
        obj1 = ((j.a) (obj)).b.a.edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putString(((j.a) (obj)).d(), s);
        ((android.content.SharedPreferences.Editor) (obj1)).putLong(((j.a) (obj)).c(), 1L);
        ((android.content.SharedPreferences.Editor) (obj1)).apply();
        obj;
        JVM INSTR monitorexit ;
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (f.a)
        {
            c1 = 'p';
        } else
        {
            c1 = 'c';
        }
          goto _L9
_L4:
        obj = ((r) (obj)).g;
          goto _L10
_L8:
        if ((UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL) < 0x7fffffffffffffffL / (1L + l))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj1 = ((j.a) (obj)).b.a.edit();
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        ((android.content.SharedPreferences.Editor) (obj1)).putString(((j.a) (obj)).d(), s);
        ((android.content.SharedPreferences.Editor) (obj1)).putLong(((j.a) (obj)).c(), l + 1L);
        ((android.content.SharedPreferences.Editor) (obj1)).apply();
        obj;
        JVM INSTR monitorexit ;
          goto _L6
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L3:
        obj = null;
          goto _L10
        if (s == null)
        {
            s = "";
        }
          goto _L11
    }

    protected final void a()
    {
        com/google/android/gms/analytics/internal/g;
        JVM INSTR monitorenter ;
        c = this;
        com/google/android/gms/analytics/internal/g;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/google/android/gms/analytics/internal/g;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, String s, Object obj, Object obj1, Object obj2)
    {
        String s1 = (String)ak.c.a();
        if (Log.isLoggable(s1, i))
        {
            Log.println(i, s1, a(s, obj, obj1, obj2));
        }
        if (i >= 5)
        {
            b(i, s, obj, obj1, obj2);
        }
    }

    public final void a(c c1, String s)
    {
        if (c1 != null)
        {
            c1 = c1.toString();
        } else
        {
            c1 = "no hit data";
        }
        d((new StringBuilder("Discarding hit. ")).append(s).toString(), c1);
    }

    public final void a(Map map, String s)
    {
        if (map != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append((String)entry.getKey());
                stringbuilder.append('=');
            }

            map = stringbuilder.toString();
        } else
        {
            map = "no hit data";
        }
        d((new StringBuilder("Discarding hit. ")).append(s).toString(), map);
    }

}
