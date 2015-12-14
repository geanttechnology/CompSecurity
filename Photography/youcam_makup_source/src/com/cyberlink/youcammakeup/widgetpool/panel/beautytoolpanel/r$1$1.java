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
//            r, BeautyToolPanel

class a extends ch
{

    final View a;
    final a b;

    public void onAnimationEnd(Animator animator)
    {
        a.setClickable(true);
    }

    a(a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/r$1

/* anonymous class */
    class r._cls1
        implements android.view.View.OnClickListener
    {

        final r a;

        public void onClick(View view)
        {
            view.setClickable(false);
            view = new r._cls1._cls2(new r._cls1._cls1(this, view));
            a.h.post(view);
        }

            
            {
                a = r1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/r$1$2

/* anonymous class */
        class r._cls1._cls2
            implements Runnable
        {

            final ch a;
            final r._cls1 b;

            public void run()
            {
                Object obj = null;
                if (b.a.f != null)
                {
                    obj = h.b().a(b.a.f.b(), b.a.f.a()).d();
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
                obj = b.a.m;
                boolean flag;
                if (b.a.m.q() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((BeautyToolPanel) (obj)).a(flag, a);
            }

                    
                    {
                        b = r._cls1.this;
                        a = ch1;
                        super();
                    }
        }

    }

}
