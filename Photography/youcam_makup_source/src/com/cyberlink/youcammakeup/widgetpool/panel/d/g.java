// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            e

public class g extends e
{

    private HashMap b;
    private String c;

    public g()
    {
    }

    private void a(String s, at at1)
    {
        b.put(s, at1.m());
    }

    private at b(String s)
    {
        return (at)b.get(s);
    }

    private void j()
    {
        Object obj = PanelDataCenter.a().a(BeautyMode.k);
        List list;
        Iterator iterator;
        b = new HashMap();
        list = PanelDataCenter.a().d(BeautyMode.k);
        iterator = ((List) (obj)).iterator();
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        at at1;
        String s;
        s = (String)iterator.next();
        at1 = MotionControlHelper.a(list, PanelDataCenter.a().c(s, null));
        obj = at1;
        if (at1 != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (list.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj = (at)list.get(0);
_L4:
        b.put(s, obj);
          goto _L3
        obj;
        m.e("MultiChoicePatternToolMustache", (new StringBuilder()).append("initColorMap exception = ").append(((Exception) (obj)).getMessage()).toString());
_L2:
        return;
        obj = new at(0);
          goto _L4
    }

    protected void a()
    {
        boolean flag = false;
        if (!"default_original_mustache".equals(c))
        {
            a(false, c, null);
            if (c() == 0)
            {
                flag = true;
            }
            a(flag);
        }
    }

    public void a(at at1)
    {
        super.a(at1);
        a(c, at1);
    }

    public void a(String s, boolean flag)
    {
        flag = true;
        at at1 = b(s);
        MotionControlHelper.e().a(at1);
        if (s.equals("default_original_mustache"))
        {
            a(8);
        } else
        {
            a(false, s, c);
            a(at1, true);
        }
        if (c() != 0)
        {
            flag = false;
        }
        a(flag);
        c = s;
    }

    protected void b()
    {
        super.b();
        j();
        float f1 = 50F;
        Object obj = StatusManager.j().d();
        float f = f1;
        if (obj != null)
        {
            obj = ((i) (obj)).E();
            f = f1;
            if (obj != null)
            {
                List list = ((o) (obj)).a();
                f = f1;
                if (list.size() > 0)
                {
                    c = (String)list.get(0);
                    obj = ((o) (obj)).b(c);
                    a(c, ((at) (obj)));
                    MotionControlHelper.e().a(((at) (obj)));
                    f = 100 - ((at) (obj)).d();
                }
            }
        }
        a(f, true, false);
        if (c == null)
        {
            obj = StatusManager.j().f();
            if (((List) (obj)).size() > 0)
            {
                c = (String)((List) (obj)).get(0);
            }
        }
        boolean flag;
        if (c() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        obj = b(c);
        a(((at) (obj)), true);
        MotionControlHelper.e().a(((at) (obj)));
    }

    protected void c(ImageStateChangedEvent imagestatechangedevent)
    {
        imagestatechangedevent = imagestatechangedevent.b();
        Object obj;
        if (imagestatechangedevent != null)
        {
            if ((imagestatechangedevent = imagestatechangedevent.a()) != null && (obj = imagestatechangedevent.f()) != null)
            {
                imagestatechangedevent = ((v) (obj)).b();
                at at1 = ((v) (obj)).a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                obj = ((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                if (imagestatechangedevent.size() > 0 && at1 != null && obj != null)
                {
                    c = (String)imagestatechangedevent.get(0);
                    a(c, at1);
                    a(false, c, null);
                    imagestatechangedevent = b(c);
                    MotionControlHelper.e().a(imagestatechangedevent);
                    a(imagestatechangedevent, true);
                    a(((Integer) (obj)).intValue());
                    boolean flag;
                    if (c() == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    a(flag);
                    return;
                }
            }
        }
    }
}
