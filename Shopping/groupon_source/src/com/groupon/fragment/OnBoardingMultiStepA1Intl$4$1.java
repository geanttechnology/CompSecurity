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

class this._cls1
    implements android.content.er
{

    final is._cls0 this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        OnBoardingMultiStepA1Intl.access$200(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/OnBoardingMultiStepA1Intl$4

/* anonymous class */
    class OnBoardingMultiStepA1Intl._cls4
        implements Function1
    {

        final OnBoardingMultiStepA1Intl this$0;

        public void execute(EmailSubscriptionContainer emailsubscriptioncontainer)
        {
            (new ThanksUIUtil(continueButton.getContext())).showThanksForSubscriptionDialog(currentCountryManager.getCurrentCountry(), OnBoardingMultiStepA1Intl.access$100(OnBoardingMultiStepA1Intl.this).toString(), new OnBoardingMultiStepA1Intl._cls4._cls1());
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((EmailSubscriptionContainer)obj);
        }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
    }

}
