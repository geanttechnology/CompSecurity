// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper

class ax extends AsyncTask
{

    final VenusHelper a;
    private boolean b;

    private ax(VenusHelper venushelper)
    {
        a = venushelper;
        super();
        b = false;
    }

    ax(VenusHelper venushelper, VenusHelper._cls1 _pcls1)
    {
        this(venushelper);
    }

    protected transient Void a(Void avoid[])
    {
        int i;
        int j;
        j = 0;
        i = 0;
_L2:
        int k;
        long l;
        if (j >= 100 || isCancelled())
        {
            return null;
        }
        j = VenusHelper.b(a).h();
        k = i;
        if (i != j)
        {
            publishProgress(new Integer[] {
                Integer.valueOf(j)
            });
            k = j;
        }
        l = 300;
        Thread.sleep(l);
        i = k;
        continue; /* Loop/switch isn't completed */
        avoid;
        avoid.getLocalizedMessage();
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected transient void a(Integer ainteger[])
    {
        if (!com.cyberlink.youcammakeup.kernelctrl.VenusHelper.f(a))
        {
            Globals.d().i().j(Globals.d().t());
            VenusHelper.b(a, true);
        }
        Globals.d().i().a(ainteger[0].intValue());
        if (!b && ainteger[0].intValue() > 1)
        {
            b = true;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
