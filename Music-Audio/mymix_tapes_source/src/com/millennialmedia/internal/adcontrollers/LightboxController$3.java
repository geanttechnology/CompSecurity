// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.graphics.Point;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.millennialmedia.internal.video.LightboxView;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController

class val.distanceToDefaultPosY extends Animation
{

    final LightboxController this$0;
    final Point val$displaySize;
    final int val$distanceToDefaultPosY;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (f == 1.0F)
        {
            f = val$displaySize.y - val$distanceToDefaultPosY;
        } else
        {
            f = (float)val$displaySize.y - (float)val$distanceToDefaultPosY * f;
        }
        LightboxController.access$000(LightboxController.this).setTranslationY(f);
    }

    ()
    {
        this$0 = final_lightboxcontroller;
        val$displaySize = point;
        val$distanceToDefaultPosY = I.this;
        super();
    }
}
