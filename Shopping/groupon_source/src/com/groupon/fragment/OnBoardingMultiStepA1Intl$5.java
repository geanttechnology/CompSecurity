// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.Function0;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1Intl

class this._cls0
    implements Function0
{

    final OnBoardingMultiStepA1Intl this$0;

    public void execute()
    {
        continueButton.stopSpinning();
        continueButton.setEnabled(true);
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1Intl.this;
        super();
    }
}
