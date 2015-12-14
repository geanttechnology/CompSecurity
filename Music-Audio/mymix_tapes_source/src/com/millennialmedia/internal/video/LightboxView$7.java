// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class this._cls0 extends Animation
{

    float distanceToOffscreen;
    final LightboxView this$0;
    float translateX;
    int width;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (f == 1.0F)
        {
            f = width * -1;
        } else
        {
            f = translateX - distanceToOffscreen * f;
        }
        setTranslationX(f);
    }

    public void initialize(int i, int j, int k, int l)
    {
        width = i;
        translateX = getTranslationX();
        distanceToOffscreen = translateX + (float)i;
    }

    public boolean willChangeBounds()
    {
        return false;
    }

    ()
    {
        this$0 = LightboxView.this;
        super();
    }
}
