// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.state;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aq;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ay;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewBadgeState
{

    private final NetworkManager a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private HashMap e;
    private HashMap f;
    private HashMap g;
    private HashMap h;
    private long i;
    private HashMap j;

    public NewBadgeState(NetworkManager networkmanager)
    {
        i = 20117L;
        a = networkmanager;
        e = new HashMap();
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        networkmanager = BadgeDataType.values();
        int j1 = networkmanager.length;
        for (int k = 0; k < j1; k++)
        {
            BadgeDataType badgedatatype = networkmanager[k];
            long l1 = z.b(a(badgedatatype), Long.valueOf(0L), Globals.d()).longValue();
            b.put(badgedatatype, Long.valueOf(l1));
        }

        networkmanager = BadgeViewType.values();
        j1 = networkmanager.length;
        for (int l = 0; l < j1; l++)
        {
            BadgeViewType badgeviewtype = networkmanager[l];
            long l2 = z.b(c(badgeviewtype), Long.valueOf(0L), Globals.d()).longValue();
            if (badgeviewtype == BadgeViewType.b)
            {
                l2 = i;
            }
            c.put(badgeviewtype, Long.valueOf(l2));
        }

        networkmanager = BadgeItemType.values();
        j1 = networkmanager.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            BadgeItemType badgeitemtype = networkmanager[i1];
            boolean flag = z.a(c(badgeitemtype), false, Globals.d());
            d.put(badgeitemtype, Boolean.valueOf(flag));
        }

        j = new HashMap();
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20003)).toString(), Long.valueOf(20117L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20004)).toString(), Long.valueOf(20117L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20005)).toString(), Long.valueOf(20117L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20006)).toString(), Long.valueOf(20116L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20007)).toString(), Long.valueOf(20099L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20008)).toString(), Long.valueOf(20107L));
        j.put((new StringBuilder()).append(BeautyTipCategoryActivity.a).append("_").append(String.valueOf(20009)).toString(), Long.valueOf(20115L));
    }

    private static final String a(BadgeDataType badgedatatype)
    {
        return (new StringBuilder()).append("NewBadgeState.Server_MAX_TID(").append(badgedatatype.toString()).append(")").toString();
    }

    private static final String a(String s)
    {
        return (new StringBuilder()).append("NewBadgeState.Server_MAX_ID(").append(s).append(")").toString();
    }

    private void a()
    {
        boolean flag1 = ((Boolean)d.get(BadgeItemType.c)).booleanValue();
        boolean flag;
        if (!flag1)
        {
            long l = ((Long)c.get(BadgeViewType.c)).longValue();
            if (((Long)b.get(BadgeDataType.c)).longValue() > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                d.put(BadgeItemType.c, Boolean.valueOf(true));
                z.a(c(BadgeItemType.c), Boolean.valueOf(flag), Globals.d());
            }
            flag1 = flag;
        }
        flag = ((Boolean)d.get(BadgeItemType.b)).booleanValue();
        if (!flag)
        {
            l = ((Long)c.get(BadgeViewType.a)).longValue();
            if (((Long)b.get(BadgeDataType.a)).longValue() > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                d.put(BadgeItemType.b, Boolean.valueOf(true));
                z.a(c(BadgeItemType.b), Boolean.valueOf(flag), Globals.d());
                d.put(BadgeItemType.e, Boolean.valueOf(true));
                z.a(c(BadgeItemType.e), Boolean.valueOf(flag), Globals.d());
            }
        }
        if (!((Boolean)d.get(BadgeItemType.a)).booleanValue())
        {
            if (flag1 || flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                d.put(BadgeItemType.a, Boolean.valueOf(true));
                z.a(c(BadgeItemType.a), Boolean.valueOf(flag), Globals.d());
            }
        }
        if (!((Boolean)d.get(BadgeItemType.d)).booleanValue())
        {
            l = ((Long)c.get(BadgeViewType.b)).longValue();
            if (((Long)b.get(BadgeDataType.b)).longValue() > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                d.put(BadgeItemType.d, Boolean.valueOf(true));
                z.a(c(BadgeItemType.d), Boolean.valueOf(flag), Globals.d());
            }
        }
    }

    private void a(String s, String s1)
    {
        String s2 = (new StringBuilder()).append(s).append("_").append(s1).toString();
        if (!e.containsKey(s2))
        {
            Long long1 = z.b(a(s2), Long.valueOf(0L), Globals.d());
            e.put(s2, long1);
            long1 = z.b(b(s2), Long.valueOf(0L), Globals.d());
            if (j.containsKey(s2))
            {
                long1 = (Long)j.get(s2);
            }
            f.put(s2, long1);
            boolean flag = z.a(c(s2), false, Globals.d());
            g.put(s2, Boolean.valueOf(flag));
            if (!h.containsKey(s))
            {
                h.put(s, new ArrayList());
            }
            long1 = Long.valueOf(s1);
            if (!((ArrayList)h.get(s)).contains(s1))
            {
                ((ArrayList)h.get(s)).add(long1);
                return;
            }
        }
    }

    private static final String b(String s)
    {
        return (new StringBuilder()).append("NewBadgeState.Seen_MAX_ID(").append(s).append(")").toString();
    }

    private boolean b(BadgeDataType badgedatatype, long l)
    {
        long l1 = ((Long)b.get(badgedatatype)).longValue();
        if (l1 == l)
        {
            return false;
        }
        if (l1 > l)
        {
            return false;
        } else
        {
            b.put(badgedatatype, Long.valueOf(l));
            z.a(a(badgedatatype), Long.valueOf(l), Globals.d());
            return true;
        }
    }

    private static final String c(BadgeItemType badgeitemtype)
    {
        return (new StringBuilder()).append("NewBadgeState.IS_NEW(").append(badgeitemtype.toString()).append(")").toString();
    }

    private static final String c(BadgeViewType badgeviewtype)
    {
        return (new StringBuilder()).append("NewBadgeState.Seen_MAX_TID(").append(badgeviewtype.toString()).append(")").toString();
    }

    private static final String c(String s)
    {
        return (new StringBuilder()).append("NewBadgeState.IS_NEW(").append(s).append(")").toString();
    }

    private BadgeDataType d(BadgeViewType badgeviewtype)
    {
        if (badgeviewtype == BadgeViewType.a)
        {
            return BadgeDataType.a;
        }
        if (badgeviewtype == BadgeViewType.b)
        {
            return BadgeDataType.b;
        } else
        {
            return null;
        }
    }

    private void d(String s)
    {
        if (!((Boolean)g.get(s)).booleanValue())
        {
            long l = ((Long)f.get(s)).longValue();
            boolean flag;
            if (((Long)e.get(s)).longValue() > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                g.put(s, Boolean.valueOf(true));
                z.a(c(s), Boolean.valueOf(flag), Globals.d());
            }
        }
    }

    private boolean e(String s, long l)
    {
        long l1 = ((Long)e.get(s)).longValue();
        if (l1 == l)
        {
            return false;
        }
        if (l1 > l)
        {
            return false;
        } else
        {
            e.put(s, Long.valueOf(l));
            z.a(a(s), Long.valueOf(l), Globals.d());
            return true;
        }
    }

    public void a(BadgeDataType badgedatatype, long l)
    {
        if (false | b(badgedatatype, l))
        {
            a();
            a.J();
        }
    }

    public void a(BadgeDataType badgedatatype, long l, String s, Map map)
    {
        if (b(badgedatatype, l) | false)
        {
            a();
            a.J();
        }
        if (map != null)
        {
            badgedatatype = map.entrySet().iterator();
            do
            {
                if (!badgedatatype.hasNext())
                {
                    break;
                }
                map = (java.util.Map.Entry)badgedatatype.next();
                l = ((Long)map.getValue()).longValue();
                long l1 = ((Long)map.getKey()).longValue();
                a(s, String.valueOf(l1));
                map = (new StringBuilder()).append(s).append("_").append(String.valueOf(l1)).toString();
                if (e(map, l) | false)
                {
                    d(map);
                    a.J();
                }
            } while (true);
        }
    }

    public void a(BadgeViewType badgeviewtype)
    {
        BadgeDataType badgedatatype = d(badgeviewtype);
        long l = ((Long)b.get(badgedatatype)).longValue();
        c.put(badgeviewtype, Long.valueOf(l));
        z.a(c(badgeviewtype), Long.valueOf(l), Globals.d());
    }

    public void a(ap ap1)
    {
        ap1 = ap1.e();
        if (ap1 != null)
        {
            long l = ap1.a();
            if (b(BadgeDataType.a, l) | false)
            {
                a();
                a.J();
            }
        }
    }

    public void a(ay ay1)
    {
        long l = ay1.j();
        if (false | b(BadgeDataType.a, l))
        {
            a();
            a.J();
        }
    }

    public void a(String s, Map map)
    {
        if (map != null)
        {
            map = map.entrySet().iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)map.next();
                long l = ((Long)((java.util.Map.Entry) (obj)).getValue()).longValue();
                long l1 = ((Long)((java.util.Map.Entry) (obj)).getKey()).longValue();
                a(s, String.valueOf(l1));
                obj = (new StringBuilder()).append(s).append("_").append(String.valueOf(l1)).toString();
                if (false | e(((String) (obj)), l))
                {
                    d(((String) (obj)));
                    a.J();
                }
            } while (true);
        }
    }

    public void a(List list)
    {
        boolean flag = false;
        BadgeItemType abadgeitemtype[] = BadgeItemType.values();
        int l = abadgeitemtype.length;
        int k = 0;
        while (k < l) 
        {
            BadgeItemType badgeitemtype = abadgeitemtype[k];
            if (list == null || !list.contains(badgeitemtype))
            {
                b(badgeitemtype);
            }
            k++;
        }
        list = BadgeViewType.values();
        l = list.length;
        k = ((flag) ? 1 : 0);
        while (k < l) 
        {
            BadgeViewType badgeviewtype = list[k];
            if (d(badgeviewtype) != null)
            {
                a(badgeviewtype);
            }
            k++;
        }
        for (list = h.entrySet().iterator(); list.hasNext();)
        {
            Object obj = (java.util.Map.Entry)list.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((ArrayList)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Long long1 = (Long)((Iterator) (obj)).next();
                b(s, long1.longValue());
                d(s, long1.longValue());
            }
        }

    }

    public boolean a(BadgeItemType badgeitemtype)
    {
        return ((Boolean)d.get(badgeitemtype)).booleanValue();
    }

    public boolean a(String s, long l)
    {
        s = (new StringBuilder()).append(s).append("_").append(l).toString();
        if (!g.containsKey(s))
        {
            return false;
        } else
        {
            return ((Boolean)g.get(s)).booleanValue();
        }
    }

    public long b(BadgeViewType badgeviewtype)
    {
        badgeviewtype = (Long)c.get(badgeviewtype);
        if (badgeviewtype != null)
        {
            return badgeviewtype.longValue();
        } else
        {
            return 0L;
        }
    }

    public void b(BadgeItemType badgeitemtype)
    {
        d.put(badgeitemtype, Boolean.valueOf(false));
        z.a(c(badgeitemtype), Boolean.valueOf(false), Globals.d());
    }

    public void b(String s, long l)
    {
        s = (new StringBuilder()).append(s).append("_").append(l).toString();
        g.put(s, Boolean.valueOf(false));
        z.a(c(s), Boolean.valueOf(false), Globals.d());
    }

    public long c(String s, long l)
    {
        s = (new StringBuilder()).append(s).append("_").append(l).toString();
        s = (Long)f.get(s);
        if (s != null)
        {
            return s.longValue();
        } else
        {
            return 0L;
        }
    }

    public void d(String s, long l)
    {
        s = (new StringBuilder()).append(s).append("_").append(l).toString();
        if (e.size() > 0 && e.containsKey(s))
        {
            l = ((Long)e.get(s)).longValue();
        } else
        {
            l = 0L;
        }
        f.put(s, Long.valueOf(l));
        z.a(b(s), Long.valueOf(l), Globals.d());
    }

    private class BadgeDataType extends Enum
    {

        public static final BadgeDataType a;
        public static final BadgeDataType b;
        public static final BadgeDataType c;
        private static final BadgeDataType d[];

        public static BadgeDataType valueOf(String s)
        {
            return (BadgeDataType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/state/NewBadgeState$BadgeDataType, s);
        }

        public static BadgeDataType[] values()
        {
            return (BadgeDataType[])d.clone();
        }

        static 
        {
            a = new BadgeDataType("Notice", 0);
            b = new BadgeDataType("BeautyTip", 1);
            c = new BadgeDataType("Extra", 2);
            d = (new BadgeDataType[] {
                a, b, c
            });
        }

        private BadgeDataType(String s, int k)
        {
            super(s, k);
        }
    }


    private class BadgeViewType extends Enum
    {

        public static final BadgeViewType a;
        public static final BadgeViewType b;
        public static final BadgeViewType c;
        private static final BadgeViewType d[];

        public static BadgeViewType valueOf(String s)
        {
            return (BadgeViewType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/state/NewBadgeState$BadgeViewType, s);
        }

        public static BadgeViewType[] values()
        {
            return (BadgeViewType[])d.clone();
        }

        static 
        {
            a = new BadgeViewType("NoticeView", 0);
            b = new BadgeViewType("BeautyTipView", 1);
            c = new BadgeViewType("ExtraView", 2);
            d = (new BadgeViewType[] {
                a, b, c
            });
        }

        private BadgeViewType(String s, int k)
        {
            super(s, k);
        }
    }


    private class BadgeItemType extends Enum
    {

        public static final BadgeItemType a;
        public static final BadgeItemType b;
        public static final BadgeItemType c;
        public static final BadgeItemType d;
        public static final BadgeItemType e;
        private static final BadgeItemType f[];

        public static BadgeItemType valueOf(String s)
        {
            return (BadgeItemType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/state/NewBadgeState$BadgeItemType, s);
        }

        public static BadgeItemType[] values()
        {
            return (BadgeItemType[])f.clone();
        }

        static 
        {
            a = new BadgeItemType("MoreItem", 0);
            b = new BadgeItemType("NoticeItem", 1);
            c = new BadgeItemType("ExtrasItem", 2);
            d = new BadgeItemType("BeautyTipItem", 3);
            e = new BadgeItemType("LauncherSettingItem", 4);
            f = (new BadgeItemType[] {
                a, b, c, d, e
            });
        }

        private BadgeItemType(String s, int k)
        {
            super(s, k);
        }
    }

}
