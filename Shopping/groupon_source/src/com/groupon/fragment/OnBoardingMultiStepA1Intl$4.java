// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.DialogInterface;
import com.groupon.models.emailsubscription.EmailSubscriptionContainer;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.Function1;
import com.groupon.util.ThanksUIUtil;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1Intl

class this._cls0
    implements Function1
{

    final OnBoardingMultiStepA1Intl this$0;

    public void execute(EmailSubscriptionContainer emailsubscriptioncontainer)
    {
        (new ThanksUIUtil(continueButton.getContext())).showThanksForSubscriptionDialog(currentCountryManager.getCurrentCountry(), OnBoardingMultiStepA1Intl.access$100(OnBoardingMultiStepA1Intl.this).toString(), new android.content.DialogInterface.OnCancelListener() {

            final OnBoardingMultiStepA1Intl._cls4 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                OnBoardingMultiStepA1Intl.access$200(this$0);
            }

            
            {
                this$1 = OnBoardingMultiStepA1Intl._cls4.this;
                super();
            }
        });
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((EmailSubscriptionContainer)obj);
    }

    _cls1.this._cls1()
    {
        this$0 = OnBoardingMultiStepA1Intl.this;
        super();
    }
}
