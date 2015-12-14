// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKSavingPageEvent extends BaseEvent
{

    public static long b;
    private static String c;
    private static FacedetectionClick d;
    private static PageType e;
    private static String f = "No";
    private static String g = "original";
    private static boolean h = false;
    private static boolean i = false;
    private static int j;
    private static boolean k = true;
    private static boolean l = true;

    public YMKSavingPageEvent(long l1, long l2, Operation operation, boolean flag, boolean flag1)
    {
        super("YMK_SavingPage");
        HashMap hashmap = new HashMap();
        hashmap.put("source", c);
        hashmap.put("operation", operation.a());
        if (operation == Operation.e)
        {
            String s;
            if (h)
            {
                s = "yes";
            } else
            {
                s = "no";
            }
            hashmap.put("facedetection_show", s);
        } else
        {
            hashmap.put("pagetype", e.a());
        }
        if (flag && e == PageType.a)
        {
            hashmap.put("look", g);
        }
        if (flag1)
        {
            hashmap.put("change", f);
        }
        if (operation == Operation.f)
        {
            hashmap.put("facedetection_click", d.a());
        }
        l1 = l2 - l1;
        if (l1 > 0L)
        {
            hashmap.put("staytime", String.valueOf(l1));
        }
        if (e == PageType.a && operation == Operation.b)
        {
            if (i)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("intensity_change", operation);
            hashmap.put("intensity_value", String.valueOf(j));
        }
        hashmap.put("ver", "4");
        a(hashmap);
    }

    public YMKSavingPageEvent(PageType pagetype)
    {
        super("YMK_SavingPage");
        if (pagetype == PageType.a)
        {
            k = false;
        }
        if (pagetype == PageType.b)
        {
            l = false;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("operation", "pageshow");
        hashmap.put("pagetype", pagetype.a());
        hashmap.put("ver", "4");
        a(hashmap);
    }

    public static void a(int i1)
    {
        j = i1;
    }

    public static void a(FacedetectionClick facedetectionclick)
    {
        d = facedetectionclick;
    }

    public static void a(PageType pagetype)
    {
        e = pagetype;
    }

    public static void a(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "Yes";
        } else
        {
            s = "No";
        }
        f = s;
    }

    public static void b(String s)
    {
        c = s;
    }

    public static void b(boolean flag)
    {
        h = flag;
    }

    public static void c(String s)
    {
        g = s;
    }

    public static void c(boolean flag)
    {
        i = flag;
    }

    public static void d()
    {
        k = true;
        l = true;
    }

    public static boolean e()
    {
        return k;
    }

    public static boolean f()
    {
        return l;
    }

    public static String g()
    {
        return c;
    }

    public YMKSavingPageEvent d(String s)
    {
        a.put("look", s);
        return this;
    }

    static 
    {
        c = Source.b.a();
        d = FacedetectionClick.a;
        e = PageType.a;
    }

    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        public static final Operation c;
        public static final Operation d;
        public static final Operation e;
        public static final Operation f;
        public static final Operation g;
        public static final Operation h;
        public static final Operation i;
        public static final Operation j;
        public static final Operation k;
        public static final Operation l;
        public static final Operation m;
        public static final Operation n;
        public static final Operation o;
        public static final Operation p;
        private static final Operation q[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])q.clone();
        }

        public abstract String a();

        static 
        {
            a = new Operation("Back", 0) {

                public String a()
                {
                    return "back";
                }

            };
            b = new Operation("SavePhoto", 1) {

                public String a()
                {
                    return "savephoto";
                }

            };
            c = new Operation("Compare", 2) {

                public String a()
                {
                    return "compare";
                }

            };
            d = new Operation("SaveMyLook", 3) {

                public String a()
                {
                    return "saveMyLook";
                }

            };
            e = new Operation("Show", 4) {

                public String a()
                {
                    return "show";
                }

            };
            f = new Operation("Detect", 5) {

                public String a()
                {
                    return "detect";
                }

            };
            g = new Operation("Tab_Looks", 6) {

                public String a()
                {
                    return "tab_looks";
                }

            };
            h = new Operation("Tab_FeatureRoom", 7) {

                public String a()
                {
                    return "tab_featureroom";
                }

            };
            i = new Operation("Tab_Natural", 8) {

                public String a()
                {
                    return "tab_natural";
                }

            };
            j = new Operation("Tab_Costume", 9) {

                public String a()
                {
                    return "tab_costume";
                }

            };
            k = new Operation("FineTune", 10) {

                public String a()
                {
                    return "finetune";
                }

            };
            l = new Operation("Redo", 11) {

                public String a()
                {
                    return "redo";
                }

            };
            m = new Operation("Undo", 12) {

                public String a()
                {
                    return "undo";
                }

            };
            n = new Operation("LooksClick", 13) {

                public String a()
                {
                    return "looksclick";
                }

            };
            o = new Operation("HowTo", 14) {

                public String a()
                {
                    return "how_to";
                }

            };
            p = new Operation("More", 15) {

                public String a()
                {
                    return "more";
                }

            };
            q = (new Operation[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p
            });
        }

        private Operation(String s, int i1)
        {
            super(s, i1);
        }

    }


    private class PageType extends Enum
    {

        public static final PageType a;
        public static final PageType b;
        private static final PageType c[];

        public static PageType valueOf(String s)
        {
            return (PageType)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$PageType, s);
        }

        public static PageType[] values()
        {
            return (PageType[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new PageType("Looks", 0) {

                public String a()
                {
                    return "looks";
                }

            };
            b = new PageType("FeatureRoom", 1) {

                public String a()
                {
                    return "featureroom";
                }

            };
            c = (new PageType[] {
                a, b
            });
        }

        private PageType(String s, int i1)
        {
            super(s, i1);
        }

    }


    private class FacedetectionClick extends Enum
    {

        public static final FacedetectionClick a;
        public static final FacedetectionClick b;
        public static final FacedetectionClick c;
        private static final FacedetectionClick d[];

        public static FacedetectionClick valueOf(String s)
        {
            return (FacedetectionClick)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$FacedetectionClick, s);
        }

        public static FacedetectionClick[] values()
        {
            return (FacedetectionClick[])d.clone();
        }

        public abstract String a();

        static 
        {
            a = new FacedetectionClick("Manual", 0) {

                public String a()
                {
                    return "manual";
                }

            };
            b = new FacedetectionClick("ReSelect", 1) {

                public String a()
                {
                    return "reselect";
                }

            };
            c = new FacedetectionClick("ReTake", 2) {

                public String a()
                {
                    return "retake";
                }

            };
            d = (new FacedetectionClick[] {
                a, b, c
            });
        }

        private FacedetectionClick(String s, int i1)
        {
            super(s, i1);
        }

    }


    private class Source extends Enum
    {

        public static final Source a;
        public static final Source b;
        public static final Source c;
        public static final Source d;
        public static final Source e;
        public static final Source f;
        public static final Source g;
        private static final Source h[];

        public static Source valueOf(String s)
        {
            return (Source)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$Source, s);
        }

        public static Source[] values()
        {
            return (Source[])h.clone();
        }

        public abstract String a();

        static 
        {
            a = new Source("LiveCam", 0) {

                public String a()
                {
                    return "liveCam";
                }

            };
            b = new Source("LivePhoto", 1) {

                public String a()
                {
                    return "livePhoto";
                }

            };
            c = new Source("Natural", 2) {

                public String a()
                {
                    return "natural";
                }

            };
            d = new Source("Costume", 3) {

                public String a()
                {
                    return "costume";
                }

            };
            e = new Source("ResultPageLib", 4) {

                public String a()
                {
                    return "resultpageLib";
                }

            };
            f = new Source("StoreNatural", 5) {

                public String a()
                {
                    return "store_natural";
                }

            };
            g = new Source("StoreCostume", 6) {

                public String a()
                {
                    return "store_costume";
                }

            };
            h = (new Source[] {
                a, b, c, d, e, f, g
            });
        }

        private Source(String s, int i1)
        {
            super(s, i1);
        }

    }

}
