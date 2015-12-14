// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class b
    implements android.view.animation.ner
{

    final boolean a;
    final View b;
    final ProEditMosaicActivity c;

    public void onAnimationEnd(Animation animation)
    {
        if (a)
        {
            b.setVisibility(0);
            return;
        } else
        {
            b.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (ProEditMosaicActivity proeditmosaicactivity, boolean flag, View view)
    {
        c = proeditmosaicactivity;
        a = flag;
        b = view;
        super();
    }
}
