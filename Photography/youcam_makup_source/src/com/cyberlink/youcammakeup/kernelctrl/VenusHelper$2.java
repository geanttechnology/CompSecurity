// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.jniproxy.bm;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            VenusHelper

class b extends AsyncTask
{

    final bm a;
    final float b;
    final VenusHelper c;

    protected transient Void a(Void avoid[])
    {
        VenusHelper.b(c).a(a, b);
        c.d();
        return null;
    }

    protected void a(Void void1)
    {
        void1 = Globals.d().t();
        if (void1 != null)
        {
            void1.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.fferName.c);
            void1.M();
            Globals.d().i().b(false);
            Globals.d().i().h(void1);
        }
        VenusHelper.a(c, false);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (VenusHelper venushelper, bm bm, float f1)
    {
        c = venushelper;
        a = bm;
        b = f1;
        super();
    }
}
