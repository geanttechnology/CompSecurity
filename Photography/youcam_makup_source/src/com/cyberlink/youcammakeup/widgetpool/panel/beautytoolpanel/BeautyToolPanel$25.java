// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements Runnable
{

    final ch a;
    final BeautyToolPanel b;

    public void run()
    {
        BeautyToolPanel.r(b).setAlpha(0.5F);
        BeautyToolPanel.r(b).setTranslationX(-BeautyToolPanel.r(b).getWidth());
        BeautyToolPanel.r(b).animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setListener(a);
    }

    (BeautyToolPanel beautytoolpanel, ch ch)
    {
        b = beautytoolpanel;
        a = ch;
        super();
    }
}
