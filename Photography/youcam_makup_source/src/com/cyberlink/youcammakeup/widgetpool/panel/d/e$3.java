// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.aq;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            e, d

class a
    implements aq
{

    final e a;

    public void a(Exception exception)
    {
        m.e("MultiChoicePatternTool", exception.toString());
        if (e.c(a) == null)
        {
            return;
        } else
        {
            Globals.c(new Runnable() {

                final e._cls3 a;

                public void run()
                {
                    if (e.c(a.a) != null)
                    {
                        e.c(a.a).v();
                        a.a.a();
                    }
                }

            
            {
                a = e._cls3.this;
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
        if (e.c(a) == null)
        {
            return;
        } else
        {
            Globals.c(new Runnable() {

                final e._cls3 a;

                public void run()
                {
                    if (e.c(a.a) != null)
                    {
                        e.c(a.a).v();
                        a.a.a();
                    }
                }

            
            {
                a = e._cls3.this;
                super();
            }
            });
            return;
        }
    }

    _cls2.a(e e1)
    {
        a = e1;
        super();
    }
}
