// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKApplyEvent extends BaseEvent
{

    public static String b = "";
    public static String c = "";
    private FeatureName d;

    public YMKApplyEvent(FeatureName featurename)
    {
        super("YMK_Apply");
        d = null;
        d = featurename;
    }

    public static FeatureName a(BeautyMode beautymode)
    {
        FeatureName featurename = null;
        if (beautymode == BeautyMode.d)
        {
            featurename = FeatureName.b;
        } else
        {
            if (beautymode == BeautyMode.b)
            {
                return FeatureName.c;
            }
            if (beautymode == BeautyMode.a)
            {
                return FeatureName.d;
            }
            if (beautymode == BeautyMode.h)
            {
                return FeatureName.e;
            }
            if (beautymode == BeautyMode.g)
            {
                return FeatureName.f;
            }
            if (beautymode == BeautyMode.f)
            {
                return FeatureName.g;
            }
            if (beautymode == BeautyMode.e)
            {
                return FeatureName.h;
            }
            if (beautymode == BeautyMode.c)
            {
                return FeatureName.i;
            }
            if (beautymode == BeautyMode.l)
            {
                return FeatureName.j;
            }
            if (beautymode == BeautyMode.m)
            {
                return FeatureName.k;
            }
            if (beautymode == BeautyMode.n)
            {
                return FeatureName.l;
            }
            if (beautymode == BeautyMode.r)
            {
                return FeatureName.m;
            }
            if (beautymode == BeautyMode.s)
            {
                return FeatureName.n;
            }
            if (beautymode == BeautyMode.p)
            {
                return FeatureName.o;
            }
            if (beautymode == BeautyMode.o)
            {
                return FeatureName.p;
            }
            if (beautymode == BeautyMode.u)
            {
                return com.cyberlink.youcammakeup.clflurry.FeatureName.r;
            }
            if (beautymode == BeautyMode.q)
            {
                return FeatureName.s;
            }
            if (beautymode == BeautyMode.t)
            {
                return FeatureName.q;
            }
            if (beautymode == BeautyMode.v)
            {
                return FeatureName.t;
            }
            if (beautymode == BeautyMode.w)
            {
                return FeatureName.u;
            }
            if (beautymode == BeautyMode.x)
            {
                return FeatureName.v;
            }
            if (beautymode == BeautyMode.z)
            {
                return FeatureName.w;
            }
            if (beautymode == BeautyMode.A)
            {
                return FeatureName.x;
            }
            if (beautymode == BeautyMode.B)
            {
                return FeatureName.y;
            }
            if (beautymode == BeautyMode.C)
            {
                return FeatureName.z;
            }
            if (beautymode == BeautyMode.y)
            {
                return FeatureName.A;
            }
        }
        return featurename;
    }

    public static String a(int l)
    {
        return String.valueOf(l);
    }

    public static String a(com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType lipsticktype)
    {
        String s = null;
        if (lipsticktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
        {
            s = "bright";
        } else
        {
            if (lipsticktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
            {
                return "thick";
            }
            if (lipsticktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
            {
                return "gloss";
            }
            if (lipsticktype == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.d)
            {
                return "cherry";
            }
        }
        return s;
    }

    public static transient String a(String as[])
    {
        int i1 = as.length;
        String s = "";
        for (int l = 0; l < i1;)
        {
            String s2 = as[l];
            String s1 = s;
            if (s2 != null)
            {
                s1 = s;
                if (!s.isEmpty())
                {
                    s1 = (new StringBuilder()).append(s).append(", ").toString();
                }
                s1 = (new StringBuilder()).append(s1).append(s2).toString();
            }
            l++;
            s = s1;
        }

        return s;
    }

    public static void a(FeatureName featurename, r r1, YMKApplyEvent ymkapplyevent)
    {
        int l;
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        l = 0;
        if (r1 != null && ymkapplyevent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (featurename == FeatureName.c)
        {
            featurename = r1.e();
            if (featurename instanceof ba)
            {
                Object obj1 = (ba)featurename;
                featurename = ((ba) (obj1)).n();
                String s = ((ba) (obj1)).h();
                obj1 = ((ba) (obj1)).i();
                float f1 = r1.g();
                ymkapplyevent.b(featurename);
                ymkapplyevent.c(s);
                ymkapplyevent.d(b(new String[] {
                    obj1
                }));
                ymkapplyevent.g(String.valueOf(f1));
                return;
            } else
            {
                featurename = r1.e().i();
                float f2 = r1.g();
                ymkapplyevent.d(b(new String[] {
                    featurename
                }));
                ymkapplyevent.g(String.valueOf(f2));
                return;
            }
        }
        if (featurename != FeatureName.d && featurename != FeatureName.k && featurename != FeatureName.j && featurename != FeatureName.m && featurename != FeatureName.A)
        {
            break; /* Loop/switch isn't completed */
        }
        featurename = r1.c();
        Object obj = PanelDataCenter.a().i(featurename);
        if (obj != null)
        {
            Object obj2 = ((aw) (obj)).i();
            String as[] = new String[((List) (obj2)).size()];
            for (; l < ((List) (obj2)).size(); l++)
            {
                as[l] = ((at)((List) (obj2)).get(l)).i();
            }

            obj2 = b(as);
            String s5 = r1.b();
            float f3 = r1.g();
            if (((aw) (obj)).k() != null)
            {
                r1 = ((aw) (obj)).k();
                obj = ((aw) (obj)).a();
                ymkapplyevent.b(r1);
                ymkapplyevent.c(((String) (obj)));
            }
            ymkapplyevent.e(featurename);
            ymkapplyevent.d(((String) (obj2)));
            ymkapplyevent.f(s5);
            ymkapplyevent.g(String.valueOf(f3));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (featurename != FeatureName.n && featurename != FeatureName.v)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = r1.c();
        Object obj3 = r1.f();
        if (obj3 != null)
        {
            String as1[] = new String[((List) (obj3)).size()];
            for (int i1 = ((flag) ? 1 : 0); i1 < ((List) (obj3)).size(); i1++)
            {
                as1[i1] = ((at)((List) (obj3)).get(i1)).i();
            }

            obj3 = b(as1);
            String s6 = r1.b();
            ax ax1 = PanelDataCenter.a().p(s6);
            if (ax1 != null)
            {
                float f4;
                if (featurename == FeatureName.v)
                {
                    f4 = 100F - r1.g();
                } else
                {
                    f4 = r1.g();
                }
                if (ax1.g() != null)
                {
                    featurename = ax1.g();
                    r1 = ax1.a();
                    ymkapplyevent.b(featurename);
                    ymkapplyevent.c(r1);
                }
                ymkapplyevent.f(s6);
                ymkapplyevent.e(s1);
                ymkapplyevent.d(((String) (obj3)));
                ymkapplyevent.g(String.valueOf(f4));
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (featurename != FeatureName.l)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s2 = r1.c();
        Object obj5 = PanelDataCenter.a().i(s2);
        if (obj5 != null)
        {
            String s4 = r1.b();
            featurename = "";
            for (int j1 = 0; j1 < r1.f().size(); j1++)
            {
                featurename = a(new String[] {
                    featurename, a(((at)r1.f().get(j1)).j())
                });
            }

            if (((aw) (obj5)).k() != null)
            {
                r1 = ((aw) (obj5)).k();
                obj5 = ((aw) (obj5)).a();
                ymkapplyevent.b(r1);
                ymkapplyevent.c(((String) (obj5)));
            }
            ymkapplyevent.e(s2);
            ymkapplyevent.f(s4);
            ymkapplyevent.h(featurename);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (featurename != FeatureName.t) goto _L1; else goto _L5
_L5:
        String s3 = r1.c();
        Object obj4 = PanelDataCenter.a().i(s3);
        if (obj4 != null)
        {
            featurename = ((aw) (obj4)).i();
            String as2[] = new String[featurename.size()];
            for (int k1 = ((flag1) ? 1 : 0); k1 < featurename.size(); k1++)
            {
                as2[k1] = ((at)featurename.get(k1)).i();
            }

            String s7 = b(as2);
            String s8 = r1.b();
            ax ax2 = PanelDataCenter.a().p(s8);
            if (ax2 != null)
            {
                float f5 = r1.g();
                featurename = null;
                if (ax2.h() != null)
                {
                    featurename = a(ax2.h().b());
                }
                if (((aw) (obj4)).k() != null)
                {
                    r1 = ((aw) (obj4)).k();
                    obj4 = ((aw) (obj4)).a();
                    ymkapplyevent.b(r1);
                    ymkapplyevent.c(((String) (obj4)));
                }
                ymkapplyevent.e(s3);
                ymkapplyevent.d(s7);
                ymkapplyevent.f(s8);
                ymkapplyevent.g(String.valueOf(f5));
                ymkapplyevent.h(featurename);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void a(String s, String s1)
    {
        d();
        if (s1 != null && !s1.isEmpty())
        {
            a.put((new StringBuilder()).append(d.b()).append(s).toString(), s1);
        }
    }

    public static transient String b(String as[])
    {
        if (as == null)
        {
            return "";
        }
        ArrayList arraylist = new ArrayList();
        int i1 = as.length;
        int l = 0;
        while (l < i1) 
        {
            String s1 = as[l];
            if (s1 != null)
            {
                String s = s1;
                if (s1.length() > 6)
                {
                    s = s1.substring(s1.length() - 6, s1.length());
                }
                arraylist.add(s);
            }
            l++;
        }
        return a((String[])arraylist.toArray(new String[arraylist.size()]));
    }

    public static void j(String s)
    {
        if (s != null)
        {
            b = s;
        }
    }

    public static void k(String s)
    {
        if (s != null)
        {
            c = s;
        }
    }

    public void a(FeatureName featurename)
    {
        d = featurename;
    }

    public void a(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        a("_yn", s);
    }

    public void b(String s)
    {
        a("_sku_guid", s);
    }

    public void c(String s)
    {
        a("_item_guid", s);
    }

    protected void d()
    {
        if (a == null)
        {
            a = new HashMap();
        }
    }

    public void d(String s)
    {
        a("_color_code", s);
    }

    public YMKApplyEvent e()
    {
        a(a);
        return this;
    }

    public void e(String s)
    {
        a("_palette_guid", s);
    }

    public void f(String s)
    {
        a("_pattern_guid", s);
    }

    public void g(String s)
    {
        if (d != FeatureName.l)
        {
            a("_intensity", s);
        }
    }

    public void h(String s)
    {
        a("_texture", s);
    }

    public void i(String s)
    {
        a("_custom_color", s);
    }


    private class FeatureName extends Enum
    {

        public static final FeatureName A;
        private static final FeatureName B[];
        public static final FeatureName a;
        public static final FeatureName b;
        public static final FeatureName c;
        public static final FeatureName d;
        public static final FeatureName e;
        public static final FeatureName f;
        public static final FeatureName g;
        public static final FeatureName h;
        public static final FeatureName i;
        public static final FeatureName j;
        public static final FeatureName k;
        public static final FeatureName l;
        public static final FeatureName m;
        public static final FeatureName n;
        public static final FeatureName o;
        public static final FeatureName p;
        public static final FeatureName q;
        public static final FeatureName r;
        public static final FeatureName s;
        public static final FeatureName t;
        public static final FeatureName u;
        public static final FeatureName v;
        public static final FeatureName w;
        public static final FeatureName x;
        public static final FeatureName y;
        public static final FeatureName z;

        public static FeatureName valueOf(String s1)
        {
            return (FeatureName)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKApplyEvent$FeatureName, s1);
        }

        public static FeatureName[] values()
        {
            return (FeatureName[])B.clone();
        }

        public abstract String a();

        public abstract String b();

        static 
        {
            a = new FeatureName("Looks", 0) {

                public String a()
                {
                    return "Looks";
                }

                public String b()
                {
                    return "looks";
                }

            };
            b = new FeatureName("SkinSmoothener", 1) {

                public String a()
                {
                    return "SkinSmoothener";
                }

                public String b()
                {
                    return "skinSmooth";
                }

            };
            c = new FeatureName("Foundation", 2) {

                public String a()
                {
                    return "Foundation";
                }

                public String b()
                {
                    return "foundation";
                }

            };
            d = new FeatureName("Blush", 3) {

                public String a()
                {
                    return "Blush";
                }

                public String b()
                {
                    return "blush";
                }

            };
            e = new FeatureName("FaceReshaper", 4) {

                public String a()
                {
                    return "Face Reshaper";
                }

                public String b()
                {
                    return "faceReshape";
                }

            };
            f = new FeatureName("FaceContour", 5) {

                public String a()
                {
                    return "Face Contour";
                }

                public String b()
                {
                    return "faceContour";
                }

            };
            g = new FeatureName("NoseEnhance", 6) {

                public String a()
                {
                    return "Nose Enhance";
                }

                public String b()
                {
                    return "noseEnhance";
                }

            };
            h = new FeatureName("BlemishRemoval", 7) {

                public String a()
                {
                    return "Blemish Removal";
                }

                public String b()
                {
                    return "blemishRemoval";
                }

            };
            i = new FeatureName("ShineRemoval", 8) {

                public String a()
                {
                    return "Shine Removal";
                }

                public String b()
                {
                    return "shineRemoval";
                }

            };
            j = new FeatureName("EyeLiner", 9) {

                public String a()
                {
                    return "Eye Liner";
                }

                public String b()
                {
                    return "eyeliner";
                }

            };
            k = new FeatureName("Eyelashes", 10) {

                public String a()
                {
                    return "Eyelashes";
                }

                public String b()
                {
                    return "eyelashes";
                }

            };
            l = new FeatureName("EyeShadow", 11) {

                public String a()
                {
                    return "Eye Shadow";
                }

                public String b()
                {
                    return "eyeshadow";
                }

            };
            m = new FeatureName("Eyebrows", 12) {

                public String a()
                {
                    return "Eyebrows";
                }

                public String b()
                {
                    return "eyebrows";
                }

            };
            n = new FeatureName("EyeColor", 13) {

                public String a()
                {
                    return "Eye Color";
                }

                public String b()
                {
                    return "eyecolor";
                }

            };
            o = new FeatureName("EyeBagRemoval", 14) {

                public String a()
                {
                    return "Eye Bag Removal";
                }

                public String b()
                {
                    return "eyeBagRemoval";
                }

            };
            p = new FeatureName("EyeEnlarger", 15) {

                public String a()
                {
                    return "Eye Enlarger";
                }

                public String b()
                {
                    return "eyeEnlarger";
                }

            };
            q = new FeatureName("DoubleEyelid", 16) {

                public String a()
                {
                    return "Eyelid";
                }

                public String b()
                {
                    return "eyelid";
                }

            };
            r = new FeatureName("EyeSparkle", 17) {

                public String a()
                {
                    return "Eye Sparkle";
                }

                public String b()
                {
                    return "eyeSparkle";
                }

            };
            s = new FeatureName("RedEyeRemoval", 18) {

                public String a()
                {
                    return "Red-Eye Removal";
                }

                public String b()
                {
                    return "redEyeRemoval";
                }

            };
            t = new FeatureName("LipColor", 19) {

                public String a()
                {
                    return "Lip Color";
                }

                public String b()
                {
                    return "lipstick";
                }

            };
            u = new FeatureName("TeethWhitener", 20) {

                public String a()
                {
                    return "Teeth Whitener";
                }

                public String b()
                {
                    return "teethWhitener";
                }

            };
            v = new FeatureName("Wig", 21) {

                public String a()
                {
                    return "Wig";
                }

                public String b()
                {
                    return "wig";
                }

            };
            w = new FeatureName("Eyewear", 22) {

                public String a()
                {
                    return "Eyewear";
                }

                public String b()
                {
                    return "eyewear";
                }

            };
            x = new FeatureName("Headband", 23) {

                public String a()
                {
                    return "Headband";
                }

                public String b()
                {
                    return "headband";
                }

            };
            y = new FeatureName("Necklace", 24) {

                public String a()
                {
                    return "Necklace";
                }

                public String b()
                {
                    return "necklace";
                }

            };
            z = new FeatureName("Earrings", 25) {

                public String a()
                {
                    return "Earrings";
                }

                public String b()
                {
                    return "earrings";
                }

            };
            A = new FeatureName("HairDye", 26) {

                public String a()
                {
                    return "Hair Dye";
                }

                public String b()
                {
                    return "hairDye";
                }

            };
            B = (new FeatureName[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A
            });
        }

        private FeatureName(String s1, int i1)
        {
            super(s1, i1);
        }

    }

}
