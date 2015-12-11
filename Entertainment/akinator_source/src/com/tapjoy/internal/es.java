// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.tapjoy.internal:
//            fn, er, fk

class es
    implements Runnable
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tapjoy/internal/es$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("GET", 0);
            b = new a("GET_CONSUME", 1);
            c = new a("POST", 2);
            d = new a("POST_CONSUME", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String f = com/tapjoy/internal/es.getName();
    private final a a;
    final fn b;
    final String c;
    final er d;
    private final fk e;

    public es(AndroidHttpClient androidhttpclient, a a1, String s, er er1, Map map, fk fk1)
    {
        b = new fn(androidhttpclient);
        b.a(map);
        a = a1;
        c = s;
        d = er1;
        e = fk1;
    }

    public fk.c a()
    {
        return b.f();
    }

    public final int b()
    {
        if (b.d() != null)
        {
            return b.d().getStatusLine().getStatusCode();
        } else
        {
            return 0;
        }
    }

    public final void c()
    {
        b.c();
    }

    public void run()
    {
        long l;
        String s = f;
        (new StringBuilder("starting retrieval: ")).append(c);
        l = -1L;
        if (a != a.a && a != a.b) goto _L2; else goto _L1
_L1:
        l = b.a((new StringBuilder()).append(c).append("?").append(d.b()).toString());
_L8:
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        Log.w(f, (new StringBuilder("failed to retrieve from ")).append(b.b()).toString());
        if (e != null)
        {
            e.a(b.f());
        }
_L6:
        return;
_L2:
        if (a == a.c || a == a.d)
        {
            l = b.a(c, d.c());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        String s1 = f;
        (new StringBuilder("retrieved: ")).append(b.a());
        if (l != 200L)
        {
            Log.w(f, (new StringBuilder("error (")).append(l).append(") status on request to ").append(b.b()).toString());
            return;
        }
        if (a != a.b && a != a.d) goto _L6; else goto _L5
_L5:
        String s2 = f;
        b.e();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
