// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.animation.ValueAnimator;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraShotAnimationVeiw, i

class k
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final CameraShotAnimationVeiw a;

    private k(CameraShotAnimationVeiw camerashotanimationveiw)
    {
        a = camerashotanimationveiw;
        super();
    }

    k(CameraShotAnimationVeiw camerashotanimationveiw, CameraShotAnimationVeiw._cls1 _pcls1)
    {
        this(camerashotanimationveiw);
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int j;
label0:
        {
            Object obj = valueanimator.getAnimatedValue();
            if (obj instanceof Integer)
            {
                j = ((Integer)obj).intValue();
                if (j != CameraShotAnimationVeiw.d(a))
                {
                    break label0;
                }
            }
            return;
        }
        CameraShotAnimationVeiw.a(a, j);
        if (valueanimator.getCurrentPlayTime() >= valueanimator.getDuration() && j > 7 && CameraShotAnimationVeiw.a(a) != null)
        {
            CameraShotAnimationVeiw.a(a).b();
        }
        CameraShotAnimationVeiw.b(a, j);
        a.invalidate();
    }
}
