// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.as;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.at;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.au;
import com.cyberlink.youcammakeup.utility.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            x, v, w

public class MakeupItemTreeManager
{

    public static long a = -1L;
    private static String b = "MakeupItemTreeManager";
    private Map c;
    private Map d;
    private Map e;

    private MakeupItemTreeManager()
    {
        c = new HashMap();
        d = new HashMap();
        DisplayMakeupType adisplaymakeuptype[] = DisplayMakeupType.values();
        int k = adisplaymakeuptype.length;
        for (int i = 0; i < k; i++)
        {
            DisplayMakeupType displaymakeuptype = adisplaymakeuptype[i];
            c.put(displaymakeuptype, ah.a(displaymakeuptype));
            d.put(displaymakeuptype, ah.b(displaymakeuptype));
        }

        e = new HashMap();
        adisplaymakeuptype = DisplayMakeupType.values();
        k = adisplaymakeuptype.length;
        for (int j = 0; j < k; j++)
        {
            DisplayMakeupType displaymakeuptype1 = adisplaymakeuptype[j];
            if (d.get(displaymakeuptype1) != null)
            {
                a((au)d.get(displaymakeuptype1));
            }
        }

    }


    private long a(at at1)
    {
        long l1 = 0L;
        if (at1 == null)
        {
            return 0L;
        }
        Object obj1 = at1.c();
        Object obj = at1.d();
        long l = l1;
        if (obj1 != null)
        {
            l = l1;
            if (((List) (obj1)).size() > 0)
            {
                obj1 = ((List) (obj1)).iterator();
                l = 0L;
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    as as1 = (as)((Iterator) (obj1)).next();
                    if (as1.a() > l)
                    {
                        l = as1.a();
                    }
                } while (true);
            }
        }
        l1 = l;
        if (obj != null)
        {
            l1 = l;
            if (((List) (obj)).size() > 0)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    l1 = a((at)((Iterator) (obj)).next());
                    if (l1 > l)
                    {
                        l = l1;
                    }
                } while (true);
                l1 = l;
            }
        }
        e.put(Long.valueOf(at1.a()), Long.valueOf(l1));
        return l1;
    }

    private b a(MKCategoryV2Status mkcategoryv2status, long l)
    {
        mkcategoryv2status = new LinkedList(mkcategoryv2status.c().values());
        do
        {
            if (mkcategoryv2status.size() <= 0)
            {
                break;
            }
            Object obj = (b)mkcategoryv2status.pollFirst();
            if (obj != null && ((b) (obj)).a() == l)
            {
                return ((b) (obj));
            }
            obj = ((b) (obj)).g();
            if (obj != null && ((Map) (obj)).size() > 0)
            {
                mkcategoryv2status.addAll(((Map) (obj)).values());
            }
        } while (true);
        return null;
    }

    public static MakeupItemTreeManager a()
    {
        return x.a();
    }

    private at a(au au1, long l)
    {
        au1 = new LinkedList(au1.a());
        do
        {
            if (au1.size() <= 0)
            {
                break;
            }
            Object obj = (at)au1.pollFirst();
            if (((at) (obj)).a() == l)
            {
                return ((at) (obj));
            }
            obj = ((at) (obj)).d();
            if (obj != null && ((List) (obj)).size() > 0)
            {
                au1.addAll(((java.util.Collection) (obj)));
            }
        } while (true);
        return null;
    }

    private void a(au au1)
    {
        at at1 = new at();
        at1.a(b(au1, a));
        a(at1);
        for (au1 = e.keySet().iterator(); au1.hasNext();)
        {
            Long long1 = (Long)au1.next();
            long1 = (Long)e.get(long1);
        }

    }

    private List b(au au1, long l)
    {
        au1 = au1.a();
        if (l == a)
        {
            return au1;
        }
        au1 = new LinkedList(au1);
        do
        {
            if (au1.size() <= 0)
            {
                break;
            }
            Object obj = (at)au1.pollFirst();
            if (obj != null && ((at) (obj)).a() == l)
            {
                return ((at) (obj)).d();
            }
            obj = ((at) (obj)).d();
            if (obj != null && ((List) (obj)).size() > 0)
            {
                au1.addAll(((java.util.Collection) (obj)));
            }
        } while (true);
        return null;
    }

    public long a(DisplayMakeupType displaymakeuptype)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = c.get(displaymakeuptype);
        if (obj != null) goto _L2; else goto _L1
_L1:
        long l = -1L;
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        l = ((MKCategoryV2Status)c.get(displaymakeuptype)).a();
        if (true) goto _L4; else goto _L3
_L3:
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public void a(DisplayMakeupType displaymakeuptype, MKCategoryV2Status mkcategoryv2status)
    {
        this;
        JVM INSTR monitorenter ;
        c.put(displaymakeuptype, mkcategoryv2status);
        this;
        JVM INSTR monitorexit ;
        return;
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public void a(DisplayMakeupType displaymakeuptype, au au1)
    {
        this;
        JVM INSTR monitorenter ;
        d.put(displaymakeuptype, au1);
        if (d.get(displaymakeuptype) != null)
        {
            a((au)d.get(displaymakeuptype));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public boolean a(DisplayMakeupType displaymakeuptype, long l)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (d.get(displaymakeuptype) == null) goto _L2; else goto _L1
_L1:
        Object obj = c.get(displaymakeuptype);
        if (obj != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        long l1 = a(displaymakeuptype);
        flag = flag1;
        if (l1 >= l)
        {
            flag = true;
        }
        if (true) goto _L2; else goto _L5
_L5:
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public List b(DisplayMakeupType displaymakeuptype, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.get(displaymakeuptype) != null && c.get(displaymakeuptype) != null) goto _L2; else goto _L1
_L1:
        displaymakeuptype = new ArrayList();
_L6:
        this;
        JVM INSTR monitorexit ;
        return displaymakeuptype;
_L2:
        ArrayList arraylist;
        List list;
        arraylist = new ArrayList();
        list = b((au)d.get(displaymakeuptype), l);
        if (list == null) goto _L4; else goto _L3
_L3:
        int j = list.size();
        int i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L5
_L5:
        Object obj = (at)list.get(i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        v v1;
        v1 = new v();
        v1.a = ((at) (obj)).a();
        v1.c = ((at) (obj)).b();
        obj = a((MKCategoryV2Status)c.get(displaymakeuptype), v1.a);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        v1.b = ((b) (obj)).e();
        v1.d = ((b) (obj)).b();
        arraylist.add(v1);
        break MISSING_BLOCK_LABEL_217;
        displaymakeuptype;
        throw displaymakeuptype;
_L4:
        displaymakeuptype = arraylist;
          goto _L6
        i++;
          goto _L7
    }

    public Map b()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = e;
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(DisplayMakeupType displaymakeuptype)
    {
        this;
        JVM INSTR monitorenter ;
        if (c.get(displaymakeuptype) != null)
        {
            ah.a(displaymakeuptype, (MKCategoryV2Status)c.get(displaymakeuptype));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public v c(DisplayMakeupType displaymakeuptype, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.get(displaymakeuptype) == null) goto _L2; else goto _L1
_L1:
        Object obj = c.get(displaymakeuptype);
        if (obj != null) goto _L3; else goto _L2
_L2:
        displaymakeuptype = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return displaymakeuptype;
_L3:
        at at1 = a((au)d.get(displaymakeuptype), l);
        if (at1 == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        obj = new v();
        obj.a = at1.a();
        obj.c = at1.b();
        displaymakeuptype = a((MKCategoryV2Status)c.get(displaymakeuptype), ((v) (obj)).a);
        if (displaymakeuptype == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        obj.b = displaymakeuptype.e();
        obj.d = displaymakeuptype.b();
        displaymakeuptype = ((DisplayMakeupType) (obj));
        continue; /* Loop/switch isn't completed */
        displaymakeuptype;
        throw displaymakeuptype;
        displaymakeuptype = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void c(DisplayMakeupType displaymakeuptype)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.get(displaymakeuptype) != null)
        {
            ah.a(displaymakeuptype, (au)d.get(displaymakeuptype));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        displaymakeuptype;
        throw displaymakeuptype;
    }

    public List d(DisplayMakeupType displaymakeuptype, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.get(displaymakeuptype) != null && c.get(displaymakeuptype) != null) goto _L2; else goto _L1
_L1:
        displaymakeuptype = new ArrayList();
_L8:
        this;
        JVM INSTR monitorexit ;
        return displaymakeuptype;
_L2:
        ArrayList arraylist;
        arraylist = new ArrayList();
        displaymakeuptype = a((au)d.get(displaymakeuptype), l);
        if (displaymakeuptype == null) goto _L4; else goto _L3
_L3:
        displaymakeuptype = displaymakeuptype.c();
        if (displaymakeuptype == null) goto _L4; else goto _L5
_L5:
        if (displaymakeuptype.size() <= 0) goto _L4; else goto _L6
_L6:
        int j = displaymakeuptype.size();
        int i = 0;
_L9:
        if (i >= j) goto _L4; else goto _L7
_L7:
        as as1 = (as)displaymakeuptype.get(i);
        if (as1 == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        w w1 = new w();
        w1.a = as1.a();
        w1.b = as1.b();
        arraylist.add(w1);
        break MISSING_BLOCK_LABEL_182;
        displaymakeuptype;
        throw displaymakeuptype;
_L4:
        displaymakeuptype = arraylist;
          goto _L8
        i++;
          goto _L9
    }


    private class DisplayMakeupType extends Enum
    {

        public static final DisplayMakeupType a;
        public static final DisplayMakeupType b;
        public static final DisplayMakeupType c;
        private static final DisplayMakeupType d[];

        public static DisplayMakeupType valueOf(String s)
        {
            return (DisplayMakeupType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/MakeupItemTreeManager$DisplayMakeupType, s);
        }

        public static DisplayMakeupType[] values()
        {
            return (DisplayMakeupType[])d.clone();
        }

        static 
        {
            a = new DisplayMakeupType("All", 0);
            b = new DisplayMakeupType("Edit", 1);
            c = new DisplayMakeupType("Live", 2);
            d = (new DisplayMakeupType[] {
                a, b, c
            });
        }

        private DisplayMakeupType(String s, int i)
        {
            super(s, i);
        }
    }

}
