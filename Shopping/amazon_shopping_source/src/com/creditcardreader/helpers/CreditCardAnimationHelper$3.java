// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.creditcardreader.camera.CreditCardCameraPreview;

// Referenced classes of package com.creditcardreader.helpers:
//            CreditCardAnimationHelper

class this._cls0
    implements android.view.animation.per._cls3
{

    final CreditCardAnimationHelper this$0;

    public void onAnimationEnd(Animation animation)
    {
        CreditCardAnimationHelper.access$300(CreditCardAnimationHelper.this).setStartOffset(300L);
        CreditCardAnimationHelper.access$300(CreditCardAnimationHelper.this).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final CreditCardAnimationHelper._cls3 this$1;

            public void onAnimationEnd(Animation animation1)
            {
                if (CreditCardAnimationHelper.access$400(this$0).isScanning())
                {
                    CreditCardAnimationHelper.access$600(this$0).startAnimation(CreditCardAnimationHelper.access$500(this$0));
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$1 = CreditCardAnimationHelper._cls3.this;
                super();
            }
        });
        if (CreditCardAnimationHelper.access$400(CreditCardAnimationHelper.this).isScanning())
        {
            CreditCardAnimationHelper.access$600(CreditCardAnimationHelper.this).startAnimation(CreditCardAnimationHelper.access$300(CreditCardAnimationHelper.this));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = CreditCardAnimationHelper.this;
        super();
    }
}
