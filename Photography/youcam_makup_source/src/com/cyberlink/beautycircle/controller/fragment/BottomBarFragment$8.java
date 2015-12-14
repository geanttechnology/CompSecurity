// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.beautycircle.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements android.animation.tener
{

    final View a;
    final BottomBarFragment b;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        a.setVisibility(4);
        a.findViewById(j.bc_new_alert_outter).setVisibility(4);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (BottomBarFragment bottombarfragment, View view)
    {
        b = bottombarfragment;
        a = view;
        super();
    }
}
