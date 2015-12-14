// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKLauncherEvent extends BaseEvent
{

    public static String b = "Launcher";
    public static String c = "4";
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;

    public YMKLauncherEvent(TileType tiletype, Operation operation)
    {
        super("YMK_Launcher");
        HashMap hashmap = new HashMap();
        hashmap.put("tileType", tiletype.a());
        hashmap.put("operation", operation.a());
        hashmap.put("ver", c);
        if (TileType.m == tiletype)
        {
            if (g)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("ycp", operation);
            if (h)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("ycn", operation);
            if (f)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("weeklystar_show", operation);
        } else
        {
            if (d)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("slide", operation);
            if (e)
            {
                operation = "yes";
            } else
            {
                operation = "no";
            }
            hashmap.put("reddot", operation);
        }
        if (tiletype.a().equals(TileType.l.a()) && !b.equals("Launcher"))
        {
            return;
        } else
        {
            a(hashmap);
            return;
        }
    }

    public static void a(boolean flag)
    {
        d = flag;
    }

    public static void b(String s)
    {
        b = s;
    }

    public static void b(boolean flag)
    {
        e = flag;
    }

    public static void c(boolean flag)
    {
        f = flag;
    }

    public static void d(boolean flag)
    {
        g = flag;
    }

    public static void e(boolean flag)
    {
        h = flag;
    }


    private class TileType extends Enum
    {

        public static final TileType a;
        public static final TileType b;
        public static final TileType c;
        public static final TileType d;
        public static final TileType e;
        public static final TileType f;
        public static final TileType g;
        public static final TileType h;
        public static final TileType i;
        public static final TileType j;
        public static final TileType k;
        public static final TileType l;
        public static final TileType m;
        public static final TileType n;
        private static final TileType o[];

        public static TileType valueOf(String s)
        {
            return (TileType)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLauncherEvent$TileType, s);
        }

        public static TileType[] values()
        {
            return (TileType[])o.clone();
        }

        public abstract String a();

        static 
        {
            a = new TileType("Cam", 0) {

                public String a()
                {
                    return "Cam";
                }

            };
            b = new TileType("Natural", 1) {

                public String a()
                {
                    return "Natural";
                }

            };
            c = new TileType("Looks", 2) {

                public String a()
                {
                    return "Looks";
                }

            };
            d = new TileType("Costume", 3) {

                public String a()
                {
                    return "Costume";
                }

            };
            e = new TileType("YCP", 4) {

                public String a()
                {
                    return "ycp";
                }

            };
            f = new TileType("YCN", 5) {

                public String a()
                {
                    return "ycn";
                }

            };
            g = new TileType("Tips", 6) {

                public String a()
                {
                    return "Tips";
                }

            };
            h = new TileType("BC", 7) {

                public String a()
                {
                    return "BC";
                }

            };
            i = new TileType("Notice", 8) {

                public String a()
                {
                    return "Notice";
                }

            };
            j = new TileType("Recom", 9) {

                public String a()
                {
                    return "Recom";
                }

            };
            k = new TileType("Setting", 10) {

                public String a()
                {
                    return "Setting";
                }

            };
            l = new TileType("Banner", 11) {

                public String a()
                {
                    return "Banner";
                }

            };
            m = new TileType("Launcher", 12) {

                public String a()
                {
                    return "Launcher";
                }

            };
            n = new TileType("WeeklyStar", 13) {

                public String a()
                {
                    return "weeklystar";
                }

            };
            o = (new TileType[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n
            });
        }

        private TileType(String s, int i1)
        {
            super(s, i1);
        }

    }


    private class Operation extends Enum
    {

        public static final Operation a;
        public static final Operation b;
        private static final Operation c[];

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLauncherEvent$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])c.clone();
        }

        public abstract String a();

        static 
        {
            a = new Operation("Show", 0) {

                public String a()
                {
                    return "show";
                }

            };
            b = new Operation("Click", 1) {

                public String a()
                {
                    return "click";
                }

            };
            c = (new Operation[] {
                a, b
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }

    }

}
