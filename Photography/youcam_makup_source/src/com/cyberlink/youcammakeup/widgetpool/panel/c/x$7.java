// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.e;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x

class c
    implements j
{

    final int a;
    final e b;
    final Activity c;
    final x d;

    public void a(a a1)
    {
        int i = Math.min(100, af.a(a1));
        if (a == ((Integer)b.getTag()).intValue())
        {
            c.runOnUiThread(new Runnable(i) {

                final int a;
                final x._cls7 b;

                public void run()
                {
                    b.b.setProgress(a);
                }

            
            {
                b = x._cls7.this;
                a = i;
                super();
            }
            });
        }
    }

    public void a(bn bn1)
    {
        if (a == ((Integer)b.getTag()).intValue())
        {
            c.runOnUiThread(new Runnable() {

                final x._cls7 a;

                public void run()
                {
                    a.b.a(true, false);
                    String s = a.c.getString(0x7f070534);
                    Globals.d().i().a(a.c, null, new android.view.View.OnClickListener(this) {

                        final _cls2 a;

                        public void onClick(View view)
                        {
                            com.cyberlink.youcammakeup.widgetpool.panel.c.x.e(a.a.d).a(a.a.b, a.a.a, a.a.b.getId());
                        }

            
            {
                a = _pcls2;
                super();
            }
                    }, null, s);
                }

            
            {
                a = x._cls7.this;
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
        if (a == ((Integer)b.getTag()).intValue())
        {
            c.runOnUiThread(new Runnable() {

                final x._cls7 a;

                public void run()
                {
                    a.b.a(true, true);
                    com.cyberlink.youcammakeup.widgetpool.panel.c.x.a(a.d, a.a, false);
                }

            
            {
                a = x._cls7.this;
                super();
            }
            });
        }
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

    _cls3.a(x x1, int i, e e1, Activity activity)
    {
        d = x1;
        a = i;
        b = e1;
        c = activity;
        super();
    }
}
