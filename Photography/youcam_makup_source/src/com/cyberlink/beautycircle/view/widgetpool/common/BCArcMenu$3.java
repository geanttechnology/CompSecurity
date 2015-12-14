// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.graphics.PointF;
import android.widget.RelativeLayout;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCArcMenu, ArcLayout, b

class a
    implements android.animation.matorListener
{

    final BCArcMenu a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        BCArcMenu.b(a).set(0.0F, 0.0F);
        int i = BCArcMenu.a(a).getWidth();
        int j = BCArcMenu.a(a).getHeight();
        int k = 0 - i;
        BCArcMenu.a(a).setLeft(k - i / 2);
        BCArcMenu.a(a).setTop(0 - j / 2);
        BCArcMenu.a(a).setRight(i / 2 + k);
        BCArcMenu.a(a).setBottom(j / 2 + 0);
        BCArcMenu.e(a).setVisibility(4);
        if (BCArcMenu.f(a) != null)
        {
            BCArcMenu.f(a).a();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (BCArcMenu bcarcmenu)
    {
        a = bcarcmenu;
        super();
    }
}
