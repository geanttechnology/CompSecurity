// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            HairDyeToolPanelMenu, BeautyToolPanel, n

class g extends AsyncTask
{

    MotionControlHelper a;
    PanelDataCenter b;
    aw c;
    int d;
    int e;
    final String f;
    final Float g[];
    final HairDyeToolPanelMenu h;

    protected transient Boolean a(Void avoid[])
    {
        a.t();
        c = b.i(f);
        if (c == null)
        {
            return Boolean.valueOf(false);
        }
        if (!"default_original_hair_dye".equalsIgnoreCase(f) && MotionControlHelper.e().ay())
        {
            VenusHelper.a().a(c, HairDyeToolPanelMenu.a(h));
            return Boolean.valueOf(false);
        }
        h.a = c;
        StatusManager.j().c(f);
        h.d(f);
        d = (int)a.a(com.cyberlink.youcammakeup.widgetpool.common.cherMode.a);
        avoid = c.i();
        float f1;
        int i;
        if (avoid != null && avoid.size() > 0)
        {
            i = ((at)avoid.get(0)).d();
        } else
        {
            i = 0;
        }
        if (g.length > 0)
        {
            f1 = g[0].floatValue();
        } else
        if (i > 0)
        {
            f1 = i;
        } else
        {
            f1 = a.w();
        }
        e = (int)f1;
        if (!"default_original_hair_dye".equalsIgnoreCase(f) && avoid.size() == 0)
        {
            return Boolean.valueOf(false);
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Integer.valueOf(d));
            a.d(avoid);
            a.a(e);
            a.c(arraylist);
            a.a(null, true);
            return Boolean.valueOf(true);
        }
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
            h.m.a(false, null);
            h.m.b(false);
            h.m.a(d);
            h.m.b(e);
            HairDyeToolPanelMenu.a(h, f);
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

    Y(HairDyeToolPanelMenu hairdyetoolpanelmenu, String s, Float afloat[])
    {
        h = hairdyetoolpanelmenu;
        f = s;
        g = afloat;
        super();
    }
}
