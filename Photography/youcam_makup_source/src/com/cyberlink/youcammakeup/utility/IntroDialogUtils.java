// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.FragmentManager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.r;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.s;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.t;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.dialogs.n;
import com.cyberlink.youcammakeup.widgetpool.dialogs.o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            BeautyMode, ab, MakeupMode, o, 
//            ac

public class IntroDialogUtils
{

    private static final Map a;
    private static final Map b;
    private static final Map c;
    private static final Map d;
    private static final Map e = new HashMap();
    private static n f;

    public static IntroDialogType a(BeautyMode beautymode)
    {
        return (IntroDialogType)a.get(beautymode);
    }

    public static IntroDialogType a(BeautyMode beautymode, boolean flag, boolean flag1)
    {
        if (flag1 && beautymode == BeautyMode.y)
        {
            return IntroDialogType.M;
        }
        if (flag)
        {
            if (beautymode == BeautyMode.v)
            {
                return IntroDialogType.B;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.a)
            {
                return IntroDialogType.c;
            }
            if (beautymode == BeautyMode.b)
            {
                return IntroDialogType.e;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.r)
            {
                return IntroDialogType.w;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.s)
            {
                return IntroDialogType.y;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.l)
            {
                return com.cyberlink.youcammakeup.utility.IntroDialogType.n;
            }
            if (beautymode == BeautyMode.m)
            {
                return IntroDialogType.p;
            }
        } else
        {
            if (beautymode == BeautyMode.v)
            {
                return IntroDialogType.A;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.a)
            {
                return IntroDialogType.b;
            }
            if (beautymode == BeautyMode.b)
            {
                return IntroDialogType.d;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.r)
            {
                return IntroDialogType.v;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.s)
            {
                return IntroDialogType.x;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.l)
            {
                return IntroDialogType.m;
            }
            if (beautymode == BeautyMode.m)
            {
                return com.cyberlink.youcammakeup.utility.IntroDialogType.o;
            }
            if (beautymode == com.cyberlink.youcammakeup.utility.BeautyMode.t)
            {
                return com.cyberlink.youcammakeup.utility.IntroDialogType.z;
            }
            if (beautymode == BeautyMode.y)
            {
                return IntroDialogType.L;
            }
        }
        return IntroDialogType.A;
    }

    public static IntroDialogType a(MakeupMode makeupmode, BeautyMode beautymode)
    {
        if (makeupmode == com.cyberlink.youcammakeup.utility.MakeupMode.a)
        {
            return com.cyberlink.youcammakeup.utility.IntroDialogType.a;
        } else
        {
            return a(beautymode);
        }
    }

    public static String a(IntroDialogType introdialogtype)
    {
        return (String)b.get(introdialogtype);
    }

    public static Map a()
    {
        return d;
    }

    public static void a(FragmentManager fragmentmanager, android.content.DialogInterface.OnDismissListener ondismisslistener, o o1)
    {
        IntroDialogType introdialogtype;
        if (StatusManager.j().r() == com.cyberlink.youcammakeup.utility.MakeupMode.a)
        {
            introdialogtype = com.cyberlink.youcammakeup.utility.IntroDialogType.a;
        } else
        {
            introdialogtype = a(StatusManager.j().s());
        }
        b(fragmentmanager, ondismisslistener, o1, introdialogtype, false);
    }

    static void a(IntroDialogType introdialogtype, Integer integer, q q1, ac ac)
    {
        b(introdialogtype, integer, q1, ac);
    }

    public static void a(ac ac)
    {
        IntroDialogType introdialogtype;
        Integer integer;
        if (StatusManager.j().r() == com.cyberlink.youcammakeup.utility.MakeupMode.a)
        {
            introdialogtype = com.cyberlink.youcammakeup.utility.IntroDialogType.a;
        } else
        {
            introdialogtype = a(StatusManager.j().s());
        }
        integer = (Integer)c.get(introdialogtype);
        if (d.containsKey(integer))
        {
            Object obj = (List)d.get(integer);
            ArrayList arraylist = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((ab)((Iterator) (obj)).next()).a)) { }
            obj = Globals.d().w();
            ((NetworkManager) (obj)).a(new s(((NetworkManager) (obj)), arraylist, new t(introdialogtype, integer, ac) {

                final IntroDialogType a;
                final Integer b;
                final ac c;

                public void a(bn bn1)
                {
                }

                public void a(q q1)
                {
                    com.cyberlink.youcammakeup.utility.IntroDialogUtils.a(a, b, q1, c);
                }

                public volatile void a(Object obj1)
                {
                    a((q)obj1);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj1)
                {
                    a((bn)obj1);
                }

                public void c(Object obj1)
                {
                    a((Void)obj1);
                }

            
            {
                a = introdialogtype;
                b = integer;
                c = ac;
                super();
            }
            }));
        }
    }

    public static boolean a(FragmentManager fragmentmanager, android.content.DialogInterface.OnDismissListener ondismisslistener, o o1, IntroDialogType introdialogtype, boolean flag)
    {
        boolean flag1;
        for (flag1 = true; IntroDialogType.G != introdialogtype || introdialogtype == null;)
        {
            return false;
        }

        String s1 = a(introdialogtype);
        if (!z.a(s1, Globals.d()))
        {
            b(fragmentmanager, ondismisslistener, o1, introdialogtype, flag);
            z.a(s1, Boolean.valueOf(true), Globals.d());
            flag = flag1;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static Integer b(IntroDialogType introdialogtype)
    {
        return (Integer)c.get(introdialogtype);
    }

    public static void b(FragmentManager fragmentmanager, android.content.DialogInterface.OnDismissListener ondismisslistener, o o1, IntroDialogType introdialogtype, boolean flag)
    {
        if (introdialogtype == null)
        {
            return;
        }
        if (f == null)
        {
            f = new n();
        }
        f.a(introdialogtype);
        f.a(ondismisslistener);
        f.a(o1);
        ondismisslistener = introdialogtype.toString();
        com.cyberlink.youcammakeup.utility.o.a(fragmentmanager, f, ondismisslistener);
    }

    private static void b(IntroDialogType introdialogtype, Integer integer, q q1, ac ac)
    {
        NetworkManager networkmanager = Globals.d().w();
        Object obj = q1.a();
        q1 = Globals.d().getExternalFilesDir(null);
        if (q1 != null)
        {
            q1 = q1.getAbsolutePath();
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                r r1 = (r)((Iterator) (obj)).next();
                networkmanager.a(q1, new k(r1.a.hashCode(), "intro", r1.b), new l(r1, integer, ac, introdialogtype) {

                    final r a;
                    final Integer b;
                    final ac c;
                    final IntroDialogType d;

                    public void a(a a1)
                    {
                    }

                    public void a(bn bn1)
                    {
                    }

                    public volatile void a(Object obj1)
                    {
                        a((String)obj1);
                    }

                    public void a(String s1)
                    {
                        z.a((new StringBuilder()).append("INTRO_IMAGE_").append(a.a).toString(), s1, Globals.d());
                        if (!IntroDialogUtils.c().containsKey(b))
                        {
                            IntroDialogUtils.c().put(b, new ArrayList());
                        }
                        Object obj1 = new File(s1);
                        s1 = (List)IntroDialogUtils.c().get(b);
                        if (!s1.contains(((File) (obj1)).getName()))
                        {
                            s1.add(((File) (obj1)).getName());
                        }
                        obj1 = (List)IntroDialogUtils.d().get(b);
                        if (s1.size() == ((List) (obj1)).size())
                        {
                            Globals.d(new Runnable(this) {

                                final _cls2 a;

                                public void run()
                                {
                                    a.c.a(a.d);
                                }

            
            {
                a = _pcls2;
                super();
            }
                            });
                        }
                    }

                    public void a(Void void1)
                    {
                    }

                    public void b(Object obj1)
                    {
                        a((bn)obj1);
                    }

                    public void c(Object obj1)
                    {
                        a((Void)obj1);
                    }

                    public void d(Object obj1)
                    {
                        a((a)obj1);
                    }

            
            {
                a = r1;
                b = integer;
                c = ac;
                d = introdialogtype;
                super();
            }
                });
            }
        }
    }

    public static boolean b()
    {
        Object obj;
        if (StatusManager.j().r() == com.cyberlink.youcammakeup.utility.MakeupMode.a)
        {
            obj = com.cyberlink.youcammakeup.utility.IntroDialogType.a;
        } else
        {
            obj = a(StatusManager.j().s());
        }
        obj = (Integer)c.get(obj);
        obj = (List)d.get(obj);
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
_L2:
        Object obj1;
        boolean flag;
        if (((Iterator) (obj)).hasNext())
        {
            obj1 = (ab)((Iterator) (obj)).next();
            obj1 = z.b((new StringBuilder()).append("INTRO_IMAGE_").append(((ab) (obj1)).a).toString(), "", Globals.d());
            if (obj1 != "")
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = true;
        } else
        {
            flag = false;
        }
_L3:
        return flag;
        if ((new File(((String) (obj1)))).exists()) goto _L2; else goto _L1
_L1:
        flag = true;
          goto _L3
    }

    public static boolean b(FragmentManager fragmentmanager, android.content.DialogInterface.OnDismissListener ondismisslistener, o o1)
    {
        return false;
    }

    static Map c()
    {
        return e;
    }

    static Map d()
    {
        return d;
    }

    static 
    {
        a = new HashMap();
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.a, IntroDialogType.b);
        a.put(BeautyMode.b, IntroDialogType.d);
        a.put(BeautyMode.c, IntroDialogType.f);
        a.put(BeautyMode.d, IntroDialogType.g);
        a.put(BeautyMode.e, IntroDialogType.h);
        a.put(BeautyMode.f, IntroDialogType.i);
        a.put(BeautyMode.g, IntroDialogType.j);
        a.put(BeautyMode.h, com.cyberlink.youcammakeup.utility.IntroDialogType.k);
        a.put(BeautyMode.i, com.cyberlink.youcammakeup.utility.IntroDialogType.l);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.l, IntroDialogType.m);
        a.put(BeautyMode.m, com.cyberlink.youcammakeup.utility.IntroDialogType.o);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.n, com.cyberlink.youcammakeup.utility.IntroDialogType.q);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.o, com.cyberlink.youcammakeup.utility.IntroDialogType.r);
        a.put(BeautyMode.u, com.cyberlink.youcammakeup.utility.IntroDialogType.s);
        a.put(BeautyMode.p, com.cyberlink.youcammakeup.utility.IntroDialogType.t);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.q, IntroDialogType.u);
        a.put(BeautyMode.v, IntroDialogType.A);
        a.put(BeautyMode.w, IntroDialogType.C);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.r, IntroDialogType.v);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.s, IntroDialogType.x);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.t, com.cyberlink.youcammakeup.utility.IntroDialogType.z);
        a.put(BeautyMode.x, IntroDialogType.D);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.z, IntroDialogType.H);
        a.put(BeautyMode.A, IntroDialogType.I);
        a.put(BeautyMode.B, IntroDialogType.J);
        a.put(BeautyMode.C, IntroDialogType.K);
        a.put(BeautyMode.y, IntroDialogType.L);
        a.put(BeautyMode.j, IntroDialogType.N);
        a.put(com.cyberlink.youcammakeup.utility.BeautyMode.k, IntroDialogType.O);
        b = new HashMap();
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.a, "HAS_SHOWN_INTRO_LOOKS");
        b.put(IntroDialogType.b, "HAS_SHOWN_INTRO_BLUSH");
        b.put(IntroDialogType.c, "HAS_SHOWN_INTRO_BLUSH_SKU");
        b.put(IntroDialogType.d, "HAS_SHOWN_INTRO_SKIN_TONER");
        b.put(IntroDialogType.e, "HAS_SHOWN_INTRO_SKIN_TONER_SKU");
        b.put(IntroDialogType.f, "HAS_SHOWN_INTRO_SHINE_REMOVAL");
        b.put(IntroDialogType.g, "HAS_SHOWN_INTRO_SKIN_SMOOTHENER");
        b.put(IntroDialogType.h, "HAS_SHOWN_INTRO_BLEMISH_REMOVAL");
        b.put(IntroDialogType.i, "HAS_SHOWN_INTRO_CONTOUR_NOSE");
        b.put(IntroDialogType.j, "HAS_SHOWN_INTRO_COUNTOUR_FACE");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.k, "HAS_SHOWN_INTRO_FACE_RESHAPER");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.l, "HAS_SHOWN_INTRO_FACE_RESHAPER_MANUAL");
        b.put(IntroDialogType.m, "HAS_SHOWN_INTRO_EYE_LINES");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.n, "HAS_SHOWN_INTRO_EYE_LINES_SKU");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.o, "HAS_SHOWN_INTRO_EYE_LASHES");
        b.put(IntroDialogType.p, "HAS_SHOWN_INTRO_EYE_LASHES_SKU");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.q, "HAS_SHOWN_INTRO_EYE_SHADOW");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.r, "HAS_SHOWN_INTRO_EYE_ENLARGER");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.s, "HAS_SHOWN_INTRO_EYE_SPARKLE");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.t, "HAS_SHOWN_INTRO_EYE_BAG_REMOVAL");
        b.put(IntroDialogType.u, "HAS_SHOWN_INTRO_RED_EYE_REMOVAL");
        b.put(IntroDialogType.A, "HAS_SHOWN_INTRO_LIP_STICK");
        b.put(IntroDialogType.B, "HAS_SHOWN_INTRO_LIP_STICK_SKU");
        b.put(IntroDialogType.C, "HAS_SHOWN_INTRO_TEETH_WHITENER");
        b.put(IntroDialogType.v, "HAS_SHOWN_INTRO_EYE_BROW");
        b.put(IntroDialogType.w, "HAS_SHOWN_INTRO_EYE_BROW_SKU");
        b.put(IntroDialogType.x, "HAS_SHOWN_INTRO_EYE_CONTACT");
        b.put(IntroDialogType.y, "HAS_SHOWN_INTRO_EYE_CONTACT_SKU");
        b.put(com.cyberlink.youcammakeup.utility.IntroDialogType.z, "HAS_SHOWN_INTRO_DOUBLE_EYELID");
        b.put(IntroDialogType.D, "HAS_SHOWN_INTRO_WIG");
        b.put(IntroDialogType.H, "HAS_SHOWN_INTRO_EYE_WEAR");
        b.put(IntroDialogType.I, "HAS_SHOWN_INTRO_HAIR_BAND");
        b.put(IntroDialogType.J, "HAS_SHOWN_INTRO_NECKLACE");
        b.put(IntroDialogType.K, "HAS_SHOWN_INTRO_EARRINGS");
        b.put(IntroDialogType.L, "HAS_SHOWN_INTRO_HAIR_DYE");
        b.put(IntroDialogType.M, "HAS_SHOWN_INTRO_HAIR_DYE_BRUSH");
        b.put(IntroDialogType.N, "HAS_SHOWN_INTRO_FACE_ART");
        b.put(IntroDialogType.O, "HAS_SHOWN_INTRO_MUSTACHE");
        b.put(IntroDialogType.E, "HAS_SHOWN_DETECT_HINT");
        b.put(IntroDialogType.F, "HAS_SHOWN_CAMERA_GESTURE_HINT");
        b.put(IntroDialogType.G, "HAS_SHOWN_INTRO_CAMERA_LIVE_MAKEUP_HINT");
        c = new HashMap();
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.a, Integer.valueOf(0x7f030142));
        c.put(IntroDialogType.b, Integer.valueOf(0x7f030127));
        c.put(IntroDialogType.c, Integer.valueOf(0x7f030128));
        c.put(IntroDialogType.d, Integer.valueOf(0x7f030148));
        c.put(IntroDialogType.e, Integer.valueOf(0x7f030149));
        c.put(IntroDialogType.f, Integer.valueOf(0x7f030126));
        c.put(IntroDialogType.g, Integer.valueOf(0x7f030147));
        c.put(IntroDialogType.h, Integer.valueOf(0x7f030145));
        c.put(IntroDialogType.i, Integer.valueOf(0x7f03012a));
        c.put(IntroDialogType.j, Integer.valueOf(0x7f030129));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.k, Integer.valueOf(0x7f03013b));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.l, Integer.valueOf(0x7f03013c));
        c.put(IntroDialogType.m, Integer.valueOf(0x7f030135));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.n, Integer.valueOf(0x7f030136));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.o, Integer.valueOf(0x7f030133));
        c.put(IntroDialogType.p, Integer.valueOf(0x7f030134));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.q, Integer.valueOf(0x7f030137));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.r, Integer.valueOf(0x7f030132));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.s, Integer.valueOf(0x7f030138));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.t, Integer.valueOf(0x7f03012d));
        c.put(IntroDialogType.u, Integer.valueOf(0x7f030146));
        c.put(IntroDialogType.A, Integer.valueOf(0x7f030140));
        c.put(IntroDialogType.B, Integer.valueOf(0x7f030141));
        c.put(IntroDialogType.C, Integer.valueOf(0x7f03014a));
        c.put(IntroDialogType.v, Integer.valueOf(0x7f03012e));
        c.put(IntroDialogType.w, Integer.valueOf(0x7f03012f));
        c.put(IntroDialogType.x, Integer.valueOf(0x7f030130));
        c.put(IntroDialogType.y, Integer.valueOf(0x7f030131));
        c.put(com.cyberlink.youcammakeup.utility.IntroDialogType.z, Integer.valueOf(0x7f03012b));
        c.put(IntroDialogType.D, Integer.valueOf(0x7f03014b));
        c.put(IntroDialogType.E, Integer.valueOf(0x7f0300e7));
        c.put(IntroDialogType.F, Integer.valueOf(0x7f0300ea));
        c.put(IntroDialogType.G, Integer.valueOf(0x7f0300eb));
        c.put(IntroDialogType.H, Integer.valueOf(0x7f030139));
        c.put(IntroDialogType.I, Integer.valueOf(0x7f03013d));
        c.put(IntroDialogType.J, Integer.valueOf(0x7f030144));
        c.put(IntroDialogType.K, Integer.valueOf(0x7f03012c));
        c.put(IntroDialogType.L, Integer.valueOf(0x7f03013e));
        c.put(IntroDialogType.M, Integer.valueOf(0x7f03013f));
        c.put(IntroDialogType.N, Integer.valueOf(0x7f03013a));
        c.put(IntroDialogType.O, Integer.valueOf(0x7f030143));
        d = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new ab("intro_photo_hair02", 0x7f0c05f0));
        arraylist.add(new ab("intro_photo_hair01", 0x7f0c05ef));
        d.put(Integer.valueOf(0x7f03014b), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_hair_photo", 0x7f0c05e3));
        d.put(Integer.valueOf(0x7f03013e), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_hair_photo", 0x7f0c05e4));
        d.put(Integer.valueOf(0x7f03013f), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_thumb_earing", 0x7f0c05d8));
        d.put(Integer.valueOf(0x7f03012c), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_thumb_eyeware", 0x7f0c05e1));
        d.put(Integer.valueOf(0x7f030139), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_thumb_hair", 0x7f0c05e2));
        d.put(Integer.valueOf(0x7f03013d), arraylist);
        arraylist = new ArrayList();
        arraylist.add(new ab("intro_thumb_neck", 0x7f0c05e7));
        d.put(Integer.valueOf(0x7f030144), arraylist);
    }

    private class IntroDialogType extends Enum
    {

        public static final IntroDialogType A;
        public static final IntroDialogType B;
        public static final IntroDialogType C;
        public static final IntroDialogType D;
        public static final IntroDialogType E;
        public static final IntroDialogType F;
        public static final IntroDialogType G;
        public static final IntroDialogType H;
        public static final IntroDialogType I;
        public static final IntroDialogType J;
        public static final IntroDialogType K;
        public static final IntroDialogType L;
        public static final IntroDialogType M;
        public static final IntroDialogType N;
        public static final IntroDialogType O;
        private static final IntroDialogType P[];
        public static final IntroDialogType a;
        public static final IntroDialogType b;
        public static final IntroDialogType c;
        public static final IntroDialogType d;
        public static final IntroDialogType e;
        public static final IntroDialogType f;
        public static final IntroDialogType g;
        public static final IntroDialogType h;
        public static final IntroDialogType i;
        public static final IntroDialogType j;
        public static final IntroDialogType k;
        public static final IntroDialogType l;
        public static final IntroDialogType m;
        public static final IntroDialogType n;
        public static final IntroDialogType o;
        public static final IntroDialogType p;
        public static final IntroDialogType q;
        public static final IntroDialogType r;
        public static final IntroDialogType s;
        public static final IntroDialogType t;
        public static final IntroDialogType u;
        public static final IntroDialogType v;
        public static final IntroDialogType w;
        public static final IntroDialogType x;
        public static final IntroDialogType y;
        public static final IntroDialogType z;

        public static IntroDialogType valueOf(String s1)
        {
            return (IntroDialogType)Enum.valueOf(com/cyberlink/youcammakeup/utility/IntroDialogUtils$IntroDialogType, s1);
        }

        public static IntroDialogType[] values()
        {
            return (IntroDialogType[])P.clone();
        }

        static 
        {
            a = new IntroDialogType("LOOKS", 0);
            b = new IntroDialogType("BLUSH", 1);
            c = new IntroDialogType("BLUSH_SKU", 2);
            d = new IntroDialogType("SKIN_TONER", 3);
            e = new IntroDialogType("SKIN_TONER_SKU", 4);
            f = new IntroDialogType("SHINE_REMOVAL", 5);
            g = new IntroDialogType("SKIN_SMOOTHENER", 6);
            h = new IntroDialogType("BLEMISH_REMOVAL", 7);
            i = new IntroDialogType("CONTOUR_NOSE", 8);
            j = new IntroDialogType("COUNTOUR_FACE", 9);
            k = new IntroDialogType("FACE_RESHAPER", 10);
            l = new IntroDialogType("FACE_RESHAPER_MANUAL", 11);
            m = new IntroDialogType("EYE_LINES", 12);
            n = new IntroDialogType("EYE_LINES_SKU", 13);
            o = new IntroDialogType("EYE_LASHES", 14);
            p = new IntroDialogType("EYE_LASHES_SKU", 15);
            q = new IntroDialogType("EYE_SHADOW", 16);
            r = new IntroDialogType("EYE_ENLARGER", 17);
            s = new IntroDialogType("EYE_SPARKLE", 18);
            t = new IntroDialogType("EYE_BAG_REMOVAL", 19);
            u = new IntroDialogType("RED_EYE_REMOVAL", 20);
            v = new IntroDialogType("EYE_BROW", 21);
            w = new IntroDialogType("EYE_BROW_SKU", 22);
            x = new IntroDialogType("EYE_CONTACT", 23);
            y = new IntroDialogType("EYE_CONTACT_SKU", 24);
            z = new IntroDialogType("DOUBLE_EYELID", 25);
            A = new IntroDialogType("LIP_STICK", 26);
            B = new IntroDialogType("LIP_STICK_SKU", 27);
            C = new IntroDialogType("TEETH_WHITENER", 28);
            D = new IntroDialogType("WIG", 29);
            E = new IntroDialogType("CAMERA_DETECT_HINT", 30);
            F = new IntroDialogType("CAMERA_GESTURE_HINT", 31);
            G = new IntroDialogType("CAMERA_LIVE_MAKEUP_HINT", 32);
            H = new IntroDialogType("EYE_WEAR", 33);
            I = new IntroDialogType("HAIR_BAND", 34);
            J = new IntroDialogType("NECKLACE", 35);
            K = new IntroDialogType("EARRINGS", 36);
            L = new IntroDialogType("HAIR_DYE", 37);
            M = new IntroDialogType("HAIR_DYE_BRUSH", 38);
            N = new IntroDialogType("FACE_ART", 39);
            O = new IntroDialogType("MUSTACHE", 40);
            P = (new IntroDialogType[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D, 
                E, F, G, H, I, J, K, L, M, N, 
                O
            });
        }

        private IntroDialogType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
