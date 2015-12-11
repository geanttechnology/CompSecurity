// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class this._cls0
    implements android.view.animation.tener
{

    final BusinessSpecialPage this$0;

    public void onAnimationEnd(Animation animation)
    {
        specialSavedText.setAlpha(1.0F);
        specialEmailSection.setAlpha(1.0F);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        specialSavedText.setAlpha(1.0F);
        specialEmailSection.setAlpha(1.0F);
    }

    istener()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
