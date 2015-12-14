// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class RateOfFeaturePointAdjustment extends BaseEvent
{

    public static final CategoryName a[];
    public static Map b = null;

    public RateOfFeaturePointAdjustment()
    {
        super("Rate of feature point adjustment");
        if (b != null)
        {
            a(new HashMap(b));
        }
    }

    public static CategoryName a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.O.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T.ordinal()] = 43;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U.ordinal()] = 44;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V.ordinal()] = 45;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W.ordinal()] = 46;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[featurepoints.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            return CategoryName.a;

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return CategoryName.b;

        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
            return CategoryName.c;

        case 19: // '\023'
        case 20: // '\024'
            return CategoryName.d;

        case 21: // '\025'
            return CategoryName.e;

        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            return CategoryName.f;

        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
            return CategoryName.g;
        }
    }

    public static void a(CategoryName categoryname, Boolean boolean1)
    {
        if (b != null)
        {
            b.put(categoryname.toString(), String.valueOf(boolean1));
        }
    }

    public static void a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, Boolean boolean1)
    {
        if (b != null)
        {
            featurepoints = a(featurepoints);
            if (featurepoints != null)
            {
                a(((CategoryName) (featurepoints)), boolean1);
            }
        }
    }

    public static void c()
    {
        b = new HashMap();
        CategoryName acategoryname[] = a;
        int j = acategoryname.length;
        for (int i = 0; i < j; i++)
        {
            a(acategoryname[i], Boolean.valueOf(false));
        }

    }

    static 
    {
        a = (new CategoryName[] {
            CategoryName.a, CategoryName.b, CategoryName.c, CategoryName.d, CategoryName.e, CategoryName.f, CategoryName.g
        });
        c();
    }

    private class CategoryName extends Enum
    {

        public static final CategoryName a;
        public static final CategoryName b;
        public static final CategoryName c;
        public static final CategoryName d;
        public static final CategoryName e;
        public static final CategoryName f;
        public static final CategoryName g;
        private static final CategoryName h[];

        public static CategoryName valueOf(String s)
        {
            return (CategoryName)Enum.valueOf(com/cyberlink/youcammakeup/flurry/RateOfFeaturePointAdjustment$CategoryName, s);
        }

        public static CategoryName[] values()
        {
            return (CategoryName[])h.clone();
        }

        static 
        {
            a = new CategoryName("Eye", 0);
            b = new CategoryName("Nose", 1);
            c = new CategoryName("Shape", 2);
            d = new CategoryName("Ear", 3);
            e = new CategoryName("Chin", 4);
            f = new CategoryName("Mouth", 5);
            g = new CategoryName("EyeBrow", 6);
            h = (new CategoryName[] {
                a, b, c, d, e, f, g
            });
        }

        private CategoryName(String s, int i)
        {
            super(s, i);
        }
    }

}
