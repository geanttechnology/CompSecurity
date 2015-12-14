// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewTiltiShiftTouch

class this._cls0
    implements com.nineoldandroids.animation.eListener
{

    final ImageViewTiltiShiftTouch this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (ImageViewTiltiShiftTouch.access$000(ImageViewTiltiShiftTouch.this))
        {
            invalidate();
        }
    }

    r()
    {
        this$0 = ImageViewTiltiShiftTouch.this;
        super();
    }
}
