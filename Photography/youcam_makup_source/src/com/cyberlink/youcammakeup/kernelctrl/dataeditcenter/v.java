// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import android.util.SparseArray;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            i, d

public class v
{

    private final int a;
    private int b;
    private Boolean c;
    private String d;
    private final List e = new ArrayList();
    private String f;
    private final SparseArray g = new SparseArray();
    private final SparseArray h = new SparseArray();
    private final SparseArray i = new SparseArray();
    private d j;
    private i k;
    private Integer l;

    public v(BeautyMode beautymode)
    {
        a(beautymode);
        a = beautymode.ordinal();
        b = -1;
        a(((String) (null)));
        b(((String) (null)));
        j = null;
        k = new i();
        c = null;
        l = null;
    }

    private static void a(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Parameter cannot be null!!");
        } else
        {
            return;
        }
    }

    public at a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        a(switchermode);
        return (at)g.get(switchermode.ordinal());
    }

    public Integer a(int i1)
    {
        if (i1 < 0)
        {
            return Integer.valueOf(-1);
        } else
        {
            return (Integer)h.get(i1);
        }
    }

    public String a()
    {
        return d;
    }

    public void a(d d1)
    {
        if (d1 != null)
        {
            j = d1.c();
            return;
        } else
        {
            j = null;
            return;
        }
    }

    public void a(i i1)
    {
        k = new i(i1);
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1)
    {
        a(switchermode);
        g.put(switchermode.ordinal(), at1);
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, at at1, Integer integer, Integer integer1)
    {
        a(switchermode);
        a(switchermode, at1);
        a(switchermode, integer);
        b(switchermode, integer1);
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, Integer integer)
    {
        a(switchermode);
        h.put(switchermode.ordinal(), integer);
    }

    public void a(Boolean boolean1)
    {
        c = boolean1;
    }

    public void a(Integer integer)
    {
        l = integer;
    }

    public void a(String s)
    {
        d = s;
    }

    public void a(List list)
    {
        if (list != null)
        {
            e.addAll(list);
        }
    }

    public Integer b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        a(switchermode);
        return (Integer)h.get(switchermode.ordinal());
    }

    public List b()
    {
        return new ArrayList(e);
    }

    public void b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode, Integer integer)
    {
        a(switchermode);
        i.put(switchermode.ordinal(), integer);
    }

    public void b(String s)
    {
        f = s;
    }

    public int c(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        a(switchermode);
        return ((Integer)i.get(switchermode.ordinal())).intValue();
    }

    public String c()
    {
        return f;
    }

    public Integer d()
    {
        return l;
    }

    public void d(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode switchermode)
    {
        a(switchermode);
        b = switchermode.ordinal();
    }

    public com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode e()
    {
        com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode aswitchermode[] = com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values();
        if (b < 0 || b >= aswitchermode.length)
        {
            return null;
        } else
        {
            return com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.values()[b];
        }
    }

    public d f()
    {
        if (j == null)
        {
            return null;
        } else
        {
            return j.c();
        }
    }

    public i g()
    {
        return k;
    }

    public Boolean h()
    {
        return c;
    }
}
