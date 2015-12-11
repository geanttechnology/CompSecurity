// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA2

class this._cls0
    implements android.view.tepA2._cls1
{

    final OnBoardingMultiStepA2 this$0;

    public void onClick(View view)
    {
        OnBoardingMultiStepA2.access$000(OnBoardingMultiStepA2.this).logOnBoardingFinished();
        view = OnBoardingMultiStepA2.access$100(OnBoardingMultiStepA2.this).newCarouselIntent().putExtra("FROM_ONBOARDING", true);
        view = OnBoardingMultiStepA2.access$100(OnBoardingMultiStepA2.this).newLoginIntent(OnBoardingMultiStepA2.access$200(OnBoardingMultiStepA2.this), view).putExtra("FROM_ONBOARDING", true);
        startActivity(view);
        OnBoardingMultiStepA2.access$200(OnBoardingMultiStepA2.this).finish();
    }

    ()
    {
        this$0 = OnBoardingMultiStepA2.this;
        super();
    }
}
