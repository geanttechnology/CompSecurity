// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.landing;

import rx.functions.Action1;

// Referenced classes of package me.lyft.android.ui.landing:
//            SignupPhoneView, LandingFlow

class this._cls0
    implements Action1
{

    final SignupPhoneView this$0;

    public volatile void call(Object obj)
    {
        call((String)obj);
    }

    public void call(String s)
    {
        landingFlow.openSingupVerifyPhoneScreen(s);
    }

    ()
    {
        this$0 = SignupPhoneView.this;
        super();
    }
}
