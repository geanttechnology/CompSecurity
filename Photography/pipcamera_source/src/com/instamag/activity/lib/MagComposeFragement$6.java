// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement

class a
    implements android.view.animation.tener
{

    final View a;
    final MagComposeFragement b;

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    er(MagComposeFragement magcomposefragement, View view)
    {
        b = magcomposefragement;
        a = view;
        super();
    }
}
