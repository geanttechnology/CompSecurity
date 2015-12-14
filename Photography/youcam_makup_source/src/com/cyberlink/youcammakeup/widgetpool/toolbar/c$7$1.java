// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            e, c

class a extends ch
{

    final a a;

    public void onAnimationEnd(Animator animator)
    {
        if (a.a.a)
        {
            a.a.b(null);
            a.a.a(false);
            return;
        } else
        {
            a.a.a(true);
            return;
        }
    }

    _cls9(_cls9 _pcls9)
    {
        a = _pcls9;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/c$7

/* anonymous class */
    class c._cls7
        implements Runnable
    {

        final e a;
        final c b;

        public void run()
        {
            c._cls7._cls1 _lcls1 = new c._cls7._cls1(this);
            if (a.b)
            {
                b.a(_lcls1);
                return;
            } else
            {
                _lcls1.onAnimationEnd(null);
                return;
            }
        }

            
            {
                b = c1;
                a = e1;
                super();
            }
    }

}
