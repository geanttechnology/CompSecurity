// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

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
        p.e(b.b, a);
    }

    >(> >, int i)
    {
        b = >;
        a = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$22

/* anonymous class */
    class p._cls22 extends h
    {

        final p b;

        public void a(int i)
        {
            if (p.D(b) != null)
            {
                p.D(b).post(new p._cls22._cls1(this, i));
            }
        }

        public void a(boolean flag)
        {
        }

            
            {
                b = p1;
                super(p1);
            }
    }

}
