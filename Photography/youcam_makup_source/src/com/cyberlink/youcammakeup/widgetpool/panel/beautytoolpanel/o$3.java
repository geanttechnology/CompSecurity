// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            o, BeautyToolPanel, n

class e extends AsyncTask
{

    MotionControlHelper a;
    PanelDataCenter b;
    aw c;
    int d;
    int e;
    final String f;
    final Float g[];
    final com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o h;

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
            avoid = c.c();
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
                        d = ((Integer)avoid.get(0)).intValue();
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
        if (e == -1)
        {
            StatusManager.j().b(h.m.g());
        }
        avoid = new ArrayList();
        avoid.add(Integer.valueOf(d));
        a.d(list);
        a.c(avoid);
        a.a(null, true);
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
            h.m.a(d);
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
    }

    (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.o o1, String s, Float afloat[])
    {
        h = o1;
        f = s;
        g = afloat;
        super();
        e = -1;
    }
}
