// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.i;
import com.cyberlink.youcammakeup.database.j;
import com.cyberlink.youcammakeup.database.l;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            DevelopSetting, h, CmdSetting

public class g
{

    public int a;
    private Long b;
    private DevelopSetting c;
    private ArrayList d;
    private boolean e;

    g(Long long1)
    {
        b = long1;
        c = DevelopSetting.a();
        d = new ArrayList();
        a = -1;
        e = false;
        c();
    }

    private ArrayList a(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        j j1;
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new h(j1.h(), j1.a())))
        {
            j1 = (j)collection.next();
        }

        return arraylist;
    }

    private boolean a(com.cyberlink.youcammakeup.jniproxy.j j1)
    {
        b("[_fixResolution_crop] ");
        d d1 = ViewEngine.a().a(b.longValue());
        int k = (int)d1.a.a;
        int i1 = (int)d1.a.b;
        return ((com.cyberlink.youcammakeup.jniproxy.g)j1).a(k, i1);
    }

    private void b(DevelopSetting developsetting)
    {
        if (c != null)
        {
            c.b();
            c = null;
        }
        c = developsetting;
        b((new StringBuilder()).append("this._curDevSetting: ").append(c).toString());
    }

    private void b(String s)
    {
    }

    private void c()
    {
        Object obj;
        if (com.cyberlink.youcammakeup.c.g() == null)
        {
            e = false;
            return;
        }
        obj = com.cyberlink.youcammakeup.c.g().b(b.longValue());
        d();
        d = a(((Collection) (obj)));
        b((new StringBuilder()).append("[_initFromDB] GetHistory imageID: ").append(b.toString()).append(" Length: ").append(((Collection) (obj)).size()).toString());
        obj = com.cyberlink.youcammakeup.c.g().a(b.longValue());
        if (obj == null) goto _L2; else goto _L1
_L1:
        int k;
        long l1;
        l1 = ((j) (obj)).a();
        k = 0;
_L7:
        if (k >= d.size()) goto _L2; else goto _L3
_L3:
        if (d.get(k) == null || l1 != ((h)d.get(k)).a) goto _L5; else goto _L4
_L4:
        a = k;
_L2:
        if (a == -1)
        {
            a = d.size() - 1;
        }
        if (a > -1)
        {
            b(DevelopSetting.a(((h)d.get(a)).b));
        } else
        {
            b(DevelopSetting.a());
            a(c);
        }
        b((new StringBuilder()).append("[_initFromDB] Finish imageID: ").append(b.toString()).toString());
        e = true;
        return;
_L5:
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean c(DevelopSetting developsetting)
    {
        Boolean boolean1;
        Integer integer;
        b("[_fixResolution] ");
        integer = Integer.valueOf(7);
        if (developsetting == null)
        {
            b("[_fixResolution] Skip due to developSetting is null.");
            return false;
        }
        boolean1 = Boolean.valueOf(true);
        if (!developsetting.containsKey(DevelopSetting.a) || !developsetting.containsKey(DevelopSetting.b)) goto _L2; else goto _L1
_L1:
        developsetting = (CmdSetting)developsetting.get(DevelopSetting.a);
        if (!developsetting.containsKey(integer)) goto _L2; else goto _L3
_L3:
        developsetting = Boolean.valueOf(a((com.cyberlink.youcammakeup.jniproxy.j)developsetting.get(integer)));
_L5:
        b((new StringBuilder()).append("[_fixResolution] bCropRet: ").append(developsetting.toString()).append(" bSkinPointRet: ").append(boolean1.toString()).toString());
        boolean flag;
        if (developsetting.booleanValue() && boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
_L2:
        developsetting = Boolean.valueOf(true);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void d()
    {
        if (c != null)
        {
            c.b();
            c = null;
        }
        c = DevelopSetting.a();
        if (d != null)
        {
            d.clear();
            d = null;
        }
        d = new ArrayList();
        a = -1;
    }

    public DevelopSetting a(boolean flag)
    {
        if (!e)
        {
            return null;
        }
        if (c.isEmpty())
        {
            c = DevelopSetting.a();
        }
        if (!c(c))
        {
            b("[queryCurrentDevSetting] _fixResolution Error");
        }
        if (flag)
        {
            return c.f();
        } else
        {
            return c;
        }
    }

    public boolean a()
    {
        if (!e)
        {
            return a("deleteAllHistorySteps");
        }
        if (com.cyberlink.youcammakeup.c.g().c(b.longValue()) >= 0)
        {
            b(DevelopSetting.a());
            a = -1;
            d.clear();
            b((new StringBuilder()).append("[deleteAllHistorySteps] Delete all steps in DB. ImageID: ").append(b.toString()).toString());
            return true;
        } else
        {
            return a("deleteAllHistorySteps");
        }
    }

    public boolean a(DevelopSetting developsetting)
    {
        if (developsetting == null || developsetting.isEmpty())
        {
            b("[pushHistoryStep] return because no data in developSetting");
            return false;
        }
        if (!developsetting.containsKey(DevelopSetting.a) || !developsetting.containsKey(DevelopSetting.b))
        {
            b("[pushHistoryStep] return because it's not a valid developSetting");
            return false;
        }
        String s = developsetting.c();
        h h1 = new h(s, -1L);
        d.add(h1);
        a = d.size() - 1;
        int j1 = a;
        b((new StringBuilder()).append("[pushHistoryStep] Push into Mem. ImageID: ").append(b.toString()).append(" developSetting: ").append(s).append(" index: ").append(Integer.toString(a)).toString());
        int k;
        int i1;
        if (!developsetting.d())
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (developsetting.e())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        developsetting = new l(k, i1, b.longValue(), new String(), new String(), new String(), s, new String());
        developsetting = com.cyberlink.youcammakeup.c.g().a(developsetting);
        if (developsetting != null)
        {
            long l1 = developsetting.a();
            ((h)d.get(j1)).a = l1;
            b((new StringBuilder()).append("[pushHistoryStep] Push into DB. imageID: ").append(b.toString()).append(" developSetting: ").append(s).append(" stepID: ").append(Long.toString(l1)).toString());
            return true;
        } else
        {
            b((new StringBuilder()).append("[pushHistoryStep] Error to add into DB. imageID: ").append(b.toString()).append(" developSetting: ").append(s).toString());
            return false;
        }
    }

    public boolean a(String s)
    {
        b((new StringBuilder()).append("[").append(s).append("] onDBErrorReturn!!!").toString());
        return false;
    }

    public boolean b()
    {
        if (a())
        {
            b(DevelopSetting.a());
            if (a(c))
            {
                return true;
            }
        }
        return false;
    }
}
