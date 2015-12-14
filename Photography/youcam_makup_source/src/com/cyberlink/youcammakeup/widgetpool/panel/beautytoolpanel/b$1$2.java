// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            b, BeautyToolPanel

class a
    implements Runnable
{

    final ch a;
    final a b;

    public void run()
    {
        Object obj = null;
        if (b.b.f != null)
        {
            obj = h.b().a(b.b.f.b(), b.b.f.a()).d();
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
        obj = b.b.m;
        boolean flag;
        if (b.b.m.q() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((BeautyToolPanel) (obj)).a(flag, a);
    }

    a(a a1, ch ch)
    {
        b = a1;
        a = ch;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/b$1

/* anonymous class */
    class b._cls1
        implements android.view.View.OnClickListener
    {

        final com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b a;

        public void onClick(View view)
        {
            view.setClickable(false);
            view = new b._cls1._cls2(this, new b._cls1._cls1(view));
            a.h.post(view);
        }

            
            {
                a = b1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/b$1$1

/* anonymous class */
        class b._cls1._cls1 extends ch
        {

            final View a;
            final b._cls1 b;

            public void onAnimationEnd(Animator animator)
            {
                a.setClickable(true);
            }

                    
                    {
                        b = b._cls1.this;
                        a = view;
                        super();
                    }
        }

    }

}
