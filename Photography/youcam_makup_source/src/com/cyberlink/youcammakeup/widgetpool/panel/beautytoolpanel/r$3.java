// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            r, BeautyToolPanel, q, n

class e extends AsyncTask
{

    MotionControlHelper a;
    PanelDataCenter b;
    aw c;
    int d;
    int e;
    final String f;
    final Float g[];
    final r h;

    protected transient Boolean a(Void avoid[])
    {
        a.t();
        c = b.i(f);
        if (c == null)
        {
            return Boolean.valueOf(false);
        }
        StatusManager.j().c(f);
        h.d(f);
        List list = c.i();
        float f1;
        if (g.length > 0)
        {
            f1 = g[0].floatValue();
        } else
        {
            f1 = a.a(com.cyberlink.youcammakeup.widgetpool.common.onControlHelper.SwitcherMode.a);
        }
        d = (int)f1;
        if (list.size() == 0)
        {
            return Boolean.valueOf(false);
        }
        if (h.m.d() != null)
        {
            Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a("wig", h.m.d()).l();
            avoid = new ArrayList();
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); avoid.add(((e)((Iterator) (obj)).next()).a())) { }
            if (avoid.size() > 0)
            {
                String s = StatusManager.j().e();
                e = avoid.indexOf(s);
                if (s != null && e > -1)
                {
                    avoid = s;
                } else
                {
                    e = 0;
                    String s1 = (String)avoid.get(e);
                    avoid = s1;
                    if (s1 != null)
                    {
                        avoid = s1;
                        if (!s1.equals(""))
                        {
                            avoid = s1;
                            if (!s1.equals(s))
                            {
                                StatusManager.j().b(s1);
                                MotionControlHelper.e().t();
                                MotionControlHelper.e().a(true);
                                avoid = s1;
                            }
                        }
                    }
                }
                if (g.length == 0)
                {
                    avoid = b.b(avoid, f);
                    if (avoid.size() > 0)
                    {
                        float f2;
                        if (((Integer)avoid.get(0)).intValue() > 0)
                        {
                            f2 = ((Integer)avoid.get(0)).intValue();
                        } else
                        {
                            f2 = h.m.J();
                        }
                        d = (int)f2;
                    }
                }
            } else
            {
                int i;
                if (g.length == 0 && ((at)list.get(0)).d() != 0)
                {
                    i = ((at)list.get(0)).d();
                } else
                {
                    i = d;
                }
                d = i;
            }
        } else
        {
            avoid = StatusManager.j().e();
            int j;
            if (h.m.i(avoid) && PanelDataCenter.d(avoid))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                j = 0;
            } else
            {
                j = -1;
            }
            e = j;
        }
        if (e == -1 && h.m != null && (h.m instanceof q))
        {
            if (h.f != null)
            {
                avoid = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(h.f.b(), h.f.a()).d();
            } else
            {
                avoid = null;
            }
            StatusManager.j().b(((q)h.m).j(avoid));
        }
        avoid = new ArrayList();
        avoid.add(Integer.valueOf(d));
        a.d(list);
        a.c(avoid);
        a.z();
        a.a(StatusManager.j().e(), f);
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        if (!boolean1.booleanValue())
        {
            if (h.k != null)
            {
                Globals.d().i().h(h.k);
            }
            return;
        } else
        {
            h.m.d(StatusManager.j().e());
            h.m.a(false, null);
            h.m.b(false);
            h.m.a(100 - d);
            ((n)h.m).a(c);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        a = MotionControlHelper.e();
        b = PanelDataCenter.a();
        if (h.k != null)
        {
            Globals.d().i().b(h.k);
        }
    }

    (r r1, String s, Float afloat[])
    {
        h = r1;
        f = s;
        g = afloat;
        super();
        e = -1;
    }
}
