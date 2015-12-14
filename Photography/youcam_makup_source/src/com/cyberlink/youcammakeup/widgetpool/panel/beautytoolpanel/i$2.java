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
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            i, BeautyToolPanel, n

class d extends AsyncTask
{

    MotionControlHelper a;
    PanelDataCenter b;
    aw c;
    int d;
    final String e;
    final i f;

    protected transient Boolean a(Void avoid[])
    {
        a.t();
        c = b.i(e);
        if (c == null)
        {
            return Boolean.valueOf(false);
        }
        StatusManager.j().c(e);
        avoid = c.i();
        if (avoid.size() == 0)
        {
            return Boolean.valueOf(false);
        }
        if (f.m.d() == null) goto _L2; else goto _L1
_L1:
        Object obj = b.a(e, null);
        if (((List) (obj)).size() <= 0) goto _L4; else goto _L3
_L3:
        String s1;
        s1 = StatusManager.j().e();
        d = ((List) (obj)).indexOf(s1);
        if (s1 == null || d <= -1) goto _L5; else goto _L4
_L4:
        if (d == -1)
        {
            StatusManager.j().b(f.m.g());
        }
        a.a((at)avoid.get(0));
        return Boolean.valueOf(true);
_L5:
        d = 0;
        obj = (String)((List) (obj)).get(d);
        if (obj != null && !((String) (obj)).equals("") && !((String) (obj)).equals(StatusManager.j().e()))
        {
            StatusManager.j().b(((String) (obj)));
            MotionControlHelper.e().t();
            MotionControlHelper.e().a(true);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        String s = StatusManager.j().e();
        int j;
        if (f.m.i(s) && PanelDataCenter.d(s))
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
        d = j;
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void a(Boolean boolean1)
    {
        if (!boolean1.booleanValue())
        {
            if (f.k != null)
            {
                Globals.d().i().h(f.k);
            }
            return;
        } else
        {
            f.m.a(StatusManager.j().e(), f.m.d());
            a.a(null, true);
            f.m.d(StatusManager.j().e());
            f.m.a(false, null);
            f.m.b(false);
            ((n)f.m).a(c);
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

    (i j, String s)
    {
        f = j;
        e = s;
        super();
        d = -1;
    }
}
