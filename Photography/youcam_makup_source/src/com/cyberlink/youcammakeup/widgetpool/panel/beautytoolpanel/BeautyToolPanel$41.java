// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements android.view.Listener
{

    final BeautyToolPanel a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (a.b != null && !a.b.isFinishing())
        {
            if (BeautyToolPanel.d(a) == null || a.l == null)
            {
                a.b.c(a.u());
                return;
            }
            view = StatusManager.j().s();
            View view1 = a.a.findViewById(0x7f0c0676);
            i = a.a.findViewById(0x7f0c0677).getHeight();
            k = view1.getHeight();
            if (l1 - j1 == l - j)
            {
                if (a.q() != 0)
                {
                    if (view == BeautyMode.s)
                    {
                        BeautyToolPanel.d(a).setTranslationY(k - i);
                        return;
                    }
                    if (a.g.getVisibility() == 0)
                    {
                        BeautyToolPanel.d(a).animate().cancel();
                        BeautyToolPanel.d(a).animate().translationY(k - i);
                        a.b.c(BeautyToolPanel.d(a).getHeight() + a.u());
                        return;
                    } else
                    {
                        BeautyToolPanel.d(a).setTranslationY(k);
                        return;
                    }
                }
            } else
            {
                a.b.c(a.u());
                if (a.g.getVisibility() != 0)
                {
                    i = 0;
                }
                j = view1.getHeight();
                BeautyToolPanel.d(a).setTranslationY(j - i);
                a.b.c(BeautyToolPanel.d(a).getHeight() + a.u());
                return;
            }
        }
    }

    (BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
