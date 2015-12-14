// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.View;
import android.view.animation.Animation;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryBottomBarViewFlipper

class this._cls0
    implements android.view.animation.rViewFlipper._cls2
{

    final AviaryBottomBarViewFlipper this$0;

    public void onAnimationEnd(Animation animation)
    {
        for (animation = AviaryBottomBarViewFlipper.access$000(AviaryBottomBarViewFlipper.this).iterator(); animation.hasNext(); ((ViewChangingStatusListener)animation.next()).onCloseEnd()) { }
        getChildAt(0).setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        getChildAt(1).setVisibility(0);
        for (animation = AviaryBottomBarViewFlipper.access$000(AviaryBottomBarViewFlipper.this).iterator(); animation.hasNext(); ((ViewChangingStatusListener)animation.next()).onCloseStart()) { }
    }

    ViewChangingStatusListener()
    {
        this$0 = AviaryBottomBarViewFlipper.this;
        super();
    }
}
