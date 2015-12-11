// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class b
    implements android.view.animation.ionListener
{

    final View a;
    final Runnable b;
    final MagicActivity c;

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(4);
        if (b != null)
        {
            b.run();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (MagicActivity magicactivity, View view, Runnable runnable)
    {
        c = magicactivity;
        a = view;
        b = runnable;
        super();
    }
}
