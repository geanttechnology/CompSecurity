// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            j, CameraShotAnimationVeiw, i

class a extends j
{

    final CameraShotAnimationVeiw a;

    public void onAnimationStart(Animator animator)
    {
        a.setAlpha(0.0F);
        a.setBackgroundColor(-1);
        if (CameraShotAnimationVeiw.a(a) != null)
        {
            CameraShotAnimationVeiw.a(a).a();
        }
    }

    A(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        a = camerashotanimationveiw;
        super(camerashotanimationveiw, null);
    }
}
