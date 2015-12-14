// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.ae;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import com.pf.common.utility.m;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, aq

public class au extends AsyncTask
{

    final VenusHelper a;
    private final aq b;

    public au(VenusHelper venushelper, aq aq1)
    {
        a = venushelper;
        super();
        b = aq1;
    }

    protected transient Integer a(Void avoid[])
    {
        int i;
        int j;
        j = -1;
        i = j;
        long l = StatusManager.j().l();
        i = j;
        avoid = ViewEngine.a().a(l);
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        i = j;
        if (((d) (avoid)).a != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            VenusHelper.a(a, null);
        }
        return Integer.valueOf(-1);
        i = j;
        if (VenusHelper.c(a) == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        i = j;
        VenusHelper.c(a).m();
        i = j;
        VenusHelper.a(a, null);
        i = j;
        VenusHelper.a(a, new ImageBufferWrapper());
        i = j;
        VenusHelper.c(a).a(((d) (avoid)).a.a, ((d) (avoid)).a.b, 4L);
        i = j;
        j = VenusHelper.b(a).b(VenusHelper.c(a).j());
        i = j;
        avoid = (new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.VenusHelper.d(a)).append("/").append(UUID.randomUUID().toString()).toString();
        i = j;
        VenusHelper.c(a).j().b(avoid);
        i = j;
        if (VenusHelper.g(a) != null)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        i = j;
        VenusHelper.b(a, new ae());
        i = j;
        VenusHelper.g(a).a(avoid);
        int k;
        k = j;
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            VenusHelper.a(a, null);
            k = j;
        }
_L2:
        return Integer.valueOf(k);
        avoid;
        m.e("GetHairDyeMaskTask", "getHairDyeMask exception!!");
        k = i;
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            VenusHelper.a(a, null);
            k = i;
        }
        if (true) goto _L2; else goto _L1
_L1:
        avoid;
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            VenusHelper.a(a, null);
        }
        throw avoid;
    }

    protected void a(Integer integer)
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().h(Globals.d().t());
        }
        if (integer.intValue() > -1)
        {
            if (b != null)
            {
                b.a(null);
            }
        } else
        if (b != null)
        {
            b.b(integer);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().h(Globals.d().t());
        }
        if (b != null)
        {
            b.c(null);
        }
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onPreExecute()
    {
        if (Globals.d().t() != null)
        {
            Globals.d().i().b(Globals.d().t());
        }
    }
}
