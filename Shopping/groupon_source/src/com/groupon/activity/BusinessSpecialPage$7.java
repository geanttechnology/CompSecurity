// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class this._cls0
    implements android.view.animation.tener
{

    final BusinessSpecialPage this$0;

    public void onAnimationEnd(Animation animation)
    {
        specialButton.setVisibility(8);
        specialInfoText.setVisibility(8);
        specialSavedText.setAlpha(0.0F);
        specialEmailSection.setAlpha(0.0F);
        specialSavedText.setVisibility(0);
        specialEmailSection.setVisibility(0);
        BusinessSpecialPage.access$900(BusinessSpecialPage.this);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    istener()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
