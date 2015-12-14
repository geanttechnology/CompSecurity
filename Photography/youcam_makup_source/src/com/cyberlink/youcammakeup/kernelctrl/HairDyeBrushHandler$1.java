// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            HairDyeBrushHandler

class a extends ch
{

    final HairDyeBrushHandler a;

    public void onAnimationEnd(Animator animator)
    {
        if (HairDyeBrushHandler.k(a) == null)
        {
            return;
        } else
        {
            HairDyeBrushHandler.k(a).setVisibility(8);
            return;
        }
    }

    A(HairDyeBrushHandler hairdyebrushhandler)
    {
        a = hairdyebrushhandler;
        super();
    }
}
