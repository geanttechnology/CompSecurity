// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.events.EmailSetEvent;
import com.groupon.events.FacebookSetEvent;
import com.groupon.events.ZipCodeSelectedEvent;
import com.groupon.util.ArraySharedPreferences;

// Referenced classes of package com.groupon.activity:
//            OnboardingMultiStep

private class <init>
{

    final OnboardingMultiStep this$0;

    public void onEmailSetEvent(EmailSetEvent emailsetevent)
    {
        OnboardingMultiStep.access$200(OnboardingMultiStep.this).edit()._mth0("email", emailsetevent.getEmail())._mth0();
    }

    public void onFacebookSetEvent(FacebookSetEvent facebooksetevent)
    {
        OnboardingMultiStep.access$200(OnboardingMultiStep.this).edit()._mth0("onboardFacebook", facebooksetevent.isUsingFacebook())._mth0();
    }

    public void onNextStepEvent(this._cls0 _pcls0)
    {
        OnboardingMultiStep.access$100(OnboardingMultiStep.this);
    }

    public void onZipCodeSelectedEvent(ZipCodeSelectedEvent zipcodeselectedevent)
    {
        OnboardingMultiStep.access$200(OnboardingMultiStep.this).edit()._mth0("zip_code", zipcodeselectedevent.getZipcode())._mth0();
    }

    private ()
    {
        this$0 = OnboardingMultiStep.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
