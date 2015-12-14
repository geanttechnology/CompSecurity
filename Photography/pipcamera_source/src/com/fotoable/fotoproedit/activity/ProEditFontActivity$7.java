// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class b
    implements android.view.animation.tener
{

    final View a;
    final boolean b;
    final ProEditFontActivity c;

    public void onAnimationEnd(Animation animation)
    {
        a.clearAnimation();
        if (b)
        {
            a.setVisibility(0);
            return;
        } else
        {
            a.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (ProEditFontActivity proeditfontactivity, View view, boolean flag)
    {
        c = proeditfontactivity;
        a = view;
        b = flag;
        super();
    }
}
