// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bb;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bd;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            BeautyTipFilmActivity

class a
    implements bd
{

    final BeautyTipFilmActivity a;

    public void a(bb bb1)
    {
        bb1 = bb1.a().iterator();
        do
        {
            d d1;
            Activity activity;
label0:
            {
                if (bb1.hasNext())
                {
                    d1 = (d)bb1.next();
                    if (Long.valueOf(d1.a()).longValue() != BeautyTipFilmActivity.b(a))
                    {
                        continue;
                    }
                    activity = Globals.d().a(com.cyberlink.youcammakeup.tivity._cls3.a);
                    if (activity != null)
                    {
                        break label0;
                    }
                }
                return;
            }
            activity.runOnUiThread(new Runnable(d1) {

                final d a;
                final BeautyTipFilmActivity._cls3 b;

                public void run()
                {
                    BeautyTipFilmActivity.c(b.a).setText(a.f());
                    StatusManager.j().a(a.f());
                }

            
            {
                b = BeautyTipFilmActivity._cls3.this;
                a = d1;
                super();
            }
            });
        } while (true);
    }

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public volatile void a(Object obj)
    {
        a((bb)obj);
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    _cls1.a(BeautyTipFilmActivity beautytipfilmactivity)
    {
        a = beautytipfilmactivity;
        super();
    }
}
