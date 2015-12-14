// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, b

class a extends ch
{

    final ch a;
    final BeautyToolPanel b;

    public void onAnimationEnd(Animator animator)
    {
        if (b.c != null && (b.c instanceof b))
        {
            ((b)b.c).c(false);
        }
        animator = new Runnable(animator) {

            final Animator a;
            final BeautyToolPanel._cls17 b;

            public void run()
            {
                BeautyToolPanel.i(b.b).setVisibility(8);
                if (b.a != null)
                {
                    b.a.onAnimationEnd(a);
                }
                if (b.b.b != null && !b.b.b.isFinishing())
                {
                    b.b.b.c(b.b.j.getHeight());
                }
                BeautyToolPanel.b(b.b, true);
            }

            
            {
                b = BeautyToolPanel._cls17.this;
                a = animator;
                super();
            }
        };
        BeautyToolPanel.i(b).post(animator);
    }

    _cls1.a(BeautyToolPanel beautytoolpanel, ch ch1)
    {
        b = beautytoolpanel;
        a = ch1;
        super();
    }
}
