// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a extends ch
{

    final CameraCtrl a;

    public void onAnimationEnd(Animator animator)
    {
        b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.t.Operation.j, false, false));
        animator.removeListener(this);
        CameraCtrl.L(a).setSelected(false);
        CameraCtrl.L(a).setClickable(true);
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ent.Operation(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
