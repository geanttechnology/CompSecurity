// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            j, CameraShotAnimationVeiw

class a extends j
{

    final CameraShotAnimationVeiw a;

    public void onAnimationEnd(Animator animator)
    {
        a.setAlpha(1.0F);
        a.setBackgroundColor(0);
    }

    A(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        a = camerashotanimationveiw;
        super(camerashotanimationveiw, null);
    }
}
