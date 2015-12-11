// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class  extends AnimatorListenerAdapter
{

    final DeliveryAddresses this$0;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        setResultAndFinish();
    }

    ()
    {
        this$0 = DeliveryAddresses.this;
        super();
    }
}
