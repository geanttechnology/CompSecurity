// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.groupon.activity.IntentFactory;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            OnboardingFragment

public class OnBoardingMultiStepA2 extends OnboardingFragment
{

    private Activity activity;
    SpinnerButton done;
    private IntentFactory intentFactory;
    private Logger logger;
    private LoggingUtils loggingUtils;

    public OnBoardingMultiStepA2()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        logger.logPageView("", com/groupon/fragment/OnBoardingMultiStepA2.getSimpleName(), Logger.NULL_NST_FIELD);
        done.setOnClickListener(new android.view.View.OnClickListener() {

            final OnBoardingMultiStepA2 this$0;

            public void onClick(View view)
            {
                loggingUtils.logOnBoardingFinished();
                view = intentFactory.newCarouselIntent().putExtra("FROM_ONBOARDING", true);
                view = intentFactory.newLoginIntent(activity, view).putExtra("FROM_ONBOARDING", true);
                startActivity(view);
                activity.finish();
            }

            
            {
                this$0 = OnBoardingMultiStepA2.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030189, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }



}
