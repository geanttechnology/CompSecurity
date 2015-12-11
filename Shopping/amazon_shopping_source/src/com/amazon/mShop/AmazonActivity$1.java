// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.animation.Animation;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity

class this._cls0
    implements android.view.animation.onListener
{

    final AmazonActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        AmazonActivity.access$202(AmazonActivity.this, false);
    }

    public void onAnimationRepeat(Animation animation)
    {
        AmazonActivity.access$202(AmazonActivity.this, true);
    }

    public void onAnimationStart(Animation animation)
    {
        AmazonActivity.access$202(AmazonActivity.this, true);
    }

    nimationListener()
    {
        this$0 = AmazonActivity.this;
        super();
    }
}
