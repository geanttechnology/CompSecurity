// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.aq;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            r, BeautyToolPanel

class a
    implements aq
{

    final r a;

    public void a(Exception exception)
    {
        m.e(r.r, exception.toString());
        if (a.m == null)
        {
            return;
        } else
        {
            Globals.d(new Runnable() {

                final r._cls4 a;

                public void run()
                {
                    if (a.a.m != null)
                    {
                        a.a.m.b(null);
                    }
                }

            
            {
                a = r._cls4.this;
                super();
            }
            });
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        if (a.m == null)
        {
            return;
        } else
        {
            Globals.d(new Runnable() {

                final r._cls4 a;

                public void run()
                {
                    if (a.a.m != null)
                    {
                        a.a.m.b(null);
                    }
                    r r1 = a.a;
                    boolean flag;
                    if (!"default_original_wig".equals(StatusManager.j().e()))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    r.a(r1, flag);
                }

            
            {
                a = r._cls4.this;
                super();
            }
            });
            return;
        }
    }

    _cls2.a(r r1)
    {
        a = r1;
        super();
    }
}
