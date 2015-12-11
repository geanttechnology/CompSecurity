// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.view.View;
import com.groupon.activity.Login;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment, TermsConditionsFragment

class this._cls0
    implements android.view.ner
{

    final SignUpFragment this$0;

    public void onClick(View view)
    {
        logger.logClick("", "google_signup_click", com/groupon/activity/Login.getSimpleName(), Logger.NULL_NST_FIELD, SignUpFragment.access$100(SignUpFragment.this));
        SignUpFragment.access$002(SignUpFragment.this, "google");
        (new TermsConditionsFragment()).show(getActivity().getFragmentManager(), "T&C");
    }

    agment()
    {
        this$0 = SignUpFragment.this;
        super();
    }
}
