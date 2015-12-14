// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            j, CameraShotAnimationVeiw, ah

class a extends j
{

    final CameraShotAnimationVeiw a;

    public void onAnimationEnd(Animator animator)
    {
        CameraShotAnimationVeiw.a(a, -1);
        CameraShotAnimationVeiw.b(a, -1);
    }

    public void onAnimationRepeat(Animator animator)
    {
        CameraShotAnimationVeiw.a(a, true);
    }

    public void onAnimationStart(Animator animator)
    {
        if (CameraShotAnimationVeiw.b(a) != null && !CameraShotAnimationVeiw.c(a))
        {
            CameraShotAnimationVeiw.b(a).a(4);
        }
    }

    A(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        a = camerashotanimationveiw;
        super(camerashotanimationveiw, null);
    }
}
