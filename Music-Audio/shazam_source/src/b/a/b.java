// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import b.a.b.a;
import b.a.b.c;
import b.a.b.j;
import com.google.b.x;
import java.util.TimeZone;

public abstract class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    private static final b f[];

    private b(String s, int i)
    {
        super(s, i);
    }

    b(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(b/a/b, s);
    }

    public static b[] values()
    {
        return (b[])f.clone();
    }

    public abstract x a(TimeZone timezone);

    static 
    {
        a = new b("unixTimeMillis") {

            final x a(TimeZone timezone)
            {
                return new j(new b.a.b.b(true));
            }

        };
        b = new b("unixTimeSeconds") {

            final x a(TimeZone timezone)
            {
                return new j(new c(true));
            }

        };
        c = new b("unixTimePositiveMillis") {

            final x a(TimeZone timezone)
            {
                return new j(new b.a.b.b(false));
            }

        };
        d = new b("unixTimePositiveSeconds") {

            final x a(TimeZone timezone)
            {
                return new j(new c(false));
            }

        };
        e = new b("rfc3339") {

            final x a(TimeZone timezone)
            {
                return new j(new a(timezone));
            }

        };
        f = (new b[] {
            a, b, c, d, e
        });
    }
}
