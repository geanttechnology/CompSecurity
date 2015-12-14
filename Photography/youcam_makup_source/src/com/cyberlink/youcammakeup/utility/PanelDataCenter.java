// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Bitmap;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.b.b;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.masteraccess.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ay, bo, BeautyMode, av, 
//            ap, ao, at, am, 
//            as, aw, aq, ax, 
//            ar

public class PanelDataCenter
{

    public PanelDataCenter()
    {
    }

    public static PanelDataCenter a()
    {
        return com.cyberlink.youcammakeup.utility.ay.a();
    }

    public static boolean d(String s1)
    {
        return bo.g(s1);
    }

    public static boolean e(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.h(s1);
    }

    public static boolean f(String s1)
    {
        return bo.f(s1);
    }

    public String a(BeautyMode beautymode, int i1)
    {
        beautymode = (List)com.cyberlink.youcammakeup.utility.bo.a(beautymode, com.cyberlink.youcammakeup.utility.SourceType.a, i1);
        if (beautymode.size() > 0)
        {
            return (String)beautymode.get(0);
        } else
        {
            return null;
        }
    }

    public String a(aw aw, r r1)
    {
        return com.cyberlink.youcammakeup.utility.bo.a(aw, r1.b(), r1.f());
    }

    public List a(BeautyMode beautymode)
    {
        ArrayList arraylist = new ArrayList();
        List list = b(beautymode, com.cyberlink.youcammakeup.utility.SourceType.b);
        beautymode = b(beautymode, com.cyberlink.youcammakeup.utility.SourceType.a);
        for (int i1 = list.size() - 1; i1 > -1; i1--)
        {
            arraylist.add(list.get(i1));
        }

        arraylist.addAll(beautymode);
        return arraylist;
    }

    public List a(BeautyMode beautymode, SourceType sourcetype)
    {
        ArrayList arraylist = new ArrayList();
        for (beautymode = ((List)com.cyberlink.youcammakeup.utility.bo.c(beautymode, sourcetype)).iterator(); beautymode.hasNext(); arraylist.add(i((String)beautymode.next()))) { }
        return arraylist;
    }

    public List a(BeautyMode beautymode, SourceType sourcetype, int i1)
    {
        if (i1 == 1 && beautymode != BeautyMode.n)
        {
            return a(beautymode, sourcetype);
        }
        if (i1 == 4)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        for (beautymode = ((List)com.cyberlink.youcammakeup.utility.bo.a(beautymode, sourcetype, i1)).iterator(); beautymode.hasNext(); arraylist.add(i((String)beautymode.next()))) { }
        return arraylist;
    }

    public List a(SourceType sourcetype)
    {
        Object obj = com.cyberlink.youcammakeup.utility.bo.a(sourcetype);
        sourcetype = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); sourcetype.add(com.cyberlink.youcammakeup.utility.av.a((av)((Iterator) (obj)).next()))) { }
        return sourcetype;
    }

    public transient List a(SourceType sourcetype, SupportMode asupportmode[])
    {
        return com.cyberlink.youcammakeup.utility.bo.a(sourcetype, asupportmode);
    }

    public List a(String s1)
    {
        Object obj = StatusManager.j().s();
        if (obj == com.cyberlink.youcammakeup.utility.BeautyMode.s && s1 == "default_original_eye_contact" || obj == BeautyMode.x && s1 == "default_original_wig" || obj == BeautyMode.z && s1 == "default_original_eye_wear" || obj == BeautyMode.A && s1 == "default_original_hair_band" || obj == BeautyMode.B && s1 == "default_original_necklace" || obj == BeautyMode.C && s1 == "default_original_earrings" || obj == BeautyMode.t && s1 == "default_original_double_eyelid")
        {
            obj = com.cyberlink.youcammakeup.utility.bo.a(((BeautyMode) (obj)), com.cyberlink.youcammakeup.utility.SourceType.a);
            if (obj != null && ((List) (obj)).size() > 0)
            {
                return bo.v((String)((List) (obj)).get(0));
            }
        }
        return bo.v(s1);
    }

    public List a(String s1, SourceType sourcetype)
    {
        return com.cyberlink.youcammakeup.utility.bo.c(s1, sourcetype);
    }

    public transient List a(String s1, SourceType asourcetype[])
    {
        return com.cyberlink.youcammakeup.utility.bo.a(s1, asourcetype);
    }

    public List a(List list, BeautyMode beautymode)
    {
        ArrayList arraylist = new ArrayList();
        for (list = ((List)com.cyberlink.youcammakeup.utility.bo.a(list, beautymode)).iterator(); list.hasNext(); arraylist.add(i((String)list.next()))) { }
        return arraylist;
    }

    public Map a(BeautyMode beautymode, boolean flag)
    {
        HashMap hashmap = new HashMap();
        beautymode = (List)com.cyberlink.youcammakeup.utility.bo.c(beautymode);
        if (flag)
        {
            Pair pair;
            for (beautymode = beautymode.iterator(); beautymode.hasNext(); hashmap.put(pair.first, pair.second))
            {
                pair = (Pair)beautymode.next();
            }

        } else
        {
            Pair pair1;
            for (beautymode = beautymode.iterator(); beautymode.hasNext(); hashmap.put(pair1.second, pair1.first))
            {
                pair1 = (Pair)beautymode.next();
            }

        }
        return hashmap;
    }

    public void a(String s1, String s2, Bitmap bitmap, i i1, aq aq)
    {
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().f(l1);
        ArrayList arraylist = new ArrayList();
        av av1 = new av();
        av1.o = s2;
        if (i1.D() != null)
        {
            s2 = i1.D();
            String s3;
            ap ap1;
            ArrayList arraylist1;
            for (Iterator iterator = s2.a().iterator(); iterator.hasNext(); arraylist.add(new ao(BeautyMode.j, s3, arraylist1, null, 0, 0, null, ap1)))
            {
                s3 = (String)iterator.next();
                ap1 = new ap();
                arraylist1 = new ArrayList();
                arraylist1.add(s2.b(s3));
            }

        }
        if (i1.E() != null)
        {
            s2 = i1.E();
            String s4;
            ap ap2;
            ArrayList arraylist2;
            for (Iterator iterator1 = s2.a().iterator(); iterator1.hasNext(); arraylist.add(new ao(com.cyberlink.youcammakeup.utility.BeautyMode.k, s4, arraylist2, null, 0, 0, null, ap2)))
            {
                s4 = (String)iterator1.next();
                ap2 = new ap();
                arraylist2 = new ArrayList();
                arraylist2.add(s2.b(s4));
            }

        }
        if (i1.u() != null)
        {
            s2 = i1.u();
            Object obj1 = s2.b();
            Object obj3 = new ap();
            obj3.a = s2.c();
            Object obj5 = new ArrayList();
            Object obj7 = s2.e();
            ((at) (obj7)).a((int)s2.g());
            ((List) (obj5)).add(obj7);
            obj7 = BeautyMode.x;
            Object obj8;
            if (obj1 != null)
            {
                s2 = a(((String) (obj1)));
            } else
            {
                s2 = null;
            }
            arraylist.add(new ao(((BeautyMode) (obj7)), ((String) (obj1)), ((List) (obj5)), s2, 0, 0, null, ((ap) (obj3))));
        }
        if (i1.b() != null)
        {
            s2 = i1.b();
            obj1 = s2.b();
            obj3 = new ap();
            obj5 = s2.f();
            obj3.a = s2.c();
            obj7 = BeautyMode.n;
            if (obj1 != null)
            {
                s2 = a(((String) (obj1)));
            } else
            {
                s2 = null;
            }
            arraylist.add(new ao(((BeautyMode) (obj7)), ((String) (obj1)), ((List) (obj5)), s2, 0, 0, null, ((ap) (obj3))));
        }
        if (i1.a() != null)
        {
            obj1 = i1.a();
            obj3 = ((s) (obj1)).b();
            obj5 = new ap();
            obj7 = new ArrayList();
            s2 = ((s) (obj1)).e();
            s2.a((int)((s) (obj1)).g());
            ((List) (obj7)).add(s2);
            obj5.a = ((s) (obj1)).c();
            obj8 = com.cyberlink.youcammakeup.utility.BeautyMode.r;
            if (obj3 != null)
            {
                s2 = a(((String) (obj3)));
            } else
            {
                s2 = null;
            }
            arraylist.add(new ao(((BeautyMode) (obj8)), ((String) (obj3)), ((List) (obj7)), s2, 0, (int)((s) (obj1)).a(), ((s) (obj1)).d(), ((ap) (obj5))));
        }
        if (i1.c() != null)
        {
            Object obj2 = i1.c();
            Object obj4 = ((m) (obj2)).b();
            Object obj6 = new ap();
            obj6.a = ((m) (obj2)).c();
            ArrayList arraylist3 = new ArrayList();
            for (s2 = ((m) (obj2)).f().iterator(); s2.hasNext(); arraylist3.add(obj8))
            {
                obj8 = (at)s2.next();
                ((at) (obj8)).a((int)((m) (obj2)).g());
            }

            BeautyMode beautymode = com.cyberlink.youcammakeup.utility.BeautyMode.s;
            double d1;
            if (obj4 != null)
            {
                s2 = a(((String) (obj4)));
            } else
            {
                s2 = null;
            }
            arraylist.add(new ao(beautymode, ((String) (obj4)), arraylist3, s2, 0, (int)((m) (obj2)).a(), null, ((ap) (obj6))));
        }
        if (i1.e() != null)
        {
            arraylist.add(com.cyberlink.youcammakeup.utility.ao.a(BeautyMode.l, i1.e()));
        }
        if (i1.f() != null)
        {
            arraylist.add(com.cyberlink.youcammakeup.utility.ao.a(com.cyberlink.youcammakeup.utility.BeautyMode.m, i1.f()));
        }
        if (i1.h() != null)
        {
            arraylist.add(com.cyberlink.youcammakeup.utility.ao.a(BeautyMode.v, i1.h()));
        }
        if (i1.g() != null)
        {
            arraylist.add(com.cyberlink.youcammakeup.utility.ao.a(com.cyberlink.youcammakeup.utility.BeautyMode.a, i1.g()));
        }
        if (i1.i() != null)
        {
            arraylist.add(com.cyberlink.youcammakeup.utility.ao.a(com.cyberlink.youcammakeup.utility.BeautyMode.b, i1.i()));
        }
        if (i1.d() != null)
        {
            s2 = i1.d();
            i1 = s2.a();
            obj2 = new ap();
            obj4 = new ArrayList();
            obj6 = s2.c();
            ((at) (obj6)).a((int)s2.b());
            ((List) (obj4)).add(obj6);
            obj6 = BeautyMode.t;
            if (i1 != null)
            {
                s2 = a(((String) (i1)));
            } else
            {
                s2 = null;
            }
            arraylist.add(new ao(((BeautyMode) (obj6)), i1, ((List) (obj4)), s2, 0, 0, null, ((ap) (obj2))));
        }
        s2 = ((a) (obj)).d;
        d1 = Math.max(172D / (double)bitmap.getWidth(), 211D / (double)bitmap.getHeight());
        bitmap = Bitmap.createScaledBitmap(bitmap, (int)((double)bitmap.getWidth() * d1), (int)(d1 * (double)bitmap.getHeight()), false);
        i1 = Exporter.j();
        obj = new ImageBufferWrapper();
        ((ImageBufferWrapper) (obj)).a(bitmap);
        bitmap.recycle();
        Globals.d().r().a(null, s2, ((ImageBufferWrapper) (obj)), i1, new c(aq, ((ImageBufferWrapper) (obj)), s1, av1, i1, arraylist) {

            final aq a;
            final ImageBufferWrapper b;
            final String c;
            final av d;
            final String e;
            final List f;
            final PanelDataCenter g;

            public void a()
            {
                if (a != null)
                {
                    a.a(new Exception("Failed to save thumbnail."));
                }
                b.m();
            }

            public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
            {
                if (a != null)
                {
                    a.a(new Exception("Failed to save thumbnail."));
                }
                b.m();
            }

            public void a(com.cyberlink.youcammakeup.masteraccess.b b1)
            {
                b1 = com.cyberlink.youcammakeup.utility.bo.a(c, d, e, f);
                if (a != null)
                {
                    a.a(b1);
                }
                b.m();
            }

            
            {
                g = PanelDataCenter.this;
                a = aq1;
                b = imagebufferwrapper;
                c = s1;
                d = av1;
                e = s2;
                f = list;
                super();
            }
        });
    }

    public void a(String s1, boolean flag)
    {
        bo.l(s1);
        if (flag)
        {
            bo.p(s1);
        }
    }

    public boolean a(String s1, String s2)
    {
        av av1 = new av();
        av1.o = s2;
        return com.cyberlink.youcammakeup.utility.bo.c(s1, com.cyberlink.youcammakeup.utility.av.b(av1).toString());
    }

    public am b(String s1)
    {
        am am1 = new am();
        for (Iterator iterator = bo.v(s1).iterator(); iterator.hasNext();)
        {
            Mask mask = (Mask)iterator.next();
            if (mask == null)
            {
                com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("getColoredMask(String). mask is null. GUID=").append(s1).toString());
            } else
            {
                String s2 = mask.C();
                if (s2 == null || s2.isEmpty())
                {
                    com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("getColoredMask(String). colorSetGuid is invalid. GUID=").append(s2).toString());
                } else
                {
                    List list = com.cyberlink.youcammakeup.utility.bo.a(com.cyberlink.youcammakeup.h.i().a(s2));
                    if (list.size() > 0)
                    {
                        am1.a(mask, list);
                    } else
                    {
                        com.pf.common.utility.m.e("PanelDataCenter", (new StringBuilder()).append("getColoredMask(String). colorList is empty. GUID=").append(s2).toString());
                    }
                }
            }
        }

        return am1;
    }

    public List b(BeautyMode beautymode)
    {
        return com.cyberlink.youcammakeup.utility.bo.b(beautymode);
    }

    public List b(BeautyMode beautymode, SourceType sourcetype)
    {
        return com.cyberlink.youcammakeup.utility.bo.a(beautymode, sourcetype);
    }

    public List b(BeautyMode beautymode, SourceType sourcetype, int i1)
    {
        if (i1 == 4)
        {
            return new ArrayList();
        } else
        {
            return (List)com.cyberlink.youcammakeup.utility.bo.a(beautymode, sourcetype, i1);
        }
    }

    public List b(String s1, SourceType sourcetype)
    {
        return bo.d(s1, sourcetype);
    }

    public List b(String s1, String s2)
    {
        return com.cyberlink.youcammakeup.utility.bo.b(s1, s2);
    }

    public void b(String s1, boolean flag)
    {
        List list = com.cyberlink.youcammakeup.utility.bo.k(s1);
        com.cyberlink.youcammakeup.utility.bo.m(s1);
        if (flag)
        {
            s1 = list.iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break;
                }
                String s2 = (String)s1.next();
                if (o(s2).f() != com.cyberlink.youcammakeup.utility.SourceType.a)
                {
                    bo.n(s2);
                }
            } while (true);
        }
    }

    public at c(BeautyMode beautymode)
    {
        return bo.d(beautymode, com.cyberlink.youcammakeup.utility.SourceType.a);
    }

    public at c(String s1, SourceType sourcetype)
    {
        return bo.e(s1, sourcetype);
    }

    public List c(BeautyMode beautymode, SourceType sourcetype)
    {
        return com.cyberlink.youcammakeup.utility.bo.b(beautymode, sourcetype);
    }

    public List c(String s1)
    {
        return bo.w(s1);
    }

    public void c(String s1, boolean flag)
    {
        if (flag)
        {
            com.cyberlink.youcammakeup.utility.bo.o(s1);
        }
        bo.n(s1);
    }

    public String d(String s1, SourceType sourcetype)
    {
        return bo.f(s1, sourcetype);
    }

    public List d(BeautyMode beautymode)
    {
        return com.cyberlink.youcammakeup.utility.bo.a(beautymode, new SourceType[] {
            com.cyberlink.youcammakeup.utility.SourceType.a
        });
    }

    public boolean g(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.i(s1);
    }

    public boolean h(String s1)
    {
        return bo.j(s1);
    }

    public aw i(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.a(s1, Boolean.valueOf(false));
    }

    public aw j(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.a(s1, Boolean.valueOf(true));
    }

    public List k(String s1)
    {
        ArrayList arraylist = new ArrayList();
        for (s1 = ((List)bo.q(s1)).iterator(); s1.hasNext(); arraylist.add(i((String)s1.next()))) { }
        return arraylist;
    }

    public List l(String s1)
    {
        return (List)bo.q(s1);
    }

    public List m(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.s(s1);
    }

    public String n(String s1)
    {
        return bo.y(s1);
    }

    public as o(String s1)
    {
        return bo.z(s1);
    }

    public ax p(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.r(s1);
    }

    public ar q(String s1)
    {
        return bo.t(s1);
    }

    public ar r(String s1)
    {
        return com.cyberlink.youcammakeup.utility.bo.u(s1);
    }

    private class SourceType extends Enum
    {

        public static final SourceType a;
        public static final SourceType b;
        public static final SourceType c;
        public static final SourceType d;
        private static final SourceType e[];

        public static SourceType valueOf(String s1)
        {
            return (SourceType)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$SourceType, s1);
        }

        public static SourceType[] values()
        {
            return (SourceType[])e.clone();
        }

        static 
        {
            a = new SourceType("DEFAULT", 0);
            b = new SourceType("DOWNLOAD", 1);
            c = new SourceType("CUSTOM", 2);
            d = new SourceType("SKU", 3);
            e = (new SourceType[] {
                a, b, c, d
            });
        }

        private SourceType(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class Mask
    {

        private final String A;
        private final int B;
        private final String C;
        private final String D;
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final Position f;
        private final Point g;
        private final Point h;
        private final Point i;
        private final Point j;
        private final EyeShadowSide k;
        private final Point l;
        private final Point m;
        private final Point n;
        private final Point o;
        private final Point p;
        private final Point q;
        private final Point r;
        private final Point s;
        private final Point t;
        private final Point u;
        private final Point v;
        private final Point w;
        private final Point x;
        private final Point y;
        private final Point z;

        public static Position a(String s1)
        {
            class Position extends Enum
            {

                public static final Position a;
                public static final Position b;
                public static final Position c;
                public static final Position d;
                public static final Position e;
                private static final Position f[];

                public static Position valueOf(String s2)
                {
                    return (Position)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$Mask$Position, s2);
                }

                public static Position[] values()
                {
                    return (Position[])f.clone();
                }

                static 
                {
                    a = new Position("LEFT", 0);
                    b = new Position("RIGHT", 1);
                    c = new Position("UPPER", 2);
                    d = new Position("LOWER", 3);
                    e = new Position("NONE", 4);
                    f = (new Position[] {
                        a, b, c, d, e
                    });
                }

                private Position(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.Position.a.name()))
            {
                return com.cyberlink.youcammakeup.utility.Position.a;
            }
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.Position.b.name()))
            {
                return com.cyberlink.youcammakeup.utility.Position.b;
            }
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.Position.c.name()))
            {
                return com.cyberlink.youcammakeup.utility.Position.c;
            }
            if (s1.equalsIgnoreCase(Position.d.name()))
            {
                return Position.d;
            } else
            {
                return Position.e;
            }
        }

        public static EyeShadowSide b(String s1)
        {
            class EyeShadowSide extends Enum
            {

                public static final EyeShadowSide a;
                public static final EyeShadowSide b;
                public static final EyeShadowSide c;
                private static final EyeShadowSide d[];

                public static EyeShadowSide valueOf(String s2)
                {
                    return (EyeShadowSide)Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$Mask$EyeShadowSide, s2);
                }

                public static EyeShadowSide[] values()
                {
                    return (EyeShadowSide[])d.clone();
                }

                static 
                {
                    a = new EyeShadowSide("BOTH", 0);
                    b = new EyeShadowSide("LEFT", 1);
                    c = new EyeShadowSide("RIGHT", 2);
                    d = (new EyeShadowSide[] {
                        a, b, c
                    });
                }

                private EyeShadowSide(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.EyeShadowSide.a.name()))
            {
                return com.cyberlink.youcammakeup.utility.EyeShadowSide.a;
            }
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.EyeShadowSide.b.name()))
            {
                return com.cyberlink.youcammakeup.utility.EyeShadowSide.b;
            }
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.utility.EyeShadowSide.c.name()))
            {
                return com.cyberlink.youcammakeup.utility.EyeShadowSide.c;
            } else
            {
                return com.cyberlink.youcammakeup.utility.EyeShadowSide.a;
            }
        }

        public int A()
        {
            int i1;
            try
            {
                i1 = Integer.parseInt(A);
            }
            catch (NumberFormatException numberformatexception)
            {
                return 0;
            }
            return i1;
        }

        public int B()
        {
            return B;
        }

        public String C()
        {
            return D;
        }

        public String a()
        {
            return a;
        }

        public String b()
        {
            return b;
        }

        public String c()
        {
            return c;
        }

        public String d()
        {
            return d;
        }

        public String e()
        {
            return e;
        }

        public Position f()
        {
            return f;
        }

        public Point g()
        {
            return g;
        }

        public Point h()
        {
            return h;
        }

        public Point i()
        {
            return i;
        }

        public Point j()
        {
            return j;
        }

        public EyeShadowSide k()
        {
            return k;
        }

        public Point l()
        {
            return l;
        }

        public Point m()
        {
            return m;
        }

        public Point n()
        {
            return n;
        }

        public Point o()
        {
            return o;
        }

        public Point p()
        {
            return p;
        }

        public Point q()
        {
            return q;
        }

        public Point r()
        {
            return r;
        }

        public Point s()
        {
            return s;
        }

        public Point t()
        {
            return t;
        }

        public Point u()
        {
            return u;
        }

        public Point v()
        {
            return v;
        }

        public Point w()
        {
            return w;
        }

        public Point x()
        {
            return x;
        }

        public Point y()
        {
            return y;
        }

        public Point z()
        {
            return z;
        }

        public Mask(Mask mask)
        {
            a = mask.a;
            b = mask.b;
            c = mask.c;
            d = mask.d;
            e = mask.e;
            f = mask.f;
            g = mask.g;
            h = mask.h;
            i = mask.i;
            j = mask.j;
            k = mask.k;
            l = mask.l;
            m = mask.m;
            n = mask.n;
            o = mask.o;
            p = mask.p;
            q = mask.q;
            r = mask.r;
            s = mask.s;
            t = mask.t;
            u = mask.u;
            v = mask.v;
            w = mask.w;
            x = mask.x;
            y = mask.y;
            z = mask.z;
            A = mask.A;
            B = mask.B;
            C = mask.C;
            D = mask.D;
        }

        public Mask(String s1, String s2, String s3, String s4, String s5, Position position, Point point, 
                Point point1, Point point2, Point point3, EyeShadowSide eyeshadowside, Point point4, Point point5, Point point6, 
                Point point7, Point point8, Point point9, Point point10, Point point11, Point point12, Point point13, 
                Point point14, Point point15, Point point16, Point point17, Point point18, String s6, int i1, 
                String s7, String s8)
        {
            a = s1;
            b = s2;
            c = s3;
            d = s4;
            e = s5;
            f = position;
            g = point;
            h = point1;
            i = point2;
            j = point3;
            k = eyeshadowside;
            l = point4;
            m = point5;
            n = point6;
            o = point7;
            p = point8;
            q = point9;
            r = point10;
            s = point11;
            t = point12;
            u = point13;
            v = point14;
            w = point15;
            x = point16;
            y = point17;
            z = point18;
            A = s6;
            B = i1;
            C = s7;
            D = s8;
        }
    }

}
