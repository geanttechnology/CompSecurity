// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            cg, ViewAnimationUtils, cf

final class  extends cg
{

    final cf a;

    public void onAnimationEnd(Animation animation)
    {
        if (a != null)
        {
            a.c();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
        if (a != null)
        {
            a.b();
        }
    }

    public void onAnimationStart(Animation animation)
    {
        if (a != null)
        {
            a.a();
        }
    }
}
