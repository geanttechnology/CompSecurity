// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            MakeupMode

public abstract class BeautyMode extends Enum
{

    public static final BeautyMode A;
    public static final BeautyMode B;
    public static final BeautyMode C;
    public static final BeautyMode D;
    private static final BeautyMode E[];
    public static final BeautyMode a;
    public static final BeautyMode b;
    public static final BeautyMode c;
    public static final BeautyMode d;
    public static final BeautyMode e;
    public static final BeautyMode f;
    public static final BeautyMode g;
    public static final BeautyMode h;
    public static final BeautyMode i;
    public static final BeautyMode j;
    public static final BeautyMode k;
    public static final BeautyMode l;
    public static final BeautyMode m;
    public static final BeautyMode n;
    public static final BeautyMode o;
    public static final BeautyMode p;
    public static final BeautyMode q;
    public static final BeautyMode r;
    public static final BeautyMode s;
    public static final BeautyMode t;
    public static final BeautyMode u;
    public static final BeautyMode v;
    public static final BeautyMode w;
    public static final BeautyMode x;
    public static final BeautyMode y;
    public static final BeautyMode z;

    private BeautyMode(String s1, int i1)
    {
        super(s1, i1);
    }


    public static boolean a(BeautyMode beautymode)
    {
        class _cls31
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.g.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[BeautyMode.f.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[BeautyMode.p.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[BeautyMode.o.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[BeautyMode.h.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[BeautyMode.d.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[BeautyMode.c.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[BeautyMode.w.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[BeautyMode.u.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[BeautyMode.e.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[BeautyMode.q.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[BeautyMode.a.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[BeautyMode.b.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[BeautyMode.j.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[BeautyMode.k.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[BeautyMode.l.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[BeautyMode.n.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[BeautyMode.r.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[BeautyMode.s.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[BeautyMode.t.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.v.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.y.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.z.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls31.a[beautymode.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            return true;
        }
    }

    public static boolean b(BeautyMode beautymode)
    {
        switch (_cls31.a[beautymode.ordinal()])
        {
        default:
            return false;

        case 10: // '\n'
        case 11: // '\013'
            return true;
        }
    }

    public static MakeupMode c(BeautyMode beautymode)
    {
        switch (_cls31.a[beautymode.ordinal()])
        {
        default:
            return MakeupMode.g;

        case 1: // '\001'
        case 2: // '\002'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
            return MakeupMode.c;

        case 3: // '\003'
        case 4: // '\004'
        case 9: // '\t'
        case 11: // '\013'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
            return MakeupMode.d;

        case 8: // '\b'
        case 22: // '\026'
            return MakeupMode.e;

        case 23: // '\027'
        case 24: // '\030'
            return MakeupMode.b;

        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
            return MakeupMode.f;
        }
    }

    public static boolean d(BeautyMode beautymode)
    {
        return c(beautymode) == MakeupMode.f;
    }

    public static boolean e(BeautyMode beautymode)
    {
        return c(beautymode) == MakeupMode.c;
    }

    public static boolean f(BeautyMode beautymode)
    {
        return c(beautymode) == MakeupMode.d;
    }

    public static boolean g(BeautyMode beautymode)
    {
        return c(beautymode) == MakeupMode.e;
    }

    public static boolean h(BeautyMode beautymode)
    {
        return c(beautymode) == MakeupMode.b;
    }

    public static BeautyMode valueOf(String s1)
    {
        return (BeautyMode)Enum.valueOf(com/cyberlink/youcammakeup/utility/BeautyMode, s1);
    }

    public static BeautyMode[] values()
    {
        return (BeautyMode[])E.clone();
    }

    public abstract String a();

    static 
    {
        a = new BeautyMode("BLUSH", 0) {

            public String a()
            {
                return "Blush";
            }

        };
        b = new BeautyMode("SKIN_TONER", 1) {

            public String a()
            {
                return "Skin Toner";
            }

        };
        c = new BeautyMode("SHINE_REMOVAL", 2) {

            public String a()
            {
                return "Shine Removal";
            }

        };
        d = new BeautyMode("SKIN_SMOOTHER", 3) {

            public String a()
            {
                return "Skin Smoother";
            }

        };
        e = new BeautyMode("BLEMISH_REMOVAL", 4) {

            public String a()
            {
                return "Blemish";
            }

        };
        f = new BeautyMode("CONTOUR_NOSE", 5) {

            public String a()
            {
                return "Contour-Nose";
            }

        };
        g = new BeautyMode("CONTOUR_FACE", 6) {

            public String a()
            {
                return "Contour-Face";
            }

        };
        h = new BeautyMode("FACE_RESHAPER", 7) {

            public String a()
            {
                return "Face Shaper";
            }

        };
        i = new BeautyMode("FACE_RESHAPER_MANUAL", 8) {

            public String a()
            {
                return "Face Shaper Manual";
            }

        };
        j = new BeautyMode("FACE_ART", 9) {

            public String a()
            {
                return "Face Art";
            }

        };
        k = new BeautyMode("MUSTACHE", 10) {

            public String a()
            {
                return "Mustache";
            }

        };
        l = new BeautyMode("EYE_LINES", 11) {

            public String a()
            {
                return "Eye Line";
            }

        };
        m = new BeautyMode("EYE_LASHES", 12) {

            public String a()
            {
                return "Eye Lash";
            }

        };
        n = new BeautyMode("EYE_SHADOW", 13) {

            public String a()
            {
                return "Eye Shadow";
            }

        };
        o = new BeautyMode("EYE_ENLARGER", 14) {

            public String a()
            {
                return "Enlarge Eye";
            }

        };
        p = new BeautyMode("EYE_BAG_REMOVAL", 15) {

            public String a()
            {
                return "Eye Bag";
            }

        };
        q = new BeautyMode("RED_EYE_REMOVAL", 16) {

            public String a()
            {
                return "Red Eye";
            }

        };
        r = new BeautyMode("EYE_BROW", 17) {

            public String a()
            {
                return "Eye Brow";
            }

        };
        s = new BeautyMode("EYE_CONTACT", 18) {

            public String a()
            {
                return "Eye Contact";
            }

        };
        t = new BeautyMode("DOUBLE_EYELID", 19) {

            public String a()
            {
                return "Double Eyelid";
            }

        };
        u = new BeautyMode("EYE_SPARKLE", 20) {

            public String a()
            {
                return "Eye Sparkle";
            }

        };
        v = new BeautyMode("LIP_STICK", 21) {

            public String a()
            {
                return "Lip Stick";
            }

        };
        w = new BeautyMode("TEETH_WHITENER", 22) {

            public String a()
            {
                return "Tooth Brush";
            }

        };
        x = new BeautyMode("WIG", 23) {

            public String a()
            {
                return "Hair";
            }

        };
        y = new BeautyMode("HAIR_DYE", 24) {

            public String a()
            {
                return "Hair Dye";
            }

        };
        z = new BeautyMode("EYE_WEAR", 25) {

            public String a()
            {
                return "Eyewear";
            }

        };
        A = new BeautyMode("HAIR_BAND", 26) {

            public String a()
            {
                return "Head band";
            }

        };
        B = new BeautyMode("NECKLACE", 27) {

            public String a()
            {
                return "Necklace";
            }

        };
        C = new BeautyMode("EARRINGS", 28) {

            public String a()
            {
                return "Earrings";
            }

        };
        D = new BeautyMode("UNDEFINED", 29) {

            public String a()
            {
                return "Undefined";
            }

        };
        E = (new BeautyMode[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D
        });
    }
}
