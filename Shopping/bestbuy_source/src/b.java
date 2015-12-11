// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.UUID;

public class b
{

    final String a;
    final Context b;
    final String c;
    final String d;
    final boolean e;
    final f f;
    final boolean g;

    b(String s, Context context, String s1, String s2, boolean flag, f f1, boolean flag1)
    {
        a = s;
        b = context;
        c = s1;
        d = s2;
        e = flag;
        f = f1;
        g = flag1;
    }

    public static c a()
    {
        return new c();
    }

    // Unreferenced inner class b$1

/* anonymous class */
    public class _cls1
    {

        private final x a;
        private final String b;
        private long c;

        public String a()
        {
            return a.b("mobileAgentToken", "-1");
        }

        public void a(long l)
        {
            if (b != null)
            {
                a.a("buildId", b);
            }
            a.a("info_point_version", l);
            a.a("info_point_version_counter", 0L);
        }

        public void a(String s)
        {
            a.a("mobileAgentToken", s);
        }

        public void a(boolean flag)
        {
            a.a("infoPointSafetyFlag", flag);
        }

        public String b()
        {
            String s1 = a.b("agentIdentifier", null);
            String s = s1;
            if (s1 == null)
            {
                s = UUID.randomUUID().toString();
                a.a("agentIdentifier", s);
            }
            return s;
        }

        void b(long l)
        {
            if (c == -1L)
            {
                c = a.b("event_counter", 0L);
            }
            c = c + l;
            a.a("event_counter", c);
        }

        public boolean c()
        {
            return e() != -1L;
        }

        public long d()
        {
            long l = a.b("info_point_version_counter", 0L);
            x x1 = a;
            l++;
            x1.a("info_point_version_counter", l);
            return l;
        }

        public long e()
        {
            long l = -1L;
            boolean flag;
            if (b != null && b.equals(a.b("buildId", "")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                l = a.b("info_point_version", -1L);
            }
            return l;
        }

        public long f()
        {
            if (c == -1L)
            {
                c = a.b("event_counter", 0L);
            }
            c = c + 1L;
            a.a("event_counter", c);
            return c;
        }

        long g()
        {
            if (c == -1L)
            {
                return 0L;
            } else
            {
                c = c + 1L;
                return c;
            }
        }

        public boolean h()
        {
            return a.b("infoPointSafetyFlag", false);
        }

            public 
            {
                this(new x(context), s);
            }

            public 
            {
                c = -1L;
                a = x1;
                b = s;
            }
    }

}
