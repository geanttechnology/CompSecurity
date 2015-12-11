// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.creditcardreader.camera.CreditCardCameraPreview;

// Referenced classes of package com.creditcardreader.helpers:
//            CreditCardAnimationHelper

class this._cls1
    implements android.view.animation.r._cls3._cls1
{

    final is._cls0 this$1;

    public void onAnimationEnd(Animation animation)
    {
        if (CreditCardAnimationHelper.access$400(_fld0).isScanning())
        {
            CreditCardAnimationHelper.access$600(_fld0).startAnimation(CreditCardAnimationHelper.access$500(_fld0));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/creditcardreader/helpers/CreditCardAnimationHelper$3

/* anonymous class */
    class CreditCardAnimationHelper._cls3
        implements android.view.animation.Animation.AnimationListener
    {

        final CreditCardAnimationHelper this$0;

        public void onAnimationEnd(Animation animation)
        {
            CreditCardAnimationHelper.access$300(CreditCardAnimationHelper.this).setStartOffset(300L);
            CreditCardAnimationHelper.access$300(CreditCardAnimationHelper.this).setAnimationListener(new CreditCardAnimationHelper._cls3._cls1());
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

            
            {
                this$0 = CreditCardAnimationHelper.this;
                super();
            }
    }

}
