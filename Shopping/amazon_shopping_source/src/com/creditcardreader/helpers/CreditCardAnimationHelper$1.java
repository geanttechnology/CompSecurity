// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package com.creditcardreader.helpers:
//            CreditCardAnimationHelper

class val.text
    implements android.view.animation.per._cls1
{

    final CreditCardAnimationHelper this$0;
    final String val$text;

    public void onAnimationEnd(Animation animation)
    {
        CreditCardAnimationHelper.access$000(CreditCardAnimationHelper.this).setText(val$text);
        CreditCardAnimationHelper.access$000(CreditCardAnimationHelper.this).startAnimation(CreditCardAnimationHelper.access$100(CreditCardAnimationHelper.this));
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
        val$text = String.this;
        super();
    }
}
