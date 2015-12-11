// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Intent;
import com.facebook.d;
import com.facebook.k;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            kc

public final class jn
    implements d
{
    public static interface a
    {

        public abstract boolean a(int i, Intent intent);
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        private static final b j[];
        private final int i;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(android/support/v7/jn$b, s);
        }

        public static b[] values()
        {
            return (b[])j.clone();
        }

        public int a()
        {
            return k.m() + i;
        }

        static 
        {
            a = new b("Login", 0, 0);
            b = new b("Share", 1, 1);
            c = new b("Message", 2, 2);
            d = new b("Like", 3, 3);
            e = new b("GameRequest", 4, 4);
            f = new b("AppGroupCreate", 5, 5);
            g = new b("AppGroupJoin", 6, 6);
            h = new b("AppInvite", 7, 7);
            j = (new b[] {
                a, b, c, d, e, f, g, h
            });
        }

        private b(String s, int l, int i1)
        {
            super(s, l);
            i = i1;
        }
    }


    private static Map a = new HashMap();
    private Map b;

    public jn()
    {
        b = new HashMap();
    }

    private static a a(Integer integer)
    {
        android/support/v7/jn;
        JVM INSTR monitorenter ;
        integer = (a)a.get(integer);
        android/support/v7/jn;
        JVM INSTR monitorexit ;
        return integer;
        integer;
        throw integer;
    }

    public static void a(int i, a a1)
    {
        android/support/v7/jn;
        JVM INSTR monitorenter ;
        boolean flag;
        kc.a(a1, "callback");
        flag = a.containsKey(Integer.valueOf(i));
        if (!flag) goto _L2; else goto _L1
_L1:
        android/support/v7/jn;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.put(Integer.valueOf(i), a1);
        if (true) goto _L1; else goto _L3
_L3:
        a1;
        throw a1;
    }

    private static boolean b(int i, int j, Intent intent)
    {
        a a1 = a(Integer.valueOf(i));
        if (a1 != null)
        {
            return a1.a(j, intent);
        } else
        {
            return false;
        }
    }

    public boolean a(int i, int j, Intent intent)
    {
        a a1 = (a)b.get(Integer.valueOf(i));
        if (a1 != null)
        {
            return a1.a(j, intent);
        } else
        {
            return b(i, j, intent);
        }
    }

    public void b(int i, a a1)
    {
        kc.a(a1, "callback");
        b.put(Integer.valueOf(i), a1);
    }

}
