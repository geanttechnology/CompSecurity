// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.ae;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.o;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper, j, ar, aq, 
//            ax

public class ap extends AsyncTask
{

    final VenusHelper a;
    private final aq b;
    private final aw c;
    private ax d;

    public ap(VenusHelper venushelper, aw aw, aq aq1)
    {
        a = venushelper;
        super();
        c = aw;
        b = aq1;
    }

    protected transient Integer a(Void avoid[])
    {
        byte byte0 = -1;
        long l = StatusManager.j().l();
        avoid = StatusManager.j().c(l).g().b();
        if (avoid == null)
        {
            avoid = ViewEngine.a().a(l, 1.0D, null);
        }
        if (avoid == null)
        {
            return Integer.valueOf(-1);
        }
        VenusHelper.b(a, false);
        publishProgress(new VenusHelper.AutoDetectHairDyeUpdateStatus[] {
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.AutoDetectHairDyeUpdateStatus.a
        });
        Object obj = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        a a1 = StatusManager.j().f(l);
        int i = byte0;
        if (a1 != null)
        {
            i = byte0;
            if (obj != null)
            {
                i = byte0;
                if (((List) (obj)).get(a1.e) != null)
                {
                    com.cyberlink.youcammakeup.jniproxy.ai ai = ((ar)((List) (obj)).get(a1.e)).b;
                    obj = ((ar)((List) (obj)).get(a1.e)).c;
                    i = VenusHelper.b(a).a(avoid.j(), ai, ((com.cyberlink.youcammakeup.jniproxy.y) (obj)));
                }
            }
        }
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a(a, null);
        }
        com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a(a, new ImageBufferWrapper());
        VenusHelper.c(a).a(avoid.b(), avoid.c(), 4L);
        i &= VenusHelper.b(a).b(VenusHelper.c(a).j());
        if (i == 0)
        {
            bb.a(com.cyberlink.youcammakeup.kernelctrl.VenusHelper.d(a));
            String s = (new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.VenusHelper.d(a)).append("/").append(UUID.randomUUID().toString()).toString();
            VenusHelper.c(a).j().b(s);
            if (VenusHelper.e(a) != null)
            {
                VenusHelper.e(a).c();
                com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a(a, null);
            }
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a(a, new ae());
            VenusHelper.e(a).a(s);
        }
        if (VenusHelper.c(a) != null)
        {
            VenusHelper.c(a).m();
            com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a(a, null);
        }
        if (avoid != null)
        {
            avoid.m();
        }
        if (i == 0)
        {
            publishProgress(new VenusHelper.AutoDetectHairDyeUpdateStatus[] {
                VenusHelper.AutoDetectHairDyeUpdateStatus.b
            });
            try
            {
                Thread.sleep(300L);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
        }
        return Integer.valueOf(i);
    }

    protected void a(Integer integer)
    {
        if (integer.intValue() > -1)
        {
            Globals.d().i().k(Globals.d().t());
            if (b != null)
            {
                b.a(c);
            }
        } else
        {
            Globals.d().i().k(Globals.d().t());
            if (b != null)
            {
                b.b(integer);
                return;
            }
        }
    }

    protected transient void a(VenusHelper.AutoDetectHairDyeUpdateStatus aautodetecthairdyeupdatestatus[])
    {
        if (aautodetecthairdyeupdatestatus[0] == com.cyberlink.youcammakeup.kernelctrl.VenusHelper.AutoDetectHairDyeUpdateStatus.a)
        {
            d = new ax(a, null);
            d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        if (aautodetecthairdyeupdatestatus[0] == VenusHelper.AutoDetectHairDyeUpdateStatus.b && d != null)
        {
            d.a(new Integer[] {
                Integer.valueOf(100)
            });
            d.cancel(true);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        Globals.d().i().k(Globals.d().t());
        if (b != null)
        {
            b.c(null);
        }
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((VenusHelper.AutoDetectHairDyeUpdateStatus[])aobj);
    }
}
