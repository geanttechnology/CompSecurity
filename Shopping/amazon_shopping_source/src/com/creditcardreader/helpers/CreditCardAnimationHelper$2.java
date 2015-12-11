// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.creditcardreader.helpers:
//            CreditCardAnimationHelper

class val.visible
    implements android.view.animation.per._cls2
{

    final CreditCardAnimationHelper this$0;
    final boolean val$visible;

    public void onAnimationEnd(Animation animation)
    {
        if (val$visible)
        {
            CreditCardAnimationHelper.access$200(CreditCardAnimationHelper.this).setVisibility(0);
            return;
        } else
        {
            CreditCardAnimationHelper.access$200(CreditCardAnimationHelper.this).setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = final_creditcardanimationhelper;
        val$visible = Z.this;
        super();
    }
}
