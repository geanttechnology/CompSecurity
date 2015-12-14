// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            ComposePhotoesActivity2

class b
    implements android.view.animation.r
{

    final boolean a;
    final View b;
    final ComposePhotoesActivity2 c;

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

    (ComposePhotoesActivity2 composephotoesactivity2, boolean flag, View view)
    {
        c = composephotoesactivity2;
        a = flag;
        b = view;
        super();
    }
}
