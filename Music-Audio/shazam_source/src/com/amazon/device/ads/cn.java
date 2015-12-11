// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.ads:
//            ch, bc, dn

public final class cn
    implements ch
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/cn$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("DEBUG", 0);
            b = new a("ERROR", 1);
            c = new a("INFO", 2);
            d = new a("VERBOSE", 3);
            e = new a("WARN", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private int a;
    private final ch b;
    private final bc c;
    private final dn d;

    public cn(ch ch1)
    {
        this(ch1, bc.a(), dn.a());
    }

    private cn(ch ch1, bc bc1, dn dn1)
    {
        a = 1000;
        b = ch1.f("AmazonMobileAds");
        c = bc1;
        d = dn1;
    }

    private transient void a(a a1, String s, Object aobj[])
    {
        a(false, a1, s, aobj);
    }

    public final void a(String s)
    {
        a(s, null);
    }

    public final transient void a(String s, Object aobj[])
    {
        a(a.c, s, aobj);
    }

    final transient void a(boolean flag, a a1, String s, Object aobj[])
    {
        int i = 0;
        boolean flag1;
        if (b == null)
        {
            flag1 = false;
        } else
        {
            flag1 = c.a("debug.logging", Boolean.valueOf(d.a("loggingEnabled", false))).booleanValue();
        }
        if (flag1 || flag)
        {
            String s1 = s;
            if (aobj != null)
            {
                s1 = s;
                if (aobj.length > 0)
                {
                    s1 = String.format(s, aobj);
                }
            }
            int j = a;
            s = new ArrayList();
            if (s1 != null && s1.length() != 0)
            {
                while (i < s1.length()) 
                {
                    s.add(s1.substring(i, Math.min(s1.length(), i + j)));
                    i += j;
                }
            }
            s = s.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                aobj = (String)s.next();
                static final class _cls1
                {

                    static final int a[];

                    static 
                    {
                        a = new int[a.values().length];
                        try
                        {
                            a[a.a.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[a.b.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[a.c.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[a.d.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[a.e.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1.a[a1.ordinal()])
                {
                case 1: // '\001'
                    b.c(((String) (aobj)));
                    // fall through

                default:
                    if (false)
                    {
                    }
                    break;

                case 2: // '\002'
                    b.e(((String) (aobj)));
                    break;

                case 3: // '\003'
                    b.a(((String) (aobj)));
                    break;

                case 4: // '\004'
                    b.b(((String) (aobj)));
                    break;

                case 5: // '\005'
                    b.d(((String) (aobj)));
                    break;
                }
            } while (true);
        }
    }

    public final void b(String s)
    {
        a(a.d, s, null);
    }

    public final transient void b(String s, Object aobj[])
    {
        a(a.a, s, aobj);
    }

    public final void c(String s)
    {
        b(s, null);
    }

    public final transient void c(String s, Object aobj[])
    {
        a(a.e, s, aobj);
    }

    public final void d(String s)
    {
        c(s, null);
    }

    public final transient void d(String s, Object aobj[])
    {
        a(a.b, s, aobj);
    }

    public final void e(String s)
    {
        d(s, null);
    }

    public final ch f(String s)
    {
        return g(s);
    }

    public final cn g(String s)
    {
        b.f((new StringBuilder("AmazonMobileAds ")).append(s).toString());
        return this;
    }
}
