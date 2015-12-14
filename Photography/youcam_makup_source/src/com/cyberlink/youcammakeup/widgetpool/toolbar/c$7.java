// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c, e

class a
    implements Runnable
{

    final e a;
    final c b;

    public void run()
    {
        ch ch1 = new ch() {

            final c._cls7 a;

            public void onAnimationEnd(Animator animator)
            {
                if (a.a.a)
                {
                    a.b.b(null);
                    a.b.a(false);
                    return;
                } else
                {
                    a.b.a(true);
                    return;
                }
            }

            
            {
                a = c._cls7.this;
                super();
            }
        };
        if (a.b)
        {
            b.a(ch1);
            return;
        } else
        {
            ch1.onAnimationEnd(null);
            return;
        }
    }

    _cls1.a(c c1, e e1)
    {
        b = c1;
        a = e1;
        super();
    }
}
