// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewVignette

class this._cls0
    implements com.nineoldandroids.animation.orUpdateListener
{

    final ImageViewVignette this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        invalidate();
    }

    Listener()
    {
        this$0 = ImageViewVignette.this;
        super();
    }
}
