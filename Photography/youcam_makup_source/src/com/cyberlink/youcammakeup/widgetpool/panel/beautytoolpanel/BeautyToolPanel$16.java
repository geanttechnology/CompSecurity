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
        b.l.setVisibility(8);
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
        if (b.b != null && !b.b.isFinishing())
        {
            int i;
            if (BeautyToolPanel.d(b) != null)
            {
                i = BeautyToolPanel.d(b).getHeight();
            } else
            {
                i = 0;
            }
            b.b.c(i + b.u());
        }
        b.e(true);
    }

    (BeautyToolPanel beautytoolpanel, ch ch1)
    {
        b = beautytoolpanel;
        a = ch1;
        super();
    }
}
