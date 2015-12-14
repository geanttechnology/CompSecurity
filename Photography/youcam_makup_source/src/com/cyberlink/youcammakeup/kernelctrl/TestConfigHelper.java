// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            c, af

public class TestConfigHelper extends c
{

    public TestConfigHelper()
    {
    }

    public static TestConfigHelper h()
    {
        return af.a();
    }

    public String a()
    {
        return "test.config";
    }

    public String a(Configs configs)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Configs.values().length];
                try
                {
                    a[Configs.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Configs.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Configs.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Configs.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[configs.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return Boolean.toString(false);

        case 2: // '\002'
            return "";

        case 3: // '\003'
            return Boolean.toString(false);

        case 4: // '\004'
            return Boolean.toString(false);
        }
    }

    public volatile String a(Enum enum)
    {
        return a((Configs)enum);
    }

    public void a(String s)
    {
        super.b(Configs.b, s);
    }

    public void a(boolean flag)
    {
        super.b(Configs.a, flag);
    }

    public Class b()
    {
        return com/cyberlink/youcammakeup/kernelctrl/TestConfigHelper$Configs;
    }

    public void b(boolean flag)
    {
        super.b(Configs.c, flag);
    }

    public void c(boolean flag)
    {
        super.b(Configs.d, flag);
    }

    public boolean i()
    {
        return super.a(Configs.a, false);
    }

    public String j()
    {
        return super.a(Configs.b, "");
    }

    public boolean k()
    {
        return super.a(Configs.c, false);
    }

    public boolean l()
    {
        return super.a(Configs.d, false);
    }

    public void m()
    {
        super.e();
    }

    private class Configs extends Enum
    {

        public static final Configs a;
        public static final Configs b;
        public static final Configs c;
        public static final Configs d;
        private static final Configs e[];

        public static Configs valueOf(String s)
        {
            return (Configs)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/TestConfigHelper$Configs, s);
        }

        public static Configs[] values()
        {
            return (Configs[])e.clone();
        }

        static 
        {
            a = new Configs("IsUseTestServer", 0);
            b = new Configs("Country", 1);
            c = new Configs("SkuBypassDateCheck", 2);
            d = new Configs("testUpgradeFailed", 3);
            e = (new Configs[] {
                a, b, c, d
            });
        }

        private Configs(String s, int i1)
        {
            super(s, i1);
        }
    }

}
