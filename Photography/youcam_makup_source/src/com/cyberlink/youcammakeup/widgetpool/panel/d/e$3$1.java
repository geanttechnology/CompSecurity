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
    implements Runnable
{

    final a a;

    public void run()
    {
        if (e.c(a.a) != null)
        {
            e.c(a.a).v();
            a.a.a();
        }
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/e$3

/* anonymous class */
    class e._cls3
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
                Globals.c(new e._cls3._cls2());
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
                Globals.c(new e._cls3._cls1(this));
                return;
            }
        }

            
            {
                a = e1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/e$3$2

/* anonymous class */
        class e._cls3._cls2
            implements Runnable
        {

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
        }

    }

}
