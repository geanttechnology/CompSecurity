// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.contextlogic.wish.ui.fragment.cartmodal.ui;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.contextlogic.wish.ui.fragment.cartmodal.ui:
//            CartUpsellModal

class this._cls0
    implements android.view.animation.nListener
{

    final CartUpsellModal this$0;

    public void onAnimationEnd(Animation animation)
    {
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        CartUpsellModal.access$100(CartUpsellModal.this).setVisibility(0);
    }

    ()
    {
        this$0 = CartUpsellModal.this;
        super();
    }
}
