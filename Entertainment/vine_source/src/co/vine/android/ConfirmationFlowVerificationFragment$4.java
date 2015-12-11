// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package co.vine.android:
//            ConfirmationFlowVerificationFragment

class this._cls0
    implements android.view.animation.
{

    final ConfirmationFlowVerificationFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        if (ConfirmationFlowVerificationFragment.access$400(ConfirmationFlowVerificationFragment.this) != null)
        {
            ConfirmationFlowVerificationFragment.access$400(ConfirmationFlowVerificationFragment.this).setVisibility(0);
        }
        if (ConfirmationFlowVerificationFragment.access$500(ConfirmationFlowVerificationFragment.this) != null)
        {
            ConfirmationFlowVerificationFragment.access$500(ConfirmationFlowVerificationFragment.this).setVisibility(4);
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
        this$0 = ConfirmationFlowVerificationFragment.this;
        super();
    }
}
