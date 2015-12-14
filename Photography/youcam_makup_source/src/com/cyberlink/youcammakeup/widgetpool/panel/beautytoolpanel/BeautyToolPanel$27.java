// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a extends ch
{

    final BeautyToolPanel a;

    public void onAnimationEnd(Animator animator)
    {
        BeautyToolPanel.r(a).setVisibility(8);
        a.e(true);
    }

    (BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
