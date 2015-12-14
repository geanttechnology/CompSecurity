// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.cyberlink.youcammakeup.database.more.h.f;
import com.cyberlink.youcammakeup.database.more.i.a;
import com.cyberlink.youcammakeup.database.more.i.b;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bo, au, ba, bi, 
//            bh, bj, BeautyMode, bg, 
//            MakeupMode, aw

public class SkuTemplateUtils
{

    public static SkuTryItUrl a(Activity activity)
    {
        if (activity == null || activity.getIntent() == null)
        {
            return null;
        } else
        {
            return (SkuTryItUrl)activity.getIntent().getSerializableExtra("EXTRA_KEY_SKU_TRY_IT_URL");
        }
    }

    static ba a(a a1)
    {
        int ai[];
        int j;
        int k;
        int l;
        String s = null;
        if (a1 == null)
        {
            return null;
        }
        int i1 = Color.parseColor((new StringBuilder()).append("#").append(a1.f()).toString());
        int j1 = a1.g();
        String s1 = a1.a();
        String s2 = a1.b();
        String s3;
        String s4;
        e e1;
        boolean flag;
        if (!a1.c().isEmpty())
        {
            s = a1.c();
        }
        s3 = a1.d();
        s4 = a1.e();
        a1 = a1.h();
        ai = new int[0];
        e1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(s4, s1, s2);
        if (e1 != null)
        {
            flag = e1.e();
        } else
        {
            flag = false;
        }
        a1 = new JSONObject(a1);
        j = com.cyberlink.youcammakeup.utility.bo.d(a1.optString("level_max"));
        l = com.cyberlink.youcammakeup.utility.bo.d(a1.optString("level_default"));
        a1 = com.cyberlink.youcammakeup.utility.au.b(a1.optString("engine_color"));
        k = j;
_L2:
        return new ba(s1, s2, s, s3, s4, i1, j1, k, l, flag, a1);
        a1;
        j = 0;
        k = 0;
_L3:
        m.e("SkuTemplateUtils", a1.toString());
        l = j;
        a1 = ai;
        if (true) goto _L2; else goto _L1
_L1:
        a1;
        l = 0;
        k = j;
        j = l;
          goto _L3
        a1;
        k = j;
        j = l;
          goto _L3
    }

    public static bh a(String s, String s1, d d1, PanelDataCenter.SourceType sourcetype)
    {
        bi bi1 = new bi();
        bi1.a = d1;
        bi1.d = sourcetype;
        bi1.b = s;
        bi1.c = s1;
        s = new bh();
        (new bj(bi1, s)).a();
        if (((bh) (s)).c == null)
        {
            a(((bh) (s)));
        }
        return s;
    }

    public static String a(BeautyMode beautymode)
    {
        if (beautymode == BeautyMode.r)
        {
            return "eye_brow";
        }
        if (beautymode == BeautyMode.l)
        {
            return "eye_line";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.b)
        {
            return "skin_toner";
        }
        if (beautymode == BeautyMode.s)
        {
            return "eye_contact";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.a)
        {
            return "blush";
        }
        if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.m)
        {
            return "eye_lash";
        }
        if (beautymode == BeautyMode.n)
        {
            return "eye_shadow";
        }
        if (beautymode == BeautyMode.t)
        {
            return "double_lid";
        }
        if (beautymode == BeautyMode.v)
        {
            return "lipstick";
        }
        if (beautymode == BeautyMode.z)
        {
            return "eye_wear";
        }
        if (beautymode == BeautyMode.A)
        {
            return "hair_band";
        }
        if (beautymode == BeautyMode.B)
        {
            return "necklace";
        }
        if (beautymode == BeautyMode.C)
        {
            return "earrings";
        }
        if (beautymode == BeautyMode.x)
        {
            return "wig";
        }
        if (beautymode == BeautyMode.y)
        {
            return "hair_dye";
        } else
        {
            return "";
        }
    }

    public static String a(String s, FeatureType featuretype)
    {
        return com.cyberlink.youcammakeup.kernelctrl.sku.h.b().o(com.cyberlink.youcammakeup.utility.FeatureType.a(featuretype), s);
    }

    public static String a(String s, String s1)
    {
        return com.cyberlink.youcammakeup.kernelctrl.sku.h.b().p(s1, s);
    }

    public static List a(String s)
    {
        ArrayList arraylist = new ArrayList();
        for (s = com.cyberlink.youcammakeup.h.x().a(s).iterator(); s.hasNext(); arraylist.add(a((a)s.next()))) { }
        return arraylist;
    }

    static List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(a((a)list.next()))) { }
        return arraylist;
    }

    protected static void a(bh bh1)
    {
        com.cyberlink.youcammakeup.utility.bo.a(bh1);
        a a1;
        for (Iterator iterator = bh1.a.a.iterator(); iterator.hasNext(); com.cyberlink.youcammakeup.h.x().a(a1))
        {
            a1 = (a)iterator.next();
        }

        com.cyberlink.youcammakeup.database.more.b.a a2;
        for (Iterator iterator1 = bh1.a.b.iterator(); iterator1.hasNext(); com.cyberlink.youcammakeup.h.i().a(a2))
        {
            a2 = (com.cyberlink.youcammakeup.database.more.b.a)iterator1.next();
        }

        com.cyberlink.youcammakeup.database.more.g.a a3;
        for (Iterator iterator2 = bh1.a.c.iterator(); iterator2.hasNext(); com.cyberlink.youcammakeup.h.j().a(a3))
        {
            a3 = (com.cyberlink.youcammakeup.database.more.g.a)iterator2.next();
        }

        com.cyberlink.youcammakeup.database.more.h.e e1;
        for (bh1 = bh1.a.d.iterator(); bh1.hasNext(); com.cyberlink.youcammakeup.h.n().a(e1))
        {
            e1 = (com.cyberlink.youcammakeup.database.more.h.e)bh1.next();
        }

    }

    public static String b(String s, FeatureType featuretype)
    {
        return com.cyberlink.youcammakeup.kernelctrl.sku.h.b().q(com.cyberlink.youcammakeup.utility.FeatureType.a(featuretype), s);
    }

    public static List b(String s)
    {
        Object obj = (List)com.cyberlink.youcammakeup.h.o().a(s, null);
        s = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (String)((Iterator) (obj)).next();
            obj1 = com.cyberlink.youcammakeup.h.x().b(((String) (obj1)));
            if (obj1 != null)
            {
                s.add(obj1);
            }
        } while (true);
        return a(s);
    }

    public static ba c(String s)
    {
        return a(com.cyberlink.youcammakeup.h.x().c(s));
    }

    public static aw d(String s)
    {
        s = e(s);
        if (s != null)
        {
            return com.cyberlink.youcammakeup.utility.bo.a(s, Boolean.valueOf(false));
        } else
        {
            return null;
        }
    }

    public static String e(String s)
    {
        s = (List)bo.q(s);
        if (s.size() > 0)
        {
            return (String)s.get(0);
        } else
        {
            return null;
        }
    }

    public static ba f(String s)
    {
        return a(com.cyberlink.youcammakeup.h.x().b(s));
    }

    public static MakeupMode g(String s)
    {
        if (s.equals("lipstick"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.e;
        }
        if (s.equals("eye_brow"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.d;
        }
        if (s.equals("eye_line"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.d;
        }
        if (s.equals("skin_toner"))
        {
            return MakeupMode.c;
        }
        if (s.equals("eye_contact"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.d;
        }
        if (s.equals("blush"))
        {
            return MakeupMode.c;
        }
        if (s.equals("eye_lash"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.d;
        }
        if (s.equals("eye_shadow"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.d;
        }
        if (s.equals("eye_wear"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.f;
        }
        if (s.equals("hair_band"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.f;
        }
        if (s.equals("necklace"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.f;
        }
        if (s.equals("earrings"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.f;
        }
        if (s.equals("wig"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.b;
        }
        if (s.equals("hair_dye"))
        {
            return com.cyberlink.youcammakeup.utility.MakeupMode.b;
        } else
        {
            return MakeupMode.g;
        }
    }

    public static BeautyMode h(String s)
    {
        if (s.equals("lipstick"))
        {
            return BeautyMode.v;
        }
        if (s.equals("eye_brow"))
        {
            return BeautyMode.r;
        }
        if (s.equals("eye_line"))
        {
            return BeautyMode.l;
        }
        if (s.equals("skin_toner"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.b;
        }
        if (s.equals("eye_contact"))
        {
            return BeautyMode.s;
        }
        if (s.equals("blush"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.a;
        }
        if (s.equals("eye_lash"))
        {
            return com.cyberlink.youcammakeup.utility.BeautyMode.m;
        }
        if (s.equals("eye_shadow"))
        {
            return BeautyMode.n;
        }
        if (s.equals("eye_wear"))
        {
            return BeautyMode.z;
        }
        if (s.equals("hair_band"))
        {
            return BeautyMode.A;
        }
        if (s.equals("necklace"))
        {
            return BeautyMode.B;
        }
        if (s.equals("earrings"))
        {
            return BeautyMode.C;
        }
        if (s.equals("wig"))
        {
            return BeautyMode.x;
        }
        if (s.equals("hair_dye"))
        {
            return BeautyMode.y;
        } else
        {
            return BeautyMode.D;
        }
    }

    public static String i(String s)
    {
        if (s.equals("lipstick"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t.b();
        }
        if (s.equals("eye_brow"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.m.b();
        }
        if (s.equals("eye_line"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.j.b();
        }
        if (s.equals("skin_toner"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c.b();
        }
        if (s.equals("eye_contact"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.n.b();
        }
        if (s.equals("blush"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.d.b();
        }
        if (s.equals("eye_lash"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.k.b();
        }
        if (s.equals("eye_shadow"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l.b();
        }
        if (s.equals("eye_wear"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.w.b();
        }
        if (s.equals("hair_band"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.x.b();
        }
        if (s.equals("necklace"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.y.b();
        }
        if (s.equals("earrings"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.z.b();
        }
        if (s.equals("wig"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.v.b();
        }
        if (s.equals("hair_dye"))
        {
            return com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.A.b();
        } else
        {
            return null;
        }
    }

    private class SkuTryItUrl
        implements Serializable
    {

        public static final SkuTryItUrl a = new SkuTryItUrl(null, null, null, null);
        private static final long serialVersionUID = 0x5ab3206d8b562639L;
        public final String itemGuid;
        public final String patternGuid;
        public final String skuGuid;
        public final String type;


        public SkuTryItUrl(String s, String s1, String s2, String s3)
        {
            type = s;
            skuGuid = s1;
            itemGuid = s2;
            patternGuid = s3;
        }
    }


    private class FeatureType extends Enum
    {

        public static final FeatureType a;
        public static final FeatureType b;
        public static final FeatureType c;
        public static final FeatureType d;
        public static final FeatureType e;
        public static final FeatureType f;
        public static final FeatureType g;
        public static final FeatureType h;
        public static final FeatureType i;
        public static final FeatureType j;
        private static final FeatureType k[];

        public static final String a(FeatureType featuretype)
        {
            if (featuretype == a)
            {
                return "lipstick";
            }
            if (featuretype == b)
            {
                return "eye_shadow";
            }
            if (featuretype == c)
            {
                return "eye_contact";
            }
            if (featuretype == d)
            {
                return "eye_brow";
            }
            if (featuretype == e)
            {
                return "eye_line";
            }
            if (featuretype == f)
            {
                return "eye_lash";
            }
            if (featuretype == g)
            {
                return "blush";
            }
            if (featuretype == h)
            {
                return "skin_toner";
            }
            if (featuretype == i)
            {
                return "wig";
            }
            if (featuretype == j)
            {
                return "hair_dye";
            } else
            {
                return "lipstick";
            }
        }

        public static FeatureType valueOf(String s)
        {
            return (FeatureType)Enum.valueOf(com/cyberlink/youcammakeup/utility/SkuTemplateUtils$FeatureType, s);
        }

        public static FeatureType[] values()
        {
            return (FeatureType[])k.clone();
        }

        static 
        {
            a = new FeatureType("LIPSTICK", 0);
            b = new FeatureType("EYE_SHADOW", 1);
            c = new FeatureType("EYE_CONTACT", 2);
            d = new FeatureType("EYE_BROW", 3);
            e = new FeatureType("EYE_LINE", 4);
            f = new FeatureType("EYE_LASH", 5);
            g = new FeatureType("BLUSH", 6);
            h = new FeatureType("SKIN_TONE", 7);
            i = new FeatureType("WIG", 8);
            j = new FeatureType("HAIR_DYE", 9);
            k = (new FeatureType[] {
                a, b, c, d, e, f, g, h, i, j
            });
        }

        private FeatureType(String s, int l)
        {
            super(s, l);
        }
    }

}
