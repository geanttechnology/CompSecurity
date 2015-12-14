// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.graphics.Point;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class val.defaultPosition extends Animation
{

    float distanceToDefault;
    final LightboxView this$0;
    float translateX;
    final Point val$defaultPosition;
    int width;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (f == 1.0F)
        {
            f = val$defaultPosition.x;
        } else
        {
            f = translateX + distanceToDefault * f;
        }
        setTranslationX(f);
    }

    public void initialize(int i, int j, int k, int l)
    {
        width = i;
        translateX = getTranslationX();
        distanceToDefault = (float)val$defaultPosition.x - translateX;
    }

    public boolean willChangeBounds()
    {
        return false;
    }

    ()
    {
        this$0 = final_lightboxview;
        val$defaultPosition = Point.this;
        super();
    }
}
