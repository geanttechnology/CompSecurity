// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.b;


// Referenced classes of package com.target.mothership.services.f.b:
//            d, c, b

public class com.target.mothership.services.f.b.a
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a AKQA;
        public static final a Apigee;
        public static final a ApigeePciSecure;
        public static final a ApigeeSecure;
        public static final a BAZAAR_VOICE;
        public static final a Cartwheel;
        public static final a Codebroker;
        public static final a GoogleAds;
        public static final a Lists;
        public static final a Pluck;
        public static final a PrzSecure;
        public static final a Scene7;
        public static final a ShopLocal;
        public static final a TGTAppData;
        public static final a TGTAppDataApi;
        public static final a TGTAppDataSecure;
        public static final a TGTFiles;
        public static final a TWS;
        public static final a Typeahead;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/mothership/services/f/b/a$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Apigee = new a("Apigee", 0);
            ApigeeSecure = new a("ApigeeSecure", 1);
            ApigeePciSecure = new a("ApigeePciSecure", 2);
            ShopLocal = new a("ShopLocal", 3);
            TGTFiles = new a("TGTFiles", 4);
            Scene7 = new a("Scene7", 5);
            AKQA = new a("AKQA", 6);
            Pluck = new a("Pluck", 7);
            Codebroker = new a("Codebroker", 8);
            TGTAppData = new a("TGTAppData", 9);
            TGTAppDataSecure = new a("TGTAppDataSecure", 10);
            TGTAppDataApi = new a("TGTAppDataApi", 11);
            Typeahead = new a("Typeahead", 12);
            Cartwheel = new a("Cartwheel", 13);
            Lists = new a("Lists", 14);
            PrzSecure = new a("PrzSecure", 15);
            TWS = new a("TWS", 16);
            BAZAAR_VOICE = new a("BAZAAR_VOICE", 17);
            GoogleAds = new a("GoogleAds", 18);
            $VALUES = (new a[] {
                Apigee, ApigeeSecure, ApigeePciSecure, ShopLocal, TGTFiles, Scene7, AKQA, Pluck, Codebroker, TGTAppData, 
                TGTAppDataSecure, TGTAppDataApi, Typeahead, Cartwheel, Lists, PrzSecure, TWS, BAZAAR_VOICE, GoogleAds
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public com.target.mothership.services.f.b.a()
    {
    }

    public static com.target.mothership.services.f.b.a a(int i1)
    {
        switch (i1)
        {
        default:
            throw new RuntimeException("invalid HostEnvironment specified");

        case 2: // '\002'
            return new d();

        case 3: // '\003'
            return new c();

        case 1: // '\001'
            return new b();
        }
    }

    protected String a()
    {
        return "http://api.target.com";
    }

    public String a(a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[];

            static 
            {
                $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Apigee.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.ApigeeSecure.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.ApigeePciSecure.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.ShopLocal.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.TGTFiles.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Scene7.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.AKQA.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Pluck.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Codebroker.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.TGTAppData.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.TGTAppDataSecure.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.TGTAppDataApi.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Typeahead.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Cartwheel.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.Lists.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.PrzSecure.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.TWS.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.BAZAAR_VOICE.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$services$url$hosts$BaseHostProvider$Host[a.GoogleAds.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.services.url.hosts.BaseHostProvider.Host[a1.ordinal()])
        {
        default:
            throw new IllegalArgumentException("Unknown host");

        case 1: // '\001'
            return a();

        case 2: // '\002'
            return b();

        case 3: // '\003'
            return c();

        case 4: // '\004'
            return d();

        case 5: // '\005'
            return e();

        case 6: // '\006'
            return f();

        case 7: // '\007'
            return g();

        case 8: // '\b'
            return h();

        case 9: // '\t'
            return i();

        case 10: // '\n'
            return j();

        case 11: // '\013'
            return k();

        case 12: // '\f'
            return l();

        case 13: // '\r'
            return m();

        case 14: // '\016'
            return n();

        case 15: // '\017'
            return o();

        case 16: // '\020'
            return p();

        case 17: // '\021'
            return q();

        case 18: // '\022'
            return r();

        case 19: // '\023'
            return s();
        }
    }

    protected String b()
    {
        return "https://api.target.com";
    }

    protected String c()
    {
        return "https://secure-api.target.com";
    }

    protected String d()
    {
        return "http://api.shoplocal.com";
    }

    protected String e()
    {
        return "http://tgtfiles.target.com";
    }

    protected String f()
    {
        return "http://target.scene7.com";
    }

    protected String g()
    {
        return "http://weeklyad.target.com";
    }

    protected String h()
    {
        return "http://community.target.com";
    }

    protected String i()
    {
        return "https://codebroker.mobi";
    }

    protected String j()
    {
        return "http://www.tgtappdata.com";
    }

    protected String k()
    {
        return "https://www.tgtappdata.com";
    }

    protected String l()
    {
        return "http://api.tgtappdata.com";
    }

    protected String m()
    {
        return "http://typeahead.target.com";
    }

    protected String n()
    {
        return "https://cartwheelws-secure.target.com/ssa/cwlservice/api";
    }

    protected String o()
    {
        return "https://api.target.com";
    }

    protected String p()
    {
        return "https://prz-secure.target.com";
    }

    protected String q()
    {
        return "http://tws.target.com";
    }

    protected String r()
    {
        return "https://api.bazaarvoice.com";
    }

    protected String s()
    {
        return "http://pubads.g.doubleclick.net";
    }
}
