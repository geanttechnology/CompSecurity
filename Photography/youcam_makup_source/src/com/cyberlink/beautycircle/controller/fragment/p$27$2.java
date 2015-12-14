// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.TextView;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.view.widgetpool.common.MeTabScrollView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p, h

class a
    implements Runnable
{

    final int a;
    final a b;

    public void run()
    {
        p.e(b.b).productFeatureCount = Integer.valueOf(a);
        p.c(b.b, a);
        p.j(b.b, a);
    }

    >(> >, int i)
    {
        b = >;
        a = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$27

/* anonymous class */
    class p._cls27 extends h
    {

        final p b;

        public void a(int i)
        {
            if (p.D(b) != null)
            {
                p.D(b).post(new p._cls27._cls2(this, i));
            }
        }

        public void a(boolean flag)
        {
            if (p.G(b) == null)
            {
                return;
            } else
            {
                p.G(b).post(new p._cls27._cls1(flag));
                return;
            }
        }

            
            {
                b = p1;
                super(p1);
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$27$1

/* anonymous class */
        class p._cls27._cls1
            implements Runnable
        {

            final boolean a;
            final p._cls27 b;

            public void run()
            {
                p p1 = b.b;
                int i;
                if (a)
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                p.j(p1, i);
            }

                    
                    {
                        b = p._cls27.this;
                        a = flag;
                        super();
                    }
        }

    }

}
