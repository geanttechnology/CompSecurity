// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksGridItem;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class d
    implements j
{

    final Activity a;
    final as b;
    final LooksGridItem c;
    final Integer d;
    final MakeupLooksBottomToolbar e;

    public void a(a a1)
    {
        int i = Math.min(100, af.a(a1));
        a.runOnUiThread(new Runnable(i) {

            final int a;
            final MakeupLooksBottomToolbar._cls2 b;

            public void run()
            {
                b.c.setProgress(a);
            }

            
            {
                b = MakeupLooksBottomToolbar._cls2.this;
                a = i;
                super();
            }
        });
    }

    public void a(bn bn1)
    {
        if (d == (Integer)c.getTag())
        {
            a.runOnUiThread(new Runnable() {

                final MakeupLooksBottomToolbar._cls2 a;

                public void run()
                {
                    a.c.a(true, false);
                    String s = a.a.getString(0x7f070534);
                    Globals.d().i().a(a.a, null, new android.view.View.OnClickListener(this) {

                        final _cls2 a;

                        public void onClick(View view)
                        {
                            MakeupLooksBottomToolbar.c(a.a.e).a(a.a.c, a.a.d.intValue(), a.a.c.getId());
                        }

            
            {
                a = _pcls2;
                super();
            }
                    }, null, s);
                }

            
            {
                a = MakeupLooksBottomToolbar._cls2.this;
                super();
            }
            });
        }
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        a.runOnUiThread(new Runnable() {

            final MakeupLooksBottomToolbar._cls2 a;

            public void run()
            {
                a.b.a(Boolean.valueOf(true));
                a.c.a(true, true);
                MakeupLooksBottomToolbar.c(a.e, a.d.intValue());
            }

            
            {
                a = MakeupLooksBottomToolbar._cls2.this;
                super();
            }
        });
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void b(Void void1)
    {
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    _cls3.a(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, Activity activity, as as, LooksGridItem looksgriditem, Integer integer)
    {
        e = makeuplooksbottomtoolbar;
        a = activity;
        b = as;
        c = looksgriditem;
        d = integer;
        super();
    }
}
