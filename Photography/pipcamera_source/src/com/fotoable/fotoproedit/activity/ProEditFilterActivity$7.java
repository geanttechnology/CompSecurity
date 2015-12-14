// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import ew;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFilterActivity

class a
    implements android.view.animation.ner
{

    final ProEditFilterActivity a;

    public void onAnimationEnd(Animation animation)
    {
        animation = (android.widget.)ProEditFilterActivity.m(a).getLayoutParams();
        animation.bottomMargin = ew.a(a, 40F);
        ProEditFilterActivity.m(a).setLayoutParams(animation);
        ProEditFilterActivity.m(a).clearAnimation();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }
}
